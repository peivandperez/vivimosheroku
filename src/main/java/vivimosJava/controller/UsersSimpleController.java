package vivimosJava.controller;


import java.io.UnsupportedEncodingException;

import javax.mail.MessagingException;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import vivimosJava.controller.recaptcha.ReCaptchaResponse;
import vivimosJava.model.MailDTO;
import vivimosJava.model.UsersSimpleDTO;
import vivimosJava.service.MailDetails;
import vivimosJava.service.MailService;
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
	MailService mailService;
	
	@Autowired
	MailDetails mailDetails;
	
	
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
		 		
				 mailDetails.mailInvierte(mailDTO);
				 mailDTO.setMailTo(person.getEmail());
				 mailDTO.setMailToName(person.getEmail());
				 mailService.sendMail(mailDTO);
			
				 usersSimpleService.insert(person);
				 return "gracias-invertir-propiedades";
		 	}		 
	    } 
	}


