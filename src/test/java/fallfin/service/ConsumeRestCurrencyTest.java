package fallfin.service;

import org.junit.Test;

public class ConsumeRestCurrencyTest {

    @Test
    public void convertCurrency() {
        //BeerDAO beerDao;
        ConsumeRestCurrencyMock.convertCurrency("CLP","USD", 50.00);
        //assertEquals(0, list.size());
    }

}
