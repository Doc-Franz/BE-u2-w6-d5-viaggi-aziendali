package com.example.viaggiAziendali.repository;

import com.example.viaggiAziendali.model.Dipendente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface DipendenteDAO extends JpaRepository<Dipendente, Long> {
}
