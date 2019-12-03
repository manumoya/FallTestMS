package fallfin.service;

import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.*;
import java.math.BigDecimal;
import java.text.DecimalFormat;

public class ConsumeRestCurrencyMock {

    public static BigDecimal convertCurrency(String currBeerCode, String currBuyCode, Double monto) {

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

        /* Formate numero */
        DecimalFormat df = new DecimalFormat("#######0.##");
        System.out.println(df.format(monto * dolar));

        /* genera valor final */
        BigDecimal montoFinal  = new BigDecimal(df.format(monto * dolar));

        return ( montoFinal );



    }
}
