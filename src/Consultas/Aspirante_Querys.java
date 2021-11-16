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
		String resultado_sorteo="", tipo_asp="", matricula="", num_lib="", fecha_rec="", Placa="", Inst="", Seccion="", Act="", PlacaS="", Q_Nombre="", Q_ApellidoP="", Q_ApellidoM="";
		int flag = 0;

		if (Nombres.equals("")) {
			Nombres = null;
			Q_Nombre = "" + Nombres + ", ";
		} else
			Q_Nombre = "'" + Nombres + "', ";

		if (ApellidoPat.equals("")) {
			ApellidoPat = null;
			Q_ApellidoP = "" + ApellidoPat + ", ";
		} else
			Q_ApellidoP = "'" + ApellidoPat + "', ";

		if (ApellidoMat.equals("")) {
			ApellidoMat = null;
			Q_ApellidoM = "" + ApellidoMat + ", ";
		} else
			Q_ApellidoM = "'" + ApellidoMat + "', ";

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
			stm = cn.createStatement();
			CallableStatement cstmt;
			cn.setAutoCommit(false); //--> DESACTIVAMOS EL AUTOCOMMIT PARA EMULAR EL "START TRANSACTION"
			
			//LLAMAR LA FUNCION SORTEO
			cstmt = cn.prepareCall("{? = CALL sorteoF(?)}");
			cstmt.setString(2, "4"); //--> ENVIA LA PROBABILIDAD PARA QUE SEA RESERVA (4 DE 10)
			cstmt.registerOutParameter(1, Types.CHAR); //--> SE RECIBE EL PARAMETRO DE SALIDA
			cstmt.execute();
			resultado_sorteo = cstmt.getString(1); //--> SE GUARDA EL VALOR DE SALIDA DE LA FUNCION DE SORTEO
			
			//GENERAMOS EL NUMERO DE LIBERACION Y SE GUARDA EN LA TABLA DE CARTILLA
			num_lib = String.valueOf((int) Math.floor(Math.random()*1700000+1530000));
			stm.executeUpdate("INSERT INTO cartilla(Num_liberación, Zona_Mil, Regimiento) VALUES('"+ num_lib +"', 17, 7);");
			
			if (resultado_sorteo.equals("Negra")) { //SE INICIA LA TRANSACCION PARA EL RESERVA
			
				matricula = "D"+(r.nextInt(9999999)+1000000); //-->SE GENERA EL NUMERO DE MATRICULA CON EL ESTANDAR "D" PARA LOS RESERVA
				tipo_asp="Reserva";
				
				stm.executeUpdate("INSERT INTO reserva(Matricula_Res, Nombres_Res, ApellidoPat_Res, ApellidoMat_Res, CURP_Res, Edad_Res, Profesión_Res, Num_Exterior, Num_Interior, Nom_Calle, Colonia, Ciudad, Sexo_Res, EstadoCivil_Res, Discapacidad_Res, Clase, Tipo_Aspirante) VALUES('"+ matricula + "', " + Q_Nombre + Q_ApellidoP + Q_ApellidoM + CURP + Edad + Profesion + Num_Exterior + Num_Interior + Calle + Colonia + Ciudad + Sexo + EstadoCivil + Discapacidad + Clase + "'" + tipo_asp+"');");
				stm.executeUpdate("INSERT INTO participa_res(Matricula_Res, Ed_Sorteo, Resultado) VALUES('"+ matricula +"', YEAR(NOW()), '"+ resultado_sorteo +"');");
				
				cstmt = cn.prepareCall("{? = CALL fechaF() }"); //--> LLAMADA A LA FUNCION DE FECHA PARA ASIGNAR UNA A LA RECOGIDA DE CARTILLA DEL RESERVA
				cstmt.registerOutParameter(1, Types.VARCHAR);
				cstmt.execute();
				fecha_rec = cstmt.getString(1);
				
				stm.executeUpdate("INSERT INTO obtiene(Matricula_Res, Num_Liberacion, Precio_Cart, Fecha_Recepcion) VALUES('"+matricula +"', '"+ num_lib+"', 75, STR_TO_DATE('"+fecha_rec+"', '%Y-%m-%d'));");
				
				flag++;
				
			}else if(resultado_sorteo.equals("Blanca")) { //--> SE INICIA LA TRANSACCION PARA EL ENCUADRADO
				
				matricula = "D-"+(r.nextInt(999999)+100000); //-->SE GENERA EL NUMERO DE MATRICULA CON EL ESTANDAR "D-" PARA LOS ENCUADRADOS
				tipo_asp="Encuadrado";
				
				stm.executeUpdate("INSERT INTO encuadrado(Matricula_Enc, Nombres_Enc, ApellidoPat_Enc, ApellidoMat_Enc, CURP_Enc, Edad_Enc, Profesión_Enc, Num_Exterior, Num_Interior, Nom_Calle, Colonia, Ciudad, Sexo_Enc, EstadoCivil_Enc, Discapacidad_Enc, Clase, Tipo_Aspirante) VALUES('"+ matricula +"', "+ Q_Nombre + Q_ApellidoP + Q_ApellidoM + CURP + Edad + Profesion + Num_Exterior + Num_Interior + Calle + Colonia + Ciudad + Sexo + EstadoCivil + Discapacidad + Clase + "'" + tipo_asp+"');");
				stm.executeUpdate("INSERT INTO participa_enc(Matricula_Enc, Ed_Sorteo, Resultado) VALUES('"+ matricula +"', YEAR(NOW()), '"+ resultado_sorteo +"');");
								
				//ASIGNACIÓN DE UNA ACTIVIDAD
				rs = stm.executeQuery("SELECT Num_Placa FROM instructor ORDER BY RAND() LIMIT 1");
				rs.next();
				Placa = rs.getString(1);
				rs = stm.executeQuery("SELECT Id_Inst FROM institucion ORDER BY RAND() LIMIT 1");
				rs.next();
				Inst = rs.getString(1);
				rs = stm.executeQuery("SELECT N_Sección FROM escuadron ORDER BY RAND() LIMIT 1");
				rs.next();
				Seccion = rs.getString(1);
				rs = stm.executeQuery("SELECT T_Actividad FROM actividad ORDER BY RAND() LIMIT 1");
				rs.next();
				Act = rs.getString(1);
				
				stm.executeUpdate("INSERT INTO actividad(Num_Placa, Matricula_Enc, N_Sección, Id_Inst, HoraInicio, HoraFin, Fecha, T_Actividad, Coste_Act) VALUES('"+Placa+"', '"+ matricula+"', " + Seccion +", '"+ Inst + "', (NOW()+INTERVAL 1 hour), (NOW()+INTERVAL 2 hour), (CURDATE()+INTERVAL 7 DAY), '"+Act+"', ROUND(RAND()*100));");
				
				//ASIGNACION DE UN VALIDADOR DE CARTILLA
				rs = stm.executeQuery("SELECT Num_Placa FROM instructor WHERE Rango = 'Sargento' ORDER BY RAND() LIMIT 1");
				rs.next();
				PlacaS = rs.getString(1);
				
				stm.executeUpdate("INSERT INTO valida(Num_Placa, Matricula_Enc, Num_liberacion, Horas_Trabajadas, Precio_Car) VALUES('"+PlacaS+"', '"+ matricula+"', '"+num_lib+"', 0, 0);");
				
				flag++;
				
			}
			
			//MENSAJE DE CONFIRMACIÓN (PARA EL COMMIT Y EL ROLLBACK)
			if (flag == 1) {
				cn.commit();
				//SE MUESTRAN LOS DATOS EN LA TABLA SI TRANSCURRIO CON EXITO LA TRANSACCIÓN
				datos[0] = matricula;
				datos[1] = Nombres+" "+ApellidoPat+" "+ApellidoMat;
				datos[2] = resultado_sorteo;
				datos[3] = tipo_asp;
				datos[4] = num_lib;
				modelo.addRow(datos);	
			}
			
			/*Object[] options = {"Continuar (Commit)", "Cancelar (Rollback)"};
			int n = JOptionPane.showOptionDialog(null,
			                "¿Estas seguro de que quieres ir a vietnam?",
			                "Confirmación de Registro",
			                JOptionPane.YES_NO_OPTION,
			                JOptionPane.QUESTION_MESSAGE,
			                null,
			                options,
			                options[0]);
			if (n == JOptionPane.YES_OPTION) {
				if (flag == 1) {
					cn.commit();
					//SE MUESTRAN LOS DATOS EN LA TABLA SI TRANSCURRIO CON EXITO LA TRANSACCIÓN
					datos[0] = matricula;
					datos[1] = Nombres+" "+ApellidoPat+" "+ApellidoMat;
					datos[2] = resultado_sorteo;
					datos[3] = tipo_asp;
					datos[4] = num_lib;
					modelo.addRow(datos);	
				}
			} else if (n == JOptionPane.NO_OPTION) {
				cn.rollback();
			}*/
			
		} catch (SQLException e) {

			JOptionPane.showMessageDialog(null, e.getErrorCode()+": "+e.getMessage());
			e.printStackTrace();
			
			if(cn!=null) {
				try {
					cn.rollback();
				}catch(SQLException ex) {
					System.out.println(ex.toString());
				}
			}

		}

		return modelo;
		
	}
	
}