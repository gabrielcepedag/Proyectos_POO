package Visual;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Cursor;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Home extends JFrame {

	private JPanel contentPane;
	private JPanel panelProductos;
	private JPanel panelFactura;
	private JPanel panelClientes;
	private JLabel lblProductos;
	private JLabel lblClientes;
	private JLabel lblFactura;
	private JLabel lblAdministrar;
	private JLabel lblSalir;
	private JPanel panelAdministrar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home frame = new Home();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Home() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1400, 886);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		panelProductos = new JPanel();
		
		final JLabel lblX = new JLabel("X");
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
		lblX.setBounds(1333, 0, 57, 55);
		panel.add(lblX);
		
		panelAdministrar = new JPanel();
		panelAdministrar.setVisible(false);
		panelAdministrar.setLayout(null);
		panelAdministrar.setBackground(Color.WHITE);
		panelAdministrar.setBounds(401, 13, 967, 850);
		panel.add(panelAdministrar);
		
		JLabel label_10 = new JLabel("");
		label_10.setIcon(new ImageIcon(Home.class.getResource("/Imagenes/AdministrarLabel.png")));
		label_10.setHorizontalAlignment(SwingConstants.CENTER);
		label_10.setForeground(Color.WHITE);
		label_10.setFont(new Font("Tahoma", Font.PLAIN, 30));
		label_10.setBounds(73, 45, 283, 71);
		panelAdministrar.add(label_10);
		
		JLabel label_11 = new JLabel("");
		label_11.setOpaque(true);
		label_11.setBackground(new Color(0, 139, 139));
		label_11.setBounds(73, 114, 785, 3);
		panelAdministrar.add(label_11);
		
		JLabel label_12 = new JLabel("");
		label_12.setIcon(new ImageIcon(Home.class.getResource("/Imagenes/PanelHome.png")));
		label_12.setHorizontalAlignment(SwingConstants.CENTER);
		label_12.setBounds(12, 13, 955, 826);
		panelAdministrar.add(label_12);
		
		panelFactura = new JPanel();
		panelFactura.setVisible(false);
		panelFactura.setLayout(null);
		panelFactura.setBackground(Color.WHITE);
		panelFactura.setBounds(401, 13, 967, 850);
		panel.add(panelFactura);
		
		JLabel label_7 = new JLabel("");
		label_7.setIcon(new ImageIcon(Home.class.getResource("/Imagenes/FacturaLabel.png")));
		label_7.setHorizontalAlignment(SwingConstants.CENTER);
		label_7.setForeground(Color.WHITE);
		label_7.setFont(new Font("Tahoma", Font.PLAIN, 30));
		label_7.setBounds(71, 46, 196, 71);
		panelFactura.add(label_7);
		
		JLabel label_8 = new JLabel("");
		label_8.setOpaque(true);
		label_8.setBackground(new Color(0, 139, 139));
		label_8.setBounds(73, 114, 785, 3);
		panelFactura.add(label_8);
		
		JLabel label_9 = new JLabel("");
		label_9.setIcon(new ImageIcon(Home.class.getResource("/Imagenes/PanelHome.png")));
		label_9.setHorizontalAlignment(SwingConstants.CENTER);
		label_9.setBounds(12, 13, 955, 826);
		panelFactura.add(label_9);
		
		panelClientes = new JPanel();
		panelClientes.setVisible(false);
		panelClientes.setLayout(null);
		panelClientes.setBackground(Color.WHITE);
		panelClientes.setBounds(401, 13, 967, 850);
		panel.add(panelClientes);
		
		JLabel label_5 = new JLabel("");
		label_5.setIcon(new ImageIcon(Home.class.getResource("/Imagenes/ClientesLabel.png")));
		label_5.setHorizontalAlignment(SwingConstants.CENTER);
		label_5.setForeground(Color.WHITE);
		label_5.setFont(new Font("Tahoma", Font.PLAIN, 30));
		label_5.setBounds(73, 45, 196, 71);
		panelClientes.add(label_5);
		
		JLabel label_4 = new JLabel("");
		label_4.setOpaque(true);
		label_4.setBackground(new Color(0, 139, 139));
		label_4.setBounds(73, 114, 785, 3);
		panelClientes.add(label_4);
		
		JLabel label_6 = new JLabel("");
		label_6.setIcon(new ImageIcon(Home.class.getResource("/Imagenes/PanelHome.png")));
		label_6.setHorizontalAlignment(SwingConstants.CENTER);
		label_6.setBounds(12, 13, 955, 826);
		panelClientes.add(label_6);
		panelProductos.setBackground(Color.WHITE);
		panelProductos.setBounds(401, 13, 967, 850);
		panel.add(panelProductos);
		panelProductos.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setOpaque(true);
		lblNewLabel_1.setBackground(new Color(0, 139, 139));
		lblNewLabel_1.setBounds(73, 114, 785, 3);
		panelProductos.add(lblNewLabel_1);
		
		JLabel label_3 = new JLabel("");
		label_3.setIcon(new ImageIcon(Home.class.getResource("/Imagenes/ProductosLabel.png")));
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setForeground(Color.WHITE);
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 30));
		label_3.setBounds(52, 45, 288, 71);
		panelProductos.add(label_3);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(Home.class.getResource("/Imagenes/PanelHome.png")));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(12, 13, 955, 826);
		panelProductos.add(label);
		
		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon(Home.class.getResource("/Imagenes/LogoMenu.png")));
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setForeground(Color.WHITE);
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 30));
		label_2.setBounds(41, 764, 358, 78);
		panel.add(label_2);
		
		lblSalir = new JLabel("Salir");
		lblSalir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				Login login = new Login();
				login.setVisible(true);
			}
		});
		lblSalir.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblSalir.setIcon(new ImageIcon(Home.class.getResource("/Imagenes/SalirIcon.png")));
		lblSalir.setHorizontalAlignment(SwingConstants.CENTER);
		lblSalir.setForeground(Color.WHITE);
		lblSalir.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblSalir.setBounds(31, 673, 358, 78);
		panel.add(lblSalir);
		
		lblAdministrar = new JLabel("Administrar");
		lblAdministrar.setBackground(new Color(36, 37, 38));
		lblAdministrar.setOpaque(true);
		lblAdministrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblProductos.setBackground(new Color(36, 37, 38));
				lblClientes.setBackground(new Color(36, 37, 38));
				lblFactura.setBackground(new Color(36, 37, 38));
				lblAdministrar.setBackground(new Color(0, 155, 124));
				panelProductos.setVisible(false);
				panelClientes.setVisible(false);
				panelFactura.setVisible(false);
				panelAdministrar.setVisible(true);
			}
		});
		lblAdministrar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblAdministrar.setIcon(new ImageIcon(Home.class.getResource("/Imagenes/Administraricon.png")));
		lblAdministrar.setHorizontalAlignment(SwingConstants.CENTER);
		lblAdministrar.setForeground(Color.WHITE);
		lblAdministrar.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblAdministrar.setBounds(31, 593, 358, 78);
		panel.add(lblAdministrar);
		
		lblFactura = new JLabel(" Factura");
		lblFactura.setBackground(new Color(36, 37, 38));
		lblFactura.setOpaque(true);
		lblFactura.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblProductos.setBackground(new Color(36, 37, 38));
				lblClientes.setBackground(new Color(36, 37, 38));
				lblFactura.setBackground(new Color(0, 155, 124));
				lblAdministrar.setBackground(new Color(36, 37, 38));
				panelProductos.setVisible(false);
				panelClientes.setVisible(false);
				panelFactura.setVisible(true);
				panelAdministrar.setVisible(false);
			}
		});
		lblFactura.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblFactura.setIcon(new ImageIcon(Home.class.getResource("/Imagenes/FacturaIcon.png")));
		lblFactura.setHorizontalAlignment(SwingConstants.CENTER);
		lblFactura.setForeground(Color.WHITE);
		lblFactura.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblFactura.setBounds(31, 516, 358, 78);
		panel.add(lblFactura);
		
		lblClientes = new JLabel("  Clientes");
		lblClientes.setBackground(new Color(36, 37, 38));
		lblClientes.setOpaque(true);
		lblClientes.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblProductos.setBackground(new Color(36, 37, 38));
				lblClientes.setBackground(new Color(0, 155, 124));
				lblFactura.setBackground(new Color(36, 37, 38));
				lblAdministrar.setBackground(new Color(36, 37, 38));
				panelProductos.setVisible(false);
				panelClientes.setVisible(true);
				panelFactura.setVisible(false);
				panelAdministrar.setVisible(false);
			}
		});
		lblClientes.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblClientes.setIcon(new ImageIcon(Home.class.getResource("/Imagenes/ClientesUSer.png")));
		lblClientes.setHorizontalAlignment(SwingConstants.CENTER);
		lblClientes.setForeground(Color.WHITE);
		lblClientes.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblClientes.setBounds(31, 437, 358, 78);
		panel.add(lblClientes);
		
		lblProductos = new JLabel("Productos");
		lblProductos.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblProductos.setOpaque(true);
		lblProductos.setBackground(new Color(0, 155, 124));
		lblProductos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblProductos.setBackground(new Color(0, 155, 124));
				lblClientes.setBackground(new Color(36, 37, 38));
				lblFactura.setBackground(new Color(36, 37, 38));
				lblAdministrar.setBackground(new Color(36, 37, 38));
				panelProductos.setVisible(true);
				panelClientes.setVisible(false);
				panelFactura.setVisible(false);
				panelAdministrar.setVisible(false);
			}
		});
		lblProductos.setIcon(new ImageIcon(Home.class.getResource("/Imagenes/ProductosIcon.png")));
		lblProductos.setHorizontalAlignment(SwingConstants.CENTER);
		lblProductos.setForeground(Color.WHITE);
		lblProductos.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblProductos.setBounds(31, 367, 358, 78);
		panel.add(lblProductos);
		
		JLabel lblAdministrador = new JLabel("Administrador");
		lblAdministrador.setHorizontalAlignment(SwingConstants.CENTER);
		lblAdministrador.setForeground(Color.WHITE);
		lblAdministrador.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblAdministrador.setBounds(112, 299, 193, 55);
		panel.add(lblAdministrador);
		
		JLabel lblDarvyBetances = new JLabel("Darvy Betances");
		lblDarvyBetances.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblDarvyBetances.setForeground(Color.WHITE);
		lblDarvyBetances.setHorizontalAlignment(SwingConstants.CENTER);
		lblDarvyBetances.setBounds(99, 238, 219, 78);
		panel.add(lblDarvyBetances);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(Home.class.getResource("/Imagenes/CirculoFotoUser.png")));
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setBounds(115, 58, 187, 202);
		panel.add(label_1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon(Home.class.getResource("/Imagenes/MenuPanel.png")));
		lblNewLabel.setBounds(31, 30, 358, 835);
		panel.add(lblNewLabel);
	}

}
