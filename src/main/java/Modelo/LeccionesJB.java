package Modelo;

import java.io.Serializable;
public class LeccionesJB implements Serializable{
	private int ID_Leccion;
	private String Leccion;
	private String Hora_Ini;
	private String Hora_Fin;
	private int creditos;
	private int Tipo_Leccion;
	
	public LeccionesJB(){
		
	}
	public LeccionesJB(int IDLeccion,String Leccion,String HoraIni,String HoraFin,int creditos,int TipoLeccion){
		this.ID_Leccion=IDLeccion;
		this.Leccion=Leccion;
		this.Hora_Ini=HoraIni;
		this.Hora_Fin=HoraFin;
		this.creditos=creditos;
		this.Tipo_Leccion=TipoLeccion;
	}
	
	public int getID_Leccion() {
	    return ID_Leccion;
	}

	public void setID_Leccion(int IDLeccion) {
	    this.ID_Leccion = IDLeccion;
	}

	public String getLeccion() {
	    return Leccion;
	}

	public void setLeccion(String leccion) {
	    Leccion = leccion;
	}
	
	public String getHora_Ini() {
	    return Hora_Ini;
	}

	public void setHora_Ini(String horaIni) {
	    Hora_Ini = horaIni;
	}
	
	public String getHora_Fin() {
	    return Hora_Fin;
	}

	public void setHora_Fin(String horaFin) {
	    Hora_Fin = horaFin;
	}
	
	public int getCreditos() {
	    return creditos;
	}

	public void setCreditos(int creditos) {
	    this.creditos = creditos;
	}
	
	public int getTipo_Leccion() {
	    return Tipo_Leccion;
	}

	public void setTipo_Leccion(int tipoLeccion) {
	    Tipo_Leccion = tipoLeccion;
	}


}
