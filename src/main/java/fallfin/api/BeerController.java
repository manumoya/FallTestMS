package fallfin.api;

import fallfin.dao.BeerDAO;
import fallfin.module.BeerItem;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
public class BeerController {

    /* Bienvenido */
    @RequestMapping("/")
    public String index() {
        return "Gracias por llegar a la API de Manuel Moya para FallFin";
    }


    /* POST => Ingresa una nueva cerveza */
    @PostMapping("/beers")
    public ResponseEntity<String> addBeers(@RequestBody BeerItem beer) {

        try {
            BeerItem beerFound = BeerDAO.get( beer.getId() );
            if (beerFound.getId() == null){ // Cerveza creada
                int id = BeerDAO.save(beer);
                return new ResponseEntity<String>("Cerveza creada", HttpStatus.CREATED); // Code 201
            }else{ // La cerveza ya existe
                return new ResponseEntity<String>("El ID "+ beer.getId() +" de la cerveza ya existe", HttpStatus.CONFLICT); // Code 409
            }
        }catch(Exception e){
            return new ResponseEntity<String>("Request inválida", HttpStatus.BAD_REQUEST); // Code 400
        }

    }

    /* GET => Buscar Cerveza por ID */
    @GetMapping("/beers/{beerID}")
    public ResponseEntity<String> searchBeerById(@PathVariable Integer beerID){
        String msgOut ="El Id de la cerveza no existe";
        HttpStatus statusHttp = HttpStatus.NOT_FOUND; // 404;
        BeerItem beerFound = BeerDAO.get( beerID );

        if(beerFound.getId() != null) {
            msgOut ="Operacion exitosa";
            statusHttp = HttpStatus.OK; // 200;

            URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                    .path("/components/schemas/BeerItem")
                    .buildAndExpand()
                    .toUri();

            HttpHeaders headers = new HttpHeaders();
            headers.setLocation(location);

            return new ResponseEntity<String>(msgOut, headers,  statusHttp);
        }

        return new ResponseEntity<String>(msgOut, statusHttp);
    }

    /* GET => Buscar Beer Item Schema */
    @GetMapping("/beers/{beerID}/components/schemas/BeerItem")
    public BeerItem getBeerItemSchema(@PathVariable Integer beerID){

        BeerItem beerFound = BeerDAO.get( beerID );

        if(beerFound.getId() == null) {
            throw new RuntimeException("Cerveza ID no encontrada - " + beerID);
        }

        return beerFound;
    }


}
