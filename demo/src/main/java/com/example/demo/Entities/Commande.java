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
    @JoinColumn(name="idFournisseur")
    private Fournisseur fournisseur;
    @OneToMany(mappedBy = "commande")
    private Collection<Produit> LesProduits;
    private Status status;

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public long getId() {
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



    public Commande(Long id, Date date, float totale, Status status) {
        this.id=id;
        this.date = date;
        this.totale = totale;
        this.status=status;
    }
}
