package org.ec.id.gaps.enumeration;

public enum TipoOperacionEnum {

	PDF("Documento PDF"), XLS("Documento de Excel"), HTML("Documento HTML"), PRINT("Imprimir");

	private String descripcion;

	private TipoOperacionEnum(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}
