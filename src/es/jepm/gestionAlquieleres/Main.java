package es.jepm.gestionAlquieleres;

import java.sql.Connection;
import java.sql.SQLException;

import es.jepm.gestionAlquieleres.controller.ConnectionManager;
import es.jepm.gestionAlquieleres.view.MainWindow;

public class Main {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Connection connection = ConnectionManager.getConnection();
		
		MainWindow.main(args);
	}

}
