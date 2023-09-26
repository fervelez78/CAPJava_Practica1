package com.minsait.practica1.terceros;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Persona {

	protected String rfc;
	protected String nombre;
	protected Date fechaNacimiento;
	protected String direccion;
	protected String telefono;
	
	public Persona(String rfc, String nombre, Date fechaNacimiento, String direccion, String telefono) {
		super();
        this.rfc = rfc;
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.direccion = direccion;
        this.telefono = telefono;
        if (!validaDatos())
        {
            System.out.println("Datos invalidos");
        };
	}
	
	private boolean validaDatos() {
		boolean validacion = true;
		
		if (nombre == null || nombre.isEmpty()) {
            validacion = false;
        }
		if (fechaNacimiento == null) {
			validacion = false;
		}
		
		return validacion;
	}
	
	protected String generaRfc() {
        String rfc = "";
        
        if (nombre != null)
        	rfc = nombre.substring(0,1) + nombre.substring(nombre.length()-1, nombre.length());
        if (fechaNacimiento!= null)
        	rfc += fechaNacimiento.toString();
        
		return rfc;
    }
	
	protected boolean esDireccionCorrecta(String direccion) {
		boolean direccionCorrecta = true;
        
        if (direccion == null || direccion.isEmpty()) {
            direccionCorrecta = false;
        }
        
        return direccionCorrecta;
	}
	
	protected String formatoTelefono(String telefono) {
		String telefonoFormato = "";
        
        if (telefono!= null &&!telefono.isEmpty() && telefono.length() >= 10) {
            telefonoFormato = telefono.substring(0, 3) + "-" + telefono.substring(3, 7) + "-" + telefono.substring(7, 10);
        }
        
        return telefonoFormato;
	}
	
	public static String formatoFecha(){
		return "dd/mm/yyyy";
	}
	
	@Override
	public String toString() {
		SimpleDateFormat formatoFecha = new SimpleDateFormat(formatoFecha());
		
		String cadena = rfc + " " + nombre + " " + 
				formatoFecha.format(fechaNacimiento) + " " + direccion + " " + formatoTelefono(telefono);
		return cadena;
	}
	
}
