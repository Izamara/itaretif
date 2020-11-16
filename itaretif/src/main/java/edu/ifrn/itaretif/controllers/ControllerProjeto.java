package edu.ifrn.itaretif.controllers;

import edu.ifrn.itaretif.service.ProjetoService;

import java.time.LocalDate;
import java.util.List;

import javax.validation.Valid;

import org.hibernate.criterion.Projection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.ifrn.itaretif.models.Projeto;

@Controller
public class ControllerProjeto {

		@Autowired
		ProjetoService ProjetoService;
		
		@RequestMapping(value = "/projetos", method = RequestMethod.GET )
		public ModelAndView getProjetos() {
			ModelAndView mv = new ModelAndView("projetos");
			List<Projeto> projetos = ProjetoService.findAll();
			mv.addObject("projetos", projetos);
			return mv;
			
		}
		
		@RequestMapping(value = "/projetos/{id}", method = RequestMethod.GET )
		public ModelAndView getProjetoDetails(@PathVariable("id") long id) {
			ModelAndView mv = new ModelAndView("projetosDetails");
			Projeto projeto = ProjetoService.findById(id);
			mv.addObject("projetos", projeto);
			return mv;
		}
		
		 @RequestMapping(value="/serv/novoprojeto", method=RequestMethod.GET)
		    public String getProjetoForm(){
		        return "projetoForm";
		    }

		    @RequestMapping(value="/serv/novoprojeto", method=RequestMethod.POST)
		    public String saveProjeto(@Valid Projeto projeto, BindingResult result, RedirectAttributes attributes){
		        if(result.hasErrors()){
		            attributes.addFlashAttribute("mensagem", "Verifique se os campos obrigatórios foram preenchidos!");
		            return "redirect:/novoprojeto";
		        }
		      
		        ProjetoService.save(projeto);
		        attributes.addFlashAttribute("mensagem", "Projeto cadastrado com sucesso!");
		        return "redirect:/projetos";
		    }

}

