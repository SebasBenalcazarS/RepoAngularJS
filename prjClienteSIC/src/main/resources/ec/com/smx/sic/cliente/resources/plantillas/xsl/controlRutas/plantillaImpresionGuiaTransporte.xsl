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
	
	<xsl:template match="guiaTransporte">
		<fo:root xmlns:fo="http://www.w3.org/1999/XSL/Format">
			<fo:layout-master-set>	  
				<fo:simple-page-master master-name="all-pages" xsl:use-attribute-sets="page">					
					<fo:region-body region-name="page-body" margin-top="5.8cm"  margin-bottom="{$page-margin-bottom}" margin-left="1.1mm" />
					<fo:region-before region-name="page-header"  />
					<fo:region-after region-name="page-footer" extent="{$page-margin-bottom}" />
				</fo:simple-page-master>
			</fo:layout-master-set>
				
			<fo:page-sequence master-reference="all-pages" initial-page-number="1" force-page-count="no-force">	
				<fo:static-content flow-name="page-header">
					<fo:block xsl:use-attribute-sets="page-header" margin-left="1.6mm" margin-top="18.5mm">		
						<fo:table xsl:use-attribute-sets="table">							
							<fo:table-column column-width="3.0cm"/>
							<fo:table-column column-width="5.0cm"/>
							<fo:table-column column-width="3.0cm"/>
							<fo:table-column column-width="3.5cm"/>
							<fo:table-body>		
								<fo:table-row>	<!--FILA 1-->																  
									<fo:table-cell text-align="left" padding-left="0.15cm">
										<fo:block>CODIGO DE RUTA:</fo:block>
									</fo:table-cell>
									<fo:table-cell text-align="left">
										<fo:block><xsl:value-of select="codigoRuta"/></fo:block>
									</fo:table-cell>
									<fo:table-cell text-align="left">
										<fo:block>NUMERO DE GUIA:</fo:block>
									</fo:table-cell>
									<fo:table-cell text-align="left">
										<fo:block><xsl:value-of select="numeroGuia"/></fo:block>
									</fo:table-cell>																		
								</fo:table-row>	
							</fo:table-body>
						</fo:table>		
						<fo:block>&#160;</fo:block>							
						<fo:block>&#160;</fo:block>	
						<fo:table xsl:use-attribute-sets="table">							
							<fo:table-column column-width="7.8cm"/>
							<fo:table-column column-width="6.0cm"/>
							<fo:table-column column-width="5.0cm"/>
							<fo:table-body>		
								<fo:table-row>																	  
									<fo:table-cell text-align="left">
										<fo:block>
											<fo:table xsl:use-attribute-sets="table">							
												<fo:table-column column-width="2.8cm"/>
												<fo:table-column column-width="5.0cm"/>
												<fo:table-body>		
													<fo:table-row>																	  
														<fo:table-cell text-align="left">
															<fo:block>FURGON #.....:</fo:block>
														</fo:table-cell>
														<fo:table-cell text-align="left">
															<fo:block><xsl:value-of select="furgon"/></fo:block>
														</fo:table-cell>	
													</fo:table-row>
													<fo:table-row>																	  
														<fo:table-cell text-align="left">
															<fo:block>FECHA........:</fo:block>
														</fo:table-cell>
														<fo:table-cell text-align="left">
															<fo:block><xsl:value-of select="fechaGuia"/></fo:block>
														</fo:table-cell>	
													</fo:table-row>
													<fo:table-row>																	  
														<fo:table-cell text-align="left">
															<fo:block>HOROMETRO....:</fo:block>
														</fo:table-cell>
														<fo:table-cell text-align="left">
															<fo:block><xsl:value-of select="horometro"/></fo:block>
														</fo:table-cell>	
													</fo:table-row>
													<fo:table-row>																	  
														<fo:table-cell text-align="left">
															<fo:block>TRANSPORTISTA:</fo:block>
														</fo:table-cell>
														<fo:table-cell text-align="left">
															<fo:block><xsl:value-of select="transportista"/></fo:block>
														</fo:table-cell>	
													</fo:table-row>
													<fo:table-row>																	  
														<fo:table-cell text-align="left">
															<fo:block>CHOFER 1.....:</fo:block>
														</fo:table-cell>
														<fo:table-cell text-align="left">
															<fo:block><xsl:value-of select="chofer1"/></fo:block>
														</fo:table-cell>	
													</fo:table-row>
												</fo:table-body>	
											</fo:table>	
										</fo:block>
									</fo:table-cell>
									<fo:table-cell text-align="left">
										<fo:block>
											<fo:table xsl:use-attribute-sets="table">							
												<fo:table-column column-width="1.9cm"/>
												<fo:table-column column-width="4.2cm"/>
												<fo:table-body>																									
													<xsl:for-each select="destinos/destino">														
														<fo:table-row>
															<fo:table-cell text-align="left">
																<fo:block>
																	DESTINO <xsl:number value="position()" format="1"/>:																
																</fo:block>
															</fo:table-cell>
															<fo:table-cell text-align="left">
																<fo:block>
																	<xsl:value-of select="nombreDestino"/>																
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
												<fo:table-column column-width="2.7cm"/>
												<fo:table-column column-width="4.8cm"/>
												<fo:table-body>	
													<fo:table-row>
														<fo:table-cell text-align="left">
															<fo:block>
																<fo:block>SELLO SALIDA 1:</fo:block>	
															</fo:block>
														</fo:table-cell>
														<fo:table-cell text-align="left">
															<fo:block>
																<xsl:value-of select="selloSalida1"/>&#160;												
															</fo:block>
														</fo:table-cell>										
													</fo:table-row>	
													<fo:table-row>																	  
														<fo:table-cell text-align="left">
															<fo:block>SELLO SALIDA 2:</fo:block>
														</fo:table-cell>
														<fo:table-cell text-align="left">
															<fo:block><xsl:value-of select="selloSalida2"/></fo:block>
														</fo:table-cell>	
													</fo:table-row>	
													<fo:table-row>																	  
														<fo:table-cell text-align="left">
															<fo:block>DESPACHADOR...:</fo:block>
														</fo:table-cell>
														<fo:table-cell text-align="left">
															<fo:block><xsl:value-of select="despachador"/></fo:block>
														</fo:table-cell>	
													</fo:table-row>	
													<fo:table-row>																	  
														<fo:table-cell text-align="left">
															<fo:block>VEHICULO......:</fo:block>
														</fo:table-cell>
														<fo:table-cell text-align="left">
															<fo:block><xsl:value-of select="vehiculo"/></fo:block>
														</fo:table-cell>	
													</fo:table-row>	
													<fo:table-row>																	  
														<fo:table-cell text-align="left">
															<fo:block>CHOFER 2......:</fo:block>
														</fo:table-cell>
														<fo:table-cell text-align="left">
															<fo:block><xsl:value-of select="chofer2"/></fo:block>
														</fo:table-cell>	
													</fo:table-row>	
												</fo:table-body>	
											</fo:table>	
										</fo:block>
									</fo:table-cell>									
								</fo:table-row>	
							</fo:table-body>
						</fo:table>		
						
					</fo:block>
				</fo:static-content>

				<fo:flow flow-name="page-body" >
					<fo:block xsl:use-attribute-sets="body">	
						<fo:table xsl:use-attribute-sets="table">
							<fo:table-column column-width="4.2cm"/>
							<fo:table-column column-width="6.0cm"/>							
							
							<fo:table-body>	
								<fo:table-row>
									<fo:table-cell text-align="left"  padding-left="0.5cm" font-weight="bold" >
										<fo:block>
											NRO DOCUMENTO		
										</fo:block>
									</fo:table-cell>
									<fo:table-cell text-align="left" font-weight="bold">
										<fo:block>
											DESCRIPCION												
										</fo:block>
									</fo:table-cell>
								</fo:table-row>
								<xsl:for-each select="detalles">
									<fo:table-row>
										<fo:table-cell text-align="left"  padding-left="0.5cm">
											<fo:block>
												<xsl:value-of select="codigoDocumento"/>		
											</fo:block>
										</fo:table-cell>
										<fo:table-cell text-align="left">
											<fo:block>
												<xsl:value-of select="descripcion"/>&#160;												
											</fo:block>
										</fo:table-cell>										
									</fo:table-row>
								</xsl:for-each>
							</fo:table-body>
						</fo:table>					
					</fo:block>
					<fo:block>&#160;</fo:block>							
					<fo:block>&#160;</fo:block>
					<fo:block xsl:use-attribute-sets="body">	
						<fo:table xsl:use-attribute-sets="table">
							<fo:table-column column-width="6.5cm"/>
							<fo:table-column column-width="6.5cm"/>							
							<fo:table-column column-width="6.5cm"/>
							<fo:table-body>	
								<fo:table-row>
									<fo:table-cell text-align="center">
										<fo:block>
											---------------------------		
										</fo:block>
									</fo:table-cell>
									<fo:table-cell text-align="center">
										<fo:block>
											---------------------------		
										</fo:block>
									</fo:table-cell>
									<fo:table-cell text-align="center">
										<fo:block>
											---------------------------		
										</fo:block>
									</fo:table-cell>
								</fo:table-row>
								<fo:table-row>
									<fo:table-cell text-align="center">
										<fo:block>
											FIRMA DESPACHADOR		
										</fo:block>
									</fo:table-cell>
									<fo:table-cell text-align="center">
										<fo:block>
											FIRMA CHOFER		
										</fo:block>
									</fo:table-cell>
									<fo:table-cell text-align="center">
										<fo:block>
											FIRMA GUARDIA		
										</fo:block>
									</fo:table-cell>
								</fo:table-row>
							</fo:table-body>	
						</fo:table>	
					</fo:block>
					<fo:block>&#160;</fo:block>
					<fo:block xsl:use-attribute-sets="body">
						<fo:table xsl:use-attribute-sets="table">
							<fo:table-column column-width="100%"/>
							<fo:table-body>	
								<fo:table-row>
									<fo:table-cell padding-left="0.5cm" padding-right="0.5cm">
										<fo:block>
											====================================================================================================================		
										</fo:block>
									</fo:table-cell>
								</fo:table-row>
								<fo:table-row>
									<fo:table-cell padding-left="0.5cm" padding-right="0.5cm">
										<fo:block>
											OBSERVACIONES GARITA _______________________________________________________________________________________________
										</fo:block>
									</fo:table-cell>
								</fo:table-row>
								<fo:table-row>
									<fo:table-cell padding-top="0.2cm" padding-bottom="0.2cm" padding-left="0.5cm" padding-right="0.5cm">
										<fo:block>
											____________________________________________________________________________________________________________________
										</fo:block>
									</fo:table-cell>
								</fo:table-row>
								<fo:table-row>
									<fo:table-cell padding-left="0.5cm" padding-right="0.5cm">
										<fo:block>
											====================================================================================================================		
										</fo:block>
									</fo:table-cell>
								</fo:table-row>
							</fo:table-body>	
						</fo:table>
					</fo:block>													
													
					<fo:block xsl:use-attribute-sets="body">
						<xsl:for-each select="destinos/destino">
							<fo:table xsl:use-attribute-sets="table">
								<fo:table-column column-width="3.7cm"/>
								<fo:table-column column-width="8.0cm"/>
								<fo:table-body>	
									<fo:table-row>
										<fo:table-cell text-align="left" padding-left="0.5cm" padding-top="0.3cm">
											<fo:block>
												DESTINO <xsl:number value="position()" format="1"/>........:	
											</fo:block>
										</fo:table-cell>	
										<fo:table-cell padding-top="0.3cm">
											<fo:block>
												<xsl:value-of select="nombreDestino"/>		
											</fo:block>
										</fo:table-cell>									
									</fo:table-row>
								</fo:table-body>	
							</fo:table>
							<fo:table xsl:use-attribute-sets="table">
								<fo:table-column column-width="3.7cm"/>
								<fo:table-column column-width="3.0cm"/>
								<fo:table-column column-width="3.5cm"/>
								<fo:table-column column-width="3.0cm"/>
								<fo:table-column column-width="3.0cm"/>
								<fo:table-column column-width="3.7cm"/>
								<fo:table-body>							
									<fo:table-row>
										<fo:table-cell text-align="left" padding-left="0.5cm">
											<fo:block>
												HORA LLEGADA.....:	
											</fo:block>
										</fo:table-cell>
										<fo:table-cell text-align="left">
											<fo:block>
												________________	
											</fo:block>
										</fo:table-cell>
										<fo:table-cell text-align="left">
											<fo:block>
												NOMBRE DEL GUARDIA:	
											</fo:block>
										</fo:table-cell>
										<fo:table-cell text-align="left">
											<fo:block>
												_________________	
											</fo:block>
										</fo:table-cell>
										<fo:table-cell text-align="left">
											<fo:block>
												NOMBRE RECEPCION:	
											</fo:block>
										</fo:table-cell>
										<fo:table-cell text-align="left">
											<fo:block>
												_______________________	
											</fo:block>
										</fo:table-cell>									
									</fo:table-row>
									<fo:table-row>
										<fo:table-cell text-align="left" padding-left="0.5cm">
											<fo:block>
												SELLO LLEGADA....:	
											</fo:block>
										</fo:table-cell>
										<fo:table-cell text-align="left">
											<fo:block>
												________________	
											</fo:block>
										</fo:table-cell>
										<fo:table-cell text-align="left">
											<fo:block>
												HOROMETRO.........:	
											</fo:block>
										</fo:table-cell>
										<fo:table-cell text-align="left">
											<fo:block>
												_________________	
											</fo:block>
										</fo:table-cell>																		
									</fo:table-row>
									<fo:table-row>
										<fo:table-cell text-align="left" padding-left="0.5cm">
											<fo:block>
												PRODUCTOS REGRESO:	
											</fo:block>
										</fo:table-cell>									
									</fo:table-row>
									<fo:table-row>
										<fo:table-cell text-align="left" padding-left="0.5cm">
											<fo:block>
												FURGON #.........:	
											</fo:block>
										</fo:table-cell>
										<fo:table-cell text-align="left">
											<fo:block>
												________________	
											</fo:block>
										</fo:table-cell>
										<fo:table-cell text-align="left">
											<fo:block>
												NRO SELLO SALIDA..:	
											</fo:block>
										</fo:table-cell>
										<fo:table-cell text-align="left">
											<fo:block>
												_________________	
											</fo:block>
										</fo:table-cell>																		
									</fo:table-row>
									<fo:table-row>
										<fo:table-cell text-align="left" padding-left="0.5cm">
											<fo:block>
												FECHA SALIDA.....:	
											</fo:block>
										</fo:table-cell>
										<fo:table-cell text-align="left">
											<fo:block>
												________________	
											</fo:block>
										</fo:table-cell>
										<fo:table-cell text-align="left">
											<fo:block>
												HORA SALIDA.......:	
											</fo:block>
										</fo:table-cell>
										<fo:table-cell text-align="left">
											<fo:block>
												_________________	
											</fo:block>
										</fo:table-cell>
										<fo:table-cell text-align="left">
											<fo:block>
											</fo:block>
										</fo:table-cell>
										<fo:table-cell text-align="left">
											<fo:block>
												FIRMA Y SELLO DE AGUA	
											</fo:block>
										</fo:table-cell>									
									</fo:table-row>
								</fo:table-body>
							</fo:table>
						</xsl:for-each>	
						<fo:block>&#160;</fo:block>
						<fo:table xsl:use-attribute-sets="table">
							<fo:table-column column-width="100%"/>
							<fo:table-body>	
								<fo:table-row>
									<fo:table-cell padding-left="0.5cm" padding-right="0.5cm">
										<fo:block>
											====================================================================================================================		
										</fo:block>
									</fo:table-cell>
								</fo:table-row>
							</fo:table-body>
						</fo:table>
						<fo:table xsl:use-attribute-sets="table">
							<fo:table-column column-width="4.0cm"/>
							<fo:table-column column-width="4.0cm"/>
							<fo:table-column column-width="4.0cm"/>
							<fo:table-column column-width="4.0cm"/>
							<fo:table-column column-width="4.0cm"/>
							<fo:table-body>							
								<fo:table-row>
									<fo:table-cell text-align="center">
										<fo:block>
											LOCALES	
										</fo:block>
									</fo:table-cell>
									<fo:table-cell text-align="center">
										<fo:block>
											PALLETS	
										</fo:block>
									</fo:table-cell>
									<fo:table-cell text-align="center">
										<fo:block>
											DEVOLUCIONES	
										</fo:block>
									</fo:table-cell>
									<fo:table-cell text-align="center">
										<fo:block>
											JABAS	
										</fo:block>
									</fo:table-cell>
									<fo:table-cell text-align="center">
										<fo:block>
											OTROS	
										</fo:block>
									</fo:table-cell>
								</fo:table-row>
								<xsl:for-each select="destinos/destino">
									<fo:table-row>
										<fo:table-cell text-align="left" padding-left="0.5cm">
											<fo:block>
												<xsl:value-of select="nombreDestino"/>:		
											</fo:block>
										</fo:table-cell>
										<fo:table-cell text-align="center">
											<fo:block>
												___________________	
											</fo:block>
										</fo:table-cell>
										<fo:table-cell text-align="center">
											<fo:block>
												___________________	
											</fo:block>
										</fo:table-cell>
										<fo:table-cell text-align="center">
											<fo:block>
												___________________	
											</fo:block>
										</fo:table-cell>
										<fo:table-cell text-align="center">
											<fo:block>
												___________________	
											</fo:block>
										</fo:table-cell>
									</fo:table-row>
								</xsl:for-each>
								<fo:table-row>
									<fo:table-cell text-align="left" padding-left="0.5cm">
										<fo:block>
											TOTAL LOCALES:		
										</fo:block>
									</fo:table-cell>
									<fo:table-cell text-align="center">
										<fo:block>
											___________________	
										</fo:block>
									</fo:table-cell>
									<fo:table-cell text-align="center">
										<fo:block>
											___________________	
										</fo:block>
									</fo:table-cell>
									<fo:table-cell text-align="center">
										<fo:block>
											___________________	
										</fo:block>
									</fo:table-cell>
									<fo:table-cell text-align="center">
										<fo:block>
											___________________	
										</fo:block>
									</fo:table-cell>
								</fo:table-row>
								<fo:table-row>
									<fo:table-cell text-align="left" padding-left="0.5cm">
										<fo:block>
											BODEGA CENTRAL:		
										</fo:block>
									</fo:table-cell>
									<fo:table-cell text-align="center">
										<fo:block>
											___________________	
										</fo:block>
									</fo:table-cell>
									<fo:table-cell text-align="center">
										<fo:block>
											___________________	
										</fo:block>
									</fo:table-cell>
									<fo:table-cell text-align="center">
										<fo:block>
											___________________	
										</fo:block>
									</fo:table-cell>
									<fo:table-cell text-align="center">
										<fo:block>
											___________________	
										</fo:block>
									</fo:table-cell>
								</fo:table-row>
							</fo:table-body>
						</fo:table>
						<fo:table xsl:use-attribute-sets="table">
							<fo:table-column column-width="100%"/>
							<fo:table-body>								
								<fo:table-row>
									<fo:table-cell padding-left="0.5cm" padding-right="0.5cm">
										<fo:block>
											OBSERVACIONES LOCALES:   _____________________________________________________________________________________________
										</fo:block>
									</fo:table-cell>
								</fo:table-row>
								<fo:table-row>
									<fo:table-cell padding-top="0.2cm" padding-bottom="0.2cm" padding-left="0.5cm" padding-right="0.5cm">
										<fo:block>
											____________________________________________________________________________________________________________________
										</fo:block>
									</fo:table-cell>
								</fo:table-row>
							</fo:table-body>	
						</fo:table>
						<fo:table xsl:use-attribute-sets="table">
							<fo:table-column column-width="100%"/>
							<fo:table-body>	
								<fo:table-row>
									<fo:table-cell padding-top="0.1cm" padding-left="0.5cm" padding-right="0.5cm">
										<fo:block>
											====================================================================================================================		
										</fo:block>
									</fo:table-cell>
								</fo:table-row>
							</fo:table-body>
						</fo:table>
						<fo:table xsl:use-attribute-sets="table">
							<fo:table-column column-width="3.7cm"/>
							<fo:table-column column-width="3.0cm"/>
							<fo:table-column column-width="3.5cm"/>
							<fo:table-column column-width="3.0cm"/>
							<fo:table-column column-width="3.0cm"/>
							<fo:table-column column-width="3.7cm"/>
							<fo:table-body>	
								<fo:table-row>
									<fo:table-cell text-align="left" padding-left="0.5cm">
										<fo:block>
											BODEGA CENTRAL	
										</fo:block>
									</fo:table-cell>
								</fo:table-row>								
								<fo:table-row>
									<fo:table-cell text-align="left" padding-left="0.5cm">
										<fo:block>
											FECHA DE LLEGADA:	
										</fo:block>
									</fo:table-cell>
									<fo:table-cell text-align="left">
										<fo:block>
											________________	
										</fo:block>
									</fo:table-cell>
									<fo:table-cell text-align="left">
										<fo:block>
											HORA LLEGADA....:	
										</fo:block>
									</fo:table-cell>
									<fo:table-cell text-align="left">
										<fo:block>
											_________________	
										</fo:block>
									</fo:table-cell>																			
								</fo:table-row>
								<fo:table-row>
									<fo:table-cell text-align="left" padding-left="0.5cm">
										<fo:block>
											NOMBRE GUARDIA..:	
										</fo:block>
									</fo:table-cell>
									<fo:table-cell text-align="left">
										<fo:block>
											________________	
										</fo:block>
									</fo:table-cell>
									<fo:table-cell text-align="left">
										<fo:block>
											NOMBRE RECEPCION:	
										</fo:block>
									</fo:table-cell>
									<fo:table-cell text-align="left">
										<fo:block>
											_________________	
										</fo:block>
									</fo:table-cell>																			
								</fo:table-row>
								<fo:table-row>
									<fo:table-cell text-align="left" padding-left="0.5cm">
										<fo:block>
											SELLO LLEGADA...:	
										</fo:block>
									</fo:table-cell>
									<fo:table-cell text-align="left">
										<fo:block>
											________________	
										</fo:block>
									</fo:table-cell>
									<fo:table-cell text-align="left">
										<fo:block>													
										</fo:block>
									</fo:table-cell>
									<fo:table-cell text-align="left">
										<fo:block>													
										</fo:block>
									</fo:table-cell>
									<fo:table-cell text-align="left">
										<fo:block>													
										</fo:block>
									</fo:table-cell>
									<fo:table-cell text-align="left">
										<fo:block>
											FIRMA Y SELLO DE AGUA	
										</fo:block>
									</fo:table-cell>									
								</fo:table-row>
							</fo:table-body>
						</fo:table>
						
						<fo:table xsl:use-attribute-sets="table">
							<fo:table-column column-width="100%"/>
							<fo:table-body>								
								<fo:table-row>
									<fo:table-cell padding-left="0.5cm" padding-right="0.5cm">
										<fo:block>
											OBSERVACIONES BODEGA _______________________________________________________________________________________________
										</fo:block>
									</fo:table-cell>
								</fo:table-row>
								<fo:table-row>
									<fo:table-cell padding-top="0.2cm" padding-bottom="0.2cm" padding-left="0.5cm" padding-right="0.5cm">
										<fo:block>
											____________________________________________________________________________________________________________________
										</fo:block>
									</fo:table-cell>
								</fo:table-row>
							</fo:table-body>	
						</fo:table>
						<fo:table xsl:use-attribute-sets="table">
							<fo:table-column column-width="100%"/>
							<fo:table-body>	
								<fo:table-row>
									<fo:table-cell padding-top="0.1cm" padding-left="0.5cm" padding-right="0.5cm">
										<fo:block>
											====================================================================================================================		
										</fo:block>
									</fo:table-cell>
								</fo:table-row>
							</fo:table-body>
						</fo:table>
						<fo:table xsl:use-attribute-sets="table">
							<fo:table-column column-width="2.0cm"/>
							<fo:table-column column-width="8.0cm"/>
							<fo:table-column column-width="2.3cm"/>
							<fo:table-column column-width="5.0cm"/>
							<fo:table-body>							
								<fo:table-row>
									<fo:table-cell text-align="left" padding-left="0.5cm">
										<fo:block>
											VALOR $:	
										</fo:block>
									</fo:table-cell>
									<fo:table-cell text-align="left">
										<fo:block>
											____________	
										</fo:block>
									</fo:table-cell>
									<fo:table-cell text-align="left">
										<fo:block>
											VISTO BUENO:	
										</fo:block>
									</fo:table-cell>
									<fo:table-cell text-align="left">
										<fo:block>
											____________	
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
									<fo:table-cell text-align="center" padding-top="0.1cm" padding-left="0.5cm" padding-right="0.5cm">
										<fo:block>
											* * * O R I G I N A L * * *		
										</fo:block>
									</fo:table-cell>
								</fo:table-row>
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
