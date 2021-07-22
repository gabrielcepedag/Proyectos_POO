package Visual;

import java.awt.BorderLayout;



import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logico.Administrador;
import logico.Cliente;
import logico.Combo;
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
import java.util.ArrayList;

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
import javax.swing.DefaultListModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JList;
import javax.swing.ListSelectionModel;

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
	private JPanel panelCombos;
	private JPanel panelProductos;
	private JTextField txtTelefono;
	private JList<String> listComboDisp;
	private JList<String> listComboSel;
	private DefaultListModel<String> listModelComboDisp;
	private DefaultListModel<String> listModelComboSel;
	private ArrayList<Combo> combosSeleccionados= new ArrayList<Combo>();
	private JList<String> listProductosDisp;
	private JList<String> listProductosSel;
	private DefaultListModel<String> listModelProductosDisp;
	private DefaultListModel<String> listModelProductosSel;
	private ArrayList<Producto> productosSeleccionados= new ArrayList<Producto>();
	private JLabel lblArribaCombo;
	private JLabel lblAbajoCombo;
	private JLabel lblAbajoProductos;
	private JLabel lblArribaProductos;
	private Cliente auxCliente = null;
	private Vendedor auxVendedor = null;
	//private Vendedor AuxVendedor;
	private Factura factura = null;
	private JRadioButton rdbtnFacturaACredito;

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
		
		lblArribaCombo = new JLabel("\u2191\u2191");
		//lblArribaCombo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblArribaCombo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String aux = listComboSel.getSelectedValue().toString();
				listModelComboDisp.addElement(aux);
				listModelComboSel.remove(listComboSel.getSelectedIndex());
				combosSeleccionados.remove(Tienda.getInstance().buscarComboByCod(aux.substring(0, aux.indexOf('|')-1)));
				lblArribaCombo.setBackground(new Color(0, 85, 70));
				lblArribaCombo.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
			}
		});
		lblArribaCombo.setOpaque(true);
		lblArribaCombo.setHorizontalAlignment(SwingConstants.CENTER);
		lblArribaCombo.setForeground(Color.WHITE);
		lblArribaCombo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblArribaCombo.setBackground(new Color(0, 85, 70));
		//lblArribaCombo.setBackground(new Color(0, 155, 124));
		lblArribaCombo.setBounds(157, 275, 74, 45);
		panelCombos.add(lblArribaCombo);
		
		lblAbajoCombo = new JLabel("\u2193\u2193");
		lblAbajoCombo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(!txtCedula.getText().isEmpty()) {
					String aux = listComboDisp.getSelectedValue().toString();
					listModelComboSel.addElement(aux);
					listModelComboDisp.remove(listComboDisp.getSelectedIndex());
					combosSeleccionados.add(Tienda.getInstance().buscarComboByCod(aux.substring(0, aux.indexOf('|')-1)));
					lblAbajoCombo.setBackground(new Color(0, 85, 70));
					lblAbajoCombo.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
				}else {
					JOptionPane.showMessageDialog(null, "Debe especificar una cédula para seleccionar un Combo.", "Información", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		//lblAbajoCombo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblAbajoCombo.setOpaque(true);
		lblAbajoCombo.setHorizontalAlignment(SwingConstants.CENTER);
		lblAbajoCombo.setForeground(Color.WHITE);
		lblAbajoCombo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblAbajoCombo.setBackground(new Color(0, 85, 70));
		//lblAbajoCombo.setBackground(new Color(0, 155, 124));
		lblAbajoCombo.setBounds(243, 275, 74, 45);
		panelCombos.add(lblAbajoCombo);
		
		JLabel lblCombosDisponibles = new JLabel("Combos disponibles:");
		lblCombosDisponibles.setForeground(Color.BLACK);
		lblCombosDisponibles.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblCombosDisponibles.setBounds(12, 0, 190, 55);
		panelCombos.add(lblCombosDisponibles);
		
		JScrollPane scrollPaneCombosDisp = new JScrollPane();
		scrollPaneCombosDisp.setBounds(12, 51, 441, 215);
		panelCombos.add(scrollPaneCombosDisp);
		
		listComboDisp = new JList<String>();
		listComboDisp.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				int index = -1;
				index = listComboDisp.getSelectedIndex();
				if (index != -1) {
					lblAbajoCombo.setBackground(new Color(0, 155, 124));
					lblAbajoCombo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				}
			}
		});
		listModelComboDisp = new DefaultListModel<String>();
		listComboDisp.setModel(listModelComboDisp);
		listComboDisp.setFont(new Font("Tahoma", Font.PLAIN, 20));
		listComboDisp.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPaneCombosDisp.setViewportView(listComboDisp);
		
		JLabel lblCombosElejidos = new JLabel("Seleccionados:");
		lblCombosElejidos.setForeground(Color.BLACK);
		lblCombosElejidos.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblCombosElejidos.setBounds(12, 280, 140, 55);
		panelCombos.add(lblCombosElejidos);
		
		JScrollPane scrollPaneCombosSel = new JScrollPane();
		scrollPaneCombosSel.setBounds(12, 333, 441, 215);
		panelCombos.add(scrollPaneCombosSel);
		
		listComboSel = new JList<String>();
		listComboSel.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				int index = -1;
				index = listComboSel.getSelectedIndex();
				if (index != -1) {
					lblArribaCombo.setBackground(new Color(0, 155, 124));
					lblArribaCombo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				}
			}
		});
		listModelComboSel = new DefaultListModel<String>();
		listComboSel.setModel(listModelComboSel);
		listComboSel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		listComboSel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPaneCombosSel.setViewportView(listComboSel);
		
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
				if(btnAddProducto.isSelected()) {
					if (!listModelProductosSel.isEmpty()) {
						if(auxCliente == null) {
							auxCliente = new Cliente(txtCedula.getText(), txtNombre.getText(), txtDireccion.getText(), txtTelefono.getText());
							Tienda.getInstance().addCliente(auxCliente);
						}
						auxVendedor = (Vendedor) Tienda.getInstance().getLoginUserEmpleado();
						factura = new Factura(new String("F-0" + Factura.cod), auxVendedor, auxCliente, productosSeleccionados);
						if(rdbtnFacturaACredito.isSelected()) {
							factura.setACredito(true); 
						}
						for (Producto producto : productosSeleccionados) {
							producto.setCantidad(producto.getCantidad() - 1);							
						}
						auxVendedor.setTotalVendido(factura.getPrecioTotal());
						auxVendedor.setComision((float) (factura.getPrecioTotal()*0.05)); 
						Tienda.getInstance().addFactura(factura);
						JOptionPane.showMessageDialog(null, "¡La factura ha sido registrada satisfactoriamente!", "Información", JOptionPane.INFORMATION_MESSAGE);
						cleanCliente();
						productosSeleccionados.clear();
						Home.loadTableFactura(0, null);
					}else {
						JOptionPane.showMessageDialog(null, "Debe seleccionar al menos un (1) producto.", "Información", JOptionPane.WARNING_MESSAGE);
					}
				}else {
					if (!listModelComboSel.isEmpty()) {
						if(auxCliente == null) {
							Cliente auxCliente = new Cliente(txtCedula.getText(), txtNombre.getText(), txtDireccion.getText(), txtTelefono.getText());
							Tienda.getInstance().addCliente(auxCliente);
						}
						ArrayList<Producto> auxListCompra = new ArrayList<Producto>();
						for (Combo combo : combosSeleccionados) {
							for (Producto producto : combo.getMisProductos()) {
								auxListCompra.add(producto);
							}
						}
						factura = new Factura(new String("F-0"+Factura.cod), auxVendedor, auxCliente, auxListCompra);
						if(rdbtnFacturaACredito.isSelected()) {
							factura.setACredito(true); 
						}
						for (Producto producto : auxListCompra) {
							producto.setCantidad(producto.getCantidad() - 1);							
						}
						auxVendedor.setTotalVendido(factura.getPrecioTotal());
						auxVendedor.setComision((float) (factura.getPrecioTotal()*0.05)); //(Para un 5% comisión)
						Tienda.getInstance().addFactura(factura);
						JOptionPane.showMessageDialog(null, "¡La factura ha sido registrada satisfactoriamente!", "Información", JOptionPane.INFORMATION_MESSAGE);		
						cleanCliente();
						combosSeleccionados.clear();
						Home.loadTableFactura(0, null);
					}else {
						JOptionPane.showMessageDialog(null, "Debe seleccionar al menos un (1) producto.", "Información", JOptionPane.WARNING_MESSAGE);
					}
				}
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
		
		JLabel lblTelefono = new JLabel("Telefono:");
		lblTelefono.setForeground(Color.BLACK);
		lblTelefono.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTelefono.setBounds(33, 306, 162, 55);
		panelDatosClientes.add(lblTelefono);
		
		JLabel lblPrecio = new JLabel("Direcci\u00F3n:");
		lblPrecio.setForeground(Color.BLACK);
		lblPrecio.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPrecio.setBounds(33, 243, 125, 55);
		panelDatosClientes.add(lblPrecio);
		
		JLabel lblblCrearFactura = new JLabel("Crear Factura:");
		lblblCrearFactura.setFont(new Font("Tahoma", Font.PLAIN, 35));
		lblblCrearFactura.setBounds(33, 13, 322, 55);
		panelDatosClientes.add(lblblCrearFactura);
		
		JLabel lblCedula = new JLabel("C\u00E9dula:");
		lblCedula.setForeground(Color.BLACK);
		lblCedula.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblCedula.setBounds(33, 117, 196, 55);
		panelDatosClientes.add(lblCedula);
		
		txtCedula = new JTextField();
		txtCedula.setForeground(new Color(0, 153, 153));
		txtCedula.setFont(new Font("Tahoma", Font.PLAIN, 22));
		txtCedula.setColumns(10);
		txtCedula.setBackground(Color.WHITE);
		txtCedula.setBounds(143, 127, 311, 45);
		panelDatosClientes.add(txtCedula);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setForeground(Color.BLACK);
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNombre.setBounds(33, 180, 125, 55);
		panelDatosClientes.add(lblNombre);
		
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
				if (clienteBuscado != null) {
					cargarCliente(clienteBuscado);
					auxCliente = clienteBuscado;					
				}else {
					txtNombre.setEnabled(true);
					txtDireccion.setEnabled(true);
					txtTelefono.setEnabled(true);				
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
		
		JLabel lblClienteDatos = new JLabel("Datos del Cliente:");
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
		txtPrecioTotal.setEnabled(false);
		txtPrecioTotal.setForeground(new Color(0, 153, 153));
		txtPrecioTotal.setFont(new Font("Tahoma", Font.PLAIN, 22));
		txtPrecioTotal.setColumns(10);
		txtPrecioTotal.setBackground(Color.WHITE);
		txtPrecioTotal.setBounds(169, 115, 292, 45);
		panelDatosFactura.add(txtPrecioTotal);
		
		JLabel lblCodigo = new JLabel("C\u00F3digo:");
		lblCodigo.setForeground(Color.BLACK);
		lblCodigo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblCodigo.setBounds(32, 47, 196, 55);
		panelDatosFactura.add(lblCodigo);
		
		txtCodigo = new JTextField();
		txtCodigo.setEnabled(false);
		txtCodigo.setText("F-0"+Factura.cod);
		txtCodigo.setForeground(new Color(0, 153, 153));
		txtCodigo.setFont(new Font("Tahoma", Font.PLAIN, 22));
		txtCodigo.setColumns(10);
		txtCodigo.setBackground(Color.WHITE);
		txtCodigo.setBounds(169, 57, 427, 45);
		panelDatosFactura.add(txtCodigo);
		
		JLabel lblPrecioTotal = new JLabel("Precio Total:");
		lblPrecioTotal.setForeground(Color.BLACK);
		lblPrecioTotal.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPrecioTotal.setBounds(32, 110, 125, 55);
		panelDatosFactura.add(lblPrecioTotal);
		
		rdbtnFacturaACredito = new JRadioButton("Factura a Credito");
		rdbtnFacturaACredito.setForeground(Color.BLACK);
		rdbtnFacturaACredito.setFont(new Font("Tahoma", Font.PLAIN, 20));
		rdbtnFacturaACredito.setBounds(211, 190, 199, 25);
		panelDatosFactura.add(rdbtnFacturaACredito);
		
		JLabel lblDatosFactura = new JLabel("Datos de la Factura:");
		lblDatosFactura.setForeground(Color.BLACK);
		lblDatosFactura.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblDatosFactura.setBounds(32, 0, 196, 55);
		panelDatosFactura.add(lblDatosFactura);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setOpaque(true);
		lblNewLabel.setBounds(12, 173, 584, 55);
		panelDatosFactura.add(lblNewLabel);
		
		JLabel lblCalcular = new JLabel("Calcular");
		lblCalcular.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(btnAddProducto.isSelected()) {
					if (!productosSeleccionados.isEmpty()) {
						float total = 0;
						for (Producto producto : productosSeleccionados) {
							total += producto.getPrecio();
						}
						total = (float) (Math.round(total * 100.0) / 100.0);
						txtPrecioTotal.setText("RD$ "+new String(new Float(total).toString()));
					}else {
						JOptionPane.showMessageDialog(null, "Debe seleccionar al menos un (1) producto.", "Información", JOptionPane.WARNING_MESSAGE);
					}
				}else {
					if (!combosSeleccionados.isEmpty()) {
						float total = 0;
						for (Combo combo : combosSeleccionados) {
							total += combo.getPrecioTotal();
						}
						total = (float) (Math.round(total * 100.0) / 100.0);
						txtPrecioTotal.setText("RD$ "+new String(new Float(total).toString()));
					}else {
						JOptionPane.showMessageDialog(null, "Debe seleccionar al menos un (1) combo.", "Información", JOptionPane.WARNING_MESSAGE);
					}					
				}
			}
		});
		lblCalcular.setOpaque(true);
		lblCalcular.setHorizontalAlignment(SwingConstants.CENTER);
		lblCalcular.setForeground(Color.BLACK);
		lblCalcular.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblCalcular.setBackground(new Color(0, 155, 124));
		lblCalcular.setBounds(471, 115, 125, 45);
		panelDatosFactura.add(lblCalcular);
		
		panelProductos = new JPanel();
		panelProductos.setLayout(null);
		panelProductos.setBackground(Color.WHITE);
		panelProductos.setBounds(630, 67, 465, 561);
		panel.add(panelProductos);
		
		lblArribaProductos = new JLabel("\u2191\u2191");
		lblArribaProductos.setOpaque(true);
		lblArribaProductos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String aux = listProductosSel.getSelectedValue().toString();
				listModelProductosDisp.addElement(aux);
				listModelProductosSel.remove(listProductosSel.getSelectedIndex());
				productosSeleccionados.remove(Tienda.getInstance().buscarProductoByNumSerie(aux.substring(0, aux.indexOf('|')-1)));
				lblArribaProductos.setBackground(new Color(0, 85, 70));
				lblArribaProductos.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
			}
		});
		lblArribaProductos.setHorizontalAlignment(SwingConstants.CENTER);
		lblArribaProductos.setForeground(Color.WHITE);
		lblArribaProductos.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblArribaProductos.setBackground(new Color(0, 85, 70));
		//lblArribaProductos.setBackground(new Color(0, 155, 124));
		lblArribaProductos.setBounds(157, 275, 74, 45);
		panelProductos.add(lblArribaProductos);
		
		lblAbajoProductos = new JLabel("\u2193\u2193");
		lblAbajoProductos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(!txtCedula.getText().isEmpty()) {
					String aux = listProductosDisp.getSelectedValue().toString();
					listModelProductosSel.addElement(aux);
					listModelProductosDisp.remove(listProductosDisp.getSelectedIndex());
					productosSeleccionados.add(Tienda.getInstance().buscarProductoByNumSerie(aux.substring(0, aux.indexOf('|')-1)));
					lblAbajoProductos.setBackground(new Color(0, 85, 70));
					lblAbajoProductos.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
				}else {
					JOptionPane.showMessageDialog(null, "Debe especificar una cédula para seleccionar un Producto.", "Información", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		lblAbajoProductos.setOpaque(true);
		lblAbajoProductos.setHorizontalAlignment(SwingConstants.CENTER);
		lblAbajoProductos.setForeground(Color.WHITE);
		lblAbajoProductos.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblAbajoProductos.setBackground(new Color(0, 85, 70));
		//lblAbajoProductos.setBackground(new Color(0, 155, 124));
		lblAbajoProductos.setBounds(243, 275, 74, 45);
		panelProductos.add(lblAbajoProductos);
		
		JLabel lblProductosDisp = new JLabel("Productos disponibles:");
		lblProductosDisp.setForeground(Color.BLACK);
		lblProductosDisp.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblProductosDisp.setBounds(12, 0, 300, 55);
		panelProductos.add(lblProductosDisp);
		
		JScrollPane scrollPaneProductosDisp = new JScrollPane();
		scrollPaneProductosDisp.setBounds(12, 51, 441, 215);
		panelProductos.add(scrollPaneProductosDisp);
		
		listProductosDisp = new JList<String>();
		listProductosDisp.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				int index = -1;
				index = listProductosDisp.getSelectedIndex();
				if (index != -1) {
					lblAbajoProductos.setBackground(new Color(0, 155, 124));
					lblAbajoProductos.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				}
			}
		});
		listModelProductosDisp = new DefaultListModel<String>();
		listProductosDisp.setModel(listModelProductosDisp);
		listProductosDisp.setFont(new Font("Tahoma", Font.PLAIN, 20));
		listProductosDisp.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPaneProductosDisp.setViewportView(listProductosDisp);
		
		JLabel lblElejidos = new JLabel("Seleccionados:");
		lblElejidos.setForeground(Color.BLACK);
		lblElejidos.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblElejidos.setBounds(12, 280, 140, 55);
		panelProductos.add(lblElejidos);
		
		JScrollPane scrollPaneProductosSel = new JScrollPane();
		scrollPaneProductosSel.setBounds(12, 333, 441, 215);
		panelProductos.add(scrollPaneProductosSel);
		
		listProductosSel = new JList<String>();
		listProductosSel.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				int index = -1;
				index = listProductosSel.getSelectedIndex();
				if (index != -1) {
					lblArribaProductos.setBackground(new Color(0, 155, 124));
					lblArribaProductos.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				}
			}
		});
		listModelProductosSel = new DefaultListModel<String>();
		listProductosSel.setModel(listModelProductosSel);
		listProductosSel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		listProductosSel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPaneProductosSel.setViewportView(listProductosSel);
		
		/*------------------TEST TEST TEST--------------------------------//
		
		ArrayList<Producto> productos1 = new ArrayList<Producto>();
		
		DiscoDuro disco1 = new DiscoDuro("0001", 25, 550, "Sony", 5, 50, "QUESEYO", 500, "Sate");
		MicroProcesador micro1 = new MicroProcesador("0002", 30, 2000, "MSI", 5, 25, "Guachupita", "GOODquestion", 200);
		
		productos1.add(disco1);
		productos1.add(micro1);
		Tienda.getInstance().addProducto(disco1);
		Tienda.getInstance().addProducto(micro1);
		
		Combo combo = new Combo("0001", "RTX", productos1, 10);
		Tienda.getInstance().addCombo(combo);
		
		Cliente cliente1 = new Cliente("047", "Gabriel", "La vega", "8295151017");
		Tienda.getInstance().addCliente(cliente1);

		
		//------------------TEST TEST TEST--------------------------------*/
		
		loadProductosDisponibles();
		loadCombosDisponibles();
	}
	
	private void loadCombosDisponibles() {
		listModelComboDisp.removeAllElements();
		listModelComboSel.removeAllElements();
		
		for (Combo combo : Tienda.getInstance().getMisCombos()) {
			String aux = new String(combo.getCodigo()+" | "+combo.getNombre());
			
			//if(combo.getIsDisponible()) {
				listModelComboDisp.addElement(aux);
			//}			
		}
	}
	
	private void loadProductosDisponibles() {
		listModelProductosDisp.removeAllElements();
		listModelProductosSel.removeAllElements();
		
		for (Producto producto : Tienda.getInstance().getMisProductos()) {
			String aux = new String(producto.getNumSerie()+" | "+producto.getMarca());
			
			if(producto.getCantidad() > 0) {
				listModelProductosDisp.addElement(aux);
			}			
		}
	}
	
	private void cargarCliente(Cliente clienteBuscado) {
		txtNombre.setText(clienteBuscado.getNombre());
		txtDireccion.setText(clienteBuscado.getDireccion());
		txtTelefono.setText(clienteBuscado.getTelefono());
	}
	
	private void cleanCliente() {
		txtCedula.setText("");
		txtNombre.setText("");
		txtDireccion.setText("");
		txtTelefono.setText("");
		txtCodigo.setText("F-0"+Factura.cod);
		txtPrecioTotal.setText("");
	}
}