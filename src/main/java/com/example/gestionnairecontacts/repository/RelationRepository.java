package com.example.gestionnairecontacts.repository;

import com.example.gestionnairecontacts.repository.entity.Relation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RelationRepository extends JpaRepository<Relation, Long> {

    List<Relation> findByContactEntreeIdContainingOrContactSortieIdContaining(Long idEntrée, Long idSortie);

}
