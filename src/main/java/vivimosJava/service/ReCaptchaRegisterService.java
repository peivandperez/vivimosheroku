package vivimosJava.service;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import vivimosJava.controller.recaptcha.ReCaptchaKeys;
import vivimosJava.controller.recaptcha.ReCaptchaResponse;

@Service
public class ReCaptchaRegisterService implements ReCaptchaService {
	
	private final ReCaptchaKeys reCaptchaKeys;
	private final RestTemplate restTemplate;
	
	
	@Autowired
	public ReCaptchaRegisterService(ReCaptchaKeys reCaptchaKeys, RestTemplate restTemplate) {
		this.reCaptchaKeys=reCaptchaKeys;
		this.restTemplate=restTemplate;
	}

	@Override
	public ReCaptchaResponse verify(String response) {
		
		//API request
		URI verifyURI= URI.create(
				String.format("https://www.google.com/recaptcha/api/siteverify?secret=%s&response=%s",
							reCaptchaKeys.getSecretKey(),response));
		
		//make HTTP call using RestTemplate
		
		ReCaptchaResponse reCaptchaResponse = restTemplate.getForObject(verifyURI, ReCaptchaResponse.class);
		return reCaptchaResponse;
	}
		
}
