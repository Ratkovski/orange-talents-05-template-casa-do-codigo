package br.com.zupacademy.ratkovski.casadocodigo.config.validation;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import br.com.zupacademy.ratkovski.casadocodigo.dto.AutorDto;
import br.com.zupacademy.ratkovski.casadocodigo.modelo.Autor;
import br.com.zupacademy.ratkovski.casadocodigo.repository.AutorRepository;

@Component  //para ser gerenciada pelo spring
public class UnicoEmailValidator implements Validator{

	@Autowired
	private AutorRepository autorRepository;
	
	@Override
	public boolean supports(Class<?> clazz) {
		return AutorDto.class.isAssignableFrom(clazz);// é a mesma ou é filha do autor request
		
	}
	@Override
	public void validate(Object target, Errors errors) {
		/**Verifica se já ocorreu algum outro erro de validação, caso sim, já não passa para a execucao da nossa validação.**/
		if(errors.hasErrors()) {
			return;
		}
		AutorDto request = (AutorDto) target;
Optional<Autor> possivelAutor =  autorRepository.findByEmail(request.getEmail());
if(possivelAutor.isPresent()) {
	errors.rejectValue("email", null,
			"Já existe um(a)outro(a) autor(a) com o mesmo email. O e-mail cadastrado é este     "
+request.getEmail());
	

}


}
}

