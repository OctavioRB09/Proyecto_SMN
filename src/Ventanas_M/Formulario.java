package Ventanas_M;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import Conexion.*;
import Consultas.*;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class Formulario extends JFrame {

	private static final long serialVersionUID = 1L;

	private JPanel contentPane;

	Instructor_Querys objIns = new Instructor_Querys();
	Instituto_Querys objInst = new Instituto_Querys();
	Actividad_Querys objAct = new Actividad_Querys();
	NumTel_Institucion_Querys objNumT = new NumTel_Institucion_Querys();
	Escuadron_Querys objEsc = new Escuadron_Querys();
	Participa_res_Querys objParR = new Participa_res_Querys();
	Obtiene_Querys objObt=new Obtiene_Querys();
	Valida_Querys objVal=new Valida_Querys();
	Sorteo_Querys objsor=new Sorteo_Querys();
	Cartilla_Querys objCar=new Cartilla_Querys();
	Encuadrado_Querys objEnc=new Encuadrado_Querys();
	Lidera_Querys objTC=new Lidera_Querys();
	Reserva_Querys objRQ=new Reserva_Querys();
	Participa_enc_Querys objPEQ=new Participa_enc_Querys();
	static Loggin objLog = new Loggin();
	
	ConexionBD conexion = new ConexionBD();
	PreparedStatement ps = null;
	ResultSet rs = null;
	Connection cn = null;
	Statement stm = null; 

	private JTextField etNumPlaca;
	private JTextField etNombreIns;
	private JTextField etApellidoPatIns;
	private JTextField etApellidoMatIns;
	private JTextField etSueldo;
	private JTextField etRango;
	private JTextField etIdInstitucion;
	private JTextField etNombreInstitucion;
	private JTextField etColoniaInstitucion;
	private JTextField etNumExtInstitucion;
	private JTextField etNumInteriorInstitucion;
	private JTextField etNombreCalleInstitucion;
	private JTextField etMunicipioInstitucion;
	private JTextField etNumPlacaIns;
	private JTextField etMatricula;
	private JTextField etNumSec;
	private JTextField etIdInst;
	private JTextField etHoraInicio;
	private JTextField etHoraFin;
	private JTextField etFecha;
	private JTextField etActividad;
	private JTextField etCosteAct;
	private JTextField etIdInstitucion1;
	private JTextField etNumTelInst;
	private JTextField etNumTelNuevo;
	private JTextField etNumeroSeccion;
	private JTextField etNumIntegrantes;
	private JTextField etMatriculaPRes;
	private JTextField etEdSorteoP;
	private JTextField etResultadoP;
	private JTextField etMatReserva;
	private JTextField etNumLiberacion;
	private JTextField etPrecioCart;
	private JTextField etMesRecepcion;
	private JTextField etsorteo;
	private JTextField etfechas;
	private JTextField etNumplaca;
	private JTextField etMatenc;
	private JTextField etNumlib;
	private JTextField etHoras;
	private JTextField etPreciocart;
	private JTextField etNum_LiberacionCartilla;
	private JTextField etZona_Militar;
	private JTextField etRegimiento;
	private JTextField txtNombreEnc;
	private JTextField txtApellidoPaternoEnc;
	private JTextField txtApellidoMaternoEnc;
	private JTextField txtCurpEnc;
	private JTextField txtProfesionEnc;
	private JTextField txtCalleEnc;
	private JTextField txtColoniaEnc;
	private JTextField txtNumInteriorEnc;
	private JTextField txtNumExtEnc;
	private JTextField txtCiudadEnc;
	private JTextField txtDiscapacidad;
	private JTextField txtClaseEnc;
	private JTextField txtHabilidadEnc;
	private JTextField txtPesoEnc;
	private JTextField txtAlturaEnc;
	private JTextField txtSexoEnc;
	private JTextField txtEdadEnc;
	private JTextField txtMatriculaEnc;
	private JTextField txtEstadoCivil;
	private JTextField txtTipoSangreEnc;
	private JTextField etMatriculaRes;
	private JTextField etNombreRes;
	private JTextField etAPaternoRes;
	private JTextField etAMaternoRes;
	private JTextField etCurpRes;
	private JTextField etEdadRes;
	private JTextField etProfesionRes;
	private JTextField etCiudadRes;
	private JTextField etColoniaRes;
	private JTextField etCalleRes;
	private JTextField etNumIntRes;
	private JTextField etNumExtRes;
	private JTextField etSexoRes;
	private JTextField etECivilRes;
	private JTextField etDiscapacidadRes;
	private JTextField etClaseRes;
	private JTextField etTelefonoRes;
	private JTextField etSargento;
	private JTextField etCabo;
	private JTextField etMatriculaEncPart;
	private JTextField etEdSorteoPartEnc;
	private JTextField etResPartEnc;
	private JTable tablaPartEnc;
	private JTable tablaSorteo;
	private JTable tablaReserva;
	private JTable tablaLidera;
	private JTable tablaCartilla;
	private JTable tablaEncuadrado;
	private JTable tablaValida;
	private JTable tablaActividad;
	private JTable tablaNumTel;
	private JTable tablaEscuadron;
	private JTable tablaPRes;
	private JTable tablaObtiene;
	private JTable tablaInstructor;
	private JTable tablaInstitucion;
	private JTable tablaAspirante;

	static Formulario window = null;
	private JTextField TxtNombreAspirante;
	private JTextField txtApellidoPatAspirante;
	private JTextField txtApellidoMatAspirante;
	private JTextField txtCurpAspirante;
	private JTextField txtEdadAspirante;
	private JTextField txtCalleAspirante;
	private JTextField txtNumExteriorAspirante;
	private JTextField txtNumInteriorAspirante;
	private JTextField txtColoniaAspirante;
	private JTextField txtCiudadAspirante;
	private JTextField txtClaseAspirante;
	private JTextField txtEstadoCivilAspirante;
	private JTextField txtProfesionAspirante;
	private JTextField txtSexoAspirante;
	private JTextField textField;
	private JTable tablaAspirantes;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					 window = new Formulario(objLog.cn);
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void cerrar() {
		this.dispose();
	}

	public void limpiarEntradas() {
		
		etNumPlaca.setText("");
		etNombreIns.setText("");
		etApellidoPatIns.setText("");
		etApellidoMatIns.setText("");
		etSueldo.setText("");
		etRango.setText("");
		etIdInstitucion.setText("");
		etNombreInstitucion.setText("");
		etColoniaInstitucion.setText("");
		etNumExtInstitucion.setText("");
		etNumInteriorInstitucion.setText("");
		etNombreCalleInstitucion.setText("");
		etMunicipioInstitucion.setText("");
		etNumPlacaIns.setText("");
		etMatricula.setText("");
		etNumSec.setText("");
		etIdInst.setText("");
		etHoraInicio.setText("");
		etHoraFin.setText("");
		etFecha.setText("");
		etActividad.setText("");
		etCosteAct.setText("");
		etIdInstitucion1.setText("");
		etNumTelInst.setText("");
		etNumTelNuevo.setText("");
		etNumeroSeccion.setText("");
		etNumIntegrantes.setText("");
		etMatriculaPRes.setText("");
		etEdSorteoP.setText("");
		etResultadoP.setText("");
		etMatReserva.setText("");
		etNumLiberacion.setText("");
		etPrecioCart.setText("");
		etMesRecepcion.setText("");
		etsorteo.setText("");
		etfechas.setText("");
		etNumplaca.setText("");
		etMatenc.setText("");
		etNumlib.setText("");
		etHoras.setText("");
		etPreciocart.setText("");
		etNum_LiberacionCartilla.setText("");
		etZona_Militar.setText("");
		etRegimiento.setText("");
		txtDiscapacidad.setText("");
		txtNombreEnc.setText("");
		txtApellidoPaternoEnc.setText("");
		txtApellidoMaternoEnc.setText("");
		txtCurpEnc.setText("");
		txtProfesionEnc.setText("");
		txtCalleEnc.setText("");
		txtColoniaEnc.setText("");
		txtNumInteriorEnc.setText("");
		txtNumExtEnc.setText("");
		txtCiudadEnc.setText("");
		txtDiscapacidad.setText("");
		txtClaseEnc.setText("");
		txtHabilidadEnc.setText("");
		txtPesoEnc.setText("");
		txtAlturaEnc.setText("");
		txtSexoEnc.setText("");
		txtEdadEnc.setText("");
		txtMatriculaEnc.setText("");
		txtEstadoCivil.setText("");
		txtTipoSangreEnc.setText("");
		etMatriculaRes.setText("");
		etNombreRes.setText("");
		etAPaternoRes.setText("");
		etAMaternoRes.setText("");
		etCurpRes.setText("");
		etEdadRes.setText("");
		etProfesionRes.setText("");
		etCiudadRes.setText("");
		etColoniaRes.setText("");
		etCalleRes.setText("");
		etNumIntRes.setText("");
		etNumExtRes.setText("");
		etSexoRes.setText("");
		etECivilRes.setText("");
		etDiscapacidadRes.setText("");
		etClaseRes.setText("");
		etTelefonoRes.setText("");
		etMatriculaEncPart.setText("");
		etEdSorteoPartEnc.setText("");
		etResPartEnc.setText("");
		etSargento.setText("");
		etCabo.setText("");
		etNumTelNuevo.setText("");
		
	}

	@SuppressWarnings("static-access")
	public Formulario(Connection cn) {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 908, 581);
		setLocationRelativeTo(null);
		setResizable(false);
		setTitle(conexion.user);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.LEFT);
		tabbedPane.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
		tabbedPane.setBounds(5, 5, 882, 488);
		getContentPane().add(tabbedPane);
		
		//-->> BOTON PARA CERRAR SESION
		JButton btnCerrarSesion = new JButton("CERRAR SESION");
		btnCerrarSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					cn.close();
				} catch (SQLException j) {
					j.printStackTrace();
				}

				Loggin log = new Loggin();
				log.setVisible(true);
				cerrar();

			}
		});
		btnCerrarSesion.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		btnCerrarSesion.setBounds(382, 504, 149, 23);
		contentPane.add(btnCerrarSesion);

//-->> INICIO DEL PANEL DE INSTRUCTOR		
		JPanel Instructor = new JPanel();
		Instructor.setBackground(SystemColor.menu);
		Instructor.setToolTipText("");
		Instructor.setLayout(null);
		tabbedPane.addTab("Instructor", null, Instructor, null);

		JTextPane txtpnMatricula = new JTextPane();
		txtpnMatricula.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		txtpnMatricula.setText("NUMERO DE PLACA");
		txtpnMatricula.setForeground(Color.BLACK);
		txtpnMatricula.setEditable(false);
		txtpnMatricula.setBackground(SystemColor.menu);
		txtpnMatricula.setBounds(106, 28, 118, 20);
		Instructor.add(txtpnMatricula);

		JTextPane txtpnNombre = new JTextPane();
		txtpnNombre.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		txtpnNombre.setText("NOMBRE INSTRUCTOR");
		txtpnNombre.setEditable(false);
		txtpnNombre.setBackground(SystemColor.menu);
		txtpnNombre.setBounds(306, 28, 139, 20);
		Instructor.add(txtpnNombre);

		JTextPane txtpnNombre_1 = new JTextPane();
		txtpnNombre_1.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		txtpnNombre_1.setText("APELLIDO PATERNO");
		txtpnNombre_1.setEditable(false);
		txtpnNombre_1.setBackground(SystemColor.menu);
		txtpnNombre_1.setBounds(524, 28, 122, 20);
		Instructor.add(txtpnNombre_1);

		JTextPane txtpnNombre_2 = new JTextPane();
		txtpnNombre_2.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		txtpnNombre_2.setText("APELLIDO MATERNO");
		txtpnNombre_2.setEditable(false);
		txtpnNombre_2.setBackground(SystemColor.menu);
		txtpnNombre_2.setBounds(106, 104, 127, 20);
		Instructor.add(txtpnNombre_2);

		JTextPane txtpnNombre_3 = new JTextPane();
		txtpnNombre_3.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		txtpnNombre_3.setText("RANGO");
		txtpnNombre_3.setEditable(false);
		txtpnNombre_3.setBackground(SystemColor.menu);
		txtpnNombre_3.setBounds(350, 104, 47, 20);
		Instructor.add(txtpnNombre_3);
		
		JTextPane txtpnNombre_3_1 = new JTextPane();
		txtpnNombre_3_1.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		txtpnNombre_3_1.setText("SUELDO");
		txtpnNombre_3_1.setEditable(false);
		txtpnNombre_3_1.setBackground(SystemColor.menu);
		txtpnNombre_3_1.setBounds(557, 104, 53, 20);
		Instructor.add(txtpnNombre_3_1);

		etNumPlaca = new JTextField();
		etNumPlaca.setColumns(10);
		etNumPlaca.setBounds(123, 59, 86, 20);
		Instructor.add(etNumPlaca);
		
		etNombreIns = new JTextField();
		etNombreIns.setColumns(10);
		etNombreIns.setBounds(332, 59, 86, 20);
		Instructor.add(etNombreIns);
		
		etApellidoPatIns = new JTextField();
		etApellidoPatIns.setColumns(10);
		etApellidoPatIns.setBounds(541, 59, 86, 20);
		Instructor.add(etApellidoPatIns);

		etApellidoMatIns = new JTextField();
		etApellidoMatIns.setColumns(10);
		etApellidoMatIns.setBounds(123, 135, 86, 20);
		Instructor.add(etApellidoMatIns);

		etRango = new JTextField();
		etRango.setBounds(332, 135, 86, 20);
		Instructor.add(etRango);
		etRango.setColumns(10);
		
		etSueldo = new JTextField();
		etSueldo.setColumns(10);
		etSueldo.setBounds(541, 131, 86, 20);
		Instructor.add(etSueldo);

		//-->> INICIO DE LOS BOTONES
		JButton btnAgregarIns = new JButton("AGREGAR");
		btnAgregarIns.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		btnAgregarIns.addActionListener((ActionListener) new ActionListener() {
			public void actionPerformed(ActionEvent Arg0) {

				objIns.ingresar_instructor(etNumPlaca.getText(), etNombreIns.getText(), etApellidoPatIns.getText(), etApellidoMatIns.getText(), etRango.getText(), etSueldo.getText());
				limpiarEntradas();

				DefaultTableModel modelo = objIns.mostrarRegistrosIns("SELECT * FROM instructor");
				tablaInstructor.setModel(modelo);
				
			}
		});
		btnAgregarIns.setBounds(32, 235, 111, 23);
		Instructor.add(btnAgregarIns);

		JButton btnModificarIns = new JButton("MODIFICAR");
		btnModificarIns.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		btnModificarIns.addActionListener((ActionListener) new ActionListener() {
			public void actionPerformed(ActionEvent Arg0) {

				objIns.modificar_instructor(etNumPlaca.getText(), etNombreIns.getText(), etApellidoPatIns.getText(), etApellidoMatIns.getText(), etRango.getText(), etSueldo.getText());
				limpiarEntradas();

				DefaultTableModel modelo = objIns.mostrarRegistrosIns("SELECT * FROM instructor");
				tablaInstructor.setModel(modelo);
				
			}
		});
		btnModificarIns.setBounds(318, 235, 111, 23);
		Instructor.add(btnModificarIns);

		JButton btnEliminarIns = new JButton("ELIMINAR");
		btnEliminarIns.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		btnEliminarIns.addActionListener((ActionListener) new ActionListener() {
			public void actionPerformed(ActionEvent Arg0) {

				objIns.eliminar_instructor(etNumPlaca.getText());
				limpiarEntradas();

				DefaultTableModel modelo = objIns.mostrarRegistrosIns("SELECT * FROM instructor");
				tablaInstructor.setModel(modelo);
				
			}
		});
		btnEliminarIns.setBounds(175, 235, 111, 23);
		Instructor.add(btnEliminarIns);

		JButton btnBuscarIns = new JButton("CONSULTAR");
		btnBuscarIns.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		btnBuscarIns.addActionListener((ActionListener) new ActionListener() {
			public void actionPerformed(ActionEvent Arg0) {
				
				String query="";
				
				if ((etNumPlaca.getText()).equals(""))
					query = "SELECT * FROM instructor";
				else
					query = "SELECT * FROM instructor WHERE Num_Placa = '" + etNumPlaca.getText() + "'";
				
				DefaultTableModel modelo = objIns.mostrarRegistrosIns(query);
				tablaInstructor.setModel(modelo);
				
			}
		});
		btnBuscarIns.setBounds(461, 235, 111, 23);
		Instructor.add(btnBuscarIns);
		
		JButton btnLimpiarIns = new JButton("LIMPIAR");
		btnLimpiarIns.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		btnLimpiarIns.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				DefaultTableModel modelo = objIns.mostrarRegistrosIns("SELECT * FROM instructor");
				tablaInstructor.setModel(modelo);
				
				limpiarEntradas();
				
			}
		});
		btnLimpiarIns.setBounds(604, 235, 111, 23);
		Instructor.add(btnLimpiarIns);

		//-->> INICIO DEL PANEL DE LA TABLA
		JPanel pnlTablaInstructor = new JPanel();
		pnlTablaInstructor.setBounds(22, 275, 704, 200);
		Instructor.add(pnlTablaInstructor);
		pnlTablaInstructor.setLayout(null);

			JScrollPane spTablaInstructor = new JScrollPane();
			spTablaInstructor.setBounds(0, 0, 704, 200);
			pnlTablaInstructor.add(spTablaInstructor);
	
			tablaInstructor = new JTable();
			spTablaInstructor.setViewportView(tablaInstructor);
		
