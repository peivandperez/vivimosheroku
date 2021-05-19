package vivimosJava.service;

import vivimosJava.controller.recaptcha.ReCaptchaResponse;

public interface ReCaptchaService {
	ReCaptchaResponse verify(String response);
}
