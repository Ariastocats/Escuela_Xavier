package Datos;
import Modelo.Asist_PresentacionJB;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class Asist_PresentacionDAO {
	public static final String selectSQL = "SELECT * FROM Asist_Presentacion";
	public static final String insertSQL = "Insert into Asist_Presentacion(N_Presentacion,Curp) VALUES (?,?)";
	public static final String updateSQL = "UPDATE Asist_Presentacion SET N_Presentacion=?,Curp=? WHERE N_Presentacion=?";
	public static final String deleteSQL = "DELETE FROM Asist_Presentacion WHERE N_Presentacion=?";
	
	public List<Asist_PresentacionJB> seleccionar(){
        Connection conn = null;
        Statement state = null;
        ResultSet result = null;
		Asist_PresentacionJB con = null;
		
		List<Asist_PresentacionJB> Asisten = new ArrayList<>();
		
		try {
            conn = Conexion.getConnection();
            state = conn.createStatement();
            result = state.executeQuery(selectSQL);
			
			while(result.next()) {
				int N_Presentacion = result.getInt("N_Presentacion");
				
				int Curp=result.getInt("Curp");
				
				con = new Asist_PresentacionJB(N_Presentacion,Curp);
				Asisten.add(con);
			}
			Conexion.close(result);
			Conexion.close(state);
			Conexion.close(conn);
			
			for(Asist_PresentacionJB c: Asisten) {
				System.out.println("Id de Presentacion: " + c.getN_Presentacion());
				System.out.println("Curp: " + c.getCurp());
				
				System.out.println("\n");
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return Asisten;

		
	}
	
	public int agregar(Asist_PresentacionJB Asisten) {
		Connection conn = null;
		PreparedStatement state = null;
		int registros = 0;
		
		try {
			conn = Conexion.getConnection();
			state = conn.prepareStatement(insertSQL);
			
			state.setInt(1,Asisten.getN_Presentacion());
		
			state.setInt(2,Asisten.getCurp());
			
			registros = state.executeUpdate();
			if(registros>0) {
				System.out.println("Registro agregado correctamente");
			}
			
			Conexion.close(state);
			Conexion.close(conn);
			Asist_PresentacionJB asistNvo = new Asist_PresentacionJB();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		return registros;
	}
	
	public int borrar(Asist_PresentacionJB Asisten) {
		Connection conn = null;
		PreparedStatement state = null;
		int registros = 0;
		
		try {
			conn = Conexion.getConnection();
			state = conn.prepareStatement(deleteSQL);
			
			state.setInt(1,Asisten.getN_Presentacion());
			registros = state.executeUpdate();
			
			if(registros>0) {
				System.out.println("Registro eliminado");
			}
			
			Conexion.close(state);
			Conexion.close(conn);
			Asist_PresentacionJB asistDelete = new Asist_PresentacionJB();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return registros;
	}
	
	public int modificar(Asist_PresentacionJB Asisten) {
		Connection conn = null;
		PreparedStatement state = null;
		int registros = 0;
		
		try {
			conn = Conexion.getConnection();
			state = conn.prepareStatement(updateSQL);
			
			state.setInt(1,Asisten.getN_Presentacion());
			state.setInt(2,Asisten.getCurp());
			state.setInt(3,Asisten.getN_Presentacion());
			
			
			registros = state.executeUpdate();
			if(registros>0)
				System.out.println("Registro actualizado");
			
			Conexion.close(state);
			Conexion.close(conn);
			Asist_PresentacionJB asistMod = new Asist_PresentacionJB();
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return registros;
	}


}
