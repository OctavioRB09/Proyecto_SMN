package Consultas;

import Conexion.*;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Instructor_Querys {
	
	//CLASE DE INSTRUCTOR
	ConexionBD conexion = new ConexionBD();
	Connection cn = null;
	Statement stm = null;
	ResultSet rs = null;
	
	String query="", Q_Placa="", Q_Nombre="", Q_ApellidoP="", Q_ApellidoM="", Q_Rango="", Q_Sueldo="";
	String[] datos = new String[6];
	
	public void ingresar_instructor(String Placa, String Nombre, String ApellidoP, String ApellidoM, String Rango, String Sueldo) {
		
		try {

			cn = conexion.conectar();
			stm = cn.createStatement();
			
			if(Placa.equals("")) {
				Placa=null;
				Q_Placa=""+Placa+", ";
			}else Q_Placa="'"+Placa+"', ";
				
			if(Nombre.equals("")) {
				Nombre=null;
				Q_Nombre=""+Nombre+", ";
			}else Q_Nombre="'"+Nombre+"', ";
				
			if(ApellidoP.equals("")) {
				ApellidoP=null;
				Q_ApellidoP=""+ApellidoP+", ";
			}else Q_ApellidoP="'"+ApellidoP+"', ";
				
			if(ApellidoM.equals("")) {
				ApellidoM=null;
				Q_ApellidoM=""+ApellidoM+", ";
			}else Q_ApellidoM="'"+ApellidoM+"', ";
				
			if(Rango.equals("")) {
				Rango=null;
				Q_Rango=""+Rango+", ";
			}else Q_Rango="'"+Rango+"', ";
				
			if(Sueldo.equals("")) {
				Sueldo=null;
				Q_Sueldo=""+Sueldo+"";
			}else Q_Sueldo="'"+Sueldo+"'";
			
			query="INSERT INTO instructor (Num_Placa, Nombre_Ins, ApellidoPat_Ins, ApellidoMat_Ins, Rango, Sueldo_Ins) VALUES ("+Q_Placa+Q_Nombre+Q_ApellidoP+Q_ApellidoM+Q_Rango+Q_Sueldo+")";
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
	
	public void eliminar_instructor(String Placa) {
		
		try {

			cn = conexion.conectar();
			stm = cn.createStatement();

			query = "DELETE FROM instructor WHERE Num_Placa = '"+Placa+"'";
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
	
	public void modificar_instructor(String Placa, String Nombre, String ApellidoP, String ApellidoM, String Rango, String Sueldo) {

		try {

			cn = conexion.conectar();
			stm = cn.createStatement();
			
			if(Placa.equals("")) {
				Placa=null;
				Q_Placa=""+Placa+"";
			}else Q_Placa="'"+Placa+"'";
				
			if(Nombre.equals("")) {
				Nombre=null;
				Q_Nombre=""+Nombre+"";
			}else Q_Nombre="'"+Nombre+"'";
				
			if(ApellidoP.equals("")) {
				ApellidoP=null;
				Q_ApellidoP=""+ApellidoP+"";
			}else Q_ApellidoP="'"+ApellidoP+"'";
				
			if(ApellidoM.equals("")) {
				ApellidoM=null;
				Q_ApellidoM=""+ApellidoM+"";
			}else Q_ApellidoM="'"+ApellidoM+"'";
				
			if(Rango.equals("")) {
				Rango=null;
				Q_Rango=""+Rango+"";
			}else Q_Rango="'"+Rango+"'";
				
			if(Sueldo.equals("")) {
				Sueldo=null;
				Q_Sueldo=""+Sueldo+"";
			}else Q_Sueldo="'"+Sueldo+"'";
			
			query = "UPDATE instructor SET Nombre_Ins = "+Q_Nombre+", ApellidoPat_Ins = "+Q_ApellidoP+", ApellidoMat_Ins = "+Q_ApellidoM+", Rango = "+Q_Rango+", Sueldo_Ins = "+Q_Sueldo+" WHERE Num_Placa = "+Q_Placa;
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

	public DefaultTableModel mostrarRegistrosIns(String query) {
		
		String[] cabecera = {"Placa", "Nombre", "Apellido Paterno", "Apellido Materno", "Rango", "Sueldo"};
		
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
	
	//METODO PARA LLEVAR EL VECTOR DE DATOS A LA CLASE FORMULARIO
	public String[] vector_edits(String[] datos_salida) {
		
		for(int i=0; i<datos.length; i++) {
			datos_salida[i]=datos[i];
		}
		
		return datos_salida;
		
	}
	
}
