package br.com.zupacademy.ratkovski.casadocodigo.dto;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonCreator;

import br.com.zupacademy.ratkovski.casadocodigo.config.validation.UniqueValue;
import br.com.zupacademy.ratkovski.casadocodigo.modelo.Categoria;

public class CategoriaDto {

	@NotBlank(message = "O campo nome da categoria é obrigatório")
	@Column(nullable = false)
	@UniqueValue(domainClass = Categoria.class, fieldName = "nome")
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
