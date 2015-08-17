<?xml version='1.0' encoding='ISO-8859-1'?>
<xsl:stylesheet version="1.1" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" 
xmlns:fo="http://www.w3.org/1999/XSL/Format" 
exclude-result-prefixes="fo">
	<!-- page size -->
	<xsl:param name="page-width">auto</xsl:param>
	<xsl:param name="page-height">auto</xsl:param>
	<xsl:param name="page-margin-top">0.1cm</xsl:param>
	<xsl:param name="page-margin-bottom"/>
	<xsl:param name="page-margin-left">0.1in</xsl:param>
	<xsl:param name="page-margin-right">0.5in</xsl:param>
	
	<!-- page header and footer-->
	<xsl:param name="page-header-margin-top">0.5cm</xsl:param>
	<xsl:param name="page-footer-margin-bottom">1.5cm</xsl:param>
	<xsl:param name="font-family">Courier</xsl:param>

	<xsl:param name="font-size">8pt</xsl:param>
	
	<!-- All pages -->
	<xsl:attribute-set name="page">
		<xsl:attribute name="page-width">
			<xsl:value-of select="$page-width" />
		</xsl:attribute>
		<xsl:attribute name="page-height">
			<xsl:value-of select="$page-height" />
		</xsl:attribute>		
	</xsl:attribute-set>
	
	<!-- atribute  page header -->
	<xsl:attribute-set name="page-header">
		<xsl:attribute name="font-family"><xsl:value-of select="$font-family"/></xsl:attribute>
		<xsl:attribute name="color">#000000</xsl:attribute>
		<xsl:attribute name="font-size"><xsl:value-of select="$font-size"/></xsl:attribute>
	</xsl:attribute-set>
	
	<!-- atribute  page body -->
	<xsl:attribute-set name="body">
		<xsl:attribute name="font-family"><xsl:value-of select="$font-family"/></xsl:attribute>
		<xsl:attribute name="color">#000000</xsl:attribute>
		<xsl:attribute name="font-size"><xsl:value-of select="$font-size"/></xsl:attribute>
	</xsl:attribute-set>
	
	<xsl:attribute-set name="table">
		<xsl:attribute name="inline-progression-dimension">100%</xsl:attribute>
		<xsl:attribute name="table-layout">fixed</xsl:attribute>			
		<xsl:attribute name="border-width">0px</xsl:attribute>
	</xsl:attribute-set>	
	
	<xsl:template match="guiaRemision">
		<fo:root xmlns:fo="http://www.w3.org/1999/XSL/Format">
			<fo:layout-master-set>	  
				<fo:simple-page-master master-name="all-pages" xsl:use-attribute-sets="page">					
					<fo:region-body region-name="page-body" margin-top="5.0cm"  margin-bottom="{$page-margin-bottom}" margin-left="3.5mm" />
					<fo:region-before region-name="page-header"  />
					<fo:region-after region-name="page-footer" extent="{$page-margin-bottom}" />
				</fo:simple-page-master>
			</fo:layout-master-set>
				
			<fo:page-sequence master-reference="all-pages" initial-page-number="1" force-page-count="no-force">	
				<fo:static-content flow-name="page-header">
					<fo:block xsl:use-attribute-sets="page-header" margin-left="1.6mm" margin-top="18.5mm">		
						<fo:table xsl:use-attribute-sets="table">							
							<fo:table-column column-width="16.0cm"/>
							<fo:table-column column-width="4.0cm"/>
							<fo:table-body>		
								<fo:table-row>																  
									<fo:table-cell text-align="left" padding-left="0.5cm" font-weight="bold">
										<fo:block>CORPORACION FAVORITA C.A.</fo:block>
									</fo:table-cell>									
									<fo:table-cell text-align="left" padding-right="0.5cm">
										<fo:block>====================</fo:block>
									</fo:table-cell>																											
								</fo:table-row>	
								<fo:table-row>																  
									<fo:table-cell text-align="left" padding-left="0.5cm" font-weight="bold">
										<fo:block>R.U.C. 1790016919001</fo:block>
									</fo:table-cell>									
									<fo:table-cell text-align="left" padding-right="0.5cm" font-weight="bold">
										<fo:block>GUIA DE REMISION</fo:block>
									</fo:table-cell>																											
								</fo:table-row>	
								<fo:table-row>																	  
									<fo:table-cell text-align="left" padding-left="0.5cm" font-weight="bold">
										<fo:block>AV. GENERAL ENRIQUEZ S/N VIA COTOGCHOA</fo:block>
									</fo:table-cell>									
									<fo:table-cell text-align="left" padding-right="0.5cm" font-weight="bold">
										<fo:block>Nro. <xsl:value-of select="numeroGuia"/></fo:block>
									</fo:table-cell>																											
								</fo:table-row>	
								<fo:table-row>																  
									<fo:table-cell text-align="left" padding-left="0.5cm" font-weight="bold">
										<fo:block><xsl:value-of select="areaTrabajoEmision"/></fo:block>
									</fo:table-cell>									
									<fo:table-cell text-align="left" padding-right="0.5cm">
										<fo:block>====================</fo:block>
									</fo:table-cell>																											
								</fo:table-row>	
								<fo:table-row>																  
									<fo:table-cell text-align="left" padding-left="0.5cm" font-weight="bold">
										<fo:block><xsl:value-of select="direccionEmision"/></fo:block>
									</fo:table-cell>									
									<fo:table-cell text-align="left" padding-right="0.5cm" font-weight="bold">
										<fo:block>Nro. Autorizaci&#243;n</fo:block>
									</fo:table-cell>																											
								</fo:table-row>	
								<fo:table-row>																  
									<fo:table-cell text-align="left" padding-left="0.5cm" font-weight="bold">
										<fo:block><xsl:value-of select="ciudadEmision"/></fo:block>
									</fo:table-cell>									
									<fo:table-cell text-align="left" padding-right="0.5cm" font-weight="bold">
										<fo:block><xsl:value-of select="numeroAutorizacion"/></fo:block>
									</fo:table-cell>																											
								</fo:table-row>									
							</fo:table-body>
						</fo:table>		
						<fo:block>&#160;</fo:block>	
						<fo:table xsl:use-attribute-sets="table">							
							<fo:table-column column-width="6.5cm"/>
							<fo:table-column column-width="3.5cm"/>
							<fo:table-column column-width="3.5cm"/>
							<fo:table-column column-width="6.0cm"/>
							<fo:table-body>		
								<fo:table-row>																  
									<fo:table-cell text-align="left" padding-left="0.5cm">
										<fo:block>Fecha de inicio del traslado:</fo:block>
									</fo:table-cell>									
									<fo:table-cell text-align="left" padding-right="0.5cm">
										<fo:block><xsl:value-of select="fechaInicioTraslado"/></fo:block>
									</fo:table-cell>
									<fo:table-cell text-align="left" padding-left="0.5cm">
										<fo:block>Comp. de Venta:</fo:block>
									</fo:table-cell>									
									<fo:table-cell text-align="left" padding-right="0.5cm">
										<fo:block>_______________</fo:block>
									</fo:table-cell>									
								</fo:table-row>	
								<fo:table-row>																  
									<fo:table-cell text-align="left" padding-left="0.5cm">
										<fo:block>Fecha de terminaci&#243;n del traslado:</fo:block>
									</fo:table-cell>									
									<fo:table-cell text-align="left" padding-right="0.5cm">
										<fo:block><xsl:value-of select="fechaFinTraslado"/></fo:block>
									</fo:table-cell>
									<fo:table-cell text-align="left" padding-left="0.5cm">
										<fo:block>Fecha Emisi&#243;n:</fo:block>
									</fo:table-cell>									
									<fo:table-cell text-align="left" padding-right="0.5cm">
										<fo:block><xsl:value-of select="ciudadEmision"/> <xsl:value-of select="fechaEmision"/></fo:block>
									</fo:table-cell>									
								</fo:table-row>
							</fo:table-body>
						</fo:table>					
					</fo:block>
				</fo:static-content>

				<fo:flow flow-name="page-body" >
					<fo:block xsl:use-attribute-sets="body">	
						<fo:table xsl:use-attribute-sets="table">							
							<fo:table-column column-width="6.5cm"/>
							<fo:table-body>		
								<fo:table-row>																  
									<fo:table-cell text-align="left" padding-left="0.5cm" font-weight="bold">
										<fo:block>MOTIVO DEL TRASLADO:</fo:block>
									</fo:table-cell>																	
								</fo:table-row>								
							</fo:table-body>
						</fo:table>
						<fo:table xsl:use-attribute-sets="table">							
							<fo:table-column column-width="8.7cm"/>
							<fo:table-column column-width="14.0cm"/>
							<fo:table-body>																								
									<fo:table-row>									
										<fo:table-cell text-align="left">
											<fo:block>
												<fo:table xsl:use-attribute-sets="table">							
													<fo:table-column column-width="2.5cm"/>
													<fo:table-column column-width="4.5cm"/>
													<fo:table-body>																									
														<xsl:for-each select="motivoTraslado/motivoTrasladoLista1/grupoTraslado">														
															<fo:table-row>
																<fo:table-cell text-align="left" padding-left="0.5cm">
																	<fo:block>
																		<xsl:value-of select="motivo"/>:																
																	</fo:block>
																</fo:table-cell>
																<fo:table-cell text-align="left">
																	<fo:block>
																		<xsl:value-of select="resultado"/>																
																	</fo:block>	
																</fo:table-cell>										
															</fo:table-row>														
														</xsl:for-each>												
													</fo:table-body>	
												</fo:table>	
											</fo:block>
										</fo:table-cell>
										<fo:table-cell text-align="left">
											<fo:block>
												<fo:table xsl:use-attribute-sets="table">							
													<fo:table-column column-width="10.5cm"/>
													<fo:table-column column-width="4.5cm"/>
													<fo:table-body>																									
														<xsl:for-each select="motivoTraslado/motivoTrasladoLista2/grupoTraslado">														
															<fo:table-row>
																<fo:table-cell text-align="left">
																	<fo:block>
																		<xsl:value-of select="motivo"/>:																
																	</fo:block>
																</fo:table-cell>
																<fo:table-cell text-align="left">
																	<fo:block>
																		<xsl:value-of select="resultado"/>																
																	</fo:block>	
																</fo:table-cell>										
															</fo:table-row>														
														</xsl:for-each>												
													</fo:table-body>	
												</fo:table>	
											</fo:block>
										</fo:table-cell>										
									</fo:table-row>																			
							</fo:table-body>	
						</fo:table>
						<fo:block>&#160;</fo:block>							
						<fo:table xsl:use-attribute-sets="table">							
							<fo:table-column column-width="100%"/>
							<fo:table-body>		
								<fo:table-row>																  
									<fo:table-cell text-align="left" padding-left="0.5cm">
										<fo:block>================================================================================================================</fo:block>
									</fo:table-cell>																	
								</fo:table-row>								
							</fo:table-body>
						</fo:table>
						<fo:block>&#160;</fo:block>				
						<fo:table xsl:use-attribute-sets="table">							
							<fo:table-column column-width="3.5cm"/>
							<fo:table-column column-width="9.0cm"/>
							<fo:table-column column-width="2.5cm"/>
							<fo:table-column column-width="6.0cm"/>
							<fo:table-body>		
								<fo:table-row>																  
									<fo:table-cell text-align="left" padding-left="0.5cm">
										<fo:block>Fecha de emisi&#243;n:</fo:block>
									</fo:table-cell>
									<fo:table-cell text-align="left">
										<fo:block><xsl:value-of select="fechaEmision"/></fo:block>
									</fo:table-cell>
									<fo:table-cell text-align="left">
										<fo:block>Hora emisi&#243;n:</fo:block>
									</fo:table-cell>
									<fo:table-cell text-align="left">
										<fo:block><xsl:value-of select="horaEmision"/></fo:block>
									</fo:table-cell>									
								</fo:table-row>	
								<fo:table-row>																  
									<fo:table-cell text-align="left" padding-left="0.5cm">
										<fo:block>Punto de partida:</fo:block>
									</fo:table-cell>
									<fo:table-cell text-align="left">
										<fo:block><xsl:value-of select="direccionEmision"/></fo:block>
									</fo:table-cell>
									<fo:table-cell text-align="left">
										<fo:block>Ciudad:</fo:block>
									</fo:table-cell>
									<fo:table-cell text-align="left">
										<fo:block><xsl:value-of select="ciudadEmision"/></fo:block>
									</fo:table-cell>									
								</fo:table-row>								
							</fo:table-body>
						</fo:table>
						<fo:table xsl:use-attribute-sets="table">							
							<fo:table-column column-width="100%"/>
							<fo:table-body>		
								<fo:table-row>																  
									<fo:table-cell text-align="left" padding-left="0.5cm" font-weight="bold">
										<fo:block>DESTINATARIO:</fo:block>
									</fo:table-cell>																	
								</fo:table-row>								
							</fo:table-body>
						</fo:table>	
						<fo:table xsl:use-attribute-sets="table">							
							<fo:table-column column-width="4.5cm"/>
							<fo:table-column column-width="8.0cm"/>
							<fo:table-column column-width="2.5cm"/>
							<fo:table-column column-width="6.0cm"/>
							<fo:table-body>		
								<fo:table-row>																  
									<fo:table-cell text-align="left" padding-left="0.5cm">
										<fo:block>Nombre o Raz&#243;n Social:</fo:block>
									</fo:table-cell>
									<fo:table-cell text-align="left">
										<fo:block><xsl:value-of select="destinatario/razonSocial"/></fo:block>
									</fo:table-cell>
									<fo:table-cell text-align="left">
										<fo:block></fo:block>
									</fo:table-cell>
									<fo:table-cell text-align="left">
										<fo:block></fo:block>
									</fo:table-cell>									
								</fo:table-row>	
								<fo:table-row>																  
									<fo:table-cell text-align="left" padding-left="0.5cm">
										<fo:block>R.U.C. / C.I.:</fo:block>
									</fo:table-cell>
									<fo:table-cell text-align="left">
										<fo:block><xsl:value-of select="destinatario/rucCI"/></fo:block>
									</fo:table-cell>
									<fo:table-cell text-align="left">
										<fo:block></fo:block>
									</fo:table-cell>
									<fo:table-cell text-align="left">
										<fo:block></fo:block>
									</fo:table-cell>									
								</fo:table-row>	
								<fo:table-row>																  
									<fo:table-cell text-align="left" padding-left="0.5cm">
										<fo:block>Punto de llegada:</fo:block>
									</fo:table-cell>
									<fo:table-cell text-align="left">
										<fo:block><xsl:value-of select="destinatario/direccionLlegada"/></fo:block>
									</fo:table-cell>
									<fo:table-cell text-align="left">
										<fo:block>Ciudad:</fo:block>
									</fo:table-cell>
									<fo:table-cell text-align="left">
										<fo:block><xsl:value-of select="destinatario/provCiudadLLegada"/></fo:block>
									</fo:table-cell>									
								</fo:table-row>							
							</fo:table-body>
						</fo:table>
						<fo:table xsl:use-attribute-sets="table">							
							<fo:table-column column-width="100%"/>
							<fo:table-body>		
								<fo:table-row>																  
									<fo:table-cell text-align="left" padding-left="0.5cm" font-weight="bold">
										<fo:block>IDENTIFICACION DE LA PERSONA ENCARGADA DEL TRANSPORTE:</fo:block>
									</fo:table-cell>																	
								</fo:table-row>								
							</fo:table-body>
						</fo:table>	
						<fo:table xsl:use-attribute-sets="table">							
							<fo:table-column column-width="4.5cm"/>
							<fo:table-column column-width="8.0cm"/>
							<fo:table-column column-width="2.5cm"/>
							<fo:table-column column-width="6.0cm"/>
							<fo:table-body>		
								<fo:table-row>																  
									<fo:table-cell text-align="left" padding-left="0.5cm">
										<fo:block>Nombre o Raz&#243;n Social:</fo:block>
									</fo:table-cell>
									<fo:table-cell text-align="left">
										<fo:block><xsl:value-of select="transportista/razonSocial"/></fo:block>
									</fo:table-cell>
									<fo:table-cell text-align="left">
										<fo:block>R.U.C. / C.I.:</fo:block>
									</fo:table-cell>
									<fo:table-cell text-align="left">
										<fo:block><xsl:value-of select="transportista/rucCI"/></fo:block>
									</fo:table-cell>									
								</fo:table-row>	
								<xsl:for-each select="choferes/chofer">
									<fo:table-row>																  
										<fo:table-cell text-align="left" padding-left="0.5cm">
											<fo:block>Nombre del chofer:</fo:block>
										</fo:table-cell>
										<fo:table-cell text-align="left">
											<fo:block><xsl:value-of select="nombre"/></fo:block>
										</fo:table-cell>
										<fo:table-cell text-align="left">
											<fo:block>C.I.:</fo:block>
										</fo:table-cell>
										<fo:table-cell text-align="left">
											<fo:block><xsl:value-of select="cedula"/></fo:block>
										</fo:table-cell>									
									</fo:table-row>	
								</xsl:for-each>						
							</fo:table-body>
						</fo:table>
						<fo:block>&#160;</fo:block>							
						<fo:table xsl:use-attribute-sets="table">							
							<fo:table-column column-width="100%"/>
							<fo:table-body>		
								<fo:table-row>																  
									<fo:table-cell text-align="left" padding-left="0.5cm">
										<fo:block>================================================================================================================</fo:block>
									</fo:table-cell>																	
								</fo:table-row>								
							</fo:table-body>
						</fo:table>
						<fo:block>&#160;</fo:block>
						<fo:table xsl:use-attribute-sets="table">							
							<fo:table-column column-width="100%"/>
							<fo:table-body>		
								<fo:table-row>																  
									<fo:table-cell text-align="left" padding-left="0.5cm" font-weight="bold">
										<fo:block>NUMEROS DE DOCUMENTOS ANEXOS:</fo:block>
									</fo:table-cell>																	
								</fo:table-row>								
							</fo:table-body>
						</fo:table>	
						<fo:table xsl:use-attribute-sets="table">							
							<fo:table-column column-width="2.5cm"/>
							<fo:table-column column-width="3.5cm"/>
							<fo:table-column column-width="2.5cm"/>
							<fo:table-column column-width="3.5cm"/>
							<fo:table-column column-width="2.5cm"/>
							<fo:table-column column-width="3.5cm"/>
							<fo:table-body>	
								<fo:table-row>																  
									<fo:table-cell text-align="left" padding-left="0.5cm">
										<fo:block>DOCUMENTO</fo:block>
									</fo:table-cell>
									<fo:table-cell text-align="left" padding-left="0.5cm">
										<fo:block>FEC. EMISION</fo:block>
									</fo:table-cell>
									<fo:table-cell text-align="left" padding-left="0.5cm">
										<fo:block>DOCUMENTO</fo:block>
									</fo:table-cell>
									<fo:table-cell text-align="left" padding-left="0.5cm">
										<fo:block>FEC. EMISION</fo:block>
									</fo:table-cell>
									<fo:table-cell text-align="left" padding-left="0.5cm">
										<fo:block>DOCUMENTO</fo:block>
									</fo:table-cell>
									<fo:table-cell text-align="left" padding-left="0.5cm">
										<fo:block>FEC. EMISION</fo:block>
									</fo:table-cell>
								</fo:table-row>	
								
								<xsl:for-each select="documentos/grupo">								
									<fo:table-row>
										<xsl:for-each select="documento">
											<fo:table-cell text-align="left" padding-left="0.5cm">
												<fo:block><xsl:value-of select="numeroDocumento"/></fo:block>
											</fo:table-cell>										
											<fo:table-cell text-align="left" padding-left="0.5cm">
												<fo:block><xsl:value-of select="fechaEmisionDoc"/></fo:block>
											</fo:table-cell>
										</xsl:for-each>													
									</fo:table-row>							
								</xsl:for-each>						
							</fo:table-body>
						</fo:table>	
						<fo:block>&#160;</fo:block>							
						<fo:block>&#160;</fo:block>
						<fo:table xsl:use-attribute-sets="table">							
							<fo:table-column column-width="100%"/>
							<fo:table-body>		
								<fo:table-row>																  
									<fo:table-cell text-align="left" padding-left="0.5cm" font-weight="bold">
										<fo:block>ARTICULOS ANEXOS:</fo:block>
									</fo:table-cell>																	
								</fo:table-row>								
							</fo:table-body>
						</fo:table>	
						<fo:table xsl:use-attribute-sets="table">							
							<fo:table-column column-width="4.0cm"/>
							<fo:table-column column-width="2.0cm"/>
							<fo:table-column column-width="4.0cm"/>
							<fo:table-column column-width="2.0cm"/>
							<fo:table-column column-width="4.0cm"/>
							<fo:table-column column-width="2.0cm"/>
							<fo:table-body>	
								<fo:table-row>																  
									<fo:table-cell text-align="left" padding-left="0.5cm">
										<fo:block>DESCRIPCION</fo:block>
									</fo:table-cell>
									<fo:table-cell text-align="left" padding-left="0.5cm">
										<fo:block>CANTIDAD</fo:block>
									</fo:table-cell>
									<fo:table-cell text-align="left" padding-left="0.5cm">
										<fo:block>DESCRIPCION</fo:block>
									</fo:table-cell>
									<fo:table-cell text-align="left" padding-left="0.5cm">
										<fo:block>CANTIDAD</fo:block>
									</fo:table-cell>
									<fo:table-cell text-align="left" padding-left="0.5cm">
										<fo:block>DESCRIPCION</fo:block>
									</fo:table-cell>
									<fo:table-cell text-align="left" padding-left="0.5cm">
										<fo:block>CANTIDAD</fo:block>
									</fo:table-cell>
								</fo:table-row>	
								
								<xsl:for-each select="anexos/grupo">								
									<fo:table-row>
										<xsl:for-each select="articulo">
											<fo:table-cell text-align="left" padding-left="0.5cm">
												<fo:block><xsl:value-of select="descripcion"/></fo:block>
											</fo:table-cell>										
											<fo:table-cell text-align="left" padding-left="0.5cm">
												<fo:block><xsl:value-of select="cantidad"/></fo:block>
											</fo:table-cell>
										</xsl:for-each>													
									</fo:table-row>							
								</xsl:for-each>						
							</fo:table-body>
						</fo:table>						
					</fo:block>																	
					<fo:block id="endPage"/>
				</fo:flow>
			</fo:page-sequence>
		</fo:root>
	</xsl:template>

	<xsl:template name="FormatDate">
		<xsl:param name="DateTime" />
		<xsl:variable name="year">
			<xsl:value-of select="substring($DateTime,1,4)" />
		</xsl:variable>
		<xsl:variable name="month-temp">
			<xsl:value-of select="substring-after($DateTime,'-')" />
		</xsl:variable>
		<xsl:variable name="month">
			<xsl:value-of select="substring-before($month-temp,'-')" />
		</xsl:variable>
		<xsl:value-of select="$month" />
		<xsl:value-of select="'/'" />
		<xsl:value-of select="$year" />
	</xsl:template>	
</xsl:stylesheet>
