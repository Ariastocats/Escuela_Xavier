package Datos;
import Modelo.LeccionesJB;
import Modelo.MutanteJB;
import Modelo.Tipo_LeccionJB;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class LeccionesDAO {
	public static final String selectSQL = "SELECT * FROM Lecciones";
	public static final String insertSQL = "Insert into Lecciones(Leccion,Horario_Ini,Horario_Fin,creditos,Tipo_Leccion) VALUES (?,?,?,?,?)";
	public static final String updateSQL = "UPDATE Lecciones SET Leccion=?,Horario_Ini,Horario_Fin,creditos,Tipo_Leccion WHERE ID_Leccion=?";
	public static final String deleteSQL = "DELETE FROM Lecciones WHERE ID_Leccion=?";
	
	public List<LeccionesJB> seleccionar(){
        Connection conn = null;
        Statement state = null;
        ResultSet result = null;
		LeccionesJB con = null;
		
		List<LeccionesJB> lec = new ArrayList<>();
		
		try {
            conn = Conexion.getConnection();
            state = conn.createStatement();
            result = state.executeQuery(selectSQL);
			
			while(result.next()) {
				int ID_Leccion = result.getInt("ID_Leccion");
				String Leccion=result.getString("Leccion");
				String Horario_Ini=result.getString("Horario_Ini");
				String Horario_Fin=result.getString("Horario_Fin");
				int creditos=result.getInt("creditos");
				int Tipo_Leccion=result.getInt("Tipo_Leccion");
				
				con = new LeccionesJB(ID_Leccion,Leccion,Horario_Ini,Horario_Fin,creditos,Tipo_Leccion);
				lec.add(con);
			}
			Conexion.close(result);
			Conexion.close(state);
			Conexion.close(conn);
			
			for(LeccionesJB c: lec) {
				System.out.println("Id de la Leccion: " + c.getID_Leccion());
				System.out.println("Leccion: " + c.getLeccion());
				System.out.println("Horario de inicio: " + c.getHora_Ini());
				System.out.println("Horario de Salida: " + c.getHora_Fin());
				System.out.println("Creditos: " + c.getCreditos());
				System.out.println("Id de la Leccion: " + c.getTipo_Leccion());
				
				System.out.println("\n");
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return lec;

		
	}
	
	public int agregar(LeccionesJB lec) {
		Connection conn = null;
		PreparedStatement state = null;
		int registros = 0;
		
		try {
			conn = Conexion.getConnection();
			state = conn.prepareStatement(insertSQL);
			
			state.setString(1,lec.getLeccion());
			state.setString(2,lec.getHora_Ini());
			state.setString(3,lec.getHora_Fin());
			state.setInt(4,lec.getCreditos());
			state.setInt(5,lec.getTipo_Leccion());
			
			
			
			registros = state.executeUpdate();
			if(registros>0) {
				System.out.println("Registro agregado correctamente");
			}
			
			Conexion.close(state);
			Conexion.close(conn);
			LeccionesJB lecNvo = new LeccionesJB();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		return registros;
	}
	
	public int borrar(LeccionesJB lec) {
		Connection conn = null;
		PreparedStatement state = null;
		int registros = 0;
		
		try {
			conn = Conexion.getConnection();
			state = conn.prepareStatement(deleteSQL);
			
			state.setInt(1,lec.getID_Leccion());
			registros = state.executeUpdate();
			
			if(registros>0) {
				System.out.println("Registro eliminado");
			}
			
			Conexion.close(state);
			Conexion.close(conn);
			LeccionesJB lecDelete = new LeccionesJB();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return registros;
	}
	
	public int modificar(LeccionesJB lec) {
		Connection conn = null;
		PreparedStatement state = null;
		int registros = 0;
		
		try {
			conn = Conexion.getConnection();
			state = conn.prepareStatement(updateSQL);
			
			state.setString(1,lec.getLeccion());
			state.setString(2,lec.getHora_Ini());
			state.setString(3,lec.getHora_Fin());
			state.setInt(4,lec.getCreditos());
			state.setInt(5,lec.getTipo_Leccion());
			state.setInt(6,lec.getID_Leccion());
			
			
			registros = state.executeUpdate();
			if(registros>0)
				System.out.println("Registro actualizado");
			
			Conexion.close(state);
			Conexion.close(conn);
			LeccionesJB lecMod = new LeccionesJB();
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return registros;
	}
	
}
