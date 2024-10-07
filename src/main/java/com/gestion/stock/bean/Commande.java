/**
 * 
 */
package com.gestion.stock.bean;

import java.time.LocalDateTime;
import java.util.List;

import com.gestion.stock.enums.StatutCommande;

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
@Table(name = "commande")
@EqualsAndHashCode
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Commande extends Audit {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "numero_commande", nullable = false, unique = true)
    private String numeroCommande;

    @Column(name = "date_commande", nullable = false)
    private LocalDateTime dateCommande;

    @Column(name = "montant_total", nullable = false)
    private Double montantTotal;

    @Enumerated(EnumType.STRING)
    @Column(name = "statut_commande", nullable = false, length = 20)
    private StatutCommande statutCommande = StatutCommande.EN_ATTENTE;

    @Column(name = "adresse_livraison", nullable = false, length = 255)
    private String adresseLivraison;

    @Column(name = "methode_paiement", nullable = false, length = 50)
    private String methodePaiement;

    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;

    @OneToMany(mappedBy = "commande", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<LigneCommande> lignesCommande;
    
    @ManyToOne
    @JoinColumn(name = "facture_id") // Foreign key in Commande table
    private Facture facture;
    
    @ManyToOne
    @JoinColumn(name = "fournisseur_id") // Foreign key in Fournisseur table
    private Fournisseur fournisseur;
    
   

}
