package com.Web.WebTechAnwendung.persistence;

import javax.persistence.*;

@Entity(name = "cocktail")
public class CocktailEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Long id;

    @Column(name = "Zutat 1", nullable = false)
    private String zutat1;

    @Column(name = "Name", nullable = false)
    private String name;

    public CocktailEntity(Long id, String zutat1, String name) {
        this.id = id;
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