//-->> INICIO DEL PANEL DEL NUMERO DEL TELEFONO DE INSTITUCION
		JPanel NumTel = new JPanel();
		tabbedPane.addTab("NumTel_Institucion", null, NumTel, null);
		NumTel.setLayout(null);

		JTextPane txtpnIdinstitucin = new JTextPane();
		txtpnIdinstitucin.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		txtpnIdinstitucin.setBackground(SystemColor.menu);
		txtpnIdinstitucin.setText("ID INSTITUCI\u00D3N");
		txtpnIdinstitucin.setEditable(false);
		txtpnIdinstitucin.setBounds(101, 70, 110, 20);
		NumTel.add(txtpnIdinstitucin);

		JTextPane txtpnN = new JTextPane();
		txtpnN.setText("NUMERO TELEFONO");
		txtpnN.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		txtpnN.setEditable(false);
		txtpnN.setBackground(SystemColor.menu);
		txtpnN.setBounds(312, 70, 125, 20);
		NumTel.add(txtpnN);

		JTextPane txtpnNumtelefonomod = new JTextPane();
		txtpnNumtelefonomod.setText("NUMTELEFONO (MOD)");
		txtpnNumtelefonomod.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		txtpnNumtelefonomod.setEditable(false);
		txtpnNumtelefonomod.setBackground(SystemColor.menu);
		txtpnNumtelefonomod.setBounds(523, 70, 138, 20);
		NumTel.add(txtpnNumtelefonomod);

		etIdInstitucion1 = new JTextField();
		etIdInstitucion1.setBounds(95, 101, 123, 20);
		NumTel.add(etIdInstitucion1);
		etIdInstitucion1.setColumns(10);

		etNumTelInst = new JTextField();
		etNumTelInst.setColumns(10);
		etNumTelInst.setBounds(313, 101, 123, 20);
		NumTel.add(etNumTelInst);

		etNumTelNuevo = new JTextField();
		etNumTelNuevo.setColumns(10);
		etNumTelNuevo.setBounds(531, 101, 123, 20);
		NumTel.add(etNumTelNuevo);

		//-->> INICIO DE LOS BOTONES
		JButton btnAgregarNumTel = new JButton("AGREGAR");
		btnAgregarNumTel.addActionListener((ActionListener) new ActionListener() {
			public void actionPerformed(ActionEvent Arg0) {

				objNumT.ingresar_NumTel(etIdInstitucion1.getText(), etNumTelInst.getText());

				DefaultTableModel modeloNumT = objNumT.mostrarRegistrosNumT("SELECT * FROM NumTel_Institucion");
				tablaNumTel.setModel(modeloNumT);

			}
		});
		btnAgregarNumTel.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		btnAgregarNumTel.setBounds(30, 193, 114, 23);
		NumTel.add(btnAgregarNumTel);

		JButton btnEliminarNumTel = new JButton("ELIMINAR");
		btnEliminarNumTel.addActionListener((ActionListener) new ActionListener() {
			public void actionPerformed(ActionEvent Arg0) {

				objNumT.eliminar_NumTel(etNumTelInst.getText());

				DefaultTableModel modeloNumT = objNumT.mostrarRegistrosNumT("SELECT * FROM NumTel_Institucion");
				tablaNumTel.setModel(modeloNumT);

			}
		});
		btnEliminarNumTel.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		btnEliminarNumTel.setBounds(174, 193, 114, 23);
		NumTel.add(btnEliminarNumTel);

		JButton btnModificarNumTel = new JButton("MODIFICAR");
		btnModificarNumTel.addActionListener((ActionListener) new ActionListener() {
			public void actionPerformed(ActionEvent Arg0) {

				objNumT.modificar_NumTel(etIdInstitucion1.getText(), etNumTelInst.getText(), etNumTelNuevo.getText());

				DefaultTableModel modeloNumT = objNumT.mostrarRegistrosNumT("SELECT * FROM NumTel_Institucion");
				tablaNumTel.setModel(modeloNumT);

			}
		});
		btnModificarNumTel.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		btnModificarNumTel.setBounds(318, 193, 114, 23);
		NumTel.add(btnModificarNumTel);

		JButton btnConsultarNumTel = new JButton("CONSULTAR");
		btnConsultarNumTel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String query="";

				if ((etIdInstitucion1.getText()).equals(""))
					query = "SELECT * FROM NumTel_Institucion";
				else
					query = "SELECT * FROM NumTel_Institucion WHERE Id_Inst = '"+etIdInstitucion1.getText()+"'";
				
				DefaultTableModel modeloNumT = objNumT.mostrarRegistrosNumT(query);
				tablaNumTel.setModel(modeloNumT);

			}
		});
		btnConsultarNumTel.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		btnConsultarNumTel.setBounds(462, 193, 114, 23);
		NumTel.add(btnConsultarNumTel);

		JButton btnLimpiarNumTel = new JButton("LIMPIAR");
		btnLimpiarNumTel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				DefaultTableModel modeloNumT = objNumT.mostrarRegistrosNumT("SELECT * FROM NumTel_Institucion");
				tablaNumTel.setModel(modeloNumT);
				
				limpiarEntradas();
				
			}
		});
		btnLimpiarNumTel.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		btnLimpiarNumTel.setBounds(606, 193, 114, 23);
		NumTel.add(btnLimpiarNumTel);

		//-->> INICIO DEL PANEL CONTENEDOR DE LA TABLA
		JPanel pnlTablaNumTel = new JPanel();
		pnlTablaNumTel.setBounds(179, 267, 392, 208);
		NumTel.add(pnlTablaNumTel);
		pnlTablaNumTel.setLayout(null);

			JScrollPane spTablaNumTel = new JScrollPane();
			spTablaNumTel.setBounds(0, 0, 392, 208);
			pnlTablaNumTel.add(spTablaNumTel);
		
			tablaNumTel = new JTable();
			tablaNumTel.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
			spTablaNumTel.setViewportView(tablaNumTel);

//-->> INICIO DEL PANEL DE INSTITUCION
		JPanel Institucion = new JPanel();
		tabbedPane.addTab("Instituci\u00F3n", null, Institucion, null);
		Institucion.setLayout(null);

		JTextPane txtpnIdintsi = new JTextPane();
		txtpnIdintsi.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		txtpnIdintsi.setText("ID INSTITUCION");
		txtpnIdintsi.setEditable(false);
		txtpnIdintsi.setBackground(SystemColor.menu);
		txtpnIdintsi.setBounds(123, 25, 111, 20);
		Institucion.add(txtpnIdintsi);

		JTextPane txtpnNombreInsti = new JTextPane();
		txtpnNombreInsti.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		txtpnNombreInsti.setText("NOMBRE");
		txtpnNombreInsti.setEditable(false);
		txtpnNombreInsti.setBackground(SystemColor.menu);
		txtpnNombreInsti.setBounds(353, 25, 57, 20);
		Institucion.add(txtpnNombreInsti);

		JTextPane txtpnNumExte = new JTextPane();
		txtpnNumExte.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		txtpnNumExte.setText("NUM EXTERIOR");
		txtpnNumExte.setEditable(false);
		txtpnNumExte.setBackground(SystemColor.menu);
		txtpnNumExte.setBounds(240, 99, 99, 20);
		Institucion.add(txtpnNumExte);

		JTextPane txtpnNumInt = new JTextPane();
		txtpnNumInt.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		txtpnNumInt.setText("NUM INTERIOR");
		txtpnNumInt.setEditable(false);
		txtpnNumInt.setBackground(SystemColor.menu);
		txtpnNumInt.setBounds(410, 99, 99, 20);
		Institucion.add(txtpnNumInt);

		JTextPane txtpnNomCalle = new JTextPane();
		txtpnNomCalle.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		txtpnNomCalle.setText("NOMBRE CALLE");
		txtpnNomCalle.setEditable(false);
		txtpnNomCalle.setBackground(SystemColor.menu);
		txtpnNomCalle.setBounds(584, 99, 96, 20);
		Institucion.add(txtpnNomCalle);

		JTextPane txtpnColonia = new JTextPane();
		txtpnColonia.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		txtpnColonia.setText("COLONIA");
		txtpnColonia.setEditable(false);
		txtpnColonia.setBackground(SystemColor.menu);
		txtpnColonia.setBounds(561, 25, 61, 20);
		Institucion.add(txtpnColonia);
		
		JTextPane txtpnMunicipio = new JTextPane();
		txtpnMunicipio.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		txtpnMunicipio.setText("MUNICIPIO");
		txtpnMunicipio.setEditable(false);
		txtpnMunicipio.setBackground(SystemColor.menu);
		txtpnMunicipio.setBounds(84, 99, 71, 20);
		Institucion.add(txtpnMunicipio);

		etIdInstitucion = new JTextField();
		etIdInstitucion.setBounds(128, 56, 100, 20);
		Institucion.add(etIdInstitucion);
		etIdInstitucion.setColumns(10);
		
		etNombreInstitucion = new JTextField();
		etNombreInstitucion.setColumns(10);
		etNombreInstitucion.setBounds(332, 56, 100, 20);
		Institucion.add(etNombreInstitucion);
		
		etColoniaInstitucion = new JTextField();
		etColoniaInstitucion.setColumns(10);
		etColoniaInstitucion.setBounds(541, 56, 100, 20);
		Institucion.add(etColoniaInstitucion);

		etNumExtInstitucion = new JTextField();
		etNumExtInstitucion.setColumns(10);
		etNumExtInstitucion.setBounds(239, 130, 100, 20);
		Institucion.add(etNumExtInstitucion);

		etNumInteriorInstitucion = new JTextField();
		etNumInteriorInstitucion.setColumns(10);
		etNumInteriorInstitucion.setBounds(409, 130, 100, 20);
		Institucion.add(etNumInteriorInstitucion);

		etNombreCalleInstitucion = new JTextField();
		etNombreCalleInstitucion.setColumns(10);
		etNombreCalleInstitucion.setBounds(582, 130, 100, 20);
		Institucion.add(etNombreCalleInstitucion);

		etMunicipioInstitucion = new JTextField();
		etMunicipioInstitucion.setColumns(10);
		etMunicipioInstitucion.setBounds(69, 130, 100, 20);
		Institucion.add(etMunicipioInstitucion);

		//-->> INICIO DE LOS BOTONES
		JButton btnAgregarInstitucion = new JButton("AGREGAR");
		btnAgregarInstitucion.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		btnAgregarInstitucion.addActionListener((ActionListener) new ActionListener() {
			public void actionPerformed(ActionEvent Arg0) {
				
				objInst.ingresarInst(etIdInstitucion.getText(), etNombreInstitucion.getText(), etNumExtInstitucion.getText(), etNumInteriorInstitucion.getText(),	etNombreCalleInstitucion.getText(), etColoniaInstitucion.getText(), etMunicipioInstitucion.getText());
				limpiarEntradas();

				DefaultTableModel modeloInsti = objInst.mostrarRegistrosIns("SELECT * FROM institucion");
				tablaInstitucion.setModel(modeloInsti);
				
			}
		});
		btnAgregarInstitucion.setBounds(32, 223, 111, 23);
		Institucion.add(btnAgregarInstitucion);

		JButton btnEliminarInstitucion = new JButton("ELIMINAR");
		btnEliminarInstitucion.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		btnEliminarInstitucion.addActionListener((ActionListener) new ActionListener() {
			public void actionPerformed(ActionEvent Arg0) {
				
				objInst.eliminarInst(etIdInstitucion.getText());
				limpiarEntradas();

				DefaultTableModel modeloInsti = objInst.mostrarRegistrosIns("SELECT * FROM institucion");
				tablaInstitucion.setModel(modeloInsti);
				
			}
		});
		btnEliminarInstitucion.setBounds(175, 223, 111, 23);
		Institucion.add(btnEliminarInstitucion);

		JButton btnModificarInstitucion = new JButton("MODIFICAR");
		btnModificarInstitucion.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		btnModificarInstitucion.addActionListener((ActionListener) new ActionListener() {
			public void actionPerformed(ActionEvent Arg0) {

				objInst.modificarInst(etIdInstitucion.getText(), etNombreInstitucion.getText(), etNumExtInstitucion.getText(), etNumInteriorInstitucion.getText(), etNombreCalleInstitucion.getText(), etColoniaInstitucion.getText(), etMunicipioInstitucion.getText());
				limpiarEntradas();

				DefaultTableModel modeloInsti = objInst.mostrarRegistrosIns("SELECT * FROM institucion");
				tablaInstitucion.setModel(modeloInsti);
				
			}
		});
		btnModificarInstitucion.setBounds(318, 223, 111, 23);
		Institucion.add(btnModificarInstitucion);

		JButton btnLimpiarInstitucion = new JButton("LIMPIAR");
		btnLimpiarInstitucion.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		btnLimpiarInstitucion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				DefaultTableModel modeloInsti = objInst.mostrarRegistrosIns("SELECT * FROM institucion");
				tablaInstitucion.setModel(modeloInsti);
				
				limpiarEntradas();
				
			}
		});
		btnLimpiarInstitucion.setBounds(604, 223, 111, 23);
		Institucion.add(btnLimpiarInstitucion);
		
		JButton btnConsultarInstitucion = new JButton("CONSULTAR");
		btnConsultarInstitucion.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		btnConsultarInstitucion.addActionListener((ActionListener) new ActionListener() {
			public void actionPerformed(ActionEvent Arg0) {
				
				String query="";

				if ((etIdInstitucion.getText()).equals(""))
					query = "SELECT * FROM institucion";
				else
					query = "SELECT * FROM institucion WHERE Id_Inst = '"+etIdInstitucion.getText()+"'";
				
				DefaultTableModel modeloInsti = objInst.mostrarRegistrosIns(query);
				tablaInstitucion.setModel(modeloInsti);
				
			}
		});
		btnConsultarInstitucion.setBounds(461, 223, 111, 23);
		Institucion.add(btnConsultarInstitucion);

		//-->> INICIO DEL PANEL DE LA TABLA
		JPanel pnlTablaInstitucion = new JPanel();
		pnlTablaInstitucion.setBounds(20, 265, 707, 210);
		Institucion.add(pnlTablaInstitucion);
		pnlTablaInstitucion.setLayout(null);

			JScrollPane spTablaInstitucion = new JScrollPane();
			spTablaInstitucion.setBounds(0, 0, 707, 210);
			pnlTablaInstitucion.add(spTablaInstitucion);
	
			tablaInstitucion = new JTable();
			spTablaInstitucion.setViewportView(tablaInstitucion);	
		
