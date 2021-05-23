package br.com.zupacademy.ratkovski.casadocodigo.dto;

import br.com.zupacademy.ratkovski.casadocodigo.modelo.Autor;

public class AutorDetalhesDto  {

	private String nome;
	private String descricao;

	public AutorDetalhesDto(Autor autor) {
   nome = autor.getNome();
   descricao = autor.getDescricao();
	}

	public String getNome() {
		return nome;
	}

	public String getDescricao() {
		return descricao;
	}

}
