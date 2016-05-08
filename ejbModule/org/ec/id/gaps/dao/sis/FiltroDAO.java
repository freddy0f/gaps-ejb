package org.ec.id.gaps.dao.sis;

import javax.ejb.Local;

import org.ec.id.gaps.dao.base.Manager;
import org.ec.id.gaps.jpa.entiti.sis.ElementoVista;
import org.ec.id.gaps.jpa.entiti.sis.Filtro;
import org.ec.id.gaps.jpa.entiti.sis.User;

@Local
public interface FiltroDAO extends Manager<Filtro, Integer> {

	/**
	 * Obtiene los valores de los filtro s
	 * 
	 * @param idUser
	 * @param idTipoFiltro
	 * @param elementoSistema
	 * @param valueDefect
	 * @param filtro
	 * @return
	 * @throws Exception
	 */
	Filtro getFiltro(User idUser, String idTipoFiltro, ElementoVista elementoSistema, Object valueDefect, Filtro filtro) throws Exception;

}
