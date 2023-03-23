package es.jepm.gestionAlquieleres.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import es.jepm.gestionAlquieleres.properties.BBDDProperties;

public class ConnectionManager {
	

	private static Connection connection = null;

	/**
	 * Realizes the connection with data base.
	 * @return
	 * @throws SQLException
	 * @throws ClassNotFoundException 
	 */
	public static void realizeConnection() throws SQLException, ClassNotFoundException {
		String driver = BBDDProperties.getProperty("JDBC_DRIVER_CLASS");
		String user = BBDDProperties.getProperty("JDBC_USER");
		String password = BBDDProperties.getProperty("JDBC_PASSWORD");
		String host = BBDDProperties.getProperty("JDBC_HOST");
		String schema = BBDDProperties.getProperty("JDBC_SCHEMA_NAME");
		String properties = BBDDProperties.getProperty("JDBC_PROPERTIES");
		
		Class.forName(driver);
		
		try {
			Class.forName(driver);
		   
			connection = (Connection) DriverManager.getConnection ("jdbc:mysql://" + host + "/" + schema + properties, user, password);			   
		}
		catch (ClassNotFoundException ex) {
			System.out.println("Imposible acceder al driver Mysql");
		}
	}
	
	/**
	 * 
	 * @return
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public static Connection getConnection () throws SQLException, ClassNotFoundException {
		if (connection == null) {
			realizeConnection();
		}
		while (!connection.isValid(5)) {
			realizeConnection();
		}
		
		return connection;
	}

}
