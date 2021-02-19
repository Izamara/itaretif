package edu.ifrn.itaretif.controllers;

import edu.ifrn.itaretif.service.ProjetoService;

import java.time.LocalDate;
import java.util.List;

import javax.validation.Valid;

import org.hibernate.criterion.Projection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.ifrn.itaretif.models.Projeto;
import edu.ifrn.itaretif.models.Setor;
import edu.ifrn.itaretif.models.Usuario;

@Controller
public class ControllerProjeto {

		@Autowired
		ProjetoService projetoService;
		
		@RequestMapping(value = "/projetos", method = RequestMethod.GET )
		public ModelAndView getProjetos() {
			ModelAndView mv = new ModelAndView("projetos");
			List<Projeto> projetos = projetoService.findAll();
			mv.addObject("projetos", projetos);
			return mv;
			
		}
		
		@RequestMapping(value = "/projeto/{id}", method = RequestMethod.GET )
		public ModelAndView getProjetoDetails(@PathVariable("id") long id) {
			ModelAndView mv = new ModelAndView("projetosDetails");
			Projeto projeto = projetoService.findById(id);
			mv.addObject("projetos", projeto);
			return mv;
		}
		
		 @RequestMapping(value="/serv/novoprojeto", method=RequestMethod.GET)
		    public String getProjetoForm(){
		        return "projetoForm" ;
		    }

		    @RequestMapping(value="/serv/novoprojeto", method=RequestMethod.POST)
		    public String saveProjeto(@Valid Projeto projeto, BindingResult result, RedirectAttributes attributes){
		        if(result.hasErrors()){
		            attributes.addFlashAttribute("mensagem", "Verifique se os campos obrigatórios foram preenchidos!");
		            return "redirect:/serv/novoprojeto";
		        }
		      
		        projetoService.save(projeto);
		        attributes.addFlashAttribute("mensagem", "Projeto cadastrado com sucesso!");
		        return "redirect:/projetos";
		    }
		    
		    
		    @RequestMapping("/deletarProjeto/{id}")
			public String deletarProjeto(long id){
		    	System.out.print("chamou o metodo");
		    	Projeto projeto = projetoService.findById(id);
		    	projetoService.delete(projeto);
				return "redirect:/projetos";
			
		    }
		    
		    
		    @RequestMapping(value="/editarProjeto/{id}", method=RequestMethod.GET)
		    public ModelAndView alterarSetor(@PathVariable("id")long id){
		    	ModelAndView mv = new ModelAndView ("projetoEdit");
		    	Projeto projeto = projetoService.findById(id);
		    	mv.addObject("projetos", projeto);
		    	return mv;
		    	
		    }		
		    		
		        
		       @RequestMapping(value="/editarProjeto", method=RequestMethod.POST)
	            public ModelAndView alterarSetor(Projeto projeto){
		            ModelAndView mv = new ModelAndView();
		            projetoService.save(projeto);
		            mv.setViewName("redirect:/projetos");
		            return mv;
	           	
	           }

}

