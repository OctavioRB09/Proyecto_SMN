package Ventanas_M;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import Conexion.*;
import Consultas.*;

import java.awt.Font;
import javax.swing.JLabel;

@SuppressWarnings({ "unused", "serial" })
public class Formulario extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	
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
	ConexionBD conexion = new ConexionBD();
	PreparedStatement ps = null;
	ResultSet rs = null;
	Connection cn = null;
	Statement stm = null; 
	
	//Instructor
	
	private JTextField txtNum;
	private JTextField txtNumP;
	private JTextField txtNomI;
	private JTextField txtAP;
	private JTextField txtAM;
	private JTextField txtSueldo;
	private JTable table;
	private JTextField txtR;
	
	//Institución
	
	private JTextField txtIdI;
	private JTextField txtNI;
	private JTextField txtCI;
	private JTextField txtNEI;
	private JTextField txtNII;
	private JTextField txtNCI;
	private JTextField txtMI;
	private JTable table_1;
	
	//Actividad
	
	private JTextField txtNPA;
	private JTextField txtMEA;
	private JTextField txtNSA;
	private JTextField txtIIA;
	private JTextField txtHIA;
	private JTextField txtHFA;
	private JTextField txtFA;
	private JTextField txtTAA;
	private JTextField txtCAA;
	private JTable table_2;
	
	//NumTel_Institucion
	
	private JTextField txtIINT;
	private JTextField txtNTNT;
	private JTable table_3;
	private JTextField txtNTMNT;
	
	//Escuadron
	
	private JTextField txtNSE;
	private JTextField txtNIE;
	private JTable table_4;
	
	//Participa_Res
	
	private JTextField txtMRPR;
	private JTextField txtEDPR;
	private JTextField txtRPR;
	private JTable table_5;
	private JTextField etMatReserva;
	private JTextField etNumLiberacion;
	private JTextField etPrecioCart;
	private JTextField etMesRecepcion;
	private JTable tablaObtiene;
	private JTextField etsorteo;
	private JTextField etfechas;
	private JTextField etNumplaca;
	private JTextField etMatenc;
	private JTextField etNumlib;
	private JTextField etHoras;
	private JTextField etPreciocart;
	private JTable tablaValida;
	
	//cartilla
	private JTextField txtNum_LiberacionCartilla;
	private JTextField txtZona_Militar;
	private JTextField txtRegimiento;
	private JTable table_6;
	
	//Encuadrado
	private JTextField Txtnombre;
	private JTextField TxtApaterno;
	private JTextField TxtAmaterno;
	private JTextField TxtCurp;
	private JTextField TxtProfesion;
	private JTextField TxtCalle;
	private JTextField TxtColonia;
	private JTextField TxtNumInterior;
	private JTextField TxtNumExterior;
	private JTextField TxtCiudad;
	private JTextField TxtDiscapacidad;
	private JTextField TxtClase;
	private JTextField TxtHabilidad;
	private JTextField TxtPeso;
	private JTextField TxtAltura;
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
	private JTextField txtEstadoCivilEnc;
	private JTextField txtClaseEnc;
	private JTextField txtHabilidadEnc;
	private JTextField txtPesoEnc;
	private JTextField txtAlturaEnc;
	private JTextField txtSexoEnc;
	private JTextField txtEdadEnc;
	private JTextField txtNumCelularEnc;
	private JTextField txtMatriculaEnc;
	private JTextField txtEstadoCivil;
	private JTextField txtTipoSangreEnc;
	private JTable tablasorteo;

	
	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try 
				{
					Formulario frame = new Formulario();
					frame.setVisible(true);
				} 
				catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	
	public void limpiarEntradas()
	{
		txtNumP.setText(null);
		txtNomI.setText(null);
		txtAP.setText(null);
		txtAM.setText(null);
		txtR.setText(null);
		txtSueldo.setText(null);
		
		txtIdI.setText(null);
		txtNI.setText(null);
		txtCI.setText(null);
		txtNEI.setText(null);
		txtNII.setText(null);
		txtNCI.setText(null);
		txtMI.setText(null);
		
		txtNPA.setText(null);
		txtMEA.setText(null);
		txtNSA.setText(null);
		txtIIA.setText(null);
		txtHIA.setText(null);
		txtHFA.setText(null);
		txtFA.setText(null);
		txtTAA.setText(null);
		txtCAA.setText(null);
		
		txtIINT.setText(null);
		txtNTNT.setText(null);
		
		txtNSE.setText(null);
		txtNIE.setText(null);
		
		txtMRPR.setText(null);
		txtEDPR.setText(null);
		txtRPR.setText(null);
		
		txtNum_LiberacionCartilla.setText(null);
		txtZona_Militar.setText(null);
		txtRegimiento.setText(null);
	}
	
	@SuppressWarnings("static-access")
	public Formulario() 
	{
		cn = conexion.conectar();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 678, 467);
		setLocationRelativeTo(null);
		setResizable(false);
		setTitle(conexion.user);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 598, 392);
		getContentPane().add(tabbedPane);
		
//-->> INICIO DEL PANEL DE INSTRUCTOR		
		
		JPanel Instructor = new JPanel();
		Instructor.setBackground(SystemColor.menu);
		Instructor.setToolTipText("");
		Instructor.setLayout(null);
		tabbedPane.addTab("Instructor", null, Instructor, null);
		
		JTextPane txtpnMatricula = new JTextPane();
		txtpnMatricula.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		txtpnMatricula.setText("NUMERO DE PLACA:");
		txtpnMatricula.setForeground(Color.BLACK);
		txtpnMatricula.setEditable(false);
		txtpnMatricula.setBackground(SystemColor.menu);
		txtpnMatricula.setBounds(10, 11, 123, 20);
		Instructor.add(txtpnMatricula);
		
		txtNumP = new JTextField();
		txtNumP.setColumns(10);
		txtNumP.setBounds(167, 11, 86, 20);
		Instructor.add(txtNumP);
		
		JTextPane txtpnNombre = new JTextPane();
		txtpnNombre.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		txtpnNombre.setText("NOMBRE INSTRUCTOR:");
		txtpnNombre.setEditable(false);
		txtpnNombre.setBackground(SystemColor.menu);
		txtpnNombre.setBounds(10, 42, 144, 20);
		Instructor.add(txtpnNombre);
		
		txtNomI = new JTextField();
		txtNomI.setColumns(10);
		txtNomI.setBounds(167, 42, 86, 20);
		Instructor.add(txtNomI);
		
		JTextPane txtpnNombre_1 = new JTextPane();
		txtpnNombre_1.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		txtpnNombre_1.setText("APELLIDO PATERNO:");
		txtpnNombre_1.setEditable(false);
		txtpnNombre_1.setBackground(SystemColor.menu);
		txtpnNombre_1.setBounds(10, 73, 127, 20);
		Instructor.add(txtpnNombre_1);
		
		JTextPane txtpnNombre_2 = new JTextPane();
		txtpnNombre_2.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		txtpnNombre_2.setText("APELLIDO MATERNO:");
		txtpnNombre_2.setEditable(false);
		txtpnNombre_2.setBackground(SystemColor.menu);
		txtpnNombre_2.setBounds(10, 104, 132, 20);
		Instructor.add(txtpnNombre_2);
		
		JTextPane txtpnNombre_3 = new JTextPane();
		txtpnNombre_3.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		txtpnNombre_3.setText("RANGO:");
		txtpnNombre_3.setEditable(false);
		txtpnNombre_3.setBackground(SystemColor.menu);
		txtpnNombre_3.setBounds(10, 135, 95, 20);
		Instructor.add(txtpnNombre_3);
		
		txtAP = new JTextField();
		txtAP.setColumns(10);
		txtAP.setBounds(167, 73, 86, 20);
		Instructor.add(txtAP);
		
		txtAM = new JTextField();
		txtAM.setColumns(10);
		txtAM.setBounds(167, 104, 86, 20);
		Instructor.add(txtAM);
		
		txtSueldo = new JTextField();
		txtSueldo.setColumns(10);
		txtSueldo.setBounds(167, 166, 86, 20);
		Instructor.add(txtSueldo);
		
		JTextPane txtpnNombre_3_1 = new JTextPane();
		txtpnNombre_3_1.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		txtpnNombre_3_1.setText("SUELDO:");
		txtpnNombre_3_1.setEditable(false);
		txtpnNombre_3_1.setBackground(SystemColor.menu);
		txtpnNombre_3_1.setBounds(10, 166, 95, 20);
		Instructor.add(txtpnNombre_3_1);
		
		JButton bAgregar = new JButton("AGREGAR");
		bAgregar.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		bAgregar.addActionListener((ActionListener) new ActionListener()
		{
			public void actionPerformed(ActionEvent Arg0)
			{
				try
				{
					objIns.ingresar_instructor(txtNumP.getText(), txtNomI.getText(), txtAP.getText(), txtAM.getText(), txtR.getText(), txtSueldo.getText());
					limpiarEntradas();
				}
				catch(IOException e1)
				{
					e1.printStackTrace();
				}
				DefaultTableModel modeloIns = objIns.mostrarRegistrosIns("SELECT * FROM instructor");
				table.setModel(modeloIns);
			}
		});
		bAgregar.setBounds(462, 11, 111, 23);
		Instructor.add(bAgregar);
		
		JButton bModificar = new JButton("MODIFICAR");
		bModificar.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		bModificar.addActionListener((ActionListener) new ActionListener()
		{
			public void actionPerformed(ActionEvent Arg0)
			{
				//conexion = Conexion.conectar(1);
				try
				{
					objIns.modificar_instructor(txtNumP.getText(), txtNomI.getText(), txtAP.getText(), txtAM.getText(), txtR.getText(), txtSueldo.getText());
					limpiarEntradas();
				}
				catch(IOException e)
				{
					e.printStackTrace();
				}
				DefaultTableModel modeloIns = objIns.mostrarRegistrosIns("SELECT * FROM instructor");
				table.setModel(modeloIns);
			}
		});
		bModificar.setBounds(462, 73, 111, 23);
		Instructor.add(bModificar);
		
		JButton bEliminar = new JButton("ELIMINAR");
		bEliminar.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		bEliminar.addActionListener((ActionListener) new ActionListener()
		{
			public void actionPerformed(ActionEvent Arg0)
			{
				//conexion = Conexion.conectar();
				try
				{
					objIns.eliminar_instructor(txtNumP.getText());
					limpiarEntradas();
				}
				catch(IOException e)
				{
					e.printStackTrace();
				}
				DefaultTableModel modeloIns = objIns.mostrarRegistrosIns("SELECT * FROM instructor");
				table.setModel(modeloIns);
			}
		});
		bEliminar.setBounds(462, 42, 111, 23);
		Instructor.add(bEliminar);
		
		JButton bBuscar = new JButton("CONSULTAR");
		bBuscar.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		bBuscar.addActionListener((ActionListener) new ActionListener()
		{
			public void actionPerformed(ActionEvent Arg0)
			{
				DefaultTableModel modeloIns = objIns.mostrarRegistrosIns("SELECT * FROM instructor");
				table.setModel(modeloIns);
			}
		});
		bBuscar.setBounds(462, 104, 111, 23);
		Instructor.add(bBuscar);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 231, 573, 142);
		Instructor.add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 573, 142);
		panel.add(scrollPane);
		
		table = new JTable();
		table.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
		scrollPane.setViewportView(table);
		
		JButton bMostrarDatos = new JButton("LIMPIAR");
		bMostrarDatos.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		bMostrarDatos.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				limpiarEntradas();
			}
		});
		bMostrarDatos.setBounds(462, 164, 111, 23);
		Instructor.add(bMostrarDatos);
		
		txtR = new JTextField();
		txtR.setBounds(167, 135, 86, 20);
		Instructor.add(txtR);
		txtR.setColumns(10);
		
