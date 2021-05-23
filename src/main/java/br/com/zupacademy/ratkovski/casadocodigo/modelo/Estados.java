package br.com.zupacademy.ratkovski.casadocodigo.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
@Entity
public class Estados {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotBlank
	private String nome;
	
	@NotNull
	@Valid
	@ManyToOne
	private Pais pais;

	@Deprecated
	public Estados() {
		
	}
	
	
	
	public Estados(@NotBlank String nome, @NotNull @Valid Pais pais) {
		super();
		this.nome = nome;
		this.pais = pais;
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public Pais getPais() {
		return pais;
	}

	@Override
	public String toString() {
		return "Estados [id=" + id + ", nome=" + nome + ", pais=" + pais + "]";
	}
	
	
	
}
