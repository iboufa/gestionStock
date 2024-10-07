/**
 * 
 */
package com.gestion.stock.bean;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "fournisseur")
@EqualsAndHashCode
@Data
@NoArgsConstructor
@AllArgsConstructor


public class Fournisseur extends Audit{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nom", nullable = false, length = 100)
    private String nom;

    @Column(name = "adresse", length = 255)
    private String adresse;

    @Column(name = "email", length = 100, unique = true)
    private String email;

    @Column(name = "telephone", length = 20, unique = true)
    private String telephone;

    @Column(name = "siret", length = 14, unique = true)
    private String siret;

    @Column(name = "site_web", length = 100)
    private String siteWeb;

    @Column(name = "contact_principal", length = 100)
    private String contactPrincipal;

    @OneToMany(mappedBy = "fournisseur")
    private List<Commande> commandes;

    @OneToMany(mappedBy = "fournisseur")
    private List<Produit> produits;
    
    @OneToMany(mappedBy = "fournisseur")
    private List<Facture> factures;
}

