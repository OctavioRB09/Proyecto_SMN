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
	
	
public void inv(String Matricula, String Nombres, String ApellidoPat, String ApellidoMat, String CURP, String Edad, String Profesion, String Num_Exterior, String Num_Interior,	String Nom_Calle, String Colonia, String Ciudad, String Sexo, String EstadoCivil, String Discapacidad, String Clase) {
		
		try {

			cn = conexion.conectar();
			stm = cn.createStatement();
			
			String  Q_Nombres, Q_ApellidoPat, Q_ApellidoMat, Q_CURP, Q_Edad,Q_Profesion, Q_Num_Exterior, Q_Num_Interior, Q_Nom_Calle, Q_Colonia, Q_Ciudad, Q_Sexo,	Q_EstadoCivil, Q_Discapacidad, Q_Clase;

			/*if (Matricula.equals("")) {
				Matricula = null;
				Q_Matricula = "" + Matricula + ", ";
			} else
				Q_Matricula = "'" + Matricula + "', ";*/

			if (Nombres.equals("")) {
				Nombres = null;
				Q_Nombres = "" + Nombres + ", ";
			} else
				Q_Nombres = "'" + Nombres + "', ";

			if (ApellidoPat.equals("")) {
				ApellidoPat = null;
				Q_ApellidoPat = "" + ApellidoPat + ", ";
			} else
				Q_ApellidoPat= "'" + ApellidoPat + "', ";
			
			if (ApellidoMat.equals("")) {
				ApellidoMat= null;
				Q_ApellidoMat = "" + ApellidoMat + ", ";
			} else
				Q_ApellidoMat = "'" + ApellidoMat + "', ";

			if (CURP.equals("")) {
				CURP = null;
				Q_CURP = "" + CURP+ ", ";
			} else
				Q_CURP = "'" + CURP + "', ";

			if (Edad.equals("")) {
				Edad = null;
				Q_Edad = "" + Edad + ", ";
			} else
				Q_Edad= "'" + Edad + "', ";

			if (Profesion.equals("")) {
				Profesion = null;
				Q_Profesion = "" + Profesion + ", ";
			} else
				Q_Profesion = "'" + Profesion + "', ";

			if (Num_Exterior.equals("")) {
				Num_Exterior = null;
				Q_Num_Exterior = "" + Num_Exterior + ", ";
			} else
				Q_Num_Exterior = "'" + Num_Exterior + "', ";

			if (Num_Interior.equals("")) {
				Num_Interior = null;
				Q_Num_Interior = "" + Num_Interior + ", ";
			} else
				Q_Num_Interior = "'" + Num_Interior + "', ";

			if (Nom_Calle.equals("")) {
				Nom_Calle = null;
				Q_Nom_Calle = "" + Nom_Calle + ", ";
			} else
				Q_Nom_Calle = "'" + Nom_Calle + "', ";

			if (Colonia.equals("")) {
				Colonia = null;
				Q_Colonia = "" + Colonia + ", ";
			} else
				Q_Colonia = "'" + Colonia + "', ";

			if (Ciudad.equals("")) {
				Ciudad = null;
				Q_Ciudad = "" + Ciudad + ", ";
			} else
				Q_Ciudad = "'" + Ciudad + "', ";

			if (Sexo.equals("")) {
				Sexo = null;
				Q_Sexo = "" + Sexo + ", ";
			} else
				Q_Sexo= "'" + Sexo + "', ";

			if (EstadoCivil.equals("")) {
				EstadoCivil = null;
				Q_EstadoCivil = "" + EstadoCivil + ", ";
			} else
				Q_EstadoCivil = "'" + EstadoCivil + "', ";

			if (Discapacidad.equals("")) {
				Discapacidad = null;
				Q_Discapacidad = "" + Discapacidad+ ", ";
			} else
				Q_Discapacidad = "'" + Discapacidad + "', ";

			if (Clase.equals("")) {
				Clase = null;
				Q_Clase = "" + Clase + ", ";
			} else
				Q_Clase = "'" + Clase + "', ";


			String query = "Call sorteo (nombre,apellidop,apellidom,curp,edad,num_ext,num_int,calle,colonia,ciudad,clase,estado_civ,profesion,sexo,discapacidad) VALUES("+ Q_Nombres + Q_ApellidoPat + Q_ApellidoMat + Q_CURP + Q_Edad +  Q_Num_Exterior + Q_Num_Interior + Q_Nom_Calle + Q_Colonia + Q_Ciudad + Q_Clase + Q_EstadoCivil +Q_Profesion +Q_Sexo +  Q_Discapacidad   +''+ ")";
			stm.executeUpdate(query);
			
		} catch (SQLException e) {
			
			JOptionPane.showMessageDialog(null, e.getMessage());
			e.printStackTrace();
			
		}

	}



public DefaultTableModel mostrarRegistrosEnc(String query) {
	
	String[] cabecera = {  "Nombres", "ApellidoPat", "ApellidoMat", "CURP", "Edad", "Profesión", "Num_Exterior", "Num_Interior", "Nom_Calle", "Colonia", "Ciudad", "Sexo", "EstadoCivil", "Discapacidad", "Clase"};
	String[] datos = new String[22];

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
				datos[9] = rs.getString(10);
				datos[10] = rs.getString(11);
				datos[11] = rs.getString(12);
				datos[12] = rs.getString(13);
				datos[13] = rs.getString(14);
				datos[14] = rs.getString(15);
				datos[15] = rs.getString(16);
				datos[16] = rs.getString(17);
				datos[17] = rs.getString(18);
				datos[18] = rs.getString(19);
				datos[19] = rs.getString(20);
				datos[20] = rs.getString(21);
				datos[21] = rs.getString(22);
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
