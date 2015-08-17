package ec.com.smx.sic.cliente.mdl.dto.id.b2b;

import java.io.Serializable;

import javax.persistence.Embeddable;

/**
 * Clase que encapsula a las propiedades Identificadoras de la clase PedidoHistorico
 * @see ec.com.smx.b2b.dto.PedidoHistorico
 *
 * @author kruger
 */
@SuppressWarnings("serial")
@Embeddable
@Deprecated
public class PedidoHistoricoID implements Serializable
{
	
	/**
	 * codigo de la compania
	 */
	private Integer codigoCompania ;
	
	/**
	 * codigo del pedido
	 */
	private java.lang.Long codigoPedido ;
	
	/**
	 * Numero de Pedido en SIC
	 */
	private java.lang.Long numeroPedido ;
	
	/**
	 * Secuencia del historico
	 */
	private Integer secuenciaHistorico ;
	
	public Integer getCodigoCompania() 
	{
		return codigoCompania;
	}


	public void setCodigoCompania(Integer codigoCompania) 
	{
		this.codigoCompania = codigoCompania;
	}

	public java.lang.Long getCodigoPedido() 
	{
		return codigoPedido;
	}

	public void setCodigoPedido(java.lang.Long codigoPedido) 
	{
		this.codigoPedido = codigoPedido;
	}

	public java.lang.Long getNumeroPedido() 
	{
		return numeroPedido;
	}


	public void setNumeroPedido(java.lang.Long numeroPedido) 
	{
		this.numeroPedido = numeroPedido;
	}


	public Integer getSecuenciaHistorico() 
	{
		return secuenciaHistorico;
	}


	public void setSecuenciaHistorico(Integer secuenciaHistorico) 
	{
		this.secuenciaHistorico = secuenciaHistorico;
	}


	/* *
	 * (sin Javadoc)
	 * @see ec.com.smx.b2b.commons.dto.id.AbstractaID#configureColIds()
	 */
	/*public void configureColIds() 
	{
		super.resetCollection();
	    
		super.addElement(this.codigoCompania);	    	
		    
		super.addElement(this.codigoPedido);	
		
		super.addElement(this.numeroPedido);	
		
		super.addElement(this.secuenciaHistorico);
		    
		super.collectionToArray();
		
	}*/
}
