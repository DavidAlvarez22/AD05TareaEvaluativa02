package eus.birt.dam.alvarez_martinez_david_AD05_TaEv2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import eus.birt.dam.alvarez_martinez_david_AD05_TaEv2.domain.Articulo;
import eus.birt.dam.alvarez_martinez_david_AD05_TaEv2.repository.ArticuloRepository;

@Controller
@RequestMapping ("/articulo")
public class ArticuloController {
	
	@Autowired
	ArticuloRepository articuloRepository;
		
		//En función de la url nos dirigirá a la página html correspondiente
		@GetMapping("/borrar/{id}")
		public String delete(@PathVariable("id") int id) { // Obtenemos id de artículo
			articuloRepository.deleteById(id);
		return "redirect:/articulo";
		}
		
		@GetMapping("/nuevo")
		public String initCreationForm(Model model) {
			Articulo articulo = new Articulo();
			model.addAttribute("articulos", articulo); // Pasamos el artículo
			return "articuloForm";
		}
		
		
		@PostMapping("/nuevo/submit")
		public String processCreationForm(@ModelAttribute Articulo articulo) {//Obtenemos los datos del formulario
			articuloRepository.save(articulo); // guardamos artículo 
			return "redirect:/articulo";
		}
		
		@GetMapping("/editar/{id}")
		public String initEditForm(@PathVariable("id") int id, Model model) {	 //Obtenemos el id
			model.addAttribute("articulos", articuloRepository.findById(id)); //pasamos el artículo según id
			return "articuloForm";
		}
	}


