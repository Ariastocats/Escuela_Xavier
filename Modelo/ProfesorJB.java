import java.io.Serializable;
public class ProfesorJB implements Serializable{
	private String  Curp;
	private String Nombre;
	private String Apellido_Pat;
	private String Apellido_Mat;
	private String Poder;
	private String N_Alias;
	private date fecha_nac;
	private String cel;
	private String direcc;
	private String Rol;
	private String Matricula_P;
	private int Remuneracion;
	private int T_Profesores;
	private String Correo_Inst;
	
	public ProfesorJB() {
		
	}
	public ProfesorJB(String Curp, String Nombre,String ApellidoPat,String ApellidoMat,String Poder,
			String NAlias,date fechanac,String cel,String direcc, String Rol,String MatriculaP,int Remuneracion,
			int TProfesores,String CorreoInst) {
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
		
	}
	
	public String getCurp() {
	    return Curp;
	}

	public void setCurp(String curp) {
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
	
	public Date getFecha_nac() {
	    return fecha_nac;
	}

	public void setFecha_nac(Date fechanac) {
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
	
	public String getRol() {
	    return Rol;
	}

	public void setRol(String rol) {
	    Rol = rol;
	}
	
	public String getMatricula_P() {
	    return Matricula_P;
	}

	public void setMatricula_P(String matriculaP) {
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

}
