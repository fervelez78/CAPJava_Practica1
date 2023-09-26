package com.minsait.practica1.terceros;

import java.util.Date;

public class PersonaMoral extends Persona {

	public PersonaMoral(String rfc, String nombre, Date fechaNacimiento, String direccion, String telefono) {
		super(rfc, nombre, fechaNacimiento, direccion, telefono);

	}

	@Override
	protected String formatoTelefono(String telefono) {
		String[] telefonos = telefono.split(",");
		StringBuilder resultado = new StringBuilder("");
		
        for (String a : telefonos){
        	if (resultado.length() > 0) {
        		resultado.append(",");
        	}
        	resultado.append(super.formatoTelefono(a));
        }
        return resultado.toString();
	}
	
	
	
}
