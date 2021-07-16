package Visual;

import java.awt.BorderLayout;

import javax.swing.JDialog;
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

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.Font;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.SwingConstants;

public class ListarDatosGenerales extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private static DefaultTableModel modelCombo;
	private static Object[] rows;
	private JLabel productos;
	private JLabel vendedores;
	private Combo selectedCombo = null;
	private JLabel clientes;
	private JPanel panelCombos;
	private JPanel panelFacturas;
	private JPanel panelVendedores;
	private JPanel panelProductos;
	private JPanel panelClientes;
	private JLabel combos;
	private JLabel facturas;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ListarDatosGenerales dialog = new ListarDatosGenerales();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ListarDatosGenerales() {
		setUndecorated(true);
		setBounds(100, 100, 1117, 703);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout(0, 0));
		contentPanel.setBackground(Color.white);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		contentPanel.setLayout(null);
		
		String header[] = {"Código", "Nombre", "Precio neto", "Descuento","Precio total", "Cant. De Productos"};
		modelCombo = new DefaultTableModel();
		modelCombo.setColumnIdentifiers(header);
		
		final JLabel label = new JLabel("X");
		label.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				dispose();
			}
		});
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setForeground(Color.DARK_GRAY);
		label.setFont(new Font("Tahoma", Font.PLAIN, 40));
		label.setBounds(1060, -2, 57, 55);
		contentPanel.add(label);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(12, 13, 322, 677);
		panel_1.setBackground(new Color(36, 37, 38));
		contentPanel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 23, 322, 83);
		panel_1.add(lblNewLabel);
		lblNewLabel.setIcon(new ImageIcon(ListarDatosGenerales.class.getResource("/Imagenes/EstadisitcasLabelBlanco.png")));
		
		clientes = new JLabel("Clientes");
		clientes.setOpaque(true);
		clientes.setHorizontalAlignment(SwingConstants.CENTER);
		clientes.setBounds(0, 160, 322, 44);
		panel_1.add(clientes);
		clientes.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				panelClientes.setVisible(true);
				panelProductos.setVisible(false);
				panelVendedores.setVisible(false);
				panelFacturas.setVisible(false);
				panelCombos.setVisible(false);
				
				clientes.setBackground(new Color(0, 155, 124));
				productos.setBackground(new Color(36, 37, 38));
				vendedores.setBackground(new Color(36, 37, 38));
				facturas.setBackground(new Color(36, 37, 38));
				combos.setBackground(new Color(36, 37, 38));
			}
		});
		clientes.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		clientes.setBackground(new Color(0, 155, 124));
		clientes.setFont(new Font("Tahoma", Font.PLAIN, 34));
		clientes.setForeground(Color.WHITE);
		clientes.setIcon(new ImageIcon(ListarDatosGenerales.class.getResource("/Imagenes/ClientesUSer.png")));
		
		productos = new JLabel("productos");
		productos.setOpaque(true);
		productos.setHorizontalAlignment(SwingConstants.CENTER);
		productos.setBounds(0, 217, 322, 44);
		panel_1.add(productos);
		productos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				panelClientes.setVisible(false);
				panelProductos.setVisible(true);
				panelVendedores.setVisible(false);
				panelFacturas.setVisible(false);
				panelCombos.setVisible(false);
				
				clientes.setBackground(new Color(36, 37, 38));
				productos.setBackground(new Color(0, 155, 124));
				vendedores.setBackground(new Color(36, 37, 38));
				facturas.setBackground(new Color(36, 37, 38));
				combos.setBackground(new Color(36, 37, 38));
			}
		});
		productos.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		productos.setIcon(new ImageIcon(ListarDatosGenerales.class.getResource("/Imagenes/ProductosIcon.png")));
		productos.setForeground(Color.WHITE);
		productos.setFont(new Font("Tahoma", Font.PLAIN, 34));
		productos.setBackground(new Color(36, 37, 38));
		
		vendedores = new JLabel("Vendedores");
		vendedores.setOpaque(true);
		vendedores.setHorizontalAlignment(SwingConstants.CENTER);
		vendedores.setBounds(0, 274, 322, 44);
		panel_1.add(vendedores);
		vendedores.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				panelClientes.setVisible(false);
				panelProductos.setVisible(false);
				panelVendedores.setVisible(true);
				panelFacturas.setVisible(false);
				panelCombos.setVisible(false);
				
				clientes.setBackground(new Color(36, 37, 38));
				productos.setBackground(new Color(36, 37, 38));
				vendedores.setBackground(new Color(0, 155, 124));
				facturas.setBackground(new Color(36, 37, 38));
				combos.setBackground(new Color(36, 37, 38));
			}
		});
		vendedores.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		vendedores.setIcon(new ImageIcon(ListarDatosGenerales.class.getResource("/Imagenes/VendedoresIcon.png")));
		vendedores.setForeground(Color.WHITE);
		vendedores.setFont(new Font("Tahoma", Font.PLAIN, 34));
		vendedores.setBackground(new Color(36, 37, 38));
		
		JLabel lblCancelar = new JLabel(" Cancelar");
		lblCancelar.setHorizontalAlignment(SwingConstants.CENTER);
		lblCancelar.setBounds(0, 620, 322, 57);
		panel_1.add(lblCancelar);
		lblCancelar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				dispose();
			}
		});
		lblCancelar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblCancelar.setIcon(new ImageIcon(ListarCliente.class.getResource("/Imagenes/CancelarIcon.png")));
		lblCancelar.setOpaque(true);
		lblCancelar.setForeground(Color.WHITE);
		lblCancelar.setFont(new Font("Tahoma", Font.PLAIN, 34));
		lblCancelar.setBackground(new Color(0, 155, 124));
		
		JLabel lblAdministracin = new JLabel("Administraci\u00F3n");
		lblAdministracin.setForeground(Color.WHITE);
		lblAdministracin.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblAdministracin.setBounds(88, 80, 144, 64);
		panel_1.add(lblAdministracin);
		
		facturas = new JLabel("Facturas");
		facturas.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		facturas.setOpaque(true);
		facturas.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				panelClientes.setVisible(false);
				panelProductos.setVisible(false);
				panelVendedores.setVisible(false);
				panelFacturas.setVisible(true);
				panelCombos.setVisible(false);
				
				clientes.setBackground(new Color(36, 37, 38));
				productos.setBackground(new Color(36, 37, 38));
				vendedores.setBackground(new Color(36, 37, 38));
				facturas.setBackground(new Color(0, 155, 124));
				combos.setBackground(new Color(36, 35, 38));
			}
		});
		facturas.setIcon(new ImageIcon(ListarDatosGenerales.class.getResource("/Imagenes/FacturaIcon.png")));
		facturas.setHorizontalAlignment(SwingConstants.CENTER);
		facturas.setForeground(Color.WHITE);
		facturas.setFont(new Font("Tahoma", Font.PLAIN, 34));
		facturas.setBackground(new Color(36, 37, 38));
		facturas.setBounds(0, 331, 322, 44);
		panel_1.add(facturas);
		
		combos = new JLabel(" Combos");
		combos.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		combos.setOpaque(true);
		combos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				panelClientes.setVisible(false);
				panelProductos.setVisible(false);
				panelVendedores.setVisible(false);
				panelFacturas.setVisible(false);
				panelCombos.setVisible(true);
				
				clientes.setBackground(new Color(36, 37, 38));
				productos.setBackground(new Color(36, 37, 38));
				vendedores.setBackground(new Color(36, 37, 38));
				facturas.setBackground(new Color(36, 35, 38));
				combos.setBackground(new Color(0, 155, 124));
			}
		});
		combos.setIcon(new ImageIcon(ListarDatosGenerales.class.getResource("/Imagenes/PedidoIcon.png")));
		combos.setHorizontalAlignment(SwingConstants.CENTER);
		combos.setForeground(Color.WHITE);
		combos.setFont(new Font("Tahoma", Font.PLAIN, 34));
		combos.setBackground(new Color(36, 37, 38));
		combos.setBounds(0, 388, 322, 44);
		panel_1.add(combos);
		
		panelCombos = new JPanel();
		panelCombos.setVisible(false);
		panelCombos.setLayout(null);
		panelCombos.setBounds(345, 43, 759, 647);
		contentPanel.add(panelCombos);
		
		JLabel lblComboMsComprado = new JLabel("Combo m\u00E1s comprado:");
		lblComboMsComprado.setFont(new Font("Tahoma", Font.PLAIN, 35));
		lblComboMsComprado.setBounds(12, 13, 458, 69);
		panelCombos.add(lblComboMsComprado);
		
		JLabel label_15 = new JLabel("Fulanito");
		label_15.setFont(new Font("Tahoma", Font.PLAIN, 24));
		label_15.setBounds(13, 65, 565, 57);
		panelCombos.add(label_15);
		
		JPanel panel_16 = new JPanel();
		panel_16.setBackground(new Color(0, 155, 124));
		panel_16.setBounds(13, 137, 445, 4);
		panelCombos.add(panel_16);
		
		JLabel lblComboMenosComprado = new JLabel("Combo menos Comprado:");
		lblComboMenosComprado.setFont(new Font("Tahoma", Font.PLAIN, 35));
		lblComboMenosComprado.setBounds(7, 157, 637, 69);
		panelCombos.add(lblComboMenosComprado);
		
		JLabel label_17 = new JLabel("Fulanito");
		label_17.setFont(new Font("Tahoma", Font.PLAIN, 24));
		label_17.setBounds(8, 209, 565, 57);
		panelCombos.add(label_17);
		
		JPanel panel_17 = new JPanel();
		panel_17.setBackground(new Color(0, 155, 124));
		panel_17.setBounds(8, 281, 445, 4);
		panelCombos.add(panel_17);
		
		panelFacturas = new JPanel();
		panelFacturas.setVisible(false);
		panelFacturas.setLayout(null);
		panelFacturas.setBounds(346, 43, 759, 647);
		contentPanel.add(panelFacturas);
		
		JLabel lblFacturaMsCara = new JLabel("Factura m\u00E1s cara:");
		lblFacturaMsCara.setFont(new Font("Tahoma", Font.PLAIN, 35));
		lblFacturaMsCara.setBounds(12, 13, 458, 69);
		panelFacturas.add(lblFacturaMsCara);
		
		JLabel label_10 = new JLabel("Fulanito");
		label_10.setFont(new Font("Tahoma", Font.PLAIN, 24));
		label_10.setBounds(13, 65, 565, 57);
		panelFacturas.add(label_10);
		
		JPanel panel_11 = new JPanel();
		panel_11.setBackground(new Color(0, 155, 124));
		panel_11.setBounds(13, 137, 445, 4);
		panelFacturas.add(panel_11);
		
		JLabel lblFacturaMenosCara = new JLabel("Factura menos cara:");
		lblFacturaMenosCara.setFont(new Font("Tahoma", Font.PLAIN, 35));
		lblFacturaMenosCara.setBounds(7, 157, 637, 69);
		panelFacturas.add(lblFacturaMenosCara);
		
		JLabel label_12 = new JLabel("Fulanito");
		label_12.setFont(new Font("Tahoma", Font.PLAIN, 24));
		label_12.setBounds(8, 209, 565, 57);
		panelFacturas.add(label_12);
		
		JPanel panel_12 = new JPanel();
		panel_12.setBackground(new Color(0, 155, 124));
		panel_12.setBounds(8, 281, 445, 4);
		panelFacturas.add(panel_12);
		
		JLabel lblCantidadDeFacturas = new JLabel("Facturas sin pagar:");
		lblCantidadDeFacturas.setFont(new Font("Tahoma", Font.PLAIN, 35));
		lblCantidadDeFacturas.setBounds(7, 298, 307, 69);
		panelFacturas.add(lblCantidadDeFacturas);
		
		JLabel label_14 = new JLabel("Fulanito");
		label_14.setFont(new Font("Tahoma", Font.PLAIN, 24));
		label_14.setBounds(8, 350, 307, 57);
		panelFacturas.add(label_14);
		
		JPanel panel_13 = new JPanel();
		panel_13.setBackground(new Color(0, 155, 124));
		panel_13.setBounds(8, 422, 313, 4);
		panelFacturas.add(panel_13);
		
		JLabel lbl = new JLabel("Facturas pagadas:");
		lbl.setFont(new Font("Tahoma", Font.PLAIN, 35));
		lbl.setBounds(379, 298, 307, 69);
		panelFacturas.add(lbl);
		
		JLabel label_11 = new JLabel("Fulanito");
		label_11.setFont(new Font("Tahoma", Font.PLAIN, 24));
		label_11.setBounds(379, 350, 245, 57);
		panelFacturas.add(label_11);
		
		JPanel panel_10 = new JPanel();
		panel_10.setBackground(new Color(0, 155, 124));
		panel_10.setBounds(379, 422, 313, 4);
		panelFacturas.add(panel_10);
		
		JLabel lblTotalDeIngresos = new JLabel("Total de ingresos:");
		lblTotalDeIngresos.setFont(new Font("Tahoma", Font.PLAIN, 35));
		lblTotalDeIngresos.setBounds(12, 439, 637, 69);
		panelFacturas.add(lblTotalDeIngresos);
		
		JLabel label_13 = new JLabel("Fulanito");
		label_13.setFont(new Font("Tahoma", Font.PLAIN, 24));
		label_13.setBounds(13, 491, 565, 57);
		panelFacturas.add(label_13);
		
		JPanel panel_14 = new JPanel();
		panel_14.setBackground(new Color(0, 155, 124));
		panel_14.setBounds(13, 563, 445, 4);
		panelFacturas.add(panel_14);
		
		panelVendedores = new JPanel();
		panelVendedores.setVisible(false);
		panelVendedores.setLayout(null);
		panelVendedores.setBounds(346, 43, 759, 647);
		contentPanel.add(panelVendedores);
		
		JLabel lblVendedorDelMes = new JLabel("Vendedor del mes:");
		lblVendedorDelMes.setFont(new Font("Tahoma", Font.PLAIN, 35));
		lblVendedorDelMes.setBounds(12, 13, 458, 69);
		panelVendedores.add(lblVendedorDelMes);
		
		JLabel label_6 = new JLabel("Fulanito");
		label_6.setFont(new Font("Tahoma", Font.PLAIN, 24));
		label_6.setBounds(13, 65, 565, 57);
		panelVendedores.add(label_6);
		
		JPanel panel_8 = new JPanel();
		panel_8.setBackground(new Color(0, 155, 124));
		panel_8.setBounds(13, 137, 445, 4);
		panelVendedores.add(panel_8);
		
		JLabel lblVendedorConMs = new JLabel("Vendedor con m\u00E1s facturas realizadas:");
		lblVendedorConMs.setFont(new Font("Tahoma", Font.PLAIN, 35));
		lblVendedorConMs.setBounds(7, 157, 637, 69);
		panelVendedores.add(lblVendedorConMs);
		
		JLabel label_9 = new JLabel("Fulanito");
		label_9.setFont(new Font("Tahoma", Font.PLAIN, 24));
		label_9.setBounds(8, 209, 565, 57);
		panelVendedores.add(label_9);
		
		JPanel panel_9 = new JPanel();
		panel_9.setBackground(new Color(0, 155, 124));
		panel_9.setBounds(8, 281, 445, 4);
		panelVendedores.add(panel_9);
		
		JLabel lblVendedorConMenos = new JLabel("Vendedor con menos facturas realizadas:");
		lblVendedorConMenos.setFont(new Font("Tahoma", Font.PLAIN, 35));
		lblVendedorConMenos.setBounds(7, 298, 657, 69);
		panelVendedores.add(lblVendedorConMenos);
		
		JLabel label_8 = new JLabel("Fulanito");
		label_8.setFont(new Font("Tahoma", Font.PLAIN, 24));
		label_8.setBounds(8, 350, 565, 57);
		panelVendedores.add(label_8);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(new Color(0, 155, 124));
		panel_5.setBounds(8, 422, 445, 4);
		panelVendedores.add(panel_5);
		
		panelProductos = new JPanel();
		panelProductos.setVisible(false);
		panelProductos.setLayout(null);
		panelProductos.setBounds(346, 43, 759, 647);
		contentPanel.add(panelProductos);
		
		JLabel lblProductoMsComprado = new JLabel("Producto m\u00E1s comprado:");
		lblProductoMsComprado.setFont(new Font("Tahoma", Font.PLAIN, 35));
		lblProductoMsComprado.setBounds(12, 13, 458, 69);
		panelProductos.add(lblProductoMsComprado);
		
		JLabel label_5 = new JLabel("Fulanito");
		label_5.setFont(new Font("Tahoma", Font.PLAIN, 24));
		label_5.setBounds(13, 65, 565, 57);
		panelProductos.add(label_5);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBackground(new Color(0, 155, 124));
		panel_6.setBounds(13, 137, 445, 4);
		panelProductos.add(panel_6);
		
		JLabel lblProductoMenosComprado = new JLabel("Producto menos comprado:");
		lblProductoMenosComprado.setFont(new Font("Tahoma", Font.PLAIN, 35));
		lblProductoMenosComprado.setBounds(7, 157, 637, 69);
		panelProductos.add(lblProductoMenosComprado);
		
		JLabel label_7 = new JLabel("Fulanito");
		label_7.setFont(new Font("Tahoma", Font.PLAIN, 24));
		label_7.setBounds(8, 209, 565, 57);
		panelProductos.add(label_7);
		
		JPanel panel_7 = new JPanel();
		panel_7.setBackground(new Color(0, 155, 124));
		panel_7.setBounds(8, 281, 445, 4);
		panelProductos.add(panel_7);
		
		panelClientes = new JPanel();
		panelClientes.setBounds(346, 43, 759, 647);
		contentPanel.add(panelClientes);
		panelClientes.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Cliente del mes:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 35));
		lblNewLabel_2.setBounds(12, 13, 315, 69);
		panelClientes.add(lblNewLabel_2);
		
		JLabel lblFulanito = new JLabel("Fulanito");
		lblFulanito.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblFulanito.setBounds(13, 65, 565, 57);
		panelClientes.add(lblFulanito);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 155, 124));
		panel.setBounds(13, 137, 445, 4);
		panelClientes.add(panel);
		
		JLabel lblClienteConMs = new JLabel("Cliente con m\u00E1s Compras realizadas:");
		lblClienteConMs.setFont(new Font("Tahoma", Font.PLAIN, 35));
		lblClienteConMs.setBounds(7, 157, 637, 69);
		panelClientes.add(lblClienteConMs);
		
		JLabel label_2 = new JLabel("Fulanito");
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 24));
		label_2.setBounds(8, 209, 565, 57);
		panelClientes.add(label_2);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(0, 155, 124));
		panel_2.setBounds(8, 281, 445, 4);
		panelClientes.add(panel_2);
		
		JLabel lblClienteConMenos = new JLabel("Cliente con menos compras Realizadas:");
		lblClienteConMenos.setFont(new Font("Tahoma", Font.PLAIN, 35));
		lblClienteConMenos.setBounds(12, 298, 637, 69);
		panelClientes.add(lblClienteConMenos);
		
		JLabel label_3 = new JLabel("Fulanito");
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 24));
		label_3.setBounds(13, 350, 588, 57);
		panelClientes.add(label_3);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(0, 155, 124));
		panel_3.setBounds(13, 422, 445, 4);
		panelClientes.add(panel_3);
		
		JLabel lblClienteConMayor = new JLabel("Cliente con mayor deuda:");
		lblClienteConMayor.setFont(new Font("Tahoma", Font.PLAIN, 35));
		lblClienteConMayor.setBounds(12, 439, 637, 69);
		panelClientes.add(lblClienteConMayor);
		
		JLabel label_4 = new JLabel("Fulanito");
		label_4.setFont(new Font("Tahoma", Font.PLAIN, 24));
		label_4.setBounds(13, 491, 416, 57);
		panelClientes.add(label_4);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(0, 155, 124));
		panel_4.setBounds(13, 563, 445, 4);
		panelClientes.add(panel_4);
		loadTableCombo();
	}
	
	public static void loadTableCombo() {
		
		modelCombo.setRowCount(0);
		rows = new Object[modelCombo.getColumnCount()];
		
		for (Combo combo : Tienda.getInstance().getMisCombos()) {
			rows[0] = combo.getCodigo();
			rows[1] = combo.getNombre();
			rows[2] = combo.getPrecioNeto();
			rows[3] = combo.getDescuento() + "%";
			rows[4] = combo.getPrecioTotal();
			rows[5] = combo.getMisProductos().size();
			modelCombo.addRow(rows);
		}
	}
}
