/**
 * 
 */
package org.ec.id.gaps.dao.sis.impl;

import java.math.BigDecimal;
import java.util.Date;

import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.SessionContext;
import javax.ejb.Stateful;

import org.ec.id.gaps.dao.base.impl.ManagerImpl;
import org.ec.id.gaps.dao.sis.FiltroDAO;
import org.ec.id.gaps.dao.sis.TipoFiltroDAO;
import org.ec.id.gaps.jpa.entiti.sis.ElementoVista;
import org.ec.id.gaps.jpa.entiti.sis.Filtro;
import org.ec.id.gaps.jpa.entiti.sis.TipoFiltro;
import org.ec.id.gaps.jpa.entiti.sis.User;

/**
 * @author Freddy G. Castillo C
 *
 */
@Stateful
public class FiltroDAOImpl extends ManagerImpl<Filtro, Integer> implements FiltroDAO {

	@EJB
	private TipoFiltroDAO tipoFiltroDAO;

	@Resource
	SessionContext sessionContext;

	@Override
	public Filtro getFiltro(User idUser, String idTipoFiltro, ElementoVista elementoSistema, Object valueDefect, Filtro filtro) throws Exception {
		TipoFiltro tipoFiltro = tipoFiltroDAO.findByPk(idTipoFiltro);
		if (tipoFiltro == null) {
			tipoFiltro = new TipoFiltro();
			tipoFiltro.setId(idTipoFiltro);
			tipoFiltro.setDescripcion(idTipoFiltro);
			tipoFiltroDAO.guardar(tipoFiltro);
		}
		Filtro filtroFirst = findByParameter("Filtro.findByTipoAndUser", tipoFiltro, idUser, elementoSistema);

		if (valueDefect != null) {
			if (valueDefect instanceof Integer)
				filtro.setValorEntero((Integer) valueDefect);
			if (valueDefect instanceof String)
				filtro.setValorCadena(valueDefect.toString());
			if (valueDefect instanceof BigDecimal)
				filtro.setValorNumerico((BigDecimal) valueDefect);
			if (valueDefect instanceof Date)
				filtro.setValorFecha((Date) valueDefect);
		}
		if (filtroFirst != null && filtro.getId() == null) {
			filtro.setValorEntero(filtroFirst.getValorEntero());
			filtro.setValorCadena(filtroFirst.getValorCadena());
			filtro.setValorNumerico((BigDecimal) filtroFirst.getValorNumerico());
			filtro.setValorFecha((Date) filtroFirst.getValorFecha());
			filtro.setId(filtroFirst.getId());
		}
		filtro.setTipoFiltro(tipoFiltro);
		filtro.setElementoVista(elementoSistema);
		filtro.setUser(idUser);
		return

		guardar(filtro);
	}
}
