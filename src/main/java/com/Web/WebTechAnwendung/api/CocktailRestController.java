package com.Web.WebTechAnwendung.api;

import com.Web.WebTechAnwendung.service.CocktailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
public class  CocktailRestController {


    @Autowired
    CocktailService service;


    private final CocktailService cocktailService;

    public CocktailRestController(CocktailService cocktailService) {
        this.cocktailService = cocktailService;
    }

    @GetMapping(path= "/")
    public String standard(){
        return "default";
    }

    @GetMapping(path= "/cocktails")
    public ResponseEntity<List<Cocktail>> fetchCocktails(){
        return ResponseEntity.ok(cocktailService.findAll());
    }

    @GetMapping(path="/cocktails/{id}" )
    public ResponseEntity<Cocktail>fetchCocktails(@PathVariable Long id){
        var cocktail = cocktailService.findById(id);
        return cocktail != null? ResponseEntity.ok(cocktail) : ResponseEntity.notFound().build();
    }

    @PostMapping(path= "/cocktails")
    public ResponseEntity<Void>creatCocktail(@Valid @RequestBody CocktailCreate cocktailCreate) throws URISyntaxException {
        var valid = validate(cocktailCreate);
        if (valid) {
            var cocktailEntity = cocktailService.create(cocktailCreate);
            URI uri = new URI("/cocktails/" + cocktailEntity.getId());
            return ResponseEntity.created(uri).build();
        }
        else{
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping(path = "/cocktails/{id}")
        public ResponseEntity<Cocktail> updateCocktail(@PathVariable Long id, @RequestBody CocktailCreate cocktailCreate){
            var cocktail = cocktailService.update(id, cocktailCreate);
            return cocktail != null? ResponseEntity.ok(cocktail) : ResponseEntity.notFound().build();
    }

    @DeleteMapping(path = "/cocktails/{id}")
    public ResponseEntity<Void> deleteCocktail(@PathVariable Long id){
        boolean successful = cocktailService.deleteById(id);
        return successful? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }
    private boolean validate (CocktailCreate cocktailCreate){
        return cocktailCreate.getName() != null
                && !cocktailCreate.getName().isBlank()
                && cocktailCreate.getRezept() != null
                && !cocktailCreate.getRezept().isBlank()
                && cocktailCreate.getZutaten() != null
                && !cocktailCreate.getZutaten().isBlank()
                && cocktailCreate.getTags() != null
                && !cocktailCreate.getTags().isBlank();
    }
}
