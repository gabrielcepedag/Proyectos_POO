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
import logico.OrdenCompra;
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
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ListarPedido extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private static DefaultTableModel modelPedido;
	private static Object[] rows;
	private JLabel Confirmar;
	private JTable tablePedido;
	private OrdenCompra selectedOrdenCompra = null;
	private JLabel lblNewLabel_1;
	private JLabel detalles;
	int indexCbx = 0;
	private JComboBox<String> cbxTipoPedido;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ListarPedido dialog = new ListarPedido();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ListarPedido() {
		setUndecorated(true);
		setBounds(100, 100, 1117, 703);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout(0, 0));
		contentPanel.setBackground(Color.white);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		contentPanel.setLayout(null);
		
		cbxTipoPedido = new JComboBox<String>();
		cbxTipoPedido.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				indexCbx = cbxTipoPedido.getSelectedIndex();
				if (indexCbx != -1) {
					loadTablePedido(indexCbx);
				}
			}
		});
		cbxTipoPedido.setModel(new DefaultComboBoxModel<String>(new String[] {"<Todos>", "Procesados", "Sin procesar"}));
		cbxTipoPedido.setFont(new Font("Tahoma", Font.PLAIN, 17));
		cbxTipoPedido.setBounds(352, 63, 187, 30);
		contentPanel.add(cbxTipoPedido);
		
		JScrollPane scrollPanePedido = new JScrollPane();
		scrollPanePedido.setBounds(352, 104, 720, 546);
		contentPanel.add(scrollPanePedido);
		
		/*Combos de Prueba:
		Producto p1 = new MotherBoard("402", 10, 25000, "RTX", 1, 20, "QSY", "QSY", "QSY");
		Producto p2 = new MemoriaRam("403", 100, 10000, "TridentZ", 1, 500, 32, "DDR4");
		Producto p3 = new MicroProcesador("404", 55, 5500, "MSI", 10, 60, "QSY", "buena", 100);
		Producto p4 = new DiscoDuro("405", 20, 4500, "Esto", 5, 90, "Funciona", 500, "Maravilla");
		
		OrdenCompra ordenCompra = new OrdenCompra("Ord - 1", p2);
		ordenCompra.setCantidad(3);
		ordenCompra.setDistribuidor("Tu madrina");
		ordenCompra.setPrecioTotal(ordenCompra.getProducto().getPrecio());
		ordenCompra.setProcesada(false);
		Tienda.getInstance().addOrdenCompra(ordenCompra);
		
		OrdenCompra ordenCompra2 = new OrdenCompra("Ord -2", p3);
		ordenCompra.setCantidad(5);
		ordenCompra.setDistribuidor("Tu padrastro");
		ordenCompra.setPrecioTotal(ordenCompra.getProducto().getPrecio());
		ordenCompra.setProcesada(true);
		Tienda.getInstance().addOrdenCompra(ordenCompra2);
		*/
		
		String header[] = {"Código", "Distribuidos", "Producto", "Cantidad", "Precio total", "Fecha de Solicitud", "Estado"};
		modelPedido = new DefaultTableModel();
		modelPedido.setColumnIdentifiers(header);
				
		tablePedido = new JTable();
		tablePedido.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int index = -1;
				index = tablePedido.getSelectedRow();
				if(index != -1) {
					Confirmar.setEnabled(true);
					detalles.setEnabled(true);
					String codigo = (String)(modelPedido.getValueAt(index, 0));
					selectedOrdenCompra = Tienda.getInstance().buscarOrdenDeCompraByCod(codigo);
				}
			}
		});
		tablePedido.setModel(modelPedido);
		tablePedido.getTableHeader().setBackground(new Color(0, 155, 124));
		tablePedido.getTableHeader().setForeground(Color.WHITE);
		scrollPanePedido.setViewportView(tablePedido);
		scrollPanePedido.setViewportView(tablePedido);
		scrollPanePedido.getViewport().setBackground(Color.white);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(12, 13, 288, 677);
		panel_1.setBackground(new Color(36, 37, 38));
		contentPanel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(48, 26, 209, 83);
		panel_1.add(lblNewLabel);
		lblNewLabel.setIcon(new ImageIcon(ListarPedido.class.getResource("/Imagenes/PedidosLabelBlanco.png")));
		
		lblNewLabel_1 = new JLabel(" Crear");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(0, 160, 288, 44);
		panel_1.add(lblNewLabel_1);
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				JOptionPane.showMessageDialog(null, "Usted no puede entrar aquí por que notamos una falta de amor propio, subase el autoestima y vuelva");
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblNewLabel_1.setBackground(new Color(0, 155, 124));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblNewLabel_1.setBackground(new Color(36, 37, 38));
			}
		});
		lblNewLabel_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel_1.setOpaque(true);
		lblNewLabel_1.setBackground(new Color(36, 37, 38));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 34));
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setIcon(new ImageIcon(ListarCliente.class.getResource("/Imagenes/A\u00F1adirIcon.png")));
		
		Confirmar = new JLabel("Confirmar");
		Confirmar.setHorizontalAlignment(SwingConstants.CENTER);
		Confirmar.setBounds(0, 217, 288, 44);
		panel_1.add(Confirmar);
		Confirmar.setEnabled(false);
		Confirmar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (selectedOrdenCompra != null) {
					selectedOrdenCompra.setProcesada(true);
					Confirmar.setEnabled(false);
					detalles.setEnabled(false);
					loadTablePedido(indexCbx);
				}
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				Confirmar.setBackground(new Color(0, 155, 124));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				Confirmar.setBackground(new Color(36, 37, 38));
			}
		});
		Confirmar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		Confirmar.setIcon(new ImageIcon(ListarPedido.class.getResource("/Imagenes/ConfirmarIcon.png")));
		Confirmar.setOpaque(true);
		Confirmar.setForeground(Color.WHITE);
		Confirmar.setFont(new Font("Tahoma", Font.PLAIN, 34));
		Confirmar.setBackground(new Color(36, 37, 38));
		
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
		
		detalles = new JLabel("Detalles");
		detalles.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JOptionPane.showMessageDialog(null, "Patrocinado por la unica tienda que nada... La sirena");
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
		detalles.setIcon(new ImageIcon(ListarPedido.class.getResource("/Imagenes/OjoIcon.png")));
		detalles.setOpaque(true);
		detalles.setHorizontalAlignment(SwingConstants.CENTER);
		detalles.setForeground(Color.WHITE);
		detalles.setFont(new Font("Tahoma", Font.PLAIN, 34));
		detalles.setEnabled(false);
		detalles.setBackground(new Color(36, 37, 38));
		detalles.setBounds(0, 270, 288, 44);
		panel_1.add(detalles);
		
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
		
		loadTablePedido(0);
	}
	
	public static void loadTablePedido(int selection) {
		
		modelPedido.setRowCount(0);
		rows = new Object[modelPedido.getColumnCount()];
		
		switch (selection) {
		case 0:
			for (OrdenCompra ordenCompra : Tienda.getInstance().getMisOrdenesCompra()) {
				rows[0] = ordenCompra.getCodigo();
				rows[1] =  ordenCompra.getDistribuidor();
				rows[2] = ordenCompra.getProducto().getClass().getSimpleName();
				rows[3] = ordenCompra.getCantidad();
				rows[4] = ordenCompra.getPrecioTotal();
				rows[5] = ordenCompra.getFechaSolicitud();
				rows[6] = ordenCompra.isProcesada();
				modelPedido.addRow(rows);
			}
			break;
			
		case 1:
			for (OrdenCompra ordenCompra : Tienda.getInstance().getMisOrdenesCompra()) {
				if (ordenCompra.isProcesada()) {
					rows[0] = ordenCompra.getCodigo();
					rows[1] =  ordenCompra.getDistribuidor();
					rows[2] = ordenCompra.getProducto().getClass().getSimpleName();
					rows[3] = ordenCompra.getCantidad();
					rows[4] = ordenCompra.getPrecioTotal();
					rows[5] = ordenCompra.getFechaSolicitud();
					rows[6] = ordenCompra.isProcesada();
					modelPedido.addRow(rows);
				}
			}
			break;
		case 2:
			for (OrdenCompra ordenCompra : Tienda.getInstance().getMisOrdenesCompra()) {
				if (!ordenCompra.isProcesada()) {
					rows[0] = ordenCompra.getCodigo();
					rows[1] =  ordenCompra.getDistribuidor();
					rows[2] = ordenCompra.getProducto().getClass().getSimpleName();
					rows[3] = ordenCompra.getCantidad();
					rows[4] = ordenCompra.getPrecioTotal();
					rows[5] = ordenCompra.getFechaSolicitud();
					rows[6] = ordenCompra.isProcesada();
					modelPedido.addRow(rows);
				}
			}
			break;
		}
		
	}
}
