package Datos;
import Modelo.ProfesorJB;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProfesorDAO {
	public static final String selectSQL = "SELECT * FROM Profesor";
	public static final String insertSQL = "Insert into Profesor(Curp,Nombre,Apellido_Pat,Apellido_Mat,Poder,N_Alias,fecha_nac,cel,direcc,Rol,Remuneracion,T_Profesores,Correo_Inst,Contraseña,Status) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static final String updateSQL = "UPDATE Profesor SET Curp=?,Nombre=?,Apellido_Pat=?,Apellido_Mat=?,Poder=?,N_Alias=?,fecha_nac=?,cel=?,direcc=?,Rol=?,Remuneracion=?,T_Profesores=?,Correo_Inst=?,Contraseña=?,Status=? WHERE Matricula_P=?";
	public static final String deleteSQL = "DELETE FROM Profesor WHERE Matricula_P=?";
	
	public List<ProfesorJB> seleccionar(){
        Connection conn = null;
        Statement state = null;
        ResultSet result = null;
		ProfesorJB con = null;
		
		List<ProfesorJB> profesores = new ArrayList<>();
		
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
				int Matricula_P=result.getInt("Matricula_P");
				int Remuneracion=result.getInt("Remuneracion");
				int T_Profesores = result.getInt("T_Profesores");
				String Correo_Inst = result.getString("Correo_Inst");
				String Contraseña = result.getString("Contraseña");
				String Status = result.getString("Status");
				
				con = new ProfesorJB(Curp,Nombre,Apellido_Pat,Apellido_Mat,Poder,N_Alias,fecha_nac,cel,direcc,Rol,Matricula_P,Remuneracion,T_Profesores,Correo_Inst,Contraseña,Status);
				profesores.add(con);
			}
			Conexion.close(result);
			Conexion.close(state);
			Conexion.close(conn);
			
			for(ProfesorJB c: profesores) {
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
				System.out.println("Matricula De Profesor: " + c.getMatricula_P());
				System.out.println("Remuneracion: " + c.getRemuneracion());
				System.out.println("Tipo de Profesor: " + c.getT_Profesores());
				System.out.println("Correo: " + c.getCorreo_Inst());
				System.out.println("Contraseña: " + c.getContraseña());
				System.out.println("Status: " + c.getStatus());
				System.out.println("\n");
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return profesores;
	}
	
	public int agregar(ProfesorJB profesores) {
		Connection conn = null;
		PreparedStatement state = null;
		int registros = 0;
		
		try {
			conn = Conexion.getConnection();
			state = conn.prepareStatement(insertSQL);
			state.setInt(1,profesores.getCurp());
			state.setString(2,profesores.getNombre());
			state.setString(3,profesores.getApellido_Pat());
			state.setString(4,profesores.getApellido_Mat());
			state.setString(5,profesores.getPoder());
			state.setString(6,profesores.getN_Alias());
			state.setString(7,profesores.getFecha_nac());
			state.setString(8,profesores.getCel());
			state.setString(9,profesores.getDirecc());
			state.setInt(10,profesores.getRol());
			state.setInt(11,profesores.getRemuneracion());
			state.setInt(12,profesores.getT_Profesores());
			state.setString(13,profesores.getCorreo_Inst());
			state.setString(14,profesores.getContraseña());
			state.setString(15,profesores.getStatus());
			
			registros = state.executeUpdate();
			if(registros>0) {
				System.out.println("Registro agregado correctamente");
			}
			
			Conexion.close(state);
			Conexion.close(conn);
			ProfesorJB profesorNvo = new ProfesorJB();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		return registros;
	}
	
	public int borrar(ProfesorJB profesores) {
		Connection conn = null;
		PreparedStatement state = null;
		int registros = 0;
		
		try {
			conn = Conexion.getConnection();
			state = conn.prepareStatement(deleteSQL);
			
			state.setInt(1,profesores.getMatricula_P());
			registros = state.executeUpdate();
			
			if(registros>0) {
				System.out.println("Registro eliminado");
			}
			
			Conexion.close(state);
			Conexion.close(conn);
			ProfesorJB profesorDelete = new ProfesorJB();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return registros;
	}
	
	public int modificar(ProfesorJB profesores) {
		Connection conn = null;
		PreparedStatement state = null;
		int registros = 0;
		
		try {
			conn = Conexion.getConnection();
			state = conn.prepareStatement(updateSQL);
			state.setInt(1,profesores.getCurp());
			state.setString(2,profesores.getNombre());
			state.setString(3,profesores.getApellido_Pat());
			state.setString(4,profesores.getApellido_Mat());
			state.setString(5,profesores.getPoder());
			state.setString(6,profesores.getN_Alias());
			state.setString(7,profesores.getFecha_nac());
			state.setString(8,profesores.getCel());
			state.setString(9,profesores.getDirecc());
			state.setInt(10,profesores.getRol());
			state.setInt(11,profesores.getRemuneracion());
			state.setInt(12,profesores.getT_Profesores());
			state.setString(13,profesores.getCorreo_Inst());
			state.setString(14,profesores.getContraseña());
			state.setString(15,profesores.getStatus());
			state.setInt(16,profesores.getMatricula_P());
			
			registros = state.executeUpdate();
			if(registros>0)
				System.out.println("Registro actualizado");
			
			Conexion.close(state);
			Conexion.close(conn);
			ProfesorJB profesorMod = new ProfesorJB();
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return registros;
	}

}
