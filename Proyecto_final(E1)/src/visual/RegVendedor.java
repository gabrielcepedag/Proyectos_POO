package visual;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logico.Administrador;
import logico.Cliente;
import logico.CopiarYPegar;
import logico.Empleado;
import logico.Tienda;
import logico.Vendedor;

import java.awt.Rectangle;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Cursor;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;

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
	private JLabel labelIcon;
	private File f;
	private JLabel lblCargarImagen;

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
	 * @throws IOException 
	 */
	public RegVendedor(Empleado empleado) throws IOException {
		selected = empleado;
		setUndecorated(true);
		setBounds(100, 100, 919, 600);
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
		panelRegistro.setBounds(11, 12, 886, 567);
		panel.add(panelRegistro);
		
		labelIcon = new JLabel("");
		labelIcon.setHorizontalAlignment(SwingConstants.CENTER);
		labelIcon.setBounds(552, 233, 321, 251);
		panelRegistro.add(labelIcon);
		labelIcon.setBorder(new LineBorder(new Color(0, 155, 124), 5));
		labelIcon.setForeground(Color.BLACK);
		labelIcon.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		lblCargarImagen = new JLabel("Cargar Imagen");
		lblCargarImagen.setBounds(552, 496, 321, 55);
		panelRegistro.add(lblCargarImagen);
		lblCargarImagen.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (lblCargarImagen.isEnabled()) {
					try {
						JFileChooser jfc = new JFileChooser();
				        jfc.showOpenDialog(null);
				        f = jfc.getSelectedFile();
				        Image bi;
						bi = ImageIO.read(f);
						labelIcon.setText("");
						labelIcon.setIcon(new ImageIcon(bi.getScaledInstance(234,203, 0)));
					    CopiarYPegar copiarYPegar = new CopiarYPegar(f.getPath(), "src/ImagenesEmpleados/Archivo"+txtcedula.getText()+".jpg");
					} catch (IOException i) {
						i.printStackTrace();
					}
				}
			}
		});
		lblCargarImagen.setOpaque(true);
		lblCargarImagen.setHorizontalAlignment(SwingConstants.CENTER);
		lblCargarImagen.setForeground(Color.WHITE);
		lblCargarImagen.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblCargarImagen.setBackground(new Color(0, 155, 124));
		
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
		txtNombre.setBounds(190, 168, 683, 50);
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
		txtcedula.setBounds(190, 103, 683, 50);
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
		lblX.setBounds(817, 0, 57, 55);
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
				if (selected == null) {
					if (txtcedula.getText().equalsIgnoreCase("") || txtDireccion.getText().equalsIgnoreCase("") || txtNombre.getText().equalsIgnoreCase("") || txtPassword.getPassword().length == 0
							|| txtTelefono.getText().equalsIgnoreCase("") || txtUsername.getText().equalsIgnoreCase("")) {
						JOptionPane.showMessageDialog(null, "Debes llenar todos los campos !", "Registro de Vendedor", JOptionPane.WARNING_MESSAGE);
					}else {
						Vendedor vendedor = new Vendedor(txtUsername.getText(), txtPassword.getText(), txtNombre.getText(), txtcedula.getText(), txtTelefono.getText(), txtDireccion.getText());
						Tienda.getInstance().addEmpleado(vendedor);
						JOptionPane.showMessageDialog(null, "Vendedor registrado correctamente", "Registrar vendedor", JOptionPane.CLOSED_OPTION);
						clean();
						ListarVendedor.loadTableVendedor(null);
					}
				}
				else {
					if (selected instanceof Vendedor) {
						if (txtcedula.getText().equalsIgnoreCase("") || txtDireccion.getText().equalsIgnoreCase("") || txtNombre.getText().equalsIgnoreCase("") || txtPassword.getPassword().length == 0
								|| txtTelefono.getText().equalsIgnoreCase("") || txtUsername.getText().equalsIgnoreCase("")) {
							JOptionPane.showMessageDialog(null, "Debes llenar todos los campos!", "Modificar Vendedor", JOptionPane.WARNING_MESSAGE);
						}else {
							 selected.setCedula(txtcedula.getText());
							 selected.setDireccion(txtDireccion.getText());
							 selected.setNombre(txtNombre.getText());
							 selected.setTelefono(txtTelefono.getText());
							 selected.setUsername(txtUsername.getText());
							 selected.setPassword(txtPassword.getText());
							 CopiarYPegar copiarYPegar = new CopiarYPegar(f.getPath(), "src/ImagenesEmpleados/Archivo"+txtcedula.getText()+".jpg");
							 JOptionPane.showMessageDialog(null, "Vendedor modificado correctamente", "Modificar Vendedor", JOptionPane.CLOSED_OPTION);
							 try {
								loadEmpleado();
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							 ListarVendedor.loadTableVendedor(null);
						}
					}
				}
				if (selected instanceof Administrador){
					if (txtcedula.getText().equalsIgnoreCase("") || txtDireccion.getText().equalsIgnoreCase("") || txtNombre.getText().equalsIgnoreCase("") || txtPassword.getPassword().length == 0
							|| txtTelefono.getText().equalsIgnoreCase("") || txtUsername.getText().equalsIgnoreCase("")) {
						JOptionPane.showMessageDialog(null, "Debes llenar todos los campos!", "Modificar Administrador", JOptionPane.WARNING_MESSAGE);
					}else {
						 selected.setCedula(txtcedula.getText());
						 selected.setDireccion(txtDireccion.getText());
						 selected.setNombre(txtNombre.getText());
						 selected.setTelefono(txtTelefono.getText());
						 selected.setUsername(txtUsername.getText());
						 selected.setPassword(txtPassword.getText());
						 JOptionPane.showMessageDialog(null, "Administrador modificado correctamente", "Modificar Administrador", JOptionPane.CLOSED_OPTION);
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
		
		if (selected != null) {
			lblConfirmar.setText("Modificar");
			if (selected instanceof Administrador) {
				lblTitle.setText("Modificar Administrador:");
				lblCargarImagen.setEnabled(false);
				labelIcon.setIcon(new ImageIcon(Home.class.getResource("/Imagenes/AdminDefectIcon.png")));
				txtcedula.setText(selected.getCedula());
				txtDireccion.setText(selected.getDireccion());
				txtNombre.setText(selected.getNombre());
				txtPassword.setText(selected.getPassword());
				txtTelefono.setText(selected.getTelefono());
				txtUsername.setText(selected.getUsername());
			}
			else {
				loadEmpleado();
				lblTitle.setText("Modificar Vendedor:");
			}
			
		}
		
	}
	private void clean() {
		txtcedula.setText("");
		txtDireccion.setText("");
		txtNombre.setText("");
		txtPassword.setText("");
		txtTelefono.setText("");
		txtUsername.setText("");
		labelIcon.setIcon(new ImageIcon());
	}
	private void loadEmpleado() throws IOException {
		txtcedula.setText(selected.getCedula());
		txtDireccion.setText(selected.getDireccion());
		txtNombre.setText(selected.getNombre());
		txtPassword.setText(selected.getPassword());
		txtTelefono.setText(selected.getTelefono());
		txtUsername.setText(selected.getUsername());
		File f = new File("src/ImagenesEmpleados/Archivo"+selected.getCedula()+".jpg");
        Image bi;
		bi = ImageIO.read(f);
		labelIcon.setIcon(new ImageIcon(bi.getScaledInstance(187, 187, 0)));
	}
}