//-->> INICIO DEL PANEL DE CARTILLA
		JPanel Cartilla = new JPanel();
		tabbedPane.addTab("Cartilla", null, Cartilla, null);
		Cartilla.setLayout(null);
		
		JLabel lblNum_Liberación = new JLabel("NUM_LIBERACI\u00D3N");
		lblNum_Liberación.setBounds(118, 70, 107, 14);
		lblNum_Liberación.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		Cartilla.add(lblNum_Liberación);

		JLabel lblZona_Militar = new JLabel("ZONA_MILITAR");
		lblZona_Militar.setBounds(343, 70, 93, 14);
		lblZona_Militar.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		Cartilla.add(lblZona_Militar);	

		JLabel lblRegimiento = new JLabel("REGIMIENTO");
		lblRegimiento.setBounds(554, 70, 77, 14);
		lblRegimiento.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		Cartilla.add(lblRegimiento);

		etNum_LiberacionCartilla = new JTextField();
		etNum_LiberacionCartilla.setBounds(112, 95, 118, 20);
		Cartilla.add(etNum_LiberacionCartilla);
		etNum_LiberacionCartilla.setColumns(10);
		
		etZona_Militar = new JTextField();
		etZona_Militar.setBounds(330, 95, 118, 20);
		etZona_Militar.setColumns(10);
		Cartilla.add(etZona_Militar);
		
		etRegimiento = new JTextField();
		etRegimiento.setBounds(533, 95, 118, 20);
		etRegimiento.setColumns(10);
		Cartilla.add(etRegimiento);
				
		//-->>INICIO DE LOS BOTONES
		JButton btnEliminarCar = new JButton("ELIMINAR");
		btnEliminarCar.setBounds(170, 192, 118, 23);
		btnEliminarCar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				objCar.eliminar_Car(etNum_LiberacionCartilla.getText());
				limpiarEntradas();

				DefaultTableModel modeloCar = objCar.mostrarRegistrosCar("SELECT * FROM cartilla");
				tablaCartilla.setModel(modeloCar);

			}
		});
		btnEliminarCar.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		Cartilla.add(btnEliminarCar);

		JButton btnAgregarCar = new JButton("AGREGAR");
		btnAgregarCar.setBounds(26, 192, 118, 23);
		btnAgregarCar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				objCar.ingresar_Car(etNum_LiberacionCartilla.getText(), etZona_Militar.getText(),	etRegimiento.getText());
				limpiarEntradas();

				DefaultTableModel modeloCar = objCar.mostrarRegistrosCar("SELECT * FROM cartilla");
				tablaCartilla.setModel(modeloCar);

			}
		});
		btnAgregarCar.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		Cartilla.add(btnAgregarCar);
		
		JButton btnModificarCar = new JButton("MODIFICAR");
		btnModificarCar.setBounds(314, 192, 118, 23);
		btnModificarCar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		
				objCar.modificar_Car(etNum_LiberacionCartilla.getText(), etZona_Militar.getText(), etRegimiento.getText());
				limpiarEntradas();
		
				DefaultTableModel modeloCar = objCar.mostrarRegistrosCar("SELECT * FROM cartilla");
				tablaCartilla.setModel(modeloCar);
				
			}
		});
		btnModificarCar.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		Cartilla.add(btnModificarCar);
		
		JButton btnConsultarCar = new JButton("CONSULTAR");
		btnConsultarCar.setBounds(458, 192, 118, 23);
		btnConsultarCar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String query="";

				if ((etNum_LiberacionCartilla.getText()).equals(""))
					query = "SELECT * FROM cartilla";
				else
					query = "SELECT * FROM cartilla  WHERE Num_liberación = '"+etNum_LiberacionCartilla.getText()+"'";
				
				DefaultTableModel modeloCar = objCar.mostrarRegistrosCar(query);
				tablaCartilla.setModel(modeloCar);
				
			}
		});
		btnConsultarCar.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		Cartilla.add(btnConsultarCar);
		
		JButton btnLimpiarCar = new JButton("LIMPIAR");
		btnLimpiarCar.setBounds(602, 192, 118, 23);
		btnLimpiarCar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				DefaultTableModel modeloCar = objCar.mostrarRegistrosCar("SELECT * FROM cartilla");
				tablaCartilla.setModel(modeloCar);
				
				limpiarEntradas();
				
			}
		});
		btnLimpiarCar.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		Cartilla.add(btnLimpiarCar);
		
		//-->> INICIO DEL PANEL CONTENEDOR DE LA TABLA
		JPanel pnlTablaCartilla = new JPanel();
		pnlTablaCartilla.setBounds(173, 266, 404, 209);
		Cartilla.add(pnlTablaCartilla);
		pnlTablaCartilla.setLayout(null);
		
			JScrollPane spTablaCartilla = new JScrollPane();
			spTablaCartilla.setBounds(0, 0, 404, 209);
			pnlTablaCartilla.add(spTablaCartilla);
			
			tablaCartilla = new JTable();
			spTablaCartilla.setViewportView(tablaCartilla);

//-->> INICIO DEL PANEL DE ACTIVIDAD
		JPanel Actividad = new JPanel();
		tabbedPane.addTab("Actividad", null, Actividad, null);
		Actividad.setLayout(null);

		JTextPane txtpnNumplaca = new JTextPane();
		txtpnNumplaca.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		txtpnNumplaca.setText("NUMERO PLACA");
		txtpnNumplaca.setBackground(SystemColor.menu);
		txtpnNumplaca.setEditable(false);
		txtpnNumplaca.setBounds(67, 11, 98, 20);
		Actividad.add(txtpnNumplaca);

		JTextPane txtpnMatriculaenc = new JTextPane();
		txtpnMatriculaenc.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		txtpnMatriculaenc.setText("MATRICULA ENC");
		txtpnMatriculaenc.setEditable(false);
		txtpnMatriculaenc.setBackground(SystemColor.menu);
		txtpnMatriculaenc.setBounds(232, 11, 104, 20);
		Actividad.add(txtpnMatriculaenc);

		JTextPane txtpnNs = new JTextPane();
		txtpnNs.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		txtpnNs.setText("NUM SECCI\u00D3N");
		txtpnNs.setEditable(false);
		txtpnNs.setBackground(SystemColor.menu);
		txtpnNs.setBounds(403, 11, 98, 20);
		Actividad.add(txtpnNs);

		JTextPane txtpnIdinst = new JTextPane();
		txtpnIdinst.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		txtpnIdinst.setText("ID INSTITUCION");
		txtpnIdinst.setEditable(false);
		txtpnIdinst.setBackground(SystemColor.menu);
		txtpnIdinst.setBounds(568, 11, 112, 20);
		Actividad.add(txtpnIdinst);

		JTextPane txtpnHora = new JTextPane();
		txtpnHora.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		txtpnHora.setText("HORA INI");
		txtpnHora.setEditable(false);
		txtpnHora.setBackground(SystemColor.menu);
		txtpnHora.setBounds(63, 100, 70, 20);
		Actividad.add(txtpnHora);
		
		JTextPane txtpnHorafin = new JTextPane();
		txtpnHorafin.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		txtpnHorafin.setText("HORA FIN");
		txtpnHorafin.setEditable(false);
		txtpnHorafin.setBackground(SystemColor.menu);
		txtpnHorafin.setBounds(196, 100, 68, 20);
		Actividad.add(txtpnHorafin);

		JTextPane txtpnFecha = new JTextPane();
		txtpnFecha.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		txtpnFecha.setText("FECHA");
		txtpnFecha.setEditable(false);
		txtpnFecha.setBackground(SystemColor.menu);
		txtpnFecha.setBounds(329, 100, 44, 20);
		Actividad.add(txtpnFecha);
		
		JTextPane txtpnTactividad = new JTextPane();
		txtpnTactividad.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		txtpnTactividad.setText("TIPO ACTIVIDAD");
		txtpnTactividad.setEditable(false);
		txtpnTactividad.setBackground(SystemColor.menu);
		txtpnTactividad.setBounds(436, 100, 107, 20);
		Actividad.add(txtpnTactividad);

		JTextPane txtpnCosteact = new JTextPane();
		txtpnCosteact.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		txtpnCosteact.setText("COSTE ACT");
		txtpnCosteact.setEditable(false);
		txtpnCosteact.setBackground(SystemColor.menu);
		txtpnCosteact.setBounds(611, 100, 74, 20);
		Actividad.add(txtpnCosteact);
		
		etNumPlacaIns = new JTextField();
		etNumPlacaIns.setBounds(73, 42, 86, 20);
		Actividad.add(etNumPlacaIns);
		etNumPlacaIns.setColumns(10);
		
		etMatricula = new JTextField();
		etMatricula.setColumns(10);
		etMatricula.setBounds(241, 42, 86, 20);
		Actividad.add(etMatricula);

		etNumSec = new JTextField();
		etNumSec.setColumns(10);
		etNumSec.setBounds(409, 42, 86, 20);
		Actividad.add(etNumSec);

		etIdInst = new JTextField();
		etIdInst.setColumns(10);
		etIdInst.setBounds(581, 42, 86, 20);
		Actividad.add(etIdInst);

		etHoraInicio = new JTextField();
		etHoraInicio.setColumns(10);
		etHoraInicio.setBounds(55, 133, 86, 20);
		Actividad.add(etHoraInicio);

		etHoraFin = new JTextField();
		etHoraFin.setColumns(10);
		etHoraFin.setBounds(188, 133, 86, 20);
		Actividad.add(etHoraFin);

		etFecha = new JTextField();
		etFecha.setColumns(10);
		etFecha.setBounds(308, 133, 86, 20);
		Actividad.add(etFecha);

		etActividad = new JTextField();
		etActividad.setColumns(10);
		etActividad.setBounds(449, 133, 86, 20);
		Actividad.add(etActividad);

		etCosteAct = new JTextField();
		etCosteAct.setColumns(10);
		etCosteAct.setBounds(605, 133, 86, 20);
		Actividad.add(etCosteAct);

		//-->> INICIO DE LOS BOTONES
		JButton btnAgregarActividad = new JButton("AGREGAR");
		btnAgregarActividad.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		btnAgregarActividad.addActionListener((ActionListener) new ActionListener() {
			public void actionPerformed(ActionEvent Arg0) {

				objAct.ingresar_actividad(etNumPlacaIns.getText(), etMatricula.getText(), etNumSec.getText(), etIdInst.getText(), etHoraInicio.getText(), etHoraFin.getText(), etFecha.getText(), etActividad.getText(), etCosteAct.getText());

				DefaultTableModel modeloAct = objAct.mostrarRegistrosAct("SELECT * FROM actividad");
				tablaActividad.setModel(modeloAct);
				
			}
		});
		btnAgregarActividad.setBounds(32, 228, 111, 23);
		Actividad.add(btnAgregarActividad);

		JButton btnEliminarActividad = new JButton("ELIMINAR");
		btnEliminarActividad.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		btnEliminarActividad.addActionListener((ActionListener) new ActionListener() {
			public void actionPerformed(ActionEvent Arg0) {

				objAct.eliminar_actividad(etNumPlacaIns.getText(), etMatricula.getText(), etNumSec.getText(), etIdInst.getText());

				DefaultTableModel modeloAct = objAct.mostrarRegistrosAct("SELECT * FROM actividad");
				tablaActividad.setModel(modeloAct);

			}
		});
		btnEliminarActividad.setBounds(175, 228, 111, 23);
		Actividad.add(btnEliminarActividad);

		JButton btnModificarActividad = new JButton("MODIFICAR");
		btnModificarActividad.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		btnModificarActividad.addActionListener((ActionListener) new ActionListener() {
			public void actionPerformed(ActionEvent Arg0) {

				objAct.modificar_actividad(etNumPlacaIns.getText(), etMatricula.getText(), etNumSec.getText(), etIdInst.getText(), etHoraInicio.getText(), etHoraFin.getText(), etFecha.getText(), etActividad.getText(), etCosteAct.getText());

				DefaultTableModel modeloAct = objAct.mostrarRegistrosAct("SELECT * FROM actividad");
				tablaActividad.setModel(modeloAct);
				
			}
		});
		btnModificarActividad.setBounds(318, 228, 111, 23);
		Actividad.add(btnModificarActividad);

		JButton btnConsultarActividad = new JButton("CONSULTAR");
		btnConsultarActividad.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		btnConsultarActividad.addActionListener((ActionListener) new ActionListener() {
			public void actionPerformed(ActionEvent Arg0) {
				
				String query="";

				if ((etNumPlacaIns.getText()).equals("") && (etMatricula.getText()).equals(""))
					query = "SELECT * FROM actividad";
				else if (!((etNumPlacaIns.getText()).equals("")))
					query = "SELECT * FROM actividad  WHERE Num_Placa = '"+etNumPlacaIns.getText()+"'";
				else if (!((etMatricula.getText()).equals("")))
					query = "SELECT * FROM actividad  WHERE Matricula_Enc = '"+etMatricula.getText()+"'";
				
				DefaultTableModel modeloAct = objAct.mostrarRegistrosAct(query);
				tablaActividad.setModel(modeloAct);
				
			}
		});
		btnConsultarActividad.setBounds(461, 228, 111, 23);
		Actividad.add(btnConsultarActividad);

		JButton btnLimpiarActividad = new JButton("LIMPIAR");
		btnLimpiarActividad.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		btnLimpiarActividad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				DefaultTableModel modeloAct = objAct.mostrarRegistrosAct("SELECT * FROM actividad");
				tablaActividad.setModel(modeloAct);
				
				limpiarEntradas();
				
			}
		});
		btnLimpiarActividad.setBounds(604, 228, 111, 23);
		Actividad.add(btnLimpiarActividad);
		
		//-->> INICIO DEL PANEL DE LA TABLA
		JPanel pnlTablaActividad = new JPanel();
		pnlTablaActividad.setBounds(20, 280, 707, 195);
		Actividad.add(pnlTablaActividad);
		pnlTablaActividad.setLayout(null);

			JScrollPane spTablaActividad = new JScrollPane();
			spTablaActividad.setBounds(0, 0, 707, 195);
			pnlTablaActividad.add(spTablaActividad);
	
			tablaActividad = new JTable();
			spTablaActividad.setViewportView(tablaActividad);		
		
