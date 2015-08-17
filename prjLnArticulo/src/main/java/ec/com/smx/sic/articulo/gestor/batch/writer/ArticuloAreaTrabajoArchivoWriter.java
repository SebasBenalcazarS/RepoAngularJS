/**
 * 
 */
package ec.com.smx.sic.articulo.gestor.batch.writer;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.batch.item.ItemWriter;

import ec.com.kruger.utilitario.dao.commons.dto.SearchDTO;
import ec.com.kruger.utilitario.dao.commons.gestor.DataGestor;
import ec.com.smx.sic.cliente.common.Logeable;
import ec.com.smx.sic.cliente.common.SICConstantes;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloBitacoraCodigoBarrasDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloLocalDTO;
import ec.com.smx.sic.cliente.mdl.nopersistente.MigracionArticuloAreaTrabajoTransient;
import ec.com.smx.sic.cliente.persistencia.articulos.dao.IArticuloAlcanceDAO;

/**
 * @author jmontenegro
 *
 */
public class ArticuloAreaTrabajoArchivoWriter<T extends SearchDTO> implements ItemWriter<MigracionArticuloAreaTrabajoTransient> {

	private DataGestor dataGestor;
	private IArticuloAlcanceDAO articuloAlcanceDAO;
	
	
	
	@Override
	public void write(List<? extends MigracionArticuloAreaTrabajoTransient> migracionArticuloAreaTrabajoTransientList) throws Exception {
		
		Logeable.LOG_SICV2.info(" -->> "+migracionArticuloAreaTrabajoTransientList.size());
		
		for(MigracionArticuloAreaTrabajoTransient mAATT:migracionArticuloAreaTrabajoTransientList){
			
			if(mAATT.getEstadoAlcance().endsWith(SICConstantes.ESTADO_ACTIVO_NUMERICO)){
				
				
				ArticuloBitacoraCodigoBarrasDTO articuloBitacoraCodigoBarrasDTO=new ArticuloBitacoraCodigoBarrasDTO();
				articuloBitacoraCodigoBarrasDTO.getId().setCodigoBarras(mAATT.getCodigoBarras());
				articuloBitacoraCodigoBarrasDTO.setEstadoArticuloBitacora(SICConstantes.ESTADO_ACTIVO_NUMERICO);
				
				ArticuloBitacoraCodigoBarrasDTO arBarrasDTO=dataGestor.findUnique(articuloBitacoraCodigoBarrasDTO);
				
				if(SearchDTO.isLoaded(arBarrasDTO)){
				
					ArticuloLocalDTO articuloLocalDTO=new ArticuloLocalDTO();
					articuloLocalDTO.getId().setCodigoLocal(Integer.valueOf(mAATT.getCodigoAreaTrabajo()));
					articuloLocalDTO.getId().setCodigoCompania(1);
					articuloLocalDTO.getId().setCodigoArticulo(arBarrasDTO.getId().getCodigoArticulo());
					
					ArticuloLocalDTO artLocalDTO = dataGestor.findUnique(articuloLocalDTO);
					
					if(! SearchDTO.isLoaded(artLocalDTO)){
						
						articuloLocalDTO.setFechaRegistro(new Timestamp(System.currentTimeMillis()));
						articuloLocalDTO.setIdUsuarioRegistro(SICConstantes.USERID);
						articuloLocalDTO.setEstadoCodigoReferencia(SICConstantes.ESTADO_INACTIVO_NUMERICO);
						articuloLocalDTO.setEstadoArticuloLocal(SICConstantes.ESTADO_ACTIVO_NUMERICO);
						articuloLocalDTO.setIdUsuarioActivacion(SICConstantes.USERID);
						articuloLocalDTO.setFechaActivacion(new Date());
						articuloLocalDTO.setFechaInicialAlcance(new Date());
						articuloLocalDTO.setUserId(SICConstantes.USERID);
						articuloLocalDTO.setEstadoIntegracionAlcance(SICConstantes.ESTADO_ACTIVO_NUMERICO);
						
						dataGestor.create(articuloLocalDTO);
						
					}else{
												
						if(artLocalDTO.getEstadoArticuloLocal().equals(SICConstantes.ESTADO_INACTIVO_NUMERICO)){
							
							artLocalDTO.setIdUsuarioModificacion(SICConstantes.USERID);
							artLocalDTO.setFechaModificacion(new Timestamp(System.currentTimeMillis()));
							artLocalDTO.setIdUsuarioActivacion(SICConstantes.USERID);
							artLocalDTO.setFechaActivacion(new Date());
							artLocalDTO.setFechaInicialAlcance(new Date());
							artLocalDTO.setFechaFinalAlcance(null);
							artLocalDTO.setEstadoArticuloLocal(SICConstantes.ESTADO_ACTIVO_NUMERICO);
							artLocalDTO.setEstadoIntegracionAlcance(SICConstantes.ESTADO_ACTIVO_NUMERICO);
							
							dataGestor.update(artLocalDTO);
						}
					}
			}else if(StringUtils.isNotEmpty(mAATT.getCodigoBarras())){
				articuloAlcanceDAO.insertarCodigoBarrasNoExistentesMigracion(mAATT.getCodigoBarras());
			}
		}
	}
		
	}
	
	

	/**
	 * @return the articuloAlcanceDAO
	 */
	public IArticuloAlcanceDAO getArticuloAlcanceDAO() {
		return articuloAlcanceDAO;
	}



	/**
	 * @param articuloAlcanceDAO the articuloAlcanceDAO to set
	 */
	public void setArticuloAlcanceDAO(IArticuloAlcanceDAO articuloAlcanceDAO) {
		this.articuloAlcanceDAO = articuloAlcanceDAO;
	}



	/**
	 * @return the dataGestor
	 */
	public DataGestor getDataGestor() {
		return dataGestor;
	}

	/**
	 * @param dataGestor the dataGestor to set
	 */
	public void setDataGestor(DataGestor dataGestor) {
		this.dataGestor = dataGestor;
	}
	
}
