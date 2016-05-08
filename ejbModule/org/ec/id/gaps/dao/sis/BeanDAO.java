package org.ec.id.gaps.dao.sis;

import javax.ejb.Local;

import org.ec.id.gaps.dao.base.Manager;
import org.ec.id.gaps.jpa.entiti.sis.Bean;

@Local
public interface BeanDAO extends Manager<Bean, String> {

	public Bean crear(String id, String descripcion);

}