//-->> INICIA PANEL DE OBTIENE		
		JPanel Obtiene = new JPanel();
		tabbedPane.addTab("Obtiene", null, Obtiene, null);
		Obtiene.setLayout(null);
		
		JLabel lblMatReserva = new JLabel("MATRICULA DEL RESERVA");
		lblMatReserva.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		lblMatReserva.setBounds(151, 44, 151, 14);
		Obtiene.add(lblMatReserva);
		
		JLabel lblNumLiberacion = new JLabel("N\u00DAMERO DE LIBERACI\u00D3N");
		lblNumLiberacion.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		lblNumLiberacion.setBounds(452, 44, 148, 14);
		Obtiene.add(lblNumLiberacion);
		
		JLabel lblPrecioCart = new JLabel("PRECIO DE CARTILLA");
		lblPrecioCart.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		lblPrecioCart.setBounds(165, 110, 123, 14);
		Obtiene.add(lblPrecioCart);
		
		JLabel lblRecepcion = new JLabel("MES DE RECEPCI\u00D3N");
		lblRecepcion.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		lblRecepcion.setBounds(468, 110, 116, 14);
		Obtiene.add(lblRecepcion);

		etMatReserva = new JTextField();
		etMatReserva.setBounds(183, 68, 86, 20);
		Obtiene.add(etMatReserva);
		etMatReserva.setColumns(10);
		
		etNumLiberacion = new JTextField();
		etNumLiberacion.setBounds(483, 68, 86, 20);
		Obtiene.add(etNumLiberacion);
		etNumLiberacion.setColumns(10);
		
		etPrecioCart = new JTextField();
		etPrecioCart.setBounds(183, 139, 86, 20);
		Obtiene.add(etPrecioCart);
		etPrecioCart.setColumns(10);

		etMesRecepcion = new JTextField();
		etMesRecepcion.setBounds(483, 139, 86, 20);
		Obtiene.add(etMesRecepcion);
		etMesRecepcion.setColumns(10);
										
		//-->> INICIO DE LOS BOTONES
		JButton btnAgregarObtiene = new JButton("AGREGAR");
		btnAgregarObtiene.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		
				objObt.ingresar_obtiene(etMatReserva.getText(), etNumLiberacion.getText(), etPrecioCart.getText(), etMesRecepcion.getText());
		
				DefaultTableModel modelo = objObt.mostrarRegistrosObtiene("SELECT * FROM obtiene");
				tablaObtiene.setModel(modelo);
		
			}
		});
		btnAgregarObtiene.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		btnAgregarObtiene.setBounds(35, 219, 108, 23);
		Obtiene.add(btnAgregarObtiene);
		
		JButton btnEliminarObtiene = new JButton("ELIMINAR");
		btnEliminarObtiene.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		
				objObt.eliminar_obtiene(etMatReserva.getText());
		
				DefaultTableModel modelo = objObt.mostrarRegistrosObtiene("SELECT * FROM obtiene");
				tablaObtiene.setModel(modelo);
		
			}
		});
		btnEliminarObtiene.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		btnEliminarObtiene.setBounds(178, 219, 108, 23);
		Obtiene.add(btnEliminarObtiene);
		
		JButton btnModificarObtiene = new JButton("MODIFICAR");
		btnModificarObtiene.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		
				objObt.modificar_obtiene(etMatReserva.getText(), etNumLiberacion.getText(), etPrecioCart.getText(), etMesRecepcion.getText());
		
				DefaultTableModel modelo = objObt.mostrarRegistrosObtiene("SELECT * FROM obtiene");
				tablaObtiene.setModel(modelo);
		
			}
		});
		btnModificarObtiene.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		btnModificarObtiene.setBounds(321, 219, 108, 23);
		Obtiene.add(btnModificarObtiene);
		
		JButton btnLimpiarObtiene = new JButton("LIMPIAR");
		btnLimpiarObtiene.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				DefaultTableModel modelo = objObt.mostrarRegistrosObtiene("SELECT * FROM obtiene");
				tablaObtiene.setModel(modelo);
				
				limpiarEntradas();

			}
		});
		btnLimpiarObtiene.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		btnLimpiarObtiene.setBounds(607, 219, 108, 23);
		Obtiene.add(btnLimpiarObtiene);
		
		JButton btnConsultarObtiene = new JButton("CONSULTAR");
		btnConsultarObtiene.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String query="";

				if ((etMatReserva.getText()).equals(""))
					query = "SELECT * FROM obtiene";
				else
					query = "SELECT * FROM obtiene  WHERE Matricula_Res = '"+etMatReserva.getText()+"'";
				
				DefaultTableModel modelo = objObt.mostrarRegistrosObtiene(query);
				tablaObtiene.setModel(modelo);
		
			}
		});
		btnConsultarObtiene.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		btnConsultarObtiene.setBounds(464, 219, 108, 23);
		Obtiene.add(btnConsultarObtiene);
		
		//-->> INICIA EL PANEL CONTENEDOR DE LA TABLA
		JPanel pnlTablaObtiene = new JPanel();
		pnlTablaObtiene.setBounds(172, 282, 405, 193);
		Obtiene.add(pnlTablaObtiene);
		pnlTablaObtiene.setLayout(null);

			JScrollPane spTablaObtiene = new JScrollPane();
			spTablaObtiene.setBounds(0, 0, 405, 193);
			pnlTablaObtiene.add(spTablaObtiene);
	
			tablaObtiene = new JTable();
			spTablaObtiene.setViewportView(tablaObtiene);
		
//-->> INICIO DE PANEL LIDERA
		JPanel Lidera = new JPanel();
		tabbedPane.addTab("Lidera", null, Lidera, null);
		Lidera.setLayout(null);
		
		JLabel lblSargento = new JLabel("PLACA DEL SARGENTO");
		lblSargento.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		lblSargento.setBounds(170, 47, 135, 16);
		Lidera.add(lblSargento);
		
		JLabel lblCabo = new JLabel("PLACA DEL CABO");
		lblCabo.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		lblCabo.setBounds(462, 47, 103, 16);
		Lidera.add(lblCabo);
	
		etSargento = new JTextField();
		etSargento.setBounds(194, 74, 86, 20);
		Lidera.add(etSargento);
		etSargento.setColumns(10);
		
		etCabo = new JTextField();
		etCabo.setBounds(470, 74, 86, 20);
		Lidera.add(etCabo);
		etCabo.setColumns(10);

		JButton btnRegistroLidera = new JButton("AGREGAR");
		btnRegistroLidera.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				objTC.ingreso_reg(etSargento.getText(), etCabo.getText());

				DefaultTableModel modelo = objTC.mostrarRegistros("SELECT * FROM lidera");
				tablaLidera.setModel(modelo);
				
			}
		});
		btnRegistroLidera.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		btnRegistroLidera.setBounds(10, 197, 113, 23);
		Lidera.add(btnRegistroLidera);

		JButton btnEliminarLidera = new JButton("ELIMINAR");
		btnEliminarLidera.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				objTC.eliminar_reg(etSargento.getText(), etCabo.getText());

				DefaultTableModel modelo = objTC.mostrarRegistros("SELECT * FROM lidera");
				tablaLidera.setModel(modelo);
				
			}
		});
		btnEliminarLidera.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		btnEliminarLidera.setBounds(163, 197, 113, 23);
		Lidera.add(btnEliminarLidera);

		JButton btnModificarLidera = new JButton("MODIFICAR");
		btnModificarLidera.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				objTC.modificar_reg(etSargento.getText(), etCabo.getText());

				DefaultTableModel modelo = objTC.mostrarRegistros("SELECT * FROM lidera");
				tablaLidera.setModel(modelo);
				
			}
		});
		btnModificarLidera.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		btnModificarLidera.setBounds(316, 197, 113, 23);
		Lidera.add(btnModificarLidera);

		JButton btnConsultarLidera = new JButton("CONSULTAR");
		btnConsultarLidera.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String query="";

				if ((etSargento.getText()).equals("") && (etCabo.getText()).equals(""))
					query = "SELECT * FROM lidera";
				else if (!((etSargento.getText()).equals("")))
					query = "SELECT * FROM lidera WHERE Num_PlacaSargento = '"+etSargento.getText()+"'";
				else if (!((etCabo.getText()).equals("")))
					query = "SELECT * FROM lidera WHERE Num_PlacaCabo = '"+etCabo.getText()+"'";
				
				DefaultTableModel modelo = objTC.mostrarRegistros(query);
				tablaLidera.setModel(modelo);
									
			}
		});
		btnConsultarLidera.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		btnConsultarLidera.setBounds(469, 197, 113, 23);
		Lidera.add(btnConsultarLidera);
		
		JButton btnLimpiarLidera = new JButton("LIMPIAR");
		btnLimpiarLidera.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				DefaultTableModel modelo = objTC.mostrarRegistros("SELECT * FROM lidera");
				tablaLidera.setModel(modelo);
				
				limpiarEntradas();
				
			}
		});
		btnLimpiarLidera.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		btnLimpiarLidera.setBounds(622, 197, 113, 23);
		Lidera.add(btnLimpiarLidera);
		
		//--> INICIA EL PANEL CONTENEDOR DE LA TABLA	
		JPanel pnlTablaLidera = new JPanel();
		pnlTablaLidera.setBounds(280, 252, 207, 223);
		Lidera.add(pnlTablaLidera);
		pnlTablaLidera.setLayout(null);

			JScrollPane spTablaLidera = new JScrollPane();
			spTablaLidera.setBounds(0, 0, 207, 223);
			pnlTablaLidera.add(spTablaLidera);
	
			tablaLidera = new JTable();
			spTablaLidera.setViewportView(tablaLidera);

//-->> INICIO DEL PANEL DE ESCUADRON
		JPanel Escuadron = new JPanel();
		tabbedPane.addTab("Escuadron", null, Escuadron, null);
		Escuadron.setLayout(null);

		JTextPane txtpnNseccin = new JTextPane();
		txtpnNseccin.setText("NUMERO SECCI\u00D3N");
		txtpnNseccin.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		txtpnNseccin.setEditable(false);
		txtpnNseccin.setBackground(SystemColor.menu);
		txtpnNseccin.setBounds(170, 48, 118, 20);
		Escuadron.add(txtpnNseccin);

		JTextPane txtpnNum = new JTextPane();
		txtpnNum.setText("NUM INTEGRANTES");
		txtpnNum.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		txtpnNum.setEditable(false);
		txtpnNum.setBackground(SystemColor.menu);
		txtpnNum.setBounds(458, 48, 125, 20);
		Escuadron.add(txtpnNum);

		etNumeroSeccion = new JTextField();
		etNumeroSeccion.setBounds(168, 85, 123, 20);
		Escuadron.add(etNumeroSeccion);
		etNumeroSeccion.setColumns(10);
		
		etNumIntegrantes = new JTextField();
		etNumIntegrantes.setColumns(10);
		etNumIntegrantes.setBounds(459, 85, 123, 20);
		Escuadron.add(etNumIntegrantes);

		//-->> INICIO DE LOS BOTONES
		JButton btnAgregarEscuadron = new JButton("AGREGAR");
		btnAgregarEscuadron.addActionListener((ActionListener) new ActionListener() {
			public void actionPerformed(ActionEvent Arg0) {
				
				objEsc.ingresar_Esc(etNumeroSeccion.getText(), etNumIntegrantes.getText());

				DefaultTableModel modeloEsc = objEsc.mostrarRegistrosEscuadron("SELECT * FROM escuadron");
				tablaEscuadron.setModel(modeloEsc);
				
			}
		});
		btnAgregarEscuadron.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		btnAgregarEscuadron.setBounds(30, 161, 114, 23);
		Escuadron.add(btnAgregarEscuadron);

		JButton btnEliminarEscuadron = new JButton("ELIMINAR");
		btnEliminarEscuadron.addActionListener((ActionListener) new ActionListener() {
			public void actionPerformed(ActionEvent Arg0) {

				objEsc.eliminar_Esc(etNumeroSeccion.getText());

				DefaultTableModel modeloEsc = objEsc.mostrarRegistrosEscuadron("SELECT * FROM escuadron");
				tablaEscuadron.setModel(modeloEsc);
				
			}
		});
		btnEliminarEscuadron.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		btnEliminarEscuadron.setBounds(174, 161, 114, 23);
		Escuadron.add(btnEliminarEscuadron);

		JButton btnModificarEscuadron = new JButton("MODIFICAR");
		btnModificarEscuadron.addActionListener((ActionListener) new ActionListener() {
			public void actionPerformed(ActionEvent Arg0) {

				objEsc.modificar_Esc(etNumeroSeccion.getText(), etNumIntegrantes.getText());

				DefaultTableModel modeloEsc = objEsc.mostrarRegistrosEscuadron("SELECT * FROM escuadron");
				tablaEscuadron.setModel(modeloEsc);
				
			}
		});
		btnModificarEscuadron.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		btnModificarEscuadron.setBounds(318, 161, 114, 23);
		Escuadron.add(btnModificarEscuadron);

		JButton btnConsultarEscuadron = new JButton("CONSULTAR");
		btnConsultarEscuadron.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String query="";

				if ((etNumeroSeccion.getText()).equals(""))
					query = "SELECT * FROM escuadron";
				else
					query = "SELECT * FROM escuadron WHERE N_Sección = '"+etNumeroSeccion.getText()+"'";
				
				DefaultTableModel modeloEsc = objEsc.mostrarRegistrosEscuadron(query);
				tablaEscuadron.setModel(modeloEsc);
				
			}
		});
		btnConsultarEscuadron.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		btnConsultarEscuadron.setBounds(462, 161, 114, 23);
		Escuadron.add(btnConsultarEscuadron);

		JButton btnLimpiarEscuadron = new JButton("LIMPIAR");
		btnLimpiarEscuadron.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				DefaultTableModel modeloEsc = objEsc.mostrarRegistrosEscuadron("SELECT * FROM escuadron");
				tablaEscuadron.setModel(modeloEsc);
				
				limpiarEntradas();
				
			}
		});
		btnLimpiarEscuadron.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		btnLimpiarEscuadron.setBounds(606, 161, 114, 23);
		Escuadron.add(btnLimpiarEscuadron);

		//-->> INICIO DEL PANEL CONTENEDOR DE LA TABLA
		JPanel pnlTablaEscuadron = new JPanel();
		pnlTablaEscuadron.setBounds(252, 251, 246, 224);
		Escuadron.add(pnlTablaEscuadron);
		pnlTablaEscuadron.setLayout(null);

			JScrollPane spTablaEscuadron = new JScrollPane();
			spTablaEscuadron.setBounds(0, 0, 246, 224);
			pnlTablaEscuadron.add(spTablaEscuadron);
	
			tablaEscuadron = new JTable();
			tablaEscuadron.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
			spTablaEscuadron.setViewportView(tablaEscuadron);

