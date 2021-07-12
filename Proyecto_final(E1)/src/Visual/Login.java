package Visual;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Rectangle;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Cursor;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField txtemail;
	private JPasswordField passwordField;
	private JTextField textField;
	private JPasswordField passwordField_1;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JPanel panelRegistro;
	private JLabel lblIniciarSesion;
	private JPanel panelLogin;

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
		
		textField_4 = new JTextField();
		textField_4.setForeground(new Color(0, 153, 153));
		textField_4.setFont(new Font("Tahoma", Font.PLAIN, 22));
		textField_4.setColumns(10);
		textField_4.setBackground(Color.WHITE);
		textField_4.setBounds(197, 468, 363, 50);
		panelRegistro.add(textField_4);
		
		textField_3 = new JTextField();
		textField_3.setForeground(new Color(0, 153, 153));
		textField_3.setFont(new Font("Tahoma", Font.PLAIN, 22));
		textField_3.setColumns(10);
		textField_3.setBackground(Color.WHITE);
		textField_3.setBounds(216, 330, 344, 50);
		panelRegistro.add(textField_3);
		
		textField_2 = new JTextField();
		textField_2.setForeground(new Color(0, 153, 153));
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 22));
		textField_2.setColumns(10);
		textField_2.setBackground(Color.WHITE);
		textField_2.setBounds(192, 267, 368, 50);
		panelRegistro.add(textField_2);
		
		textField_1 = new JTextField();
		textField_1.setForeground(new Color(0, 153, 153));
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 22));
		textField_1.setColumns(10);
		textField_1.setBackground(Color.WHITE);
		textField_1.setBounds(182, 204, 378, 50);
		panelRegistro.add(textField_1);
		
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
		
		textField = new JTextField();
		textField.setForeground(new Color(0, 153, 153));
		textField.setFont(new Font("Tahoma", Font.PLAIN, 22));
		textField.setColumns(10);
		textField.setBackground(Color.WHITE);
		textField.setBounds(182, 141, 378, 50);
		panelRegistro.add(textField);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setIcon(new ImageIcon(Login.class.getResource("/Imagenes/Name.png")));
		lblNombre.setForeground(Color.BLACK);
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNombre.setBounds(60, 202, 125, 55);
		panelRegistro.add(lblNombre);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setForeground(new Color(0, 153, 153));
		passwordField_1.setFont(new Font("Tahoma", Font.PLAIN, 22));
		passwordField_1.setBounds(216, 400, 344, 50);
		panelRegistro.add(passwordField_1);
		
		JButton button = new JButton("");
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
		label_3.setBounds(283, 263, 382, 353);
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
		lblNewLabel_1.setIcon(new ImageIcon(Login.class.getResource("/Imagenes/loginText.png")));
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
		
		JLabel lblanNoTienes = new JLabel("\u00BFA\u00FAn no tienes una cuenta? Que MMG");
		lblanNoTienes.setBounds(124, 532, 345, 55);
		panelLogin.add(lblanNoTienes);
		lblanNoTienes.setForeground(Color.BLACK);
		lblanNoTienes.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JLabel lblRegistrarse = new JLabel("Registrate aqu\u00ED!");
		lblRegistrarse.setBounds(236, 565, 162, 55);
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
}
