package com.andrey.helpdesk.domain.repositories;

import com.andrey.helpdesk.domain.Cliente;
import com.andrey.helpdesk.domain.Tecnico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TecnicoRepository extends JpaRepository<Tecnico, Integer> {
}
