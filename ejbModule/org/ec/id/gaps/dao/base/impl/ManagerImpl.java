/**
 * 
 */
package org.ec.id.gaps.dao.base.impl;

import java.io.Serializable;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.ec.id.gaps.dao.base.Manager;

/**
 * @author Freddy G. Castillo C
 *
 */
public class ManagerImpl<T extends Serializable, Pk extends Serializable> extends DAOImpl<T, Pk>
		implements Manager<T, Pk> {

	@PersistenceContext(name = "pugaps")
	protected EntityManager entityManager;

	@Override
	public EntityManager em() {
		return entityManager;
	}

	@Override
	public void newInstance() {
		try {
			instance = entityClass.newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public T getInstance() {
		return instance;
	}

}
