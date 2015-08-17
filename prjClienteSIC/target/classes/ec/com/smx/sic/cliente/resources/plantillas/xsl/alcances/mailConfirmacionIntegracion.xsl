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
                  <xsl:value-of select="datos/para" />
               </td>
            </tr>
            <tr>
               <td height="15px" />
            </tr>
            <tr>
               <td>
                  <xsl:value-of select="datos/textoMensajeCabecera" />
               </td>
            </tr>
			
            <tr>
               <td height="15px" />
            </tr>
           
			 <xsl:variable name="motivo" select="datos/motivo" />
			<xsl:if test="count(//articulosLocalesNoIntegrados) > 0">
               <tr>
                  <td height="15px" />
               </tr>

               <tr>
                  <td height="15px" />
               </tr>
               <tr>
                  <td>
                     <table border="1">
                        <tr>
                           <td>
                              <b>Art&#237;culo</b>
                           </td>						    
						   <td>
							  <b>&#193;rea de trabajo</b>
						   </td>	
							  <td>
								<b>Motivo</b>
							  </td>
                        </tr>
                        <xsl:for-each select="/datos/articulosLocalesNoIntegrados">
                           <tr>
                              <td>
                                 <xsl:value-of select="codigoArticulo" /> -
								 <xsl:value-of select="nombreArticulo" />
                              </td>
							  <td>
								 <xsl:value-of select="codigoLocal" /> -
								 <xsl:value-of select="nombreLocal" />
							  </td>	
							  <xsl:if test="motivo='2'">
							  <td>&#193;rea de trabajo no existe</td>
							  </xsl:if>
							  <xsl:if test="motivo='3'">
							  <td>Prototipo no existe</td>
							  </xsl:if>
							  <xsl:if test="motivo='4'">
							  <td>Art&#237;culo no existe</td>
							  </xsl:if>
                           </tr>
                        </xsl:for-each>
                     </table>
                  </td>
               </tr>
            </xsl:if>
			
			<tr>
               <td height="15px" />
            </tr>
            <tr>
               <td>
                  <table border="0" width="100%" cellpadding="0" cellspacing="0">
                     <tr>
                        <td>
                           <b>CORPORACI&#211;N FAVORITA C.A.</b>
                        </td>
                     </tr>
                     <tr>
                        <td>AV. GRAL. ENR&#205;QUEZ S/N VIA - COTOGCHOA</td>
                     </tr>
                     <tr>
                        <td>TEL&#201;FONOS: 593 2 2996500</td>
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
         </table>
      </html>
   </xsl:template>
</xsl:stylesheet>