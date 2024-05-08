package ar.edu.unju.fi.ejercicio5.model;

import java.time.LocalDate;

import ar.edu.unju.fi.ejercicio5.interfaces.Pago;

public class PagoEfectivo implements Pago {
 
    private double montoPagado;
    private LocalDate fechaPago;

 
    public PagoEfectivo(double montoPagado, LocalDate fechaPago) {
        this.montoPagado = montoPagado;
        this.fechaPago = fechaPago;
    }

    @Override
    public void realizarPago(double monto) {
        this.montoPagado -= monto * 0.10;
    }

    @Override
    public void imprimirRecibo() {
        System.out.println("Pago en efectivo:");
        System.out.println("Fecha de pago: " + fechaPago);
        System.out.println("Monto pagado: " + montoPagado);
    }
}