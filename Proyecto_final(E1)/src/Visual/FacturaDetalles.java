package Visual;

import java.awt.BorderLayout;

import javax.swing.JDialog;
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
import logico.Producto;
import logico.Tienda;
import logico.Vendedor;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.Font;
import java.awt.Panel;
import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.UIManager;

public class FacturaDetalles extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private static DefaultTableModel model;
	private static Object[] rows;
	int indexCbx = 0;
	private Color colorVerde = new Color(0, 155, 124);
	private JTable table;
	private Factura selectedFactura;
	private JLabel lblAbonar;
	private JLabel lblMontoAbonar;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			FacturaDetalles dialog = new FacturaDetalles(null);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public FacturaDetalles(Factura factura) {
		selectedFactura = factura;
		setUndecorated(true);
		setBounds(100, 100, 780, 630);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout(0, 0));
		contentPanel.setBackground(Color.white);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		contentPanel.setLayout(null);
		
		String headerFactura[] = {"Num", "Marca", "Categoría", "cant", "Precio"};
		model = new DefaultTableModel();
		model.setColumnIdentifiers(headerFactura);
		
		JPanel panel = new JPanel();
		panel.setBackground(UIManager.getColor("Button.background"));
		panel.setBounds(12, 46, 756, 571);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		lblAbonar = new JLabel("Abonar");
		lblAbonar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				float monto = Float.parseFloat(JOptionPane.showInputDialog(null, "Ingrese el monto a Abonar", "Abonar linea de crédito", JOptionPane.DEFAULT_OPTION));
				boolean esPosible = Tienda.getInstance().abonarFacturaCredito(selectedFactura.getCodigo(), monto);
				if (esPosible) {
					lblMontoAbonar.setText(""+selectedFactura.getLineaCredito());
					JOptionPane.showMessageDialog(null, "Monto abonado Correctamente");
				}
				else {
					JOptionPane.showMessageDialog(null, "El monto no pudo ser abonado", "Abonar", JOptionPane.WARNING_MESSAGE);
				}
				
			}
		});
		lblAbonar.setHorizontalAlignment(SwingConstants.CENTER);
		lblAbonar.setForeground(Color.WHITE);
		lblAbonar.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblAbonar.setBounds(510, 507, 234, 51);
		panel.add(lblAbonar);
		
		JLabel label_15 = new JLabel("");
		label_15.setOpaque(true);
		label_15.setForeground(new Color(0, 155, 124));
		label_15.setFont(new Font("Tahoma", Font.BOLD, 40));
		label_15.setBackground(new Color(0, 155, 124));
		label_15.setBounds(510, 507, 234, 51);
		panel.add(label_15);
		
		JLabel lblMonto = new JLabel("" + selectedFactura.getMisProductos().size());
		lblMonto.setForeground(Color.BLACK);
		lblMonto.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblMonto.setBounds(525, 308, 219, 28);
		panel.add(lblMonto);
		
		JLabel lblPrecioTotal = new JLabel("Cantidad");
		lblPrecioTotal.setForeground(Color.WHITE);
		lblPrecioTotal.setFont(new Font("Tahoma", Font.BOLD, 21));
		lblPrecioTotal.setBounds(516, 270, 187, 28);
		panel.add(lblPrecioTotal);
		
		JLabel lblProductos = new JLabel("Productos");
		lblProductos.setForeground(Color.WHITE);
		lblProductos.setFont(new Font("Tahoma", Font.BOLD, 21));
		lblProductos.setBounds(22, 270, 187, 28);
		panel.add(lblProductos);
		
		JLabel lbldireccionCliente = new JLabel(selectedFactura.getMiCliente().getDireccion());
		lbldireccionCliente.setForeground(Color.BLACK);
		lbldireccionCliente.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lbldireccionCliente.setBounds(22, 195, 206, 28);
		panel.add(lbldireccionCliente);
		
		JLabel lbltelefonoCliente = new JLabel(selectedFactura.getMiCliente().getTelefono());
		lbltelefonoCliente.setForeground(Color.BLACK);
		lbltelefonoCliente.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lbltelefonoCliente.setBounds(22, 162, 206, 28);
		panel.add(lbltelefonoCliente);
		
		JLabel lblFacturarA = new JLabel("Facturar a");
		lblFacturarA.setForeground(Color.WHITE);
		lblFacturarA.setFont(new Font("Tahoma", Font.BOLD, 21));
		lblFacturarA.setBounds(23, 75, 187, 28);
		panel.add(lblFacturarA);
		
		JLabel lblFecha = new JLabel("Fecha");
		lblFecha.setForeground(Color.WHITE);
		lblFecha.setFont(new Font("Tahoma", Font.BOLD, 21));
		lblFecha.setBounds(567, 75, 187, 28);
		panel.add(lblFecha);
		
		JLabel lblFactura = new JLabel("Factura#");
		lblFactura.setForeground(Color.WHITE);
		lblFactura.setFont(new Font("Tahoma", Font.BOLD, 21));
		lblFactura.setBounds(304, 75, 187, 28);
		panel.add(lblFactura);
		
		JLabel lblNewLabel = new JLabel("FACTURA");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 40));
		lblNewLabel.setForeground(colorVerde);
		lblNewLabel.setBounds(556, 13, 198, 39);
		panel.add(lblNewLabel);
		
		JLabel label_1 = new JLabel("");
		label_1.setOpaque(true);
		label_1.setForeground(new Color(0, 155, 124));
		label_1.setBackground(colorVerde);
		label_1.setFont(new Font("Tahoma", Font.BOLD, 40));
		label_1.setBounds(289, 75, 455, 28);
		panel.add(label_1);
		
		JLabel lblDato = new JLabel(selectedFactura.getCodigo());
		lblDato.setForeground(Color.BLACK);
		lblDato.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblDato.setBounds(299, 121, 249, 28);
		panel.add(lblDato);
		
		JLabel lblFecha_1 = new JLabel(new SimpleDateFormat("dd-MM-yyyy").format(selectedFactura.getFecha()));
		lblFecha_1.setForeground(Color.BLACK);
		lblFecha_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblFecha_1.setBounds(557, 121, 187, 28);
		panel.add(lblFecha_1);
		
		JLabel lblCliente = new JLabel("Cliente Cedula");
		lblCliente.setForeground(Color.WHITE);
		lblCliente.setFont(new Font("Tahoma", Font.BOLD, 21));
		lblCliente.setBounds(304, 162, 187, 28);
		panel.add(lblCliente);
		
		JLabel lblTipoDeFactura = new JLabel("Tipo de Factura");
		lblTipoDeFactura.setForeground(Color.WHITE);
		lblTipoDeFactura.setFont(new Font("Tahoma", Font.BOLD, 21));
		lblTipoDeFactura.setBounds(544, 162, 187, 28);
		panel.add(lblTipoDeFactura);
		
		JLabel label_3 = new JLabel("");
		label_3.setOpaque(true);
		label_3.setForeground(new Color(0, 155, 124));
		label_3.setFont(new Font("Tahoma", Font.BOLD, 40));
		label_3.setBackground(new Color(0, 155, 124));
		label_3.setBounds(289, 162, 455, 28);
		panel.add(label_3);
		
		JLabel lblCreditoONo = new JLabel("" + selectedFactura.isACredito());
		lblCreditoONo.setForeground(Color.BLACK);
		lblCreditoONo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblCreditoONo.setBounds(557, 209, 187, 28);
		panel.add(lblCreditoONo);
		
		JLabel lblCedula = new JLabel(selectedFactura.getMiCliente().getCedula());
		lblCedula.setForeground(Color.BLACK);
		lblCedula.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblCedula.setBounds(304, 209, 239, 28);
		panel.add(lblCedula);
		
		JLabel label_4 = new JLabel("");
		label_4.setOpaque(true);
		label_4.setBackground(Color.WHITE);
		label_4.setForeground(Color.BLACK);
		label_4.setFont(new Font("Tahoma", Font.BOLD, 23));
		label_4.setBounds(289, 116, 455, 39);
		panel.add(label_4);
		
		JLabel label_5 = new JLabel("");
		label_5.setOpaque(true);
		label_5.setForeground(Color.BLACK);
		label_5.setFont(new Font("Tahoma", Font.BOLD, 23));
		label_5.setBackground(Color.WHITE);
		label_5.setBounds(289, 203, 455, 39);
		panel.add(label_5);
		
		JLabel label_8 = new JLabel("");
		label_8.setOpaque(true);
		label_8.setForeground(new Color(0, 155, 124));
		label_8.setFont(new Font("Tahoma", Font.BOLD, 40));
		label_8.setBackground(new Color(0, 155, 124));
		label_8.setBounds(12, 75, 234, 28);
		panel.add(label_8);
		
		JLabel lblnombreCliente = new JLabel(selectedFactura.getMiCliente().getNombre());
		lblnombreCliente.setForeground(Color.BLACK);
		lblnombreCliente.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblnombreCliente.setBounds(22, 121, 206, 28);
		panel.add(lblnombreCliente);
		
		JLabel label_13 = new JLabel("");
		label_13.setOpaque(true);
		label_13.setForeground(Color.BLACK);
		label_13.setFont(new Font("Tahoma", Font.BOLD, 23));
		label_13.setBackground(Color.WHITE);
		label_13.setBounds(12, 116, 234, 126);
		panel.add(label_13);
		
		JLabel label_2 = new JLabel("");
		label_2.setOpaque(true);
		label_2.setForeground(new Color(0, 155, 124));
		label_2.setFont(new Font("Tahoma", Font.BOLD, 40));
		label_2.setBackground(new Color(0, 155, 124));
		label_2.setBounds(12, 270, 479, 28);
		panel.add(label_2);
		
		JLabel label_7 = new JLabel("");
		label_7.setOpaque(true);
		label_7.setForeground(new Color(0, 155, 124));
		label_7.setFont(new Font("Tahoma", Font.BOLD, 40));
		label_7.setBackground(new Color(0, 155, 124));
		label_7.setBounds(510, 270, 234, 28);
		panel.add(label_7);
		
		JLabel label_9 = new JLabel("");
		label_9.setOpaque(true);
		label_9.setForeground(Color.BLACK);
		label_9.setFont(new Font("Tahoma", Font.BOLD, 23));
		label_9.setBackground(Color.WHITE);
		label_9.setBounds(510, 303, 234, 38);
		panel.add(label_9);
		
		JLabel label_10 = new JLabel("Precio total");
		label_10.setForeground(Color.WHITE);
		label_10.setFont(new Font("Tahoma", Font.BOLD, 21));
		label_10.setBounds(516, 347, 187, 28);
		panel.add(label_10);
		
		JLabel label_11 = new JLabel("");
		label_11.setOpaque(true);
		label_11.setForeground(new Color(0, 155, 124));
		label_11.setFont(new Font("Tahoma", Font.BOLD, 40));
		label_11.setBackground(new Color(0, 155, 124));
		label_11.setBounds(510, 347, 234, 28);
		panel.add(label_11);
		
		JLabel label_12 = new JLabel("" + selectedFactura.getPrecioTotal());
		label_12.setForeground(Color.BLACK);
		label_12.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label_12.setBounds(525, 386, 219, 28);
		panel.add(label_12);
		
		JLabel label_14 = new JLabel("");
		label_14.setOpaque(true);
		label_14.setForeground(Color.BLACK);
		label_14.setFont(new Font("Tahoma", Font.BOLD, 23));
		label_14.setBackground(Color.WHITE);
		label_14.setBounds(510, 381, 234, 38);
		panel.add(label_14);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 303, 479, 255);
		panel.add(scrollPane);
		
		table = new JTable();
		table.setModel(model);
		table.setBackground(Color.WHITE);
		scrollPane.setViewportView(table);
		
		lblMontoAbonar = new JLabel(""+selectedFactura.getLineaCredito());
		lblMontoAbonar.setForeground(Color.BLACK);
		lblMontoAbonar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblMontoAbonar.setBounds(525, 466, 219, 28);
		panel.add(lblMontoAbonar);
		
		JLabel label_16 = new JLabel("");
		label_16.setOpaque(true);
		label_16.setForeground(Color.BLACK);
		label_16.setFont(new Font("Tahoma", Font.BOLD, 23));
		label_16.setBackground(Color.WHITE);
		label_16.setBounds(510, 461, 234, 38);
		panel.add(label_16);
		
		JLabel lblLineaDeCredito = new JLabel("Linea de Credito");
		lblLineaDeCredito.setForeground(Color.WHITE);
		lblLineaDeCredito.setFont(new Font("Tahoma", Font.BOLD, 21));
		lblLineaDeCredito.setBounds(516, 427, 187, 28);
		panel.add(lblLineaDeCredito);
		
		JLabel label_18 = new JLabel("");
		label_18.setOpaque(true);
		label_18.setForeground(new Color(0, 155, 124));
		label_18.setFont(new Font("Tahoma", Font.BOLD, 40));
		label_18.setBackground(new Color(0, 155, 124));
		label_18.setBounds(510, 427, 234, 28);
		panel.add(label_18);
		scrollPane.getViewport().setBackground(Color.white);
		
		final JLabel label = new JLabel("X");
		label.setBounds(745, 0, 23, 49);
		contentPanel.add(label);
		label.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				dispose();
			}
			@Override
			public void mousePressed(MouseEvent e) {
				label.setForeground(Color.red);
			}
		});
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setForeground(Color.DARK_GRAY);
		label.setFont(new Font("Tahoma", Font.PLAIN, 40));
		
		if (selectedFactura.isACredito()) {
			lblAbonar.setEnabled(true);
		}
		else {
			lblAbonar.setEnabled(false);
		}
		loadTableFactura(selectedFactura);
	}
	
	public static void loadTableFactura(Factura selectedFactura) {
		
		model.setRowCount(0);
		rows = new Object[model.getColumnCount()];
		for (Producto producto : selectedFactura.getMisProductos()) {
			rows[0] = producto.getNumSerie();
			rows[1] = producto.getMarca();
			rows[2] = producto.getClass().getSimpleName();
			rows[3] = producto.getCantidad();
			rows[4] = producto.getPrecio();
			model.addRow(rows);
		}
		
	}
}
