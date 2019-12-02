package fallfin.dao;

import fallfin.module.BeerBox;
import fallfin.module.BeerItem;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;


public class BeerBoxDAOTest {
    @Test
    public void findAll() {
        BeerBoxDAOImpl beerBoxDao = new BeerBoxDAOImpl();
        List<BeerItem> list = beerBoxDao.findAll();
        assertEquals(0, list.size());
    }

    @Test
    public void save() {

        BeerBox beerBox = new BeerBox(3000.00);
        BeerItem beer = new BeerItem(0, "pilsen", "ARTOR", "Chile", 1000.00, "CLP", beerBox);

        BeerBoxDAOImpl beerBoxDao = new BeerBoxDAOImpl();
        beerBoxDao.save(beer);
        List<BeerItem> beers = beerBoxDao.findAll();
        assertEquals(1,beers.size());


    }
}
