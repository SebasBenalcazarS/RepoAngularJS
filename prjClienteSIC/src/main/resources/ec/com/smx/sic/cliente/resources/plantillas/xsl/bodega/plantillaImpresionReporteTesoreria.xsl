<?xml version='1.0' encoding='ISO-8859-1'?>
<xsl:stylesheet version="1.1" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" 
xmlns:fo="http://www.w3.org/1999/XSL/Format" 
exclude-result-prefixes="fo">
	<!-- page size -->
	<!--
	ANCHO_PAGINA("page-width"),
	ALTO_PAGINA("page-height"),
	MARGEN_SUPERIOR_PAGINA("page-margin-top")
	MARGEN_INFERIOR_PAGINA("page-margin-bottom"),
	MARGEN_IZQUIERDO_PAGINA("page-margin-left"),
	MARGEN_DERECHO_PAGINA("page-margin-right"),
	MARGEN_INFERIOR_PIE_PAGINA("page-footer-margin-bottom"),
	MARGEN_SUPERIOR_CABECERA_PAGINA("page-header-margin-top");-->
	<xsl:param name="page-width"/>
	<xsl:param name="page-height"/>
	<xsl:param name="page-margin-bottom"/>
	<xsl:param name="page-footer-margin-bottom"/>
	<xsl:param name="page-margin-left"/>
	<xsl:param name="page-margin-top"/>
	<xsl:param name="page-margin-right"/>
	<xsl:param name="page-header-margin-top"/>
	
	<!-- page header and footer-->
	<xsl:param name="font-family">SansSerif</xsl:param>
	<xsl:param name="font-size">7pt</xsl:param>
	<xsl:param name="decimal-format-total">###,##0.00</xsl:param>
	<xsl:param name="decimal-format-items">###,##0.0000</xsl:param>
	<xsl:param name="number-format">###,###</xsl:param>
	
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
	
	<!-- atribute  table -->
	<xsl:attribute-set name="table">
		<xsl:attribute name="table-layout">fixed</xsl:attribute>	
		<xsl:attribute name="width">100%</xsl:attribute>
		<xsl:attribute name="hyphenate">false</xsl:attribute>	
		<xsl:attribute name="language">en</xsl:attribute>	
		<!-- <xsl:attribute name="border-style">solid</xsl:attribute>--> <!--bode de las tablas-->	
	</xsl:attribute-set>
	
	<xsl:template match="reporteTesoreria">
		<fo:root xmlns:fo="http://www.w3.org/1999/XSL/Format">
			<fo:layout-master-set>	  
				<fo:simple-page-master master-name="all-pages" xsl:use-attribute-sets="page">		
					<fo:region-body margin-top="{$page-margin-top}"  margin-left="{$page-margin-left}" />
					<fo:region-before />
				</fo:simple-page-master>
			</fo:layout-master-set>
				
			<fo:page-sequence master-reference="all-pages">	
				<fo:static-content flow-name="xsl-region-before">
					<fo:block xsl:use-attribute-sets="page-header" margin-left="5.0mm" margin-top="{$page-header-margin-top}">		
						<fo:table>
							<fo:table-column column-width="9.5cm"/>
							<fo:table-column column-width="9.5cm"/>
							<fo:table-column column-width="9.5cm"/>
							<fo:table-body>		
								<fo:table-row>
									<fo:table-cell text-align="left"><fo:block><xsl:value-of select="cabecera/reporteOrigen"/></fo:block></fo:table-cell>									
									<fo:table-cell text-align="center"><fo:block>S U P E R M A X I</fo:block></fo:table-cell>							  
									<fo:table-cell text-align="right">
										<fo:block>
											<xsl:value-of select="cabecera/fechaReporte"/>&#160;<xsl:value-of select="cabecera/horaReporte"/>
										</fo:block>
									</fo:table-cell>
								</fo:table-row>									
								<fo:table-row>
									<fo:table-cell text-align="left"><fo:block></fo:block></fo:table-cell>
									<fo:table-cell text-align="center"><fo:block>SISTEMA INTEGRADO DE COMERCIALIZACION</fo:block></fo:table-cell>
									<fo:table-cell text-align="right">
										<fo:block>P&#225;gina&#160;<fo:page-number/>&#160;de&#160;<fo:page-number-citation ref-id="endPage"/></fo:block>
									</fo:table-cell>
								</fo:table-row>									
								<fo:table-row>								 
									<fo:table-cell text-align="left">
										<fo:block>
											Bodega:&#160;<xsl:value-of select="cabecera/codigoBodega"/>&#160;<xsl:value-of select="cabecera/nombreBodega"/>
										</fo:block>
									</fo:table-cell>
									<fo:table-cell text-align="center"><fo:block>Mercancia Recibida</fo:block></fo:table-cell>
									<fo:table-cell><fo:block></fo:block></fo:table-cell>
								</fo:table-row>
								<fo:table-row>								 
									<fo:table-cell text-align="left">
										<fo:block>
											Tienda:&#160;<xsl:value-of select="cabecera/codigoCd"/>&#160;<xsl:value-of select="cabecera/nombreCd"/>
										</fo:block>
									</fo:table-cell>
									<!--<fo:table-cell text-align="center"><fo:block><xsl:value-of select="cabecera/origenProveedor"/></fo:block></fo:table-cell> -->
									<xsl:call-template name="info-tipo-proveedor">
										<xsl:with-param name="tipo"><xsl:value-of select="cabecera/origenProveedor"/></xsl:with-param>
									</xsl:call-template>
									<fo:table-cell text-align="right"><fo:block>Fecha de Movimientos:&#160;<xsl:value-of select="cabecera/fechaMovimiento"/></fo:block></fo:table-cell>
								</fo:table-row>
							</fo:table-body>
						</fo:table>							
					</fo:block>
				</fo:static-content>
				
				<fo:flow flow-name="xsl-region-body" >
					<fo:block xsl:use-attribute-sets="body">	
						<fo:table xsl:use-attribute-sets="table" table-omit-footer-at-break="true">
							<fo:table-column column-width="1.0cm"/>
							<fo:table-column column-width="1.0cm"/>
							<fo:table-column column-width="2.0cm"/>
							<fo:table-column column-width="1.0cm"/>
							<fo:table-column column-width="1.0cm"/>
							<fo:table-column column-width="3.0cm"/>
							<fo:table-column column-width="2.0cm"/>								
							<fo:table-column column-width="3.0cm"/>
							<fo:table-column column-width="2.0cm"/>
							<fo:table-column column-width="2.0cm"/>
							<fo:table-column column-width="2.0cm"/>								
							<fo:table-column column-width="2.0cm"/>
							<fo:table-column column-width="2.0cm"/>
							<fo:table-header>
								<fo:table-row height="5.0mm">
									<fo:table-cell text-align="left"><fo:block font-weight="bold">Div</fo:block></fo:table-cell>
									<fo:table-cell text-align="right"><fo:block font-weight="bold">Dep</fo:block></fo:table-cell>
									<fo:table-cell text-align="right"><fo:block font-weight="bold">Orden compra</fo:block></fo:table-cell>
									<fo:table-cell text-align="right"><fo:block font-weight="bold">N/I</fo:block></fo:table-cell>
									<fo:table-cell text-align="right"><fo:block font-weight="bold">Prov</fo:block></fo:table-cell>
									<fo:table-cell text-align="right"><fo:block font-weight="bold">Razon social</fo:block></fo:table-cell>											
									<fo:table-cell text-align="center"><fo:block font-weight="bold">C. recibo</fo:block></fo:table-cell>
									<fo:table-cell text-align="center"><fo:block font-weight="bold">Num Factura</fo:block></fo:table-cell>
									<fo:table-cell text-align="right"><fo:block font-weight="bold">Fact.Proveedor</fo:block></fo:table-cell>
									<fo:table-cell text-align="right"><fo:block font-weight="bold">Fa.Int.C/Iva</fo:block></fo:table-cell>
									<fo:table-cell text-align="right"><fo:block font-weight="bold">Fa.Int.T.Cero</fo:block></fo:table-cell>
									<fo:table-cell text-align="right"><fo:block font-weight="bold">Fa.Int.T.Iva</fo:block></fo:table-cell>
									<fo:table-cell text-align="right"><fo:block font-weight="bold">E</fo:block></fo:table-cell>
								</fo:table-row>
							</fo:table-header>
							<fo:table-footer>
								<fo:table-row>
									<fo:table-cell ><fo:block></fo:block></fo:table-cell>
									<fo:table-cell ><fo:block></fo:block></fo:table-cell>
									<fo:table-cell ><fo:block></fo:block></fo:table-cell>
									<fo:table-cell ><fo:block></fo:block></fo:table-cell>
									<fo:table-cell ><fo:block></fo:block></fo:table-cell>
									<fo:table-cell ><fo:block></fo:block></fo:table-cell>
									<fo:table-cell padding-top="0.2cm" number-columns-spanned="2">
										<fo:table xsl:use-attribute-sets="table">
											<fo:table-column column-width="24.0mm"/>
											<fo:table-column column-width="25.0mm"/>
											<fo:table-body>	
												<fo:table-row>
													<fo:table-cell text-align="left"><fo:block>Total Nacional</fo:block></fo:table-cell>
													<fo:table-cell text-align="right"><fo:block><xsl:value-of select="totalArticulosNacionales"/></fo:block></fo:table-cell>
												</fo:table-row>
												<fo:table-row>
													<fo:table-cell text-align="left"><fo:block>Total Importado</fo:block></fo:table-cell>
													<fo:table-cell text-align="right"><fo:block><xsl:value-of select="totalArticulosImportados"/></fo:block></fo:table-cell>
												</fo:table-row>
												<fo:table-row>
													<fo:table-cell text-align="left"><fo:block>T o t a l e s :</fo:block></fo:table-cell>
													<fo:table-cell text-align="right"><fo:block><xsl:value-of select="totalArticulosRecibidos"/></fo:block></fo:table-cell>
												</fo:table-row>
											</fo:table-body>	
										</fo:table> 
									</fo:table-cell>
									<fo:table-cell padding-top="0.2cm" text-align="right"><fo:block><xsl:value-of select="totalFacturasProveedor"/></fo:block></fo:table-cell>
									<fo:table-cell padding-top="0.2cm" text-align="right"><fo:block><xsl:value-of select="totalNotaIngreso"/></fo:block></fo:table-cell>
									<fo:table-cell ><fo:block></fo:block></fo:table-cell>
									<fo:table-cell ><fo:block></fo:block></fo:table-cell>
									<fo:table-cell ><fo:block></fo:block></fo:table-cell>
								</fo:table-row>
							</fo:table-footer>
							<fo:table-body>									
								<xsl:for-each select="detallesReprote/detalle">							
									<fo:table-row>
										<fo:table-cell text-align="left"><fo:block><xsl:value-of select="division"/></fo:block></fo:table-cell>
										<fo:table-cell text-align="right"><fo:block><xsl:value-of select="departamento"/></fo:block></fo:table-cell>
										<fo:table-cell text-align="right"><fo:block><xsl:value-of select="numeroOrdenCompra"/></fo:block></fo:table-cell>
										<fo:table-cell text-align="right"><fo:block><xsl:value-of select="origenProveedor"/></fo:block></fo:table-cell>
										<fo:table-cell text-align="right"><fo:block><xsl:value-of select="codigoProveedor"/></fo:block></fo:table-cell>
										<fo:table-cell text-align="right"><fo:block><xsl:value-of select="razonSocial"/></fo:block></fo:table-cell>
										<fo:table-cell text-align="right"><fo:block><xsl:value-of select="numeroFactura"/></fo:block></fo:table-cell>
										<fo:table-cell text-align="right"><fo:block><xsl:value-of select="agrupadorFactura"/></fo:block></fo:table-cell>
										<fo:table-cell text-align="right"><fo:block><xsl:value-of select='format-number(valorTotalProveedor, $decimal-format-total)'/></fo:block></fo:table-cell>
										<fo:table-cell text-align="right"><fo:block><xsl:value-of select='format-number(totalFactura, $decimal-format-total)'/></fo:block></fo:table-cell>
										<fo:table-cell text-align="right"><fo:block><xsl:value-of select='format-number(valorTarifaCero, $decimal-format-total)'/></fo:block></fo:table-cell>
										<fo:table-cell text-align="right"><fo:block><xsl:value-of select='format-number(valorTarifaDoce, $decimal-format-total)'/></fo:block></fo:table-cell>
										<fo:table-cell text-align="right"><fo:block><xsl:value-of select="numeroEntrega"/></fo:block></fo:table-cell>
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
	
	<xsl:template name="info-tipo-proveedor">
		<xsl:param name="tipo"/>
		<xsl:if test="$tipo = 'I'">
			<fo:table-cell text-align="center"><fo:block>IMPORTADO</fo:block></fo:table-cell>
		</xsl:if>
		<xsl:if test="$tipo = 'N'">
			<fo:table-cell text-align="center"><fo:block>NACIONAL</fo:block></fo:table-cell>
		</xsl:if>
	</xsl:template>
</xsl:stylesheet>