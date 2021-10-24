package Consultas;

import Conexion.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Aspirante_Querys {
	
	ConexionBD conexion = new ConexionBD();
	Connection cn = null;
	Statement stm = null;
	ResultSet rs = null;
	String[] datos=new String[5];
	
	
		
	//CallableStatement x = cn.prepareCall("{call sorteo (nombre,apellidop,apellidom,curp,edad,num_ext,num_int,calle,colonia,ciudad,clase,estado_civ,profesion,sexo,discapacidad)}"); 
	
	
public void RegistraAspirante(String Nombres, String ApellidoPat, String ApellidoMat, String CURP, String Edad, String Calle, String Num_Exterior, String Num_Interior,	String Colonia, String Ciudad,String Clase,  String EstadoCivil,String Profesion,String Sexo, String Discapacidad) {
		
		try {

			cn = conexion.conectar();
			stm = cn.createStatement();
			CallableStatement cstmt;			
			
			cstmt = cn.prepareCall("CALL sorteo(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			

			int edad=0,num_ext,num_int,clase;
			
			edad = Integer.valueOf(Edad);
			num_ext =Integer.valueOf(Num_Exterior);
			num_int = Integer.valueOf(Num_Interior);
			clase = Integer.valueOf(Clase);
			
			cstmt.setString(1,Nombres);
			cstmt.setString(2,ApellidoPat);
			cstmt.setString(3,ApellidoMat);
			cstmt.setString(4,CURP);
			cstmt.setInt(5,edad);
			cstmt.setString(6,Calle);
			cstmt.setInt(7,num_ext);
			cstmt.setInt(8,num_int);
			cstmt.setString(9,Colonia);
			cstmt.setString(10,Ciudad);
			cstmt.setInt(11,clase);
			cstmt.setString(12,EstadoCivil);
			cstmt.setString(13,Profesion);
			cstmt.setString(14,Sexo);
			cstmt.setString(15,Discapacidad);
			
			cstmt.registerOutParameter(16, java.sql.Types.VARCHAR);
			cstmt.registerOutParameter(17, java.sql.Types.VARCHAR);
			cstmt.registerOutParameter(18, java.sql.Types.VARCHAR);
			cstmt.registerOutParameter(19, java.sql.Types.VARCHAR);
			cstmt.registerOutParameter(20, java.sql.Types.VARCHAR);
			cstmt.registerOutParameter(21, java.sql.Types.VARCHAR);
			cstmt.registerOutParameter(22, java.sql.Types.VARCHAR);
			
			cstmt.executeUpdate();
			
			/*System.out.println("\n"+cstmt.getString(16)+
					"\n"+cstmt.getString(17)+
					"\n"+cstmt.getString(18)+
					"\n"+cstmt.getString(19)+
					"\n"+cstmt.getString(20)+
					"\n"+cstmt.getString(21)+
					"\n"+cstmt.getString(22));*/
			
			
		} catch (SQLException e) {
			
			JOptionPane.showMessageDialog(null, e.getMessage());
			e.printStackTrace();
			
		}

	}



public DefaultTableModel mostrarRegistrosAsp(String Nombres, String ApellidoPat, String ApellidoMat, String CURP, String Edad, String Calle, String Num_Exterior, String Num_Interior,	String Colonia, String Ciudad,String Clase,  String EstadoCivil,String Profesion,String Sexo, String Discapacidad,String query) {
	String[] cabecera = { "Matricula", "Nombre_Aspirante", "Resultado sorteo", "Tipo", "NumLiberacion_Cartilla"};
	String[] datos = new String[5];

	DefaultTableModel modelo = new DefaultTableModel(null, cabecera);
	
	try {

		cn = conexion.conectar();
		stm = cn.createStatement();
		CallableStatement cstmt;			
		
		cstmt = cn.prepareCall("CALL sorteo(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
		

		int edad=0,num_ext,num_int,clase;
		
		edad = Integer.valueOf(Edad);
		num_ext =Integer.valueOf(Num_Exterior);
		num_int = Integer.valueOf(Num_Interior);
		clase = Integer.valueOf(Clase);
		
		cstmt.setString(1,Nombres);
		cstmt.setString(2,ApellidoPat);
		cstmt.setString(3,ApellidoMat);
		cstmt.setString(4,CURP);
		cstmt.setInt(5,edad);
		cstmt.setString(6,Calle);
		cstmt.setInt(7,num_ext);
		cstmt.setInt(8,num_int);
		cstmt.setString(9,Colonia);
		cstmt.setString(10,Ciudad);
		cstmt.setInt(11,clase);
		cstmt.setString(12,EstadoCivil);
		cstmt.setString(13,Profesion);
		cstmt.setString(14,Sexo);
		cstmt.setString(15,Discapacidad);
		
		cstmt.registerOutParameter(16, java.sql.Types.VARCHAR);
		cstmt.registerOutParameter(17, java.sql.Types.VARCHAR);
		cstmt.registerOutParameter(18, java.sql.Types.VARCHAR);
		cstmt.registerOutParameter(19, java.sql.Types.VARCHAR);
		cstmt.registerOutParameter(20, java.sql.Types.VARCHAR);
		cstmt.registerOutParameter(21, java.sql.Types.VARCHAR);
		cstmt.registerOutParameter(22, java.sql.Types.VARCHAR);
		
		cstmt.executeUpdate();
		
	
		System.out.println("\n"+cstmt.getString(16)+
				"\n"+cstmt.getString(17)+
				"\n"+cstmt.getString(18)+
				"\n"+cstmt.getString(19)+
				"\n"+cstmt.getString(20)+
				"\n"+cstmt.getString(21)+
				"\n"+cstmt.getString(22));

	
				datos[0] = cstmt.getString(16);
				datos[1] = cstmt.getString(17)+cstmt.getString(18)+cstmt.getString(19);
				datos[2] = cstmt.getString(20);
				datos[3] = cstmt.getString(21);
				datos[4] = cstmt.getString(22);
								modelo.addRow(datos);
		
	} catch (SQLException e) {
		
		JOptionPane.showMessageDialog(null, e.getMessage());
		e.printStackTrace();
		
	}

	


return modelo;
}
	
}
