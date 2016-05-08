package org.ec.id.gaps.dao.base;

import java.io.Serializable;

public interface Manager<T extends Serializable, Pk extends Serializable> extends DAO<T, Pk> {

	void newInstance();

	T getInstance();

}
