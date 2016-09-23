/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.utng.ana.model;

public class Lector {
   private int numeroLector;
   private String nombre;
   private String telefono;
   private String direccion;
   
   
   
public Lector() {
	this(0,"","","");
}
public Lector(int numeroLector, String nombre, String telefono, String direccion) {
	super();
	this.numeroLector = numeroLector;
	this.nombre = nombre;
	this.telefono = telefono;
	this.direccion = direccion;
}
public int getNumeroLector() {
	return numeroLector;
}
public void setNumeroLector(int numeroLector) {
	this.numeroLector = numeroLector;
}
public String getNombre() {
	return nombre;
}
public void setNombre(String nombre) {
	this.nombre = nombre;
}
public String getTelefono() {
	return telefono;
}
public void setTelefono(String telefono) {
	this.telefono = telefono;
}
public String getDireccion() {
	return direccion;
}
public void setDireccion(String direccion) {
	this.direccion = direccion;
}
@Override
public String toString() {
	return "Lector [numeroLector=" + numeroLector + ", nombre=" + nombre + ", telefono=" + telefono + ", direccion="
			+ direccion + "]";
}
   
   

  
}
