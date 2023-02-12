package com.example.gestionnairecontacts.repository;

import com.example.gestionnairecontacts.repository.entity.Relation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RelationRepository extends JpaRepository<Relation, Long> {
}
