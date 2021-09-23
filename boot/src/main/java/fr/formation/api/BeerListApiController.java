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

import fr.formation.dao.IBeerListDaoJpaRepository;
import fr.formation.model.BeerList;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/beerlist")
public class BeerListApiController {
    
    @Autowired
    private IBeerListDaoJpaRepository daoBeerList;
    
    @JsonView(Views.BeerList.class)
    @GetMapping
    public List<BeerList> findAll(){
        return this.daoBeerList.findAll();
    }

    @PostMapping
    public boolean add(@RequestBody BeerList beerlist){

        try {
            this.daoBeerList.save(beerlist);
            return true;
        }
        catch (Exception e){
            return false;
        }
    }

    @PutMapping("/{id}")
    public boolean put(@PathVariable int id, @RequestBody BeerList beerlist){
        try {
            this.daoBeerList.save(beerlist);
            return true;
        }
        catch (Exception e){
            return false;
        }
    }

    @DeleteMapping("/{id}")
    public boolean deleteById(@PathVariable int id){
        try {
            this.daoBeerList.deleteById(id);
            return true;
        }
        catch (Exception e){
            return false;
        }
    }
}
