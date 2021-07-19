package Visual;

import java.awt.BorderLayout;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

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
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JSeparator;

public class RegCombo extends JDialog {

	private JPanel contentPane;
	private JTextField txtMarca;
	private JPanel panelRegistro;
	private JTextField txtNumSerie;
	private JPanel panelDiscoDuro;
	private JSpinner spnDispReal;
	private JLabel lblRegistrar;
	private JTextField textField;
	private JTextField textField_1;
	private JTable table;
	private JTable table_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegCombo dialog = new RegCombo();
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
	public RegCombo() {
		setUndecorated(true);
		setBounds(100, 100, 647, 741);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(36, 37, 38));
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		panelDiscoDuro = new JPanel();
		panelDiscoDuro.setLayout(null);
		panelDiscoDuro.setBackground(Color.WHITE);
		panelDiscoDuro.setBounds(11, 300, 613, 369);
		panel.add(panelDiscoDuro);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 56, 228, 227);
		panelDiscoDuro.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(376, 56, 228, 227);
		panelDiscoDuro.add(scrollPane_1);
		
		table_1 = new JTable();
		scrollPane_1.setViewportView(table_1);
		
		JLabel label = new JLabel("<<");
		label.setOpaque(true);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label.setBackground(new Color(0, 155, 124));
		label.setBounds(260, 137, 99, 45);
		panelDiscoDuro.add(label);
		
		JLabel label_1 = new JLabel(">>");
		label_1.setOpaque(true);
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label_1.setBackground(new Color(0, 155, 124));
		label_1.setBounds(260, 195, 99, 45);
		panelDiscoDuro.add(label_1);
		
		JLabel lblDisponibles = new JLabel("Disponibles:");
		lblDisponibles.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblDisponibles.setBounds(12, 1, 205, 55);
		panelDiscoDuro.add(lblDisponibles);
		
		JLabel lblElejidos = new JLabel("Elejidos:");
		lblElejidos.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblElejidos.setBounds(376, 1, 205, 55);
		panelDiscoDuro.add(lblElejidos);
		
		JLabel lblPrecio_1 = new JLabel("Precio:");
		lblPrecio_1.setForeground(Color.BLACK);
		lblPrecio_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPrecio_1.setBounds(12, 300, 125, 55);
		panelDiscoDuro.add(lblPrecio_1);
		
		textField = new JTextField();
		textField.setEnabled(false);
		textField.setForeground(new Color(0, 153, 153));
		textField.setFont(new Font("Tahoma", Font.PLAIN, 22));
		textField.setColumns(10);
		textField.setBackground(Color.WHITE);
		textField.setBounds(84, 305, 186, 45);
		panelDiscoDuro.add(textField);
		
		JLabel lblPrecioNeto = new JLabel("Precio neto:");
		lblPrecioNeto.setForeground(Color.BLACK);
		lblPrecioNeto.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPrecioNeto.setBounds(297, 300, 125, 55);
		panelDiscoDuro.add(lblPrecioNeto);
		
		textField_1 = new JTextField();
		textField_1.setEnabled(false);
		textField_1.setForeground(new Color(0, 153, 153));
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 22));
		textField_1.setColumns(10);
		textField_1.setBackground(Color.WHITE);
		textField_1.setBounds(418, 305, 186, 45);
		panelDiscoDuro.add(textField_1);
		
		JSeparator separator = new JSeparator();
		separator.setBackground(new Color(0, 155, 124));
		separator.setBounds(12, 296, 589, 2);
		panelDiscoDuro.add(separator);
		
		panelRegistro = new JPanel();
		panelRegistro.setLayout(null);
		panelRegistro.setBackground(Color.WHITE);
		panelRegistro.setBounds(11, 12, 613, 282);
		panel.add(panelRegistro);
		
		txtMarca = new JTextField();
		txtMarca.setForeground(new Color(0, 153, 153));
		txtMarca.setFont(new Font("Tahoma", Font.PLAIN, 22));
		txtMarca.setColumns(10);
		txtMarca.setBackground(Color.WHITE);
		txtMarca.setBounds(148, 147, 440, 45);
		panelRegistro.add(txtMarca);
		
		JLabel lblPrecio = new JLabel("Descuento:");
		lblPrecio.setForeground(Color.BLACK);
		lblPrecio.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPrecio.setBounds(33, 205, 125, 55);
		panelRegistro.add(lblPrecio);
		
		JLabel lblRegistrarProducto = new JLabel("Registrar Combo:");
		lblRegistrarProducto.setFont(new Font("Tahoma", Font.PLAIN, 35));
		lblRegistrarProducto.setBounds(33, 13, 322, 55);
		panelRegistro.add(lblRegistrarProducto);
		
		JLabel lblNumSerie = new JLabel("C\u00F3digo:");
		lblNumSerie.setForeground(Color.BLACK);
		lblNumSerie.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNumSerie.setBounds(33, 79, 196, 55);
		panelRegistro.add(lblNumSerie);
		
		txtNumSerie = new JTextField();
		txtNumSerie.setForeground(new Color(0, 153, 153));
		txtNumSerie.setFont(new Font("Tahoma", Font.PLAIN, 22));
		txtNumSerie.setColumns(10);
		txtNumSerie.setBackground(Color.WHITE);
		txtNumSerie.setBounds(148, 84, 440, 45);
		panelRegistro.add(txtNumSerie);
		
		JLabel lblMarca = new JLabel("Nombre:");
		lblMarca.setForeground(Color.BLACK);
		lblMarca.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblMarca.setBounds(33, 142, 125, 55);
		panelRegistro.add(lblMarca);
		
		final JLabel lblX = new JLabel("X");
		lblX.setBounds(531, 11, 57, 55);
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
		
		JPanel panel1 = new JPanel();
		panel1.setBackground(new Color(0, 155, 124));
		panel1.setBounds(34, 64, 420, 4);
		panelRegistro.add(panel1);
		
		spnDispReal = new JSpinner();
		spnDispReal.setFont(new Font("Tahoma", Font.PLAIN, 20));
		spnDispReal.setBounds(148, 210, 440, 45);
		panelRegistro.add(spnDispReal);
		
		JLabel lblCancelar = new JLabel("Cancelar");
		lblCancelar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblCancelar.setBounds(169, 675, 225, 45);
		panel.add(lblCancelar);
		lblCancelar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
		lblCancelar.setForeground(Color.WHITE);
		lblCancelar.setBackground(new Color(0, 155, 124));
		lblCancelar.setOpaque(true);
		lblCancelar.setHorizontalAlignment(SwingConstants.CENTER);
		lblCancelar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		lblRegistrar = new JLabel("Registrar");
		lblRegistrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});
		lblRegistrar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblRegistrar.setBounds(400, 675, 225, 45);
		panel.add(lblRegistrar);

		lblRegistrar.setOpaque(true);
		lblRegistrar.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegistrar.setForeground(Color.WHITE);
		lblRegistrar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblRegistrar.setBackground(new Color(0, 155, 124));
		
	}
	
	private void clean() {
		
	}
}
