package fallfin.service;

public class Validation {

    /* entrega cantidad multiple de 6, se venden cajas cerradas*/
    public static Integer getQuantityBeerOK(Integer quantity){

        Integer mod6 = quantity % 6;
        return ( quantity + (6-mod6) );
    }
}
