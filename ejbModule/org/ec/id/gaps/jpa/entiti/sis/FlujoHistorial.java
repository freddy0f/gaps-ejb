package org.ec.id.gaps.jpa.entiti.sis;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the sis_flujo_historial database table.
 * 
 */
@Entity
@Table(name="sis_flujo_historial")
@NamedQuery(name="FlujoHistorial.findAll", query="SELECT f FROM FlujoHistorial f")
public class FlujoHistorial implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private String accion;

	@Column(name="estado_resultante")
	private String estadoResultante;

	@Temporal(TemporalType.DATE)
	private Date fecha;

	@Column(name="id_documento")
	private Integer idDocumento;

	private String motivo;

	private String observacion;

	//bi-directional many-to-one association to Flujo
	@ManyToOne
	@JoinColumn(name="id_flujo")
	private Flujo flujo;

	//bi-directional many-to-one association to TipoEntidad
	@ManyToOne
	@JoinColumn(name="tipo_entidad")
	private TipoEntidad tipoEntidad;

	public FlujoHistorial() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAccion() {
		return this.accion;
	}

	public void setAccion(String accion) {
		this.accion = accion;
	}

	public String getEstadoResultante() {
		return this.estadoResultante;
	}

	public void setEstadoResultante(String estadoResultante) {
		this.estadoResultante = estadoResultante;
	}

	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Integer getIdDocumento() {
		return this.idDocumento;
	}

	public void setIdDocumento(Integer idDocumento) {
		this.idDocumento = idDocumento;
	}

	public String getMotivo() {
		return this.motivo;
	}

	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}

	public String getObservacion() {
		return this.observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	public Flujo getFlujo() {
		return this.flujo;
	}

	public void setFlujo(Flujo flujo) {
		this.flujo = flujo;
	}

	public TipoEntidad getTipoEntidad() {
		return this.tipoEntidad;
	}

	public void setTipoEntidad(TipoEntidad tipoEntidad) {
		this.tipoEntidad = tipoEntidad;
	}

}