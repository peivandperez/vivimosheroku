package vivimosJava.controller;


import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
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
import vivimosJava.model.UsersSimpleDTO;
import vivimosJava.service.ReCaptchaRegisterServiceImpl;
import vivimosJava.service.UsersSimpleService;

@Controller
public class UsersSimpleController {
	
	private final UsersSimpleService usersSimpleService;
	private final ReCaptchaRegisterServiceImpl reCaptchaRegisterService;
	
	
	
	boolean responseClass=true;

	
	@Autowired
	public UsersSimpleController(UsersSimpleService usersSimpleService,
			ReCaptchaRegisterServiceImpl reCaptchaRegisterService) {
		
		this.usersSimpleService=usersSimpleService;
		this.reCaptchaRegisterService = reCaptchaRegisterService;
	
	}

	
	@GetMapping("/invierte")
	public String showForm(Model model) {
		model.addAttribute("user", new UsersSimpleDTO());
		model.addAttribute("message", "Completa el captcha");
		if(responseClass==true) {
		model.addAttribute("responseClass",true);
		}else {
			model.addAttribute("responseClass",false);
			responseClass=true;
		}
		return "invierte";
	
	}
	
	
	 @PostMapping("/invierteForm")
	   public String submissionResult(@ModelAttribute("user") UsersSimpleDTO person, @RequestParam(name="g-recaptcha-response") String response,
			   BindingResult result,ModelMap model) {
		 
		 //Verify ReCaptcha response
		 reCaptchaRegisterService.verify(response);
			 
		 /*
		 if(reCaptchaResponse.isSuccess()) {
			 System.out.println("recaptcha success");
			 System.out.println(reCaptchaResponse.getScore());
			 usersSimpleService.insert(person);
			  return "gracias-invertir-propiedades";
		
		 }else {
			 responseClass=false;
			 return "redirect:invierte";
		 }
		 */
		 	return "invierte";
		
	    }


	}


