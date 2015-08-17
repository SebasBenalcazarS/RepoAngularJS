<?xml version='1.0'?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:template match="/">
		<html>
			<table border="0" cellspacing="0" cellpadding="0" width="900px">
				<tr>
					<td>
						<table width="100%">
							<tr>
								<td><img src="cid:LOGO" border="0"/>
								</td>
							</tr>
						</table>
					</td>
				</tr>
				<tr>
					<td height="15px"><xsl:value-of select="datos/de"/></td>
				</tr>
				<tr>
					<td height="15px"><xsl:value-of select="datos/para"/></td>
				</tr>
				<tr>
					<td height="10px"></td>
				</tr>				
				<tr>
					<td>Estimado(a)&#xA0; proveedor:
					</td>
				</tr>
				<tr>
					<td height="10px"></td>
				</tr>				
				<tr>
					<td>Adjunto a la presente encontrar&#225; el reporte de las &#243;rdenes de compra en formato pdf. Las razones para su env&#237;o son las siguientes: </td>
				</tr>
				<tr>
					<td height="10px"></td>
				</tr>
				<tr>
					<td height="15px"><xsl:value-of select="datos/razon"/></td>
				</tr>			
				<tr>
					<td height="15px"></td>
				</tr>
				<tr>
					<td>Atentamente,</td>
				</tr>
				<!--
				<tr>
					<td height="15px"><xsl:value-of select="datos/usuario"/></td>
				</tr>
				-->
				<tr>
					<td height="10px"></td>
				</tr>				
				<tr>
					<td>
						<table border="0" width="100%" cellpadding="0" cellspacing="0">
							<tr>
								<td><b>CORPORACI&#xD3;N FAVORITA C.A.</b></td>
							</tr>
							<tr>
								<td>AV. GRAL. ENR&#xCD;QUEZ S/N VIA - COTOGCHOA</td>
							</tr>
							<tr>
								<td>TEL&#xC9;FONOS: 593 2 2996500</td>
							</tr>
							<tr>
								<td>R.U.C: 1790016919001</td>
							</tr>
							<tr>
								<td>MATRIZ: QUITO - ECUADOR</td>
							</tr>
						</table>
					</td>
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