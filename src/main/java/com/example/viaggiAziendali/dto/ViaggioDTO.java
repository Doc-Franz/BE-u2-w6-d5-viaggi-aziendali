package com.example.viaggiAziendali.dto;

import com.example.viaggiAziendali.enumerations.StatoViaggio;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class ViaggioDTO {

    @NotBlank(message = "Il campo destinazione risulta vuoto")
    @NotNull(message = "Il campo destinazione è obbligatorio")
    private String destinazione;

    public ViaggioDTO() {}

    public ViaggioDTO(String destinazione) {
        this.destinazione = destinazione;
    }

    public String getDestinazione() {
        return destinazione;
    }

    public void setDestinazione(String destinazione) {
        this.destinazione = destinazione;
    }

}
