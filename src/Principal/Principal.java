package Principal;

import java.util.ArrayList;
import java.util.Scanner;

import Objetos.*;

public class Principal {
	
	//Variables
	static ArrayList <Libro> lbs = null;
	
	public static void main(String[] args) {
		boolean salir = false;
		while (!salir) {
			switch (menu()) {
			case 1:
				cargarLibros();
				break;
			case 2:
				mostrarLibros();
				break;
			case 3:
				crearLibro();
				break;
			case 4:
				guardarLibros();
				break;
			case 5:
				salir = true;
				break;
			default:
				System.out.println(limpiar(25));
				System.out.println("Has introducido un valor no válido");
				
			}
		}
		System.out.println("Programa finalizado correctamente!");
	}
	
	//Menu principal
	public static int menu() {
		Scanner entrada = new Scanner(System.in);
		System.out.println(limpiar(25));
		System.out.println("Menu principal");
		System.out.println(limpiar(25));
		System.out.println("1. Cargar libros");
		System.out.println("2. Mostrar libros obtenidos");
		System.out.println("3. Crear libro");
		System.out.println("4. Guardar libros");
		System.out.println("5. Salir");
		
		int opcion = 0;
		try {
			opcion = entrada.nextInt();
		}catch (Exception e) {
			// TODO: handle exception
			opcion = 0;
		}
		
		return opcion;
	}
	
	//Obtener libros XML
	public static void cargarLibros() {
		ParserLibros pl = new ParserLibros();
		pl.parseXML("biblioteca.xml");
		pl.parseDocument();
		
		lbs = pl.getLibros();
		
		System.out.println(limpiar(25));
		System.out.println("Se han obtenido " + lbs.size() + " libros");
	}
	
	//Mostrar libros
	public static void mostrarLibros() {
		if (lbs != null) {
			System.out.println(limpiar(25));
			System.out.println("Mostrando " + lbs.size() + " libros...");
			System.out.println(limpiar(50));
			
			//Imprimimos libros
			System.out.println(limpiar(20));
			for (int i=0; i<lbs.size(); i++) {
				System.out.println("Libro número " + (i+1));
				System.out.println(limpiar(20));
				System.out.println(lbs.get(i).imprimir());
				System.out.println(limpiar(20));
			}
		} else {
			System.out.println(limpiar(25));
			System.out.println("No se encuentran libros actualmente");
		}
	}
	
	//Crear un nuevo libro
	public static void crearLibro() {
		Scanner entrada = new Scanner(System.in);
		System.out.println(limpiar(25));
		System.out.println("Generando nuevo libro");
		
		//Variables a ultilizar
		String titulo,año,editor,paginas = "";
		int numAutores = 0;
		ArrayList <Autor> autores = new ArrayList<Autor>();
		
		//Pedimos datos
		System.out.println("> Introduce el Titulo");
		titulo = entrada.nextLine();
		System.out.println("> Introduce el Año");
		año = entrada.nextLine();
		numAutores = pedirInt("autores");
		System.out.println("> Introduce el Editor");
		editor = entrada.nextLine();
		System.out.println("> Introduce el número de páginas");
		paginas = entrada.nextLine();
		
		//Generamos autores del libro
		for (int i=0; i<numAutores; i++) {
			System.out.println("> Introduce el autor nº " + (i+1));
			String name = entrada.nextLine();
			
			autores.add(new Autor(name));
		}
		
		//Se crea libro
		Libro nuevo = new Libro(titulo, año, autores, editor, paginas);
		
		//Se imprime datos
		System.out.println(limpiar(25));
		System.out.println("Nuevo libro generado:");
		nuevo.imprimir();
		System.out.println(limpiar(25));
		
		//Se añade al arrayList
		lbs.add(nuevo);
	}
	
	//Guardar libros
	public static void guardarLibros() {
		System.out.println(limpiar(25));
		System.out.println("Proximamente...");
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
				System.out.println("***** No puede tener 0 autores, introduce un numero válido");
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
