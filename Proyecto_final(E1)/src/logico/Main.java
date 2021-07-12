package logico;

import java.util.ArrayList;

public class Main {
	//Main de Pruebas
	public static void main(String[] args) {
		
		DiscoDuro d1 = new DiscoDuro("0001", 25, 550, "Sony", "QUESEYO", 500, "Sate");
		MicroProcesador m1 = new MicroProcesador("002", 30, 2000, "MSI", "Guachupita", "GOODquestion", 200);
		
		Tienda.getInstance().addProducto(d1);
		Tienda.getInstance().addProducto(m1);
		
		char [] password = null;
		password[0] = 'h';
		
		Cliente cliente = new Cliente("047", "Gabriel", "La vega", "8295151017","Username",password);
		Tienda.getInstance().addCliente(cliente);
		
		Factura factura = new Factura(new String("F-" + Factura.cod), cliente);
		ArrayList<Producto> productos = new ArrayList<Producto>();
		factura.agregarProductos(productos);
		factura.calcPrecioFactura();
		Tienda.getInstance().addFactura(factura);
		
		System.out.println(Tienda.getInstance().getMisFacturas().get(0).getValorTotal());
		System.out.println(Tienda.getInstance().calPrecioTotalPC(productos));
		Factura aux = Tienda.getInstance().buscarFacturaByCodigo("F-1");
		System.out.println(aux.calcPrecioFactura());
	}
	
}