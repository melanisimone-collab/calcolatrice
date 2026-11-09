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
        while (!scanner.hasNextDouble()) { 
            System.out.println("inserire un numero");
            scanner.next();
        }
        Double n1= scanner.nextDouble();
        output.println(n1);

        String operatore;
        do {
            System.out.println("inserisci l'operatore");
            operatore= scanner.next();
        } while (!operatore.equals("+") &&!operatore.equals("-")&& !operatore.equals("*") && !operatore.equals("/"));
        
        output.println(operatore);

        System.out.println("inserisci il secondo operando");
        double n2;
        do {
            while (!scanner.hasNextDouble()) {
                System.out.println("Devi inserire un numero!");
                scanner.next();
            }
            n2 = scanner.nextDouble();
            if (operatore.equals("/") && n2 == 0) {
                System.out.println("Non si può dividere per 0, inserisci un altro numero");
            }
        } while (operatore.equals("/") && n2 == 0);

        output.println(n2);

        BufferedReader input = new BufferedReader(
                new InputStreamReader(socket.getInputStream())
            );
        String risultato= input.readLine();
        System.out.println("il risultato è "+ risultato);


    } catch (IOException e) {
        e.getMessage();
    }

    }

}
