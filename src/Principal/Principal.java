package Principal;

import java.util.ArrayList;
import Objetos.*;

public class Principal {
	
	public static void main(String[] args) {
		ParserLibros pl = new ParserLibros();
		pl.parseXML("biblioteca.xml");
		pl.parseDocument();
		
		ArrayList <Libro> lbs = pl.getLibros();
		
		//Imprimimos libros
		System.out.println(limpiar(20));
		for (int i=0; i<lbs.size(); i++) {
			System.out.println("Libro número " + (i+1));
			System.out.println(limpiar(20));
			System.out.println(lbs.get(i).imprimir());
			System.out.println(limpiar(20));
		}
	}
	
	public static String limpiar(int lines) {
		String lineas = "";
		for (int i=0; i<=lines; i++) {
			lineas += "-";
		}
		return lineas;
	}
	
}
