package ec.com.smx.sic.articulo.gestor.archivo.calculo;


import org.apache.commons.lang3.StringUtils;

import ec.com.smx.sic.cliente.common.SICConstantes;
import ec.com.smx.sic.cliente.exception.SICRuleException;
import ec.com.smx.sic.cliente.gestor.articulo.archivo.calculo.ICalculoArchivoGestor;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloDefinicionArchivoDTO;

public class CalculoArchivoGestor implements ICalculoArchivoGestor {

	/**
	 * 
	 * @param articuloDefinicionArchivoDTO
	 * @throws SICRuleException
	 */
	@Override
	public void asignarCamposArticuloArchivo(ArticuloDefinicionArchivoDTO articuloDefinicionArchivoDTO)throws SICRuleException{
		if(articuloDefinicionArchivoDTO.getNombreArchivo()== null)
			articuloDefinicionArchivoDTO.setNombreArchivo("");
		if(articuloDefinicionArchivoDTO.getDescripcionArchivo() == null)
			articuloDefinicionArchivoDTO.setDescripcionArchivo(articuloDefinicionArchivoDTO.getNombreArchivo());
		if(articuloDefinicionArchivoDTO.getTipoContenidoArchivo() == null)
			articuloDefinicionArchivoDTO.setTipoContenidoArchivo("");
		if(articuloDefinicionArchivoDTO.getTamanioArchivo() == null)
			articuloDefinicionArchivoDTO.setTamanioArchivo(0d);
		if(StringUtils.isEmpty(articuloDefinicionArchivoDTO.getEstadoArchivo()))
			articuloDefinicionArchivoDTO.setEstadoArchivo(SICConstantes.ESTADO_ACTIVO_NUMERICO);
		if(StringUtils.isNotEmpty(articuloDefinicionArchivoDTO.getValorTipoArchivo())){
			articuloDefinicionArchivoDTO.setCodigoTipoArchivo(SICConstantes.CODIGO_TIPO_ARCHIVOARTICULO);
		}
		if(articuloDefinicionArchivoDTO.getOrden()==null){
			articuloDefinicionArchivoDTO.setOrden(0);
		}
			
		
	}
}
