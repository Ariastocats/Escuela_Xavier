import java.io.Serializable;
public class Tipo_LeccionJB implements Serializable{
	private String ID_TipoL;
	private String Tipo_Leccion;
	
	public Tipo_LeccionJB(){
		
	}
	
	public Tipo_LeccionJB(String IDTipoL,String TipoLeccion) {
		this.ID_TipoL=IDTipoL;
		this.Tipo_Leccion=TipoLeccion;
		
	}
	
	public String getID_TipoL() {
	    return ID_TipoL;
	}

	public void setID_TipoL(String IDTipoL) {
	    this.ID_TipoL = IDTipoL;
	}
	
	public String getTipo_Leccion() {
	    return Tipo_Leccion;
	}

	public void setTipo_Leccion(String tipoLeccion) {
	    Tipo_Leccion = tipoLeccion;
	}
	

}
