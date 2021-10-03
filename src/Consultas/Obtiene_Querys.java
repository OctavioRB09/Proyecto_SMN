package Consultas;

import Conexion.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Obtiene_Querys {
	
	ConexionBD conexion = new ConexionBD();
	Connection cn = null;
	Statement stm = null;
	ResultSet rs = null;
	String[] datos=new String[4];
	String query="", Q_Matricula="", Q_NumLiberacion="", Q_Precio="", Q_MRec="";
	
	public void ingresar_obtiene(String Matricula, String Num_Liberacion, String Precio_Cart, String Mes_Recepcion) {

		try {

			cn = conexion.conectar();
			stm = cn.createStatement();

			if (Matricula.equals("")) {
				Matricula = null;
				Q_Matricula = "" + Matricula + ", ";
			} else
				Q_Matricula = "'" + Matricula + "', ";

			if (Num_Liberacion.equals("")) {
				Num_Liberacion = null;
				Q_NumLiberacion = "" + Num_Liberacion + ", ";
			} else
				Q_NumLiberacion = "'" + Num_Liberacion + "', ";

			if (Precio_Cart.equals("")) {
				Precio_Cart = null;
				Q_Precio = "" + Precio_Cart + ", ";
			} else
				Q_Precio = "'" + Precio_Cart + "', ";

			if (Mes_Recepcion.equals("")) {
				Mes_Recepcion = null;
				Q_MRec = "" + Mes_Recepcion + "";
			} else
				Q_MRec = "'" + Mes_Recepcion + "'";

			query = "INSERT INTO obtiene (Matricula_Res, Num_Liberacion, Precio_Cart, Mes_Recepcion) VALUES (" + Q_Matricula + Q_NumLiberacion + Q_Precio + Q_MRec + ")";
			stm.executeUpdate(query);

		} catch (SQLException e) {

			JOptionPane.showMessageDialog(null, e.getErrorCode() + ": " + e.getMessage());
			e.printStackTrace();

		}

	}

	public void eliminar_obtiene(String Matricula_Res) {

		try {

			cn = conexion.conectar();
			stm = cn.createStatement();

			query = "DELETE FROM obtiene WHERE Matricula_Res = '" + Matricula_Res + "'";
			stm.executeUpdate(query);

		} catch (SQLException e) {

			JOptionPane.showMessageDialog(null, e.getErrorCode() + ": " + e.getMessage());
			e.printStackTrace();

		}

	}

	public void modificar_obtiene(String Matricula, String Num_Liberacion, String Precio_Cart, String Mes_Recepcion) {

		try {

			cn = conexion.conectar();
			stm = cn.createStatement();

			if (Matricula.equals("")) {
				Matricula = null;
				Q_Matricula = "" + Matricula + "";
			} else
				Q_Matricula = "'" + Matricula + "'";

			if (Num_Liberacion.equals("")) {
				Num_Liberacion = null;
				Q_NumLiberacion = "" + Num_Liberacion + "";
			} else
				Q_NumLiberacion = "'" + Num_Liberacion + "'";

			if (Precio_Cart.equals("")) {
				Precio_Cart = null;
				Q_Precio = "" + Precio_Cart + "";
			} else
				Q_Precio = "'" + Precio_Cart + "'";

			if (Mes_Recepcion.equals("")) {
				Mes_Recepcion = null;
				Q_MRec = "" + Mes_Recepcion + "";
			} else
				Q_MRec = "'" + Mes_Recepcion + "'";

			query = "UPDATE obtiene SET Num_Liberacion = " + Q_NumLiberacion + ", Precio_Cart = " + Q_Precio + ", Mes_Recepcion = " + Q_MRec + " WHERE Matricula_Res = " + Q_Matricula;
			stm.executeUpdate(query);

		} catch (SQLException e) {

			JOptionPane.showMessageDialog(null, e.getErrorCode() + ": " + e.getMessage());
			e.printStackTrace();

		}

	}

	public DefaultTableModel mostrarRegistrosObtiene(String query) {

		String[] cabecera = { "Matricula_Res", "Num_Liberacion", "Precio_Cart", "Mes_Recepcion" };

		DefaultTableModel modelo = new DefaultTableModel(null, cabecera);

		try {

			cn = conexion.conectar();
			stm = cn.createStatement();
			rs = stm.executeQuery(query);

			if (rs.next()) {

				do {

					datos[0] = rs.getString(1);
					datos[1] = rs.getString(2);
					datos[2] = rs.getString(3);
					datos[3] = rs.getString(4);
					modelo.addRow(datos);

				} while (rs.next());

			} else 
				for (int i = 0; i < datos.length; i++) datos[i] = "";

		} catch (SQLException e) {

			JOptionPane.showMessageDialog(null, e.getErrorCode() + ": " + e.getMessage());
			e.printStackTrace();

		}
		
		return modelo;

	}

	public String[] vector_edits(String[] datos_salida) {

		for (int i = 0; i < datos.length; i++) {
			datos_salida[i] = datos[i];
		}

		return datos_salida;

	}

}
