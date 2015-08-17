package ec.com.smx.sic.cliente.persistencia.recipientes.dao;

import java.util.Collection;
import java.util.Map;

import ec.com.smx.sic.cliente.mdl.dto.RecipienteTaraDTO;
import ec.com.smx.sic.cliente.mdl.dto.id.RecipienteTaraID;

public interface IRecipienteTaraDAO {
	
	void crearRecipienteTara(RecipienteTaraDTO ordenRecipienteTara);
	
	void actualizarRecipienteTara(RecipienteTaraDTO recipienteTaraDTO);

	RecipienteTaraDTO findRecipienteTara(Long codigoRecipienteTara);
  
    Boolean findExistsRecipienteTaraDTO(RecipienteTaraID id) ;
  
    Collection<RecipienteTaraDTO> findRecipienteTaraAll() ;
  
    Collection<RecipienteTaraDTO> findCampaniasFiltros (RecipienteTaraDTO recipienteTaraDTO,Map<String, Object> componentesMap);

}
