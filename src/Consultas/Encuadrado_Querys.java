package Consultas;

import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import Conexion.ConexionBD;

public class Encuadrado_Querys {
	
	ConexionBD conexion = new ConexionBD();
	Connection cn = null;
	Statement stm = null;
	ResultSet rs = null;
	
	public void ingresar_Enc(String MatriculaEnc, String Nombres_Enc, String ApellidoPat_Enc, String ApellidoMat_Enc, String CURP_Enc, String Edad_Enc, String Profesion_Enc, String Num_Exterior, String Num_Interior,	String Nom_Calle, String Colonia, String Ciudad, String Sexo_Enc, String EstadoCivil_Enc, String Discapacidad_Enc, String Clase, String Habilidad, String TipoSangre, String Peso, String Altura) {
		
		try {

			cn = conexion.conectar();
			stm = cn.createStatement();
			
			String Q_MatriculaEnc, Q_Nombres_Enc, Q_ApellidoPat_Enc, Q_ApellidoMat_Enc, Q_CURP_Enc, Q_Edad_Enc,	Q_Profesion_Enc, Q_Num_Exterior, Q_Num_Interior, Q_Nom_Calle, Q_Colonia, Q_Ciudad, Q_Sexo_Enc,	Q_EstadoCivil_Enc, Q_Discapacidad_Enc, Q_Clase, Q_Habilidad, Q_TipoSangre, Q_Peso, Q_Altura;

			if (MatriculaEnc.equals("")) {
				MatriculaEnc = null;
				Q_MatriculaEnc = "" + MatriculaEnc + ", ";
			} else
				Q_MatriculaEnc = "'" + MatriculaEnc + "', ";

			if (Nombres_Enc.equals("")) {
				Nombres_Enc = null;
				Q_Nombres_Enc = "" + Nombres_Enc + ", ";
			} else
				Q_Nombres_Enc = "'" + Nombres_Enc + "', ";

			if (ApellidoPat_Enc.equals("")) {
				ApellidoPat_Enc = null;
				Q_ApellidoPat_Enc = "" + ApellidoPat_Enc + ", ";
			} else
				Q_ApellidoPat_Enc = "'" + ApellidoPat_Enc + "', ";

			if (ApellidoMat_Enc.equals("")) {
				ApellidoMat_Enc = null;
				Q_ApellidoMat_Enc = "" + ApellidoMat_Enc + ", ";
			} else
				Q_ApellidoMat_Enc = "'" + ApellidoMat_Enc + "', ";

			if (CURP_Enc.equals("")) {
				CURP_Enc = null;
				Q_CURP_Enc = "" + CURP_Enc + ", ";
			} else
				Q_CURP_Enc = "'" + CURP_Enc + "', ";

			if (Edad_Enc.equals("")) {
				Edad_Enc = null;
				Q_Edad_Enc = "" + Edad_Enc + ", ";
			} else
				Q_Edad_Enc = "'" + Edad_Enc + "', ";

			if (Profesion_Enc.equals("")) {
				Profesion_Enc = null;
				Q_Profesion_Enc = "" + Profesion_Enc + ", ";
			} else
				Q_Profesion_Enc = "'" + Profesion_Enc + "', ";

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

			if (Sexo_Enc.equals("")) {
				Sexo_Enc = null;
				Q_Sexo_Enc = "" + Sexo_Enc + ", ";
			} else
				Q_Sexo_Enc = "'" + Sexo_Enc + "', ";

			if (EstadoCivil_Enc.equals("")) {
				EstadoCivil_Enc = null;
				Q_EstadoCivil_Enc = "" + EstadoCivil_Enc + ", ";
			} else
				Q_EstadoCivil_Enc = "'" + EstadoCivil_Enc + "', ";

			if (Discapacidad_Enc.equals("")) {
				Discapacidad_Enc = null;
				Q_Discapacidad_Enc = "" + Discapacidad_Enc + ", ";
			} else
				Q_Discapacidad_Enc = "'" + Discapacidad_Enc + "', ";

			if (Clase.equals("")) {
				Clase = null;
				Q_Clase = "" + Clase + ", ";
			} else
				Q_Clase = "'" + Clase + "', ";

			if (Habilidad.equals("")) {
				Habilidad = null;
				Q_Habilidad = "" + Habilidad + ", ";
			} else
				Q_Habilidad = "'" + Habilidad + "', ";

			if (TipoSangre.equals("")) {
				TipoSangre = null;
				Q_TipoSangre = "" + TipoSangre + ", ";
			} else
				Q_TipoSangre = "'" + TipoSangre + "', ";

			if (Peso.equals("")) {
				Peso = null;
				Q_Peso = "" + Peso + ", ";
			} else
				Q_Peso = "'" + Peso + "', ";

			if (Altura.equals("")) {
				Altura = null;
				Q_Altura = "" + Altura + "";
			} else
				Q_Altura = "'" + Altura + "'";

			String query = "INSERT INTO encuadrado(Matricula_Enc, Nombres_Enc, ApellidoPat_Enc, ApellidoMat_Enc, CURP_Enc, Edad_Enc, Profesión_Enc, Num_Exterior, Num_Interior, Nom_Calle, Colonia, Ciudad, Sexo_Enc, EstadoCivil_Enc, Discapacidad_Enc, Clase, Habilidad, TipoSangre, Peso, Altura) VALUES("+ Q_MatriculaEnc + Q_Nombres_Enc + Q_ApellidoPat_Enc + Q_ApellidoMat_Enc + Q_CURP_Enc + Q_Edad_Enc	+ Q_Profesion_Enc + Q_Num_Exterior + Q_Num_Interior + Q_Nom_Calle + Q_Colonia + Q_Ciudad + Q_Sexo_Enc + Q_EstadoCivil_Enc + Q_Discapacidad_Enc + Q_Clase + Q_Habilidad + Q_TipoSangre + Q_Peso + Q_Altura + ")";
			stm.executeUpdate(query);
			JOptionPane.showMessageDialog(null, "Encuadrado agregado correctamente");
			
		} catch (SQLException e) {
			
			JOptionPane.showMessageDialog(null, e.getMessage());
			e.printStackTrace();
			
		}

	}

