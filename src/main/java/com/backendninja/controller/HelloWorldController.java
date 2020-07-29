package com.backendninja.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/say") // la URL que va a tener este controlado
public class HelloWorldController {

	@GetMapping("/helloworld")//el siguiente path y redirecciona a la pagina que se encuentra en /backendninja/src/main/resources/templates/helloworld.html
	public String helloWorld() {
		return "helloworld";
	}
	
}
