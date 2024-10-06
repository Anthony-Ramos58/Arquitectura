/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author dgarc
 */
public class Contado extends Venta {

    public static int n = 0; // Variable estática para contar la cantidad de objetos

    public Contado(int cantidad, String cliente, String fecha, String hora, String producto, String ruc) {
        super(cantidad, cliente, fecha, hora, producto, ruc);
        Contado.n++; // Incrementar la variable n
    }

    public static int getN() {
        return n;
    }

    public double calculaDescuento() {
        double subtotal = calculaSubtotal();
        if (subtotal > 3000) {
            return subtotal * 0.12;  // Descuento del 12%
        } else if (subtotal >= 1000) {
            return subtotal * 0.08;  // Descuento del 8%
        } else {
            return subtotal * 0.05;  // Descuento del 5%
        }
    }

    public double calculaTotal() {
        return calculaSubtotal() - calculaDescuento();
    }
}
