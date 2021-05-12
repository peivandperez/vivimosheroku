package vivimosJava.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WebAppController {
	@RequestMapping("/index")
	public String getIndex() {
		return "index";
	}
	
	@RequestMapping("/5errores")
	public String get5errores() {
		return "5errores";
	}
	/*
	@RequestMapping("/invierte")
	public String getInvierte() {
		return "invierte";
	}
	*/
	
	@RequestMapping("/gracias-invertir-propiedades")
	public String getGraciasInvertirPropiedades() {
		return "gracias-invertir-propiedades";
	}
	
	@RequestMapping("/greetingResult")
	public String getGreetingResult() {
		return "greetingResult";
	}
}
