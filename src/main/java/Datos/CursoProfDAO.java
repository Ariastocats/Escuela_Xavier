package Datos;

import Modelo.CursoProfJB;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CursoProfDAO {
	public static final String selectSQL = "SELECT * FROM CursoProf";
	public static final String insertSQL = "Insert into CursoProf(Matricula_Prof,ID_Leccion,semestre) VALUES (?,?,?)";
	public static final String updateSQL = "UPDATE CursoProf SET Matricula_Prof=?,ID_Leccion=?,semestre=? WHERE Matricula_Prof=?";
	public static final String deleteSQL = "DELETE FROM CursoProf WHERE Matricula_Prof=?";
	
	public List<CursoProfJB> seleccionar(){
        Connection conn = null;
        Statement state = null;
        ResultSet result = null;
		CursoProfJB con = null;
		
		List<CursoProfJB> cursop = new ArrayList<>();
		
		try {
            conn = Conexion.getConnection();
            state = conn.createStatement();
            result = state.executeQuery(selectSQL);
			
			while(result.next()) {
				int Matricula_Prof = result.getInt("Matricula_Prof");
				
				int ID_Leccion=result.getInt("ID_Leccion");
				String semestre=result.getString("semestre");
				
				con = new CursoProfJB(Matricula_Prof,ID_Leccion,semestre);
				cursop.add(con);
			}
			Conexion.close(result);
			Conexion.close(state);
			Conexion.close(conn);
			
			for(CursoProfJB c: cursop) {
				System.out.println("Id del profesor: " + c.getMatricula_Prof());
				System.out.println("ID de la leccion: " + c.getID_Leccion());
				
				System.out.println("semestre: " + c.getSemestre());
				
				System.out.println("\n");
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return cursop;

		
	}
	
	public int agregar(CursoProfJB cursop) {
		Connection conn = null;
		PreparedStatement state = null;
		int registros = 0;
		
		try {
			conn = Conexion.getConnection();
			state = conn.prepareStatement(insertSQL);
			
			state.setInt(1,cursop.getMatricula_Prof());
		
			state.setInt(2,cursop.getID_Leccion());
			state.setString(2,cursop.getSemestre());
			
			registros = state.executeUpdate();
			if(registros>0) {
				System.out.println("Registro agregado correctamente");
			}
			
			Conexion.close(state);
			Conexion.close(conn);
			CursoProfJB cursopNvo = new CursoProfJB();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		return registros;
	}
	
	public int borrar(CursoProfJB cursop) {
		Connection conn = null;
		PreparedStatement state = null;
		int registros = 0;
		
		try {
			conn = Conexion.getConnection();
			state = conn.prepareStatement(deleteSQL);
			
			state.setInt(1,cursop.getMatricula_Prof());
			registros = state.executeUpdate();
			
			if(registros>0) {
				System.out.println("Registro eliminado");
			}
			
			Conexion.close(state);
			Conexion.close(conn);
			CursoProfJB cursopDelete = new CursoProfJB();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return registros;
	}
	
	public int modificar(CursoProfJB cursop) {
		Connection conn = null;
		PreparedStatement state = null;
		int registros = 0;
		
		try {
			conn = Conexion.getConnection();
			state = conn.prepareStatement(updateSQL);
			
			state.setInt(1,cursop.getMatricula_Prof());
			state.setInt(2,cursop.getID_Leccion());
			state.setString(3,cursop.getSemestre());
			state.setInt(4,cursop.getMatricula_Prof());
			
			
			registros = state.executeUpdate();
			if(registros>0)
				System.out.println("Registro actualizado");
			
			Conexion.close(state);
			Conexion.close(conn);
			CursoProfJB cursopMod = new CursoProfJB();
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return registros;
	}

}
