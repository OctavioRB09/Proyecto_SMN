package Consultas;

import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import Conexion.ConexionBD;

public class NumTel_Institucion_Querys {
	
	ConexionBD conexion = new ConexionBD();
	Connection cn = null;
	Statement stm = null;
	ResultSet rs = null;

	public void ingresar_NumTel(String Id, String Numero) {

		try {
			
			// cn = conexion.conectar(1);
			String Q_Id, Q_Numero;
			
			if (Id.equals("")) {
				Id = null;
				Q_Id = "" + Id + ", ";
			} else
				Q_Id = "'" + Id + "', ";

			if (Numero.equals("")) {
				Numero = null;
				Q_Numero = "" + Numero;
			} else
				Q_Numero = "'" + Numero + "'";

			String query = "INSERT INTO NumTel_Institucion(Id_Inst, NumTel) VALUES(" + Q_Id + Q_Numero + ")";
			stm.executeUpdate(query);
			JOptionPane.showMessageDialog(null, "Numero de telefono de la institución agregado correctamente");
			
		} catch (SQLException e) {
			
			JOptionPane.showMessageDialog(null, e.getMessage());
			e.printStackTrace();
			
		}

	}

	public void modificar_NumTel(String Id, String Numero, String NumeroM) {
		
		try {
			
			cn = conexion.conectar();
			stm = cn.createStatement();

			String query = "UPDATE NumTel_Institucion SET NumTel = '" + NumeroM + "' WHERE Id_Inst = '" + Id + "' AND NumTel = '" + Numero + "'";
			stm.executeUpdate(query);
			JOptionPane.showMessageDialog(null, "Numero de telefono modificado correctamente");
			
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
			e.printStackTrace();
		}

	}

	public void eliminar_NumTel(String Numero) {
		
		try {
			
			cn = conexion.conectar();
			stm = cn.createStatement();

			String query = "DELETE FROM NumTel_Institucion WHERE NumTel = '" + Numero + "'";
			stm.executeUpdate(query);
			JOptionPane.showMessageDialog(null, "Numero de telefono eliminado correctamente");

		} catch (SQLException e) {
			
			JOptionPane.showMessageDialog(null, e.getMessage());
			e.printStackTrace();
			
		}

	}

	public DefaultTableModel mostrarRegistrosNumT(String query) {
		
		String[] cabecera = { "Id", "Numero de la Institución" };
		String[] datos = new String[2];

		DefaultTableModel modelo = new DefaultTableModel(null, cabecera);

		try {
			cn = conexion.conectar();
			stm = cn.createStatement();
			rs = stm.executeQuery(query);

			if (rs.next()) {
				do {
					datos[0] = rs.getString(1);
					datos[1] = rs.getString(2);
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
