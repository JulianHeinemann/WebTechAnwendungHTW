package com.Web.WebTechAnwendung.api;


import java.util.List;

public class CocktailCreate {

    private String zutat1;
    private String name;

    public CocktailCreate(String zutat1, String name) {
        this.zutat1 = zutat1;
        this.name = name;
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
