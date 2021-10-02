package Consultas;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import Conexion.ConexionBD;

public class Encuadrado_Querys 
{
	ConexionBD conexion = new ConexionBD();
	Connection cn = null;
	Statement stm = null;
	ResultSet rs = null;
	PreparedStatement ps = null;
	
	public void ingresar_Enc(String MatriculaEnc, String Nombres_Enc, String ApellidoPat_Enc, String ApellidoMat_Enc, String CURP_Enc, String Edad_Enc, String Profesion_Enc, String Num_Exterior, String Num_Interior, String Nom_Calle, String Colonia, String Ciudad, String Sexo_Enc, String EstadoCivil_Enc, String Discapacidad_Enc, String Clase, String Habilidad, String TipoSangre, String Peso, String Altura) throws IOException
	{
		try 
		{
			//cn = conexion.conectar(1);
			String Q_MatriculaEnc, Q_Nombres_Enc, Q_ApellidoPat_Enc,Q_ApellidoMat_Enc,Q_CURP_Enc,Q_Edad_Enc,Q_Profesion_Enc,Q_Num_Exterior,Q_Num_Interior,Q_Nom_Calle,Q_Colonia,Q_Ciudad,Q_Sexo_Enc,Q_EstadoCivil_Enc,Q_Discapacidad_Enc,Q_Clase,Q_Habilidad,Q_TipoSangre,Q_Peso,Q_Altura;
			
			if(MatriculaEnc.equals("")) 
			{
				MatriculaEnc=null;
				Q_MatriculaEnc=""+MatriculaEnc+", ";
			}
			else Q_MatriculaEnc="'"+MatriculaEnc+"', ";
			//_________________________________________//	
			if(Nombres_Enc.equals(""))
			{
				Nombres_Enc=null;
				Q_Nombres_Enc=""+Nombres_Enc;
			}
			else
			{
				Q_Nombres_Enc="'"+Nombres_Enc+"', ";
			}
			//_________________________________________//	
			if(ApellidoPat_Enc.equals(""))
			{
				ApellidoPat_Enc=null;
				Q_ApellidoPat_Enc=""+ApellidoPat_Enc;
			}
			else
			{
				Q_ApellidoPat_Enc="'"+ApellidoPat_Enc+"', ";
			}
			//_________________________________________//	
			if(ApellidoMat_Enc.equals(""))
			{
				ApellidoMat_Enc=null;
				Q_ApellidoMat_Enc=""+ApellidoMat_Enc;
			}
			else
			{
				Q_ApellidoMat_Enc="'"+ApellidoMat_Enc+"', ";
			}
			//_________________________________________//	
			if(CURP_Enc.equals(""))
			{
				CURP_Enc=null;
				Q_CURP_Enc=""+CURP_Enc;
			}
			else
			{
				Q_CURP_Enc="'"+CURP_Enc+"', ";
			}
			//_________________________________________//	
			if(Edad_Enc.equals(""))
			{
				Edad_Enc=null;
				Q_Edad_Enc=""+Edad_Enc;
			}
			else
			{
				Q_Edad_Enc="'"+Edad_Enc+"', ";
			}
			//_________________________________________//	
			if(Profesion_Enc.equals(""))
			{
				Profesion_Enc=null;
				Q_Profesion_Enc=""+Profesion_Enc;
			}
			else
			{
				Q_Profesion_Enc="'"+Profesion_Enc+"', ";
			}
			//_________________________________________//	
			if(Num_Exterior.equals(""))
			{
				Num_Exterior=null;
				Q_Num_Exterior=""+Num_Exterior;
			}
			else
			{
				Q_Num_Exterior="'"+Num_Exterior+"', ";
			}
			//_________________________________________//	
			if(Num_Interior.equals(""))
			{
				Num_Interior=null;
				Q_Num_Interior=""+Num_Interior;
			}
			else
			{
				Q_Num_Interior="'"+Num_Interior+"', ";
			}
			//_________________________________________//	
			if(Nom_Calle.equals(""))
			{
				Nom_Calle=null;
				Q_Nom_Calle=""+Nom_Calle;
			}
			else
			{
				Q_Nom_Calle="'"+Nom_Calle+"', ";
			}
			//_________________________________________//	
			if(Colonia.equals(""))
			{
				Colonia=null;
				Q_Colonia=""+Colonia;
			}
			else
			{
				Q_Colonia="'"+Colonia+"', ";
			}
			//_________________________________________//	
			if(Ciudad.equals(""))
			{
				Ciudad=null;
				Q_Ciudad=""+Ciudad;
			}
			else
			{
				Q_Ciudad="'"+Ciudad+"', ";
			}
			//_________________________________________//	
			if(Sexo_Enc.equals(""))
			{
				Sexo_Enc=null;
				Q_Sexo_Enc=""+Sexo_Enc;
			}
			else
			{
				Q_Sexo_Enc="'"+Sexo_Enc+"', ";
			}
			//_________________________________________//	
			if(EstadoCivil_Enc.equals(""))
			{
				EstadoCivil_Enc=null;
				Q_EstadoCivil_Enc=""+EstadoCivil_Enc;
			}
			else
			{
				Q_EstadoCivil_Enc="'"+EstadoCivil_Enc+"', ";
			}
			//_________________________________________//	
			if(Discapacidad_Enc.equals(""))
			{
				Discapacidad_Enc=null;
				Q_Discapacidad_Enc=""+Discapacidad_Enc;
			}
			else
			{
				Q_Discapacidad_Enc="'"+Discapacidad_Enc+"', ";
			}
			//_________________________________________//	
			if(Clase.equals(""))
			{
				Clase=null;
				Q_Clase=""+Clase;
			}
			else
			{
				Q_Clase="'"+Clase+"', ";
			}
			//_________________________________________//	
			if(Habilidad.equals(""))
			{
				Habilidad=null;
				Q_Habilidad=""+Habilidad;
			}
			else
			{
				Q_Habilidad="'"+Habilidad+"', ";
			}
			//_________________________________________//	
			if(TipoSangre.equals(""))
			{
				TipoSangre=null;
				Q_TipoSangre=""+TipoSangre;
			}
			else
			{
				Q_TipoSangre="'"+TipoSangre+"', ";
			}
			//_________________________________________//	
			if(Peso.equals(""))
			{
				Peso=null;
				Q_Peso=""+Peso;
			}
			else
			{
				Q_Peso="'"+Peso+"', ";
			}
			//_________________________________________//
			if(Altura.equals(""))
			{
				Altura=null;
				Q_Altura=""+Altura;
			}
			else
			{
				Q_Altura="'"+Altura+"'";
			}
			//_________________________________________//
			String query = "INSERT INTO encuadrado(Matricula_Enc, Nombres_Enc, ApellidoPat_Enc, ApellidoMat_Enc, CURP_Enc, Edad_Enc, Profesión_Enc, Num_Exterior, Num_Interior, Nom_Calle, Colonia, Ciudad, Sexo_Enc, EstadoCivil_Enc, Discapacidad_Enc, Clase, Habilidad, TipoSangre, Peso, Altura) VALUES("+Q_MatriculaEnc+ Q_Nombres_Enc+ Q_ApellidoPat_Enc+Q_ApellidoMat_Enc+Q_CURP_Enc+Q_Edad_Enc+Q_Profesion_Enc+Q_Num_Exterior+Q_Num_Interior+Q_Nom_Calle+Q_Colonia+Q_Ciudad+Q_Sexo_Enc+Q_EstadoCivil_Enc+Q_Discapacidad_Enc+Q_Clase+Q_Habilidad+Q_TipoSangre+Q_Peso+Q_Altura+")";
			stm.executeUpdate(query);
			JOptionPane.showMessageDialog(null, "Encuadrado agregado correctamente");
		}
		catch (SQLException e)
		{
			JOptionPane.showMessageDialog(null, e.getMessage());
			e.printStackTrace();
		}
		/*finally 
		{ //CERRANDO LOS OBJETOS DE CONSULTA
			try 
			{
				if(cn!=null) cn.close();
				if(stm!=null) stm.close();
			} 
			catch (Exception e2) 
			{
				e2.printStackTrace();
			}
		}*/
	}
	
