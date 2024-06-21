package com.br.projeto_temperatura.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
@Controller	
public class ControllerInicio {
    @RequestMapping(path="/home", method=RequestMethod.GET)
    public String index(Model model) {

        return "inicio.html";
    }

}
	