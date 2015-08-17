<?xml version='1.0'?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:template match="/">
		<html>
			<table border="0" cellspacing="0" cellpadding="0" width="900px">
				<tr>
					<td height="10px"></td>
				</tr>				
				<tr>
					<td height="15px">Se produjo un error al migrar <xsl:value-of select="datos/tipoMigracion"/></td>
				</tr>
				<tr>
					<td height="10px"></td>
				</tr>
				<tr>
					<td height="15px">--------DETALLE INCIDENCIA----------</td>
				</tr>
				<tr>
					<td height="10px"></td>
				</tr>
				<tr>
					<td height="15px"><xsl:value-of select="datos/cabeceraError"/></td>
				</tr>
				<tr>
					<td height="10px"></td>
				</tr>
				<tr>
					<td height="15px"><xsl:value-of select="datos/contenidoError"/></td>
				</tr>								
				<tr>
					<td height="30px"></td>
				</tr>
				<tr>
					<td>
						Nota: Esta informaci&#xF3;n fue generada autom&#xE1;ticamente.
					</td>
				</tr>				
			</table>
		</html>
	</xsl:template>
</xsl:stylesheet>