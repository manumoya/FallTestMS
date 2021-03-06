package fallfin.dao;

import fallfin.model.BeerItem;

import java.util.ArrayList;
import java.util.List;

public class BeerDAO {

    private static List<BeerItem> beers = new ArrayList();

    /* Busca todas las cervezas */
    public static List<BeerItem> findAll(){
        return beers;
    }

    /* graba una cerveza */
    public static Integer save (BeerItem beer){
        //Integer id = findAll().size()+1;
        //beer.setId(id);
        beers.add(beer);
        return beer.getId();
    }

    /* Obtener una cerveza según ID */
    public static BeerItem get(Integer idBeer){
        BeerItem beerFound = new BeerItem();
        for (BeerItem beerItem : beers) {
            if (idBeer == beerItem.getId()) {
                beerFound = beerItem;
            }
        }
        return beerFound;
    }





}
