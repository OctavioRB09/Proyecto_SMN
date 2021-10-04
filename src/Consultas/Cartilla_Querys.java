package Consultas;

import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import Conexion.ConexionBD;

public class Cartilla_Querys {
	
	ConexionBD conexion = new ConexionBD();
	Connection cn = null;
	Statement stm = null;
	ResultSet rs = null;

	public void ingresar_Car(String Num_Liberacion, String ZonaMilitar, String Regimiento) {
		
		try {
			
			cn = conexion.conectar();
			stm = cn.createStatement();

			String Q_Liberacion, Q_ZonaMilitar, Q_Regimiento;
			if (Num_Liberacion.equals("")) {
				Num_Liberacion = null;
				Q_Liberacion = "" + Num_Liberacion + ", ";
			} else
				Q_Liberacion = "'" + Num_Liberacion + "', ";

			if (ZonaMilitar.equals("")) {
				ZonaMilitar = null;
				Q_ZonaMilitar = "" + ZonaMilitar + ", ";
			} else
				Q_ZonaMilitar = "'" + ZonaMilitar + "', ";

			if (Regimiento.equals("")) {
				Regimiento = null;
				Q_Regimiento = "" + Regimiento + "";
			} else 
				Q_Regimiento = "'" + Regimiento + "'";

			String query = "INSERT INTO cartilla(Num_liberación, Zona_Mil, Regimiento) VALUES(" + Q_Liberacion + Q_ZonaMilitar + Q_Regimiento + ")";
			stm.executeUpdate(query);
			JOptionPane.showMessageDialog(null, "Cartilla agregada correctamente");
			
		} catch (SQLException e) {
			
			JOptionPane.showMessageDialog(null, e.getMessage());
			e.printStackTrace();
			
		}

	}

	public void modificar_Car(String Num_Liberacion, String ZonaMilitar, String Regimiento) {
		
		try {
			
			cn = conexion.conectar();
			stm = cn.createStatement();

			String query = "UPDATE cartilla SET Zona_Mil = '" + ZonaMilitar + "',Regimiento = '" + Regimiento + "' WHERE Num_liberación = '" + Num_Liberacion + "'";
			stm.executeUpdate(query);
			JOptionPane.showMessageDialog(null, "cartilla modificada correctamente");
			
		} catch (SQLException e) {
			
			JOptionPane.showMessageDialog(null, e.getMessage());
			e.printStackTrace();
			
		}

	}

	public void eliminar_Car(String Num_Liberación) {
		
		try {
			
			cn = conexion.conectar();
			stm = cn.createStatement();

			String query = "DELETE FROM cartilla WHERE Num_liberación = '" + Num_Liberación + "'";
			stm.executeUpdate(query);
			JOptionPane.showMessageDialog(null, "Cartilla eliminada correctamente");

		} catch (SQLException e) {
			
			JOptionPane.showMessageDialog(null, e.getMessage());
			e.printStackTrace();
			
		}

	}

	public DefaultTableModel mostrarRegistrosCar(String query) {
		
		String[] cabecera = { "Num_Liberacion", "Zona_Militar", "Regimiento" };
		String[] datos = new String[3];

		DefaultTableModel modelo = new DefaultTableModel(null, cabecera);

		try {
			
			cn = conexion.conectar();
			stm = cn.createStatement();
			rs = stm.executeQuery(query);

			if(rs.next()) {
			
				do {
					datos[0] = rs.getString(1);
					datos[1] = rs.getString(2);
					datos[2] = rs.getString(3);
					modelo.addRow(datos);
				} while (rs.next());
				
			}

		} catch (SQLException e) {
			
			JOptionPane.showMessageDialog(null, e.getMessage());
			e.printStackTrace();
			
		}

		return modelo;

	}
	
}
