package eus.birt.dam.alvarez_martinez_david_AD05_TaEv2.domain;

import java.time.LocalDate;
import org.springframework.format.annotation.DateTimeFormat;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
public class Opinion extends ClaseId {
	
	//Atributos que se corresponden con las columnas
	@Column
	private String nombre;
	
	@Column
	private int valoracion;
	
	@DateTimeFormat (pattern = "yyyy-MM-dd")
	private LocalDate fechaValoracion; 
	
	@Column
	private String razon;
	
	//Relación Many to one
	@ManyToOne
	@JoinColumn (name = "articulo_id")
	private Articulo articulo;
	
	//Constructor
	public Opinion(String nombre, int valoracion, LocalDate fechaValoracion, String razon) {
		super();
		this.nombre = nombre;
		this.valoracion = valoracion;
		this.fechaValoracion = fechaValoracion;
		this.razon = razon;
	}
	

}
