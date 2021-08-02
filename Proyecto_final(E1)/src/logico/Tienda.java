package logico;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class Tienda implements Serializable{

	private static final long serialVersionUID = 1L;
	private static Tienda tienda = null;
	private static Empleado loginUserEmpleado = null;
	private int staticPedidos = 1;
	private int staticCombo = 1;
	private int staticFactura = 1;
	private ArrayList<Producto> misProductos;
	private ArrayList<Cliente> misClientes;
	private ArrayList<Factura> misFacturas;
	private ArrayList<Empleado> misEmpleados;
	private ArrayList<Combo> misCombos;
	private ArrayList<OrdenCompra> misOrdenesCompra;
	private ArrayList<String> misDistribuidores = new ArrayList<String>();

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
	
	public ArrayList<String> getMisDistribuidores() {
		return misDistribuidores;
	}
	public void setMisDistribuidores(ArrayList<String> misDistribuidores) {
		this.misDistribuidores = misDistribuidores;
	}
	
	public Empleado getLoginUserEmpleado() {
		return loginUserEmpleado;
	}
	public void setLoginUserEmpleado(Empleado loginUserEmpleado) {
		Tienda.loginUserEmpleado = loginUserEmpleado;
	}

	public void actualizarVariablesStatic() {
		staticCombo = Combo.cod;
		staticPedidos = OrdenCompra.numOrdenCompra;
		staticFactura = Factura.cod;
	}
	
	public int getStaticCombo() {
		return staticCombo;
	}
	
	public int getStaticFactura() {
		return staticFactura;
	}
	
	public  int getStaticPedido() {
		return staticPedidos;
	}
	
	public static void setTienda(Tienda tienda) {
		Tienda.tienda = tienda;
	}
	
	public void addDistribuidor(String distribuidor) {
		misDistribuidores.add(distribuidor);
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
	
	public void eliminarDistribuidor(String distribuidor) {
		misDistribuidores.remove(distribuidor);
	}
	
	public void eliminarVendededor(Vendedor vendedor) {
		misEmpleados.remove(vendedor);
	}
	
	public void eliminarCliente(Cliente cliente) {
		misClientes.remove(cliente);
	}
	
	public void eliminarFactura(Factura factura) {
		misFacturas.remove(factura);
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
		
	@SuppressWarnings("deprecation")
	public Cliente clienteDelMes(){
		Cliente clienteDelMes = null;
		int comprasEnEsteMes = 0;
		int mayor = 0;
		Date fecha = new Date();
		for (Cliente cliente : misClientes) {
			for (Factura factura : misFacturas) {
				if (cliente.getCedula().equalsIgnoreCase(factura.getMiCliente().getCedula())) {
					if (factura.getFecha().getMonth() == fecha.getMonth() && factura.getFecha().getYear() == fecha.getYear()) {
						if (factura.isACredito() == false) {
							comprasEnEsteMes++;
						}
					}
				}
			}
			if (comprasEnEsteMes > mayor) {
				mayor = comprasEnEsteMes;
				clienteDelMes = cliente;
			}
		}
		if (mayor == 0) {
			return null;
		}
		return clienteDelMes;
	}
	
	@SuppressWarnings("deprecation")
	public Vendedor vendedorDelMes() {
		float mayor = 0;
		float montoEnEseMes = 0;
		Date fecha = new Date();
		Vendedor vendedorDelMes = null;
		
		for (Empleado empleado : misEmpleados) {
			if(empleado instanceof Vendedor) {
				for (Factura factura : misFacturas) {
					if (empleado.getCedula().equalsIgnoreCase(factura.getMiVendedor().getCedula())) {
						if (factura.getFecha().getMonth() == fecha.getMonth() && factura.getFecha().getYear() == fecha.getYear()) {
							montoEnEseMes += factura.getPrecioTotal();
						}
					}
				}
				if (montoEnEseMes > mayor) {
					mayor = montoEnEseMes;
					vendedorDelMes = (Vendedor) empleado;
				}
			}
		}
		if (mayor == 0) {
			return null;
		}
		return vendedorDelMes;
	}
	
	public void crearOrdenesCompra() {
		
		for (Producto producto : misProductos) {
			Producto productoAOrdenar = null;
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
		/*for (Producto producto : factura.getMisProductos()) {
			producto.setCantidad(producto.getCantidad() - 1);
		}*/
		addFactura(factura);
		return esPosible;
	}

	public boolean clienteYaTieneCredito(Cliente miCliente) {
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
			if (f1.getLineaCredito() < abono) {
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
	
	public Cliente getClienteMasCompras() {
		int mayor = 0;
		Cliente aux = null;
		
		for (Cliente cliente : misClientes) {
			if(cliente.getCantCompras() > mayor) {
				mayor = cliente.getCantCompras();
				aux = cliente;
			}
		}
		
		if (mayor == 0) {
			return null;
		}
		return aux;
	}
	
	public Cliente getClienteMenosCompras() {
		Cliente aux = null;
		if (getClienteMasCompras() == null) {
			return null;
		}
		int menor = getClienteMasCompras().getCantCompras();
		
		for (Cliente cliente : misClientes) {
			if (cliente.getCantCompras() < menor) {
				aux = cliente;
				menor = cliente.getCantCompras();
			}
		}
		if (menor == getClienteMasCompras().getCantCompras()) {
			return null;
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
		
		if (mayor == 0) {
			return null;
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
		
		if (contMR == 0 && contMP == 0 && contMB == 0 && contDD == 0) {
			return null;
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
		
		if (contMR == 0 && contMP == 0 && contMB == 0 && contDD == 0) {
			return null;
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
		if (mayor == 0) {
			return null;
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
	
	public int CantMayorDeFacturasEnUnVendedor() {
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
		
		return cont;
	}
	
	public Vendedor vendedorConMenosFacturas() {
		int menor = CantMayorDeFacturasEnUnVendedor(), cont = 0;
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
		
		if (menor == CantMayorDeFacturasEnUnVendedor()) {
			return null;
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
		if (mayor == 0) {
			return null;
		}
		return aux;
	}
	
	public Factura facturaMenosCara() {
		Factura aux = null;
		float menor = 0;
		if (facturaMasCara() == null) {
			return null;
		}
		else {
			menor = facturaMasCara().getPrecioTotal();
		}
		for (Factura factura : misFacturas) {
			if (factura.getPrecioTotal() < menor) {
				menor = factura.getPrecioTotal();
				aux = factura;
			}
		}
		if (menor == facturaMasCara().getPrecioTotal()) {
			return null;
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
		if (cont == 0) {
			return null;
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
		int cont = 0, menor = 10000;
		String aux = null;
		
		for (Combo combo : misCombos) {
			cont = cantCombosComprados(combo);
			if (cont < menor) {
				menor = cont;
				aux = combo.getNombre();
			}
		}
		if (cont == 0) {
			return null;
		}
		return aux;
	}

	public boolean verificarUser(String username, int indexEmpleado) {
		boolean diferente = true;
		int i = 0;
		for (Empleado empleado : misEmpleados) {
			if (empleado.getUsername().equals(username) && i != indexEmpleado) {
				diferente = false;
				break;
			}
			i++;
		}
		return diferente;
	}

	public boolean verificarUserRegistrar(String username) {
		boolean diferente = true;
		for (Empleado empleado : misEmpleados) {
			if (empleado.getUsername().equals(username)) {
				diferente = false;
				break;
			}
		}
		return diferente;
	}

	public int buscarIndexEmpleado(Empleado selected) {
		return misEmpleados.indexOf(selected);
	}
}
