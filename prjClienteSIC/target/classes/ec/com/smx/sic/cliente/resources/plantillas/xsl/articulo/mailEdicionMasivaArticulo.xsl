<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:exsl="http://exslt.org/common" extension-element-prefixes="exsl" version="1.0">
   <xsl:template match="/">
      <html>
         <table border="0" cellspacing="0" cellpadding="0" width="900px">

            <tr>
               <td height="10px" />
            </tr>
            <tr>
               <td>
                  Estimado(a):
                  <xsl:value-of select="datos/para"/>
               </td>
            </tr>
			<tr>
				<td height="15px" />
			</tr>
			<tr>
				<td>
					<xsl:value-of select="datos/textoCabecera" />
				</td>
			</tr>
            <tr>
               <td height="15px" />
            </tr>
			<xsl:if test="count(//articulos) > 0">
               <tr>
				  <td>
					<xsl:value-of select="datos/textoCabeceraError" />
				  </td>
               </tr>
               <tr>
                  <td height="15px" />
               </tr>
               <tr>
                  <td>
                     <table border="1" style ="border-collapse : collapse">
                        <tr>
                           <td>
                              <b>C&#243;digo barras</b>
                           </td>
							<td>
                              <b>Descripci&#243;n art&#237;culo</b>
                           </td>						   
                        </tr>
                        <xsl:for-each select="/datos/articulos">
                           <tr>
                              <td>
                                 <xsl:value-of select="codigoBarras" />
                              </td>
							  <td>
                                 <xsl:value-of select="descripcion" />
                              </td>
                           </tr>
                        </xsl:for-each>
                     </table>
                  </td>
               </tr>
            </xsl:if>
         </table>
      </html>
   </xsl:template>
</xsl:stylesheet>