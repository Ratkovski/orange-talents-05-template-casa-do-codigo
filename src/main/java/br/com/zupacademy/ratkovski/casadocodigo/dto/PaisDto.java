package br.com.zupacademy.ratkovski.casadocodigo.dto;


import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonCreator;

import br.com.zupacademy.ratkovski.casadocodigo.config.validation.UniqueValue;
import br.com.zupacademy.ratkovski.casadocodigo.modelo.Pais;

public class PaisDto {

	
	@NotBlank(message = "O campo nome é obrigatório")
	@UniqueValue(domainClass = Pais.class, fieldName = "nome")
	private String nome;
	
	/**lembar de usar o json quando for somente uma para n se perder**/
	@JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
	public PaisDto(@NotBlank(message = "O campo nome é obrigatório") String nome) {
		super();
		this.nome = nome;
	}
	
	public String getNome() {
		return nome;
	}

	public Pais toModel() {
		return new Pais(nome);
	}
}
