package Modelo;

import java.io.Serializable;
public class ProfesorJB implements Serializable{
	private int  Curp;
	private String Nombre;
	private String Apellido_Pat;
	private String Apellido_Mat;
	private String Poder;
	private String N_Alias;
	private String fecha_nac;
	private String cel;
	private String direcc;
	private int Rol;
	private int Matricula_P;
	private int Remuneracion;
	private int T_Profesores;
	private String Correo_Inst;
	private String Contraseña;
	private String Status;
	
	public ProfesorJB() {
		
	}
	public ProfesorJB(int Curp, String Nombre,String ApellidoPat,String ApellidoMat,String Poder,
			String NAlias,String fechanac,String cel,String direcc, int Rol,int MatriculaP,int Remuneracion,
			int TProfesores,String CorreoInst,String Contraseña,String Status) {
		this.Curp=Curp;
		this.Nombre=Nombre;
		this.Apellido_Pat=ApellidoPat;
		this.Apellido_Mat=ApellidoMat;
		this.Poder=Poder;
		this.N_Alias=NAlias;
		this.fecha_nac=fechanac;
		this.cel=cel;
		this.direcc=direcc;
		this.Rol=Rol;
		this.Matricula_P=MatriculaP;
		this.Remuneracion=Remuneracion;
		this.T_Profesores=TProfesores;
		this.Correo_Inst=CorreoInst;
		this.Contraseña=Contraseña;
		this.Status=Status;
		
	}
	
	public int getCurp() {
	    return Curp;
	}

	public void setCurp(int curp) {
	    Curp = curp;
	}

	public String getNombre() {
	    return Nombre;
	}

	public void setNombre(String nombre) {
	    Nombre = nombre;
	}
	
	public String getApellido_Pat() {
	    return Apellido_Pat;
	}

	public void setApellido_Pat(String apellidoPat) {
	    Apellido_Pat = apellidoPat;
	}
	
	public String getApellido_Mat() {
	    return Apellido_Mat;
	}

	public void setApellido_Mat(String apellidoMat) {
	    Apellido_Mat = apellidoMat;
	}

	public String getPoder() {
	    return Poder;
	}

	public void setPoder(String poder) {
	    Poder = poder;
	}
	
	public String getN_Alias() {
	    return N_Alias;
	}

	public void setN_Alias(String nAlias) {
	    N_Alias = nAlias;
	}
	
	public String getFecha_nac() {
	    return fecha_nac;
	}

	public void setFecha_nac(String fechanac) {
	    this.fecha_nac = fechanac;
	}
	
	public String getCel() {
	    return cel;
	}

	public void setCel(String cel) {
	    this.cel = cel;
	}
	
	public String getDirecc() {
	    return direcc;
	}

	public void setDirecc(String direcc) {
	    this.direcc = direcc;
	}
	
	public int getRol() {
	    return Rol;
	}

	public void setRol(int rol) {
	    Rol = rol;
	}
	
	public int getMatricula_P() {
	    return Matricula_P;
	}

	public void setMatricula_P(int matriculaP) {
	    Matricula_P = matriculaP;
	}
	
	public int getRemuneracion() {
	    return Remuneracion;
	}

	public void setRemuneracion(int remuneracion) {
	    Remuneracion = remuneracion;
	}
	
	public int getT_Profesores() {
	    return T_Profesores;
	}

	public void setT_Profesores(int tProfesores) {
	    T_Profesores = tProfesores;
	}
	
	public String getCorreo_Inst() {
	    return Correo_Inst;
	}

	public void setCorreo_Inst(String correoInst) {
	    Correo_Inst = correoInst;
	}
	
	public String getContraseña() {
	    return Contraseña;
	}

	public void setContraseña(String contraseña) {
	    Contraseña = contraseña;
	}
	
	public String getStatus() {
	    return Status;
	}

	public void setStatus(String status) {
	    Status = status;
	}


}