package com.brq.ms01.models;

import com.brq.ms01.dtos.UsuarioDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;

import javax.persistence.*;
import java.util.List;

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
    @Column (name="id_user")
    private int id;

    @Column (name="nome_user")
    private String nome;

    @Column (name="email_user")
    private String email;

    @Column(name = "telefone_user")
    private String telefone;

    // no mappedby guardamos a variavel JAVA que mapeia esta entidade (UsuarioModel)
    @OneToMany(mappedBy = "usuario")
    private List<FinanciamentoModel> financiamentos;

    @OneToOne(mappedBy = "usuario")
    private EnderecoModel endereco;

    @ManyToMany
    @JoinTable(
            name = "usuario_consorcio",
            joinColumns = @JoinColumn(name = "usuario_id"),
            inverseJoinColumns = @JoinColumn(name = "consorcio_id")
    )
    private List<ConsorcioModel> consorcios;

    public UsuarioDTO toDTO(){
        ModelMapper mapper = new ModelMapper();

        return mapper.map(this, UsuarioDTO.class);
    }


}