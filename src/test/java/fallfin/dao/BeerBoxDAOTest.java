package fallfin.dao;

import fallfin.module.BeerBox;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;


public class BeerBoxDAOTest {
    @Test
    public void findAll() {

        BeerBoxDAO beerBoxDao = new BeerBoxDAO();
        List<BeerBox> list = beerBoxDao.findAll();
        assertEquals(0, list.size());

        /*
        Persona persona = new Persona(0,"manu", "moya", "rgua", 999, "red");
        int id = PersonaInfoDAO.save(persona);

        List<Persona> list2 = PersonaInfoDAO.findAll();
        assertEquals(1,list2.size());
         */

    }

    @Test
    public void save() {
    }
}
