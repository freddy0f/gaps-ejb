package org.ec.id.gaps.dao.sis;

import javax.ejb.Local;

import org.ec.id.gaps.dao.base.Manager;
import org.ec.id.gaps.jpa.entiti.sis.Perfil;
import org.ec.id.gaps.jpa.entiti.sis.User;

@Local
public interface PerfilDAO extends Manager<Perfil, String> {

	Perfil crearPerfil(String descripcion, String codigo, User user) throws Exception;

}
