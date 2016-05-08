package org.ec.id.gaps.dao.sis;

import java.math.BigDecimal;
import java.util.Date;

import javax.ejb.Local;

import org.ec.id.gaps.dao.base.Manager;
import org.ec.id.gaps.jpa.entiti.sis.Parametro;

@Local
public interface ParametroDAO extends Manager<Parametro, String> {

	String findCadena(String pk) throws Exception;

	BigDecimal findNumero(String pk) throws Exception;

	/**
	 * Crea o actualiza un parametro
	 * 
	 * @param codigo
	 * @param descripcion
	 * @param valorEntero
	 * @param valorFecha
	 * @param valorNumerico
	 * @param valorString
	 * @return
	 * @throws Exception
	 */
	public Parametro createParametro(String codigo, String descripcion, Integer valorEntero, Date valorFecha,
			BigDecimal valorNumerico, String valorString) throws Exception;

	/**
	 * Crea o actualzia un valor String
	 * 
	 * @param codigo
	 * @param descripcion
	 * @param valorString
	 * @return
	 * @throws Exception
	 */
	public Parametro createParametro(String codigo, String descripcion, String valorString) throws Exception;

	/**
	 * 
	 * @param codigo
	 * @param descripcion
	 * @param valorString
	 * @return
	 * @throws Exception
	 */
	String createParametroString(String codigo, String descripcion, String valorString) throws Exception;
}
