package vivimosJava.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import vivimosJava.model.dto.UsersSimpleDTO;

@Controller
public class UsersSimpleController {
	
	@GetMapping("/invierte")
	public String showForm(Model model) {
		model.addAttribute("user", new UsersSimpleDTO());
		return "invierte";
	}
	
	/*
	@PostMapping("/registerEmail")
	public String submitForm(@ModelAttribute UsersSimpleDTO user,Model model) {
		model.addAttribute("user",user);
		return "gracias-invertir-propiedades";
	}
	*/
	
	   @PostMapping("/invierteForm")
	    public String submissionResult(@ModelAttribute("user") UsersSimpleDTO person) {
	        return "gracias-invertir-propiedades";
	    }
	
}
