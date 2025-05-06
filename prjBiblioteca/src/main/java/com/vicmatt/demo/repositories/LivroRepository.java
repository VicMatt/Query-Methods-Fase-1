package com.vicmatt.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vicmatt.demo.entities.Livro;

public interface LivroRepository extends JpaRepository<Livro, Long>{

}
