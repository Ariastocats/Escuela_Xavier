import java.io.Serializable;
public class LeccionesJB implements Serializable{
	private String ID_Leccion;
	private String Leccion;
	private time Hora_Ini;
	private time Hora_Fin;
	private int creditos;
	private int Tipo_Leccion;
	
	public LeccionesJB(){
		
	}
	public LeccionesJB(String IDLeccion,String Leccion,time HoraIni,time HoraFin,int creditos,int TipoLeccion){
		this.ID_Leccion=IDLeccion;
		this.Leccion=Leccion;
		this.Hora_Ini=HoraIni;
		this.Hora_Fin=HoraFin;
		this.creditos=creditos;
		this.Tipo_Leccion=TipoLeccion;
	}
	
	public String getID_Leccion() {
	    return ID_Leccion;
	}

	public void setID_Leccion(String IDLeccion) {
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


}
