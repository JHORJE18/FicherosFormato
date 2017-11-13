package EXAMEN;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

import Objetos.*;

public class Principal {
	
	//Variables
	static ArrayList <Acciones> accs = new ArrayList<Acciones>();
	
	public static void main(String[] args) {
		cargarAcciones();
		System.out.println("Programa finalizado correctamente!");
	}
		
	//Obtener libros XML
	public static void cargarAcciones() {
		ParserAcciones pa = new ParserAcciones();
		pa.parseXML(pedirFichero());
		pa.parseDocument();
		
		//Añadimos al array que conservamos los nuevos libros cargados
		ArrayList <Acciones> acsTEMP = pl.getLibros();
			for (int i=0; i<acsTEMP.size(); i++) {
				accs.add(acsTEMP.get(i));
			}
		
			System.out.println(limpiar(25));
			System.out.println("Se han obtenido " + lbsTEMP.size() + " nuevos libros");
			System.out.println("Atualmente hay un total de " + accs.size() + " libros");
	}
	
	//Pedir fichero 
	public static String pedirFichero() {
		Scanner entrada = new Scanner(System.in);
		String fichero = "";
		boolean valido = false;
		while (!valido) {
			System.out.println("Introduce el nombre del fichero XML");
			fichero = entrada.nextLine();
			
			File archivo = new File(fichero);
			if (!archivo.exists()) {
				System.out.println("El fichero no existe");
			} else {
				valido = true;
			}
		}
		
		return fichero;
	}
	
	//Devuelve Int seguro
	public static int pedirInt(String motivo) {
		Scanner entrada = new Scanner(System.in);
		boolean valido = false;
		int valor = 0;
		
		while (!valido) {
			System.out.println("> Introduce el Número de " + motivo);
			try {
				valor = entrada.nextInt();
			}catch (Exception e) {
				// TODO: handle exception
				valor = 0;
			}
			
			if (valor > 0) {
				valido = true;
			} else {
				System.out.println("***** No puede tener 0, introduce un numero válido");
			}
		}
		
		return valor;
	}
	
	//Genera Linea (Diseño)
	public static String limpiar(int lines) {
		String lineas = "";
		for (int i=0; i<=lines; i++) {
			lineas += "-";
		}
		return lineas;
	}
	
}