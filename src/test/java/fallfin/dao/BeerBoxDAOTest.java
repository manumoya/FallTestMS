package fallfin.dao;

import fallfin.module.BeerBox;
import fallfin.module.BeerItem;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;


public class BeerBoxDAOTest {
    @Test
    public void findAll() {
        BeerDAOImpl beerDao = new BeerDAOImpl();
        List<BeerItem> list = beerDao.findAll();
        assertEquals(0, list.size());
    }

    @Test
    public void save() {

        BeerItem beer = new BeerItem(0, "pilsen", "ARTOR", "Chile", 1000.00, "CLP");
        BeerItem beer2 = new BeerItem(0, "pilsen2", "ARTOR2", "Chile2", 1000.00, "CLP");

        BeerDAOImpl beerDao = new BeerDAOImpl();
        beerDao.save(beer);
        List<BeerItem> beers = beerDao.findAll();
        assertEquals(1,beers.size());
        beerDao.save(beer);
        assertEquals(2,beers.size());

    }
}
