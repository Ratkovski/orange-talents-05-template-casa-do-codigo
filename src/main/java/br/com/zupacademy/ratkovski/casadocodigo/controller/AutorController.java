package br.com.zupacademy.ratkovski.casadocodigo.controller;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;

import br.com.zupacademy.ratkovski.casadocodigo.dto.AutorDto;
import br.com.zupacademy.ratkovski.casadocodigo.modelo.Autor;

@RestController
//@RequestMapping("/autor")
public class AutorController {

	// @Autowired também funciona qual a diferenca
	// **@PersistenceConext, você pode passar qual persistence-unit quer usar
	// ex:@PersistenceContext(unitName="livraria-auditoria")
	// EntityManager já o @Autowired você precisaria criar um bean para ensinar pro
	// Spring como produzir um EntityManager**/

	@PersistenceContext
	private EntityManager em; // abrir e fechar transações automaticamente
// recurso responsável por realizar as operações de sincronismo com o banco de dados

	@PostMapping(value = "/autor")
	@Transactional
	public String cadastrar(@RequestBody @Valid AutorDto autordto) {
		Autor autor = autordto.toModel();
		em.persist(autor);
		return autor.toString();

		// *possui mais de uma forma de fazer**/
		// desta forma criamos mais um arquivo no sistema pra fazer o mesmo fluxo sem
		// dividir nenhuma responsabilidade
		/**
		 * @Autowired private AutorRepository autorRepository;
		 * @PostMapping
		 * @Transactional public ResponseEntity<AutorDto> cadastrar(@RequestBody @Valid
		 *                AutorDto autordto) { Autor autor = autordto.toModel();
		 *                autorRepository.save(autor); return
		 *                ResponseEntity.ok().build();
		 **/

	}
}
