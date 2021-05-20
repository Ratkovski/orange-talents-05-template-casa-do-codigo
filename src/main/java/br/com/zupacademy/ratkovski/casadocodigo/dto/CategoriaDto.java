package br.com.zupacademy.ratkovski.casadocodigo.dto;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonCreator;

import br.com.zupacademy.ratkovski.casadocodigo.modelo.Categoria;
import net.bytebuddy.asm.Advice.This;

public class CategoriaDto {


	@NotBlank(message = "O campo nome da categoria é obrigatório")
	@Column(nullable = false)
	private String nome;
	
	/*
	 * Anotação para evitar erro "JSON parse error: Cannot construct instance of.."
	 * Pois quando tem um atributo ele se perde
	 */

	@JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
	public CategoriaDto(@NotBlank(message = "O campo nome da categoria é obrigatório") String nome) {
		super();
		this.nome = nome;
	}

	public Categoria toModel() {	
		return new Categoria(nome);
	}
	

	

	public String getNome() {
		return this.nome;
	}

	
	

	
	
	
}
