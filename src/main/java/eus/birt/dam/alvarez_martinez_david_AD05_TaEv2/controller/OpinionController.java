package eus.birt.dam.alvarez_martinez_david_AD05_TaEv2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import eus.birt.dam.alvarez_martinez_david_AD05_TaEv2.domain.Opinion;
import eus.birt.dam.alvarez_martinez_david_AD05_TaEv2.repository.ArticuloRepository;
import eus.birt.dam.alvarez_martinez_david_AD05_TaEv2.repository.OpinionRepository;

@Controller
@RequestMapping ("/opinion")
public class OpinionController {
	
	@Autowired
	OpinionRepository opinionRepository;
	
	@Autowired
	ArticuloRepository articuloRepository;
		
	//En función de la url nos dirigirá a la página html correspondiente
		@GetMapping("/borrar/{id}")
		public String delete(@PathVariable("id") int id) {
			opinionRepository.deleteById(id); //Borramos por ID
		return "redirect:/opinion";
		}
		
		@GetMapping("/nuevo")
		public String initCreationForm(Model model) {
			Opinion opinion = new Opinion();
			model.addAttribute("opinion", opinion); // Pasamos el objeto opinion
			model.addAttribute("articulos", articuloRepository.findAll()); //Pasamos los objetos artículos
			return "opinionForm";
		}
		
		@PostMapping("/nuevo/submit")
		public String processCreationForm(@ModelAttribute Opinion opinion) {
			opinionRepository.save(opinion); // Guardamos opinion
			return "redirect:/opinion";
		}
		
		@GetMapping("/editar/{id}")
		public String initEditForm(@PathVariable("id") int id, Model model) {//obtenemos el id 
			model.addAttribute("opinion", opinionRepository.findById(id)); //pasamos la opinión por id
			model.addAttribute("articulos", articuloRepository.findAll()); //pasamos listado de artículos
			return "opinionForm";
		}
	}


