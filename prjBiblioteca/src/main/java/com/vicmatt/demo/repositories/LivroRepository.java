package com.vicmatt.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.vicmatt.demo.entities.Livro;

public interface LivroRepository extends JpaRepository<Livro, Long>{

	@Query(value = "SELECT * FROM tb_biblioteca l WHERE LOWER(l.nome) LIKE %:nome%", nativeQuery = true)
	List<Livro> buscarPorTitulo(@Param("nome") String nome);
	
}