package com.Web.WebTechAnwendung.api;

import com.Web.WebTechAnwendung.api.Cocktail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CocktailRestController {

    private List<Cocktail> cocktails;

    @Autowired
    CocktailService service;

    public CocktailRestController() {
    }


    @PostMapping("/Cocktail")
    public Cocktail createCocktail(@RequestBody Cocktail cocktail){
        return service.save(cocktail);
    }
    @GetMapping(path= "/api/v1/cocktails")
    public ResponseEntity<List<Cocktail>> fetchCocktails(){
        return ResponseEntity.ok(cocktails);
    }
}
