package ahorcado;

import java.util.Queue;
import java.util.LinkedList;
import java.util.Stack;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner lee = new Scanner(System.in);
        Queue<Character> letrasAdivinadas = new LinkedList<>();
        Stack<Character> letrasJugador2 = new Stack<>();
        var res = "";
        int i = 0;
        String[] palabras = new String[10]; // Arreglo para almacenar las palabras

        System.out.println("<<-- Juego del Ahorcado -->>");

        do {
            // Jugador 1
            Jugador1 jugador1 = new Jugador1();
            palabras[i] = jugador1.getPalabra();
            i++;

            // Fin Jugador 1
            //Jugador 2
            System.out.println(" ");
            System.out.println("Jugador 2, adivina la palabra:");
            String palabraSecreta = palabras[i - 1];
            // Cambiar la palabra completa por secciones para la valicación de sus caracteres
            char[] palabraSecretaArray = palabraSecreta.toCharArray(); 
            // Seccionar los caracteres
            char[] palabraAdivinadaArray = new char[palabraSecretaArray.length];
            // Variable para validar el intento
            boolean adivinada = false;

            //Intentos 
            System.out.println(" ");
            for (int intentos = 1; intentos <= 5; intentos++) {
                System.out.print("Intento " + intentos + ": ");
                char intento = lee.nextLine().charAt(0);

                // Proceso de valicación
                boolean letraEncontrada = false;
                for (int j = 0; j < palabraSecretaArray.length; j++) {
                    if (palabraSecretaArray[j] == intento) {
                        palabraAdivinadaArray[j] = intento;
                        letraEncontrada = true;
                    }
                }

                // En caso de que la validación sea satisfactoria
                if (letraEncontrada) {
                    System.out.println("¡Letra correcta!");
                    System.out.println("Palabra adivinada: " + new String(palabraAdivinadaArray));
                } else {
                // En caso de que la valifación sea una cagada 
                    System.out.println("Letra incorrecta. Intentos restantes: " + (5 - intentos));
                }
                // En caso que el usuario encuentre la palabra 
                if (new String(palabraAdivinadaArray).equals(palabraSecreta)) {
                    System.out.println("¡Felicidades! Jugador 2 adivinó la palabra secreta: " + palabraSecreta);
                    adivinada = true;
                    break;
                }
            }
            // En caso de que el usuario no haya podido encontrar la palabra
            if (!adivinada) {
                System.out.println("Jugador 2 agotó sus 5 oportunidades. La palabra secreta era: " + palabraSecreta);
            }

            // Volver a empezar el juego
            System.out.println(" ");
            System.out.println("<<-- ¿Volver a empezar? -->>");
            res = lee.nextLine();

            // Validar respuesta del usuario 
            if (res.equalsIgnoreCase("no")) {
                System.out.println("Gracias por jugar :D");
            } else {
                System.out.println("Reiniciando el juego...");
                System.out.println(" ");
            }
        } while (!res.equalsIgnoreCase("no"));

        //Banco de palabras xd
        //System.out.println("Palabras ingresadas por Jugador 1:");
        //for (int j = 0; j < i; j++) {
        //    System.out.println("Palabra " + (j + 1) + ": " + palabras[j]);
        //}
    }
}
