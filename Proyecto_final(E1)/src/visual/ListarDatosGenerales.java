package visual;

import java.awt.BorderLayout;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

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
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.Font;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.swing.SwingConstants;

public class ListarDatosGenerales extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private static DefaultTableModel modelCombo;
	private static Object[] rows;
	private JLabel lblProductos;
	private JLabel lblVendedores;
	private Combo selectedCombo = null;
	private JLabel lblClientes;
	private JPanel panelCombos;
	private JPanel panelFacturas;
	private JPanel panelVendedores;
	private JPanel panelProductos;
	private JPanel panelClientes;
	private JLabel lblCombos;
	private JLabel lblFacturas;
	private JLabel lblCmbMasComp;
	private JLabel lblCmbMenosComp;
	private JLabel lblFactMasCara;
	private JLabel lblFactMenosCara;
	private JLabel lblCantFactSinPagar;
	private JLabel lblCantFactPagadas;
	private JLabel lblCantIngresos;
	private JLabel lblVendedorMes;
	private JLabel lblVendedorMasFact;
	private JLabel lblVendedorMenosFact;
	private JLabel lblProdMasComprado;
	private JLabel lblProdMenosComprado;
	private JLabel lblClienteDelMes;
	private JLabel lblClienteMasComp;
	private JLabel lblClienteMenosComp;
	private JLabel lblClientMayorDeuda;
	private JLabel lblGrafico;
	private JPanel panelGrafico;
	private JLabel lblGraficoImprimir;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ListarDatosGenerales dialog = new ListarDatosGenerales();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	@SuppressWarnings("unused")
	public ListarDatosGenerales() {
		setUndecorated(true);
		setBounds(100, 100, 1117, 703);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout(0, 0));
		contentPanel.setBackground(Color.white);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		contentPanel.setLayout(null);
		
		String header[] = {"Código", "Nombre", "Precio neto", "Descuento","Precio total", "Cant. De Productos"};
		modelCombo = new DefaultTableModel();
		modelCombo.setColumnIdentifiers(header);
		
		final JLabel label = new JLabel("X");
		label.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				dispose();
			}
		});
		
		panelGrafico = new JPanel();
		panelGrafico.setVisible(false);
		panelGrafico.setBounds(346, 43, 759, 647);
		contentPanel.add(panelGrafico);
		panelGrafico.setLayout(null);
		
		lblGraficoImprimir = new JLabel("");
		lblGraficoImprimir.setBounds(12, 13, 735, 621);
		panelGrafico.add(lblGraficoImprimir);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setForeground(Color.DARK_GRAY);
		label.setFont(new Font("Tahoma", Font.PLAIN, 40));
		label.setBounds(1060, -2, 57, 55);
		contentPanel.add(label);
		
		JPanel panelPrincipal = new JPanel();
		panelPrincipal.setBounds(12, 13, 322, 677);
		panelPrincipal.setBackground(new Color(36, 37, 38));
		contentPanel.add(panelPrincipal);
		panelPrincipal.setLayout(null);
		
		JLabel lblEstadisticas = new JLabel("");
		lblEstadisticas.setHorizontalAlignment(SwingConstants.CENTER);
		lblEstadisticas.setBounds(0, 23, 322, 83);
		panelPrincipal.add(lblEstadisticas);
		lblEstadisticas.setIcon(new ImageIcon(ListarDatosGenerales.class.getResource("/Imagenes/EstadisitcasLabelBlanco.png")));
		
		lblClientes = new JLabel("Clientes");
		lblClientes.setOpaque(true);
		lblClientes.setHorizontalAlignment(SwingConstants.CENTER);
		lblClientes.setBounds(0, 160, 322, 60);
		panelPrincipal.add(lblClientes);
		lblClientes.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				panelClientes.setVisible(true);
				panelProductos.setVisible(false);
				panelVendedores.setVisible(false);
				panelFacturas.setVisible(false);
				panelCombos.setVisible(false);
				panelGrafico.setVisible(false);
				
				lblClientes.setBackground(new Color(0, 155, 124));
				lblProductos.setBackground(new Color(36, 37, 38));
				lblVendedores.setBackground(new Color(36, 37, 38));
				lblFacturas.setBackground(new Color(36, 37, 38));
				lblCombos.setBackground(new Color(36, 37, 38));
				lblGrafico.setBackground(new Color(36, 37, 38));
			}
		});
		lblClientes.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblClientes.setBackground(new Color(0, 155, 124));
		lblClientes.setFont(new Font("Tahoma", Font.PLAIN, 34));
		lblClientes.setForeground(Color.WHITE);
		lblClientes.setIcon(new ImageIcon(ListarDatosGenerales.class.getResource("/Imagenes/ClientesUSer.png")));
		
		lblProductos = new JLabel("productos");
		lblProductos.setOpaque(true);
		lblProductos.setHorizontalAlignment(SwingConstants.CENTER);
		lblProductos.setBounds(0, 225, 322, 60);
		panelPrincipal.add(lblProductos);
		lblProductos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				panelClientes.setVisible(false);
				panelProductos.setVisible(true);
				panelVendedores.setVisible(false);
				panelFacturas.setVisible(false);
				panelCombos.setVisible(false);
				panelGrafico.setVisible(false);
				
				lblClientes.setBackground(new Color(36, 37, 38));
				lblProductos.setBackground(new Color(0, 155, 124));
				lblVendedores.setBackground(new Color(36, 37, 38));
				lblFacturas.setBackground(new Color(36, 37, 38));
				lblCombos.setBackground(new Color(36, 37, 38));
				lblGrafico.setBackground(new Color(36, 37, 38));
			}
		});
		lblProductos.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblProductos.setIcon(new ImageIcon(ListarDatosGenerales.class.getResource("/Imagenes/ProductosIcon.png")));
		lblProductos.setForeground(Color.WHITE);
		lblProductos.setFont(new Font("Tahoma", Font.PLAIN, 34));
		lblProductos.setBackground(new Color(36, 37, 38));
		
		lblVendedores = new JLabel("Vendedores");
		lblVendedores.setOpaque(true);
		lblVendedores.setHorizontalAlignment(SwingConstants.CENTER);
		lblVendedores.setBounds(0, 290, 322, 60);
		panelPrincipal.add(lblVendedores);
		lblVendedores.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				panelClientes.setVisible(false);
				panelProductos.setVisible(false);
				panelVendedores.setVisible(true);
				panelFacturas.setVisible(false);
				panelCombos.setVisible(false);
				panelGrafico.setVisible(false);
				
				lblClientes.setBackground(new Color(36, 37, 38));
				lblProductos.setBackground(new Color(36, 37, 38));
				lblVendedores.setBackground(new Color(0, 155, 124));
				lblFacturas.setBackground(new Color(36, 37, 38));
				lblCombos.setBackground(new Color(36, 37, 38));
				lblGrafico.setBackground(new Color(36, 37, 38));
			}
		});
		lblVendedores.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblVendedores.setIcon(new ImageIcon(ListarDatosGenerales.class.getResource("/Imagenes/VendedoresIcon.png")));
		lblVendedores.setForeground(Color.WHITE);
		lblVendedores.setFont(new Font("Tahoma", Font.PLAIN, 34));
		lblVendedores.setBackground(new Color(36, 37, 38));
		
		JLabel lblCancelar = new JLabel(" Cancelar");
		lblCancelar.setHorizontalAlignment(SwingConstants.CENTER);
		lblCancelar.setBounds(0, 620, 322, 57);
		panelPrincipal.add(lblCancelar);
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
		lblAdministracin.setBounds(88, 80, 144, 64);
		panelPrincipal.add(lblAdministracin);
		
		lblFacturas = new JLabel("Facturas");
		lblFacturas.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblFacturas.setOpaque(true);
		lblFacturas.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				panelClientes.setVisible(false);
				panelProductos.setVisible(false);
				panelVendedores.setVisible(false);
				panelFacturas.setVisible(true);
				panelCombos.setVisible(false);
				panelGrafico.setVisible(false);
				
				lblClientes.setBackground(new Color(36, 37, 38));
				lblProductos.setBackground(new Color(36, 37, 38));
				lblVendedores.setBackground(new Color(36, 37, 38));
				lblFacturas.setBackground(new Color(0, 155, 124));
				lblCombos.setBackground(new Color(36, 35, 38));
				lblGrafico.setBackground(new Color(36, 37, 38));
			}
		});
		lblFacturas.setIcon(new ImageIcon(ListarDatosGenerales.class.getResource("/Imagenes/FacturaIcon.png")));
		lblFacturas.setHorizontalAlignment(SwingConstants.CENTER);
		lblFacturas.setForeground(Color.WHITE);
		lblFacturas.setFont(new Font("Tahoma", Font.PLAIN, 34));
		lblFacturas.setBackground(new Color(36, 37, 38));
		lblFacturas.setBounds(0, 360, 322, 60);
		panelPrincipal.add(lblFacturas);
		
		lblCombos = new JLabel(" Combos");
		lblCombos.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblCombos.setOpaque(true);
		lblCombos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				panelClientes.setVisible(false);
				panelProductos.setVisible(false);
				panelVendedores.setVisible(false);
				panelFacturas.setVisible(false);
				panelCombos.setVisible(true);
				panelGrafico.setVisible(false);
				
				lblClientes.setBackground(new Color(36, 37, 38));
				lblProductos.setBackground(new Color(36, 37, 38));
				lblVendedores.setBackground(new Color(36, 37, 38));
				lblFacturas.setBackground(new Color(36, 35, 38));
				lblCombos.setBackground(new Color(0, 155, 124));
				lblGrafico.setBackground(new Color(36, 37, 38));
			}
		});
		lblCombos.setIcon(new ImageIcon(ListarDatosGenerales.class.getResource("/Imagenes/PedidoIcon.png")));
		lblCombos.setHorizontalAlignment(SwingConstants.CENTER);
		lblCombos.setForeground(Color.WHITE);
		lblCombos.setFont(new Font("Tahoma", Font.PLAIN, 34));
		lblCombos.setBackground(new Color(36, 37, 38));
		lblCombos.setBounds(0, 425, 322, 60);
		panelPrincipal.add(lblCombos);
		
		lblGrafico = new JLabel("Ventas Gr\u00E1fico");
		lblGrafico.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblGrafico.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panelClientes.setVisible(false);
				panelProductos.setVisible(false);
				panelVendedores.setVisible(false);
				panelFacturas.setVisible(false);
				panelCombos.setVisible(false);
				panelGrafico.setVisible(true);
				
				lblClientes.setBackground(new Color(36, 37, 38));
				lblProductos.setBackground(new Color(36, 37, 38));
				lblVendedores.setBackground(new Color(36, 37, 38));
				lblFacturas.setBackground(new Color(36, 35, 38));
				lblCombos.setBackground(new Color(36, 35, 38));
				lblGrafico.setBackground(new Color(0, 155, 124));
				lblGrafico.setBackground(new Color(36, 37, 38));
				
				float dia1 = 0, dia2 = 0, dia3 = 0, dia4 = 0, dia5 = 0;
				Date fechaActual = new Date();
				DefaultCategoryDataset datos = new DefaultCategoryDataset();
				Calendar calendar = Calendar.getInstance();
				calendar.setTime(fechaActual);
				
				for (Factura factura : Tienda.getInstance().getMisFacturas()) {
					if (calendar.getTime().getDay() == factura.getFecha().getDay()) {
						dia5 += factura.getPrecioTotal();
					}
				}
				calendar.setTime(fechaActual);
				calendar.add(Calendar.DAY_OF_MONTH, -1);
				for (Factura factura : Tienda.getInstance().getMisFacturas()) {
					if (calendar.getTime().getDay() == factura.getFecha().getDay()) {
						dia4 += factura.getPrecioTotal();
					}
				}
				calendar.add(Calendar.DAY_OF_MONTH, -1);
				for (Factura factura : Tienda.getInstance().getMisFacturas()) {
					if (calendar.getTime().getDay() == factura.getFecha().getDay()) {
						dia3 += factura.getPrecioTotal();
					}
				}
				calendar.add(Calendar.DAY_OF_MONTH, -1);
				for (Factura factura : Tienda.getInstance().getMisFacturas()) {
					if (calendar.getTime().getDay() == factura.getFecha().getDay()) {
						dia2 += factura.getPrecioTotal();
					}
				}
				calendar.add(Calendar.DAY_OF_MONTH, -1);
				for (Factura factura : Tienda.getInstance().getMisFacturas()) {
					if (calendar.getTime().getDay() == factura.getFecha().getDay()) {
						dia1 += factura.getPrecioTotal();
					}
				}
				
				datos.setValue(dia1, "Total Ventas", calendar.get(Calendar.DAY_OF_MONTH) + " del mes " + (calendar.getTime().getMonth()+1));
				calendar.add(Calendar.DAY_OF_MONTH, 1);
				datos.setValue(dia2, "Total Ventas", calendar.get(Calendar.DAY_OF_MONTH) + " del mes " + (calendar.getTime().getMonth()+1));
				calendar.add(Calendar.DAY_OF_MONTH, 1);
				datos.setValue(dia3, "Total Ventas", calendar.get(Calendar.DAY_OF_MONTH) + " del mes " + (calendar.getTime().getMonth()+1));
				calendar.add(Calendar.DAY_OF_MONTH, 1);
				datos.setValue(dia4, "Total Ventas", calendar.get(Calendar.DAY_OF_MONTH) + " del mes " + (calendar.getTime().getMonth()+1));
				calendar.add(Calendar.DAY_OF_MONTH, 1);
				datos.setValue(dia5, "Total Ventas", calendar.get(Calendar.DAY_OF_MONTH) + " de " + (calendar.getTime().getMonth()+1));
				
				JFreeChart grafico = ChartFactory.createBarChart3D("Ventas de los últimos 5 días", "Total de Ventas de cada día", "Total vendido", datos, PlotOrientation.VERTICAL, true, true, false);
		        BufferedImage image = grafico.createBufferedImage(700,600);
		        lblGraficoImprimir.setIcon(new ImageIcon(image));
			}
		});
		lblGrafico.setIcon(new ImageIcon(ListarDatosGenerales.class.getResource("/Imagenes/EstadisticaIcon.png")));
		lblGrafico.setOpaque(true);
		lblGrafico.setHorizontalAlignment(SwingConstants.CENTER);
		lblGrafico.setForeground(Color.WHITE);
		lblGrafico.setFont(new Font("Tahoma", Font.PLAIN, 34));
		lblGrafico.setBackground(new Color(36, 37, 38));
		lblGrafico.setBounds(0, 480, 322, 60);
		panelPrincipal.add(lblGrafico);
		
		panelCombos = new JPanel();
		panelCombos.setVisible(false);
		panelCombos.setLayout(null);
		panelCombos.setBounds(345, 43, 759, 647);
		contentPanel.add(panelCombos);
		
		JLabel lblComboMasComprado = new JLabel("Combo m\u00E1s vendido:");
		lblComboMasComprado.setFont(new Font("Tahoma", Font.PLAIN, 35));
		lblComboMasComprado.setBounds(12, 13, 458, 69);
		panelCombos.add(lblComboMasComprado);
		
		String comboMasVendido = Tienda.getInstance().comboMasVendido();
		if (comboMasVendido == null) {
			comboMasVendido = "Aún no hay";
		}
		
		lblCmbMasComp = new JLabel(comboMasVendido);
		lblCmbMasComp.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblCmbMasComp.setBounds(13, 80, 565, 57);
		panelCombos.add(lblCmbMasComp);
	
		
		JPanel panel1 = new JPanel();
		panel1.setBackground(new Color(0, 155, 124));
		panel1.setBounds(13, 137, 445, 4);
		panelCombos.add(panel1);
		
		JLabel lblComboMenosComprado = new JLabel("Combo menos vendido:");
		lblComboMenosComprado.setFont(new Font("Tahoma", Font.PLAIN, 35));
		lblComboMenosComprado.setBounds(7, 157, 637, 69);
		panelCombos.add(lblComboMenosComprado);
		
		String comboMenosVendido = Tienda.getInstance().comboMenosVendido();
		if (comboMenosVendido == null) {
			comboMenosVendido = "Aún no hay";
		}
		lblCmbMenosComp = new JLabel(comboMenosVendido);
		lblCmbMenosComp.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblCmbMenosComp.setBounds(13, 225, 565, 57);
		panelCombos.add(lblCmbMenosComp);
		
		JPanel panel2 = new JPanel();
		panel2.setBackground(new Color(0, 155, 124));
		panel2.setBounds(13, 281, 445, 4);
		panelCombos.add(panel2);
		
		panelFacturas = new JPanel();
		panelFacturas.setVisible(false);
		panelFacturas.setLayout(null);
		panelFacturas.setBounds(346, 43, 759, 647);
		contentPanel.add(panelFacturas);
		
		JLabel lblFacturaMasCara = new JLabel("Factura m\u00E1s cara:");
		lblFacturaMasCara.setFont(new Font("Tahoma", Font.PLAIN, 35));
		lblFacturaMasCara.setBounds(12, 13, 458, 69);
		panelFacturas.add(lblFacturaMasCara);
		
		Factura facturaAux = Tienda.getInstance().facturaMasCara();
		String facturaMasCara = null;
		if (facturaAux != null) {
			facturaMasCara = new String(facturaAux.getCodigo() + " - " + facturaAux.getPrecioTotal());
		}else {
			facturaMasCara = "Aún no hay";
		}
		lblFactMasCara = new JLabel(facturaMasCara);
		lblFactMasCara.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblFactMasCara.setBounds(13, 80, 565, 57);
		panelFacturas.add(lblFactMasCara);
		
		JPanel panel3 = new JPanel();
		panel3.setBackground(new Color(0, 155, 124));
		panel3.setBounds(13, 137, 445, 4);
		panelFacturas.add(panel3);
		
		JLabel lblFacturaMenosCara = new JLabel("Factura menos cara:");
		lblFacturaMenosCara.setFont(new Font("Tahoma", Font.PLAIN, 35));
		lblFacturaMenosCara.setBounds(7, 157, 637, 69);
		panelFacturas.add(lblFacturaMenosCara);
		
		Factura facturaAux2 = Tienda.getInstance().facturaMenosCara();
		String facturaMenosCara = null;
		if (facturaAux2 != null) {
			facturaMenosCara = new String(facturaAux2.getCodigo() + " - " + facturaAux2.getPrecioTotal());
		}else {
			facturaMenosCara = "Aún no hay";
		}
		lblFactMenosCara = new JLabel(facturaMenosCara);
		lblFactMenosCara.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblFactMenosCara.setBounds(8, 225, 565, 57);
		panelFacturas.add(lblFactMenosCara);
		
		JPanel panel4 = new JPanel();
		panel4.setBackground(new Color(0, 155, 124));
		panel4.setBounds(13, 281, 445, 4);
		panelFacturas.add(panel4);
		
		JLabel lblFacturasSinPagar = new JLabel("Facturas adeudadas:");
		lblFacturasSinPagar.setFont(new Font("Tahoma", Font.PLAIN, 35));
		lblFacturasSinPagar.setBounds(7, 298, 320, 69);
		panelFacturas.add(lblFacturasSinPagar);
		
		String facturasAdeudadas = Integer.toString(Tienda.getInstance().cantFacturasAdeudadas());
		lblCantFactSinPagar = new JLabel(facturasAdeudadas);
		lblCantFactSinPagar.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblCantFactSinPagar.setBounds(8, 360, 307, 57);
		panelFacturas.add(lblCantFactSinPagar);
		
		JPanel panel5 = new JPanel();
		panel5.setBackground(new Color(0, 155, 124));
		panel5.setBounds(13, 422, 313, 4);
		panelFacturas.add(panel5);
		
		JLabel lblFacturasPagadas = new JLabel("Facturas pagadas:");
		lblFacturasPagadas.setFont(new Font("Tahoma", Font.PLAIN, 35));
		lblFacturasPagadas.setBounds(379, 298, 307, 69);
		panelFacturas.add(lblFacturasPagadas);
		
		String facturasPagadas = Integer.toString(Tienda.getInstance().cantFacturasPagadas());
		lblCantFactPagadas = new JLabel(facturasPagadas);
		lblCantFactPagadas.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblCantFactPagadas.setBounds(379, 365, 245, 57);
		panelFacturas.add(lblCantFactPagadas);
		
		JPanel panel6 = new JPanel();
		panel6.setBackground(new Color(0, 155, 124));
		panel6.setBounds(379, 422, 313, 4);
		panelFacturas.add(panel6);
		
		JLabel lblTotalIngresos = new JLabel("Total vendido:");
		lblTotalIngresos.setFont(new Font("Tahoma", Font.PLAIN, 35));
		lblTotalIngresos.setBounds(12, 439, 637, 69);
		panelFacturas.add(lblTotalIngresos);
		
		String totalVendido = new String("RD$ " + Float.toString(Tienda.getInstance().totalVendido()));
		lblCantIngresos = new JLabel(totalVendido);
		lblCantIngresos.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblCantIngresos.setBounds(13, 505, 565, 57);
		panelFacturas.add(lblCantIngresos);
		
		JPanel panel7 = new JPanel();
		panel7.setBackground(new Color(0, 155, 124));
		panel7.setBounds(13, 563, 445, 4);
		panelFacturas.add(panel7);
		
		Vendedor vendedorAux = Tienda.getInstance().vendedorConMasFacturas();
		String vendedorConMasFacturas = null;
		if (vendedorAux != null) {
			vendedorConMasFacturas = new String(vendedorAux.getNombre() + " - " + vendedorAux.getCedula());
		}else {
			vendedorConMasFacturas = "";
		}
		
		panelProductos = new JPanel();
		panelProductos.setVisible(false);
		panelProductos.setLayout(null);
		panelProductos.setBounds(346, 43, 759, 647);
		contentPanel.add(panelProductos);
		
		JLabel lblProductoMasComprado = new JLabel("Producto m\u00E1s comprado:");
		lblProductoMasComprado.setFont(new Font("Tahoma", Font.PLAIN, 35));
		lblProductoMasComprado.setBounds(12, 13, 458, 69);
		panelProductos.add(lblProductoMasComprado);
		
		String productoMasComprado = Tienda.getInstance().productoMasComprado();
		if (productoMasComprado == null) {
			productoMasComprado = "Aún no hay";
		}
		lblProdMasComprado = new JLabel(productoMasComprado);
		lblProdMasComprado.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblProdMasComprado.setBounds(13, 80, 565, 57);
		panelProductos.add(lblProdMasComprado);
		
		JPanel panel11 = new JPanel();
		panel11.setBackground(new Color(0, 155, 124));
		panel11.setBounds(13, 137, 445, 4);
		panelProductos.add(panel11);
		
		JLabel lblProductoMenosComprado = new JLabel("Producto menos comprado:");
		lblProductoMenosComprado.setFont(new Font("Tahoma", Font.PLAIN, 35));
		lblProductoMenosComprado.setBounds(7, 157, 637, 69);
		panelProductos.add(lblProductoMenosComprado);
		
		String productoMenosComprado = Tienda.getInstance().productoMenosComprado();
		if (productoMenosComprado == null) {
			productoMenosComprado = "Aún no hay";
		}
		lblProdMenosComprado = new JLabel(productoMenosComprado);
		lblProdMenosComprado.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblProdMenosComprado.setBounds(8, 225, 565, 57);
		panelProductos.add(lblProdMenosComprado);
		
		JPanel panel12 = new JPanel();
		panel12.setBackground(new Color(0, 155, 124));
		panel12.setBounds(13, 281, 445, 4);
		panelProductos.add(panel12);
		
		panelClientes = new JPanel();
		panelClientes.setBounds(346, 43, 759, 647);
		contentPanel.add(panelClientes);
		panelClientes.setLayout(null);
		
		JLabel lblClienteMes = new JLabel("Cliente del mes:");
		lblClienteMes.setFont(new Font("Tahoma", Font.PLAIN, 35));
		lblClienteMes.setBounds(12, 13, 315, 69);
		panelClientes.add(lblClienteMes);
		
		lblClienteDelMes = new JLabel("");
		if (Tienda.getInstance().clienteDelMes() == null) {
			lblClienteDelMes.setText("Aún no hay");
		}
		else {
			lblClienteDelMes.setText(Tienda.getInstance().clienteDelMes().getNombre() + " | " + Tienda.getInstance().clienteDelMes().getCedula());
		}
		lblClienteDelMes.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblClienteDelMes.setBounds(13, 80, 565, 57);
		panelClientes.add(lblClienteDelMes);
		
		JPanel panel13 = new JPanel();
		panel13.setBackground(new Color(0, 155, 124));
		panel13.setBounds(13, 137, 445, 4);
		panelClientes.add(panel13);
		
		JLabel lblClienteMasCompras = new JLabel("Cliente con m\u00E1s Compras realizadas:");
		lblClienteMasCompras.setFont(new Font("Tahoma", Font.PLAIN, 35));
		lblClienteMasCompras.setBounds(7, 157, 637, 69);
		panelClientes.add(lblClienteMasCompras);
		
		Cliente clienteMasCompra = Tienda.getInstance().getClienteMasCompras();
		String nombreCliente = null;
		if (clienteMasCompra != null) {
			nombreCliente = new String(clienteMasCompra.getNombre() + " - " + clienteMasCompra.getCedula() + " - " + clienteMasCompra.getCantCompras());
		}else {
			nombreCliente = "Aún no hay";
		}
		lblClienteMasComp = new JLabel(nombreCliente);
		lblClienteMasComp.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblClienteMasComp.setBounds(8, 225, 565, 57);
		panelClientes.add(lblClienteMasComp);
		
		JPanel panel14 = new JPanel();
		panel14.setBackground(new Color(0, 155, 124));
		panel14.setBounds(8, 281, 445, 4);
		panelClientes.add(panel14);
		
		JLabel lblClienteMenosCompras = new JLabel("Cliente con menos compras Realizadas:");
		lblClienteMenosCompras.setFont(new Font("Tahoma", Font.PLAIN, 35));
		lblClienteMenosCompras.setBounds(12, 298, 637, 69);
		panelClientes.add(lblClienteMenosCompras);
		
		Cliente clienteMenosCompra = Tienda.getInstance().getClienteMenosCompras();
		String nombreCliente2 = null;
		if (clienteMenosCompra != null) {
			nombreCliente2 = new String(clienteMenosCompra.getNombre() + " - " + clienteMenosCompra.getCedula() + " - " + clienteMenosCompra.getCantCompras());
		}else {
			nombreCliente2 = "Aún no hay";
		}
		lblClienteMenosComp = new JLabel(nombreCliente2);
		lblClienteMenosComp.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblClienteMenosComp.setBounds(13, 365, 588, 57);
		panelClientes.add(lblClienteMenosComp);
		
		JPanel panel15 = new JPanel();
		panel15.setBackground(new Color(0, 155, 124));
		panel15.setBounds(13, 422, 445, 4);
		panelClientes.add(panel15);
		
		JLabel lblClienteMayorDeuda = new JLabel("Cliente con mayor deuda:");
		lblClienteMayorDeuda.setFont(new Font("Tahoma", Font.PLAIN, 35));
		lblClienteMayorDeuda.setBounds(12, 439, 637, 69);
		panelClientes.add(lblClienteMayorDeuda);
		
		Cliente clienteMayorDeuda = Tienda.getInstance().getClienteMayorDeuda();
		String clienteMasDeuda = null;
		if (clienteMayorDeuda != null) {
			clienteMasDeuda = new String(clienteMayorDeuda.getNombre() + " - " + clienteMayorDeuda.getCedula());
		}else {
			clienteMasDeuda = "Aún no hay";
		}
		lblClientMayorDeuda = new JLabel(clienteMasDeuda);
		lblClientMayorDeuda.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblClientMayorDeuda.setBounds(13, 505, 416, 57);
		panelClientes.add(lblClientMayorDeuda);
		
		JPanel panel16 = new JPanel();
		panel16.setBackground(new Color(0, 155, 124));
		panel16.setBounds(13, 563, 445, 4);
		panelClientes.add(panel16);
		
		panelVendedores = new JPanel();
		panelVendedores.setVisible(false);
		panelVendedores.setLayout(null);
		panelVendedores.setBounds(346, 43, 759, 647);
		contentPanel.add(panelVendedores);
		
		JLabel lblVendedorDelMes = new JLabel("Vendedor del mes");
		lblVendedorDelMes.setFont(new Font("Tahoma", Font.PLAIN, 35));
		lblVendedorDelMes.setBounds(12, 13, 458, 69);
		panelVendedores.add(lblVendedorDelMes);
		
		lblVendedorMes = new JLabel("");
		if (Tienda.getInstance().vendedorDelMes() == null) {
			lblVendedorMes.setText("Aún no hay");
		}
		else {
			lblVendedorMes.setText(Tienda.getInstance().vendedorDelMes().getNombre() + "!" + " | " + Tienda.getInstance().vendedorDelMes().getCedula());
		}
		lblVendedorMes.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblVendedorMes.setBounds(13, 80, 565, 57);
		panelVendedores.add(lblVendedorMes);
		
		JPanel panel8 = new JPanel();
		panel8.setBackground(new Color(0, 155, 124));
		panel8.setBounds(13, 137, 445, 4);
		panelVendedores.add(panel8);
		
		JLabel lblVendedorMasFacturas = new JLabel("Vendedor con m\u00E1s facturas realizadas:");
		lblVendedorMasFacturas.setFont(new Font("Tahoma", Font.PLAIN, 35));
		lblVendedorMasFacturas.setBounds(7, 157, 637, 69);
		panelVendedores.add(lblVendedorMasFacturas);
		lblVendedorMasFact = new JLabel(vendedorConMasFacturas);
		lblVendedorMasFact.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblVendedorMasFact.setBounds(8, 225, 565, 57);
		panelVendedores.add(lblVendedorMasFact);
		
		JPanel panel9 = new JPanel();
		panel9.setBackground(new Color(0, 155, 124));
		panel9.setBounds(8, 281, 445, 4);
		panelVendedores.add(panel9);
		
		Vendedor vendedorAux2 = Tienda.getInstance().vendedorConMenosFacturas();
		String vendedorConMenosFacturas = null;
		if (vendedorAux2 != null) {
			vendedorConMenosFacturas = new String(vendedorAux2.getNombre() + " - " + vendedorAux2.getCedula());
		}else {
			vendedorConMenosFacturas = "Aún no hay";
		}
		JLabel lblVendedorMenosFacturas = new JLabel("Vendedor con menos facturas realizadas:");
		lblVendedorMenosFacturas.setFont(new Font("Tahoma", Font.PLAIN, 35));
		lblVendedorMenosFacturas.setBounds(7, 298, 657, 69);
		panelVendedores.add(lblVendedorMenosFacturas);
		lblVendedorMenosFact = new JLabel(vendedorConMenosFacturas);
		lblVendedorMenosFact.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblVendedorMenosFact.setBounds(8, 370, 565, 57);
		panelVendedores.add(lblVendedorMenosFact);
		
		JPanel panel10 = new JPanel();
		panel10.setBackground(new Color(0, 155, 124));
		panel10.setBounds(8, 422, 445, 4);
		panelVendedores.add(panel10);
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
