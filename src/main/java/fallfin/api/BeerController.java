package fallfin.api;

import fallfin.dao.BeerDAOImpl;
import fallfin.module.BeerItem;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BeerController {

    /* Bienvenido */
    @RequestMapping("/")
    public String index() {
        return "Gracias por llegar a la API de Manuel Moya para FallFin";
    }


    /* POST => Grabar cerveza */
    @PostMapping("/beers")
    public BeerItem addBeers(@RequestBody BeerItem beer) {

        BeerDAOImpl beerDao = new BeerDAOImpl();

        int id = beerDao.save(beer);
        beer.setId(id);
        return beer;

    }

}
