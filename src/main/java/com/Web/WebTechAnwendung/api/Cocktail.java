package com.Web.WebTechAnwendung.api;

public class Cocktail {

    private long id;
    private String rezept;
    private String name;
    private String zutaten;

    public Cocktail(long id, String rezept, String name, String zutaten) {
        this.id = id;
        this.rezept = rezept;
        this.name = name;
        this.zutaten = zutaten;
    }

    public String getRezept() { return rezept; }

    public void setRezept(String rezept) { this.rezept = rezept; }

    public long getId() {return id;}

    public void setId(long id) {this.id = id;}

    public String getZutaten() { return zutaten; }

    public void setZutaten(String zutaten) { this.zutaten = zutaten; }

    public String getName() { return name; }

    public void setName(String name) {
        this.name = name;
    }
}
