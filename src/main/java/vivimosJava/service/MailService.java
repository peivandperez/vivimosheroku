package vivimosJava.service;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Locale;
import java.util.Map;

import javax.mail.MessagingException;

import org.springframework.context.annotation.Bean;
import org.springframework.ui.ModelMap;

import vivimosJava.model.MailDTO;

public interface MailService {
	
	public void sendMail(MailDTO mailDTO) throws UnsupportedEncodingException, MessagingException;
	public void sendMailAttachment(MailDTO mailDTO) throws MessagingException;
	public void sendMessageUsingThymleafTemplate(MailDTO mailDTO) throws MessagingException, UnsupportedEncodingException;
	public void sendMailSendgrid(MailDTO mailDTO) throws IOException;
	public void sendMailInversionista() throws IOException;

}
