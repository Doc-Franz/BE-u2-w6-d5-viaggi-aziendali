package com.example.viaggiAziendali.controller;

import com.example.viaggiAziendali.dto.DipendenteDTO;
import com.example.viaggiAziendali.model.Dipendente;
import com.example.viaggiAziendali.service.DipendenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dipendenti")

public class DipendenteController {

    @Autowired
    DipendenteService dipendenteService;

    // post per salvare sul db un nuovo dipendente
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

}
