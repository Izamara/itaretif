package edu.ifrn.itaretif.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import edu.ifrn.itaretif.models.Servidor;
import edu.ifrn.itaretif.repository.ServidorRepository;

@Controller
public class ServidorController {
	
	@Autowired
	private ServidorRepository srr;
	
		@RequestMapping(value="/admin/cadastrarServidor", method=RequestMethod.GET)
		public String form(){
			
			return "servidor/formServidor";
		}

		@RequestMapping(value="/admin/cadastrarServidor", method=RequestMethod.POST)
		public String form(Servidor servidor){
			  
			srr.save(servidor);

			return "redirect:/admin/cadastrarServidor";

	   }
			
		    @RequestMapping(value="/admin/listarServidores", method= RequestMethod.GET)
			public ModelAndView listarServidores(){
		    	ModelAndView mv = new ModelAndView("servidor/listarServidores");
		    	Iterable<Servidor> servidores = srr.findAll();
		    	mv.addObject("servidores", servidores);
		    	return mv;
		    	
	    } 	
		    @RequestMapping(value="/deletarServidor", method=RequestMethod.GET)
			    public String deletarServidor(long id){
			    Servidor servidor = srr.findById(id);
			    srr.delete(servidor);
			    return "redirect:/admin/listarServidores";
			    
		    }
		
		    
		    @RequestMapping(value="/editarServidor/{id}", method=RequestMethod.GET)
		    public ModelAndView alterarServidor(@PathVariable("id")long id){
		    	ModelAndView mv = new ModelAndView ("servidor/servidorEditi");
		    	Servidor servidor = srr.findById(id);
		    	mv.addObject("servidor", servidor);
		    	return mv;
		    	
		    }		
		    		
		        
		       @RequestMapping(value="/editarServidor", method=RequestMethod.POST)
	            public ModelAndView alterarServidor(Servidor servidor){
		            ModelAndView mv = new ModelAndView();
		            srr.save(servidor);
		            mv.setViewName("redirect:/admin/listarServidores");
		            return mv;
	           	
	           }



}
