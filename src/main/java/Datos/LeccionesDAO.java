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
	public static final String updateSQL = "UPDATE Lecciones SET Leccion=?,Horario_Ini=?,Horario_Fin=?,creditos=?,Tipo_Leccion=? WHERE ID_Leccion=?";
	public static final String deleteSQL = "DELETE FROM Lecciones WHERE ID_Leccion=?";
	public static final String lecjoin="SELECT estudiantes.matricula as matricula,estudiantes.nombre as nombre,lecciones.leccion,lecciones.creditos,curso.calificacion as calif from lecciones join curso on lecciones.id_leccion=curso.id_leccion join estudiantes on curso.id_est=estudiantes.matricula";
	public static final String select="Select lecciones.id_leccion,lecciones.leccion,lecciones.horario_ini,lecciones.horario_fin,lecciones.creditos,tipo_leccion.tipo_leccion as tipoleccion from lecciones join tipo_leccion on lecciones.tipo_leccion=tipo_leccion.id_tipol";
	public static final String updatebuscar = "SELECT * FROM Lecciones WHERE id_leccion=?";
	
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
				Time Horario_Ini=result.getTime("Horario_Ini");
				Time Horario_Fin=result.getTime("Horario_Fin");
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
	
	public List<LeccionesJB> select(){
        Connection conn = null;
        Statement state = null;
        ResultSet result = null;
		LeccionesJB con = null;
		
		List<LeccionesJB> lec = new ArrayList<>();
		
		try {
            conn = Conexion.getConnection();
            state = conn.createStatement();
            result = state.executeQuery(select);
			
			while(result.next()) {
				int ID_Leccion = result.getInt("ID_Leccion");
				String Leccion=result.getString("Leccion");
				Time Horario_Ini=result.getTime("Horario_Ini");
				Time Horario_Fin=result.getTime("Horario_Fin");
				int creditos=result.getInt("creditos");
				String tipoleccion=result.getString("tipoleccion");
				
				con = new LeccionesJB(ID_Leccion,Leccion,Horario_Ini,Horario_Fin,creditos,tipoleccion);
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
				System.out.println("Id de la Leccion: " + c.getTipoleccion());
				
				System.out.println("\n");
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return lec;

		
	}
	
	public List<LeccionesJB> lecjoin(){
        Connection conn = null;
        Statement state = null;
        ResultSet result = null;
		LeccionesJB con = null;
		
		List<LeccionesJB> lec = new ArrayList<>();
		
		try {
            conn = Conexion.getConnection();
            state = conn.createStatement();
            result = state.executeQuery(lecjoin);
			
			while(result.next()) {
				int matri=result.getInt("matricula");
				String nombre = result.getString("nombre");
				String Leccion=result.getString("Leccion");
				int creditos=result.getInt("creditos");
				float calif=result.getInt("calif");
				
				con = new LeccionesJB(matri,nombre,Leccion,creditos,calif);
				lec.add(con);
			}
			Conexion.close(result);
			Conexion.close(state);
			Conexion.close(conn);
			
			for(LeccionesJB c: lec) {
				System.out.println("matricula de alumno: " + c.getMatri());
				System.out.println("nombre del alumno: " + c.getNombre());
				System.out.println("Leccion: " + c.getLeccion());
				System.out.println("Creditos: " + c.getCreditos());
				System.out.println("Calificacion: " + c.getCalif());
				
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
			state.setTime(2,lec.getHora_Ini());
			state.setTime(3,lec.getHora_Fin());
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
	
	public int borrar(int id_leccion) {
		Connection conn = null;
		PreparedStatement state = null;
		int registros = 0;
		
		try {
			conn = Conexion.getConnection();
			state = conn.prepareStatement(deleteSQL);
			
			state.setInt(1,id_leccion);
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
	
	public LeccionesJB buscar(int id){
        Connection conn = null;
        PreparedStatement state = null;
        ResultSet result = null;
        LeccionesJB ruta = null;

        try {
            conn = Conexion.getConnection();
            state = conn.prepareStatement(updatebuscar);

            state.setInt(1,id);

            result = state.executeQuery();

            while(result.next()) {
                int id_leccion = result.getInt("id_leccion");
                String leccion = result.getString("leccion");
                Time hora_ini = result.getTime("horario_ini");
                Time hora_fin = result.getTime("horario_fin");
                int creditos =result.getInt("creditos");
                int tipo_leccion=result.getInt("tipo_leccion");

                System.out.println("encontramos los valores");
                ruta = new LeccionesJB(id_leccion,leccion,hora_ini,hora_fin,creditos,tipo_leccion);
            }
            Conexion.close(result);
            Conexion.close(state);
            Conexion.close(conn);

        } catch(Exception e) {
            e.printStackTrace();
        }

        return ruta;
    }
	
	public int modificar(LeccionesJB lec) {
		Connection conn = null;
		PreparedStatement state = null;
		int registros = 0;
		
		try {
			conn = Conexion.getConnection();
			state = conn.prepareStatement(updateSQL);
			
			state.setString(1,lec.getLeccion());
			state.setTime(2,lec.getHora_Ini());
			state.setTime(3,lec.getHora_Fin());
			state.setInt(4,lec.getCreditos());
			state.setInt(5,lec.getTipo_Leccion());
			state.setInt(6,lec.getID_Leccion());
			
			
			registros = state.executeUpdate();
			if(registros>0) {
				System.out.println("Registro actualizado");
			}
			else {
				System.out.println("Registro no actualizado");
			}
			Conexion.close(state);
			Conexion.close(conn);
			LeccionesJB lecMod = new LeccionesJB();
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return registros;
	}
	
}
