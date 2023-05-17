package Modelo;

import java.io.Serializable;
public class CursoJB implements Serializable{
	
	private int ID_Est;
	private int ID_Leccion;
	private float calificacion;
	
	public CursoJB() {
		
	}
	
	public CursoJB(int IDEst,int IDLeccion,float calificacion) {
		this.ID_Est=IDEst;
		this.ID_Leccion=IDLeccion;
		this.calificacion=calificacion;
		
	}
	
	public int getID_Est() {
	    return ID_Est;
	}

	public void setID_Est(int IDEst) {
	    this.ID_Est = IDEst;
	}
	
	public int getID_Leccion() {
	    return ID_Leccion;
	}

	public void setID_Leccion(int IDLeccion) {
	    this.ID_Leccion = IDLeccion;
	}
	
	public float getCalificacion() {
	    return calificacion;
	}

	public void setCalificacion(float calificacion) {
	    this.calificacion = calificacion;
	}

}
