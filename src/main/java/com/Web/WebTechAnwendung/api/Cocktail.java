package com.Web.WebTechAnwendung.api;

public class Cocktail {

    private long id;
    private String rezept;
    private String name;
    private String zutaten;
    private String tags;

    public Cocktail(long id, String rezept, String name, String zutaten, String tags) {
        this.id = id;
        this.rezept = rezept;
        this.name = name;
        this.zutaten = zutaten;
        this.tags = tags;
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

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }
}
