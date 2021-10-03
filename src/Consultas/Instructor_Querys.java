package Consultas;

import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import Conexion.ConexionBD;

public class Instructor_Querys {
	
	ConexionBD conexion = new ConexionBD();
	Connection cn = null;
	Statement stm = null;
	ResultSet rs = null;
	
	public void ingresar_instructor(String Placa, String Nombre, String ApellidoP, String ApellidoM, String Rango, String Sueldo) {
		
		try {
			
			//cn = conexion.conectar();
			String Q_Placa, Q_Nombre, Q_ApellidoP, Q_ApellidoM, Q_Rango, Q_Sueldo;
			
			if (Placa.equals("")) {
				Placa = null;
				Q_Placa = "" + Placa + ", ";
			} else
				Q_Placa = "'" + Placa + "', ";

			if (Nombre.equals("")) {
				Nombre = null;
				Q_Nombre = "" + Nombre + ", ";
			} else
				Q_Nombre = "'" + Nombre + "', ";

			if (ApellidoP.equals("")) {
				ApellidoP = null;
				Q_ApellidoP = "" + ApellidoP + ", ";
			} else
				Q_ApellidoP = "'" + ApellidoP + "', ";

			if (ApellidoM.equals("")) {
				ApellidoM = null;
				Q_ApellidoM = "" + ApellidoM + ", ";
			} else
				Q_ApellidoM = "'" + ApellidoM + "', ";

			if (Rango.equals("")) {
				Rango = null;
				Q_Rango = "" + Rango + ", ";
			} else
				Q_Rango = "'" + Rango + "', ";

			if (Sueldo.equals("")) {
				Sueldo = null;
				Q_Sueldo = "" + Sueldo + "";
			} else
				Q_Sueldo = "" + Sueldo + "";
			
			String query = "insert into instructor(Num_Placa, Nombre_Ins, ApellidoPat_Ins, ApellidoMat_Ins, Rango, Sueldo_Ins) VALUES("+Q_Placa+Q_Nombre+Q_ApellidoP+Q_ApellidoM+Q_Rango+Q_Sueldo+")";
			stm.executeUpdate(query);
			JOptionPane.showMessageDialog(null, "Instructor agregado correctamente");
			
		}catch (SQLException e) {
			
			JOptionPane.showMessageDialog(null, e.getMessage());
			e.printStackTrace();
			
		}

	}
	
	public void modificar_instructor(String Placa, String Nombre, String ApellidoP, String ApellidoM, String Rango, String Sueldo) {
		
		try	{

			cn = conexion.conectar();
			stm = cn.createStatement();

			String query = "UPDATE instructor SET Nombre_Ins = '"+Nombre+"', ApellidoPat_Ins = '"+ApellidoP+"', ApellidoMat_Ins = '"+ApellidoM+"', Rango = '"+Rango+"', Sueldo_Ins = "+Sueldo+" WHERE Num_Placa = '"+Placa+"'";
			stm.executeUpdate(query);
			JOptionPane.showMessageDialog(null, "Registro modificado correctamente");
		
		}catch (SQLException e)	{

			JOptionPane.showMessageDialog(null, e.getMessage());
			e.printStackTrace();
			
		}
		
	}
	
	public void eliminar_instructor(String Placa) {
		
		try {
			
			cn = conexion.conectar();
			stm = cn.createStatement();

			String query = "DELETE FROM instructor WHERE Num_Placa = '"+Placa+"'";
			stm.executeUpdate(query);
			JOptionPane.showMessageDialog(null, "Registro eliminado correctamente");
			
		}catch (SQLException e)	{		
			
			JOptionPane.showMessageDialog(null, e.getMessage());
			e.printStackTrace();
			
		}
		
	}
	
	public DefaultTableModel mostrarRegistrosIns(String query) {
		
		String[] cabecera = {"Placa", "Nombre", "Apellido Paterno", "Apellido Materno", "Rango", "Sueldo"};
		String[] datos = new String[6];
		
		DefaultTableModel modelo = new DefaultTableModel(null, cabecera);

		try {

			cn = conexion.conectar();
			stm = cn.createStatement();
			rs = stm.executeQuery(query);

			do {
				datos[0] = rs.getString(1);
				datos[1] = rs.getString(2);	
				datos[2] = rs.getString(3);
				datos[3] = rs.getString(4);
				datos[4] = rs.getString(5);
				datos[5] = rs.getString(6);
				modelo.addRow(datos);
			} while(rs.next());

		}catch (SQLException e)	{
			
			JOptionPane.showMessageDialog(null, e.getMessage());
			e.printStackTrace();
			
		}

		return modelo;

	}

}
