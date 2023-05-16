import java.io.Serializable;
public class PresentacionesJB implements Serializable{
	private String N_Presentacion;
	private date Dia;
	private time Horario;
	private String Curp;
	
	public PresentacionesJB() {
		
	}
	public PresentacionesJB(String NPresentacion,date Dia,time Horario,String Curp) {
		this.N_Presentacion=NPresentacion;
		this.Dia=Dia;
		this.Horario=Horario;
		this.Curp=Curp;
		
	}
	
	public String getN_Presentacion() {
	    return N_Presentacion;
	}

	public void setN_Presentacion(String nPresentacion) {
	    N_Presentacion = nPresentacion;
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
	
	public String getCurp() {
	    return Curp;
	}

	public void setCurp(String curp) {
	    Curp = curp;
	}

}
