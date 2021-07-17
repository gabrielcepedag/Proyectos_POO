package Visual;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

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
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.JComboBox;

public class RegProducto extends JDialog {

	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField txtTelefono;
	private JPanel panelRegistro;
	Cliente selected = null;
	private JTextField txtcedula;
	private JTextField textField;
	private JTextField textField_1;
	private JPanel panelDiscoDuro;
	private JTextField textField_2;
	private JTextField textField_4;
	private JPanel panelMemoriaRam;
	private JTextField textField_3;
	private JTextField textField_5;
	private JPanel panelTarjetaMadre;
	private JPanel panelMicroProcesador;
	private JRadioButton btnDiscoDuro;
	private JRadioButton btnMemoriaRam;
	private JRadioButton btnTarjetaMadre;
	private JRadioButton btnMicroProcesador;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegProducto dialog = new RegProducto();
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
	public RegProducto() {
		setUndecorated(true);
		setBounds(100, 100, 585, 840);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(36, 37, 38));
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		panelMicroProcesador = new JPanel();
		panelMicroProcesador.setVisible(false);
		
		panelTarjetaMadre = new JPanel();
		panelTarjetaMadre.setVisible(false);
		panelTarjetaMadre.setLayout(null);
		panelTarjetaMadre.setBackground(Color.WHITE);
		panelTarjetaMadre.setBounds(11, 515, 553, 236);
		panel.add(panelTarjetaMadre);
		
		JLabel lblModelo = new JLabel("Modelo:");
		lblModelo.setForeground(Color.BLACK);
		lblModelo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblModelo.setBounds(29, 9, 125, 55);
		panelTarjetaMadre.add(lblModelo);
		
		textField = new JTextField();
		textField.setForeground(new Color(0, 153, 153));
		textField.setFont(new Font("Tahoma", Font.PLAIN, 22));
		textField.setColumns(10);
		textField.setBackground(Color.WHITE);
		textField.setBounds(153, 11, 377, 50);
		panelTarjetaMadre.add(textField);
		
		JLabel lblSocket = new JLabel("Socket:");
		lblSocket.setForeground(Color.BLACK);
		lblSocket.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblSocket.setBounds(29, 70, 112, 55);
		panelTarjetaMadre.add(lblSocket);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(153, 72, 377, 50);
		panelTarjetaMadre.add(comboBox);
		
		JLabel lblTipoDeRam = new JLabel("Tipo de Ram:");
		lblTipoDeRam.setForeground(Color.BLACK);
		lblTipoDeRam.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTipoDeRam.setBounds(29, 131, 138, 55);
		panelTarjetaMadre.add(lblTipoDeRam);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(179, 133, 351, 50);
		panelTarjetaMadre.add(comboBox_1);
		
		JRadioButton rdbtnIde = new JRadioButton("IDE");
		rdbtnIde.setForeground(Color.BLACK);
		rdbtnIde.setFont(new Font("Tahoma", Font.PLAIN, 20));
		rdbtnIde.setBounds(29, 195, 94, 25);
		panelTarjetaMadre.add(rdbtnIde);
		
		JRadioButton rdbtnSata = new JRadioButton("SATA");
		rdbtnSata.setForeground(Color.BLACK);
		rdbtnSata.setFont(new Font("Tahoma", Font.PLAIN, 20));
		rdbtnSata.setBounds(149, 195, 102, 25);
		panelTarjetaMadre.add(rdbtnSata);
		
		JRadioButton rdbtnSata_1 = new JRadioButton("SATA-2");
		rdbtnSata_1.setForeground(Color.BLACK);
		rdbtnSata_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		rdbtnSata_1.setBounds(281, 195, 112, 25);
		panelTarjetaMadre.add(rdbtnSata_1);
		
		JRadioButton rdbtnSata_2 = new JRadioButton("SATA-3");
		rdbtnSata_2.setForeground(Color.BLACK);
		rdbtnSata_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		rdbtnSata_2.setBounds(411, 195, 119, 25);
		panelTarjetaMadre.add(rdbtnSata_2);
		panelMicroProcesador.setLayout(null);
		panelMicroProcesador.setBackground(Color.WHITE);
		panelMicroProcesador.setBounds(15, 515, 553, 236);
		panel.add(panelMicroProcesador);
		
