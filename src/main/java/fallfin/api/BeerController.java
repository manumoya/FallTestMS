package fallfin.api;

import fallfin.dao.BeerDAO;
import fallfin.module.BeerItem;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<BeerItem> addBeers(@RequestBody BeerItem beer) {

        int id = BeerDAO.save(beer);
        //beer.setId(id);
        //return beer;
        return new ResponseEntity<BeerItem>(beer, HttpStatus.CREATED);

    }

}
