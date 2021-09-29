package Conexion;

import java.sql.*;
import javax.swing.*;

public class ConexionBD {
	//PRUEBA DE CONEXION
	private static String url="jdbc:mysql://localhost:3306/pruebacdb?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=flase&serverTimezone=UTC";
	private static String user="root", pass="pass";
	
	static {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			JOptionPane.showMessageDialog(null, "Error de conector: "+e.getMessage());
			e.printStackTrace();
		}

	}

	public Connection conectar() {

		try {

			Connection conexion = DriverManager.getConnection(url, user, pass);
			return conexion;

		} catch (SQLException e) {

			JOptionPane.showMessageDialog(null, e.getMessage());
			e.printStackTrace();

		}

		return null;

	}

}
