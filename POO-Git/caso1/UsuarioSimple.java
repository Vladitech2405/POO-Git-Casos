import java.util.Scanner;

public class UsuarioSimple {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingresa tu nombre: ");
        String nombre = sc.nextLine();

        System.out.print("Ingresa tu edad (años): ");
        int edad = sc.nextInt();

        System.out.print("Ingresa tu estatura (en metros, ej. 1.72): ");
        double estatura = sc.nextDouble();

        System.out.println("\n--- RESUMEN ---");
        System.out.println("Nombre: " + nombre);
        System.out.println("Edad: " + edad + " años");
        System.out.println("Estatura: " + estatura + " m");
        sc.close();
    }
}
