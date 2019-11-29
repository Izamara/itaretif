package edu.ifrn.itaretif.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
	
	@RequestMapping("/")
	public String index() {
		return "inicio";
	}
	
	@RequestMapping("/campus")
	public String campus() {
		return "o campus";
	}
	
	@RequestMapping("/regras")
	public String regras() {
		return "regras";
	}
	
	@RequestMapping("/lajes")
	public String lajes() {
		return "lajes";
	}
	
	@RequestMapping("/mapeamento")
	public String mapeamento() {
		return "mapeamento";
	}
	
	@RequestMapping("/sobre")
	public String sobre() {
		return "sobre";
	}
	
}
