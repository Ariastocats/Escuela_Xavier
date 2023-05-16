import java.io.Serializable;
public class CursoProfJB {
	
	private String Matricula_Prof;
	private String ID_Leccion;
	private String Semestre;
	
	public CursoProfJB() {
		
	}
	public CursoProfJB(String MatriculaProf,String IDLeccion,String Semestre) {
		
		this.Matricula_Prof=MatriculaProf;
		this.ID_Leccion=IDLeccion;
		this.Semestre=Semestre;
		
	}
	
	public String getMatricula_Prof() {
	    return Matricula_Prof;
	}

	public void setMatricula_Prof(String matriculaProf) {
	    Matricula_Prof = matriculaProf;
	}
	
	public String getID_Leccion() {
	    return ID_Leccion;
	}

	public void setID_Leccion(String IDLeccion) {
	    this.ID_Leccion = IDLeccion;
	}
	
	public String getSemestre() {
	    return Semestre;
	}

	public void setSemestre(String semestre) {
	    Semestre = semestre;
	}

}
