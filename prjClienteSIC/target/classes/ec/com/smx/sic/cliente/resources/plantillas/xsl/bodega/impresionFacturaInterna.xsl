<?xml version='1.0' encoding='ISO-8859-1'?>
<xsl:stylesheet version="1.1" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" 
xmlns:fo="http://www.w3.org/1999/XSL/Format" 
exclude-result-prefixes="fo">
	<!-- page size -->
	<!--<xsl:param name="page-margin-top">0.5cm</xsl:param>-->
	<xsl:param name="page-width"/>
	<xsl:param name="page-height"/>
	<xsl:param name="page-margin-bottom"/>
	<xsl:param name="page-footer-margin-bottom"/>
	<xsl:param name="page-margin-left"/>
	<!--<xsl:param name="page-margin-left">0.1in</xsl:param>-->
	<!--<xsl:param name="page-margin-right">0.5in</xsl:param>-->
	
	<!-- page header and footer-->
	<!--<xsl:param name="page-header-margin-top">0.5cm</xsl:param>-->
	<xsl:param name="font-family">SansSerif</xsl:param>
	<xsl:param name="font-size">7pt</xsl:param>
	<xsl:param name="page-number-format">{total}</xsl:param>
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
	
	<!-- atribute  page footer -->
	<xsl:attribute-set name="page-footer">
		<xsl:attribute name="space-after.conditionality">retain</xsl:attribute>
		<xsl:attribute name="space-after"><xsl:value-of select="$page-footer-margin-bottom"/></xsl:attribute>			
		<xsl:attribute name="font-family"><xsl:value-of select="$font-family" /></xsl:attribute>
		<xsl:attribute name="font-size"><xsl:value-of select="$font-size" /></xsl:attribute>
		<xsl:attribute name="text-align">center</xsl:attribute>
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
	
	<xsl:template match="Factura">
		<fo:root xmlns:fo="http://www.w3.org/1999/XSL/Format">
			<fo:layout-master-set>	  
				<fo:simple-page-master master-name="all-pages" xsl:use-attribute-sets="page">					
					<fo:region-body region-name="page-body" margin-top="4.5cm"  margin-bottom="{$page-margin-bottom}" margin-left="{$page-margin-left}" />
					<fo:region-before region-name="page-header"  />
				</fo:simple-page-master>
			</fo:layout-master-set>
				
			<fo:page-sequence master-reference="all-pages" initial-page-number="1" force-page-count="no-force">	
				<fo:static-content flow-name="page-header">
					<fo:block xsl:use-attribute-sets="page-header" margin-left="3.0mm" margin-top="10.5mm">		
						<fo:table>
							<fo:table-column column-width="6.0cm"/>
							<fo:table-column column-width="6.0cm"/>
							<fo:table-column column-width="4.4cm"/>
							<fo:table-column column-width="2.5cm"/>
							<fo:table-column column-width="2.5cm"/>
							<fo:table-body>		
								<fo:table-row>	<!--FILA 1-->
									<fo:table-cell text-align="left"><fo:block>Tda/Alm/CDI:</fo:block></fo:table-cell>									
									<fo:table-cell text-align="left"><fo:block>Proveedor:</fo:block></fo:table-cell>							  
									<fo:table-cell text-align="left">
										<fo:block font-weight="bold">
											<!-- <xsl:value-of select="cabecera/informacionFactura/fecha"/>&#160;<xsl:value-of select="cabecera/informacionFactura/hora"/> -->
											PRUEBAS MAX, IGNORE ESTO POR FAVOR
										</fo:block>
									</fo:table-cell>
									<fo:table-cell number-columns-spanned="2" text-align="right">
										<fo:block>P&#225;gina&#160;<fo:page-number/>&#160;de&#160;<fo:page-number-citation ref-id="endPage"/></fo:block>
									</fo:table-cell>
								</fo:table-row>									
								<fo:table-row>
									<fo:table-cell text-align="left"><fo:block><xsl:value-of select="cabecera/empresa/codigoCd"/></fo:block></fo:table-cell>
									<fo:table-cell text-align="left"><fo:block><xsl:value-of select="cabecera/proveedor/codigo"/></fo:block></fo:table-cell>
									<fo:table-cell text-align="left"><fo:block>==================================================================</fo:block></fo:table-cell>							  
									<fo:table-cell text-align="left"><fo:block></fo:block></fo:table-cell>
									<fo:table-cell text-align="left"><fo:block></fo:block></fo:table-cell>
								</fo:table-row>									
								<fo:table-row>								 
									<fo:table-cell text-align="left"><fo:block><xsl:value-of select="cabecera/empresa/nombre"/></fo:block></fo:table-cell>
									<fo:table-cell text-align="left"><fo:block><xsl:value-of select="cabecera/proveedor/nombre"/></fo:block></fo:table-cell>
									<fo:table-cell number-columns-spanned="2" text-align="left"><fo:block font-weight="bold">PRUEBAS MAX, IGNORE ESTO POR FAVOR</fo:block></fo:table-cell>
									<fo:table-cell text-align="right"><fo:block><xsl:value-of select="cabecera/informacionFactura/numero"/></fo:block></fo:table-cell>
								</fo:table-row>
								<fo:table-row>	
									<fo:table-cell text-align="left"><fo:block><xsl:value-of select="cabecera/empresa/direccion"/></fo:block></fo:table-cell>
									<fo:table-cell text-align="left"><fo:block><xsl:value-of select="cabecera/proveedor/direccion"/></fo:block></fo:table-cell>
									<fo:table-cell text-align="left"><fo:block>==================================================================</fo:block></fo:table-cell>
									<fo:table-cell text-align="left"><fo:block></fo:block></fo:table-cell>
									<fo:table-cell text-align="left"><fo:block></fo:block></fo:table-cell>
								</fo:table-row>								
								<fo:table-row>	
									<fo:table-cell>
										<fo:block><xsl:value-of select="cabecera/empresa/ciudad"/> - ECUADOR &#160;&#160;&#160;&#160;<xsl:value-of select="cabecera/empresa/provincia"/></fo:block>
									</fo:table-cell>
									<fo:table-cell text-align="left"> 
										<fo:block><xsl:value-of select="cabecera/proveedor/ciudad"/> &#160;&#160;&#160;&#160;<xsl:value-of select="cabecera/proveedor/provincia"/></fo:block>
									</fo:table-cell>
									<fo:table-cell text-align="left"><fo:block></fo:block></fo:table-cell>
									<fo:table-cell text-align="left"><fo:block>Factura:</fo:block></fo:table-cell>
									<fo:table-cell text-align="right"><fo:block><xsl:value-of select="cabecera/informacionFactura/codigoAgrupador"/></fo:block></fo:table-cell>
								</fo:table-row>
								<fo:table-row>
									<fo:table-cell text-align="left"><fo:block><xsl:value-of select="cabecera/empresa/telefono"/></fo:block></fo:table-cell>
									<fo:table-cell text-align="left"><fo:block><xsl:value-of select="cabecera/proveedor/telefono"/></fo:block></fo:table-cell>
									<fo:table-cell text-align="left"><fo:block></fo:block></fo:table-cell>
									<fo:table-cell text-align="left"><fo:block>Fecha Factura:</fo:block></fo:table-cell>
									<fo:table-cell text-align="right"><fo:block><xsl:value-of select="cabecera/informacionFactura/fechaFacturado"/></fo:block></fo:table-cell>
								</fo:table-row>	
								<fo:table-row> 
									<fo:table-cell text-align="left"><fo:block>RUC:<xsl:value-of select="cabecera/empresa/ruc"/></fo:block></fo:table-cell>
									<fo:table-cell text-align="left">
										<fo:block>RUC:<xsl:value-of select="cabecera/proveedor/ruc"/></fo:block>
									</fo:table-cell>							  
									<fo:table-cell text-align="left">
										<fo:block>
											Bod:<xsl:value-of select="cabecera/bodega/codigo"/> &#160;<xsl:value-of select="cabecera/bodega/nombre"/>
										</fo:block>
									</fo:table-cell>
									<fo:table-cell text-align="left"><fo:block>Fecha Recibo:</fo:block></fo:table-cell>		
									<fo:table-cell text-align="right"><fo:block><xsl:value-of select="cabecera/informacionFactura/fechaRecibido"/></fo:block></fo:table-cell>
								</fo:table-row>	
							</fo:table-body>
						</fo:table>							
						<fo:block>&#160;</fo:block>		
						<fo:table> 
							<fo:table-column column-width="2.2cm"/>
							<fo:table-column column-width="0.8cm"/>
							<fo:table-column column-width="4.7cm"/>
							<fo:table-column column-width="0.8cm"/>
							<fo:table-column column-width="1.2cm"/>
							<fo:table-column column-width="1.2cm"/>								
							<fo:table-column column-width="2.2cm"/>
							<xsl:for-each select="cadenaDescuentos">
								<fo:table-column column-width="1.0cm"/>
							</xsl:for-each>							
							<fo:table-column column-width="1.8cm"/>
							<fo:table-column column-width="0.9cm"/>
							<fo:table-body>
								<fo:table-row>
									<fo:table-cell text-align="left"><fo:block>&#160;</fo:block><fo:block font-weight="bold">C&#243;digo Barras</fo:block></fo:table-cell>
									<fo:table-cell text-align="left"><fo:block>&#160;</fo:block><fo:block font-weight="bold">DP</fo:block></fo:table-cell>
									<fo:table-cell text-align="left"><fo:block>&#160;</fo:block><fo:block font-weight="bold">Descripci&#243;n - Tama&#241;o</fo:block></fo:table-cell>
									<fo:table-cell text-align="left"><fo:block>&#160;</fo:block><fo:block font-weight="bold">IVA </fo:block></fo:table-cell>
									<fo:table-cell text-align="right"><fo:block font-weight="bold">Piezas</fo:block><fo:block font-weight="bold">x UC</fo:block></fo:table-cell>											
									<fo:table-cell text-align="center"><fo:block font-weight="bold">Cantidad</fo:block><fo:block font-weight="bold">Recibida</fo:block></fo:table-cell>
									<fo:table-cell text-align="right"><fo:block>&#160;</fo:block><fo:block font-weight="bold">Costo Bruto</fo:block></fo:table-cell>
									<xsl:for-each select="cadenaDescuentos">
										<fo:table-cell text-align="center">
											<fo:block>&#160;</fo:block><fo:block font-weight="bold"><xsl:value-of select="descuento"/></fo:block>
										</fo:table-cell>
									</xsl:for-each>	
									<fo:table-cell text-align="center"><fo:block>&#160;</fo:block><fo:block font-weight="bold">Costo Total</fo:block></fo:table-cell>
									<fo:table-cell text-align="center"><fo:block>&#160;</fo:block><fo:block font-weight="bold">I.Ver</fo:block></fo:table-cell>
								</fo:table-row>						  
							</fo:table-body>
						</fo:table>
					</fo:block>
				</fo:static-content>

				<fo:flow flow-name="page-body" >
					<fo:block xsl:use-attribute-sets="body">	
						<fo:table xsl:use-attribute-sets="table">
							<fo:table-column column-width="2.2cm"/>
							<fo:table-column column-width="0.8cm"/>
							<fo:table-column column-width="4.7cm"/>
							<fo:table-column column-width="0.8cm"/>
							<fo:table-column column-width="0.8cm"/>
							<fo:table-column column-width="1.2cm"/>								
							<fo:table-column column-width="2.2cm"/>
							<xsl:for-each select="cadenaDescuentos">
								<fo:table-column column-width="1.0cm"/>
							</xsl:for-each>		
							<fo:table-column column-width="1.8cm"/>
							<fo:table-column column-width="0.9cm"/>
							<fo:table-body>									
								<xsl:for-each select="detalles/articulo">
									<fo:table-row>
										<fo:table-cell text-align="left"><fo:block><xsl:value-of select="codigoBarras"/></fo:block></fo:table-cell>
										<fo:table-cell text-align="left"><fo:block><xsl:value-of select="Dp"/></fo:block></fo:table-cell>
										<fo:table-cell text-align="left">
											<fo:block>
												<xsl:value-of select="descripcion"/>&#160;
												<xsl:value-of select="tamanio"/>
												<xsl:if test="codigoRefenciaInterna != ''">
													<xsl:value-of select="codigoRefenciaInterna"/>&#160;
												</xsl:if>
												<xsl:value-of select="pesoAproximadoRecepcion"/>
											</fo:block>
										</fo:table-cell>
										<fo:table-cell text-align="left"><fo:block><xsl:value-of select="Iva"/></fo:block></fo:table-cell>
										<fo:table-cell text-align="right"><fo:block><xsl:value-of select="Uc"/></fo:block></fo:table-cell>
										<fo:table-cell text-align="right"><fo:block><xsl:value-of select='format-number(cantidadRecibida, $number-format)'/></fo:block></fo:table-cell>
										<fo:table-cell text-align="right"><fo:block><xsl:value-of select='format-number(costo, $decimal-format-items)'/></fo:block></fo:table-cell>
										<xsl:for-each select="valorDesceunto">
											<fo:table-cell text-align="right"><fo:block><xsl:value-of select="valor"/></fo:block></fo:table-cell>
										</xsl:for-each>	
										<fo:table-cell text-align="right"><fo:block><xsl:value-of select='format-number(costoTotal, $decimal-format-items)'/></fo:block></fo:table-cell>
										<fo:table-cell text-align="right"><fo:block><xsl:value-of select="ImpVerde"/></fo:block></fo:table-cell>
									</fo:table-row>
								</xsl:for-each>
							</fo:table-body>
						</fo:table> 
						<xsl:if test="lineNumber &gt; 15">
							<fo:table xsl:use-attribute-sets="table" break-after="page">
								<fo:table-column column-width="2.2cm"/>
								<fo:table-body>									
									<fo:table-row>
										<fo:table-cell text-align="left"><fo:block></fo:block></fo:table-cell>
									</fo:table-row>
								</fo:table-body>
							</fo:table> 
						</xsl:if>
				<!-- salto de pagina-->
						<fo:block>&#160;</fo:block>
						<!--  <fo:block text-align="left"> RECIBIDOR: <xsl:value-of select="cabecera/informacionFactura/recibidor"/></fo:block> -->
						 <fo:block text-align="left" font-weight="bold"> PRUEBAS MAX, IGNORE ESTO POR FAVOR </fo:block>
						<fo:table xsl:use-attribute-sets="table" >
							  <fo:table-column column-width="15.4cm" />
							  <fo:table-column column-width="6.8cm" />
							  <fo:table-body>	
							    <fo:table-row>	
									<fo:table-cell>
										<fo:block>
											<fo:table xsl:use-attribute-sets="table">
												<fo:table-column column-width="0.1mm" />
												<fo:table-column column-width="3.4cm" />
												<fo:table-column column-width="3.4cm" />
												<fo:table-column column-width="3.8cm" />
												<fo:table-column column-width="4.3cm" />
												<fo:table-column column-width="0.2cm" />
												<!--<fo:table-column column-width="50mm" />
												<fo:table-column column-width="25mm" />-->
												<fo:table-body>	
													<fo:table-row>	
														<fo:table-cell text-align="left" >
															<fo:block>_____________________________________________________________________________________________________________</fo:block>
														</fo:table-cell>
														<fo:table-cell text-align="left"><fo:block></fo:block></fo:table-cell>				
														<fo:table-cell text-align="left"><fo:block></fo:block></fo:table-cell>				
														<fo:table-cell text-align="left"><fo:block></fo:block></fo:table-cell>				
														<fo:table-cell text-align="left"><fo:block></fo:block></fo:table-cell>		
														<fo:table-cell text-align="left"><fo:block></fo:block></fo:table-cell>	
													</fo:table-row>	
													<fo:table-row>	
													  <fo:table-cell text-align="left"><fo:block></fo:block></fo:table-cell>				
													  <fo:table-cell text-align="left"><fo:block>| Recepcion:</fo:block></fo:table-cell>
													  <fo:table-cell text-align="left"><fo:block>| Proveedor:</fo:block></fo:table-cell>
													  <fo:table-cell text-align="left"><fo:block>| Proveedor:</fo:block></fo:table-cell>
													  <fo:table-cell text-align="left"><fo:block>| Proveedor:</fo:block></fo:table-cell>
													  <fo:table-cell text-align="left"><fo:block>|</fo:block></fo:table-cell>
													</fo:table-row>
													<fo:table-row>	
													  <fo:table-cell text-align="left"><fo:block></fo:block></fo:table-cell>				
													  <fo:table-cell text-align="left"><fo:block>|</fo:block></fo:table-cell>	
													  <fo:table-cell text-align="left"><fo:block>|</fo:block></fo:table-cell>
													  <fo:table-cell text-align="left"><fo:block>|</fo:block></fo:table-cell>
													  <fo:table-cell text-align="left"><fo:block>| Acepto las condiciones</fo:block></fo:table-cell>
													  <fo:table-cell text-align="left"><fo:block>|</fo:block></fo:table-cell>
													</fo:table-row>
													<fo:table-row>	
													  <fo:table-cell text-align="left"><fo:block></fo:block></fo:table-cell>				
													  <fo:table-cell text-align="left"><fo:block>|</fo:block></fo:table-cell>
													  <fo:table-cell text-align="left"><fo:block>|</fo:block></fo:table-cell>
													  <fo:table-cell text-align="left"><fo:block>|</fo:block></fo:table-cell>
													  <fo:table-cell text-align="left"><fo:block>| &#8226; Forma Pago: Transferencia</fo:block></fo:table-cell>
													  <fo:table-cell text-align="left"><fo:block>|</fo:block></fo:table-cell>
													</fo:table-row>
													<fo:table-row>	
													  <fo:table-cell text-align="left"><fo:block></fo:block></fo:table-cell>				
													  <fo:table-cell text-align="left"><fo:block>|</fo:block></fo:table-cell>							
													  <fo:table-cell text-align="left"><fo:block>|</fo:block></fo:table-cell>
													  <fo:table-cell text-align="left"><fo:block>|</fo:block></fo:table-cell>
													  <fo:table-cell text-align="left"><fo:block>| &#8226; Plazo Pago: <xsl:value-of select="cabecera/proveedor/plazoPago"/>-<xsl:value-of select="cabecera/proveedor/tipoPlazoPago"/></fo:block></fo:table-cell>
													  <fo:table-cell text-align="left"><fo:block>|</fo:block></fo:table-cell>
													</fo:table-row>
													<fo:table-row>
													  <fo:table-cell text-align="left"><fo:block></fo:block></fo:table-cell>				
													  <fo:table-cell text-align="left"><fo:block>|</fo:block></fo:table-cell>
													  <fo:table-cell text-align="left"><fo:block>|</fo:block></fo:table-cell>
													  <fo:table-cell text-align="left"><fo:block>|</fo:block></fo:table-cell>
													  <fo:table-cell text-align="left"><fo:block>|</fo:block></fo:table-cell>
													  <fo:table-cell text-align="left"><fo:block>|</fo:block></fo:table-cell>
													</fo:table-row>
													<fo:table-row>	
													  <fo:table-cell text-align="left"><fo:block></fo:block></fo:table-cell>				
													  <fo:table-cell text-align="left"><fo:block>|</fo:block></fo:table-cell>
													  <fo:table-cell text-align="left"><fo:block>|</fo:block></fo:table-cell>
													  <fo:table-cell text-align="left"><fo:block>|</fo:block></fo:table-cell>
													  <fo:table-cell text-align="left"><fo:block>|</fo:block></fo:table-cell>
													  <fo:table-cell text-align="left"><fo:block>|</fo:block></fo:table-cell>
													</fo:table-row>
													<fo:table-row>	
													  <fo:table-cell text-align="left"><fo:block></fo:block></fo:table-cell>				
													  <fo:table-cell text-align="left"><fo:block>|</fo:block></fo:table-cell>
													  <fo:table-cell text-align="left"><fo:block>|</fo:block></fo:table-cell>
													  <fo:table-cell text-align="left"><fo:block>|</fo:block></fo:table-cell>
													  <fo:table-cell text-align="left"><fo:block>|</fo:block></fo:table-cell>
													  <fo:table-cell text-align="left"><fo:block>|</fo:block></fo:table-cell>
													</fo:table-row>
													<fo:table-row>	
													  <fo:table-cell text-align="left"><fo:block></fo:block></fo:table-cell>				
													  <fo:table-cell text-align="left"><fo:block>|</fo:block></fo:table-cell>
													  <fo:table-cell text-align="left"><fo:block>|</fo:block></fo:table-cell>
													  <fo:table-cell text-align="left"><fo:block>|</fo:block></fo:table-cell>
													  <fo:table-cell text-align="left"><fo:block>|</fo:block></fo:table-cell>
													  <fo:table-cell text-align="left"><fo:block>|</fo:block></fo:table-cell>
													</fo:table-row>
													<fo:table-row>	
													  <fo:table-cell text-align="left"><fo:block></fo:block></fo:table-cell>				
													  <fo:table-cell text-align="left"><fo:block>| <xsl:value-of select="cabecera/informacionFactura/usuarioLogueado"/></fo:block></fo:table-cell> 
													  <fo:table-cell text-align="left"><fo:block>|</fo:block></fo:table-cell>
													  <fo:table-cell text-align="left"><fo:block>|    *** <xsl:value-of select="cabecera/proveedor/tipoPlazoPago"/>***</fo:block></fo:table-cell>
													  <fo:table-cell text-align="left"><fo:block>|</fo:block></fo:table-cell>
													  <fo:table-cell text-align="left"><fo:block>|</fo:block></fo:table-cell>
													</fo:table-row>
													<fo:table-row>	
													  <fo:table-cell text-align="left" >
														<fo:block>_____________________________________________________________________________________________________________</fo:block>
													  </fo:table-cell>				
													  <fo:table-cell text-align="left"><fo:block>|</fo:block></fo:table-cell> 
													  <fo:table-cell text-align="left"><fo:block>|</fo:block></fo:table-cell>
													  <fo:table-cell text-align="left"><fo:block>|</fo:block></fo:table-cell>
													  <fo:table-cell text-align="left"><fo:block>|</fo:block></fo:table-cell>
													  <fo:table-cell text-align="left"><fo:block>|</fo:block></fo:table-cell>
													</fo:table-row>
												</fo:table-body>		
											</fo:table>
										</fo:block>
									</fo:table-cell>
									<fo:table-cell>
										<fo:block>
											<fo:table xsl:use-attribute-sets="table">
												<fo:table-column column-width="4.2cm" />
												<fo:table-column column-width="2.0cm" />
												<fo:table-body>	
													<fo:table-row>	
														<fo:table-cell text-align="left"><fo:block>TOTAL FACTURADO&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;:</fo:block></fo:table-cell>		
														<fo:table-cell text-align="right"><fo:block><xsl:value-of  select='format-number(totales/facturado, $decimal-format-total)'/></fo:block></fo:table-cell>
													</fo:table-row>	
													<fo:table-row>
														<fo:table-cell text-align="left"><fo:block>TOTAL CON TARIFA CERO&#160;&#160;:</fo:block></fo:table-cell>											  
														<fo:table-cell text-align="right"><fo:block><xsl:value-of select='format-number(totales/tarifa0, $decimal-format-total)'/></fo:block></fo:table-cell>
													</fo:table-row>	
													<fo:table-row>	
													<fo:table-cell text-align="left"><fo:block>TOTAL CON TARIFA 12%&#160;&#160;&#160;&#160;&#160;:</fo:block></fo:table-cell>											  
													<fo:table-cell text-align="right"><fo:block><xsl:value-of select='format-number(totales/tarifa12, $decimal-format-total)'/></fo:block></fo:table-cell>
													</fo:table-row>	
													<fo:table-row>	
													<fo:table-cell text-align="left"><fo:block>12% VALOR I.V.A&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;:</fo:block></fo:table-cell>											  
													<fo:table-cell text-align="right"><fo:block><xsl:value-of select='format-number(totales/valorIva12, $decimal-format-total)'/></fo:block></fo:table-cell>
													</fo:table-row>	
													<fo:table-row>	
													<fo:table-cell text-align="left"><fo:block>TOTAL IMPUESTO VERDE&#160;&#160;&#160;:</fo:block></fo:table-cell>											  
													<fo:table-cell text-align="right"><fo:block><xsl:value-of select='format-number(totales/impuestoVerde, $decimal-format-total)'/></fo:block></fo:table-cell>
													</fo:table-row>	
													<fo:table-row>
														<fo:table-cell text-align="left"><fo:block>T O T A L&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;:</fo:block></fo:table-cell>											  
														<fo:table-cell text-align="right"><fo:block><xsl:value-of select="format-number(totales/totalRecibido, $decimal-format-total)"/></fo:block></fo:table-cell>
													</fo:table-row>
													
													<fo:table-row>
														<fo:table-cell>
															<fo:block> 
																<fo:table>
																	<fo:table-column column-width="7.3cm" />
																	<fo:table-body>	
																		<fo:table-row> 
																			<fo:table-cell text-align="left"><fo:block>SR. PROVEEDOR.-</fo:block></fo:table-cell>
																		</fo:table-row>
																		<fo:table-row> 
																			<fo:table-cell text-align="left"><fo:block>ESTE DOCUMENTO ES LA FACTURA DE RECEPCI&#211;N</fo:block></fo:table-cell>
																		</fo:table-row>
																		<fo:table-row> 
																			<fo:table-cell text-align="left"><fo:block>DE MERCADER&#205;A. CUALQUIER TRAMITE DE CON-</fo:block></fo:table-cell>
																		</fo:table-row>
																		<fo:table-row> 
																			<fo:table-cell text-align="left"><fo:block>SULTA O RECLAMO, FAVOR REALIZARLO CON EL</fo:block></fo:table-cell>
																		</fo:table-row>
																		<fo:table-row> 
																			<fo:table-cell text-align="left"><fo:block>N&#218;MERO DE ESTE DOCUMENTO(factura).</fo:block></fo:table-cell>
																		</fo:table-row>														
																	</fo:table-body>
																</fo:table>
															</fo:block>
														</fo:table-cell>
													</fo:table-row>
												</fo:table-body>													
											</fo:table>
										</fo:block>
									</fo:table-cell>
								</fo:table-row>	
							</fo:table-body>	
					</fo:table> 
						<fo:block>&#160;</fo:block>
						<fo:table xsl:use-attribute-sets="table" >
							<fo:table-column column-width="14.1cm" />
							<fo:table-column column-width="8.1cm" />
							<fo:table-body>	
								<fo:table-row> 
									<fo:table-cell> 
										<fo:block space-before.optimum="0pt" space-after.optimum="20pt">   <!--block de separacion entre detalle totales-->
											<fo:table xsl:use-attribute-sets="table">
												<fo:table-column column-width="2.6cm" />
												<fo:table-column column-width="2.9cm" />
												<fo:table-column column-width="2.9cm" />
												<fo:table-column column-width="2.8cm" />
												<fo:table-column column-width="2.9cm" />
												<fo:table-body>	
													<fo:table-row> 
													<fo:table-cell text-align="left"> <fo:block>FACTURA PROVEE</fo:block></fo:table-cell>
													<fo:table-cell text-align="right"> <fo:block>IMP.MERCANCIA</fo:block></fo:table-cell>
													<fo:table-cell text-align="right"> <fo:block>DESCUENTOS</fo:block></fo:table-cell>
													<fo:table-cell text-align="right"> <fo:block>IVA.</fo:block></fo:table-cell>
													<fo:table-cell text-align="right"> <fo:block>TOTAL FACTURA</fo:block></fo:table-cell>
													</fo:table-row> 
													<xsl:for-each select="facturaProveedor/factura">
														<fo:table-row>
															<fo:table-cell text-align="left"><fo:block><xsl:value-of select="numero"/></fo:block></fo:table-cell>
															<fo:table-cell text-align="right"><fo:block><xsl:value-of select="impuestoMercancia"/></fo:block></fo:table-cell>
															<fo:table-cell text-align="right"><fo:block><xsl:value-of select="descuento"/></fo:block></fo:table-cell>
															<fo:table-cell text-align="right"><fo:block><xsl:value-of select="iva"/></fo:block></fo:table-cell>
															<fo:table-cell text-align="right"><fo:block><xsl:value-of select="format-number(valorTotal, $decimal-format-total)"/></fo:block></fo:table-cell>
														</fo:table-row>
													</xsl:for-each> 													
												  </fo:table-body> 
											</fo:table>  
										</fo:block>
									</fo:table-cell>
									<fo:table-cell> 
										<fo:block>
											<fo:table xsl:use-attribute-sets="table" >
												<fo:table-column column-width="2.5cm" />
												<fo:table-column column-width="2.5cm" />
												<fo:table-column column-width="2.5cm" />
												<fo:table-body>	
													<fo:table-row> 
														<fo:table-cell text-align="right"> <fo:block>ORDEN COMPRA</fo:block></fo:table-cell>
														<fo:table-cell text-align="right"> <fo:block>VALOR</fo:block></fo:table-cell>
														<fo:table-cell text-align="right"> <fo:block>DIFERENCIA</fo:block></fo:table-cell>
													</fo:table-row> 
													<xsl:for-each select="ordenCompra/item">
														<fo:table-row>
															<fo:table-cell text-align="right"><fo:block><xsl:value-of select="numeroOrdenCompra"/></fo:block></fo:table-cell>
															<fo:table-cell text-align="right"><fo:block><xsl:value-of select="format-number(valorOrdenCompra, $decimal-format-total)"/></fo:block></fo:table-cell>
															
														</fo:table-row>
													</xsl:for-each> 
												</fo:table-body>
											</fo:table>													
										</fo:block>
									</fo:table-cell>
								</fo:table-row>
								<fo:table-row> 
									<fo:table-cell>
										<fo:block>
											<fo:table xsl:use-attribute-sets="table" >
												<fo:table-column column-width="2.6cm" />
												<fo:table-column column-width="2.9cm" />
												<fo:table-column column-width="2.9cm" />
												<fo:table-column column-width="2.8cm" />
												<fo:table-column column-width="2.9cm" />
												<fo:table-body>	
													<fo:table-row> 
														<fo:table-cell text-align="left"><fo:block font-weight="bold">TOTALES</fo:block></fo:table-cell>
														<fo:table-cell text-align="right"><fo:block font-weight="bold"><xsl:value-of select="format-number(facturaProveedor/totalImpuestoMercaderia, $decimal-format-total)"/></fo:block></fo:table-cell>
														<fo:table-cell text-align="right"><fo:block font-weight="bold"><xsl:value-of select="format-number(facturaProveedor/totalDescuento, $decimal-format-total)"/></fo:block></fo:table-cell>
														<fo:table-cell text-align="right"><fo:block font-weight="bold"><xsl:value-of select="format-number(facturaProveedor/totalIva, $decimal-format-total)"/></fo:block></fo:table-cell>
														<fo:table-cell text-align="right"><fo:block font-weight="bold"><xsl:value-of select="format-number(facturaProveedor/totalFacturado, $decimal-format-total)"/></fo:block></fo:table-cell>
													</fo:table-row> 
												</fo:table-body> 
											</fo:table> 
										</fo:block>
									</fo:table-cell>
									<fo:table-cell> 
										<fo:block>
											<fo:table xsl:use-attribute-sets="table" >
												<fo:table-column column-width="2.5cm" />
												<fo:table-column column-width="2.5cm" />
												<fo:table-column column-width="2.5cm" />
												<fo:table-body>	
													<fo:table-row> 
														<fo:table-cell text-align="right"><fo:block></fo:block></fo:table-cell>
														<fo:table-cell text-align="right" font-weight="bold"><fo:block><xsl:value-of select="format-number(valorTotalOrdenesCompra, $decimal-format-total)"/></fo:block></fo:table-cell>
														<fo:table-cell text-align="right" font-weight="bold"> <fo:block><xsl:value-of select="format-number(totales/diferencia, $decimal-format-total)"/></fo:block></fo:table-cell>
													</fo:table-row> 
												</fo:table-body>
											</fo:table>													
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
</xsl:stylesheet>