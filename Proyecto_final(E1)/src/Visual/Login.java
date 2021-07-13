package Visual;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logico.Cliente;
import logico.Tienda;

import java.awt.Rectangle;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Cursor;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField txtemail;
	private JPasswordField passwordField;
	private JPasswordField txtPassword;
	private JTextField txtNombre;
	private JTextField txtTelefono;
	private JTextField txtUsername;
	private JTextField txtDireccion;
	private JPanel panelRegistro;
	private JLabel lblIniciarSesion;
	private JPanel panelLogin;
	Cliente selected = null;
	private JTextField txtcedula;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Login() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1400, 741);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(36, 37, 38));
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		final JLabel lblX = new JLabel("X");
		lblX.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblX.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
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
		lblX.setBounds(1333, 0, 57, 55);
		panel.add(lblX);
		
		panelRegistro = new JPanel();
		panelRegistro.setVisible(false);
		panelRegistro.setLayout(null);
		panelRegistro.setBackground(new Color(36, 37, 38, 100));
		panelRegistro.setBounds(770, 25, 613, 681);
		panel.add(panelRegistro);
		
		txtDireccion = new JTextField();
		txtDireccion.setForeground(new Color(0, 153, 153));
		txtDireccion.setFont(new Font("Tahoma", Font.PLAIN, 22));
		txtDireccion.setColumns(10);
		txtDireccion.setBackground(Color.WHITE);
		txtDireccion.setBounds(216, 466, 344, 50);
		panelRegistro.add(txtDireccion);
		
		txtUsername = new JTextField();
		txtUsername.setForeground(new Color(0, 153, 153));
		txtUsername.setFont(new Font("Tahoma", Font.PLAIN, 22));
		txtUsername.setColumns(10);
		txtUsername.setBackground(Color.WHITE);
		txtUsername.setBounds(216, 336, 344, 50);
		panelRegistro.add(txtUsername);
		
		txtTelefono = new JTextField();
		txtTelefono.setForeground(new Color(0, 153, 153));
		txtTelefono.setFont(new Font("Tahoma", Font.PLAIN, 22));
		txtTelefono.setColumns(10);
		txtTelefono.setBackground(Color.WHITE);
		txtTelefono.setBounds(216, 271, 344, 50);
		panelRegistro.add(txtTelefono);
		
		txtNombre = new JTextField();
		txtNombre.setForeground(new Color(0, 153, 153));
		txtNombre.setFont(new Font("Tahoma", Font.PLAIN, 22));
		txtNombre.setColumns(10);
		txtNombre.setBackground(Color.WHITE);
		txtNombre.setBounds(216, 206, 344, 50);
		panelRegistro.add(txtNombre);
		
		JLabel lblDireccin = new JLabel("Direcci\u00F3n:");
		lblDireccin.setIcon(new ImageIcon(Login.class.getResource("/Imagenes/ubicacion.png")));
		lblDireccin.setForeground(Color.BLACK);
		lblDireccin.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblDireccin.setBounds(60, 466, 136, 55);
		panelRegistro.add(lblDireccin);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a:");
		lblContrasea.setIcon(new ImageIcon(Login.class.getResource("/Imagenes/Password.png")));
		lblContrasea.setForeground(Color.BLACK);
		lblContrasea.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblContrasea.setBounds(60, 398, 162, 55);
		panelRegistro.add(lblContrasea);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setIcon(new ImageIcon(Login.class.getResource("/Imagenes/Email.png")));
		lblUsername.setForeground(Color.BLACK);
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblUsername.setBounds(60, 328, 162, 55);
		panelRegistro.add(lblUsername);
		
		JLabel lblNmero = new JLabel("N\u00FAmero:");
		lblNmero.setIcon(new ImageIcon(Login.class.getResource("/Imagenes/Telefono.png")));
		lblNmero.setForeground(Color.BLACK);
		lblNmero.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNmero.setBounds(60, 265, 125, 55);
		panelRegistro.add(lblNmero);
		
		JLabel lblRegistrar = new JLabel("");
		lblRegistrar.setIcon(new ImageIcon(Login.class.getResource("/Imagenes/Registro.png")));
		lblRegistrar.setFont(new Font("Tahoma", Font.PLAIN, 35));
		lblRegistrar.setBounds(60, 60, 243, 55);
		panelRegistro.add(lblRegistrar);
		
		JLabel label_14 = new JLabel("C\u00E9dula:");
		label_14.setIcon(new ImageIcon(Login.class.getResource("/Imagenes/Cedula.png")));
		label_14.setForeground(Color.BLACK);
		label_14.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label_14.setBounds(58, 139, 125, 55);
		panelRegistro.add(label_14);
		
		txtcedula = new JTextField();
		txtcedula.setForeground(new Color(0, 153, 153));
		txtcedula.setFont(new Font("Tahoma", Font.PLAIN, 22));
		txtcedula.setColumns(10);
		txtcedula.setBackground(Color.WHITE);
		txtcedula.setBounds(216, 141, 344, 50);
		panelRegistro.add(txtcedula);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setIcon(new ImageIcon(Login.class.getResource("/Imagenes/Name.png")));
		lblNombre.setForeground(Color.BLACK);
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNombre.setBounds(60, 202, 125, 55);
		panelRegistro.add(lblNombre);
		
		txtPassword = new JPasswordField();
		txtPassword.setForeground(new Color(0, 153, 153));
		txtPassword.setFont(new Font("Tahoma", Font.PLAIN, 22));
		txtPassword.setBounds(216, 401, 344, 50);
		panelRegistro.add(txtPassword);
		
		JButton button = new JButton("");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if (txtcedula.getText().equalsIgnoreCase("") || txtDireccion.getText().equalsIgnoreCase("") || txtNombre.getText().equalsIgnoreCase("") || txtPassword.getPassword().length == 0
						|| txtTelefono.getText().equalsIgnoreCase("") || txtUsername.getText().equalsIgnoreCase("")) {
					JOptionPane.showMessageDialog(null, "Debes llenar todos los campos !", "Registro de Cliente", JOptionPane.WARNING_MESSAGE);
				}else {
				/*
					String cedula = txtcedula.getText();
					String username = txtUsername.getText();
					
					if (Tienda.getInstance().buscarClienteByCedula(cedula) == null && Tienda.getInstance().buscarClienteByUsername(username) == null) { 
						selected = new Cliente(cedula, txtNombre.getText(), txtDireccion.getText(), txtTelefono.getText(),username,txtPassword.getPassword());
						Tienda.getInstance().addCliente(selected);
						JOptionPane.showMessageDialog(null, "Cliente registrado satisfactoriamente.", "Registro de Cliente", JOptionPane.INFORMATION_MESSAGE);
						panelRegistro.setVisible(false);
						panelLogin.setVisible(true);
						clean();
					}else if (Tienda.getInstance().buscarClienteByCedula(cedula) != null && Tienda.getInstance().buscarClienteByUsername(username) != null){
						JOptionPane.showMessageDialog(null, "El cliente ya existe. Favor de iniciar sesión.", "Registro de Cliente", JOptionPane.WARNING_MESSAGE);
						clean();
					}else if(Tienda.getInstance().buscarClienteByUsername(username) != null) {
						JOptionPane.showMessageDialog(null, "Username ya existe. Favor de digitar otro.", "Registro de Cliente", JOptionPane.WARNING_MESSAGE);
						txtUsername.setText("");
					}else if(Tienda.getInstance().buscarClienteByCedula(cedula) != null) {
						JOptionPane.showMessageDialog(null, "Ya existe un usuario con esa cédula !", "Registro de Cliente", JOptionPane.WARNING_MESSAGE);
						clean();
					}
				*/
				}
			}

		});
		button.setIcon(new ImageIcon(Login.class.getResource("/Imagenes/Registrarse.png")));
		button.setBounds(60, 534, 500, 55);
		panelRegistro.add(button);
		
		JLabel lblyaTienesUna = new JLabel("\u00BFYa tienes una cuenta?");
		lblyaTienesUna.setForeground(Color.BLACK);
		lblyaTienesUna.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblyaTienesUna.setBounds(104, 602, 225, 55);
		panelRegistro.add(lblyaTienesUna);
		
		lblIniciarSesion = new JLabel("Iniciar Sesi\u00F3n");
		lblIniciarSesion.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblIniciarSesion.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				clean();
				panelLogin.setVisible(true);
				panelRegistro.setVisible(false);
			}
		});
		lblIniciarSesion.setForeground(Color.BLUE);
		lblIniciarSesion.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblIniciarSesion.setBounds(319, 602, 162, 55);
		panelRegistro.add(lblIniciarSesion);
		
		JLabel label_20 = new JLabel("");
		label_20.setIcon(new ImageIcon(Login.class.getResource("/Imagenes/panelLogin.png")));
		label_20.setHorizontalAlignment(SwingConstants.CENTER);
		label_20.setBounds(21, 5, 571, 667);
		panelRegistro.add(label_20);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Login.class.getResource("/Imagenes/Tecno-4C.png")));
		lblNewLabel.setBounds(72, 54, 267, 98);
		panel.add(lblNewLabel);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(Login.class.getResource("/Imagenes/Logo.png")));
		label.setBounds(336, 54, 121, 98);
		panel.add(label);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(Login.class.getResource("/Imagenes/Upgrade.png")));
		label_1.setBounds(45, 156, 615, 142);
		panel.add(label_1);
		
		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon(Login.class.getResource("/Imagenes/Caracteristicas.png")));
		label_2.setBounds(45, 350, 210, 142);
		panel.add(label_2);
		
		JLabel label_3 = new JLabel("");
		label_3.setIcon(new ImageIcon(Login.class.getResource("/Imagenes/pcMuestra.png")));
		label_3.setBounds(368, 257, 382, 353);
		panel.add(label_3);
		
		JLabel label_4 = new JLabel("");
		label_4.setIcon(new ImageIcon(Login.class.getResource("/Imagenes/Nombres.png")));
		label_4.setBounds(44, 591, 210, 88);
		panel.add(label_4);
		
		JLabel label_5 = new JLabel("");
		label_5.setIcon(new ImageIcon(Login.class.getResource("/Imagenes/Barra.png")));
		label_5.setBounds(269, 629, 506, 55);
		panel.add(label_5);
		
		panelLogin = new JPanel();
		panelLogin.setBackground(new Color(36, 37, 38, 100));
		panelLogin.setBounds(765, 25, 613, 681);
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
		
		txtemail = new JTextField();
		txtemail.setBounds(70, 253, 455, 50);
		panelLogin.add(txtemail);
		txtemail.setBorder(null);
		txtemail.setBackground(new Color(255, 255, 255));
		txtemail.setFont(new Font("Tahoma", Font.PLAIN, 22));
		txtemail.setForeground(new Color(0, 153, 153));
		txtemail.setColumns(10);
		
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
		
		passwordField = new JPasswordField();
		passwordField.setBounds(70, 386, 455, 50);
		panelLogin.add(passwordField);
		passwordField.setBorder(null);
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 22));
		passwordField.setForeground(new Color(0, 153, 153));
		
		JLabel label_11 = new JLabel("");
		label_11.setBounds(70, 438, 461, 3);
		panelLogin.add(label_11);
		label_11.setOpaque(true);
		label_11.setBackground(new Color(0, 153, 153));
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setBounds(66, 464, 455, 55);
		panelLogin.add(btnNewButton);
		btnNewButton.setIcon(new ImageIcon(Login.class.getResource("/Imagenes/iniciar.png")));
		
		JLabel lblanNoTienes = new JLabel("\u00BFA\u00FAn no tienes una cuenta?");
		lblanNoTienes.setBounds(100, 540, 345, 55);
		panelLogin.add(lblanNoTienes);
		lblanNoTienes.setForeground(Color.BLACK);
		lblanNoTienes.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JLabel lblRegistrarse = new JLabel("Registrate aqu\u00ED!");
		lblRegistrarse.setBounds(350, 540, 162, 55);
		panelLogin.add(lblRegistrarse);
		lblRegistrarse.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panelRegistro.setVisible(true);
				panelLogin.setVisible(false);
			}
		});
		lblRegistrarse.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblRegistrarse.setForeground(new Color(0, 0, 255));
		lblRegistrarse.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JLabel label_9 = new JLabel("");
		label_9.setBounds(21, 5, 571, 667);
		panelLogin.add(label_9);
		label_9.setHorizontalAlignment(SwingConstants.CENTER);
		label_9.setIcon(new ImageIcon(Login.class.getResource("/Imagenes/panelLogin.png")));
		
		JLabel label_6 = new JLabel("");
		label_6.setIcon(new ImageIcon(Login.class.getResource("/Imagenes/Ellipse2.png")));
		label_6.setBounds(671, 257, 243, 142);
		panel.add(label_6);
		
		JLabel label_8 = new JLabel("");
		label_8.setIcon(new ImageIcon(Login.class.getResource("/Imagenes/Ellipse3.png")));
		label_8.setBounds(718, 289, 225, 142);
		panel.add(label_8);
		
		JLabel label_7 = new JLabel("");
		label_7.setIcon(new ImageIcon(Login.class.getResource("/Imagenes/Elipse1.png")));
		label_7.setBounds(628, 218, 256, 142);
		panel.add(label_7);
		
	}
	private void clean() {
		txtemail.setText("");
		passwordField.setText("");
		txtcedula.setText("");
		txtDireccion.setText("");
		txtNombre.setText("");
		txtPassword.setText("");
		txtTelefono.setText("");
		txtUsername.setText("");
	}
}