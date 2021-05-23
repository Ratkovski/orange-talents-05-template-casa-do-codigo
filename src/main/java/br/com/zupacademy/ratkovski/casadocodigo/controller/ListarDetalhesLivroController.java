package br.com.zupacademy.ratkovski.casadocodigo.controller;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import br.com.zupacademy.ratkovski.casadocodigo.dto.DetalhesLivroDto;
import br.com.zupacademy.ratkovski.casadocodigo.modelo.Livro;

@RestController

public class ListarDetalhesLivroController {

	
	@PersistenceContext
	private EntityManager em;
	
	@GetMapping(value= "/listardetalhes/{id}")
	public ResponseEntity<?> listarDetalhes(@PathVariable("id") Long id){
		Livro livroBusca = em.find(Livro.class, id);
		if(livroBusca == null) {
			return ResponseEntity.notFound().build();
		}
		DetalhesLivroDto detalhesLivroDto = new DetalhesLivroDto(livroBusca);
		return ResponseEntity.ok( detalhesLivroDto);
		
	}
	
}
