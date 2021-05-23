package br.com.zupacademy.ratkovski.casadocodigo.modelo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;

@Entity
public class Pais {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotBlank
	private String nome;
	
	@OneToMany(mappedBy = "pais", fetch = FetchType.EAGER)
	private Set<Estados> estados = new HashSet<Estados>();
	 /**mappedBy é para indicar qual é o lado inverso ou não dominante da relação.**/
	/** FetchType.EAGER Isso carrega todos os relacionamentos.**/
	
	
	@Deprecated
	public Pais() {
		
	}

		
	public Pais( @NotBlank String nome) {
		this.nome = nome;
	}
	
	public String getNome() {
		return nome;

}

	@Override
	public String toString() {
		return "Pais [id=" + id + ", nome=" + nome + "]";
	}
	
}
