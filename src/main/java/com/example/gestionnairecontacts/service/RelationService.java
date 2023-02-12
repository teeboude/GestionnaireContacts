package com.example.gestionnairecontacts.service;

import com.example.gestionnairecontacts.repository.RelationRepository;
import com.example.gestionnairecontacts.repository.entity.Relation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RelationService {

    @Autowired
    private RelationRepository relationRepository;

    public void addRelation(Relation relation) {
        relationRepository.save(relation);
    }

    public Long deleteRelation(Long id) {
        Long idContact = relationRepository.findById(id).get().getContactEntree().getId();
        relationRepository.findById(id).get().setContactSortie(null);
        relationRepository.findById(id).get().setContactEntree(null);
        relationRepository.deleteById(id);
        return idContact;
    }

    public List<Relation> getAllRelations() {
        return relationRepository.findAll();
    }
    public List<Relation> getRelations(Long id) {
        return relationRepository.findByContactEntreeIdContainingOrContactSortieIdContaining(id, id);
    }
    public Optional<Relation> getRelation(Long id) {
        return relationRepository.findById(id);
    }

}
