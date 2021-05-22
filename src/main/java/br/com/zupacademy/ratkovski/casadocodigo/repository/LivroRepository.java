package br.com.zupacademy.ratkovski.casadocodigo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.zupacademy.ratkovski.casadocodigo.modelo.Livro;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Long> {

}
