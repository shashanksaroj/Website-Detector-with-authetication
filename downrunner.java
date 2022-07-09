package com.shashank.main;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class downrunner {


    public static void main(String args[]) throws Exception {

    String url ="https://www.google.com";


        try {
            URL urlObj = new URL(url);
            HttpURLConnection connection = (HttpURLConnection) urlObj.openConnection();
            connection.setRequestMethod("GET");
            String auth = "user" + ":" + "password";/
            String basicAuth = "Basic " + new String(Base64.getEncoder().encode(auth.getBytes()));

            connection.setRequestProperty("Authorization", basicAuth);
            // Set connection timeout
            connection.setConnectTimeout(3000);
            connection.connect();

            int code = connection.getResponseCode();
            if (code == 200) {
                System.out.println("website is up");
            }
        } catch (Exception e) {
            System.out.println("website is down");
        }

    }




}
