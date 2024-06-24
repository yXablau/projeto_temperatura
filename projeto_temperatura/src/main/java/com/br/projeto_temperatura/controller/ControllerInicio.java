package com.br.projeto_temperatura.controller;

import com.br.projeto_temperatura.DAO.InterfaceTemperatura;
import com.br.projeto_temperatura.model.ModelTemperatura;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Optional;

@Controller
public class ControllerInicio {

    @Autowired
    private InterfaceTemperatura interfaceTemperatura;

    @RequestMapping(path = "/home", method = RequestMethod.GET)
    public String index(Model model) {
        Optional<ModelTemperatura> latestTemperature = interfaceTemperatura.findTopByOrderByTimestampDesc();
        if (latestTemperature.isPresent()) {
            model.addAttribute("latestTemperature", latestTemperature.get().getValor());
        } else {
            model.addAttribute("latestTemperature", "N/A");
        }
        return "inicio.html";
    }
}
