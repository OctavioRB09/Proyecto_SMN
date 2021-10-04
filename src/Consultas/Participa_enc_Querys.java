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
	
	String query="", Q_EdSorteo="", Q_MatEnc="", Q_Res="";
	String[] datos=new String[3];
	
	public void ingreso_reg(String EdSorteo, String MatEnc, String Res) {
	
		try {
			
			cn = conexion.conectar();
			stm = cn.createStatement();
			
			if (EdSorteo.equals("")) {
				EdSorteo = null;
				Q_EdSorteo = "" + EdSorteo + ", ";
			} else
				Q_EdSorteo = "'" + EdSorteo + "', ";

			if (MatEnc.equals("")) {
				MatEnc = null;
				Q_MatEnc = "" + MatEnc + ", ";
			} else
				Q_MatEnc = "'" + MatEnc + "', ";

			if (Res.equals("")) {
				Res = null;
				Q_Res = "" + Res + "";
			} else
				Q_Res = "'" + Res + "'";			
			
			query="INSERT INTO participa_enc (Ed_Sorteo, Matricula_Enc, Resultado) VALUES ("+Q_EdSorteo+Q_MatEnc+Q_Res+")";
			stm.executeUpdate(query);
			
		} catch (SQLException e) {
			
			JOptionPane.showMessageDialog(null, e.getErrorCode()+": "+e.getMessage());
			e.printStackTrace();
			
		}
		
	}
	
	public void eliminar_reg(String MatEnc) {
	
		try {
			
			cn = conexion.conectar();
			stm = cn.createStatement();
			
			query="DELETE FROM participa_enc WHERE Matricula_Enc = '"+MatEnc+"'";
			stm.executeUpdate(query);
			
		} catch (SQLException e) {
			
			JOptionPane.showMessageDialog(null, e.getErrorCode()+": "+e.getMessage());
			e.printStackTrace();
			
		}
		
	}
	
	public void modificar_reg(String EdSorteo, String MatEnc, String Res) {
		
		try {
			
			cn = conexion.conectar();
			stm = cn.createStatement();
			
			if (EdSorteo.equals("")) {
				EdSorteo = null;
				Q_EdSorteo = "" + EdSorteo + ", ";
			} else
				Q_EdSorteo = "'" + EdSorteo + "', ";

			if (MatEnc.equals("")) {
				MatEnc = null;
				Q_MatEnc = "" + MatEnc + ", ";
			} else
				Q_MatEnc = "'" + MatEnc + "', ";

			if (Res.equals("")) {
				Res = null;
				Q_Res = "" + Res + "";
			} else
				Q_Res = "'" + Res + "'";		
			
			query="UPDATE participa_enc SET Ed_Sorteo = "+Q_EdSorteo+", Resultado = "+Q_Res+" WHERE Matricula_Enc = "+Q_MatEnc;
			stm.executeUpdate(query);
			
		} catch (SQLException e) {
			
			JOptionPane.showMessageDialog(null, e.getErrorCode()+": "+e.getMessage());
			e.printStackTrace();
			
		}
		
	}
	
	public DefaultTableModel mostrarRegistrosPartEnc (String query) {

		String[] cabecera = {"Ed Sorteo", "Matricula", "Resultado"};

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
		
		for(int i=0; i<datos.length; i++)
			datos_salida[i]=datos[i];
		
		return datos_salida;
		
	}

}
