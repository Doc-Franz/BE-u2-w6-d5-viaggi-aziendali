package com.example.viaggiAziendali.service;

import com.example.viaggiAziendali.model.Prenotazione;
import com.example.viaggiAziendali.repository.PrenotazioneDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;
import java.util.Scanner;

@Service

public class PrenotazioneService {

    Scanner sc = new Scanner(System.in);

    @Autowired
    PrenotazioneDAO prenotazioneDAO;

    public void savePrenotazione(Prenotazione prenotazione){
        prenotazioneDAO.save(prenotazione);
    }

    // ricerca di un viaggio tramite ID
    public Optional<Prenotazione> getPrenotazioneById(long prenotazioneId){
        return prenotazioneDAO.findById(prenotazioneId);
    }


    // metodo che controlla se nella data selezionata le prenotazioni per quel viaggio sono nello stato PROGRAMATO o COMPLETATO
    public LocalDate checkDataViaggio(){
        System.out.println("Che data (yyyy-mm-gg) intendi controllare per verificare lo stato del viaggio?");
        return LocalDate.parse(sc.nextLine());
    }
}
