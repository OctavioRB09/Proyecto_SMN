package Consultas;

import Conexion.*;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
//INICIO DE LA PRUEBA
public class Lidera_Querys {
	
	ConexionBD conexion = new ConexionBD();
	Connection cn = null;
	Statement stm = null;
	ResultSet rs = null;
	
	String query="", Q_etSargento="", Q_etCabo="";
	
	//SE INGRESA UN NUEVO REGISTRO A LA TABLA
	public void ingreso_reg(String etSargento, String etCabo) {
		
		try {
			
			cn = conexion.conectar();
			stm = cn.createStatement();
			
			if(etSargento.equals("")) {
				etSargento=null;
				Q_etSargento=""+etSargento+", ";
			}else Q_etSargento="'"+etSargento+"', ";
				
			if(etCabo.equals("")) {
				etCabo=null;
				Q_etCabo=""+etCabo+"";
			}else Q_etCabo="'"+etCabo+"'";
			
			query="INSERT INTO lidera (Num_PlacaSargento, Num_PlacaCabo) VALUES ("+Q_etSargento+""+Q_etCabo+")";
			stm.executeUpdate(query);
			
		} catch (SQLException e) {
			
			JOptionPane.showMessageDialog(null, e.getErrorCode()+": "+e.getMessage());
			e.printStackTrace();
			
		} finally { //CERRANDO LOS OBJETOS DE CONSULTA
			
			try {
				
				if(cn!=null) cn.close();
				if(stm!=null) stm.close();
				
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			
		}
		
	}

	//SE ELIMINA UN REGISTRO DE LA TABLA
	public void eliminar_reg(String etSargento, String etCabo) {

		try {

			cn = conexion.conectar();
			stm = cn.createStatement();

			String query = "DELETE FROM lidera WHERE Num_PlacaSargento = '"+etSargento+"'AND Num_PlacaCabo = '"+etCabo+"'";
			stm.executeUpdate(query);
			
		} catch (SQLException e) {
			
			JOptionPane.showMessageDialog(null, e.getErrorCode()+": "+e.getMessage());
			e.printStackTrace();
			
		} finally { //CERRANDO LOS OBJETOS DE CONSULTA
			
			try {
				
				if(cn!=null) cn.close();
				if(stm!=null) stm.close();
				
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			
		}
		
	}
	
	//SE MODIFICA UN REGISTRO EN LA TABLA
	public void modificar_reg(String etSargento, String etCabo) {
		
		try {
			
			cn = conexion.conectar();
			stm = cn.createStatement();
			
			String query = "UPDATE lidera SET Num_PlacaSargento = '"+etSargento+"' WHERE Num_PlacaCabo = '"+etCabo+"'";
			stm.executeUpdate(query);
			
		} catch (SQLException e) {
			
			JOptionPane.showMessageDialog(null, e.getErrorCode()+": "+e.getMessage());
			e.printStackTrace();
			
		} finally { //CERRANDO LOS OBJETOS DE CONSULTA
			
			try {
				
				if(cn!=null) cn.close();
				if(stm!=null) stm.close();
				
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			
		}
		
	}

	//MOSTRANDO LOS REGISTROS EN UNA TABLA
	public DefaultTableModel mostrarRegistros(String query) {
		
		String[] cabecera = {"Sargento", "Cabo"};
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

		} catch (SQLException e) {

			JOptionPane.showMessageDialog(null, e.getErrorCode()+": "+e.getMessage());
			e.printStackTrace();

		} finally { //CERRANDO LOS OBJETOS DE CONSULTA

			try {

				if(rs!=null) rs.close();
				if(stm!=null) stm.close();
				if(cn!=null) cn.close();				

			} catch (Exception e2) {
				e2.printStackTrace();
			}

		}
		
		return modelo;
		
	}
	
}