package mx.ipn;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String flag = "S";
        Scanner scanner = new Scanner(System.in);

        while(flag.equals("S") || flag.equals("s")) {
            System.out.println("Bienvenido a la Actividad 13");

            System.out.println("¿Desea repetir? S/N");
            flag = scanner.nextLine();
        }
    }
}
