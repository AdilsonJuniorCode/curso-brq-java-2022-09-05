package com.brq.ms01.models;

import com.brq.ms01.dtos.UsuarioDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;

import javax.persistence.*;

//@Data em tempo de execucao gera getters, setter and metodo toString
//@AllArgsConstructor gera construtores com parametros
//@AllArgsConstructor gera construtores sem parametros
// @Entity diz que a classe vai se mapeada com alguma tabela no banco de dados
//@Table especifica o nome da tabela que a classe irá mapear

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table (name="usuarios")

public class UsuarioModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name="id")
    private int id;

    @Column (name="nome_user")
    private String nome;

    @Column (name="email_user")
    private String email;

    @Column(name = "telefone_user")
    private String telefone;


    public UsuarioDTO toDTO(){
        ModelMapper mapper = new ModelMapper();

        return mapper.map(this, UsuarioDTO.class);
    }


}