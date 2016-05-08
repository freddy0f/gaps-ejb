package org.ec.id.gaps.jpa.entiti.sis;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the sis_flujo database table.
 * 
 */
@Entity
@Table(name="sis_flujo")
@NamedQuery(name="Flujo.findAll", query="SELECT f FROM Flujo f")
public class Flujo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	@Column(name="aplica_condicion")
	private String aplicaCondicion;

	@Column(name="aplica_condicion_inicial")
	private String aplicaCondicionInicial;

	@Column(name="aplica_motivo")
	private String aplicaMotivo;

	private String descripcion;

	@Column(name="id_accion_negocio")
	private Integer idAccionNegocio;

	@Column(name="id_vista_elemento")
	private Integer idVistaElemento;

	@Column(name="imagen_accion")
	private String imagenAccion;

	@Column(name="nivel_bloqueo")
	private Integer nivelBloqueo;

	private String permitido;

	//bi-directional many-to-one association to CondicionFlujo
	@OneToMany(mappedBy="flujo")
	private List<CondicionFlujo> listaCondicionFlujo;

	//bi-directional many-to-one association to EstadoEntidad
	@ManyToOne
	@JoinColumn(name="anterior")
	private EstadoEntidad anteriorEstado;

	//bi-directional many-to-one association to EstadoEntidad
	@ManyToOne
	@JoinColumn(name="nuevo")
	private EstadoEntidad nuevoEstado;

	//bi-directional many-to-one association to Operacion
	@ManyToOne
	@JoinColumn(name="id_operacion")
	private Operacion operacion;

	//bi-directional many-to-one association to TipoEntidad
	@ManyToOne
	@JoinColumn(name="tipo_entidad")
	private TipoEntidad tipoEntidad;

	//bi-directional many-to-one association to FlujoHistorial
	@OneToMany(mappedBy="flujo")
	private List<FlujoHistorial> listaFlujoHistorial;

	public Flujo() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAplicaCondicion() {
		return this.aplicaCondicion;
	}

	public void setAplicaCondicion(String aplicaCondicion) {
		this.aplicaCondicion = aplicaCondicion;
	}

	public String getAplicaCondicionInicial() {
		return this.aplicaCondicionInicial;
	}

	public void setAplicaCondicionInicial(String aplicaCondicionInicial) {
		this.aplicaCondicionInicial = aplicaCondicionInicial;
	}

	public String getAplicaMotivo() {
		return this.aplicaMotivo;
	}

	public void setAplicaMotivo(String aplicaMotivo) {
		this.aplicaMotivo = aplicaMotivo;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Integer getIdAccionNegocio() {
		return this.idAccionNegocio;
	}

	public void setIdAccionNegocio(Integer idAccionNegocio) {
		this.idAccionNegocio = idAccionNegocio;
	}

	public Integer getIdVistaElemento() {
		return this.idVistaElemento;
	}

	public void setIdVistaElemento(Integer idVistaElemento) {
		this.idVistaElemento = idVistaElemento;
	}

	public String getImagenAccion() {
		return this.imagenAccion;
	}

	public void setImagenAccion(String imagenAccion) {
		this.imagenAccion = imagenAccion;
	}

	public Integer getNivelBloqueo() {
		return this.nivelBloqueo;
	}

	public void setNivelBloqueo(Integer nivelBloqueo) {
		this.nivelBloqueo = nivelBloqueo;
	}

	public String getPermitido() {
		return this.permitido;
	}

	public void setPermitido(String permitido) {
		this.permitido = permitido;
	}

	public List<CondicionFlujo> getListaCondicionFlujo() {
		return this.listaCondicionFlujo;
	}

	public void setListaCondicionFlujo(List<CondicionFlujo> listaCondicionFlujo) {
		this.listaCondicionFlujo = listaCondicionFlujo;
	}

	public CondicionFlujo addListaCondicionFlujo(CondicionFlujo listaCondicionFlujo) {
		getListaCondicionFlujo().add(listaCondicionFlujo);
		listaCondicionFlujo.setFlujo(this);

		return listaCondicionFlujo;
	}

	public CondicionFlujo removeListaCondicionFlujo(CondicionFlujo listaCondicionFlujo) {
		getListaCondicionFlujo().remove(listaCondicionFlujo);
		listaCondicionFlujo.setFlujo(null);

		return listaCondicionFlujo;
	}

	public EstadoEntidad getAnteriorEstado() {
		return this.anteriorEstado;
	}

	public void setAnteriorEstado(EstadoEntidad anteriorEstado) {
		this.anteriorEstado = anteriorEstado;
	}

	public EstadoEntidad getNuevoEstado() {
		return this.nuevoEstado;
	}

	public void setNuevoEstado(EstadoEntidad nuevoEstado) {
		this.nuevoEstado = nuevoEstado;
	}

	public Operacion getOperacion() {
		return this.operacion;
	}

	public void setOperacion(Operacion operacion) {
		this.operacion = operacion;
	}

	public TipoEntidad getTipoEntidad() {
		return this.tipoEntidad;
	}

	public void setTipoEntidad(TipoEntidad tipoEntidad) {
		this.tipoEntidad = tipoEntidad;
	}

	public List<FlujoHistorial> getListaFlujoHistorial() {
		return this.listaFlujoHistorial;
	}

	public void setListaFlujoHistorial(List<FlujoHistorial> listaFlujoHistorial) {
		this.listaFlujoHistorial = listaFlujoHistorial;
	}

	public FlujoHistorial addListaFlujoHistorial(FlujoHistorial listaFlujoHistorial) {
		getListaFlujoHistorial().add(listaFlujoHistorial);
		listaFlujoHistorial.setFlujo(this);

		return listaFlujoHistorial;
	}

	public FlujoHistorial removeListaFlujoHistorial(FlujoHistorial listaFlujoHistorial) {
		getListaFlujoHistorial().remove(listaFlujoHistorial);
		listaFlujoHistorial.setFlujo(null);

		return listaFlujoHistorial;
	}

}