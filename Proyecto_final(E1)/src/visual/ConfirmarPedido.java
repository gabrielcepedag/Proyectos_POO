package visual;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import logico.Administrador;
import logico.OrdenCompra;
import logico.Producto;
import logico.Tienda;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Cursor;
import javax.swing.JTextField;
import javax.swing.JDialog;
import javax.swing.JSpinner;
import javax.swing.JComboBox;
import javax.swing.SpinnerNumberModel;
import javax.swing.DefaultComboBoxModel;

public class ConfirmarPedido extends JDialog {

	private JPanel contentPane;
	private JPanel panelRegistro;
	private OrdenCompra selected = null;
	private JTextField txtAdmin;
	private JTextField txtFecha;
	private JSpinner spnCantidad;
	private JComboBox<String> cbxDistribuidor;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConfirmarPedido dialog = new ConfirmarPedido(null);
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
	public ConfirmarPedido(OrdenCompra pedido) {
		selected = pedido;
		
		setUndecorated(true);
		setBounds(100, 100, 587, 453);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(36, 37, 38));
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		panelRegistro = new JPanel();
		panelRegistro.setLayout(null);
		panelRegistro.setBackground(Color.WHITE);
		panelRegistro.setBounds(11, 12, 553, 417);
		panel.add(panelRegistro);
		
		JLabel lblRegistrar = new JLabel("Confirmar pedido:");
		lblRegistrar.setFont(new Font("Tahoma", Font.PLAIN, 35));
		lblRegistrar.setBounds(33, 13, 391, 55);
		panelRegistro.add(lblRegistrar);
		
		JLabel lblCantidad = new JLabel("Cantidad:");
		lblCantidad.setForeground(Color.BLACK);
		lblCantidad.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblCantidad.setBounds(33, 81, 103, 55);
		panelRegistro.add(lblCantidad);
		
		JLabel lblNewLabel = new JLabel("Cancelar");
		lblNewLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBackground(new Color(0, 155, 124));
		lblNewLabel.setOpaque(true);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(43, 346, 225, 55);
		panelRegistro.add(lblNewLabel);
		
		final JLabel lblX = new JLabel("X");
		lblX.setBounds(496, 0, 57, 55);
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
		
		JLabel lblRegistrar_1 = new JLabel("A\u00F1adir");
		lblRegistrar_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblRegistrar_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (cbxDistribuidor.getSelectedIndex() == 0 || txtAdmin.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Algún campo está vacío", "Error", JOptionPane.WARNING_MESSAGE);
				}
				else {
					selected.setCantidad(Integer.parseInt(spnCantidad.getValue().toString()));
					selected.setDistribuidor(cbxDistribuidor.getSelectedItem().toString());
					selected.setFechaSolicitud(new Date());
					selected.setProcesada(true);
					selected.setMiAdministrador((Administrador)Tienda.getInstance().getLoginUserEmpleado());
					selected.setPrecioTotal(selected.getProducto().getPrecio());
					JOptionPane.showMessageDialog(null, "pedido confirmado exitosamente");
					ListarPedido.loadTablePedido(0);
					dispose();
				}
			}
		});
		lblRegistrar_1.setOpaque(true);
		lblRegistrar_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegistrar_1.setForeground(Color.WHITE);
		lblRegistrar_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblRegistrar_1.setBackground(new Color(0, 155, 124));
		lblRegistrar_1.setBounds(302, 346, 225, 55);
		panelRegistro.add(lblRegistrar_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 155, 124));
		panel_1.setBounds(34, 64, 390, 4);
		panelRegistro.add(panel_1);
		
		txtAdmin = new JTextField();
		txtAdmin.setEnabled(false);
		txtAdmin.setFont(new Font("Dialog", Font.PLAIN, 20));
		txtAdmin.setBounds(179, 215, 348, 50);
		panelRegistro.add(txtAdmin);
		txtAdmin.setColumns(10);
		
		spnCantidad = new JSpinner();
		spnCantidad.setFont(new Font("Dialog", Font.PLAIN, 20));
		int max = selected.getProducto().getDispMax() - selected.getProducto().getCantidad();
		spnCantidad.setModel(new SpinnerNumberModel(1, 1, max, 1));
		spnCantidad.setBounds(179, 86, 348, 50);
		panelRegistro.add(spnCantidad);
		
		JLabel lblAdministrador = new JLabel("Administrador:");
		lblAdministrador.setForeground(Color.BLACK);
		lblAdministrador.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblAdministrador.setBounds(33, 212, 176, 55);
		panelRegistro.add(lblAdministrador);
		
		JLabel lblDistribuidor = new JLabel("Distribuidor:");
		lblDistribuidor.setForeground(Color.BLACK);
		lblDistribuidor.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblDistribuidor.setBounds(33, 149, 120, 55);
		panelRegistro.add(lblDistribuidor);
		
		cbxDistribuidor = new JComboBox<String>();
		cbxDistribuidor.setFont(new Font("Dialog", Font.PLAIN, 20));
		DefaultComboBoxModel<String> model = new DefaultComboBoxModel<String>();
		model.addElement("<Seleccione>");
		for (String distribuidor : Tienda.getInstance().getMisDistribuidores()) {
			model.addElement(distribuidor);
		}
		cbxDistribuidor.setModel(model);
		cbxDistribuidor.setBounds(179, 151, 348, 50);
		panelRegistro.add(cbxDistribuidor);
		
		JLabel lblFechaActual = new JLabel("Fecha Actual:");
		lblFechaActual.setForeground(Color.BLACK);
		lblFechaActual.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblFechaActual.setBounds(33, 278, 176, 55);
		panelRegistro.add(lblFechaActual);
		
		txtFecha = new JTextField();
		txtFecha.setEnabled(false);
		txtFecha.setFont(new Font("Dialog", Font.PLAIN, 20));
		txtFecha.setColumns(10);
		txtFecha.setBounds(179, 278, 348, 50);
		panelRegistro.add(txtFecha);
		
		loadDatos();
		
	}
	private void loadDatos() {
		if(selected != null) {
			txtAdmin.setText(Tienda.getInstance().getLoginUserEmpleado().getNombre());
			txtFecha.setText(new SimpleDateFormat("dd-MM-yyyy").format(new Date()));
		}
	}
}