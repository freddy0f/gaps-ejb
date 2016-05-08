package org.ec.id.gaps.dao.sis;

import javax.ejb.Local;

import org.ec.id.gaps.dao.base.Manager;
import org.ec.id.gaps.jpa.entiti.sis.PerfilElementoVista;

@Local
public interface PerfilElementoVistaDAO extends Manager<PerfilElementoVista, Integer> {

	/**
	 * M�todo que verifica ejecuta el acceso total para el rol administrador
	 * 
	 * @return
	 * @throws Exception
	 */
	public Boolean executedInitScript() throws Exception;

	
}
