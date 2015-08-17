package ec.com.smx.sic.cliente.common.factory;

import ec.com.smx.sic.cliente.servicio.convenio.ICampaniaPromocionServicio;
import ec.com.smx.sic.cliente.servicio.convenio.IConvenioParticipanteServicio;
import ec.com.smx.sic.cliente.servicio.convenio.IEmpresaParticipanteServicio;
import ec.com.smx.sic.cliente.servicio.convenio.INegociacionServicio;
import ec.com.smx.sic.cliente.servicio.convenio.IOrdenCompraNegociacionServicio;
import ec.com.smx.sic.cliente.servicio.convenio.calculo.ICatalogoConvenioServicio;
import ec.com.smx.sic.cliente.servicio.convenio.cobros.INegociacionCobroServicio;
import ec.com.smx.sic.cliente.servicio.convenio.cobros.IRegistroCobroServicio;
import ec.com.smx.sic.cliente.servicio.convenio.negociacion.IParametroConvenioServicio;
import ec.com.smx.sic.cliente.servicio.convenio.ventas.IConfiguracionDatosProcesadosServicio;
import ec.com.smx.sic.cliente.servicio.convenio.ventas.IDefinicionConfiguracionServicio;
import ec.com.smx.sic.cliente.servicio.convenio.ventas.IProcesamientoVentasServicio;
import ec.com.smx.sic.cliente.servicio.convenio.ventas.IRecuperacionVentasServicio;
import ec.com.smx.sic.cliente.servicio.tareaprogramada.ITareaProgramadaProcesamientoVentas;
import ec.com.smx.sic.cliente.servicio.tareaprogramada.ITareaProgramadaRecuperacionVentas;


/**
 * @author srodriguez
 * 2014-09-10
*/

public final class ConveniosFactory extends SICSpringContextFactory{
	
	public IEmpresaParticipanteServicio getEmpresaParticipanteServicio(){
		return getBean(ConveniosFactoryConstantes.EMPRESA_PARTICIPANTE_SERVICIO, IEmpresaParticipanteServicio.class);
	}
	
	public IConvenioParticipanteServicio getConvenioParticipanteServicio(){
		return getBean(ConveniosFactoryConstantes.CONVENIO_PARTICIPANTE_SERVICIO, IConvenioParticipanteServicio.class);
	}
	
	public ICampaniaPromocionServicio getCampaniaPromocionServicio(){
        return getBean(ConveniosFactoryConstantes.CAMPANIA_PROMOCION_SERVICIO, ICampaniaPromocionServicio.class);
    }

    public ICatalogoConvenioServicio getCatalogoConvenioServicio(){
        return getBean(ConveniosFactoryConstantes.CATALOGO_CONVENIO_SERVICIO, ICatalogoConvenioServicio.class);
    }
    
    public INegociacionServicio getNegociacionServicio(){
    	return getBean(ConveniosFactoryConstantes.NEGOCIACION_SERVICIO, INegociacionServicio.class);
    }
    
    public IRecuperacionVentasServicio getRecuperacionVentasServicio(){
    	return getBean(ConveniosFactoryConstantes.RECUPERACION_VENTAS_SERVICIO, IRecuperacionVentasServicio.class);
    }
    
    public IProcesamientoVentasServicio getProcesamientoVentasServicio(){
    	return getBean(ConveniosFactoryConstantes.PROCESAMIENTO_VENTAS_SERVICIO, IProcesamientoVentasServicio.class);
    }
    
    public IConfiguracionDatosProcesadosServicio getConfiguracionDatosProcesados(){
    	return getBean(ConveniosFactoryConstantes.CONFIGURACION_DATOS_PROCESADOS,IConfiguracionDatosProcesadosServicio.class);
    }
    
    public IDefinicionConfiguracionServicio getDefinicionConfiguracionServicio(){
    	return getBean(ConveniosFactoryConstantes.DEFINICION_CONFIGURACION,IDefinicionConfiguracionServicio.class);
    }
    
    public ITareaProgramadaRecuperacionVentas getTareaProgramadaRecuperacionVentas(){
    	return getBean(ConveniosFactoryConstantes.TAREA_PROGRAMADA_RECUPERACION_VENTAS,ITareaProgramadaRecuperacionVentas.class);
    }
    
    public ITareaProgramadaProcesamientoVentas getTareaProgramadaProcesamientoVentas(){
    	return getBean(ConveniosFactoryConstantes.TAREA_PROGRAMADA_PROCESAMIENTO_VENTAS,ITareaProgramadaProcesamientoVentas.class);
    }
    
    public INegociacionCobroServicio getNegociacionCobroServicio(){
    	return getBean(ConveniosFactoryConstantes.NEGOCIACION_COBRO_SERVICIO,INegociacionCobroServicio.class);
    }
    
    public IRegistroCobroServicio getRegistroCobroServicio(){
    	return getBean(ConveniosFactoryConstantes.REGISTRO_COBRO_SERVICIO,IRegistroCobroServicio.class);
    }
    public IOrdenCompraNegociacionServicio getIOrdenCompraNegociacionArticulo(){
    	return getBean(ConveniosFactoryConstantes.ORDEN_COMPRA_NEGOCIACION_ARTICULO,IOrdenCompraNegociacionServicio.class);
    }
    public IParametroConvenioServicio getParametroConvenioServicio(){
        return getBean(ConveniosFactoryConstantes.PARAMETRO_CONVENIO_SERVICIO, IParametroConvenioServicio.class);
    }
}
