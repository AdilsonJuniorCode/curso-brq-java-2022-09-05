package com.brq.ms01.controllers;

import com.brq.ms01.dtos.UsuarioDTO;
import com.brq.ms01.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


// comentário

/*
 * comentário
 * */

@RestController
public class UsuarioController {



    // private UsuarioService usuService = new UsuarioService();
    // @Autowired é importante pois permite que o Spring "instancie" o objeto do tipo UsuarioService
    @Autowired
    private UsuarioService usuService;


    /*
     * o @GetMapping permite associoar o verbo GET com a rota /usuarios
     * */
    @GetMapping("usuarios")
    public ResponseEntity<List<UsuarioDTO>> getAllUsuarios(){

        // ISSO É VERDADEIRO?????
        /*
         * EM JAVA, NÃÃÃÃÃÃÃOOOO SE COMPARA STRING COM OPERADOR ==
         * */
//        if ("aaa" == "aaa"){
//
//        }
//        if ("aaa".equalsIgnoreCase("aaa")){
//
//        }
        usuService.mostrarMensagemService();
        //return usuarios;
//        ArrayList<UsuarioModel> usuarios = usuService.getAllUsuarios();
//          MANIPULAR AQUI
//        return usuarios;

        return ResponseEntity.ok().body(usuService.getAllUsuarios());
    }

    @PostMapping("usuarios")
    public ResponseEntity<UsuarioDTO> create(@Valid @RequestBody UsuarioDTO usuario){
//        UsuarioModel u = usuService.create(usuario);
//        return u;
        // return usuService.create(usuario);
        var t = usuService.create(usuario);

        return ResponseEntity.ok().body(t);

    } // create

    // /usuarios/1 -> o valor do id vai ser 1

    @PatchMapping("usuarios/{id}")
    public ResponseEntity<UsuarioDTO> update(@RequestBody UsuarioDTO usuarioBody,
                             @PathVariable int id ){
        //        UsuarioModel u = usuService.update(id, usuarioBody);
        //        return u;

        usuService.update(id, usuarioBody);

        return ResponseEntity.ok().body(usuService.update(id, usuarioBody));
    } // update()

    @DeleteMapping("usuarios/{id}")
    public ResponseEntity<String> delete(@PathVariable int id){

//        String response = usuService.delete(id);
//        return response;

        return ResponseEntity.ok().body(usuService.delete(id));
    } // delete

    // busca por apenas um usuário (pelo id)
    @GetMapping("usuarios/{id}")
    public ResponseEntity<UsuarioDTO> getOne(@PathVariable int id){

//        UsuarioModel u = usuService.getOne(id);
//        return u;

        return ResponseEntity.ok().body(usuService.getOne(id));

    } // getOne

    // usuarios/nome/Fabrizio
    @GetMapping("usuarios/nome/{nomeBusca}")
    public ResponseEntity<List<UsuarioDTO>> fetchUsuariosByNome(@PathVariable String nomeBusca){
        // TODO: Não esquecer do ResponseEntity
        // TODO: fazer a busca usando o operador like

        var list= usuService.fetchUsuariosByNome(nomeBusca);

        return ResponseEntity.ok().body(list);
    }

    // usuarios/nome/Fabrizio
    @GetMapping("usuarios/nome/{nomeBusca}/email/{emailBusca}")
    public ResponseEntity<List<UsuarioDTO>> fetchUsuariosByNomeAndEmail(
            @PathVariable String nomeBusca,
            @PathVariable String emailBusca){
        // TODO: Não esquecer do ResponseEntity
        // TODO: fazer a busca usando o operador like

        var list = usuService.fetchUsuariosByNomeAndEmail(nomeBusca, emailBusca);

        return ResponseEntity.ok().body(list);

    }

} // UsuarioController