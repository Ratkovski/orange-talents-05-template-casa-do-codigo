package br.com.zupacademy.ratkovski.casadocodigo.controller;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zupacademy.ratkovski.casadocodigo.config.validation.UnicoEmailValidator;
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

	@Autowired
	private UnicoEmailValidator unicoEmailValidator;

	/** Para validações customizadas **/
	/**
	 * um método publico com esta notation ele é utilizado já no primeiro request
	 * feito que bate no metodo deste controller o codigo dentro do init é executado
	 * para fazer configurações adicionais que vao ser colocadas na execução da
	 * request dest controller
	 **/
	@InitBinder
	public void init(WebDataBinder binder) {
		binder.addValidators(unicoEmailValidator);
	}

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
