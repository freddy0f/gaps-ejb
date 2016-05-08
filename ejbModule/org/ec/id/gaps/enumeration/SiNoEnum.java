package org.ec.id.gaps.enumeration;

public enum SiNoEnum {

	S("Si"), N("No"), ACT("Activo"), INAC("Inactivo");
	private String descripcion;

	private SiNoEnum(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}
