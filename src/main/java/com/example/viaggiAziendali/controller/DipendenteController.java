package com.example.viaggiAziendali.controller;

import com.example.viaggiAziendali.dto.DipendenteDTO;
import com.example.viaggiAziendali.exceptions.DipendenteNotFound;
import com.example.viaggiAziendali.model.Dipendente;
import com.example.viaggiAziendali.model.Prenotazione;
import com.example.viaggiAziendali.model.Viaggio;
import com.example.viaggiAziendali.service.DipendenteService;
import com.example.viaggiAziendali.service.PrenotazioneService;
import com.example.viaggiAziendali.service.ViaggioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/dipendenti")

public class DipendenteController {

    @Autowired
    DipendenteService dipendenteService;

    @Autowired
    ViaggioService viaggioService;

    @Autowired
    PrenotazioneService prenotazioneService;

    // POST per salvare sul db un nuovo dipendente
    @PostMapping()
    public ResponseEntity<String> postDipendente(@RequestBody @Validated DipendenteDTO dipendenteDTO, BindingResult validation){

        // verificare se ci sono problemi nella validazione
        if (validation.hasErrors()) {

            String messaggioDiErrore = "Errore di validazione \n";

            // inviare i messaggi di errore al client
            for (ObjectError errore : validation.getAllErrors()){
                messaggioDiErrore += errore.getDefaultMessage() + "\n";
            }

            return new ResponseEntity<>(messaggioDiErrore, HttpStatus.BAD_REQUEST);
        }

        Long dipendenteId = dipendenteService.saveDipendente(dipendenteDTO);
        return new ResponseEntity<>("Il dipendente con ID " + dipendenteId + " è stato salvato correttamente!", HttpStatus.CREATED);

    }

    // GET per riprendere tutti i dipendenti dal db
    @GetMapping()
    public List<Dipendente> getAllDipendenti(){
        return dipendenteService.getAllDipendenti();
    }

    // GET per ricercare un dipendente tramite ID
    @GetMapping("/{dipendenteId}")
    public String getDipendenteById(@PathVariable long dipendenteId){

        try {
            Optional<Dipendente> dipendente = dipendenteService.getDipendenteById(dipendenteId);
            if (dipendente.isPresent()) {
                return "Il dipendente con ID " + dipendenteId + " ha nome " + dipendente.get().getNome() + " e cognome " + dipendente.get().getCognome();
            } else {
                throw new DipendenteNotFound("Il dipendente con ID " + dipendenteId + " non è presente nel database");
            }

        } catch (DipendenteNotFound e) {
            System.out.println("Errore: " + e.getMessage());
            return "Errore: " + e.getMessage();
        }
    }

    // POST per aggiungere una nuova prenotazione
    @PostMapping("/prenotazioni")
    public ResponseEntity<String> postPrenotazione(@RequestParam long dipendenteId, long viaggioId){

        try {
            Optional<Dipendente> dipendente = dipendenteService.getDipendenteById(dipendenteId);
            Optional<Viaggio> viaggio = viaggioService.getViaggioById(viaggioId);
            if (dipendente.isPresent() && viaggio.isPresent()){
                Prenotazione prenotazione = new Prenotazione(LocalDate.now(), "bagaglio a mano");

                // aggiungere la prenotazine alla lista prenotazioni del dipendente
                dipendente.get().getPrenotazioneList().add(prenotazione);

                // aggiungere la prenotazine alla lista prenotazioni del viaggio
                viaggio.get().getPrenotazioneList().add(prenotazione);

                prenotazioneService.savePrenotazione(prenotazione);

                return new ResponseEntity<>("La prenotazione è stata generata correttamente!", HttpStatus.CREATED);
            } else {
                throw new RuntimeException("Non è stato possibile generare la prenotazione...");
            }
        } catch (RuntimeException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

}
