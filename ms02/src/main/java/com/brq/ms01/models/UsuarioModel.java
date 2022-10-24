package com.brq.ms01.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//@Data em tempo de execucao gera getters, setter and metodo toString
//@AllArgsConstructor gera construtores com parametros
//@AllArgsConstructor gera construtores sem parametros

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioModel {

    private int id;
    private String nome;
    private String email;


}