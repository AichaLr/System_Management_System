package com.example.demo.Entities;

import javax.persistence.*;

@Entity
@Table(name = "Produits")
public class Produit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String intitule;
    private int qtt;
    private float prix_unitaire;
    private float montant;
   // @OneToOne
    //private Commande commande;

    public Produit() {}

    public Produit(String intitule,int qtt,float prix_unitaire,float montant) {
        this.intitule=intitule;
        this.prix_unitaire=prix_unitaire;
        this.montant=montant;
        this.qtt=qtt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIntitule() {
        return intitule;
    }

    public void setIntitule(String intitule) {
        this.intitule = intitule;
    }

    public int getQtt() {
        return qtt;
    }

    public void setQtt(int qtt) {
        this.qtt = qtt;
    }

    public float getPrix_unitaire() {
        return prix_unitaire;
    }

    public void setPrix_unitaire(float prix_unitaire) {
        this.prix_unitaire = prix_unitaire;
    }

    public float getMontant() {
        return montant;
    }

    public void setMontant(float montant) {
        this.montant = montant;
    }
}
