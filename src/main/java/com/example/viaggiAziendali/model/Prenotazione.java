package com.example.viaggiAziendali.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity(name = "prenotazioni")

public class Prenotazione {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private LocalDate dataViaggio;

    private String note;

    public Prenotazione(){}

    public Prenotazione(LocalDate dataViaggio, String note) {
        this.dataViaggio = dataViaggio;
        this.note = note;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
