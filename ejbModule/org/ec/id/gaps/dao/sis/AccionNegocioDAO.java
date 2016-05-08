package org.ec.id.gaps.dao.sis;

import javax.ejb.Local;

import org.ec.id.gaps.dao.base.Manager;
import org.ec.id.gaps.jpa.entiti.sis.AccionNegocio;

@Local
public interface AccionNegocioDAO extends Manager<AccionNegocio, String> {

}
