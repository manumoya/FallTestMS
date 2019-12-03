package fallfin.api;

import fallfin.dao.BeerDAO;
import fallfin.module.BeerBox;
import fallfin.module.BeerBoxBuy;
import fallfin.module.BeerItem;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BeerBoxController {

    /* GET => Buscar BOX Price */
    @GetMapping("/beers/{beerID}/boxprice")
    public ResponseEntity<BeerBox> searchBeerById(@PathVariable Integer beerID, @RequestBody BeerBoxBuy beerBoxBuy){
        try {
            BeerItem beerFound = BeerDAO.get( beerID );
            BeerBox beerBox = new BeerBox(1243.89);
            if(beerFound.getId() != null) { // Se encontró
                return new ResponseEntity<BeerBox>(beerBox, HttpStatus.OK); // Code 200
            }else{
                return new ResponseEntity<BeerBox>(beerBox, HttpStatus.NOT_FOUND); // Code 404
            }
        }catch( Exception e){
            return new ResponseEntity<BeerBox>(new BeerBox(), HttpStatus.BAD_REQUEST); // Code 400
        }
    }

}
