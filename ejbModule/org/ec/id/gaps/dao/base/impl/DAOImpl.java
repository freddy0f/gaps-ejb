/**
 * 
 */
package org.ec.id.gaps.dao.base.impl;

import java.beans.PropertyDescriptor;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import javax.annotation.Resource;
import javax.ejb.SessionContext;
import javax.persistence.Id;
import javax.persistence.Query;

import org.ec.id.gaps.dao.base.DAO;

/**
 * @author Freddy G. Castillo C
 *
 */
@SuppressWarnings("all")
public abstract class DAOImpl<T extends Serializable, Pk extends Serializable> implements DAO<T, Pk> {

	protected Class<T> entityClass;
	protected Class<Pk> pkClass;
	protected T instance;
	protected Pk pk;
	
	@Resource
	SessionContext sessionContext;

	public DAOImpl() {
		ParameterizedType genericSuperclass = (ParameterizedType) getClass().getGenericSuperclass();
		Type[] genericInterfaces = genericSuperclass.getActualTypeArguments();
		entityClass = (Class<T>) genericInterfaces[0];
		pkClass = (Class<Pk>) genericInterfaces[1];
	}

	@Override
	public T guardar() {
		if (getPk() != null && em().find(entityClass, getPk()) != null) {
			return em().merge(instance);
		} else {
			em().persist(instance);
			em().flush();
		}
		return instance;
	}

	@Override
	public T guardar(T t) {
		if (getPk(t) != null && em().find(entityClass, getPk(t)) != null) {
			return em().merge(t);
		} else {
			em().persist(t);
		}
		return t;
	}

	@Override
	public T findByPk() {
		return em().find(entityClass, pk != null ? pk : getPk());
	}

	@Override
	public T findByPk(Pk pk) {
		this.pk = pk;
		return findByPk();
	}

	@Override
	public void eliminar() {
		instance = em().merge(instance);
		em().remove(instance);
	}

	@Override
	public T findByParameter(String namedQuerry, Object... p) throws Exception {
		System.out.println(sessionContext.getCallerPrincipal().getName());
		Query query = em().createNamedQuery(namedQuerry);
		query = buildParameters(query, p);
		List<T> list = query.getResultList();
		if (!list.isEmpty()) {
			return list.get(0);
		} else {
			return null;
		}

	}

	@Override
	public List<T> findListByParameter(String namedQuerry, Object... p) throws Exception {
		Query query = em().createNamedQuery(namedQuerry);
		query = buildParameters(query, p);
		return query.getResultList();
	}

	@Override
	public Query buildParameters(Query query, Object... p) throws Exception {
		if (p != null) {
			for (int i = 0; i < p.length; i++) {
				query.setParameter(i + 1, p[i]);
			}
		}
		return query;
	}

	@Override
	public Pk getPk() {
		try {
			for (Field field : entityClass.getDeclaredFields()) {
				Id anotationId = field.getAnnotation(Id.class);
				if (anotationId instanceof Id) {
					PropertyDescriptor pd = new PropertyDescriptor(field.getName(), entityClass);
					Method getter = pd.getReadMethod();
					Object f = getter.invoke(instance);
					return (Pk) f;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Pk getPk(T t) {
		try {
			for (Field field : entityClass.getDeclaredFields()) {
				Id anotationId = field.getAnnotation(Id.class);
				if (anotationId instanceof Id) {
					PropertyDescriptor pd = new PropertyDescriptor(field.getName(), entityClass);
					Method getter = pd.getReadMethod();
					Object f = getter.invoke(t);
					return (Pk) f;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
