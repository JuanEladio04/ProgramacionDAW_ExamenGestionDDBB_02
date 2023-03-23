package es.jepm.gestionAlquieleres.controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import es.jepm.gestionAlquieleres.model.Localidad;
import es.jepm.gestionAlquieleres.model.Vivienda;

public class ViviendaController {

	/**
	 * 
	 * @return
	 */
	public static List<Vivienda> findAll(int id) {
		List<Vivienda> list = new ArrayList<Vivienda>();
		
		try {
			Connection conn = ConnectionManager.getConnection();
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("select * from vivienda where idLocalidad like " + id);
			
			while (rs.next()) {
				Vivienda vivienda = new Vivienda();
				vivienda.setId(rs.getInt("id"));
				vivienda.setDescripcion(rs.getString("descripcion"));
				vivienda.setIdLocaloidad(rs.getInt("idLocalidad"));
				list.add(vivienda);
				
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
	public static int getViviendaId(String nombre) throws ClassNotFoundException, SQLException {
		
		Connection conn = ConnectionManager.getConnection();
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery("select id from vivienda where descripcion like '" + nombre + "'");
		
		rs.next();
		
		return rs.getInt("id");
		
	}
	
}
