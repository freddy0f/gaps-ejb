package org.ec.id.gaps.dao.base;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

public interface DAO<T extends Serializable, Pk extends Serializable> {

	/**
	 * Obtiene el Gestor de Pojos
	 * 
	 * @return
	 */
	abstract EntityManager em();

	/**
	 * Guarda o actualiza una nueva instancia
	 * 
	 * @return
	 */
	T guardar();

	/**
	 * Buscar mediante su Pk
	 * 
	 * @return
	 */
	T findByPk();

	/**
	 * Buscar mediante su Pk
	 * 
	 * @param id
	 * @return
	 */
	T findByPk(Pk pk);

	/**
	 * Elimina una instancia
	 * 
	 */
	void eliminar();

	/**
	 * Obtiene el la llave primaria
	 * 
	 * @return
	 */
	Pk getPk();

	/**
	 * Metodo que consulta un entidad mediante un conjunto de parametros
	 * 
	 * @param namedQuerry
	 * @param p
	 * @return
	 * @throws Exception
	 */
	public T findByParameter(String namedQuerry, Object... p) throws Exception;

	/**
	 * Setea los parametros a un Querry
	 * 
	 * @param query
	 * @param p
	 * @return
	 * @throws Exception
	 */
	Query buildParameters(Query query, Object... p) throws Exception;

	/**
	 * 
	 * @param t
	 * @return
	 */
	T guardar(T t);

	/**
	 * 
	 * @param t
	 * @return
	 */
	Pk getPk(T t);

	/**
	 * 
	 * @param namedQuerry
	 * @param p
	 * @return
	 * @throws Exception
	 */
	List<T> findListByParameter(String namedQuerry, Object... p) throws Exception;

}
