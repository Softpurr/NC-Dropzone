package fr.formation.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.formation.model.BeerList;

public interface IBeerListDaoJpaRepository extends JpaRepository<BeerList, Integer>{
    
}
