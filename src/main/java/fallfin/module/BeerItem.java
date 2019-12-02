package fallfin.module;

public class BeerItem {
    private Integer id;
    private String name;
    private String brewery;
    private String country;
    private Double price;
    private String currency;
    private final Integer quantity = 6;

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

    public Integer getQuantity() {
        return quantity;
    }

}
