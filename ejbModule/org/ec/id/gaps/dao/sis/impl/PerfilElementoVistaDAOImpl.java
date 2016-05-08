/**
 * 
 */
package org.ec.id.gaps.dao.sis.impl;

import javax.ejb.EJB;
import javax.ejb.Stateful;

import org.ec.id.gaps.dao.base.impl.ManagerImpl;
import org.ec.id.gaps.dao.sis.BeanDAO;
import org.ec.id.gaps.dao.sis.ElementoVistaDAO;
import org.ec.id.gaps.dao.sis.OperacionDAO;
import org.ec.id.gaps.dao.sis.ParametroDAO;
import org.ec.id.gaps.dao.sis.PerfilDAO;
import org.ec.id.gaps.dao.sis.PerfilElementoVistaDAO;
import org.ec.id.gaps.dao.sis.UserDAO;
import org.ec.id.gaps.dao.sis.UserPerfilDAO;
import org.ec.id.gaps.enumeration.ConstantesEnum;
import org.ec.id.gaps.enumeration.IconEnum;
import org.ec.id.gaps.enumeration.SiNoEnum;
import org.ec.id.gaps.enumeration.TipoElementoVistaEnum;
import org.ec.id.gaps.jpa.entiti.sis.ElementoVista;
import org.ec.id.gaps.jpa.entiti.sis.Operacion;
import org.ec.id.gaps.jpa.entiti.sis.Perfil;
import org.ec.id.gaps.jpa.entiti.sis.PerfilElementoVista;

/**
 * @author Freddy G. Castillo C
 *
 */
@Stateful
public class PerfilElementoVistaDAOImpl extends ManagerImpl<PerfilElementoVista, Integer> implements PerfilElementoVistaDAO {

	@EJB
	ParametroDAO parametroDAO;

	@EJB
	PerfilDAO perfilDAO;

	@EJB
	UserDAO userDAO;

	@EJB
	ElementoVistaDAO elementoVistaDAO;

	@EJB
	UserPerfilDAO userPerfilDAO;

	@EJB
	BeanDAO beanDAO;
	@EJB
	OperacionDAO operacionDAO;

	

	@Override
	public Boolean executedInitScript() throws Exception {		
		String rolAdmin = parametroDAO.createParametroString(ConstantesEnum.ROL_ADMIN.name(), ConstantesEnum.ROL_ADMIN.getDescripcion(), ConstantesEnum.ADM.name());
		String loginAdmin = parametroDAO.createParametroString(ConstantesEnum.LOGIN_ADMIN.name(), ConstantesEnum.LOGIN_ADMIN.getDescripcion(), ConstantesEnum.ADMIN.name());
		String password = parametroDAO.createParametroString(ConstantesEnum.PASS_ADMIN.name(), ConstantesEnum.PASS_ADMIN.getDescripcion(), ConstantesEnum.ADMINADMIN.name());
		userDAO.crearUsuario(loginAdmin, loginAdmin, password);
		Operacion operacionBuscar = operacionDAO.crear("1", "Buscar", "bt_buscar", IconEnum.icon_buscar, "BUS", "Shift+B", null);
		Operacion operacionNuevo = operacionDAO.crear("1", "Buscar", "bt_buscar", IconEnum.icon_buscar, "BUS", "Shift+B", null);
		perfilDAO.crearPerfil(ConstantesEnum.ADM.getDescripcion(), rolAdmin, userDAO.getInstance());
		ElementoVista elementoVistaOpt = crearModulo(-1, 1, TipoElementoVistaEnum.MOD, "Administración", 0, perfilDAO.getInstance());
		elementoVistaOpt = crearModulo(elementoVistaOpt.getId(), 2, TipoElementoVistaEnum.TAB, "Principal", 1, perfilDAO.getInstance());
		elementoVistaOpt = crearOpcion(elementoVistaOpt.getId(), 3, TipoElementoVistaEnum.OPT, "Perfiles", 2, perfilDAO.getInstance(), "org.ec.id.gaps.seguridad.PerfilBean", "/pages/admin/perfilList.jsf");
		elementoVistaOpt = crearAccion(elementoVistaOpt.getId(), 4, TipoElementoVistaEnum.ACC, "Buscar", 3, perfilDAO.getInstance(), "/pages/admin/perfilList", operacionBuscar);
		elementoVistaOpt = crearAccion(elementoVistaOpt.getId(), 5, TipoElementoVistaEnum.ACC, "Nuevo", 4, perfilDAO.getInstance(), "/pages/admin/perfilEdit", operacionNuevo);
		return true;
	}

