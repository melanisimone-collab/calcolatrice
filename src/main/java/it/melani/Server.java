package it.melani;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) {
        
        try{
            ServerSocket serverSocket = new ServerSocket(12345);
            System.out.println("il server è in ascolto");
            Socket client = serverSocket.accept();
            System.out.println("Il client si è connesso"+ client.getInetAddress());
            BufferedReader input = new BufferedReader(
                    new InputStreamReader(client.getInputStream())
                );
            double n1 = Double.parseDouble(input.readLine());

            String operatore = input.readLine();

            double n2 = Double.parseDouble(input.readLine());
            System.out.println("il calcolo da fare è "+n1+operatore+n2);
            
        } catch (IOException e) {
            e.getMessage();
        }

    }

}