	public void modificar_Enc(String MatriculaEnc, String Nombres_Enc, String ApellidoPat_Enc, String ApellidoMat_Enc, String CURP_Enc, String Edad_Enc, String Profesion_Enc, String Num_Exterior, String Num_Interior, String Nom_Calle, String Colonia, String Ciudad, String Sexo_Enc, String EstadoCivil_Enc, String Discapacidad_Enc, String Clase, String Habilidad, String TipoSangre, String Peso, String Altura) throws IOException 
	{
		try 
		{
			cn = conexion.conectar();
			stm = cn.createStatement();

			String query = "UPDATE encuadrado SET Nombres_Enc = '"+Nombres_Enc+"', ApellidoPat_Enc = '"+ApellidoPat_Enc+"', ApellidoMat_Enc = '"+ApellidoMat_Enc+"', CURP_Enc = '"+CURP_Enc+"', Edad_Enc = '"+Edad_Enc+"', Profesión_Enc = '"+Profesion_Enc+"', Num_Exterior = '"+Num_Exterior+"', Num_Interior = '"+Num_Interior+"', Nom_Calle = '"+Nom_Calle+"', Colonia = '"+Colonia+"', Ciudad = '"+Ciudad+"', Sexo_Enc = '"+Sexo_Enc+"', EstadoCivil_Enc = '"+EstadoCivil_Enc+"', Discapacidad_Enc = '"+Discapacidad_Enc+"', Clase = '"+Clase+"', habilidad = '"+Habilidad+"', TipoSangre = '"+TipoSangre+"', Peso = '"+Peso+"', Altura = '"+Altura+"' WHERE Matricula_Enc = '"+MatriculaEnc+"'";
			stm.executeUpdate(query);
			JOptionPane.showMessageDialog(null, "Encuadrado modificado correctamente");
		}
		catch (SQLException e) 
		{
			JOptionPane.showMessageDialog(null, e.getMessage());
			e.printStackTrace();	
		}
		/*finally 
		{ //CERRANDO LOS OBJETOS DE CONSULTA
			try 
			{
				if(cn!=null) cn.close();
				if(stm!=null) stm.close();
			} 
			catch (Exception e2) 
			{
				e2.printStackTrace();
			}
		}*/
	}
	
