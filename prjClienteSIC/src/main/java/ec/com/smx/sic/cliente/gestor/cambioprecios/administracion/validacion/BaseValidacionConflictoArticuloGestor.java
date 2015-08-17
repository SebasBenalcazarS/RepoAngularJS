package ec.com.smx.sic.cliente.gestor.cambioprecios.administracion.validacion;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.lang3.StringUtils;

import ec.com.smx.sic.cliente.common.cambioprecios.beans.DatosCalculoCambioPrecio;
import ec.com.smx.sic.cliente.common.gestionprecios.constantes.SeveridadConflictoArticulo;
import ec.com.smx.sic.cliente.common.gestionprecios.constantes.TipoConflictoArticulo;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloGestionPrecioDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloProveedorGestionPrecioDTO;
import ec.com.smx.sic.cliente.mdl.dto.PrecioDiferenciadoArticuloGestionDTO;

/**
 * @author Luis Yacchirema
 *
 */
@SuppressWarnings("serial")
public abstract class BaseValidacionConflictoArticuloGestor implements IValidacionConflictoArticuloGestor {

	@Override
	public void existeConflictoArticulo(ArticuloGestionPrecioDTO articuloGestionPrecio, DatosCalculoCambioPrecio datosCalculoCambioPrecio) throws SICException {
		throw new SICException("Este m\u00E9todo no est\u00E1 implementado en la clase " + this + ", verificar...");
	}

	@Override
	public void validarConflictosArticulo(ArticuloGestionPrecioDTO articuloGestionPrecio, DatosCalculoCambioPrecio datosCalculoCambioPrecio) throws SICException {
		throw new SICException("Este m\u00E9todo no est\u00E1 implementado en la clase " + this + ", verificar...");
	}

	@Override
	public void validarConflictosArticuloProveedor(ArticuloGestionPrecioDTO articuloGestionPrecio, String codigoProveedorRelacionado) throws SICException {
		throw new SICException("Este m\u00E9todo no est\u00E1 implementado en la clase " + this + ", verificar...");
	}
	
	@Override
	public void validarConflictosPrecioDiferenciadoArticulo(ArticuloGestionPrecioDTO articuloGestionPrecio) throws SICException {
		throw new SICException("Este m\u00E9todo no est\u00E1 implementado en la clase " + this + ", verificar...");
	}
	
	@Override
	public TipoConflictoArticulo validarTipoConflictoArticulo(ArticuloGestionPrecioDTO articuloGestionPrecio, DatosCalculoCambioPrecio datosCalculoCambioPrecio) throws SICException {
		throw new SICException("Este m\u00E9todo no est\u00E1 implementado en la clase " + this + ", verificar...");
	}

	@Override
	public void validarConflictoArticuloPorTipo(ArticuloGestionPrecioDTO articuloGestionPrecio, TipoConflictoArticulo tipoConflictoArticulo) throws SICException {
		throw new SICException("Este m\u00E9todo no est\u00E1 implementado en la clase " + this + ", verificar...");
	}

	@Override
	public Collection<TipoConflictoArticulo> generarTiposConflictosArticulo(ArticuloGestionPrecioDTO articuloGestionPrecio, DatosCalculoCambioPrecio datosCalculoCambioPrecio) throws SICException {
		throw new SICException("Este m\u00E9todo no est\u00E1 implementado en la clase " + this + ", verificar...");
	}
	
	/**
	 * @param articuloGestionPrecio
	 * @param severidadConflictoArticulo
	 * @param mensajeConflictoArticulo
	 * @throws SICException
	 */
	private void establecerMensajeConflictoArticulo(ArticuloGestionPrecioDTO articuloGestionPrecio,
			SeveridadConflictoArticulo severidadConflictoArticulo, String mensajeConflictoArticulo) throws SICException {

		if (articuloGestionPrecio != null && StringUtils.isNotEmpty(mensajeConflictoArticulo)) {

			if (articuloGestionPrecio.getMensajesConflictosArticulo() == null)
				articuloGestionPrecio.setMensajesConflictosArticulo(new HashMap<SeveridadConflictoArticulo, Set<String>>());

			if (BooleanUtils.isFalse(articuloGestionPrecio.getMensajesConflictosArticulo().containsKey(severidadConflictoArticulo)))
				articuloGestionPrecio.getMensajesConflictosArticulo().put(severidadConflictoArticulo, new HashSet<String>());

			articuloGestionPrecio.getMensajesConflictosArticulo().get(severidadConflictoArticulo).add(mensajeConflictoArticulo);
		}		

	}

