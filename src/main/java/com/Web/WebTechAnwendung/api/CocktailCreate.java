package com.Web.WebTechAnwendung.api;


import java.util.List;

public class CocktailCreate {

    private String rezept;
    private String name;
    private List<String> zutaten;

    public CocktailCreate(String rezept, String name, List<String> zutaten) {
        this.rezept = rezept;
        this.name = name;
        this.zutaten = zutaten;
    }

    public String getRezept() {
        return rezept;
    }

    public void setRezept(String rezept) {
            this.rezept = rezept;
    }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public List<String> getZutaten() { return zutaten; }

    public void setZutaten(List<String> zutaten) { this.zutaten = zutaten; }
}
