package Consultas;

import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import Conexion.ConexionBD;

public class Participa_res_Querys {
	
	ConexionBD conexion = new ConexionBD();
	Connection cn = null;
	Statement stm = null;
	ResultSet rs = null;

	public void ingresar_ParR(String Matricula, String Ed, String Resultado) {
		
		try {
			
			// cn = conexion.conectar(1);
			String Q_Matricula, Q_Ed, Q_Resultado;
			
			if (Matricula.equals("")) {
				Matricula = null;
				Q_Matricula = "" + Matricula + ", ";
			} else
				Q_Matricula = "'" + Matricula + "', ";

			if (Ed.equals("")) {
				Ed = null;
				Q_Ed = "" + Ed;
			} else
				Q_Ed = "'" + Ed + "', ";

			if (Resultado.equals("")) {
				Resultado = null;
				Q_Resultado = "" + Resultado;
			} else
				Q_Resultado = "'" + Resultado + "'";

			String query = "INSERT INTO participa_res(Matricula_Res, Ed_Sorteo, Resultado) VALUES(" + Q_Matricula + Q_Ed + Q_Resultado + ")";
			stm.executeUpdate(query);
			JOptionPane.showMessageDialog(null, "Participante reserva agregado correctamente");
			
		} catch (SQLException e) {
			
			JOptionPane.showMessageDialog(null, e.getMessage());
			e.printStackTrace();
			
		}

	}

	public void modificar_ParR(String Matricula, String Ed, String Resultado) {
		
		try {
			
			cn = conexion.conectar();
			stm = cn.createStatement();

			String query = "UPDATE participa_res SET Ed_Sorteo = '" + Ed + "', Resultado = '" + Resultado + "' WHERE Matricula_Res = '" + Matricula + "'";
			stm.executeUpdate(query);
			JOptionPane.showMessageDialog(null, "Participa reserva modificado correctamente");
			
		} catch (SQLException e) {
			
			JOptionPane.showMessageDialog(null, e.getMessage());
			e.printStackTrace();
			
		}

	}

	public void eliminar_ParR(String Matricula) {
		
		try {
			
			cn = conexion.conectar();
			stm = cn.createStatement();

			String query = "DELETE FROM participa_res WHERE Matricula_Res = '" + Matricula + "'";
			stm.executeUpdate(query);
			JOptionPane.showMessageDialog(null, "Participa reserva eliminado correctamente");

		} catch (SQLException e) {
			
			JOptionPane.showMessageDialog(null, e.getMessage());
			e.printStackTrace();
			
		}

	}

	public DefaultTableModel mostrarRegistrosNumT(String query) {
		
		String[] cabecera = { "Matricula_Res", "Ed_Sorteo", "Resultado" };
		String[] datos = new String[3];

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
