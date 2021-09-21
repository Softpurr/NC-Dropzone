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

import fr.formation.dao.IParachutisteDaoJpaRepository;
import fr.formation.model.Parachutiste;


@RestController
@CrossOrigin("*")
@RequestMapping("/api/parachutiste")
public class ParachutisteApiController {
    @Autowired
    private IParachutisteDaoJpaRepository daoParachutiste;

    @JsonView(Views.Parachutiste.class)
    @GetMapping
    public List<Parachutiste> findAll(){
        return this.daoParachutiste.findAll();
    }

    @PostMapping
    public boolean add(@RequestBody Parachutiste parachutiste){
        
        try {
            System.out.println("Try");
            this.daoParachutiste.save(parachutiste);
            return true;
        }
        catch (Exception e){
            System.out.println("catch");
            return false;
        }
    }

    @PutMapping("/{id}")
    public boolean put(@PathVariable int id, @RequestBody Parachutiste parachutiste){
        try {
            this.daoParachutiste.save(parachutiste);
            return true;
        }
        catch (Exception e){
            return false;
        }
    }

    @DeleteMapping("/{id}")
    public boolean deleteById(@PathVariable int id){
        try {
            this.daoParachutiste.deleteById(id);
            return true;
        }
        catch (Exception e){
            return false;
        }
    }

}