//-->> INICIA PANEL DE SORTEO
		JPanel Sorteo = new JPanel();
		tabbedPane.addTab("Sorteo", null, Sorteo, null);
		Sorteo.setLayout(null);

		JLabel lblEdicionDelSorteo = new JLabel("EDICION DEL SORTEO");
		lblEdicionDelSorteo.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		lblEdicionDelSorteo.setBounds(167, 62, 136, 14);
		Sorteo.add(lblEdicionDelSorteo);

		JLabel lblFecha = new JLabel("FECHA");
		lblFecha.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		lblFecha.setBounds(491, 62, 45, 14);
		Sorteo.add(lblFecha);
		
		etsorteo = new JTextField();
		etsorteo.setColumns(10);
		etsorteo.setBounds(192, 84, 86, 20);
		Sorteo.add(etsorteo);

		etfechas = new JTextField();
		etfechas.setColumns(10);
		etfechas.setBounds(470, 84, 86, 20);
		Sorteo.add(etfechas);

		//-->> INICIO DE LOS BOTONES
		JButton btnAgregarSorteo = new JButton("AGREGAR");
		btnAgregarSorteo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				objsor.ingresar_sorteo(etsorteo.getText(), etfechas.getText());

				DefaultTableModel modelos = objsor.mostrarRegistrosSorteo("SELECT * FROM sorteo");
				tablaSorteo.setModel(modelos);

			}
		});
		btnAgregarSorteo.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		btnAgregarSorteo.setBounds(35, 181, 108, 23);
		Sorteo.add(btnAgregarSorteo);

		JButton btnModificarSorteo = new JButton("MODIFICAR");
		btnModificarSorteo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				objsor.modificar_sor(etsorteo.getText(), etfechas.getText());

				DefaultTableModel modelos = objsor.mostrarRegistrosSorteo("SELECT * FROM sorteo");
				tablaSorteo.setModel(modelos);

			}
		});
		btnModificarSorteo.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		btnModificarSorteo.setBounds(321, 181, 108, 23);
		Sorteo.add(btnModificarSorteo);

		JButton btnLimpiarSorteo = new JButton("LIMPIAR");
		btnLimpiarSorteo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				DefaultTableModel modelos = objsor.mostrarRegistrosSorteo("SELECT * FROM sorteo");
				tablaSorteo.setModel(modelos);
				
				limpiarEntradas();

			}
		});
		btnLimpiarSorteo.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		btnLimpiarSorteo.setBounds(607, 181, 108, 23);
		Sorteo.add(btnLimpiarSorteo);
		
		JButton btnConsultarSorteo = new JButton("CONSULTAR");
		btnConsultarSorteo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String query="";

				if ((etsorteo.getText()).equals(""))
					query = "SELECT * FROM sorteo";
				else
					query = "SELECT * FROM sorteo WHERE Ed_Sorteo = '"+etsorteo.getText()+"'";
				
				DefaultTableModel modelos = objsor.mostrarRegistrosSorteo(query);
				tablaSorteo.setModel(modelos);

			}
		});
		btnConsultarSorteo.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		btnConsultarSorteo.setBounds(464, 181, 108, 23);
		Sorteo.add(btnConsultarSorteo);
		
		JButton btnEliminarSorteo = new JButton("ELIMINAR");
		btnEliminarSorteo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				objsor.eliminar_sor(etsorteo.getText());
				
				DefaultTableModel modelos = objsor.mostrarRegistrosSorteo("SELECT * FROM sorteo");
				tablaSorteo.setModel(modelos);
				
			}
		});
		btnEliminarSorteo.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		btnEliminarSorteo.setBounds(178, 181, 108, 23);
		Sorteo.add(btnEliminarSorteo);
		
		//-->> INICIA EL PANEL CONTENEDOR DE LA TABLA
		JPanel pnlTablaSorteo = new JPanel();
		pnlTablaSorteo.setLayout(null);
		pnlTablaSorteo.setBounds(272, 247, 205, 228);
		Sorteo.add(pnlTablaSorteo);

			JScrollPane spTablaSorteo = new JScrollPane();
			spTablaSorteo.setBounds(0, 0, 205, 228);
			pnlTablaSorteo.add(spTablaSorteo);
			
			tablaSorteo = new JTable();
			spTablaSorteo.setViewportView(tablaSorteo);
		
//-->> INICIA EL PANEL CONTENEDOR DE VALIDA
		JPanel Valida = new JPanel();
		Valida.setLayout(null);
		tabbedPane.addTab("Valida", null, Valida, null);
		
		JLabel lblNumeroliberacion = new JLabel("NUMERO DE LIBERACI\u00D3N");
		lblNumeroliberacion.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		lblNumeroliberacion.setBounds(92, 97, 148, 14);
		Valida.add(lblNumeroliberacion);

		JLabel lblHorastrabajadas = new JLabel("HORAS TRABAJADAS");
		lblHorastrabajadas.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		lblHorastrabajadas.setBounds(312, 97, 127, 14);
		Valida.add(lblHorastrabajadas);

		JLabel lblPreciocartilla = new JLabel("PRECIO CARTILLA");
		lblPreciocartilla.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		lblPreciocartilla.setBounds(530, 97, 108, 14);
		Valida.add(lblPreciocartilla);
		
		JLabel lblNumeroDePlaca = new JLabel("NUMERO DE PLACA");
		lblNumeroDePlaca.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		lblNumeroDePlaca.setBounds(177, 31, 117, 14);
		Valida.add(lblNumeroDePlaca);

		JLabel lblMatriculaEncuadrado = new JLabel("MATRICULA DEL  ENCUADRADO");
		lblMatriculaEncuadrado.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		lblMatriculaEncuadrado.setBounds(418, 31, 190, 14);
		Valida.add(lblMatriculaEncuadrado);

		etNumplaca = new JTextField();
		etNumplaca.setColumns(10);
		etNumplaca.setBounds(192, 56, 86, 20);
		Valida.add(etNumplaca);

		etMatenc = new JTextField();
		etMatenc.setColumns(10);
		etMatenc.setBounds(470, 56, 86, 20);
		Valida.add(etMatenc);
		
		etNumlib = new JTextField();
		etNumlib.setColumns(10);
		etNumlib.setBounds(123, 123, 86, 20);
		Valida.add(etNumlib);

		etHoras = new JTextField();
		etHoras.setColumns(10);
		etHoras.setBounds(332, 123, 86, 20);
		Valida.add(etHoras);

		etPreciocart = new JTextField();
		etPreciocart.setColumns(10);
		etPreciocart.setBounds(541, 123, 86, 20);
		Valida.add(etPreciocart); 

		//-->> INICIAN LOS BOTONES
		JButton btnAgregar_V = new JButton("AGREGAR");
		btnAgregar_V.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				objVal.ingresar_valida(etNumplaca.getText(), etMatenc.getText(), etNumlib.getText(), etHoras.getText(), etPreciocart.getText());

				DefaultTableModel modelo = objVal.mostrarRegistrosValida("SELECT * FROM valida");
				tablaValida.setModel(modelo);

			}
		});
		btnAgregar_V.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		btnAgregar_V.setBounds(35, 218, 108, 23);
		Valida.add(btnAgregar_V);

		JButton btnEliminar_V = new JButton("ELIMINAR");
		btnEliminar_V.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				objVal.eliminar_valida(etMatenc.getText());

				DefaultTableModel modelo = objVal.mostrarRegistrosValida("SELECT * FROM valida");
				tablaValida.setModel(modelo);

			}
		});
		btnEliminar_V.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		btnEliminar_V.setBounds(178, 218, 108, 23);
		Valida.add(btnEliminar_V);

		JButton btnModificar_V = new JButton("MODIFICAR");
		btnModificar_V.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				objVal.modificar_val(etNumplaca.getText(), etMatenc.getText(), etNumlib.getText(), etHoras.getText(), etPreciocart.getText());

				DefaultTableModel modelo = objVal.mostrarRegistrosValida("SELECT * FROM valida");
				tablaValida.setModel(modelo);

			}
		});
		btnModificar_V.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		btnModificar_V.setBounds(321, 218, 108, 23);
		Valida.add(btnModificar_V);

		JButton btnLimpiar_V = new JButton("LIMPIAR");
		btnLimpiar_V.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				DefaultTableModel modelo = objVal.mostrarRegistrosValida("SELECT * FROM valida");
				tablaValida.setModel(modelo);

				limpiarEntradas();
				
			}
		});
		btnLimpiar_V.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		btnLimpiar_V.setBounds(607, 218, 108, 23);
		Valida.add(btnLimpiar_V);

		JButton btnConsultar_V = new JButton("CONSULTAR");
		btnConsultar_V.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String query="";

				if ((etNumplaca.getText()).equals("") && (etMatenc.getText()).equals(""))
					query = "SELECT * FROM valida";
				else if (!(etNumplaca.getText()).equals(""))
					query = "SELECT * FROM valida WHERE Num_Placa = '"+etNumplaca.getText()+"'";
				else if (!(etMatenc.getText()).equals(""))
					query = "SELECT * FROM valida WHERE Matricula_Enc = '"+etMatenc.getText()+"'";
				
				DefaultTableModel modelo = objVal.mostrarRegistrosValida(query);
				tablaValida.setModel(modelo);

			}
		});
		btnConsultar_V.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		btnConsultar_V.setBounds(464, 218, 108, 23);
		Valida.add(btnConsultar_V);
		
		//-->> INICIA EL PANEL CONTENEDOR DE LA TABLA
		JPanel pnlTablaValida = new JPanel();
		pnlTablaValida.setLayout(null);
		pnlTablaValida.setBounds(23, 285, 700, 190);
		Valida.add(pnlTablaValida);

			JScrollPane spTablaValida = new JScrollPane();
			spTablaValida.setBounds(0, 0, 700, 190);
			pnlTablaValida.add(spTablaValida);

			tablaValida = new JTable();
			spTablaValida.setViewportView(tablaValida);
		
//-->> INICIO DEL PANEL DE PARTICIPANTE RESERVA
		JPanel ParticipaRes = new JPanel();
		tabbedPane.addTab("Participa_Res", null, ParticipaRes, null);
		ParticipaRes.setLayout(null);

		JTextPane txtpnMatriculares = new JTextPane();
		txtpnMatriculares.setEditable(false);
		txtpnMatriculares.setBackground(SystemColor.menu);
		txtpnMatriculares.setText("MATRICULA RES");
		txtpnMatriculares.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		txtpnMatriculares.setBounds(107, 69, 105, 20);
		ParticipaRes.add(txtpnMatriculares);

		JTextPane txtpnEdsorteo = new JTextPane();
		txtpnEdsorteo.setEditable(false);
		txtpnEdsorteo.setText("ED SORTEO");
		txtpnEdsorteo.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		txtpnEdsorteo.setBackground(SystemColor.menu);
		txtpnEdsorteo.setBounds(337, 69, 77, 20);
		ParticipaRes.add(txtpnEdsorteo);

		JTextPane txtpnResultado = new JTextPane();
		txtpnResultado.setEditable(false);
		txtpnResultado.setText("RESULTADO");
		txtpnResultado.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		txtpnResultado.setBackground(SystemColor.menu);
		txtpnResultado.setBounds(551, 69, 77, 20);
		ParticipaRes.add(txtpnResultado);

		etMatriculaPRes = new JTextField();
		etMatriculaPRes.setBounds(104, 100, 110, 20);
		ParticipaRes.add(etMatriculaPRes);
		etMatriculaPRes.setColumns(10);

		etEdSorteoP = new JTextField();
		etEdSorteoP.setColumns(10);
		etEdSorteoP.setBounds(320, 100, 110, 20);
		ParticipaRes.add(etEdSorteoP);

		etResultadoP = new JTextField();
		etResultadoP.setColumns(10);
		etResultadoP.setBounds(534, 100, 110, 20);
		ParticipaRes.add(etResultadoP);

		JButton btnAgregarPRes = new JButton("AGREGAR");
		btnAgregarPRes.addActionListener((ActionListener) new ActionListener() {
			public void actionPerformed(ActionEvent Arg0) {
		
				objParR.ingresar_ParR(etMatriculaPRes.getText(), etEdSorteoP.getText(), etResultadoP.getText());
		
				DefaultTableModel modeloParR = objParR.mostrarRegistrosNumT("SELECT * FROM participa_res");
				tablaPRes.setModel(modeloParR);
				
			}
		});
		btnAgregarPRes.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		btnAgregarPRes.setBounds(33, 212, 110, 23);
		ParticipaRes.add(btnAgregarPRes);

		JButton btnEliminarPRes = new JButton("ELIMINAR");
		btnEliminarPRes.addActionListener((ActionListener) new ActionListener() {
			public void actionPerformed(ActionEvent Arg0) {

				objParR.eliminar_ParR(etMatriculaPRes.getText());

				DefaultTableModel modeloParR = objParR.mostrarRegistrosNumT("SELECT * FROM participa_res");
				tablaPRes.setModel(modeloParR);

			}
		});
		btnEliminarPRes.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		btnEliminarPRes.setBounds(176, 212, 110, 23);
		ParticipaRes.add(btnEliminarPRes);

		JButton btnModificarPRes = new JButton("MODIFICAR");
		btnModificarPRes.addActionListener((ActionListener) new ActionListener() {
			public void actionPerformed(ActionEvent Arg0) {

				objParR.modificar_ParR(etMatriculaPRes.getText(), etEdSorteoP.getText(), etResultadoP.getText());

				DefaultTableModel modeloParR = objParR.mostrarRegistrosNumT("SELECT * FROM participa_res");
				tablaPRes.setModel(modeloParR);
				
			}
		});
		btnModificarPRes.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		btnModificarPRes.setBounds(319, 212, 110, 23);
		ParticipaRes.add(btnModificarPRes);
		
		JButton btnConsultarPRes = new JButton("CONSULTAR");
		btnConsultarPRes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String query="";

				if ((etMatriculaPRes.getText()).equals(""))
					query = "SELECT * FROM participa_res";
				else
					query = "SELECT * FROM participa_res WHERE Matricula_Res = '"+etMatriculaPRes.getText()+"'";
				
				DefaultTableModel modeloParR = objParR.mostrarRegistrosNumT(query);
				tablaPRes.setModel(modeloParR);
				
			}
		});
		btnConsultarPRes.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		btnConsultarPRes.setBounds(462, 212, 110, 23);
		ParticipaRes.add(btnConsultarPRes);
		
		JButton btnLimpiarPRes = new JButton("LIMPIAR");
		btnLimpiarPRes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				DefaultTableModel modeloParR = objParR.mostrarRegistrosNumT("SELECT * FROM participa_res");
				tablaPRes.setModel(modeloParR);
				
				limpiarEntradas();
				
			}
		});
		btnLimpiarPRes.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		btnLimpiarPRes.setBounds(605, 212, 110, 23);
		ParticipaRes.add(btnLimpiarPRes);
		
		//-->> INICIO DEL PANEL CONTENEDOR DE LA TABLA
		JPanel pnlTablaPRes = new JPanel();
		pnlTablaPRes.setBounds(230, 278, 289, 197);
		ParticipaRes.add(pnlTablaPRes);
		pnlTablaPRes.setLayout(null);
		
			JScrollPane spTablaPRes = new JScrollPane();
			spTablaPRes.setBounds(0, 0, 289, 197);
			pnlTablaPRes.add(spTablaPRes);
			
			tablaPRes = new JTable();
			spTablaPRes.setViewportView(tablaPRes);

