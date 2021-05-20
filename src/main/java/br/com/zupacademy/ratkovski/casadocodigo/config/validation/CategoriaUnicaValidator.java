package br.com.zupacademy.ratkovski.casadocodigo.config.validation;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import br.com.zupacademy.ratkovski.casadocodigo.dto.CategoriaDto;
import br.com.zupacademy.ratkovski.casadocodigo.modelo.Categoria;
import br.com.zupacademy.ratkovski.casadocodigo.repository.CategoriaRepository;

@Component  //para ser gerenciada pelo spring
public class CategoriaUnicaValidator implements Validator {

	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Override
	public boolean supports(Class<?> clazz) {
		return CategoriaDto.class.isAssignableFrom(clazz);// é a mesma ou é filha do autor request
		
	}
	@Override
	public void validate(Object target, Errors errors) {
		/**Verifica se já ocorreu algum outro erro de validação, caso sim, já não passa para a execucao da nossa validação.**/
		if(errors.hasErrors()) {
			return;
		}
		CategoriaDto request = (CategoriaDto) target;
Optional<Categoria> existeCategoria =  categoriaRepository.findByNomeIgnoreCase(request.getNome());
if(existeCategoria.isPresent()) {
	errors.rejectValue("nome", 
			"NomeUnicoCategoria");
	/**	errors.rejectValue("nome", null,
			"Já existe uma categoria cadastrada com este nome.");**/

	
}
	}
}

