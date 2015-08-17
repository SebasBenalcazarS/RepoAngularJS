<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:template match="/">
	  <html>
		  <body>
			<p>Estimado(a): <xsl:value-of select="mensaje/para"/></p>
			<p>Se le comunica que los art&#237;culos editados por archivo excel, <xsl:value-of select="mensaje/mensajeTexto"/></p>
			<p><xsl:value-of select="mensaje/fechaCreacion"/></p>
			<p><xsl:value-of select="mensaje/nombreArchivo"/></p>
			<h4><xsl:value-of select="mensaje/textoFilaCorrecto"/></h4>
			<p><xsl:value-of select="mensaje/mensajeTextoError"/></p>
			<h4><xsl:value-of select="mensaje/textoFilaIncorrecto"/></h4>
			<table border="0" style="BORDER: #cccccc 1px solid" cellspacing="0" cellpadding="0">
			  <tr style = "FONT-SIZE: 9px; FONT-FAMILY: Verdana, Arial, Helvetica; FONT-WEIGHT: bold; COLOR: #ffffff; FONT-STYLE: normal; LINE-HEIGHT: normal; BACKGROUND-COLOR: #ff0f0f">
				<th><xsl:value-of select="mensaje/articulosInc/tituloFilaIncorrecto"/></th>
			  </tr>
			  <xsl:for-each select="mensaje/articulosInc/articuloInc">
			  <tr>
				<td style="BORDER-BOTTOM: #cccccc 1px solid; BORDER-LEFT: #cccccc 1px solid"><xsl:value-of select="fila"/></td>
			  </tr>
			  </xsl:for-each>
			</table>
		  </body>
	  </html>
	</xsl:template>
</xsl:stylesheet>