//-->> INICIO DEL PANEL DE INSTITUCION
		
		JPanel Institucion = new JPanel();
		tabbedPane.addTab("Instituci\u00F3n", null, Institucion, null);
		Institucion.setLayout(null);
		
		JTextPane txtpnIdintsi = new JTextPane();
		txtpnIdintsi.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		txtpnIdintsi.setText("ID INSTITUCION:");
		txtpnIdintsi.setEditable(false);
		txtpnIdintsi.setBackground(SystemColor.menu);
		txtpnIdintsi.setBounds(10, 11, 125, 20);
		Institucion.add(txtpnIdintsi);
		
		txtIdI = new JTextField();
		txtIdI.setBounds(140, 11, 86, 20);
		Institucion.add(txtIdI);
		txtIdI.setColumns(10);
		
		JTextPane txtpnNombreInsti = new JTextPane();
		txtpnNombreInsti.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		txtpnNombreInsti.setText("NOMBRE:");
		txtpnNombreInsti.setEditable(false);
		txtpnNombreInsti.setBackground(SystemColor.menu);
		txtpnNombreInsti.setBounds(10, 40, 77, 20);
		Institucion.add(txtpnNombreInsti);
		
		txtNI = new JTextField();
		txtNI.setColumns(10);
		txtNI.setBounds(140, 40, 86, 20);
		Institucion.add(txtNI);
		
		JTextPane txtpnNumExte = new JTextPane();
		txtpnNumExte.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		txtpnNumExte.setText("NUM EXTERIOR:");
		txtpnNumExte.setEditable(false);
		txtpnNumExte.setBackground(SystemColor.menu);
		txtpnNumExte.setBounds(10, 130, 104, 20);
		Institucion.add(txtpnNumExte);
		
		JTextPane txtpnNumInt = new JTextPane();
		txtpnNumInt.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		txtpnNumInt.setText("NUM INTERIOR:");
		txtpnNumInt.setEditable(false);
		txtpnNumInt.setBackground(SystemColor.menu);
		txtpnNumInt.setBounds(10, 159, 104, 20);
		Institucion.add(txtpnNumInt);
		
		JTextPane txtpnNomCalle = new JTextPane();
		txtpnNomCalle.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		txtpnNomCalle.setText("NOMBRE CALLE:");
		txtpnNomCalle.setEditable(false);
		txtpnNomCalle.setBackground(SystemColor.menu);
		txtpnNomCalle.setBounds(10, 185, 104, 20);
		Institucion.add(txtpnNomCalle);
		
		JTextPane txtpnColonia = new JTextPane();
		txtpnColonia.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		txtpnColonia.setText("COLONIA:");
		txtpnColonia.setEditable(false);
		txtpnColonia.setBackground(SystemColor.menu);
		txtpnColonia.setBounds(10, 68, 77, 20);
		Institucion.add(txtpnColonia);
		
		txtCI = new JTextField();
		txtCI.setColumns(10);
		txtCI.setBounds(140, 68, 86, 20);
		Institucion.add(txtCI);
		
		txtNEI = new JTextField();
		txtNEI.setColumns(10);
		txtNEI.setBounds(140, 130, 86, 20);
		Institucion.add(txtNEI);
		
		txtNII = new JTextField();
		txtNII.setColumns(10);
		txtNII.setBounds(140, 159, 86, 20);
		Institucion.add(txtNII);
		
		txtNCI = new JTextField();
		txtNCI.setColumns(10);
		txtNCI.setBounds(140, 188, 86, 20);
		Institucion.add(txtNCI);
		
		JTextPane txtpnMunicipio = new JTextPane();
		txtpnMunicipio.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		txtpnMunicipio.setText("MUNICIPIO:");
		txtpnMunicipio.setEditable(false);
		txtpnMunicipio.setBackground(SystemColor.menu);
		txtpnMunicipio.setBounds(10, 99, 77, 20);
		Institucion.add(txtpnMunicipio);
		
		txtMI = new JTextField();
		txtMI.setColumns(10);
		txtMI.setBounds(140, 99, 86, 20);
		Institucion.add(txtMI);
		
		JButton bAgregarI = new JButton("AGREGAR");
		bAgregarI.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		bAgregarI.addActionListener((ActionListener) new ActionListener()
		{
			public void actionPerformed(ActionEvent Arg0)
			{
				try
				{	
					objInst.ingresarInst(txtIdI.getText(), txtNI.getText(), txtNEI.getText(), txtNII.getText(), txtNCI.getText(), txtCI.getText(), txtMI.getText());
					limpiarEntradas();
				}
				catch(IOException e)
				{
					e.printStackTrace();
				}
				DefaultTableModel modeloInsti = objInst.mostrarRegistrosIns("SELECT * FROM institucion");
				table_1.setModel(modeloInsti);
			}
		});
		bAgregarI.setBounds(462, 8, 111, 23);
		Institucion.add(bAgregarI);
		
		JButton bEliminarI = new JButton("ELIMINAR");
		bEliminarI.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		bEliminarI.addActionListener((ActionListener) new ActionListener()
		{
			public void actionPerformed(ActionEvent Arg0)
			{
				try
				{
					objInst.eliminarInst(txtIdI.getText());
					limpiarEntradas();
				}
				catch(IOException e)
				{
					e.printStackTrace();
				}
				DefaultTableModel modeloInsti = objInst.mostrarRegistrosIns("SELECT * FROM institucion");
				table_1.setModel(modeloInsti);
			}
		});
		bEliminarI.setBounds(462, 37, 111, 23);
		Institucion.add(bEliminarI);
		
		JButton bModificarI = new JButton("MODIFICAR");
		bModificarI.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		bModificarI.addActionListener((ActionListener) new ActionListener()
		{
			public void actionPerformed(ActionEvent Arg0)
			{
				try
				{
					objInst.modificarInst(txtIdI.getText(), txtNI.getText(), txtNEI.getText(), txtNII.getText(), txtNCI.getText(), txtCI.getText(), txtMI.getText());
					limpiarEntradas();
				}
				catch(IOException e)
				{
					e.printStackTrace();
				}
				DefaultTableModel modeloInsti = objInst.mostrarRegistrosIns("SELECT * FROM institucion");
				table_1.setModel(modeloInsti);
			}
		});
		bModificarI.setBounds(462, 68, 111, 23);
		Institucion.add(bModificarI);
		
		JButton bBuscarI = new JButton("CONSULTAR");
		bBuscarI.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		bBuscarI.addActionListener((ActionListener) new ActionListener()
		{
			public void actionPerformed(ActionEvent Arg0)
			{
				DefaultTableModel modeloInsti = objInst.mostrarRegistrosIns("SELECT * FROM institucion");
				table_1.setModel(modeloInsti);	
			}
		});
		bBuscarI.setBounds(462, 96, 111, 23);
		Institucion.add(bBuscarI);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 219, 573, 160);
		Institucion.add(panel_1);
		panel_1.setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(0, 0, 573, 159);
		panel_1.add(scrollPane_1);
		
		table_1 = new JTable();
		scrollPane_1.setViewportView(table_1);
		
		JButton bMostrarDatosI = new JButton("LIMPAR");
		bMostrarDatosI.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		bMostrarDatosI.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				limpiarEntradas();
			}
		});
		bMostrarDatosI.setBounds(462, 127, 111, 23);
		Institucion.add(bMostrarDatosI);
	
