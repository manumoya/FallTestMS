package fallfin.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BeerController {

    /* Bienvenido */
    @RequestMapping("/")
    public String index() {
        return "Gracias por llegar a la API de Manuel Moya para FallFin";
    }


}
