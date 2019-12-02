package fallfin.module;

public class BeerBox {
    private BeerItem beerItem;
    private Double priceTotal;

    public BeerBox(BeerItem beerItem, Double priceTotal){
        setBeerItem(beerItem);
        setPriceTotal(priceTotal);
    }

    public BeerItem getBeerItem() {
        return beerItem;
    }

    public void setBeerItem(BeerItem beerItem) {
        this.beerItem = beerItem;
    }

    public Double getPriceTotal() {
        return priceTotal;
    }

    public void setPriceTotal(Double priceTotal) {
        this.priceTotal = priceTotal;
    }
}
