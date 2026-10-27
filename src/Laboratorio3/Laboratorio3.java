/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Laboratorio3;
import java.util.Scanner;
/**
 *
 * @author ayrth
 */
public class Laboratorio3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Propietario propietario = null;
        int opcion;

        do {
            System.out.println("\n=== SISTEMA DE REGISTRO DE MULTAS ===");
            System.out.println("1. Registrar datos del propietario");
            System.out.println("2. Registrar datos del vehículo");
            System.out.println("3. Registrar infracciones");
            System.out.println("4. Ver infracciones");
            System.out.println("5. Ver datos generales");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Nombre completo: ");
                    String nombre = sc.nextLine();
                    System.out.print("Número de cédula: ");
                    String cedula = sc.nextLine();
                    System.out.print("Código de huella dactilar: ");
                    String huella = sc.nextLine();
                    propietario = new Propietario(nombre, cedula, huella);
                    System.out.println("Propietario registrado exitosamente.");
                    break;

                case 2:
                    if (propietario == null) {
                        System.out.println("Primero debe registrar un propietario.");
                        break;
                    }
                    System.out.print("Placa: ");
                    String placa = sc.nextLine();
                    System.out.print("Marca: ");
                    String marca = sc.nextLine();
                    System.out.print("Modelo: ");
                    String modelo = sc.nextLine();
                    System.out.print("Color: ");
                    String color = sc.nextLine();
                    Automovil auto = new Automovil(placa, marca, modelo, color);
                    propietario.agregarAutomovil(auto);
                    System.out.println("Vehículo registrado exitosamente.");
                    break;

                case 3:
                    if (propietario == null || propietario.getAutomoviles().isEmpty()) {
                        System.out.println("No hay vehículos registrados para agregar infracciones.");
                        break;
                    }
                    System.out.print("Ingrese la placa del vehículo a multar: ");
                    String placaBuscar = sc.nextLine();
                    Automovil autoEncontrado = null;
                    for (Automovil a : propietario.getAutomoviles()) {
                        if (a.getPlaca().equalsIgnoreCase(placaBuscar)) {
                            autoEncontrado = a;
                            break;
                        }
                    }
                    if (autoEncontrado != null) {
                        System.out.print("Lugar de la infracción: ");
                        String lugar = sc.nextLine();
                        autoEncontrado.agregarInfraccion(lugar);
                        System.out.println("Infracción registrada exitosamente.");
                    } else {
                        System.out.println("Vehículo no encontrado.");
                    }
                    break;

                case 4:
                    if (propietario == null || propietario.getAutomoviles().isEmpty()) {
                        System.out.println("No hay vehículos ni infracciones registradas.");
                        break;
                    }
                    System.out.println("\n--- LISTADO DE INFRACCIONES ---");
                    for (Automovil a : propietario.getAutomoviles()) {
                        System.out.println("Vehículo Placa: " + a.getPlaca());
                        if (a.getInfracciones().isEmpty()) {
                            System.out.println("  Sin infracciones.");
                        } else {
                            for (String inf : a.getInfracciones()) {
                                System.out.println("  - Lugar: " + inf);
                            }
                        }
                    }
                    break;

                case 5:
                    if (propietario == null) {
                        System.out.println("No hay datos de propietario registrados.");
                        break;
                    }
                    System.out.println("\n--- DATOS GENERALES ---");
                    propietario.mostrarDatosPropietario();
                    System.out.println("Vehículos registrados: " + propietario.getAutomoviles().size());
                    for (Automovil a : propietario.getAutomoviles()) {
                        a.mostrarDatosAutomovil();
                    }
                    break;

                case 6:
                    System.out.println("Saliendo del sistema...");
                    break;

                default:
                    System.out.println("Opción inválida, intente de nuevo.");
            }
        } while (opcion != 6);

        sc.close();
    }
}
