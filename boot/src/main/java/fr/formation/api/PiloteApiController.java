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

import fr.formation.dao.IPiloteDaoJpaRepository;
import fr.formation.model.Pilote;


@RestController
@CrossOrigin("*")
@RequestMapping("/api/pilote")
public class PiloteApiController {
    @Autowired
    private IPiloteDaoJpaRepository daoPilote;

    @JsonView(Views.Pilote.class)
    @GetMapping
    public List<Pilote> findAll(){
        return this.daoPilote.findAll();
    }

    @PostMapping
    public boolean add(@RequestBody Pilote pilote){

        try {
            this.daoPilote.save(pilote);
            return true;
        }
        catch (Exception e){
            return false;
        }
    }

    @PutMapping("/{id}")
    public boolean put(@PathVariable int id, @RequestBody Pilote pilote){
        try {
            this.daoPilote.save(pilote);
            return true;
        }
        catch (Exception e){
            return false;
        }
    }

    @DeleteMapping("/{id}")
    public boolean deleteById(@PathVariable int id){
        try {
            this.daoPilote.deleteById(id);
            return true;
        }
        catch (Exception e){
            return false;
        }
    }

}
