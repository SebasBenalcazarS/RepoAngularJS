<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:output version="1.0" encoding="UTF-8" indent="no" omit-xml-declaration="no" media-type="text/html" method="html"/>
	
	<xsl:template match="/">
	
		<html>
			<head>	
				<style type="text/css">
				.styleCabDet{color: #000000;font-size: 10px;font-style: normal;line-height: normal;font-family: Courier New, Courier;}
				.styleFilDet{color: #000000;font-size: 10px;font-style: normal;line-height: normal;font-family: Courier New, Courier;}
				.styleCabDet1{color: #000000;font-size: 10px;font-style: normal;line-height: normal;font-family: Courier New, Courier;}
				.styleFilDet1{color: #000000;font-size: 10px;font-style: normal;line-height: normal;font-family: Courier New, Courier;}
				.stylehr{color: #000000; height: 1px;}
				.styleDet{color: #000000;font-size: 10px;font-style: normal;line-height: normal;font-family: Courier New, Courier;border-bottom-width: 1px;border-bottom-style: none; border-bottom-color: #cccccc;	border-right-width: 1px;	border-right-style: dashed;border-left-color: #CCCCCC; /*border-top-width: 1px;	border-top-style: dashed;*/ }
				</style>
			</head>	
			<xsl:for-each select="pedido/ordenCompra">		
				<table border="0" width="80%" cellspacing="0" cellpadding="0" >
					<tr>
						<td class="styleFilDet" width="33%" align="left">Tda/Alm/CDI: </td>
						<td class="styleFilDet" width="27%" align="left">Proveedor: </td>
						<td class="styleFilDet" width="23%"> </td>
						<td class="styleFilDet" width="12%" align="center"><xsl:value-of select="cabeceraA/columna1"/></td>
						<td class="styleFilDet" width="5%" align="right"><xsl:value-of select="cabeceraA/columna2"/></td>
					</tr>					
					<tr>
						<td class="styleFilDet" align="left"><xsl:value-of select="cabeceraB/columna1"/></td>
						<td class="styleFilDet" align="left"><xsl:value-of select="cabeceraB/columna2"/></td>
						<td class="styleFilDet" align="left" colspan="3">================================================================</td>
					</tr>	
					<tr>
						<td class="styleFilDet" align="left"><xsl:value-of select="cabeceraC/columna1"/></td>
						<td class="styleFilDet" align="left"><xsl:value-of select="cabeceraC/columna2"/></td>
						<td class="styleFilDet" align="left">ORDEN COMPRA <xsl:value-of select="cabeceraC/columna3"/> INDIVIDUAL</td>
						<td class="styleFilDet" align="right" colspan="2"><xsl:value-of select="cabeceraC/columna4"/></td>
					</tr>	
					<tr>
						<td class="styleFilDet" align="left"><xsl:value-of select="cabeceraD/columna1"/></td>
						<td class="styleFilDet" align="left"><xsl:value-of select="cabeceraD/columna2"/></td>
						<td class="styleFilDet" align="left" colspan="3">================================================================</td>
					</tr>	
				</table>
				<table border="0" width="80%" cellspacing="0" cellpadding="0" >
					<tr>
						<td class="styleFilDet" width="23%" align="left"><xsl:value-of select="cabeceraE/columna1"/></td>
						<td class="styleFilDet" width="10%" align="left"><xsl:value-of select="cabeceraE/columna2"/></td>
						<td class="styleFilDet" width="19%" align="left"><xsl:value-of select="cabeceraE/columna3"/></td>
						<td class="styleFilDet" width="8%" align="left"><xsl:value-of select="cabeceraE/columna4"/></td>
						<td class="styleFilDet" width="4%" align="left">Div: </td>
						<td class="styleFilDet" width="4%" align="left"><xsl:value-of select="cabeceraE/columna5"/></td>
						<td class="styleFilDet" width="15%" align="left"><xsl:value-of select="cabeceraE/columna6"/></td>
						<td class="styleFilDet" width="10%" align="left">Fecha Elabora: </td>
						<td class="styleFilDet" width="7%" align="right"><xsl:value-of select="cabeceraE/columna7"/></td>
					</tr>	
					<tr>
						<td class="styleFilDet" align="left"><xsl:value-of select="cabeceraF/columna1"/></td>
						<td class="styleFilDet" align="left">Fx 996502</td>
						<td class="styleFilDet" align="left"><xsl:value-of select="cabeceraF/columna2"/></td>
						<td class="styleFilDet" align="left"><xsl:value-of select="cabeceraF/columna3"/></td>
						<td class="styleFilDet" align="left">Dep: </td>
						<td class="styleFilDet" align="left"><xsl:value-of select="cabeceraF/columna4"/></td>
						<td class="styleFilDet" align="left"><xsl:value-of select="cabeceraF/columna5"/></td>
						<td class="styleFilDet" align="left">Fecha Vigencia: </td>
						<td class="styleFilDet" align="right"><xsl:value-of select="cabeceraF/columna6"/></td>
					</tr>
					<tr>
						<td class="styleFilDet" colspan="2" align="left">RUC: <xsl:value-of select="cabeceraG/columna1"/></td>
						<td class="styleFilDet" colspan="2" align="left">RUC: <xsl:value-of select="cabeceraG/columna2"/></td>
						<td class="styleFilDet" align="left">Bod: </td>
						<td class="styleFilDet" align="left"><xsl:value-of select="cabeceraG/columna3"/></td>
						<td class="styleFilDet" align="left"><xsl:value-of select="cabeceraG/columna4"/></td>
						<td class="styleFilDet" align="left">Fecha Cancela: </td>
						<td class="styleFilDet" align="right"><xsl:value-of select="cabeceraG/columna5"/></td>
					</tr>						
				</table>
				<table border="0" width="80%" cellspacing="0" cellpadding="0">
					<tr>
						<td class="styleFilDet" align="left"> </td>
						<td class="styleFilDet" align="left">011000027790000</td>
						<td class="styleFilDet" align="left"> </td>
						<td class="styleFilDet" align="left">000000000000000</td>
						<td class="styleFilDet" align="center"> </td>
						<td class="styleFilDet" align="left" colspan="2">Entregar Dia Preestablecido.</td>
					</tr>
					<tr>
						<td class="styleFilDet" width="3%" align="left"> </td>
						<td class="styleFilDet" width="29%" align="left">1790016919001</td>
						<td class="styleFilDet" width="4%" align="left"> </td>
						<td class="styleFilDet" width="24%" align="left">000000000000000</td>
						<td class="styleFilDet" width="23%" align="center"> </td>
						<td class="styleFilDet" width="10%" align="justify">Surtido minimo Ent: </td>
						<td class="styleFilDet" width="7%" align="right">.00</td>
					</tr>						
				</table>
				<table border="0" width="80%" cellspacing="0" cellpadding="0">
					<tr>
						<td class="styleFilDet" width="100%" height="20px"> </td>
					</tr>	
				</table>
				<table border="0" width="80%" cellspacing="0" cellpadding="0">
					<thead>
						<xsl:if test="planContingencia = 'SI'">
							<tr>
								<td class="styleFilDet" width="37%" align="left" height="20px">IT Descripcion</td>
								<td class="styleFilDet" width="13%" align="center" height="20px">Tamano</td>
								<td class="styleFilDet" width="13%" align="center" height="20px">Acabado</td>
								<td class="styleFilDet" width="7%" align="justify" height="20px">S</td>
								<td class="styleFilDet" width="17%" align="left" height="20px">Codigo Barras</td>
								<td class="styleFilDet" width="6%" align="right" height="20px">UC.</td>
								<td class="styleFilDet" width="7%" align="right" height="20px">Cant.Ped</td>
							</tr>
						</xsl:if>
						<xsl:if test="planContingencia = 'NO'">
							<tr>
								<td class="styleFilDet" width="22%" align="left" height="20px">IT Descripcion</td>
								<td class="styleFilDet" width="7%" align="center" height="20px">Tamano</td>
								<td class="styleFilDet" width="9%" align="center" height="20px">Acabado</td>
								<td class="styleFilDet" width="2%" align="justify" height="20px">S</td>
								<td class="styleFilDet" width="8%" align="left" height="20px">Codigo Barras</td>
								<td class="styleFilDet" width="4%" align="right" height="20px">UC.</td>
								<td class="styleFilDet" width="8%" align="right" height="20px"><xsl:value-of select="tituloCabeceraCosto"/></td>
								<td class="styleFilDet" width="5%" align="right" height="20px">DxUC</td>
								<td class="styleFilDet" width="5%" align="right" height="20px">Des-1</td>
								<td class="styleFilDet" width="5%" align="right" height="20px">Des-2</td>
								<td class="styleFilDet" width="5%" align="right" height="20px">DxTra</td>
								<td class="styleFilDet" width="5%" align="right" height="20px">Des-4</td>
								<td class="styleFilDet" width="5%" align="right" height="20px">Des-T</td>
								<td class="styleFilDet" width="5%" align="center" height="20px">Des-P</td>
								<td class="styleFilDet" width="5%" align="right" height="20px">Cant.Ped</td>
							</tr>
						</xsl:if>
					</thead>
					<tbody>
						<xsl:for-each select="detalles">	
							<xsl:if test="espacioHojaInicial = 'SI' and position() = '48' and planContingencia = 'SI'">
								<tr>
									<td class="styleFilDet" width="4%" align="left" height="20px" colspan="8"> </td>
								</tr>			
							</xsl:if>
							<xsl:if test="espacioHojaInicial = 'SI' and position() = '48' and planContingencia = 'NO'">
								<tr>
									<td class="styleFilDet" width="4%" align="left" height="20px" colspan="16"> </td>
								</tr>			
							</xsl:if>
							<tr>
								<xsl:if test="planContingencia = 'SI'">
									<td class="styleFilDet" width="37%" align="left"><xsl:value-of select="descripcion"/></td>
									<td class="styleFilDet" align="left" width="13%"><xsl:value-of select="tamanio"/></td>
									<td class="styleFilDet" align="left" width="13%"><xsl:value-of select="acabado"/></td>
									<td class="styleFilDet" align="justify" width="7%"><xsl:value-of select="s"/></td>
									<td class="styleFilDet" align="left" width="17%"><xsl:value-of select="codigoBarras"/></td>
									<td class="styleFilDet" align="right" width="6%"><xsl:value-of select="uc"/></td>
									<td class="styleFilDet" align="right" width="7%"><xsl:value-of select="cantidad"/></td>
								</xsl:if>
								<xsl:if test="planContingencia = 'NO'">
									<td class="styleFilDet" width="22%" align="left"><xsl:value-of select="descripcion"/></td>
									<td class="styleFilDet" align="left" width="7%"><xsl:value-of select="tamanio"/></td>
									<td class="styleFilDet" align="left" width="9%"><xsl:value-of select="acabado"/></td>
									<td class="styleFilDet" align="justify" width="2%"><xsl:value-of select="s"/></td>
									<td class="styleFilDet" align="left" width="8%"><xsl:value-of select="codigoBarras"/></td>
									<td class="styleFilDet" align="right" width="4%"><xsl:value-of select="uc"/></td>
									<td class="styleFilDet" align="right" width="8%"><xsl:value-of select="precioCosto"/></td>
									<td class="styleFilDet" align="right" width="5%"><xsl:value-of select="descuentoDocenas"/></td>
									<td class="styleFilDet" align="right" width="5%"><xsl:value-of select="descuento1"/></td>
									<td class="styleFilDet" align="right" width="5%"><xsl:value-of select="descuento2"/></td>
									<td class="styleFilDet" align="right" width="5%"><xsl:value-of select="descuento3"/></td>
									<td class="styleFilDet" align="right" width="5%"><xsl:value-of select="descuento4"/></td>
									<td class="styleFilDet" align="right" width="5%"><xsl:value-of select="descuentoProducto"/></td>
									<td class="styleFilDet" align="right" width="5%"><xsl:value-of select="descuentoPromocion"/></td>
									<td class="styleFilDet" align="right" width="5%"><xsl:value-of select="cantidad"/></td>
								</xsl:if>
							</tr>
						</xsl:for-each>
					</tbody>
				</table>
				<table border="0" width="80%" cellspacing="0" cellpadding="0">
					<xsl:for-each select="filasTablaCompletar">	
						<tr>
							<td class="styleFilDet" width="100%" height="10px"> </td>
						</tr>
					</xsl:for-each>
				</table>
				<table border="0" width="80%" cellspacing="0" cellpadding="0">
					<tr>
						<td class="styleFilDet" width="50%" align="left">Observaciones: </td>
						<td class="styleFilDet" width="43%" align="right">Total Unidades:</td>
						<td class="styleFilDet" width="7%" align="right"><xsl:value-of select="totalUnidades"/></td>
						<!--<td class="styleFilDet" width="7%" align="right"><xsl:value-of select="format-number(totalUnidades,'###,###.000')"/></td> -->
					</tr>
					<tr>
						<td class="styleFilDet" align="left" colspan="3"><xsl:value-of select="observacion"/></td>
					</tr>
				</table>
				<table border="0" width="80%" cellspacing="0" cellpadding="0">
					<xsl:for-each select="filasObservacion">	
						<tr>
							<td class="styleFilDet" width="100%" height="10px"> </td>
						</tr>
					</xsl:for-each>
				</table>
				<xsl:if test="saltoPaginaDetInicial = 'SI'">
					<div  border="0" class="pagebreak">&#xA0;</div>
				</xsl:if>
				<xsl:if test="saltoPaginaDetFinal = 'SI'">
					<div  border="0" class="pagebreak">&#xA0;</div>
				</xsl:if>
				<table border="0" width="80%" cellspacing="0" cellpadding="0">
					<tr>
						<td class="styleFilDet" align="justify">*************** I M P O R T A N T E ***************</td>
						<td class="styleFilDet" align="justify"> </td>
						<td class="styleFilDet" align="left" colspan="4">_________________________________________________________________________________________________________________________________</td>
					</tr>
					<tr>
						<td class="styleFilDet" width="27%" align="justify"> </td>
						<td class="styleFilDet" width="1%" align="justify"> </td>
						<td class="styleFilDet" width="22%" align="left">! Elaboro Orden Compra:  </td>
						<td class="styleFilDet" width="20%" align="left">! Autorizo Orden Compra:  </td>
						<td class="styleFilDet" width="29%" align="left">! Proveedor:              </td>
						<td class="styleFilDet" width="1%" align="right">!</td>
					</tr>
					<tr>
						<td class="styleFilDet" align="justify"> </td>
						<td class="styleFilDet" align="justify"> </td>
						<td class="styleFilDet" align="left">! </td>
						<td class="styleFilDet" align="left">! </td>
						<td class="styleFilDet" align="left">! </td>
						<td class="styleFilDet" align="right">!</td>
					</tr>
					<tr>
						<td class="styleFilDet" align="justify" rowspan="7"><xsl:value-of select="mensajeReporte"/></td>
						<td class="styleFilDet" align="justify"> </td>
						<td class="styleFilDet" align="left">! </td>
						<td class="styleFilDet" align="left">! </td>
						<td class="styleFilDet" align="left">! Acepto las condiciones </td>
						<td class="styleFilDet" align="right">!</td>
					</tr>
			
					<tr>
						<td class="styleFilDet" align="justify"> </td>
						<td class="styleFilDet" align="left">! </td>
						<td class="styleFilDet" align="left">! </td>
						<td class="styleFilDet" align="left">! </td>
						<td class="styleFilDet" align="right">!</td>
					</tr>
					<tr>
						<td class="styleFilDet" align="justify"> </td>
						<td class="styleFilDet" align="left">! </td>
						<td class="styleFilDet" align="left">! </td>
						<td class="styleFilDet" align="left">! </td>
						<td class="styleFilDet" align="right">!</td>
					</tr>
					<tr>
						<td class="styleFilDet" align="justify"> </td>
						<td class="styleFilDet" align="left">! </td>
						<td class="styleFilDet" align="left">! </td>
						<td class="styleFilDet" align="left">! -Pago Flete: Proveedor</td>
						<td class="styleFilDet" align="right">!</td>
					</tr>
					<tr>
						<td class="styleFilDet" align="justify"> </td>
						<td class="styleFilDet" align="left">! </td>
						<td class="styleFilDet" align="left">! </td>
						<td class="styleFilDet" align="left">! -Desc.PP 1 :  0.00 a  0 Dias</td>
						<td class="styleFilDet" align="right">!</td>
					</tr>
					<tr>
						<td class="styleFilDet" align="justify"> </td>
						<td class="styleFilDet" align="left">! </td>
						<td class="styleFilDet" align="left">! </td>
						<td class="styleFilDet" align="left">! -Desc.PP 2 :  0.00 a  0 Dias</td>
						<td class="styleFilDet" align="right">!</td>
					</tr>
					<tr>
						<td class="styleFilDet" align="justify"> </td>
						<td class="styleFilDet" align="left">! <xsl:value-of select="usuarioResponsable"/></td>
						<td class="styleFilDet" align="left">! </td>
						<td class="styleFilDet" align="left">! -Desc Publ :  0.00</td>
						<td class="styleFilDet" align="right">!</td>
					</tr>
					<tr>
						<td class="styleFilDet" align="justify"> </td>
						<td class="styleFilDet" align="justify"> </td>
						<td class="styleFilDet" align="left" colspan="4">_________________________________________________________________________________________________________________________________</td>
					</tr>
				</table>
				<xsl:if test="saltoPagina = 'SI'">
					<div  border="0" class="pagebreak">&#xA0;</div>
				</xsl:if>
			</xsl:for-each>
		</html>
	</xsl:template>
</xsl:stylesheet>