package es.jepm.gestionAlquieleres.model;

import java.sql.Date;

public class Inquilino {
	private int id;
	private String DNI;
	private String nombreCompleto;
	private java.util.Date fechaInicioAlquiler;
	private java.util.Date fechaFinAlquiler;
	private int cuotaAlquiler;
	private int idVivienda;
	/**
	 * 
	 */
	public Inquilino() {
		super();
	}
	/**
	 * @param id
	 * @param dNI
	 * @param nombreCompleto
	 * @param fechaInicioAlquiler
	 * @param fechaFinAlquiler
	 * @param cuotaAlquiler
	 * @param idVivienda
	 */
	public Inquilino(int id, String dNI, String nombreCompleto, Date fechaInicioAlquiler, Date fechaFinAlquiler,
			int cuotaAlquiler, int idVivienda) {
		super();
		this.id = id;
		DNI = dNI;
		this.nombreCompleto = nombreCompleto;
		this.fechaInicioAlquiler = fechaInicioAlquiler;
		this.fechaFinAlquiler = fechaFinAlquiler;
		this.cuotaAlquiler = cuotaAlquiler;
		this.idVivienda = idVivienda;
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
	 * @return the dNI
	 */
	public String getDNI() {
		return DNI;
	}
	/**
	 * @param dNI the dNI to set
	 */
	public void setDNI(String dNI) {
		DNI = dNI;
	}
	/**
	 * @return the nombreCompleto
	 */
	public String getNombreCompleto() {
		return nombreCompleto;
	}
	/**
	 * @param nombreCompleto the nombreCompleto to set
	 */
	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}
	/**
	 * @return the fechaInicioAlquiler
	 */
	public java.util.Date getFechaInicioAlquiler() {
		return fechaInicioAlquiler;
	}
	/**
	 * @param date the fechaInicioAlquiler to set
	 */
	public void setFechaInicioAlquiler(java.util.Date date) {
		this.fechaInicioAlquiler = date;
	}
	/**
	 * @return the fechaFinAlquiler
	 */
	public java.util.Date getFechaFinAlquiler() {
		return fechaFinAlquiler;
	}
	/**
	 * @param date the fechaFinAlquiler to set
	 */
	public void setFechaFinAlquiler(java.util.Date date) {
		this.fechaFinAlquiler = date;
	}
	/**
	 * @return the cuotaAlquiler
	 */
	public int getCuotaAlquiler() {
		return cuotaAlquiler;
	}
	/**
	 * @param cuotaAlquiler the cuotaAlquiler to set
	 */
	public void setCuotaAlquiler(int cuotaAlquiler) {
		this.cuotaAlquiler = cuotaAlquiler;
	}
	/**
	 * @return the idVivienda
	 */
	public int getIdVivienda() {
		return idVivienda;
	}
	/**
	 * @param idVivienda the idVivienda to set
	 */
	public void setIdVivienda(int idVivienda) {
		this.idVivienda = idVivienda;
	}
	@Override
	public String toString() {
		return "Inquilino [id=" + id + ", DNI=" + DNI + ", nombreCompleto=" + nombreCompleto + ", fechaInicioAlquiler="
				+ fechaInicioAlquiler + ", fechaFinAlquiler=" + fechaFinAlquiler + ", cuotaAlquiler=" + cuotaAlquiler
				+ ", idVivienda=" + idVivienda + "]";
	}
	
	

}
