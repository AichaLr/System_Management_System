package com.example.demo.Payload.request;

import java.util.Set;

public class SignuprequestFournisseur {


    private String username;

    private String email;

    private Set<String> role;


    private String password;
    private String nom;
    private String teléphone;
    private String adresse;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getTeléphone() {
        return teléphone;
    }

    public void setTeléphone(String teléphone) {
        this.teléphone = teléphone;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<String> getRole() {
        return this.role;
    }

    public void setRole(Set<String> role) {
        this.role = role;
    }}
