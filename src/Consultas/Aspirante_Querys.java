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

	public DefaultTableModel mostrarRegistrosAsp(String Nombres, String ApellidoPat, String ApellidoMat, String CURP, String Edad, String Calle, String Num_Exterior, String Num_Interior, String Colonia, String Ciudad, String Clase, String EstadoCivil, String Profesion, String Sexo, String Discapacidad, String query) {
		
		String[] cabecera = { "Matricula", "Nombre Aspirante", "Resultado sorteo", "Tipo", "Número Liberación C."};
		String[] datos = new String[5];
		int edad=0, clase=0;

		DefaultTableModel modelo = new DefaultTableModel(null, cabecera);

		try {

			cn = conexion.conectar();
			stm = cn.createStatement();
			CallableStatement cstmt;			
			cstmt = cn.prepareCall("CALL sorteo(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");

			edad = Integer.valueOf(Edad);
			clase = Integer.valueOf(Clase);

			cstmt.setString(1,Nombres);
			cstmt.setString(2,ApellidoPat);
			cstmt.setString(3,ApellidoMat);
			cstmt.setString(4,CURP);
			cstmt.setInt(5,edad);
			cstmt.setString(6,Num_Exterior);
			cstmt.setString(7,Num_Interior);
			cstmt.setString(8,Calle);
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
