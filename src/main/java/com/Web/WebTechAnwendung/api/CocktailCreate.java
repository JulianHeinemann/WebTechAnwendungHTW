package com.Web.WebTechAnwendung.api;


public class CocktailCreate {

    private String rezept;
    private String name;
    private String zutaten;

    public CocktailCreate(String rezept, String name, String zutaten) {
        this.rezept = rezept;
        this.name = name;
        this.zutaten = zutaten;
    }
    protected CocktailCreate(){

    }

    public String getRezept() {
        return rezept;
    }

    public void setRezept(String rezept) {
            this.rezept = rezept;
    }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getZutaten() { return zutaten; }

    public void setZutaten(String zutaten) { this.zutaten = zutaten; }
}
