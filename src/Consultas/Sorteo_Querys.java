package Consultas;

import Conexion.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Sorteo_Querys {
	
	ConexionBD conexion = new ConexionBD();
	Connection cn = null;
	Statement stm = null;
	ResultSet rs = null;
	String[] datos=new String[2];
	String query="", Q_Edsorteo="", Q_fecha="";
	
	public void ingresar_sorteo(String edsorteo,String fecha) {
		
		try {

			cn = conexion.conectar();
			stm = cn.createStatement();
			
			if (edsorteo.equals("")) {
				edsorteo = null;
				Q_Edsorteo = "" + edsorteo + ", ";
			} else
				Q_Edsorteo = "'" + edsorteo + "', ";

			if (fecha.equals("")) {
				fecha = null;
				Q_fecha = "" + fecha + "";
			} else
				Q_fecha = "'" + fecha + "'";		
			
			query="INSERT INTO sorteo (Ed_sorteo, Fecha) VALUES ("+Q_Edsorteo+ Q_fecha+")";
			stm.executeUpdate(query);

		} catch (SQLException e) {

			JOptionPane.showMessageDialog(null, e.getErrorCode()+": "+e.getMessage());
			e.printStackTrace();

		}
		
	}
		
	public void eliminar_sor(String edsorteo) {
		
		try {

			cn = conexion.conectar();
			stm = cn.createStatement();
			
			query = "DELETE FROM sorteo WHERE Ed_Sorteo = '"+edsorteo+"'";
			stm.executeUpdate(query);

		} catch (SQLException e) {

			JOptionPane.showMessageDialog(null, e.getErrorCode()+": "+e.getMessage());
			e.printStackTrace();
			
		}
		
	}
	
	public void modificar_sor(String edsorteo,String fecha) {
		
		try {

			cn = conexion.conectar();
			stm = cn.createStatement();
			
			if (fecha.equals("")) {
				fecha = null;
				Q_fecha = "" + fecha + "";
			} else
				Q_fecha = "'" + fecha + "'";
			
			query = "UPDATE sorteo SET Fecha = "+Q_fecha+" WHERE Ed_Sorteo = '"+edsorteo+"'";
			stm.executeUpdate(query);

		} catch (SQLException e) {

			JOptionPane.showMessageDialog(null, e.getErrorCode()+": "+e.getMessage());
			e.printStackTrace();
			
		}
		
	}
	
	public DefaultTableModel mostrarRegistrosSorteo(String query) {
		
		String[] cabecera = {"Ed_Sorteo", "Fecha"};
		
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
				
			}else
				for(int i=0; i<datos.length; i++) datos[i]="";
			

		} catch (SQLException e) {

			JOptionPane.showMessageDialog(null, e.getErrorCode()+": "+e.getMessage());
			e.printStackTrace();

		}
		
		return modelo;
		
	}
	
	public String[] vector_edits(String[] datos_salida) {
		
		for(int i=0; i<datos.length; i++) {
			datos_salida[i]=datos[i];
		}
		
		return datos_salida;
		
	}

}
