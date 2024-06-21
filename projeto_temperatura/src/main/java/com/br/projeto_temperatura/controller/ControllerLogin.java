package com.br.projeto_temperatura.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import com.br.projeto_temperatura.DAO.InterfaceUsuario;
import com.br.projeto_temperatura.model.ModelUsuario;
@Controller
public class ControllerLogin {
    @Autowired
    private InterfaceUsuario dao;

    @RequestMapping(path="/login", method=RequestMethod.GET)
    public String index(Model modelo) {
    	
    	return "login.html"; 
    }
    

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody ModelUsuario usuario) {
        Optional<ModelUsuario> user = dao.findByUsuarioAndSenha(usuario.getUsuario(), usuario.getSenha());
        if (user.isPresent()) {
            return ResponseEntity.ok("Login bem-sucedido");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Usuário ou senha incorretos");
        }

    }
}
