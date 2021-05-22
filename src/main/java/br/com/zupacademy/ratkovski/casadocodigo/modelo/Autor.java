package br.com.zupacademy.ratkovski.casadocodigo.modelo;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Autor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank(message = "O campo nome é obrigatório")
	@Column(nullable = false)
	private String nome;

	@NotBlank(message = "O campo e-mail é obrigatório")
	@Column(nullable = false)
	@Email(message = "Digite um e-mail válido")
	private String email;

	@NotBlank(message = "A descrição não pode estar em branco")
	@Column(nullable = false)
	@Size(max = 400, message = "Número máximo de caracteres é 400")
	private String descricao;

	@NotNull
	@Column(nullable = false)
	private LocalDateTime data = LocalDateTime.now();

	
	@Deprecated
	public Autor() {

	}

	public Autor(@NotBlank String nome, @NotBlank @Email String email, @NotBlank @Size(max = 400) String descricao) {
		super();
		this.nome = nome;
		this.email = email;
		this.descricao = descricao;

	}
	
	
	

	public Long getId() {
		return id;
	}



	@Override
	public String toString() {
		return "Autor [id=" + id + ", nome=" + nome + ", email=" + email + ", descricao=" + descricao + ", data=" + data
				+ "]";
	}

}
