package fallfin.module;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class BeerItem {
    private Integer id;

    @NotNull(message="Name: es obligatorio")
    @Size(min=2, message="Name: debe se de al menos en 2 caracteres")
    private String name;

    private String brewery;
    private String country;

    private Double price;

    @Size(min=3, max=3, message="currency: debe ser de 3 caracteres")
    private String currency;

    public BeerItem(){
    }

    public BeerItem(Integer id, String name, String brewery, String country, Double price, String currency){
        setId(id);
        setName(name);
        setBrewery(brewery);
        setCountry(country);
        setPrice(price);
        setCurrency(currency);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrewery() {
        return brewery;
    }

    public void setBrewery(String brewery) {
        this.brewery = brewery;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}
