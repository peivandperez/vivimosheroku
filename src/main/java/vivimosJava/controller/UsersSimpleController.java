package vivimosJava.controller;


import java.io.UnsupportedEncodingException;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import vivimosJava.controller.recaptcha.ReCaptchaResponse;
import vivimosJava.model.MailDTO;
import vivimosJava.model.UsersSimpleDTO;
import vivimosJava.service.MailServiceImpl;
import vivimosJava.service.ReCaptchaRegisterServiceImpl;
import vivimosJava.service.UsersSimpleService;

@Controller
public class UsersSimpleController {
	
	private final UsersSimpleService usersSimpleService;
	private final ReCaptchaRegisterServiceImpl reCaptchaRegisterService;
		
	@Autowired
	public UsersSimpleController(UsersSimpleService usersSimpleService,
			ReCaptchaRegisterServiceImpl reCaptchaRegisterService) {
		this.usersSimpleService=usersSimpleService;
		this.reCaptchaRegisterService = reCaptchaRegisterService;	
	}
	
	@Autowired
	private MailServiceImpl mailServiceImpl;
	
	
	@GetMapping("/invierte")
	public String showForm(Model model) {
		model.addAttribute("user", new UsersSimpleDTO());
		return "invierte";
	
	}
	
	
	 @PostMapping("/invierteForm")
	   public String submissionResult(@ModelAttribute("user") UsersSimpleDTO person, MailDTO mailDTO, @RequestParam(name="g-recaptcha-response") String response,
			   BindingResult result,ModelMap model) throws MessagingException, UnsupportedEncodingException {
		 
		 //Verify ReCaptcha response
		 ReCaptchaResponse reCaptchaResponse= reCaptchaRegisterService.verify(response);
		 	if(!reCaptchaResponse.isSuccess()) {
		 		model.addAttribute("reCaptchaError", reCaptchaResponse.getErrors());
		 	System.out.println(reCaptchaResponse.getErrorCodes());
		 		return "invierte";
		 	}else {
		 		 System.out.println("recaptcha success");
				 System.out.println(reCaptchaResponse.getScore());
				 mailDTO.setMailTo(person.getEmail());
				 mailDTO.setMailFrom("p.perez@vivimos.cl");
				 mailDTO.setMailSubject("Gracias por querer invertir con nosotros");
				 mailDTO.setMailContent("<html>Hola, <b>muchas gracias</b> por escribirnos. Te dejamos los siguientes links</html>");
				
				 mailServiceImpl.sendMail(mailDTO);
				 //mailServiceImpl.sendMailAttachment(mailDTO);
		
				 usersSimpleService.insert(person);
				 return "gracias-invertir-propiedades";
		 	}		 
	    } 
	}


