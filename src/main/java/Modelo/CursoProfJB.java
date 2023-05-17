package Modelo;

import java.io.Serializable;
public class CursoProfJB implements Serializable{
	
	private int Matricula_Prof;
	private int ID_Leccion;
	private String Semestre;
	
	public CursoProfJB() {
		
	}
	public CursoProfJB(int MatriculaProf,int IDLeccion,String Semestre) {
		
		this.Matricula_Prof=MatriculaProf;
		this.ID_Leccion=IDLeccion;
		this.Semestre=Semestre;
		
	}
	
	public int getMatricula_Prof() {
	    return Matricula_Prof;
	}

	public void setMatricula_Prof(int matriculaProf) {
	    Matricula_Prof = matriculaProf;
	}
	
	public int getID_Leccion() {
	    return ID_Leccion;
	}

	public void setID_Leccion(int IDLeccion) {
	    this.ID_Leccion = IDLeccion;
	}
	
	public String getSemestre() {
	    return Semestre;
	}

	public void setSemestre(String semestre) {
	    Semestre = semestre;
	}

}
