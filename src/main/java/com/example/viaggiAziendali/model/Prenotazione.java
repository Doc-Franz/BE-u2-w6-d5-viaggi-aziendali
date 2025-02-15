package com.example.viaggiAziendali.model;

import com.example.viaggiAziendali.enumerations.StatoViaggio;
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

    @Enumerated(value = EnumType.STRING)
    private StatoViaggio statoViaggio;

    private String note;

    public Prenotazione(){
        this.setStatoViaggio(StatoViaggio.PROGRAMMATO);
    }

    public Prenotazione(LocalDate dataViaggio, String note) {
        this.dataViaggio = dataViaggio;
        this.note = note;
        this.statoViaggio = StatoViaggio.PROGRAMMATO;
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

    public StatoViaggio getStatoViaggio() {
        return statoViaggio;
    }

    public void setStatoViaggio(StatoViaggio statoViaggio) {
        this.statoViaggio = statoViaggio;
    }
}
