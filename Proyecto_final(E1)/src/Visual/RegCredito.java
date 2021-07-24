package Visual;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.omg.CORBA.TCKind;

import logico.Cliente;
import logico.Empleado;
import logico.Tienda;
import logico.Vendedor;

import java.awt.Rectangle;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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
import javax.swing.JSpinner;

public class RegCredito extends JDialog {

	private JPanel contentPane;
	private JPanel panelRegistro;
	Cliente selected = null;
	private Cliente clienteSelected = null;
	private JTextField txtCredito;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegCredito dialog = new RegCredito(null);
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
	public RegCredito(Cliente cliente) {
		clienteSelected = cliente;
		setUndecorated(true);
		setBounds(100, 100, 587, 271);
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
		panelRegistro.setBounds(11, 12, 553, 239);
		panel.add(panelRegistro);
		
		JLabel lblRegistrar = new JLabel("A\u00F1adir Cr\u00E9dito:");
		lblRegistrar.setFont(new Font("Tahoma", Font.PLAIN, 35));
		lblRegistrar.setBounds(33, 13, 322, 55);
		panelRegistro.add(lblRegistrar);
		
		JLabel lblCantidad = new JLabel("Cantidad:");
		lblCantidad.setForeground(Color.BLACK);
		lblCantidad.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblCantidad.setBounds(32, 101, 103, 55);
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
		lblNewLabel.setBounds(42, 169, 225, 55);
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
				if (txtCredito.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "El campo está vacío", "Error", JOptionPane.WARNING_MESSAGE);
					System.exit(1);
				}
				else {
					clienteSelected.setCredito(Float.valueOf(txtCredito.getText()));
					JOptionPane.showMessageDialog(null, "Credito Asignado correctamente");
					ListarCliente.loadTableCliente(null);
					dispose();
				}
			}
		});
		lblRegistrar_1.setOpaque(true);
		lblRegistrar_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegistrar_1.setForeground(Color.WHITE);
		lblRegistrar_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblRegistrar_1.setBackground(new Color(0, 155, 124));
		lblRegistrar_1.setBounds(301, 169, 225, 55);
		panelRegistro.add(lblRegistrar_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 155, 124));
		panel_1.setBounds(34, 64, 390, 4);
		panelRegistro.add(panel_1);
		
		txtCredito = new JTextField();
		txtCredito.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtCredito.setBounds(122, 103, 404, 50);
		panelRegistro.add(txtCredito);
		txtCredito.setColumns(10);
		
		loadSpn();
		
	}
	private void loadSpn() {
		if(clienteSelected != null) {
			txtCredito.setText(""+clienteSelected.getCredito());
		}
	}
}
