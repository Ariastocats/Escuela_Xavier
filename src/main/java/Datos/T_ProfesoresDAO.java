package Datos;
import Modelo.T_ProfesoresJB;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class T_ProfesoresDAO {
	public static final String selectSQL = "SELECT * FROM T_Profesores";
	public static final String insertSQL = "Insert into T_Profesores(Tiempo) VALUES (?)";
	public static final String updateSQL = "UPDATE T_Profesores SET Tiempo=? WHERE ID_TipoP=?";
	public static final String deleteSQL = "DELETE FROM T_Profesores WHERE ID_TipoP=?";
	
	public List<T_ProfesoresJB> seleccionar(){
        Connection conn = null;
        Statement state = null;
        ResultSet result = null;
		T_ProfesoresJB con = null;
		
		List<T_ProfesoresJB> Tipop = new ArrayList<>();
		
		try {
            conn = Conexion.getConnection();
            state = conn.createStatement();
            result = state.executeQuery(selectSQL);
			
			while(result.next()) {
				int ID_TipoP = result.getInt("ID_TipoP");
				
				String Tiempo=result.getString("Tiempo");
				
				con = new T_ProfesoresJB(ID_TipoP,Tiempo);
				Tipop.add(con);
			}
			Conexion.close(result);
			Conexion.close(state);
			Conexion.close(conn);
			
			for(T_ProfesoresJB c: Tipop) {
				System.out.println("Id de Presentacion: " + c.getID_TipoP());
				System.out.println("Tiempo: " + c.getTiempo());
				
				System.out.println("\n");
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return Tipop;

		
	}
	
	public int agregar(T_ProfesoresJB Tipop) {
		Connection conn = null;
		PreparedStatement state = null;
		int registros = 0;
		
		try {
			conn = Conexion.getConnection();
			state = conn.prepareStatement(insertSQL);
			
			state.setString(1,Tipop.getTiempo());
			
			registros = state.executeUpdate();
			if(registros>0) {
				System.out.println("Registro agregado correctamente");
			}
			
			Conexion.close(state);
			Conexion.close(conn);
			T_ProfesoresJB tipopNvo = new T_ProfesoresJB();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		return registros;
	}
	
	public int borrar(T_ProfesoresJB tipop) {
		Connection conn = null;
		PreparedStatement state = null;
		int registros = 0;
		
		try {
			conn = Conexion.getConnection();
			state = conn.prepareStatement(deleteSQL);
			
			state.setInt(1,tipop.getID_TipoP());
			registros = state.executeUpdate();
			
			if(registros>0) {
				System.out.println("Registro eliminado");
			}
			
			Conexion.close(state);
			Conexion.close(conn);
			T_ProfesoresJB tipopDelete = new T_ProfesoresJB();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return registros;
	}
	
	public int modificar(T_ProfesoresJB tipop) {
		Connection conn = null;
		PreparedStatement state = null;
		int registros = 0;
		
		try {
			conn = Conexion.getConnection();
			state = conn.prepareStatement(updateSQL);
			
			state.setString(1,tipop.getTiempo());
			state.setInt(2,tipop.getID_TipoP());
			
			
			registros = state.executeUpdate();
			if(registros>0)
				System.out.println("Registro actualizado");
			
			Conexion.close(state);
			Conexion.close(conn);
			T_ProfesoresJB tipopMod = new T_ProfesoresJB();
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return registros;
	}


}