//-->> INICIO DEL PANEL DE ACTIVIDAD
	
		JPanel Actividad = new JPanel();
		tabbedPane.addTab("Actividad", null, Actividad, null);
		Actividad.setLayout(null);
		
		JTextPane txtpnNumplaca = new JTextPane();
		txtpnNumplaca.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		txtpnNumplaca.setText("NUMERO PLACA:");
		txtpnNumplaca.setBackground(SystemColor.menu);
		txtpnNumplaca.setEditable(false);
		txtpnNumplaca.setBounds(0, 11, 112, 20);
		Actividad.add(txtpnNumplaca);
		
		txtNPA = new JTextField();
		txtNPA.setBounds(122, 11, 86, 20);
		Actividad.add(txtNPA);
		txtNPA.setColumns(10);
		
		JTextPane txtpnMatriculaenc = new JTextPane();
		txtpnMatriculaenc.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		txtpnMatriculaenc.setText("MATRICULA ENC:");
		txtpnMatriculaenc.setEditable(false);
		txtpnMatriculaenc.setBackground(SystemColor.menu);
		txtpnMatriculaenc.setBounds(0, 40, 112, 20);
		Actividad.add(txtpnMatriculaenc);
		
		JTextPane txtpnNs = new JTextPane();
		txtpnNs.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		txtpnNs.setText("NUM SECCI\u00D3N:");
		txtpnNs.setEditable(false);
		txtpnNs.setBackground(SystemColor.menu);
		txtpnNs.setBounds(0, 71, 112, 20);
		Actividad.add(txtpnNs);
		
		JTextPane txtpnIdinst = new JTextPane();
		txtpnIdinst.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		txtpnIdinst.setText("ID INSTITUCION:");
		txtpnIdinst.setEditable(false);
		txtpnIdinst.setBackground(SystemColor.menu);
		txtpnIdinst.setBounds(0, 102, 122, 20);
		Actividad.add(txtpnIdinst);
		
		JTextPane txtpnHora = new JTextPane();
		txtpnHora.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		txtpnHora.setText("HORA INICIO:");
		txtpnHora.setEditable(false);
		txtpnHora.setBackground(SystemColor.menu);
		txtpnHora.setBounds(0, 133, 92, 20);
		Actividad.add(txtpnHora);
		
		txtMEA = new JTextField();
		txtMEA.setColumns(10);
		txtMEA.setBounds(122, 40, 86, 20);
		Actividad.add(txtMEA);
		
		txtNSA = new JTextField();
		txtNSA.setColumns(10);
		txtNSA.setBounds(122, 71, 86, 20);
		Actividad.add(txtNSA);
		
		txtIIA = new JTextField();
		txtIIA.setColumns(10);
		txtIIA.setBounds(122, 102, 86, 20);
		Actividad.add(txtIIA);
		
		txtHIA = new JTextField();
		txtHIA.setColumns(10);
		txtHIA.setBounds(122, 133, 86, 20);
		Actividad.add(txtHIA);
		
		JTextPane txtpnHorafin = new JTextPane();
		txtpnHorafin.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		txtpnHorafin.setText("HORA FIN:");
		txtpnHorafin.setEditable(false);
		txtpnHorafin.setBackground(SystemColor.menu);
		txtpnHorafin.setBounds(0, 164, 86, 20);
		Actividad.add(txtpnHorafin);
		
		JTextPane txtpnFecha = new JTextPane();
		txtpnFecha.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		txtpnFecha.setText("FECHA:");
		txtpnFecha.setEditable(false);
		txtpnFecha.setBackground(SystemColor.menu);
		txtpnFecha.setBounds(224, 11, 70, 20);
		Actividad.add(txtpnFecha);
		
		txtHFA = new JTextField();
		txtHFA.setColumns(10);
		txtHFA.setBounds(122, 164, 86, 20);
		Actividad.add(txtHFA);
		
		txtFA = new JTextField();
		txtFA.setColumns(10);
		txtFA.setBounds(346, 11, 86, 20);
		Actividad.add(txtFA);
		
		JTextPane txtpnTactividad = new JTextPane();
		txtpnTactividad.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		txtpnTactividad.setText("TIPO ACTIVIDAD:");
		txtpnTactividad.setEditable(false);
		txtpnTactividad.setBackground(SystemColor.menu);
		txtpnTactividad.setBounds(224, 40, 112, 20);
		Actividad.add(txtpnTactividad);
		
		JTextPane txtpnCosteact = new JTextPane();
		txtpnCosteact.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		txtpnCosteact.setText("COSTE ACT:");
		txtpnCosteact.setEditable(false);
		txtpnCosteact.setBackground(SystemColor.menu);
		txtpnCosteact.setBounds(224, 71, 89, 20);
		Actividad.add(txtpnCosteact);
		
		txtTAA = new JTextField();
		txtTAA.setColumns(10);
		txtTAA.setBounds(346, 40, 86, 20);
		Actividad.add(txtTAA);
		
		txtCAA = new JTextField();
		txtCAA.setColumns(10);
		txtCAA.setBounds(346, 71, 86, 20);
		Actividad.add(txtCAA);
		
		JButton bAA = new JButton("AGREGAR");
		bAA.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		bAA.addActionListener((ActionListener) new ActionListener()
		{
			public void actionPerformed(ActionEvent Arg0)
			{
				try
				{
					objAct.ingresar_actividad(txtNPA.getText(), txtMEA.getText(), txtNSA.getText(), txtIIA.getText(), txtHIA.getText(), txtHFA.getText(), txtFA.getText(), txtTAA.getText(), txtCAA.getText());
				}
				catch(IOException e)
				{
					JOptionPane.showMessageDialog(null, "Ocurrio un error con el acceso de la base de datos \n"+e.getMessage());
					System.out.println(e.getMessage());
				}
				DefaultTableModel modeloAct = objAct.mostrarRegistrosAct("SELECT * FROM actividad");
				table_2.setModel(modeloAct);
			}
		});
		bAA.setBounds(462, 8, 111, 23);
		Actividad.add(bAA);
		
		JButton bEA = new JButton("ELIMINAR");
		bEA.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		bEA.addActionListener((ActionListener) new ActionListener()
		{
			public void actionPerformed(ActionEvent Arg0)
			{
				try
				{
					objAct.eliminar_actividad(txtNPA.getText(), txtMEA.getText(), txtNSA.getText(), txtIIA.getText());
				}
				catch(IOException e)
				{
					JOptionPane.showMessageDialog(null, "Ocurrio un error con el acceso de la base de datos \n"+e.getMessage());
					System.out.println(e.getMessage());
				}
				DefaultTableModel modeloAct = objAct.mostrarRegistrosAct("SELECT * FROM actividad");
				table_2.setModel(modeloAct);
			}
		});
		bEA.setBounds(462, 40, 111, 23);
		Actividad.add(bEA);
		
		JButton bMA = new JButton("MODIFICAR");
		bMA.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		bMA.addActionListener((ActionListener) new ActionListener()
		{
			public void actionPerformed(ActionEvent Arg0)
			{
				try
				{
					objAct.modificar_actividad(txtNPA.getText(), txtMEA.getText(), txtNSA.getText(), txtIIA.getText(), txtHIA.getText(), txtHFA.getText(), txtFA.getText(), txtTAA.getText(), txtCAA.getText());
				}
				catch(IOException e)
				{
					JOptionPane.showMessageDialog(null, "Ocurrio un error con el acceso de la base de datos \n"+ e.getMessage());
					System.out.println(e.getMessage());
				}
				DefaultTableModel modeloAct = objAct.mostrarRegistrosAct("SELECT * FROM actividad");
				table_2.setModel(modeloAct);
			}
		});
		bMA.setBounds(462, 71, 111, 23);
		Actividad.add(bMA);
		
		JButton bCA = new JButton("CONSULTAR");
		bCA.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		bCA.addActionListener((ActionListener) new ActionListener()
		{
			public void actionPerformed(ActionEvent Arg0)
			{
				DefaultTableModel modeloAct = objAct.mostrarRegistrosAct("SELECT * FROM actividad");
				table_2.setModel(modeloAct);
			}
		});
		bCA.setBounds(462, 102, 111, 23);
		Actividad.add(bCA);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(10, 218, 573, 158);
		Actividad.add(panel_2);
		panel_2.setLayout(null);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(0, 0, 573, 158);
		panel_2.add(scrollPane_2);
		
		table_2 = new JTable();
		scrollPane_2.setViewportView(table_2);
		
		JButton bLA = new JButton("LIMPIAR");
		bLA.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		bLA.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				limpiarEntradas();
			}
		});
		bLA.setBounds(462, 161, 111, 23);
		Actividad.add(bLA);
		
