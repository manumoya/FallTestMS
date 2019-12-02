package fallfin.dao;

import fallfin.module.BeerBox;

import java.util.List;

/* Interfaz DAO */
public interface IBeerBoxDAO {

    List<BeerBox> findAll();
    int save (BeerBox beerBox);
}
