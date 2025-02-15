package com.example.viaggiAziendali.controller;

import com.example.viaggiAziendali.dto.ViaggioDTO;
import com.example.viaggiAziendali.enumerations.StatoViaggio;
import com.example.viaggiAziendali.exceptions.DipendenteNotFound;
import com.example.viaggiAziendali.exceptions.ViaggioNotFound;
import com.example.viaggiAziendali.model.Dipendente;
import com.example.viaggiAziendali.model.Viaggio;
import com.example.viaggiAziendali.service.ViaggioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/viaggi")

public class ViaggioController {

    @Autowired
    ViaggioService viaggioService;

    @PostMapping()
    public ResponseEntity<String> postViaggio(@RequestBody @Validated ViaggioDTO viaggioDTO, BindingResult validation){

        // verificare che la validazione vada a buon fine
        if (validation.hasErrors()){

            String messaggioDiErrore = "Errore di validazione \n";

            for (ObjectError errore : validation.getAllErrors()){
                messaggioDiErrore += errore.getDefaultMessage();
            }
            return new  ResponseEntity<>(messaggioDiErrore,HttpStatus.BAD_REQUEST);
        }

        long idViaggio = viaggioService.saveViaggio(viaggioDTO);
        return new ResponseEntity<>("Il viaggio con ID " + idViaggio + " è stato salvato correttamente!", HttpStatus.CREATED);
    }

    // GET per riprendere tutti i viaggi dal db
    @GetMapping()
    public List<Viaggio> getAllViaggi(){
        return viaggioService.getAllViaggi();
    }

    // GET che ricerca un viaggio tramite ID
    @GetMapping("/{viaggioId}")
    public String getViaggioById(@PathVariable long viaggioId){

        try {
            Optional<Viaggio> viaggio = viaggioService.getViaggioById(viaggioId);
            if (viaggio.isPresent()) {
                return "Il viaggio con ID " + viaggioId + " e destinazione " + viaggio.get().getDestinazione();
            } else {
                throw new ViaggioNotFound("Il viaggio con ID " + viaggioId + " non è presente nel database");
            }

        } catch (ViaggioNotFound e) {
            System.out.println("Errore: " + e.getMessage());
            return "Errore: " + e.getMessage();
        }

    }

}
