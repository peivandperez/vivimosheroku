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
	
	@RequestMapping("/")
	public String getIndex3() {
		return "index";
	}
	
	@RequestMapping("/5errores")
	public String get5errores() {
		return "5errores";
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
	
	@RequestMapping("/index2")
	public String getIndex2() {
		return "index2";
	}
	
	@RequestMapping("/descargaGuia")
	public String getDescargaGuia() {
		return "graciasDescargaGuia";
	}
	
	
}
