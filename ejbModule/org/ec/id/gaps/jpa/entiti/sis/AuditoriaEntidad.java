package org.ec.id.gaps.jpa.entiti.sis;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the sis_auditoria_entidad database table.
 * 
 */
@Entity
@Table(name="sis_auditoria_entidad")
@NamedQuery(name="AuditoriaEntidad.findAll", query="SELECT a FROM AuditoriaEntidad a")
public class AuditoriaEntidad implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	@Column(name="cambios_atributos")
	private String cambiosAtributos;

	private String descripcion;

	private String descripcion1;

	private String descripcion2;

	private Timestamp fecha;

	@Column(name="id_entidad")
	private Integer idEntidad;

	@Column(name="id_entidad1")
	private Integer idEntidad1;

	@Column(name="id_entidad2")
	private Integer idEntidad2;

	//bi-directional many-to-one association to TipoEntidad
	@ManyToOne
	@JoinColumn(name="tipo_entidad")
	private TipoEntidad tipoEntidad;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="id_usuario")
	private User user;

	public AuditoriaEntidad() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCambiosAtributos() {
		return this.cambiosAtributos;
	}

	public void setCambiosAtributos(String cambiosAtributos) {
		this.cambiosAtributos = cambiosAtributos;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getDescripcion1() {
		return this.descripcion1;
	}

	public void setDescripcion1(String descripcion1) {
		this.descripcion1 = descripcion1;
	}

	public String getDescripcion2() {
		return this.descripcion2;
	}

	public void setDescripcion2(String descripcion2) {
		this.descripcion2 = descripcion2;
	}

	public Timestamp getFecha() {
		return this.fecha;
	}

	public void setFecha(Timestamp fecha) {
		this.fecha = fecha;
	}

	public Integer getIdEntidad() {
		return this.idEntidad;
	}

	public void setIdEntidad(Integer idEntidad) {
		this.idEntidad = idEntidad;
	}

	public Integer getIdEntidad1() {
		return this.idEntidad1;
	}

	public void setIdEntidad1(Integer idEntidad1) {
		this.idEntidad1 = idEntidad1;
	}

	public Integer getIdEntidad2() {
		return this.idEntidad2;
	}

	public void setIdEntidad2(Integer idEntidad2) {
		this.idEntidad2 = idEntidad2;
	}

	public TipoEntidad getTipoEntidad() {
		return this.tipoEntidad;
	}

	public void setTipoEntidad(TipoEntidad tipoEntidad) {
		this.tipoEntidad = tipoEntidad;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}