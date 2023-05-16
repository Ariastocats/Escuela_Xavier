import java.io.Serializable;
public class T_ProfesoresJB implements Serializable{
	private String ID_TipoP;
	private String Tiempo;
	
	public T_ProfesoresJB() {
		
	}

	public T_ProfesoresJB(String IDTipoP,String Tiempo) {
		this.ID_TipoP=IDTipoP;
		this.Tiempo=Tiempo;
		
	}
	
	public String getID_TipoP() {
	    return ID_TipoP;
	}

	public void setID_TipoP(String IDTipoP) {
	    this.ID_TipoP = IDTipoP;
	}
	
	public String getTiempo() {
	    return Tiempo;
	}

	public void setTiempo(String tiempo) {
	    Tiempo = tiempo;
	}
	
}
