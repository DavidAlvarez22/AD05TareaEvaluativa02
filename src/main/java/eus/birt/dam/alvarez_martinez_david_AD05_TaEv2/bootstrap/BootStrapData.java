package eus.birt.dam.alvarez_martinez_david_AD05_TaEv2.bootstrap;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import eus.birt.dam.alvarez_martinez_david_AD05_TaEv2.domain.Articulo;
import eus.birt.dam.alvarez_martinez_david_AD05_TaEv2.domain.Opinion;
import eus.birt.dam.alvarez_martinez_david_AD05_TaEv2.repository.ArticuloRepository;
import eus.birt.dam.alvarez_martinez_david_AD05_TaEv2.repository.OpinionRepository;
import jakarta.transaction.Transactional;

@Component
public class BootStrapData implements CommandLineRunner{
	
	//Obtenemos nuestros repositorios para poder hacer acciones JPA
	@Autowired
	private ArticuloRepository articuloRepository;
	
	@Autowired
	private OpinionRepository opinionRepository;
	
	@Transactional //Metodo con única transaccion, evita: object references an unsaved transient instance
	@Override
	public void run(String... arg0) throws Exception {
		
		//Creamos los distintos objetos necesarios 
		Articulo articulo1 = new Articulo("Lo que queda por venir", "David",LocalDate.parse ("2023-02-12"),"Birt-DAm");
		Articulo articulo2 = new Articulo("Segunda parte del anterior", "David",LocalDate.parse ("2023-02-12"),"Birt-DAm");
		Opinion opinion1 = new Opinion ("Anonimo",10,LocalDate.parse ("2023-02-12"),"Ha sido muy interesante");
		Opinion opinion2 = new Opinion ("Anonimo2",4,LocalDate.parse ("2023-02-12"),"No ofrece nada nuevo");
		Opinion opinion3 = new Opinion ("Anonimo",7,LocalDate.parse ("2023-02-12"),"Ha sido interesante");
		
		//Hacemos operaciones bidireccionales
		articulo1.getOpiniones().add(opinion1);
		articulo1.getOpiniones().add(opinion2);
		articulo2.getOpiniones().add(opinion3);
		
		opinion1.setArticulo(articulo1);
		opinion2.setArticulo(articulo1);
		opinion3.setArticulo(articulo2);
						
		//Guardamos nuestros distintos objetos
		articuloRepository.save(articulo1);
		articuloRepository.save(articulo2);
		
		opinionRepository.save(opinion1);	
		opinionRepository.save(opinion2);
		opinionRepository.save(opinion3);
			
		
		System.out.println("Carga finalizada correctamente");
        System.out.println("Numero de artículos: " + articuloRepository.count());
        System.out.println("Numero de opiniones: " + opinionRepository.count());	
	}
	
}
