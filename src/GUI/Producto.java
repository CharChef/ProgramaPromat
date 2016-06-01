package GUI;

public class Producto {

	private int id;
	private String descripcion;
	private float precio;
	private String marca;
	private String Categoria;
	private int stock;
	private String detalle;
	
	/**
	 * @param id
	 * @param descripcion
	 * @param precio
	 * @param marca
	 * @param categoria
	 * @param stock
	 * @param detalle
	 */
	public Producto(int id, String descripcion, int precio, String marca,
			String categoria, int stock, String detalle) 
	{
		this.id = id;
		this.descripcion = descripcion;
		this.precio = precio;
		this.marca = marca;
		this.Categoria = categoria;
		this.stock = stock;
		this.detalle = detalle;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getCategoria() {
		return Categoria;
	}

	public void setCategoria(String categoria) {
		Categoria = categoria;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public String getDetalle() {
		return detalle;
	}

	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}
			
}
