package com.example.viaggiAziendali.repository;

import com.example.viaggiAziendali.model.Viaggio;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface ViaggioDAO extends JpaRepository<Viaggio, Long> {}
