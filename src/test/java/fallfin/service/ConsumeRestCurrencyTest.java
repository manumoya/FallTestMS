package fallfin.service;

import org.junit.Test;

public class ConsumeRestCurrencyTest {

    @Test
    public void getCurrency() {
        //BeerDAO beerDao;
        ConsumeRestCurrency.getCurrency("CLP","USD", 50.00);
        //assertEquals(0, list.size());
    }

}
