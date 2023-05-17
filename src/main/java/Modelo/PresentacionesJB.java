package Modelo;

import java.io.Serializable;
public class PresentacionesJB implements Serializable{
	
	private int N_Presentacion;
	private String Presentacion;
	private String Dia;
	private String Horario;
	
	
	public PresentacionesJB() {
		
	}
	public PresentacionesJB(int NPresentacion,String Presentacion,String Dia,String Horario) {
		this.N_Presentacion=NPresentacion;
		this.Presentacion=Presentacion;
		this.Dia=Dia;
		this.Horario=Horario;
		
		
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
