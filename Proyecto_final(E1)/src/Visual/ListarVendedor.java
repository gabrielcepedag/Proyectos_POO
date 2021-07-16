package Visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import logico.Cliente;
import logico.Empleado;
import logico.Tienda;
import logico.Vendedor;

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
import javax.swing.SwingConstants;
import javax.swing.JTextField;

public class ListarVendedor extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private static DefaultTableModel modelVendedor;
	private static Object[] rows;
	private JLabel Eliminar;
	private JLabel Modificar;
	private JTable tableClienteVendedor;
	private Cliente selectedCliente = null;
	private JLabel nuevo;
	private JLabel lblNewLabel_1;
	private JTextField txtCedulaVend;
	String cedulaVendedor = null;
	
	public static void main(String[] args) {
		try {
			ListarVendedor dialog = new ListarVendedor();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ListarVendedor() {
		setUndecorated(true);
		setBounds(100, 100, 1117, 703);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout(0, 0));
		contentPanel.setBackground(Color.white);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		contentPanel.setLayout(null);
		
		txtCedulaVend = new JTextField();
		txtCedulaVend.setFont(new Font("Tahoma", Font.PLAIN, 17));
		txtCedulaVend.setBounds(366, 34, 208, 35);
		contentPanel.add(txtCedulaVend);
		txtCedulaVend.setColumns(10);
		
		lblNewLabel_1 = new JLabel("Buscar");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (!txtCedulaVend.getText().isEmpty()) {
					cedulaVendedor = txtCedulaVend.getText();
					loadTableVendedor(cedulaVendedor);
				}else {
					txtCedulaVend.setText("");
					loadTableVendedor(null);
				}
			}
		});
		lblNewLabel_1.setOpaque(true);
		lblNewLabel_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel_1.setBackground(new Color(0, 155, 124));
		lblNewLabel_1.setIcon(new ImageIcon(ListarVendedor.class.getResource("/Imagenes/Lupa.png")));
		lblNewLabel_1.setBounds(598, 34, 130, 35);
	
		contentPanel.add(lblNewLabel_1);
		
		JScrollPane scrollPaneVendedor = new JScrollPane();
		scrollPaneVendedor.setBounds(352, 76, 730, 570);
		contentPanel.add(scrollPaneVendedor);
		
		//Vendedores de prrueba;
		
		Vendedor v1 = new Vendedor("sdas", "adsasd", "asdsad", "asdassad", "asadas", "asdsadads");
		Vendedor v2 = new Vendedor("DarvyBM", "KLK", "Darvy Betances", "2434332", "809-247-2240", "Santiago de los caballeros");
		Tienda.getInstance().addEmpleado(v1);
		Tienda.getInstance().addEmpleado(v2);
		
		String header[] = {"Cédula", "Nombre", "Usename", "Contraseñá","Telefono", "Dirección", "Total vendido"};
		modelVendedor = new DefaultTableModel();
		modelVendedor.setColumnIdentifiers(header);
				
		tableClienteVendedor = new JTable();
		tableClienteVendedor.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int index = -1;
				index = tableClienteVendedor.getSelectedRow();
				if(index != -1) {
					Eliminar.setEnabled(true);
					Modificar.setEnabled(true);
					String cedula = (String)(modelVendedor.getValueAt(index, 0));
					selectedCliente = Tienda.getInstance().buscarClienteByCedula(cedula);
				}
			}
		});
		tableClienteVendedor.setModel(modelVendedor);
		tableClienteVendedor.getTableHeader().setBackground(new Color(0, 155, 124));
		tableClienteVendedor.getTableHeader().setForeground(Color.WHITE);
		scrollPaneVendedor.setViewportView(tableClienteVendedor);
		scrollPaneVendedor.setViewportView(tableClienteVendedor);
		scrollPaneVendedor.getViewport().setBackground(Color.white);
		
		JPanel panel = new JPanel();
		panel.setBounds(22, 808, 10, 10);
		contentPanel.add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(12, 13, 303, 677);
		panel_1.setBackground(new Color(36, 37, 38));
		contentPanel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(7, 28, 288, 83);
		panel_1.add(lblNewLabel);
		lblNewLabel.setIcon(new ImageIcon(ListarVendedor.class.getResource("/Imagenes/VendedoresLabelBlanco.png")));
		
		nuevo = new JLabel(" Nuevo");
		nuevo.setHorizontalAlignment(SwingConstants.CENTER);
		nuevo.setBounds(0, 160, 303, 44);
		panel_1.add(nuevo);
		nuevo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				RegVendedor regVendedor = new RegVendedor();
				regVendedor.setModal(true);
				regVendedor.setVisible(true);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				nuevo.setBackground(new Color(0, 155, 124));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				nuevo.setBackground(new Color(36, 37, 38));
			}
		});
		nuevo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		nuevo.setOpaque(true);
		nuevo.setBackground(new Color(36, 37, 38));
		nuevo.setFont(new Font("Tahoma", Font.PLAIN, 34));
		nuevo.setForeground(Color.WHITE);
		nuevo.setIcon(new ImageIcon(ListarCliente.class.getResource("/Imagenes/A\u00F1adirIcon.png")));
		
		Eliminar = new JLabel(" Eliminar");
		Eliminar.setHorizontalAlignment(SwingConstants.CENTER);
		Eliminar.setBounds(0, 217, 303, 44);
		panel_1.add(Eliminar);
		Eliminar.setEnabled(false);
		Eliminar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Tienda.getInstance().eliminarCliente(selectedCliente);;
				Eliminar.setEnabled(false);
				Modificar.setEnabled(false);
				loadTableVendedor(null);
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
		Modificar.setBounds(0, 274, 303, 44);
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
		lblCancelar.setBounds(0, 620, 303, 57);
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
		lblAdministracin.setBounds(84, 81, 144, 64);
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
		lblNewLabel_2.setBounds(327, 8, 778, 682);
		contentPanel.add(lblNewLabel_2);
		
		loadTableVendedor(null);
	}
	
	public static void loadTableVendedor(String cedula) {
		
		modelVendedor.setRowCount(0);
		rows = new Object[modelVendedor.getColumnCount()];
		
		Empleado vendedor = (Vendedor) Tienda.getInstance().buscarEmpleadoByCedula(cedula);
		
		if (cedula == null) {
			for (Empleado empleado : Tienda.getInstance().getMisEmpleados()) {
				if(empleado instanceof Vendedor) {
					rows[0] = empleado.getCedula();
					rows[1] = empleado.getNombre();
					rows[2] = empleado.getUsername();
					rows[3] = empleado.getPassword();
					rows[4] = empleado.getTelefono();
					rows[5] = empleado.getDireccion();
					rows[6] = ((Vendedor) empleado).getTotalVendido();
					modelVendedor.addRow(rows);
				}
			}
		}else if (vendedor != null) {
				rows[0] = vendedor.getCedula();
				rows[1] = vendedor.getNombre();
				rows[2] = vendedor.getUsername();
				rows[3] = vendedor.getPassword();
				rows[4] = vendedor.getTelefono();
				rows[5] = vendedor.getDireccion();
				rows[6] = ((Vendedor)vendedor).getTotalVendido();
				modelVendedor.addRow(rows);
		}
		
	}
}

