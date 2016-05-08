package org.ec.id.gaps.jpa.entiti.sis;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.ec.id.gaps.enumeration.SiNoEnum;

/**
 * The persistent class for the sis_user_perfil database table.
 * 
 */
@Entity
@Table(name = "sis_user_perfil")


@NamedQueries(value = {
		@NamedQuery(name = "UserPerfil.findAll", query = "SELECT u FROM UserPerfil u"),
		@NamedQuery(name = "UserPerfil.findByUser", query = "SELECT up FROM UserPerfil up inner join up.user us where us.cedula=?1") })
public class UserPerfil implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Enumerated(EnumType.STRING)
	private SiNoEnum activo;

	@Enumerated(EnumType.STRING)
	@Column(name = "lectura_escritura")
	private SiNoEnum lecturaEscritura;

	@Enumerated(EnumType.STRING)
	@Column(name = "solo_lectura")
	private SiNoEnum soloLectura;

	// bi-directional many-to-one association to Perfil
	@ManyToOne
	@JoinColumn(name = "id_perfil")
	private Perfil perfil;

	// bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name = "id_user")
	private User user;

	public UserPerfil() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public SiNoEnum getActivo() {
		return this.activo;
	}

	public void setActivo(SiNoEnum activo) {
		this.activo = activo;
	}

	public SiNoEnum getLecturaEscritura() {
		return this.lecturaEscritura;
	}

	public void setLecturaEscritura(SiNoEnum lecturaEscritura) {
		this.lecturaEscritura = lecturaEscritura;
	}

	public SiNoEnum getSoloLectura() {
		return this.soloLectura;
	}

	public void setSoloLectura(SiNoEnum soloLectura) {
		this.soloLectura = soloLectura;
	}

	public Perfil getPerfil() {
		return this.perfil;
	}

	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		} else {
			UserPerfil userPerfil = (UserPerfil) obj;
			return perfil.equals(userPerfil.getPerfil()) && user.equals(userPerfil.getUser());
		}
	}

}