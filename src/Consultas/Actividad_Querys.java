package Consultas;

import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import Conexion.ConexionBD;

public class Actividad_Querys {
	
	ConexionBD conexion = new ConexionBD();
	Connection cn = null;
	Statement stm = null;
	ResultSet rs = null;

	public void ingresar_actividad(String NPA, String MEA, String NSA, String IIA, String HIA, String HFA, String FA, String TAA, String CAA) {
		
		try {
			
			cn = conexion.conectar();
			stm = cn.createStatement();
			
			String Q_NPA, Q_MEA, Q_NSA, Q_IIA, Q_HIA, Q_HFA, Q_FA, Q_TAA, Q_CAA;
			
			if (NPA.equals("")) {
				NPA = null;
				Q_NPA = "" + NPA + ", ";
			} else
				Q_NPA = "'" + NPA + "', ";

			if (MEA.equals("")) {
				MEA = null;
				Q_MEA = "" + MEA + ", ";
			} else
				Q_MEA = "'" + MEA + "', ";

			if (NSA.equals("")) {
				NSA = null;
				Q_NSA = "" + NSA + ", ";
			} else
				Q_NSA = "'" + NSA + "', ";

			if (IIA.equals("")) {
				IIA = null;
				Q_IIA = "" + IIA + ", ";
			} else
				Q_IIA = "'" + IIA + "', ";

			if (HIA.equals("")) {
				HIA = null;
				Q_HIA = "" + HIA + ", ";
			} else
				Q_HIA = "'" + HIA + "', ";

			if (HFA.equals("")) {
				HFA = null;
				Q_HFA = "" + HFA + ",";
			} else
				Q_HFA = "'" + HFA + "', ";

			if (FA.equals("")) {
				FA = null;
				Q_FA = "" + FA + ", ";
			} else
				Q_FA = "'" + FA + "', ";

			if (TAA.equals("")) {
				TAA = null;
				Q_TAA = "" + TAA + ", ";
			} else
				Q_TAA = "'" + TAA + "', ";

			if (CAA.equals("")) {
				CAA = null;
				Q_CAA = "" + CAA + "";
			} else
				Q_CAA = "'" + CAA + "'";

			String query = "INSERT INTO actividad(Num_Placa, Matricula_Enc, N_Sección, Id_Inst, HoraInicio, HoraFin, Fecha, T_Actividad, Coste_Act) VALUES(" + Q_NPA + Q_MEA + Q_NSA + Q_IIA + Q_HIA + Q_HFA + Q_FA + Q_TAA + Q_CAA + ")";
			stm.executeUpdate(query);
			
		} catch (SQLException e) {
			
			JOptionPane.showMessageDialog(null, e.getErrorCode() + ": " + e.getMessage());
			e.printStackTrace();
			
		}
		
	}

	public void modificar_actividad(String NPA, String MEA, String NSA, String IIA, String HIA, String HFA, String FA, String TAA, String CAA) {
		
		try {
			
			cn = conexion.conectar();
			stm = cn.createStatement();

			String query = "Update actividad SET HoraInicio = '" + HIA + "', HoraFin = '" + HFA + "', Fecha = '" + FA + "', T_Actividad = '" + TAA + "', Coste_Act = '" + CAA + "' WHERE Num_Placa = '" + NPA + "' AND Matricula_Enc = '" + MEA + "' AND N_Sección = '" + NSA + "' AND Id_Inst = '" + IIA + "'";
			stm.executeUpdate(query);
			
		} catch (SQLException e) {
			
			JOptionPane.showMessageDialog(null, e.getErrorCode() + ": " + e.getMessage());
			e.printStackTrace();
			
		}
		
	}

	public void eliminar_actividad(String NPA, String MEA, String NSA, String IIA) {
		
		try {
			
			cn = conexion.conectar();
			stm = cn.createStatement();

			String query = "DELETE FROM actividad WHERE Num_Placa = '" + NPA + "' AND Matricula_Enc = '" + MEA+ "' AND N_Sección = '" + NSA + "' AND Id_Inst = '" + IIA + "'";
			stm.executeUpdate(query);

		} catch (SQLException e) {
			
			JOptionPane.showMessageDialog(null, e.getErrorCode() + ": " + e.getMessage());
			e.printStackTrace();
			
		}
		
	}

	public DefaultTableModel mostrarRegistrosAct(String query) {
		
		String[] cabecera = { "Num_Placa", "Matricula_Enc", "N_Sección", "Id_Inst", "HoraInicio", "HoraFin", "Fecha", "T_Actividad", "Coste_Act" };
		String[] datos = new String[9];

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
					datos[3] = rs.getString(4);
					datos[4] = rs.getString(5);
					datos[5] = rs.getString(6);
					datos[6] = rs.getString(7);
					datos[7] = rs.getString(8);
					datos[8] = rs.getString(9);
					modelo.addRow(datos);
				} while (rs.next());
				
			}

		} catch (SQLException e) {
			
			JOptionPane.showMessageDialog(null, e.getErrorCode() + ": " + e.getMessage());
			e.printStackTrace();
			
		}

		return modelo;

	}
	
}
