package Visual;

import java.awt.BorderLayout;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logico.Administrador;
import logico.Cliente;
import logico.DiscoDuro;
import logico.Empleado;
import logico.Factura;
import logico.MemoriaRam;
import logico.MicroProcesador;
import logico.MotherBoard;
import logico.Producto;
import logico.Tienda;
import logico.Vendedor;

import java.awt.Rectangle;
import java.awt.datatransfer.ClipboardOwner;
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

public class RegFactura extends JDialog {

	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField txtDireccion;
	private JPanel panelDatosClientes;
	Cliente selected = null;
	private JTextField txtCedula;
	private JRadioButton btnAddProducto;
	private JRadioButton btnAddCombo;
	private JLabel lblRegistrar;
	private JLabel lblBuscar;
	private JTextField txtPrecioTotal;
	private JTextField txtCodigo;
	private JTable table;
	private JTable table_1;
	private JPanel panelCombos;
	private JPanel panelProductos;
	private JTable table_2;
	private JTable table_3;
	private JTextField txtTelefono;
	private boolean clienteExiste = false;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegFactura dialog = new RegFactura();
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
	public RegFactura() {
		setUndecorated(true);
		setBounds(100, 100, 1114, 700);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(36, 37, 38));
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		panelCombos = new JPanel();
		panelCombos.setVisible(false);
		panelCombos.setLayout(null);
		panelCombos.setBackground(Color.WHITE);
		panelCombos.setBounds(630, 67, 465, 561);
		panel.add(panelCombos);
		
		JLabel label_2 = new JLabel("\u2191\u2191");
		label_2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		label_2.setOpaque(true);
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setForeground(Color.WHITE);
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label_2.setBackground(new Color(0, 155, 124));
		label_2.setBounds(157, 275, 74, 45);
		panelCombos.add(label_2);
		
		JLabel label_3 = new JLabel("\u2193\u2193");
		label_3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		label_3.setOpaque(true);
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setForeground(Color.WHITE);
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label_3.setBackground(new Color(0, 155, 124));
		label_3.setBounds(243, 275, 74, 45);
		panelCombos.add(label_3);
		
		JLabel lblCombosDisponibles = new JLabel("Combos disponibles:");
		lblCombosDisponibles.setForeground(Color.BLACK);
		lblCombosDisponibles.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblCombosDisponibles.setBounds(12, 0, 190, 55);
		panelCombos.add(lblCombosDisponibles);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(12, 51, 441, 215);
		panelCombos.add(scrollPane_2);
		
		table_2 = new JTable();
		scrollPane_2.setViewportView(table_2);
		
		JLabel label_5 = new JLabel("Elejidos:");
		label_5.setForeground(Color.BLACK);
		label_5.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label_5.setBounds(12, 282, 134, 55);
		panelCombos.add(label_5);
		
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(12, 333, 441, 215);
		panelCombos.add(scrollPane_3);
		
		table_3 = new JTable();
		scrollPane_3.setViewportView(table_3);
		