//-->> INICIO DEL PANEL DEL NUMERO DEL TELEFONO DE INSTITUCION
		
		JPanel NumTel = new JPanel();
		tabbedPane.addTab("numtel_institucion", null, NumTel, null);
		NumTel.setLayout(null);
		
		JTextPane txtpnIdinstitucin = new JTextPane();
		txtpnIdinstitucin.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		txtpnIdinstitucin.setBackground(SystemColor.menu);
		txtpnIdinstitucin.setText("ID INSTITUCI\u00D3N:");
		txtpnIdinstitucin.setEditable(false);
		txtpnIdinstitucin.setBounds(10, 11, 123, 20);
		NumTel.add(txtpnIdinstitucin);
		
		txtIINT = new JTextField();
		txtIINT.setBounds(161, 11, 123, 20);
		NumTel.add(txtIINT);
		txtIINT.setColumns(10);
		
		JTextPane txtpnN = new JTextPane();
		txtpnN.setText("NUMERO TELEFONO:");
		txtpnN.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		txtpnN.setEditable(false);
		txtpnN.setBackground(SystemColor.menu);
		txtpnN.setBounds(10, 42, 141, 20);
		NumTel.add(txtpnN);
		
		txtNTNT = new JTextField();
		txtNTNT.setColumns(10);
		txtNTNT.setBounds(161, 42, 123, 20);
		NumTel.add(txtNTNT);
		
		txtNTMNT = new JTextField();
		txtNTMNT.setColumns(10);
		txtNTMNT.setBounds(161, 81, 123, 20);
		NumTel.add(txtNTMNT);
		
		JButton bANT = new JButton("AGREGAR");
		bANT.addActionListener((ActionListener) new ActionListener()
		{
			public void actionPerformed(ActionEvent Arg0)
			{
				try
				{
					objNumT.ingresar_NumTel(txtIINT.getText(), txtNTNT.getText());
				}
				catch(IOException e)
				{
					JOptionPane.showMessageDialog(null, "Ocurrio un error con el acceso de la base de datos \n"+e.getMessage());
					System.out.println(e.getMessage());
				}
				DefaultTableModel modeloNumT = objNumT.mostrarRegistrosNumT("SELECT * FROM NumTel_Institucion");
				table_3.setModel(modeloNumT);
			}
		});
			
		bANT.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		bANT.setBounds(469, 11, 114, 23);
		NumTel.add(bANT);
		
		JButton bENT = new JButton("ELIMINAR");
		bENT.addActionListener((ActionListener) new ActionListener()
		{
			public void actionPerformed(ActionEvent Arg0)
			{
				try
				{
					objNumT.eliminar_NumTel(txtNTNT.getText());
				}
				catch(IOException e)
				{
					JOptionPane.showMessageDialog(null, "Ocurrio un error con el acceso de la base de datos \n"+e.getMessage());
					System.out.println(e.getMessage());
				}
				DefaultTableModel modeloNumT = objNumT.mostrarRegistrosNumT("SELECT * FROM NumTel_Institucion");
				table_3.setModel(modeloNumT);
			}
		});
		bENT.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		bENT.setBounds(469, 45, 114, 23);
		NumTel.add(bENT);
		
		JButton bMNT = new JButton("MODIFICAR");
		bMNT.addActionListener((ActionListener) new ActionListener()
		{
			public void actionPerformed(ActionEvent Arg0)
			{
				try
				{
					objNumT.modificar_NumTel(txtIINT.getText(), txtNTNT.getText(), txtNTMNT.getText());
				}
				catch(IOException e)
				{
					JOptionPane.showMessageDialog(null, "Ocurrio un error con el acceso de la base de datos \n"+ e.getMessage());
					System.out.println(e.getMessage());
				}
				DefaultTableModel modeloNumT = objNumT.mostrarRegistrosNumT("SELECT * FROM NumTel_Institucion");
				table_3.setModel(modeloNumT);
			}
		});
		bMNT.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		bMNT.setBounds(469, 79, 114, 23);
		NumTel.add(bMNT);
		
		JButton bCNT = new JButton("CONSULTAR");
		bCNT.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				DefaultTableModel modeloNumT = objNumT.mostrarRegistrosNumT("SELECT * FROM NumTel_Institucion");
				table_3.setModel(modeloNumT);
			}
		});
		bCNT.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		bCNT.setBounds(469, 113, 114, 23);
		NumTel.add(bCNT);
		
		JButton bLNT = new JButton("LIMPIAR");
		bLNT.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				limpiarEntradas();
			}
		});
		bLNT.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		bLNT.setBounds(10, 137, 114, 23);
		NumTel.add(bLNT);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(10, 171, 573, 208);
		NumTel.add(panel_3);
		panel_3.setLayout(null);
		
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(0, 0, 574, 208);
		panel_3.add(scrollPane_3);
		
		table_3 = new JTable();
		table_3.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
		scrollPane_3.setViewportView(table_3);
		
		JTextPane txtpnNumtelefonomod = new JTextPane();
		txtpnNumtelefonomod.setText("NUMTELEFONO (MOD):");
		txtpnNumtelefonomod.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		txtpnNumtelefonomod.setEditable(false);
		txtpnNumtelefonomod.setBackground(SystemColor.menu);
		txtpnNumtelefonomod.setBounds(10, 81, 152, 20);
		NumTel.add(txtpnNumtelefonomod);
		
		//--------------------------------------inicia panel Cartilla ---------------------------//
		JPanel Cartilla = new JPanel();
		tabbedPane.addTab("Cartilla", null, Cartilla, null);
		Cartilla.setLayout(null);
		
		JLabel lblNum_Liberación = new JLabel("NUM_LIBERACI\u00D3N");
		lblNum_Liberación.setBounds(21, 106, 118, 14);
		lblNum_Liberación.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		Cartilla.add(lblNum_Liberación);
		
		txtNum_LiberacionCartilla = new JTextField();
		txtNum_LiberacionCartilla.setBounds(21, 131, 118, 20);
		Cartilla.add(txtNum_LiberacionCartilla);
		txtNum_LiberacionCartilla.setColumns(10);
		
		JLabel lblZona_Militar = new JLabel("ZONA_MILITAR");
		lblZona_Militar.setBounds(176, 106, 118, 14);
		lblZona_Militar.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		Cartilla.add(lblZona_Militar);
		
		txtZona_Militar = new JTextField();
		txtZona_Militar.setBounds(176, 131, 118, 20);
		txtZona_Militar.setColumns(10);
		Cartilla.add(txtZona_Militar);
		
		JLabel lblRegimiento = new JLabel("REGIMIENTO");
		lblRegimiento.setBounds(331, 106, 118, 14);
		lblRegimiento.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		Cartilla.add(lblRegimiento);
		
		txtRegimiento = new JTextField();
		txtRegimiento.setBounds(331, 131, 118, 20);
		txtRegimiento.setColumns(10);
		Cartilla.add(txtRegimiento);
		
		JButton btnEliminarCar = new JButton("ELIMINAR");
		btnEliminarCar.setBounds(476, 57, 118, 23);
		btnEliminarCar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{System.out.println("->"+txtNum_LiberacionCartilla.getText()+ txtZona_Militar.getText()+ txtRegimiento.getText());
					objCar.eliminar_Car(txtNum_LiberacionCartilla.getText());
					limpiarEntradas();
				}
				catch(IOException e1)
				{
					e1.printStackTrace();
				}
				DefaultTableModel modeloCar = objCar.mostrarRegistrosCar("SELECT * FROM cartilla");
				table.setModel(modeloCar);
				
			}
		});
		btnEliminarCar.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		Cartilla.add(btnEliminarCar);
		
		JButton btnAgregarCar = new JButton("AGREGAR");
		btnAgregarCar.setBounds(476, 23, 118, 23);
		btnAgregarCar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{System.out.println("->"+txtNum_LiberacionCartilla.getText()+ txtZona_Militar.getText()+ txtRegimiento.getText());
					objCar.ingresar_Car(txtNum_LiberacionCartilla.getText(), txtZona_Militar.getText(), txtRegimiento.getText());
					limpiarEntradas();
				}
				catch(IOException e1)
				{
					e1.printStackTrace();
				}
				DefaultTableModel modeloCar = objCar.mostrarRegistrosCar("SELECT * FROM cartilla");
				table.setModel(modeloCar);
				
			}
		});
		btnAgregarCar.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		Cartilla.add(btnAgregarCar);
		
		JButton btnModificarCar = new JButton("MODIFICAR\r\n");
		btnModificarCar.setBounds(476, 91, 118, 23);
		btnModificarCar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{System.out.println("->"+txtNum_LiberacionCartilla.getText()+ txtZona_Militar.getText()+ txtRegimiento.getText());
					objCar.modificar_Car(txtNum_LiberacionCartilla.getText(), txtZona_Militar.getText(), txtRegimiento.getText());
					limpiarEntradas();
				}
				catch(IOException e1)
				{
					e1.printStackTrace();
				}
				DefaultTableModel modeloCar = objCar.mostrarRegistrosCar("SELECT * FROM cartilla");
				table.setModel(modeloCar);
			}
		});
		btnModificarCar.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		Cartilla.add(btnModificarCar);
		
		JButton btnConsultarCar = new JButton("CONSULTAR");
		btnConsultarCar.setBounds(476, 125, 118, 23);
		btnConsultarCar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel modeloCar = objParR.mostrarRegistrosNumT("SELECT * FROM cartilla");
				table_6.setModel(modeloCar);
			}
		});
		btnConsultarCar.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		Cartilla.add(btnConsultarCar);
		
		JButton btnLimpiarCar = new JButton("LIMPIAR");
		btnLimpiarCar.setBounds(476, 203, 118, 23);
		btnLimpiarCar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpiarEntradas();
			}
		});
		btnLimpiarCar.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		Cartilla.add(btnLimpiarCar);
		
		JPanel panel_6 = new JPanel();
		panel_6.setLayout(null);
		panel_6.setBounds(21, 237, 573, 142);
		Cartilla.add(panel_6);
		
		JScrollPane scrollPane_6 = new JScrollPane();
		scrollPane_6.setBounds(0, 78, 573, 142);
		panel_6.add(scrollPane_6);
		
		table_6 = new JTable();
		table_6.setBounds(0, 11, 571, 0);
		panel_6.add(table_6);
		
