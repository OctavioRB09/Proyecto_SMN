package Consultas;

import java.sql.*;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import Conexion.*;

public class Reserva_Querys {
	
	ConexionBD conexion = new ConexionBD();
	Connection cn = null;
	Statement stm = null;
	ResultSet rs = null;
	
	String query="", Q_MatRes="", Q_Nombre="", Q_ApellidoP="", Q_ApellidoM="", Q_Curp="", Q_Edad="", Q_Profesion="", Q_Ciudad="", Q_Colonia="", Q_Calle="", Q_NumInt="", Q_NumExt="", Q_Sexo="", Q_ECivil="", Q_Discapacidad="", Q_Clase="", Q_Telefono="";
	String[] datos = new String[17];
	
	public void ingresar_reserva(String MatRes, String Nombre, String ApellidoP, String ApellidoM, String Curp, String Edad, String Profesion, String Ciudad, String Colonia, String Calle , String NumInt, String NumExt, String Sexo, String ECivil, String Discapacidad, String Clase, String Telefono) {
		
		try {
			
			cn = conexion.conectar();
			stm = cn.createStatement();
			
			if (MatRes.equals("")) {
				MatRes = null;
				Q_MatRes = "" + MatRes + ", ";
			} else
				Q_MatRes = "'" + MatRes + "', ";

			if (Nombre.equals("")) {
				Nombre = null;
				Q_Nombre = "" + Nombre + ", ";
			} else
				Q_Nombre = "'" + Nombre + "', ";

			if (ApellidoP.equals("")) {
				ApellidoP = null;
				Q_ApellidoP = "" + ApellidoP + ", ";
			} else
				Q_ApellidoP = "'" + ApellidoP + "', ";

			if (ApellidoM.equals("")) {
				ApellidoM = null;
				Q_ApellidoM = "" + ApellidoM + ", ";
			} else
				Q_ApellidoM = "'" + ApellidoM + "', ";

			if (Curp.equals("")) {
				Curp = null;
				Q_Curp = "" + Curp + ", ";
			} else
				Q_Curp = "'" + Curp + "', ";

			if (Edad.equals("")) {
				Edad = null;
				Q_Edad = "" + Edad + ", ";
			} else
				Q_Edad = "'" + Edad + "', ";
			
			if (Profesion.equals("")) {
				Profesion = null;
				Q_Profesion = "" + Profesion + ", ";
			} else
				Q_Profesion = "'" + Profesion + "', ";

			if (Ciudad.equals("")) {
				Ciudad = null;
				Q_Ciudad = "" + Ciudad + ", ";
			} else
				Q_Ciudad = "'" + Ciudad + "', ";

			if (Colonia.equals("")) {
				Colonia = null;
				Q_Colonia = "" + Colonia + ", ";
			} else
				Q_Colonia = "'" + Colonia + "', ";

			if (Calle.equals("")) {
				Calle = null;
				Q_Calle = "" + Calle + ", ";
			} else
				Q_Calle = "'" + Calle + "', ";
			
			if (NumInt.equals("")) {
				NumInt = null;
				Q_NumInt = "" + NumInt + ", ";
			} else
				Q_NumInt = "'" + NumInt + "', ";

			if (NumExt.equals("")) {
				NumExt = null;
				Q_NumExt = "" + NumExt + ", ";
			} else
				Q_NumExt = "'" + NumExt + "', ";

			if (Sexo.equals("")) {
				Sexo = null;
				Q_Sexo = "" + Sexo + ", ";
			} else
				Q_Sexo = "'" + Sexo + "', ";

			if (ECivil.equals("")) {
				ECivil = null;
				Q_ECivil = "" + ECivil + ", ";
			} else
				Q_ECivil = "'" + ECivil + "', ";
			
			if (Discapacidad.equals("")) {
				Discapacidad = null;
				Q_Discapacidad = "" + Discapacidad + ", ";
			} else
				Q_Discapacidad = "'" + Discapacidad + "', ";

			if (Clase.equals("")) {
				Clase = null;
				Q_Clase = "" + Clase + ", ";
			} else
				Q_Clase = "'" + Clase + "', ";
			
			if (Telefono.equals("")) {
				Telefono = null;
				Q_Telefono = "" + Telefono + ", ";
			} else
				Q_Telefono = "'" + Telefono + "', ";
			
			query="INSERT INTO reserva (Matricula_Res,Nombres_Res,ApellidoPat_Res,ApellidoMat_Res,CURP_Res,Edad_Res,Profesión_Res,Num_Exterior,Num_Interior,Nom_Calle,Colonia,Ciudad,Sexo_Res,EstadoCivil_Res,Discapacidad_Res,Clase,Num_Tel,Tipo_Aspirante) VALUES ("+Q_MatRes+Q_Nombre+Q_ApellidoP+Q_ApellidoM+Q_Curp+Q_Edad+Q_Profesion+Q_NumExt+Q_NumInt+Q_Calle+Q_Colonia+Q_Ciudad+Q_Sexo+Q_ECivil+Q_Discapacidad+Q_Clase+Q_Telefono+"Reserva);";
			stm.executeUpdate(query);
			
		}catch(SQLException e) {
			
			JOptionPane.showMessageDialog(null, e.getErrorCode()+": "+e.getMessage());
			e.printStackTrace();
			
		}
		
	}
	
