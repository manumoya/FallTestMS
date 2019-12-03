package fallfin.service;

import org.junit.Test;

import java.math.BigDecimal;

public class ConsumeRestCurrencyTest {

    @Test
    public void convertCurrency() {
        //BeerDAO beerDao;
        BigDecimal num = ConsumeRestCurrencyMock.convertCurrency("CLP","USD", 120000.13);
        // BigDecimal bd = new BigDecimal(num);
        System.out.println( num );


        //assertEquals(0, list.size());
    }

}
