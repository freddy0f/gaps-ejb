/**
 * 
 */
package org.ec.id.gaps.dao.sis.impl;

import java.math.BigDecimal;
import java.util.Date;

import javax.ejb.Stateful;

import org.ec.id.gaps.dao.base.impl.ManagerImpl;
import org.ec.id.gaps.dao.sis.ParametroDAO;
import org.ec.id.gaps.jpa.entiti.sis.Parametro;

/**
 * @author Freddy G. Castillo C
 *
 */
@Stateful
public class ParametroDAOImpl extends ManagerImpl<Parametro, String> implements ParametroDAO {

	@Override
	public String findCadena(String pk) throws Exception {
		Parametro parametro = findByPk(pk);
		return parametro != null ? parametro.getValorString() : "";
	}

	@Override
	public BigDecimal findNumero(String pk) throws Exception {
		Parametro parametro = findByPk(pk);
		return parametro != null ? parametro.getValorNumerico() : null;
	}

	@Override
	public Parametro createParametro(String codigo, String descripcion, Integer valorEntero, Date valorFecha,
			BigDecimal valorNumerico, String valorString) throws Exception {
		Parametro parametro = new Parametro();
		parametro.setId(codigo);
		parametro.setDescripcion(descripcion);
		parametro.setValorEntero(valorEntero);
		parametro.setValorFecha(valorFecha);
		parametro.setValorNumerico(valorNumerico);
		parametro.setValorString(valorString);
		return guardar(parametro);
	}

	@Override
	public Parametro createParametro(String codigo, String descripcion, String valorString) throws Exception {
		return createParametro(codigo, descripcion, null, null, null, valorString);
	}
	@Override
	public String createParametroString(String codigo, String descripcion, String valorString) throws Exception {
		createParametro(codigo, descripcion, null, null, null, valorString);
		return findCadena(codigo);
	}

}
