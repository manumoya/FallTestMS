package fallfin.service;

import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.*;

public class ConsumeRestCurrencyMock {

    /*
    public ConsumeRestCurrency() {
    }
    */

    public static Double convertCurrency(String currBeerCode, String currBuyCode, Double monto) {

        /*
        String uri =  "http://www.apilayer.net/api/convert?" +
                    "access_key=d4cbcd1348c05f9682ba114108106061" +
                    "&from="+ currBeerCode +
                    "&to=" + currBuyCode +
                    "&amount=" + monto +
                    "&format=1";

        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(uri, String.class);
        System.out.println(result);

        //JSONTokener tokener = new JSONTokener(is);
        //JSONObject obj = new JSONObject(tokener);
        //Integer currencyPay = obj.getJSONObject("quotes").getInt("USDUSD");

        */

        Double dolar = 819.0;

        System.out.println(monto * dolar);
        return monto * dolar;

    }
}
