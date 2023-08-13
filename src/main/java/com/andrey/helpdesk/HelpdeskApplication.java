package com.andrey.helpdesk;

import com.andrey.helpdesk.domain.Chamado;
import com.andrey.helpdesk.domain.Cliente;
import com.andrey.helpdesk.domain.Tecnico;
import com.andrey.helpdesk.domain.enums.Perfil;
import com.andrey.helpdesk.domain.enums.Prioridade;
import com.andrey.helpdesk.domain.enums.Status;
import com.andrey.helpdesk.domain.repositories.ChamadoRepository;
import com.andrey.helpdesk.domain.repositories.ClienteRepository;
import com.andrey.helpdesk.domain.repositories.TecnicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class HelpdeskApplication implements CommandLineRunner {
    @Autowired
    private TecnicoRepository tecnicoRepository;
    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private ChamadoRepository chamadoRepository;

    public static void main(String[] args) {
        SpringApplication.run(HelpdeskApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Tecnico tec1 = new Tecnico(null, "Andrey Couto", "13282596090", "andrey@mail.com", "1234");
        tec1.addPerfil(Perfil.ADMIN);

        Cliente cli1 = new Cliente(null, "Lucas Matheus", "99584725033", "lucas@mail.com", "1234");
        cli1.addPerfil(Perfil.CLIENTE);

        Chamado c1 = new Chamado(null, Prioridade.MEDIA, Status.ANDAMENTO, "Chamado 01", "Primeiro Chamado", cli1, tec1);

        tecnicoRepository.saveAll(Arrays.asList(tec1));
        clienteRepository.saveAll(Arrays.asList(cli1));
        chamadoRepository.saveAll(Arrays.asList(c1));
    }
}
