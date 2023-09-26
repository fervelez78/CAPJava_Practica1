package com.minsait.practica1.terceros;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class PersonaFisica extends Persona {


	String apellido1 = "";
	String apellido2 = "";
	
	public PersonaFisica(String rfc, String nombre, String apellido1, String apellido2, Date fechaNacimiento, String direccion, String telefono) {
		super(rfc, nombre, fechaNacimiento, direccion, telefono);
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
        if (rfc.isEmpty())
        	this.rfc = generaRfc();

	}

	
	@Override
	protected String generaRfc() {
		String rfc = apellido1.substring(1, 3) + apellido2.substring(1,2) + nombre.substring(1,2);
		//Obtener el formato simple de fecha de nacimiento
		
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(fechaNacimiento);
		
		int anio = calendar.get(Calendar.YEAR);
		if (anio >= 2000)
			anio = anio - 2000;
		else
			anio = anio - 1900;
		String mes = "";
		if (calendar.get(Calendar.MONTH) + 1 >= 10)
			mes = "" + calendar.get(Calendar.MONTH) + 1;
		else
			mes = "0" + (calendar.get(Calendar.MONTH) + 1);
		String dia = "";
		if (calendar.get(Calendar.DAY_OF_MONTH) >= 10)
			dia = "" + calendar.get(Calendar.DAY_OF_MONTH);
        else	
        	dia = "0" + calendar.get(Calendar.DAY_OF_MONTH);
        rfc += anio + mes + dia;
		return rfc.toUpperCase();
	}
	
	@Override
	public String toString() {
		SimpleDateFormat formatoFecha = new SimpleDateFormat(formatoFecha());
		String cadena = rfc + " " + nombre + " " + apellido1 + " " + apellido2 + " " +
				formatoFecha.format(fechaNacimiento) + " " + direccion + " " + formatoTelefono(telefono);
		return cadena;
	}

}
