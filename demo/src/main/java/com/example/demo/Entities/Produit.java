package com.example.demo.Entities;

import javax.persistence.*;

@Entity
@Table(name = "Produits")
public class Produit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String intitulé;
    private int qtt;
    private float prix_unitaire;
    private float montant;
    @ManyToOne
    @JoinColumn(name="idCommande")
    private Commande commande;
    public Produit() {}

    public Produit(long id,String intitulé,int qtt,float prix_unitaire,float montant) {
        this.id=id;
        this.intitulé=intitulé;
        this.prix_unitaire=prix_unitaire;
        this.montant=montant;
        this.qtt=qtt;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getIntitulé() {
        return intitulé;
    }

    public void setIntitulé(String intitulé) {
        this.intitulé = intitulé;
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
