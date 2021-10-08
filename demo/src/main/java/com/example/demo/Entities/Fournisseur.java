package com.example.demo.Entities;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "Fournisseurs")
public class Fournisseur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nom;
    private String teléphone;
    private String adresse;
    @OneToMany(mappedBy = "fournisseur")
    private Collection<Commande> LesComandes;

    public Fournisseur() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

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

    public Fournisseur(long id,String nom,String teléphone,String adresse) {
        this.adresse=adresse;
        this.id=id;
        this.nom=nom;
        this.teléphone=teléphone;
    }
}
