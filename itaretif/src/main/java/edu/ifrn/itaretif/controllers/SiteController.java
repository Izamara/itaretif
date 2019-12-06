package edu.ifrn.itaretif.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SiteController {
	
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
	
//	@RequestMapping("/sobre")
//	public String sobre() {
//		return "sobre";
//	}
	
	@RequestMapping("/planta1")
	public String palnta1() {
		return "planta1";
	}
	
	@RequestMapping("/planta2")
	public String palnta2() {
		return "planta2";
	}
	
	@RequestMapping("/planta3")
	public String palnta3() {
		return "planta3";
	}
	
	@RequestMapping("/planta4")
	public String palnta4() {
		return "planta4";
	}
	
	@RequestMapping("/planta5")
	public String palnta5() {
		return "planta5";
	}
	
	@RequestMapping("/planta6")
	public String palnta6() {
		return "planta6";
	}
	
	@RequestMapping("/planta7")
	public String palnta7() {
		return "planta7";
	}
	
}
