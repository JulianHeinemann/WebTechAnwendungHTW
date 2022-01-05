package com.Web.WebTechAnwendung.persistence;

import javax.persistence.*;
import java.util.List;

@Entity(name = "cocktail")
public class CocktailEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Long id;

    @Column(name = "Rezept")
    private String rezept;

    @Column(name = "Name")
    private String name;

    @Column(name = "Zutaten")
    private String zutaten;

    public CocktailEntity(String rezept, String name, List<String> zutatenliste) {
        this.rezept = rezept;
        this.name = name;
        this.zutaten = zutatenliste.toString();
    }

    protected CocktailEntity() {}

    public Long getId() {
        return id;
    }

    public String getRezept() { return rezept; }

    public void setRezept(String zutat1) {
        this.rezept = zutat1;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getZutaten() { return zutaten; }

    public void setZutaten(String zutaten) { this.zutaten = zutaten; }
}
