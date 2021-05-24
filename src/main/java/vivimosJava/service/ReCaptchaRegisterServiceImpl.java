package vivimosJava.service;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import vivimosJava.controller.recaptcha.ReCaptchaKeys;
import vivimosJava.controller.recaptcha.ReCaptchaResponse;

@Service
public class ReCaptchaRegisterServiceImpl implements ReCaptchaService {
	
	private final ReCaptchaKeys reCaptchaKeys;
	private final RestTemplate restTemplate;
	
	
	@Autowired
	public ReCaptchaRegisterServiceImpl(ReCaptchaKeys reCaptchaKeys, RestTemplate restTemplate) {
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
		
		
		if(reCaptchaResponse !=null) {
			if(reCaptchaResponse.isSuccess() && (reCaptchaResponse.getScore() < reCaptchaKeys.getThreshold() 
					|| !reCaptchaResponse.getAction().equals("invierteForm"))) {
				reCaptchaResponse.setSuccess(false);
			}
		}	
		return reCaptchaResponse;
	}
		
}
