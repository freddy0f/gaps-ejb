package org.ec.id.gaps.dao.sis;

import javax.ejb.Local;

import org.ec.id.gaps.dao.base.Manager;
import org.ec.id.gaps.jpa.entiti.sis.TipoFiltro;

@Local
public interface TipoFiltroDAO extends Manager<TipoFiltro, String> {

}
