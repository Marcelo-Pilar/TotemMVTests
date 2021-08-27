package com.marcelo.totemmv.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.marcelo.totemmv.domain.FilaSenha;
import com.marcelo.totemmv.services.FilaSenhaServices;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/filaSenha")

public class FilaSenhaController {
	
	@Autowired
	private FilaSenhaServices filaSenhaServices;
	
	@GetMapping
	public List<FilaSenha> listar() {
		return filaSenhaServices.listar();
	}

	@GetMapping("/{filaSenhaId}")
	public ResponseEntity<Optional<FilaSenha>> buscar(@PathVariable Long filaSenhaId) {
		Optional<FilaSenha> retorno = filaSenhaServices.buscarId(filaSenhaId);
		if (retorno == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);

		}
		return new ResponseEntity<>(retorno, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<String> adicionar(@Valid @RequestBody FilaSenha filaSenha) {
		try {
			return new ResponseEntity<>(filaSenhaServices.salvar(filaSenha), HttpStatus.CREATED);
		} catch (Exception e) {

			return new ResponseEntity<>("Erro ao registrar o Fila!", HttpStatus.NOT_IMPLEMENTED);
		}
	}

	@PutMapping("/{filaSenhaId}")
	public ResponseEntity<String> alterar(@Valid @RequestBody FilaSenha filaSenha,
			@PathVariable Long filaSenhaId) {
		try {
			return new ResponseEntity<>(filaSenhaServices.alterar(filaSenha, filaSenhaId),
					HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>("Erro ao alterar a Fila!", HttpStatus.NOT_MODIFIED);
		}
	}

	@DeleteMapping("/{filaSenhaId}")
	public ResponseEntity<String> excluir(@PathVariable Long filaSenhaId) {
		try {
			return new ResponseEntity<>(filaSenhaServices.excluir(filaSenhaId), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>("Erro ao deletar o Fila!", HttpStatus.NOT_MODIFIED);
		}
	}


}
