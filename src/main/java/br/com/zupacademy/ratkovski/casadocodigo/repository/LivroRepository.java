package br.com.zupacademy.ratkovski.casadocodigo.repository;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import br.com.zupacademy.ratkovski.casadocodigo.modelo.Livro;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Long> {

	
	

}
