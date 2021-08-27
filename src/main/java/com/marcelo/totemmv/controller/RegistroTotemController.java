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

import com.marcelo.totemmv.domain.RegistroTotem;
import com.marcelo.totemmv.services.RegistroTotemService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/registroTotem")

public class RegistroTotemController {

	@Autowired
	private RegistroTotemService registroTotemService;

	@GetMapping
	public List<RegistroTotem> listar() {
		return registroTotemService.listar();
	}

	@GetMapping("/{registroTotemId}")
	public ResponseEntity<Optional<RegistroTotem>> buscar(@PathVariable Long registroTotemId) {
		Optional<RegistroTotem> retorno = registroTotemService.buscarId(registroTotemId);
		if (retorno == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);

		}
		return new ResponseEntity<>(retorno, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<String> adicionar(@Valid @RequestBody RegistroTotem registroTotem) {
		try {
			return new ResponseEntity<>(registroTotemService.salvar(registroTotem), HttpStatus.CREATED);
		} catch (Exception e) {

			return new ResponseEntity<>("Erro ao registrar o TOTEM!", HttpStatus.NOT_IMPLEMENTED);
		}
	}

	@PutMapping("/{registroTotemId}")
	public ResponseEntity<String> alterar(@Valid @RequestBody RegistroTotem registroTotem,
			@PathVariable Long registroTotemId) {
		try {
			return new ResponseEntity<>(registroTotemService.alterar(registroTotem, registroTotemId),
					HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>("Erro ao alterar o TOTEM!", HttpStatus.NOT_MODIFIED);
		}
	}

	@DeleteMapping("/{registroTotemId}")
	public ResponseEntity<String> excluir(@PathVariable Long registroTotemId) {
		try {
			return new ResponseEntity<>(registroTotemService.excluir(registroTotemId), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>("Erro ao deletar o TOTEM!", HttpStatus.NOT_MODIFIED);
		}
	}

}
