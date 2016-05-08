package org.ec.id.gaps.jpa.entiti.sis;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * The persistent class for the sis_user database table.
 * 
 */
@Entity
@Table(name = "sis_user")

@NamedQueries({@NamedQuery(name = "User.findAll", query = "SELECT u FROM User u"),@NamedQuery(name = "User.findByLogin", query = "SELECT u FROM User u where u.username=?1")})
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String cedula;

	private String contrasenia;

	private String email;

	private String estado;

	@Temporal(TemporalType.DATE)
	@Column(name = "fecha_registro")
	private Date fechaRegistro;

	private String username;

	// bi-directional many-to-one association to AuditoriaEntidad
	@OneToMany(mappedBy = "user")
	private List<AuditoriaEntidad> listaAuditoriaEntidad;

	// bi-directional many-to-one association to Filtro
	@OneToMany(mappedBy = "user")
	private List<Filtro> listaFiltro;

	// bi-directional many-to-one association to UserPerfil
	@OneToMany(mappedBy = "user")
	private List<UserPerfil> listaUserPerfil;

	public User() {
	}

	public String getCedula() {
		return this.cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getContrasenia() {
		return this.contrasenia;
	}

	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Date getFechaRegistro() {
		return this.fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<AuditoriaEntidad> getListaAuditoriaEntidad() {
		return this.listaAuditoriaEntidad;
	}

	public void setListaAuditoriaEntidad(List<AuditoriaEntidad> listaAuditoriaEntidad) {
		this.listaAuditoriaEntidad = listaAuditoriaEntidad;
	}

	public AuditoriaEntidad addListaAuditoriaEntidad(AuditoriaEntidad listaAuditoriaEntidad) {
		getListaAuditoriaEntidad().add(listaAuditoriaEntidad);
		listaAuditoriaEntidad.setUser(this);

		return listaAuditoriaEntidad;
	}

	public AuditoriaEntidad removeListaAuditoriaEntidad(AuditoriaEntidad listaAuditoriaEntidad) {
		getListaAuditoriaEntidad().remove(listaAuditoriaEntidad);
		listaAuditoriaEntidad.setUser(null);

		return listaAuditoriaEntidad;
	}

	public List<Filtro> getListaFiltro() {
		return this.listaFiltro;
	}

	public void setListaFiltro(List<Filtro> listaFiltro) {
		this.listaFiltro = listaFiltro;
	}

	public Filtro addListaFiltro(Filtro listaFiltro) {
		getListaFiltro().add(listaFiltro);
		listaFiltro.setUser(this);

		return listaFiltro;
	}

	public Filtro removeListaFiltro(Filtro listaFiltro) {
		getListaFiltro().remove(listaFiltro);
		listaFiltro.setUser(null);

		return listaFiltro;
	}

	public List<UserPerfil> getListaUserPerfil() {
		return this.listaUserPerfil;
	}

	public void setListaUserPerfil(List<UserPerfil> listaUserPerfil) {
		this.listaUserPerfil = listaUserPerfil;
	}

	public UserPerfil addListaUserPerfil(UserPerfil listaUserPerfil) {
		getListaUserPerfil().add(listaUserPerfil);
		listaUserPerfil.setUser(this);

		return listaUserPerfil;
	}

	public UserPerfil removeListaUserPerfil(UserPerfil listaUserPerfil) {
		getListaUserPerfil().remove(listaUserPerfil);
		listaUserPerfil.setUser(null);

		return listaUserPerfil;
	}

	@Override
	public boolean equals(Object obj) {
		User user = (User) obj;
		return cedula.equals(user.cedula);
	}

}