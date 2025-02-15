package com.example.viaggiAziendali.service;

import com.example.viaggiAziendali.dto.ViaggioDTO;
import com.example.viaggiAziendali.model.Viaggio;
import com.example.viaggiAziendali.repository.ViaggioDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class ViaggioService {

    @Autowired
    ViaggioDAO viaggioDAO;

    // salvataggio di viaggio nel database e restituzione dell'ID
    public Long saveViaggio(ViaggioDTO viaggioDTO){
        return viaggioDAO.save(dto_entity(viaggioDTO)).getId();
    }

    // restituzione di tutti i viaggi
    public List<Viaggio> getAllViaggi(){
        return viaggioDAO.findAll();
    }

    // ricerca di un viaggio tramite ID
    public Optional<Viaggio> getViaggioById(long viaggioId){
        return viaggioDAO.findById(viaggioId);
    }

    // DTO -> ENTITY
    public Viaggio dto_entity(ViaggioDTO viaggioDTO){
        Viaggio viaggio = new Viaggio();

        viaggio.setDestinazione(viaggioDTO.getDestinazione());
        return viaggio;
    }

    // ENTITY -> DTO
    public ViaggioDTO entity_dto(Viaggio viaggio){
        ViaggioDTO viaggioDTO = new ViaggioDTO();

        viaggioDTO.setDestinazione(viaggio.getDestinazione());
        return viaggioDTO;
    }
}
