package eus.birt.dam.alvarez_martinez_david_AD05_TaEv2.domain;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//Superclase
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
public class ClaseId {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
}
