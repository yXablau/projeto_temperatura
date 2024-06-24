package com.br.projeto_temperatura.controller;

import com.br.projeto_temperatura.DAO.InterfaceTemperatura;
import com.br.projeto_temperatura.model.ModelTemperatura;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ControllerTemperatura {

    @Autowired
    private InterfaceTemperatura interfaceTemperatura;

    @PostMapping("/temperatura")
    public void receiveTemperature(@RequestBody ModelTemperatura temperatura) {
        interfaceTemperatura.save(temperatura);
    }
}