	public void eliminar_reserva(String MatRes) {
		
		try {
			
			cn = conexion.conectar();
			stm = cn.createStatement();
			
			query="DELETE FROM reserva WHERE Matricula_Res = '"+MatRes+"'";
			stm.executeUpdate(query);

		} catch (SQLException e) {
			
			JOptionPane.showMessageDialog(null, e.getErrorCode()+": "+e.getMessage());
			e.printStackTrace();
			
		}
		
	}
	
	public void modificar_reserva(String MatRes, String Nombre, String ApellidoP, String ApellidoM, String Curp, String Edad, String Profesion, String Ciudad, String Colonia, String Calle , String NumInt, String NumExt, String Sexo, String ECivil, String Discapacidad, String Clase, String Telefono) {
		
		try {
			
			cn = conexion.conectar();
			stm = cn.createStatement();
			
			if (MatRes.equals("")) {
				MatRes = null;
				Q_MatRes = "" + MatRes + "";
			} else
				Q_MatRes = "'" + MatRes + "'";

			if (Nombre.equals("")) {
				Nombre = null;
				Q_Nombre = "" + Nombre + "";
			} else
				Q_Nombre = "'" + Nombre + "'";

			if (ApellidoP.equals("")) {
				ApellidoP = null;
				Q_ApellidoP = "" + ApellidoP + "";
			} else
				Q_ApellidoP = "'" + ApellidoP + "'";

			if (ApellidoM.equals("")) {
				ApellidoM = null;
				Q_ApellidoM = "" + ApellidoM + "";
			} else
				Q_ApellidoM = "'" + ApellidoM + "'";

			if (Curp.equals("")) {
				Curp = null;
				Q_Curp = "" + Curp + "";
			} else
				Q_Curp = "'" + Curp + "'";

			if (Edad.equals("")) {
				Edad = null;
				Q_Edad = "" + Edad + "";
			} else
				Q_Edad = "'" + Edad + "'";
			
			if (Profesion.equals("")) {
				Profesion = null;
				Q_Profesion = "" + Profesion + "";
			} else
				Q_Profesion = "'" + Profesion + "'";

			if (Ciudad.equals("")) {
				Ciudad = null;
				Q_Ciudad = "" + Ciudad + "";
			} else
				Q_Ciudad = "'" + Ciudad + "'";

			if (Colonia.equals("")) {
				Colonia = null;
				Q_Colonia = "" + Colonia + "";
			} else
				Q_Colonia = "'" + Colonia + "'";

			if (Calle.equals("")) {
				Calle = null;
				Q_Calle = "" + Calle + "";
			} else
				Q_Calle = "'" + Calle + "'";
			
			if (NumInt.equals("")) {
				NumInt = null;
				Q_NumInt = "" + NumInt + "";
			} else
				Q_NumInt = "'" + NumInt + "'";

			if (NumExt.equals("")) {
				NumExt = null;
				Q_NumExt = "" + NumExt + "";
			} else
				Q_NumExt = "'" + NumExt + "'";

			if (Sexo.equals("")) {
				Sexo = null;
				Q_Sexo = "" + Sexo + "";
			} else
				Q_Sexo = "'" + Sexo + "'";

			if (ECivil.equals("")) {
				ECivil = null;
				Q_ECivil = "" + ECivil + "";
			} else
				Q_ECivil = "'" + ECivil + "'";
			
			if (Discapacidad.equals("")) {
				Discapacidad = null;
				Q_Discapacidad = "" + Discapacidad + "";
			} else
				Q_Discapacidad = "'" + Discapacidad + "'";

			if (Clase.equals("")) {
				Clase = null;
				Q_Clase = "" + Clase + "";
			} else
				Q_Clase = "'" + Clase + "'";
			
			if (Telefono.equals("")) {
				Telefono = null;
				Q_Telefono = "" + Telefono + "";
			} else
				Q_Telefono = "'" + Telefono + "'";
			
			query="UPDATE reserva SET Nombres_Res="+Q_Nombre+", ApellidoPat_Res = "+Q_ApellidoP+", ApellidoMat_Res = "+Q_ApellidoM+", CURP_Res = "+Q_Curp+", Edad_Res = "+Q_Edad+", Profesión_Res = "+Q_Profesion+", Num_Exterior = "+Q_NumExt+", Num_Interior = "+Q_NumInt+", Nom_Calle = "+Q_Calle+", Colonia = "+Q_Colonia+", Ciudad = "+Q_Ciudad+", Sexo_Res = "+Q_Sexo+", EstadoCivil_Res="+Q_ECivil+", Discapacidad_Res = "+Q_Discapacidad+", Clase = "+Q_Clase+", Num_Tel = "+Q_Telefono+", Tipo_Aspirante = 'Reserva' WHERE Matricula_Res = "+Q_MatRes;
			stm.executeUpdate(query);
			
		} catch (SQLException e) {
			
			JOptionPane.showMessageDialog(null, e.getErrorCode()+": "+e.getMessage());
			e.printStackTrace();
			
		}
		
	}
	
	public DefaultTableModel mostrarRegistrosRes (String query) {
		
		String[] cabecera = {"Matricula", "Nombre", "A. Paterno", "A. Materno", "CURP", "Edad", "Profesión", "NumExt", "NumInt", "Calle", "Colonia", "Ciudad", "Sexo", "E. Civil", "Discapacidad", "Clase", "NumTel", "Tipo A."};
		
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
					modelo.addRow(datos);
					
				} while(rs.next());
				
			}else
				for(int i=0; i<datos.length; i++) datos[i]="";

		} catch (SQLException e) {

			JOptionPane.showMessageDialog(null, e.getErrorCode()+": "+e.getMessage());
			e.printStackTrace();

		}
		
		return modelo;
		
	}

}
