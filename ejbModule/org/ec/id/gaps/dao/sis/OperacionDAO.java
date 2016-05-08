package org.ec.id.gaps.dao.sis;

import javax.ejb.Local;

import org.ec.id.gaps.dao.base.Manager;
import org.ec.id.gaps.enumeration.IconEnum;
import org.ec.id.gaps.enumeration.TipoOperacionEnum;
import org.ec.id.gaps.jpa.entiti.sis.Operacion;

@Local
public interface OperacionDAO extends Manager<Operacion, String> {

	public Operacion crear(String id, String descripcion, String idComponenteInterfaz, IconEnum imagen, String operacionPage, String tecladoOperacion, TipoOperacionEnum tipo);
}
