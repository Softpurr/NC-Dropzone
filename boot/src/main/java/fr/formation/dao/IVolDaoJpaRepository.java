package fr.formation.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.formation.model.Etat;
import fr.formation.model.Vol;

public interface IVolDaoJpaRepository extends JpaRepository<Vol, Integer>{
    public List<Vol> findAllByEtat(Etat etat);
}
