package Datos;

import Modelo.ProfesorJB;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProfesorDAO {
	public static final String selectSQL = "SELECT * FROM Profesor";
	public static final String insertSQL = "Insert into Profesor(Curp,Nombre,Apellido_Pat,Apellido_Mat,Poder,N_Alias,fecha_nac,cel,direcc,Rol,Remuneracion,T_Profesores,Correo_Inst,Contraseña,Status) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static final String updateSQL = "UPDATE Profesor SET Nombre=?,Apellido_Pat=?,Apellido_Mat=?,Poder=?,N_Alias=?,fecha_nac=?,cel=?,direcc=?,Rol=?,Remuneracion=?,T_Profesores=?,Correo_Inst=?,Contraseña=?,Status=? WHERE Matricula_P=?";
	public static final String update2SQL = "UPDATE Profesor SET Nombre=?,Apellido_Pat=?,Apellido_Mat=?,Poder=?,N_Alias=?,fecha_nac=?,cel=?,direcc=?,Rol=? WHERE Curp=?";
	public static final String deleteSQL = "DELETE FROM Profesor WHERE Matricula_P=?";
	public static final String joinprof="SELECT profesor.curp,profesor.nombre,profesor.apellido_pat,profesor.apellido_mat,profesor.poder,profesor.n_alias,profesor.fecha_nac,profesor.cel,profesor.direcc, rol.rol as Rols,profesor.matricula_p,profesor.remuneracion,t_profesores.tiempo as T_Profesor, profesor.correo_inst,profesor.contraseña,profesor.status FROM profesor JOIN rol ON profesor.rol=rol.id_rol join t_profesores on profesor.t_profesores=t_profesores.id_tipop";
	public static final String joinprle="SELECT profesor.matricula_p,profesor.nombre,lecciones.leccion as leccion,tipo_leccion.tipo_leccion as lecciont,profesor.remuneracion from lecciones inner join tipo_leccion on lecciones.tipo_leccion=tipo_leccion.id_tipol inner join cursoprof on lecciones.id_leccion=cursoprof.id_leccion inner join profesor on cursoprof.matricula_prof=profesor.matricula_p order by profesor.matricula_p asc";
	public static final String updatebuscar = "SELECT * FROM Profesor WHERE matricula_p=?";
	public static final String eliminar="UPDATE Profesor set Status='deshabilitado' where curp =?";
	
	public List<ProfesorJB> seleccionar(){
        Connection conn = null;
        Statement state = null;
        ResultSet result = null;
		ProfesorJB con = null;
		
		List<ProfesorJB> profesores = new ArrayList<>();
		
		try {
            conn = Conexion.getConnection();
            state = conn.createStatement();
            result = state.executeQuery(selectSQL);
			
			while(result.next()) {
				int Curp = result.getInt("Curp");
				String Nombre = result.getString("Nombre");
				String Apellido_Pat = result.getString("Apellido_Pat");
				String Apellido_Mat = result.getString("Apellido_Mat");
				String Poder = result.getString("Poder");
				String N_Alias= result.getString("N_Alias");
				Date fecha_nac = result.getDate("fecha_nac");
				String cel = result.getString("cel");
				String direcc=result.getString("direcc");
				int Rol=result.getInt("Rol");
				int Matricula_P=result.getInt("Matricula_P");
				int Remuneracion=result.getInt("Remuneracion");
				int T_Profesores = result.getInt("T_Profesores");
				String Correo_Inst = result.getString("Correo_Inst");
				String Contraseña = result.getString("Contraseña");
				String Status = result.getString("Status");
				
				con = new ProfesorJB(Curp,Nombre,Apellido_Pat,Apellido_Mat,Poder,N_Alias,fecha_nac,cel,direcc,Rol,Matricula_P,Remuneracion,T_Profesores,Correo_Inst,Contraseña,Status);
				profesores.add(con);
			}
			Conexion.close(result);
			Conexion.close(state);
			Conexion.close(conn);
			
			for(ProfesorJB c: profesores) {
				System.out.println("Curp: " + c.getCurp());
				System.out.println("Nombre: " + c.getNombre());
				System.out.println("Apellido paterno: " + c.getApellido_Pat());
				System.out.println("Apellido materno: " + c.getApellido_Mat());
				System.out.println("Poder: " + c.getPoder());
				System.out.println("Alias: " + c.getN_Alias());
				System.out.println("Fecha de Nacimiento: " + c.getFecha_nac());
				System.out.println("Numero de celular: " + c.getCel());
				System.out.println("Direccion: " + c.getDirecc());
				System.out.println("Tipo de usuario: " + c.getRol());
				System.out.println("Matricula De Profesor: " + c.getMatricula_P());
				System.out.println("Remuneracion: " + c.getRemuneracion());
				System.out.println("Tipo de Profesor: " + c.getT_Profesores());
				System.out.println("Correo: " + c.getCorreo_Inst());
				System.out.println("Contraseña: " + c.getContraseña());
				System.out.println("Status: " + c.getStatus());
				System.out.println("\n");
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return profesores;
	}
	
	public List<ProfesorJB> joinprof(){
        Connection conn = null;
        Statement state = null;
        ResultSet result = null;
		ProfesorJB con = null;
		
		List<ProfesorJB> profesores = new ArrayList<>();
		
		try {
            conn = Conexion.getConnection();
            state = conn.createStatement();
            result = state.executeQuery(joinprof);
			
			while(result.next()) {
				int Curp = result.getInt("Curp");
				String Nombre = result.getString("Nombre");
				String Apellido_Pat = result.getString("Apellido_Pat");
				String Apellido_Mat = result.getString("Apellido_Mat");
				String Poder = result.getString("Poder");
				String N_Alias= result.getString("N_Alias");
				Date fecha_nac = result.getDate("fecha_nac");
				String cel = result.getString("cel");
				String direcc=result.getString("direcc");
				String Rols=result.getString("Rols");
				int Matricula_P=result.getInt("Matricula_P");
				int Remuneracion=result.getInt("Remuneracion");
				String T_Profesor = result.getString("T_Profesor");
				String Correo_Inst = result.getString("Correo_Inst");
				String Contraseña = result.getString("Contraseña");
				String Status = result.getString("Status");
				
				con = new ProfesorJB(Curp,Nombre,Apellido_Pat,Apellido_Mat,Poder,N_Alias,fecha_nac,cel,direcc,Rols,Matricula_P,Remuneracion,T_Profesor,Correo_Inst,Contraseña,Status);
				profesores.add(con);
			}
			Conexion.close(result);
			Conexion.close(state);
			Conexion.close(conn);
			
			for(ProfesorJB c: profesores) {
				System.out.println("Curp: " + c.getCurp());
				System.out.println("Nombre: " + c.getNombre());
				System.out.println("Apellido paterno: " + c.getApellido_Pat());
				System.out.println("Apellido materno: " + c.getApellido_Mat());
				System.out.println("Poder: " + c.getPoder());
				System.out.println("Alias: " + c.getN_Alias());
				System.out.println("Fecha de Nacimiento: " + c.getFecha_nac());
				System.out.println("Numero de celular: " + c.getCel());
				System.out.println("Direccion: " + c.getDirecc());
				System.out.println("Tipo de usuario: " + c.getRols());
				System.out.println("Matricula De Profesor: " + c.getMatricula_P());
				System.out.println("Remuneracion: " + c.getRemuneracion());
				System.out.println("Tipo de Profesor: " + c.getT_Profesor());
				System.out.println("Correo: " + c.getCorreo_Inst());
				System.out.println("Contraseña: " + c.getContraseña());
				System.out.println("Status: " + c.getStatus());
				System.out.println("\n");
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return profesores;
	}
	
	public List<ProfesorJB> joinprle(){
        Connection conn = null;
        Statement state = null;
        ResultSet result = null;
		ProfesorJB con = null;
		
		List<ProfesorJB> profesores = new ArrayList<>();
		
		try {
            conn = Conexion.getConnection();
            state = conn.createStatement();
            result = state.executeQuery(joinprle);
			
			while(result.next()) {
				int Matricula_P = result.getInt("Matricula_P");
				String Nombre = result.getString("Nombre");
				String leccion=result.getString("leccion");
				String lecciont=result.getString("lecciont");
				int Remuneracion=result.getInt("Remuneracion");
				
				
				
				con = new ProfesorJB(Matricula_P,Nombre,leccion,lecciont,Remuneracion);
				profesores.add(con);
			}
			Conexion.close(result);
			Conexion.close(state);
			Conexion.close(conn);
			
			for(ProfesorJB c: profesores) {
				System.out.println("Matricula de profesor: " + c.getMatricula_P());
				System.out.println("Nombre: " + c.getNombre());
				System.out.println("leccion: " + c.getLeccion());
				System.out.println("leccion tipo: " + c.getLecciont());
				System.out.println("Remuneracion: " + c.getRemuneracion());
				System.out.println("\n");
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return profesores;
	}
	
	public int agregar(ProfesorJB profesores) {
		Connection conn = null;
		PreparedStatement state = null;
		int registros = 0;
		
		try {
			conn = Conexion.getConnection();
			state = conn.prepareStatement(insertSQL);
			state.setInt(1,profesores.getCurp());
			state.setString(2,profesores.getNombre());
			state.setString(3,profesores.getApellido_Pat());
			state.setString(4,profesores.getApellido_Mat());
			state.setString(5,profesores.getPoder());
			state.setString(6,profesores.getN_Alias());
			state.setDate(7,profesores.getFecha_nac());
			state.setString(8,profesores.getCel());
			state.setString(9,profesores.getDirecc());
			state.setInt(10,profesores.getRol());
			state.setInt(11,profesores.getRemuneracion());
			state.setInt(12,profesores.getT_Profesores());
			state.setString(13,profesores.getCorreo_Inst());
			state.setString(14,profesores.getContraseña());
			state.setString(15,profesores.getStatus());
			
			registros = state.executeUpdate();
			if(registros>0) {
				System.out.println("Registro agregado correctamente");
			}
			
			Conexion.close(state);
			Conexion.close(conn);
			ProfesorJB profesorNvo = new ProfesorJB();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		return registros;
	}
	
	public int borrar(ProfesorJB profesores) {
		Connection conn = null;
		PreparedStatement state = null;
		int registros = 0;
		
		try {
			conn = Conexion.getConnection();
			state = conn.prepareStatement(deleteSQL);
			
			state.setInt(1,profesores.getMatricula_P());
			registros = state.executeUpdate();
			
			if(registros>0) {
				System.out.println("Registro eliminado");
			}
			
			Conexion.close(state);
			Conexion.close(conn);
			ProfesorJB profesorDelete = new ProfesorJB();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return registros;
	}
	
	
	public ProfesorJB buscar(int id){
        Connection conn = null;
        PreparedStatement state = null;
        ResultSet result = null;
        ProfesorJB mut = null;

        try {
            conn = Conexion.getConnection();
            state = conn.prepareStatement(updatebuscar);

            state.setInt(1,id);

            result = state.executeQuery();

            while(result.next()) {
            	
                int curp = result.getInt("curp");
                String nombre = result.getString("nombre");
                String apellido_pat = result.getString("apellido_pat");
                String apellido_mat = result.getString("apellido_mat");
                String poder = result.getString("poder");
                String n_alias = result.getString("n_alias");
                Date fecha_nac = result.getDate("fecha_nac");
				String cel = result.getString("cel");
				String direcc=result.getString("direcc");
				int rol=result.getInt("rol");
				int Matricula_P=result.getInt("Matricula_P");
				int Remuneracion=result.getInt("Remuneracion");
				int T_Profesor = result.getInt("T_Profesor");
				String Correo_Inst = result.getString("Correo_Inst");
				String Contraseña = result.getString("Contraseña");
				String Status = result.getString("Status");
                

                System.out.println("encontramos los valores");
                mut = new ProfesorJB(curp,nombre,apellido_pat,apellido_mat,poder,n_alias,fecha_nac,cel,direcc,rol,Matricula_P,Remuneracion,T_Profesor,Correo_Inst,Contraseña,Status);
            }
            Conexion.close(result);
            Conexion.close(state);
            Conexion.close(conn);

        } catch(Exception e) {
            e.printStackTrace();
        }

        return mut;
    }
	
	public int dardebaja(int curp) {
		Connection conn = null;
		PreparedStatement state = null;
		int registros = 0;
		
		try {
			conn = Conexion.getConnection();
			state = conn.prepareStatement(eliminar);
		
			
			state.setInt(1,curp);
			
			registros = state.executeUpdate();
			if(registros>0)
				System.out.println("Registro actualizado");
			
			Conexion.close(state);
			Conexion.close(conn);
			ProfesorJB profesorMod = new ProfesorJB();
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return registros;
	}
	
	
	public int modificar(ProfesorJB profesores) {
		Connection conn = null;
		PreparedStatement state = null;
		int registros = 0;
		
		try {
			conn = Conexion.getConnection();
			state = conn.prepareStatement(updateSQL);
		
			state.setString(1,profesores.getNombre());
			state.setString(2,profesores.getApellido_Pat());
			state.setString(3,profesores.getApellido_Mat());
			state.setString(4,profesores.getPoder());
			state.setString(5,profesores.getN_Alias());
			state.setDate(6,profesores.getFecha_nac());
			state.setString(7,profesores.getCel());
			state.setString(8,profesores.getDirecc());
			state.setInt(9,profesores.getRol());
			state.setInt(10,profesores.getRemuneracion());
			state.setInt(11,profesores.getT_Profesores());
			state.setString(12,profesores.getCorreo_Inst());
			state.setString(13,profesores.getContraseña());
			state.setString(14,profesores.getStatus());
			state.setInt(15,profesores.getMatricula_P());
			
			registros = state.executeUpdate();
			if(registros>0)
				System.out.println("Registro actualizado");
			
			Conexion.close(state);
			Conexion.close(conn);
			ProfesorJB profesorMod = new ProfesorJB();
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return registros;
	}
	
	public int modificar2(ProfesorJB profesores) {
		Connection conn = null;
		PreparedStatement state = null;
		int registros = 0;
		
		try {
			conn = Conexion.getConnection();
			state = conn.prepareStatement(update2SQL);
		
			state.setString(1,profesores.getNombre());
			state.setString(2,profesores.getApellido_Pat());
			state.setString(3,profesores.getApellido_Mat());
			state.setString(4,profesores.getPoder());
			state.setString(5,profesores.getN_Alias());
			state.setDate(6,profesores.getFecha_nac());
			state.setString(7,profesores.getCel());
			state.setString(8,profesores.getDirecc());
			state.setInt(9,profesores.getRol());
			state.setInt(10,profesores.getCurp());
			
			registros = state.executeUpdate();
			if(registros>0)
				System.out.println("Registro actualizado");
			
			Conexion.close(state);
			Conexion.close(conn);
			ProfesorJB profesorMod = new ProfesorJB();
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return registros;
	}


}
