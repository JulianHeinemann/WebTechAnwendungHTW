package com.Web.WebTechAnwendung.api;

import javax.annotation.processing.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;
import com.Web.WebTechAnwendung.service.CocktailService;
import java.util.Set;

@Entity
public class Cocktail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String zutat1;
    private String name;

    public Cocktail(long id, String zutat1, String name) {
        this.id = id;
        this.zutat1 = zutat1;
        this.name = name;
    }

    public Cocktail() {

    }
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getZutaten() {
        return zutat1;
    }

    public void setZutaten(String zutat1) {
        this.zutat1 = zutat1;
    }

    public String getName() { return name; }

    public void setName(String name) {
        this.name = name;
    }
}
