package com.example;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Server in avvio!" );
        
        try {

            ServerSocket server = new ServerSocket(3000);
            Socket s = server.accept();
            
            System.out.println("client collegato");

            BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
            DataOutputStream out = new DataOutputStream(s.getOutputStream());

            String stringaRicevuta = in.readLine();

            System.out.println("String ottenuta");

            String stringaMaiuscola = stringaRicevuta.toUpperCase();

            out.writeBytes(stringaMaiuscola);

            s.close();
            server.close();

        } catch (Exception e) {
            // TODO: handle exception
        }
        
    }


}
