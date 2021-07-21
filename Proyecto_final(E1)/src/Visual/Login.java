package Visual;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logico.Administrador;
import logico.Cliente;
import logico.Empleado;
import logico.Tienda;

import java.awt.Rectangle;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Cursor;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login extends JFrame implements Serializable{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtUSer;
	private JPasswordField txtPassword;
	private JPanel panelLogin;
	Cliente selected = null;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				FileInputStream tienda;
				FileOutputStream tienda2;
				ObjectInputStream tiendaRead;
				ObjectOutputStream tiendaWrite;
				
				try {
					tienda = new FileInputStream ("empresa.dat");
					tiendaRead = new ObjectInputStream(tienda);
					Tienda temp = (Tienda)tiendaRead.readObject();
					Tienda.setTienda(temp);
					tienda.close();
					tiendaRead.close();
					System.out.println("Leyó");
				} catch (FileNotFoundException e) {
					try {
						System.out.println("Está Creando");
						tienda2 = new  FileOutputStream("empresa.dat");
						tiendaWrite = new ObjectOutputStream(tienda2);
						Administrador aux = new Administrador("Admin", "Admin", "Administrador", "-", "-", "-");
						Tienda.getInstance().addEmpleado(aux);
						tiendaWrite.writeObject(Tienda.getInstance());
						tienda2.close();
						tiendaWrite.close();
					} catch (FileNotFoundException e1) {
					} catch (IOException e1) {
					}
				} catch (IOException e) {
					
					
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
				
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Login() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1176, 725);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(36, 37, 38));
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Login.class.getResource("/Imagenes/Tecno-4C.png")));
		lblNewLabel.setBounds(24, 28, 267, 98);
		panel.add(lblNewLabel);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(Login.class.getResource("/Imagenes/Logo.png")));
		label.setBounds(289, 28, 121, 98);
		panel.add(label);
		
		JLabel label_3 = new JLabel("");
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setIcon(new ImageIcon(Login.class.getResource("/Imagenes/pcMuestra.png")));
		label_3.setBounds(24, 145, 382, 353);
		panel.add(label_3);
		
		JLabel label_4 = new JLabel("");
		label_4.setIcon(new ImageIcon(Login.class.getResource("/Imagenes/Nombres.png")));
		label_4.setBounds(122, 533, 210, 88);
		panel.add(label_4);
		
		JLabel label_5 = new JLabel("");
		label_5.setIcon(new ImageIcon(Login.class.getResource("/Imagenes/Barra.png")));
		label_5.setBounds(24, 639, 506, 55);
		panel.add(label_5);
		
		panelLogin = new JPanel();
		panelLogin.setBackground(new Color(36, 37, 38, 100));
		panelLogin.setBounds(545, 13, 598, 681);
		panel.add(panelLogin);
		panelLogin.setLayout(null);
		
		JLabel lblParaIniciarSesin = new JLabel("Para iniciar sesi\u00F3n Ingrese su usuario y contrase\u00F1a");
		lblParaIniciarSesin.setBounds(60, 128, 497, 55);
		panelLogin.add(lblParaIniciarSesin);
		lblParaIniciarSesin.setForeground(Color.BLACK);
		lblParaIniciarSesin.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(60, 60, 243, 55);
		panelLogin.add(lblNewLabel_1);
		lblNewLabel_1.setIcon(new ImageIcon(Login.class.getResource("/Imagenes/Login.png")));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JLabel lblEmail = new JLabel("Usuario:");
		lblEmail.setBounds(70, 196, 131, 55);
		panelLogin.add(lblEmail);
		lblEmail.setIcon(new ImageIcon(Login.class.getResource("/Imagenes/Email.png")));
		lblEmail.setForeground(Color.BLACK);
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		txtUSer = new JTextField();
		txtUSer.setBounds(70, 253, 455, 50);
		panelLogin.add(txtUSer);
		txtUSer.setBorder(null);
		txtUSer.setBackground(new Color(255, 255, 255));
		txtUSer.setFont(new Font("Tahoma", Font.PLAIN, 22));
		txtUSer.setForeground(new Color(0, 153, 153));
		txtUSer.setColumns(10);
		
		JLabel label_10 = new JLabel("");
		label_10.setBounds(70, 307, 461, 3);
		panelLogin.add(label_10);
		label_10.setOpaque(true);
		label_10.setBackground(new Color(0, 153, 153));
		
		JLabel lblEmail_1 = new JLabel("Contrase\u00F1a:");
		lblEmail_1.setBounds(76, 318, 200, 55);
		panelLogin.add(lblEmail_1);
		lblEmail_1.setIcon(new ImageIcon(Login.class.getResource("/Imagenes/Password.png")));
		lblEmail_1.setForeground(Color.BLACK);
		lblEmail_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		txtPassword = new JPasswordField();
		txtPassword.setBounds(70, 386, 455, 50);
		panelLogin.add(txtPassword);
		txtPassword.setBorder(null);
		txtPassword.setFont(new Font("Tahoma", Font.PLAIN, 22));
		txtPassword.setForeground(new Color(0, 153, 153));
		
		JLabel label_11 = new JLabel("");
		label_11.setBounds(70, 438, 461, 3);
		panelLogin.add(label_11);
		label_11.setOpaque(true);
		label_11.setBackground(new Color(0, 153, 153));
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				System.out.println(txtUSer.getText());
				System.out.println(txtPassword.getText());
				if (Tienda.getInstance().confirmLogin(txtUSer.getText(), txtPassword.getText())) {
					System.out.println("PAso por aqui");
					Home frame = new Home();
					dispose();
					frame.setVisible(true);
				}
			}
		});
		btnNewButton.setBounds(66, 464, 455, 55);
		panelLogin.add(btnNewButton);
		btnNewButton.setIcon(new ImageIcon(Login.class.getResource("/Imagenes/iniciar.png")));
		
		JLabel label_9 = new JLabel("");
		label_9.setBounds(21, 5, 571, 667);
		panelLogin.add(label_9);
		label_9.setHorizontalAlignment(SwingConstants.CENTER);
		label_9.setIcon(new ImageIcon(Login.class.getResource("/Imagenes/panelLogin.png")));
		
		JLabel label_6 = new JLabel("");
		label_6.setIcon(new ImageIcon(Login.class.getResource("/Imagenes/Ellipse2.png")));
		label_6.setBounds(486, 243, 243, 142);
		panel.add(label_6);
		
		JLabel label_8 = new JLabel("");
		label_8.setIcon(new ImageIcon(Login.class.getResource("/Imagenes/Ellipse3.png")));
		label_8.setBounds(533, 275, 225, 142);
		panel.add(label_8);
		
		JLabel label_7 = new JLabel("");
		label_7.setIcon(new ImageIcon(Login.class.getResource("/Imagenes/Elipse1.png")));
		label_7.setBounds(443, 204, 256, 142);
		panel.add(label_7);
		
		final JLabel lblX = new JLabel("X");
		lblX.setBounds(1120, 0, 57, 55);
		panel.add(lblX);
		lblX.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblX.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				FileOutputStream tienda2;
				ObjectOutputStream tiendaWrite;
				try {
					tienda2 = new  FileOutputStream("empresa.dat");
					tiendaWrite = new ObjectOutputStream(tienda2);
					tiendaWrite.writeObject(Tienda.getInstance());
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				dispose();
			}
			@Override
			public void mousePressed(MouseEvent e) {
				lblX.setForeground(Color.red);
			}
		});
		lblX.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblX.setHorizontalAlignment(SwingConstants.CENTER);
		lblX.setForeground(Color.WHITE);
		
	}
	private void clean() {
		txtUSer.setText("");
		txtPassword.setText("");
	}
}