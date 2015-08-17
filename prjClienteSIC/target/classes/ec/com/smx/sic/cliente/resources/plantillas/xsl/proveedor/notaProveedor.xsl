<?xml version="1.0"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:exsl="http://exslt.org/common" extension-element-prefixes="exsl" version="1.0">
	<xsl:param name="codigojde"></xsl:param>
	<xsl:param name="nombre"></xsl:param>
	<xsl:param name="identificador"></xsl:param>
	<xsl:param name="mail"></xsl:param>				
	<xsl:template match="/">
		<html>
				<table>
					<tr>
				      	 <td>
						<table width="100%">
							    <tr>
								<td>  
								    <img hspace="0" align="baseline" border="0"><xsl:attribute name="src">/max/resources/images/sistemas/LOGO.gif</xsl:attribute></img>
								</td>                                            
							    </tr>
						</table>
					   </td>
					</tr>				
					<tr>
						<td>
							Señor Proveedor : <b> <xsl:value-of select="$codigojde"/> - <xsl:value-of select="$nombre"/> </b>
						</td>
					</tr>
					<tr>
						<td style="height:0.5cm;"></td>
					</tr>
					<tr>
						<td>
							La presente tiene por objeto entregar a usted  el Usuario de acceso a la aplicación B2B (Business to Business) de Corporación Favorita C.A., a la que podrá acceder a través de la siguiente página: <b>http://www.slf.com.ec</b>.
						</td>
					</tr>
					<tr>
						<td style="height:0.3cm;"></td>
					</tr>
					<tr>
						<td>
							En la parte inferior de esta hoja, se encuentra su Usuario Administrador, el mismo que está formado por el prefijo ADM seguido de su código de proveedor; el Identificador que es el número de RUC de su empresa y el email de dicho usuario. Cuando usted ingrese por primera vez a nuestro portal deberá seleccionar la opción <b>¿Olvidó su contraseña?</b>, luego deberá ingresar su usuario e identificador y entonces se generará una contraseña que será enviada a su email. La primera vez que utilice su contraseña el sistema le pedirá que la cambie y después ocurrirá lo mismo cada 30 días.
						</td>
					</tr>
					<tr>
						<td style="height:0.3cm;"></td>
					</tr>
					<tr>
						<td>
							Cabe recordar que este usuario y contraseña son de uso exclusivo y por ende, confidencial de acuerdo a las normas que se encuentran en el ACUERDO DE CONFIDENCIALIDAD que usted firmó.
						</td>
					</tr>
					<tr>
						<td style="height:0.3cm;"></td>
					</tr>
					<tr>
						<td>
							Cualquier duda, problema o inconveniente, favor comuníquese a los teléfonos 09-9200-345 o al 2240-997 con el Sr. Marlon Murillo para que le asista en su problema.
						</td>
					</tr>
					<tr>
						<td style="height:0.3cm;"></td>
					</tr>
					<tr>
						<td>
							Atentamente,
						</td>
					</tr>
					<tr>
						<td style="height:0.3cm;"></td>
					</tr>
					<tr>
						<td>
							Departamento Comercial
						</td>
					</tr>
					<tr>
						<td style="height:0.3cm;"></td>
					</tr>
					<tr>
						<td>
							CORPORACION FAVORITA C.A.
						</td>
					</tr>
					<tr>
						<td style="height:0.3cm;"></td>
					</tr>
					<tr>
						<td>
							<b>Proveedor:</b>  <xsl:value-of select="$codigojde"/>  -  <xsl:value-of select="$nombre"/>
						</td>
					</tr>
					<tr>
						<td style="height:0.1cm;"></td>
					</tr>
					<tr>
						<td>
							<b>Usuario:</b>  <xsl:value-of select="Consulta/Registro/v.cuentaUsuario"/> 
						</td>
					</tr>
					<tr>
						<td style="height:0.1cm;"></td>
					</tr>
					<tr>
						<td>
							<b>Identificador:</b>  <xsl:value-of select="$identificador"/>
						</td>
					</tr>
					<tr>
						<td style="height:0.1cm;"></td>
					</tr>
					<tr>
						<td>
							<b>Mail:</b>  <xsl:value-of select="$mail"/>
						</td>
					</tr>
				</table>
		</html>
	</xsl:template>
</xsl:stylesheet>