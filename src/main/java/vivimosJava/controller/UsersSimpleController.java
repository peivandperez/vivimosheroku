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
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import vivimosJava.model.UsersSimpleDTO;
import vivimosJava.service.UsersSimpleService;

@Controller
public class UsersSimpleController {
	@Autowired
	UsersSimpleService usersSimpleService;
	
	@Autowired
	RestTemplate restTemplate;
	
	@Value("${recaptcha.secretkey}")
	private String recaptchaSecret;
	
	@Value("${recaptcha.serverUrl}")
	private String recaptchaServerUrl;
	

	@GetMapping("/invierte")
	public String showForm(Model model) {
		
		model.addAttribute("user", new UsersSimpleDTO());
		return "invierte";
	}
	
	
	 @PostMapping("/invierteForm")
	 //	public String submitInvierte(HttpServletRequest request, Model model) {
	   public String submissionResult(@ModelAttribute("user") UsersSimpleDTO person, @RequestParam(name="g-recaptcha-response") String captchaResponse) {
			 
		 String params= "?secret="+recaptchaSecret+"&response="+captchaResponse;
	
		 System.out.println("captchaResponse= "+captchaResponse);
		 //String params= "?secret="+recaptchaSecret+"&response="+captchaResponse;
		 
		 ReCaptchaResponse reCaptchaResponse= restTemplate.exchange(recaptchaServerUrl+params, HttpMethod.POST,null,ReCaptchaResponse.class).getBody();
		 
		 
		 if(reCaptchaResponse.isSuccess()) {
			 System.out.println("recaptcha success");
			 usersSimpleService.insert(person);
		
		 }else {
			 System.out.println("recaptcha falla");
		 }
		 
	        return "gracias-invertir-propiedades";
	    }


	}


