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

public class ListarCombo extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private static DefaultTableModel modelCombo;
	private static Object[] rows;
	private JLabel Eliminar;
	private JLabel Modificar;
	private JTable tableCombo;
	private Combo selectedCombo = null;
	private JLabel lblNewLabel_1;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ListarCombo dialog = new ListarCombo();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ListarCombo() {
		setUndecorated(true);
		setBounds(100, 100, 1117, 703);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout(0, 0));
		contentPanel.setBackground(Color.white);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		contentPanel.setLayout(null);
		
		JScrollPane scrollPaneCombo = new JScrollPane();
		scrollPaneCombo.setBounds(352, 43, 720, 607);
		contentPanel.add(scrollPaneCombo);
		
		//Combos de Prueba:
		Producto p1 = new MotherBoard("402", 10, 25000, "RTX", 1, 20, "QSY", "QSY", "QSY");
		Producto p2 = new MemoriaRam("403", 100, 10000, "TridentZ", 1, 500, 32, "DDR4");
		Producto p3 = new MicroProcesador("404", 55, 5500, "MSI", 10, 60, "QSY", "buena", 100);
		Producto p4 = new DiscoDuro("405", 20, 4500, "Esto", 5, 90, "Funciona", 500, "Maravilla");
		ArrayList<Producto> productosCombo = new ArrayList<Producto>();
		productosCombo.add(p1);
		productosCombo.add(p2);
		productosCombo.add(p3);
		productosCombo.add(p4);
		Combo c1 = new Combo("C - 1", "Super Pc Gaming JAJA", productosCombo, 30);
		Combo c2 = new Combo("C - 2", "La creme Gaming  ", productosCombo, 10);
		
		Tienda.getInstance().addCombo(c1);
		Tienda.getInstance().addCombo(c2);
		
		String header[] = {"Código", "Nombre", "Precio neto", "Descuento","Precio total", "Cant. De Productos"};
		modelCombo = new DefaultTableModel();
		modelCombo.setColumnIdentifiers(header);
				
		tableCombo = new JTable();
		tableCombo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int index = -1;
				index = tableCombo.getSelectedRow();
				if(index != -1) {
					Eliminar.setEnabled(true);
					Modificar.setEnabled(true);
					String codigo = (String)(modelCombo.getValueAt(index, 0));
					selectedCombo = Tienda.getInstance().buscarComboByCod(codigo);
				}
			}
		});
		tableCombo.setModel(modelCombo);
		tableCombo.getTableHeader().setBackground(new Color(0, 155, 124));
		tableCombo.getTableHeader().setForeground(Color.WHITE);
		scrollPaneCombo.setViewportView(tableCombo);
		scrollPaneCombo.setViewportView(tableCombo);
		scrollPaneCombo.getViewport().setBackground(Color.white);
		
		JPanel panel = new JPanel();
		panel.setBounds(22, 808, 10, 10);
		contentPanel.add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(12, 13, 288, 677);
		panel_1.setBackground(new Color(36, 37, 38));
		contentPanel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(48, 26, 209, 83);
		panel_1.add(lblNewLabel);
		lblNewLabel.setIcon(new ImageIcon(ListarCombo.class.getResource("/Imagenes/CombosLabelBlanco.png")));
		
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
		
		Eliminar = new JLabel(" Eliminar");
		Eliminar.setHorizontalAlignment(SwingConstants.CENTER);
		Eliminar.setBounds(0, 217, 288, 44);
		panel_1.add(Eliminar);
		Eliminar.setEnabled(false);
		Eliminar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Tienda.getInstance().eliminarCombo(selectedCombo);;
				Modificar.setEnabled(false);
				Eliminar.setEnabled(false);
				loadTableCombo();
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				Eliminar.setBackground(new Color(0, 155, 124));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				Eliminar.setBackground(new Color(36, 37, 38));
			}
		});
		Eliminar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		Eliminar.setIcon(new ImageIcon(ListarCliente.class.getResource("/Imagenes/EliminarIcon.png")));
		Eliminar.setOpaque(true);
		Eliminar.setForeground(Color.WHITE);
		Eliminar.setFont(new Font("Tahoma", Font.PLAIN, 34));
		Eliminar.setBackground(new Color(36, 37, 38));
		
		Modificar = new JLabel(" Modificar");
		Modificar.setHorizontalAlignment(SwingConstants.CENTER);
		Modificar.setBounds(0, 274, 288, 44);
		panel_1.add(Modificar);
		Modificar.setEnabled(false);
		Modificar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				Modificar.setBackground(new Color(0, 155, 124));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				Modificar.setBackground(new Color(36, 37, 38));
			}
		});
		Modificar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		Modificar.setIcon(new ImageIcon(ListarCliente.class.getResource("/Imagenes/ModificarIcon.png")));
		Modificar.setOpaque(true);
		Modificar.setForeground(Color.WHITE);
		Modificar.setFont(new Font("Tahoma", Font.PLAIN, 34));
		Modificar.setBackground(new Color(36, 37, 38));
		
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

