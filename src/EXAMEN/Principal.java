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
		
		mostrar();
		System.out.println("Programa finalizado correctamente!");
	}
		
	//Obtener Acciones XML
	public static void cargarAcciones() {
		ParserAcciones pa = new ParserAcciones();
		pa.parseXML(pedirFichero());
		pa.parseDocument();
		
		//Añadimos al array que conservamos las nuevas Acciones cargados
		ArrayList <Acciones> acsTEMP = pa.getAcciones();
			for (int i=0; i<acsTEMP.size(); i++) {
				accs.add(acsTEMP.get(i));
			}
		
		System.out.println(limpiar(25));
		System.out.println("Se han obtenido " + acsTEMP.size() + " acciones");
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
	
	//Mostrar por pantalla
	public static void mostrar() {
		if (accs != null) {
			System.out.println("Mostrando " + accs.size() + " acciones...");
			
			//Imprimimos Acciones
			System.out.println(limpiar(20));
			for (int i=0; i<accs.size(); i++) {
				System.out.println("Acción Nº " + (i+1));
				System.out.println(limpiar(20));
				System.out.println(accs.get(i).imprimir());
				System.out.println(limpiar(20));
			}
		} else {
			System.out.println(limpiar(25));
			System.out.println("No se encuentran acciones actualmente");
		}
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