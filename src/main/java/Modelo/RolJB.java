package Modelo;

import java.io.Serializable;
public class RolJB implements Serializable{
	
	private int ID_Rol;
	private String Rol;
	
	public RolJB() {
		
	}
	
	public RolJB(int IDRol, String Rol) {
		this.ID_Rol=IDRol;
		this.Rol=Rol;
		
	}
	
	public int getID_Rol() {
	    return ID_Rol;
	}

	public void setID_Rol(int ID_Rol) {
	    this.ID_Rol = ID_Rol;
	}
	
	public String getRol() {
	    return Rol;
	}

	public void setRol(String rol) {
	    Rol = rol;
	}

}
