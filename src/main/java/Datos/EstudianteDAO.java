package Datos;
import Modelo.EstudianteJB;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class EstudianteDAO {
	public static final String selectSQL = "SELECT * FROM estudiantes";
	public static final String insertSQL = "Insert into Estudiantes(Curp,Nombre,Apellido_Pat,Apellido_Mat,Poder,N_Alias,fecha_nac,cel,direcc,Rol,Correo_Inst,Contraseña,Status) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static final String updateSQL = "UPDATE Estudiantes SET Nombre=?,Apellido_Pat=?,Apellido_Mat=?,Poder=?,N_Alias=?,fecha_nac=?,cel=?,direcc=?,Rol=?,Correo_Inst=?,Contraseña=?,Status=? WHERE Matricula=?";
	public static final String update2SQL= "UPDATE Estudiantes SET Nombre=?,Apellido_Pat=?,Apellido_Mat=?,Poder=?,N_Alias=?,fecha_nac=?,cel=?,direcc=?,Rol=? WHERE Curp=?";
	public static final String deleteSQL = "DELETE FROM Estudiantes WHERE Matricula=?";
	public static final String joinest="SELECT estudiantes.curp,estudiantes.nombre,estudiantes.apellido_pat,estudiantes.apellido_mat,estudiantes.poder,estudiantes.n_alias,estudiantes.fecha_nac,estudiantes.cel,estudiantes.direcc, rol.rol as Rols,estudiantes.matricula, estudiantes.correo_inst,estudiantes.contraseña,estudiantes.status FROM estudiantes JOIN rol ON estudiantes.rol=rol.id_rol";
	public static final String updatebuscar = "SELECT * FROM Estudiantes WHERE matricula=?";
	public static final String eliminar="UPDATE Estudiantes set Status='deshabilitado' where curp=?";
	public static final String correobuscar = "SELECT * FROM Estudiantes WHERE correo_inst=?";
	
	public List<EstudianteJB> seleccionar(){
        Connection conn = null;
        Statement state = null;
        ResultSet result = null;
		EstudianteJB con = null;
		
		List<EstudianteJB> est = new ArrayList<>();
		
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
				int Matricula=result.getInt("Matricula");
				String Correo_Inst = result.getString("Correo_Inst");
				String Contraseña = result.getString("Contraseña");
				String Status = result.getString("Status");
				
				con = new EstudianteJB(Curp,Nombre,Apellido_Pat,Apellido_Mat,Poder,N_Alias,fecha_nac,cel,direcc,Rol,Matricula,Correo_Inst,Contraseña,Status);
				est.add(con);
			}
			Conexion.close(result);
			Conexion.close(state);
			Conexion.close(conn);
			
			for(EstudianteJB c: est) {
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
				System.out.println("Matricula De Profesor: " + c.getMatricula());
				System.out.println("Correo: " + c.getCorreo_Inst());
				System.out.println("Contraseña: " + c.getContraseña());
				System.out.println("Status: " + c.getStatus());
				System.out.println("\n");
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return est;
	}
	
	public List<EstudianteJB> joinest(){
        Connection conn = null;
        Statement state = null;
        ResultSet result = null;
		EstudianteJB con = null;
		
		List<EstudianteJB> est = new ArrayList<>();
		
		try {
            conn = Conexion.getConnection();
            state = conn.createStatement();
            result = state.executeQuery(joinest);
			
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
				int Matricula=result.getInt("Matricula");
				String Correo_Inst = result.getString("Correo_Inst");
				String Contraseña = result.getString("Contraseña");
				String Status = result.getString("Status");
				
				con = new EstudianteJB(Curp,Nombre,Apellido_Pat,Apellido_Mat,Poder,N_Alias,fecha_nac,cel,direcc,Rols,Matricula,Correo_Inst,Contraseña,Status);
				est.add(con);
			}
			Conexion.close(result);
			Conexion.close(state);
			Conexion.close(conn);
			
			for(EstudianteJB c: est) {
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
				System.out.println("Matricula De Profesor: " + c.getMatricula());
				System.out.println("Correo: " + c.getCorreo_Inst());
				System.out.println("Contraseña: " + c.getContraseña());
				System.out.println("Status: " + c.getStatus());
				System.out.println("\n");
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return est;
	}
	
	public int agregar(EstudianteJB est) {
		Connection conn = null;
		PreparedStatement state = null;
		int registros = 0;
		
		try {
			conn = Conexion.getConnection();
			state = conn.prepareStatement(insertSQL);
			state.setInt(1,est.getCurp());
			state.setString(2,est.getNombre());
			state.setString(3,est.getApellido_Pat());
			state.setString(4,est.getApellido_Mat());
			state.setString(5,est.getPoder());
			state.setString(6,est.getN_Alias());
			state.setDate(7,est.getFecha_nac());
			state.setString(8,est.getCel());
			state.setString(9,est.getDirecc());
			state.setInt(10,est.getRol());
			state.setString(11,est.getCorreo_Inst());
			state.setString(12,est.getContraseña());
			state.setString(13,est.getStatus());
			
			registros = state.executeUpdate();
			if(registros>0) {
				System.out.println("Registro agregado correctamente");
			}
			
			Conexion.close(state);
			Conexion.close(conn);
			EstudianteJB estudianteNvo = new EstudianteJB();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		return registros;
	}
	
	public int borrar(EstudianteJB est) {
		Connection conn = null;
		PreparedStatement state = null;
		int registros = 0;
		
		try {
			conn = Conexion.getConnection();
			state = conn.prepareStatement(deleteSQL);
			
			state.setInt(1,est.getMatricula());
			registros = state.executeUpdate();
			
			if(registros>0) {
				System.out.println("Registro eliminado");
			}
			
			Conexion.close(state);
			Conexion.close(conn);
			EstudianteJB estudianteDelete = new EstudianteJB();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return registros;
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
			EstudianteJB estMod = new EstudianteJB();
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return registros;
	}
	
	public EstudianteJB buscar(int id){
        Connection conn = null;
        PreparedStatement state = null;
        ResultSet result = null;
        EstudianteJB mut = null;

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
				int Matricula=result.getInt("Matricula");
				String Correo_Inst = result.getString("Correo_Inst");
				String Contraseña = result.getString("Contraseña");
				String Status = result.getString("Status");
                

                System.out.println("encontramos los valores");
                mut = new EstudianteJB(curp,nombre,apellido_pat,apellido_mat,poder,n_alias,fecha_nac,cel,direcc,rol,Matricula,Correo_Inst,Contraseña,Status);
            }
            Conexion.close(result);
            Conexion.close(state);
            Conexion.close(conn);

        } catch(Exception e) {
            e.printStackTrace();
        }

        return mut;
    }
	
	public EstudianteJB buscarcorreo(String id){
        Connection conn = null;
        PreparedStatement state = null;
        ResultSet result = null;
        EstudianteJB mut = null;

        try {
            conn = Conexion.getConnection();
            state = conn.prepareStatement(correobuscar);

            state.setString(1,id);

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
				int Matricula=result.getInt("Matricula");
				String Correo_Inst = result.getString("Correo_Inst");
				String Contraseña = result.getString("Contraseña");
				String Status = result.getString("Status");
                

                System.out.println("encontramos los valores");
                mut = new EstudianteJB(curp,nombre,apellido_pat,apellido_mat,poder,n_alias,fecha_nac,cel,direcc,rol,Matricula,Correo_Inst,Contraseña,Status);
            }
            Conexion.close(result);
            Conexion.close(state);
            Conexion.close(conn);

        } catch(Exception e) {
            e.printStackTrace();
        }

        return mut;
    }
	
	public int modificar(EstudianteJB est) {
		Connection conn = null;
		PreparedStatement state = null;
		int registros = 0;
		
		try {
			conn = Conexion.getConnection();
			state = conn.prepareStatement(updateSQL);
			state.setString(1,est.getNombre());
			state.setString(2,est.getApellido_Pat());
			state.setString(3,est.getApellido_Mat());
			state.setString(4,est.getPoder());
			state.setString(5,est.getN_Alias());
			state.setDate(6,est.getFecha_nac());
			state.setString(7,est.getCel());
			state.setString(8,est.getDirecc());
			state.setInt(9,est.getRol());
			state.setString(10,est.getCorreo_Inst());
			state.setString(11,est.getContraseña());
			state.setString(12,est.getStatus());
			state.setInt(13,est.getMatricula());
			
			registros = state.executeUpdate();
			if(registros>0)
				System.out.println("Registro actualizado");
			
			Conexion.close(state);
			Conexion.close(conn);
			EstudianteJB estudianteMod = new EstudianteJB();
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return registros;
	}
	
	public int modificar2(EstudianteJB est) {
		Connection conn = null;
		PreparedStatement state = null;
		int registros = 0;
		
		try {
			conn = Conexion.getConnection();
			state = conn.prepareStatement(update2SQL);
			state.setString(1,est.getNombre());
			state.setString(2,est.getApellido_Pat());
			state.setString(3,est.getApellido_Mat());
			state.setString(4,est.getPoder());
			state.setString(5,est.getN_Alias());
			state.setDate(6,est.getFecha_nac());
			state.setString(7,est.getCel());
			state.setString(8,est.getDirecc());
			state.setInt(9,est.getRol());
			state.setInt(10,est.getCurp());
			
			registros = state.executeUpdate();
			if(registros>0)
				System.out.println("Registro actualizado");
			
			Conexion.close(state);
			Conexion.close(conn);
			EstudianteJB estudianteMod = new EstudianteJB();
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return registros;
	}


}