		JLabel lblModelo_1 = new JLabel("Modelo:");
		lblModelo_1.setForeground(Color.BLACK);
		lblModelo_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblModelo_1.setBounds(29, 13, 112, 55);
		panelMicroProcesador.add(lblModelo_1);
		
		JLabel lblSocket_1 = new JLabel("Socket:");
		lblSocket_1.setForeground(Color.BLACK);
		lblSocket_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblSocket_1.setBounds(29, 74, 112, 55);
		panelMicroProcesador.add(lblSocket_1);
		
		JComboBox comboBox_4 = new JComboBox();
		comboBox_4.setBounds(153, 76, 377, 50);
		panelMicroProcesador.add(comboBox_4);
		
		textField_3 = new JTextField();
		textField_3.setForeground(new Color(0, 153, 153));
		textField_3.setFont(new Font("Tahoma", Font.PLAIN, 22));
		textField_3.setColumns(10);
		textField_3.setBackground(Color.WHITE);
		textField_3.setBounds(153, 15, 377, 50);
		panelMicroProcesador.add(textField_3);
		
		JLabel lblVelocidadDeProcesamiento = new JLabel("Velocidad de procesamiento:");
		lblVelocidadDeProcesamiento.setForeground(Color.BLACK);
		lblVelocidadDeProcesamiento.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblVelocidadDeProcesamiento.setBounds(29, 142, 268, 55);
		panelMicroProcesador.add(lblVelocidadDeProcesamiento);
		
		textField_5 = new JTextField();
		textField_5.setForeground(new Color(0, 153, 153));
		textField_5.setFont(new Font("Tahoma", Font.PLAIN, 22));
		textField_5.setColumns(10);
		textField_5.setBackground(Color.WHITE);
		textField_5.setBounds(298, 144, 232, 50);
		panelMicroProcesador.add(textField_5);
		
		panelMemoriaRam = new JPanel();
		panelMemoriaRam.setVisible(false);
		panelMemoriaRam.setLayout(null);
		panelMemoriaRam.setBackground(Color.WHITE);
		panelMemoriaRam.setBounds(11, 515, 553, 236);
		panel.add(panelMemoriaRam);
		
		JLabel label_1 = new JLabel("Capacidad:");
		label_1.setForeground(Color.BLACK);
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label_1.setBounds(29, 13, 112, 55);
		panelMemoriaRam.add(label_1);
		
		JLabel lblTipoDeMemoria = new JLabel("Tipo de Memoria:");
		lblTipoDeMemoria.setForeground(Color.BLACK);
		lblTipoDeMemoria.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTipoDeMemoria.setBounds(29, 74, 165, 55);
		panelMemoriaRam.add(lblTipoDeMemoria);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBounds(195, 76, 335, 50);
		panelMemoriaRam.add(comboBox_2);
		
		textField_4 = new JTextField();
		textField_4.setForeground(new Color(0, 153, 153));
		textField_4.setFont(new Font("Tahoma", Font.PLAIN, 22));
		textField_4.setColumns(10);
		textField_4.setBackground(Color.WHITE);
		textField_4.setBounds(153, 15, 377, 50);
		panelMemoriaRam.add(textField_4);
		
		panelDiscoDuro = new JPanel();
		panelDiscoDuro.setLayout(null);
		panelDiscoDuro.setBackground(Color.WHITE);
		panelDiscoDuro.setBounds(11, 515, 553, 236);
		panel.add(panelDiscoDuro);
		
		JLabel lblMarca = new JLabel("Modelo:");
		lblMarca.setForeground(Color.BLACK);
		lblMarca.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblMarca.setBounds(29, 9, 125, 55);
		panelDiscoDuro.add(lblMarca);
		
