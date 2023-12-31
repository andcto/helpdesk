package com.andrey.helpdesk.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Prioridade {
    BAIXA(0, "BAIXA"), MEDIA(1, "MÉDIA"), ALTA(2, "ALTA");

    private final Integer codigo;
    private final String descricao;

    public static Prioridade toEnum(Integer codigo){
        if(codigo == null){
            return null;
        }

        for(Prioridade x : Prioridade.values()){
            if(codigo.equals(x.getCodigo())){
                return x;
            }
        }

        throw new IllegalArgumentException("Prioridade Inválida");
    }

}