//-->> INICIA EL PANEL DE ENCUADRADO
		JPanel Encuadrado = new JPanel();
		Encuadrado.setLayout(null);
		tabbedPane.addTab("Encuadrado", null, Encuadrado, null);

		JLabel lblNombreEnc = new JLabel("NOMBRE");
		lblNombreEnc.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombreEnc.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		lblNombreEnc.setBounds(175, 26, 56, 14);
		Encuadrado.add(lblNombreEnc);

		JLabel lblApellidoPat = new JLabel("A. PATERNO");
		lblApellidoPat.setHorizontalAlignment(SwingConstants.CENTER);
		lblApellidoPat.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		lblApellidoPat.setBounds(280, 26, 72, 14);
		Encuadrado.add(lblApellidoPat);

		JLabel lblApellidoMaternoEnc = new JLabel("A. MATERNO");
		lblApellidoMaternoEnc.setHorizontalAlignment(SwingConstants.CENTER);
		lblApellidoMaternoEnc.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		lblApellidoMaternoEnc.setBounds(391, 26, 77, 14);
		Encuadrado.add(lblApellidoMaternoEnc);

		JLabel lblCurpEnc = new JLabel("CURP\r\n");
		lblCurpEnc.setHorizontalAlignment(SwingConstants.CENTER);
		lblCurpEnc.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		lblCurpEnc.setBounds(538, 26, 28, 14);
		Encuadrado.add(lblCurpEnc);
		
		JLabel lblEdadEnc = new JLabel("EDAD");
		lblEdadEnc.setHorizontalAlignment(SwingConstants.CENTER);
		lblEdadEnc.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		lblEdadEnc.setBounds(660, 26, 31, 14);
		Encuadrado.add(lblEdadEnc);

		JLabel lblProfesionEnc = new JLabel("PROFESI\u00D3N");
		lblProfesionEnc.setHorizontalAlignment(SwingConstants.CENTER);
		lblProfesionEnc.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		lblProfesionEnc.setBounds(38, 94, 72, 14);
		Encuadrado.add(lblProfesionEnc);
		
		JLabel lblSexoEnc = new JLabel("SEXO");
		lblSexoEnc.setHorizontalAlignment(SwingConstants.CENTER);
		lblSexoEnc.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		lblSexoEnc.setBounds(58, 156, 32, 14);
		Encuadrado.add(lblSexoEnc);

		JLabel lblCalleEnc = new JLabel("CALLE");
		lblCalleEnc.setHorizontalAlignment(SwingConstants.CENTER);
		lblCalleEnc.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		lblCalleEnc.setBounds(416, 94, 39, 14);
		Encuadrado.add(lblCalleEnc);
		
		JLabel lblColoniaEnc = new JLabel("COLONIA");
		lblColoniaEnc.setHorizontalAlignment(SwingConstants.CENTER);
		lblColoniaEnc.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		lblColoniaEnc.setBounds(534, 94, 56, 14);
		Encuadrado.add(lblColoniaEnc);
		
		JLabel lblNumInteriorEnc = new JLabel("NUM INTER");
		lblNumInteriorEnc.setHorizontalAlignment(SwingConstants.CENTER);
		lblNumInteriorEnc.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		lblNumInteriorEnc.setBounds(272, 94, 72, 14);
		Encuadrado.add(lblNumInteriorEnc);
		
		JLabel lblNumExteriorEnc = new JLabel("NUM EXT");
		lblNumExteriorEnc.setHorizontalAlignment(SwingConstants.CENTER);
		lblNumExteriorEnc.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		lblNumExteriorEnc.setBounds(163, 94, 56, 14);
		Encuadrado.add(lblNumExteriorEnc);
		
		JLabel lblCiudadEnc = new JLabel("CIUDAD");
		lblCiudadEnc.setHorizontalAlignment(SwingConstants.CENTER);
		lblCiudadEnc.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		lblCiudadEnc.setBounds(656, 94, 46, 14);
		Encuadrado.add(lblCiudadEnc);
		
		JLabel lblEstadoCivilEnc = new JLabel("ESTADO CIVIL");
		lblEstadoCivilEnc.setHorizontalAlignment(SwingConstants.CENTER);
		lblEstadoCivilEnc.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		lblEstadoCivilEnc.setBounds(158, 156, 86, 14);
		Encuadrado.add(lblEstadoCivilEnc);

		JLabel lblDiscapacidad = new JLabel("DISCAPACIDAD");
		lblDiscapacidad.setHorizontalAlignment(SwingConstants.CENTER);
		lblDiscapacidad.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		lblDiscapacidad.setBounds(283, 156, 90, 14);
		Encuadrado.add(lblDiscapacidad);
		
		JLabel lblClaseEnc = new JLabel("CLASE");
		lblClaseEnc.setHorizontalAlignment(SwingConstants.CENTER);
		lblClaseEnc.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		lblClaseEnc.setBounds(426, 156, 39, 14);
		Encuadrado.add(lblClaseEnc);
		
		JLabel lblHablilidadEnc = new JLabel("HABILIDAD\r\n");
		lblHablilidadEnc.setHorizontalAlignment(SwingConstants.CENTER);
		lblHablilidadEnc.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		lblHablilidadEnc.setBounds(530, 156, 65, 14);
		Encuadrado.add(lblHablilidadEnc);
		
		JLabel lblTipoSangreEnc = new JLabel("TIPO SANGRE");
		lblTipoSangreEnc.setHorizontalAlignment(SwingConstants.CENTER);
		lblTipoSangreEnc.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		lblTipoSangreEnc.setBounds(636, 156, 86, 14);
		Encuadrado.add(lblTipoSangreEnc);

		JLabel lblPesoEnc = new JLabel("PESO (KG)");
		lblPesoEnc.setHorizontalAlignment(SwingConstants.CENTER);
		lblPesoEnc.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		lblPesoEnc.setBounds(208, 214, 65, 14);
		Encuadrado.add(lblPesoEnc);
		
		JLabel lblAlturaEnc = new JLabel("ALTURA (MTS)");
		lblAlturaEnc.setHorizontalAlignment(SwingConstants.CENTER);
		lblAlturaEnc.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		lblAlturaEnc.setBounds(480, 214, 86, 14);
		Encuadrado.add(lblAlturaEnc);

		JLabel lblMatriculaEnc = new JLabel("MATRICULA ENC");
		lblMatriculaEnc.setHorizontalAlignment(SwingConstants.CENTER);
		lblMatriculaEnc.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		lblMatriculaEnc.setBounds(31, 26, 98, 14);
		Encuadrado.add(lblMatriculaEnc);
		
		txtNombreEnc = new JTextField();
		txtNombreEnc.setColumns(10);
		txtNombreEnc.setBounds(162, 51, 86, 20);
		Encuadrado.add(txtNombreEnc);
		
		txtApellidoPaternoEnc = new JTextField();
		txtApellidoPaternoEnc.setColumns(10);
		txtApellidoPaternoEnc.setBounds(276, 51, 86, 20);
		Encuadrado.add(txtApellidoPaternoEnc);

		txtApellidoMaternoEnc = new JTextField();
		txtApellidoMaternoEnc.setColumns(10);
		txtApellidoMaternoEnc.setBounds(390, 51, 86, 20);
		Encuadrado.add(txtApellidoMaternoEnc);

		txtCurpEnc = new JTextField();
		txtCurpEnc.setColumns(10);
		txtCurpEnc.setBounds(504, 51, 106, 20);
		Encuadrado.add(txtCurpEnc);

		txtProfesionEnc = new JTextField();
		txtProfesionEnc.setColumns(10);
		txtProfesionEnc.setBounds(31, 120, 86, 20);
		Encuadrado.add(txtProfesionEnc);

		txtCalleEnc = new JTextField();
		txtCalleEnc.setColumns(10);
		txtCalleEnc.setBounds(382, 120, 106, 20);
		Encuadrado.add(txtCalleEnc);

		txtColoniaEnc = new JTextField();
		txtColoniaEnc.setColumns(10);
		txtColoniaEnc.setBounds(519, 120, 86, 20);
		Encuadrado.add(txtColoniaEnc);

		txtNumInteriorEnc = new JTextField();
		txtNumInteriorEnc.setColumns(10);
		txtNumInteriorEnc.setBounds(265, 120, 86, 20);
		Encuadrado.add(txtNumInteriorEnc);

		txtNumExtEnc = new JTextField();
		txtNumExtEnc.setColumns(10);
		txtNumExtEnc.setBounds(148, 120, 86, 20);
		Encuadrado.add(txtNumExtEnc);

		txtCiudadEnc = new JTextField();
		txtCiudadEnc.setColumns(10);
		txtCiudadEnc.setBounds(636, 120, 86, 20);
		Encuadrado.add(txtCiudadEnc);

		txtDiscapacidad = new JTextField();
		txtDiscapacidad.setColumns(10);
		txtDiscapacidad.setBounds(285, 182, 86, 20);
		Encuadrado.add(txtDiscapacidad);

		txtClaseEnc = new JTextField();
		txtClaseEnc.setColumns(10);
		txtClaseEnc.setBounds(402, 182, 86, 20);
		Encuadrado.add(txtClaseEnc);

		txtHabilidadEnc = new JTextField();
		txtHabilidadEnc.setColumns(10);
		txtHabilidadEnc.setBounds(519, 182, 86, 20);
		Encuadrado.add(txtHabilidadEnc);

		txtPesoEnc = new JTextField();
		txtPesoEnc.setColumns(10);
		txtPesoEnc.setBounds(187, 239, 106, 20);
		Encuadrado.add(txtPesoEnc);	

		txtAlturaEnc = new JTextField();
		txtAlturaEnc.setColumns(10);
		txtAlturaEnc.setBounds(480, 239, 86, 20);
		Encuadrado.add(txtAlturaEnc);

		txtSexoEnc = new JTextField();
		txtSexoEnc.setColumns(10);
		txtSexoEnc.setBounds(31, 182, 86, 20);
		Encuadrado.add(txtSexoEnc);

		txtEdadEnc = new JTextField();
		txtEdadEnc.setColumns(10);
		txtEdadEnc.setBounds(638, 51, 86, 20);
		Encuadrado.add(txtEdadEnc);

		txtMatriculaEnc = new JTextField();
		txtMatriculaEnc.setColumns(10);
		txtMatriculaEnc.setBounds(28, 51, 106, 20);
		Encuadrado.add(txtMatriculaEnc);

		txtEstadoCivil = new JTextField();
		txtEstadoCivil.setColumns(10);
		txtEstadoCivil.setBounds(148, 182, 106, 20);
		Encuadrado.add(txtEstadoCivil);

		txtTipoSangreEnc = new JTextField();
		txtTipoSangreEnc.setColumns(10);
		txtTipoSangreEnc.setBounds(636, 182, 86, 20);
		Encuadrado.add(txtTipoSangreEnc);

		JButton btnAgregarEnc = new JButton("AGREGAR");
		btnAgregarEnc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				objEnc.ingresar_Enc(txtMatriculaEnc.getText(), txtNombreEnc.getText(), txtApellidoPaternoEnc.getText(), txtApellidoMaternoEnc.getText(), txtCurpEnc.getText(), txtEdadEnc.getText(), txtProfesionEnc.getText(), txtNumExtEnc.getText(),	txtNumInteriorEnc.getText(), txtCalleEnc.getText(), txtColoniaEnc.getText(), txtCiudadEnc.getText(), txtSexoEnc.getText(), txtEstadoCivil.getText(), txtDiscapacidad.getText(), txtClaseEnc.getText(), txtHabilidadEnc.getText(), txtTipoSangreEnc.getText(), txtPesoEnc.getText(), txtAlturaEnc.getText());

				DefaultTableModel modeloEnc = objEnc.mostrarRegistrosEnc("SELECT * FROM encuadrado");
				tablaEncuadrado.setModel(modeloEnc);

			}
		});
		btnAgregarEnc.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		btnAgregarEnc.setBounds(26, 276, 118, 23);
		Encuadrado.add(btnAgregarEnc);

		JButton btnEliminarEnc = new JButton("ELIMINAR");
		btnEliminarEnc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				objEnc.eliminar_Enc(txtMatriculaEnc.getText());

				DefaultTableModel modeloEnc = objEnc.mostrarRegistrosEnc("SELECT * FROM encuadrado");
				tablaEncuadrado.setModel(modeloEnc);

			}
		});
		btnEliminarEnc.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		btnEliminarEnc.setBounds(170, 276, 118, 23);
		Encuadrado.add(btnEliminarEnc);

		JButton btnModificarEnc = new JButton("MODIFICAR");
		btnModificarEnc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				objEnc.modificar_Enc(txtMatriculaEnc.getText(), txtNombreEnc.getText(), txtApellidoPaternoEnc.getText(), txtApellidoMaternoEnc.getText(), txtCurpEnc.getText(), txtEdadEnc.getText(), txtProfesionEnc.getText(), txtNumExtEnc.getText(),	txtNumInteriorEnc.getText(), txtCalleEnc.getText(), txtColoniaEnc.getText(), txtCiudadEnc.getText(), txtSexoEnc.getText(), txtEstadoCivil.getText(), txtDiscapacidad.getText(), txtClaseEnc.getText(), txtHabilidadEnc.getText(), txtTipoSangreEnc.getText(), txtPesoEnc.getText(), txtAlturaEnc.getText());

				DefaultTableModel modeloEnc = objEnc.mostrarRegistrosEnc("SELECT * FROM encuadrado");
				tablaEncuadrado.setModel(modeloEnc);

			}
		});
		btnModificarEnc.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		btnModificarEnc.setBounds(314, 276, 118, 23);
		Encuadrado.add(btnModificarEnc);

		JButton btnConsultarEnc = new JButton("CONSULTAR");
		btnConsultarEnc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String query="";

				if ((txtMatriculaEnc.getText()).equals(""))
					query = "SELECT * FROM encuadrado";
				else
					query = "SELECT * FROM encuadrado WHERE Matricula_Enc = '"+txtMatriculaEnc.getText()+"'";
				
				DefaultTableModel modeloEnc = objEnc.mostrarRegistrosEnc(query);
				tablaEncuadrado.setModel(modeloEnc);
				
			}
		});
		btnConsultarEnc.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		btnConsultarEnc.setBounds(458, 276, 118, 23);
		Encuadrado.add(btnConsultarEnc);

		JButton btnLimpiarEnc = new JButton("LIMPIAR");
		btnLimpiarEnc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				DefaultTableModel modeloEnc = objEnc.mostrarRegistrosEnc("SELECT * FROM encuadrado");
				tablaEncuadrado.setModel(modeloEnc);
				
				limpiarEntradas();
				
			}
		});
		btnLimpiarEnc.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		btnLimpiarEnc.setBounds(602, 276, 118, 23);
		Encuadrado.add(btnLimpiarEnc);

		//-->> PANEL DE LA TABLA ENCUADRADO
		JPanel pnlTablaEncuadrado = new JPanel();
		pnlTablaEncuadrado.setBounds(10, 326, 730, 149);
		Encuadrado.add(pnlTablaEncuadrado);
		pnlTablaEncuadrado.setLayout(null);

			JScrollPane spTablaEncuadrado = new JScrollPane();
			spTablaEncuadrado.setBounds(0, 0, 730, 149);
			pnlTablaEncuadrado.add(spTablaEncuadrado);
	
			tablaEncuadrado = new JTable();
			tablaEncuadrado.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
			spTablaEncuadrado.setViewportView(tablaEncuadrado);
			
