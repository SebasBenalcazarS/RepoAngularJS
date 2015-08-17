<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

    <xsl:decimal-format name="numerico" NaN="-" decimal-separator="," grouping-separator="." />
	<xsl:param name="heightScrollFactura"/>
	
	<xsl:template match="/">
	    <xsl:variable name="ruc" select="factura/infoTributaria/ruc" />
        <xsl:variable name="cont" select="factura/infoFactura/contribuyenteEspecial" />
        <xsl:variable name="razonSocial" select="factura/infoTributaria/razonSocial" />
        <xsl:variable name="nomComercial" select="factura/infoTributaria/nombreComercial" />
        <xsl:variable name="dirMatriz" select="factura/infoTributaria/dirMatriz" />
        <xsl:variable name="dirSucursal" select="factura/infoFactura/dirEstablecimiento" />
        <xsl:variable name="obligadoContabilidad" select="factura/infoFactura/obligadoContabilidad" />
        <xsl:variable name="sucursal" select="factura/infoTributaria/estab" />
        <xsl:variable name="nombreDocumento" select="factura/infoTributaria/codDoc" />
        <xsl:variable name="estab" select="factura/infoTributaria/estab" />
        <xsl:variable name="ptoEmi" select="factura/infoTributaria/ptoEmi" />
        <xsl:variable name="secuencial" select="factura/infoTributaria/secuencial" />
        <xsl:variable name="numContribuyente" select="factura/infoFactura/contribuyenteEspecial" />
        <xsl:variable name="numeroAutorizacion" select="autorizacion/numeroAutorizacion" />
        <xsl:variable name="ambiente" select="factura/infoTributaria/ambiente" />
        <xsl:variable name="fechaAutorizacion" select="autorizacion/fechaAutorizacion" />
        <xsl:variable name="emision" select="factura/infoTributaria/tipoEmision" />
        <xsl:variable name="fechaEmision" select="factura/infoFactura/fechaEmision" />
        <xsl:variable name="telef" select="factura/infoAdicional/campoAdicional/@Telefono" />
        <xsl:variable name="codigoAcceso" select="factura/infoTributaria/claveAcceso" />
        <xsl:variable name="identificacionComprador" select="factura/infoFactura/identificacionComprador" />
        <xsl:variable name="razonSocialComprador" select="factura/infoFactura/razonSocialComprador" />
        <xsl:variable name="direccionCliente" select="factura/infoAdicional/campoAdicional/@DireccioPARROQUIA" />
        <xsl:variable name="baseImponible" select="factura/infoFactura/totalConImpuestos/totalImpuesto/baseImponible" />            
        <xsl:variable name="totalDescuento" select="factura/infoFactura/totalDescuento" />
        <xsl:variable name="valor" select="factura/infoFactura/totalConImpuestos/totalImpuesto/valor" />
        <xsl:variable name="valorTotal" select="factura/infoFactura/importeTotal" />  
        <xsl:variable name="descuentoTotal" select="factura/infoFactura/totalDescuento" />
        <xsl:variable name="propina" select="factura/infoFactura/propina" />
        <xsl:variable name="totalSinImpuestos" select="factura/infoFactura/totalSinImpuestos" />
            
		<html>
			<style>
				.classNameBodyFactura{
					font-family:Verdana, Arial, sans-serif; 
					font-size:9px; 
				}
				.columnClassCabecera3{
					width:3%;
				}
				.columnClassCabecera4{
					width:20%;
					font-weight:bold;
				}
				.columnClassCabecera5{
					width:27%;
				}
				.columnClassCabecera7{
					width:26%;
					font-weight:bold;
				}
				.classNameTable1{
					border-collapse:collapse;
				}
				.columnClassCabeceraDetalle{
					border-style:solid; 
					border-width:1px;
					border-color:inherit;
					font-weight: bold;
					text-align:center;
					background-color:rgb(208, 225, 250);
				}
				.columnClassDetalle2{
					border-style:solid; 
					border-width:1px;
					border-color:inherit;
				}				
				.columnClassTotal1{
					border-style:none; 
					border-width:0px;
					border-color:inherit;
					width:60%;
				}
				.columnClassTotal2{
					border-style:solid; 
					border-width:1px;
					border-color:inherit;
					width:25%;
					text-align:right;
					font-weight: bold;
				}				
				.columnClassTotal3{
					border-style:solid; 
					border-width:1px;
					border-color:inherit;
					width:15%;
					text-align:right;
				}
				.classNameNumber{
					text-align:right;
				}
			</style>

			<div id="idDivFactura" class="classNameBodyFactura"
				style="border:none; width:100%;">
				<div id="idPanelScroll" class="classNamePanelScroll" style="border:none; width:100%; height:{$heightScrollFactura}; overflow-y:auto; margin-top:0px; margin-bottom:0px;">
					<div id="idPanelCabecera" style="border:none; width:100%; padding-top:0px;">
						<table width="100%" border="0" cellpadding="2" cellspacing="0"> 
							<tr>
								<td class="columnClassCabecera4">FACTURA N&#186;:</td>
								<td class="columnClassCabecera5"><xsl:value-of select="$estab"/>-<xsl:value-of select="$ptoEmi"/>-<xsl:value-of select="$secuencial"/></td>
								<td class="columnClassCabecera3"></td>
								<td class="columnClassCabecera7">Raz&#243;n Social / Nombres y Apellidos:</td>      
								<td><xsl:value-of select="$razonSocialComprador" /></td>							
							</tr>
							<tr>
								<td class="columnClassCabecera4">RUC:</td>
								<td class="columnClassCabecera5"><xsl:value-of select="$ruc"/></td>
								<td class="columnClassCabecera3"></td>
								<td class="columnClassCabecera7">RUC/CI:</td>                        
								<td><xsl:value-of select="$identificacionComprador" /></td>                        
							</tr>
							<tr>
								<td class="columnClassCabecera4">No. de Autorizaci&#243;n:</td>
								<td class="columnClassCabecera5"><xsl:value-of select="$numeroAutorizacion"/></td>
								<td class="columnClassCabecera3"></td>
								<td class="columnClassCabecera7">Fecha de emisi&#243;n:</td>                        
								<td><xsl:value-of select="$fechaEmision" /></td>                        
							</tr>
							<tr>
								<td class="columnClassCabecera4">Fecha y hora de autorizaci&#243;n:</td>
								<td class="columnClassCabecera5"><xsl:value-of select="$fechaAutorizacion"/></td>
								<td class="columnClassCabecera3"></td>
							</tr>
							<tr>
								<td class="columnClassCabecera4">Emisi&#243;n:</td>
								<td class="columnClassCabecera5">
									<xsl:if test="$emision='2'">INDISPOSICION</xsl:if>
									<xsl:if test="$emision='1'">NORMAL</xsl:if>
								</td>
								<td class="columnClassCabecera3"></td>
							</tr>
							
							<tr>
								<td colspan="2">
									<div style="font-weight:bold;">Clave de acceso:</div>
									<div id="idDivClaveAcceso">
										<!--
										<img style="width:350px;height:60px;">
											<xsl:attribute name="src"><xsl:value-of select="$context" />/CodigoBarras?data=<xsl:value-of select="$codigoAcceso" />&#38;height=50&#38;width=1</xsl:attribute>
										</img>
										-->
									</div>
									<xsl:value-of select="$codigoAcceso" />
								</td>	
							</tr>		
						</table>

						<table width="100%" border="0" align="center" cellpadding="3" cellspacing="0" style='margin-top: 10px;' >                    
							<tr>
							</tr>
							<tr>
							</tr>						
							<tr>
							</tr>												
						</table>
					</div>

					<!-- DETALLES -->
					<div id="idDivDetalles" 
						style="border:none; width:100%; margin-top:0px; margin-bottom:0px; background: white;">
						<table width="100%" border="0" align="center" cellpadding="2" cellspacing="0" class="classNameTable1">
							<tr>
								<td class="columnClassCabeceraDetalle">Cod principal</td>				
								<td colspan="" class="columnClassCabeceraDetalle">Descripci&#243;n</td>
								<td class="columnClassCabeceraDetalle">Cant</td> 
								<td colspan="" class="columnClassCabeceraDetalle">Precio unitario</td>
								<td colspan="" class="columnClassCabeceraDetalle">Descuento</td>
								<td colspan="" class="columnClassCabeceraDetalle">Precio total</td> 
								<td class="columnClassCabeceraDetalle">Porcentaje</td>
								<td class="columnClassCabeceraDetalle">Base imponible</td>
								<td class="columnClassCabeceraDetalle">Valor</td>
							</tr>	
							<xsl:for-each select="factura/detalles/detalle">					
								<xsl:variable name="codigo" select="codigoPrincipal" />
								<xsl:variable name="descripcion" select="descripcion" />
								<xsl:variable name="cantidad" select="cantidad" />
								<xsl:variable name="precio" select="precioUnitario" />
								<xsl:variable name="precioTotal" select="precioTotalSinImpuesto" />
								<tr>
									<td class="columnClassDetalle2"><xsl:value-of select="$codigo"/></td>
									<td colspan="" class="columnClassDetalle2"><xsl:value-of select="$descripcion"/></td>
									<td class="columnClassDetalle2 classNameNumber"><xsl:value-of select="$cantidad"/></td>
									<td class="columnClassDetalle2 classNameNumber"><xsl:value-of select="format-number($precio,'###.##0,0000','numerico')" /></td>
									<td class="columnClassDetalle2 classNameNumber"></td>
									<td class="columnClassDetalle2 classNameNumber"><xsl:value-of select="format-number($precioTotal,'###.##0,00','numerico')" /></td>	                    	
									<xsl:for-each select="impuestos/impuesto">
										<td class="columnClassDetalle2 classNameNumber"><xsl:value-of select="format-number(tarifa,'###.##0,00','numerico')" /></td>
									</xsl:for-each>
									<xsl:for-each select="impuestos/impuesto">
										<td class="columnClassDetalle2 classNameNumber"><xsl:value-of select="format-number(baseImponible,'###.##0,00','numerico')" /></td>
									</xsl:for-each>
									<xsl:for-each select="impuestos/impuesto">
										<td class="columnClassDetalle2 classNameNumber"><xsl:value-of select="format-number(valor,'###.##0,00','numerico')" /></td>
									</xsl:for-each>
								</tr>	                
							</xsl:for-each>
						</table> 
					</div>
				</div>
				
				<!-- TOTALES FACTURA -->
				<div id="idPanelTotales" style="border:none; width:98%; padding-top:0px; background:white;" class="idPanelTotalesClass">
					<table width="100%" border="0" cellpadding="3" cellspacing="0" class="classNameTable1">   
						<tr>             
							<td rowspan="10" class="columnClassTotal1"></td>
							<td class="columnClassTotal2">SUBTOTAL 12%:</td>
							<td class="columnClassTotal3">
								<xsl:for-each select="factura/infoFactura/totalConImpuestos/totalImpuesto">
									<xsl:choose>
										<xsl:when test="codigoPorcentaje = 2">								  
										  <xsl:value-of select="format-number(baseImponible,'###.##0,00','numerico')" />
										</xsl:when>
										<xsl:when test="codigoPorcentaje != 2">								  
										</xsl:when>
									</xsl:choose> 
								</xsl:for-each>                                        
							</td>
						</tr>
						<tr>
							<td class="columnClassTotal2">DESCUENTO ADICIONAL:</td>
							<td class="columnClassTotal3">
								<xsl:if test="factura/infoFactura/totalConImpuestos/totalImpuesto/descuentoAdicional">
									<xsl:for-each select="factura/infoFactura/totalConImpuestos/totalImpuesto">
										<xsl:choose>
											<xsl:when test="codigoPorcentaje = 2">								  
											  <xsl:value-of select="format-number(descuentoAdicional,'###.##0,00','numerico')" />
											</xsl:when>
											<xsl:when test="codigoPorcentaje != 2">0.00								  
											</xsl:when>
										</xsl:choose> 
									</xsl:for-each> 
								</xsl:if>
							</td>
						</tr>
						<tr>
							<td class="columnClassTotal2">SUBTOTAL 0%:</td>
							<td class="columnClassTotal3">
								<xsl:for-each select="factura/infoFactura/totalConImpuestos/totalImpuesto">
									<xsl:variable name="flag">false</xsl:variable>
									<xsl:choose>
										<xsl:when test="codigoPorcentaje = 0">								  
										  <xsl:value-of select="format-number(baseImponible,'###.##0,00','numerico')" />								  
										</xsl:when>
										
										<xsl:when test="codigoPorcentaje != 0 and $flag='true'">								  
											<xsl:value-of select="$flag"/>
										</xsl:when>
									</xsl:choose>                        
								</xsl:for-each>
							</td>
						</tr>		
						<tr>                                 
							<td class="columnClassTotal2">SUBTOTAL NO SUJETO DE IVA:</td>
							<td class="columnClassTotal3">
								<xsl:for-each select="factura/infoFactura/totalConImpuestos/totalImpuesto">
									<xsl:choose>
										<xsl:when test="codigoPorcentaje = 6">								  
										  <xsl:value-of select="format-number(baseImponible,'###.##0,00','numerico')" />
										</xsl:when>
										<xsl:when test="codigoPorcentaje != 6">								  
										</xsl:when>
									</xsl:choose>                        
								</xsl:for-each>
							</td>
						</tr>
						<tr>                              
							<td class="columnClassTotal2">SUBTOTAL SIN IMPUESTOS:</td>
							<td class="columnClassTotal3"><xsl:value-of select="$totalSinImpuestos"/></td>
						</tr>
						<tr>                                 
							<td class="columnClassTotal2">DESCUENTO:</td>
							<td class="columnClassTotal3"><xsl:value-of select="format-number($descuentoTotal,'###.##0,00','numerico')" /></td>
						</tr>
						<tr>                        
							<td class="columnClassTotal2">ICE:</td>
							<td class="columnClassTotal3">0,00</td>
						</tr>
						<tr>                                  
							<td class="columnClassTotal2">IVA 12%:</td>
							<td class="columnClassTotal3">
								<xsl:for-each select="factura/infoFactura/totalConImpuestos/totalImpuesto">
									<xsl:choose>
										<xsl:when test="codigoPorcentaje = 2">								  
										  <xsl:value-of select="format-number(valor,'###.##0,00','numerico')" />
										</xsl:when>
										<xsl:when test="codigoPorcentaje != 2">								  
										</xsl:when>
									</xsl:choose>                        
								</xsl:for-each>
							</td>
						</tr>
						<tr>                                 
							<td class="columnClassTotal2">PROPINA:</td>
							<td class="columnClassTotal3"><xsl:value-of select="format-number($propina,'###.##0,00','numerico')" /></td>
						</tr>
						<tr>                                    
							<td class="columnClassTotal2">VALOR TOTAL:</td>
							<td class="columnClassTotal3"><xsl:value-of select="format-number($valorTotal,'###.##0,00','numerico')" /></td>
						</tr> 
					</table>
				</div>

			</div>    
		</html>
	</xsl:template>
	
</xsl:stylesheet>