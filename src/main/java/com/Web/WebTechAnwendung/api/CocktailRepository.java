package com.Web.WebTechAnwendung.api;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CocktailRepository extends CrudRepository<Cocktail, Long> { }
