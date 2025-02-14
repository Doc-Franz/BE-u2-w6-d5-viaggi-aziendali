package com.example.viaggiAziendali.controller;

import com.example.viaggiAziendali.dto.ViaggioDTO;
import com.example.viaggiAziendali.enumerations.StatoViaggio;
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
}