//-->> INICIO DE PANEL RESERVA
		JPanel Reserva = new JPanel();
		tabbedPane.addTab("Reserva", null, Reserva, null);
		Reserva.setLayout(null);
		
		JLabel lblMatriculaRes = new JLabel("MATRICULA");
		lblMatriculaRes.setHorizontalAlignment(SwingConstants.CENTER);
		lblMatriculaRes.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		lblMatriculaRes.setBounds(42, 11, 69, 14);
		Reserva.add(lblMatriculaRes);
		
		JLabel lblNombreRes = new JLabel("NOMBRE");
		lblNombreRes.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombreRes.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		lblNombreRes.setBounds(168, 11, 55, 14);
		Reserva.add(lblNombreRes);
		
		JLabel lblApPaternoRes = new JLabel("A. PATERNO");
		lblApPaternoRes.setHorizontalAlignment(SwingConstants.CENTER);
		lblApPaternoRes.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		lblApPaternoRes.setBounds(276, 11, 77, 14);
		Reserva.add(lblApPaternoRes);
		
		JLabel lblApMaternoRes = new JLabel("A. MATERNO");
		lblApMaternoRes.setHorizontalAlignment(SwingConstants.CENTER);
		lblApMaternoRes.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		lblApMaternoRes.setBounds(395, 11, 77, 14);
		Reserva.add(lblApMaternoRes);
		
		JLabel lblCurpRes = new JLabel("CURP");
		lblCurpRes.setHorizontalAlignment(SwingConstants.CENTER);
		lblCurpRes.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		lblCurpRes.setBounds(536, 11, 33, 14);
		Reserva.add(lblCurpRes);
		
		JLabel lblEdadRes = new JLabel("EDAD");
		lblEdadRes.setHorizontalAlignment(SwingConstants.CENTER);
		lblEdadRes.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		lblEdadRes.setBounds(655, 11, 33, 14);
		Reserva.add(lblEdadRes);
		
		JLabel lblProfesion = new JLabel("PROFESI\u00D3N");
		lblProfesion.setHorizontalAlignment(SwingConstants.CENTER);
		lblProfesion.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		lblProfesion.setBounds(43, 95, 69, 14);
		Reserva.add(lblProfesion);
		
		JLabel lblCiudad = new JLabel("CIUDAD");
		lblCiudad.setHorizontalAlignment(SwingConstants.CENTER);
		lblCiudad.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		lblCiudad.setBounds(415, 95, 45, 14);
		Reserva.add(lblCiudad);
		
		JLabel lblColonia = new JLabel("COLONIA");
		lblColonia.setHorizontalAlignment(SwingConstants.CENTER);
		lblColonia.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		lblColonia.setBounds(530, 95, 55, 14);
		Reserva.add(lblColonia);
		
		JLabel lblCalle = new JLabel("CALLE");
		lblCalle.setHorizontalAlignment(SwingConstants.CENTER);
		lblCalle.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		lblCalle.setBounds(658, 95, 39, 14);
		Reserva.add(lblCalle);
		
		JLabel lblNumInterior = new JLabel("NUM INT");
		lblNumInterior.setHorizontalAlignment(SwingConstants.CENTER);
		lblNumInterior.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		lblNumInterior.setBounds(289, 95, 56, 14);
		Reserva.add(lblNumInterior);
		
		JLabel lblNumExterior = new JLabel("NUM EXT");
		lblNumExterior.setHorizontalAlignment(SwingConstants.CENTER);
		lblNumExterior.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		lblNumExterior.setBounds(167, 95, 61, 14);
		Reserva.add(lblNumExterior);
		
		JLabel lblSexo = new JLabel("SEXO");
		lblSexo.setHorizontalAlignment(SwingConstants.CENTER);
		lblSexo.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		lblSexo.setBounds(80, 177, 33, 14);
		Reserva.add(lblSexo);
		
		JLabel lblECivil = new JLabel("E. CIVIL");
		lblECivil.setHorizontalAlignment(SwingConstants.CENTER);
		lblECivil.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		lblECivil.setBounds(210, 177, 51, 14);
		Reserva.add(lblECivil);
		
		JLabel lblDiscapacidad_1 = new JLabel("DISCAPACIDAD");
		lblDiscapacidad_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblDiscapacidad_1.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		lblDiscapacidad_1.setBounds(328, 177, 93, 14);
		Reserva.add(lblDiscapacidad_1);
		
		JLabel lblClase = new JLabel("CLASE");
		lblClase.setHorizontalAlignment(SwingConstants.CENTER);
		lblClase.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		lblClase.setBounds(494, 177, 39, 14);
		Reserva.add(lblClase);
		
		JLabel lblTelefono = new JLabel("TELEFONO");
		lblTelefono.setHorizontalAlignment(SwingConstants.CENTER);
		lblTelefono.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		lblTelefono.setBounds(618, 177, 69, 14);
		Reserva.add(lblTelefono);
		
		etMatriculaRes = new JTextField();
		etMatriculaRes.setBounds(33, 36, 86, 20);
		Reserva.add(etMatriculaRes);
		etMatriculaRes.setColumns(10);
		
		etNombreRes = new JTextField();
		etNombreRes.setBounds(152, 36, 86, 20);
		Reserva.add(etNombreRes);
		etNombreRes.setColumns(10);
		
		etAPaternoRes = new JTextField();
		etAPaternoRes.setBounds(271, 36, 86, 20);
		Reserva.add(etAPaternoRes);
		etAPaternoRes.setColumns(10);
		
		etAMaternoRes = new JTextField();
		etAMaternoRes.setBounds(390, 36, 86, 20);
		Reserva.add(etAMaternoRes);
		etAMaternoRes.setColumns(10);
		
		etCurpRes = new JTextField();
		etCurpRes.setBounds(509, 36, 86, 20);
		Reserva.add(etCurpRes);
		etCurpRes.setColumns(10);
		
		etEdadRes = new JTextField();
		etEdadRes.setBounds(628, 36, 86, 20);
		Reserva.add(etEdadRes);
		etEdadRes.setColumns(10);
		
		etProfesionRes = new JTextField();
		etProfesionRes.setBounds(34, 120, 86, 20);
		Reserva.add(etProfesionRes);
		etProfesionRes.setColumns(10);
		
		etCiudadRes = new JTextField();
		etCiudadRes.setBounds(394, 120, 86, 20);
		Reserva.add(etCiudadRes);
		etCiudadRes.setColumns(10);
		
		etColoniaRes = new JTextField();
		etColoniaRes.setBounds(514, 120, 86, 20);
		Reserva.add(etColoniaRes);
		etColoniaRes.setColumns(10);
		
		etCalleRes = new JTextField();
		etCalleRes.setBounds(634, 120, 86, 20);
		Reserva.add(etCalleRes);
		etCalleRes.setColumns(10);
		
		etNumIntRes = new JTextField();
		etNumIntRes.setBounds(274, 120, 86, 20);
		Reserva.add(etNumIntRes);
		etNumIntRes.setColumns(10);
		
		etNumExtRes = new JTextField();
		etNumExtRes.setBounds(154, 120, 86, 20);
		Reserva.add(etNumExtRes);
		etNumExtRes.setColumns(10);
		
		etSexoRes = new JTextField();
		etSexoRes.setBounds(53, 202, 86, 20);
		Reserva.add(etSexoRes);
		etSexoRes.setColumns(10);
		
		etECivilRes = new JTextField();
		etECivilRes.setBounds(192, 202, 86, 20);
		Reserva.add(etECivilRes);
		etECivilRes.setColumns(10);
		
		etDiscapacidadRes = new JTextField();
		etDiscapacidadRes.setBounds(331, 202, 86, 20);
		Reserva.add(etDiscapacidadRes);
		etDiscapacidadRes.setColumns(10);
		
		etClaseRes = new JTextField();
		etClaseRes.setBounds(470, 202, 86, 20);
		Reserva.add(etClaseRes);
		etClaseRes.setColumns(10);
		
		etTelefonoRes = new JTextField();
		etTelefonoRes.setBounds(609, 202, 86, 20);
		Reserva.add(etTelefonoRes);
		etTelefonoRes.setColumns(10);
		
		JButton btnAgregarRes = new JButton("AGREGAR");
		btnAgregarRes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				objRQ.ingresar_reserva(etMatriculaRes.getText(), etNombreRes.getText(), etAPaternoRes.getText(), etAMaternoRes.getText(), etCurpRes.getText(), etEdadRes.getText(), etProfesionRes.getText(), etNumExtRes.getText(), etNumIntRes.getText(), etCalleRes.getText(), etColoniaRes.getText(), etCiudadRes.getText(), etSexoRes.getText(), etECivilRes.getText(), etDiscapacidadRes.getText(), etClaseRes.getText(), etTelefonoRes.getText());
				
				DefaultTableModel modelo = objRQ.mostrarRegistrosRes("SELECT * FROM reserva");
				tablaReserva.setModel(modelo);
				
			}
		});
		btnAgregarRes.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		btnAgregarRes.setBounds(37, 254, 105, 23);
		Reserva.add(btnAgregarRes);
		
		JButton btnEliminarRes = new JButton("ELIMINAR");
		btnEliminarRes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				objRQ.eliminar_reserva(etMatriculaRes.getText());
							
				DefaultTableModel modelo = objRQ.mostrarRegistrosRes("SELECT * FROM reserva");
				tablaReserva.setModel(modelo);
				
			}
		});
		btnEliminarRes.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		btnEliminarRes.setBounds(179, 254, 105, 23);
		Reserva.add(btnEliminarRes);
		
		JButton btnModificarRes = new JButton("MODIFICAR");
		btnModificarRes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				objRQ.modificar_reserva(etMatriculaRes.getText(), etNombreRes.getText(), etAPaternoRes.getText(), etAMaternoRes.getText(), etCurpRes.getText(), etEdadRes.getText(), etProfesionRes.getText(), etNumExtRes.getText(), etNumIntRes.getText(), etCalleRes.getText(), etColoniaRes.getText(), etCiudadRes.getText(), etSexoRes.getText(), etECivilRes.getText(), etDiscapacidadRes.getText(), etClaseRes.getText(), etTelefonoRes.getText());
				
				DefaultTableModel modelo = objRQ.mostrarRegistrosRes("SELECT * FROM reserva");
				tablaReserva.setModel(modelo);
				
			}
		});
		btnModificarRes.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		btnModificarRes.setBounds(321, 254, 105, 23);
		Reserva.add(btnModificarRes);
		
		JButton btnConsultarRes = new JButton("CONSULTAR");
		btnConsultarRes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String query="";

				if ((etMatriculaRes.getText()).equals(""))
					query = "SELECT * FROM reserva";
				else
					query = "SELECT * FROM reserva WHERE Matricula_Res = '"+etMatriculaRes.getText()+"'";
				
				DefaultTableModel modelo = objRQ.mostrarRegistrosRes(query);
				tablaReserva.setModel(modelo);
				
			}
		});
		btnConsultarRes.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		btnConsultarRes.setBounds(463, 254, 105, 23);
		Reserva.add(btnConsultarRes);
		
		JButton btnLimpiarRes = new JButton("LIMPIAR");
		btnLimpiarRes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				DefaultTableModel modelo = objRQ.mostrarRegistrosRes("SELECT * FROM reserva");
				tablaReserva.setModel(modelo);
				
				limpiarEntradas();
				
			}
		});
		btnLimpiarRes.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		btnLimpiarRes.setBounds(605, 254, 105, 23);
		Reserva.add(btnLimpiarRes);
		
		//-->> INICIO DEL PANEL CONTENEDOR DE LA TABLA RESERVA
		JPanel pnlTablaReserva = new JPanel();
		pnlTablaReserva.setBounds(10, 298, 730, 177);
		Reserva.add(pnlTablaReserva);
		pnlTablaReserva.setLayout(null);
		
			JScrollPane spTablaReserva = new JScrollPane();
			spTablaReserva.setBounds(0, 0, 730, 177);
			pnlTablaReserva.add(spTablaReserva);
			
			tablaReserva = new JTable();
			tablaReserva.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
			spTablaReserva.setViewportView(tablaReserva);
		
