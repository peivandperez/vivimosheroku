package vivimosJava.service;

import org.springframework.stereotype.Service;

import vivimosJava.controller.recaptcha.ReCaptchaResponse;

@Service
public class ReCaptchaRegisterService implements ReCaptchaService {

	@Override
	public ReCaptchaResponse verify(String response) {
		return null;
	}
		
}
