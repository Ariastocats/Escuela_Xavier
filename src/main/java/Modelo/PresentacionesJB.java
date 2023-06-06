package Modelo;

import java.io.Serializable;
public class PresentacionesJB implements Serializable{
	
	private int N_Presentacion;
	private String Presentacion;
	private String Dia;
	private String Horario;
	//strings
	private String nombre;
	private String Rols;
	private int asist;
	
	
	
	public PresentacionesJB() {
		
	}
	public PresentacionesJB(int NPresentacion,String Presentacion,String Dia,String Horario) {
		this.N_Presentacion=NPresentacion;
		this.Presentacion=Presentacion;
		this.Dia=Dia;
		this.Horario=Horario;
		
		
	}
	
	public PresentacionesJB(int NPresentacion,String Presentacion,String Dia,String Horario,int asist) {
		this.N_Presentacion=NPresentacion;
		this.Presentacion=Presentacion;
		this.Dia=Dia;
		this.Horario=Horario;
		this.asist=asist;
		
		
		
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
	
	public String getDia() {
	    return Dia;
	}

	public void setDia(String dia) {
	    Dia = dia;
	}
	
	public String getHorario() {
	    return Horario;
	}

	public void setHorario(String horario) {
	    Horario = horario;
	}
	

}
