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
	private JTextField textField;
	private JTextField textField_1;
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
		
//-->> INICIO DEL PANEL DE ESCUADRON
		
		JPanel Escuadron = new JPanel();
		tabbedPane.addTab("Escuadron", null, Escuadron, null);
		tabbedPane.setEnabledAt(4, false);
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
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(223, 31, 86, 20);
		Sorteo.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(223, 62, 86, 20);
		Sorteo.add(textField_1);
		
		JButton btnAgregar_S = new JButton("AGREGAR");
		btnAgregar_S.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		btnAgregar_S.setBounds(496, 30, 108, 23);
		Sorteo.add(btnAgregar_S);
		
		
		JButton btnEliminar_S = new JButton("ELIMINAR");
		btnEliminar_S.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		btnEliminar_S.setBounds(496, 61, 108, 23);
		Sorteo.add(btnEliminar_S);
		
		JButton btnModificar_S = new JButton("MODIFICAR");
		btnModificar_S.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		btnModificar_S.setBounds(496, 92, 108, 23);
		Sorteo.add(btnModificar_S);
		
		JButton btnLimpiar_S = new JButton("LIMPIAR");
		btnLimpiar_S.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		btnLimpiar_S.setBounds(496, 157, 108, 23);
		Sorteo.add(btnLimpiar_S);
		
		JPanel pnlTabla_1 = new JPanel();
		pnlTabla_1.setLayout(null);
		pnlTabla_1.setBounds(60, 207, 544, 172);
		Sorteo.add(pnlTabla_1);
		
		JScrollPane spTabla_1 = new JScrollPane();
		spTabla_1.setBounds(0, 0, 544, 172);
		pnlTabla_1.add(spTabla_1);
		
		JButton btnConsultar_S = new JButton("CONSULTAR");
		btnConsultar_S.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		btnConsultar_S.setBounds(496, 123, 108, 23);
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
				
				etNumLiberacion.setText(datos[1]);
				etPrecioCart.setText(datos[2]);
				etMesRecepcion.setText(datos[3]);
				
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
		
		//--------------------------------------inicia panel Cartilla ---------------------------//
		JPanel Cartilla = new JPanel();
		tabbedPane.addTab("Cartilla", null, Cartilla, null);
		Cartilla.setLayout(null);
		
		JScrollPane Muestra_Cartilla = new JScrollPane();
		Muestra_Cartilla.setBounds(21, 237, 573, 142);
		Cartilla.add(Muestra_Cartilla);
		
		JLabel lblNum_Liberación = new JLabel("NUM_LIBERACI\u00D3N");
		lblNum_Liberación.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		lblNum_Liberación.setBounds(21, 106, 118, 14);
		Cartilla.add(lblNum_Liberación);
		 
		txtNum_LiberacionCartilla = new JTextField();
		txtNum_LiberacionCartilla.setBounds(21, 131, 118, 20);
		Cartilla.add(txtNum_LiberacionCartilla);
		txtNum_LiberacionCartilla.setColumns(10);
		
		JLabel lblZona_Militar = new JLabel("ZONA_MILITAR");
		lblZona_Militar.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		lblZona_Militar.setBounds(176, 106, 118, 14);
		Cartilla.add(lblZona_Militar);
		
		txtZona_Militar = new JTextField();
		txtZona_Militar.setColumns(10);
		txtZona_Militar.setBounds(176, 131, 118, 20);
		Cartilla.add(txtZona_Militar);
		
		JLabel lblRegimiento = new JLabel("REGIMIENTO");
		lblRegimiento.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		lblRegimiento.setBounds(331, 106, 118, 14);
		Cartilla.add(lblRegimiento);
		
		txtRegimiento = new JTextField();
		txtRegimiento.setColumns(10);
		txtRegimiento.setBounds(331, 131, 118, 20);
		Cartilla.add(txtRegimiento);
		
		JButton btnEliminarCar = new JButton("ELIMINAR");
		btnEliminarCar.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		btnEliminarCar.setBounds(476, 57, 118, 23);
		Cartilla.add(btnEliminarCar);
		
		JButton btnAgregarCar = new JButton("AGREGAR");
		btnAgregarCar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
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
		btnAgregarCar.setBounds(476, 23, 118, 23);
		Cartilla.add(btnAgregarCar);
		
		JButton btnModificarCar = new JButton("MODIFICAR\r\n");
		btnModificarCar.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		btnModificarCar.setBounds(476, 91, 118, 23);
		Cartilla.add(btnModificarCar);
		
		JButton btnConsultarCar = new JButton("CONSULTAR");
		btnConsultarCar.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		btnConsultarCar.setBounds(476, 125, 118, 23);
		Cartilla.add(btnConsultarCar);
		
		JButton btnLimpiarCar = new JButton("LIMPIAR");
		btnLimpiarCar.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		btnLimpiarCar.setBounds(476, 203, 118, 23);
		Cartilla.add(btnLimpiarCar);
		

		
		
		
	}
}
