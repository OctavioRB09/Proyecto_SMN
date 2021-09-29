package Ventanas_M;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Conexion.*;

import javax.swing.JTextPane;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;

public class Loggin extends JFrame 
{

	private JPanel contentPane;
	private JTextField txtU;
	private JTextField txtC;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try 
				{
					Loggin frame = new Loggin();
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
	public Loggin() 
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextPane txtpnUsuario = new JTextPane();
		txtpnUsuario.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		txtpnUsuario.setEditable(false);
		txtpnUsuario.setText("USUARIO:");
		txtpnUsuario.setBackground(SystemColor.menu);
		txtpnUsuario.setBounds(103, 36, 85, 20);
		contentPane.add(txtpnUsuario);
		
		txtU = new JTextField();
		txtU.setBounds(198, 36, 86, 20);
		contentPane.add(txtU);
		txtU.setColumns(10);
		
		JTextPane txtpnPass = new JTextPane();
		txtpnPass.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		txtpnPass.setText("CONTRASE\u00D1A:");
		txtpnPass.setEditable(false);
		txtpnPass.setBackground(SystemColor.menu);
		txtpnPass.setBounds(103, 68, 95, 20);
		contentPane.add(txtpnPass);
		
		txtC = new JTextField();
		txtC.setColumns(10);
		txtC.setBounds(198, 68, 86, 20);
		contentPane.add(txtC);
		
		JButton bE = new JButton("ENTRAR");
		bE.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		bE.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				ConexionBD conexion = new ConexionBD(txtU.getText(), txtC.getText());
				Formulario form = new Formulario();
				form.setVisible(true);
				cerrar();
			}
		});
		bE.setBounds(155, 137, 89, 23);
		contentPane.add(bE);
	}
	
	public void cerrar()
	{
		this.dispose();
	}

}
