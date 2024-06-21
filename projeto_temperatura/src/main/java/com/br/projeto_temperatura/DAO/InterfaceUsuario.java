package com.br.projeto_temperatura.DAO;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.br.projeto_temperatura.model.ModelUsuario;

public interface InterfaceUsuario extends CrudRepository<ModelUsuario, Integer>{
	Optional<ModelUsuario> findByUsuarioAndSenha(String usuario, String senha);
	
}
