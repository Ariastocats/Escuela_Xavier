package Datos;
import Modelo.EstudianteJB;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import Modelo.ProfesorJB;
public class EstudianteDAO {
	public static final String selectSQL = "SELECT * FROM estudiantes";
	public static final String insertSQL = "Insert into Estudiante(Curp,Nombre,Apellido_Pat,Apellido_Mat,Poder,N_Alias,fecha_nac,cel,direcc,Rol,Correo_Inst,Contraseña,Status) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static final String updateSQL = "UPDATE Estudiante SET Curp=?,Nombre=?,Apellido_Pat=?,Apellido_Mat=?,Poder=?,N_Alias=?,fecha_nac=?,cel=?,direcc=?,Rol=?,Correo_Inst=?,Contraseña=?,Status=? WHERE Matricula=?";
	public static final String deleteSQL = "DELETE FROM Estudiante WHERE Matricula=?";
	public static final String joinest="SELECT estudiantes.curp,estudiantes.nombre,estudiantes.apellido_pat,estudiantes.apellido_mat,estudiantes.poder,estudiantes.n_alias,estudiantes.fecha_nac,estudiantes.cel,estudiantes.direcc, rol.rol as Rols,estudiantes.matricula, estudiantes.correo_inst,estudiantes.contraseña,estudiantes.status FROM estudiantes JOIN rol ON estudiantes.rol=rol.id_rol";
	
