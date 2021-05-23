package br.com.zupacademy.ratkovski.casadocodigo.controller;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.zupacademy.ratkovski.casadocodigo.dto.PaisDto;
import br.com.zupacademy.ratkovski.casadocodigo.modelo.Pais;

@RestController
public class PaisController {
	
	@PersistenceContext
	private EntityManager em;
	
	
	@PostMapping(value= "/paises")
	@Transactional
public String cadastrar(@RequestBody @Valid PaisDto paisDto) {
	Pais pais = paisDto.toModel();
	em.persist(pais);
return pais.toString();
	
	}
	
}
