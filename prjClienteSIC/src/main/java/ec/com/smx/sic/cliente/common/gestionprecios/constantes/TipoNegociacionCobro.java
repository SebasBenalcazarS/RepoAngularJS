package ec.com.smx.sic.cliente.common.gestionprecios.constantes;

public abstract class TipoNegociacionCobro {

	private String valorTipoNegociacionCobro;
	public final static Integer CODIGO_TIPO_NEGOCIACION_COBRO = TipoCatalogosGestionPrecios.TIPO_NEGOCIACION_COBRO;

	public TipoNegociacionCobro(String valorTipoNegociacionCobro) {
		this.valorTipoNegociacionCobro = valorTipoNegociacionCobro;
	}

	public String getValorTipoNegociacionCobro() {
		return valorTipoNegociacionCobro;
	}

	// Constantes para tipo de negociacion cobro
	public static final TipoNegociacionCobro PENDIENTE = new TipoNegociacionCobro(GestionPrecioConstantes.getInstancia().VALOR_TIPO_NEGOCIACION_COBRO_PENDIENTE) {};
	public static final TipoNegociacionCobro CONFIGURADA = new TipoNegociacionCobro(GestionPrecioConstantes.getInstancia().VALOR_TIPO_NEGOCIACION_COBRO_CONFIGURADA) {};
	public static final TipoNegociacionCobro EN_CURSO = new TipoNegociacionCobro(GestionPrecioConstantes.getInstancia().VALOR_TIPO_NEGOCIACION_COBRO_EN_CURSO) {};
	public static final TipoNegociacionCobro FINALIZADA = new TipoNegociacionCobro(GestionPrecioConstantes.getInstancia().VALOR_TIPO_NEGOCIACION_COBRO_FINALIZADA) {};
	public static final TipoNegociacionCobro COBRADA = new TipoNegociacionCobro(GestionPrecioConstantes.getInstancia().VALOR_TIPO_NEGOCIACION_COBRO_COBRADA) {};
}
