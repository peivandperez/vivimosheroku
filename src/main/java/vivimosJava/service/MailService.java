package vivimosJava.service;

import java.io.UnsupportedEncodingException;
import javax.mail.MessagingException;

import org.springframework.context.annotation.Bean;

import vivimosJava.model.MailDTO;

public interface MailService {
	
	public void sendMail(MailDTO mailDTO) throws UnsupportedEncodingException, MessagingException;
	public void sendMailAttachment(MailDTO mailDTO) throws MessagingException;
}
