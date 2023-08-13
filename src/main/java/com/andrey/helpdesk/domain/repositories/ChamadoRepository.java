package com.andrey.helpdesk.domain.repositories;

import com.andrey.helpdesk.domain.Chamado;
import com.andrey.helpdesk.domain.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChamadoRepository extends JpaRepository<Chamado, Integer> {
}
