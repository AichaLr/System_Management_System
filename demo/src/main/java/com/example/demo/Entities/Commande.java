package com.example.demo.Entities;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;
import java.util.List;
@Entity
@Table(name = "commandes")
public class Commande {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date date;
    private float totale;
   @ManyToOne
    @JoinColumn(name="idFournisseur"  )
    private Fournisseur fournisseur;

    @OneToOne
    @JoinColumn(name = "produit_id")
    private Produit produit;

    private String status;


    public Fournisseur getFournisseur() {
        return fournisseur;
    }

    public void setFournisseur(Fournisseur fournisseur) {
        this.fournisseur = fournisseur;
    }

    public Produit getProduit() {
        return produit;
    }

    public void setProduit(Produit produit) {
        this.produit = produit;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }




    public void setDate(Date date) {
        this.date = date;
    }

    public float getTotale() {
        return totale;
    }

    public void setTotale(float totale) {
        this.totale = totale;
    }


    public Commande() {
    }

    public Commande(Date date, float totale, String status,Produit produit,Fournisseur fournisseur) {
        this.date = date;
        this.totale = totale;
        this.status=status;
        this.fournisseur=fournisseur;
        this.produit= produit;
    }
}
