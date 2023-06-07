package Modelo;


import java.io.Serializable;
import java.sql.Time;
import java.sql.Date;

public class PresentacionesJB implements Serializable{
	
	private int N_Presentacion;
	private String Presentacion;
	private Date Dia;
	private Time Horario;
	//strings
	private String nombre;
	private String Rols;
	private int asist;
	
	
	
	public PresentacionesJB() {
		
	}
	public PresentacionesJB(int NPresentacion,String Presentacion,Date Dia,Time Horario) {
		this.N_Presentacion=NPresentacion;
		this.Presentacion=Presentacion;
		this.Dia=Dia;
		this.Horario=Horario;
		
		
	}
	
	public PresentacionesJB(int NPresentacion,String Presentacion,Date Dia,Time Horario,int asist) {
		this.N_Presentacion=NPresentacion;
		this.Presentacion=Presentacion;
		this.Dia=Dia;
		this.Horario=Horario;
		this.asist=asist;
		
		
		
	}
	
	public PresentacionesJB(String Presentacion,Date Dia, Time Horario) {
		this.Presentacion=Presentacion;
		this.Dia=Dia;
		this.Horario=Horario;
	}
	public int getAsist() {
		return asist;
	}
	public void setAsist(int asist) {
		this.asist = asist;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getRols() {
		return Rols;
	}
	public void setRols(String Rols) {
		this.Rols = Rols;
	}
	
	public int getN_Presentacion() {
	    return N_Presentacion;
	}

	public void setN_Presentacion(int nPresentacion) {
	    N_Presentacion = nPresentacion;
	}
	
	public String getPresentacion() {
	    return Presentacion;
	}

	public void setPresentacion(String presentacion) {
	    Presentacion = presentacion;
	}
	
	public Date getDia() {
	    return Dia;
	}

	public void setDia(Date dia) {
	    Dia = dia;
	}
	
	public Time getHorario() {
	    return Horario;
	}

	public void setHorario(Time horario) {
	    Horario = horario;
	}
	

}
