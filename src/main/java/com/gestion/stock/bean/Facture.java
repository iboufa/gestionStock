/**
 * 
 */
package com.gestion.stock.bean;

import java.time.LocalDateTime;
import java.util.List;

import com.gestion.stock.enums.TypeClient;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "facture")
@EqualsAndHashCode
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Facture extends Audit {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nom", nullable = false, length = 100)
    private String nom;

    @Column(name = "prenom", nullable = false, length = 100)
    private String prenom;

    @Column(name = "email", nullable = false, unique = true, length = 150)
    private String email;

    @Column(name = "telephone", nullable = false, length = 15)
    private String telephone;

    @Column(name = "adresse", nullable = false, length = 255)
    private String adresse;

    @Column(name = "ville", nullable = false, length = 100)
    private String ville;

    @Column(name = "code_postal", nullable = false, length = 20)
    private String codePostal;

    @Column(name = "pays", nullable = false, length = 100)
    private String pays;

    @Column(name = "date_naissance", nullable = true)
    private LocalDateTime dateNaissance;

    @Enumerated(EnumType.STRING)
    @Column(name = "type_client", nullable = false, length = 20)
    private TypeClient typeClient = TypeClient.PARTICULIER;

    @Column(name = "date_creation", updatable = false)
    private LocalDateTime dateCreation;

    @Column(name = "date_modification")
    private LocalDateTime dateModification;

    @OneToMany(mappedBy = "facture", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Commande> commandes;
    
    @ManyToOne
    @JoinColumn(name = "fournisseur_id", nullable = false)
    private Fournisseur fournisseur;

  




}
