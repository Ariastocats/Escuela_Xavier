package Datos;
import Modelo.CursoJB;
import Modelo.CursoProfJB;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CursoDAO {
	public static final String selectSQL = "SELECT * FROM Curso";
	public static final String insertSQL = "Insert into Curso(ID_Est,ID_Leccion,calificacion) VALUES (?,?,?)";
	public static final String updateSQL = "UPDATE Curso SET ID_Est=?,ID_Leccion=?, calificacion=? WHERE ID_Est=?";
	public static final String deleteSQL = "DELETE FROM Curso WHERE ID_Est=?";
	
	public List<CursoJB> seleccionar(){
        Connection conn = null;
        Statement state = null;
        ResultSet result = null;
		CursoJB con = null;
		
		List<CursoJB> cur = new ArrayList<>();
		
		try {
            conn = Conexion.getConnection();
            state = conn.createStatement();
            result = state.executeQuery(selectSQL);
			
			while(result.next()) {
				int ID_Est = result.getInt("ID_Est");
				
				int ID_Leccion=result.getInt("ID_Leccion");
				float calificacion=result.getFloat("calificacion");
				
				con = new CursoJB(ID_Est,ID_Leccion,calificacion);
				cur.add(con);
			}
			Conexion.close(result);
			Conexion.close(state);
			Conexion.close(conn);
			
			for(CursoJB c: cur) {
				System.out.println("Id del estudiante: " + c.getID_Est());
				System.out.println("ID de la leccion: " + c.getID_Leccion());
				
				System.out.println("semestre: " + c.getCalificacion());
				
				System.out.println("\n");
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return cur;

		
	}
	
	public int agregar(CursoJB cur) {
		Connection conn = null;
		PreparedStatement state = null;
		int registros = 0;
		
		try {
			conn = Conexion.getConnection();
			state = conn.prepareStatement(insertSQL);
			
			state.setInt(1,cur.getID_Est());
		
			state.setInt(2,cur.getID_Leccion());
			state.setFloat(3,cur.getCalificacion());
			
			registros = state.executeUpdate();
			if(registros>0) {
				System.out.println("Registro agregado correctamente");
			}
			
			Conexion.close(state);
			Conexion.close(conn);
			CursoJB cursoNvo = new CursoJB();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		return registros;
	}
	
	public int borrar(CursoJB cur) {
		Connection conn = null;
		PreparedStatement state = null;
		int registros = 0;
		
		try {
			conn = Conexion.getConnection();
			state = conn.prepareStatement(deleteSQL);
			
			state.setInt(1,cur.getID_Est());
			registros = state.executeUpdate();
			
			if(registros>0) {
				System.out.println("Registro eliminado");
			}
			
			Conexion.close(state);
			Conexion.close(conn);
			CursoJB cursoDelete = new CursoJB();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return registros;
	}
	
	public int modificar(CursoJB cur) {
		Connection conn = null;
		PreparedStatement state = null;
		int registros = 0;
		
		try {
			conn = Conexion.getConnection();
			state = conn.prepareStatement(updateSQL);
			
			state.setInt(1,cur.getID_Est());
			state.setInt(2,cur.getID_Leccion());
			state.setFloat(3,cur.getCalificacion());
			state.setInt(4,cur.getID_Est());
			
			
			registros = state.executeUpdate();
			if(registros>0)
				System.out.println("Registro actualizado");
			
			Conexion.close(state);
			Conexion.close(conn);
			CursoJB cursoMod = new CursoJB();
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return registros;
	}

}
