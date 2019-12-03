package fallfin.model;

public class BeerBoxBuy {

    private String currency;
    private Integer quantity =6;

    public BeerBoxBuy(){

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

    public void setQuanty(Integer quantity) {
        this.quantity = quantity;
    }
}
