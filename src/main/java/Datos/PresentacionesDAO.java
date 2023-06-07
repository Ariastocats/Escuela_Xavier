package Datos;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import Modelo.PresentacionesJB;

public class PresentacionesDAO {
	public static final String selectSQL = "SELECT * FROM Presentaciones";
	public static final String insertSQL = "Insert into Presentaciones(Presentacion,Dia,Horario) VALUES (?,?,?)";
	public static final String updateSQL = "UPDATE Presentaciones SET Presentacion=?,Dia=?,Horario=? WHERE N_Presentacion=?";
	public static final String deleteSQL = "DELETE FROM Presentaciones WHERE N_Presentaciones=?";
	public static final String joinpres="SELECT presentaciones.n_presentacion,presentaciones.presentacion,presentaciones.dia,presentaciones.horario,count(mutante.nombre) as Asistentes from presentaciones join asist_presentacion on presentaciones.n_presentacion=asist_presentacion.n_presentacion join only mutante on asist_presentacion.curp=mutante.curp join rol on mutante.rol=rol.id_rol group by presentaciones.n_presentacion order by presentaciones.n_presentacion asc ";
	
	public List<PresentacionesJB> seleccionar(){
        Connection conn = null;
        Statement state = null;
        ResultSet result = null;
		PresentacionesJB con = null;
		
		List<PresentacionesJB> presentaciones = new ArrayList<>();
		
		try {
            conn = Conexion.getConnection();
            state = conn.createStatement();
            result = state.executeQuery(selectSQL);
			
			while(result.next()) {
				int N_Presentacion = result.getInt("N_Presentaciones");
				String Presentacion = result.getString("Presentacion");
				Date Dia = result.getDate("Dia");
				Time Horario = result.getTime("Horario");
				
				con = new PresentacionesJB(N_Presentacion,Presentacion,Dia,Horario);
				presentaciones.add(con);
			}
			Conexion.close(result);
			Conexion.close(state);
			Conexion.close(conn);
			
			for(PresentacionesJB c: presentaciones) {
				System.out.println("ID de presentaciones: " + c.getN_Presentacion());
				System.out.println("Nombre de presentacion: " + c.getPresentacion());
				System.out.println("Dia: " + c.getDia());
				System.out.println("Hora: " + c.getHorario());
				System.out.println("\n");
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return presentaciones;

		
	}
	
	public List<PresentacionesJB> joinpres(){
        Connection conn = null;
        Statement state = null;
        ResultSet result = null;
		PresentacionesJB con = null;
		
		List<PresentacionesJB> presentaciones = new ArrayList<>();
		
		try {
            conn = Conexion.getConnection();
            state = conn.createStatement();
            result = state.executeQuery(joinpres);
			
			while(result.next()) {
				int N_Presentacion = result.getInt("N_Presentacion");
				String Presentacion = result.getString("Presentacion");
				Date Dia = result.getDate("Dia");
				Time Horario = result.getTime("Horario");
				int asist=result.getInt("Asistentes");
				
				con = new PresentacionesJB(N_Presentacion,Presentacion,Dia,Horario,asist);
				presentaciones.add(con);
			}
			Conexion.close(result);
			Conexion.close(state);
			Conexion.close(conn);
			
			for(PresentacionesJB c: presentaciones) {
				System.out.println("ID de presentaciones: " + c.getN_Presentacion());
				System.out.println("Nombre de presentacion: " + c.getPresentacion());
				System.out.println("Dia: " + c.getDia());
				System.out.println("Hora: " + c.getHorario());
				System.out.println("Asistentes: " + c.getAsist());
				System.out.println("\n");
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return presentaciones;

		
	}
	
	public int agregar(PresentacionesJB presentaciones) {
		Connection conn = null;
		PreparedStatement state = null;
		int registros = 0;
		
		try {
			conn = Conexion.getConnection();
			state = conn.prepareStatement(insertSQL);
			
			state.setString(1,presentaciones.getPresentacion());
			state.setDate(2,(Date)presentaciones.getDia());
			state.setTime(3,presentaciones.getHorario());
			
			
			registros = state.executeUpdate();
			if(registros>0) {
				System.out.println("Registro agregado correctamente");
			}
			else {
				System.out.println("No se puedo agregar el registro");
				
			}
			
			Conexion.close(state);
			Conexion.close(conn);
			PresentacionesJB presentacionNvo = new PresentacionesJB();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		return registros;
	}
	
	public int borrar(PresentacionesJB presentaciones) {
		Connection conn = null;
		PreparedStatement state = null;
		int registros = 0;
		
		try {
			conn = Conexion.getConnection();
			state = conn.prepareStatement(deleteSQL);
			
			state.setInt(1,presentaciones.getN_Presentacion());
			registros = state.executeUpdate();
			
			if(registros>0) {
				System.out.println("Registro eliminado");
			}
			
			Conexion.close(state);
			Conexion.close(conn);
			PresentacionesJB presentacionDelete = new PresentacionesJB();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return registros;
	}
	
	public int modificar(PresentacionesJB presentaciones) {
		Connection conn = null;
		PreparedStatement state = null;
		int registros = 0;
		
		try {
			conn = Conexion.getConnection();
			state = conn.prepareStatement(updateSQL);
			
			state.setString(1,presentaciones.getPresentacion());
			state.setDate(2,(Date)presentaciones.getDia());
			state.setTime(3,presentaciones.getHorario());
			state.setInt(4,presentaciones.getN_Presentacion());
			
			
			registros = state.executeUpdate();
			if(registros>0)
				System.out.println("Registro actualizado");
			
			Conexion.close(state);
			Conexion.close(conn);
			PresentacionesJB conductorMod = new PresentacionesJB();
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return registros;
	}


}
