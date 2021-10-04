package Conexion;

import java.sql.*;
import javax.swing.*;

public class ConexionBD {
	
	private static String url="jdbc:mysql://localhost:3306/proyecto_smn?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=flase&serverTimezone=UTC";
	public static String user="root", pass="pass";
	public int flag1;
	
	static {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			JOptionPane.showMessageDialog(null, "Error de conector: "+e.getMessage());
			e.printStackTrace();
		}

	}

	//CONSTRUCTORES DE LA CLASE
	public ConexionBD() {
		
	}
	@SuppressWarnings("static-access")
	public ConexionBD(String user, String pass) {
		this.user = user;
		this.pass = pass;
	}

	//SE ESTABLECE LA CONEXION
	public Connection conectar() {

		try {

			Connection conexion = DriverManager.getConnection(url, user, pass);
			return conexion;

		} catch (SQLException e) {
			
			flag1=1;
			JOptionPane.showMessageDialog(null, e.getMessage());
			e.printStackTrace();

		}

		error(flag1);
		
		return null;

	}
	
	public int error(int flag) {
		return flag1;
	}

}
