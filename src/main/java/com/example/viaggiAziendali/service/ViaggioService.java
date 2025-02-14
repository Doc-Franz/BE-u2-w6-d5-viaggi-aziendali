package com.example.viaggiAziendali.service;

import com.example.viaggiAziendali.dto.ViaggioDTO;
import com.example.viaggiAziendali.model.Viaggio;
import com.example.viaggiAziendali.repository.ViaggioDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class ViaggioService {

    @Autowired
    ViaggioDAO viaggioDAO;

    public Long saveViaggio(ViaggioDTO viaggioDTO){
        return viaggioDAO.save(dto_entity(viaggioDTO)).getId();
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
