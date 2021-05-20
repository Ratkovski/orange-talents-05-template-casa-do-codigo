package br.com.zupacademy.ratkovski.casadocodigo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.zupacademy.ratkovski.casadocodigo.modelo.Categoria;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long>{


	Optional<Categoria> findByNomeIgnoreCase(String nome);
	

}
