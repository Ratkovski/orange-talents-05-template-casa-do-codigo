package br.com.zupacademy.ratkovski.casadocodigo.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
public class Categoria {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank(message = "O campo nome da categoria é obrigatório")
	@Column(nullable = false)
	private String nome;

	@Deprecated
	public Categoria() {

	}

	public Categoria(@NotBlank(message = "O campo nome da categoria é obrigatório") String nome) {
	/**if(nome==null || nome.trim().equals("")) {
		throw new IllegalArgumentException("não podemos cadastrar sem o nome da categoria");
	}**/
		this.nome = nome;
	}

	@Override
	public String toString() {
		return "Categoria [id=" + id + ", nome=" + nome + "]";
	}

}
