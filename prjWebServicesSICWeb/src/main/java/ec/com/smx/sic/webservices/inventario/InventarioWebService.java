package ec.com.smx.sic.webservices.inventario;

import static ec.com.smx.sic.cliente.common.Logeable.LOG_SICV2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import ec.com.smx.corpv2.dto.AreaTrabajoDTO;
import ec.com.smx.corpv2.dto.CatalogoValorDTO;
import ec.com.smx.corpv2.dto.TipoTransaccionAreaTrabajoDTO;
import ec.com.smx.corpv2.dto.TransaccionCausalDTO;
import ec.com.smx.corpv2.dto.TransaccionCausalRelacionDTO;
import ec.com.smx.framework.ad.json.JsonPojoMapper;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.inventario.cliente.common.factory.InventarioFactory;

/**
 * Web services para proyecto inventarios
 * @author osaransig
 * Mar 20, 2014
 */

@Controller
@RequestMapping("/ws/inventario")
@Scope(value = "request")
public class InventarioWebService {



	@RequestMapping(value = "/permisos", method = RequestMethod.GET, headers = "Accept= application/json")
	public @ResponseBody
	ResponseEntity<String> findPermisosTipoTransacion(
			@RequestParam(value = "codigoTipTraTipAre", required = true) Integer codigoTipTraTipoAre) {

		LOG_SICV2.info("Inicio web service find permisos, codigoTipTraTipAre: {}", codigoTipTraTipoAre);

		HttpHeaders headers = new HttpHeaders();

		headers.add("Content-Type", "text/html; charset=utf-8");

		return new ResponseEntity<String>(consultaDatosFormatoJSON(codigoTipTraTipoAre), headers, HttpStatus.OK);
	}

	public String consultaDatosFormatoJSON(Integer codigoTipTraTipoAre) throws SICException {

		try {
			TipoTransaccionAreaTrabajoDTO tipoTransaccionAreaTrabajoDTO = new TipoTransaccionAreaTrabajoDTO();
			tipoTransaccionAreaTrabajoDTO.setCodigoTipoTrabajoTipoAreTrabajo(codigoTipTraTipoAre);
			tipoTransaccionAreaTrabajoDTO.setAreaTrabajoDTO(new AreaTrabajoDTO());
			tipoTransaccionAreaTrabajoDTO.setEtapaAfectacion(new CatalogoValorDTO());

			Collection<TipoTransaccionAreaTrabajoDTO> resp = InventarioFactory.getInstancia().getDataService().findObjects(tipoTransaccionAreaTrabajoDTO);

			Collection<TipoTransaccionAreaTrabajo> respFormat = new ArrayList<InventarioWebService.TipoTransaccionAreaTrabajo>();

			Integer index = 1;

			for (TipoTransaccionAreaTrabajoDTO tipoTraAreTra : resp) {
				TipoTransaccionAreaTrabajo nuevoTipo = new TipoTransaccionAreaTrabajo();
				nuevoTipo.setIndex(index);
				nuevoTipo.setId(tipoTraAreTra.getId().getCodigoSecuencial());
				nuevoTipo.setIdAreaTrabajo(tipoTraAreTra.getAreaTrabajoDTO().getId().getCodigoAreaTrabajo());
				nuevoTipo.setAreaTrabajo(tipoTraAreTra.getAreaTrabajoDTO().getNombreAreaTrabajo());
				nuevoTipo.setIdAfectacion(tipoTraAreTra.getEtapaAfectacion().getId().getCodigoCatalogoValor());
				nuevoTipo.setAfectacion(tipoTraAreTra.getEtapaAfectacion().getNombreCatalogoValor());
				respFormat.add(nuevoTipo);

				index++;
			}

			return JsonPojoMapper.getInstance().writeValueAsString(respFormat);

		} catch (Exception e) {
			LOG_SICV2.error("Error: {}", e);
			throw new SICException(e);

		}
	}


	public class TipoTransaccionAreaTrabajo {

		private Integer id;
		private Integer index;
		private String areaTrabajo;
		private String afectacion;
		private Integer idAreaTrabajo;
		private String idAfectacion;

		public Integer getId() {
			return id;
		}
		public void setId(Integer id) {
			this.id = id;
		}
		public String getAreaTrabajo() {
			return areaTrabajo;
		}
		public void setAreaTrabajo(String areaTrabajo) {
			this.areaTrabajo = areaTrabajo;
		}
		public String getAfectacion() {
			return afectacion;
		}
		public void setAfectacion(String afectacion) {
			this.afectacion = afectacion;
		}
		public Integer getIndex() {
			return index;
		}
		public void setIndex(Integer index) {
			this.index = index;
		}
		public Integer getIdAreaTrabajo() {
			return idAreaTrabajo;
		}
		public void setIdAreaTrabajo(Integer idAreaTrabajo) {
			this.idAreaTrabajo = idAreaTrabajo;
		}
		public String getIdAfectacion() {
			return idAfectacion;
		}
		public void setIdAfectacion(String idAfectacion) {
			this.idAfectacion = idAfectacion;
		}

	}

	// servicio para causales de transaccion 

