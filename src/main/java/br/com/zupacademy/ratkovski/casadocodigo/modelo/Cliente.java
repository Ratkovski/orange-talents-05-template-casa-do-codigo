package br.com.zupacademy.ratkovski.casadocodigo.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.zupacademy.ratkovski.casadocodigo.config.validation.CPForCNPJ;

@Entity
public class Cliente {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Email
	private String 	email;
	@NotBlank
	private String  nome;
	@NotBlank
	private String  sobrenome;
	@CPForCNPJ
	private String  documento;
	@NotBlank
	private String  endereco;
	@NotBlank
	private String  complemento;
	@NotBlank
	private String  cidade;
	
	@NotNull
	@ManyToOne
	private Pais pais;
	
	@NotNull
	@ManyToOne
	private Estados estados;
	
	@NotBlank
	private String 	telefone;
	@NotBlank
	private String cep;
	
	
	@Deprecated
	public Cliente() {
		
	}
	

	public Cliente(@Email String email, @NotBlank String nome, @NotBlank String sobrenome, String documento,
			@NotBlank String endereco, @NotBlank String complemento, @NotBlank String cidade, @NotNull Pais pais,
			@NotNull Estados estados, @NotBlank String telefone, @NotBlank String cep) {
		super();
		this.email = email;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.documento = documento;
		this.endereco = endereco;
		this.complemento = complemento;
		this.cidade = cidade;
		this.pais = pais;
		this.estados = estados;
		this.telefone = telefone;
		this.cep = cep;
	}




	public Long getId() {
		return id;
	}

}
