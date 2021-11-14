package com.Web.WebTechAnwendung.service;

import com.Web.WebTechAnwendung.api.Cocktail;
import com.Web.WebTechAnwendung.api.CocktailCreat;
import com.Web.WebTechAnwendung.persistence.CocktailEntity;
import com.Web.WebTechAnwendung.persistence.CocktailRepository;
import com.Web.WebTechAnwendung.api.CocktailRestController;
import org.springframework.beans.factory.annotation.Autowired;
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
                        cocktailEntity.getZutat1(),
                        cocktailEntity.getName())
                )
                .collect(Collectors.toList());

    }

    public Cocktail create(CocktailCreat cocktailCreat){
        var cocktailEntity = new CocktailEntity(cocktailCreat.getZutat1(),cocktailCreat.getName());
        cocktailEntity = cocktailRepository.save(cocktailEntity);
        return transformEntity(cocktailEntity);
    }

    private Cocktail transformEntity(CocktailEntity cocktailEntity){
        return new Cocktail(
                cocktailEntity.getId(),
                cocktailEntity.getZutat1(),
                cocktailEntity.getName());
    }

    public Cocktail findById(Long id){
        var cocktailEntity = cocktailRepository.findById(id);
        return cocktailEntity.isPresent()? transformEntity(cocktailEntity.get()) : null;
    }

    public Cocktail update(Long id, CocktailCreat cocktailCreat){
        var cocktailEntityOptional = cocktailRepository.findById(id);
        if(cocktailEntityOptional.isEmpty()){
            return null;
        }
        var cocktailEntity = cocktailEntityOptional.get();
        cocktailEntity.setName(cocktailCreat.getName());
        cocktailEntity.setZutat1(cocktailCreat.getZutat1());
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
