package com.example;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

public class HmacExample {
    public static void main(String[] args) {
        try {
            // Chiave e messaggio dall'esempio Python
            String keyString = "qnscAdgRlkIhAUPY44oiexBKtQbGY0orf7OV1I50";
            String message = "foo";
            
            // Creazione della chiave con specifica dell'algoritmo HmacSHA1
            SecretKeySpec key = new SecretKeySpec(keyString.getBytes("UTF-8"), "HmacSHA1");
            
            // Creazione e inizializzazione del Mac
            Mac mac = Mac.getInstance("HmacSHA1");
            mac.init(key);
            
            // Calcolo dell'HMAC
            byte[] bytes = mac.doFinal(message.getBytes("UTF-8"));
            
            // Codifica del risultato in Base64
            String result = Base64.getEncoder().encodeToString(bytes);
            
            // Stampa del risultato
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
