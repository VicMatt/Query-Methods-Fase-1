package com.vicmatt.demo.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.vicmatt.demo.entities.Livro;

import com.vicmatt.demo.services.LivroService;



@RestController
@RequestMapping("/livros")
public class LivroController {

	private final LivroService livroService;

	public LivroController(LivroService livroService) {
		this.livroService = livroService;
	}

	@GetMapping("/{id}")
	public ResponseEntity<Livro> findLivroByid(@PathVariable Long id) {
		Livro livro = livroService.findLivroByid(id);

		if (livro != null) {
			return ResponseEntity.ok(livro);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@GetMapping("/listar")
	public ResponseEntity<List<Livro>> findAllLivros() {
		List<Livro> livro = livroService.findAllLivro();
		return ResponseEntity.ok(livro);
	}
	@PostMapping("/salvar")
	public ResponseEntity<Livro> insertLivro(@RequestBody Livro livro) {
		Livro novolivro = livroService.saveLivro(livro);
		return ResponseEntity.status(HttpStatus.CREATED).body(novolivro);
	}
	
}
