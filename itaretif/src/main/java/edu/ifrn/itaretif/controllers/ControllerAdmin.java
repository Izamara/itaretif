package edu.ifrn.itaretif.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class ControllerAdmin {
	
	
	
	@GetMapping("/inicioAdmin")
	public String inicioAdmin() {
		return "inicioAdmin";
	}
	
}
