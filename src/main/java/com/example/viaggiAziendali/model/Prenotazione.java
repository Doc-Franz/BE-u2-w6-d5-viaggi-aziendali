package com.example.viaggiAziendali.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity(name = "prenotazioni")

public class Prenotazione {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private LocalDate dataViaggio;

    public Prenotazione(){}

    public Prenotazione(LocalDate dataViaggio) {
        this.dataViaggio = dataViaggio;
    }

    public LocalDate getDataViaggio() {
        return dataViaggio;
    }

    public void setDataViaggio(LocalDate dataViaggio) {
        this.dataViaggio = dataViaggio;
    }
}
