/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author dgarc
 */
public class Credito extends Venta {

    private int letras;

    public Credito(int cantidad, String cliente, String fecha, String hora, String producto, String ruc, int letras) {
        super(cantidad, cliente, fecha, hora, producto, ruc);
        this.letras = letras;
    }

    // Método para obtener la cantidad de letras
    public int getLetras() {
        return letras;
    }

    // Método para asignar la cantidad de letras
    public void setLetras(int letras) {
        this.letras = letras;
    }

    // Método para calcular el descuento
    public double calculaDescuento() {
        double subtotal = calculaSubtotal();
        double porcentajeDescuento = 0;

        if (subtotal < 1000) {
            porcentajeDescuento = 0.03;
        } else if (subtotal >= 1000 && subtotal <= 3000) {
            porcentajeDescuento = 0.05;
        } else {
            porcentajeDescuento = 0.08;
        }

        return subtotal * porcentajeDescuento;
    }

    // Método para calcular el monto mensual
    public double calculaMontoMensual() {
        double subtotal = calculaSubtotal();
        double descuento = calculaDescuento();
        double montoMensual = (subtotal - descuento) / letras;
        return montoMensual;
    }

    public double calculaMontoTotal() {
        double subtotal = calculaSubtotal(); // Calcular el subtotal
        double descuento = calculaDescuento(); // Aplicar el descuento según las reglas definidas
        return subtotal - descuento; // Retornar el monto total con descuento
    }
}
