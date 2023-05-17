package Modelo;

import java.io.Serializable;
public class Asist_PresentacionJB implements Serializable{
	
	private int N_Presentacion;
	private int Curp;
	
	public Asist_PresentacionJB() {
		
	}
	
	public Asist_PresentacionJB(int NPresentacion,int Curp) {
		this.N_Presentacion=NPresentacion;
		this.Curp=Curp;
		
	}
	
	public int getN_Presentacion() {
	    return N_Presentacion;
	}

	public void setN_Presentacion(int n_Presentacion) {
	    N_Presentacion = n_Presentacion;
	}
	
	public int getCurp() {
	    return Curp;
	}

	public void setCurp(int curp) {
	    Curp = curp;
	}
	
	

}
