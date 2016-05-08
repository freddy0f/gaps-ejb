/**
 * 
 */
package org.ec.id.gaps.dao.sis.impl;

import java.util.Calendar;

import javax.ejb.Stateful;

import org.ec.id.gaps.dao.base.impl.ManagerImpl;
import org.ec.id.gaps.dao.sis.UserDAO;
import org.ec.id.gaps.enumeration.SiNoEnum;
import org.ec.id.gaps.jpa.entiti.sis.User;
import org.ec.id.gaps.util.Utilitario;

/**
 * @author Freddy G. Castillo C
 *
 */
@Stateful
public class UserDAOImpl extends ManagerImpl<User, String> implements UserDAO {

	@Override
	public User crearUsuario(String cedula, String username, String password) throws Exception {
		newInstance();
		getInstance().setCedula(cedula.toLowerCase());
		getInstance().setUsername(cedula.toLowerCase());
		getInstance().setFechaRegistro(Calendar.getInstance().getTime());
		getInstance().setContrasenia(Utilitario.getMD5_Base64(password.toLowerCase()));
		getInstance().setEstado(SiNoEnum.ACT.name());
		return guardar();
	}

}
