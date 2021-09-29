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
import javax.swing.table.DefaultTableModel;

import Conexion.*;
import Consultas.*;

import java.awt.Font;

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
	ConexionBD conexion = new ConexionBD();
	Random r1 = new Random();
	PreparedStatement ps = null;
	ResultSet rs = null;
	String[] a = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
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
		setBounds(100, 100, 614, 431);
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
		
		JPanel Instructor = new JPanel();
		Instructor.setBackground(SystemColor.menu);
		Instructor.setToolTipText("");
		Instructor.setLayout(null);
		tabbedPane.addTab("Instructor", null, Instructor, null);
		
		JTextPane txtpnMatricula = new JTextPane();
		txtpnMatricula.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		txtpnMatricula.setText("NUM_PLACA:");
		txtpnMatricula.setForeground(Color.BLACK);
		txtpnMatricula.setEditable(false);
		txtpnMatricula.setBackground(SystemColor.menu);
		txtpnMatricula.setBounds(10, 11, 95, 20);
		Instructor.add(txtpnMatricula);
		
		txtNumP = new JTextField();
		txtNumP.setColumns(10);
		txtNumP.setBounds(115, 11, 86, 20);
		Instructor.add(txtNumP);
		
		JTextPane txtpnNombre = new JTextPane();
		txtpnNombre.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		txtpnNombre.setText("NOMBRE_INS:");
		txtpnNombre.setEditable(false);
		txtpnNombre.setBackground(SystemColor.menu);
		txtpnNombre.setBounds(10, 42, 95, 20);
		Instructor.add(txtpnNombre);
		
		txtNomI = new JTextField();
		txtNomI.setColumns(10);
		txtNomI.setBounds(115, 42, 86, 20);
		Instructor.add(txtNomI);
		
		JTextPane txtpnNombre_1 = new JTextPane();
		txtpnNombre_1.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		txtpnNombre_1.setText("APELLIDO_P:");
		txtpnNombre_1.setEditable(false);
		txtpnNombre_1.setBackground(SystemColor.menu);
		txtpnNombre_1.setBounds(10, 73, 95, 20);
		Instructor.add(txtpnNombre_1);
		
		JTextPane txtpnNombre_2 = new JTextPane();
		txtpnNombre_2.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		txtpnNombre_2.setText("APELLIDO_M:");
		txtpnNombre_2.setEditable(false);
		txtpnNombre_2.setBackground(SystemColor.menu);
		txtpnNombre_2.setBounds(10, 104, 95, 20);
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
		txtAP.setBounds(115, 73, 86, 20);
		Instructor.add(txtAP);
		
		txtAM = new JTextField();
		txtAM.setColumns(10);
		txtAM.setBounds(115, 104, 86, 20);
		Instructor.add(txtAM);
		
		txtSueldo = new JTextField();
		txtSueldo.setColumns(10);
		txtSueldo.setBounds(115, 166, 86, 20);
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
		panel.setBounds(10, 211, 573, 142);
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
		txtR.setBounds(115, 135, 86, 20);
		Instructor.add(txtR);
		txtR.setColumns(10);
		
		// Institución
		
		JPanel Institucion = new JPanel();
		tabbedPane.addTab("Instituci\u00F3n", null, Institucion, null);
		Institucion.setLayout(null);
		
		JTextPane txtpnIdintsi = new JTextPane();
		txtpnIdintsi.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		txtpnIdintsi.setText("ID_INST:");
		txtpnIdintsi.setEditable(false);
		txtpnIdintsi.setBackground(SystemColor.menu);
		txtpnIdintsi.setBounds(10, 11, 77, 20);
		Institucion.add(txtpnIdintsi);
		
		txtIdI = new JTextField();
		txtIdI.setBounds(97, 11, 86, 20);
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
		txtNI.setBounds(97, 40, 86, 20);
		Institucion.add(txtNI);
		
		JTextPane txtpnNumExte = new JTextPane();
		txtpnNumExte.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		txtpnNumExte.setText("NUM EXT:");
		txtpnNumExte.setEditable(false);
		txtpnNumExte.setBackground(SystemColor.menu);
		txtpnNumExte.setBounds(10, 130, 77, 20);
		Institucion.add(txtpnNumExte);
		
		JTextPane txtpnNumInt = new JTextPane();
		txtpnNumInt.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		txtpnNumInt.setText("NUM INT:");
		txtpnNumInt.setEditable(false);
		txtpnNumInt.setBackground(SystemColor.menu);
		txtpnNumInt.setBounds(207, 11, 77, 20);
		Institucion.add(txtpnNumInt);
		
		JTextPane txtpnNomCalle = new JTextPane();
		txtpnNomCalle.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		txtpnNomCalle.setText("NOM CALLE:");
		txtpnNomCalle.setEditable(false);
		txtpnNomCalle.setBackground(SystemColor.menu);
		txtpnNomCalle.setBounds(207, 37, 81, 20);
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
		txtCI.setBounds(97, 68, 86, 20);
		Institucion.add(txtCI);
		
		txtNEI = new JTextField();
		txtNEI.setColumns(10);
		txtNEI.setBounds(97, 130, 86, 20);
		Institucion.add(txtNEI);
		
		txtNII = new JTextField();
		txtNII.setColumns(10);
		txtNII.setBounds(294, 11, 86, 20);
		Institucion.add(txtNII);
		
		txtNCI = new JTextField();
		txtNCI.setColumns(10);
		txtNCI.setBounds(294, 40, 86, 20);
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
		txtMI.setBounds(97, 99, 86, 20);
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
		panel_1.setBounds(10, 164, 573, 189);
		Institucion.add(panel_1);
		panel_1.setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(0, 0, 573, 189);
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
	
		//Actividad
	
		JPanel Actividad = new JPanel();
		tabbedPane.addTab("Actividad", null, Actividad, null);
		Actividad.setLayout(null);
		
		JTextPane txtpnNumplaca = new JTextPane();
		txtpnNumplaca.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		txtpnNumplaca.setText("NUM_PLACA:");
		txtpnNumplaca.setBackground(SystemColor.menu);
		txtpnNumplaca.setEditable(false);
		txtpnNumplaca.setBounds(0, 11, 82, 20);
		Actividad.add(txtpnNumplaca);
		
		txtNPA = new JTextField();
		txtNPA.setBounds(92, 11, 86, 20);
		Actividad.add(txtNPA);
		txtNPA.setColumns(10);
		
		JTextPane txtpnMatriculaenc = new JTextPane();
		txtpnMatriculaenc.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		txtpnMatriculaenc.setText("MATRICULA_E:");
		txtpnMatriculaenc.setEditable(false);
		txtpnMatriculaenc.setBackground(SystemColor.menu);
		txtpnMatriculaenc.setBounds(0, 40, 82, 20);
		Actividad.add(txtpnMatriculaenc);
		
		JTextPane txtpnNs = new JTextPane();
		txtpnNs.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		txtpnNs.setText("N_SECCI\u00D3N:");
		txtpnNs.setEditable(false);
		txtpnNs.setBackground(SystemColor.menu);
		txtpnNs.setBounds(0, 71, 82, 20);
		Actividad.add(txtpnNs);
		
		JTextPane txtpnIdinst = new JTextPane();
		txtpnIdinst.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		txtpnIdinst.setText("ID_INST:");
		txtpnIdinst.setEditable(false);
		txtpnIdinst.setBackground(SystemColor.menu);
		txtpnIdinst.setBounds(0, 102, 82, 20);
		Actividad.add(txtpnIdinst);
		
		JTextPane txtpnHora = new JTextPane();
		txtpnHora.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		txtpnHora.setText("HORAINICIO:");
		txtpnHora.setEditable(false);
		txtpnHora.setBackground(SystemColor.menu);
		txtpnHora.setBounds(0, 133, 82, 20);
		Actividad.add(txtpnHora);
		
		txtMEA = new JTextField();
		txtMEA.setColumns(10);
		txtMEA.setBounds(92, 40, 86, 20);
		Actividad.add(txtMEA);
		
		txtNSA = new JTextField();
		txtNSA.setColumns(10);
		txtNSA.setBounds(92, 71, 86, 20);
		Actividad.add(txtNSA);
		
		txtIIA = new JTextField();
		txtIIA.setColumns(10);
		txtIIA.setBounds(92, 102, 86, 20);
		Actividad.add(txtIIA);
		
		txtHIA = new JTextField();
		txtHIA.setColumns(10);
		txtHIA.setBounds(92, 133, 86, 20);
		Actividad.add(txtHIA);
		
		JTextPane txtpnHorafin = new JTextPane();
		txtpnHorafin.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		txtpnHorafin.setText("HORAFIN:");
		txtpnHorafin.setEditable(false);
		txtpnHorafin.setBackground(SystemColor.menu);
		txtpnHorafin.setBounds(0, 164, 70, 20);
		Actividad.add(txtpnHorafin);
		
		JTextPane txtpnFecha = new JTextPane();
		txtpnFecha.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		txtpnFecha.setText("FECHA:");
		txtpnFecha.setEditable(false);
		txtpnFecha.setBackground(SystemColor.menu);
		txtpnFecha.setBounds(188, 11, 70, 20);
		Actividad.add(txtpnFecha);
		
		txtHFA = new JTextField();
		txtHFA.setColumns(10);
		txtHFA.setBounds(92, 164, 86, 20);
		Actividad.add(txtHFA);
		
		txtFA = new JTextField();
		txtFA.setColumns(10);
		txtFA.setBounds(287, 11, 86, 20);
		Actividad.add(txtFA);
		
		JTextPane txtpnTactividad = new JTextPane();
		txtpnTactividad.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		txtpnTactividad.setText("T_ACTIVIDAD:");
		txtpnTactividad.setEditable(false);
		txtpnTactividad.setBackground(SystemColor.menu);
		txtpnTactividad.setBounds(188, 40, 89, 20);
		Actividad.add(txtpnTactividad);
		
		JTextPane txtpnCosteact = new JTextPane();
		txtpnCosteact.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		txtpnCosteact.setText("COSTE_ACT:");
		txtpnCosteact.setEditable(false);
		txtpnCosteact.setBackground(SystemColor.menu);
		txtpnCosteact.setBounds(188, 71, 89, 20);
		Actividad.add(txtpnCosteact);
		
		txtTAA = new JTextField();
		txtTAA.setColumns(10);
		txtTAA.setBounds(287, 40, 86, 20);
		Actividad.add(txtTAA);
		
		txtCAA = new JTextField();
		txtCAA.setColumns(10);
		txtCAA.setBounds(287, 71, 86, 20);
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
		panel_2.setBounds(10, 195, 573, 158);
		Actividad.add(panel_2);
		panel_2.setLayout(null);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(0, 0, 573, 189);
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
		
		//NumTel_Institucion
		
		JPanel NumTel = new JPanel();
		tabbedPane.addTab("numtel_institucion", null, NumTel, null);
		NumTel.setLayout(null);
		
		JTextPane txtpnIdinstitucin = new JTextPane();
		txtpnIdinstitucin.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		txtpnIdinstitucin.setBackground(SystemColor.menu);
		txtpnIdinstitucin.setText("ID_INSTITUCI\u00D3N:");
		txtpnIdinstitucin.setEditable(false);
		txtpnIdinstitucin.setBounds(10, 11, 123, 20);
		NumTel.add(txtpnIdinstitucin);
		
		txtIINT = new JTextField();
		txtIINT.setBounds(143, 11, 123, 20);
		NumTel.add(txtIINT);
		txtIINT.setColumns(10);
		
		JTextPane txtpnN = new JTextPane();
		txtpnN.setText("NUMTELEFONO:");
		txtpnN.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		txtpnN.setEditable(false);
		txtpnN.setBackground(SystemColor.menu);
		txtpnN.setBounds(10, 42, 123, 20);
		NumTel.add(txtpnN);
		
		txtNTNT = new JTextField();
		txtNTNT.setColumns(10);
		txtNTNT.setBounds(143, 42, 123, 20);
		NumTel.add(txtNTNT);
		
		txtNTMNT = new JTextField();
		txtNTMNT.setColumns(10);
		txtNTMNT.setBounds(143, 81, 123, 20);
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
		bLNT.setBounds(10, 114, 114, 23);
		NumTel.add(bLNT);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(10, 171, 573, 182);
		NumTel.add(panel_3);
		panel_3.setLayout(null);
		
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(0, 0, 574, 185);
		panel_3.add(scrollPane_3);
		
		table_3 = new JTable();
		table_3.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
		scrollPane_3.setViewportView(table_3);
		
		JTextPane txtpnNumtelefonomod = new JTextPane();
		txtpnNumtelefonomod.setText("NUMTELEFONOMOD:");
		txtpnNumtelefonomod.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		txtpnNumtelefonomod.setEditable(false);
		txtpnNumtelefonomod.setBackground(SystemColor.menu);
		txtpnNumtelefonomod.setBounds(10, 83, 123, 20);
		NumTel.add(txtpnNumtelefonomod);
		
		// Escuadron 
		
		JPanel Escuadron = new JPanel();
		tabbedPane.addTab("Escuadron", null, Escuadron, null);
		Escuadron.setLayout(null);
		
		JTextPane txtpnNseccin = new JTextPane();
		txtpnNseccin.setText("N_SECCI\u00D3N:");
		txtpnNseccin.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		txtpnNseccin.setEditable(false);
		txtpnNseccin.setBackground(SystemColor.menu);
		txtpnNseccin.setBounds(10, 11, 86, 20);
		Escuadron.add(txtpnNseccin);
		
		txtNSE = new JTextField();
		txtNSE.setBounds(106, 11, 123, 20);
		Escuadron.add(txtNSE);
		txtNSE.setColumns(10);
		
		JTextPane txtpnNum = new JTextPane();
		txtpnNum.setText("NUM_INTE:");
		txtpnNum.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		txtpnNum.setEditable(false);
		txtpnNum.setBackground(SystemColor.menu);
		txtpnNum.setBounds(10, 42, 86, 20);
		Escuadron.add(txtpnNum);
		
		txtNIE = new JTextField();
		txtNIE.setColumns(10);
		txtNIE.setBounds(106, 42, 123, 20);
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
		
		//Participa_Res
		
		JPanel ParticipaRes = new JPanel();
		tabbedPane.addTab("Participa_res", null, ParticipaRes, null);
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
		panel_5.setBounds(10, 170, 563, 173);
		ParticipaRes.add(panel_5);
		panel_5.setLayout(null);
		
		JScrollPane scrollPane_5 = new JScrollPane();
		scrollPane_5.setBounds(0, 0, 563, 173);
		panel_5.add(scrollPane_5);
		
		table_5 = new JTable();
		scrollPane_5.setViewportView(table_5);
	}
}
