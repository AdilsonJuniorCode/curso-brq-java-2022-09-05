package com.brq.ms03.controllers;

import com.brq.ms03.dtos.ProfessorDTO;
import com.brq.ms03.services.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;


import org.springframework.http.MediaType;


import javax.validation.Valid;
import java.util.List;

@RestController
public class ProfessorController {

    @Autowired
    private ProfessorService profService;

    @GetMapping("professor")
    public List<ProfessorDTO> getAllProfessor(){
        profService.mostrarMensagemService();
        return profService.getAllProfessor();
    } // todos


//    @PostMapping(path = "professor", consumes = { MediaType.APPLICATION_FORM_URLENCODED_VALUE })
    @PostMapping("professor")
    public ProfessorDTO create(@Valid @RequestBody ProfessorDTO professor){
        var t = profService.create(professor);
        return t;
    } // create

//    @PostMapping("/professor-form-data")
//    public void ProfessorDTO create(
//            @RequestParam("nome") String nome,
//            @RequestParam("cpf") String cpf,
//            @RequestParam("salario") int salario,
//            @RequestParam("telefone") String telefone)
//    {

//       return profService.create(professor);



//        public void handleFileUpload(
//                @RequestParam("nome") String nome,
//                @RequestParam("cpf") String cpf,
//        @RequestParam("salario") int salario,
//        @RequestParam("telefone") String telefone){


 //   }

    @PatchMapping("professor/{id}")
    public ProfessorDTO update(@RequestBody ProfessorDTO professorBody,
                               @PathVariable int id ){
        return profService.update(id, professorBody);
    } // update()

    @DeleteMapping("professor/{id}")
    public String delete(@PathVariable int id){

        return profService.delete(id);
    } // delete

    @GetMapping("professor/{id}")
    public ProfessorDTO getOne(@PathVariable int id){

        return profService.getOne(id);
    } // getOne

}