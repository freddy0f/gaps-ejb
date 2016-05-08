package org.ec.id.gaps.enumeration;

public enum TipoElementoVistaEnum {

	ROOT("Root"), MOD("Modulo"), TAB("Tab"), OPT("Opción"), ACC("Acción"), LIST("Lista"), EDI("Edición"), POP("Popup");

	private String descripcion;

	private TipoElementoVistaEnum(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}
