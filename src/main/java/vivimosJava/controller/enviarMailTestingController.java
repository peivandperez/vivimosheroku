package vivimosJava.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import vivimosJava.service.MailService;

@Controller
public class enviarMailTestingController {
	
	@Autowired
	MailService mailService;
	
	
	@RequestMapping(value="/enviarMailInversion")
	public String doStuffMethod() throws IOException {
	    mailService.sendMailInversionista();
	    return "enviarMailInversion";
	}
}
