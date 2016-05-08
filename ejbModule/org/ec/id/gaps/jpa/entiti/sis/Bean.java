package org.ec.id.gaps.jpa.entiti.sis;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the sis_bean database table.
 * 
 */
@Entity
@Table(name="sis_bean")
@NamedQuery(name="Bean.findAll", query="SELECT b FROM Bean b")
public class Bean implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="class_bean")
	private String classBean;

	private String descripcion;

	//bi-directional many-to-one association to ElementoVista
	@OneToMany(mappedBy="bean")
	private List<ElementoVista> listaElementoVista;

	public Bean() {
	}

	public String getClassBean() {
		return this.classBean;
	}

	public void setClassBean(String classBean) {
		this.classBean = classBean;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public List<ElementoVista> getListaElementoVista() {
		return this.listaElementoVista;
	}

	public void setListaElementoVista(List<ElementoVista> listaElementoVista) {
		this.listaElementoVista = listaElementoVista;
	}

	public ElementoVista addListaElementoVista(ElementoVista listaElementoVista) {
		getListaElementoVista().add(listaElementoVista);
		listaElementoVista.setBean(this);

		return listaElementoVista;
	}

	public ElementoVista removeListaElementoVista(ElementoVista listaElementoVista) {
		getListaElementoVista().remove(listaElementoVista);
		listaElementoVista.setBean(null);

		return listaElementoVista;
	}

}