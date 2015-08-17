<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:output version="1.0" encoding="UTF-8" indent="no" omit-xml-declaration="no" media-type="text/html" method="html"/>
	
	<xsl:template match="/">
	
		<html>
			<head>	
				
			</head>	
			
			<table style="border-spacing:5px 0px;border-collapse:separate;">
			
				<thead>
					<tr>
						<td style="text-align:right;height:20px;" colspan="9"><xsl:value-of select="pedido/cabecera/fechaReporte"/></td> 
					</tr>
					<tr>
						<td style="text-align:center;" colspan="9">
							<h2>C O R P O R A C I O N     F A V O R I T A</h2>
						</td>
					</tr>
					<tr>
						<td style="text-align:center;" colspan="9">SISTEMA DE INFORMACION COMERCIAL</td> 
					</tr>
					<tr>
						<td style="text-align:center;" colspan="9">REPORTE DE ARTICULOS EN STAND BY</td>
					</tr>
					<tr>
						<td style="text-align:center;height:20px;" colspan="9"></td> 
					</tr>
					<tr>
						<td style="text-align:left;" colspan="4">LOCAL : <xsl:value-of select="pedido/cabecera/local"/></td>
						<td></td>
						<td style="text-align:left;" colspan="4">USUARIO : <xsl:value-of select="pedido/cabecera/usuario"/></td>
					</tr>
					<tr>
						<td style="text-align:left;" colspan="4">SUBBODEGA : <xsl:value-of select="pedido/cabecera/subbodega"/></td>
						<td></td>
						<td style="text-align:left;" colspan="4">C.D. : <xsl:value-of select="pedido/cabecera/centroDistribucion"/></td>
					</tr>
					<tr>
						<td style="text-align:left;" colspan="4">FECHA PEDIDO : <xsl:value-of select="pedido/cabecera/fechaDespacho"/></td>
						<td></td>
						<td style="text-align:left;" colspan="4">HORA CONFIRMACION : <xsl:value-of select="pedido/cabecera/horaMaxTra"/></td>
					</tr>
					<tr>
						<td style="text-align:center;height:20px;" colspan="9"></td>
					</tr>
					<tr>
						<td width="12%" style="text-align:right;font-size:7px;">COD.BAR.</td>
						<td width="43%" style="text-align:left;font-size:7px;">DESCRIPCION/TAMANO</td>
						<td width="5%"  style="text-align:right;font-size:7px;">U.M.</td>
						<td width="9%" style="text-align:right;font-size:7px;">EXI.C.D.</td>
						<td width="9%" style="text-align:right;font-size:7px;">EXI.LOC</td>
						<td width="8%"  style="text-align:right;font-size:7px;">V.A.</td>
						<td width="8%"  style="text-align:right;font-size:7px;">PROY.</td>
						<td width="8%"  style="text-align:right;font-size:7px;">CANT.</td>
						<td width="8%"  style="text-align:right;font-size:7px;">CANT.R.</td>
					</tr>
					
					<tr>
						<td width="12%" style="text-align:right;font-size:7px;">_____________</td>
						<td width="43%" style="text-align:left;font-size:7px;">_____________________________________________</td>
						<td width="5%"  style="text-align:right;font-size:7px;">_____</td>
						<td width="9%"  style="text-align:right;font-size:7px;">_______</td>
						<td width="9%"  style="text-align:right;font-size:7px;">________</td>
						<td width="8%"  style="text-align:right;font-size:7px;">________</td>
						<td width="8%"  style="text-align:right;font-size:7px;">________</td>
						<td width="8%"  style="text-align:right;font-size:7px;">________</td>
						<td width="8%"  style="text-align:right;font-size:7px;">________</td>
					</tr>
					
		
				</thead>
				
				<tbody>
					<xsl:for-each select="pedido/detalles/detalle">	
						<tr>
							<td width="12%"  style="text-align:right;"><xsl:value-of select="codigoBarras"/></td>
							<td width="33%"  style="text-align:left ;"><xsl:value-of select="descripcion"/></td>
							<td width="5%"  style="text-align:right;"><xsl:value-of select="unidadManejo"/></td>
							<td width="5%"  style="text-align:right;"><xsl:value-of select="existenciaCD"/></td>
							<td width="5%"  style="text-align:right;"><xsl:value-of select="existenciaLocal"/></td>
							<td width="5%"  style="text-align:right;">78989</td>
							<td width="5%"  style="text-align:right;">45289</td>
							<td width="5%"  style="text-align:right;"><xsl:value-of select="cantidad"/></td>
							<td width="5%"  style="text-align:right;">________</td>
						</tr>
					</xsl:for-each>
				</tbody>
			
			</table>
			
		</html>
	</xsl:template>
</xsl:stylesheet>