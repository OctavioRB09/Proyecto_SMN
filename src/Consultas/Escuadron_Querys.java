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

public class Escuadron_Querys 
{
	ConexionBD conexion = new ConexionBD();
	Connection cn = null;
	Statement stm = null;
	ResultSet rs = null;
	PreparedStatement ps = null;
	
	public void ingresar_Esc(String NumEsc, String NumInt) throws IOException
	{
		try 
		{
			//cn = conexion.conectar(1);
			String Q_NumEsc, Q_NumInt;
			if(NumEsc.equals("")) 
			{
				NumEsc=null;
				Q_NumEsc=""+NumEsc+", ";
			}
			else Q_NumEsc="'"+NumEsc+"', ";
				
			if(NumInt.equals(""))
			{
				NumInt=null;
				Q_NumInt=""+NumInt;
			}
			else
			{
				Q_NumInt="'"+NumInt+"'";
			}
			
			String query = "INSERT INTO escuadron(N_Sección, Num_Integrantes) VALUES("+Q_NumEsc+Q_NumInt+")";
			stm.executeUpdate(query);
			JOptionPane.showMessageDialog(null, "Escuadron agregado correctamente");
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
	
	public void modificar_Esc(String NumEsc, String NumInt) throws IOException 
	{
		try 
		{
			cn = conexion.conectar();
			stm = cn.createStatement();

			String query = "UPDATE escuadron SET Num_Integrantes = '"+NumInt+"' WHERE N_Sección = '"+NumEsc+"'";
			stm.executeUpdate(query);
			JOptionPane.showMessageDialog(null, "Escuadron modificado correctamente");
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
	
	public void eliminar_Esc(String NumEsc) throws IOException 
	{
		try 
		{
			cn = conexion.conectar();
			stm = cn.createStatement();

			String query = "DELETE FROM escuadron WHERE N_Sección = '"+NumEsc+"'";
			stm.executeUpdate(query);
			JOptionPane.showMessageDialog(null, "Numero de telefono eliminado correctamente");
			
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
		String[] cabecera = {"N_Sección", "Num_Integrantes"};
		String[] datos = new String[2];
		
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
