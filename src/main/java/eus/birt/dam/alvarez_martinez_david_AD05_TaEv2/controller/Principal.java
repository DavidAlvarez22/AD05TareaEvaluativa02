package eus.birt.dam.alvarez_martinez_david_AD05_TaEv2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import eus.birt.dam.alvarez_martinez_david_AD05_TaEv2.repository.ArticuloRepository;
import eus.birt.dam.alvarez_martinez_david_AD05_TaEv2.repository.OpinionRepository;

@Controller
public class Principal {
		
	@Autowired
   	private ArticuloRepository articuloRepository;
	@Autowired
   	private OpinionRepository opinionRepository;
	
	//En función de la url nos dirigirá a la página html correspondiente
	@GetMapping ({"/","/welcome"})
	public String welcome() {
		return "index";
	}
	
	@GetMapping ({"/articulo"})
	public String getCyclists(Model model) {
		model.addAttribute("articulos", articuloRepository.findAll()); //Pasamos todos los articulos
		return "articulo";
	}
	
	@GetMapping ({"/opinion"})
	public String getTeams(Model model) {
		model.addAttribute("opiniones", opinionRepository.findAll()); // Pasamos todas las opiniones
		return "opinion";
	}
}