//-->> INICIO DEL PANEL DE ESCUADRON
		
		JPanel Escuadron = new JPanel();
		tabbedPane.addTab("Escuadron", null, Escuadron, null);
		tabbedPane.setEnabledAt(5, false);
		Escuadron.setLayout(null);
		
		JTextPane txtpnNseccin = new JTextPane();
		txtpnNseccin.setText("NUMERO SECCI\u00D3N:");
		txtpnNseccin.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		txtpnNseccin.setEditable(false);
		txtpnNseccin.setBackground(SystemColor.menu);
		txtpnNseccin.setBounds(10, 11, 137, 20);
		Escuadron.add(txtpnNseccin);
		
		txtNSE = new JTextField();
		txtNSE.setBounds(157, 11, 123, 20);
		Escuadron.add(txtNSE);
		txtNSE.setColumns(10);
		
		JTextPane txtpnNum = new JTextPane();
		txtpnNum.setText("NUM INTEGRANTES:");
		txtpnNum.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		txtpnNum.setEditable(false);
		txtpnNum.setBackground(SystemColor.menu);
		txtpnNum.setBounds(10, 42, 137, 20);
		Escuadron.add(txtpnNum);
		
		txtNIE = new JTextField();
		txtNIE.setColumns(10);
		txtNIE.setBounds(157, 42, 123, 20);
		Escuadron.add(txtNIE);
		
		JButton bAE = new JButton("AGREGAR");
		bAE.addActionListener((ActionListener) new ActionListener()
		{
			public void actionPerformed(ActionEvent Arg0)
			{
				try
				{
					objEsc.ingresar_Esc(txtNSE.getText(), txtNIE.getText());
				}
				catch(IOException e)
				{
					JOptionPane.showMessageDialog(null, "Ocurrio un error con el acceso de la base de datos \n"+e.getMessage());
					System.out.println(e.getMessage());
				}
				DefaultTableModel modeloEsc = objEsc.mostrarRegistrosNumT("SELECT * FROM escuadron");
				table_4.setModel(modeloEsc);
			}
		});
		bAE.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		bAE.setBounds(459, 10, 114, 23);
		Escuadron.add(bAE);
		
		JButton bEE = new JButton("ELIMINAR");
		bEE.addActionListener((ActionListener) new ActionListener()
		{
			public void actionPerformed(ActionEvent Arg0)
			{
				try
				{
					objEsc.eliminar_Esc(txtNSE.getText());
				}
				catch(IOException e)
				{
					JOptionPane.showMessageDialog(null, "Ocurrio un error con el acceso de la base de datos \n"+e.getMessage());
					System.out.println(e.getMessage());
				}
				DefaultTableModel modeloEsc = objEsc.mostrarRegistrosNumT("SELECT * FROM escuadron");
				table_4.setModel(modeloEsc);
			}
		});
		bEE.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		bEE.setBounds(459, 42, 114, 23);
		Escuadron.add(bEE);
		
		JButton bME = new JButton("MODIFICAR");
		bME.addActionListener((ActionListener) new ActionListener()
		{
			public void actionPerformed(ActionEvent Arg0)
			{
				try
				{
					objEsc.modificar_Esc(txtNSE.getText(), txtNIE.getText());
				}
				catch(IOException e)
				{
					JOptionPane.showMessageDialog(null, "Ocurrio un error con el acceso de la base de datos \n"+ e.getMessage());
					System.out.println(e.getMessage());
				}
				DefaultTableModel modeloEsc = objEsc.mostrarRegistrosNumT("SELECT * FROM escuadron");
				table_4.setModel(modeloEsc);
			}
		});
		bME.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		bME.setBounds(459, 76, 114, 23);
		Escuadron.add(bME);
		
		JButton bCE = new JButton("CONSULTAR");
		bCE.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				DefaultTableModel modeloEsc = objEsc.mostrarRegistrosNumT("SELECT * FROM escuadron");
				table_4.setModel(modeloEsc);
			}
		});
		bCE.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		bCE.setBounds(459, 110, 114, 23);
		Escuadron.add(bCE);
		
		JButton bLE = new JButton("LIMPIAR");
		bLE.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				limpiarEntradas();
			}
		});
		bLE.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		bLE.setBounds(10, 110, 114, 23);
		Escuadron.add(bLE);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(10, 155, 563, 188);
		Escuadron.add(panel_4);
		panel_4.setLayout(null);
		
		JScrollPane scrollPane_4 = new JScrollPane();
		scrollPane_4.setBounds(0, 0, 563, 188);
		panel_4.add(scrollPane_4);
		
		table_4 = new JTable();
		table_4.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
		scrollPane_4.setViewportView(table_4);
		
//-->> INICIO DEL PANEL DE PARTICIPANTE RESERVA (participa_res)
		
		JPanel ParticipaRes = new JPanel();
		tabbedPane.addTab("Participa_Res", null, ParticipaRes, null);
		ParticipaRes.setLayout(null);
		
		JTextPane txtpnMatriculares = new JTextPane();
		txtpnMatriculares.setEditable(false);
		txtpnMatriculares.setBackground(SystemColor.menu);
		txtpnMatriculares.setText("MATRICULA_RES:");
		txtpnMatriculares.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		txtpnMatriculares.setBounds(10, 11, 120, 20);
		ParticipaRes.add(txtpnMatriculares);
		
		JTextPane txtpnEdsorteo = new JTextPane();
		txtpnEdsorteo.setEditable(false);
		txtpnEdsorteo.setText("ED_SORTEO:");
		txtpnEdsorteo.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		txtpnEdsorteo.setBackground(SystemColor.menu);
		txtpnEdsorteo.setBounds(10, 42, 120, 20);
		ParticipaRes.add(txtpnEdsorteo);
		
		JTextPane txtpnResultado = new JTextPane();
		txtpnResultado.setEditable(false);
		txtpnResultado.setText("RESULTADO:");
		txtpnResultado.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		txtpnResultado.setBackground(SystemColor.menu);
		txtpnResultado.setBounds(10, 73, 120, 20);
		ParticipaRes.add(txtpnResultado);
		
		txtMRPR = new JTextField();
		txtMRPR.setBounds(140, 11, 110, 20);
		ParticipaRes.add(txtMRPR);
		txtMRPR.setColumns(10);
		
		txtEDPR = new JTextField();
		txtEDPR.setColumns(10);
		txtEDPR.setBounds(140, 42, 110, 20);
		ParticipaRes.add(txtEDPR);
		
		txtRPR = new JTextField();
		txtRPR.setColumns(10);
		txtRPR.setBounds(140, 73, 110, 20);
		ParticipaRes.add(txtRPR);
		
		JButton bAPR = new JButton("AGREGAR");
		bAPR.addActionListener((ActionListener) new ActionListener()
		{
			public void actionPerformed(ActionEvent Arg0)
			{
				try
				{
					objParR.ingresar_ParR(txtMRPR.getText(), txtEDPR.getText(), txtRPR.getText());
				}
				catch(IOException e)
				{
					JOptionPane.showMessageDialog(null, "Ocurrio un error con el acceso de la base de datos \n"+e.getMessage());
					System.out.println(e.getMessage());
				}
				DefaultTableModel modeloParR = objParR.mostrarRegistrosNumT("SELECT * FROM participa_res");
				table_5.setModel(modeloParR);
			}
		});
		bAPR.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		bAPR.setBounds(463, 11, 110, 23);
		ParticipaRes.add(bAPR);
		
		JButton bEPR = new JButton("ELIMINAR");
		bEPR.addActionListener((ActionListener) new ActionListener()
		{
			public void actionPerformed(ActionEvent Arg0)
			{
				try
				{
					objParR.eliminar_ParR(txtMRPR.getText());
				}
				catch(IOException e)
				{
					JOptionPane.showMessageDialog(null, "Ocurrio un error con el acceso de la base de datos \n"+e.getMessage());
					System.out.println(e.getMessage());
				}
				DefaultTableModel modeloParR = objParR.mostrarRegistrosNumT("SELECT * FROM participa_res");
				table_5.setModel(modeloParR);
			}
		});
		bEPR.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		bEPR.setBounds(463, 42, 110, 23);
		ParticipaRes.add(bEPR);
		
		JButton bMPR = new JButton("MODIFICAR");
		bMPR.addActionListener((ActionListener) new ActionListener()
		{
			public void actionPerformed(ActionEvent Arg0)
			{
				try
				{
					objParR.modificar_ParR(txtMRPR.getText(), txtEDPR.getText(), txtRPR.getText());
				}
				catch(IOException e)
				{
					JOptionPane.showMessageDialog(null, "Ocurrio un error con el acceso de la base de datos \n"+ e.getMessage());
					System.out.println(e.getMessage());
				}
				DefaultTableModel modeloParR = objParR.mostrarRegistrosNumT("SELECT * FROM participa_res");
				table_5.setModel(modeloParR);
			}
		});
		bMPR.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		bMPR.setBounds(463, 73, 110, 23);
		ParticipaRes.add(bMPR);
		
		JButton bCPR = new JButton("CONSULTAR");
		bCPR.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				DefaultTableModel modeloParR = objParR.mostrarRegistrosNumT("SELECT * FROM participa_res");
				table_5.setModel(modeloParR);
			}
		});
		bCPR.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		bCPR.setBounds(463, 104, 110, 23);
		ParticipaRes.add(bCPR);
		
		JButton bLPR = new JButton("LIMPIAR");
		bLPR.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				limpiarEntradas();
			}
		});
		bLPR.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		bLPR.setBounds(463, 136, 110, 23);
		ParticipaRes.add(bLPR);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBounds(10, 182, 577, 197);
		ParticipaRes.add(panel_5);
		panel_5.setLayout(null);
		
		JScrollPane scrollPane_5 = new JScrollPane();
		scrollPane_5.setBounds(0, 0, 577, 197);
		panel_5.add(scrollPane_5);
		
		table_5 = new JTable();
		scrollPane_5.setViewportView(table_5);
		
