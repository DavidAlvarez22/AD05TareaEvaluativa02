package eus.birt.dam.alvarez_martinez_david_AD05_TaEv2.domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//Anotaciones lombok
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Articulo extends ClaseId{
	
	//Atributos que se corresponden con las columnas
	@Column
	private String titulo;
	
	@Column 
	private String autor;
	
	@DateTimeFormat (pattern = "yyyy-MM-dd")
	private LocalDate fechaPublicacion;
	
	@Column
	private String revista_Publicacion;
	
	//Relación OneToMany con cascade all, para que al borrar el artículo 
	@OneToMany(mappedBy= "articulo", cascade=jakarta.persistence.CascadeType.ALL)
	List <Opinion> opiniones = new ArrayList<>();
	
	//Constructor
	public Articulo(String titulo, String autor, LocalDate fechaPublicacion, String revista_Publicacion) {
		super();
		this.titulo = titulo;
		this.autor = autor;
		this.fechaPublicacion = fechaPublicacion;
		this.revista_Publicacion = revista_Publicacion;
	}
		
}
