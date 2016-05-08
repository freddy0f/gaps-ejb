package org.ec.id.gaps.jpa.entiti.sis;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the sis_condicion_flujo database table.
 * 
 */
@Entity
@Table(name="sis_condicion_flujo")
@NamedQuery(name="CondicionFlujo.findAll", query="SELECT c FROM CondicionFlujo c")
public class CondicionFlujo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String id;

	private String aplica;

	private String descripcion;

	@Column(name="sentencia_valida")
	private String sentenciaValida;

	//bi-directional many-to-one association to Flujo
	@ManyToOne
	@JoinColumn(name="id_flujo")
	private Flujo flujo;

	public CondicionFlujo() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAplica() {
		return this.aplica;
	}

	public void setAplica(String aplica) {
		this.aplica = aplica;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getSentenciaValida() {
		return this.sentenciaValida;
	}

	public void setSentenciaValida(String sentenciaValida) {
		this.sentenciaValida = sentenciaValida;
	}

	public Flujo getFlujo() {
		return this.flujo;
	}

	public void setFlujo(Flujo flujo) {
		this.flujo = flujo;
	}

}