package br.com.zupacademy.ratkovski.casadocodigo.controller;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zupacademy.ratkovski.casadocodigo.config.validation.ExisteEstadoNoPaisValidator;
import br.com.zupacademy.ratkovski.casadocodigo.dto.ClienteDto;
import br.com.zupacademy.ratkovski.casadocodigo.dto.ClienteRespostaDto;
import br.com.zupacademy.ratkovski.casadocodigo.modelo.Cliente;

@RestController
@RequestMapping
public class ClienteController {
	
	@PersistenceContext
	private EntityManager em;
	
	@Autowired
	private ExisteEstadoNoPaisValidator existeEstadoNoPaisValidator;

	
	/**chama o verificador antes de continuar**/
	@InitBinder
	public void init(WebDataBinder binder) {
		binder.addValidators(existeEstadoNoPaisValidator);
	}
	
	/**abaixo duas formas de cadastrar deixei uma comentada  para estudo**/
	
	
	@PostMapping(value = "/clientes")
	@Transactional
	
	public ResponseEntity<ClienteRespostaDto> cadastra(@RequestBody @Valid ClienteDto clienteDto) {
		Cliente cliente = clienteDto.toModel(em);
		em.persist(cliente);

		System.out.println("id novo cliente: " + cliente.getId());

		return ResponseEntity.ok(ClienteRespostaDto.toModel(cliente));
		
		
	}
	
	/**
	
	public String cadastrar(@RequestBody @Valid ClienteDto clienteDto) {	
		Cliente cliente = clienteDto.toModel(em);
		em.persist(cliente);
			System.out.println("id novo cliente: " + cliente.getId());
		return cliente.toString();
	}
	
**/
}
