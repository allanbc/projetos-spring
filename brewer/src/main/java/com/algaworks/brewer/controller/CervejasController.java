package com.algaworks.brewer.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.algaworks.brewer.model.Cerveja;
import com.algaworks.brewer.model.Origem;
import com.algaworks.brewer.model.Sabor;
import com.algaworks.brewer.repository.Estilos;
import com.algaworks.brewer.service.CadastroCervejaService;

@Controller
public class CervejasController {
	
	//private static final Logger logger = LoggerFactory.getLogger(CervejasController.class);
	
	//@Autowired
	//private Cervejas cervejas;
	
	@Autowired
	private Estilos estilos;
	
	@Autowired
	private CadastroCervejaService cadastroCervejaService;
	
	@RequestMapping("/cervejas/novo")
	//public String novo(Cerveja cerveja){//Model model - Aula 4.3
	public ModelAndView novo(Cerveja cerveja){//Aula 9.5
		//model.addAttribute(new Cerveja());-- Aula 4.3
		//Aula 6.3 - Logger
		//logger.error("Aqui é um log nível erro");
		//logger.info("Aqui é um log nível info");
		//cervejas.findAll();//Aula 9.2
		//Optional<Cerveja> cervejaOptional = cervejas.findBySkuIgnoreCase("AA1111");//Aula 9.3
		//System.out.println(cervejaOptional.isPresent());--Aula 9.3	
		ModelAndView mv = new ModelAndView("cerveja/CadastroCerveja");//Aula 9.5
		mv.addObject("sabores", Sabor.values());
		mv.addObject("estilos", estilos.findAll());
		mv.addObject("origens", Origem.values());
		return mv;
	}
	
	@RequestMapping(value = "/cervejas/novo", method = RequestMethod.POST)
	public ModelAndView cadastrar(@Valid Cerveja cerveja, BindingResult result, Model model, RedirectAttributes attributes){
		if(result.hasErrors()){
			//model.addAttribute(cerveja);--Aula 4.3
			//return "cerveja/CadastroCerveja"; --Aula 4.3
			return novo(cerveja);//Aula 4.3
		}
		
		//Salvar no banco de dados
		//No redirect a mensagem some
		//addFlasAttributes não perde a mensagem quando é feito o redirect
		//model.addAttribute("mensagem", "Cerveja salva com sucesso");
		cadastroCervejaService.salvar(cerveja);
		attributes.addFlashAttribute("mensagem", "Cerveja salva com sucesso!");
		return new ModelAndView("redirect:/cervejas/novo");
	}
}
