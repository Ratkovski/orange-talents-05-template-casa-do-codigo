package br.com.zupacademy.ratkovski.casadocodigo.controller;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zupacademy.ratkovski.casadocodigo.dto.LivroDto;
import br.com.zupacademy.ratkovski.casadocodigo.modelo.Livro;

/**classe escolhida para a contagem de carga intriseca**/
/**fiquei em duvida se o  EntityManager entraria na contagem**/

@RestController
@RequestMapping
public class LivroController {
	
	@PersistenceContext
	private EntityManager em;
	
	
	@PostMapping(value="/livro")
	@Transactional
	public String cria(@RequestBody @Valid LivroDto livroDto) {
		//1
		Livro livro = livroDto.toModel(em);
		em.persist(livro);
		return livro.toString();
	}
	
/** com o metodo abaixo neste cenario a carga intriseca seria maior  sem nescessidade  fiz para aprendizado**/
	/**
@Autowired
private LivroRepository livroRepository;
//1
@Autowired
private AutorRepository autorRepository;
//2
@Autowired
private CategoriaRepository categoriaRepository;
//3

@PostMapping(value="/livro")
@Transactional
public ResponseEntity<?> cadastrar(@RequestBody @Valid LivroDto livroDto) {
//4
	Livro livro = livroDto.converter(autorRepository, categoriaRepository);
	livroRepository.save(livro);
	return ResponseEntity.ok().build();

}**/



}
	