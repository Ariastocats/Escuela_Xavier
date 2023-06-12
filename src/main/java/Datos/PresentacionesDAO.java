package Datos;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


import Modelo.PresentacionesJB;

public class PresentacionesDAO {
	public static final String selectSQL = "SELECT * FROM Presentaciones";
	public static final String insertSQL = "Insert into Presentaciones(Presentacion,Dia,Horario) VALUES (?,?,?)";
	public static final String updateSQL = "UPDATE Presentaciones SET Presentacion=?,Dia=?,Horario=? WHERE N_Presentacion=?";
	public static final String deleteSQL = "DELETE FROM Presentaciones WHERE N_Presentacion=?";
	public static final String joinpres="SELECT presentaciones.n_presentacion,presentaciones.presentacion,presentaciones.dia,presentaciones.horario,count(mutante.nombre) as Asistentes from presentaciones join asist_presentacion on presentaciones.n_presentacion=asist_presentacion.n_presentacion join only mutante on asist_presentacion.curp=mutante.curp join rol on mutante.rol=rol.id_rol group by presentaciones.n_presentacion order by presentaciones.n_presentacion asc ";
	public static final String updatebuscar = "SELECT * FROM Presentaciones WHERE N_Presentacion=?";
	
	public List<PresentacionesJB> seleccionar(){
        Connection conn = null;
        Statement state = null;
        ResultSet result = null;
		PresentacionesJB pres = null;
		
		List<PresentacionesJB> presentaciones = new ArrayList<>();
		
		try {
            conn = Conexion.getConnection();
            state = conn.createStatement();
            result = state.executeQuery(selectSQL);
			
			while(result.next()) {
				int N_Presentacion = result.getInt("N_Presentacion");
				String Presentacion = result.getString("Presentacion");
				Date Dia = result.getDate("Dia");
				Time Horario = result.getTime("Horario");
				
				pres = new PresentacionesJB(N_Presentacion,Presentacion,Dia,Horario);
				presentaciones.add(pres);
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
		PresentacionesJB pres = null;
		
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
				
				pres = new PresentacionesJB(N_Presentacion,Presentacion,Dia,Horario,asist);
				presentaciones.add(pres);
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
	
	public int borrar(int id_presentacion) {
		Connection conn = null;
		PreparedStatement state = null;
		int registros = 0;
		
		try {
			conn = Conexion.getConnection();
			state = conn.prepareStatement(deleteSQL);
			
			state.setInt(1,id_presentacion);
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
	
	public PresentacionesJB buscar(int id){
        Connection conn = null;
        PreparedStatement state = null;
        ResultSet result = null;
        PresentacionesJB pres = null;

        try {
            conn = Conexion.getConnection();
            state = conn.prepareStatement(updatebuscar);

            state.setInt(1,id);

            result = state.executeQuery();

            while(result.next()) {
                int n_presentacion = result.getInt("n_presentacion");
                String presentacion = result.getString("presentacion");
                Date dia = result.getDate("dia");
				Time horario = result.getTime("horario");
				

                System.out.println("encontramos los valores");
                pres = new PresentacionesJB(n_presentacion,presentacion,dia,horario);
            }
            Conexion.close(result);
            Conexion.close(state);
            Conexion.close(conn);

        } catch(Exception e) {
            e.printStackTrace();
        }

        return pres;
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
			PresentacionesJB presMod = new PresentacionesJB();
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return registros;
	}


}
