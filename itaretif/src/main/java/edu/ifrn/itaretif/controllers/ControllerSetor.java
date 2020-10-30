package edu.ifrn.itaretif.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
		
		    @RequestMapping(value="/listarSetores", method= RequestMethod.GET)
			public ModelAndView listarSetores(){
		    	ModelAndView mv = new ModelAndView("setor/listarSetores");
		    	Iterable<Setor> setores = sr.findAll();
		    	mv.addObject("setores", setores);
		    	return mv;
		    	
	    } 	
		    
		    @GetMapping("deletarSetor")
			    public String deletarSetor(long id){
			    Setor setor = sr.findById(id);
			    sr.delete(setor);
			    return "redirect:/listarSetores";
		    }

		    
		    @RequestMapping(value="/editarSetor/{id}", method=RequestMethod.GET)
		    public ModelAndView alterarSetor(@PathVariable("id")long id){
		    	ModelAndView mv = new ModelAndView ("setor/setorEditi");
		    	Setor setor = sr.findById(id);
		    	mv.addObject("setor", setor);
		    	return mv;
		    	
		    }		
		    		
		        
		       @RequestMapping(value="/editarSetor", method=RequestMethod.POST)
	            public ModelAndView alterarSetor(Setor setor){
		            ModelAndView mv = new ModelAndView();
		            sr.save(setor);
		            mv.setViewName("redirect:/listarSetores");
		            return mv;
	           	
	           }
 	
	    
		
}
