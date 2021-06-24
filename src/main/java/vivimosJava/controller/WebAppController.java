package vivimosJava.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import vivimosJava.model.TestimonialesDTO;
import vivimosJava.service.TestimonialesService;

@Controller
public class WebAppController {
	
	@Autowired
	TestimonialesService testimonialesService;
	
	
	@RequestMapping("/index")
	public String getIndex() {
		return "index";
	}
	
	@RequestMapping("/5errores")
	public String get5errores() {
		return "5errores";
	}

	@RequestMapping("/invierte")
	public String getInvierte() {
		return "invierte";
	}
	
	
	@RequestMapping("/gracias-invertir-propiedades")
	public String getGraciasInvertirPropiedades() {
		return "gracias-invertir-propiedades";
	}
	
	@RequestMapping("/enviarMail")
	public String getEnviarMail() {
		return "enviarMail";
	}
	
	@RequestMapping("/como-invertir-en-propiedades")
	public String getComoInvertirEnPropiedades(Model model) {
		List<TestimonialesDTO> testimoniales=testimonialesService.todas();
		model.addAttribute("testimoniales", testimoniales);
		return "como-invertir-en-propiedades";
	}
	
}
