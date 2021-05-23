package br.com.zupacademy.ratkovski.casadocodigo.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import br.com.zupacademy.ratkovski.casadocodigo.modelo.Livro;

public class DetalhesLivroDto {

	private String titulo;
	private AutorDetalhesDto autor;
	private BigDecimal preco;
	private String resumo;
	private String sumario;
	private String isbn;
	private Integer numeroPaginas;
	private String dataPublicacao;
	
	
	public DetalhesLivroDto(Livro livro) {
		titulo = livro.getTitulo();
		autor = new AutorDetalhesDto(livro.getAutor());
		preco = livro.getPreco();
		resumo = livro.getResumo();
	    sumario = livro.getSumario();
		isbn = livro.getIsbn();
		numeroPaginas = livro.getNumeroPaginas();
		/**dataPublicacao = livro.getDataPublicacao().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));**/
		
	}
/**public String getDataPublicacao() {
	return dataPublicacao;
}**/

	public String getTitulo() {
		return titulo;
	}


	public AutorDetalhesDto getAutor() {
		return autor;
	}


	public BigDecimal getPreco() {
		return preco;
	}


	public String getResumo() {
		return resumo;
	}


	public String getSumario() {
		return sumario;
	}


	public String getIsbn() {
		return isbn;
	}


	public Integer getNumeroPaginas() {
		return numeroPaginas;
	}
	
	
	
	
	

	
	
	
	
	
}
