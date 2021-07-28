package Visual;

import java.awt.BorderLayout;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import logico.Combo;
import logico.DiscoDuro;
import logico.MemoriaRam;
import logico.MicroProcesador;
import logico.MotherBoard;
import logico.Producto;
import logico.Tienda;

import java.awt.Rectangle;
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
import javax.swing.JSeparator;
import javax.swing.SpinnerNumberModel;
import javax.swing.ListSelectionModel;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

public class RegCombo extends JDialog {

	private JPanel contentPane;
	private JTextField txtNombre;
	private JPanel panelRegistro;
	private JTextField txtCodigo;
	private JPanel panelDiscoDuro;
	private JSpinner spnDescuento;
	private JLabel lblRegistrar;
	private JTable tableDisp;
	private static DefaultTableModel modelDisp;
	private static Object[] rows;
	private JTable tableElegidos;
	private static DefaultTableModel modelElegidos;
	float precio = 0;
	float precioNeto = 0;
	private JSpinner spnPrecioNeto;
	private JSpinner spnPrecio;
	private JLabel btnDerecha;
	private JLabel btnIzquierda;
	private DefaultListModel<String> listModelDisp;
	private DefaultListModel<String> listModelActivo;
	ArrayList<Producto> productosSelected = new ArrayList<Producto>();
	Combo selectedCombo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegCombo dialog = new RegCombo(null);
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
	public RegCombo(Combo combo) {
		selectedCombo = combo;
		setUndecorated(true);
		setBounds(100, 100, 647, 741);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		/*Productos de prueba
		Producto p1 = new MotherBoard("402", 3, 25000, "RTX", 1, 20, "QSY", "QSY", "QSY");
		Producto p2 = new MemoriaRam("403", 100, 10000, "TridentZ", 1, 500, 32, "DDR4");
		Producto p3 = new MicroProcesador("404", 2, 5500, "MSI", 10, 60, "QSY", "buena", 100);
		Producto p4 = new DiscoDuro("405", 20, 4500, "Esto", 5, 90, "Funciona", 500, "Maravilla");
		Tienda.getInstance().addProducto(p1);
		Tienda.getInstance().addProducto(p2);
		Tienda.getInstance().addProducto(p3);
		Tienda.getInstance().addProducto(p4);*/
		
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
		
		String header[] = {"# Serie", "Categoria","Marca"};
		modelDisp = new DefaultTableModel();
		modelDisp.setColumnIdentifiers(header);
		
		tableDisp = new JTable();
		tableDisp.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tableDisp.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int index = -1;
				index = tableDisp.getSelectedRow();
				String numSerie = (String)(modelDisp.getValueAt(index, 0));
				if (index != -1 && Tienda.getInstance().buscarProductoByNumSerie(numSerie).getCantidad() > 0) {
					btnDerecha.setEnabled(true);
				}else if (Tienda.getInstance().buscarProductoByNumSerie(numSerie).getCantidad() <= 0) {
					JOptionPane.showMessageDialog(null, "No hay cantidad disponible para el producto seleccionado.", "Selección de productos", JOptionPane.OK_OPTION);
				}
			}
		});
		tableDisp.setModel(modelDisp);
		scrollPane.setViewportView(tableDisp);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(376, 56, 228, 227);
		panelDiscoDuro.add(scrollPane_1);
		
		modelElegidos = new DefaultTableModel();
		modelElegidos.setColumnIdentifiers(header);
		tableElegidos = new JTable();
		tableElegidos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int index = -1;
				index = tableElegidos.getSelectedRow();
				if (index != -1) {
					btnIzquierda.setEnabled(true);
				}
			}
		});
		tableElegidos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tableElegidos.setModel(modelElegidos);
		scrollPane_1.setViewportView(tableElegidos);
		
		btnDerecha = new JLabel(">>");
		btnDerecha.setEnabled(false);
		btnDerecha.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int index = -1;
				index = tableDisp.getSelectedRow();
				if (index != -1) {
					String numSerie = (String)(modelDisp.getValueAt(index, 0));
					Producto productoAux = Tienda.getInstance().buscarProductoByNumSerie(numSerie);
					productosSelected.add(productoAux);
					productoAux.setCantidad(productoAux.getCantidad() - 1);
					loadProductosElegidos();
					loadProductosDisp();
					btnDerecha.setEnabled(false);
					actualizarPrecio();
				}
			}
		});
		btnDerecha.setOpaque(true);
		btnDerecha.setHorizontalAlignment(SwingConstants.CENTER);
		btnDerecha.setForeground(Color.WHITE);
		btnDerecha.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnDerecha.setBackground(new Color(0, 155, 124));
		btnDerecha.setBounds(265, 116, 99, 45);
		panelDiscoDuro.add(btnDerecha);
		
		btnIzquierda = new JLabel("<<");
		btnIzquierda.setEnabled(false);
		btnIzquierda.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int index = -1;
				index = tableElegidos.getSelectedRow();
				if (index != -1) {
					String numSerie = (String)(modelElegidos.getValueAt(index, 0));
					Producto productoAux = Tienda.getInstance().buscarProductoByNumSerie(numSerie);
					productosSelected.remove(productoAux);
					productoAux.setCantidad(productoAux.getCantidad() + 1);
					loadProductosElegidos();
					loadProductosDisp();
					btnIzquierda.setEnabled(false);
					actualizarPrecio();
				}
			}
		});
		btnIzquierda.setOpaque(true);
		btnIzquierda.setHorizontalAlignment(SwingConstants.CENTER);
		btnIzquierda.setForeground(Color.WHITE);
		btnIzquierda.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnIzquierda.setBackground(new Color(0, 155, 124));
		btnIzquierda.setBounds(265, 174, 99, 45);
		panelDiscoDuro.add(btnIzquierda);
		
		JLabel lblDisponibles = new JLabel("Disponibles:");
		lblDisponibles.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblDisponibles.setBounds(12, 1, 205, 55);
		panelDiscoDuro.add(lblDisponibles);
		
		JLabel lblElegidos = new JLabel("Elegidos:");
		lblElegidos.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblElegidos.setBounds(376, 1, 205, 55);
		panelDiscoDuro.add(lblElegidos);
		
		JLabel lblPrecio_1 = new JLabel("Precio:");
		lblPrecio_1.setForeground(Color.BLACK);
		lblPrecio_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPrecio_1.setBounds(12, 300, 125, 55);
		panelDiscoDuro.add(lblPrecio_1);
		
		JLabel lblPrecioNeto = new JLabel("Precio neto:");
		lblPrecioNeto.setForeground(Color.BLACK);
		lblPrecioNeto.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPrecioNeto.setBounds(297, 300, 125, 55);
		panelDiscoDuro.add(lblPrecioNeto);
		
		JSeparator separator = new JSeparator();
		separator.setBackground(new Color(0, 155, 124));
		separator.setBounds(12, 296, 589, 2);
		panelDiscoDuro.add(separator);
		
		spnPrecio = new JSpinner();
		spnPrecio.setModel(new SpinnerNumberModel(new Float(0), null, null, new Float(1)));
		spnPrecio.setFont(new Font("Tahoma", Font.PLAIN, 17));
		spnPrecio.setEnabled(false);
		spnPrecio.setBounds(88, 308, 186, 45);
		panelDiscoDuro.add(spnPrecio);
		
		spnPrecioNeto = new JSpinner();
		spnPrecioNeto.setFont(new Font("Tahoma", Font.PLAIN, 17));
		spnPrecioNeto.setEnabled(false);
		spnPrecioNeto.setBounds(415, 310, 186, 45);
		panelDiscoDuro.add(spnPrecioNeto);
		
		panelRegistro = new JPanel();
		panelRegistro.setLayout(null);
		panelRegistro.setBackground(Color.WHITE);
		panelRegistro.setBounds(11, 12, 613, 282);
		panel.add(panelRegistro);
		
		txtNombre = new JTextField();
		txtNombre.setForeground(new Color(0, 153, 153));
		txtNombre.setFont(new Font("Tahoma", Font.PLAIN, 22));
		txtNombre.setColumns(10);
		txtNombre.setBackground(Color.WHITE);
		txtNombre.setBounds(148, 147, 440, 45);
		panelRegistro.add(txtNombre);
		
		JLabel lblPrecio = new JLabel("Descuento:");
		lblPrecio.setForeground(Color.BLACK);
		lblPrecio.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPrecio.setBounds(33, 205, 125, 55);
		panelRegistro.add(lblPrecio);
		
		String aux = "";
		if (selectedCombo == null) {
			aux = "Registrar Combo:";
		}else {
			aux = "Modificar Combo:";
		}
		JLabel lblRegistrarProducto = new JLabel(aux);
		lblRegistrarProducto.setFont(new Font("Tahoma", Font.PLAIN, 35));
		lblRegistrarProducto.setBounds(33, 13, 322, 55);
		panelRegistro.add(lblRegistrarProducto);
		
		JLabel lblNumSerie = new JLabel("C\u00F3digo:");
		lblNumSerie.setForeground(Color.BLACK);
		lblNumSerie.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNumSerie.setBounds(33, 79, 196, 55);
		panelRegistro.add(lblNumSerie);
		
		txtCodigo = new JTextField();
		txtCodigo.setEditable(false);
		txtCodigo.setForeground(new Color(0, 153, 153));
		txtCodigo.setFont(new Font("Tahoma", Font.PLAIN, 22));
		txtCodigo.setColumns(10);
		txtCodigo.setBackground(Color.WHITE);
		txtCodigo.setBounds(148, 84, 440, 45);
		txtCodigo.setText(new String("Combo-"+Combo.cod));
		panelRegistro.add(txtCodigo);
		
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
		
		spnDescuento = new JSpinner();
		spnDescuento.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				actualizarPrecio();
			}
		});
		spnDescuento.setModel(new SpinnerNumberModel(new Float(0), new Float(0), new Float(100), new Float(1)));
		spnDescuento.setFont(new Font("Tahoma", Font.PLAIN, 20));
		spnDescuento.setBounds(148, 210, 398, 45);
		panelRegistro.add(spnDescuento);
		
		JLabel lblNewLabel = new JLabel("%");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel.setBounds(550, 213, 43, 38);
		panelRegistro.add(lblNewLabel);
		
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
		
		String boton = "";
		if (selectedCombo == null) {
			boton = "Registrar";
		}else {
			boton = "Modificar";
		}
		lblRegistrar = new JLabel(boton);
		lblRegistrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (selectedCombo == null) {
					if (!txtNombre.getText().isEmpty() && modelElegidos.getRowCount() > 0) {
						Tienda.getInstance().getMisCombos().clear();
						
						Combo comboAux = new Combo(txtCodigo.getText(), txtNombre.getText(), productosSelected, Float.parseFloat(spnDescuento.getValue().toString()));
						comboAux.setPrecioNeto(Float.parseFloat(spnPrecioNeto.getValue().toString()));
						comboAux.setPrecioTotal(Float.parseFloat(spnPrecio.getValue().toString()));
						Tienda.getInstance().addCombo(comboAux);
						
						JOptionPane.showMessageDialog(null, "Combo registrado satisfactoriamente !", "Registro de combo", JOptionPane.INFORMATION_MESSAGE);
						clean();
						ListarCombo.loadTableCombo();
					}else {
						JOptionPane.showMessageDialog(null, "Debes llenar todos los campos requeridos.", "Registro de combo", JOptionPane.WARNING_MESSAGE);
					}
				}else {
					selectedCombo.setNombre(txtNombre.getText());
					selectedCombo.setDescuento(Integer.parseInt(spnDescuento.getValue().toString()));
					selectedCombo.setMisProductos(productosSelected);
					selectedCombo.setPrecioNeto(Float.parseFloat(spnPrecioNeto.getValue().toString()));
					selectedCombo.setPrecioTotal(Float.parseFloat(spnPrecio.getValue().toString()));
					JOptionPane.showMessageDialog(null, "El combo ha sido modificado satisfactoriamente !", "Modificar Combo", JOptionPane.CLOSED_OPTION);
					ListarCombo.loadTableCombo();
					Home.loadHome();
				}
				
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
		
		loadProductosDisp();
		if (selectedCombo != null) {
			txtNombre.setText(selectedCombo.getNombre());
			txtCodigo.setText(selectedCombo.getCodigo());
			spnDescuento.setValue(selectedCombo.getDescuento());
			spnPrecio.setValue(selectedCombo.getPrecioTotal());
			spnPrecioNeto.setValue(selectedCombo.getPrecioNeto());
			loadProductosElegidos();
		}
	}
	
	private void loadProductosElegidos() {
		
		modelElegidos.setRowCount(0);
		rows = new Object[modelElegidos.getColumnCount()];
		
		if (selectedCombo == null) {
			for (Producto producto : productosSelected) {
				rows[0] = producto.getNumSerie();
				rows[1] = producto.getClass().getSimpleName();
				rows[2] = producto.getMarca();
				
				modelElegidos.addRow(rows);
			}
		}else {
			for (Producto producto : selectedCombo.getMisProductos()) {
				rows[0] = producto.getNumSerie();
				rows[1] = producto.getClass().getSimpleName();
				rows[2] = producto.getMarca();
				
				modelElegidos.addRow(rows);
			}
		}
		
	}

	private void loadProductosDisp() {
		
		modelDisp.setRowCount(0);
		rows = new Object[modelDisp.getColumnCount()];
		
		for (int i = modelDisp.getRowCount() - 1; i >= 0; i--) {
			modelDisp.removeRow(i);
		}
		
		for (Producto producto : Tienda.getInstance().getMisProductos()) {
			rows[0] = producto.getNumSerie();
			rows[1] = producto.getClass().getSimpleName();
			rows[2] = producto.getMarca();
			modelDisp.addRow(rows);
		}
	}

	private void actualizarPrecio() {
		
		if (productosSelected.size() > 0) {
			precio = Tienda.getInstance().calPrecioTotalProductos(productosSelected);
			spnPrecio.setValue(precio);

			float descuento = Float.parseFloat(spnDescuento.getValue().toString()) / 100;
			descuento = precio * descuento;
			
			spnPrecioNeto.setValue(precio - descuento);
		}else {
			spnPrecio.setValue(0);
			spnPrecioNeto.setValue(0);
		}
	}

	private void clean() {
		
		txtCodigo.setText("Combo-"+Combo.cod);
		txtNombre.setText("");
		productosSelected.removeAll(productosSelected);
		spnDescuento.setValue(0);
		spnPrecio.setValue(0.0);
		spnPrecioNeto.setValue(0.0);
		loadProductosDisp();
		loadProductosElegidos();
	}
}
