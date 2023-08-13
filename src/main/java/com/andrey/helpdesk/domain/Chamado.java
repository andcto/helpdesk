package com.andrey.helpdesk.domain;

import com.andrey.helpdesk.domain.enums.Prioridade;
import com.andrey.helpdesk.domain.enums.Status;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
@Getter
@Setter
@EqualsAndHashCode
@Entity
public class Chamado implements Serializable{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataAbertura = LocalDate.now();

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataFechamento;
    private Prioridade prioridade;
    private Status status;
    private String titulo;
    private String observacoes;

    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "id_tecnico")
    private Tecnico tecnico;

    public Chamado(){
        super();
    }

    public Chamado(Integer id, Prioridade prioridade, Status status, String titulo, String observacoes, Cliente cliente, Tecnico tecnico) {
        this.id = id;
        this.prioridade = prioridade;
        this.status = status;
        this.titulo = titulo;
        this.observacoes = observacoes;
        this.cliente = cliente;
        this.tecnico = tecnico;
    }
}