	public List<EstudianteJB> seleccionar(){
        Connection conn = null;
        Statement state = null;
        ResultSet result = null;
		EstudianteJB con = null;
		
		List<EstudianteJB> est = new ArrayList<>();
		
		try {
            conn = Conexion.getConnection();
            state = conn.createStatement();
            result = state.executeQuery(selectSQL);
			
			while(result.next()) {
				int Curp = result.getInt("Curp");
				String Nombre = result.getString("Nombre");
				String Apellido_Pat = result.getString("Apellido_Pat");
				String Apellido_Mat = result.getString("Apellido_Mat");
				String Poder = result.getString("Poder");
				String N_Alias= result.getString("N_Alias");
				String fecha_nac = result.getString("fecha_nac");
				String cel = result.getString("cel");
				String direcc=result.getString("direcc");
				int Rol=result.getInt("Rol");
				int Matricula=result.getInt("Matricula");
				String Correo_Inst = result.getString("Correo_Inst");
				String Contraseña = result.getString("Contraseña");
				String Status = result.getString("Status");
				
				con = new EstudianteJB(Curp,Nombre,Apellido_Pat,Apellido_Mat,Poder,N_Alias,fecha_nac,cel,direcc,Rol,Matricula,Correo_Inst,Contraseña,Status);
				est.add(con);
			}
			Conexion.close(result);
			Conexion.close(state);
			Conexion.close(conn);
			
			for(EstudianteJB c: est) {
				System.out.println("Curp: " + c.getCurp());
				System.out.println("Nombre: " + c.getNombre());
				System.out.println("Apellido paterno: " + c.getApellido_Pat());
				System.out.println("Apellido materno: " + c.getApellido_Mat());
				System.out.println("Poder: " + c.getPoder());
				System.out.println("Alias: " + c.getN_Alias());
				System.out.println("Fecha de Nacimiento: " + c.getFecha_nac());
				System.out.println("Numero de celular: " + c.getCel());
				System.out.println("Direccion: " + c.getDirecc());
				System.out.println("Tipo de usuario: " + c.getRol());
				System.out.println("Matricula De Profesor: " + c.getMatricula());
				System.out.println("Correo: " + c.getCorreo_Inst());
				System.out.println("Contraseña: " + c.getContraseña());
				System.out.println("Status: " + c.getStatus());
				System.out.println("\n");
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return est;
	}
	
	public List<EstudianteJB> joinest(){
        Connection conn = null;
        Statement state = null;
        ResultSet result = null;
		EstudianteJB con = null;
		
		List<EstudianteJB> est = new ArrayList<>();
		
		try {
            conn = Conexion.getConnection();
            state = conn.createStatement();
            result = state.executeQuery(joinest);
			
			while(result.next()) {
				int Curp = result.getInt("Curp");
				String Nombre = result.getString("Nombre");
				String Apellido_Pat = result.getString("Apellido_Pat");
				String Apellido_Mat = result.getString("Apellido_Mat");
				String Poder = result.getString("Poder");
				String N_Alias= result.getString("N_Alias");
				String fecha_nac = result.getString("fecha_nac");
				String cel = result.getString("cel");
				String direcc=result.getString("direcc");
				String Rols=result.getString("Rols");
				int Matricula=result.getInt("Matricula");
				String Correo_Inst = result.getString("Correo_Inst");
				String Contraseña = result.getString("Contraseña");
				String Status = result.getString("Status");
				
				con = new EstudianteJB(Curp,Nombre,Apellido_Pat,Apellido_Mat,Poder,N_Alias,fecha_nac,cel,direcc,Rols,Matricula,Correo_Inst,Contraseña,Status);
				est.add(con);
			}
			Conexion.close(result);
			Conexion.close(state);
			Conexion.close(conn);
			
			for(EstudianteJB c: est) {
				System.out.println("Curp: " + c.getCurp());
				System.out.println("Nombre: " + c.getNombre());
				System.out.println("Apellido paterno: " + c.getApellido_Pat());
				System.out.println("Apellido materno: " + c.getApellido_Mat());
				System.out.println("Poder: " + c.getPoder());
				System.out.println("Alias: " + c.getN_Alias());
				System.out.println("Fecha de Nacimiento: " + c.getFecha_nac());
				System.out.println("Numero de celular: " + c.getCel());
				System.out.println("Direccion: " + c.getDirecc());
				System.out.println("Tipo de usuario: " + c.getRols());
				System.out.println("Matricula De Profesor: " + c.getMatricula());
				System.out.println("Correo: " + c.getCorreo_Inst());
				System.out.println("Contraseña: " + c.getContraseña());
				System.out.println("Status: " + c.getStatus());
				System.out.println("\n");
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return est;
	}
	
	public int agregar(EstudianteJB est) {
		Connection conn = null;
		PreparedStatement state = null;
		int registros = 0;
		
		try {
			conn = Conexion.getConnection();
			state = conn.prepareStatement(insertSQL);
			state.setInt(1,est.getCurp());
			state.setString(2,est.getNombre());
			state.setString(3,est.getApellido_Pat());
			state.setString(4,est.getApellido_Mat());
			state.setString(5,est.getPoder());
			state.setString(6,est.getN_Alias());
			state.setString(7,est.getFecha_nac());
			state.setString(8,est.getCel());
			state.setString(9,est.getDirecc());
			state.setInt(10,est.getRol());
			state.setString(11,est.getCorreo_Inst());
			state.setString(12,est.getContraseña());
			state.setString(13,est.getStatus());
			
			registros = state.executeUpdate();
			if(registros>0) {
				System.out.println("Registro agregado correctamente");
			}
			
			Conexion.close(state);
			Conexion.close(conn);
			EstudianteJB estudianteNvo = new EstudianteJB();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		return registros;
	}
	
	public int borrar(EstudianteJB est) {
		Connection conn = null;
		PreparedStatement state = null;
		int registros = 0;
		
		try {
			conn = Conexion.getConnection();
			state = conn.prepareStatement(deleteSQL);
			
			state.setInt(1,est.getMatricula());
			registros = state.executeUpdate();
			
			if(registros>0) {
				System.out.println("Registro eliminado");
			}
			
			Conexion.close(state);
			Conexion.close(conn);
			ProfesorJB estudianteDelete = new ProfesorJB();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return registros;
	}
	
	public int modificar(EstudianteJB est) {
		Connection conn = null;
		PreparedStatement state = null;
		int registros = 0;
		
		try {
			conn = Conexion.getConnection();
			state = conn.prepareStatement(updateSQL);
			state.setInt(1,est.getCurp());
			state.setString(2,est.getNombre());
			state.setString(3,est.getApellido_Pat());
			state.setString(4,est.getApellido_Mat());
			state.setString(5,est.getPoder());
			state.setString(6,est.getN_Alias());
			state.setString(7,est.getFecha_nac());
			state.setString(8,est.getCel());
			state.setString(9,est.getDirecc());
			state.setInt(10,est.getRol());
			state.setString(13,est.getCorreo_Inst());
			state.setString(14,est.getContraseña());
			state.setString(15,est.getStatus());
			state.setInt(16,est.getMatricula());
			
			registros = state.executeUpdate();
			if(registros>0)
				System.out.println("Registro actualizado");
			
			Conexion.close(state);
			Conexion.close(conn);
			EstudianteJB estudianteMod = new EstudianteJB();
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return registros;
	}


}
