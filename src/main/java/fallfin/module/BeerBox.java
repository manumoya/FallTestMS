package fallfin.module;

public class BeerBox {

    private Double priceTotal;

    public BeerBox( Double priceTotal){
        setPriceTotal(priceTotal);
    }

    public Double getPriceTotal() {
        return priceTotal;
    }

    public void setPriceTotal(Double priceTotal) {
        this.priceTotal = priceTotal;
    }
}
