package br.com.zupacademy.ratkovski.casadocodigo.dto;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import br.com.zupacademy.ratkovski.casadocodigo.config.validation.UniqueValue;
import br.com.zupacademy.ratkovski.casadocodigo.modelo.Autor;
import br.com.zupacademy.ratkovski.casadocodigo.modelo.Categoria;

public class AutorDto {

	@NotBlank(message = "O campo nome é obrigatório")
	@Column(nullable = false)
	private String nome;

	@NotBlank(message = "O campo e-mail é obrigatório")
	@Column(nullable = false)
	@UniqueValue(domainClass = Autor.class, fieldName = "email")
	@Email(message = "Digite um e-mail válido")
	private String email;

	@NotBlank(message = "A descrição não pode estar em branco")
	@Column(nullable = false)
	@Size(max = 400, message = "Número máximo de caracteres é 400")
	private String descricao;
	
	

	public AutorDto(@NotBlank(message = "O campo nome é obrigatório") String nome,
			@NotBlank(message = "O campo e-mail é obrigatório") @Email(message = "Digite um e-mail válido") String email,
			@NotBlank(message = "A descrição não pode estar em branco") @Size(max = 400, message = "Número máximo de caracteres é 400") String descricao) {
		super();
		this.nome = nome;
		this.email = email;
		this.descricao = descricao;

	}
/**não tinha nescessidade*/
	/*
	 * public String getNome() { return nome; }
	 * 
	 * public String getEmail() { return email; }
	 * 
	 * public String getDescricao() { return descricao; }
	 */

	public Autor toModel() {
		return new Autor(nome, email, descricao);
	}
	
	public String getEmail() { 
		return this.email;
	}

}
