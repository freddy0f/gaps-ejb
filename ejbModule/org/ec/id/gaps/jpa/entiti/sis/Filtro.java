package org.ec.id.gaps.jpa.entiti.sis;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

/**
 * The persistent class for the sis_filtro database table.
 * 
 */
@Entity
@Table(name = "sis_filtro")
@NamedQueries({ @NamedQuery(name = "Filtro.findByTipoAndUser", query = "SELECT f FROM Filtro f INNER JOIN f.tipoFiltro tp INNER JOIN f.user u inner join f.elementoVista e WHERE tp=?1 and u=?2 and e=?3") })

public class Filtro implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "valor_boolean")
	private Boolean valorBoolean;

	@Column(name = "valor_cadena")
	private String valorCadena;

	@Column(name = "valor_entero")
	private Integer valorEntero;

	@Temporal(TemporalType.DATE)
	@Column(name = "valor_fecha")
	private Date valorFecha;

	@Column(name = "valor_numerico")
	private BigDecimal valorNumerico;

	// bi-directional many-to-one association to ElementoVista
	@ManyToOne
	@JoinColumn(name = "id_sis_elemento_vista")
	private ElementoVista elementoVista;

	// bi-directional many-to-one association to TipoFiltro
	@ManyToOne
	@JoinColumn(name = "codigo")
	private TipoFiltro tipoFiltro;

	// bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name = "id_usuario")
	private User user;

	public Filtro() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Boolean getValorBoolean() {
		return this.valorBoolean;
	}

	public void setValorBoolean(Boolean valorBoolean) {
		this.valorBoolean = valorBoolean;
	}

	public String getValorCadena() {
		return this.valorCadena;
	}

	public void setValorCadena(String valorCadena) {
		this.valorCadena = valorCadena;
	}

	public Integer getValorEntero() {
		return this.valorEntero;
	}

	public void setValorEntero(Integer valorEntero) {
		this.valorEntero = valorEntero;
	}

	public Date getValorFecha() {
		return this.valorFecha;
	}

	public void setValorFecha(Date valorFecha) {
		this.valorFecha = valorFecha;
	}

	public BigDecimal getValorNumerico() {
		return this.valorNumerico;
	}

	public void setValorNumerico(BigDecimal valorNumerico) {
		this.valorNumerico = valorNumerico;
	}

	public ElementoVista getElementoVista() {
		return this.elementoVista;
	}

	public void setElementoVista(ElementoVista elementoVista) {
		this.elementoVista = elementoVista;
	}

	public TipoFiltro getTipoFiltro() {
		return this.tipoFiltro;
	}

	public void setTipoFiltro(TipoFiltro tipoFiltro) {
		this.tipoFiltro = tipoFiltro;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}