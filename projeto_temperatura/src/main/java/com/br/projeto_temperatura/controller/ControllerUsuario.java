package com.br.projeto_temperatura.controller;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
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
import com.br.projeto_temperatura.DAO.InterfaceUsuario;
import com.br.projeto_temperatura.model.ModelUsuario;

@Controller
public class ControllerUsuario {
    @Autowired
    private InterfaceUsuario dao;

    @GetMapping("/cadastroUsuarios")
    public String index(Model model) {
        return "cadUsuarios.html"; // Certifique-se de que este arquivo está na pasta correta, normalmente em "src/main/resources/templates/"
    }

    @PostMapping("/api/cadastroUsuarios")
    @ResponseBody
    public ModelUsuario userCreate(@RequestBody ModelUsuario usuario) {
        ModelUsuario newUser = dao.save(usuario);
        return newUser;
    }

    @PutMapping("/api/cadastroUsuarios")
    @ResponseBody
    public ModelUsuario editCreate(@RequestBody ModelUsuario usuario) {
        ModelUsuario updatedUser = dao.save(usuario);
        return updatedUser;
    }	

    @DeleteMapping("/api/cadastroUsuarios/{id}")
    @ResponseBody
    public Optional<ModelUsuario> deleteUser(@PathVariable Integer id) {
        Optional<ModelUsuario> user = dao.findById(id);
        dao.deleteById(id);
        return user;
    }
}
