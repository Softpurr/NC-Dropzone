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

import fr.formation.dao.IVolDaoJpaRepository;
import fr.formation.model.Etat;
import fr.formation.model.Vol;


@RestController
@CrossOrigin("*")
@RequestMapping("/api/vol")
public class VolApiController {
    @Autowired
    private IVolDaoJpaRepository daoVol;

    @JsonView(Views.Vol.class)
    @GetMapping
    public List<Vol> findAll(){
        return this.daoVol.findAll();
    }

    @GetMapping("/etat")
    public Etat[] findEtats(){
        return Etat.values();
    }

    @PostMapping
    public boolean add(@RequestBody Vol vol){
        System.out.println(vol.getNombreSaut());
        System.out.println(vol.getEtat());
        try {
            this.daoVol.save(vol);
            return true;
        }
        catch (Exception e){
            return false;
        }
    }

    @PutMapping("/{id}")
    public boolean put(@PathVariable int id, @RequestBody Vol vol){
        try {
            this.daoVol.save(vol);
            return true;
        }
        catch (Exception e){
            return false;
        }
    }

    @DeleteMapping("/{id}")
    public boolean deleteById(@PathVariable int id){
        try {
            this.daoVol.deleteById(id);
            return true;
        }
        catch (Exception e){
            return false;
        }
    }

}
