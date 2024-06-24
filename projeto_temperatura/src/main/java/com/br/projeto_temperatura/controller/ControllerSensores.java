package com.br.projeto_temperatura.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.br.projeto_temperatura.DAO.interfaceSensores;
import com.br.projeto_temperatura.model.ModelSensores;

@Controller
public class ControllerSensores {

    @Autowired
    private interfaceSensores dao;
    
    @GetMapping("/api/sensores")
    @ResponseBody
    public List<ModelSensores> listaSensores() {
        return (List<ModelSensores>) dao.findAll();
    }

    @RequestMapping(path = "/sensores")
    public String index(Model model) {
        return "cadastroSensores.html";
    }

    @PostMapping("/api/sensores")
    @ResponseBody
    public ResponseEntity<ModelSensores> criaSensor(@RequestBody ModelSensores sensor) {
        try {
            ModelSensores novoSensor = dao.save(sensor);
            return ResponseEntity.ok(novoSensor);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }


    @PutMapping("/api/sensores")
    @ResponseBody
    public ModelSensores editaSensor(@RequestBody ModelSensores sensor) {
        ModelSensores sensorEditado = dao.save(sensor);
        return sensorEditado;
    }

    @DeleteMapping("/api/sensores/{id}")
    @ResponseBody
    public Optional<ModelSensores> apagaSensor(@PathVariable Integer id) {
        Optional<ModelSensores> sensor = dao.findById(id);
        dao.deleteById(id);
        return sensor;
    }
}
