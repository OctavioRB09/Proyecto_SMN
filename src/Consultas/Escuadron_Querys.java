package Consultas;

import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import Conexion.ConexionBD;

public class Escuadron_Querys {
	
	ConexionBD conexion = new ConexionBD();
	Connection cn = null;
	Statement stm = null;
	ResultSet rs = null;
	
	public void ingresar_Esc(String NumEsc, String NumInt) {
		
		try	{
			
			cn = conexion.conectar();
			stm = cn.createStatement();
			
			String Q_NumEsc, Q_NumInt;
			
			if (NumEsc.equals("")) {
				NumEsc = null;
				Q_NumEsc = "" + NumEsc + ", ";
			} else
				Q_NumEsc = "'" + NumEsc + "', ";

			if (NumInt.equals("")) {
				NumInt = null;
				Q_NumInt = "" + NumInt;
			} else
				Q_NumInt = "'" + NumInt + "'";
			
			String query = "INSERT INTO escuadron(N_Sección, Num_Integrantes) VALUES("+Q_NumEsc+Q_NumInt+")";
			stm.executeUpdate(query);
		
		}catch (SQLException e)	{
			
			JOptionPane.showMessageDialog(null, e.getMessage());
			e.printStackTrace();
			
		}
	
	}
	
	public void modificar_Esc(String NumEsc, String NumInt) {
		
		try	{
			
			cn = conexion.conectar();
			stm = cn.createStatement();

			String query = "UPDATE escuadron SET Num_Integrantes = '"+NumInt+"' WHERE N_Sección = '"+NumEsc+"'";
			stm.executeUpdate(query);
			
		}catch (SQLException e)	{
			
			JOptionPane.showMessageDialog(null, e.getMessage());
			e.printStackTrace();
			
		}

	}
	
	public void eliminar_Esc(String NumEsc) {
		
		try {

			cn = conexion.conectar();
			stm = cn.createStatement();

			String query = "DELETE FROM escuadron WHERE N_Sección = '"+NumEsc+"'";
			stm.executeUpdate(query);
			
		}catch (SQLException e)	{		
			
			JOptionPane.showMessageDialog(null, e.getMessage());
			e.printStackTrace();
			
		}

	}
	
	public DefaultTableModel mostrarRegistrosEscuadron(String query) {
		
		String[] cabecera = {"N_Sección", "Num_Integrantes"};
		String[] datos = new String[2];
		
		DefaultTableModel modelo = new DefaultTableModel(null, cabecera);

		try {
			
			cn = conexion.conectar();
			stm = cn.createStatement();
			rs = stm.executeQuery(query);

			if(rs.next()) {
			
				do {
					datos[0] = rs.getString(1);
					datos[1] = rs.getString(2);	
					modelo.addRow(datos);
				} while(rs.next());
				
			}

		}catch (SQLException e)	{
			
			JOptionPane.showMessageDialog(null, e.getMessage());
			e.printStackTrace();
			
		}
		
		return modelo;
		
	}
	
}
