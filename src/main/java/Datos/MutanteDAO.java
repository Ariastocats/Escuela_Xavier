package Datos;
import Modelo.MutanteJB;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class MutanteDAO {
	public static final String selectSQL = "SELECT * FROM only Mutante";
	public static final String insertSQL = "Insert into Mutante(Nombre,Apellido_Pat,Apellido_Mat,Poder,N_Alias,fecha_nac,cel,direcc,Rol) VALUES (?,?,?,?,?,?,?,?,?)";
	public static final String updateSQL = "UPDATE Mutante SET Nombre=?,Apellido_Pat=?,Apellido_Mat=?,Poder=?,N_Alias=?,fecha_nac=?,cel=?,direcc=?,Rol=? WHERE Curp=?";
	public static final String deleteSQL = "DELETE FROM Mutante WHERE Curp=?";
	public static final String seljoin= "SELECT mutante.curp,mutante.nombre,mutante.apellido_pat,mutante.apellido_mat,mutante.poder,mutante.n_alias,mutante.fecha_nac,mutante.cel,mutante.direcc, rol.rol as Rols FROM only mutante JOIN rol ON rol.id_rol=mutante.rol ORDER BY mutante.curp";
	
	public List<MutanteJB> seleccionar(){
        Connection conn = null;
        Statement state = null;
        ResultSet result = null;
		MutanteJB con = null;
		
		List<MutanteJB> Mutantes = new ArrayList<>();
		
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
				
				con = new MutanteJB(Curp,Nombre,Apellido_Pat,Apellido_Mat,Poder,N_Alias,fecha_nac,cel,direcc,Rol);
				Mutantes.add(con);
			}
			Conexion.close(result);
			Conexion.close(state);
			Conexion.close(conn);
			
			for(MutanteJB c: Mutantes) {
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
				System.out.println("\n");
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return Mutantes;

		
	}
	
	public List<MutanteJB> seljoin(){
        Connection conn = null;
        Statement state = null;
        ResultSet result = null;
		MutanteJB con = null;
		
		List<MutanteJB> Mutantes = new ArrayList<>();
		
		try {
            conn = Conexion.getConnection();
            state = conn.createStatement();
            result = state.executeQuery(seljoin);
			
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
				
				con = new MutanteJB(Curp,Nombre,Apellido_Pat,Apellido_Mat,Poder,N_Alias,fecha_nac,cel,direcc,Rols);
				Mutantes.add(con);
			}
			Conexion.close(result);
			Conexion.close(state);
			Conexion.close(conn);
			
			for(MutanteJB c: Mutantes) {
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
				System.out.println("\n");
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return Mutantes;

		
	}
	
	public int agregar(MutanteJB Mutantes) {
		Connection conn = null;
		PreparedStatement state = null;
		int registros = 0;
		
		try {
			conn = Conexion.getConnection();
			state = conn.prepareStatement(insertSQL);
			
			state.setString(1,Mutantes.getNombre());
			state.setString(2,Mutantes.getApellido_Pat());
			state.setString(3,Mutantes.getApellido_Mat());
			state.setString(4,Mutantes.getPoder());
			state.setString(5,Mutantes.getN_Alias());
			state.setString(6,Mutantes.getFecha_nac());
			state.setString(7,Mutantes.getCel());
			state.setString(8,Mutantes.getDirecc());
			state.setInt(9,Mutantes.getRol());
			
			registros = state.executeUpdate();
			if(registros>0) {
				System.out.println("Registro agregado correctamente");
			}
			
			Conexion.close(state);
			Conexion.close(conn);
			MutanteJB mutanteNvo = new MutanteJB();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		return registros;
	}
	
	public int borrar(MutanteJB Mutantes) {
		Connection conn = null;
		PreparedStatement state = null;
		int registros = 0;
		
		try {
			conn = Conexion.getConnection();
			state = conn.prepareStatement(deleteSQL);
			
			state.setInt(1,Mutantes.getCurp());
			registros = state.executeUpdate();
			
			if(registros>0) {
				System.out.println("Registro eliminado");
			}
			
			Conexion.close(state);
			Conexion.close(conn);
			MutanteJB mutanteDelete = new MutanteJB();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return registros;
	}
	
	public int modificar(MutanteJB Mutantes) {
		Connection conn = null;
		PreparedStatement state = null;
		int registros = 0;
		
		try {
			conn = Conexion.getConnection();
			state = conn.prepareStatement(updateSQL);
			
			state.setString(1,Mutantes.getNombre());
			state.setString(2,Mutantes.getApellido_Pat());
			state.setString(3,Mutantes.getApellido_Mat());
			state.setString(4,Mutantes.getPoder());
			state.setString(5,Mutantes.getN_Alias());
			state.setString(6,Mutantes.getFecha_nac());
			state.setString(7,Mutantes.getCel());
			state.setString(8,Mutantes.getDirecc());
			state.setInt(9,Mutantes.getRol());
			state.setInt(10,Mutantes.getCurp());
			
			
			registros = state.executeUpdate();
			if(registros>0)
				System.out.println("Registro actualizado");
			
			Conexion.close(state);
			Conexion.close(conn);
			MutanteJB mutanteMod = new MutanteJB();
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return registros;
	}

	
}
