package ec.com.smx.sic.cliente.mdl.dto;

import java.io.Serializable;
import java.util.List;

public class VistaResumenPalletsNavesSubnaves implements Serializable 
{
	private static final long serialVersionUID = -1015304290279615515L;
	
	private Long codigoDetalleSeccion;
	private String identificador;
	private Long totalPallets;
	private boolean colapsado;
	private List<VistaResumenPalletsNavesSubnaves> subnaves;
	
	public Long getCodigoDetalleSeccion() 
	{
		return codigoDetalleSeccion;
	}
	public void setCodigoDetalleSeccion(Long codigoDetalleSeccion) 
	{
		this.codigoDetalleSeccion = codigoDetalleSeccion;
	}
	public String getIdentificador() 
	{
		return identificador;
	}
	public void setIdentificador(String identificador) 
	{
		this.identificador = identificador;
	}
	public Long getTotalPallets() 
	{
		if(totalPallets == null && subnaves != null && subnaves.size() > 0)
		{
			Long suma = 0L;
			for(VistaResumenPalletsNavesSubnaves item : subnaves)
			{
				suma = suma + item.getTotalPallets();
			}
			return suma;
		}
		return totalPallets;
	}
	public void setTotalPallets(Long totalPallets) 
	{
		this.totalPallets = totalPallets;
	}
	public boolean isColapsado() 
	{
		return colapsado;
	}
	public void setColapsado(boolean colapsado) 
	{
		this.colapsado = colapsado;
	}
	public List<VistaResumenPalletsNavesSubnaves> getSubnaves() 
	{
		return subnaves;
	}
	public void setSubnaves(List<VistaResumenPalletsNavesSubnaves> subnaves) 
	{
		this.subnaves = subnaves;
	}
}