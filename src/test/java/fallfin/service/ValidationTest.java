package fallfin.service;

import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class ValidationTest {

    @Test
    public void getQuantityBeerOK() {
        Integer valor = Validation.getQuantityBeerOK(8);
        assertEquals(Double.valueOf(12), Double.valueOf(valor));

         valor = Validation.getQuantityBeerOK(6);
        assertEquals(Double.valueOf(6), Double.valueOf(valor));


    }
}
