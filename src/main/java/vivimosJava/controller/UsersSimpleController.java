package vivimosJava.controller;


import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;

import vivimosJava.model.UsersSimpleDTO;
import vivimosJava.service.UsersSimpleService;

@Controller
public class UsersSimpleController {
	@Autowired
	UsersSimpleService usersSimpleService;
	
	@Value("${recaptcha.secret}")
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
	   public String submissionResult(@ModelAttribute("user") UsersSimpleDTO person) {
		 	
		 	
		 	
		 	usersSimpleService.insert(person);
	        return "gracias-invertir-propiedades";
	    }

	
		
		// TODO Auto-generated method stub
		
	}
	

