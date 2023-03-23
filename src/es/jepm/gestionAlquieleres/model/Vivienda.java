package es.jepm.gestionAlquieleres.model;

public class Vivienda {
	
	private int id;
	private String descripcion;
	private int idLocaloidad;
	/**
	 * 
	 */
	public Vivienda() {
		super();
	}
	/**
	 * @param id
	 * @param descripcion
	 * @param idLocaloidad
	 */
	public Vivienda(int id, String descripcion, int idLocaloidad) {
		super();
		this.id = id;
		this.descripcion = descripcion;
		this.idLocaloidad = idLocaloidad;
	}
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}
	/**
	 * @param descripcion the descripcion to set
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	/**
	 * @return the idLocaloidad
	 */
	public int getIdLocaloidad() {
		return idLocaloidad;
	}
	/**
	 * @param idLocaloidad the idLocaloidad to set
	 */
	public void setIdLocaloidad(int idLocaloidad) {
		this.idLocaloidad = idLocaloidad;
	}
	@Override
	public String toString() {
		return descripcion;
	}
	
	

}
