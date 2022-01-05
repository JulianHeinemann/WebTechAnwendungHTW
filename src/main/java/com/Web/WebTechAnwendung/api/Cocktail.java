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
    private String rezept;
    private String name;
    private String zutaten;

    public Cocktail(long id, String inputRezept, String name, String zutaten) {
        this.id = id;
        this.rezept = inputRezept;
        this.name = name;
        this.zutaten = zutaten;
    }

    public Cocktail() {

    }

    public String getRezept() { return rezept; }

    public void setRezept(String rezept) { this.rezept = rezept; }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getZutaten() { return zutaten; }

    public void setZutaten(String zutaten) { this.zutaten = zutaten; }

    public String getName() { return name; }

    public void setName(String name) {
        this.name = name;
    }
}
