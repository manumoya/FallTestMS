package fallfin.dao;

import fallfin.module.BeerBox;
import fallfin.module.BeerItem;

import java.util.ArrayList;
import java.util.List;

public class BeerDAOImpl implements IBeerDAO {

    private static List<BeerItem> beers = new ArrayList();

    /* Busca todas las cervezas */
    public List<BeerItem> findAll(){
        return beers;
    }

    /* graba una cerveza */
    public int save (BeerItem beer){
        Integer id = findAll().size()+1;
        beer.setId(id);
        beers.add(beer);
        return id;
    }

}
