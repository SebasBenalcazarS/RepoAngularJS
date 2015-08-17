package ec.com.smx.sic.articulo.servicio;

import java.util.Collection;
import java.util.Map;

import ec.com.kruger.utilitario.dao.commons.dto.SearchResultDTO;
import ec.com.smx.corpv2.vo.FuncionarioVO;
import ec.com.smx.frameworkv2.security.dto.UserDto;
import ec.com.smx.sic.cliente.common.annotation.HibernateTransaction;
import ec.com.smx.sic.cliente.common.articulo.EnumFormatoImpresionRegSan;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.gestor.articulo.regsan.IArticuloRegistroSanitarioGestor;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloRegistroSanitarioDTO;
import ec.com.smx.sic.cliente.mdl.dto.BitacoraRevisionRegistroSanitarioDTO;
import ec.com.smx.sic.cliente.mdl.dto.RelacionArticuloRegistroSanitarioDTO;
import ec.com.smx.sic.cliente.servicio.articulo.IArticuloRegistroSanitarioServicio;

public class ArticuloRegistroSanitarioServicio implements IArticuloRegistroSanitarioServicio {

	private IArticuloRegistroSanitarioGestor articuloRegistroSanitarioGestor;
	
	public synchronized void registrarRegistroSanitarioArticulo(Collection<RelacionArticuloRegistroSanitarioDTO> artRegSanCol) throws SICException {
		this.articuloRegistroSanitarioGestor.registrarRegistroSanitarioArticulo(artRegSanCol);
	}

	
	public synchronized void registrarRegistroSanitarioArticulo(RelacionArticuloRegistroSanitarioDTO ars) throws SICException {
		this.articuloRegistroSanitarioGestor.registrarRegistroSanitarioArticulo(ars);
	}


	/**
	 * @param articuloRegistroSanitarioGestor the articuloRegistroSanitarioGestor to set
	 */
	public void setArticuloRegistroSanitarioGestor(IArticuloRegistroSanitarioGestor articuloRegistroSanitarioGestor) {
		this.articuloRegistroSanitarioGestor = articuloRegistroSanitarioGestor;
	}


	@Override
	public SearchResultDTO<ArticuloRegistroSanitarioDTO> obtenerArticulosRegistroSanitarioPaginados(ArticuloRegistroSanitarioDTO articuloRegistroSanitarioDTO) throws SICException {
		return this.articuloRegistroSanitarioGestor.obtenerArticuloRegistroSanitarioPaginados(articuloRegistroSanitarioDTO);
	}


	@Override
	public Collection<ArticuloRegistroSanitarioDTO> obtenerArticulosRegistroSanitario(ArticuloRegistroSanitarioDTO articuloRegistroSanitarioDTO) throws SICException {
		return this.articuloRegistroSanitarioGestor.obtenerArticulosRegistroSanitario(articuloRegistroSanitarioDTO);
	}


	@Override
	public Collection<BitacoraRevisionRegistroSanitarioDTO> obtenerBitacoraRevisioRegistroSanitario(BitacoraRevisionRegistroSanitarioDTO bitacoraRevisionRegSan) throws SICException {
		return this.articuloRegistroSanitarioGestor.obtenerBitacoraRevisioRegistroSanitario(bitacoraRevisionRegSan);
	}

	public Map<String, Integer> asignarNivelesConcentracionSemaforo(Collection<RelacionArticuloRegistroSanitarioDTO> registros)throws SICException{
		return this.articuloRegistroSanitarioGestor.asignarNivelesConcentracionSemaforo(registros);
	}
	
		
	@HibernateTransaction
	public void generarArchivoImpresion(RelacionArticuloRegistroSanitarioDTO relacionArticuloRegistroSanitarioDTO,UserDto userDto,EnumFormatoImpresionRegSan enumFormatoImpresionRegSan,String remoteHost, FuncionarioVO funcionarioVO) throws SICException {
		this.articuloRegistroSanitarioGestor.generarArchivoImpresion(relacionArticuloRegistroSanitarioDTO, userDto, enumFormatoImpresionRegSan, remoteHost, funcionarioVO);
	}

	@Override
	public Collection<ArticuloRegistroSanitarioDTO> buscarRegistrosSanitariosActivos(ArticuloDTO articuloDTO)throws SICException{
		return articuloRegistroSanitarioGestor.buscarRegistrosSanitariosActivos(articuloDTO);
	}

}
