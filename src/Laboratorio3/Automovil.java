/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Laboratorio3;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ayrth
 */
public class Automovil {
    private String placa;
    private String marca;
    private String modelo;
    private String color;
    private final List<String> infracciones;

    public Automovil(String placa, String marca, String modelo, String color) {
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.color = color;
        this.infracciones = new ArrayList<>();
    }

    public void agregarInfraccion(String lugar) {
        this.infracciones.add(lugar);
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public List<String> getInfracciones() {
        return infracciones;
    }

    public void mostrarDatosAutomovil() {
        System.out.println("Placa: " + placa + " | Marca: " + marca + " | Modelo: " + modelo + " | Color: " + color);
        if (infracciones.isEmpty()) {
            System.out.println("  Sin infracciones registradas.");
        } else {
            System.out.println("  Infracciones (Lugares):");
            for (String inf : infracciones) {
                System.out.println("   - " + inf);
            }
        }
    }
}