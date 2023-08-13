package com.andrey.helpdesk.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Cliente extends Pessoa{
    private List<Chamado> chamados = new ArrayList<Chamado>();
    public Cliente() {
        super();
    }
    public Cliente(Integer id, String nome, String cpf, String email, String senha) {
        super(id, nome, cpf, email, senha);
    }
}