//-->> INICIA PANEL DE OBTIENE
		DefaultTableModel modeloIns = null;
		
		JPanel Obtiene = new JPanel();
		tabbedPane.addTab("Obtiene", null, Obtiene, null);
		Obtiene.setLayout(null);
		
		JLabel lblMatReserva = new JLabel("MATRICULA DEL RESERVA");
		lblMatReserva.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		lblMatReserva.setBounds(34, 31, 151, 14);
		Obtiene.add(lblMatReserva);
		
		JLabel lblNumLiberacion = new JLabel("N\u00DAMERO DE LIBERACI\u00D3N");
		lblNumLiberacion.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		lblNumLiberacion.setBounds(34, 62, 148, 14);
		Obtiene.add(lblNumLiberacion);
		
		JLabel lblPrecioCart = new JLabel("PRECIO DE CARTILLA");
		lblPrecioCart.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		lblPrecioCart.setBounds(34, 93, 123, 14);
		Obtiene.add(lblPrecioCart);
		
		JLabel lblRecepcion = new JLabel("MES DE RECEPCI\u00D3N");
		lblRecepcion.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		lblRecepcion.setBounds(34, 124, 116, 14);
		Obtiene.add(lblRecepcion);
		
		etMatReserva = new JTextField();
		etMatReserva.setBounds(197, 29, 86, 20);
		Obtiene.add(etMatReserva);
		etMatReserva.setColumns(10);
		
		etNumLiberacion = new JTextField();
		etNumLiberacion.setBounds(197, 60, 86, 20);
		Obtiene.add(etNumLiberacion);
		etNumLiberacion.setColumns(10);
		
		etPrecioCart = new JTextField();
		etPrecioCart.setBounds(197, 91, 86, 20);
		Obtiene.add(etPrecioCart);
		etPrecioCart.setColumns(10);
		
		etMesRecepcion = new JTextField();
		etMesRecepcion.setBounds(197, 122, 86, 20);
		Obtiene.add(etMesRecepcion);
		etMesRecepcion.setColumns(10);
		
		
		
		JButton btnAgregar = new JButton("AGREGAR");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String Matricula="", NumeroLib="", Precio="", Mes="";
				
				Matricula = etMatReserva.getText();
				NumeroLib = etNumLiberacion.getText();
				Precio = etPrecioCart.getText();
				Mes = etMesRecepcion.getText();
				
				objObt.ingresar_obtiene(Matricula, NumeroLib, Precio, Mes);
				
				DefaultTableModel modeloIns = objObt.mostrarRegistrosObtiene("SELECT * FROM obtiene");
				tablaObtiene.setModel(modeloIns);
				
			}
		});
		btnAgregar.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		btnAgregar.setBounds(470, 28, 108, 23);
		Obtiene.add(btnAgregar);
		
		JButton btnEliminar = new JButton("ELIMINAR");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String Matricula="";
				
				Matricula = etMatReserva.getText();
				
				objObt.eliminar_obtiene(Matricula);
				
				DefaultTableModel modeloIns = objObt.mostrarRegistrosObtiene("SELECT * FROM obtiene");
				tablaObtiene.setModel(modeloIns);
				
			}
		});
		btnEliminar.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		btnEliminar.setBounds(470, 59, 108, 23);
		Obtiene.add(btnEliminar);
		
		JButton btnModificar = new JButton("MODIFICAR");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String Matricula="", NumeroLib="", Precio="", Mes="";
				
				Matricula = etMatReserva.getText();
				NumeroLib = etNumLiberacion.getText();
				Precio = etPrecioCart.getText();
				Mes = etMesRecepcion.getText();
				
				objObt.modificar_obtiene(Matricula, NumeroLib, Precio, Mes);
				
				DefaultTableModel modeloIns = objObt.mostrarRegistrosObtiene("SELECT * FROM obtiene WHERE Matricula_Res = '"+Matricula+"'");
				tablaObtiene.setModel(modeloIns);
				
			}
		});
		btnModificar.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		btnModificar.setBounds(470, 90, 108, 23);
		Obtiene.add(btnModificar);
		
		JButton btnLimpiar = new JButton("LIMPIAR");
		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				etMatReserva.setText("");
				etNumLiberacion.setText("");
				etPrecioCart.setText("");
				etMesRecepcion.setText("");
				
				DefaultTableModel modelo = objObt.mostrarRegistrosObtiene("SELECT * FROM obtiene");
				tablaObtiene.setModel(modelo);
				
			}
		});
		btnLimpiar.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		btnLimpiar.setBounds(470, 155, 108, 23);
		Obtiene.add(btnLimpiar);
		
		//-->> INICIA EL PANEL CONTENEDOR DE LA TABLA
		JPanel pnlTabla = new JPanel();
		pnlTabla.setBounds(34, 205, 544, 172);
		Obtiene.add(pnlTabla);
		pnlTabla.setLayout(null);
		
		JScrollPane spTabla = new JScrollPane();
		spTabla.setBounds(0, 0, 544, 172);
		pnlTabla.add(spTabla);
		
		tablaObtiene = new JTable();
		tablaObtiene.setShowVerticalLines(false);
		spTabla.setViewportView(tablaObtiene);
		
		tablaObtiene.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		tablaObtiene.setFont(new Font("Tahoma", Font.BOLD, 12));
		tablaObtiene.setForeground(Color.BLACK);
		tablaObtiene.setCellSelectionEnabled(true);
		
		JButton btnConsultar = new JButton("CONSULTAR");
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String[] datos=new String[4];
				String Matricula = etMatReserva.getText();
				
				DefaultTableModel modelo = objObt.mostrarRegistrosObtiene("SELECT * FROM obtiene WHERE Matricula_Res = '"+Matricula+"'");
				tablaObtiene.setModel(modelo);
				
				datos=objObt.vector_edits(datos);
				
				etNumLiberacion.setText(datos[1]);
				etPrecioCart.setText(datos[2]);
				etMesRecepcion.setText(datos[3]);
				
				for(int i=0; i<datos.length; i++) {
					datos[i]=null;
				}
				
				objObt.vector_edits(datos);
				
			}
		});
		btnConsultar.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		btnConsultar.setBounds(470, 121, 108, 23);
		Obtiene.add(btnConsultar);
		
		//-------------------------------------Inicia panel de sorteo-----------------//
		
		JPanel Sorteo = new JPanel();
		tabbedPane.addTab("Sorteo", null, Sorteo, null);
		Sorteo.setLayout(null);
		
		etsorteo = new JTextField();
		etsorteo.setColumns(10);
		etsorteo.setBounds(223, 31, 86, 20);
		Sorteo.add(etsorteo);
		
		etfechas = new JTextField();
		etfechas.setColumns(10);
		etfechas.setBounds(223, 62, 86, 20);
		Sorteo.add(etfechas);
		
		JButton btnAgregar_S = new JButton("AGREGAR");
		btnAgregar_S.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
						
						String edsorteo="",fecha="";
						edsorteo=etsorteo.getText();
						fecha = etfechas.getText();
						
						
						
						objsor.ingresar_sorteo(edsorteo,fecha);
						
						DefaultTableModel modelos = objsor.mostrarRegistrosSorteo("SELECT * FROM sorteo");
						tablasorteo.setModel(modelos);
						
					}
				});
		btnAgregar_S.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		btnAgregar_S.setBounds(496, 30, 108, 23);
		Sorteo.add(btnAgregar_S);
		
		
		JButton btnModificar_S = new JButton("MODIFICAR");
		btnModificar_S.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String edsorteo="",fecha="";
				edsorteo=etsorteo.getText();
				fecha = etfechas.getText();
				
				
				
				objsor.ingresar_sorteo(edsorteo,fecha);
				
				DefaultTableModel modelos = objsor.mostrarRegistrosSorteo("SELECT * FROM sorteo WHERE Ed_Sorteo = '"+edsorteo+"'");
				tablaValida.setModel(modelos);
				
			}
		});
		btnModificar_S.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		btnModificar_S.setBounds(496, 60, 108, 23);
		Sorteo.add(btnModificar_S);
		
		JButton btnLimpiar_S = new JButton("LIMPIAR");
		btnLimpiar_S.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				etsorteo.setText("");
				etfechas.setText("");
				
				DefaultTableModel modelos = objsor.mostrarRegistrosSorteo("SELECT * FROM sorteo");
				tablasorteo.setModel(modelos);
				
			}
		});
		btnLimpiar_S.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		btnLimpiar_S.setBounds(496, 128, 108, 23);
		Sorteo.add(btnLimpiar_S);
		
		JPanel pnlTabla_1 = new JPanel();
		pnlTabla_1.setLayout(null);
		pnlTabla_1.setBounds(60, 207, 544, 172);
		Sorteo.add(pnlTabla_1);
		
		JScrollPane spTabla_1 = new JScrollPane();
		spTabla_1.setBounds(0, 0, 544, 172);
		pnlTabla_1.add(spTabla_1);
		
		tablasorteo = new JTable();
		tablasorteo.setBounds(0, 0, 1, 1);
		pnlTabla_1.add(tablasorteo);
		
		JButton btnConsultar_S = new JButton("CONSULTAR");
		btnConsultar_S.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String[] datos=new String[2];
				String edsorteo=etsorteo.getText();
				
				DefaultTableModel modelos = objsor.mostrarRegistrosSorteo("SELECT * FROM sorteo WHERE Ed_Sorteo = '"+edsorteo+"'");
				tablaValida.setModel(modelos);
				
				
				datos=objsor.vector_edits(datos);
				
				etsorteo.setText(datos[1]);
				etfechas.setText(datos[2]);
				
				
				for(int i=0; i<datos.length; i++) {
					datos[i]=null;
				}
				
				objVal.vector_edits(datos);
				
			}
		});
		btnConsultar_S.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		btnConsultar_S.setBounds(496, 94, 108, 23);
		Sorteo.add(btnConsultar_S);
		
		JLabel lblEdicionDelSorteo = new JLabel("EDICION DEL SORTEO");
		lblEdicionDelSorteo.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		lblEdicionDelSorteo.setBounds(23, 31, 151, 14);
		Sorteo.add(lblEdicionDelSorteo);
		
		JLabel lblFecha = new JLabel("FECHA");
		lblFecha.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		lblFecha.setBounds(23, 62, 148, 14);
		Sorteo.add(lblFecha);
		//--------------------------------------inicia panel valida ---------------------------//
		DefaultTableModel modelos = null;
		JPanel Valida = new JPanel();
		Valida.setLayout(null);
		tabbedPane.addTab("Valida", null, Valida, null);
		
		etNumplaca = new JTextField();
		etNumplaca.setColumns(10);
		etNumplaca.setBounds(223, 31, 86, 20);
		Valida.add(etNumplaca);
		
		etMatenc = new JTextField();
		etMatenc.setColumns(10);
		etMatenc.setBounds(223, 62, 86, 20);
		Valida.add(etMatenc);
		
		JButton btnAgregar_V = new JButton("AGREGAR");
		btnAgregar_V.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
			
			String Placa="",Matricula="", NumeroLib="",horas="", Precio="";
			Placa=etNumplaca.getText();
			Matricula = etMatenc.getText();
			NumeroLib = etNumlib.getText();
			horas=etHoras.getText();
			Precio = etPreciocart.getText();
			
			
			objVal.ingresar_valida(Placa,Matricula, NumeroLib,horas, Precio);
			
			DefaultTableModel modelos = objVal.mostrarRegistrosValida("SELECT * FROM valida");
			tablaValida.setModel(modelos);
			
		}
	});
		btnAgregar_V.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		btnAgregar_V.setBounds(496, 30, 108, 23);
		Valida.add(btnAgregar_V);

		
		JButton btnEliminar_V = new JButton("ELIMINAR");
		btnEliminar_V.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String Matricula="";
				
				Matricula = etMatenc.getText();
				
				objVal.eliminar_valida(Matricula);
				
				DefaultTableModel modelos = objVal.mostrarRegistrosValida("SELECT * FROM valida");
				tablaValida.setModel(modelos);
				
			}
		});
		btnEliminar_V.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		btnEliminar_V.setBounds(496, 61, 108, 23);
		Valida.add(btnEliminar_V);
		
		
		JButton btnModificar_V = new JButton("MODIFICAR");
		btnModificar_V.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String Placa="",Matricula="", NumeroLib="",Horas="", Precio="";
				
				Placa=etNumplaca.getText();
				Matricula = etMatenc.getText();
				NumeroLib = etNumlib.getText();
				Horas=etHoras.getText();
				Precio = etPreciocart.getText();
				
				
				objVal.modificar_val(Placa,Matricula, NumeroLib,Horas, Precio);
				
				DefaultTableModel modelos = objVal.mostrarRegistrosValida("SELECT * FROM valida WHERE Num_Placa = '"+Placa+"'");
				tablaValida.setModel(modelos);
				
			}
		});
		btnModificar_V.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		btnModificar_V.setBounds(496, 92, 108, 23);
		Valida.add(btnModificar_V);
		
		
		
		JButton btnLimpiar_V = new JButton("LIMPIAR");
		btnLimpiar_V.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				

				etNumplaca.setText("");
				etMatReserva.setText("");
				etNumLiberacion.setText("");
				etPrecioCart.setText("");
				etMesRecepcion.setText("");
				
				
				DefaultTableModel modelo = objVal.mostrarRegistrosValida("SELECT * FROM valida");
				tablaValida.setModel(modelo);
				
			}
		});
		btnLimpiar_V.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		btnLimpiar_V.setBounds(496, 157, 108, 23);
		Valida.add(btnLimpiar_V);
		
		JPanel pnlTabla_V = new JPanel();
		pnlTabla_V.setLayout(null);
		pnlTabla_V.setBounds(60, 207, 544, 172);
		Valida.add(pnlTabla_V);
		
		JScrollPane sptablav = new JScrollPane();
		sptablav.setBounds(0, 0, 544, 172);
		pnlTabla_V.add(sptablav);
		
		tablaValida = new JTable();
		tablaValida.setShowVerticalLines(false);
		tablaValida.setForeground(Color.BLACK);
		tablaValida.setFont(new Font("Tahoma", Font.BOLD, 12));
		tablaValida.setCellSelectionEnabled(true);
		tablaValida.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		tablaValida.setBounds(0, 0, 1, 1);
		pnlTabla_V.add(tablaValida);
		
		tablaValida = new JTable();
		tablaValida.setShowVerticalLines(false);
		spTabla.setViewportView(tablaValida);
		
		tablaValida.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		tablaValida.setFont(new Font("Tahoma", Font.BOLD, 12));
		tablaValida.setForeground(Color.BLACK);
		tablaValida.setCellSelectionEnabled(true);
		
		
		JButton btnConsultar_V = new JButton("CONSULTAR");
		btnConsultar_V.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String[] datos=new String[5];
				String Placa=etNumplaca.getText();
				
				DefaultTableModel modelo = objVal.mostrarRegistrosValida("SELECT * FROM valida WHERE Num_Placa = '"+Placa+"'");
				tablaValida.setModel(modelo);
				
				
				datos=objVal.vector_edits(datos);
				
				etNumplaca.setText(datos[1]);
				etMatReserva.setText(datos[2]);
				etNumLiberacion.setText(datos[3]);
				etPrecioCart.setText(datos[4]);
				etMesRecepcion.setText(datos[5]);
				
				for(int i=0; i<datos.length; i++) {
					datos[i]=null;
				}
				
				objVal.vector_edits(datos);
				
			}
		});
		btnConsultar_V.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		btnConsultar_V.setBounds(496, 123, 108, 23);
		Valida.add(btnConsultar_V);
		
		JLabel lblNumeroDePlaca = new JLabel("NUMERO DE PLACA");
		lblNumeroDePlaca.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		lblNumeroDePlaca.setBounds(23, 31, 151, 14);
		Valida.add(lblNumeroDePlaca);
		
		JLabel lblMatriculaEncuadrado = new JLabel("MATRICULA DEL  ENCUADRADO");
		lblMatriculaEncuadrado.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		lblMatriculaEncuadrado.setBounds(23, 62, 190, 14);
		Valida.add(lblMatriculaEncuadrado);
		
		etNumlib = new JTextField();
		etNumlib.setColumns(10);
		etNumlib.setBounds(223, 95, 86, 20);
		Valida.add(etNumlib);
		
		etHoras = new JTextField();
		etHoras.setColumns(10);
		etHoras.setBounds(223, 126, 86, 20);
		Valida.add(etHoras);
		
		etPreciocart = new JTextField();
		etPreciocart.setColumns(10);
		etPreciocart.setBounds(223, 159, 86, 20);
		Valida.add(etPreciocart); 
		
		JLabel lblNumeroliberacion = new JLabel("NUMERO DE LIBERACI\u00D3N");
		lblNumeroliberacion.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		lblNumeroliberacion.setBounds(23, 97, 148, 14);
		Valida.add(lblNumeroliberacion);
		
		JLabel lblHorastrabajadas = new JLabel("HORAS TRABAJADAS");
		lblHorastrabajadas.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		lblHorastrabajadas.setBounds(23, 128, 148, 14);
		Valida.add(lblHorastrabajadas);
		
		JLabel lblPreciocartilla = new JLabel("PRECIO CARTILLA");
		lblPreciocartilla.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		lblPreciocartilla.setBounds(26, 162, 148, 14);
		Valida.add(lblPreciocartilla);
		
		//============================================PANEL ENCUADRADO=====================================//
		JPanel panel_7 = new JPanel();
		panel_7.setLayout(null);
		tabbedPane.addTab("Encuadrado", null, panel_7, null);
		
		JLabel lblNombreEnc = new JLabel("NOMBRE");
		lblNombreEnc.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		lblNombreEnc.setBounds(126, 26, 86, 14);
		panel_7.add(lblNombreEnc);
		
		txtNombreEnc = new JTextField();
		txtNombreEnc.setColumns(10);
		txtNombreEnc.setBounds(126, 51, 86, 20);
		panel_7.add(txtNombreEnc);
		
		JLabel lblApellidoPat = new JLabel("A. PATERNO");
		lblApellidoPat.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		lblApellidoPat.setBounds(222, 26, 93, 14);
		panel_7.add(lblApellidoPat);
		
		JLabel lblApellidoMaternoEnc = new JLabel("A. MATERNO");
		lblApellidoMaternoEnc.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		lblApellidoMaternoEnc.setBounds(318, 26, 93, 14);
		panel_7.add(lblApellidoMaternoEnc);
		
		txtApellidoPaternoEnc = new JTextField();
		txtApellidoPaternoEnc.setColumns(10);
		txtApellidoPaternoEnc.setBounds(222, 51, 86, 20);
		panel_7.add(txtApellidoPaternoEnc);
		
		txtApellidoMaternoEnc = new JTextField();
		txtApellidoMaternoEnc.setColumns(10);
		txtApellidoMaternoEnc.setBounds(318, 51, 86, 20);
		panel_7.add(txtApellidoMaternoEnc);
		
		JLabel lblCurpEnc = new JLabel("CURP\r\n");
		lblCurpEnc.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		lblCurpEnc.setBounds(10, 89, 93, 14);
		panel_7.add(lblCurpEnc);
		
		txtCurpEnc = new JTextField();
		txtCurpEnc.setColumns(10);
		txtCurpEnc.setBounds(10, 107, 106, 20);
		panel_7.add(txtCurpEnc);
		
		JLabel lblEdadEnc = new JLabel("EDAD");
		lblEdadEnc.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		lblEdadEnc.setBounds(126, 89, 46, 14);
		panel_7.add(lblEdadEnc);
		
		JLabel lblProfesionEnc = new JLabel("PROFESI\u00D3N");
		lblProfesionEnc.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		lblProfesionEnc.setBounds(318, 89, 86, 14);
		panel_7.add(lblProfesionEnc);
		
		txtProfesionEnc = new JTextField();
		txtProfesionEnc.setColumns(10);
		txtProfesionEnc.setBounds(318, 107, 86, 20);
		panel_7.add(txtProfesionEnc);
		
		JLabel lblSexoEnc = new JLabel("SEXO");
		lblSexoEnc.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		lblSexoEnc.setBounds(414, 89, 46, 14);
		panel_7.add(lblSexoEnc);
		
		JLabel lblCalleEnc = new JLabel("CALLE");
		lblCalleEnc.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		lblCalleEnc.setBounds(10, 145, 46, 14);
		panel_7.add(lblCalleEnc);
		
		txtCalleEnc = new JTextField();
		txtCalleEnc.setColumns(10);
		txtCalleEnc.setBounds(10, 170, 106, 20);
		panel_7.add(txtCalleEnc);
		
		JLabel lblColoniaEnc = new JLabel("COLONIA");
		lblColoniaEnc.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		lblColoniaEnc.setBounds(126, 145, 86, 14);
		panel_7.add(lblColoniaEnc);
		
		txtColoniaEnc = new JTextField();
		txtColoniaEnc.setColumns(10);
		txtColoniaEnc.setBounds(126, 170, 86, 20);
		panel_7.add(txtColoniaEnc);
		
		JLabel lblNumInteriorEnc = new JLabel("NUM INTER");
		lblNumInteriorEnc.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		lblNumInteriorEnc.setBounds(222, 145, 86, 14);
		panel_7.add(lblNumInteriorEnc);
		
		txtNumInteriorEnc = new JTextField();
		txtNumInteriorEnc.setColumns(10);
		txtNumInteriorEnc.setBounds(222, 170, 86, 20);
		panel_7.add(txtNumInteriorEnc);
		
		JLabel lblNumExteriorEnc = new JLabel("NUM EXT");
		lblNumExteriorEnc.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		lblNumExteriorEnc.setBounds(318, 145, 83, 14);
		panel_7.add(lblNumExteriorEnc);
		
		txtNumExtEnc = new JTextField();
		txtNumExtEnc.setColumns(10);
		txtNumExtEnc.setBounds(318, 170, 86, 20);
		panel_7.add(txtNumExtEnc);
		
		JLabel lblCiudadEnc = new JLabel("CIUDAD");
		lblCiudadEnc.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		lblCiudadEnc.setBounds(415, 145, 56, 14);
		panel_7.add(lblCiudadEnc);
		
		txtCiudadEnc = new JTextField();
		txtCiudadEnc.setColumns(10);
		txtCiudadEnc.setBounds(414, 170, 86, 20);
		panel_7.add(txtCiudadEnc);
		
		JLabel lblEstadoCivilEnc = new JLabel("ESTADO CIVIL");
		lblEstadoCivilEnc.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		lblEstadoCivilEnc.setBounds(10, 213, 106, 14);
		panel_7.add(lblEstadoCivilEnc);
		
		JLabel lblDiscapacidad = new JLabel("DISCAPACIDAD");
		lblDiscapacidad.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		lblDiscapacidad.setBounds(118, 213, 106, 14);
		panel_7.add(lblDiscapacidad);
		
		txtEstadoCivilEnc = new JTextField();
		txtEstadoCivilEnc.setColumns(10);
		txtEstadoCivilEnc.setBounds(126, 239, 86, 20);
		panel_7.add(txtEstadoCivilEnc);
		
		JLabel lblClaseEnc = new JLabel("CLASE");
		lblClaseEnc.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		lblClaseEnc.setBounds(222, 213, 46, 14);
		panel_7.add(lblClaseEnc);
		
		txtClaseEnc = new JTextField();
		txtClaseEnc.setColumns(10);
		txtClaseEnc.setBounds(222, 239, 86, 20);
		panel_7.add(txtClaseEnc);
		
		JLabel lblHablilidadEnc = new JLabel("HABILIDAD\r\n");
		lblHablilidadEnc.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		lblHablilidadEnc.setBounds(318, 213, 86, 14);
		panel_7.add(lblHablilidadEnc);
		
		txtHabilidadEnc = new JTextField();
		txtHabilidadEnc.setColumns(10);
		txtHabilidadEnc.setBounds(318, 239, 86, 20);
		panel_7.add(txtHabilidadEnc);
		
		JLabel lblTipoSangreEnc = new JLabel("TIPO SANGRE");
		lblTipoSangreEnc.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		lblTipoSangreEnc.setBounds(414, 213, 93, 14);
		panel_7.add(lblTipoSangreEnc);
		
		JLabel lblPesoEnc = new JLabel("PESO (KG)");
		lblPesoEnc.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		lblPesoEnc.setBounds(10, 270, 83, 14);
		panel_7.add(lblPesoEnc);
		
		txtPesoEnc = new JTextField();
		txtPesoEnc.setColumns(10);
		txtPesoEnc.setBounds(10, 295, 106, 20);
		panel_7.add(txtPesoEnc);
		
		JLabel lblAlturaEnc = new JLabel("ALTURA (MTS)");
		lblAlturaEnc.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		lblAlturaEnc.setBounds(126, 270, 86, 14);
		panel_7.add(lblAlturaEnc);
		
		txtAlturaEnc = new JTextField();
		txtAlturaEnc.setColumns(10);
		txtAlturaEnc.setBounds(126, 295, 86, 20);
		panel_7.add(txtAlturaEnc);
		
		txtSexoEnc = new JTextField();
		txtSexoEnc.setColumns(10);
		txtSexoEnc.setBounds(414, 107, 86, 20);
		panel_7.add(txtSexoEnc);
		
		txtEdadEnc = new JTextField();
		txtEdadEnc.setColumns(10);
		txtEdadEnc.setBounds(126, 107, 86, 20);
		panel_7.add(txtEdadEnc);
		
		txtNumCelularEnc = new JTextField();
		txtNumCelularEnc.setColumns(10);
		txtNumCelularEnc.setBounds(222, 107, 86, 20);
		panel_7.add(txtNumCelularEnc);
		
		JLabel lblNumCelularEnc = new JLabel("NUM CELULAR");
		lblNumCelularEnc.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		lblNumCelularEnc.setBounds(222, 89, 98, 14);
		panel_7.add(lblNumCelularEnc);
		
		JLabel lblMatriculaEnc = new JLabel("MATRICULA ENC");
		lblMatriculaEnc.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		lblMatriculaEnc.setBounds(10, 26, 116, 14);
		panel_7.add(lblMatriculaEnc);
		
		txtMatriculaEnc = new JTextField();
		txtMatriculaEnc.setColumns(10);
		txtMatriculaEnc.setBounds(10, 51, 106, 20);
		panel_7.add(txtMatriculaEnc);
		
		txtEstadoCivil = new JTextField();
		txtEstadoCivil.setColumns(10);
		txtEstadoCivil.setBounds(10, 238, 106, 20);
		panel_7.add(txtEstadoCivil);
		
		txtTipoSangreEnc = new JTextField();
		txtTipoSangreEnc.setColumns(10);
		txtTipoSangreEnc.setBounds(414, 239, 86, 20);
		panel_7.add(txtTipoSangreEnc);
		
		JButton btnAgregarEnc = new JButton("AGREGAR");
		btnAgregarEnc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAgregarEnc.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		btnAgregarEnc.setBounds(519, 26, 118, 23);
		panel_7.add(btnAgregarEnc);
		
		JButton btnEliminarEnc = new JButton("ELIMINAR");
		btnEliminarEnc.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		btnEliminarEnc.setBounds(519, 60, 118, 23);
		panel_7.add(btnEliminarEnc);
		
		JButton btnModificarEnc = new JButton("MODIFICAR\r\n");
		btnModificarEnc.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		btnModificarEnc.setBounds(519, 94, 118, 23);
		panel_7.add(btnModificarEnc);
		
		JButton btnConsultarEnc = new JButton("CONSULTAR");
		btnConsultarEnc.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		btnConsultarEnc.setBounds(519, 128, 118, 23);
		panel_7.add(btnConsultarEnc);
		
		JButton btnLimpiarEnc = new JButton("LIMPIAR");
		btnLimpiarEnc.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		btnLimpiarEnc.setBounds(519, 237, 118, 23);
		panel_7.add(btnLimpiarEnc);
		

		
		
		
	}
}
