package Principal;

import java.util.ArrayList;
import java.util.Scanner;

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
	
	//TODO: Introducir menu
	public static int menu() {
		Scanner entrada = new Scanner(System.in);
		int opcion = 1;
		
		return opcion;
	}
	
	public static String limpiar(int lines) {
		String lineas = "";
		for (int i=0; i<=lines; i++) {
			lineas += "-";
		}
		return lineas;
	}
	
}
