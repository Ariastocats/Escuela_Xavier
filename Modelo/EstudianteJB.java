import java.io.Serializable;
public class EstudianteJB implements Serializable{
	
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
	private String Matricula;
	private String Correo_Inst;
	
	public EstudianteJB() {
		
	}
	
	public EstudianteJB(String Curp, String Nombre,String ApellidoPat,String ApellidoMat,String Poder,
			String NAlias,date fechanac,String cel,String direcc, String Rol,String Matricula,String CorreoInst) {
		
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
		this.Matricula=Matricula;
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
	
	public String getMatricula() {
	    return Matricula;
	}

	public void setMatricula(String matricula) {
	    Matricula = matricula;
	}
	
	public String getCorreo_Inst() {
	    return Correo_Inst;
	}

	public void setCorreo_Inst(String correoInst) {
	    Correo_Inst = correoInst;
	}

}
