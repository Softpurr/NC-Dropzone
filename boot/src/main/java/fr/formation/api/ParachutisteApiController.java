package fr.formation.api;

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

import fr.formation.dao.IParachuteDaoJpaRepository;
import fr.formation.dao.IParachutisteDaoJpaRepository;
import fr.formation.model.Parachute;
import fr.formation.model.Parachutiste;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/parachutiste")
public class ParachutisteApiController {
    @Autowired
    private IParachutisteDaoJpaRepository daoParachutiste;

    @Autowired
    private IParachuteDaoJpaRepository daoParachute;

    @JsonView(Views.Parachutiste.class)
    @GetMapping
    public List<Parachutiste> findAll() {
        return this.daoParachutiste.findAll();
    }

    @JsonView(Views.Parachutiste.class)
    @GetMapping("/by-id/{id}")
    public Parachutiste findById(@PathVariable int id) {
        return this.daoParachutiste.findById(id).get();
    }

    @JsonView(Views.Parachutiste.class)
    @GetMapping("/by-parachutiste/{numLicence}")
    public Parachutiste findByNumLicence(@PathVariable String numLicence) {
        return this.daoParachutiste.findByNumLicence(numLicence);
    }

    @JsonView(Views.Parachutiste.class)
    @GetMapping("/by-nom/{nom}")
    public List<Parachutiste> findByNom(@PathVariable String nom) {
        return this.daoParachutiste.findByNom(nom);
    }

    @JsonView(Views.Parachutiste.class)
    @GetMapping("/by-saut/{id}")
    public List<Parachutiste> findBySaut(@PathVariable int id) {
        return this.daoParachutiste.findBySaut(id);
    }

    @JsonView(Views.Parachutiste.class)
    @GetMapping("/by-licence/{licence}")
    public List<Parachutiste> findByLicence(@PathVariable String licence) {
        return this.daoParachutiste.findByLicence(licence);
    }

    @JsonView(Views.Parachutiste.class)
    @GetMapping("/confirme")
    public List<Parachutiste> findConfirme() {
        return this.daoParachutiste.findByIsConfirme(true);
    }

    @PostMapping
    public boolean add( @RequestBody Parachutiste parachutiste) {

        try {
            
            Parachutiste p = this.daoParachutiste.save(parachutiste);
            // System.out.println(parachutiste.getId());
            List<Parachute> parachutePossede = p.getParachutes();
            for (int i=0; i< parachutePossede.size(); i++) {
                Parachute para = this.daoParachute.findById(parachutePossede.get(i).getId()).get() ;
                para.setParachutiste(p);
                para.setPerso(true);
                this.daoParachute.save(para);
            }
            
            return true;
        } catch (Exception e) {
            
            return false;
        }
    }

    @PutMapping("/{id}")
    public boolean put(@PathVariable int id, @RequestBody Parachutiste parachutiste) {
        try {
            this.daoParachutiste.save(parachutiste);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @DeleteMapping("/{id}")
    public boolean deleteById(@PathVariable int id) {
        try {
            List<Parachute> p =this.daoParachute.findAllByParachutisteId(id);
            for (int i=0; i< p.size(); i++) {
                this.daoParachute.deleteById(p.get(i).getId());
            }
            this.daoParachutiste.deleteById(id);
            // System.out.println(parachutiste.getId());
            
            
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
