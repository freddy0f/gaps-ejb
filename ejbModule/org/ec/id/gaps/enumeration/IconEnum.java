package org.ec.id.gaps.enumeration;

public enum IconEnum {

	icon_buscar("buscar");
	private String descripcion;

	private IconEnum(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}
