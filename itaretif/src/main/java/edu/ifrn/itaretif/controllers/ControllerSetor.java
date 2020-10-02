package edu.ifrn.itaretif.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import edu.ifrn.itaretif.models.Setor;
import edu.ifrn.itaretif.repository.SetorRepository;

@Controller
public class ControllerSetor {
	@Autowired
	private SetorRepository sr;
	
	@RequestMapping(value="/cadastrarSetor", method=RequestMethod.GET)
	public String form(){
        return "setor/formSetor"; 

    } 
	
	
	@RequestMapping(value="/cadastrarSetor", method=RequestMethod.POST)
	public String form(Setor setor){
		  
		sr.save(setor);

		return "redirect:/cadastrarSetor";

	
   }
	
	    @RequestMapping(value="/setores", method= RequestMethod.GET)
		public ModelAndView listaSetores(){
	    	ModelAndView mv = new ModelAndView("setor");
	    	Iterable<Setor> setores = sr.findAll();
	    	mv.addObject("setor", setores);
	    	return mv;
	    	
    } 	
	    
		
}