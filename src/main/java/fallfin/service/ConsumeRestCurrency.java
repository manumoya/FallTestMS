package fallfin.service;

import org.json.JSONObject;
import org.springframework.web.client.RestTemplate;

public class ConsumeRestCurrency {

    /*
    public ConsumeRestCurrency() {
    }
    */

    public static void getCurrency(String currBeerCode, String currBuyCode, Double monto) {
        String uri =  "http://www.apilayer.net/api/convert?" +
                    "access_key=d4cbcd1348c05f9682ba114108106061" +
                    "&from="+ currBeerCode +
                    "&to=" + currBuyCode +
                    "&amount=" + monto +
                    "&format=1";

        System.out.println(uri);

        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(uri, String.class);

        System.out.println(result);

        JSONObject obj = new JSONObject(result);
        //Integer currencyPay = obj.getJSONObject("quotes").getInt("USDUSD");

       // System.out.println(currencyPay);

    }
}
