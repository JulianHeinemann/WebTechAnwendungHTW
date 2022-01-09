package com.Web.WebTechAnwendung.service;

import com.Web.WebTechAnwendung.api.Cocktail;
import com.Web.WebTechAnwendung.persistence.CocktailEntity;

public class CocktailTransformer {

    public Cocktail transformEntity(CocktailEntity cocktailEntity){
        return new Cocktail(
                cocktailEntity.getId(),
                cocktailEntity.getRezept(),
                cocktailEntity.getName(),
                cocktailEntity.getZutaten(),
                cocktailEntity.getTags());
    }
}