	public ElementoVista crearModulo(Integer elementoVistaPadre, Integer id, TipoElementoVistaEnum tipo, String nombre, Integer orden, Perfil perfil) {
		elementoVistaDAO.newInstance();
		elementoVistaDAO.getInstance().setId(id);
		elementoVistaDAO.getInstance().setTipoElemento(tipo);
		elementoVistaDAO.getInstance().setNombre(nombre);
		elementoVistaDAO.getInstance().setIdElementoVistaPadre(elementoVistaPadre);
		elementoVistaDAO.getInstance().setOrden(orden);
		elementoVistaDAO.getInstance().setVisible(SiNoEnum.S);
		Boolean existe = elementoVistaDAO.findByPk(id) != null;
		ElementoVista elementoVista = elementoVistaDAO.guardar();
		if (!existe) {
			// Se crea la relacion entre el perfil admin y la vista del root
			newInstance();
			getInstance().setActivo(SiNoEnum.S);
			getInstance().setElementoVista(elementoVistaDAO.getInstance());
			getInstance().setPerfil(perfil);
			guardar();
		}
		return elementoVista;
	}

	public ElementoVista crearOpcion(Integer elementoVistaPadre, Integer id, TipoElementoVistaEnum tipo, String nombre, Integer orden, Perfil perfil, String classBean, String url) {

		beanDAO.newInstance();
		elementoVistaDAO.newInstance();
		elementoVistaDAO.getInstance().setId(id);
		elementoVistaDAO.getInstance().setTipoElemento(tipo);
		elementoVistaDAO.getInstance().setNombre(nombre);
		elementoVistaDAO.getInstance().setIdElementoVistaPadre(elementoVistaPadre);
		elementoVistaDAO.getInstance().setOrden(orden);
		elementoVistaDAO.getInstance().setVisible(SiNoEnum.S);
		elementoVistaDAO.getInstance().setBean(beanDAO.crear(classBean, nombre));
		elementoVistaDAO.getInstance().setUrl(url);
		Boolean existe = elementoVistaDAO.findByPk(id) != null;
		ElementoVista elementoVista = elementoVistaDAO.guardar();
		if (!existe) {
			// Se crea la relacion entre el perfil admin y la vista del root
			newInstance();
			getInstance().setActivo(SiNoEnum.S);
			getInstance().setElementoVista(elementoVistaDAO.getInstance());
			getInstance().setPerfil(perfil);
			guardar();
		}
		return elementoVista;
	}

	public ElementoVista crearAccion(Integer elementoVistaPadre, Integer id, TipoElementoVistaEnum tipo, String nombre, Integer orden, Perfil perfil, String outcome, Operacion operacion) {

		beanDAO.newInstance();
		elementoVistaDAO.newInstance();
		elementoVistaDAO.getInstance().setId(id);
		elementoVistaDAO.getInstance().setTipoElemento(tipo);
		elementoVistaDAO.getInstance().setNombre(nombre);
		elementoVistaDAO.getInstance().setIdElementoVistaPadre(elementoVistaPadre);
		elementoVistaDAO.getInstance().setOrden(orden);
		elementoVistaDAO.getInstance().setVisible(SiNoEnum.S);
		elementoVistaDAO.getInstance().setOutcome(outcome);
		elementoVistaDAO.getInstance().setOperacion(operacion);
		Boolean existe = elementoVistaDAO.findByPk(id) != null;
		ElementoVista elementoVista = elementoVistaDAO.guardar();
		// Se crea la relacion entre el perfil admin y la vista del root
		if (!existe) {
			newInstance();
			getInstance().setActivo(SiNoEnum.S);
			getInstance().setElementoVista(elementoVistaDAO.getInstance());
			getInstance().setPerfil(perfil);
			guardar();
		}
		return elementoVista;
	}

}
