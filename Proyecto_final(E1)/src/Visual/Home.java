package Visual;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import logico.Cliente;
import logico.Empleado;
import logico.Factura;
import logico.MemoriaRam;
import logico.MicroProcesador;
import logico.MotherBoard;
import logico.Producto;
import logico.Tienda;
import logico.Vendedor;

import java.awt.Color;
import java.awt.Cursor;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.chrono.HijrahEra;
import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class Home extends JFrame {

	private JPanel contentPane;
	private JPanel panelProductos;
	private JPanel panelFactura;
	private JPanel panelClientes;
	private JLabel lblProductos;
	private JLabel lblClientes;
	private JLabel lblFactura;
	private JLabel lblAdministrar;
	private JLabel lblSalir;
	private JPanel panelAdministrar;
	private JTable tableProductos;
	private static DefaultTableModel modelCliente;
	private static DefaultTableModel modelFactura;
	private static Object rows[];
	private static DefaultTableModel modelProductos;
	private JTable tableCliente;
	private JScrollPane scrollPaneCliente;
	private JLabel crearFactura;
	private JTable tableFactura;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home frame = new Home();
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
	public Home() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1400, 886);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		panelClientes = new JPanel();
		panelClientes.setVisible(false);
		
		panelFactura = new JPanel();
		panelFactura.setVisible(false);
		
		panelAdministrar = new JPanel();
		panelAdministrar.setVisible(false);
		
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
		lblX.setForeground(Color.DARK_GRAY);
		lblX.setBounds(1333, 0, 57, 55);
		panel.add(lblX);
		
		panelProductos = new JPanel();
		panelProductos.setBackground(Color.WHITE);
		panelProductos.setBounds(401, 13, 967, 850);
		panel.add(panelProductos);
		panelProductos.setLayout(null);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setOpaque(false);
		comboBox.setIgnoreRepaint(true);
		comboBox.setBorder(null);
		comboBox.setBackground(Color.WHITE);
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 17));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Todos", "Disco Duros", "Memorias Ram", "Micro Procesadores", "Placas Madres"}));
		comboBox.setBounds(73, 130, 340, 33);
		panelProductos.add(comboBox);
		
		JScrollPane scrollPaneProducto = new JScrollPane();
		scrollPaneProducto.setBounds(73, 176, 795, 643);
		panelProductos.add(scrollPaneProducto);
		
		String headerProducto[] = {"Categoría", "Número de serie", "Marca", "Precio", "Cantidad"};
		modelProductos = new DefaultTableModel();
		modelProductos.setColumnIdentifiers(headerProducto);
		
		tableProductos = new JTable();
		tableProductos.setEnabled(false);
		tableProductos.setModel(modelProductos);
		tableProductos.getTableHeader().setBackground(new Color(0, 155, 124));
		tableProductos.getTableHeader().setForeground(Color.WHITE);
		scrollPaneProducto.setViewportView(tableProductos);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setOpaque(true);
		lblNewLabel_1.setBackground(new Color(0, 139, 139));
		lblNewLabel_1.setBounds(73, 114, 785, 3);
		panelProductos.add(lblNewLabel_1);
		
		JLabel label_3 = new JLabel("");
		label_3.setIcon(new ImageIcon(Home.class.getResource("/Imagenes/ProductosLabel.png")));
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setForeground(Color.WHITE);
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 30));
		label_3.setBounds(52, 45, 288, 71);
		panelProductos.add(label_3);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(Home.class.getResource("/Imagenes/PanelHome.png")));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(12, 13, 955, 826);
		panelProductos.add(label);
		panelAdministrar.setLayout(null);
		panelAdministrar.setBackground(Color.WHITE);
		panelAdministrar.setBounds(401, 13, 967, 850);
		panel.add(panelAdministrar);
		
		JLabel lblCuenta = new JLabel(" Cuenta");
		lblCuenta.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblCuenta.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JOptionPane.showMessageDialog(null, "Coming Soon");
			}
		});
		lblCuenta.setIcon(new ImageIcon(Home.class.getResource("/Imagenes/settingsIcon.png")));
		lblCuenta.setForeground(Color.WHITE);
		lblCuenta.setFont(new Font("Tahoma", Font.PLAIN, 35));
		lblCuenta.setBounds(86, 569, 222, 122);
		panelAdministrar.add(lblCuenta);
		
		JLabel label_17 = new JLabel("");
		label_17.setIcon(new ImageIcon(Home.class.getResource("/Imagenes/Group 3.png")));
		label_17.setBounds(46, 543, 290, 175);
		panelAdministrar.add(label_17);
		
		JLabel lblOrdenDeCompra = new JLabel(" Pedidos");
		lblOrdenDeCompra.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblOrdenDeCompra.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JOptionPane.showMessageDialog(null, "Coming Soon");
			}
		});
		lblOrdenDeCompra.setIcon(new ImageIcon(Home.class.getResource("/Imagenes/PedidoIcon.png")));
		lblOrdenDeCompra.setForeground(Color.WHITE);
		lblOrdenDeCompra.setFont(new Font("Tahoma", Font.PLAIN, 35));
		lblOrdenDeCompra.setBounds(665, 367, 237, 122);
		panelAdministrar.add(lblOrdenDeCompra);
		
		JLabel label_14 = new JLabel("");
		label_14.setIcon(new ImageIcon(Home.class.getResource("/Imagenes/Group 3.png")));
		label_14.setBounds(640, 345, 290, 175);
		panelAdministrar.add(label_14);
		
		JLabel lblFacturas = new JLabel(" Facturas");
		lblFacturas.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblFacturas.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JOptionPane.showMessageDialog(null, "Coming Soon");
			}
		});
		lblFacturas.setIcon(new ImageIcon(Home.class.getResource("/Imagenes/FacturaIcon.png")));
		lblFacturas.setForeground(Color.WHITE);
		lblFacturas.setFont(new Font("Tahoma", Font.PLAIN, 35));
		lblFacturas.setBounds(71, 367, 237, 122);
		panelAdministrar.add(lblFacturas);
		
		JLabel label_16 = new JLabel("");
		label_16.setIcon(new ImageIcon(Home.class.getResource("/Imagenes/Group 3.png")));
		label_16.setBounds(46, 345, 290, 175);
		panelAdministrar.add(label_16);
		
		JLabel lblDistribuidor = new JLabel("Distribuidor");
		lblDistribuidor.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblDistribuidor.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JOptionPane.showMessageDialog(null, "Coming Soon");
			}
		});
		lblDistribuidor.setIcon(new ImageIcon(Home.class.getResource("/Imagenes/Distribuidor.png")));
		lblDistribuidor.setForeground(Color.WHITE);
		lblDistribuidor.setFont(new Font("Tahoma", Font.PLAIN, 35));
		lblDistribuidor.setBounds(360, 367, 249, 122);
		panelAdministrar.add(lblDistribuidor);
		
		JLabel label_15 = new JLabel("");
		label_15.setIcon(new ImageIcon(Home.class.getResource("/Imagenes/Group 3.png")));
		label_15.setBounds(338, 345, 290, 175);
		panelAdministrar.add(label_15);
		
		JLabel lblCombos = new JLabel(" Combos");
		lblCombos.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblCombos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JOptionPane.showMessageDialog(null, "Coming Soon");
			}
		});
		lblCombos.setIcon(new ImageIcon(Home.class.getResource("/Imagenes/CombosIcon.png")));
		lblCombos.setForeground(Color.WHITE);
		lblCombos.setFont(new Font("Tahoma", Font.PLAIN, 35));
		lblCombos.setBounds(679, 167, 222, 122);
		panelAdministrar.add(lblCombos);
		
		JLabel label_13 = new JLabel("");
		label_13.setIcon(new ImageIcon(Home.class.getResource("/Imagenes/Group 3.png")));
		label_13.setBounds(640, 145, 290, 175);
		panelAdministrar.add(label_13);
		
		JLabel lblVendedores = new JLabel("Vendedores");
		lblVendedores.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblVendedores.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JOptionPane.showMessageDialog(null, "Coming Soon");
			}
		});
		lblVendedores.setIcon(new ImageIcon(Home.class.getResource("/Imagenes/VendedoresIcon.png")));
		lblVendedores.setForeground(Color.WHITE);
		lblVendedores.setFont(new Font("Tahoma", Font.PLAIN, 35));
		lblVendedores.setBounds(359, 167, 249, 122);
		panelAdministrar.add(lblVendedores);
		
		JLabel label_12 = new JLabel("");
		label_12.setIcon(new ImageIcon(Home.class.getResource("/Imagenes/Group 3.png")));
		label_12.setBounds(337, 145, 290, 175);
		panelAdministrar.add(label_12);
		
		JLabel lblClientes_2 = new JLabel("  Clientes");
		lblClientes_2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblClientes_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JOptionPane.showMessageDialog(null, "Coming Soon");
			}
		});
		lblClientes_2.setForeground(Color.WHITE);
		lblClientes_2.setFont(new Font("Tahoma", Font.PLAIN, 35));
		lblClientes_2.setIcon(new ImageIcon(Home.class.getResource("/Imagenes/ClientesUSer.png")));
		lblClientes_2.setBounds(84, 167, 208, 122);
		panelAdministrar.add(lblClientes_2);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(Home.class.getResource("/Imagenes/Group 3.png")));
		lblNewLabel_2.setBounds(45, 145, 290, 175);
		panelAdministrar.add(lblNewLabel_2);
		
		JLabel label_10 = new JLabel("");
		label_10.setIcon(new ImageIcon(Home.class.getResource("/Imagenes/Administracion.png")));
		label_10.setHorizontalAlignment(SwingConstants.CENTER);
		label_10.setForeground(Color.WHITE);
		label_10.setFont(new Font("Tahoma", Font.PLAIN, 30));
		label_10.setBounds(73, 45, 371, 71);
		panelAdministrar.add(label_10);
		
		JLabel label_11 = new JLabel("");
		label_11.setOpaque(true);
		label_11.setBackground(new Color(0, 139, 139));
		label_11.setBounds(73, 114, 785, 3);
		panelAdministrar.add(label_11);
		
		JLabel lblClientes_1 = new JLabel("     Clientes");
		lblClientes_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblClientes_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JOptionPane.showMessageDialog(null, "Coming Soon");
			}
		});
		lblClientes_1.setIcon(new ImageIcon(Home.class.getResource("/Imagenes/PanelHome.png")));
		lblClientes_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblClientes_1.setBounds(12, 13, 955, 826);
		panelAdministrar.add(lblClientes_1);
		panelFactura.setLayout(null);
		panelFactura.setBackground(Color.WHITE);
		panelFactura.setBounds(401, 13, 967, 850);
		panel.add(panelFactura);
		
		JLabel lblVerMsDetalles = new JLabel("Ver m\u00E1s detalles");
		lblVerMsDetalles.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				JOptionPane.showMessageDialog(null, "Coming Soon");
			}
		});
		lblVerMsDetalles.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblVerMsDetalles.setIcon(new ImageIcon(Home.class.getResource("/Imagenes/OjoIcon.png")));
		lblVerMsDetalles.setOpaque(true);
		lblVerMsDetalles.setHorizontalAlignment(SwingConstants.CENTER);
		lblVerMsDetalles.setForeground(Color.WHITE);
		lblVerMsDetalles.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblVerMsDetalles.setBorder(null);
		lblVerMsDetalles.setBackground(new Color(0, 155, 124));
		lblVerMsDetalles.setBounds(473, 722, 358, 63);
		panelFactura.add(lblVerMsDetalles);
		
		crearFactura = new JLabel("Crear Factura");
		crearFactura.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				JOptionPane.showMessageDialog(null, "Coming Soon");
			}
		});
		crearFactura.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		crearFactura.setIcon(new ImageIcon(Home.class.getResource("/Imagenes/FacturaIcon.png")));
		crearFactura.setBorder(null);
		crearFactura.setOpaque(true);
		crearFactura.setHorizontalAlignment(SwingConstants.CENTER);
		crearFactura.setForeground(Color.WHITE);
		crearFactura.setFont(new Font("Tahoma", Font.PLAIN, 30));
		crearFactura.setBackground(new Color(0, 155, 124));
		crearFactura.setBounds(73, 722, 358, 63);
		panelFactura.add(crearFactura);
		
		JScrollPane scrollPaneFactura = new JScrollPane();
		scrollPaneFactura.setBounds(73, 140, 795, 569);
		panelFactura.add(scrollPaneFactura);
		
		String headerFactura[] = {"Código", "Cliente", "Vendedor", "Cant. Articulos", "Total de la Factura"};
		modelFactura = new DefaultTableModel();
		modelFactura.setColumnIdentifiers(headerFactura);
		
		tableFactura = new JTable();
		tableFactura.setModel(modelFactura);
		tableFactura.getTableHeader().setBackground(new Color(0, 155, 124));
		tableFactura.getTableHeader().setForeground(Color.white);
		
		scrollPaneFactura.setViewportView(tableFactura);
		
		JLabel label_7 = new JLabel("");
		label_7.setIcon(new ImageIcon(Home.class.getResource("/Imagenes/FacturaLabel.png")));
		label_7.setHorizontalAlignment(SwingConstants.CENTER);
		label_7.setForeground(Color.WHITE);
		label_7.setFont(new Font("Tahoma", Font.PLAIN, 30));
		label_7.setBounds(71, 46, 196, 71);
		panelFactura.add(label_7);
		
		JLabel label_8 = new JLabel("");
		label_8.setOpaque(true);
		label_8.setBackground(new Color(0, 139, 139));
		label_8.setBounds(73, 114, 785, 3);
		panelFactura.add(label_8);
		
		JLabel label_9 = new JLabel("");
		label_9.setIcon(new ImageIcon(Home.class.getResource("/Imagenes/PanelHome.png")));
		label_9.setHorizontalAlignment(SwingConstants.CENTER);
		label_9.setBounds(12, 13, 955, 826);
		panelFactura.add(label_9);
		panelClientes.setLayout(null);
		panelClientes.setBackground(Color.WHITE);
		panelClientes.setBounds(401, 13, 967, 850);
		panel.add(panelClientes);
		
		scrollPaneCliente = new JScrollPane();
		scrollPaneCliente.setBounds(73, 140, 795, 639);
		panelClientes.add(scrollPaneCliente);
		
		String header[] = {"Cédula", "Nombre", "Telefono", "Dirección"};
		modelCliente = new DefaultTableModel();
		modelCliente.setColumnIdentifiers(header);
		
		tableCliente = new JTable();
		tableCliente.setModel(modelCliente);
		tableCliente.getTableHeader().setBackground(new Color(0, 155, 124));
		tableCliente.getTableHeader().setForeground(Color.WHITE);
		scrollPaneCliente.setViewportView(tableCliente);
		
		JLabel label_5 = new JLabel("");
		label_5.setIcon(new ImageIcon(Home.class.getResource("/Imagenes/ClientesLabel.png")));
		label_5.setHorizontalAlignment(SwingConstants.CENTER);
		label_5.setForeground(Color.WHITE);
		label_5.setFont(new Font("Tahoma", Font.PLAIN, 30));
		label_5.setBounds(73, 45, 196, 71);
		panelClientes.add(label_5);
		
		JLabel label_4 = new JLabel("");
		label_4.setOpaque(true);
		label_4.setBackground(new Color(0, 139, 139));
		label_4.setBounds(73, 114, 785, 3);
		panelClientes.add(label_4);
		
		JLabel label_6 = new JLabel("");
		label_6.setIcon(new ImageIcon(Home.class.getResource("/Imagenes/PanelHome.png")));
		label_6.setHorizontalAlignment(SwingConstants.CENTER);
		label_6.setBounds(12, 13, 955, 826);
		panelClientes.add(label_6);
		
		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon(Home.class.getResource("/Imagenes/LogoMenu.png")));
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setForeground(Color.WHITE);
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 30));
		label_2.setBounds(41, 764, 358, 78);
		panel.add(label_2);
		
		lblSalir = new JLabel("Salir");
		lblSalir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				Login login = new Login();
				login.setVisible(true);
			}
		});
		lblSalir.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblSalir.setIcon(new ImageIcon(Home.class.getResource("/Imagenes/SalirIcon.png")));
		lblSalir.setHorizontalAlignment(SwingConstants.CENTER);
		lblSalir.setForeground(Color.WHITE);
		lblSalir.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblSalir.setBounds(31, 673, 358, 78);
		panel.add(lblSalir);
		
		lblAdministrar = new JLabel("Administración");
		lblAdministrar.setBackground(new Color(36, 37, 38));
		lblAdministrar.setOpaque(true);
		lblAdministrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblProductos.setBackground(new Color(36, 37, 38));
				lblClientes.setBackground(new Color(36, 37, 38));
				lblFactura.setBackground(new Color(36, 37, 38));
				lblAdministrar.setBackground(new Color(0, 155, 124));
				panelProductos.setVisible(false);
				panelClientes.setVisible(false);
				panelFactura.setVisible(false);
				panelAdministrar.setVisible(true);
			}
		});
		lblAdministrar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblAdministrar.setIcon(new ImageIcon(Home.class.getResource("/Imagenes/Administraricon.png")));
		lblAdministrar.setHorizontalAlignment(SwingConstants.CENTER);
		lblAdministrar.setForeground(Color.WHITE);
		lblAdministrar.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblAdministrar.setBounds(31, 593, 358, 78);
		panel.add(lblAdministrar);
		
		lblFactura = new JLabel(" Factura");
		lblFactura.setBackground(new Color(36, 37, 38));
		lblFactura.setOpaque(true);
		lblFactura.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblProductos.setBackground(new Color(36, 37, 38));
				lblClientes.setBackground(new Color(36, 37, 38));
				lblFactura.setBackground(new Color(0, 155, 124));
				lblAdministrar.setBackground(new Color(36, 37, 38));
				panelProductos.setVisible(false);
				panelClientes.setVisible(false);
				panelFactura.setVisible(true);
				panelAdministrar.setVisible(false);
			}
		});
		lblFactura.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblFactura.setIcon(new ImageIcon(Home.class.getResource("/Imagenes/FacturaIcon.png")));
		lblFactura.setHorizontalAlignment(SwingConstants.CENTER);
		lblFactura.setForeground(Color.WHITE);
		lblFactura.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblFactura.setBounds(31, 516, 358, 78);
		panel.add(lblFactura);
		
		lblClientes = new JLabel("  Clientes");
		lblClientes.setBackground(new Color(36, 37, 38));
		lblClientes.setOpaque(true);
		lblClientes.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblProductos.setBackground(new Color(36, 37, 38));
				lblClientes.setBackground(new Color(0, 155, 124));
				lblFactura.setBackground(new Color(36, 37, 38));
				lblAdministrar.setBackground(new Color(36, 37, 38));
				panelProductos.setVisible(false);
				panelClientes.setVisible(true);
				panelFactura.setVisible(false);
				panelAdministrar.setVisible(false);
			}
		});
		lblClientes.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblClientes.setIcon(new ImageIcon(Home.class.getResource("/Imagenes/ClientesUSer.png")));
		lblClientes.setHorizontalAlignment(SwingConstants.CENTER);
		lblClientes.setForeground(Color.WHITE);
		lblClientes.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblClientes.setBounds(31, 437, 358, 78);
		panel.add(lblClientes);
		
		lblProductos = new JLabel("Productos");
		lblProductos.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblProductos.setOpaque(true);
		lblProductos.setBackground(new Color(0, 155, 124));
		lblProductos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblProductos.setBackground(new Color(0, 155, 124));
				lblClientes.setBackground(new Color(36, 37, 38));
				lblFactura.setBackground(new Color(36, 37, 38));
				lblAdministrar.setBackground(new Color(36, 37, 38));
				panelProductos.setVisible(true);
				panelClientes.setVisible(false);
				panelFactura.setVisible(false);
				panelAdministrar.setVisible(false);
			}
		});
		lblProductos.setIcon(new ImageIcon(Home.class.getResource("/Imagenes/ProductosIcon.png")));
		lblProductos.setHorizontalAlignment(SwingConstants.CENTER);
		lblProductos.setForeground(Color.WHITE);
		lblProductos.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblProductos.setBounds(31, 367, 358, 78);
		panel.add(lblProductos);
		
		JLabel lblAdministrador = new JLabel("Administrador");
		lblAdministrador.setHorizontalAlignment(SwingConstants.CENTER);
		lblAdministrador.setForeground(Color.WHITE);
		lblAdministrador.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblAdministrador.setBounds(112, 299, 193, 55);
		panel.add(lblAdministrador);
		
		JLabel lblDarvyBetances = new JLabel("Darvy Betances");
		lblDarvyBetances.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblDarvyBetances.setForeground(Color.WHITE);
		lblDarvyBetances.setHorizontalAlignment(SwingConstants.CENTER);
		lblDarvyBetances.setBounds(99, 238, 219, 78);
		panel.add(lblDarvyBetances);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(Home.class.getResource("/Imagenes/CirculoFotoUser.png")));
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setBounds(115, 58, 187, 202);
		panel.add(label_1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon(Home.class.getResource("/Imagenes/MenuPanel.png")));
		lblNewLabel.setBounds(31, 30, 358, 835);
		panel.add(lblNewLabel);
		
		loadTableCliente();
		loadTableProductos();
		loadTableFactura();
	}
	
	public static void loadTableCliente() {
		
		modelCliente.setRowCount(0);
		rows = new Object[modelCliente.getColumnCount()];
		
		//Clientes de Prueba
		
		Cliente c1 = new Cliente("402-3343", "Darvy", "Bella vista, Satiago de los caballeros", "829-699-4610");
		Cliente c2 = new Cliente("402-4550", "Eduardo", "Puerto Planta", "843-433-5552");
		Cliente c3 = new Cliente("402-5024", "Gabriel", "La Vega", "829-444-1340");
		
		Tienda.getInstance().addCliente(c1);
		Tienda.getInstance().addCliente(c2);
		Tienda.getInstance().addCliente(c3);
		
		for (Cliente cliente : Tienda.getInstance().getMisClientes()) {
			rows[0] = cliente.getCedula();
			rows[1] = cliente.getNombre();
			rows[2] = cliente.getTelefono();
			rows[3] = cliente.getDireccion();
			modelCliente.addRow(rows);
		}
	}
