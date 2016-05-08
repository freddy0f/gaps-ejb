/**
 * 
 */
package org.ec.id.gaps.dao.sis.impl;

import javax.ejb.EJB;
import javax.ejb.Stateful;

import org.ec.id.gaps.dao.base.impl.ManagerImpl;
import org.ec.id.gaps.dao.sis.PerfilDAO;
import org.ec.id.gaps.dao.sis.UserPerfilDAO;
import org.ec.id.gaps.enumeration.ConstantesEnum;
import org.ec.id.gaps.enumeration.SiNoEnum;
import org.ec.id.gaps.jpa.entiti.sis.Perfil;
import org.ec.id.gaps.jpa.entiti.sis.User;

/**
 * @author Freddy G. Castillo C
 *
 */
@Stateful
public class PerfilDAOImpl extends ManagerImpl<Perfil, String> implements PerfilDAO {

	@EJB
	UserPerfilDAO userPerfilDAO;

	@Override
	public Perfil crearPerfil(String descripcion, String rolAdmin, User user) throws Exception {
		Perfil perfil = findByParameter("Perfil.findByCodigo", rolAdmin);

		if (perfil == null) {
			newInstance();
			getInstance().setActivo(SiNoEnum.S);
			getInstance().setCodigo(rolAdmin);
			getInstance().setDescripcion(ConstantesEnum.ADM.getDescripcion());
			perfil = guardar();
			userPerfilDAO.newInstance();
			userPerfilDAO.getInstance().setLecturaEscritura(SiNoEnum.S);
			userPerfilDAO.getInstance().setSoloLectura(SiNoEnum.N);
			userPerfilDAO.getInstance().setPerfil(perfil);
			userPerfilDAO.getInstance().setUser(user);
			userPerfilDAO.guardar();

		}
		return perfil;
	}

}
