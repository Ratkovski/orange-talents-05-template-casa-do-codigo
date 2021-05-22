package br.com.zupacademy.ratkovski.casadocodigo.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.zupacademy.ratkovski.casadocodigo.modelo.Autor;

@Repository
public interface AutorRepository extends CrudRepository<Autor, Long>{

	Optional<Autor> findByEmail(String email);


	Optional<Autor> findById(Autor autor);



}
