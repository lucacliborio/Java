package com.luca.Aula5.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController 
@RequestMapping("/api")
public class HelloController {

	@GetMapping("/oi")
	public String Ola() {
		return "Olá mundo!";
	}
	
	@GetMapping("/no")
	public String no() {
		return "Não";
	}
	
}
