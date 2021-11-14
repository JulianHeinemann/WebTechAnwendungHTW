package com.Web.WebTechAnwendung.persistence;

import javax.persistence.*;

@Entity(name = "cocktail")
public class CocktailEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Long id;

    @Column(name = "Zutat1")
    private String zutat1;

    @Column(name = "Name")
    private String name;

    public CocktailEntity( String zutat1, String name) {
        this.zutat1 = zutat1;
        this.name = name;
    }

    protected CocktailEntity() {}

    public Long getId() {
        return id;
    }

    public String getZutat1() {
        return zutat1;
    }

    public void setZutat1(String zutat1) {
        this.zutat1 = zutat1;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
