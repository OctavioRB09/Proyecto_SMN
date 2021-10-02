package Consultas;

import Conexion.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Valida_Querys {
	
	ConexionBD conexion = new ConexionBD();
	Connection cn = null;
	Statement stm = null;
	ResultSet rs = null;
	PreparedStatement ps = null;
	String[] datos=new String[5];
	
	String query="",Q_Numplaca="", Q_Matricula="", Q_NumLiberacion="",Q_Htrabajadas="", Q_Precio="";
	
	public void ingresar_valida(String Placa,String Matricula, String Num_Liberacion,String horas ,String Precio_Cart) {
		
		try {

			cn = conexion.conectar();
			stm = cn.createStatement();
			
			if(Placa.equals("")) {
				Matricula=null;
				Q_Numplaca=""+Placa+", ";
			}else Q_Numplaca="'"+Placa+"', ";
			
			if(Matricula.equals("")) {
				Matricula=null;
				Q_Matricula=""+Matricula+", ";
			}else Q_Matricula="'"+Matricula+"', ";
				
			if(horas.equals("")) {
				horas=null;
				Q_Htrabajadas=""+horas+", ";
			}else Q_Htrabajadas="'"+horas+"', ";
			
			if(Num_Liberacion.equals("")) {
				Num_Liberacion=null;
				Q_NumLiberacion=""+Num_Liberacion+", ";
			}else Q_NumLiberacion="'"+Num_Liberacion+"', ";
				
			if(Precio_Cart.equals("")) {
				Precio_Cart=null;
				Q_Precio=""+Precio_Cart+", ";
			}else Q_Precio="'"+Precio_Cart+"', ";
				
			
			
			query="INSERT INTO valida (Num_Placa,Matricula_Enc, Num_Liberacion,Horas_Trabajadas, Precio_Cart) VALUES ("+Q_Numplaca+Q_Matricula+Q_NumLiberacion+Q_Htrabajadas+Q_Precio+")";
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
	
	public void eliminar_valida(String Matricula_Enc) {
		
		try {

			cn = conexion.conectar();
			stm = cn.createStatement();

			query = "DELETE FROM valida WHERE Matricula_Enc = '"+Matricula_Enc+"'";
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
	
	public void modificar_val(String Placa,String Matricula, String Num_Liberacion,String horas ,String Precio_Cart) {
		
		try {

			cn = conexion.conectar();
			stm = cn.createStatement();
			
			if(Placa.equals("")) {
				Matricula=null;
				Q_Numplaca=""+Placa+", ";
			}else Q_Numplaca="'"+Placa+"', ";
			
			if(Matricula.equals("")) {
				Matricula=null;
				Q_Matricula=""+Matricula+", ";
			}else Q_Matricula="'"+Matricula+"', ";
				
			if(horas.equals("")) {
				horas=null;
				Q_Htrabajadas=""+horas+", ";
			}else Q_Htrabajadas="'"+horas+"', ";
			
			if(Num_Liberacion.equals("")) {
				Num_Liberacion=null;
				Q_NumLiberacion=""+Num_Liberacion+", ";
			}else Q_NumLiberacion="'"+Num_Liberacion+"', ";
				
			if(Precio_Cart.equals("")) {
				Precio_Cart=null;
				Q_Precio=""+Precio_Cart+", ";
			}else Q_Precio="'"+Precio_Cart+"', ";
			
			query = "UPDATE valida SET Matricula_Enc"+Q_Matricula+",Num_Liberacion = "+Q_NumLiberacion+",Horas_Trabajadas="+Q_Htrabajadas +", Precio_Cart = "+Q_Precio+" WHERE Num_Placa = "+Q_Numplaca;
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
	
	public DefaultTableModel mostrarRegistrosValida(String query) {
		
		String[] cabecera = {"Num_Placa","Matricula_Enc", "Num_Liberacion","Horas_Trabajadas", "Precio_Cart"};
		
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
					modelo.addRow(datos);
					
				} while(rs.next());
				
			}else
				for(int i=0; i<datos.length; i++) datos[i]="";
			

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
	
	public String[] vector_edits(String[] datos_salida) {
		
		for(int i=0; i<datos.length; i++) {
			datos_salida[i]=datos[i];
		}
		
		return datos_salida;
		
	}

}
