package Visual;

import java.awt.BorderLayout;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logico.Administrador;
import logico.Cliente;
import logico.DiscoDuro;
import logico.Empleado;
import logico.MemoriaRam;
import logico.MicroProcesador;
import logico.MotherBoard;
import logico.Producto;
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
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class RegProducto extends JDialog {

	private JPanel contentPane;
	private JTextField txtMarca;
	private JTextField txtPrecio;
	private JPanel panelRegistro;
	Cliente selected = null;
	private JTextField txtNumSerie;
	private JTextField txtModeloTM;
	private JTextField txtModeloDiscoDuro;
	private JPanel panelDiscoDuro;
	private JTextField txtCapacidadDiscoDuro;
	private JTextField txtCapacidadMRAM;
	private JPanel panelMemoriaRam;
	private JTextField txtModeloMicroP;
	private JTextField txtVelProcesamiento;
	private JPanel panelTarjetaMadre;
	private JPanel panelMicroProcesador;
	private JRadioButton btnDiscoDuro;
	private JRadioButton btnMemoriaRam;
	private JRadioButton btnTarjetaMadre;
	private JRadioButton btnMicroProcesador;
	private JComboBox cbxTipoRamTM;
	private JComboBox cbxSocketTM;
	private JRadioButton rdbtnIde;
	private JRadioButton rdbtnSata;
	private JRadioButton rdbtnSata2;
	private JRadioButton rdbtnSata3;
	private JComboBox cbxTipoMemoriaRam;
	private JComboBox cbxSocketDiscoDuro;
	private JSpinner spnDispMin;
	private JSpinner spnDispReal;
	private JSpinner spnDispMax;
	private JComboBox cbxSocketMicroP;
	private JLabel lblRegistrar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegProducto dialog = new RegProducto();
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
	public RegProducto() {
		setUndecorated(true);
		setBounds(100, 100, 700, 750);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(36, 37, 38));
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		panelMicroProcesador = new JPanel();
		panelMicroProcesador.setVisible(false);
		
		panelTarjetaMadre = new JPanel();
		panelTarjetaMadre.setVisible(false);
		panelTarjetaMadre.setLayout(null);
		panelTarjetaMadre.setBackground(Color.WHITE);
		panelTarjetaMadre.setBounds(11, 465, 669, 215);
		panel.add(panelTarjetaMadre);
		
		JLabel lblModeloTM = new JLabel("Modelo:");
		lblModeloTM.setForeground(Color.BLACK);
		lblModeloTM.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblModeloTM.setBounds(33, 6, 125, 55);
		panelTarjetaMadre.add(lblModeloTM);
		
		txtModeloTM = new JTextField();
		txtModeloTM.setForeground(new Color(0, 153, 153));
		txtModeloTM.setFont(new Font("Tahoma", Font.PLAIN, 22));
		txtModeloTM.setColumns(10);
		txtModeloTM.setBackground(Color.WHITE);
		txtModeloTM.setBounds(179, 11, 480, 45);
		panelTarjetaMadre.add(txtModeloTM);
		
		JLabel lblSocketTM = new JLabel("Socket:");
		lblSocketTM.setForeground(Color.BLACK);
		lblSocketTM.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblSocketTM.setBounds(33, 60, 112, 55);
		panelTarjetaMadre.add(lblSocketTM);
		
		cbxSocketTM = new JComboBox();
		cbxSocketTM.setFont(new Font("Tahoma", Font.PLAIN, 20));
		cbxSocketTM.setModel(new DefaultComboBoxModel(new String[] {"<Seleccione>", "LGA", "hexLGA", "PGA", "mPGA"}));
		cbxSocketTM.setBounds(179, 65, 480, 45);
		panelTarjetaMadre.add(cbxSocketTM);
		
		JLabel lblTipoRamTM = new JLabel("Tipo de Ram:");
		lblTipoRamTM.setForeground(Color.BLACK);
		lblTipoRamTM.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTipoRamTM.setBounds(33, 115, 138, 55);
		panelTarjetaMadre.add(lblTipoRamTM);
		
		cbxTipoRamTM = new JComboBox();
		cbxTipoRamTM.setModel(new DefaultComboBoxModel(new String[] {"<Seleccione>", "DDR", "DDR-2", "DDR-3", "DDR-4", "SDRAM", "RDRAM"}));
		cbxTipoRamTM.setFont(new Font("Tahoma", Font.PLAIN, 20));
		cbxTipoRamTM.setBounds(179, 120, 480, 45);
		panelTarjetaMadre.add(cbxTipoRamTM);
		
		rdbtnIde = new JRadioButton("IDE");
		rdbtnIde.setForeground(Color.BLACK);
		rdbtnIde.setFont(new Font("Tahoma", Font.PLAIN, 20));
		rdbtnIde.setBounds(48, 180, 94, 25);
		panelTarjetaMadre.add(rdbtnIde);
		
		rdbtnSata = new JRadioButton("SATA");
		rdbtnSata.setForeground(Color.BLACK);
		rdbtnSata.setFont(new Font("Tahoma", Font.PLAIN, 20));
		rdbtnSata.setBounds(190, 180, 102, 25);
		panelTarjetaMadre.add(rdbtnSata);
		
		rdbtnSata2 = new JRadioButton("SATA-2");
		rdbtnSata2.setForeground(Color.BLACK);
		rdbtnSata2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		rdbtnSata2.setBounds(340, 180, 112, 25);
		panelTarjetaMadre.add(rdbtnSata2);
		
		rdbtnSata3 = new JRadioButton("SATA-3");
		rdbtnSata3.setForeground(Color.BLACK);
		rdbtnSata3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		rdbtnSata3.setBounds(500, 180, 119, 25);
		panelTarjetaMadre.add(rdbtnSata3);
		panelMicroProcesador.setLayout(null);
		panelMicroProcesador.setBackground(Color.WHITE);
		panelMicroProcesador.setBounds(11, 465, 669, 215);
		panel.add(panelMicroProcesador);
		
		JLabel lblModeloMicroP = new JLabel("Modelo:");
		lblModeloMicroP.setForeground(Color.BLACK);
		lblModeloMicroP.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblModeloMicroP.setBounds(33, 12, 112, 55);
		panelMicroProcesador.add(lblModeloMicroP);
		
		JLabel lblSocketMicroP = new JLabel("Socket:");
		lblSocketMicroP.setForeground(Color.BLACK);
		lblSocketMicroP.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblSocketMicroP.setBounds(33, 79, 112, 55);
		panelMicroProcesador.add(lblSocketMicroP);
		
		cbxSocketMicroP = new JComboBox();
		cbxSocketMicroP.setModel(new DefaultComboBoxModel(new String[] {"<Seleccione>", "LGA", "hexLGA", "PGA", "mPGA"}));
		cbxSocketMicroP.setFont(new Font("Tahoma", Font.PLAIN, 20));
		cbxSocketMicroP.setBounds(179, 84, 480, 45);
		panelMicroProcesador.add(cbxSocketMicroP);
		
		txtModeloMicroP = new JTextField();
		txtModeloMicroP.setForeground(new Color(0, 153, 153));
		txtModeloMicroP.setFont(new Font("Tahoma", Font.PLAIN, 22));
		txtModeloMicroP.setColumns(10);
		txtModeloMicroP.setBackground(Color.WHITE);
		txtModeloMicroP.setBounds(179, 17, 480, 45);
		panelMicroProcesador.add(txtModeloMicroP);
		
		JLabel lblVelProcesamiento = new JLabel("Velocidad de procesamiento:");
		lblVelProcesamiento.setForeground(Color.BLACK);
		lblVelProcesamiento.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblVelProcesamiento.setBounds(33, 146, 268, 55);
		panelMicroProcesador.add(lblVelProcesamiento);
		
		txtVelProcesamiento = new JTextField();
		txtVelProcesamiento.setForeground(new Color(0, 153, 153));
		txtVelProcesamiento.setFont(new Font("Tahoma", Font.PLAIN, 22));
		txtVelProcesamiento.setColumns(10);
		txtVelProcesamiento.setBackground(Color.WHITE);
		txtVelProcesamiento.setBounds(300, 151, 359, 45);
		panelMicroProcesador.add(txtVelProcesamiento);
		
		panelMemoriaRam = new JPanel();
		panelMemoriaRam.setVisible(false);
		panelMemoriaRam.setLayout(null);
		panelMemoriaRam.setBackground(Color.WHITE);
		panelMemoriaRam.setBounds(11, 465, 669, 215);
		panel.add(panelMemoriaRam);
		
		JLabel lblCapacidadMRam = new JLabel("Capacidad:");
		lblCapacidadMRam.setForeground(Color.BLACK);
		lblCapacidadMRam.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblCapacidadMRam.setBounds(33, 35, 112, 55);
		panelMemoriaRam.add(lblCapacidadMRam);
		
		JLabel lblTipoMemoriaRam = new JLabel("Tipo de Memoria:");
		lblTipoMemoriaRam.setForeground(Color.BLACK);
		lblTipoMemoriaRam.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTipoMemoriaRam.setBounds(33, 125, 165, 55);
		panelMemoriaRam.add(lblTipoMemoriaRam);
		
		cbxTipoMemoriaRam = new JComboBox();
		cbxTipoMemoriaRam.setModel(new DefaultComboBoxModel(new String[] {"<Seleccione>", "DDR", "DDR-2", "DDR-3", "DDR-4", "SDRAM", "RDRAM"}));
		cbxTipoMemoriaRam.setFont(new Font("Tahoma", Font.PLAIN, 20));
		cbxTipoMemoriaRam.setBounds(215, 127, 444, 50);
		panelMemoriaRam.add(cbxTipoMemoriaRam);
		
		txtCapacidadMRAM = new JTextField();
		txtCapacidadMRAM.setForeground(new Color(0, 153, 153));
		txtCapacidadMRAM.setFont(new Font("Tahoma", Font.PLAIN, 22));
		txtCapacidadMRAM.setColumns(10);
		txtCapacidadMRAM.setBackground(Color.WHITE);
		txtCapacidadMRAM.setBounds(215, 37, 444, 50);
		panelMemoriaRam.add(txtCapacidadMRAM);
		
		panelDiscoDuro = new JPanel();
		panelDiscoDuro.setLayout(null);
		panelDiscoDuro.setBackground(Color.WHITE);
		panelDiscoDuro.setBounds(11, 465, 669, 215);
		panel.add(panelDiscoDuro);
		
		JLabel lblModeloDiscoDuro = new JLabel("Modelo:");
		lblModeloDiscoDuro.setForeground(Color.BLACK);
		lblModeloDiscoDuro.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblModeloDiscoDuro.setBounds(33, 12, 125, 55);
		panelDiscoDuro.add(lblModeloDiscoDuro);
		
		txtModeloDiscoDuro = new JTextField();
		txtModeloDiscoDuro.setForeground(new Color(0, 153, 153));
		txtModeloDiscoDuro.setFont(new Font("Tahoma", Font.PLAIN, 22));
		txtModeloDiscoDuro.setColumns(10);
		txtModeloDiscoDuro.setBackground(Color.WHITE);
		txtModeloDiscoDuro.setBounds(190, 16, 469, 50);
		panelDiscoDuro.add(txtModeloDiscoDuro);
		
		JLabel lblCapacidadDiscoDuro = new JLabel("Capacidad:");
		lblCapacidadDiscoDuro.setForeground(Color.BLACK);
		lblCapacidadDiscoDuro.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblCapacidadDiscoDuro.setBounds(33, 79, 112, 55);
		panelDiscoDuro.add(lblCapacidadDiscoDuro);
		
		JLabel lblTipoSocketDiscoDuro = new JLabel("Tipo de Socket:");
		lblTipoSocketDiscoDuro.setForeground(Color.BLACK);
		lblTipoSocketDiscoDuro.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTipoSocketDiscoDuro.setBounds(33, 146, 154, 55);
		panelDiscoDuro.add(lblTipoSocketDiscoDuro);
		
		cbxSocketDiscoDuro = new JComboBox();
		cbxSocketDiscoDuro.setFont(new Font("Tahoma", Font.PLAIN, 20));
		cbxSocketDiscoDuro.setModel(new DefaultComboBoxModel(new String[] {"<Seleccione>", "LGA", "hexLGA", "PGA", "mPGA"}));
		cbxSocketDiscoDuro.setBounds(190, 148, 469, 50);
		panelDiscoDuro.add(cbxSocketDiscoDuro);
		
		txtCapacidadDiscoDuro = new JTextField();
		txtCapacidadDiscoDuro.setForeground(new Color(0, 153, 153));
		txtCapacidadDiscoDuro.setFont(new Font("Tahoma", Font.PLAIN, 22));
		txtCapacidadDiscoDuro.setColumns(10);
		txtCapacidadDiscoDuro.setBackground(Color.WHITE);
		txtCapacidadDiscoDuro.setBounds(190, 82, 469, 50);
		panelDiscoDuro.add(txtCapacidadDiscoDuro);
		
		panelRegistro = new JPanel();
		panelRegistro.setLayout(null);
		panelRegistro.setBackground(Color.WHITE);
		panelRegistro.setBounds(11, 12, 669, 395);
		panel.add(panelRegistro);
		
		txtPrecio = new JTextField();
		txtPrecio.setForeground(new Color(0, 153, 153));
		txtPrecio.setFont(new Font("Tahoma", Font.PLAIN, 22));
		txtPrecio.setColumns(10);
		txtPrecio.setBackground(Color.WHITE);
		txtPrecio.setBounds(192, 210, 467, 45);
		panelRegistro.add(txtPrecio);
		
		txtMarca = new JTextField();
		txtMarca.setForeground(new Color(0, 153, 153));
		txtMarca.setFont(new Font("Tahoma", Font.PLAIN, 22));
		txtMarca.setColumns(10);
		txtMarca.setBackground(Color.WHITE);
		txtMarca.setBounds(192, 147, 467, 45);
		panelRegistro.add(txtMarca);
		
		JLabel lblDispMax = new JLabel("Disp. M\u00E1xima:");
		lblDispMax.setForeground(Color.BLACK);
		lblDispMax.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblDispMax.setBounds(364, 330, 136, 55);
		panelRegistro.add(lblDispMax);
		
		JLabel lblDispMin = new JLabel("Disp. M\u00EDnima:");
		lblDispMin.setForeground(Color.BLACK);
		lblDispMin.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblDispMin.setBounds(33, 330, 162, 55);
		panelRegistro.add(lblDispMin);
		
		JLabel lblCantidad = new JLabel("Cantidad:");
		lblCantidad.setForeground(Color.BLACK);
		lblCantidad.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblCantidad.setBounds(33, 268, 162, 55);
		panelRegistro.add(lblCantidad);
		
		JLabel lblPrecio = new JLabel("Precio:");
		lblPrecio.setForeground(Color.BLACK);
		lblPrecio.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPrecio.setBounds(33, 205, 125, 55);
		panelRegistro.add(lblPrecio);
		
		JLabel lblRegistrarProducto = new JLabel("Registrar Producto:");
		lblRegistrarProducto.setFont(new Font("Tahoma", Font.PLAIN, 35));
		lblRegistrarProducto.setBounds(33, 13, 322, 55);
		panelRegistro.add(lblRegistrarProducto);
		
		JLabel lblNumSerie = new JLabel("Num. De serie:");
		lblNumSerie.setForeground(Color.BLACK);
		lblNumSerie.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNumSerie.setBounds(33, 79, 196, 55);
		panelRegistro.add(lblNumSerie);
		
		txtNumSerie = new JTextField();
		txtNumSerie.setForeground(new Color(0, 153, 153));
		txtNumSerie.setFont(new Font("Tahoma", Font.PLAIN, 22));
		txtNumSerie.setColumns(10);
		txtNumSerie.setBackground(Color.WHITE);
		txtNumSerie.setBounds(192, 84, 467, 45);
		panelRegistro.add(txtNumSerie);
		
		JLabel lblMarca = new JLabel("Marca:");
		lblMarca.setForeground(Color.BLACK);
		lblMarca.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblMarca.setBounds(33, 142, 125, 55);
		panelRegistro.add(lblMarca);
		
		final JLabel lblX = new JLabel("X");
		lblX.setBounds(602, 0, 57, 55);
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
		
		JPanel panel1 = new JPanel();
		panel1.setBackground(new Color(0, 155, 124));
		panel1.setBounds(34, 64, 420, 4);
		panelRegistro.add(panel1);
		
		spnDispMin = new JSpinner();
		spnDispMin.setFont(new Font("Tahoma", Font.PLAIN, 20));
		spnDispMin.setBounds(192, 335, 100, 45);
		panelRegistro.add(spnDispMin);
		
		spnDispMax = new JSpinner();
		spnDispMax.setFont(new Font("Tahoma", Font.PLAIN, 20));
		spnDispMax.setBounds(559, 335, 100, 45);
		panelRegistro.add(spnDispMax);
		
		spnDispReal = new JSpinner();
		spnDispReal.setFont(new Font("Tahoma", Font.PLAIN, 20));
		spnDispReal.setBounds(192, 273, 467, 45);
		panelRegistro.add(spnDispReal);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(11, 415, 669, 42);
		panel.add(panel_2);
		
		btnDiscoDuro = new JRadioButton("Disco Duro");
		btnDiscoDuro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panelDiscoDuro.setVisible(true);
				panelMemoriaRam.setVisible(false);
				panelTarjetaMadre.setVisible(false);
				panelMicroProcesador.setVisible(false);
				
				btnDiscoDuro.setSelected(true);
				btnMemoriaRam.setSelected(false);
				btnTarjetaMadre.setSelected(false);
				btnMicroProcesador.setSelected(false);
			}
		});
		btnDiscoDuro.setSelected(true);
		btnDiscoDuro.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnDiscoDuro.setForeground(new Color(0, 0, 0));
		btnDiscoDuro.setBounds(11, 9, 133, 25);
		panel_2.add(btnDiscoDuro);
		
		btnMemoriaRam = new JRadioButton("Memoria Ram");
		btnMemoriaRam.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelDiscoDuro.setVisible(false);
				panelMemoriaRam.setVisible(true);
				panelTarjetaMadre.setVisible(false);
				panelMicroProcesador.setVisible(false);
				
				btnDiscoDuro.setSelected(false);
				btnMemoriaRam.setSelected(true);
				btnTarjetaMadre.setSelected(false);
				btnMicroProcesador.setSelected(false);
			}
		});
		btnMemoriaRam.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnMemoriaRam.setForeground(new Color(0, 0, 0));
		btnMemoriaRam.setBounds(155, 9, 150, 25);
		panel_2.add(btnMemoriaRam);
		
		btnTarjetaMadre = new JRadioButton("Tarjeta Madre");
		btnTarjetaMadre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panelDiscoDuro.setVisible(false);
				panelMemoriaRam.setVisible(false);
				panelTarjetaMadre.setVisible(true);
				panelMicroProcesador.setVisible(false);
				
				btnDiscoDuro.setSelected(false);
				btnMemoriaRam.setSelected(false);
				btnTarjetaMadre.setSelected(true);
				btnMicroProcesador.setSelected(false);
			}
		});
		btnTarjetaMadre.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnTarjetaMadre.setForeground(new Color(0, 0, 0));
		btnTarjetaMadre.setBounds(316, 9, 151, 25);
		panel_2.add(btnTarjetaMadre);
		
		btnMicroProcesador = new JRadioButton("Micro Procesador");
		btnMicroProcesador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelDiscoDuro.setVisible(false);
				panelMemoriaRam.setVisible(false);
				panelTarjetaMadre.setVisible(false);
				panelMicroProcesador.setVisible(true);
				
				btnDiscoDuro.setSelected(false);
				btnMemoriaRam.setSelected(false);
				btnTarjetaMadre.setSelected(false);
				btnMicroProcesador.setSelected(true);
			}
		});
		btnMicroProcesador.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnMicroProcesador.setForeground(new Color(0, 0, 0));
		btnMicroProcesador.setBounds(478, 9, 176, 25);
		panel_2.add(btnMicroProcesador);
		
		JLabel lblCancelar = new JLabel("Cancelar");
		lblCancelar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblCancelar.setBounds(80, 687, 225, 45);
		panel.add(lblCancelar);
		lblCancelar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
		lblCancelar.setForeground(Color.WHITE);
		lblCancelar.setBackground(new Color(0, 155, 124));
		lblCancelar.setOpaque(true);
		lblCancelar.setHorizontalAlignment(SwingConstants.CENTER);
		lblCancelar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		lblRegistrar = new JLabel("Registrar");
		lblRegistrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Producto aux = null;
				String numSerie = txtNumSerie.getText();
				String marca = txtMarca.getText();
				float precio = new Float(txtPrecio.getText().toString());
				int dispReal = new Integer(spnDispReal.getValue().toString());
				int dispMax = new Integer(spnDispMax.getValue().toString());
				int dispMin = new Integer(spnDispMin.getValue().toString());
				
				if(btnDiscoDuro.isSelected()) {
					String modelo = txtModeloDiscoDuro.getText();
					String socket = cbxSocketDiscoDuro.getSelectedItem().toString();
					int capacidad = new Integer(txtCapacidadDiscoDuro.getText());
					aux = new DiscoDuro(numSerie, dispReal, precio, marca, dispMin, dispMax, modelo, capacidad, socket);
				}
				if(btnMemoriaRam.isSelected()) {
					String tipo = cbxTipoMemoriaRam.getSelectedItem().toString();
					int capacidad = new Integer(txtCapacidadMRAM.getText());
					aux = new MemoriaRam(numSerie, dispReal, precio, marca, dispMin, dispMax, capacidad, tipo);
				}
				if(btnMicroProcesador.isSelected()) {
					String modelo = txtModeloMicroP.getText();
					String socket = cbxSocketMicroP.getSelectedItem().toString();
					float velocidad = new Float(txtVelProcesamiento.getText());
					aux = new MicroProcesador(numSerie, dispReal, precio, marca, dispMin, dispMax, modelo, socket, velocidad);
				}
				if(btnTarjetaMadre.isSelected()) {
					String modelo = txtModeloTM.getText();
					String socket = cbxSocketTM.getSelectedItem().toString();
					String tipoRam = cbxTipoRamTM.getSelectedItem().toString();
					aux= new MotherBoard(numSerie, dispReal, precio, marca, dispMin, dispMax, modelo, socket, tipoRam);
				}
				Tienda.getInstance().addProducto(aux);
				JOptionPane.showMessageDialog(null, "El prodcuto ha sido registrado satisfactoriamente.", "Registro de Producto", JOptionPane.INFORMATION_MESSAGE);
				clean();	
				ListarProducto.loadTableProductos(0);;
				
				/* LOGICA DE MODIFICAR PRODUCTO
				 * if(selected == null){
				 * 
				 * }else{
				 * 
				 * } 
				 */
			}
		});
		lblRegistrar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblRegistrar.setBounds(385, 687, 225, 45);
		panel.add(lblRegistrar);

		lblRegistrar.setOpaque(true);
		lblRegistrar.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegistrar.setForeground(Color.WHITE);
		lblRegistrar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblRegistrar.setBackground(new Color(0, 155, 124));
		
	}
	
	private void clean() {
		txtNumSerie.setText(" ");
		txtMarca.setText(" ");
		txtModeloDiscoDuro.setText(" ");
		txtPrecio.setText(" ");
		txtModeloTM.setText(" ");
		txtModeloMicroP.setText(" ");
		txtModeloDiscoDuro.setText(" ");
		txtCapacidadDiscoDuro.setText(" ");
		txtCapacidadMRAM.setText(" ");
		
		spnDispReal.setValue(0);
		spnDispMax.setValue(0);
		spnDispMin.setValue(0);
		cbxSocketMicroP.setSelectedIndex(0);
		
		cbxSocketTM.setSelectedIndex(0);
		cbxTipoMemoriaRam.setSelectedIndex(0);
		cbxTipoRamTM.setSelectedIndex(0);
		cbxSocketDiscoDuro.setSelectedIndex(0);
		
		rdbtnIde.setSelected(false);
		rdbtnSata.setSelected(false);
		rdbtnSata2.setSelected(false);
		rdbtnSata3.setSelected(false);
	}
}