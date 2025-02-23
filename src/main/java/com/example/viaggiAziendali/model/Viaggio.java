package com.example.viaggiAziendali.model;

import com.example.viaggiAziendali.enumerations.StatoViaggio;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity(name = "viaggi")

public class Viaggio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;

    @Column(nullable = false, unique = true)
    private String destinazione;

    // relazione unidirezionale one to many tra viaggio e prenotazioni
    @OneToMany
    @JoinColumn(name = "viaggio_id")
    List<Prenotazione> prenotazioneList;

    public Viaggio() {}

    public Viaggio(String destinazione) {
        this.destinazione = destinazione;
    }

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public String getDestinazione() {
        return destinazione;
    }

    public void setDestinazione(String destinazione) {
        this.destinazione = destinazione;
    }

    public List<Prenotazione> getPrenotazioneList() {
        return prenotazioneList;
    }

    public void setPrenotazioneList(List<Prenotazione> prenotazioneList) {
        this.prenotazioneList = prenotazioneList;
    }
}
