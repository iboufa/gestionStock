package com.gestion.stock.bean;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "produit")
@EqualsAndHashCode
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Produit extends Audit {


	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nom", nullable = false, length = 100)
    private String nom;

    @Column(name = "description", length = 255)
    private String description;

    @Column(name = "prix", nullable = false, precision = 10, scale = 2)
    private BigDecimal prix;

    @Column(name = "quantite_en_stock", nullable = false)
    private int quantiteEnStock;

    @Column(name = "code_barre", length = 50, unique = true)
    private String codeBarre;

    @ManyToOne
    @JoinColumn(name = "categorie_id", nullable = false)
    private Categorie categorie;

    @ManyToOne
    @JoinColumn(name = "fournisseur_id", nullable = false)
    private Fournisseur fournisseur;

    @Column(name = "tva", precision = 5, scale = 2)
    private BigDecimal tva;

    @Column(name = "poids", precision = 10, scale = 2)
    private BigDecimal poids;

    @Column(name = "couleur", length = 50)
    private String couleur;

    @Column(name = "taille", length = 20)
    private String taille;

}
