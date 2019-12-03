package fallfin.service;

public class Validation {

    /* Entrega cantidad multiple de 6, se venden cajas cerradas*/
    public static Integer getQuantityBeerOK(Integer quantity){

        Integer mod6 = quantity % 6;
        if (mod6>0){
            return ( quantity + (6-mod6) );
        }else{
            return quantity;
        }

    }
}
