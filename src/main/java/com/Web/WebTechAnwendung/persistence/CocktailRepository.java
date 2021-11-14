package com.Web.WebTechAnwendung.persistence;

import com.Web.WebTechAnwendung.api.Cocktail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CocktailRepository extends JpaRepository<CocktailEntity, Long> {

    List<CocktailEntity> findAllById(Long id);
}
