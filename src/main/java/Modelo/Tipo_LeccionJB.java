package Modelo;

import java.io.Serializable;
public class Tipo_LeccionJB implements Serializable{
	private int ID_TipoL;
	private String Tipo_Leccion;
	
	public Tipo_LeccionJB(){
		
	}
	
	public Tipo_LeccionJB(int IDTipoL,String TipoLeccion) {
		this.ID_TipoL=IDTipoL;
		this.Tipo_Leccion=TipoLeccion;
		
	}
	
	public int getID_TipoL() {
	    return ID_TipoL;
	}

	public void setID_TipoL(int IDTipoL) {
	    this.ID_TipoL = IDTipoL;
	}
	
	public String getTipo_Leccion() {
	    return Tipo_Leccion;
	}

	public void setTipo_Leccion(String tipoLeccion) {
	    Tipo_Leccion = tipoLeccion;
	}
	

}
