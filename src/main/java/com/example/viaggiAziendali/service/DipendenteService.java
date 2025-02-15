package com.example.viaggiAziendali.service;

import com.example.viaggiAziendali.dto.DipendenteDTO;
import com.example.viaggiAziendali.model.Dipendente;
import com.example.viaggiAziendali.model.Viaggio;
import com.example.viaggiAziendali.repository.DipendenteDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

@Service

public class DipendenteService {

    Scanner sc = new Scanner(System.in);

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
        dipendente.setImmagineDipendente(dipendenteDTO.getImmagineDipendente());

        return dipendente;
    }

    // ENTITY -> DTO
    public DipendenteDTO entity_dto(Dipendente dipendente){
        DipendenteDTO dipendenteDTO = new DipendenteDTO();

        dipendenteDTO.setUsername(dipendente.getUsername());
        dipendenteDTO.setNome(dipendente.getNome());
        dipendenteDTO.setCognome(dipendente.getCognome());
        dipendenteDTO.setEmail(dipendente.getEmail());
        dipendenteDTO.setImmagineDipendente(dipendente.getImmagineDipendente());

        return dipendenteDTO;
    }

    // metodo che permette di inserire da console la data della prenotazione
    public LocalDate setDataPrenotazione(){
        System.out.println("In che data (yyyy-mm-gg) intendi effettuare la prenotazione?");
        return LocalDate.parse(sc.nextLine());
    }

    // metodo che permette di inserire da console le note della prenotazione
    public String setNote(){
        System.out.println("Intendi aggiugere delle note per il viaggio?");
        return sc.nextLine();
    }
}