//-->> INICIO DE PANEL PARTICIPA_ENC
		JPanel ParticipaEnc = new JPanel();
		tabbedPane.addTab("Participa_Enc", null, ParticipaEnc, null);
		ParticipaEnc.setLayout(null);
		
		JLabel lblMatriculaEncPart = new JLabel("MATRICULA ENC");
		lblMatriculaEncPart.setHorizontalAlignment(SwingConstants.CENTER);
		lblMatriculaEncPart.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		lblMatriculaEncPart.setBounds(114, 64, 105, 14);
		ParticipaEnc.add(lblMatriculaEncPart);
		
		JLabel lblEdSorteoPartEnc = new JLabel("ED SORTEO");
		lblEdSorteoPartEnc.setHorizontalAlignment(SwingConstants.CENTER);
		lblEdSorteoPartEnc.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		lblEdSorteoPartEnc.setBounds(341, 64, 68, 14);
		ParticipaEnc.add(lblEdSorteoPartEnc);
		
		JLabel lblResPartEnc = new JLabel("RESULTADO");
		lblResPartEnc.setHorizontalAlignment(SwingConstants.CENTER);
		lblResPartEnc.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		lblResPartEnc.setBounds(546, 64, 77, 14);
		ParticipaEnc.add(lblResPartEnc);
		
		etMatriculaEncPart = new JTextField();
		etMatriculaEncPart.setBounds(123, 89, 86, 20);
		ParticipaEnc.add(etMatriculaEncPart);
		etMatriculaEncPart.setColumns(10);
		
		etEdSorteoPartEnc = new JTextField();
		etEdSorteoPartEnc.setBounds(332, 89, 86, 20);
		ParticipaEnc.add(etEdSorteoPartEnc);
		etEdSorteoPartEnc.setColumns(10);
		
		etResPartEnc = new JTextField();
		etResPartEnc.setBounds(541, 89, 86, 20);
		ParticipaEnc.add(etResPartEnc);
		etResPartEnc.setColumns(10);
		
		JButton btnAgregarPEnc = new JButton("AGREGAR");
		btnAgregarPEnc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				objPEQ.ingreso_reg(etEdSorteoPartEnc.getText(), etMatriculaEncPart.getText(), etResPartEnc.getText());
				
				DefaultTableModel modelo = objPEQ.mostrarRegistrosPartEnc("SELECT * FROM participa_enc");
				tablaPartEnc.setModel(modelo);
				
			}
		});
		btnAgregarPEnc.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		btnAgregarPEnc.setBounds(37, 194, 105, 23);
		ParticipaEnc.add(btnAgregarPEnc);
		
		JButton btnEliminarPEnc = new JButton("ELIMINAR");
		btnEliminarPEnc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				objPEQ.eliminar_reg(etMatriculaEncPart.getText());
				
				DefaultTableModel modelo = objPEQ.mostrarRegistrosPartEnc("SELECT * FROM participa_enc");
				tablaPartEnc.setModel(modelo);
				
			}
		});
		btnEliminarPEnc.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		btnEliminarPEnc.setBounds(179, 194, 105, 23);
		ParticipaEnc.add(btnEliminarPEnc);
		
		JButton btnModificarPEnc = new JButton("MODIFICAR");
		btnModificarPEnc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				objPEQ.modificar_reg(etEdSorteoPartEnc.getText(), etMatriculaEncPart.getText(), etResPartEnc.getText());
				
				DefaultTableModel modelo = objPEQ.mostrarRegistrosPartEnc("SELECT * FROM participa_enc");
				tablaPartEnc.setModel(modelo);
				
			}
		});
		btnModificarPEnc.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		btnModificarPEnc.setBounds(321, 194, 105, 23);
		ParticipaEnc.add(btnModificarPEnc);
		
		JButton btnConsultarPEnc = new JButton("CONSULTAR");
		btnConsultarPEnc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String query="";

				if ((etMatriculaEncPart.getText()).equals(""))
					query = "SELECT * FROM participa_enc";
				else
					query = "SELECT * FROM participa_enc WHERE Matricula_Enc = '"+etMatriculaEncPart.getText()+"'";
				
				DefaultTableModel modelo = objPEQ.mostrarRegistrosPartEnc(query);
				tablaPartEnc.setModel(modelo);
				
			}
		});
		btnConsultarPEnc.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		btnConsultarPEnc.setBounds(463, 194, 105, 23);
		ParticipaEnc.add(btnConsultarPEnc);
		
		JButton btnLimpiarPEnc = new JButton("LIMPIAR");
		btnLimpiarPEnc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				DefaultTableModel modelo = objPEQ.mostrarRegistrosPartEnc("SELECT * FROM participa_enc");
				tablaPartEnc.setModel(modelo);
				
				limpiarEntradas();
				
			}
		});
		btnLimpiarPEnc.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		btnLimpiarPEnc.setBounds(605, 194, 105, 23);
		ParticipaEnc.add(btnLimpiarPEnc);
		
		//-->> PANEL DE LA TABLA PARTICIPA_ENC
		JPanel pnlTablaPartEnc = new JPanel();
		pnlTablaPartEnc.setBounds(234, 253, 282, 222);
		ParticipaEnc.add(pnlTablaPartEnc);
		pnlTablaPartEnc.setLayout(null);
		
			JScrollPane spTablaPartEnc = new JScrollPane();
			spTablaPartEnc.setBounds(0, 0, 282, 222);
			pnlTablaPartEnc.add(spTablaPartEnc);
			
			tablaPartEnc = new JTable();
			spTablaPartEnc.setViewportView(tablaPartEnc);
			//-------------------------ASPIRANTE------------------------//
			JPanel Aspirante = new JPanel();
			tabbedPane.addTab("Aspirante", null, Aspirante, null);
			Aspirante.setLayout(null);
			
			TxtNombreAspirante = new JTextField();
			TxtNombreAspirante.setBounds(10, 47, 86, 20);
			Aspirante.add(TxtNombreAspirante);
			TxtNombreAspirante.setColumns(10);
			
			JLabel lblNombreAspirante = new JLabel("NOMBRE");
			lblNombreAspirante.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
			lblNombreAspirante.setBounds(10, 22, 86, 14);
			Aspirante.add(lblNombreAspirante);
			
			JLabel lblApellidoPatAspirante = new JLabel("APELLIDO PAT");
			lblApellidoPatAspirante.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
			lblApellidoPatAspirante.setBounds(119, 22, 106, 14);
			Aspirante.add(lblApellidoPatAspirante);
			
			txtApellidoPatAspirante = new JTextField();
			txtApellidoPatAspirante.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
			txtApellidoPatAspirante.setBounds(119, 46, 86, 20);
			Aspirante.add(txtApellidoPatAspirante);
			txtApellidoPatAspirante.setColumns(10);
			
			JLabel lblApellidoMatAspirante = new JLabel("APELLIDO MAT");
			lblApellidoMatAspirante.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
			lblApellidoMatAspirante.setBounds(227, 22, 106, 14);
			Aspirante.add(lblApellidoMatAspirante);
			
			txtApellidoMatAspirante = new JTextField();
			txtApellidoMatAspirante.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
			txtApellidoMatAspirante.setColumns(10);
			txtApellidoMatAspirante.setBounds(227, 46, 86, 20);
			Aspirante.add(txtApellidoMatAspirante);
			
			JLabel lblCurpAspirante = new JLabel("CURP\r\n");
			lblCurpAspirante.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
			lblCurpAspirante.setBounds(334, 22, 46, 14);
			Aspirante.add(lblCurpAspirante);
			
			txtCurpAspirante = new JTextField();
			txtCurpAspirante.setBounds(334, 46, 86, 20);
			Aspirante.add(txtCurpAspirante);
			txtCurpAspirante.setColumns(10);
			
			JLabel lblEdadAspirante = new JLabel("EDAD");
			lblEdadAspirante.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
			lblEdadAspirante.setBounds(438, 23, 46, 14);
			Aspirante.add(lblEdadAspirante);
			
			txtEdadAspirante = new JTextField();
			txtEdadAspirante.setBounds(438, 47, 86, 20);
			Aspirante.add(txtEdadAspirante);
			txtEdadAspirante.setColumns(10);
			
			JLabel lblCalleAspirante = new JLabel("CALLE");
			lblCalleAspirante.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
			lblCalleAspirante.setBounds(542, 22, 46, 14);
			Aspirante.add(lblCalleAspirante);
			
			txtCalleAspirante = new JTextField();
			txtCalleAspirante.setColumns(10);
			txtCalleAspirante.setBounds(542, 46, 86, 20);
			Aspirante.add(txtCalleAspirante);
			
			JLabel lblNumExteriorAspirante = new JLabel("NUM EXT");
			lblNumExteriorAspirante.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
			lblNumExteriorAspirante.setBounds(10, 104, 86, 14);
			Aspirante.add(lblNumExteriorAspirante);
			
			txtNumExteriorAspirante = new JTextField();
			txtNumExteriorAspirante.setColumns(10);
			txtNumExteriorAspirante.setBounds(10, 124, 86, 20);
			Aspirante.add(txtNumExteriorAspirante);
			
			JLabel lblNumInteriorAspirante = new JLabel("NUM INT");
			lblNumInteriorAspirante.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
			lblNumInteriorAspirante.setBounds(119, 104, 61, 14);
			Aspirante.add(lblNumInteriorAspirante);
			
			txtNumInteriorAspirante = new JTextField();
			txtNumInteriorAspirante.setColumns(10);
			txtNumInteriorAspirante.setBounds(119, 124, 86, 20);
			Aspirante.add(txtNumInteriorAspirante);
			
			JLabel lblColoniaAspirante = new JLabel("COLONIA\r\n");
			lblColoniaAspirante.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
			lblColoniaAspirante.setBounds(227, 104, 61, 14);
			Aspirante.add(lblColoniaAspirante);
			
			txtColoniaAspirante = new JTextField();
			txtColoniaAspirante.setColumns(10);
			txtColoniaAspirante.setBounds(227, 124, 86, 20);
			Aspirante.add(txtColoniaAspirante);
			
			JLabel lblCiudadAspirante = new JLabel("CIUDAD\r\n");
			lblCiudadAspirante.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
			lblCiudadAspirante.setBounds(334, 104, 46, 14);
			Aspirante.add(lblCiudadAspirante);
			
			txtCiudadAspirante = new JTextField();
			txtCiudadAspirante.setColumns(10);
			txtCiudadAspirante.setBounds(334, 124, 86, 20);
			Aspirante.add(txtCiudadAspirante);
			
			JLabel lblClaseAspirante = new JLabel("CLASE");
			lblClaseAspirante.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
			lblClaseAspirante.setBounds(438, 104, 61, 14);
			Aspirante.add(lblClaseAspirante);
			
			txtClaseAspirante = new JTextField();
			txtClaseAspirante.setColumns(10);
			txtClaseAspirante.setBounds(438, 124, 86, 20);
			Aspirante.add(txtClaseAspirante);
			
			JLabel lblEstadoCivilAspirante = new JLabel("ESTADO CIVIL");
			lblEstadoCivilAspirante.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
			lblEstadoCivilAspirante.setBounds(542, 104, 86, 14);
			Aspirante.add(lblEstadoCivilAspirante);
			
			txtEstadoCivilAspirante = new JTextField();
			txtEstadoCivilAspirante.setColumns(10);
			txtEstadoCivilAspirante.setBounds(542, 124, 86, 20);
			Aspirante.add(txtEstadoCivilAspirante);
			
			JLabel lblProfesionAspirante = new JLabel("PROFESION");
			lblProfesionAspirante.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
			lblProfesionAspirante.setBounds(10, 172, 86, 14);
			Aspirante.add(lblProfesionAspirante);
			
			txtProfesionAspirante = new JTextField();
			txtProfesionAspirante.setColumns(10);
			txtProfesionAspirante.setBounds(10, 197, 86, 20);
			Aspirante.add(txtProfesionAspirante);
			
			JLabel lblSexoAspirante = new JLabel("SEXO");
			lblSexoAspirante.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
			lblSexoAspirante.setBounds(119, 172, 46, 14);
			Aspirante.add(lblSexoAspirante);
			
			txtSexoAspirante = new JTextField();
			txtSexoAspirante.setColumns(10);
			txtSexoAspirante.setBounds(119, 197, 86, 20);
			Aspirante.add(txtSexoAspirante);
			
			JLabel lblDiscapacidadAspirante = new JLabel("DISCAPACIDAD");
			lblDiscapacidadAspirante.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
			lblDiscapacidadAspirante.setBounds(227, 172, 106, 14);
			Aspirante.add(lblDiscapacidadAspirante);
			
			textField = new JTextField();
			textField.setColumns(10);
			textField.setBounds(227, 197, 86, 20);
			Aspirante.add(textField);
			
			JButton btnAgregarAspirante = new JButton("AGREGAR");
			btnAgregarAspirante.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					String query="";

					
						query = "CALL sorteo(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
					
					
					DefaultTableModel modeloEnc = objEnc.mostrarRegistrosEnc(query);
					tablaEncuadrado.setModel(modeloEnc);
				}
			});
			btnAgregarAspirante.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
			btnAgregarAspirante.setBounds(326, 257, 105, 23);
			Aspirante.add(btnAgregarAspirante);
			
			JPanel pnlTablaAspirante = new JPanel();
			pnlTablaAspirante.setBounds(35, 283, 687, 173);
			Aspirante.add(pnlTablaAspirante);
			pnlTablaAspirante.setLayout(null);
			
			JScrollPane spTablaAspirante = new JScrollPane();
			spTablaAspirante.setBounds(10, 11, 667, 151);
			pnlTablaAspirante.add(spTablaAspirante);
			
			tablaAspirantes = new JTable();
			spTablaAspirante.add(tablaAspirantes);
		
		/*		
				
				JPanel pnlTablaPartEnc = new JPanel();
		pnlTablaPartEnc.setBounds(234, 253, 282, 222);
		ParticipaEnc.add(pnlTablaPartEnc);
		pnlTablaPartEnc.setLayout(null);
		
			JScrollPane spTablaPartEnc = new JScrollPane();
			spTablaPartEnc.setBounds(0, 0, 282, 222);
			pnlTablaPartEnc.add(spTablaPartEnc);
			
			tablaPartEnc = new JTable();
			spTablaPartEnc.setViewportView(tablaPartEnc);
				*/
			
			
	}
}
