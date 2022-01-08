package com.Web.WebTechAnwendung.service;

import com.Web.WebTechAnwendung.api.Cocktail;
import com.Web.WebTechAnwendung.api.CocktailCreate;
import com.Web.WebTechAnwendung.persistence.CocktailEntity;
import com.Web.WebTechAnwendung.persistence.CocktailRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CocktailService {


    CocktailRepository repo;

    private final CocktailRepository cocktailRepository;

    public CocktailService(CocktailRepository cocktailRepository) {
        this.cocktailRepository = cocktailRepository;
    }

    public List<Cocktail> findAll(){
        List<CocktailEntity> cocktail = cocktailRepository.findAll();
        return cocktail.stream()
                .map(cocktailEntity -> new Cocktail(
                        cocktailEntity.getId(),
                        cocktailEntity.getRezept(),
                        cocktailEntity.getName(),
                        cocktailEntity.getZutaten(),
                        cocktailEntity.getTags())
                ).collect(Collectors.toList());

    }

    public Cocktail create(CocktailCreate cocktailCreate){
        var cocktailEntity = new CocktailEntity(cocktailCreate.getRezept(), cocktailCreate.getName(), cocktailCreate.getZutaten(),cocktailCreate.getTags());
        cocktailEntity = cocktailRepository.save(cocktailEntity);
        return transformEntity(cocktailEntity);
    }

    private Cocktail transformEntity(CocktailEntity cocktailEntity){
        return new Cocktail(
                cocktailEntity.getId(),
                cocktailEntity.getRezept(),
                cocktailEntity.getName(),
                cocktailEntity.getZutaten(),
                cocktailEntity.getTags());
    }

    public Cocktail findById(Long id){
        var cocktailEntity = cocktailRepository.findById(id);
        return cocktailEntity.isPresent()? transformEntity(cocktailEntity.get()) : null;
    }

    public Cocktail update(Long id, CocktailCreate cocktailCreate){
        var cocktailEntityOptional = cocktailRepository.findById(id);
        if(cocktailEntityOptional.isEmpty()){
            return null;
        }
        var cocktailEntity = cocktailEntityOptional.get();
        cocktailEntity.setName(cocktailCreate.getName());
        cocktailEntity.setRezept(cocktailCreate.getRezept());
        cocktailEntity.setZutaten(cocktailCreate.getZutaten());
        cocktailEntity.setTags(cocktailCreate.getTags());
        cocktailRepository.save(cocktailEntity);

        return transformEntity(cocktailEntity);
    }

    public boolean deleteById(Long id){
        if(!cocktailRepository.existsById(id)){
            return false;
        }

        cocktailRepository.deleteById(id);
        return true;
    }
}
