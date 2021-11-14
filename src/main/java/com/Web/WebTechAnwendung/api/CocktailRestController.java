package com.Web.WebTechAnwendung.api;

import com.Web.WebTechAnwendung.service.CocktailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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


   /* @PostMapping("/Cocktail")
    public Cocktail createCocktail(@RequestBody Cocktail cocktail){
        return cocktailService.save(cocktail);
    }
*/
    @GetMapping(path= "/api/v1/cocktails")
    public ResponseEntity<List<Cocktail>> fetchCocktails(){
        return ResponseEntity.ok(cocktailService.findAll());
    }

    @GetMapping(path="/api/v1/cocktails/{id}" )
    public ResponseEntity<Cocktail>fetchCocktails(@PathVariable Long id){
        var cocktail = cocktailService.findById(id);
        return cocktail != null? ResponseEntity.ok(cocktail) : ResponseEntity.notFound().build();
    }

    @PostMapping(path= "/api/v1/cocktails")
    public ResponseEntity<Void>creatCocktail(@RequestBody CocktailCreat cocktailCreat) throws URISyntaxException {
        var cocktailEntity = cocktailService.create(cocktailCreat);
        URI uri = new URI("/api/v1/cocktails/" + cocktailEntity.getId());
        return ResponseEntity.created(uri).build();
    }

    @PutMapping(path = "/api/v1/cocktails/{id}")
        public ResponseEntity<Cocktail> updateCocktail(@PathVariable Long id, @RequestBody CocktailCreat cocktailCreat){
            var cocktail = cocktailService.update(id, cocktailCreat);
            return cocktail != null? ResponseEntity.ok(cocktail) : ResponseEntity.notFound().build();
    }

    @DeleteMapping(path = "/api/v1/cocktails/{id}")
    public ResponseEntity<Void> deleteCocktail(@PathVariable Long id){
        boolean successful = cocktailService.deleteById(id);
        return successful? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }
}
