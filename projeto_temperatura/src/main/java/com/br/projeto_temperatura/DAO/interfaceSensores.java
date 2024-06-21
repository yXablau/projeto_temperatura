package com.br.projeto_temperatura.DAO;

import org.springframework.data.repository.CrudRepository;

import com.br.projeto_temperatura.model.ModelSensores;

public interface interfaceSensores extends CrudRepository<ModelSensores, Integer> {

}
