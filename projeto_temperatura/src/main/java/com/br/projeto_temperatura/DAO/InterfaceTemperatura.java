package com.br.projeto_temperatura.DAO;

import com.br.projeto_temperatura.model.ModelTemperatura;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.Optional;

public interface InterfaceTemperatura extends CrudRepository<ModelTemperatura, Integer> {

    @Query(value = "SELECT * FROM temperaturas ORDER BY timestamp DESC LIMIT 1", nativeQuery = true)
    Optional<ModelTemperatura> findTopByOrderByTimestampDesc();
}
