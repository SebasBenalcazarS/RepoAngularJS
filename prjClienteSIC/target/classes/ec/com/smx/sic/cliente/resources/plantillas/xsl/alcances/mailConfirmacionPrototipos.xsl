<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:exsl="http://exslt.org/common" extension-element-prefixes="exsl" version="1.0">
   <xsl:template match="/">
      <html>
         <table border="0" cellspacing="0" cellpadding="0" width="900px">
            <tr>
               <td>
              
               </td>
            </tr>
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
            <xsl:variable name="codigoTipoAsignacion" select="datos/codigoTipoAsignacion" />
			<xsl:variable name="tipoMail" select="datos/tipoMail" />
			<xsl:if test="($tipoMail='ALC_MAS')">			
            <xsl:if test="($codigoTipoAsignacion = 'OCA'or $codigoTipoAsignacion ='LCA' or $codigoTipoAsignacion ='CB')">
               <tr>
                  <td>
                     <b>Tipo de asignaci&#243;n:</b>
                     <xsl:value-of select="datos/tipoAsignacion" />
                  </td>
               </tr>
               <tr>
                  <td height="15px" />
               </tr>
               <tr>
                  <td>
                     <b>
                        <xsl:value-of select="datos/tituloBase" />
                     </b>
                  </td>
               </tr>
               <tr>
                  <td height="15px" />
               </tr>
               <tr>
                  <td>
                     <table border="1">
                        <tr>
                           <td>
                              <b>C&#243;digo</b>
                           </td>
                           <td>
                              <b>Nombre</b>
                           </td>
                        </tr>
                        <xsl:for-each select="/datos/areasBase">
                           <tr>
                              <td>
                                 <xsl:value-of select="codigo" />
                              </td>
                              <td>
                                 <xsl:value-of select="nombre" />
                              </td>
                           </tr>
                        </xsl:for-each>
                     </table>
                  </td>
               </tr>
               <tr>
                  <td height="15px" />
               </tr>
               <tr>
                  <td>
                     <b>
                        <xsl:value-of select="datos/tituloDestino" />
                     </b>
                  </td>
               </tr>
               <tr>
                  <td height="15px" />
               </tr>
               <tr>
                  <td>
                     <table border="1">
                        <tr>
                           <td>
                              <b>C&#243;digo</b>
                           </td>
                           <td>
                              <b>Nombre</b>
                           </td>
                        </tr>
                        <xsl:for-each select="/datos/areasDestino">
                           <tr>
                              <td>
                                 <xsl:value-of select="codigo" />
                              </td>
                              <td>
                                 <xsl:value-of select="nombre" />
                              </td>
                           </tr>
                        </xsl:for-each>
                     </table>
                  </td>
               </tr>
            </xsl:if>
            <xsl:if test="($codigoTipoAsignacion = 'LEA'or $codigoTipoAsignacion ='BEA' or $codigoTipoAsignacion ='OEA' or $codigoTipoAsignacion='LPA')">
               <tr>
                  <td>
                     <b>Tipo de Asignaci&#243;n:</b>
                     <xsl:value-of select="datos/tipoAsignacion" />
                  </td>
               </tr>
               <tr>
                  <td height="15px" />
               </tr>
               <tr>
                  <td>
                     <b>
                        <xsl:value-of select="datos/tituloAreasTrabajo" />
                     </b>
                  </td>
               </tr>
               <tr>
                  <td height="15px" />
               </tr>
               <tr>
                  <td>
                     <table border="1">
                        <tr>
                           <td>
                              <b>C&#243;digo</b>
                           </td>
                           <td>
                              <b>Nombre</b>
                           </td>
                        </tr>
                        <xsl:for-each select="/datos/areas">
                           <tr>
                              <td>
                                 <xsl:value-of select="codigo" />
                              </td>
                              <td>
                                 <xsl:value-of select="nombre" />
                              </td>
                           </tr>
                        </xsl:for-each>
                     </table>
                  </td>
               </tr>
			   
			</xsl:if>
			</xsl:if>
            
			<xsl:if test="($tipoMail='ADM_PROT')">			
				<tr>
					  <td height="15px" />
				</tr>
				<tr>
				    <td> <b>Opci&#243;n seleccionada: </b>  <xsl:value-of select="datos/opcionSelAdminProt" /> </td>
				</tr>
				
				<tr>
					  <td height="15px" />
				</tr>
				<tr>
				    <td> <xsl:value-of select="datos/tituloAreasTrabajoSeleccionado" /> </td>
				</tr>
				<tr>
					  <td height="5px" />
				</tr>
				<tr>
				<td>				
					<table border="1">
						<tr>
						   <td>
							  <b>C&#243;digo</b>
						   </td>
						   <td>
							  <b>Nombre</b>
						   </td>
						</tr>	   
						<xsl:for-each select="/datos/grupoTrabajoSeleccionado">
                           <tr>
                              <td>
                                 <xsl:value-of select="codigo" />
                              </td>
                              <td>
                                 <xsl:value-of select="nombre" />
                              </td>
                           </tr>
                        </xsl:for-each>	   					
					</table>	
				</td>
				</tr>
				
				<xsl:if test="count(//areasTrabajoActivas) > 0">
				<tr>
					  <td height="15px" />
				</tr>
				<tr>
				    <td> <xsl:value-of select="datos/tituloAreasTrabajoActivas" /> </td>
				</tr>
				<tr>
					  <td height="5px" />
				</tr>
				<tr>
				<td>
					<table border="1">
						<tr>
						   <td>
							  <b>C&#243;digo</b>
						   </td>
						   <td>
							  <b>Nombre</b>
						   </td>
						</tr>	   
						<xsl:for-each select="/datos/areasTrabajoActivas">
                           <tr>
                              <td>
                                 <xsl:value-of select="codigo" />
                              </td>
                              <td>
                                 <xsl:value-of select="nombre" />
                              </td>
                           </tr>
                        </xsl:for-each>	   					
					</table>
				</td>					
				</tr>
				</xsl:if>
				
				<xsl:if test="count(//areasTrabajoDesactivadas) > 0">
				<tr>
					  <td height="15px" />
				</tr>
				<tr>
				    <td> <xsl:value-of select="datos/tituloAreasTrabajoDesactivadas" /> </td>
				</tr>
				<tr>
					  <td height="5px" />
				</tr>
				<tr>
				<td>
					<table border="1">
						<tr>
						   <td>
							  <b>C&#243;digo</b>
						   </td>
						   <td>
							  <b>Nombre</b>
						   </td>
						</tr>	   
						<xsl:for-each select="/datos/areasTrabajoDesactivadas">
                           <tr>
                              <td>
                                 <xsl:value-of select="codigo" />
                              </td>
                              <td>
                                 <xsl:value-of select="nombre" />
                              </td>
                           </tr>
                        </xsl:for-each>	   					
					</table>
				</td>
				</tr>
				</xsl:if>
			</xsl:if>
			
			<xsl:if test="count(//articuloNoIntegrados) > 0">
               <tr>
                  <td height="15px" />
               </tr>
               <tr>
                  <td>
                     <b>
                        <xsl:value-of select="datos/tituloNoIntegrados" />
                     </b>
                  </td>
               </tr>
               <tr>
                  <td height="15px" />
               </tr>
               <tr>
                  <td>
                     <table border="1">
                        <tr>
                           <td>
                              <b>Local</b>
                           </td>						    
						   <td>
							  <b>Art&#237;culo</b>
						   </td>						   
						   <td>
                              <b>Prototipo</b>
                           </td>
						   <td>
                              <b>Estado alcance</b>
                           </td>
						   <td>
                              <b>Observaci&#243;n</b>
                           </td>
                        </tr>
                        <xsl:for-each select="/datos/articuloNoIntegrados">
                           <tr>
                              <td>
                                 <xsl:value-of select="codigoLocal" /> -
								 <xsl:value-of select="nombreLocal" />
                              </td>
							  <td>
								 <xsl:value-of select="codigoArticulo" /> -
								 <xsl:value-of select="nombreArticulo" />
							  </td>							  
							  <td>
                                 <xsl:value-of select="prototipo" />
                              </td>							  
							  <td>
                                 <xsl:value-of select="estadoAlcance" />
                              </td>
							  <td>
                                 <xsl:value-of select="observacion" />
                              </td>
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
				<td>Se proceder&#225; a tranferir los alcances de los art&#237;culos realizados desde el sistema MAX al sistema </td>
			</tr>
              <tr>
                <td height="15px" />
             </tr>
			<tr>
				<td><b>NOTA:</b> Se adjuntar&#225; un archivo si se presenta errores al asignar alcances a los art&#237;culos seleccionados</td>
			</tr>
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