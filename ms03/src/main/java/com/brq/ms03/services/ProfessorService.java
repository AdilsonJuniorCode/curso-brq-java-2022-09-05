package com.brq.ms03.services;

import com.brq.ms03.dtos.ProfessorDTO;
import com.brq.ms03.models.ProfessorModel;
import com.brq.ms03.repositories.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class ProfessorService {

    private ArrayList<ProfessorModel> professor = new ArrayList<>();
    private int counter = 1;

    @Autowired
    private ProfessorRepository profRepository;

    public void mostrarMensagemService(){
        System.out.println("Mensagem do serviço");
    }

    public List<ProfessorDTO> getAllProfessor(){

        // a repository vai executar : SELECT * FROM professor;
        List<ProfessorModel> list = profRepository.findAll();

        // como converter uma lista de model para lista dto

        List<ProfessorDTO> listDTO = new ArrayList<>();

        //Tipo da variavel
        for (ProfessorModel balde: list) {
            listDTO.add(balde.toDTO());
        }


        return listDTO;
        //return professor;
    }

    public ProfessorDTO create(ProfessorDTO professor){

        // INSERT INTO professor (name_user, email_user ) VALUEs()....
        ProfessorModel professorSalvo = profRepository.save( professor.toModel() );
        // return  usuRepository.save( usuario );
        // return "POST Usuários";
        //return usuario;
        return professorSalvo.toDTO();
    }

    public ProfessorDTO update(int id, ProfessorDTO professorBody)  {

        ProfessorModel professor = profRepository.findById(id)
                .orElseThrow( () -> new RuntimeException("Professor não localizado") );

        professor.setNome( professorBody.getNome() );
        professor.setCpf( professorBody.getCpf() );
        professor.setSalario( professorBody.getSalario() );
        professor.setTelefone( professorBody.getTelefone() );

        return profRepository.save(professor).toDTO();


    }

    public String delete(int id){
         profRepository.deleteById(id);
        return "Professor delatado com sucesso!";
    }

    public ProfessorDTO getOne(int id){

        ProfessorModel professor = profRepository.findById(id)
                .orElseThrow( () -> new RuntimeException("Professor não localizado"));

        return professor.toDTO();
    }
}