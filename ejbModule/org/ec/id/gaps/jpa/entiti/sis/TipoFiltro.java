package org.ec.id.gaps.jpa.entiti.sis;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the sis_tipo_filtro database table.
 * 
 */
@Entity
@Table(name="sis_tipo_filtro")
@NamedQuery(name="TipoFiltro.findAll", query="SELECT t FROM TipoFiltro t")
public class TipoFiltro implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String id;

	private String descripcion;

	//bi-directional many-to-one association to Filtro
	@OneToMany(mappedBy="tipoFiltro")
	private List<Filtro> listaFiltro;

	public TipoFiltro() {
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

	public List<Filtro> getListaFiltro() {
		return this.listaFiltro;
	}

	public void setListaFiltro(List<Filtro> listaFiltro) {
		this.listaFiltro = listaFiltro;
	}

	public Filtro addListaFiltro(Filtro listaFiltro) {
		getListaFiltro().add(listaFiltro);
		listaFiltro.setTipoFiltro(this);

		return listaFiltro;
	}

	public Filtro removeListaFiltro(Filtro listaFiltro) {
		getListaFiltro().remove(listaFiltro);
		listaFiltro.setTipoFiltro(null);

		return listaFiltro;
	}

}