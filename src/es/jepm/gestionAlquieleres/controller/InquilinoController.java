package es.jepm.gestionAlquieleres.controller;

import java.awt.print.Printable;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import es.jepm.gestionAlquieleres.model.Inquilino;
import es.jepm.gestionAlquieleres.model.Vivienda;

public class InquilinoController {
	
	/**
	 * 
	 * @return
	 */
	public static Inquilino findAll(int id) {	
		Inquilino inquilino = new Inquilino();

		try {
			Connection conn = ConnectionManager.getConnection();
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("select * from inquilino where idVivienda like " + id);
			
			while (rs.next()) {
				inquilino.setId(rs.getInt("id"));
				inquilino.setDNI(rs.getString("DNI"));
				inquilino.setNombreCompleto(rs.getString("nombreCompleto"));
				inquilino.setFechaInicioAlquiler(rs.getDate("fechaInicioAlquiler"));
				inquilino.setFechaFinAlquiler(rs.getDate("fechaFinAlquiler"));
				inquilino.setCuotaAlquiler(rs.getInt("cuotaMensual"));
				inquilino.setIdVivienda(rs.getInt("idVivienda"));				
			}
			
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
		
		return inquilino;
	}
	
	/**
	 * 
	 * @param inquilino
	 * @return
	 * @throws ClassNotFoundException
	 */
	public static int updateInquilino(Inquilino inquilino) throws ClassNotFoundException {
		try {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		Connection conn = ConnectionManager.getConnection();
		PreparedStatement ps = conn.prepareStatement(
				"update inquilino set id = ?, DNI = ?, nombreCompleto = ?, fechaInicioAlquiler = ?, fechaFinAlquiler = ?, cuotaMensual = ? where idVivienda = ?");
	
		ps.setInt(1, inquilino.getId());
		ps.setString(2, inquilino.getDNI());
		ps.setString(3, inquilino.getNombreCompleto());
		ps.setDate(4, new java.sql.Date(inquilino.getFechaInicioAlquiler().getTime()));
		if (inquilino.getFechaFinAlquiler() != null) {
			ps.setDate(5, new java.sql.Date(inquilino.getFechaFinAlquiler().getTime()));
		}
		else {
			ps.setDate(5, null);
		}
		ps.setInt(6, inquilino.getCuotaAlquiler());
		ps.setInt(7, inquilino.getIdVivienda());
		int rows = ps.executeUpdate();
		ps.close();
		conn.close();
		JOptionPane.showMessageDialog(null, "Modificacion realizada correctamente");
		return rows;
	} catch (SQLException e) {
		JOptionPane.showMessageDialog(null, "Imposible realizar la modificación");
		e.printStackTrace();
	}
	return 0;
		
	}


}
