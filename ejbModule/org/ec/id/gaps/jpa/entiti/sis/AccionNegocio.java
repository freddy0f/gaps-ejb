package org.ec.id.gaps.jpa.entiti.sis;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the sis_accion_negocio database table.
 * 
 */
@Entity
@Table(name="sis_accion_negocio")
@NamedQuery(name="AccionNegocio.findAll", query="SELECT a FROM AccionNegocio a")
public class AccionNegocio implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String id;

	private String descripcion;

	public AccionNegocio() {
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

}