package com.example.demo.Controllers;

import com.example.demo.Entities.Commande;
import com.example.demo.Entities.Fournisseur;
import com.example.demo.Entities.Produit;
import com.example.demo.Entities.User;
import com.example.demo.Repositories.CommandeRepository;
import com.example.demo.Repositories.FournisseurRepository;
import com.example.demo.Repositories.ProduitRepository;
import com.example.demo.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/test")
public class TestControler {
    @Autowired
    UserRepository userRepository;
    @Autowired
    FournisseurRepository fournisseurRepository;
    @Autowired
    ProduitRepository produitRepository;
    @Autowired
    CommandeRepository commandeRepository;
    @GetMapping("/all")
    public String allAccess() {
        return "Public Content.";
    }

    @GetMapping("/fournisseur")
    @PreAuthorize("hasRole('FOURNISSEUR')")
    public String moderatorAccess() {
        return "Fournisseur Board.";
    }

    @GetMapping("/responsable")
    @PreAuthorize("hasRole('RESPONSABLE')")
    public String adminAccess() {
        return "Responsable Board.";
    }
    @GetMapping("/listfournisseur")
    public List<Fournisseur> fournisseurList(){

        return fournisseurRepository.findAll();
    }
    @GetMapping("/produit/{id}")
    public Optional<Produit> produit(@PathVariable  Long id){

        return produitRepository.findById(id);
    }
    @GetMapping("/listproduits")
    public List<Produit> produitList(){

        return produitRepository.findAll();
    }

    @GetMapping("/listcommandes")
    public List<Commande> commandeList(){

        return commandeRepository.findAll();
    }
    @GetMapping("/fournisseurrr/{id}")
    public Optional<Fournisseur> fournisseur(@PathVariable Long id){

        return fournisseurRepository.findById(id);
    }


    @GetMapping("/etatcommande/{id}")
    public List<Commande> etat(@PathVariable Long id){
       Optional<User> user= userRepository.findById(id);
       Fournisseur f1= fournisseurRepository.findByCompte_Id(user.get().getId());

       return commandeRepository.findAllByFournisseur_Id(f1.getId());
    }
}
