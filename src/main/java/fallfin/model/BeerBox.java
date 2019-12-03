package fallfin.model;

import java.math.BigDecimal;

public class BeerBox {

    private BigDecimal priceTotal;

    public BeerBox(){
    }

    public BeerBox( BigDecimal priceTotal){
        setPriceTotal(priceTotal);
    }

    public BigDecimal getPriceTotal() {
        return priceTotal;
    }

    public void setPriceTotal(BigDecimal priceTotal) {
        this.priceTotal = priceTotal;
    }
}
