package vivimosJava.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import vivimosJava.model.PropiedadesTestingDTO;
import vivimosJava.service.PropiedadesTestingService;

@Controller
public class PropiedadesController {
	
	@Autowired
	PropiedadesTestingService propiedadesTestingService;
	
	@RequestMapping("/propiedadSingle/{url}")
		public String propiedadId(@PathVariable("url") String url, Model model) {
			PropiedadesTestingDTO propiedad= propiedadesTestingService.findByUrl(url);
			
			if (propiedad==null) {
				return "error";
			}else {
		
			model.addAttribute("propiedad", propiedad);
			
			return "propiedadSingle";
			}
		}
	
	@RequestMapping("/propiedades")
	public String propiedades(Model model) {
		List<PropiedadesTestingDTO> todasPropiedades=propiedadesTestingService.listTodas();
		model.addAttribute("todasPropiedades", todasPropiedades);
		
		return "propiedades";
	}
	}

