package ec.com.smx.sic.cliente.persistencia.recargacupon;

import java.util.Collection;

import ec.com.smx.corpv2.dto.CatalogoValorDTO;
import ec.com.smx.sic.cliente.exception.SICException;

public interface ICatalogoValorDAO {

	/**
	 * permite consultar los catalogos de estructura logistica
	 * @param codigoCatalogoTipo
	 * @return
	 * @throws SICException
	 */
	public Collection<CatalogoValorDTO> consultarCatalogoValor(Integer codigoCatalogoTipo)throws SICException;
	
	/**
	 * permite consultar un catalogo de estructura logistica
	 * @param codigoCatalogoTipo
	 * @return catalogoValorDTO
	 * @throws SICException
	 */
	public CatalogoValorDTO consultarCatalogoValorUnico(CatalogoValorDTO catalogo)throws SICException;
	/**
	 * Permite consultar solo la estructura logistica uniendose con el agrupador de los catalogos
	 * @param codigoCatalogoTipo
	 * @return
	 * @throws SICException
	 */
	public Collection<CatalogoValorDTO> consultarCatalogoValorEstructuraLogistica(Integer codigoCatalogoTipo)throws SICException;
}
