package vivimosJava.service;

import java.io.File;
import java.io.UnsupportedEncodingException;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.mail.javamail.MimeMessageHelper;  

import vivimosJava.model.MailDTO;

@Service
public class MailServiceImpl {

	private JavaMailSender javaMailSender;
	
	public MailServiceImpl(JavaMailSender javaMailSender) {
		this.javaMailSender=javaMailSender;	
		}
	
	

	
	@Async
	public void sendMail(MailDTO mailDTO) throws UnsupportedEncodingException {
		MimeMessage mimeMessage=javaMailSender.createMimeMessage();
		MimeMessageHelper mimeMessageHelper= new MimeMessageHelper(mimeMessage);
		
		try {
			
			mimeMessageHelper.setSubject(mailDTO.getMailSubject());
			mimeMessageHelper.setFrom(mailDTO.getMailFrom(),"Invierte Vivimos");
			mimeMessageHelper.setTo(mailDTO.getMailTo()+"<"+mailDTO.getMailTo()+">");
			mimeMessageHelper.setText(mailDTO.getMailContent(),true);
			
			
			javaMailSender.send(mimeMessage);
			
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}
	
	@Async
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

}
