package edu.ifrn.itaretif.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class NoticiasController {

	@RequestMapping("/cadastrarEvento")
	public String form() {
		return "formNoticia";
	}
}
