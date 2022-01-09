package com.Web.WebTechAnwendung.api;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class CocktailCreate {

    @Size(min = 20,max = 800, message = "Beschreibe wie der Cocktail gemacht werden soll. Min. 20 Zeichen.")
    private String rezept;
    @Size(min = 3 ,max = 30, message = "Bitte gib dem Cocktail einen Namen")
    private String name;
    @Size(min = 5, message = "Der Cocktail braucht mindestens eine Zutat")
    private String zutaten;

    @Pattern(
            regexp = "VODKA|RUM|KORN|WHISKEY|SÜß|SAUER|HERB|FRUCHTIG|STARK|MITTEL|LEICHT",
            message = "bitte gib dem Cocktail einen Tag VODKA|RUM|KORN|WHISKEY|SÜß|SAUER|HERB|FRUCHTIG|STARK|MITTEL oder LEICHT"
    )
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
