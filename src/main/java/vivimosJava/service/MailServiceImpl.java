package vivimosJava.service;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.mail.BodyPart;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring5.SpringTemplateEngine;

import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.Email;
import com.sendgrid.helpers.mail.objects.Personalization;

import org.springframework.mail.javamail.MimeMessageHelper;

import vivimosJava.model.InversionistasTestingDAO;
import vivimosJava.model.InversionistasTestingDTO;
import vivimosJava.model.MailDTO;

@Service
public class MailServiceImpl implements MailService {
	
	@Value("${sendgrid.api.key}")
	private String sendGridApiKey;
	
	@Value("${sendgrid.templateId}")
	private String emailTemplateId;
	
	private String emailTemplateIdSantaRosa ="d-2c353fcbd118457088bbaf96de517742";
	
	
	@Autowired
	JavaMailSender javaMailSender;
	
	@Autowired
	InversionistasTestingDAO inversionistasTestingDAO;
	
	
	public MailServiceImpl(JavaMailSender javaMailSender) {
		this.javaMailSender=javaMailSender;	
		}
	
	
	@Override
	@Async
	public void sendMessageUsingThymleafTemplate(MailDTO mailDTO)
			throws MessagingException, UnsupportedEncodingException {
		
		MimeMessage mimeMessage=javaMailSender.createMimeMessage();
		MimeMessageHelper mimeMessageHelper= new MimeMessageHelper(mimeMessage,true,"UTF-8");
	

		try {
			
			mimeMessageHelper.setFrom(mailDTO.getMailFrom(), mailDTO.getMailFromPersonal());
			mimeMessageHelper.setTo(mailDTO.getMailToName()+"<"+mailDTO.getMailTo()+">");
			mimeMessageHelper.setSubject(mailDTO.getMailSubject());
			mimeMessageHelper.setText(mailDTO.getMailContent(),true);
		
					
			javaMailSender.send(mimeMessage);
			System.out.println("mail enviado");
			
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		
		
	}
	
	
	
	@Async
	@Override
	public void sendMail(MailDTO mailDTO) throws UnsupportedEncodingException, MessagingException {
		MimeMessage mimeMessage=javaMailSender.createMimeMessage();
		MimeMessageHelper mimeMessageHelper= new MimeMessageHelper(mimeMessage,true,"UTF-8");
	
		try {
			
			mimeMessageHelper.setFrom(mailDTO.getMailFrom(), mailDTO.getMailFromPersonal());
			mimeMessageHelper.setTo(mailDTO.getMailToName()+"<"+mailDTO.getMailTo()+">");
			mimeMessageHelper.setSubject(mailDTO.getMailSubject());
			mimeMessageHelper.setText(mailDTO.getMailContent(),true); //(HTML body, true)
					
			javaMailSender.send(mimeMessage);
			
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}
	
	@Async
	@Override
	public void sendMailAttachment(MailDTO mailDTO) throws MessagingException {
		MimeMessage mimeMessage=javaMailSender.createMimeMessage();
		MimeMessageHelper mimeMessageHelper= new MimeMessageHelper(mimeMessage,true);
	
		
		mimeMessageHelper.setSubject(mailDTO.getMailSubject());
		mimeMessageHelper.setFrom(mailDTO.getMailFrom());
		mimeMessageHelper.setTo(mailDTO.getMailTo());
		mimeMessageHelper.setText(mailDTO.getMailContent(),true);
		FileSystemResource file=new FileSystemResource(new File("src/main/resources/static/pdf/como_invertir_en_propiedades.pdf"));
		mimeMessageHelper.addAttachment("Como Invertir en Propiedades", file);
		
		javaMailSender.send(mimeMessage);
		
		
	}


	@Override
	public void sendMailSendgrid(MailDTO mailDTO) throws IOException {
		
		
		String linkWhatsapp="https://api.whatsapp.com/send?phone=56989997466&text=Hola, quisiera consultar por propiedades para inversión. Mi mail es : ";
		String linkWhatsappCliente=linkWhatsapp;
		
		String urlDepto1="https://vivimos.cl/product/estcentral2dorm-santa-petronila-32-cod-1320";
		String urlDepto2="https://vivimos.cl/product/stgo1dorm_santa_rosa_991_cod_1267";
		
		
		
		ArrayList<String> listaMails=new ArrayList<String>();
	
		listaMails.add("info@vivimos.cl");
		listaMails.add("portalinmobiliario@vivimos.cl");
		listaMails.add("p.perez@vivimos.cl");
		listaMails.add("visitas@vivimos.cl");
		listaMails.add("peivandp@gmail.com");

		
		
		Mail mail= new Mail();
		Email fromEmail=new Email();
		fromEmail.setEmail("info@vivimos.cl");
		fromEmail.setName("Invierte Vivimos");
		mail.setFrom(fromEmail);
		mail.setTemplateId(emailTemplateId);
		
		
		
		
		
		
	
	for (int i=0; i<listaMails.size();i++) {
		//String personalizationIndex=((String)listaMails.get(i));
		Email to=new Email(listaMails.get(i));
		Personalization personalization= new Personalization();
		personalization.addDynamicTemplateData("depto1", "https://vivimos.cl/product/estcentral2dorm-santa-petronila-32-cod-1320");
		personalization.addDynamicTemplateData("depto2", "https://vivimos.cl/product/stgo1dorm_santa_rosa_991_cod_1267");
		
		linkWhatsappCliente=linkWhatsapp+listaMails.get(i);

		personalization.addDynamicTemplateData("linkWhatsapp", linkWhatsappCliente);
		personalization.addTo(to);
		mail.addPersonalization(personalization);
		
		linkWhatsappCliente="";
		
	}
	
			SendGrid sg=new SendGrid(sendGridApiKey);
			sg.addRequestHeader("X-Mock","true");
			
			Request request=new Request();
			try {
				  request.setMethod(Method.POST);
			      request.setEndpoint("mail/send");
			      request.setBody(mail.build());
			     
			      Response response = sg.api(request);
			      System.out.println(response.getStatusCode());
			      System.out.println(response.getBody());
			      System.out.println(response.getHeaders());
			} catch (IOException ex) {
				throw ex;
			}
	
	}

	@Async
	@Override
	public void sendMailInversionista() throws IOException {

		String direccion="Santa Rosa 249";
		String sector="Metro Santa Lucía";
		String linkWhatsappNombre="Mi nombre es: ";
		String linkWhatsappMail=" y mi correo es : ";
		String linkWhatsapp="https://api.whatsapp.com/send?phone=56989997466&text=Hola, quisiera consultar por la propiedad de ";
		String linkWhatsappCliente="";
		
		String subject="Antes que se publique.Propiedad para inversión en "+ sector;
		String preHeader="Mírala antes que la publiquemos. Revisa aquí la información ";
	
		Mail mail= new Mail();
		Email fromEmail=new Email();
		fromEmail.setEmail("info@vivimos.cl");
		fromEmail.setName("Invierte Vivimos");
		mail.setFrom(fromEmail);
		mail.setTemplateId(emailTemplateIdSantaRosa);
		
		List<InversionistasTestingDTO> lista=inversionistasTestingDAO.listaInversionistasTesting();
		for(InversionistasTestingDTO inversionistasTestingDTO:lista) {
			
			Email to=new Email(inversionistasTestingDTO.getMail());
			Personalization personalization= new Personalization();
			personalization.addDynamicTemplateData("subject", subject);
			personalization.addDynamicTemplateData("preHeader", preHeader);
			personalization.addDynamicTemplateData("primerNombre", inversionistasTestingDTO.getNombre());
			
			linkWhatsappNombre=linkWhatsappNombre + inversionistasTestingDTO.getNombre();
			linkWhatsappMail=linkWhatsappMail + inversionistasTestingDTO.getMail();
			linkWhatsapp=linkWhatsapp + direccion +"."+ linkWhatsappNombre + linkWhatsappMail;	
			linkWhatsappCliente=linkWhatsapp;

			personalization.addDynamicTemplateData("linkWhatsapp", linkWhatsappCliente);
			personalization.addTo(to);
			mail.addPersonalization(personalization);
			
			
			linkWhatsappCliente="";
			linkWhatsappNombre="";
			linkWhatsappMail="";
		}
		

		
		SendGrid sg=new SendGrid(sendGridApiKey);
		sg.addRequestHeader("X-Mock","true");
		
		Request request=new Request();
		try {
			  request.setMethod(Method.POST);
		      request.setEndpoint("mail/send");
		      request.setBody(mail.build());
		     
		      Response response = sg.api(request);
		      System.out.println(response.getStatusCode());
		      System.out.println(response.getBody());
		      System.out.println(response.getHeaders());
		} catch (IOException ex) {
			throw ex;
		}
		
	}

}
