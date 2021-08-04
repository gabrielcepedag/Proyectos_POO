package visual;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import logico.Cliente;
import logico.Combo;
import logico.DiscoDuro;
import logico.Factura;
import logico.MemoriaRam;
import logico.MicroProcesador;
import logico.MotherBoard;
import logico.OrdenCompra;
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
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;
import javax.swing.JComboBox;
import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ListSelectionModel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
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
	private static DefaultTableModel modelCliente;
	private static DefaultTableModel modelFactura;
	private static Object rows[];
	private static DefaultTableModel modelProductos;
	private JTable tableCliente;
	private JScrollPane scrollPaneCliente;
	private JLabel crearFactura;
	private JTable tableFactura;
	private JComboBox<String> cbxTipoProducto;
	private JScrollPane scrollPaneProducto;
	private JTextField txtCedulaFact;
	Cliente clienteBuscado = null;
	int indexCbx = 0;
	String cedulaClienteFact = null;
	String cedulaCliente = null;
	private JComboBox<String> cbxTipoFactura;
	private JTextField txtCedulaCliente;
	private JLabel label_19;
	private JLabel detalles;
	 private Factura selectedFactura = null;
	 private static JLabel lblNombre;
	 private static JLabel lblClass;
	 private JLabel lblImagen;
	
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

	public Home() throws IOException {
		
		/*
		Tienda.getInstance().getMisClientes().clear();
		Tienda.getInstance().getMisFacturas().clear();
		Tienda.getInstance().getMisProductos().clear();
		Tienda.getInstance().getMisCombos().clear();
		Tienda.getInstance().getMisEmpleados().clear();
		Tienda.getInstance().getMisOrdenesCompra().clear();
		Factura.cod = 1;
		Combo.cod = 1;
		OrdenCompra.numOrdenCompra = 1;*/
		
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
				int option = JOptionPane.showConfirmDialog(null, "¿Desea cerrar sesión?", "Cierre de sesión",JOptionPane.YES_NO_OPTION);
				if (option == JOptionPane.YES_OPTION) {
					FileOutputStream tienda2;
					ObjectOutputStream tiendaWrite;
					try {
						tienda2 = new  FileOutputStream("empresa.dat");
						tiendaWrite = new ObjectOutputStream(tienda2);
						Tienda.getInstance().actualizarVariablesStatic();
						tiendaWrite.writeObject(Tienda.getInstance());
					} catch (FileNotFoundException e1) {
						e1.printStackTrace();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					dispose();
				}
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
		panelAdministrar.setLayout(null);
		panelAdministrar.setBackground(Color.WHITE);
		panelAdministrar.setBounds(401, 13, 967, 850);
		panel.add(panelAdministrar);
		
		JLabel lblCuenta = new JLabel(" Cuenta");
		lblCuenta.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblCuenta.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				RegVendedor regVendedor = null;
				try {
					regVendedor = new RegVendedor(Tienda.getInstance().getLoginUserEmpleado());
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				regVendedor.setModal(true);
				regVendedor.setVisible(true);
			}
		});
		
		JLabel lblProductos_1 = new JLabel(" Productos");
		lblProductos_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ListarProducto listarProducto = new ListarProducto();
				listarProducto.setModal(true);
				listarProducto.setVisible(true);
			}
		});
		
		JLabel lblDistribuidor = new JLabel("Datos Generales");
		lblDistribuidor.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblDistribuidor.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ListarDatosGenerales listarDatosGenerales = new ListarDatosGenerales();
				listarDatosGenerales.setModal(true);
				listarDatosGenerales.setVisible(true);
			}
		});
		lblDistribuidor.setIcon(new ImageIcon(Home.class.getResource("/Imagenes/EstadisticaIcon.png")));
		lblDistribuidor.setForeground(Color.WHITE);
		lblDistribuidor.setFont(new Font("Tahoma", Font.PLAIN, 35));
		lblDistribuidor.setBounds(381, 574, 357, 122);
		panelAdministrar.add(lblDistribuidor);
		
		JLabel label_20 = new JLabel("");
		label_20.setIcon(new ImageIcon(Home.class.getResource("/Imagenes/Group 3.png")));
		label_20.setBounds(466, 548, 290, 175);
		panelAdministrar.add(label_20);
		lblProductos_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblProductos_1.setIcon(new ImageIcon(Home.class.getResource("/Imagenes/ProductosIcon.png")));
		lblProductos_1.setForeground(Color.WHITE);
		lblProductos_1.setFont(new Font("Tahoma", Font.PLAIN, 35));
		lblProductos_1.setBounds(360, 167, 249, 122);
		panelAdministrar.add(lblProductos_1);
		
		JLabel label_18 = new JLabel("");
		label_18.setIcon(new ImageIcon(Home.class.getResource("/Imagenes/Group 3.png")));
		label_18.setBounds(338, 145, 290, 175);
		panelAdministrar.add(label_18);
		lblCuenta.setIcon(new ImageIcon(Home.class.getResource("/Imagenes/settingsIcon.png")));
		lblCuenta.setForeground(Color.WHITE);
		lblCuenta.setFont(new Font("Tahoma", Font.PLAIN, 35));
		lblCuenta.setBounds(86, 574, 222, 122);
		panelAdministrar.add(lblCuenta);
		
		JLabel label_17 = new JLabel("");
		label_17.setIcon(new ImageIcon(Home.class.getResource("/Imagenes/Group 3.png")));
		label_17.setBounds(46, 548, 290, 175);
		panelAdministrar.add(label_17);
		
		JLabel lblOrdenDeCompra = new JLabel(" Pedidos");
		lblOrdenDeCompra.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblOrdenDeCompra.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ListarPedido listarPedido = new ListarPedido();
				listarPedido.setModal(true);
				listarPedido.setVisible(true);
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
				ListarFactura listarFactura = new ListarFactura();
				listarFactura.setModal(true);
				listarFactura.setVisible(true);
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
		
		JLabel label_15 = new JLabel("");
		label_15.setIcon(new ImageIcon(Home.class.getResource("/Imagenes/Group 3.png")));
		label_15.setBounds(338, 548, 422, 175);
		panelAdministrar.add(label_15);
		
		JLabel lblCombos = new JLabel(" Combos");
		lblCombos.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblCombos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ListarCombo listarCombo = new ListarCombo();
				listarCombo.setModal(true);
				listarCombo.setVisible(true);
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
				ListarVendedor listarVendedor = new ListarVendedor();
				listarVendedor.setModal(true);
				listarVendedor.setVisible(true);
			}
		});
		lblVendedores.setIcon(new ImageIcon(Home.class.getResource("/Imagenes/VendedoresIcon.png")));
		lblVendedores.setForeground(Color.WHITE);
		lblVendedores.setFont(new Font("Tahoma", Font.PLAIN, 35));
		lblVendedores.setBounds(360, 367, 249, 122);
		panelAdministrar.add(lblVendedores);
		
		JLabel label_12 = new JLabel("");
		label_12.setIcon(new ImageIcon(Home.class.getResource("/Imagenes/Group 3.png")));
		label_12.setBounds(338, 345, 290, 175);
		panelAdministrar.add(label_12);
		
		JLabel lblClientes_2 = new JLabel("  Clientes");
		lblClientes_2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblClientes_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ListarCliente listarCliente = new ListarCliente();
				listarCliente.setModal(true);
				listarCliente.setVisible(true);
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
				//JOptionPane.showMessageDialog(null, "Coming Soon","Aviso",JOptionPane.INFORMATION_MESSAGE);
			}
		});
		lblClientes_1.setIcon(new ImageIcon(Home.class.getResource("/Imagenes/PanelHome.png")));
		lblClientes_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblClientes_1.setBounds(12, 13, 955, 826);
		panelAdministrar.add(lblClientes_1);
		
		panelProductos = new JPanel();
		panelProductos.setBackground(Color.WHITE);
		panelProductos.setBounds(401, 13, 967, 850);
		panel.add(panelProductos);
		panelProductos.setLayout(null);
		
		cbxTipoProducto = new JComboBox<String>();
		cbxTipoProducto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int index = -1;
				index = cbxTipoProducto.getSelectedIndex();
				if (index != -1) {
					loadTableProductos(index);
				}
			}
		});
		
		cbxTipoProducto.setOpaque(false);
		cbxTipoProducto.setIgnoreRepaint(true);
		cbxTipoProducto.setBorder(null);
		cbxTipoProducto.setBackground(Color.WHITE);
		cbxTipoProducto.setFont(new Font("Tahoma", Font.PLAIN, 17));
		cbxTipoProducto.setModel(new DefaultComboBoxModel<String>(new String[] {"<Todos>", "Disco Duros", "Memorias Ram", "Micro Procesadores", "Placas Madres"}));
		cbxTipoProducto.setBounds(73, 130, 340, 33);
		panelProductos.add(cbxTipoProducto);
		
		scrollPaneProducto = new JScrollPane();
		scrollPaneProducto.setBounds(73, 176, 795, 643);
		panelProductos.add(scrollPaneProducto);
		
		String headerProducto[] = {"Número de serie", "Marca", "Precio", "Cantidad", "Disp. Min","Categoría"};
		modelProductos = new DefaultTableModel();
		modelProductos.setColumnIdentifiers(headerProducto);
		
		JTable tableProductos = new JTable();
		tableProductos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
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
		panelFactura.setLayout(null);
		panelFactura.setBackground(Color.WHITE);
		panelFactura.setBounds(401, 13, 967, 850);
		panel.add(panelFactura);
		
		detalles = new JLabel("Ver m\u00E1s detalles");
		detalles.setEnabled(false);
		detalles.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				FacturaDetalles facturaDetalles = new FacturaDetalles(selectedFactura);
				facturaDetalles.setModal(true);
				facturaDetalles.setVisible(true);
			}
		});
		
		JLabel lblNewLabel_4 = new JLabel("Buscar");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_4.setOpaque(true);
		lblNewLabel_4.setBackground(new Color(0,155,124));
		lblNewLabel_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (!(txtCedulaFact.getText().isEmpty())) {
					indexCbx = cbxTipoFactura.getSelectedIndex();
					cedulaClienteFact = txtCedulaFact.getText();
					loadTableFactura(indexCbx, cedulaClienteFact);
				}else {
					txtCedulaFact.setText("");
					loadTableFactura(indexCbx, null);
				}
			}
		});
		lblNewLabel_4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel_4.setIcon(new ImageIcon(Home.class.getResource("/Imagenes/Lupa.png")));
		lblNewLabel_4.setBounds(535, 128, 150, 37);
		panelFactura.add(lblNewLabel_4);
		
		txtCedulaFact = new JTextField();
		txtCedulaFact.setFont(new Font("Tahoma", Font.PLAIN, 17));
		txtCedulaFact.setHorizontalAlignment(SwingConstants.CENTER);
		txtCedulaFact.setBackground(Color.WHITE);
		txtCedulaFact.setBounds(315, 130, 200, 33);
		panelFactura.add(txtCedulaFact);
		txtCedulaFact.setColumns(10);
		
		detalles.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		detalles.setIcon(new ImageIcon(Home.class.getResource("/Imagenes/OjoIcon.png")));
		detalles.setOpaque(true);
		detalles.setHorizontalAlignment(SwingConstants.CENTER);
		detalles.setForeground(Color.WHITE);
		detalles.setFont(new Font("Tahoma", Font.PLAIN, 30));
		detalles.setBorder(null);
		detalles.setBackground(new Color(0, 155, 124));
		detalles.setBounds(473, 722, 358, 63);
		panelFactura.add(detalles);
		
		crearFactura = new JLabel("Crear Factura");
		crearFactura.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(crearFactura.isEnabled()) {
					RegFactura regFactura = new RegFactura();
					regFactura.setModal(true);
					regFactura.setVisible(true);
				}
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
		scrollPaneFactura.setBounds(73, 170, 795, 530);
		panelFactura.add(scrollPaneFactura);
		
		String headerFactura[] = {"Código", "Cliente", "Vendedor", "Cant. Articulos", "Total de la Factura","Crédito"};
		modelFactura = new DefaultTableModel();
		modelFactura.setColumnIdentifiers(headerFactura);
		
		tableFactura = new JTable();
		tableFactura.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int index = -1;
				index = tableFactura.getSelectedRow();
				if(index != -1) {
					detalles.setEnabled(true);
					String codigo = (String)(modelFactura.getValueAt(index, 0));
					selectedFactura = Tienda.getInstance().buscarFacturaByCodigo(codigo);
				}
			}
		});
		tableFactura.setModel(modelFactura);
		tableFactura.getTableHeader().setBackground(new Color(0, 155, 124));
		tableFactura.getTableHeader().setForeground(Color.white);
		
		cbxTipoFactura = new JComboBox<String>();
		cbxTipoFactura.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index = -1;
				index = cbxTipoFactura.getSelectedIndex();
				if (index != -1) {
					indexCbx = index;
					if (txtCedulaFact.getText().isEmpty()) {
						loadTableFactura(indexCbx, null);
					}else {
						loadTableFactura(indexCbx, cedulaClienteFact);
					}
				}
			}
		});
		cbxTipoFactura.setModel(new DefaultComboBoxModel<String>(new String[] {"<Todas>", "Facturas sin cr\u00E9dito", "Facturas a cr\u00E9dito"}));
		cbxTipoFactura.setSelectedIndex(0);
		cbxTipoFactura.setOpaque(false);
		cbxTipoFactura.setIgnoreRepaint(true);
		cbxTipoFactura.setFont(new Font("Tahoma", Font.PLAIN, 17));
		cbxTipoFactura.setBorder(null);
		cbxTipoFactura.setBackground(Color.WHITE);
		cbxTipoFactura.setBounds(73, 130, 200, 33);
		panelFactura.add(cbxTipoFactura);
		
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
		
		txtCedulaCliente = new JTextField();
		txtCedulaCliente.setHorizontalAlignment(SwingConstants.CENTER);
		txtCedulaCliente.setFont(new Font("Tahoma", Font.PLAIN, 17));
		txtCedulaCliente.setColumns(10);
		txtCedulaCliente.setBackground(Color.WHITE);
		txtCedulaCliente.setBounds(73, 128, 210, 40);
		panelClientes.add(txtCedulaCliente);
		
		label_19 = new JLabel("Buscar");
		label_19.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (!(txtCedulaCliente.getText().isEmpty())) {
					cedulaCliente = txtCedulaCliente.getText();
					loadTableCliente(cedulaCliente);
				}else {
					txtCedulaFact.setText("");
					loadTableCliente(null);
				}
			}
		});
		label_19.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		label_19.setIcon(new ImageIcon(Home.class.getResource("/Imagenes/Lupa.png")));
		label_19.setOpaque(true);
		label_19.setFont(new Font("Tahoma", Font.PLAIN, 17));
		label_19.setBackground(new Color(0, 155, 124));
		label_19.setBounds(300, 128, 150, 40);
		panelClientes.add(label_19);
		
		scrollPaneCliente = new JScrollPane();
		scrollPaneCliente.setBounds(73, 179, 795, 585);
		panelClientes.add(scrollPaneCliente);
		
		String header[] = {"Cédula", "Nombre", "Telefono", "Dirección","Crédito"};
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
				int option = JOptionPane.showConfirmDialog(null, "¿Desea cerrar sesión?", "Cierre de sesión",JOptionPane.YES_NO_OPTION);
				if (option == JOptionPane.YES_OPTION) {
					FileOutputStream tienda2;
					ObjectOutputStream tiendaWrite;
					try {
						tienda2 = new  FileOutputStream("empresa.dat");
						tiendaWrite = new ObjectOutputStream(tienda2);
						Tienda.getInstance().actualizarVariablesStatic();
						tiendaWrite.writeObject(Tienda.getInstance());
					} catch (FileNotFoundException e1) {
						e1.printStackTrace();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					Login login = new Login();
					dispose();
					login.setVisible(true);
				}
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
				if (lblAdministrar.isEnabled()) {
					lblProductos.setBackground(new Color(36, 37, 38));
					lblClientes.setBackground(new Color(36, 37, 38));
					lblFactura.setBackground(new Color(36, 37, 38));
					lblAdministrar.setBackground(new Color(0, 155, 124));
					panelProductos.setVisible(false);
					panelClientes.setVisible(false);
					panelFactura.setVisible(false);
					panelAdministrar.setVisible(true);
				}
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
				panelAdministrar.setVisible(false);
				panelFactura.setVisible(true);
				loadTableFactura(0, null);
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
				panelFactura.setVisible(false);
				panelAdministrar.setVisible(false);
				panelClientes.setVisible(true);
				loadTableCliente(null);
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
				panelClientes.setVisible(false);
				panelFactura.setVisible(false);
				panelAdministrar.setVisible(false);
				panelProductos.setVisible(true);
				loadTableProductos(0);
			}
		});
		lblProductos.setIcon(new ImageIcon(Home.class.getResource("/Imagenes/ProductosIcon.png")));
		lblProductos.setHorizontalAlignment(SwingConstants.CENTER);
		lblProductos.setForeground(Color.WHITE);
		lblProductos.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblProductos.setBounds(31, 367, 358, 78);
		panel.add(lblProductos);
		
		lblClass = new JLabel(Tienda.getInstance().getLoginUserEmpleado().getClass().getSimpleName());
		lblClass.setHorizontalAlignment(SwingConstants.CENTER);
		lblClass.setForeground(Color.WHITE);
		lblClass.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblClass.setBounds(112, 299, 193, 55);
		panel.add(lblClass);
		
		lblNombre = new JLabel(Tienda.getInstance().getLoginUserEmpleado().getNombre());
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNombre.setForeground(Color.WHITE);
		lblNombre.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombre.setBounds(99, 238, 219, 78);
		panel.add(lblNombre);
		
		lblImagen = new JLabel("");
		lblImagen.setBorder(new LineBorder(new Color(0, 155, 124), 5));
		lblImagen.setHorizontalAlignment(SwingConstants.CENTER);
		lblImagen.setBounds(118, 60, 187, 187);
		panel.add(lblImagen);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon(Home.class.getResource("/Imagenes/MenuPanel.png")));
		lblNewLabel.setBounds(31, 30, 358, 835);
		panel.add(lblNewLabel);
		
		loadTableCliente(null);
		cbxTipoProducto.setSelectedIndex(0);
		loadTableProductos(0);
		cbxTipoFactura.setSelectedIndex(0);
		loadTableFactura(indexCbx,cedulaClienteFact);
		
		if (!Tienda.getInstance().getLoginUserEmpleado().getClass().getSimpleName().equalsIgnoreCase("Administrador")) {
			lblAdministrar.setEnabled(false);
		}
		if (Tienda.getInstance().getLoginUserEmpleado().getClass().getSimpleName().equalsIgnoreCase("Administrador")) {
			crearFactura.setEnabled(false);
		}
		
		if (Tienda.getInstance().getLoginUserEmpleado() instanceof Vendedor) {
	        File f = new File("src/ImagenesEmpleados/Archivo"+Tienda.getInstance().getLoginUserEmpleado().getCedula()+".jpg");
	        Image bi;
			bi = ImageIO.read(f);
			lblImagen.setIcon(new ImageIcon(bi.getScaledInstance(187, 187, 0)));
		}
		else {
			lblImagen.setIcon(new ImageIcon(Home.class.getResource("/Imagenes/AdminDefectIcon.png")));
		}
	}
	
	public static void loadHome() {
		lblNombre.setText(Tienda.getInstance().getLoginUserEmpleado().getNombre());
		lblClass.setText(Tienda.getInstance().getLoginUserEmpleado().getClass().getSimpleName());
	}
	
	public static void loadTableCliente(String cedula) {
		
		modelCliente.setRowCount(0);
		rows = new Object[modelCliente.getColumnCount()];
		
		Cliente clienteSel = Tienda.getInstance().buscarClienteByCedula(cedula);
		
		if (cedula == null) {
			for (Cliente cliente : Tienda.getInstance().getMisClientes()) {
				rows[0] = cliente.getCedula();
				rows[1] = cliente.getNombre();
				rows[2] = cliente.getTelefono();
				rows[3] = cliente.getDireccion();
				rows[4] = cliente.getCredito();
				modelCliente.addRow(rows);
			}
		}else if (clienteSel != null) {
				rows[0] = clienteSel.getCedula();
				rows[1] = clienteSel.getNombre();
				rows[2] = clienteSel.getTelefono();
				rows[3] = clienteSel.getDireccion();
				rows[4] = clienteSel.getCredito();
				modelCliente.addRow(rows);
		}
		
	}
	
	public static void loadTableProductos(int selection) {
		
		modelProductos.setRowCount(0);
		rows = new Object[modelProductos.getColumnCount()];
		
		for (int i = modelProductos.getRowCount() - 1; i >= 0; i--) {
			modelProductos.removeRow(i);
		}

		switch (selection) {
		case 0:
			String headerProducto[] = {"# de serie", "Marca", "Precio", "Cantidad","Disp. min","Categoría"};
			modelProductos.setColumnIdentifiers(headerProducto);
			
			for (Producto producto : Tienda.getInstance().getMisProductos()) {
				rows[0] = producto.getNumSerie();
				rows[1] = producto.getMarca();
				rows[2] = producto.getPrecio();
				rows[3] = producto.getCantidad();
				rows[4] = producto.getDispMin();
				rows[5] = producto.getClass().getSimpleName();
				modelProductos.addRow(rows);
			}
			break;

		case 1:
			String headersHD[] = {"# de serie", "Marca", "Precio", "Cantidad","Modelo","Capacidad"};
			modelProductos.setColumnIdentifiers(headersHD);
			
			for (Producto producto : Tienda.getInstance().getMisProductos()) {
				if (producto instanceof DiscoDuro) {
					rows[0] = producto.getNumSerie();
					rows[1] = producto.getMarca();
					rows[2] = producto.getPrecio();
					rows[3] = producto.getCantidad();
					rows[4] = ((DiscoDuro)producto).getModelo();
					if (((DiscoDuro)producto).getCapacidad() >= 1024) {
						rows[5] = ((DiscoDuro)producto).getCapacidad() / 1024 + " TB";
					}else {
						rows[5] = ((DiscoDuro)producto).getCapacidad() + " GB";
					}
					modelProductos.addRow(rows);
				}
			}
			break;
		case 2:
			String headersRam[] = {"# de serie", "Marca", "Precio", "Cantidad","Capacidad","Tipo memoria"};
			modelProductos.setColumnIdentifiers(headersRam);
			
			for (Producto producto : Tienda.getInstance().getMisProductos()) {
				if (producto instanceof MemoriaRam) {
					rows[0] = producto.getNumSerie();
					rows[1] = producto.getMarca();
					rows[2] = producto.getPrecio();
					rows[3] = producto.getCantidad();
					if (((MemoriaRam)producto).getCapacidad() >= 1024) {
						rows[4] = ((MemoriaRam)producto).getCapacidad() / 1024 + " TB";
					}else {
						rows[4] = ((MemoriaRam)producto).getCapacidad() + " GB";
					}
					rows[5] = ((MemoriaRam)producto).getTipoMemoria();
					modelProductos.addRow(rows);
				}
			}
			break;
		
		case 3:
			String headersMicro[] = {"# de serie", "Marca", "Precio", "Cantidad","Modelo","procesamiento"};
			modelProductos.setColumnIdentifiers(headersMicro);
			
			for (Producto producto : Tienda.getInstance().getMisProductos()) {
				if (producto instanceof MicroProcesador) {
					rows[0] = producto.getNumSerie();
					rows[1] = producto.getMarca();
					rows[2] = producto.getPrecio();
					rows[3] = producto.getCantidad();
					rows[4] = ((MicroProcesador)producto).getModelo();
					rows[5] = ((MicroProcesador)producto).getVelocidadProcesamiento() + " GHz";
					modelProductos.addRow(rows);
				}
			}
			break;
		case 4:
			String headersMoBoard[] = {"# de serie", "Marca", "Precio", "Cantidad","Modelo","Tipo Ram"};
			modelProductos.setColumnIdentifiers(headersMoBoard);
			
			for (Producto producto : Tienda.getInstance().getMisProductos()) {
				if (producto instanceof MotherBoard) {
					rows[0] = producto.getNumSerie();
					rows[1] = producto.getMarca();
					rows[2] = producto.getPrecio();
					rows[3] = producto.getCantidad();
					rows[4] = ((MotherBoard)producto).getModelo();
					rows[5] = ((MotherBoard)producto).getTipoRam();
					modelProductos.addRow(rows);
				}
			}
			break;
		}
		
	}

	public static void loadTableFactura(int selection, String cedulaCliente) {
	
		modelFactura.setRowCount(0);
		rows = new Object[modelFactura.getColumnCount()];

		Cliente clienteSel = Tienda.getInstance().buscarClienteByCedula(cedulaCliente);
	
		if (cedulaCliente == null && selection == 0) {
			for (Factura factura : Tienda.getInstance().getMisFacturas()) {
				rows[0] = factura.getCodigo();
				rows[1] = factura.getMiCliente().getNombre();
				rows[2] = factura.getMiVendedor().getNombre();
				rows[3] = factura.getMisProductos().size();
				rows[4] = factura.getPrecioTotal();
				if (factura.isACredito()) {
					rows[5] = "Si";
				}else {
					rows[5] = "No";
				}
				modelFactura.addRow(rows);
			}
		} else if (cedulaCliente != null && selection == 0){
			for (Factura factura : Tienda.getInstance().getMisFacturas()) {
				if (factura.getMiCliente().equals(clienteSel)) {
					rows[0] = factura.getCodigo();
					rows[1] = factura.getMiCliente().getNombre();
					rows[2] = factura.getMiVendedor().getNombre();
					rows[3] = factura.getMisProductos().size();
					rows[4] = factura.getPrecioTotal();
					if (factura.isACredito()) {
						rows[5] = "Si";
					}else {
						rows[5] = "No";
					}
					modelFactura.addRow(rows);
				}
			}
		}else if(cedulaCliente == null && selection == 1) {
			for (Factura factura : Tienda.getInstance().getMisFacturas()) {
				if (factura.isACredito() == false ) {
					rows[0] = factura.getCodigo();
					rows[1] = factura.getMiCliente().getNombre();
					rows[2] = factura.getMiVendedor().getNombre();
					rows[3] = factura.getMisProductos().size();
					rows[4] = factura.getPrecioTotal();
					rows[5] = "No";
					modelFactura.addRow(rows);
				}
			}
		}else if (cedulaCliente != null && selection == 1) {
			for (Factura factura : Tienda.getInstance().getMisFacturas()) {
				if (factura.getMiCliente().equals(clienteSel) && factura.isACredito() == false ) {
					rows[0] = factura.getCodigo();
					rows[1] = factura.getMiCliente().getNombre();
					rows[2] = factura.getMiVendedor().getNombre();
					rows[3] = factura.getMisProductos().size();
					rows[4] = factura.getPrecioTotal();
					rows[5] = "No";
					modelFactura.addRow(rows);
				}
			}
		}else if (cedulaCliente == null && selection == 2) {
			for (Factura factura : Tienda.getInstance().getMisFacturas()) {
				if (factura.isACredito()) {
					rows[0] = factura.getCodigo();
					rows[1] = factura.getMiCliente().getNombre();
					rows[2] = factura.getMiVendedor().getNombre();
					rows[3] = factura.getMisProductos().size();
					rows[4] = factura.getPrecioTotal();
					rows[5] = "si";
					modelFactura.addRow(rows);
				}
			}
		}else if (cedulaCliente != null && selection == 2) {
			for (Factura factura : Tienda.getInstance().getMisFacturas()) {
				if (factura.getMiCliente().equals(clienteSel) && factura.isACredito()) {
					rows[0] = factura.getCodigo();
					rows[1] = factura.getMiCliente().getNombre();
					rows[2] = factura.getMiVendedor().getNombre();
					rows[3] = factura.getMisProductos().size();
					rows[4] = factura.getPrecioTotal();
					rows[5] = "si";
					modelFactura.addRow(rows);
				}
			}
		}
		
	}
}
