package com.minsait.practica1;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import com.minsait.practica1.terceros.Persona;
import com.minsait.practica1.terceros.PersonaFisica;
import com.minsait.practica1.terceros.PersonaMoral;

public class Practica1 {

	public static void main(String[] args) {
		// Obtener el formato de la fecha
		SimpleDateFormat formato = new SimpleDateFormat(Persona.formatoFecha());
		try {
			// clase persona fisica
			PersonaFisica persona = new PersonaFisica(
					"", 
					"Juan", 
	                "Perez",
	                "Ramirez",
	                formato.parse("01/01/1985"),  
	                "Pruebas No. 1 col. Indra", 
	                "5559112299");
			System.out.println(persona.toString());
		
			
			// clase Persona moral
			PersonaMoral empresa = new PersonaMoral(
					"PBEM901223", 
					"Pruebas S. A. de C. V.",
	                formato.parse("23/12/1990"), 
	                "Practica 1 No. 101 col. Minsait", 
	                "5556667777,5539865233");
			System.out.println(empresa.toString());
		}catch (ParseException e) {
			e.printStackTrace();
		}		

	}

}
