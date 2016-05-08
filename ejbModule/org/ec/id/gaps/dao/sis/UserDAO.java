package org.ec.id.gaps.dao.sis;

import javax.ejb.Local;

import org.ec.id.gaps.dao.base.Manager;
import org.ec.id.gaps.jpa.entiti.sis.User;

@Local
public interface UserDAO extends Manager<User, String> {

	public User crearUsuario(String cedula, String username, String password) throws Exception;

}
