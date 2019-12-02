package fallfin.dao;

import fallfin.module.BeerBox;

import java.util.ArrayList;
import java.util.List;

public class BeerBoxDAO {

    private List<BeerBox> beersBox = new ArrayList();

    /* Busca todas las cervezas */
    public List<BeerBox> findAll(){
        return beersBox;
    }

    /* graba una cerveza */
    public int save (BeerBox beerBox){
        Integer id = findAll().size()+1;
        beerBox.getBeerItem().setId(id);
        beersBox.add(beerBox);
        return id;
    }

}
