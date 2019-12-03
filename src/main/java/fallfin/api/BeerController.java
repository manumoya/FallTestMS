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
    public ResponseEntity<String> addBeers(@RequestBody BeerItem beer) {

        String msgOut ="Request inválida";
        HttpStatus statusHttp = HttpStatus.BAD_REQUEST; // 400;

        BeerItem beerFound = BeerDAO.get( beer.getId() );

        /* Cerveza no encontrada, graba cerveza */
        if (beerFound.getId() == null){
            int id = BeerDAO.save(beer);
            msgOut ="Cerveza creada";
            statusHttp = HttpStatus.CREATED; // 201
        }else{
            msgOut ="El ID "+ beer.getId() +" de la cerveza ya existe";
            statusHttp = HttpStatus.CONFLICT; //409
        }

        return new ResponseEntity<String>(msgOut, statusHttp);

    }

}
