package br.com.zupacademy.ratkovski.casadocodigo.modelo;


import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.Valid;
import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;


@Entity
public class Livro {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank
	private String titulo;

	@NotBlank
	@Length(max = 500)
	private String resumo;

	@NotBlank
	private String sumario;

	@NotNull
	@Min(20)
	private BigDecimal preco;

	@NotNull
	@Min(100)
	private Integer numeroPaginas;

	@NotBlank
	private String isbn;

	@NotNull
	@Future
	private LocalDate dataPublicacao;

	@NotNull
	@Valid
	@ManyToOne
	private Autor autor;

	@NotNull
	@Valid
	@ManyToOne
	private Categoria categoria;
	
	
@Deprecated
	public Livro() {

	}


	public Livro(@NotBlank String titulo,
			@NotBlank @Length(max = 500) String resumo,
			@NotBlank String sumario,
			@NotNull @Min(20) BigDecimal preco,
			@NotNull @Min(100) Integer numeroPaginas,
			@NotBlank String isbn,
			@NotNull @Future LocalDate dataPublicacao,
			@NotNull @Valid Autor autor,
			@NotNull @Valid Categoria categoria) {
		super();
		this.titulo = titulo;
		this.resumo = resumo;
		this.sumario = sumario;
		this.preco = preco;
		this.numeroPaginas = numeroPaginas;
		this.isbn = isbn;
		this.dataPublicacao = dataPublicacao;
		this.autor = autor;
		this.categoria = categoria;
	}


	public Long getId() {
		return id;
	}
	public String getTitulo() {
		return titulo;
	}

	public String getResumo() {
		return resumo;
	}

	public String getSumario() {
		return sumario;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public Integer getNumeroPaginas() {
		return numeroPaginas;
	}

	public String getIsbn() {
		return isbn;
	}

	public LocalDate getDataPublicacao() {
		return this.dataPublicacao;
	}

	public Autor getAutor() {
		return autor;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	@Override
	public String toString() {
		return "Livro [id=" + id + ", titulo=" + titulo + ", resumo=" + resumo + ", sumario=" + sumario + ", preco="
				+ preco + ", numeroPaginas=" + numeroPaginas + ", isbn=" + isbn + ", dataPublicacao=" + dataPublicacao
				+ ", autor=" + autor + ", categoria=" + categoria + "]";
	}




}

    
    
    
    

	




	
    
    
    
    
	

