package com.example.demo.Repositories;

import com.example.demo.Entities.Commande;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommandeRepository extends JpaRepository<Commande,Long> {
    List<Commande> findAllByFournisseur_Id(Long id);
}
