/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Ejercicio1;
import java.util.Scanner;
/**
 *
 * @author ayrth
 */
public class ClaseCliente {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Cliente cliente = null;
        int opcion;

        do {
            System.out.println("\n=== SISTEMA BANCARIO ===");
            System.out.println("1. Registrar datos del cliente");
            System.out.println("2. Registrar cuenta bancaria");
            System.out.println("3. Ver cuentas bancarias");
            System.out.println("4. Ver datos generales");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Cédula: ");
                    String cedula = sc.nextLine();
                    System.out.print("Nombre: ");
                    String nombre = sc.nextLine();
                    System.out.print("Edad: ");
                    int edad = sc.nextInt();
                    sc.nextLine();
                    cliente = new Cliente(cedula, nombre, edad);
                    System.out.println("Cliente registrado exitosamente.");
                    break;

                case 2:
                    if (cliente == null) {
                        System.out.println("Primero debe registrar un cliente.");
                        break;
                    }
                    System.out.print("Número de cuenta: ");
                    String numeroCuenta = sc.nextLine();
                    System.out.print("Saldo inicial: ");
                    double saldo = sc.nextDouble();
                    sc.nextLine();
                    System.out.print("Tipo de cuenta: ");
                    String tipoCuenta = sc.nextLine();
                    CuentaBancaria cuenta = new CuentaBancaria(numeroCuenta, saldo, tipoCuenta);
                    cliente.agregarCuenta(cuenta);
                    System.out.println("Cuenta registrada exitosamente.");
                    break;

                case 3:
                    if (cliente == null || cliente.getCuentas().isEmpty()) {
                        System.out.println("No hay cuentas registradas.");
                        break;
                    }
                    System.out.println("\n--- CUENTAS BANCARIAS ---");
                    for (CuentaBancaria c : cliente.getCuentas()) {
                        c.mostrarCuenta();
                    }
                    break;

                case 4:
                    if (cliente == null) {
                        System.out.println("No hay datos de cliente registrados.");
                        break;
                    }
                    System.out.println("\n--- DATOS GENERALES ---");
                    cliente.mostrarCliente();
                    System.out.println("Total de cuentas: " + cliente.getCuentas().size());
                    for (CuentaBancaria c : cliente.getCuentas()) {
                        c.mostrarCuenta();
                    }
                    break;

                case 5:
                    System.out.println("Saliendo del sistema...");
                    break;

                default:
                    System.out.println("Opción inválida.");
            }
        } while (opcion != 5);

        sc.close();
    }
}