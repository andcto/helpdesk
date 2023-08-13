package com.andrey.helpdesk.services;

import com.andrey.helpdesk.domain.Chamado;
import com.andrey.helpdesk.domain.Cliente;
import com.andrey.helpdesk.domain.Tecnico;
import com.andrey.helpdesk.domain.TecnicoDTO;
import com.andrey.helpdesk.domain.enums.Perfil;
import com.andrey.helpdesk.domain.enums.Prioridade;
import com.andrey.helpdesk.domain.enums.Status;
import com.andrey.helpdesk.domain.repositories.ChamadoRepository;
import com.andrey.helpdesk.domain.repositories.ClienteRepository;
import com.andrey.helpdesk.domain.repositories.TecnicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class DBService {
    @Autowired
    private TecnicoRepository tecnicoRepository;
    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private ChamadoRepository chamadoRepository;
    public void instanciaDB(){
        Tecnico tec = new Tecnico(null, "Andrey Couto", "13282596090", "andrey@mail.com", "1234");
        tec.addPerfil(Perfil.ADMIN);
        TecnicoDTO tec1 = new TecnicoDTO(tec);

        Cliente cli1 = new Cliente(null, "Lucas Matheus", "99584725033", "lucas@mail.com", "1234");
        cli1.addPerfil(Perfil.CLIENTE);

        Chamado c1 = new Chamado(null, Prioridade.MEDIA, Status.ANDAMENTO, "Chamado 01", "Primeiro Chamado", cli1, tec);

        tecnicoRepository.saveAll(Arrays.asList(tec));
        clienteRepository.saveAll(Arrays.asList(cli1));
        chamadoRepository.saveAll(Arrays.asList(c1));
    }

}
