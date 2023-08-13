package com.andrey.helpdesk.services;

import com.andrey.helpdesk.domain.Tecnico;
import com.andrey.helpdesk.domain.TecnicoDTO;
import com.andrey.helpdesk.domain.repositories.TecnicoRepository;
import com.andrey.helpdesk.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TecnicoService {
    @Autowired
    private TecnicoRepository tecnicoRepository;

    public Tecnico findById(Integer id){
        Optional<Tecnico> obj = tecnicoRepository.findById(id);

        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id));
    }

    public List<Tecnico> findAll() {
        return tecnicoRepository.findAll();
    }

    public Tecnico create(TecnicoDTO tecnicoDTO) {
        tecnicoDTO.setId(null); //Para assegurar que será uma criação de Tecnico e não um update
        Tecnico newTecnico = new Tecnico(tecnicoDTO);

        return tecnicoRepository.save(newTecnico);
    }
}
