package visual;

import java.awt.BorderLayout;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import logico.Factura;
import logico.Producto;
import logico.Tienda;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.SwingConstants;
import javax.swing.UIManager;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.Image;

@SuppressWarnings("serial")
public class FacturaDetalles extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private static DefaultTableModel model;
	private static Object[] rows;
	int indexCbx = 0;
	private Color colorVerde = new Color(0, 155, 124);
	private JTable table;
	private Factura selectedFactura;
	private JLabel lblAbonar;
	private JLabel lblMontoAbonar;
	private JPanel panelFactura;
	private JLabel lblTitle;
	private JLabel lblImprimir;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			FacturaDetalles dialog = new FacturaDetalles(null);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public FacturaDetalles(Factura factura) {
		selectedFactura = factura;
		setUndecorated(true);
		setBounds(100, 100, 780, 630);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout(0, 0));
		contentPanel.setBackground(Color.white);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		contentPanel.setLayout(null);
		
		String headerFactura[] = {"Num", "Marca", "Categoría", "cant", "Precio", "Total"};
		model = new DefaultTableModel();
		model.setColumnIdentifiers(headerFactura);
		
		panelFactura = new JPanel();
		panelFactura.setBackground(UIManager.getColor("Button.background"));
		panelFactura.setBounds(12, 46, 756, 571);
		contentPanel.add(panelFactura);
		panelFactura.setLayout(null);
		
		lblAbonar = new JLabel("Abonar");
		lblAbonar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				float monto = Float.parseFloat(JOptionPane.showInputDialog(null, "Ingrese el monto a abonar", "Abonar Linea de Crédito", JOptionPane.DEFAULT_OPTION));
				boolean esPosible = Tienda.getInstance().abonarFacturaCredito(selectedFactura.getCodigo(), monto);
				if (esPosible) {
					lblMontoAbonar.setText(""+selectedFactura.getLineaCredito());
					JOptionPane.showMessageDialog(null, "El monto ingresado ha sido abonado correctamente.");
				}
				else {
					JOptionPane.showMessageDialog(null, "El monto ingresado no pudo ser abonado. Revise el monto introducido", "Error", JOptionPane.ERROR_MESSAGE);
				}
				Home.loadTableFactura(0, null);
			}
			
		});
		
		lblImprimir = new JLabel("");
		lblImprimir.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblImprimir.setIcon(new ImageIcon(FacturaDetalles.class.getResource("/Imagenes/pdfIcon.png")));
		lblImprimir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblImprimir.setVisible(false);
				
				try {
					   ImageIO.write(createImage(panelFactura), "png", new File("src/Facturas/factura"+selectedFactura.getMiCliente().getCedula()+".png"));
					} catch (IOException eio) {
					   System.out.println("Error de escritura");
					}
								
				Document documento = new Document();
				try {
					PdfWriter.getInstance(documento, new FileOutputStream("src/Facturas/factura"+selectedFactura.getMiCliente().getCedula()+".pdf"));
					Image imagen = Image.getInstance("src/Facturas/factura"+selectedFactura.getMiCliente().getCedula()+".png");
					documento.open();
					imagen.scaleToFit(500, 1000);
					imagen.setAlignment(Chunk.ALIGN_CENTER);
					
					Paragraph parrafo = new Paragraph();
					parrafo.setAlignment(Paragraph.ALIGN_JUSTIFIED);
					parrafo.add("\n\n");
					documento.add(parrafo);
					documento.add(imagen);
					Paragraph parrafo2 = new Paragraph();
					parrafo2.setAlignment(Paragraph.ALIGN_JUSTIFIED);
					parrafo2.add("\n\nGracias Por preferirnos Tecno C\n\n");
					parrafo2.setFont(FontFactory.getFont("Tahoma", 18, Font.BOLD, BaseColor.DARK_GRAY));
					documento.add(parrafo2);
					documento.close();
				} catch (Exception i) {
					
				}
				lblImprimir.setVisible(true);
				
				try {
				     File path = new File ("src/Facturas/factura"+selectedFactura.getMiCliente().getCedula()+".pdf");
				     Desktop.getDesktop().open(path);
				}catch (IOException ex) {
				     ex.printStackTrace();
				}
			}
		});
		lblImprimir.setOpaque(true);
		lblImprimir.setHorizontalAlignment(SwingConstants.CENTER);
		lblImprimir.setForeground(Color.WHITE);
		lblImprimir.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblImprimir.setBounds(465, 9, 79, 51);
		lblImprimir.setBackground(new Color(0, 155, 124));
		panelFactura.add(lblImprimir);
		
		lblAbonar.setHorizontalAlignment(SwingConstants.CENTER);
		lblAbonar.setForeground(Color.WHITE);
		lblAbonar.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblAbonar.setBounds(510, 507, 234, 51);
		panelFactura.add(lblAbonar);
		
		JLabel label_15 = new JLabel("");
		label_15.setOpaque(true);
		label_15.setForeground(new Color(0, 155, 124));
		label_15.setFont(new Font("Tahoma", Font.BOLD, 40));
		label_15.setBackground(new Color(0, 155, 124));
		label_15.setBounds(510, 507, 234, 51);
		panelFactura.add(label_15);
		
		JLabel lblMonto = new JLabel("" + selectedFactura.getMisProductos().size());
		lblMonto.setForeground(Color.BLACK);
		lblMonto.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblMonto.setBounds(525, 308, 219, 28);
		panelFactura.add(lblMonto);
		
		JLabel lblPrecioTotal = new JLabel("Cantidad");
		lblPrecioTotal.setForeground(Color.WHITE);
		lblPrecioTotal.setFont(new Font("Tahoma", Font.BOLD, 21));
		lblPrecioTotal.setBounds(516, 270, 187, 28);
		panelFactura.add(lblPrecioTotal);
		
		JLabel lblProductos = new JLabel("Productos");
		lblProductos.setForeground(Color.WHITE);
		lblProductos.setFont(new Font("Tahoma", Font.BOLD, 21));
		lblProductos.setBounds(22, 270, 187, 28);
		panelFactura.add(lblProductos);
		
		JLabel lbldireccionCliente = new JLabel(selectedFactura.getMiCliente().getDireccion());
		lbldireccionCliente.setForeground(Color.BLACK);
		lbldireccionCliente.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lbldireccionCliente.setBounds(22, 195, 206, 28);
		panelFactura.add(lbldireccionCliente);
		
		JLabel lbltelefonoCliente = new JLabel(selectedFactura.getMiCliente().getTelefono());
		lbltelefonoCliente.setForeground(Color.BLACK);
		lbltelefonoCliente.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lbltelefonoCliente.setBounds(22, 162, 206, 28);
		panelFactura.add(lbltelefonoCliente);
		
		JLabel lblFacturarA = new JLabel("Facturar a");
		lblFacturarA.setForeground(Color.WHITE);
		lblFacturarA.setFont(new Font("Tahoma", Font.BOLD, 21));
		lblFacturarA.setBounds(23, 75, 187, 28);
		panelFactura.add(lblFacturarA);
		
		JLabel lblFecha = new JLabel("Fecha");
		lblFecha.setForeground(Color.WHITE);
		lblFecha.setFont(new Font("Tahoma", Font.BOLD, 21));
		lblFecha.setBounds(567, 75, 187, 28);
		panelFactura.add(lblFecha);
		
		JLabel lblFactura = new JLabel("Factura#");
		lblFactura.setForeground(Color.WHITE);
		lblFactura.setFont(new Font("Tahoma", Font.BOLD, 21));
		lblFactura.setBounds(304, 75, 187, 28);
		panelFactura.add(lblFactura);
		
		lblTitle = new JLabel("FACTURA");
		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 40));
		lblTitle.setForeground(colorVerde);
		lblTitle.setBounds(556, 13, 198, 39);
		panelFactura.add(lblTitle);
		
		JLabel label_1 = new JLabel("");
		label_1.setOpaque(true);
		label_1.setForeground(new Color(0, 155, 124));
		label_1.setBackground(colorVerde);
		label_1.setFont(new Font("Tahoma", Font.BOLD, 40));
		label_1.setBounds(289, 75, 455, 28);
		panelFactura.add(label_1);
		
		JLabel lblDato = new JLabel(selectedFactura.getCodigo());
		lblDato.setForeground(Color.BLACK);
		lblDato.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblDato.setBounds(299, 121, 249, 28);
		panelFactura.add(lblDato);
		
		JLabel lblFecha_1 = new JLabel(new SimpleDateFormat("dd-MM-yyyy").format(selectedFactura.getFecha()));
		lblFecha_1.setForeground(Color.BLACK);
		lblFecha_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblFecha_1.setBounds(557, 121, 187, 28);
		panelFactura.add(lblFecha_1);
		
		JLabel lblCliente = new JLabel("Vendedor");
		lblCliente.setForeground(Color.WHITE);
		lblCliente.setFont(new Font("Tahoma", Font.BOLD, 21));
		lblCliente.setBounds(304, 162, 187, 28);
		panelFactura.add(lblCliente);
		
		JLabel lblTipoDeFactura = new JLabel("Tipo de Factura");
		lblTipoDeFactura.setForeground(Color.WHITE);
		lblTipoDeFactura.setFont(new Font("Tahoma", Font.BOLD, 21));
		lblTipoDeFactura.setBounds(544, 162, 187, 28);
		panelFactura.add(lblTipoDeFactura);
		
		JLabel label_3 = new JLabel("");
		label_3.setOpaque(true);
		label_3.setForeground(new Color(0, 155, 124));
		label_3.setFont(new Font("Tahoma", Font.BOLD, 40));
		label_3.setBackground(new Color(0, 155, 124));
		label_3.setBounds(289, 162, 455, 28);
		panelFactura.add(label_3);
		
		String auxString = "";
		if (selectedFactura.isACredito()) {
			auxString = "A crédito";
		}else {
			auxString = "Sin crédito";
		}
		JLabel lblCreditoONo = new JLabel(auxString);
		lblCreditoONo.setForeground(Color.BLACK);
		lblCreditoONo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblCreditoONo.setBounds(557, 209, 187, 28);
		panelFactura.add(lblCreditoONo);
		
		JLabel lblCedula = new JLabel(selectedFactura.getMiVendedor().getNombre());
		lblCedula.setForeground(Color.BLACK);
		lblCedula.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblCedula.setBounds(304, 209, 239, 28);
		panelFactura.add(lblCedula);
		
		JLabel label_4 = new JLabel("");
		label_4.setOpaque(true);
		label_4.setBackground(Color.WHITE);
		label_4.setForeground(Color.BLACK);
		label_4.setFont(new Font("Tahoma", Font.BOLD, 23));
		label_4.setBounds(289, 116, 455, 39);
		panelFactura.add(label_4);
		
		JLabel label_5 = new JLabel("");
		label_5.setOpaque(true);
		label_5.setForeground(Color.BLACK);
		label_5.setFont(new Font("Tahoma", Font.BOLD, 23));
		label_5.setBackground(Color.WHITE);
		label_5.setBounds(289, 203, 455, 39);
		panelFactura.add(label_5);
		
		JLabel label_8 = new JLabel("");
		label_8.setOpaque(true);
		label_8.setForeground(new Color(0, 155, 124));
		label_8.setFont(new Font("Tahoma", Font.BOLD, 40));
		label_8.setBackground(new Color(0, 155, 124));
		label_8.setBounds(12, 75, 234, 28);
		panelFactura.add(label_8);
		
		JLabel lblnombreCliente = new JLabel(selectedFactura.getMiCliente().getNombre());
		lblnombreCliente.setForeground(Color.BLACK);
		lblnombreCliente.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblnombreCliente.setBounds(22, 121, 206, 28);
		panelFactura.add(lblnombreCliente);
		
		JLabel label_13 = new JLabel("");
		label_13.setOpaque(true);
		label_13.setForeground(Color.BLACK);
		label_13.setFont(new Font("Tahoma", Font.BOLD, 23));
		label_13.setBackground(Color.WHITE);
		label_13.setBounds(12, 116, 234, 126);
		panelFactura.add(label_13);
		
		JLabel label_2 = new JLabel("");
		label_2.setOpaque(true);
		label_2.setForeground(new Color(0, 155, 124));
		label_2.setFont(new Font("Tahoma", Font.BOLD, 40));
		label_2.setBackground(new Color(0, 155, 124));
		label_2.setBounds(12, 270, 479, 28);
		panelFactura.add(label_2);
		
		JLabel label_7 = new JLabel("");
		label_7.setOpaque(true);
		label_7.setForeground(new Color(0, 155, 124));
		label_7.setFont(new Font("Tahoma", Font.BOLD, 40));
		label_7.setBackground(new Color(0, 155, 124));
		label_7.setBounds(510, 270, 234, 28);
		panelFactura.add(label_7);
		
		JLabel label_9 = new JLabel("");
		label_9.setOpaque(true);
		label_9.setForeground(Color.BLACK);
		label_9.setFont(new Font("Tahoma", Font.BOLD, 23));
		label_9.setBackground(Color.WHITE);
		label_9.setBounds(510, 303, 234, 38);
		panelFactura.add(label_9);
		
		JLabel label_10 = new JLabel("Precio total");
		label_10.setForeground(Color.WHITE);
		label_10.setFont(new Font("Tahoma", Font.BOLD, 21));
		label_10.setBounds(516, 347, 187, 28);
		panelFactura.add(label_10);
		
		JLabel label_11 = new JLabel("");
		label_11.setOpaque(true);
		label_11.setForeground(new Color(0, 155, 124));
		label_11.setFont(new Font("Tahoma", Font.BOLD, 40));
		label_11.setBackground(new Color(0, 155, 124));
		label_11.setBounds(510, 347, 234, 28);
		panelFactura.add(label_11);
		
		JLabel label_12 = new JLabel("" + selectedFactura.getPrecioTotal());
		label_12.setForeground(Color.BLACK);
		label_12.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label_12.setBounds(525, 386, 219, 28);
		panelFactura.add(label_12);
		
		JLabel label_14 = new JLabel("");
		label_14.setOpaque(true);
		label_14.setForeground(Color.BLACK);
		label_14.setFont(new Font("Tahoma", Font.BOLD, 23));
		label_14.setBackground(Color.WHITE);
		label_14.setBounds(510, 381, 234, 38);
		panelFactura.add(label_14);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 303, 479, 255);
		panelFactura.add(scrollPane);
		
		table = new JTable();
		table.setModel(model);
		table.setBackground(Color.WHITE);
		scrollPane.setViewportView(table);
		
		lblMontoAbonar = new JLabel(""+selectedFactura.getLineaCredito());
		lblMontoAbonar.setForeground(Color.BLACK);
		lblMontoAbonar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblMontoAbonar.setBounds(525, 466, 219, 28);
		panelFactura.add(lblMontoAbonar);
		
		JLabel label_16 = new JLabel("");
		label_16.setOpaque(true);
		label_16.setForeground(Color.BLACK);
		label_16.setFont(new Font("Tahoma", Font.BOLD, 23));
		label_16.setBackground(Color.WHITE);
		label_16.setBounds(510, 461, 234, 38);
		panelFactura.add(label_16);
		
		JLabel lblLineaDeCredito = new JLabel("Linea de Credito");
		lblLineaDeCredito.setForeground(Color.WHITE);
		lblLineaDeCredito.setFont(new Font("Tahoma", Font.BOLD, 21));
		lblLineaDeCredito.setBounds(516, 427, 187, 28);
		panelFactura.add(lblLineaDeCredito);
		
		JLabel label_18 = new JLabel("");
		label_18.setOpaque(true);
		label_18.setForeground(new Color(0, 155, 124));
		label_18.setFont(new Font("Tahoma", Font.BOLD, 40));
		label_18.setBackground(new Color(0, 155, 124));
		label_18.setBounds(510, 427, 234, 28);
		panelFactura.add(label_18);
		
		JLabel lblTecno = new JLabel("Tecno");
		lblTecno.setForeground(Color.DARK_GRAY);
		lblTecno.setFont(new Font("Tahoma", Font.BOLD, 40));
		lblTecno.setBounds(12, 13, 121, 39);
		panelFactura.add(lblTecno);
		
		JLabel lblC = new JLabel("C");
		lblC.setForeground(new Color(0, 155, 124));
		lblC.setFont(new Font("Tahoma", Font.ITALIC, 50));
		lblC.setBounds(138, 7, 59, 51);
		panelFactura.add(lblC);
		scrollPane.getViewport().setBackground(Color.white);
		
		final JLabel label = new JLabel("X");
		label.setBounds(745, 0, 23, 49);
		contentPanel.add(label);
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
		
		if (selectedFactura.isACredito()) {
			lblAbonar.setEnabled(true);
		}
		else {
			lblAbonar.setEnabled(false);
		}
		loadTableFactura(selectedFactura);
	}
	
	public BufferedImage createImage(JPanel panel) {

	    int w = panel.getWidth();
	    int h = panel.getHeight();
	    BufferedImage bi = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
	    Graphics2D g = bi.createGraphics();
	    panel.paint(g);
	    g.dispose();
	    return bi;
	}
	
	public static void loadTableFactura(Factura selectedFactura) {
		
		model.setRowCount(0);
		rows = new Object[model.getColumnCount()];
		int cant;
		
		ArrayList<Producto> productosSinRepetir = new ArrayList<Producto>();
		ArrayList<Producto> productos = new ArrayList<Producto>();
		
		productos.addAll(selectedFactura.getMisProductos());
		
		for (int i = 0; i < productos.size(); i++) {
			int j = 1;
			cant = contProductosEnUnaFactura(productos.get(i), selectedFactura);
			if (cant > 1) {
				while (j < cant) {
					productos.remove(productos.lastIndexOf(productos.get(i)));
					j++;
				}
				productosSinRepetir.add(productos.get(i));
			}else {
				productosSinRepetir.add(productos.get(i));
			}
		}
		
		for (Producto producto : productos) {
			int cont = contProductosEnUnaFactura(producto,selectedFactura);
			rows[0] = producto.getNumSerie();
			rows[1] = producto.getMarca();
			rows[2] = producto.getClass().getSimpleName();
			rows[3] = cont;
			rows[4] = producto.getPrecio();
			rows[5] = producto.getPrecio() * cont;
			
			model.addRow(rows);
		}
	
	}

	private static int contProductosEnUnaFactura(Producto producto, Factura selected) {
		int cont = 0;
		
		for (Producto p1 : selected.getMisProductos()) {
			if (p1.equals(producto)) {
				cont++;
			}
		}
		
		return cont;
	}
}