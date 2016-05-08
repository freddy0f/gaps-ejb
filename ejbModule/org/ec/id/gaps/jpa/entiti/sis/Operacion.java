package org.ec.id.gaps.jpa.entiti.sis;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.ec.id.gaps.enumeration.IconEnum;
import org.ec.id.gaps.enumeration.TipoOperacionEnum;

/**
 * The persistent class for the sis_operacion database table.
 * 
 */
@Entity
@Table(name = "sis_operacion")
@NamedQuery(name = "Operacion.findAll", query = "SELECT o FROM Operacion o")
public class Operacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String id;

	private String descripcion;

	@Column(name = "id_componente_interfaz")
	private String idComponenteInterfaz;

	@Enumerated(EnumType.STRING)
	private IconEnum imagen;

	@Column(name = "operacion_page")
	private String operacionPage;

	@Column(name = "teclado_operacion")
	private String tecladoOperacion;

	@Enumerated(EnumType.STRING)
	private TipoOperacionEnum tipo;

	// bi-directional many-to-one association to ElementoVista
	@OneToMany(mappedBy = "operacion")
	private List<ElementoVista> listaElementoVista;

	// bi-directional many-to-one association to Flujo
	@OneToMany(mappedBy = "operacion")
	private List<Flujo> listaFlujo;

	public Operacion() {
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

	public String getIdComponenteInterfaz() {
		return this.idComponenteInterfaz;
	}

	public void setIdComponenteInterfaz(String idComponenteInterfaz) {
		this.idComponenteInterfaz = idComponenteInterfaz;
	}

	public IconEnum getImagen() {
		return imagen;
	}

	public void setImagen(IconEnum imagen) {
		this.imagen = imagen;
	}

	public TipoOperacionEnum getTipo() {
		return tipo;
	}

	public void setTipo(TipoOperacionEnum tipo) {
		this.tipo = tipo;
	}

	public String getOperacionPage() {
		return this.operacionPage;
	}

	public void setOperacionPage(String operacionPage) {
		this.operacionPage = operacionPage;
	}

	public String getTecladoOperacion() {
		return this.tecladoOperacion;
	}

	public void setTecladoOperacion(String tecladoOperacion) {
		this.tecladoOperacion = tecladoOperacion;
	}

	public List<ElementoVista> getListaElementoVista() {
		return this.listaElementoVista;
	}

	public void setListaElementoVista(List<ElementoVista> listaElementoVista) {
		this.listaElementoVista = listaElementoVista;
	}

	public ElementoVista addListaElementoVista(ElementoVista listaElementoVista) {
		getListaElementoVista().add(listaElementoVista);
		listaElementoVista.setOperacion(this);

		return listaElementoVista;
	}

	public ElementoVista removeListaElementoVista(ElementoVista listaElementoVista) {
		getListaElementoVista().remove(listaElementoVista);
		listaElementoVista.setOperacion(null);

		return listaElementoVista;
	}

	public List<Flujo> getListaFlujo() {
		return this.listaFlujo;
	}

	public void setListaFlujo(List<Flujo> listaFlujo) {
		this.listaFlujo = listaFlujo;
	}

	public Flujo addListaFlujo(Flujo listaFlujo) {
		getListaFlujo().add(listaFlujo);
		listaFlujo.setOperacion(this);

		return listaFlujo;
	}

	public Flujo removeListaFlujo(Flujo listaFlujo) {
		getListaFlujo().remove(listaFlujo);
		listaFlujo.setOperacion(null);

		return listaFlujo;
	}

}