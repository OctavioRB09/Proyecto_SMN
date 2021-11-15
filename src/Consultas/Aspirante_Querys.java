package Consultas;

import Conexion.*;
import java.sql.*;
import java.util.Random;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Aspirante_Querys {
	
	ConexionBD conexion = new ConexionBD();
	Random r = new Random();
	Connection cn = null;
	Statement stm = null;
	ResultSet rs = null;
	String[] datos=new String[5];

	public DefaultTableModel mostrarRegistrosAsp(String Nombres, String ApellidoPat, String ApellidoMat, String CURP, String Edad, String Calle, String Num_Exterior, String Num_Interior, String Colonia, String Ciudad, String Clase, String EstadoCivil, String Profesion, String Sexo, String Discapacidad) {
		
		String[] cabecera = { "Matricula", "Nombre Aspirante", "Resultado sorteo", "Tipo", "Número Liberación C."};
		String[] datos = new String[5];
		String resultado_sorteo="", tipo_asp="", matricula="", num_lib="", fecha_rec="";

		if (Nombres.equals("")) {
			Nombres = null;
			Nombres = "" + Nombres + ", ";
		} else
			Nombres = "'" + Nombres + "', ";

		if (ApellidoPat.equals("")) {
			ApellidoPat = null;
			ApellidoPat = "" + ApellidoPat + ", ";
		} else
			ApellidoPat = "'" + ApellidoPat + "', ";

		if (ApellidoMat.equals("")) {
			ApellidoMat = null;
			ApellidoMat = "" + ApellidoMat + ", ";
		} else
			ApellidoMat = "'" + ApellidoMat + "', ";

		if (CURP.equals("")) {
			CURP = null;
			CURP = "" + CURP + ", ";
		} else
			CURP = "'" + CURP + "', ";

		if (Edad.equals("")) {
			Edad = null;
			Edad = "" + Edad + ", ";
		} else
			Edad = "'" + Edad + "', ";

		if (Profesion.equals("")) {
			Profesion = null;
			Profesion = "" + Profesion + ", ";
		} else
			Profesion = "'" + Profesion + "', ";

		if (Num_Exterior.equals("")) {
			Num_Exterior = null;
			Num_Exterior = "" + Num_Exterior + ", ";
		} else
			Num_Exterior = "'" + Num_Exterior + "', ";

		if (Num_Interior.equals("")) {
			Num_Interior = null;
			Num_Interior = "" + Num_Interior + ", ";
		} else
			Num_Interior = "'" + Num_Interior + "', ";

		if (Calle.equals("")) {
			Calle = null;
			Calle = "" + Calle + ", ";
		} else
			Calle = "'" + Calle + "', ";

		if (Colonia.equals("")) {
			Colonia = null;
			Colonia = "" + Colonia + ", ";
		} else
			Colonia = "'" + Colonia + "', ";

		if (Ciudad.equals("")) {
			Ciudad = null;
			Ciudad = "" + Ciudad + ", ";
		} else
			Ciudad = "'" + Ciudad + "', ";

		if (Sexo.equals("")) {
			Sexo = null;
			Sexo = "" + Sexo + ", ";
		} else
			Sexo = "'" + Sexo + "', ";

		if (EstadoCivil.equals("")) {
			EstadoCivil = null;
			EstadoCivil = "" + EstadoCivil + ", ";
		} else
			EstadoCivil = "'" + EstadoCivil + "', ";

		if (Discapacidad.equals("")) {
			Discapacidad = null;
			Discapacidad = "" + Discapacidad + ", ";
		} else
			Discapacidad = "'" + Discapacidad + "', ";

		if (Clase.equals("")) {
			Clase = null;
			Clase = "" + Clase + ", ";
		} else
			Clase = "'" + Clase + "', ";

		DefaultTableModel modelo = new DefaultTableModel(null, cabecera);

		try {

			cn = conexion.conectar();
			cn.setAutoCommit(false); //--> DESACTIVAMOS EL AUTOCOMMIT PARA EMULAR EL "START TRANSACTION"
			stm = cn.createStatement();
			CallableStatement cstmt;			
			cstmt = cn.prepareCall("");
			
			//LLAMAR LA FUNCION SORTEO
			cstmt = cn.prepareCall("CALL sorteoF(?)");
			cstmt.registerOutParameter(1, java.sql.Types.VARCHAR);
			cstmt.execute();
			resultado_sorteo = cstmt.getString(1);
			
			//GENERAMOS LOS NUMEROS DE MATRICULA Y DE LIBERACION
			matricula = "'D-"+(r.nextInt(9999999)+1000000)+ "', ";
			num_lib = String.valueOf("'"+(Math.random()*1700000+1530000)+"', ");
			
			//INICIA IF QUE DEFINE DONDE SE GUARDAN LOS DATOS
			if (resultado_sorteo.equals("Negra")) { //SE INICIA LA TRANSACCION PARA EL RESERVA
				
				tipo_asp="Reserva";
				stm.executeUpdate("INSERT INTO reserva(Matricula_Res, Nombres_Res, ApellidoPat_Res, ApellidoMat_Res, CURP_Res, Edad_Res, Profesión_Res, Num_Exterior, Num_Interior, Nom_Calle, Colonia, Ciudad, Sexo_Res, EstadoCivil_Res, Discapacidad_Res, Clase, Tipo_Aspirante) VALUES("+ matricula + Nombres + ApellidoPat + ApellidoMat + CURP + Edad + Profesion + Num_Exterior + Num_Interior + Calle + Colonia + Ciudad + Sexo + EstadoCivil + Discapacidad + Clase + tipo_asp+");");
				stm.executeUpdate("INSERT INTO cartilla(Num_liberación, Zona_Mil, Regimiento) VALUES("+ num_lib +" 17, 7);");
				stm.executeUpdate("INSERT INTO participa_res(Matricula_Res, Ed_Sorteo, Resultado) VALUES("+ matricula +" YEAR(NOW()), '"+ resultado_sorteo +"');");
				
				cstmt = cn.prepareCall("CALL fechaF(?)");
				cstmt.registerOutParameter(1, java.sql.Types.VARCHAR);
				cstmt.execute();
				fecha_rec = cstmt.getString(1);
				
				stm.executeUpdate("INSERT INTO obtiene(Matricula_Res, Num_Liberacion, Precio_Cart, Fecha_Recepcion) VALUES("+matricula + num_lib+" 75, STR_TO_DATE("+fecha_rec+", '%Y-%m-%d'));");
				
			}else { //SE INICIA LA TRANSACCION PARA EL ENCUADRADO
				
				
				
			}
			
			//SE DEFINE SI SE HACE UN COMMIT O UN ROLLBACK
			
			
			cstmt.executeUpdate();
			
			

		} catch (SQLException e) {

			JOptionPane.showMessageDialog(null, e.getErrorCode()+": "+e.getMessage());
			e.printStackTrace();

		}

		return modelo;
		
	}
	
	/*
	String[] cabecera = { "Matricula", "Nombre Aspirante", "Resultado sorteo", "Tipo", "Número Liberación C."};
	String[] datos = new String[5];
	int edad=0, clase=0;

	DefaultTableModel modelo = new DefaultTableModel(null, cabecera);

	try {

		cn = conexion.conectar();
		stm = cn.createStatement();
		CallableStatement cstmt;			
		cstmt = cn.prepareCall("CALL sorteo_transaccion(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
		
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
		if(String.valueOf(cstmt.getString(17)).equals("null")) datos[1]=" ";
		else datos[1] = cstmt.getString(17)+" "+cstmt.getString(18)+" "+cstmt.getString(19);
		datos[2] = cstmt.getString(20);
		datos[3] = cstmt.getString(21);
		datos[4] = cstmt.getString(22);
		modelo.addRow(datos);

	} catch (SQLException e) {

		JOptionPane.showMessageDialog(null, e.getMessage());
		e.printStackTrace();

	}

	return modelo;
	 */

}
