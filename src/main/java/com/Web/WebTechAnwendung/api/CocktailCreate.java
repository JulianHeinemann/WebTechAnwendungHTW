package com.Web.WebTechAnwendung.api;


public class CocktailCreate {

    private String rezept;
    private String name;
    private String zutaten;
    private String tags;

    public CocktailCreate(String rezept, String name, String zutaten, String tags) {
        this.rezept = rezept;
        this.name = name;
        this.zutaten = zutaten;
        this.tags = tags;
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

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }
}
