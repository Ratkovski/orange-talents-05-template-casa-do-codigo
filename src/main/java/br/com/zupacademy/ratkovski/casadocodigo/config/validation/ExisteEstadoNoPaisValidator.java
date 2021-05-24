package br.com.zupacademy.ratkovski.casadocodigo.config.validation;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import br.com.zupacademy.ratkovski.casadocodigo.dto.ClienteDto;

@Component
public class ExisteEstadoNoPaisValidator implements Validator{
	
	@PersistenceContext
	private EntityManager em;
	
	
	@Override
	public boolean supports(Class<?> clazz) {
		return ClienteDto.class.isAssignableFrom(clazz);
	}
	
	
	@Override
	public void validate(Object target, Errors errors) {
		ClienteDto req = (ClienteDto) target;

		if (errors.hasErrors()) {
			return;
		}

		if (req.getIdEstados() == null) {
			Query query = em.createQuery("select 1 from Estados e WHERE e.pais.id = :idPais");
			query.setParameter("idEstados", req.getIdPais());

			List result = query.getResultList();

			if (!result.isEmpty()) {
				errors.rejectValue("idEstados", "", "Informe o Estado");
			}
		} else {
			Query query = em.createQuery("select 1 from Estados e WHERE e.pais.id = :idPais AND e.id = :idEstados");
			query.setParameter("idPais", req.getIdPais());
			query.setParameter("idEstados", req.getIdEstados());

			List result = query.getResultList();

			if (result.isEmpty()) {
				errors.rejectValue("idEstados", null, "Estado informado é inválido pois não esta cadastrado como um estado deste País");
			}
		}
	}


}