	public void modificar_Enc(String MatriculaEnc, String Nombres_Enc, String ApellidoPat_Enc, String ApellidoMat_Enc, String CURP_Enc, String Edad_Enc, String Profesion_Enc, String Num_Exterior, String Num_Interior, String Nom_Calle, String Colonia, String Ciudad, String Sexo_Enc, String EstadoCivil_Enc, String Discapacidad_Enc, String Clase, String Habilidad, String TipoSangre, String Peso, String Altura) {	
		
		try {
			
			cn = conexion.conectar();
			stm = cn.createStatement();

			String query = "UPDATE encuadrado SET Nombres_Enc = '" + Nombres_Enc + "', ApellidoPat_Enc = '"	+ ApellidoPat_Enc + "', ApellidoMat_Enc = '" + ApellidoMat_Enc + "', CURP_Enc = '" + CURP_Enc + "', Edad_Enc = '" + Edad_Enc + "', Profesión_Enc = '" + Profesion_Enc + "', Num_Exterior = '" + Num_Exterior + "', Num_Interior = '" + Num_Interior + "', Nom_Calle = '" + Nom_Calle + "', Colonia = '" + Colonia + "', Ciudad = '" + Ciudad + "', Sexo_Enc = '" + Sexo_Enc	+ "', EstadoCivil_Enc = '" + EstadoCivil_Enc + "', Discapacidad_Enc = '" + Discapacidad_Enc	+ "', Clase = '" + Clase + "', habilidad = '" + Habilidad + "', TipoSangre = '" + TipoSangre + "', Peso = '" + Peso + "', Altura = '" + Altura + "' WHERE Matricula_Enc = '" + MatriculaEnc	+ "'";
			stm.executeUpdate(query);
			JOptionPane.showMessageDialog(null, "Encuadrado modificado correctamente");
			
		} catch (SQLException e) {
			
			JOptionPane.showMessageDialog(null, e.getMessage());
			e.printStackTrace();
			
		}
	
	}

	public void eliminar_Enc(String Matricula_Enc) {
		
		try {
			
			cn = conexion.conectar();
			stm = cn.createStatement();

			String query = "DELETE FROM encuadrado WHERE Matricula_Enc = '" + Matricula_Enc + "'";
			stm.executeUpdate(query);
			JOptionPane.showMessageDialog(null, "Encuadrado eliminado correctamente");

		} catch (SQLException e) {
			
			JOptionPane.showMessageDialog(null, e.getMessage());
			e.printStackTrace();
			
		}

	}

	public DefaultTableModel mostrarRegistrosNumT(String query) {
		
		String[] cabecera = { "Matricula_Enc", "Nombres_Enc", "ApellidoPat_Enc", "ApellidoMat_Enc", "CURP_Enc", "Edad_Enc", "Profesión_Enc", "Num_Exterior", "Num_Interior", "Nom_Calle", "Colonia", "Ciudad", "Sexo_Enc", "EstadoCivil_Enc", "Discapacidad_Enc", "Clase", "Habilidad", "TipoSangre", "Peso", "Altura" };
		String[] datos = new String[21];

		DefaultTableModel modelo = new DefaultTableModel(null, cabecera);

		try {
			cn = conexion.conectar();
			stm = cn.createStatement();
			rs = stm.executeQuery(query);

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

		} catch (SQLException e) {
			
			JOptionPane.showMessageDialog(null, e.getMessage());
			e.printStackTrace();
			
		}

		return modelo;

	}
	
}