public static void loadTableProductos() {
		
		modelProductos.setRowCount(0);
		rows = new Object[modelProductos.getColumnCount()];
		
		//Productos de Prueba
		Producto p1 = new MotherBoard("402", 10, 25000, "RTX", 1, 20, "QSY", "QSY", "QSY");
		Producto p2 = new MemoriaRam("403", 100, 10000, "TridentZ", 1, 500, 32, "DDR4");
		Tienda.getInstance().addProducto(p1);
		Tienda.getInstance().addProducto(p2);

		for (Producto producto : Tienda.getInstance().getMisProductos()) {
			rows[0] = producto.getClass().getSimpleName();
			rows[1] = producto.getNumSerie();
			rows[2] = producto.getMarca();
			rows[3] = producto.getPrecio();
			rows[4] = producto.getCantidad();
			modelProductos.addRow(rows);
		}
	}

public static void loadTableFactura() {
	
	modelFactura.setRowCount(0);
	rows = new Object[modelFactura.getColumnCount()];
	
	//Factura de Prueba:
	Vendedor v1 = new Vendedor("DarvyBM", "KLK", "Darvy Betances", "2434-332", "809-247-2240", "Santiago de los caballeros");
	Cliente c1 = new Cliente("24234", "Fulanito", "Cerca de ti bb", "334-233-4244");
	ArrayList<Producto> productos = new ArrayList<Producto>();
	productos.add(new MicroProcesador("344", 43, 2344, "Intel", 1, 400, "Qsy", "Qsy", 124));
	Factura f1 = new Factura("Fact - 1", v1, c1 , productos);

	Tienda.getInstance().addFactura(f1);
	
	for (Factura factura : Tienda.getInstance().getMisFacturas()) {
		rows[0] = factura.getCodigo();
		rows[1] = factura.getMiCliente().getNombre();
		rows[2] = factura.getMiVendedor().getNombre();
		rows[3] = factura.getMisProductos().size();
		rows[4] = factura.getPrecioTotal();
		modelFactura.addRow(rows);
	}
}
}
