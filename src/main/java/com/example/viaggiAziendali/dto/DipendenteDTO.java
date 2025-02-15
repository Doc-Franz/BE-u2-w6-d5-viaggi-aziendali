package com.example.viaggiAziendali.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.URL;

public class DipendenteDTO {

    @NotBlank(message = "Il campo username risulta vuoto")
    @NotNull(message = "Il campo username è obbligatorio")
    private String username;

    @NotBlank(message = "Il campo nome risulta vuoto")
    @NotNull(message = "Il campo nome è obbligatorio")
    private String nome;

    @NotBlank(message = "Il campo cognome risulta vuoto")
    @NotNull(message = "Il campo cognome è obbligatorio")
    private String cognome;

    @Email(message = "Il formato dell'email non è corretto")
    private String email;

    @URL
    private String immagineDipendente;

    public DipendenteDTO() {}

    public DipendenteDTO(String username, String nome, String cognome, String email) {
        this.username = username;
        this.nome = nome;
        this.cognome = cognome;
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getImmagineDipendente() {
        return immagineDipendente;
    }

    public void setImmagineDipendente(String immagineDipendente) {
        this.immagineDipendente = immagineDipendente;
    }
}
