package fr.smeal.subscription.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

public class NetworkUtil {

    private static NetworkUtil instance = new NetworkUtil();

    private NetworkUtil(){}

    public static NetworkUtil getInstance() {
        if (NetworkUtil.instance == null) {
            instance = new NetworkUtil();
        }
        return instance;
    }

    // HTTP GET request
    public static String sendGet(String url) throws Exception {
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();

        // optional default is GET
        con.setRequestMethod("GET");

        int responseCode = con.getResponseCode();
        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        return response.toString();
    }


    // HTTP PUT request
    public static String sendPut(String url, String data) throws Exception {
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();

        // optional default is PUT
        con.setRequestMethod("PUT");

        int responseCode = con.getResponseCode();
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(con.getOutputStream()));
        String outputLine;
        StringBuffer response = new StringBuffer();
        out.write(data);
        out.close();
        return response.toString();
    }
}
