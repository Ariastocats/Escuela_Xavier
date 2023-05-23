package Datos;
import Modelo.Tipo_LeccionJB;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class Tipo_LeccionDAO {
	public static final String selectSQL = "SELECT * FROM Tipo_Leccion";
	public static final String insertSQL = "Insert into Tipo_Leccion(Tipo_Leccion) VALUES (?)";
	public static final String updateSQL = "UPDATE Tipo_Leccion SET Tipo_Leccion=? WHERE ID_TipoL=?";
	public static final String deleteSQL = "DELETE FROM Tipo_Leccion WHERE ID_TipoL=?";
	
	public List<Tipo_LeccionJB> seleccionar(){
        Connection conn = null;
        Statement state = null;
        ResultSet result = null;
		Tipo_LeccionJB con = null;
		
		List<Tipo_LeccionJB> Tipol = new ArrayList<>();
		
		try {
            conn = Conexion.getConnection();
            state = conn.createStatement();
            result = state.executeQuery(selectSQL);
			
			while(result.next()) {
				int ID_TipoL = result.getInt("ID_TipoL");
				
				String Tipo_Leccion=result.getString("Tipo_Leccion");
				
				con = new Tipo_LeccionJB(ID_TipoL,Tipo_Leccion);
				Tipol.add(con);
			}
			Conexion.close(result);
			Conexion.close(state);
			Conexion.close(conn);
			
			for(Tipo_LeccionJB c: Tipol) {
				System.out.println("Id de Presentacion: " + c.getID_TipoL());
				System.out.println("Tiempo: " + c.getTipo_Leccion());
				
				System.out.println("\n");
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return Tipol;

		
	}
	
	public int agregar(Tipo_LeccionJB Tipol) {
		Connection conn = null;
		PreparedStatement state = null;
		int registros = 0;
		
		try {
			conn = Conexion.getConnection();
			state = conn.prepareStatement(insertSQL);
			
			state.setString(1,Tipol.getTipo_Leccion());
			
			registros = state.executeUpdate();
			if(registros>0) {
				System.out.println("Registro agregado correctamente");
			}
			
			Conexion.close(state);
			Conexion.close(conn);
			Tipo_LeccionJB tipolNvo = new Tipo_LeccionJB();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		return registros;
	}
	
	public int borrar(Tipo_LeccionJB tipol) {
		Connection conn = null;
		PreparedStatement state = null;
		int registros = 0;
		
		try {
			conn = Conexion.getConnection();
			state = conn.prepareStatement(deleteSQL);
			
			state.setInt(1,tipol.getID_TipoL());
			registros = state.executeUpdate();
			
			if(registros>0) {
				System.out.println("Registro eliminado");
			}
			
			Conexion.close(state);
			Conexion.close(conn);
			Tipo_LeccionJB tipolDelete = new Tipo_LeccionJB();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return registros;
	}
	
	public int modificar(Tipo_LeccionJB tipol) {
		Connection conn = null;
		PreparedStatement state = null;
		int registros = 0;
		
		try {
			conn = Conexion.getConnection();
			state = conn.prepareStatement(updateSQL);
			
			state.setString(1,tipol.getTipo_Leccion());
			state.setInt(2,tipol.getID_TipoL());
			
			
			registros = state.executeUpdate();
			if(registros>0)
				System.out.println("Registro actualizado");
			
			Conexion.close(state);
			Conexion.close(conn);
			Tipo_LeccionJB tipolMod = new Tipo_LeccionJB();
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return registros;
	}

}
