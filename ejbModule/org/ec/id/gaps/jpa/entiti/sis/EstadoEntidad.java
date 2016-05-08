package org.ec.id.gaps.jpa.entiti.sis;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

/**
 * The persistent class for the sis_estado_entidad database table.
 * 
 */
@Entity
@Table(name = "sis_estado_entidad")
@NamedQuery(name = "EstadoEntidad.findAll", query = "SELECT e FROM EstadoEntidad e")
public class EstadoEntidad implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String id;

	private String descripcion;

	private String estado;

	// bi-directional many-to-one association to TipoEntidad
	@ManyToOne
	@JoinColumn(name = "id_tipo_entidad")
	private TipoEntidad tipoEntidad;

	// bi-directional many-to-one association to Flujo
	@OneToMany(mappedBy = "anteriorEstado")
	private List<Flujo> listaFlujoAnterior;

	// bi-directional many-to-one association to Flujo
	@OneToMany(mappedBy = "nuevoEstado")
	private List<Flujo> listaFlujoNuevo;

	public EstadoEntidad() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public TipoEntidad getTipoEntidad() {
		return this.tipoEntidad;
	}

	public void setTipoEntidad(TipoEntidad tipoEntidad) {
		this.tipoEntidad = tipoEntidad;
	}

	public List<Flujo> getListaFlujoAnterior() {
		return listaFlujoAnterior;
	}

	public void setListaFlujoAnterior(List<Flujo> listaFlujoAnterior) {
		this.listaFlujoAnterior = listaFlujoAnterior;
	}

	public List<Flujo> getListaFlujoNuevo() {
		return listaFlujoNuevo;
	}

	public void setListaFlujoNuevo(List<Flujo> listaFlujoNuevo) {
		this.listaFlujoNuevo = listaFlujoNuevo;
	}

	public Flujo addListaFlujoAnterior(Flujo flujo) {
		getListaFlujoAnterior().add(flujo);
		flujo.setAnteriorEstado(this);
		return flujo;
	}

	public Flujo removeListaFlujoAnterior(Flujo flujo) {
		getListaFlujoAnterior().remove(flujo);
		flujo.setAnteriorEstado(null);
		return flujo;
	}

	public Flujo addListaFlujoNuevo(Flujo flujo) {
		getListaFlujoNuevo().add(flujo);
		flujo.setNuevoEstado(this);
		return flujo;
	}

	public Flujo removeListaFlujoNuevo(Flujo flujo) {
		getListaFlujoNuevo().remove(flujo);
		flujo.setNuevoEstado(null);
		return flujo;
	}

}