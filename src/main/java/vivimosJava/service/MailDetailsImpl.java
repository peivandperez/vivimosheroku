package vivimosJava.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring5.SpringTemplateEngine;

import vivimosJava.model.MailDTO;

@Service
public class MailDetailsImpl implements MailDetails{
	
	@Autowired
	private SpringTemplateEngine thymeleafTemplateEngine;
	
	@Override
	public void mailInvierte(MailDTO mailDTO){
		Context thymeleafContext = new Context();
		thymeleafContext.setVariable("email", mailDTO.getMailTo());
		String htmlBody= thymeleafTemplateEngine.process("mailInvierte", thymeleafContext);
		
		String from="p.perez@vivimos.cl";
		String fromPersonal="Invierte Vivimos";
		String subjectDetail="Invierte en propiedades con Vivimos.cl";
		
		mailDTO.setMailFrom(from);
		mailDTO.setMailFromPersonal(fromPersonal);
		mailDTO.setMailSubject(subjectDetail);
		
	
		mailDTO.setMailContent(htmlBody);
	}
}
