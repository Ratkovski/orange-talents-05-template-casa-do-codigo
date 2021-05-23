package br.com.zupacademy.ratkovski.casadocodigo.dto;

import br.com.zupacademy.ratkovski.casadocodigo.modelo.Livro;

public class ListarLivroDto {
	
		private Long id;
		private String titulo;

		
		
		public ListarLivroDto (Livro livro) {
			this.id= livro.getId();
			this.titulo=livro.getTitulo();
			
		}



		public Long getId() {
			return id;
		}



		public String getTitulo() {
			return titulo;
		}
		


	}


