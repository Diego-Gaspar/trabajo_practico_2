package ar.edu.unju.fi.ejercicio5.model;

public class Producto {
	private String nombre;
	private double precio;
	private boolean estado;

public Producto(String nombre, double precio, boolean estado) {
    this.nombre = nombre;
    this.precio = precio;
    this.estado = estado;
 }
public String getNombre() {
	return nombre;
}

public void setNombre(String nombre) {
	this.nombre = nombre;
}

public double getPrecio() {
	return precio;
}

public void setPrecio(double precio) {
	this.precio = precio;
}

public boolean isEstado() {
	return estado;
}

public void setEstado(boolean estado) {
	this.estado = estado;
}
}
