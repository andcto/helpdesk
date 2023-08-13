package com.andrey.helpdesk.domain.repositories;

import com.andrey.helpdesk.domain.Cliente;
import com.andrey.helpdesk.domain.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
}
