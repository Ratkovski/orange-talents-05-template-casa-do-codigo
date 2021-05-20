package br.com.zupacademy.ratkovski.casadocodigo.controller;


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

import br.com.zupacademy.ratkovski.casadocodigo.config.validation.CategoriaUnicaValidator;

import br.com.zupacademy.ratkovski.casadocodigo.dto.CategoriaDto;
import br.com.zupacademy.ratkovski.casadocodigo.modelo.Categoria;
import br.com.zupacademy.ratkovski.casadocodigo.repository.CategoriaRepository;

@RestController
@RequestMapping("/categoria")

public class CategoriaController {
	
	
	  @Autowired 
	  private CategoriaRepository categoriaRepository ;
	  /**
	  @Autowired 
	  private CategoriaUnicaValidator categoriaUnicaValidator;
	  **/

		/** Para validações customizadas **/
		/**
		 * um método publico com esta notation ele é utilizado já no primeiro request
		 * feito que bate no metodo deste controller o codigo dentro do init é executado
		 * para fazer configurações adicionais que vao ser colocadas na execução da
		 * request dest controller
		 **/
	
		/*
		 * 
		 * @InitBinder public void init(WebDataBinder binder) {
		 * binder.addValidators(categoriaUnicaValidator); }
		 */
	  
	  
	 // @PostMapping(value = "/categoria")
	  @PostMapping
	  @Transactional public ResponseEntity<CategoriaDto> cadastrar(@RequestBody @Valid CategoriaDto categoriadto) {
		   Categoria categoria = categoriadto.toModel();
	                 categoriaRepository.save(categoria); 
	                 return ResponseEntity.ok().build();

}
	  
}
