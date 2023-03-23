package es.jepm.gestionAlquieleres.controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import es.jepm.gestionAlquieleres.model.Localidad;


public class LocalidadController {
	
	/**
	 * 
	 * @return
	 */
	public static List<Localidad> findAll() {
		List<Localidad> list = new ArrayList<Localidad>();
		
		try {
			Connection conn = ConnectionManager.getConnection();
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("select * from localidad");
			
			while (rs.next()) {
				Localidad localidad = new Localidad();
				localidad.setId(rs.getInt("id"));
				localidad.setDescripcion(rs.getString("descripcion"));
				list.add(localidad);
				
			}
			
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
		
		return list;
	}
	
	/**
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 * 
	 * 
	 */
	public static int getLocalidadId(String nombre) throws ClassNotFoundException, SQLException {
		
		Connection conn = ConnectionManager.getConnection();
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery("select id from localidad where descripcion like '" + nombre + "'");
		
		rs.next();
		
		return rs.getInt("id");
		
	}

}