	/**
	 * 
	 * @param precioDiferenciadoArticulo
	 * @param severidadConflictoPrecioDiferenciado
	 * @param mensajeConflictoPrecioDiferenciado
	 * @throws SICException
	 */
	public void establecerMensajeConflictoPrecioDiferenciadoArticulo(PrecioDiferenciadoArticuloGestionDTO precioDiferenciadoArticulo,
			SeveridadConflictoArticulo severidadConflictoPrecioDiferenciado, String mensajeConflictoPrecioDiferenciado) throws SICException {
		
		if(precioDiferenciadoArticulo != null && StringUtils.isNotEmpty(mensajeConflictoPrecioDiferenciado)) {
			if(precioDiferenciadoArticulo.getMensajesConflictosPrecioDiferenciadoArticulo() == null)
				precioDiferenciadoArticulo.setMensajesConflictosPrecioDiferenciadoArticulo(new HashMap<SeveridadConflictoArticulo, Set<String>>());
			
			if(BooleanUtils.isFalse(precioDiferenciadoArticulo.getMensajesConflictosPrecioDiferenciadoArticulo().containsKey(severidadConflictoPrecioDiferenciado)))
				precioDiferenciadoArticulo.getMensajesConflictosPrecioDiferenciadoArticulo().put(severidadConflictoPrecioDiferenciado, new HashSet<String>());
			
			precioDiferenciadoArticulo.getMensajesConflictosPrecioDiferenciadoArticulo().get(severidadConflictoPrecioDiferenciado).add(mensajeConflictoPrecioDiferenciado);
		}
	}
	
	/**
	 * 
	 * @param articuloProveedorGestionPrecio
	 * @param severidadConflictoArticulo
	 * @param mensajeConflictoArticulo
	 * @throws SICException
	 */
	private void establecerMensajeConflictoArticulo(ArticuloProveedorGestionPrecioDTO articuloProveedorGestionPrecio,
			SeveridadConflictoArticulo severidadConflictoArticulo, String mensajeConflictoArticulo) throws SICException {

		if (articuloProveedorGestionPrecio != null && StringUtils.isNotEmpty(mensajeConflictoArticulo)) {
			if (articuloProveedorGestionPrecio.getMensajesConflictosArticuloProveedor() == null)
				articuloProveedorGestionPrecio.setMensajesConflictosArticuloProveedor(new HashMap<SeveridadConflictoArticulo, Set<String>>());

			if (BooleanUtils.isFalse(articuloProveedorGestionPrecio.getMensajesConflictosArticuloProveedor().containsKey(severidadConflictoArticulo)))
				articuloProveedorGestionPrecio.getMensajesConflictosArticuloProveedor().put(severidadConflictoArticulo, new HashSet<String>());

			articuloProveedorGestionPrecio.getMensajesConflictosArticuloProveedor().get(severidadConflictoArticulo).add(mensajeConflictoArticulo);
		}		
	}

	/**
	 * @param articuloGestionPrecio
	 * @param mensajeErrorConflicto
	 * @throws SICException
	 */
	public void agregarMensajeErrorConflictoArticulo(ArticuloGestionPrecioDTO articuloGestionPrecio, String mensajeErrorConflicto) throws SICException {
		this.establecerMensajeConflictoArticulo(articuloGestionPrecio, SeveridadConflictoArticulo.ERROR, mensajeErrorConflicto);
	}

	/**
	 * 
	 * @param precioDiferenciadoArticulo
	 * @param mensajeErrorConflicto
	 * @throws SICException
	 */
	public void agregarMensajeErrorConflictoPrecioDiferenciado(PrecioDiferenciadoArticuloGestionDTO precioDiferenciadoArticulo, String mensajeErrorConflicto) throws SICException {
		this.establecerMensajeConflictoPrecioDiferenciadoArticulo(precioDiferenciadoArticulo, SeveridadConflictoArticulo.ERROR, mensajeErrorConflicto);
	}
	
	/**
	 * @param articuloGestionPrecio
	 * @param mensajeAlertaConflicto
	 * @throws SICException
	 */
	public void agregarMensajeAlertaConflictoArticulo(ArticuloGestionPrecioDTO articuloGestionPrecio, String mensajeAlertaConflicto) throws SICException {
		this.establecerMensajeConflictoArticulo(articuloGestionPrecio, SeveridadConflictoArticulo.ALERTA, mensajeAlertaConflicto);
	}

	/**
	 * @param articuloGestionPrecio
	 * @param mensajeInformacionConflicto
	 * @throws SICException
	 */
	public void agregarMensajeInformacionConflictoArticulo(ArticuloGestionPrecioDTO articuloGestionPrecio, String mensajeInformacionConflicto) throws SICException {
		this.establecerMensajeConflictoArticulo(articuloGestionPrecio, SeveridadConflictoArticulo.INFORMACION, mensajeInformacionConflicto);
	}
	
	/**
	 * 
	 * @param articuloGestionPrecio
	 * @param mensajeErrorConflicto
	 * @throws SICException
	 */
	public void agregarMensajeErrorConflictoArticulo(ArticuloProveedorGestionPrecioDTO articuloProveedorGestionPrecio, String mensajeErrorConflicto) throws SICException {
		this.establecerMensajeConflictoArticulo(articuloProveedorGestionPrecio, SeveridadConflictoArticulo.ERROR, mensajeErrorConflicto);
	}

}