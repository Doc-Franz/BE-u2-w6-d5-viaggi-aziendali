package com.example.viaggiAziendali.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public class PrenotazioneDTO {

    @NotBlank(message = "Il campo data risulta vuoto")
    @NotNull(message = "Il campo data è obbligatorio")
    private LocalDate dataViaggio;

    private String note;

    public PrenotazioneDTO() {}

    public PrenotazioneDTO(LocalDate dataViaggio, String note) {
        this.dataViaggio = dataViaggio;
        this.note = note;
    }

    public LocalDate getDataViaggio() {
        return dataViaggio;
    }

    public void setDataViaggio(LocalDate dataViaggio) {
        this.dataViaggio = dataViaggio;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
