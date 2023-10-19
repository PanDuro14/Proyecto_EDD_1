package ahorcado;

import java.util.Scanner;

public class Jugador1 {
    private String palabra;

    public Jugador1(){
        Scanner lee = new Scanner(System.in);
        System.out.println("Jugador 1, escoge la palabra:");
        palabra = lee.nextLine();
    }

    public String getPalabra(){
        return palabra;
    }
}
