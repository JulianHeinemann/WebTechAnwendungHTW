package com.Web.WebTechAnwendung.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
public class CocktailService {

    @Autowired
    CocktailRepository repo;

    public Cocktail save(Cocktail cocktail){
        return repo.save(cocktail);
    }

}
