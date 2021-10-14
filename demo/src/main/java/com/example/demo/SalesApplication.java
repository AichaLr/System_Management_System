package com.example.demo;

import com.example.demo.Entities.Commande;
import com.example.demo.Entities.Fournisseur;
import com.example.demo.Entities.Produit;
import com.example.demo.Repositories.FournisseurRepository;
import com.example.demo.Repositories.ProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SalesApplication  implements CommandLineRunner {
@Autowired
	FournisseurRepository fournisseurRepository;
@Autowired
	ProduitRepository produitRepository;

	public static void main(String[] args) {
		SpringApplication.run(SalesApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		/*Fournisseur fournisseur1=new Fournisseur(1L,"fournisseur1","+213556463327",null);
		  this.id=id;
        this.intitulé=intitulé;
        this.prix_unitaire=prix_unitaire;
        this.montant=montant;
        this.qtt=qtt;
		fournisseurRepository.save(fournisseur1);
		Fournisseur fournisseur2=new Fournisseur(2L,"fournisseur2","+213556665432",null);

		fournisseurRepository.save(fournisseur2);
			Produit product1=new Produit (1L,"basket",30,100,3000);
		Produit product2=new Produit (2L,"jupe",10,50,500);
produitRepository.save(product1); produitRepository.save(product2);
Produit product1=new Produit (1L,"basket",30,100,3000);
		Produit product2=new Produit (2L,"jupe",10,50,500);
		produitRepository.save(product1); produitRepository.save(product2);
				Produit product1=new Produit (1L,"basket",30,100,3000);
		Produit product2=new Produit (2L,"jupe",10,50,500);
		produitRepository.save(product1); produitRepository.save(product2);
		Produit product1=new Produit (1L,"basket",30,100,3000);
		Produit product2=new Produit (2L,"jupe",10,50,500);
		produitRepository.save(product1); produitRepository.save(product2);
		Produit product1=new Produit ("Robe",10,3000,30000);
		Produit product2=new Produit ("jupe",20,1000,20000);
		produitRepository.save(product1); produitRepository.save(product2);
		*/




	}
}
