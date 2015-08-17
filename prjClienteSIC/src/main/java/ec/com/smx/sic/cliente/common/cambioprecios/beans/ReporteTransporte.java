package ec.com.smx.sic.cliente.common.cambioprecios.beans;

import java.util.*;

import ec.com.smx.sic.cliente.common.busqueda.bean.*;
import ec.com.smx.sic.cliente.common.cambioprecios.constantes.TipoBusquedaCambioPrecios;
import ec.com.smx.sic.cliente.common.search.bean.ISearchTemplate;

public class ReporteTransporte {
	
	public ReporteTransporte() {	}

	public ReporteTransporte(	TipoBusquedaCambioPrecios tipo, 
								Collection<ISearchTemplate> cist,
								Integer codigoCompania, 
								String codigoFuncionario,
								Boolean incluirPreciosDif) {
 
		this.tipo = tipo;
		this.codigoCompania = codigoCompania;
		this.codigoFuncionario = codigoFuncionario;
		this.incluirPreciosDif = incluirPreciosDif;
		
		for (ISearchTemplate iSearchTemplate : cist) {
			if (iSearchTemplate instanceof PlantillaBusquedaArticulo) {
				this.plantillaBusquedaArticulo = (PlantillaBusquedaArticulo)iSearchTemplate;
			} else if (iSearchTemplate instanceof PlantillaBusquedaBodega) {
				this.plantillaBusquedaBodega = (PlantillaBusquedaBodega)iSearchTemplate;
			} else if (iSearchTemplate instanceof PlantillaBusquedaCambioPrecio) {
				this.plantillaBusquedaCambioPrecio = (PlantillaBusquedaCambioPrecio)iSearchTemplate;
			} else if (iSearchTemplate instanceof PlantillaBusquedaEstructuraComercial) {
				this.plantillaBusquedaEstructuraComercial = (PlantillaBusquedaEstructuraComercial)iSearchTemplate;
			} else if (iSearchTemplate instanceof PlantillaBusquedaFuncionario) {
				this.plantillaBusquedaFuncionario = (PlantillaBusquedaFuncionario)iSearchTemplate;
			} else if (iSearchTemplate instanceof PlantillaBusquedaProveedor) {
				this.plantillaBusquedaProveedor = (PlantillaBusquedaProveedor)iSearchTemplate;
			}
		}
	}
	
	public Collection<ISearchTemplate> devolverLista() {
		Collection<ISearchTemplate> coleccion = new ArrayList<ISearchTemplate>();
		if (plantillaBusquedaArticulo!= null) coleccion.add(plantillaBusquedaArticulo);
		if (plantillaBusquedaBodega!= null) coleccion.add(plantillaBusquedaBodega);
		if (plantillaBusquedaCambioPrecio!= null) coleccion.add(plantillaBusquedaCambioPrecio);
		if (plantillaBusquedaEstructuraComercial!= null) coleccion.add(plantillaBusquedaEstructuraComercial);
		if (plantillaBusquedaFuncionario!= null) coleccion.add(plantillaBusquedaFuncionario);
		if (plantillaBusquedaProveedor!= null) coleccion.add(plantillaBusquedaProveedor);
		return coleccion;
	}

	private TipoBusquedaCambioPrecios tipo;
	public TipoBusquedaCambioPrecios getTipo() { return tipo; }
	public void setTipo(TipoBusquedaCambioPrecios tipo) { this.tipo = tipo; }

	private Integer codigoCompania;
	public Integer getCodigoCompania() { return codigoCompania; }
	public void setCodigoCompania(Integer codigoCompania) { this.codigoCompania = codigoCompania; }

	private String codigoFuncionario;
	public String getCodigoFuncionario() { return codigoFuncionario; }
	public void setCodigoFuncionario(String codigoFuncionario) { this.codigoFuncionario = codigoFuncionario; }
	
	private Boolean incluirPreciosDif;
	public Boolean getIncluirPreciosDif() { return incluirPreciosDif; }
	public void setIncluirPreciosDif(Boolean incluirPreciosDif) { this.incluirPreciosDif = incluirPreciosDif; }

	private PlantillaBusquedaArticulo plantillaBusquedaArticulo;
	private PlantillaBusquedaBodega plantillaBusquedaBodega;
	private PlantillaBusquedaCambioPrecio plantillaBusquedaCambioPrecio;
	private PlantillaBusquedaEstructuraComercial plantillaBusquedaEstructuraComercial;
	private PlantillaBusquedaFuncionario plantillaBusquedaFuncionario;
	private PlantillaBusquedaProveedor plantillaBusquedaProveedor;
	
	public PlantillaBusquedaArticulo getPlantillaBusquedaArticulo() {
		return plantillaBusquedaArticulo;
	}

	public void setPlantillaBusquedaArticulo(PlantillaBusquedaArticulo plantillaBusquedaArticulo) {
		this.plantillaBusquedaArticulo = plantillaBusquedaArticulo;
	}

	public PlantillaBusquedaBodega getPlantillaBusquedaBodega() {
		return plantillaBusquedaBodega;
	}

	public void setPlantillaBusquedaBodega(PlantillaBusquedaBodega plantillaBusquedaBodega) {
		this.plantillaBusquedaBodega = plantillaBusquedaBodega;
	}

	public PlantillaBusquedaCambioPrecio getPlantillaBusquedaCambioPrecio() {
		return plantillaBusquedaCambioPrecio;
	}

	public void setPlantillaBusquedaCambioPrecio(PlantillaBusquedaCambioPrecio plantillaBusquedaCambioPrecio) {
		this.plantillaBusquedaCambioPrecio = plantillaBusquedaCambioPrecio;
	}

	public PlantillaBusquedaEstructuraComercial getPlantillaBusquedaEstructuraComercial() {
		return plantillaBusquedaEstructuraComercial;
	}

	public void setPlantillaBusquedaEstructuraComercial(PlantillaBusquedaEstructuraComercial plantillaBusquedaEstructuraComercial) {
		this.plantillaBusquedaEstructuraComercial = plantillaBusquedaEstructuraComercial;
	}

	public PlantillaBusquedaFuncionario getPlantillaBusquedaFuncionario() {
		return plantillaBusquedaFuncionario;
	}

	public void setPlantillaBusquedaFuncionario(PlantillaBusquedaFuncionario plantillaBusquedaFuncionario) {
		this.plantillaBusquedaFuncionario = plantillaBusquedaFuncionario;
	}

	public PlantillaBusquedaProveedor getPlantillaBusquedaProveedor() {
		return plantillaBusquedaProveedor;
	}

	public void setPlantillaBusquedaProveedor(PlantillaBusquedaProveedor plantillaBusquedaProveedor) {
		this.plantillaBusquedaProveedor = plantillaBusquedaProveedor;
	}
}
