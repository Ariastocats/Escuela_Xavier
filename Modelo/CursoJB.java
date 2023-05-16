import java.io.Serializable;
public class CursoJB {
	
	private String ID_Est;
	private String ID_Leccion;
	private float calificacion;
	
	public CursoJB() {
		
	}
	
	public CursoJB(String IDEst,String IDLeccion,float calificacion) {
		this.ID_Est=IDEst;
		this.ID_Leccion=IDLeccion;
		this.calificacion=calificacion;
		
	}
	
	public String getID_Est() {
	    return ID_Est;
	}

	public void setID_Est(String IDEst) {
	    this.ID_Est = IDEst;
	}
	
	public String getID_Leccion() {
	    return ID_Leccion;
	}

	public void setID_Leccion(String IDLeccion) {
	    this.ID_Leccion = IDLeccion;
	}
	
	public float getCalificacion() {
	    return calificacion;
	}

	public void setCalificacion(float calificacion) {
	    this.calificacion = calificacion;
	}

}
