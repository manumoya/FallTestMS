package fallfin.dao;

import fallfin.module.BeerBox;
import fallfin.module.BeerItem;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;


public class BeerBoxDAOTest {
    @Test
    public void findAll() {
        BeerBoxDAO beerBoxDao = new BeerBoxDAO();
        List<BeerBox> list = beerBoxDao.findAll();
        assertEquals(0, list.size());
    }

    @Test
    public void save() {
        BeerItem beer = new BeerItem(0, "pilsen", "ARTOR", "Chile", 1000.00, "CLP");
        BeerBox beerBox = new BeerBox(beer, 3000.00);

        BeerBoxDAO beerBoxDao = new BeerBoxDAO();
        beerBoxDao.save(beerBox);
        List<BeerBox> beers = beerBoxDao.findAll();
        assertEquals(1,beers.size());


        /*
        int id = PersonaInfoDAO.save(persona);

        List<Persona> list2 = PersonaInfoDAO.findAll();
        assertEquals(1,list2.size());
        */
    }
}
