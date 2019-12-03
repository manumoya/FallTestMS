package fallfin.dao;

import fallfin.module.BeerItem;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;


public class BeerBoxDAOTest {
    @Test
    public void findAll() {
        //BeerDAO beerDao;
        List<BeerItem> list = BeerDAO.findAll();
        assertEquals(0, list.size());
    }

    @Test
    public void get() {
        BeerItem beer = new BeerItem(3, "pilsener", "ARTOR", "Chile", 1000.00, "CLP");
        BeerDAO.save(beer);
        BeerItem beerFound = BeerDAO.get(3);
        assertEquals("pilsener", beerFound.getName());
    }

    @Test
    public void save() {

        BeerItem beer = new BeerItem(1, "pilsen", "ARTOR", "Chile", 1000.00, "CLP");
        BeerItem beer2 = new BeerItem(2, "pilsen2", "ARTOR2", "Chile2", 1000.00, "CLP");

        //BeerDAO beerDao;
        BeerDAO.save(beer);
        List<BeerItem> beers = BeerDAO.findAll();
        assertEquals(2,beers.size());
        BeerDAO.save(beer);
        assertEquals(3,beers.size());

    }




}
