package Visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import logico.Cliente;
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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.GridLayout;
import javax.swing.SwingConstants;
import javax.swing.JTextField;

public class ListarCliente extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable tableProductos;
	private static DefaultTableModel modelCliente;
	private static Object[] rows;
	private JLabel Eliminar;
	private JLabel Modificar;
	private JTable tableCliente;
	private Cliente selectedCliente = null;
	private JLabel lblNewLabel_1;
	private JTextField txtCedulaCliente;
	private Cliente clienteBuscado = null;
	private String cedulaClienteFact = null;
	private String cedulaCliente = null;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ListarCliente dialog = new ListarCliente();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ListarCliente() {
		setUndecorated(true);
		setBounds(100, 100, 1117, 703);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout(0, 0));
		contentPanel.setBackground(Color.white);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		contentPanel.setLayout(null);
		
		txtCedulaCliente = new JTextField();
		txtCedulaCliente.setHorizontalAlignment(SwingConstants.CENTER);
		txtCedulaCliente.setFont(new Font("Tahoma", Font.PLAIN, 17));
		txtCedulaCliente.setColumns(10);
		txtCedulaCliente.setBackground(Color.WHITE);
		txtCedulaCliente.setBounds(352, 28, 210, 40);
		contentPanel.add(txtCedulaCliente);
		
		JLabel label_1 = new JLabel("Buscar");
		label_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (!(txtCedulaCliente.getText().isEmpty())) {
					cedulaCliente = txtCedulaCliente.getText();
					loadTableCliente(cedulaCliente);
				}else {
					txtCedulaCliente.setText("");
					loadTableCliente(null);
				}
			}
		});
		label_1.setIcon(new ImageIcon(ListarCliente.class.getResource("/Imagenes/Lupa.png")));
		label_1.setOpaque(true);
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		label_1.setBackground(new Color(0, 155, 124));
		label_1.setBounds(579, 28, 150, 40);
		contentPanel.add(label_1);
		
		JScrollPane scrollPaneCliente = new JScrollPane();
		scrollPaneCliente.setBounds(352, 81, 730, 565);
		contentPanel.add(scrollPaneCliente);
		
		Cliente c1 = new Cliente("4023343", "Darvy", "Bella vista, Satiago de los caballeros", "829-699-4610");
		c1.setCredito(10000);
		Cliente c2 = new Cliente("4024550", "Eduardo", "Puerto Planta", "843-433-5552");
		c2.setCredito(25000);
		Cliente c3 = new Cliente("4021460", "Gabriel", "La Vega", "829-444-1340");
		Tienda.getInstance().addCliente(c1);
		Tienda.getInstance().addCliente(c2);
		Tienda.getInstance().addCliente(c3);
		
		String header[] = {"Cédula", "Nombre", "Telefono", "Dirección","Crédito"};
		modelCliente = new DefaultTableModel();
		modelCliente.setColumnIdentifiers(header);
				
		tableCliente = new JTable();
		tableCliente.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int index = -1;
				index = tableCliente.getSelectedRow();
				if(index != -1) {
					Eliminar.setEnabled(true);
					Modificar.setEnabled(true);
					String cedula = (String)(modelCliente.getValueAt(index, 0));
					selectedCliente = Tienda.getInstance().buscarClienteByCedula(cedula);
				}
			}
		});
		tableCliente.setModel(modelCliente);
		tableCliente.getTableHeader().setBackground(new Color(0, 155, 124));
		tableCliente.getTableHeader().setForeground(Color.WHITE);
		scrollPaneCliente.setViewportView(tableCliente);
		scrollPaneCliente.setViewportView(tableCliente);
		scrollPaneCliente.getViewport().setBackground(Color.white);
		
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
		lblNewLabel.setIcon(new ImageIcon(ListarCliente.class.getResource("/Imagenes/ClientesLabelBlanco.png")));
		
		lblNewLabel_1 = new JLabel(" Cr\u00E9dito");
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
				Tienda.getInstance().eliminarCliente(selectedCliente);;
				Modificar.setEnabled(false);
				Eliminar.setEnabled(false);
				loadTableCliente(null);
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
		loadTableCliente(null);
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
}

