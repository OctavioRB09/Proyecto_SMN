package Conexion;

import java.sql.*;
import javax.swing.*;

public class ConexionBD {
	
	private static String url="jdbc:mysql://localhost:3306/pruebacdb?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=flase&serverTimezone=UTC";
	public static String user="root", pass="pass";
	
	static {
		System.out.println("SYSO");
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			JOptionPane.showMessageDialog(null, "Error de conector: "+e.getMessage());
			e.printStackTrace();
		}

	}

	public ConexionBD()
	{
		
	}
	
	public ConexionBD(String user, String pass)
	{
		this.user = user;
		this.pass = pass;
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
