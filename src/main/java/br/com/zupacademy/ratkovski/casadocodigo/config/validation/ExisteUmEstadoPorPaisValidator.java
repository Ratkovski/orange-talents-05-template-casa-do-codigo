package br.com.zupacademy.ratkovski.casadocodigo.config.validation;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.util.Assert;

import br.com.zupacademy.ratkovski.casadocodigo.dto.EstadosDto;

public class ExisteUmEstadoPorPaisValidator implements ConstraintValidator<ExisteUmEstadoPorPais, EstadosDto>{

	/**private String domainAttribute;
	private Class<?> klass;**/
	
	@PersistenceContext
	private EntityManager em;

	/**@Override
	public void initialize(ExisteUmEstadoPorPais params) {
		domainAttribute = params.fieldName();
		klass = params.domainClass();
	}**/
	
	
	@Override
	public boolean isValid(EstadosDto value, ConstraintValidatorContext context) {
	

Query query = em.createQuery("select 1 from Estados e where e.nome = :nomeEstados AND e.pais.id = :paisId");
query.setParameter("nomeEstados", value.getNome());
query.setParameter("paisId", value.getIdPais());

List result = query.getResultList();


Assert.state(result.size() <= 1, "Existe mais de um estado " + value.getNome() + 
" no país de Id: " + value.getIdPais());


return result.isEmpty();
}
}
