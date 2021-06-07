package vivimosJava.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class enviarMailTestingController {
	@RequestMapping(value="/enviarMailInversion")
	public String doStuffMethod() {
	    System.out.println("Success");
	    return "enviarMailInversion";
	}
}
