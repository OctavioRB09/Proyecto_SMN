package Cod_Retirados;

public class Retirados {

	/* CODIGO PARA REGISTRAR A LOS ASPIRANTES
	 * public void RegistraAspirante(String Nombres, String ApellidoPat, String ApellidoMat, String CURP, String Edad, String Calle, String Num_Exterior, String Num_Interior,	String Colonia, String Ciudad,String Clase,  String EstadoCivil,String Profesion,String Sexo, String Discapacidad) {

		try {

			cn = conexion.conectar();
			stm = cn.createStatement();
			CallableStatement cstmt;			

			cstmt = cn.prepareCall("CALL sorteo(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");

			int edad=0, clase;

			edad = Integer.valueOf(Edad);
			clase = Integer.valueOf(Clase);

			cstmt.setString(1,Nombres);
			cstmt.setString(2,ApellidoPat);
			cstmt.setString(3,ApellidoMat);
			cstmt.setString(4,CURP);
			cstmt.setInt(5,edad);
			cstmt.setString(6,Calle);
			cstmt.setString(7,Num_Exterior);
			cstmt.setString(8,Num_Interior);
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

		} catch (SQLException e) {

			JOptionPane.showMessageDialog(null, e.getMessage());
			e.printStackTrace();

		}

	}
	 */
	
	
	
}
