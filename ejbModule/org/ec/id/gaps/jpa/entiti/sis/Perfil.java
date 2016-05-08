package org.ec.id.gaps.jpa.entiti.sis;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.ec.id.gaps.enumeration.SiNoEnum;

/**
 * The persistent class for the sis_perfil database table.
 * 
 */
@Entity
@Table(name = "sis_perfil")
@NamedQueries(value = { @NamedQuery(name = "Perfil.findByCodigo", query = "select p from Perfil p where p.codigo=?1 "),
		@NamedQuery(name = "Perfil.findAll", query = "SELECT p FROM Perfil p") })
public class Perfil implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Enumerated(EnumType.STRING)
	private SiNoEnum activo;

	private String descripcion;

	private String codigo;

	// bi-directional many-to-one association to PerfilElementoSistema
	@OneToMany(mappedBy = "perfil")
	private List<PerfilElementoVista> listaPerfilElementoSistema;

	// bi-directional many-to-one association to UserPerfil
	@OneToMany(mappedBy = "perfil")
	private List<UserPerfil> listaUserPerfil;

	public Perfil() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public SiNoEnum getActivo() {
		return activo;
	}

	public void setActivo(SiNoEnum activo) {
		this.activo = activo;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public List<PerfilElementoVista> getListaPerfilElementoSistema() {
		return this.listaPerfilElementoSistema;
	}

	public void setListaPerfilElementoSistema(List<PerfilElementoVista> listaPerfilElementoSistema) {
		this.listaPerfilElementoSistema = listaPerfilElementoSistema;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public PerfilElementoVista addListaPerfilElementoSistema(PerfilElementoVista listaPerfilElementoSistema) {
		getListaPerfilElementoSistema().add(listaPerfilElementoSistema);
		listaPerfilElementoSistema.setPerfil(this);

		return listaPerfilElementoSistema;
	}

	public PerfilElementoVista removeListaPerfilElementoSistema(PerfilElementoVista listaPerfilElementoSistema) {
		getListaPerfilElementoSistema().remove(listaPerfilElementoSistema);
		listaPerfilElementoSistema.setPerfil(null);

		return listaPerfilElementoSistema;
	}

	public List<UserPerfil> getListaUserPerfil() {
		return this.listaUserPerfil;
	}

	public void setListaUserPerfil(List<UserPerfil> listaUserPerfil) {
		this.listaUserPerfil = listaUserPerfil;
	}

	public UserPerfil addListaUserPerfil(UserPerfil listaUserPerfil) {
		getListaUserPerfil().add(listaUserPerfil);
		listaUserPerfil.setPerfil(this);

		return listaUserPerfil;
	}

	public UserPerfil removeListaUserPerfil(UserPerfil listaUserPerfil) {
		getListaUserPerfil().remove(listaUserPerfil);
		listaUserPerfil.setPerfil(null);

		return listaUserPerfil;
	}

	@Override
	public boolean equals(Object obj) {
		Perfil perfil = (Perfil) obj;
		return id.equals(perfil.id);
	}

}