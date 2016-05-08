package org.ec.id.gaps.enumeration;

public enum ConstantesEnum {

	ROL_ADMIN("LLave Primaria del Rol Administrador "), LOGIN_ADMIN("Nombre de Usuario del Administrador"), PASS_ADMIN("Contraseña de Usuario del Administrador"), ADM("Administrador"), ADMIN("Usuario Administrador"), ADMINADMIN("Contraseña de Administrador");

	private String descripcion;

	private ConstantesEnum(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}
