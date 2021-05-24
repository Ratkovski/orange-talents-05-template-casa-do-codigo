package br.com.zupacademy.ratkovski.casadocodigo.dto;

import javax.persistence.EntityManager;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.util.Assert;

import br.com.zupacademy.ratkovski.casadocodigo.config.validation.CPForCNPJ;
import br.com.zupacademy.ratkovski.casadocodigo.config.validation.ExistsId;
import br.com.zupacademy.ratkovski.casadocodigo.config.validation.UniqueValue;
import br.com.zupacademy.ratkovski.casadocodigo.modelo.Cliente;
import br.com.zupacademy.ratkovski.casadocodigo.modelo.Estados;
import br.com.zupacademy.ratkovski.casadocodigo.modelo.Pais;

public class ClienteDto {
	
	@NotNull
	@Email
	@UniqueValue(domainClass = Cliente.class, fieldName = "email")
	private String 	email;
	
	@NotBlank(message = "O nome é obrigatório")
	private String  nome;
	
	@NotBlank(message = "O sobrenome é obrigatório")
	private String  sobrenome;
	
	@CPForCNPJ
	@UniqueValue(domainClass = Cliente.class, fieldName = "documento")
	private String  documento;
	
	@NotBlank(message = "O endereço é obrigatório")
	private String  endereco;
	
	@NotBlank(message = "O complemento é obrigatório")
	private String  complemento;
	
	@NotBlank(message = "A cidade é obrigatória")
	private String  cidade;
	
	@NotNull
	@ExistsId(domainClass = Pais.class, fieldName = "id" )
	private Long idPais;
	
	@NotNull
	@ExistsId(domainClass = Estados.class, fieldName = "id" )
	private Long idEstados;
	
	@NotBlank(message = "O telefone é obrigatório")
	private String 	telefone;
	
	@NotBlank(message = "O cep é obrigatório")
	private String cep;
	
	

	public ClienteDto(@NotNull @Email String email, @NotBlank(message = "O nome é obrigatório") String nome,
			@NotBlank(message = "O sobrenome é obrigatório") String sobrenome, String documento,
			@NotBlank(message = "O endereço é obrigatório") String endereco,
			@NotBlank(message = "O complemento é obrigatório") String complemento,
			@NotBlank(message = "A cidade é obrigatória") String cidade, @NotNull Long idPais, @NotNull Long idEstados,
			@NotBlank(message = "O telefone é obrigatório") String telefone,
			@NotBlank(message = "O cep é obrigatório") String cep) {
		
		this.email = email;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.documento = documento;
		this.endereco = endereco;
		this.complemento = complemento;
		this.cidade = cidade;
		this.idPais = idPais;
		this.idEstados = idEstados;
		this.telefone = telefone;
		this.cep = cep;
	}

	




	public Long getIdPais() {
		return idPais;
	}





	public Long getIdEstados() {
		return idEstados;
	}



	public Cliente toModel(EntityManager em) {
		@NotNull Pais pais = em.find(Pais.class, idPais);
		@NotNull Estados estados =idEstados != null ? em.find(Estados.class, idEstados):null;

		Assert.state(pais!=null,"Este Paísque não esta cadastrado no banco "+idPais);
		Assert.state(estados!=null,"Este Estado não está cadastrada no banco "+idEstados);
		return new Cliente(email, nome,sobrenome,documento,endereco,complemento,cidade,pais,estados,telefone,cep);
	}

	
	}

	
	
	
	
	



