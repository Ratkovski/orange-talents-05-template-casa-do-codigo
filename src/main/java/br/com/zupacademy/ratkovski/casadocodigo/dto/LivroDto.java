package br.com.zupacademy.ratkovski.casadocodigo.dto;


import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;
import org.springframework.util.Assert;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.zupacademy.ratkovski.casadocodigo.config.validation.ExistsId;
import br.com.zupacademy.ratkovski.casadocodigo.config.validation.UniqueValue;
import br.com.zupacademy.ratkovski.casadocodigo.modelo.Autor;
import br.com.zupacademy.ratkovski.casadocodigo.modelo.Categoria;
import br.com.zupacademy.ratkovski.casadocodigo.modelo.Livro;
import br.com.zupacademy.ratkovski.casadocodigo.repository.AutorRepository;
import br.com.zupacademy.ratkovski.casadocodigo.repository.CategoriaRepository;
public class LivroDto {

@NotBlank(message = "O titulo é obrigatório")
@UniqueValue(domainClass = Livro.class, fieldName = "titulo")
private String titulo;


@NotBlank(message = "O resumo é obrigatório")
@Length(max = 500, message = "Número máximo de caracteres é 500")
private String resumo;

@NotBlank(message = "O sumário não pode estar em branco")
private String sumario;

@NotNull(message = "O preço é obrigatório")
@Min(value = 20, message = "O preço minimo é 20 reais")
private BigDecimal preco;

@NotNull(message = "O número de páginas é obrigatório")
@Min(value = 100, message = "O número minimo de páginas é 100")
private Integer numeroPaginas;

@NotBlank(message = "O isbn é obrigatório")
@UniqueValue(domainClass = Livro.class, fieldName = "isbn")
private String isbn;

// @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
@JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING)
@NotNull
@Future
private LocalDate dataPublicacao;

@NotNull
@ExistsId(domainClass = Autor.class, fieldName = "id" )
private Long idAutor;

@NotNull
@ExistsId(domainClass = Categoria.class, fieldName = "id")
private Long idCategoria;

@JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
public LivroDto(
		@NotBlank(message = "O titulo é obrigatório") @Size(min = 3, message = "O titulo precisa ter mais que 3 caracteres") String titulo,
		@NotBlank(message = "O resumo é obrigatório") @Length(max = 500, message = "Número máximo de caracteres é 500") String resumo,
		@NotBlank(message = "O sumario não pode estar em branco") String sumario,
		@NotNull(message = "O preço é obrigatório") @Min(value = 20, message = "O preço minimo é 20 reais") BigDecimal preco,
		@NotBlank(message = "O número de páginas é obrigatório") @Min(value = 100, message = "O número minimo de páginas é 100") Integer numeroPaginas,
		@NotBlank(message = "O isbn é obrigatório") String isbn, @NotNull @Future LocalDate dataPublicacao,
		@NotNull Long idAutor, @NotNull Long idCategoria) {
	super();
	this.titulo = titulo;
	this.resumo = resumo;
	this.sumario = sumario;
	this.preco = preco;
	this.numeroPaginas = numeroPaginas;
	this.isbn = isbn;
	this.dataPublicacao = dataPublicacao;
	this.idAutor = idAutor;
	this.idCategoria = idCategoria;
}

/**
 * setter criado pq o jackson não estava sendo capaz de desserializar o json com
 * a data no parametro pelo construtor
 **/

public void setDataPublicacao(LocalDate dataPublicacao) {
	this.dataPublicacao = dataPublicacao;
}
/**a carga intriseca se torna maior
/**public Livro converter(AutorRepository autorRepository, CategoriaRepository categoriaRepository) {
	{

		Autor autordb = autorRepository.findById(idAutor).get();
		Categoria categoriadb = categoriaRepository.findById(idCategoria).get();
		return new Livro(titulo, resumo, sumario, preco, numeroPaginas, isbn, dataPublicacao, autordb, categoriadb);
	}
}**/

public LocalDate getDataPublicacao() {
	return dataPublicacao;
}

public Long getIdAutor() {
	return idAutor;
}

public Long getIdCategoria() {
	return idCategoria;
}

public Livro toModel(EntityManager em) {
	@NotNull Autor autor = em.find(Autor.class, idAutor);
	@NotNull Categoria categoria = em.find(Categoria.class, idCategoria);

	Assert.state(autor!=null,"Este autor que não esta cadastrado no banco "+idAutor);
	Assert.state(categoria!=null,"Esta categoria não está cadastrada no banco "+idCategoria);
	return new Livro(titulo, resumo, sumario, preco, numeroPaginas, isbn, dataPublicacao, autor, categoria);
}


}

