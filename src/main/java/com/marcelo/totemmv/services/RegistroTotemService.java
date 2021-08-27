package com.marcelo.totemmv.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.marcelo.totemmv.domain.RegistroTotem;
import com.marcelo.totemmv.repositories.RegistroTotemRepository;

@Service
public class RegistroTotemService {

	@Autowired
	RegistroTotemRepository registroTotemRepository;
	

	public String salvar(RegistroTotem registroTotem) {

		registroTotemRepository.save(registroTotem);
		return "Totem Registrado com sucesso!";
	}

	public List<RegistroTotem> listar() {
		
		return registroTotemRepository.findAll();

	}

	public Optional<RegistroTotem> buscarId(Long Id) {
		Optional<RegistroTotem> registroTotem = registroTotemRepository.findById(Id);
		if (registroTotem.isPresent()) {
			return registroTotem;
		} else {
			return null;
		}
	}

	public String alterar(RegistroTotem registroTotem, Long id) {
		Optional<RegistroTotem> resultTotem = registroTotemRepository.findById(id);
		if (resultTotem.isPresent()) {
			registroTotem.setId(id);
			registroTotemRepository.save(registroTotem);
			return "Totem alterado com sucesso!";
		}

		return "Totem não encontrado!";
	}

	@Transactional
	public String excluir(Long id) {
		Optional<RegistroTotem> resultTotem = registroTotemRepository.findById(id);
		if (resultTotem.isPresent()) {
			registroTotemRepository.deleteById(id);
			return "Totem excluído com sucesso!";
		}
		return "Totem não encontrado!";
	}

}
