package com.example.viaggiAziendali.service;

import com.example.viaggiAziendali.dto.DipendenteDTO;
import com.example.viaggiAziendali.model.Dipendente;
import com.example.viaggiAziendali.model.Viaggio;
import com.example.viaggiAziendali.repository.DipendenteDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class DipendenteService {

    @Autowired
    private DipendenteDAO dipendenteDAO;

    // lato user arriva oggetto DTO e dovrà essere travasato in entity per poter essere caricato sul database --
    public Long saveDipendente(DipendenteDTO dipendenteDTO){
        return dipendenteDAO.save(dto_entity(dipendenteDTO)).getId();
    }

    // restituzione di tutti i dipendenti dal database
    public List<Dipendente> getAllDipendenti(){
        return dipendenteDAO.findAll();
    }

    // ricerca di un dipendente tramite ID
    public Optional<Dipendente> getDipendenteById(long dipendenteId){
        return dipendenteDAO.findById(dipendenteId);
    }

    // DTO -> ENTITY
    public Dipendente dto_entity(DipendenteDTO dipendenteDTO){
        Dipendente dipendente = new Dipendente();

        dipendente.setUsername(dipendenteDTO.getUsername());
        dipendente.setNome(dipendenteDTO.getNome());
        dipendente.setCognome(dipendenteDTO.getCognome());
        dipendente.setEmail(dipendenteDTO.getEmail());

        return dipendente;
    }

    // ENTITY -> DTO
    public DipendenteDTO entity_dto(Dipendente dipendente){
        DipendenteDTO dipendenteDTO = new DipendenteDTO();

        dipendenteDTO.setUsername(dipendente.getUsername());
        dipendenteDTO.setNome(dipendente.getNome());
        dipendenteDTO.setCognome(dipendente.getCognome());
        dipendenteDTO.setEmail(dipendente.getEmail());

        return dipendenteDTO;
    }
}
