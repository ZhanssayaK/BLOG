package kz.bitlab.javapro.model;

public class Item {

    private Long id;
    private String name;
    private String description;
    private int price;
    private Country country;

    public Item() {
    }

    public Item(Long id, String name, String description, int price) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
    }
    public Item(Long id, String name, String description, int price, Country country) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.country = country;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }
}
