package com.Web.WebTechAnwendung.persistence;

import javax.persistence.*;

@Entity(name = "cocktail")
public class CocktailEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "rezept")
    private String rezept;

    @Column(name = "name")
    private String name;

    @Column(name = "zutaten")
    private String zutaten;

    @Column(name = "tags")
    private String tags;

    public CocktailEntity(String rezept, String name, String zutaten, String tags) {
        this.rezept = rezept;
        this.name = name;
        this.zutaten = zutaten;
        this.tags = tags;
    }

    protected CocktailEntity() {}

    public Long getId() {
        return id;
    }

    public String getRezept() { return rezept; }

    public void setRezept(String rezept) {this.rezept = rezept;}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getZutaten() { return zutaten; }

    public void setZutaten(String zutaten) { this.zutaten = zutaten; }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }
}
