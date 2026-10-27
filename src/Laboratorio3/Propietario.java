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
public class Propietario {
    private String nombre;
    private String cedula;
    private String huellaDactilar;
    private List<Automovil> automoviles;

    public Propietario(String nombre, String cedula, String huellaDactilar) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.huellaDactilar = huellaDactilar;
        this.automoviles = new ArrayList<>();
    }

    public void agregarAutomovil(Automovil automovil) {
        this.automoviles.add(automovil);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getHuellaDactilar() {
        return huellaDactilar;
    }

    public void setHuellaDactilar(String huellaDactilar) {
        this.huellaDactilar = huellaDactilar;
    }

    public List<Automovil> getAutomoviles() {
        return automoviles;
    }

    public void mostrarDatosPropietario() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Cédula: " + cedula);
        System.out.println("Huella Dactilar: " + huellaDactilar);
    }
}