	@RequestMapping(value = "/causalesRelacionados", method = RequestMethod.GET, headers = "Accept= application/json")
	public @ResponseBody
	ResponseEntity<String> findCausalesTransacion(
			@RequestParam(value = "codigoCompania", required = true) Integer codigoCompania,
			@RequestParam(value = "codigoTransaccion", required = true) String codigoTransaccion,
			@RequestParam(value = "codigoValorCausal", required = true) String codigoValorCausal) {

		LOG_SICV2.info("Inicio web service find causales, codigoTransaccion: {}", codigoTransaccion+" codigoValorCausal: {}", codigoValorCausal+" codigocompania "+codigoCompania);

		HttpHeaders headers = new HttpHeaders();

		headers.add("Content-Type", "text/html; charset=utf-8");

		return new ResponseEntity<String>(consultaCausalesFormatoJSON(codigoCompania,codigoTransaccion,codigoValorCausal), headers, HttpStatus.OK);
	}

	public String consultaCausalesFormatoJSON(Integer codigoCompania,String codigoTransaccion,String codigoValorCausal) throws SICException {

		try {
			TransaccionCausalDTO transaccionCausalDTO=InventarioFactory.getInstancia().getInventarioServicioAdministracion().findCausalesTransaccion(codigoCompania,codigoTransaccion, codigoValorCausal);
			Collection<causalesTransaccion> respFormat = new ArrayList<InventarioWebService.causalesTransaccion>();
			int cont=0;
			Integer index = 1;

			for (Iterator iterator = transaccionCausalDTO.getTransaccionCausalPriCol().iterator(); iterator.hasNext();) {
				TransaccionCausalRelacionDTO type = (TransaccionCausalRelacionDTO) iterator.next();

				causalesTransaccion ct=new causalesTransaccion();
				ct.setIndex(index);
				ct.setCodigoCausalBase(transaccionCausalDTO.getCatalogoValorCausal().getId().getCodigoCatalogoValor());
				ct.setCodigoTipoCausalBase(transaccionCausalDTO.getCatalogoValorCausal().getId().getCodigoCatalogoTipo());
				ct.setNombreCausalBase(transaccionCausalDTO.getCatalogoValorCausal().getNombreCatalogoValor());

				ct.setCodigoCausalRelacion(type.getCodigoValorCausalRel());
				ct.setCodigoTipoCausalRelacion(type.getTransaccionCausalRel().getCatalogoValorCausal().getId().getCodigoCatalogoTipo());
				ct.setNombreCausalRelacion(type.getTransaccionCausalRel().getCatalogoValorCausal().getNombreCatalogoValor());

				ct.setCodigoRelacion(type.getCodigoValorRelacion());
				ct.setCodigoTipoRelacion(type.getCatalogoValorRelacion().getId().getCodigoCatalogoTipo());
				ct.setNombreRelacion(type.getCatalogoValorRelacion().getNombreCatalogoValor());

				ct.setId(cont+1);
				respFormat.add(ct);
				cont++;
				index++;
			}



			return JsonPojoMapper.getInstance().writeValueAsString(respFormat);

		} catch (Exception e) {
			LOG_SICV2.error("Error: {}", e);
			throw new SICException(e);

		}
	}

	public class causalesTransaccion {

		private Integer id;
		private Integer index;

		private String codigoRelacion;
		private Integer codigoTipoRelacion;
		private String nombreRelacion;

		private String codigoCausalBase;
		private Integer codigoTipoCausalBase;
		private String nombreCausalBase;

		private String codigoCausalRelacion;
		private Integer codigoTipoCausalRelacion;
		private String nombreCausalRelacion;

		public Integer getId() {
			return id;
		}
		public void setId(Integer id) {
			this.id = id;
		}

		public Integer getIndex() {
			return index;
		}
		public void setIndex(Integer index) {
			this.index = index;
		}
		public String getCodigoRelacion() {
			return codigoRelacion;
		}
		public void setCodigoRelacion(String codigoRelacion) {
			this.codigoRelacion = codigoRelacion;
		}
		public String getCodigoCausalBase() {
			return codigoCausalBase;
		}
		public void setCodigoCausalBase(String codigoCausalBase) {
			this.codigoCausalBase = codigoCausalBase;
		}
		public String getCodigoCausalRelacion() {
			return codigoCausalRelacion;
		}
		public void setCodigoCausalRelacion(String codigoCausalRelacion) {
			this.codigoCausalRelacion = codigoCausalRelacion;
		}
		public String getNombreRelacion() {
			return nombreRelacion;
		}
		public void setNombreRelacion(String nombreRelacion) {
			this.nombreRelacion = nombreRelacion;
		}
		public String getNombreCausalBase() {
			return nombreCausalBase;
		}
		public void setNombreCausalBase(String nombreCausalBase) {
			this.nombreCausalBase = nombreCausalBase;
		}
		public String getNombreCausalRelacion() {
			return nombreCausalRelacion;
		}
		public void setNombreCausalRelacion(String nombreCausalRelacion) {
			this.nombreCausalRelacion = nombreCausalRelacion;
		}
		public Integer getCodigoTipoRelacion() {
			return codigoTipoRelacion;
		}
		public void setCodigoTipoRelacion(Integer codigoTipoRelacion) {
			this.codigoTipoRelacion = codigoTipoRelacion;
		}
		public Integer getCodigoTipoCausalBase() {
			return codigoTipoCausalBase;
		}
		public void setCodigoTipoCausalBase(Integer codigoTipoCausalBase) {
			this.codigoTipoCausalBase = codigoTipoCausalBase;
		}
		public Integer getCodigoTipoCausalRelacion() {
			return codigoTipoCausalRelacion;
		}
		public void setCodigoTipoCausalRelacion(Integer codigoTipoCausalRelacion) {
			this.codigoTipoCausalRelacion = codigoTipoCausalRelacion;
		}
	}
}