		JLabel lblCancelar = new JLabel("Cancelar");
		lblCancelar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblCancelar.setBounds(630, 635, 225, 45);
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
				if (clienteExiste == false) {
					Cliente cliente = new Cliente(txtCedula.getText(), txtNombre.getText(), txtDireccion.getText(), txtTelefono.getText());
					Tienda.getInstance().addCliente(cliente);
					
				}
				//Todo lo otro que va para cosa esta
				//..........
				JOptionPane.showMessageDialog(null, "Factura Creada Esxitosamente", "Crear Factura", JOptionPane.DEFAULT_OPTION);
				Home.loadTableFactura(0, null);
			}
		});
		lblRegistrar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblRegistrar.setBounds(870, 635, 225, 45);
		panel.add(lblRegistrar);
		
				lblRegistrar.setOpaque(true);
				lblRegistrar.setHorizontalAlignment(SwingConstants.CENTER);
				lblRegistrar.setForeground(Color.WHITE);
				lblRegistrar.setFont(new Font("Tahoma", Font.PLAIN, 20));
				lblRegistrar.setBackground(new Color(0, 155, 124));
		
		panelDatosClientes = new JPanel();
		panelDatosClientes.setLayout(null);
		panelDatosClientes.setBackground(Color.WHITE);
		panelDatosClientes.setBounds(11, 12, 607, 399);
		panel.add(panelDatosClientes);
		
		txtDireccion = new JTextField();
		txtDireccion.setEnabled(false);
		txtDireccion.setForeground(new Color(0, 153, 153));
		txtDireccion.setFont(new Font("Tahoma", Font.PLAIN, 22));
		txtDireccion.setColumns(10);
		txtDireccion.setBackground(Color.WHITE);
		txtDireccion.setBounds(143, 248, 453, 45);
		panelDatosClientes.add(txtDireccion);
		
		txtNombre = new JTextField();
		txtNombre.setEnabled(false);
		txtNombre.setForeground(new Color(0, 153, 153));
		txtNombre.setFont(new Font("Tahoma", Font.PLAIN, 22));
		txtNombre.setColumns(10);
		txtNombre.setBackground(Color.WHITE);
		txtNombre.setBounds(143, 185, 453, 45);
		panelDatosClientes.add(txtNombre);
		
		JLabel lblCantidad = new JLabel("Telefono:");
		lblCantidad.setForeground(Color.BLACK);
		lblCantidad.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblCantidad.setBounds(33, 306, 162, 55);
		panelDatosClientes.add(lblCantidad);
		
		JLabel lblPrecio = new JLabel("Direcci\u00F3n:");
		lblPrecio.setForeground(Color.BLACK);
		lblPrecio.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPrecio.setBounds(33, 243, 125, 55);
		panelDatosClientes.add(lblPrecio);
		
		JLabel lblRegistrarProducto = new JLabel("Crear Factura:");
		lblRegistrarProducto.setFont(new Font("Tahoma", Font.PLAIN, 35));
		lblRegistrarProducto.setBounds(33, 13, 322, 55);
		panelDatosClientes.add(lblRegistrarProducto);
		
		JLabel lblNumSerie = new JLabel("C\u00E9dula:");
		lblNumSerie.setForeground(Color.BLACK);
		lblNumSerie.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNumSerie.setBounds(33, 117, 196, 55);
		panelDatosClientes.add(lblNumSerie);
		
		txtCedula = new JTextField();
		txtCedula.setForeground(new Color(0, 153, 153));
		txtCedula.setFont(new Font("Tahoma", Font.PLAIN, 22));
		txtCedula.setColumns(10);
		txtCedula.setBackground(Color.WHITE);
		txtCedula.setBounds(143, 127, 311, 45);
		panelDatosClientes.add(txtCedula);
		
		JLabel lblMarca = new JLabel("Nombre:");
		lblMarca.setForeground(Color.BLACK);
		lblMarca.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblMarca.setBounds(33, 180, 125, 55);
		panelDatosClientes.add(lblMarca);
		
		final JLabel lblX = new JLabel("X");
		lblX.setBounds(539, 11, 57, 55);
		panelDatosClientes.add(lblX);
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
		panelDatosClientes.add(panel1);
		
		lblBuscar = new JLabel("Buscar");
		lblBuscar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Cliente clienteBuscado = Tienda.getInstance().buscarClienteByCedula(txtCedula.getText());
				if (clienteBuscado == null) {
					txtNombre.setEnabled(true);
					txtDireccion.setEnabled(true);
					txtTelefono.setEnabled(true);
					clienteExiste = false;
					
				}else {
					cargarCliente(clienteBuscado);
					clienteExiste = true;
				}
			}
		});
		lblBuscar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblBuscar.setIcon(new ImageIcon(RegFactura.class.getResource("/Imagenes/Lupa.png")));
		lblBuscar.setOpaque(true);
		lblBuscar.setHorizontalAlignment(SwingConstants.CENTER);
		lblBuscar.setForeground(Color.BLACK);
		lblBuscar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblBuscar.setBackground(new Color(0, 155, 124));
		lblBuscar.setBounds(460, 127, 136, 45);
		panelDatosClientes.add(lblBuscar);
		
		JLabel lblClienteDatos = new JLabel("Cliente Datos:");
		lblClienteDatos.setForeground(Color.BLACK);
		lblClienteDatos.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblClienteDatos.setBounds(33, 70, 196, 55);
		panelDatosClientes.add(lblClienteDatos);
		
		txtTelefono = new JTextField();
		txtTelefono.setForeground(new Color(0, 153, 153));
		txtTelefono.setFont(new Font("Tahoma", Font.PLAIN, 22));
		txtTelefono.setEnabled(false);
		txtTelefono.setColumns(10);
		txtTelefono.setBackground(Color.WHITE);
		txtTelefono.setBounds(143, 311, 453, 45);
		panelDatosClientes.add(txtTelefono);
		
		JPanel panelRadioButtons = new JPanel();
		panelRadioButtons.setLayout(null);
		panelRadioButtons.setBackground(Color.WHITE);
		panelRadioButtons.setBounds(630, 12, 465, 42);
		panel.add(panelRadioButtons);
		
		btnAddProducto = new JRadioButton("Agregar Productos");
		btnAddProducto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panelProductos.setVisible(true);
				panelCombos.setVisible(false);
				
				btnAddProducto.setSelected(true);
				btnAddCombo.setSelected(false);
			}
		});
		btnAddProducto.setSelected(true);
		btnAddProducto.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnAddProducto.setForeground(new Color(0, 0, 0));
		btnAddProducto.setBounds(20, 9, 199, 25);
		panelRadioButtons.add(btnAddProducto);
		
		btnAddCombo = new JRadioButton("Agregar Combos");
		btnAddCombo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelProductos.setVisible(false);
				panelCombos.setVisible(true);
				
				btnAddProducto.setSelected(false);
				btnAddCombo.setSelected(true);
			}
		});
		btnAddCombo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnAddCombo.setForeground(new Color(0, 0, 0));
		btnAddCombo.setBounds(239, 9, 206, 25);
		panelRadioButtons.add(btnAddCombo);
		
		JPanel panelDatosFactura = new JPanel();
		panelDatosFactura.setLayout(null);
		panelDatosFactura.setBackground(Color.WHITE);
		panelDatosFactura.setBounds(11, 424, 607, 256);
		panel.add(panelDatosFactura);
		
		txtPrecioTotal = new JTextField();
		txtPrecioTotal.setForeground(new Color(0, 153, 153));
		txtPrecioTotal.setFont(new Font("Tahoma", Font.PLAIN, 22));
		txtPrecioTotal.setColumns(10);
		txtPrecioTotal.setBackground(Color.WHITE);
		txtPrecioTotal.setBounds(169, 115, 427, 45);
		panelDatosFactura.add(txtPrecioTotal);
		
		JLabel lblCodigo = new JLabel("C\u00F3digo:");
		lblCodigo.setForeground(Color.BLACK);
		lblCodigo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblCodigo.setBounds(32, 47, 196, 55);
		panelDatosFactura.add(lblCodigo);
		
		txtCodigo = new JTextField();
		txtCodigo.setForeground(new Color(0, 153, 153));
		txtCodigo.setFont(new Font("Tahoma", Font.PLAIN, 22));
		txtCodigo.setColumns(10);
		txtCodigo.setBackground(Color.WHITE);
		txtCodigo.setBounds(169, 57, 427, 45);
		panelDatosFactura.add(txtCodigo);
		
		JLabel lblVendedor = new JLabel("Precio Total:");
		lblVendedor.setForeground(Color.BLACK);
		lblVendedor.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblVendedor.setBounds(32, 110, 125, 55);
		panelDatosFactura.add(lblVendedor);
		
		JRadioButton rdbtnFacturaACredito = new JRadioButton("Factura a Credito");
		rdbtnFacturaACredito.setForeground(Color.BLACK);
		rdbtnFacturaACredito.setFont(new Font("Tahoma", Font.PLAIN, 20));
		rdbtnFacturaACredito.setBounds(211, 190, 199, 25);
		panelDatosFactura.add(rdbtnFacturaACredito);
		
		JLabel lblFactura = new JLabel("Factura Datos:");
		lblFactura.setForeground(Color.BLACK);
		lblFactura.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblFactura.setBounds(32, 0, 196, 55);
		panelDatosFactura.add(lblFactura);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setOpaque(true);
		lblNewLabel.setBounds(12, 173, 584, 55);
		panelDatosFactura.add(lblNewLabel);
		
		panelProductos = new JPanel();
		panelProductos.setLayout(null);
		panelProductos.setBackground(Color.WHITE);
		panelProductos.setBounds(630, 67, 465, 561);
		panel.add(panelProductos);
		
		JLabel label = new JLabel("\u2191\u2191");
		label.setOpaque(true);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label.setBackground(new Color(0, 155, 124));
		label.setBounds(157, 275, 74, 45);
		panelProductos.add(label);
		
		JLabel label_1 = new JLabel("\u2193\u2193");
		label_1.setOpaque(true);
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label_1.setBackground(new Color(0, 155, 124));
		label_1.setBounds(243, 275, 74, 45);
		panelProductos.add(label_1);
		
		JLabel lblDisponibles = new JLabel("Productos disponibles:");
		lblDisponibles.setForeground(Color.BLACK);
		lblDisponibles.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblDisponibles.setBounds(12, 0, 300, 55);
		panelProductos.add(lblDisponibles);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 51, 441, 215);
		panelProductos.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JLabel lblElejidos = new JLabel("Elejidos:");
		lblElejidos.setForeground(Color.BLACK);
		lblElejidos.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblElejidos.setBounds(12, 282, 134, 55);
		panelProductos.add(lblElejidos);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(12, 333, 441, 215);
		panelProductos.add(scrollPane_1);
		
		table_1 = new JTable();
		scrollPane_1.setViewportView(table_1);
		
	}
	
	private void cargarCliente(Cliente clienteBuscado) {
		txtNombre.setText(clienteBuscado.getNombre());
		txtDireccion.setText(clienteBuscado.getDireccion());
		txtTelefono.setText(clienteBuscado.getTelefono());
	}
	
	private void clean() {
		
	}
}