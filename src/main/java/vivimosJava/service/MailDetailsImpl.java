package vivimosJava.service;

import org.springframework.stereotype.Service;

import vivimosJava.model.MailDTO;

@Service
public class MailDetailsImpl implements MailDetails{
	
	@Override
	public void mailInvierte(MailDTO mailDTO){
	
		
		String from="p.perez@vivimos.cl";
		String fromPersonal="Invierte Vivimos";
		String subjectDetail="Invierte en propiedades con Vivimos.cl";
		String content="<html>Hola, <b>muchas gracias</b> por escribirnos. <p>Te dejamos los siguientes links</p></br><a href='https://vivimos.cl'>Vivimos.cl</a></html>'";
		
		mailDTO.setMailFrom(from);
		mailDTO.setMailFromPersonal(fromPersonal);
		mailDTO.setMailSubject(subjectDetail);
		mailDTO.setMailContent(content);
	}
}
