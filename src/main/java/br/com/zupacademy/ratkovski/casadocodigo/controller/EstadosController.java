package br.com.zupacademy.ratkovski.casadocodigo.controller;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zupacademy.ratkovski.casadocodigo.dto.EstadosDto;
import br.com.zupacademy.ratkovski.casadocodigo.modelo.Estados;

@RestController
@RequestMapping
public class EstadosController {

	@PersistenceContext
	private EntityManager em;
	
	@PostMapping(value="/estados")
	@Transactional
	public String cadastrar(@RequestBody @Valid EstadosDto estadosDto) {
		Estados estado = estadosDto.toModel(em);
		em.persist(estado);
		return estado.toString();

		
		
	}
}
