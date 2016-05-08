package org.ec.id.gaps.jpa.entiti.sis;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the sis_tipo_entidad database table.
 * 
 */
@Entity
@Table(name="sis_tipo_entidad")
@NamedQuery(name="TipoEntidad.findAll", query="SELECT t FROM TipoEntidad t")
public class TipoEntidad implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String id;

	private String descripcion;

	@Column(name="es_activo")
	private String esActivo;

	private String grupo;

	@Column(name="sentencia_delete")
	private String sentenciaDelete;

	@Column(name="sentencia_select")
	private String sentenciaSelect;

	@Column(name="sentencia_update")
	private String sentenciaUpdate;

	//bi-directional many-to-one association to AuditoriaEntidad
	@OneToMany(mappedBy="tipoEntidad")
	private List<AuditoriaEntidad> listaAuditoriaEntidad;

	//bi-directional many-to-one association to EstadoEntidad
	@OneToMany(mappedBy="tipoEntidad")
	private List<EstadoEntidad> listaEstadoEntidad;

	//bi-directional many-to-one association to Flujo
	@OneToMany(mappedBy="tipoEntidad")
	private List<Flujo> listaFlujo;

	//bi-directional many-to-one association to FlujoHistorial
	@OneToMany(mappedBy="tipoEntidad")
	private List<FlujoHistorial> listaFlujoHistorial;

	public TipoEntidad() {
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

	public String getEsActivo() {
		return this.esActivo;
	}

	public void setEsActivo(String esActivo) {
		this.esActivo = esActivo;
	}

	public String getGrupo() {
		return this.grupo;
	}

	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}

	public String getSentenciaDelete() {
		return this.sentenciaDelete;
	}

	public void setSentenciaDelete(String sentenciaDelete) {
		this.sentenciaDelete = sentenciaDelete;
	}

	public String getSentenciaSelect() {
		return this.sentenciaSelect;
	}

	public void setSentenciaSelect(String sentenciaSelect) {
		this.sentenciaSelect = sentenciaSelect;
	}

	public String getSentenciaUpdate() {
		return this.sentenciaUpdate;
	}

	public void setSentenciaUpdate(String sentenciaUpdate) {
		this.sentenciaUpdate = sentenciaUpdate;
	}

	public List<AuditoriaEntidad> getListaAuditoriaEntidad() {
		return this.listaAuditoriaEntidad;
	}

	public void setListaAuditoriaEntidad(List<AuditoriaEntidad> listaAuditoriaEntidad) {
		this.listaAuditoriaEntidad = listaAuditoriaEntidad;
	}

	public AuditoriaEntidad addListaAuditoriaEntidad(AuditoriaEntidad listaAuditoriaEntidad) {
		getListaAuditoriaEntidad().add(listaAuditoriaEntidad);
		listaAuditoriaEntidad.setTipoEntidad(this);

		return listaAuditoriaEntidad;
	}

	public AuditoriaEntidad removeListaAuditoriaEntidad(AuditoriaEntidad listaAuditoriaEntidad) {
		getListaAuditoriaEntidad().remove(listaAuditoriaEntidad);
		listaAuditoriaEntidad.setTipoEntidad(null);

		return listaAuditoriaEntidad;
	}

	public List<EstadoEntidad> getListaEstadoEntidad() {
		return this.listaEstadoEntidad;
	}

	public void setListaEstadoEntidad(List<EstadoEntidad> listaEstadoEntidad) {
		this.listaEstadoEntidad = listaEstadoEntidad;
	}

	public EstadoEntidad addListaEstadoEntidad(EstadoEntidad listaEstadoEntidad) {
		getListaEstadoEntidad().add(listaEstadoEntidad);
		listaEstadoEntidad.setTipoEntidad(this);

		return listaEstadoEntidad;
	}

	public EstadoEntidad removeListaEstadoEntidad(EstadoEntidad listaEstadoEntidad) {
		getListaEstadoEntidad().remove(listaEstadoEntidad);
		listaEstadoEntidad.setTipoEntidad(null);

		return listaEstadoEntidad;
	}

	public List<Flujo> getListaFlujo() {
		return this.listaFlujo;
	}

	public void setListaFlujo(List<Flujo> listaFlujo) {
		this.listaFlujo = listaFlujo;
	}

	public Flujo addListaFlujo(Flujo listaFlujo) {
		getListaFlujo().add(listaFlujo);
		listaFlujo.setTipoEntidad(this);

		return listaFlujo;
	}

	public Flujo removeListaFlujo(Flujo listaFlujo) {
		getListaFlujo().remove(listaFlujo);
		listaFlujo.setTipoEntidad(null);

		return listaFlujo;
	}

	public List<FlujoHistorial> getListaFlujoHistorial() {
		return this.listaFlujoHistorial;
	}

	public void setListaFlujoHistorial(List<FlujoHistorial> listaFlujoHistorial) {
		this.listaFlujoHistorial = listaFlujoHistorial;
	}

	public FlujoHistorial addListaFlujoHistorial(FlujoHistorial listaFlujoHistorial) {
		getListaFlujoHistorial().add(listaFlujoHistorial);
		listaFlujoHistorial.setTipoEntidad(this);

		return listaFlujoHistorial;
	}

	public FlujoHistorial removeListaFlujoHistorial(FlujoHistorial listaFlujoHistorial) {
		getListaFlujoHistorial().remove(listaFlujoHistorial);
		listaFlujoHistorial.setTipoEntidad(null);

		return listaFlujoHistorial;
	}

}