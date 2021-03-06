package fr.formation.api;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonView;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.formation.dao.IParachutisteDaoJpaRepository;
import fr.formation.dao.ISautDaoJpaRepository;
import fr.formation.model.Hauteur;
import fr.formation.model.Parachutiste;
import fr.formation.model.Saut;
import fr.formation.model.TypeSaut;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/saut")
public class SautApiController {
    @Autowired
    private ISautDaoJpaRepository daoSaut;

    @Autowired
    private IParachutisteDaoJpaRepository daoParachutiste;

    @JsonView(Views.Saut.class)
    @GetMapping
    public List<Saut> findAll() {
        return this.daoSaut.findAll();
    }

    @JsonView(Views.Saut.class)
    @GetMapping("/hauteur")
    public List<Integer> findHauteur() {
        List<Integer> listeHauteurs = new ArrayList<Integer>();

        for (Hauteur h : Hauteur.values()) {
            listeHauteurs.add(h.getInt());
        }

        return listeHauteurs;
    }

    @JsonView(Views.Saut.class)
    @GetMapping("/type")
    public TypeSaut[] findTypes() {
        return TypeSaut.values();
    }

    @PostMapping
    public boolean add(@RequestBody Saut saut) {
        try {
            enregistrerParachutistes(saut);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @PutMapping("/{id}")
    public boolean put(@PathVariable int id, @RequestBody Saut saut) {
        try {
            enregistrerParachutistes(saut);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @DeleteMapping("/{id}")
    public boolean deleteById(@PathVariable int id) {
        try {
            Saut s = daoSaut.findById(id).get();
            for (Parachutiste p : s.getParachutistes()) {
                p.setSaut(null);
            }
            this.daoSaut.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private void enregistrerParachutistes(Saut saut) {
        if (saut.getTypeSaut() == null) {
            if (saut.getParachutistes().size() > 1) {
                saut.setTypeSaut(TypeSaut.GROUPE);
            } else {
                saut.setTypeSaut(TypeSaut.SOLO);
            }
        }
        Saut s = this.daoSaut.save(saut);
        List<Parachutiste> l = s.getParachutistes();
        for (int i = 0; i < l.size(); i++) {
            Parachutiste p = this.daoParachutiste.findById(l.get(i).getId()).get();
            p.setSaut(s);
            this.daoParachutiste.save(p);
        }
    }

}