	public void eliminar_Enc(String Matricula_Enc) throws IOException 
	{
		try 
		{
			cn = conexion.conectar();
			stm = cn.createStatement();

			String query = "DELETE FROM encuadrado WHERE Matricula_Enc = '"+Matricula_Enc+"'";
			stm.executeUpdate(query);
			JOptionPane.showMessageDialog(null, "Encuadrado eliminado correctamente");
			
		}
		catch (SQLException e) 
		{		
			JOptionPane.showMessageDialog(null, e.getMessage());
			e.printStackTrace();
		}
		/*finally 
		{ //CERRANDO LOS OBJETOS DE CONSULTA
			try 
			{
				if(cn!=null) cn.close();
				if(stm!=null) stm.close();
			} 
			catch (Exception e2) 
			{
				e2.printStackTrace();
			}
		}*/
	}
	
	public DefaultTableModel mostrarRegistrosNumT(String query) 
	{
		String[] cabecera = {"Matricula_Res", "Ed_Sorteo", "Resultado"};
		String[] datos = new String[3];
		
		DefaultTableModel modelo = new DefaultTableModel(null, cabecera);

		try 
		{
			cn = conexion.conectar();
			stm = cn.createStatement();
			rs = stm.executeQuery(query);

			if(rs.next()) 
			{
				 do 
				 {
					datos[0] = rs.getString(1);
					datos[1] = rs.getString(2);	
					datos[2] = rs.getString(3);
					modelo.addRow(datos);
				}
				while(rs.next());
				
			}
			else 
			{
				JOptionPane.showMessageDialog(null, "NO SE ENCONTRO DICHO REGISTRO");
			}

		} 
		catch (SQLException e) 
		{
			JOptionPane.showMessageDialog(null, e.getMessage());
			e.printStackTrace();
		}
		
		return modelo;
		
	}
}
