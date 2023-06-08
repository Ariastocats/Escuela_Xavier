package Modelo;

import java.io.Serializable;
import java.sql.Time;



public class LeccionesJB implements Serializable{
	private int ID_Leccion;
	private String Leccion;
	private Time Hora_Ini;
	private Time Hora_Fin;
	private int creditos;
	private int Tipo_Leccion;
	//leccionesjoin
	private String tipoleccion;
	private String nombre;
	private int matri;
	private float calif;
	
	public LeccionesJB(){
		
	}
	//el completo
	public LeccionesJB(int IDLeccion,String Leccion,Time HoraIni,Time HoraFin,int creditos,int TipoLeccion){
		this.ID_Leccion=IDLeccion;
		this.Leccion=Leccion;
		this.Hora_Ini=HoraIni;
		this.Hora_Fin=HoraFin;
		this.creditos=creditos;
		this.Tipo_Leccion=TipoLeccion;
	}
	//el que no tiene ID
	public LeccionesJB(String Leccion,Time HoraIni,Time HoraFin,int creditos,int TipoLeccion){
		this.Leccion=Leccion;
		this.Hora_Ini=HoraIni;
		this.Hora_Fin=HoraFin;
		this.creditos=creditos;
		this.Tipo_Leccion=TipoLeccion;
	}
	
	
	//el que tiene el tipo leccion con string
	public LeccionesJB(int IDLeccion,String Leccion,Time HoraIni,Time HoraFin,int creditos,String tipoleccion){
		this.ID_Leccion=IDLeccion;
		this.Leccion=Leccion;
		this.Hora_Ini=HoraIni;
		this.Hora_Fin=HoraFin;
		this.creditos=creditos;
		this.tipoleccion=tipoleccion;
	}
	//el que es para los alumnos
	public LeccionesJB(int matri,String nombre,String Leccion,int creditos,float calif){
		this.matri=matri;
		this.nombre=nombre;
		this.Leccion=Leccion;
		this.creditos=creditos;
		this.calif=calif;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public float getCalif() {
		return calif;
	}
	public void setCalif(float calif) {
		this.calif = calif;
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
	
	public Time getHora_Ini() {
	    return Hora_Ini;
	}

	public void setHora_Ini(Time horaIni) {
	    Hora_Ini = horaIni;
	}
	
	public Time getHora_Fin() {
	    return Hora_Fin;
	}

	public void setHora_Fin(Time horaFin) {
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
	
	public int getMatri() {
		return matri;
	}
	public void setMatri(int matricula) {
		this.matri = matricula;
	}
	
	public String getTipoleccion() {
		return tipoleccion;
	}
	public void setTipoleccion(String tipoleccion) {
		this.tipoleccion = tipoleccion;
	}



}
