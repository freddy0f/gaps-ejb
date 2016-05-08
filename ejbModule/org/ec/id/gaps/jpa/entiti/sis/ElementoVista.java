package org.ec.id.gaps.jpa.entiti.sis;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.ec.id.gaps.enumeration.SiNoEnum;
import org.ec.id.gaps.enumeration.TipoElementoVistaEnum;

/**
 * The persistent class for the sis_elemento_vista database table.
 * 
 */
@Entity
@Table(name = "sis_elemento_vista")

@NamedQueries({ @NamedQuery(name = "ElementoVista.findAll", query = "SELECT e FROM ElementoVista e"),
		@NamedQuery(name = "ElementoVista.findAllByUser", query = "SELECT e FROM ElementoVista e WHERE e.idElementoVistaPadre=?1 AND e.tipoElemento=?2 AND e.id IN(SELECT p.elementoVista.id FROM PerfilElementoVista p WHERE p.perfil IN (SELECT per FROM Perfil per WHERE per.id IN (SELECT up.perfil.id FROM UserPerfil up WHERE up.user=?3 AND up.activo=?4 ) AND per.activo=?5) AND p.activo=?6) AND e.visible=?7") })

public class ElementoVista implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	@Column(name = "id_elemento_vista_padre")
	private Integer idElementoVistaPadre;

	private String nombre;

	private Integer orden;

	private String outcome;

	@Enumerated(EnumType.STRING)
	@Column(name = "tipo_elemento")
	private TipoElementoVistaEnum tipoElemento;

	private String url;

	@Enumerated(EnumType.STRING)
	private SiNoEnum visible;

	// bi-directional many-to-one association to Bean
	@ManyToOne
	@JoinColumn(name = "id_class_bean")
	private Bean bean;

	// bi-directional many-to-one association to Operacion
	@ManyToOne
	@JoinColumn(name = "id_sis_operacion")
	private Operacion operacion;

	// bi-directional many-to-one association to Filtro
	@OneToMany(mappedBy = "elementoVista")
	private List<Filtro> listaFiltro;

	// bi-directional many-to-one association to PerfilElementoSistema
	@OneToMany(mappedBy = "elementoVista")
	private List<PerfilElementoVista> listaPerfilElementoSistema;

	public ElementoVista() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getIdElementoVistaPadre() {
		return this.idElementoVistaPadre;
	}

	public void setIdElementoVistaPadre(Integer idElementoVistaPadre) {
		this.idElementoVistaPadre = idElementoVistaPadre;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getOrden() {
		return this.orden;
	}

	public void setOrden(Integer orden) {
		this.orden = orden;
	}

	public String getOutcome() {
		return this.outcome;
	}

	public void setOutcome(String outcome) {
		this.outcome = outcome;
	}

	public TipoElementoVistaEnum getTipoElemento() {
		return this.tipoElemento;
	}

	public void setTipoElemento(TipoElementoVistaEnum tipoElemento) {
		this.tipoElemento = tipoElemento;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public SiNoEnum getVisible() {
		return visible;
	}

	public void setVisible(SiNoEnum visible) {
		this.visible = visible;
	}

	public Bean getBean() {
		return this.bean;
	}

	public void setBean(Bean bean) {
		this.bean = bean;
	}

	public Operacion getOperacion() {
		return this.operacion;
	}

	public void setOperacion(Operacion operacion) {
		this.operacion = operacion;
	}

	public List<Filtro> getListaFiltro() {
		return this.listaFiltro;
	}

	public void setListaFiltro(List<Filtro> listaFiltro) {
		this.listaFiltro = listaFiltro;
	}

	public Filtro addListaFiltro(Filtro listaFiltro) {
		getListaFiltro().add(listaFiltro);
		listaFiltro.setElementoVista(this);

		return listaFiltro;
	}

	public Filtro removeListaFiltro(Filtro listaFiltro) {
		getListaFiltro().remove(listaFiltro);
		listaFiltro.setElementoVista(null);

		return listaFiltro;
	}

	public List<PerfilElementoVista> getListaPerfilElementoSistema() {
		return this.listaPerfilElementoSistema;
	}

	public void setListaPerfilElementoSistema(List<PerfilElementoVista> listaPerfilElementoSistema) {
		this.listaPerfilElementoSistema = listaPerfilElementoSistema;
	}

	public PerfilElementoVista addListaPerfilElementoSistema(PerfilElementoVista listaPerfilElementoSistema) {
		getListaPerfilElementoSistema().add(listaPerfilElementoSistema);
		listaPerfilElementoSistema.setElementoVista(this);

		return listaPerfilElementoSistema;
	}

	public PerfilElementoVista removeListaPerfilElementoSistema(PerfilElementoVista listaPerfilElementoSistema) {
		getListaPerfilElementoSistema().remove(listaPerfilElementoSistema);
		listaPerfilElementoSistema.setElementoVista(null);

		return listaPerfilElementoSistema;
	}

}