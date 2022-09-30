package com.brq.ms01.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

// Comentário

@RestController
public class UsuarioController {

    // Getmapping permite assiciar o verbo GET com a rota /usuarios

    @GetMapping("usuarios")
    public String getAllUsuarios(){
        return "GET Usuários";
    }

}
