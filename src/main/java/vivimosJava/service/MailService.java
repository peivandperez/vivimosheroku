package vivimosJava.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class MailService {
	@Autowired
	private JavaMailSender javaMailSender;
	
	public MailService(JavaMailSender javaMailSender) {
		this.javaMailSender=javaMailSender;	
		}
	
	
	@Async
	public void sendEmail(String toMail,String subject,String text) {
	
		
		SimpleMailMessage message=new SimpleMailMessage();
		message.setTo(toMail);
		message.setSubject(subject);
		message.setText(text);
		message.setFrom("p.perez@vivimos.cl");
		javaMailSender.send(message);
	}
	
}
