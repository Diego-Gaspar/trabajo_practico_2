package ar.edu.unju.fi.ejercicio7.model;

public class Producto {
	private String nombre;
	private double precio;
	private boolean estado;
	private String categoria;


public Producto(String nombre, double precio, boolean estado, String categoria) {
    this.nombre = nombre;
    this.precio = precio;
    this.estado = estado;
    this.categoria = categoria;


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

public String getCategoria() {
    return categoria;
}

public void setCategoria(String categoria) {
    this.categoria = categoria;
}

@Override
public String toString() {
	return "Producto [nombre=" + nombre + ", precio=" + precio + ", estado=" + estado + ", categoria=" + categoria
			+ "]";
}


}

