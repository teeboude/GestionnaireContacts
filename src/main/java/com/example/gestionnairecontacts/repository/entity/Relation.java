package com.example.gestionnairecontacts.repository.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "relation_data")
public class Relation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String lien;

    @ManyToOne()
    private Contact contactEntree;

    @ManyToOne()
    private Contact contactSortie;

    public Relation() {
    }

    // getters et setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLien() {
        return lien;
    }

    public void setLien(String lien) {
        this.lien = lien;
    }

    public Contact getContactEntree() {
        return contactEntree;
    }

    public void setContactEntree(Contact contactEntree) {
        this.contactEntree = contactEntree;
    }

    public Contact getContactSortie() {
        return contactSortie;
    }

    public void setContactSortie(Contact contactSortie) {
        this.contactSortie = contactSortie;
    }
}
