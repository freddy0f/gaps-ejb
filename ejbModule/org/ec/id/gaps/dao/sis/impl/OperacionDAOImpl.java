/**
 * 
 */
package org.ec.id.gaps.dao.sis.impl;

import javax.ejb.Stateful;

import org.ec.id.gaps.dao.base.impl.ManagerImpl;
import org.ec.id.gaps.dao.sis.OperacionDAO;
import org.ec.id.gaps.enumeration.IconEnum;
import org.ec.id.gaps.enumeration.TipoOperacionEnum;
import org.ec.id.gaps.jpa.entiti.sis.Operacion;

/**
 * @author Freddy G. Castillo C
 *
 */
@Stateful
public class OperacionDAOImpl extends ManagerImpl<Operacion, String> implements OperacionDAO {

	@Override
	public Operacion crear(String id, String descripcion, String idComponenteInterfaz, IconEnum imagen, String operacionPage, String tecladoOperacion, TipoOperacionEnum tipo) {
		newInstance();
		getInstance().setId(id);
		getInstance().setDescripcion(descripcion);
		getInstance().setIdComponenteInterfaz(idComponenteInterfaz);
		getInstance().setImagen(imagen);
		getInstance().setOperacionPage(operacionPage);
		getInstance().setTecladoOperacion(tecladoOperacion);
		getInstance().setTipo(tipo);
		return guardar();
	}

}
