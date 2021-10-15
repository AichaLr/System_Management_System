package com.example.demo.Controllers;

import com.example.demo.Entities.*;
import com.example.demo.Payload.request.Loginrequest;
import com.example.demo.Payload.request.Signuprequest;
import com.example.demo.Payload.request.SignuprequestFournisseur;
import com.example.demo.Payload.response.Jwtresponse;
import com.example.demo.Payload.response.Messageresponse;
import com.example.demo.Repositories.*;
import com.example.demo.Security.jwt.JwtUtils;
import com.example.demo.Services.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;

@CrossOrigin(origins = "*", maxAge = 3600)

@RestController
@RequestMapping("api/auth")
public class Controller {


    @GetMapping("/text")
    String hello(){
        return "hello world";
    }


    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    PasswordEncoder encoder;
    @Autowired
    FournisseurRepository fournisseurRepository;

    @Autowired
    JwtUtils jwtUtils;
    @Autowired
    ProduitRepository produitRepository;
@Autowired
CommandeRepository commandeRepository;

    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@RequestBody Loginrequest loginRequest) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        List<String> roles = userDetails.getAuthorities().stream()
                .map(item -> item.getAuthority())
                .collect(Collectors.toList());

        return ResponseEntity.ok(new Jwtresponse(jwt,
                userDetails.getId(),
                userDetails.getUsername(),
                userDetails.getEmail(),
                roles));
    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser( @RequestBody Signuprequest signUpRequest) {
        if (userRepository.existsByUsername(signUpRequest.getUsername())) {
            return ResponseEntity
                    .badRequest()
                    .body(new Messageresponse("Error: Username is already taken!"));
        }

        if (userRepository.existsByEmail(signUpRequest.getEmail())) {
            return ResponseEntity
                    .badRequest()
                    .body(new Messageresponse("Error: Email is already in use!"));
        }

        // Create new user's account
        User user = new User(signUpRequest.getUsername(),
                signUpRequest.getEmail(),
                encoder.encode(signUpRequest.getPassword()));

        Set<String> strRoles = signUpRequest.getRole();
        Set<Role> roles = new HashSet<>();

        if (strRoles == null) {
            Role userRole = roleRepository.findByName(ERole.ROLE_FOURNISSEUR)
                    .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
            roles.add(userRole);
        } else {
            strRoles.forEach(role -> {
                switch (role) {
                    case "responsable":
                        Role adminRole = roleRepository.findByName(ERole.ROLE_RESPONSABLE)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(adminRole);

                        break;
                    case "fournisseur":
                        Role modRole = roleRepository.findByName(ERole.ROLE_FOURNISSEUR)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(modRole);

                        break;

                }
            });
        }

        user.setRoles(roles);
        userRepository.save(user);

        return ResponseEntity.ok(new Messageresponse("User registered successfully!"));
    }





    @PostMapping("/signupfournisseur")
    public ResponseEntity<?> registerfournisseur( @RequestBody SignuprequestFournisseur signUpRequest) {
        if (userRepository.existsByUsername(signUpRequest.getUsername())) {
            return ResponseEntity
                    .badRequest()
                    .body(new Messageresponse("Error: Username is already taken!"));
        }

        if (userRepository.existsByEmail(signUpRequest.getEmail())) {
            return ResponseEntity
                    .badRequest()
                    .body(new Messageresponse("Error: Email is already in use!"));
        }

        // Create new user's account
        User user = new User(signUpRequest.getUsername(),
                signUpRequest.getEmail(),
                encoder.encode(signUpRequest.getPassword()));

        Set<String> strRoles = signUpRequest.getRole();
        Set<Role> roles = new HashSet<>();

        if (strRoles == null) {
            Role userRole = roleRepository.findByName(ERole.ROLE_FOURNISSEUR)
                    .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
            roles.add(userRole);
        } else {
            strRoles.forEach(role -> {
                switch (role) {
                    case "responsable":
                        Role adminRole = roleRepository.findByName(ERole.ROLE_RESPONSABLE)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(adminRole);

                        break;
                    case "fournisseur":
                        Role modRole = roleRepository.findByName(ERole.ROLE_FOURNISSEUR)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(modRole);

                        break;

                }
            });
        }

        user.setRoles(roles);
        userRepository.save(user);
Fournisseur fournisseur=new Fournisseur(signUpRequest.getNom(),signUpRequest.getTeléphone(),signUpRequest.getAdresse(),user);
fournisseurRepository.save(fournisseur);
        return ResponseEntity.ok(new Messageresponse("User registered successfully!"));
    }




































    @PostMapping("/addorder")
    public String save(@RequestBody Commande commande) {
        // List<level> levelList=new List<>();

Commande commande1=new Commande(commande.getDate(),commande.getTotale(), commande.getStatus(),commande.getProduit(),commande.getFournisseur());
commandeRepository.save(commande1);
return "commande created successfully";    }
    @PostMapping("/addproduct")
    public String saveproduct(@RequestBody Produit produit) {
        // List<level> levelList=new List<>();

        Produit produit1=new Produit(produit.getIntitule(),produit.getQtt(),produit.getPrix_unitaire(),produit.getMontant());
produitRepository.save(produit1);

        return "product created successfully";    }

@PostMapping("/updateorder/{id}/{status}")
    public Optional<Commande> update(@PathVariable Long id,@PathVariable String status) {
     Optional<Commande> commande= commandeRepository.findById(id);
commande.get().setStatus(status);
commandeRepository.save(commande.get());
        return commande;
}























}
