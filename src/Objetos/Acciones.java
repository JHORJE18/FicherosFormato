package Objetos;

import java.util.ArrayList;

public class Acciones {
	
	//Variables
	private String nombre;
	private ArrayList<Operacion> operaciones;
	
	public Acciones(String nombre, ArrayList<Operacion> operaciones) {
		super();
		this.nombre = nombre;
		this.operaciones = operaciones;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public ArrayList<Operacion> getOperaciones() {
		return operaciones;
	}
	public void setOperaciones(ArrayList<Operacion> operaciones) {
		this.operaciones = operaciones;
	}

}
