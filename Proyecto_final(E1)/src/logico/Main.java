package logico;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class Main implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//Main de Pruebas
	public static void main(String[] args) {
		Administrador administrador = new Administrador("admin", "12345", "nombre", "cedula", "telefono", "direccion");
		Tienda.getInstance().addEmpleado(administrador);
		
		ArrayList<Producto> productos1 = new ArrayList<Producto>();
		
		DiscoDuro disco1 = new DiscoDuro("0001", 25, 550, "Sony", 5, 50, "QUESEYO", 500, "Sate");
		MicroProcesador micro1 = new MicroProcesador("002", 30, 2000, "MSI", 5, 25, "Guachupita", "GOODquestion", 200);
		
		productos1.add(disco1);
		productos1.add(micro1);
		Tienda.getInstance().addProducto(disco1);
		Tienda.getInstance().addProducto(micro1);
		
		Vendedor vendedor1 = new Vendedor("username", "password", "nombre", "cedula", "telefono", "direccion");
		Tienda.getInstance().addEmpleado(vendedor1);
		administrador.addVendedor(vendedor1);
		
		Cliente cliente1 = new Cliente("047", "Gabriel", "La vega", "8295151017");
		Tienda.getInstance().addCliente(cliente1);
		
		Factura factura1 = new Factura(new String("F-" + Factura.cod), vendedor1, cliente1, productos1, new Date());
		factura1.calcPrecioFactura();
		Tienda.getInstance().addFactura(factura1);
		
		/*System.out.println(Tienda.getInstance().getMisFacturas().get(0).getPrecioTotal());
		System.out.println(Tienda.getInstance().calPrecioTotalPC(productos1));
		Factura aux = Tienda.getInstance().buscarFacturaByCodigo("F-1");
		System.out.println(aux.calcPrecioFactura());*/
		
		Combo combo = new Combo("001", "RTX", productos1, 10);
		System.out.println(combo.getPrecioNeto() + " Otro precio: " + combo.getPrecioTotal());
	}
	
}