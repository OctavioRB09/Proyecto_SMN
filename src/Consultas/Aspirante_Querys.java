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
			
			String  Q_Matricula="",Q_Nombres, Q_ApellidoPat, Q_ApellidoMat, Q_CURP, Q_Edad,Q_Profesion, Q_Num_Exterior, Q_Num_Interior, Q_Nom_Calle, Q_Colonia, Q_Ciudad, Q_Sexo,	Q_EstadoCivil, Q_Discapacidad, Q_Clase;
			
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

			if (Calle.equals("")) {
				Calle = null;
				Q_Nom_Calle = "" + Calle + ", ";
			} else
				Q_Nom_Calle = "'" + Calle + "', ";

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
			
			//String query = "CALL sorteo("+Q_Nombres+ Q_ApellidoPat+ Q_ApellidoMat+ Q_CURP+ Q_Edad+ Q_Num_Exterior+ Q_Num_Interior+ Q_Nom_Calle+ Q_Colonia+ Q_Ciudad+ Q_Clase+ Q_EstadoCivil+ Q_Profesion+ Q_Sexo+ Q_Discapacidad+" @matricula, @nombre_a, @apellidop_a, @apellidom_a, @resultado_sorteo, @tipo_aspirante, @num_liberacion)";
			//stm.executeUpdate(query);
			
		} catch (SQLException e) {
			
			JOptionPane.showMessageDialog(null, e.getMessage());
			e.printStackTrace();
			
		}

	}



public DefaultTableModel mostrarRegistrosAsp(String query) {
	
	String[] cabecera = { "Matricula", "Nombre_Aspirante", "Resultado sorteo", "Tipo", "NumLiberacion_Cartilla"};
	String[] datos = new String[5];

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
			} while (rs.next());
			
		}

	} catch (SQLException e) {
		
		JOptionPane.showMessageDialog(null, e.getMessage());
		e.printStackTrace();
		
	}


return modelo;
}
	
}
