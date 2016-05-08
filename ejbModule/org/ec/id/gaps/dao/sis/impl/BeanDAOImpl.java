/**
 * 
 */
package org.ec.id.gaps.dao.sis.impl;

import javax.ejb.Stateful;

import org.ec.id.gaps.dao.base.impl.ManagerImpl;
import org.ec.id.gaps.dao.sis.BeanDAO;
import org.ec.id.gaps.jpa.entiti.sis.Bean;

/**
 * @author Freddy G. Castillo C
 *
 */
@Stateful
public class BeanDAOImpl extends ManagerImpl<Bean, String> implements BeanDAO {

	@Override
	public Bean crear(String id, String descripcion) {
		// TODO Auto-generated method stub
		newInstance();
		getInstance().setClassBean(id);
		getInstance().setDescripcion(descripcion);
		return guardar();
	}

}
