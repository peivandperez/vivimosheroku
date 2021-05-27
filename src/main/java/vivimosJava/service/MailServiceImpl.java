package vivimosJava.service;

import java.io.File;
import java.io.UnsupportedEncodingException;

import javax.mail.BodyPart;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.mail.javamail.MimeMessageHelper;

import vivimosJava.model.MailDTO;

@Service
public class MailServiceImpl implements MailService {
	
	@Autowired
	JavaMailSender javaMailSender;
	
	public MailServiceImpl(JavaMailSender javaMailSender) {
		this.javaMailSender=javaMailSender;	
		}
	
	@Async
	@Override
	public void sendMail(MailDTO mailDTO) throws UnsupportedEncodingException {
		MimeMessage mimeMessage=javaMailSender.createMimeMessage();
		MimeMessageHelper mimeMessageHelper= new MimeMessageHelper(mimeMessage);
		
		
		
		try {
			
			mimeMessageHelper.setFrom(mailDTO.getMailFrom(), mailDTO.getMailFromPersonal());
			mimeMessageHelper.setTo(mailDTO.getMailToName()+"<"+mailDTO.getMailTo()+">");
			mimeMessageHelper.setSubject(mailDTO.getMailSubject());
			mimeMessageHelper.setText(mailDTO.getMailContent(),true);
					
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

}
