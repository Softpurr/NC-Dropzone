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
import fr.formation.model.Parachute;


@RestController
@CrossOrigin("*")
@RequestMapping("/api/parachute")
public class ParachuteApiController {
    @Autowired
    private IParachuteDaoJpaRepository daoParachute;

    @JsonView(Views.Parachute.class)
    @GetMapping
    public List<Parachute> findAll(){
        return this.daoParachute.findAll();
    }

    @JsonView(Views.Parachute.class)
    @GetMapping("/parachute-non-possede")
    public List<Parachute> findAllByIsPersoFalse() {
        return this.daoParachute.findAllByIsPersoFalse();
    }

    @GetMapping("/by-parachutiste/{parachutisteId}")
    @JsonView(Views.Parachute.class)
    public List<Parachute> findAllByParachutisteId(@PathVariable int parachutisteId) {
        return this.daoParachute.findAllByParachutisteId(parachutisteId);
    }

    @PostMapping
    public boolean add(@RequestBody Parachute parachute){

        try {
            this.daoParachute.save(parachute);
            return true;
        }
        catch (Exception e){
            return false;
        }
    }

    @PutMapping("/{id}")
    public boolean put(@PathVariable int id, @RequestBody Parachute parachute){
        try {
            this.daoParachute.save(parachute);
            return true;
        }
        catch (Exception e){
            return false;
        }
    }

    @DeleteMapping("/{id}")
    public boolean deleteById(@PathVariable int id){
        try {
            this.daoParachute.deleteById(id);
            return true;
        }
        catch (Exception e){
            return false;
        }
    }

}
