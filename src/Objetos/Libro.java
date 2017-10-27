package Objetos;

import java.util.ArrayList;

public class Libro {
	
	//Variables
	String titulo;
	String año;
	ArrayList <Autor> autores = null;
	String editor;
	String paginas;
	
	public Libro(String titulo, String año, ArrayList<Autor> autores, String editor, String paginas) {
		super();
		this.titulo = titulo;
		this.año = año;
		this.autores = autores;
		this.editor = editor;
		this.paginas = paginas;
	}
	
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getAño() {
		return año;
	}
	public void setAño(String año) {
		this.año = año;
	}
	public ArrayList<Autor> getAutores() {
		return autores;
	}
	public void setAutores(ArrayList<Autor> autores) {
		this.autores = autores;
	}
	public String getEditor() {
		return editor;
	}
	public void setEditor(String editor) {
		this.editor = editor;
	}
	public String getPaginas() {
		return paginas;
	}
	public void setPaginas(String paginas) {
		this.paginas = paginas;
	}
	
	public String imprimir() {
		String datos = "";
		datos += ("Titulo: " + this.titulo + "\n");
		datos += ("Año: " + this.año + "\n");
		for (int i=0; i<autores.size(); i++) {
			datos += ("Autor Nº" + (i+1) + ": " + this.autores.get(i).getAutor() + "\n");
		}
		datos += ("Editor: " + this.editor + "\n");
		datos += ("Paginas: " + this.paginas);
		
		return datos;
	}

}
