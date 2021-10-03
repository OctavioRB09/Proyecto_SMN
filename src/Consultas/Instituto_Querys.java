package Consultas;

import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import Conexion.ConexionBD;

public class Instituto_Querys {
	
	ConexionBD conexion = new ConexionBD();
	Connection cn = null;
	Statement stm = null;
	ResultSet rs = null;
	
	public void ingresarInst(String IdI, String NI, String NEI, String NII, String NCI, String CI, String MI) {
		
		try {
			
			//cn = conexion.conectar();
			//stm = cn.createStatement();
			String Q_IdI, Q_NI, Q_NEI, Q_NII, Q_NCI, Q_CI, Q_MI;
			
			if (IdI.equals("")) {
				IdI = null;
				Q_IdI = "" + IdI + ", ";
			} else
				Q_IdI = "'" + IdI + "', ";

			if (NI.equals("")) {
				NI = null;
				Q_NI = "" + NI + ", ";
			} else
				Q_NI = "'" + NI + "', ";

			if (NEI.equals("")) {
				NEI = null;
				Q_NEI = "" + NEI + ", ";
			} else
				Q_NEI = "'" + NEI + "', ";

			if (NII.equals("")) {
				NII = null;
				Q_NII = "" + NII + ", ";
			} else
				Q_NII = "'" + NII + "', ";

			if (NCI.equals("")) {
				NCI = null;
				Q_NCI = "" + NCI + ", ";
			} else
				Q_NCI = "'" + NCI + "', ";

			if (CI.equals("")) {
				CI = null;
				Q_CI = "" + CI + ", ";
			} else
				Q_CI = "'" + CI + "', ";

			if (MI.equals("")) {
				MI = null;
				Q_MI = "" + MI + "";
			} else
				Q_MI = "'" + MI + "'";
			
			String query="INSERT INTO institucion(Id_Inst, Nombre_Inst, Num_Exterior, Num_Interior, Nom_Calle, Colonia, Municipio) VALUES ("+Q_IdI+Q_NI+Q_NEI+Q_NII+Q_NCI+Q_CI+Q_MI+")";
			stm.executeUpdate(query);
			JOptionPane.showMessageDialog(null, "Instituto agregado correctamente");

		}catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
			e.printStackTrace();
		}
		
	}
	
	public void eliminarInst(String IdI) {
		
		try {
						
			cn = conexion.conectar();
			stm = cn.createStatement();

			String query = "DELETE FROM institucion WHERE Id_Inst = '"+IdI+"'";
			stm.executeUpdate(query);
			JOptionPane.showMessageDialog(null, "Registro eliminado correctamente");
			
		}catch (SQLException e) {
			
			JOptionPane.showMessageDialog(null, e.getMessage());
			e.printStackTrace();
		}
		
	}
	
	public void modificarInst(String IdI, String NI, String NEI, String NII, String NCI, String CI, String MI) {
		
		try {
			
			cn = conexion.conectar();
			stm = cn.createStatement();

			String query = "UPDATE institucion SET Id_Inst = '"+IdI+"', Nombre_Inst = '"+NI+"', Num_Exterior = '"+NEI+"', Num_Interior = '"+NII+"', Nom_Calle = '"+NCI+"', Colonia = '"+CI+"', Municipio = '"+MI+"' WHERE Id_Inst = '"+IdI+"'";
			stm.executeUpdate(query);
			JOptionPane.showMessageDialog(null, "Registro modificado correctamente");
			
		}catch (SQLException e)	{
			
			JOptionPane.showMessageDialog(null, e.getMessage());
			e.printStackTrace();
			
		} 
		
	}
	
	public DefaultTableModel mostrarRegistrosIns(String query) {
		
		String[] cabecera = {"Id_Inst", "Nombre_Inst", "Num_Exterior", "Num_Interior", "Nom_Calle", "Colonia", "Municipio"};
		String[] datos = new String[7];
		
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
				datos[6] = rs.getString(7);
				modelo.addRow(datos);
			}while(rs.next());

		}catch (SQLException e) {
			
			JOptionPane.showMessageDialog(null, e.getMessage());
			e.printStackTrace();
			
		} 

		return modelo;
		
	}
	
}
