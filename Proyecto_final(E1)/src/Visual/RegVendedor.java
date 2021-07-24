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
import logico.Vendedor;

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
import javax.swing.JDialog;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RegVendedor extends JDialog {

	private JPanel contentPane;
	private JPasswordField txtPassword;
	private JTextField txtNombre;
	private JTextField txtTelefono;
	private JTextField txtUsername;
	private JTextField txtDireccion;
	private JPanel panelRegistro;
	Empleado selected = null;
	private JTextField txtcedula;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegVendedor dialog = new RegVendedor(null);
					dialog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public RegVendedor(Empleado empleado) {
		selected = empleado;
		setUndecorated(true);
		setBounds(100, 100, 586, 600);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(36, 37, 38));
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		panelRegistro = new JPanel();
		panelRegistro.setLayout(null);
		panelRegistro.setBackground(Color.WHITE);
		panelRegistro.setBounds(11, 12, 553, 567);
		panel.add(panelRegistro);
		
		txtDireccion = new JTextField();
		txtDireccion.setForeground(new Color(0, 153, 153));
		txtDireccion.setFont(new Font("Tahoma", Font.PLAIN, 22));
		txtDireccion.setColumns(10);
		txtDireccion.setBackground(Color.WHITE);
		txtDireccion.setBounds(190, 428, 344, 50);
		panelRegistro.add(txtDireccion);
		
		txtUsername = new JTextField();
		txtUsername.setForeground(new Color(0, 153, 153));
		txtUsername.setFont(new Font("Tahoma", Font.PLAIN, 22));
		txtUsername.setColumns(10);
		txtUsername.setBackground(Color.WHITE);
		txtUsername.setBounds(190, 298, 344, 50);
		panelRegistro.add(txtUsername);
		
		txtTelefono = new JTextField();
		txtTelefono.setForeground(new Color(0, 153, 153));
		txtTelefono.setFont(new Font("Tahoma", Font.PLAIN, 22));
		txtTelefono.setColumns(10);
		txtTelefono.setBackground(Color.WHITE);
		txtTelefono.setBounds(190, 233, 344, 50);
		panelRegistro.add(txtTelefono);
		
		txtNombre = new JTextField();
		txtNombre.setForeground(new Color(0, 153, 153));
		txtNombre.setFont(new Font("Tahoma", Font.PLAIN, 22));
		txtNombre.setColumns(10);
		txtNombre.setBackground(Color.WHITE);
		txtNombre.setBounds(190, 168, 344, 50);
		panelRegistro.add(txtNombre);
		
		JLabel lblDireccin = new JLabel("Direcci\u00F3n:");
		lblDireccin.setIcon(new ImageIcon(Login.class.getResource("/Imagenes/ubicacion.png")));
		lblDireccin.setForeground(Color.BLACK);
		lblDireccin.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblDireccin.setBounds(34, 428, 136, 55);
		panelRegistro.add(lblDireccin);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a:");
		lblContrasea.setIcon(new ImageIcon(Login.class.getResource("/Imagenes/Password.png")));
		lblContrasea.setForeground(Color.BLACK);
		lblContrasea.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblContrasea.setBounds(34, 360, 162, 55);
		panelRegistro.add(lblContrasea);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setIcon(new ImageIcon(Login.class.getResource("/Imagenes/Email.png")));
		lblUsername.setForeground(Color.BLACK);
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblUsername.setBounds(34, 290, 162, 55);
		panelRegistro.add(lblUsername);
		
		JLabel lblNmero = new JLabel("N\u00FAmero:");
		lblNmero.setIcon(new ImageIcon(Login.class.getResource("/Imagenes/Telefono.png")));
		lblNmero.setForeground(Color.BLACK);
		lblNmero.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNmero.setBounds(34, 227, 125, 55);
		panelRegistro.add(lblNmero);
		
		JLabel lblTitle = new JLabel("Registrar Vendedor:");
		lblTitle.setFont(new Font("Tahoma", Font.PLAIN, 35));
		lblTitle.setBounds(33, 13, 431, 55);
		panelRegistro.add(lblTitle);
		
		JLabel label_14 = new JLabel("C\u00E9dula:");
		label_14.setIcon(new ImageIcon(Login.class.getResource("/Imagenes/Cedula.png")));
		label_14.setForeground(Color.BLACK);
		label_14.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label_14.setBounds(32, 101, 125, 55);
		panelRegistro.add(label_14);
		
		txtcedula = new JTextField();
		txtcedula.setForeground(new Color(0, 153, 153));
		txtcedula.setFont(new Font("Tahoma", Font.PLAIN, 22));
		txtcedula.setColumns(10);
		txtcedula.setBackground(Color.WHITE);
		txtcedula.setBounds(190, 103, 344, 50);
		panelRegistro.add(txtcedula);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setIcon(new ImageIcon(Login.class.getResource("/Imagenes/Name.png")));
		lblNombre.setForeground(Color.BLACK);
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNombre.setBounds(34, 164, 125, 55);
		panelRegistro.add(lblNombre);
		
		txtPassword = new JPasswordField();
		txtPassword.setForeground(new Color(0, 153, 153));
		txtPassword.setFont(new Font("Tahoma", Font.PLAIN, 22));
		txtPassword.setBounds(190, 363, 344, 50);
		panelRegistro.add(txtPassword);
		
		JLabel lblNewLabel = new JLabel("Cancelar");
		lblNewLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBackground(new Color(0, 155, 124));
		lblNewLabel.setOpaque(true);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(34, 496, 225, 55);
		panelRegistro.add(lblNewLabel);
		
		final JLabel lblX = new JLabel("X");
		lblX.setBounds(496, 0, 57, 55);
		panelRegistro.add(lblX);
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
		lblX.setForeground(Color.DARK_GRAY);
		
		JLabel lblConfirmar = new JLabel("Registrar");
		lblConfirmar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblConfirmar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("1");
				if (selected == null) {
					System.out.println("2");
					if (txtcedula.getText().equalsIgnoreCase("") || txtDireccion.getText().equalsIgnoreCase("") || txtNombre.getText().equalsIgnoreCase("") || txtPassword.getPassword().length == 0
							|| txtTelefono.getText().equalsIgnoreCase("") || txtUsername.getText().equalsIgnoreCase("")) {
						JOptionPane.showMessageDialog(null, "Debes llenar todos los campos !", "Registro de Vendedor", JOptionPane.WARNING_MESSAGE);
					}else {
						System.out.println("3");
						Vendedor vendedor = new Vendedor(txtUsername.getText(), txtPassword.getText(), txtNombre.getText(), txtcedula.getText(), txtTelefono.getText(), txtDireccion.getText());
						Tienda.getInstance().addEmpleado(vendedor);
						JOptionPane.showMessageDialog(null, "Vendedor registrado correctamente", "Registrar vendedor", JOptionPane.CLOSED_OPTION);
						clean();
						ListarVendedor.loadTableVendedor(null);
					}
				}
				else {
					if (selected instanceof Vendedor) {
						System.out.println("4");
						JOptionPane.showMessageDialog(null, "Modificar Vendedor");
					}
				}
				if (selected instanceof Administrador){
					System.out.println("5");
					if (txtcedula.getText().equalsIgnoreCase("") || txtDireccion.getText().equalsIgnoreCase("") || txtNombre.getText().equalsIgnoreCase("") || txtPassword.getPassword().length == 0
							|| txtTelefono.getText().equalsIgnoreCase("") || txtUsername.getText().equalsIgnoreCase("")) {
						JOptionPane.showMessageDialog(null, "Debes llenar todos los campos!", "Modificar Administrador", JOptionPane.WARNING_MESSAGE);
					}else {
						System.out.println("6");
						 selected.setCedula(txtcedula.getText());
						 selected.setDireccion(txtDireccion.getText());
						 selected.setNombre(txtNombre.getText());
						 selected.setTelefono(txtTelefono.getText());
						 selected.setUsername(txtUsername.getText());
						 selected.setPassword(txtPassword.getText());
						 JOptionPane.showMessageDialog(null, "Administrador modificado correctamente", "Modificar Administrador", JOptionPane.CLOSED_OPTION);
						 loadAdministrador();
						 Home.loadHome();
					}
				}
			}
		});
		lblConfirmar.setOpaque(true);
		lblConfirmar.setHorizontalAlignment(SwingConstants.CENTER);
		lblConfirmar.setForeground(Color.WHITE);
		lblConfirmar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblConfirmar.setBackground(new Color(0, 155, 124));
		lblConfirmar.setBounds(293, 496, 225, 55);
		panelRegistro.add(lblConfirmar);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 155, 124));
		panel_1.setBounds(34, 64, 390, 4);
		panelRegistro.add(panel_1);
		
		if (selected instanceof Administrador) {
			loadAdministrador();
			lblConfirmar.setText("Modificar");
			lblTitle.setText("Modificar Administrador:");
		}
		
	}
	private void clean() {
		txtcedula.setText("");
		txtDireccion.setText("");
		txtNombre.setText("");
		txtPassword.setText("");
		txtTelefono.setText("");
		txtUsername.setText("");
	}
	private void loadAdministrador() {
		txtcedula.setText(selected.getCedula());
		txtDireccion.setText(selected.getDireccion());
		txtNombre.setText(selected.getNombre());
		txtPassword.setText(selected.getPassword());
		txtTelefono.setText(selected.getTelefono());
		txtUsername.setText(selected.getUsername());
	}
}