		textField_1 = new JTextField();
		textField_1.setForeground(new Color(0, 153, 153));
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 22));
		textField_1.setColumns(10);
		textField_1.setBackground(Color.WHITE);
		textField_1.setBounds(153, 11, 377, 50);
		panelDiscoDuro.add(textField_1);
		
		JLabel lblCapacidad = new JLabel("Capacidad:");
		lblCapacidad.setForeground(Color.BLACK);
		lblCapacidad.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblCapacidad.setBounds(29, 70, 112, 55);
		panelDiscoDuro.add(lblCapacidad);
		
		JLabel lblTipoDeSocket = new JLabel("Tipo de Socket:");
		lblTipoDeSocket.setForeground(Color.BLACK);
		lblTipoDeSocket.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTipoDeSocket.setBounds(29, 131, 154, 55);
		panelDiscoDuro.add(lblTipoDeSocket);
		
		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setBounds(179, 133, 351, 50);
		panelDiscoDuro.add(comboBox_3);
		
		textField_2 = new JTextField();
		textField_2.setForeground(new Color(0, 153, 153));
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 22));
		textField_2.setColumns(10);
		textField_2.setBackground(Color.WHITE);
		textField_2.setBounds(153, 72, 377, 50);
		panelDiscoDuro.add(textField_2);
		
		panelRegistro = new JPanel();
		panelRegistro.setLayout(null);
		panelRegistro.setBackground(Color.WHITE);
		panelRegistro.setBounds(11, 12, 553, 442);
		panel.add(panelRegistro);
		
		txtTelefono = new JTextField();
		txtTelefono.setForeground(new Color(0, 153, 153));
		txtTelefono.setFont(new Font("Tahoma", Font.PLAIN, 22));
		txtTelefono.setColumns(10);
		txtTelefono.setBackground(Color.WHITE);
		txtTelefono.setBounds(113, 233, 421, 50);
		panelRegistro.add(txtTelefono);
		
		txtNombre = new JTextField();
		txtNombre.setForeground(new Color(0, 153, 153));
		txtNombre.setFont(new Font("Tahoma", Font.PLAIN, 22));
		txtNombre.setColumns(10);
		txtNombre.setBackground(Color.WHITE);
		txtNombre.setBounds(113, 168, 421, 50);
		panelRegistro.add(txtNombre);
		
		JLabel lblDireccin = new JLabel("Disp Max:");
		lblDireccin.setForeground(Color.BLACK);
		lblDireccin.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblDireccin.setBounds(292, 360, 136, 55);
		panelRegistro.add(lblDireccin);
		
		JLabel lblContrasea = new JLabel("Disp Min:");
		lblContrasea.setForeground(Color.BLACK);
		lblContrasea.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblContrasea.setBounds(34, 360, 162, 55);
		panelRegistro.add(lblContrasea);
		
		JLabel lblUsername = new JLabel("Cantidad:");
		lblUsername.setForeground(Color.BLACK);
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblUsername.setBounds(34, 290, 162, 55);
		panelRegistro.add(lblUsername);
		
		JLabel lblNmero = new JLabel("Precio:");
		lblNmero.setForeground(Color.BLACK);
		lblNmero.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNmero.setBounds(34, 227, 125, 55);
		panelRegistro.add(lblNmero);
		
		JLabel lblRegistrar = new JLabel("Registrar Producto:");
		lblRegistrar.setFont(new Font("Tahoma", Font.PLAIN, 35));
		lblRegistrar.setBounds(33, 13, 322, 55);
		panelRegistro.add(lblRegistrar);
		
		JLabel lblNumDeSerie = new JLabel("Num. De serie:");
		lblNumDeSerie.setForeground(Color.BLACK);
		lblNumDeSerie.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNumDeSerie.setBounds(32, 101, 196, 55);
		panelRegistro.add(lblNumDeSerie);
		
		txtcedula = new JTextField();
		txtcedula.setForeground(new Color(0, 153, 153));
		txtcedula.setFont(new Font("Tahoma", Font.PLAIN, 22));
		txtcedula.setColumns(10);
		txtcedula.setBackground(Color.WHITE);
		txtcedula.setBounds(179, 103, 355, 52);
		panelRegistro.add(txtcedula);
		
		JLabel lblNombre = new JLabel("Marca:");
		lblNombre.setForeground(Color.BLACK);
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNombre.setBounds(34, 164, 125, 55);
		panelRegistro.add(lblNombre);
		
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
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 155, 124));
		panel_1.setBounds(34, 64, 390, 4);
		panelRegistro.add(panel_1);
		
		JSpinner spinner = new JSpinner();
		spinner.setFont(new Font("Tahoma", Font.PLAIN, 20));
		spinner.setBounds(136, 362, 131, 51);
		panelRegistro.add(spinner);
		
		JSpinner spinner_1 = new JSpinner();
		spinner_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		spinner_1.setBounds(403, 362, 131, 51);
		panelRegistro.add(spinner_1);
		
		JSpinner spinner_2 = new JSpinner();
		spinner_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		spinner_2.setBounds(136, 296, 398, 51);
		panelRegistro.add(spinner_2);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(11, 463, 553, 42);
		panel.add(panel_2);
		
		btnDiscoDuro = new JRadioButton("D Duro");
		btnDiscoDuro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panelDiscoDuro.setVisible(true);
				panelMemoriaRam.setVisible(false);
				panelTarjetaMadre.setVisible(false);
				panelMicroProcesador.setVisible(false);
				
				btnDiscoDuro.setSelected(true);
				btnMemoriaRam.setSelected(false);
				btnTarjetaMadre.setSelected(false);
				btnMicroProcesador.setSelected(false);
			}
		});
		btnDiscoDuro.setSelected(true);
		btnDiscoDuro.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnDiscoDuro.setForeground(new Color(0, 0, 0));
		btnDiscoDuro.setBounds(8, 11, 102, 25);
		panel_2.add(btnDiscoDuro);
		
		btnMemoriaRam = new JRadioButton("M Ram");
		btnMemoriaRam.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelDiscoDuro.setVisible(false);
				panelMemoriaRam.setVisible(true);
				panelTarjetaMadre.setVisible(false);
				panelMicroProcesador.setVisible(false);
				
				btnDiscoDuro.setSelected(false);
				btnMemoriaRam.setSelected(true);
				btnTarjetaMadre.setSelected(false);
				btnMicroProcesador.setSelected(false);
			}
		});
		btnMemoriaRam.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnMemoriaRam.setForeground(new Color(0, 0, 0));
		btnMemoriaRam.setBounds(130, 11, 102, 25);
		panel_2.add(btnMemoriaRam);
		
		btnTarjetaMadre = new JRadioButton("Tarj. Madre");
		btnTarjetaMadre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panelDiscoDuro.setVisible(false);
				panelMemoriaRam.setVisible(false);
				panelTarjetaMadre.setVisible(true);
				panelMicroProcesador.setVisible(false);
				
				btnDiscoDuro.setSelected(false);
				btnMemoriaRam.setSelected(false);
				btnTarjetaMadre.setSelected(true);
				btnMicroProcesador.setSelected(false);
			}
		});
		btnTarjetaMadre.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnTarjetaMadre.setForeground(new Color(0, 0, 0));
		btnTarjetaMadre.setBounds(251, 11, 142, 25);
		panel_2.add(btnTarjetaMadre);
		
		btnMicroProcesador = new JRadioButton("Mic. Proces");
		btnMicroProcesador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelDiscoDuro.setVisible(false);
				panelMemoriaRam.setVisible(false);
				panelTarjetaMadre.setVisible(false);
				panelMicroProcesador.setVisible(true);
				
				btnDiscoDuro.setSelected(false);
				btnMemoriaRam.setSelected(false);
				btnTarjetaMadre.setSelected(false);
				btnMicroProcesador.setSelected(true);
			}
		});
		btnMicroProcesador.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnMicroProcesador.setForeground(new Color(0, 0, 0));
		btnMicroProcesador.setBounds(411, 11, 134, 25);
		panel_2.add(btnMicroProcesador);
		
		JLabel lblNewLabel = new JLabel("Cancelar");
		lblNewLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel.setBounds(101, 764, 225, 55);
		panel.add(lblNewLabel);
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
		
		JLabel lblRegistrar_1 = new JLabel("Registrar");
		lblRegistrar_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblRegistrar_1.setBounds(339, 764, 225, 55);
		panel.add(lblRegistrar_1);

		lblRegistrar_1.setOpaque(true);
		lblRegistrar_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegistrar_1.setForeground(Color.WHITE);
		lblRegistrar_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblRegistrar_1.setBackground(new Color(0, 155, 124));
		
	}
	private void clean() {

	}
}
