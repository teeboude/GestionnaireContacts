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

    public void deleteRelation(Long id) {
        relationRepository.deleteById(id);
    }

    public List<Relation> getAllRelations() {
        return relationRepository.findAll();
    }

    public Optional<Relation> getRelation(Long id) {
        return relationRepository.findById(id);
    }

}
