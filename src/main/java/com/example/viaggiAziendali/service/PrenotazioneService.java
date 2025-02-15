package com.example.viaggiAziendali.service;

import com.example.viaggiAziendali.model.Prenotazione;
import com.example.viaggiAziendali.repository.PrenotazioneDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class PrenotazioneService {

    @Autowired
    PrenotazioneDAO prenotazioneDAO;

    public void savePrenotazione(Prenotazione prenotazione){
        prenotazioneDAO.save(prenotazione);
    }
}
