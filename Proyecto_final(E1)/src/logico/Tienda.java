package logico;

import java.awt.Container;
import java.io.Serializable;
import java.util.ArrayList;

public class Tienda implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<Producto> misProductos;
	private ArrayList<Cliente> misClientes;
	private ArrayList<Factura> misFacturas;
	private ArrayList<Empleado> misEmpleados;
	private ArrayList<Combo> misCombos;
	private ArrayList<OrdenCompra> misOrdenesCompra;
	private static Tienda tienda = null;
	private static Empleado loginUserEmpleado = null;


	private Tienda() {
		super();
		this.misProductos = new ArrayList<Producto>();
		this.misClientes = new ArrayList<Cliente>();
		this.misFacturas = new ArrayList<Factura>();
		this.misEmpleados = new ArrayList<Empleado>();
		this.misCombos = new ArrayList<Combo>();
		this.misOrdenesCompra = new ArrayList<OrdenCompra>();
	}
	
	public static Tienda getInstance() {
		if (tienda == null) {
			tienda = new Tienda();
		}
		return tienda;
	}
	
	public ArrayList<Producto> getMisProductos() {
		return misProductos;
	}
	public void setMisProductos(ArrayList<Producto> misProductos) {
		this.misProductos = misProductos;
	}

	public ArrayList<Cliente> getMisClientes() {
		return misClientes;
	}
	public void setMisClientes(ArrayList<Cliente> misClientes) {
		this.misClientes = misClientes;
	}

	public ArrayList<Factura> getMisFacturas() {
		return misFacturas;
	}
	public void setMisFacturas(ArrayList<Factura> misFacturas) {
		this.misFacturas = misFacturas;
	}

	public ArrayList<Empleado> getMisEmpleados() {
		return misEmpleados;
	}

	public void setMisEmpleados(ArrayList<Empleado> misEmpleados) {
		this.misEmpleados = misEmpleados;
	}

	public ArrayList<Combo> getMisCombos() {
		return misCombos;
	}

	public void setMisCombos(ArrayList<Combo> misCombos) {
		this.misCombos = misCombos;
	}

	public ArrayList<OrdenCompra> getMisOrdenesCompra() {
		return misOrdenesCompra;
	}

	public void setMisOrdenesCompra(ArrayList<OrdenCompra> misOrdenesCompra) {
		this.misOrdenesCompra = misOrdenesCompra;
	}
	
	public static void setTienda(Tienda tienda) {
		Tienda.tienda = tienda;
	}

	public Empleado getLoginUserEmpleado() {
		return loginUserEmpleado;
	}

	public void setLoginUserEmpleado(Empleado loginUserEmpleado) {
		Tienda.loginUserEmpleado = loginUserEmpleado;
	}

	public void addCliente(Cliente cliente) {
		misClientes.add(cliente);
	}
	
	public void addProducto(Producto producto) {
		misProductos.add(producto);
	}
	
	public void addFactura(Factura factura) {
		misFacturas.add(factura);
	}
	
	public void addEmpleado(Empleado empleado) {
		misEmpleados.add(empleado);
	}

	public void addCombo(Combo combo) {
		misCombos.add(combo);
	}
	
	public void addOrdenCompra(OrdenCompra orden) {
		misOrdenesCompra.add(orden);
	}
	
	public void eliminarProducto(Producto producto) {
		misProductos.remove(producto);
	}
	
	public void eliminarCombo(Combo combo) {
		misCombos.remove(combo);
	}
	
	public void eliminarVendededor(Vendedor vendedor) {
		misEmpleados.remove(vendedor);
	}
	
	public void eliminarCliente(Cliente cliente) {
		misClientes.remove(cliente);
	}
	
	public boolean confirmLogin(String user, String password) {
		boolean login = false;
		for (Empleado empleado : misEmpleados) { 
			if (empleado.getUsername().equals(user) && empleado.getPassword().equals(password)) {
				loginUserEmpleado = empleado;
				login = true;
			}
		}
		return login;
	}
	
	public Cliente buscarClienteByCedula(String cedula) {
		Cliente clienteAux = null;
		for (Cliente cliente : misClientes) {
			if (cliente.getCedula().equalsIgnoreCase(cedula)) {
				clienteAux = cliente;
				return clienteAux;
			}
		}
		return clienteAux;
	}
	
	public Producto buscarProductoByNumSerie(String numSerie) {
		Producto productoAux = null;
		for (Producto producto : misProductos) {
			if (producto.getNumSerie().equalsIgnoreCase(numSerie)) {
				productoAux = producto;
				return productoAux;
			}
		}
		return productoAux;
	}
	
	public Factura buscarFacturaByCodigo(String codigo) {
		Factura facturaAux = null;
		for (Factura factura : misFacturas) {
			if (factura.getCodigo().equalsIgnoreCase(codigo)) {
				facturaAux = factura;
				return facturaAux;
			}
		}
		return facturaAux;
	}
	
	public Empleado buscarEmpleadoByCedula(String cedula) {
		Empleado empleadoAux = null;
		for (Empleado empleado : misEmpleados) {
			if (empleado.getCedula().equalsIgnoreCase(cedula)) {
				empleadoAux = empleado;
				return empleadoAux;
			}
		}
		return empleadoAux;
	}
	
	public Combo buscarComboByCod(String codigo) {
		Combo comboAux = null;
		for (Combo combo : misCombos) {
			if (combo.getCodigo().equalsIgnoreCase(codigo)) {
				comboAux = combo;
				return comboAux;
			}
		}
		return comboAux;
	}
	
	public OrdenCompra buscarOrdenDeCompraByCod(String codigo) {
		OrdenCompra ordenCompraAux = null;
		for (OrdenCompra ordenCompra : misOrdenesCompra) {
			if (ordenCompra.getCodigo().equalsIgnoreCase(codigo)) {
				ordenCompraAux = ordenCompra;
				return ordenCompraAux;
			}
		}
		return ordenCompraAux;
	}
	
	public float calcTotalFactura(String codFactura) {
		Factura factura = buscarFacturaByCodigo(codFactura);
		
		return factura.calcPrecioFactura();
	}
	
	public float calPrecioTotalProductos(ArrayList<Producto> productos) {
		float precioTotal = 0;
		for (Producto producto : productos) {
			precioTotal += producto.getPrecio();
		}
		return precioTotal;
	}
	
	/*
	public float calcTotalVendidoByVendedor(String cedula) {
		Vendedor vendedor = (Vendedor) buscarEmpleadoByCedula(cedula);
		float suma = 0;
		
		for (Factura factura : misFacturas) {
			if(factura.getMiVendedor().equals(vendedor)) {
				suma += factura.getPrecioTotal();
			}
		}
		vendedor.setTotalVendido(suma);
		return suma;
	} 
	//Ya esto no es necesario, lo hago en la clase visual desde que el metodo hacerCompra retorna true.
	*/
	
	public Vendedor vendedorDelMes() {
		float mayor = 0;
		Vendedor vendedorDelMes = null;
		
		for (Empleado empleado : misEmpleados) {
			if(empleado instanceof Vendedor) {
				if  ( ((Vendedor)empleado).getTotalVendido() > mayor) {
					mayor = ((Vendedor)empleado).getTotalVendido();
					vendedorDelMes = (Vendedor) empleado;
				}
			}
		}
		return vendedorDelMes;
	}
	//--------------------------------PENDIENTE---------------------------------------//
	public Cliente clienteDelMes(){
		Cliente clienteDelMes = null;
		
		
		
		return clienteDelMes;
	}
	//--------------------------------------------------------------------------------//
	
	public void crearOrdenesCompra() {
		Producto productoAOrdenar = null;
		
		for (Producto producto : misProductos) {
			if (producto.getCantidad() < producto.getDispMin()) {
				if (ExisteOrdenDelProducto(producto) == false) {
					productoAOrdenar = producto;
				}
			}
			
			if(productoAOrdenar != null) {
				OrdenCompra orden = new OrdenCompra(new String("Orden-"+OrdenCompra.numOrdenCompra), productoAOrdenar);
				
				Tienda.getInstance().addOrdenCompra(orden);
			}
		}
	}

	private boolean ExisteOrdenDelProducto(Producto producto) {
		boolean existe = false;
		
		for (OrdenCompra orden : misOrdenesCompra) {
			if (orden.getProducto().equals(producto)) {
				existe = true;
				return existe;
			}
		}
		return existe;
	}
	
	public boolean CrearFactura(Factura factura) {
		boolean esPosible = false;
		
		if (factura.isACredito()) {
			if (factura.getMiCliente().getCredito() < factura.getPrecioTotal()  || clienteYaTieneCredito(factura.getMiCliente())) {
				return esPosible;
			}
		}
		esPosible = true;
		//factura.getMiVendedor().setTotalVendido(factura.getPrecioTotal());
		for (Producto producto : factura.getMisProductos()) {
			//En la parte visual hay que mostrar solamente los productos que tengan cantidad > 0.
			producto.setCantidad(producto.getCantidad() - 1);
		}
		addFactura(factura);
		return esPosible;
	}

	private boolean clienteYaTieneCredito(Cliente miCliente) {
		boolean yaTiene = true;
		
		for (Factura factura : misFacturas) {
			if (factura.isACredito()) {
				if (factura.getMiCliente().equals(miCliente)) {
					return yaTiene;
				}
			}
		}
		yaTiene = false;
		return yaTiene;
	}
	
	public boolean abonarFacturaCredito(String cod, float abono) {
		boolean esPosible = false;
		Factura f1 = buscarFacturaByCodigo(cod);
		
		if (f1.isACredito()) {
			if (f1.getPrecioTotal() < abono) {
				return esPosible;
			}
			f1.setLineaCredito(f1.getLineaCredito() - abono);
			if (f1.getLineaCredito() == 0) {
				f1.setACredito(false);
			}
			esPosible = true;
		}
		return esPosible;
	}
	
	//--------------------------------PENDIENTE---------------------------------------//
	public Cliente getClienteMasCompras() {
		int mayor = 0;
		Cliente aux = null;
		
		for (Cliente cliente : misClientes) {
			if(cliente.getCantCompras() > mayor) {
				mayor = cliente.getCantCompras();
				aux = cliente;
			}
		}
		
		return aux;
	}
	
	public Cliente getClienteMenosCompras() {
		/*int mayor = 0;
		int menor;
		Cliente aux = null;
		
		for (Cliente cliente : misClientes) {
			if(cliente.getCantCompras() > mayor) {
				mayor = cliente.getCantCompras();
			}
		}
		menor = mayor;
		for (Cliente cliente : misClientes) {
			if(cliente.getCantCompras() < menor) {
				menor = cliente.getCantCompras();
			}
		}
		
		for (Cliente cliente : misClientes) {
			if(cliente.getCantCompras() == menor) {
				aux = cliente;
			}
		}*/
		Cliente aux = misClientes.get(0);
		
		for (Cliente cliente : misClientes) {
			if (cliente.getCantCompras() < aux.getCantCompras()) {
				aux = cliente;
			}
		}
		return aux;
	}
	
	public Cliente getClienteMayorDeuda(){
		Cliente aux = null;
		float mayor = 0;
		
		for (Factura factura : misFacturas) {
			if(factura.isACredito()) {
				if(factura.getPrecioTotal() > mayor) {
					mayor = factura.getPrecioTotal();
					aux = factura.getMiCliente();
				}
			}
		}
		return aux;
	}
	
	public String productoMasComprado() {
		String aux = null;
		int contMR = 0, contMP = 0, contMB = 0, contDD = 0;
		
		for (Factura factura : misFacturas) {
			for (Producto producto : factura.getMisProductos()) {
				if (producto instanceof DiscoDuro) {
					contDD++;
				}else if (producto instanceof MemoriaRam) {
					contMR++;
				}else if (producto instanceof MotherBoard) {
					contMB++;
				}else if (producto instanceof MicroProcesador) {
					contMP++;
				}
			}
		}
		if (contDD > contMB && contDD > contMR && contDD > contMP) {
			aux = "Disco Duro";
		}else if (contMR > contMB && contMR > contDD && contMR > contMP) {
			aux = "Memoria RAM";
		}else if (contMB > contMR && contMB > contDD && contMB > contMP) {
			aux = "Mother Board";
		}else if (contMP > contMR && contMP > contDD && contMP > contMB) {
			aux = "Microprocesador";
		}
		
		return aux;
	}
	
	public String productoMenosComprado() {
		String aux = null;
		int contMR = 0, contMP = 0, contMB = 0, contDD = 0;
		
		for (Factura factura : misFacturas) {
			for (Producto producto : factura.getMisProductos()) {
				if (producto instanceof DiscoDuro) {
					contDD++;
				}else if (producto instanceof MemoriaRam) {
					contMR++;
				}else if (producto instanceof MotherBoard) {
					contMB++;
				}else if (producto instanceof MicroProcesador) {
					contMP++;
				}
			}
		}
		if (contDD < contMB && contDD < contMR && contDD < contMP) {
			aux = "Disco Duro";
		}else if (contMR < contMB && contMR < contDD && contMR < contMP) {
			aux = "Memoria RAM";
		}else if (contMB < contMR && contMB < contDD && contMB < contMP) {
			aux = "Mother Board";
		}else if (contMP < contMR && contMP < contDD && contMP < contMB) {
			aux = "Microprocesador";
		}
		
		return aux;
	}
	
	public Vendedor vendedorConMasFacturas() {
		int mayor = 0, cont = 0;
		Vendedor aux = null;
		
		for (Factura factura : misFacturas) {
			if (factura.getMiVendedor() instanceof Vendedor) {
				cont = calcFacturasVendedor(factura.getMiVendedor());
				if (cont > mayor) {
					mayor = cont;
					aux = factura.getMiVendedor();
				}
			}
		}
		
		return aux;
	}

	private int calcFacturasVendedor(Vendedor v1) {
		int cont = 0;
		
		for (Factura f1 : misFacturas) {
			if (f1.getMiVendedor().equals(v1)) {
				cont++;
			}
		}
		return cont;
	}
	
	public Vendedor vendedorConMenosFacturas() {
		int menor = 10, cont = 0;
		Vendedor aux = null;
		
		for (Factura factura : misFacturas) {
			if (factura.getMiVendedor() instanceof Vendedor) {
				cont = calcFacturasVendedor(factura.getMiVendedor());
				if (cont < menor) {
					menor = cont;
					aux = factura.getMiVendedor();
				}
			}
		}
		
		return aux;
	}
	
	public Factura facturaMasCara() {
		Factura aux = null;
		float mayor = 0;
		
		for (Factura factura : misFacturas) {
			if (factura.getPrecioTotal() > mayor) {
				mayor = factura.getPrecioTotal();
				aux = factura;
			}
		}
		
		return aux;
	}
	
	public Factura facturaMenosCara() {
		Factura aux = null;
		float menor = misFacturas.get(0).getPrecioTotal();
		
		for (Factura factura : misFacturas) {
			if (factura.getPrecioTotal() < menor) {
				menor = factura.getPrecioTotal();
				aux = factura;
			}
		}
		
		return aux;
	}
	
	public int cantFacturasAdeudadas() {
		int cont = 0;
		
		for (Factura factura : misFacturas) {
			if (factura.isACredito()) {
				cont++;
			}
		}
		return cont;
	}
	
	public int cantFacturasPagadas() {
		int cont = 0;
		
		for (Factura factura : misFacturas) {
			if (factura.isACredito() == false) {
				cont++;
			}
		}
		return cont;
	}
	
	public float totalVendido() {
		float total = 0;
		
		for (Factura f1 : misFacturas) {
			total += f1.getPrecioTotal();
		}
		return total;
	}
	
	public String comboMasVendido() {
		int cont = 0, mayor = 0;
		String aux = null;
		
		for (Combo combo : misCombos) {
			cont = cantCombosComprados(combo);
			if (cont > mayor) {
				mayor = cont;
				aux = combo.getNombre();
			}
		}
		return aux;
	}

	private int cantCombosComprados(Combo combo) {
		int cont = 0;
		
		for (Factura f1 : misFacturas) {
			if (f1.getMisProductos().equals(combo.getMisProductos())){
				cont++;
			}
		}
		return cont;
	}
	
	public String comboMenosVendido() {
		int cont = 0, menor = 1000;
		String aux = null;
		
		for (Combo combo : misCombos) {
			cont = cantCombosComprados(combo);
			if (cont < menor) {
				menor = cont;
				aux = combo.getNombre();
			}
		}
		return aux;
	}
	
	
}
