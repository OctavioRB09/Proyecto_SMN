package Consultas;

import java.sql.*;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import Conexion.ConexionBD;

public class Participa_enc_Querys {
	
	ConexionBD conexion = new ConexionBD();
	Connection cn = null;
	Statement stm = null;
	ResultSet rs = null;
	
	String query="";
	
	public void ingreso_reg() {
	
		try {
			
			cn = conexion.conectar();
			stm = cn.createStatement();
			
			query="";
			stm.executeUpdate(query);
			
		} catch (SQLException e) {
			
			JOptionPane.showMessageDialog(null, e.getErrorCode()+": "+e.getMessage());
			e.printStackTrace();
			
		}
		
	}
	
	public void eliminar_reg() {
	
		try {
			
			cn = conexion.conectar();
			stm = cn.createStatement();
			
			query="";
			stm.executeUpdate(query);
			
		} catch (SQLException e) {
			
			JOptionPane.showMessageDialog(null, e.getErrorCode()+": "+e.getMessage());
			e.printStackTrace();
			
		}
		
	}
	
	public void modificar_reg() {
		
		try {
			
			cn = conexion.conectar();
			stm = cn.createStatement();
			
			query="";
			stm.executeUpdate(query);
			
		} catch (SQLException e) {
			
			JOptionPane.showMessageDialog(null, e.getErrorCode()+": "+e.getMessage());
			e.printStackTrace();
			
		}
		
	}
	
	public DefaultTableModel mostrarRegistrosRes (String query) {
		
		
		return null;
		
	}

}
