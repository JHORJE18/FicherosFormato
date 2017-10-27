package Principal;

import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import Objetos.*;

public class ParserLibros {
	
	private Document dom = null;
	private ArrayList<Libro> libros = null;
	
	public ParserLibros() {
		libros = new ArrayList<Libro>();
	}
	
	public void parseXML(String fichero) {
		//Creamos fabrica
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		
		try {
			//Creamos DocumentBuilder
			DocumentBuilder db = dbf.newDocumentBuilder();
			dom = db.parse(fichero);
		}catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void parseDocument() {
		//Obtenemos elemento Raiz
		Element docEl = dom.getDocumentElement();
		
		//Obtenemos NodeList
		NodeList nl = docEl.getElementsByTagName("libro");
		if (nl != null && nl.getLength() > 0) {
			for (int i=0; i<nl.getLength(); i++) {
				
				//Obtenemos elemento
				Element el = (Element) nl.item(i);
				
				//Obtenemos un libro
				Libro lb = getLibro(el);
				
				//Añadimos al array
				libros.add(lb);
			}
		}
	}
	
	//Obtenemos datos del libro
	private Libro getLibro(Element libroEle) {
		
		//Empezamos a obtener cada elemento
		String titulo = getTextValue(libroEle, "titulo");
		String anyo = getAño(libroEle, "titulo");;
		ArrayList <Autor> autores = getAutores(libroEle);
		String editor = getTextValue(libroEle, "editor");
		String paginas = getTextValue(libroEle, "paginas");

		Libro actual = new Libro(titulo, anyo, autores, editor, paginas);
		
		return actual;
	}
	
	//Obtiene el año del titulo
	private String getAño(Element ele, String tagName) {
		String txtValue = null;
		NodeList nl = ele.getElementsByTagName(tagName);
		if (nl != null && nl.getLength() > 0) {
			Element el = (Element) nl.item(0);
			txtValue = el.getAttributes().getNamedItem("anyo").getNodeValue();
		}
		return txtValue;
	}
	
	//Obtiene el valor del elemento a buscar
	private String getTextValue(Element ele, String tagName) {
		String txtValue = null;
		NodeList nl = ele.getElementsByTagName(tagName);
		if (nl != null && nl.getLength() > 0) {
			Element el = (Element) nl.item(0);
			txtValue = el.getFirstChild().getNodeValue();
		}
		return txtValue;
	}
	
	//Obtener autores
	private ArrayList<Autor> getAutores(Element ele){
		ArrayList <Autor> autores = new ArrayList<Autor>();
		
		NodeList nl = ele.getElementsByTagName("autor");
		if (nl != null && nl.getLength() > 0) {
				//Obtenemos elemento Autores
				Element elA = (Element) nl.item(0);
				
				//Inspecciona cada nombre que hay en autores
				NodeList nlA = elA.getElementsByTagName("nombre");
				for (int i=0; i<nlA.getLength(); i++) {
					Element el = (Element) nlA.item(i);
					String au = el.getFirstChild().getNodeValue();
					
					autores.add(new Autor(au));
				}				
		}

		return autores;
	}
	
	//Devuelbe array
	public ArrayList<Libro> getLibros(){
		return this.libros;
	}

}
