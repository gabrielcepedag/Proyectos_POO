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
import java.util.ArrayList;
import java.util.Date;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JComboBox;

public class ListarFactura extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private static DefaultTableModel modelFactura;
	private static Object[] rows;
	private JTable tableFactura;
	private Factura selectedFactura = null;
	private JTextField txtCedulaFact;
	int indexCbx = 0;
	String cedulaClienteFact = null;
	private JComboBox<String> cbxTipoFactura;
	private JLabel detalles;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ListarFactura dialog = new ListarFactura();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ListarFactura() {
		setUndecorated(true);
		setBounds(100, 100, 1117, 703);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout(0, 0));
		contentPanel.setBackground(Color.white);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		contentPanel.setLayout(null);
		
		JScrollPane scrollPaneFactura = new JScrollPane();
		scrollPaneFactura.setBounds(352, 83, 720, 567);
		contentPanel.add(scrollPaneFactura);
		
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
		
		scrollPaneFactura.setViewportView(tableFactura);
		tableFactura.getTableHeader().setBackground(new Color(0, 155, 124));
		tableFactura.getTableHeader().setForeground(Color.WHITE);
		scrollPaneFactura.setViewportView(tableFactura);
		scrollPaneFactura.getViewport().setBackground(Color.white);
		
		txtCedulaFact = new JTextField();
		txtCedulaFact.setHorizontalAlignment(SwingConstants.CENTER);
		txtCedulaFact.setFont(new Font("Tahoma", Font.PLAIN, 17));
		txtCedulaFact.setColumns(10);
		txtCedulaFact.setBackground(Color.WHITE);
		txtCedulaFact.setBounds(594, 33, 200, 37);
		contentPanel.add(txtCedulaFact);
		
		cbxTipoFactura = new JComboBox<String>();
		cbxTipoFactura.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
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
		cbxTipoFactura.setBounds(351, 33, 206, 37);
		contentPanel.add(cbxTipoFactura);
		
		JLabel label_1 = new JLabel("Buscar");
		label_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		label_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
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
		label_1.setIcon(new ImageIcon(ListarFactura.class.getResource("/Imagenes/Lupa.png")));
		label_1.setOpaque(true);
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		label_1.setBackground(new Color(0, 155, 124));
		label_1.setBounds(814, 33, 150, 37);
		contentPanel.add(label_1);
		
		
		/*Vendedor v1 = new Vendedor("DarvyBM", "KLK", "Darvy Betances", "2434-332", "809-247-2240", "Santiago de los caballeros");
		Tienda.getInstance().addEmpleado(v1);
		Cliente c1 = new Cliente("24234", "Fulanito", "Cerca de ti bb", "334-233-4244");
		Tienda.getInstance().addCliente(c1);
		ArrayList<Producto> productos = new ArrayList<Producto>();
		Producto p1 = new MicroProcesador("344", 10, 2344, "Intel", 1, 400, "Qsy", "Qsy", 124);
		Producto p2 = new MicroProcesador("355", 10, 2344, "Intel", 1, 400, "Qsy", "Qsy", 124);
		productos.add(p1);
		productos.add(p1);
		productos.add(p2);
		productos.add(p1);
		productos.add(p1);
		productos.add(p2);
		productos.add(p2);
		productos.add(p1);
		Factura f3 = new Factura("Fact-3", v1,c1, productos, new Date());
		Tienda.getInstance().addFactura(f3);*/
		
				
		JPanel panel = new JPanel();
		panel.setBounds(22, 808, 10, 10);
		contentPanel.add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(12, 13, 288, 677);
		panel_1.setBackground(new Color(36, 37, 38));
		contentPanel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(58, 26, 189, 83);
		panel_1.add(lblNewLabel);
		lblNewLabel.setIcon(new ImageIcon(ListarFactura.class.getResource("/Imagenes/FacturaLabelBlanco.png")));
		
		detalles = new JLabel("Detalles");
		detalles.setEnabled(false);
		detalles.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				FacturaDetalles facturaDetalles = new FacturaDetalles(selectedFactura);
				facturaDetalles.setModal(true);
				facturaDetalles.setVisible(true);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				detalles.setBackground(new Color(0, 155, 124));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				detalles.setBackground(new Color(36, 37, 38));
			}
		});
		detalles.setHorizontalAlignment(SwingConstants.CENTER);
		detalles.setBounds(0, 160, 288, 44);
		panel_1.add(detalles);
		
		detalles.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		detalles.setOpaque(true);
		detalles.setBackground(new Color(36, 37, 38));
		detalles.setFont(new Font("Tahoma", Font.PLAIN, 34));
		detalles.setForeground(Color.WHITE);
		detalles.setIcon(new ImageIcon(ListarFactura.class.getResource("/Imagenes/OjoIcon.png")));
		
		JLabel lblCancelar = new JLabel(" Cancelar");
		lblCancelar.setHorizontalAlignment(SwingConstants.CENTER);
		lblCancelar.setBounds(0, 626, 288, 51);
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
		lblAdministracin.setBounds(75, 81, 144, 64);
		panel_1.add(lblAdministracin);
		
		final JLabel label = new JLabel("X");
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
		label.setBounds(1060, -2, 57, 55);
		contentPanel.add(label);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBackground(Color.WHITE);
		lblNewLabel_2.setIcon(new ImageIcon(ListarCliente.class.getResource("/Imagenes/PanelListar.png")));
		lblNewLabel_2.setOpaque(true);
		lblNewLabel_2.setBounds(312, 8, 793, 682);
		contentPanel.add(lblNewLabel_2);
		cbxTipoFactura.setSelectedIndex(0);
		loadTableFactura(indexCbx,cedulaClienteFact);
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
