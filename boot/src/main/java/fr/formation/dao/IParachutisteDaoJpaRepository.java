package fr.formation.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import fr.formation.model.Parachutiste;

public interface IParachutisteDaoJpaRepository extends JpaRepository<Parachutiste, Integer> {
    @Query("select p from Parachutiste p where Lower(p.nomParachutiste) like Lower(?1)")
    public List<Parachutiste> findByNom(String nom);

    public List<Parachutiste> findBySaut(int id);

    @Query("select p from Parachutiste p where Lower(p.numLicence) like Lower(?1)")
    public List<Parachutiste> findByLicence(String licence);

    public List<Parachutiste> findByIsConfirme(Boolean confirme);
}
