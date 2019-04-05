package fr.smeal.subscription.util;

public class ParameterUtil {
    // String url = "https://www.smeal.fr/api/carts/" + cartId + "?ws_key=9IY4WY4Z4W12C5B4K38CC2X7G8NGGEK2";
    private static String smealServer =  "http://54.38.189.20/prestashop";
    private static String smealServerApiKey = "QAAKISDBV7ZC6LP9QMYIK4NZFSKA8AVB";
    public static String stripApiKey = "sk_test_xV8hH1378GxwxL8MAGOpzxN3";


    /**
     * @param utlToReceive: /carts, /carts/8
     * @return
     */
    public static String getSmealApiUrl(String utlToReceive) {
        return smealServer + "/api" + utlToReceive + "?ws_key=" + smealServerApiKey;
    }
}
