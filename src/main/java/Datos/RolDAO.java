package Datos;

import Modelo.RolJB;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class RolDAO {
	public static final String selectSQL = "SELECT * FROM Rol";
	public static final String insertSQL = "Insert into Rol(Rol) VALUES (?)";
	public static final String updateSQL = "UPDATE Rol SET Rol=? WHERE ID_Rol=?";
	public static final String deleteSQL = "DELETE FROM Rol WHERE ID_Rol=?";
	
	public List<RolJB> seleccionar(){
        Connection conn = null;
        Statement state = null;
        ResultSet result = null;
		RolJB con = null;
		
		List<RolJB> Roles = new ArrayList<>();
		
		try {
            conn = Conexion.getConnection();
            state = conn.createStatement();
            result = state.executeQuery(selectSQL);
			
			while(result.next()) {
				int ID_Rol = result.getInt("ID_Rol");
				String Rol=result.getString("Rol");
				
				con = new RolJB(ID_Rol,Rol);
				Roles.add(con);
			}
			Conexion.close(result);
			Conexion.close(state);
			Conexion.close(conn);
			
			for(RolJB c: Roles) {
				System.out.println("ID de Rol: " + c.getID_Rol());
				System.out.println("Tipo de usuario: " + c.getRol());
				System.out.println("\n");
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return Roles;

		
	}
	
	public int agregar(RolJB Roles) {
		Connection conn = null;
		PreparedStatement state = null;
		int registros = 0;
		
		try {
			conn = Conexion.getConnection();
			state = conn.prepareStatement(insertSQL);
			
			state.setString(1,Roles.getRol());
			
			registros = state.executeUpdate();
			if(registros>0) {
				System.out.println("Registro agregado correctamente");
			}
			
			Conexion.close(state);
			Conexion.close(conn);
			RolJB RolNvo = new RolJB();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		return registros;
	}
	
	public int borrar(RolJB Roles) {
		Connection conn = null;
		PreparedStatement state = null;
		int registros = 0;
		
		try {
			conn = Conexion.getConnection();
			state = conn.prepareStatement(deleteSQL);
			
			state.setInt(1,Roles.getID_Rol());
			registros = state.executeUpdate();
			
			if(registros>0) {
				System.out.println("Registro eliminado");
			}
			
			Conexion.close(state);
			Conexion.close(conn);
			RolJB RolDelete = new RolJB();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return registros;
	}
	
	public int modificar(RolJB Roles) {
		Connection conn = null;
		PreparedStatement state = null;
		int registros = 0;
		
		try {
			conn = Conexion.getConnection();
			state = conn.prepareStatement(updateSQL);
			
			state.setString(1,Roles.getRol());
			state.setInt(2,Roles.getID_Rol());
			
			
			registros = state.executeUpdate();
			if(registros>0)
				System.out.println("Registro actualizado");
			
			Conexion.close(state);
			Conexion.close(conn);
			RolJB rolMod = new RolJB();
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return registros;
	}


}
