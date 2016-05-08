package org.ec.id.gaps.jpa.entiti.sis;

import java.io.Serializable;
import javax.persistence.*;

import org.ec.id.gaps.enumeration.SiNoEnum;

/**
 * The persistent class for the sis_perfil_elemento_sistema database table.
 * 
 */
@Entity
@Table(name = "sis_perfil_elemento_vista")

@NamedQueries(value = {
		@NamedQuery(name = "PerfilElementoVista.findByUserAndRol", query = "select pes from PerfilElementoVista pes inner join pes.perfil per inner join per.listaUserPerfil uper inner join uper.user u where u.username= ?1"),
		@NamedQuery(name = "PerfilElementoVista.findAll", query = "SELECT p FROM PerfilElementoVista p") })

public class PerfilElementoVista implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Enumerated(EnumType.STRING)
	private SiNoEnum activo;

	// bi-directional many-to-one association to ElementoVista
	@ManyToOne
	@JoinColumn(name = "id_elemento_vista")
	private ElementoVista elementoVista;

	// bi-directional many-to-one association to Perfil
	@ManyToOne
	@JoinColumn(name = "id_perfil")
	private Perfil perfil;

	public PerfilElementoVista() {
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

	public ElementoVista getElementoVista() {
		return this.elementoVista;
	}

	public void setElementoVista(ElementoVista elementoVista) {
		this.elementoVista = elementoVista;
	}

	public Perfil getPerfil() {
		return this.perfil;
	}

	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		else {
			PerfilElementoVista other = (PerfilElementoVista) obj;
			return perfil.equals(other.perfil) && elementoVista.equals(other.elementoVista);
		}
	}

}