<?xml version='1.0' encoding='ISO-8859-1'?>
<xsl:stylesheet version="1.1" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" 
xmlns:fo="http://www.w3.org/1999/XSL/Format" 
exclude-result-prefixes="fo">
	<!-- page size -->
	<xsl:param name="page-width">auto</xsl:param>
	<xsl:param name="page-height">auto</xsl:param>
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
	
	<xsl:template match="recepcionJuguetes">
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
							<fo:table-column column-width="5.5cm"/>
							<fo:table-column column-width="5.0cm"/>
							<fo:table-column column-width="5.0cm"/>
							<fo:table-column column-width="3.5cm"/>
							<fo:table-column column-width="3.5cm"/>
							<fo:table-body>		
								<fo:table-row>	<!--FILA 1-->
									<fo:table-cell text-align="left"><fo:block>Tda/Alm/CDI:</fo:block></fo:table-cell>									
									<fo:table-cell text-align="left"><fo:block>Proveedor:</fo:block></fo:table-cell>							  
									<fo:table-cell text-align="left">
										<fo:block>
											MAX
										</fo:block>
									</fo:table-cell>
									<fo:table-cell><fo:block><xsl:value-of select="fecha"/></fo:block></fo:table-cell>
									<fo:table-cell>
										<fo:block>P&#225;gina&#160;<fo:page-number/>&#160;de&#160;<fo:page-number-citation ref-id="endPage"/></fo:block>
									</fo:table-cell>
								</fo:table-row>									
								<fo:table-row>
									<fo:table-cell text-align="left">
										<fo:block>
											<xsl:value-of select="codigoCd"/>&#160;<xsl:value-of select="nombreCd"/>
										</fo:block>
									</fo:table-cell>
									<fo:table-cell text-align="left"><fo:block><xsl:value-of select="proveedor/codigo"/></fo:block></fo:table-cell>
									<fo:table-cell text-align="left"><fo:block>================================================================</fo:block></fo:table-cell>							  
									<fo:table-cell text-align="left"><fo:block></fo:block></fo:table-cell>
									<fo:table-cell text-align="left"><fo:block></fo:block></fo:table-cell>
								</fo:table-row>									
								<fo:table-row>								 
									<fo:table-cell text-align="left"><fo:block><xsl:value-of select="compania/nombre"/></fo:block></fo:table-cell>
									<fo:table-cell text-align="left"><fo:block><xsl:value-of select="proveedor/nombre"/></fo:block></fo:table-cell>
									<fo:table-cell number-columns-spanned="3" text-align="left"><fo:block>HOJA PRELIMINAR PARA RECEPCION x O.C. PENDIENTE DE RECIBIR 013</fo:block></fo:table-cell>
								</fo:table-row>
								<fo:table-row>	
									<fo:table-cell text-align="left"><fo:block><xsl:value-of select="compania/direccion"/></fo:block></fo:table-cell>
									<fo:table-cell text-align="left"><fo:block><xsl:value-of select="proveedor/direccion"/></fo:block></fo:table-cell>
									<fo:table-cell text-align="left"><fo:block>================================================================</fo:block></fo:table-cell>
									<fo:table-cell text-align="left"><fo:block></fo:block></fo:table-cell>
									<fo:table-cell text-align="left"><fo:block></fo:block></fo:table-cell>
								</fo:table-row>								
								<fo:table-row>	
									<fo:table-cell>
										<fo:block><xsl:value-of select="compania/ciudad"/> - ECUADOR &#160;&#160;&#160;&#160;<xsl:value-of select="compania/provincia"/></fo:block>
									</fo:table-cell>
									<fo:table-cell text-align="left"> 
										<fo:block><xsl:value-of select="proveedor/ciudad"/> &#160;&#160;&#160;&#160;<xsl:value-of select="Cabecera/Proveedor/provinciaProv"/></fo:block>
									</fo:table-cell>
									<fo:table-cell text-align="left"><fo:block>Embarque: <xsl:value-of select="proveedor/embarque"/> </fo:block></fo:table-cell>
									<fo:table-cell text-align="left"><fo:block>Agrupa Fech. Desde:</fo:block></fo:table-cell>
									<fo:table-cell text-align="left"><fo:block><xsl:value-of select="fechaInicio"/></fo:block></fo:table-cell>
								</fo:table-row>
								<fo:table-row>
									<fo:table-cell text-align="left"><fo:block><xsl:value-of select="compania/telefono"/></fo:block></fo:table-cell>
									<fo:table-cell text-align="left"><fo:block><xsl:value-of select="proveedor/telefono"/></fo:block></fo:table-cell>
									<fo:table-cell text-align="left"><fo:block></fo:block></fo:table-cell>
									<fo:table-cell text-align="left"><fo:block>Hasta:</fo:block></fo:table-cell>
									<fo:table-cell text-align="left"><fo:block><xsl:value-of select="fechaFin"/></fo:block></fo:table-cell>
								</fo:table-row>	
								<fo:table-row> 
									<fo:table-cell text-align="left"><fo:block>RFC:<xsl:value-of select="compania/ruc"/></fo:block></fo:table-cell>
									<fo:table-cell text-align="left">
										<fo:block>RFC:<xsl:value-of select="proveedor/ruc"/></fo:block>
									</fo:table-cell>							  
									<fo:table-cell text-align="left">
										<fo:block>
											NORMAL
										</fo:block>
									</fo:table-cell>
									<fo:table-cell number-columns-spanned="2" text-align="left">
										<fo:block>
											Bodega:&#160;<xsl:value-of select="codigoBodega"/>&#160;<xsl:value-of select="nombreBodega"/>
										</fo:block>
									</fo:table-cell>
								</fo:table-row>	
							</fo:table-body>
						</fo:table>							
						<fo:block>&#160;</fo:block>		
						<fo:table xsl:use-attribute-sets="table"> 
							<fo:table-column column-width="6.0cm"/>
							<fo:table-column column-width="2.2cm"/>
							<fo:table-column column-width="0.8cm"/>
							<fo:table-column column-width="1.2cm"/>
							<fo:table-column column-width="2.2cm"/>
							<fo:table-column column-width="1.6cm"/>								
							<fo:table-column column-width="1.5cm"/>
							<fo:table-column column-width="4.0cm"/>
							<fo:table-column column-width="1.5cm"/>
							<fo:table-body>
								<fo:table-row>
									<fo:table-cell text-align="left"><fo:block>&#160;</fo:block><fo:block font-weight="bold">Descripci&#243;n/Tama&#241;o/Acabado</fo:block></fo:table-cell>
									<fo:table-cell text-align="left"><fo:block>&#160;</fo:block><fo:block font-weight="bold">Ref. ext.</fo:block></fo:table-cell>
									<fo:table-cell text-align="left"><fo:block>&#160;</fo:block><fo:block font-weight="bold">UC</fo:block></fo:table-cell>
									<fo:table-cell text-align="left"><fo:block font-weight="bold">Piezas X UC </fo:block></fo:table-cell>
									<fo:table-cell text-align="left"><fo:block>&#160;</fo:block><fo:block font-weight="bold">C&#243;digo Barras</fo:block></fo:table-cell>
									<fo:table-cell text-align="left"><fo:block font-weight="bold">Cantidad Pdte Rec.</fo:block></fo:table-cell>
									<fo:table-cell text-align="left"><fo:block>&#160;</fo:block><fo:block font-weight="bold">Cantidad</fo:block></fo:table-cell>
									<fo:table-cell text-align="center"><fo:block>&#160;</fo:block><fo:block font-weight="bold">C&#243;digo Barras</fo:block></fo:table-cell>
									<fo:table-cell text-align="left"><fo:block>&#160;</fo:block><fo:block font-weight="bold">U. Manejo</fo:block></fo:table-cell>
								</fo:table-row>						  
							</fo:table-body>
						</fo:table>
					</fo:block>
				</fo:static-content>

				<fo:flow flow-name="page-body" >
					<fo:block xsl:use-attribute-sets="body">	
						<fo:table xsl:use-attribute-sets="table">
							<fo:table-column column-width="6.0cm"/>
							<fo:table-column column-width="2.2cm"/>
							<fo:table-column column-width="0.8cm"/>
							<fo:table-column column-width="1.2cm"/>
							<fo:table-column column-width="2.2cm"/>
							<fo:table-column column-width="1.6cm"/>								
							<fo:table-column column-width="1.5cm"/>
							<fo:table-column column-width="4.0cm"/>
							<fo:table-column column-width="1.5cm"/>
							
							<fo:table-body>									
								<xsl:for-each select="detalles">
									<fo:table-row>
										<fo:table-cell text-align="left" padding="0.2cm">
											<fo:block>
												<xsl:value-of select="descripcion"/>&#160;
												<xsl:if test="tamanio != null">
													<xsl:value-of select="tamanio"/>&#160;
												</xsl:if>
											</fo:block>
										</fo:table-cell>
										<fo:table-cell text-align="left"  padding="0.2cm">
											<fo:block  font-family="Arial">
												<fo:inline letter-spacing="2pt"><xsl:value-of select="referenciaExterna"/></fo:inline>					
											</fo:block>
										</fo:table-cell>
										<fo:table-cell text-align="left" padding="0.2cm"><fo:block><xsl:value-of select="uc"/></fo:block></fo:table-cell>
										<fo:table-cell text-align="left" padding="0.2cm">
											<fo:block>
												<fo:inline letter-spacing="2pt" font-family="Arial"><xsl:value-of select="piezas"/></fo:inline>
											</fo:block>
										</fo:table-cell>
										<fo:table-cell text-align="center" padding="0.2cm">
											<fo:block>
												<fo:inline letter-spacing="2pt" font-family="Arial"><xsl:value-of select="codigoBarras"/></fo:inline>	
											</fo:block>
										</fo:table-cell>
										<fo:table-cell text-align="right" padding="0.2cm">
											<fo:block>
												<fo:inline letter-spacing="2pt" font-family="Arial"><xsl:value-of select="cantidad"/></fo:inline>
											</fo:block>
										</fo:table-cell>
										<fo:table-cell text-align="left" padding="0.2cm"><fo:block>________</fo:block></fo:table-cell>
										<fo:table-cell text-align="left" padding="0.2cm"><fo:block>________________________</fo:block></fo:table-cell>
										<fo:table-cell text-align="left" padding="0.2cm"><fo:block>________</fo:block></fo:table-cell>
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