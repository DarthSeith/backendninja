package com.backendninja.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/example") // la URL que va a tener este controlado
public class ExampleController {

	public static final String EXAMPLE_VIEW = "example";

	// Primera Forma
	@RequestMapping(value = "/exampleString", method = RequestMethod.GET) // el siguiente path y redirecciona a la
																			// pagina que se encuentra en
																			// /backendninja/src/main/resources/templates/helloworld.html
																			// Las nuevas versiones utilizan la
																			// annotation @GetMapping (La tercera forma)
	public String exampleString() {
		return EXAMPLE_VIEW;
	}

	// Segunda Forma
	@RequestMapping(value = "/exampleMAV", method = RequestMethod.GET) // aca utilizamos ModelAndView Las nuevas
																		// versiones utilizan la annotation
																		// @GetMapping @GetMapping (La tercera forma)
	public ModelAndView exampleMAV() {
		return new ModelAndView(EXAMPLE_VIEW);
	}

	// Tercera forma
	@GetMapping("/exampleGetMapping") // el siguiente path y redirecciona a la pagina que se encuentra en
										// /backendninja/src/main/resources/templates/helloworld.html
	public String exampleGetMapping() {
		return EXAMPLE_VIEW;
	}

}
