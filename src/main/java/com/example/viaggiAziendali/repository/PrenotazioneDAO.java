package com.example.viaggiAziendali.repository;

import com.example.viaggiAziendali.model.Prenotazione;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface PrenotazioneDAO extends JpaRepository<Prenotazione, Long> {
}
