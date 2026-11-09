package it.melani;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;


public class Client {

    public static void main(String[] args) {
        
       try {
        Socket socket = new Socket("localhost", 12345);
        Scanner scanner= new Scanner(System.in);
        PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
        System.out.println("ti sei connesso al server");

        System.out.println("inserisci il primo operando");
        Double n1= scanner.nextDouble();
        output.println(n1);

        String operatore;
        do {
            System.out.println("inserisci l'operatore");
            operatore= scanner.next();
        } while (!operatore.equals("+") &&!operatore.equals("-")&& !operatore.equals("*") && !operatore.equals("/"));
        
        output.println(operatore);

        System.out.println("inserisci il secondo operando");
        Double n2= scanner.nextDouble();
        output.println(n2);


    } catch (IOException e) {
        e.getMessage();
    }

    }

}
