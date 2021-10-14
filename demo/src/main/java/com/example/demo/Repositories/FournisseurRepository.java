package com.example.demo.Repositories;

import com.example.demo.Entities.Fournisseur;
import com.example.demo.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository

public interface FournisseurRepository extends JpaRepository<Fournisseur,Long> {
    Fournisseur findByCompte(Optional<User> compte);
    Fournisseur findByCompte_Id(Long id);
}
