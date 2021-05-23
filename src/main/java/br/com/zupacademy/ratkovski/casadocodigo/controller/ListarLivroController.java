package br.com.zupacademy.ratkovski.casadocodigo.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RestController;

import br.com.zupacademy.ratkovski.casadocodigo.dto.ListarLivroDto;

import br.com.zupacademy.ratkovski.casadocodigo.repository.LivroRepository;

@RestController

public class ListarLivroController {

	@Autowired
	private LivroRepository livroRepository;

	@GetMapping("/lista")
	public Page<ListarLivroDto> listarLivrosIdNome(Pageable paginacao) {
		return livroRepository.findAll(paginacao).map(listarLivro -> new ListarLivroDto(listarLivro));
	}
}
