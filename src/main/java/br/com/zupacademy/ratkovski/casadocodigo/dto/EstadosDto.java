package br.com.zupacademy.ratkovski.casadocodigo.dto;

import javax.persistence.EntityManager;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.util.Assert;

import com.fasterxml.jackson.annotation.JsonCreator;

import br.com.zupacademy.ratkovski.casadocodigo.config.validation.ExisteUmEstadoPorPais;
import br.com.zupacademy.ratkovski.casadocodigo.config.validation.ExistsId;
import br.com.zupacademy.ratkovski.casadocodigo.modelo.Estados;
import br.com.zupacademy.ratkovski.casadocodigo.modelo.Pais;

@ExisteUmEstadoPorPais
public class EstadosDto {

	@NotBlank(message = "O campo nome é obrigatório")
	
	private String nome;

	@NotNull
    @ExistsId(domainClass = Pais.class, fieldName = "id" )
	private Long idPais;

	/**lembar de usar o json quando for somente uma para n se perder**/
	@JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
	public EstadosDto(@NotBlank(message = "O campo nome é obrigatório") String nome, @NotNull Long idPais) {
		super();
		this.nome = nome;
		this.idPais = idPais;
	}

	public String getNome() {
		return nome;
	}

	public Long getIdPais() {
		return idPais;
	}
	

	@Override
	public String toString() {
		return "EstadosDto [nome=" + nome + ", idPais=" + idPais + "]";
	}

	public Estados toModel(EntityManager em) {
		@NotNull Pais pais = em.find(Pais.class, idPais);
		Assert.state(pais !=null,"Este pais não esta cadastrado no banco "+idPais);

		/**return new Estados(nome, em.find(Pais.class, idPais));**/
		return new Estados(nome, pais);
	}
	
}
	

