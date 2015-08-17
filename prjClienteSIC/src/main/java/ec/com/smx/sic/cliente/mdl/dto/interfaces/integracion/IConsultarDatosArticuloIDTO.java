package ec.com.smx.sic.cliente.mdl.dto.interfaces.integracion;

public interface IConsultarDatosArticuloIDTO {

	/*getters and setters*/
	public abstract Integer getCodigoProveedor();

	public abstract void setCodigoProveedor(Integer codigoProveedor);

	public abstract Integer getFechaElaboracion();

	public abstract void setFechaElaboracion(Integer fechaElaboracion);

	public abstract Integer getFechaEntrega();

	public abstract void setFechaEntrega(Integer fechaEntrega);

	public abstract Integer getFechaCaducidad();

	public abstract void setFechaCaducidad(Integer fechaCaducidad);

	public abstract Integer getUnidadOperativa();

	public abstract void setUnidadOperativa(Integer unidadOperativa);

	public abstract Integer getSubBodega();

	public abstract void setSubBodega(Integer subBodega);

	public abstract String getTipoFrecuencia();

	public abstract void setTipoFrecuencia(String tipoFrecuencia);

	public abstract String getModoCreacion();

	public abstract void setModoCreacion(String modoCreacion);

	public abstract String getFechaRotacion1();

	public abstract void setFechaRotacion1(String fechaRotacion1);

	public abstract String getFechaRotacion2();

	public abstract void setFechaRotacion2(String fechaRotacion2);

	public abstract String getFechaRotacion3();

	public abstract void setFechaRotacion3(String fechaRotacion3);

	public abstract String getFechaRotacion4();

	public abstract void setFechaRotacion4(String fechaRotacion4);

	public abstract String getFechaRotacion5();

	public abstract void setFechaRotacion5(String fechaRotacion5);

	public abstract String getFechaRotacion6();

	public abstract void setFechaRotacion6(String fechaRotacion6);
	
	public abstract Integer getTiempoStock();
	
	public abstract void setTiempoStock(Integer tiempoStock);	
}