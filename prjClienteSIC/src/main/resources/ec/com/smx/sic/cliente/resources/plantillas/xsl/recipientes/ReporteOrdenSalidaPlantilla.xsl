<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
    version="1.0">
    <!-- page size -->
    <xsl:param name="page-width">29cm</xsl:param>
    <xsl:param name="page-height">20cm</xsl:param>
    <xsl:param name="page-margin-top">0.5cm</xsl:param>
    <xsl:param name="page-margin-bottom"/>
    <xsl:param name="page-margin-left">0.1in</xsl:param>
    <xsl:param name="page-margin-right">0.5in</xsl:param>
    
    <!-- page header and footer-->
    <xsl:param name="page-header-margin-top">0.5cm</xsl:param>
    <xsl:param name="page-footer-margin-bottom">1.5cm</xsl:param>
    <xsl:param name="font-family">SansSerif</xsl:param>
    
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
    <xsl:attribute-set name="table">
        <xsl:attribute name="inline-progression-dimension">100%</xsl:attribute>
        <xsl:attribute name="table-layout">fixed</xsl:attribute>			
        <xsl:attribute name="border-width">1px</xsl:attribute>
		<!--xsl:attribute name="border">solid</xsl:attribute-->
	</xsl:attribute-set>
    <xsl:template match="ordenSalida">
    <fo:root xmlns:fo="http://www.w3.org/1999/XSL/Format">
        <fo:layout-master-set>
            <fo:simple-page-master master-name="all-pages" xsl:use-attribute-sets="page" >
               <fo:region-body region-name="page-body"   margin-bottom="{$page-margin-bottom}" margin-left="0.5cm" />
			   <fo:region-before region-name="page-header"  />
            </fo:simple-page-master>
        </fo:layout-master-set>
        <fo:page-sequence master-reference="all-pages" initial-page-number="1" force-page-count="no-force">
			<fo:flow flow-name="page-body">
                    <fo:block xsl:use-attribute-sets="page-header" margin-left="0.0mm" margin-top="10.5mm">
						<!--Table central-->
						<fo:table xsl:use-attribute-sets="table" >
							<fo:table-column column-width="15.0cm"/>
							<fo:table-column column-width="11.0cm"/>
							<fo:table-body>
								<fo:table-row>
									<fo:table-cell text-align="center" number-columns-spanned="2">
										<fo:block>O&#160;&#160;R&#160;&#160;D&#160;&#160;E&#160;&#160;N&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;D&#160;&#160;E&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;S&#160;&#160;A&#160;&#160;L&#160;&#160;I&#160;&#160;D&#160;&#160;A</fo:block>
									</fo:table-cell>
								</fo:table-row>
								<fo:table-row>
									<!--tabla izquierda-->
									<fo:table-cell text-align="center">
										<fo:table xsl:use-attribute-sets="table">
											<!--declaracion de las columnas-->
											<fo:table-column column-width="7.5cm"/>
											<fo:table-column column-width="7.5cm"/>
											<fo:table-body>
												<fo:table-row>
													<fo:table-cell text-align="left"><fo:block>Tda/Alm/CDI Entrega:</fo:block></fo:table-cell>
													<fo:table-cell text-align="left"><fo:block>Proveedor/Recibe:</fo:block></fo:table-cell>		
												</fo:table-row>
												<fo:table-row>
													<fo:table-cell text-align="left"><fo:block><xsl:value-of select="bodega"/></fo:block></fo:table-cell>
													<fo:table-cell text-align="left"><fo:block><xsl:value-of select="codigoNombreProv"/></fo:block></fo:table-cell>		
												</fo:table-row>
												<fo:table-row>
													<fo:table-cell text-align="left"><fo:block><xsl:value-of select="nombreCorp"/></fo:block></fo:table-cell>
													<fo:table-cell text-align="left"><fo:block><xsl:value-of select="nombreProv"/></fo:block></fo:table-cell>		
												</fo:table-row>
												<fo:table-row>
													<fo:table-cell text-align="left"><fo:block><xsl:value-of select="dirCorp"/></fo:block></fo:table-cell>
													<fo:table-cell text-align="left"><fo:block><xsl:value-of select="dirProv"/></fo:block></fo:table-cell>		
												</fo:table-row>
												<fo:table-row>
													<fo:table-cell text-align="left"><fo:block><xsl:value-of select="ciudadCorp"/></fo:block></fo:table-cell>
													<fo:table-cell text-align="left"><fo:block><xsl:value-of select="ciudadProv"/></fo:block></fo:table-cell>		
												</fo:table-row>
												<fo:table-row>
													<fo:table-cell text-align="left"><fo:block><xsl:value-of select="telefonoCorp"/></fo:block></fo:table-cell>
													<fo:table-cell text-align="left"><fo:block><xsl:value-of select="telefonoProv"/></fo:block></fo:table-cell>		
												</fo:table-row>
												<fo:table-row>
													<fo:table-cell text-align="left"><fo:block><xsl:value-of select="rucCorp"/></fo:block></fo:table-cell>
													<fo:table-cell text-align="left"><fo:block><xsl:value-of select="rucProv"/></fo:block></fo:table-cell>		
												</fo:table-row>
												<fo:table-row>
													<fo:table-cell text-align="center" number-columns-spanned="2">
														<fo:table xsl:use-attribute-sets="table">
															<fo:table-column column-width="3.0cm"/>
															<fo:table-column column-width="3.0cm"/>
															<fo:table-column column-width="6.0cm"/>
															<fo:table-column column-width="3.0cm"/>
															<fo:table-body>
																<fo:table-row>
																	<fo:table-cell text-align="left"><fo:block>Cantidad</fo:block></fo:table-cell>
																	<fo:table-cell text-align="left"><fo:block>Codigo</fo:block></fo:table-cell>		
																	<fo:table-cell text-align="left"><fo:block>Descripcion-Articulo</fo:block></fo:table-cell>		
																	<fo:table-cell text-align="left"><fo:block>Tamanio</fo:block></fo:table-cell>		
																</fo:table-row>
																<!--DETALLES DE LAS JABAS-->
																<xsl:for-each select="detalles">
																		<fo:table-row>
																			<fo:table-cell text-align="left" padding="0.0cm"><fo:block><xsl:value-of select="cantidad"/></fo:block></fo:table-cell>
																			<fo:table-cell text-align="left" padding="0.0cm"><fo:block><xsl:value-of select="codigo"/></fo:block></fo:table-cell>
																			<fo:table-cell text-align="left" padding="0.0cm"><fo:block><xsl:value-of select="descripcion"/></fo:block></fo:table-cell>
																			<fo:table-cell text-align="left" padding="0.0cm"><fo:block><xsl:value-of select="tamanio"/></fo:block></fo:table-cell>
																		</fo:table-row>
																</xsl:for-each>
																<fo:table-row>
																	<fo:table-cell text-align="left" number-columns-spanned="2"><fo:block>*** SALDOS POR ENTREGAR***</fo:block></fo:table-cell>
																</fo:table-row>
																<!--DETALLES DE LAS JABAS-->
																<xsl:for-each select="detallesPorEntregar">
																		<fo:table-row>
																			<fo:table-cell text-align="left" padding="0.0cm"><fo:block><xsl:value-of select="cantidad"/></fo:block></fo:table-cell>
																			<fo:table-cell text-align="left" padding="0.0cm"><fo:block><xsl:value-of select="codigo"/></fo:block></fo:table-cell>
																			<fo:table-cell text-align="left" padding="0.0cm"><fo:block><xsl:value-of select="descripcion"/></fo:block></fo:table-cell>
																			<fo:table-cell text-align="left" padding="0.0cm"><fo:block><xsl:value-of select="tamanio"/></fo:block></fo:table-cell>
																		</fo:table-row>
																</xsl:for-each>
															</fo:table-body>
														</fo:table>
													</fo:table-cell>
												</fo:table-row>
											</fo:table-body>
										</fo:table>
									</fo:table-cell>
									<!--tabla derecha-->
									<fo:table-cell text-align="right">
										<fo:table xsl:use-attribute-sets="table">
											<!--declaracion de las columnas-->
											<fo:table-column column-width="5.5cm"/>
											<fo:table-column column-width="5.0cm"/>
											<fo:table-body>
												<fo:table-row>
													<fo:table-cell text-align="center"><fo:block>SIC/SMX434-SMX434DS</fo:block></fo:table-cell>
													<fo:table-cell text-align="right"><fo:block>11/JUN/2012 15:37</fo:block></fo:table-cell>		
												</fo:table-row>
												<fo:table-row>
													<fo:table-cell text-align="left" number-columns-spanned="2">
														<fo:block>================================================================</fo:block>
													</fo:table-cell>
												</fo:table-row>
												<fo:table-row>
													<fo:table-cell text-align="left"><fo:block>	ORDEN DE SALIDA</fo:block></fo:table-cell>
													<fo:table-cell text-align="right"><fo:block>025: 020 2163 50001</fo:block></fo:table-cell>		
												</fo:table-row>
												<fo:table-row>
													<fo:table-cell text-align="left" number-columns-spanned="2">
														<fo:block>================================================================</fo:block>
													</fo:table-cell>
												</fo:table-row>
												<fo:table-row>
													<fo:table-cell text-align="right" number-columns-spanned="2">
														<fo:block>Fecha Elaborac: 11/JUN/2012 </fo:block>
													</fo:table-cell>
												</fo:table-row>
												<fo:table-row>
													<fo:table-cell text-align="left" number-columns-spanned="2">
														<fo:block>BOD:<xsl:value-of select="bodega"/></fo:block>
													</fo:table-cell>
												</fo:table-row>
											</fo:table-body>
										</fo:table>
									</fo:table-cell>
								</fo:table-row>
								<!--pie de pagina-->
								<fo:table-row><fo:table-cell margin-right="5.0mm" text-align="right" number-columns-spanned="2"><fo:block>-------------------------------------------------------------------------------------</fo:block></fo:table-cell></fo:table-row>
								<fo:table-row><fo:table-cell margin-right="5.0mm" text-align="right" number-columns-spanned="2"><fo:block>!&#160;&#160;&#160;&#160;&#160;Autorizo  Orden de Salida&#160;&#160;&#160;&#160;&#160;!&#160;&#160;&#160;&#160;&#160;Recibo Orden de Salida&#160;&#160;&#160;&#160;&#160;!</fo:block></fo:table-cell></fo:table-row>
								<fo:table-row><fo:table-cell margin-right="5.0mm" text-align="right" number-columns-spanned="2"><fo:block>!&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;!&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;!</fo:block></fo:table-cell></fo:table-row>
								<fo:table-row><fo:table-cell margin-right="5.0mm" text-align="right" number-columns-spanned="2"><fo:block>!&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;!&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;!</fo:block></fo:table-cell></fo:table-row>
								<fo:table-row><fo:table-cell margin-right="5.0mm" text-align="right" number-columns-spanned="2"><fo:block>!&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;!&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;!</fo:block></fo:table-cell></fo:table-row>
								<fo:table-row><fo:table-cell margin-right="5.0mm" text-align="right" number-columns-spanned="2"><fo:block>!&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;!&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;!</fo:block></fo:table-cell></fo:table-row>
								<fo:table-row><fo:table-cell margin-right="5.0mm" text-align="right" number-columns-spanned="2"><fo:block>!&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;!&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;!</fo:block></fo:table-cell></fo:table-row>
								<fo:table-row><fo:table-cell margin-right="5.0mm" text-align="right" number-columns-spanned="2"><fo:block>!&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;!&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;!</fo:block></fo:table-cell></fo:table-row>
								<fo:table-row><fo:table-cell margin-right="5.0mm" text-align="right" number-columns-spanned="2"><fo:block>!&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;!&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;!</fo:block></fo:table-cell></fo:table-row>
								<fo:table-row><fo:table-cell margin-right="5.0mm" text-align="right" number-columns-spanned="2"><fo:block>-------------------------------------------------------------------------------------</fo:block></fo:table-cell></fo:table-row>
								<fo:table-row>
									<fo:table-cell padding-top="1.0cm" text-align="center" number-columns-spanned="2" >
										<fo:table xsl:use-attribute-sets="table">
											<fo:table-column column-width="8.0cm"/>
											<fo:table-column column-width="10.5cm"/>
											<fo:table-body>	
												<fo:table-row>
													<fo:table-cell padding-top="1.0cm" text-align="center" number-columns-spanned="2" >
														<fo:block>&#160;SALDOS POR ENTREGAR</fo:block>
													</fo:table-cell>
												</fo:table-row>
												<fo:table-row>
													<!--tabla izquierda-->
													<fo:table-cell text-align="center">
														<fo:table xsl:use-attribute-sets="table">
															<fo:table-column column-width="8.0cm"/>
															<fo:table-body>
																<fo:table-row>
																	<fo:table-cell text-align="left"><fo:block>PROVEEDOR:</fo:block></fo:table-cell>
																</fo:table-row>
																<fo:table-row>
																	<fo:table-cell text-align="left"><fo:block><xsl:value-of select="codigoNombreProv"/></fo:block></fo:table-cell>
																</fo:table-row>
																<fo:table-row>
																	<fo:table-cell text-align="left"><fo:block><xsl:value-of select="nombreProv"/></fo:block></fo:table-cell>
																</fo:table-row>
																<fo:table-row>
																	<fo:table-cell text-align="left"><fo:block><xsl:value-of select="dirProv"/></fo:block></fo:table-cell>		
																</fo:table-row>
																<fo:table-row>
																	<fo:table-cell text-align="left"><fo:block><xsl:value-of select="ciudadProv"/></fo:block></fo:table-cell>		
																</fo:table-row>
																<fo:table-row>
																	<fo:table-cell text-align="left"><fo:block><xsl:value-of select="telefonoProv"/></fo:block></fo:table-cell>		
																</fo:table-row>
																<fo:table-row>
																	<fo:table-cell text-align="left"><fo:block><xsl:value-of select="rucProv"/></fo:block></fo:table-cell>		
																</fo:table-row>
																<fo:table-row>
																	<fo:table-cell text-align="center">
																		<fo:table xsl:use-attribute-sets="table">
																			<fo:table-column column-width="3.0cm"/>
																			<fo:table-column column-width="3.0cm"/>
																			<fo:table-column column-width="6.0cm"/>
																			<fo:table-column column-width="3.0cm"/>
																			<fo:table-body>
																				<fo:table-row>
																					<fo:table-cell text-align="left"><fo:block>Cantidad</fo:block></fo:table-cell>
																					<fo:table-cell text-align="left"><fo:block>Codigo</fo:block></fo:table-cell>		
																					<fo:table-cell text-align="left"><fo:block>Descripcion-Articulo</fo:block></fo:table-cell>		
																					<fo:table-cell text-align="left"><fo:block>Tamanio</fo:block></fo:table-cell>		
																				</fo:table-row>
																				<!--DETALLES DE LAS JABAS-->
																				<xsl:for-each select="detallesPorEntregar">
																						<fo:table-row>
																							<fo:table-cell text-align="left" padding="0.0cm"><fo:block><xsl:value-of select="cantidad"/></fo:block></fo:table-cell>
																							<fo:table-cell text-align="left" padding="0.0cm"><fo:block><xsl:value-of select="codigo"/></fo:block></fo:table-cell>
																							<fo:table-cell text-align="left" padding="0.0cm"><fo:block><xsl:value-of select="descripcion"/></fo:block></fo:table-cell>
																							<fo:table-cell text-align="left" padding="0.0cm"><fo:block><xsl:value-of select="tamanio"/></fo:block></fo:table-cell>
																						</fo:table-row>
																				</xsl:for-each>
																			</fo:table-body>
																		</fo:table>
																	</fo:table-cell>
																</fo:table-row>
															</fo:table-body>
														</fo:table>
													</fo:table-cell>
													<!--tabla derecha-->
													<fo:table-cell text-align="left">
														<fo:table xsl:use-attribute-sets="table">
															<!--declaracion de las columnas-->
															<fo:table-column column-width="5.5cm"/>
															<fo:table-column column-width="5.0cm"/>
															<fo:table-body>
																<fo:table-row>
																	<fo:table-cell text-align="center"><fo:block>SIC/SMX434-SMX434DS</fo:block></fo:table-cell>
																	<fo:table-cell text-align="right"><fo:block>11/JUN/2012 15:37</fo:block></fo:table-cell>		
																</fo:table-row>
																<fo:table-row>
																	<fo:table-cell text-align="left" number-columns-spanned="2">
																		<fo:block>================================================================</fo:block>
																	</fo:table-cell>
																</fo:table-row>
																<fo:table-row>
																	<fo:table-cell text-align="left"><fo:block>SALDO POR ENTREGAR</fo:block></fo:table-cell>
																	<fo:table-cell text-align="right"><fo:block>025: 020 2163 50001</fo:block></fo:table-cell>		
																</fo:table-row>
																<fo:table-row>
																	<fo:table-cell text-align="left" number-columns-spanned="2">
																		<fo:block>================================================================</fo:block>
																	</fo:table-cell>
																</fo:table-row>
																<fo:table-row>
																	<fo:table-cell text-align="right" number-columns-spanned="2">
																		<fo:block>Fecha Elaborac: 11/JUN/2012 </fo:block>
																	</fo:table-cell>
																</fo:table-row>
																<fo:table-row>
																	<fo:table-cell text-align="left" number-columns-spanned="2">
																		<fo:block>BOD: <xsl:value-of select="bodega"/></fo:block>
																	</fo:table-cell>
																</fo:table-row>
															</fo:table-body>
														</fo:table>
													</fo:table-cell>
											</fo:table-row>
											<fo:table-row><fo:table-cell margin-right="5.0mm" text-align="right" number-columns-spanned="2"><fo:block>-------------------------------------------------------------------------------------------</fo:block></fo:table-cell></fo:table-row>
											<fo:table-row><fo:table-cell margin-right="5.0mm" text-align="right" number-columns-spanned="2"><fo:block>!&#160;&#160;&#160;&#160;&#160;Entrega Documento Saldos&#160;&#160;&#160;&#160;&#160;!&#160;&#160;&#160;&#160;&#160;Recibe Documento Saldos&#160;&#160;&#160;&#160;&#160;!</fo:block></fo:table-cell></fo:table-row>
											<fo:table-row><fo:table-cell margin-right="5.0mm" text-align="right" number-columns-spanned="2"><fo:block>!&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;!&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;!</fo:block></fo:table-cell></fo:table-row>
											<fo:table-row><fo:table-cell margin-right="5.0mm" text-align="right" number-columns-spanned="2"><fo:block>!&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;!&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;!</fo:block></fo:table-cell></fo:table-row>
											<fo:table-row><fo:table-cell margin-right="5.0mm" text-align="right" number-columns-spanned="2"><fo:block>!&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;!&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;!</fo:block></fo:table-cell></fo:table-row>
											<fo:table-row><fo:table-cell margin-right="5.0mm" text-align="right" number-columns-spanned="2"><fo:block>!&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;!&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;!</fo:block></fo:table-cell></fo:table-row>
											<fo:table-row><fo:table-cell margin-right="5.0mm" text-align="right" number-columns-spanned="2"><fo:block>!&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;!&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;!</fo:block></fo:table-cell></fo:table-row>
											<fo:table-row><fo:table-cell margin-right="5.0mm" text-align="right" number-columns-spanned="2"><fo:block>!&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;!&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;!</fo:block></fo:table-cell></fo:table-row>
											<fo:table-row><fo:table-cell margin-right="5.0mm" text-align="right" number-columns-spanned="2"><fo:block>!&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;!&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;!</fo:block></fo:table-cell></fo:table-row>
											<fo:table-row><fo:table-cell margin-right="5.0mm" text-align="right" number-columns-spanned="2"><fo:block>-------------------------------------------------------------------------------------------</fo:block></fo:table-cell></fo:table-row>
											</fo:table-body>
										</fo:table>
									</fo:table-cell>
								</fo:table-row>
							</fo:table-body>
						</fo:table>
						
					</fo:block>
					
           </fo:flow>
        </fo:page-sequence>
    </fo:root>
    </xsl:template> 
</xsl:stylesheet>