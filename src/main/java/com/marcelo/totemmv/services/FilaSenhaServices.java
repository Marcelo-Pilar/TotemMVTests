package com.marcelo.totemmv.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.marcelo.totemmv.domain.FilaSenha;
import com.marcelo.totemmv.repositories.FilaSenhaRepository;

@Service
public class FilaSenhaServices {
	
	@Autowired
	FilaSenhaRepository filaSenhaRepository;
	
	public String salvar(FilaSenha filaSenha) {

		filaSenhaRepository.save(filaSenha);
		return "Fila Registrado com sucesso!";
	}

	public List<FilaSenha> listar() {
		
		return filaSenhaRepository.findAll();

	}

	public Optional<FilaSenha> buscarId(Long Id) {
		Optional<FilaSenha> filaSenha = filaSenhaRepository.findById(Id);
		if (filaSenha.isPresent()) {
			return filaSenha;
		} else {
			return null;
		}
	}

	public String alterar(FilaSenha filaSenha, Long id) {
		Optional<FilaSenha> filaSenha1 = filaSenhaRepository.findById(id);
		if (filaSenha1.isPresent()) {
			filaSenha.setId(id);
			filaSenhaRepository.save(filaSenha);
			return "Fila alterada com sucesso!";
		}

		return "Fila não encontrada!";
	}

	@Transactional
	public String excluir(Long id) {
		Optional<FilaSenha> resultTotem = filaSenhaRepository.findById(id);
		if (resultTotem.isPresent()) {
			filaSenhaRepository.deleteById(id);
			return "Fila excluída com sucesso!";
		}
		return "Fila não encontrada!";
	}

}
