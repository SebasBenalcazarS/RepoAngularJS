<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:output version="1.0" encoding="UTF-8" indent="no"
		omit-xml-declaration="no" media-type="text/html" method="html" />
	<xsl:template match="/">
		<html>
			<head>
				<style type="text/css">
					.styleCabDet{
						color: #000000;
						font-size:10px;
						font-style: bold;
						line-height: normal;
						font-family: Arial;
					}
					.styleDet{
						color: #000000;
						font-size: 9px;
						font-style: normal;
						line-height: normal;
						font-family: Arial;
					}
					
				</style>
			</head>
			<xsl:for-each select="datosNotaPedido/datos">
				<table width="100%" align="center" cellpadding="0" cellspacing="0">
					<!-- fila 1 cabecera -->
					<tr>
						<th align="left" colspan="2" style="border:1px solid black;">
							Pedido (P.O.)No.:&#xA0;<xsl:value-of select="orden/numeroOrden"/>
							&#xA0;&#xA0;<xsl:value-of select="orden/codigoReferencia"/>
							&#xA0;&#xA0;Fecha orden: <xsl:value-of select="orden/fechaOrden"/>
						</th>
					</tr>
					
					<!-- PROVEEDOR & CORPORACION -->
					<tr bordercolor="black">
						<th style="border:1px solid black;">
							<table width="100%" >
								<tr>
									<td width="10%">To:</td><td width="90%"><xsl:value-of select="datosProveedor/nombre"/></td>
								</tr>
								<tr>
									<td width="10%"></td><td width="90%"><xsl:value-of select="datosProveedor/direccion"/></td>
								</tr>
								<tr>
									<td width="10%"></td><td width="90%"><xsl:value-of select="datosProveedor/ciudad"/></td>
								</tr>
								<tr>
									<td width="10%"></td><td width="90%"><xsl:value-of select="datosProveedor/pais"/></td>
								</tr>
								<tr>
									<td width="10%"></td><td width="90%">Tlf.:<xsl:value-of select="datosProveedor/telefono"/></td>
								</tr>
								<tr>
									<td width="10%"></td><td width="90%">Fax:<xsl:value-of select="datosProveedor/fax"/></td>
								</tr>
								<tr>
									<td width="10%"></td><td width="90%">Contact:<xsl:value-of select="datosProveedor/contacto"/></td>
								</tr>
							</table>
						</th>
						<th style="border:1px solid black;">
							<table width="100%">
								<tr>
									<td width="15%">Bill to:</td><td width="85%"><xsl:value-of select="clienteNombre"/></td>
								</tr>
								<tr>
									<td width="15%"></td><td width="85%">AVE. GENERAL ENRIQUEZ</td>
								</tr>
								<tr>
									<td width="15%"></td><td width="85%">COTOGCHOA, SALGOLQUI</td>
								</tr>
								<tr>
									<td width="15%"></td><td width="85%">QUITO</td>
								</tr>
								<tr>
									<td width="15%"></td><td width="85%">Tlf.:+593-022-996-500 ext.6524</td>
								</tr>
								<tr>
									<td width="15%"></td><td width="85%">Fax:+593-022-996-500 ext.6637</td>
								</tr>
								<tr>
									<td width="15%"> </td><td width="85%"><xsl:value-of select="orden/contactoBillTo"/></td>
								</tr>
								
							</table>
						</th>
					</tr>
					
					<!-- REPRESENTANTE & ENVIO -->
					<tr >
						<td>
							<table width="100%" border="1">
								<tr>
									<td width="10%">Rep:</td><td width="90%" align="left">NONE</td>
								</tr>
								<tr>
									<td width="100%" colspan="2">.</td>
								</tr>
								<tr>
									<td width="100%" colspan="2">.</td>
								</tr>
								<tr>
									<td width="100%" colspan="2">.</td>
								</tr>
								<tr>
									<td width="100%" colspan="2">.</td>
								</tr>
								<tr>
									<td width="100%" colspan="2">.</td>
								</tr>
							</table>
						</td>
						
						<td>
							<table width="100%" border="1">
								<tr>
									<td width="15%">Ship to:</td><td width="85%"><xsl:value-of select="clienteNombre"/></td>
								</tr>
								<tr>
									<td width="15%"></td><td width="85%">AVE. GENERAL ENRIQUEZ</td>
								</tr>
								<tr>
									<td width="15%"></td><td width="85%">COTOGCHOA, SALGOLQUI</td>
								</tr>
								<tr>
									<td width="15%"></td><td width="85%">QUITO</td>
								</tr>
								<tr>
									<td width="15%"></td><td width="85%">Tlf.:+593-022-996-500 ext.6524</td>
								</tr>
								<tr>
									<td width="15%"></td><td width="85%">Fax:+593-022-996-500 ext.6637</td>
								</tr>
								<tr>
									<td width="15%"></td><td width="85%"></td>
								</tr>
							</table>
						</td>
					</tr>
					
					<!-- CONDICIONES DE PAGO -->
					<tr>
						<td colspan="2">
							<table width="100%" border="1">
								<tr>
									<td width="25%" align="left">Payment Terms...:</td>
									<td width="25%" align="left"></td>
									<td width="25%" align="left">Shipping Terms...:</td>
									<td width="25%" align="left"></td>
								</tr>
								<tr>
									<td width="25%" align="left">Do Not Ship before:</td>
									<td width="25%" align="left">dateBefore</td>
									<td width="25%" align="left">and not after:</td>
									<td width="25%" align="left">dateAfter</td>
								</tr>
							</table>	
						</td>
						
					</tr>
				</table>
				
				<!-- CABECERA DETALLES DINAMICO -->
				<table width="100%" align="center" cellpadding="0" cellspacing="0">
									
					<thead>
						<tr>
							<td>
								<table width="100%" align="left">
									<col style="width:5%;" />
									<col style="width:10%;" />
									<col style="width:10%;" />
									<col style="width:10%;" />
									<col style="width:10%;" />
									<col style="width:29%;" />
									<col style="width:13%;" />
									<col style="width:13%" />
									<tr>
										<th align="left" style="border:1px solid black;font-weight: bold;" colspan= "8">
											Pedido (P.O.)No.:&#xA0;<xsl:value-of select="orden/numeroOrden"/>
											&#xA0;&#xA0;<xsl:value-of select="orden/codigoReferencia"/>
											&#xA0;&#xA0;Fecha orden: <xsl:value-of select="orden/fechaOrden"/>
										</th>
									</tr>
									
									<tr>
										<th width="5%"  style="border:1px solid black;font-weight: bold;" align="left">No.</th>
										<th width="10%" style="border:1px solid black;font-weight: bold;" align="center">Qyt.</th>
										
										<th width="10%" style="border:1px solid black;font-weight: bold;" align="center">Unit</th>
										<th width="20%" style="border:1px solid black;font-weight: bold;" align="center" colspan="2">Item Number</th>
										
										<th width="25%" style="border:1px solid black;font-weight: bold;" align="center">Description</th>
										<th width="15%" style="border:1px solid black;font-weight: bold;" align="center">Unit Price USD</th>
										<th width="15%" style="border:1px solid black;font-weight: bold;" align="center">Total Amount</th>
									</tr>
									<tr>
										<th width="15%" style="border:1px solid black;font-weight: bold;" align="center" colspan="2">Inner</th>
										
										<th width="10%" style="border:1px solid black;font-weight: bold;" align="center">Pack</th>
										<th width="10%" style="border:1px solid black;font-weight: bold;" align="center">Cube</th>
										<th width="10%" style="border:1px solid black;font-weight: bold;" align="center">Volume</th>
										
										<th width="25%" style="border:1px solid black;font-weight: bold;" align="center">UPC Code</th>
										<th width="30%" style="border:1px solid black;font-weight: bold;" align="center" colspan="2">Class Name</th>
									</tr>
									<tr>
										<th colspan="8" align="center" width="100%" style="border-bottom:1px solid black;font-weight: bold;">Title: REVISAR DATO</th>
									</tr>
								</table>
							</td>
						</tr>
					</thead>
					
					<!-- DETALLES -->
					<tbody>
						<xsl:for-each select="notaPedido/detalles">
							<tr>
								<td>
									<table width="100%">
										<col style="width:5%;" />
										<col style="width:10%;" />
										<col style="width:10%;" />
										<col style="width:10%;" />
										<col style="width:10%;" />
										<col style="width:29%;" />
										<col style="width:13%;" />
										<col style="width:13%" />
										
										<tbody>
											<!-- SALTOS DE PAGINA --> 	
											<xsl:if test="saltoPagina='inicial'">
												<tr>
													<td height="25"></td>
												</tr>	
											</xsl:if>
											<xsl:if test="saltoPagina='documento'">
												<tr>	
													<td height="10"></td>
												</tr>	
											</xsl:if>
											
											<tr>
												<!-- No. -->
												<td align="left">
													<xsl:value-of select="nro" />
												</td>
												<!-- Qty.-->
												<td align="center">
													<xsl:value-of select="cantidad" />
												</td>
												<!-- Unit-->
												<td align="center"></td>
												<!-- Item Number -->
												<td align="center" colspan="2">
													<xsl:value-of select="referencia" />
												</td>
												<!-- Description -->
												<td align="center">
													<xsl:value-of select="descripcion" />
												</td>
												<!-- Unit Price USD -->
												<td align="center">
													<xsl:value-of select="costoNeto" />
												</td>
												<!-- Total Amount-->
												<td align="center">
													<xsl:value-of select="valorTotal" />
												</td>
											</tr>
											
											<tr>
												<!-- Inner -->
												<td align="center" colspan="2">
													<xsl:value-of select="unidad" />&#xA0;<xsl:value-of select="unidadManejo" />
												</td>
												<!-- Pack-->
												<td align="center"></td>
												<!-- Cube -->
												<td align="center">
													<xsl:value-of select="cubicaje" />
												</td>
												<!-- Volume -->
												<td align="center"></td>
												<!-- UPC Code -->
												<td align="center">
													<xsl:value-of select="codigoBarras" />
												</td>
												<!-- Class Name -->
												<td align="center" colspan="2">
													<xsl:value-of select="nombreClase" />
												</td>
											</tr>
											
											<tr>
												<th align="left" colspan="2" style="font-weight: bold;">Material:</th>
												<th align="left" colspan="6"><xsl:value-of select="material" /></th>
											</tr>
											<tr>
												<th align="left" colspan="2" style="font-weight: bold;">Country:</th>
												<th align="left" colspan="6"><xsl:value-of select="pais"/></th>					
											</tr>
											<tr>
												<th align="left" colspan="2" style="font-weight: bold;">Brand:</th>
												<th align="left" colspan="6"><xsl:value-of select="marca"/></th>					
											</tr>
											<tr>
												<th align="left" width="15%" colspan="8">
												______________________________________________________________________________________________________________
												</th>
											</tr>
										</tbody>
									</table>
								</td>
							</tr>
						</xsl:for-each>

						<!-- TOTALES NOTA DEL PEDIDO -->
						<tr>
							<td height="10"></td>
						</tr>
						
						<tr>
							<td align="left">
								<table width="100%" cellpadding="0" cellspacing="0">
									<tr>
										<td class="styleCabDet" align="left" width="30%"  style="font-weight: bold;">Total Volume CBM:&#xA0;&#xA0;</td>
										<td class="styleCabDet" align="left" width="30%"  style="font-weight: bold;">Grand Gross Weight KSG: &#xA0;&#xA0;0.00</td>
										<td class="styleCabDet" align="right" width="40%" style="font-weight: bold;">=========================================</td>
									</tr>
								</table>
							</td>
						</tr>
						<tr>
							<td align="left">
								<table width="100%" cellpadding="0" cellspacing="0">
									<tr>
										<td width="30%">.</td>
										<td class="styleCabDet" align="left" width="30%" style="font-weight: bold;">Grand Net Weight KSG...: &#xA0;&#xA0;<xsl:value-of select="notaPedido/detalles/pesoTotal" /></td>
										<td class="styleCabDet" align="left" width="15%">USD &#xA0;&#xA0;&#xA0;&#xA0;</td>
										<td class="styleCabDet" align="right" width="25%" ><xsl:value-of select="notaPedido/totalPedido" /></td>
									</tr>
								</table>
							</td>
						</tr>
						<tr>
						<td align="left">
								<table width="100%" cellpadding="0" cellspacing="0">
									<tr>
										<td width="60%" align="right">.</td>
										<td width="40%" align="left">IN US DOLLARS</td>
									</tr>
								</table>
							</td>
						</tr>
						
					</tbody>
				
					
				</table>
				
				
				
			</xsl:for-each>
		</html>
	</xsl:template>
</xsl:stylesheet>