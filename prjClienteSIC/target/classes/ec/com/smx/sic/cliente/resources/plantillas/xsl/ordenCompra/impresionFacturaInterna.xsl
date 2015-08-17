<?xml version='1.0' encoding='ISO-8859-1'?>
<xsl:stylesheet version="1.1" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" 
xmlns:fo="http://www.w3.org/1999/XSL/Format" 
exclude-result-prefixes="fo">

	<!-- page size -->
	<xsl:param name="page-width">29.7cm</xsl:param>
	<xsl:param name="page-height">21.4cm</xsl:param>
		<xsl:param name="page-margin-top">3.7cm</xsl:param>
	<xsl:param name="page-margin-bottom">11.5cm</xsl:param> 
	<xsl:param name="page-margin-left">1cm</xsl:param>
	<xsl:param name="page-margin-right">1cm</xsl:param>
	<!-- page header and footer-->
	<xsl:param name="page-header-margin-top">0.5cm</xsl:param>
	<xsl:param name="page-footer-margin-bottom">1.5cm</xsl:param>
	<xsl:param name="font-family">Courier New, Courier, monospace</xsl:param>
	<xsl:param name="font-size">8pt</xsl:param>
	<xsl:param name="page-number-format">{total}</xsl:param>
	
	<!-- atribute  page footer -->
	<xsl:attribute-set name="page-footer">
		<xsl:attribute name="space-after.conditionality">retain</xsl:attribute>
		<xsl:attribute name="space-after"><xsl:value-of select="$page-footer-margin-bottom"/></xsl:attribute>			
		<xsl:attribute name="font-family"><xsl:value-of select="$font-family" /></xsl:attribute>
		<xsl:attribute name="font-size"><xsl:value-of select="$font-size" /></xsl:attribute>
		<!--<xsl:attribute name="text-align">center</xsl:attribute>-->
	</xsl:attribute-set>
	<!-- atribute  page header -->
	<xsl:attribute-set name="page-header">
		<xsl:attribute name="space-before.conditionality">retain</xsl:attribute>
		<xsl:attribute name="space-before"><xsl:value-of select="$page-header-margin-top"/></xsl:attribute>
		<xsl:attribute name="space-after"><xsl:value-of select="$page-footer-margin-bottom"/></xsl:attribute>
		<xsl:attribute name="font-family"><xsl:value-of select="$font-family" /></xsl:attribute>
		<xsl:attribute name="font-size"><xsl:value-of select="$font-size" /></xsl:attribute>
		<!-- <xsl:attribute name="border-style">solid</xsl:attribute> -->		
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
		<!--<xsl:attribute name="border-style">solid</xsl:attribute>	-->
	</xsl:attribute-set>
	
	<xsl:attribute-set name="block-decoration">
		<xsl:attribute name="line-height">9pt</xsl:attribute>	
    </xsl:attribute-set>
	
	<xsl:template match="Factura">
	<fo:root xmlns:fo="http://www.w3.org/1999/XSL/Format">
			<fo:layout-master-set>
				<fo:simple-page-master master-name="first" 
										page-width="{$page-width}" 
										page-height="{$page-height}"
										margin-left="{$page-margin-left}" 
										margin-right="{$page-margin-right}">
					<fo:region-body region-name="page-body" margin-top="{$page-margin-top}" margin-bottom="{$page-margin-bottom}"/>
                    <fo:region-before region-name="page-header" extent="{$page-margin-top}" />
                    <!--<fo:region-after region-name="page-footer" extent="{$page-margin-bottom}" />-->
				</fo:simple-page-master>
				<fo:simple-page-master master-name="last" 
										page-width="{$page-width}" 
										page-height="{$page-height}"
										margin-left="{$page-margin-left}" 
										margin-right="{$page-margin-right}">
					<fo:region-body region-name="page-body" margin-top="{$page-margin-top}" margin-bottom="{$page-margin-bottom}"/>
                    <fo:region-before region-name="page-header" extent="{$page-margin-top}" />
                    <fo:region-after region-name="page-footer" extent="{$page-margin-bottom}" />                    
				</fo:simple-page-master>
  
				<fo:page-sequence-master master-name="standard">
					 <fo:repeatable-page-master-reference master-reference="first" maximum-repeats= "0"/>
					 <fo:repeatable-page-master-reference master-reference="last" maximum-repeats= "0"/>
				</fo:page-sequence-master>  
			</fo:layout-master-set>
			<fo:page-sequence master-reference="standard" initial-page-number="0" force-page-count="no-force">					
				<fo:static-content flow-name="page-header">
				<fo:block xsl:use-attribute-sets="page-header">						
					<fo:table xsl:use-attribute-sets="table">
						<fo:table-column column-width="6.2cm"/>
						<fo:table-column column-width="7.2cm"/>
						<fo:table-column column-width="4.1cm"/>
						<fo:table-column column-width="2.5cm"/>
						<fo:table-column column-width="2.2cm"/>
						<fo:table-body>		
							<fo:table-row>	<!--FILA 1-->
							  <fo:table-cell text-align="left"><fo:block xsl:use-attribute-sets="block-decoration">Tda/Alm/CDI:</fo:block></fo:table-cell>									
							  <fo:table-cell text-align="left"><fo:block xsl:use-attribute-sets="block-decoration">Proveedor:</fo:block></fo:table-cell>							  
							  <fo:table-cell text-align="left"><fo:block xsl:use-attribute-sets="block-decoration"><xsl:value-of select="Cabecera/InfFac/fecha"/> 
												&#160; <xsl:value-of select="Cabecera/InfFac/Hora"/></fo:block></fo:table-cell>
								<fo:table-cell text-align="left"><fo:block xsl:use-attribute-sets="block-decoration"></fo:block></fo:table-cell>
								<fo:table-cell text-align="left"><fo:block xsl:use-attribute-sets="block-decoration"></fo:block></fo:table-cell>
							 </fo:table-row>									
							<fo:table-row>
							  <fo:table-cell text-align="left"><fo:block xsl:use-attribute-sets="block-decoration"><xsl:value-of select="Cabecera/Compania/CodCd"/></fo:block></fo:table-cell>
							  <fo:table-cell text-align="left"><fo:block xsl:use-attribute-sets="block-decoration"><xsl:value-of select="Cabecera/Proveedor/CodProv"/></fo:block></fo:table-cell>
							  <fo:table-cell text-align="left"><fo:block xsl:use-attribute-sets="block-decoration">====================================================</fo:block></fo:table-cell>							  
							  <fo:table-cell text-align="left"><fo:block xsl:use-attribute-sets="block-decoration"></fo:block></fo:table-cell>
							  <fo:table-cell text-align="left"><fo:block xsl:use-attribute-sets="block-decoration"></fo:block></fo:table-cell>
							</fo:table-row>									
							 <fo:table-row>								 
							  <fo:table-cell text-align="left"><fo:block xsl:use-attribute-sets="block-decoration"><xsl:value-of select="Cabecera/Compania/NomCom"/></fo:block></fo:table-cell>
							  <fo:table-cell text-align="left"><fo:block xsl:use-attribute-sets="block-decoration"><xsl:value-of select="Cabecera/Proveedor/NomProv"/></fo:block></fo:table-cell>
							  <fo:table-cell text-align="left"><fo:block xsl:use-attribute-sets="block-decoration">NOTA DE INGRESO DE </fo:block></fo:table-cell> <!-- MERCADERIA -->	
							  <fo:table-cell text-align="left"><fo:block xsl:use-attribute-sets="block-decoration">MERCADERIA</fo:block></fo:table-cell>
							  <fo:table-cell text-align="right"><fo:block xsl:use-attribute-sets="block-decoration"><xsl:value-of select="Cabecera/InfFac/NumFac"/></fo:block></fo:table-cell>							  							  
							</fo:table-row>
							<fo:table-row>	
							  <fo:table-cell text-align="left"><fo:block xsl:use-attribute-sets="block-decoration"><xsl:value-of select="Cabecera/Compania/DirCom"/></fo:block></fo:table-cell>
							  <fo:table-cell text-align="left"><fo:block xsl:use-attribute-sets="block-decoration"><xsl:value-of select="Cabecera/Proveedor/DirProv"/></fo:block></fo:table-cell>
							  <fo:table-cell text-align="left"><fo:block xsl:use-attribute-sets="block-decoration">====================================================</fo:block></fo:table-cell>
							  <fo:table-cell text-align="left"><fo:block xsl:use-attribute-sets="block-decoration"></fo:block></fo:table-cell>
							  <fo:table-cell text-align="left"><fo:block xsl:use-attribute-sets="block-decoration"></fo:block></fo:table-cell>
							</fo:table-row>								
							<fo:table-row>	
							  <fo:table-cell text-align="left"><fo:block xsl:use-attribute-sets="block-decoration">
									<fo:table xsl:use-attribute-sets="table"> 
									<fo:table-column column-width="3.7cm"/>
									<fo:table-column column-width="2.5cm"/>
										<fo:table-body>
											<fo:table-row>
												<fo:table-cell text-align="left"><fo:block xsl:use-attribute-sets="block-decoration">SANGOLQUI -ECUADOR</fo:block></fo:table-cell>
												<fo:table-cell text-align="left"><fo:block xsl:use-attribute-sets="block-decoration">PIC</fo:block></fo:table-cell>
											</fo:table-row>
										</fo:table-body>	
									</fo:table></fo:block></fo:table-cell>
							  <fo:table-cell text-align="left"><fo:block xsl:use-attribute-sets="block-decoration">
							  <fo:table xsl:use-attribute-sets="table"> 
									<fo:table-column column-width="4.3cm"/>
									<fo:table-column column-width="2.9cm"/>
										<fo:table-body>
											<fo:table-row>
												<fo:table-cell text-align="left"><fo:block xsl:use-attribute-sets="block-decoration">00000 QUITO</fo:block></fo:table-cell>
												<fo:table-cell text-align="left"><fo:block xsl:use-attribute-sets="block-decoration">PIC</fo:block></fo:table-cell>
											</fo:table-row>
										</fo:table-body>	
									</fo:table></fo:block></fo:table-cell>
							  <fo:table-cell text-align="left"><fo:block xsl:use-attribute-sets="block-decoration"></fo:block></fo:table-cell>
							  <fo:table-cell text-align="left"><fo:block xsl:use-attribute-sets="block-decoration">Factura:</fo:block></fo:table-cell>
							  <fo:table-cell text-align="right"><fo:block xsl:use-attribute-sets="block-decoration"><xsl:value-of select="Cabecera/InfFac/AgrFac"/></fo:block></fo:table-cell>
							</fo:table-row>
							<fo:table-row>
							  <fo:table-cell text-align="left"><fo:block xsl:use-attribute-sets="block-decoration"><xsl:value-of select="Cabecera/Compania/TelCom"/></fo:block></fo:table-cell>
							  <fo:table-cell text-align="left"><fo:block xsl:use-attribute-sets="block-decoration"><xsl:value-of select="Cabecera/Proveedor/TelProv"/></fo:block></fo:table-cell>
							  <fo:table-cell text-align="left"><fo:block xsl:use-attribute-sets="block-decoration"></fo:block></fo:table-cell>
							  <fo:table-cell text-align="left"><fo:block xsl:use-attribute-sets="block-decoration">Fecha Factura:</fo:block></fo:table-cell>
							  <fo:table-cell text-align="right"><fo:block xsl:use-attribute-sets="block-decoration"><xsl:value-of select="Cabecera/InfFac/FecFac"/></fo:block></fo:table-cell>							  
							</fo:table-row>	
							<fo:table-row> 
							  <fo:table-cell text-align="left"><fo:block xsl:use-attribute-sets="block-decoration">RUC:<xsl:value-of select="Cabecera/Compania/RucCom"/></fo:block></fo:table-cell>
							  <fo:table-cell text-align="left"><fo:block xsl:use-attribute-sets="block-decoration">
							   <fo:table xsl:use-attribute-sets="table"> 
									<fo:table-column column-width="6cm"/>
									<fo:table-column column-width="1.2cm"/>
										<fo:table-body>
											<fo:table-row>
												<fo:table-cell text-align="left"><fo:block xsl:use-attribute-sets="block-decoration">RUC:<xsl:value-of select="Cabecera/Proveedor/RucProv"/></fo:block></fo:table-cell>
												<fo:table-cell text-align="left" ><fo:block xsl:use-attribute-sets="block-decoration">Bod:</fo:block></fo:table-cell>
											</fo:table-row>
										</fo:table-body>	
									</fo:table>
							  </fo:block></fo:table-cell>							  
							  <fo:table-cell text-align="left"><fo:block xsl:use-attribute-sets="block-decoration">
									<xsl:value-of select="Cabecera/Bodega/CodBod"/> &#160;<xsl:value-of select="Cabecera/Bodega/NomBod"/></fo:block></fo:table-cell>-->
							  <fo:table-cell text-align="left"><fo:block xsl:use-attribute-sets="block-decoration">Fecha Recibo:</fo:block></fo:table-cell>							 
							  <fo:table-cell text-align="right"><fo:block xsl:use-attribute-sets="block-decoration"><xsl:value-of select="Cabecera/InfFac/FecRec"/></fo:block></fo:table-cell>							  
							</fo:table-row>	
						</fo:table-body>
					</fo:table>							
					<fo:block xsl:use-attribute-sets="block-decoration"></fo:block>		
					<fo:table xsl:use-attribute-sets="table"> 
						  <fo:table-column column-width="2.3cm"/>
						  <fo:table-column column-width="0.7cm"/>
						  <fo:table-column column-width="4.2cm"/>
						  <fo:table-column column-width="0.8cm"/>
						  <fo:table-column column-width="1.0cm"/>
						  <fo:table-column column-width="1.6cm"/>								
						  <fo:table-column column-width="2.0cm"/>
						  <fo:table-column column-width="0.9cm"/>
						  <fo:table-column column-width="0.9cm"/>
						  <fo:table-column column-width="0.9cm"/>
						  <fo:table-column column-width="0.9cm"/>
						  <fo:table-column column-width="0.9cm"/>
						  <fo:table-column column-width="0.9cm"/>
						  <fo:table-column column-width="0.9cm"/>
						  <fo:table-column column-width="2.3cm"/>
						  <fo:table-column column-width="0.9cm"/>
						  
						<fo:table-body>
						  <fo:table-row>
							<fo:table-cell text-align="left" display-align="after"><fo:block xsl:use-attribute-sets="block-decoration">Codigo Barras</fo:block></fo:table-cell>			<!--   -->							
							<fo:table-cell text-align="left" display-align="after"><fo:block xsl:use-attribute-sets="block-decoration">DP</fo:block></fo:table-cell>
							<fo:table-cell text-align="left" display-align="after"><fo:block xsl:use-attribute-sets="block-decoration">Descripcion - Tamano</fo:block></fo:table-cell>
							<fo:table-cell text-align="left" display-align="after"><fo:block xsl:use-attribute-sets="block-decoration">IVA </fo:block></fo:table-cell>
							<fo:table-cell text-align="right" display-align="after"><fo:block xsl:use-attribute-sets="block-decoration">x UC</fo:block></fo:table-cell>											
							<fo:table-cell text-align="left"><fo:block xsl:use-attribute-sets="block-decoration">Pzas Recib</fo:block></fo:table-cell>
							<fo:table-cell text-align="center"><fo:block xsl:use-attribute-sets="block-decoration">Cantidad Costo Bruto</fo:block></fo:table-cell>
							<fo:table-cell text-align="center" display-align="after"><fo:block xsl:use-attribute-sets="block-decoration">DxUC</fo:block></fo:table-cell>
							<fo:table-cell text-align="center" display-align="after"><fo:block xsl:use-attribute-sets="block-decoration">Des-1</fo:block></fo:table-cell>
							<fo:table-cell text-align="center" display-align="after"><fo:block xsl:use-attribute-sets="block-decoration">Des-2</fo:block></fo:table-cell>
							<fo:table-cell text-align="center" display-align="after"><fo:block xsl:use-attribute-sets="block-decoration">DxTra</fo:block></fo:table-cell>
							<fo:table-cell text-align="center" display-align="after"><fo:block xsl:use-attribute-sets="block-decoration">Des-4</fo:block></fo:table-cell>
							<fo:table-cell text-align="center" display-align="after"><fo:block xsl:use-attribute-sets="block-decoration">Des-T</fo:block></fo:table-cell>
							<fo:table-cell text-align="center" display-align="after"><fo:block xsl:use-attribute-sets="block-decoration">Des-P</fo:block></fo:table-cell>
							<fo:table-cell text-align="center" display-align="after"><fo:block xsl:use-attribute-sets="block-decoration">Costo Total</fo:block></fo:table-cell>
							<fo:table-cell text-align="center" display-align="after"><fo:block xsl:use-attribute-sets="block-decoration">I.Ver</fo:block></fo:table-cell>
						  </fo:table-row>						  
						</fo:table-body>
					</fo:table>
				</fo:block>
			</fo:static-content>
					
			<fo:static-content flow-name="page-footer">   <!--Pie de Pagina-->
			       <fo:block xsl:use-attribute-sets="page-footer">
					<fo:block text-align="left"> RECIBIDOR: <xsl:value-of select="Cabecera/InfFac/Recibidor"/></fo:block> 
					<fo:table xsl:use-attribute-sets="table">
							  <fo:table-column column-width="15.4cm" />
							  <fo:table-column column-width="6.8cm" />
							  <fo:table-body>	
							    <fo:table-row>	
									<fo:table-cell>
										<fo:block xsl:use-attribute-sets="block-decoration">
										<fo:table xsl:use-attribute-sets="table">
													<fo:table-column column-width="0.1mm" />
													<fo:table-column column-width="3.4cm" />
													<fo:table-column column-width="3.4cm" />
													<fo:table-column column-width="3.8cm" />
													<fo:table-column column-width="4.5cm" />
													<fo:table-column column-width="0.2cm" />
													<!--<fo:table-column column-width="50mm" />
													<fo:table-column column-width="25mm" />-->
													<fo:table-body>	
														<fo:table-row>	
														  <fo:table-cell text-align="left" >
															<fo:block xsl:use-attribute-sets="block-decoration">________________________________________________________________________________________</fo:block>
														  </fo:table-cell>
														  <fo:table-cell text-align="left"><fo:block xsl:use-attribute-sets="block-decoration"></fo:block></fo:table-cell>				
														  <fo:table-cell text-align="left"><fo:block xsl:use-attribute-sets="block-decoration"></fo:block></fo:table-cell>				
														  <fo:table-cell text-align="left"><fo:block xsl:use-attribute-sets="block-decoration"></fo:block></fo:table-cell>				
														  <fo:table-cell text-align="left"><fo:block xsl:use-attribute-sets="block-decoration"></fo:block></fo:table-cell>		
														  <fo:table-cell text-align="left"><fo:block xsl:use-attribute-sets="block-decoration"></fo:block></fo:table-cell>	
													    </fo:table-row>	
														<fo:table-row>	
														  <fo:table-cell text-align="left"><fo:block xsl:use-attribute-sets="block-decoration"></fo:block></fo:table-cell>				
														  <fo:table-cell text-align="left"><fo:block xsl:use-attribute-sets="block-decoration">! Recepcion:</fo:block></fo:table-cell>									
														  <fo:table-cell text-align="left"><fo:block xsl:use-attribute-sets="block-decoration">! Proveedor:</fo:block></fo:table-cell>
														  <fo:table-cell text-align="left"><fo:block xsl:use-attribute-sets="block-decoration">! Proveedor:</fo:block></fo:table-cell>
														  <fo:table-cell text-align="left"><fo:block xsl:use-attribute-sets="block-decoration">! Proveedor:</fo:block></fo:table-cell>
														  <fo:table-cell text-align="left"><fo:block xsl:use-attribute-sets="block-decoration">!</fo:block></fo:table-cell>

														  
														  
														</fo:table-row>
														<fo:table-row>	
														  <fo:table-cell text-align="left"><fo:block xsl:use-attribute-sets="block-decoration"></fo:block></fo:table-cell>				
														  <fo:table-cell text-align="left"><fo:block xsl:use-attribute-sets="block-decoration">!</fo:block></fo:table-cell>									
														  <fo:table-cell text-align="left"><fo:block xsl:use-attribute-sets="block-decoration">!</fo:block></fo:table-cell>
														  <fo:table-cell text-align="left"><fo:block xsl:use-attribute-sets="block-decoration">!</fo:block></fo:table-cell>
														  <fo:table-cell text-align="left"><fo:block xsl:use-attribute-sets="block-decoration">! Acepto las condiciones</fo:block></fo:table-cell>
														  <fo:table-cell text-align="left"><fo:block xsl:use-attribute-sets="block-decoration">!</fo:block></fo:table-cell>
														  
														</fo:table-row>
														<fo:table-row>	
														  <fo:table-cell text-align="left"><fo:block xsl:use-attribute-sets="block-decoration"></fo:block></fo:table-cell>				
														  <fo:table-cell text-align="left"><fo:block xsl:use-attribute-sets="block-decoration">!</fo:block></fo:table-cell>									
														  <fo:table-cell text-align="left"><fo:block xsl:use-attribute-sets="block-decoration">!</fo:block></fo:table-cell>
														  <fo:table-cell text-align="left"><fo:block xsl:use-attribute-sets="block-decoration">!</fo:block></fo:table-cell>
														  <fo:table-cell text-align="left"><fo:block xsl:use-attribute-sets="block-decoration">! - Forma Pago:</fo:block></fo:table-cell>
														  <fo:table-cell text-align="left"><fo:block xsl:use-attribute-sets="block-decoration">!</fo:block></fo:table-cell>
														  
														</fo:table-row>
														<fo:table-row>	
														  <fo:table-cell text-align="left"><fo:block xsl:use-attribute-sets="block-decoration"></fo:block></fo:table-cell>				
														  <fo:table-cell text-align="left" ><fo:block xsl:use-attribute-sets="block-decoration">!</fo:block></fo:table-cell>									
														  <fo:table-cell text-align="left"><fo:block xsl:use-attribute-sets="block-decoration">!</fo:block></fo:table-cell>
														  <fo:table-cell text-align="left"><fo:block xsl:use-attribute-sets="block-decoration">!</fo:block></fo:table-cell>
														  <fo:table-cell text-align="left"><fo:block xsl:use-attribute-sets="block-decoration">! - Plazo Pago:</fo:block></fo:table-cell>
														  <fo:table-cell text-align="left"><fo:block xsl:use-attribute-sets="block-decoration">!</fo:block></fo:table-cell>
														  
														</fo:table-row>
														<fo:table-row>
														  <fo:table-cell text-align="left"><fo:block xsl:use-attribute-sets="block-decoration"></fo:block></fo:table-cell>				
														  <fo:table-cell text-align="left"><fo:block xsl:use-attribute-sets="block-decoration">!</fo:block></fo:table-cell>									
														  <fo:table-cell text-align="left"><fo:block xsl:use-attribute-sets="block-decoration">!</fo:block></fo:table-cell>
														  <fo:table-cell text-align="left"><fo:block xsl:use-attribute-sets="block-decoration">!</fo:block></fo:table-cell>
														  <fo:table-cell text-align="left"><fo:block xsl:use-attribute-sets="block-decoration">! - Pago Flete:</fo:block></fo:table-cell>
														  <fo:table-cell text-align="left"><fo:block xsl:use-attribute-sets="block-decoration">!</fo:block></fo:table-cell>
														  
														</fo:table-row>
														<fo:table-row>	
														  <fo:table-cell text-align="left"><fo:block xsl:use-attribute-sets="block-decoration"></fo:block></fo:table-cell>				
														  <fo:table-cell text-align="left" ><fo:block xsl:use-attribute-sets="block-decoration">!</fo:block></fo:table-cell>									
														  <fo:table-cell text-align="left"><fo:block xsl:use-attribute-sets="block-decoration">!</fo:block></fo:table-cell>
														  <fo:table-cell text-align="left"><fo:block xsl:use-attribute-sets="block-decoration">!</fo:block></fo:table-cell>
														  <fo:table-cell text-align="left"><fo:block xsl:use-attribute-sets="block-decoration">! - Desc.PP1:</fo:block></fo:table-cell>
														  <fo:table-cell text-align="left"><fo:block xsl:use-attribute-sets="block-decoration">!</fo:block></fo:table-cell>
														 
														</fo:table-row>
														<fo:table-row>	
														  <fo:table-cell text-align="left"><fo:block xsl:use-attribute-sets="block-decoration"></fo:block></fo:table-cell>				
														  <fo:table-cell text-align="left" ><fo:block xsl:use-attribute-sets="block-decoration">!</fo:block></fo:table-cell>									
														  <fo:table-cell text-align="left"><fo:block xsl:use-attribute-sets="block-decoration">!</fo:block></fo:table-cell>
														  <fo:table-cell text-align="left"><fo:block xsl:use-attribute-sets="block-decoration">!</fo:block></fo:table-cell>
														  <fo:table-cell text-align="left"><fo:block xsl:use-attribute-sets="block-decoration">! - Desc Globa:</fo:block></fo:table-cell>
														  <fo:table-cell text-align="left"><fo:block xsl:use-attribute-sets="block-decoration">!</fo:block></fo:table-cell>
														  
														</fo:table-row>
														<fo:table-row>	
														  <fo:table-cell text-align="left"><fo:block xsl:use-attribute-sets="block-decoration"></fo:block></fo:table-cell>				
														  <fo:table-cell text-align="left" ><fo:block xsl:use-attribute-sets="block-decoration">!</fo:block></fo:table-cell>									
														  <fo:table-cell text-align="left"><fo:block xsl:use-attribute-sets="block-decoration">!</fo:block></fo:table-cell>
														  <fo:table-cell text-align="left"><fo:block xsl:use-attribute-sets="block-decoration">!</fo:block></fo:table-cell>
														  <fo:table-cell text-align="left"><fo:block xsl:use-attribute-sets="block-decoration">! - Desc Publ:</fo:block></fo:table-cell>
														  <fo:table-cell text-align="left"><fo:block xsl:use-attribute-sets="block-decoration">!</fo:block></fo:table-cell>
														  
														</fo:table-row>
														<fo:table-row>	
														  <fo:table-cell text-align="left"><fo:block xsl:use-attribute-sets="block-decoration"></fo:block></fo:table-cell>				
														  <fo:table-cell text-align="left"><fo:block xsl:use-attribute-sets="block-decoration">! <xsl:value-of select="Cabecera/InfFac/Recibidor"/></fo:block></fo:table-cell> 
														  <fo:table-cell text-align="left"><fo:block xsl:use-attribute-sets="block-decoration">!</fo:block></fo:table-cell>
														  <fo:table-cell text-align="left"><fo:block xsl:use-attribute-sets="block-decoration">!    *** <xsl:value-of select="Cabecera/Proveedor/PlaPagProv"/>***</fo:block></fo:table-cell>
														  <fo:table-cell text-align="left"><fo:block xsl:use-attribute-sets="block-decoration">!</fo:block></fo:table-cell>
														  <fo:table-cell text-align="left"><fo:block xsl:use-attribute-sets="block-decoration">!</fo:block></fo:table-cell>
														  
														</fo:table-row>
														<fo:table-row>	
														  <fo:table-cell text-align="left" >
															<fo:block xsl:use-attribute-sets="block-decoration">________________________________________________________________________________________</fo:block>
														  </fo:table-cell>				
														  <fo:table-cell text-align="left"><fo:block xsl:use-attribute-sets="block-decoration">!</fo:block></fo:table-cell> 
														  <fo:table-cell text-align="left"><fo:block xsl:use-attribute-sets="block-decoration">!</fo:block></fo:table-cell>
														  <fo:table-cell text-align="left"><fo:block xsl:use-attribute-sets="block-decoration">!</fo:block></fo:table-cell>
														  <fo:table-cell text-align="left"><fo:block xsl:use-attribute-sets="block-decoration">!</fo:block></fo:table-cell>
														  <fo:table-cell text-align="left"><fo:block xsl:use-attribute-sets="block-decoration">!</fo:block></fo:table-cell>
														  
														</fo:table-row>
													</fo:table-body>		
											</fo:table>
										</fo:block>
									</fo:table-cell>
									<fo:table-cell>
									<fo:block xsl:use-attribute-sets="block-decoration">
											<fo:table xsl:use-attribute-sets="table">
												<fo:table-column column-width="4.2cm" />
												<fo:table-column column-width="2.6cm" />
												<fo:table-body>	
													<fo:table-row>	
														<fo:table-cell text-align="left"><fo:block xsl:use-attribute-sets="block-decoration">&#160;&#160;TOTAL FACTURADO&#160;&#160;&#160;&#160;&#160;&#160;:</fo:block></fo:table-cell>		
														<fo:table-cell text-align="right"><fo:block xsl:use-attribute-sets="block-decoration"><xsl:value-of select="Totales/ValTotFac"/></fo:block></fo:table-cell>
													</fo:table-row>	
													<fo:table-row>
														<fo:table-cell text-align="left"><fo:block xsl:use-attribute-sets="block-decoration">&#160;&#160;TOTAL CON TARIFA CERO:</fo:block></fo:table-cell>											  
														<fo:table-cell text-align="right"><fo:block xsl:use-attribute-sets="block-decoration"><xsl:value-of select="Totales/ValTotTarO"/></fo:block></fo:table-cell>
													</fo:table-row>	
													<fo:table-row>	
													<fo:table-cell text-align="left"><fo:block xsl:use-attribute-sets="block-decoration">&#160;&#160;TOTAL CON TARIFA 12% :</fo:block></fo:table-cell>											  
													<fo:table-cell text-align="right"><fo:block xsl:use-attribute-sets="block-decoration"><xsl:value-of select="Totales/ValTotTar12"/></fo:block></fo:table-cell>
													</fo:table-row>	
													<fo:table-row>	
													<fo:table-cell text-align="left"><fo:block xsl:use-attribute-sets="block-decoration">&#160;&#160;12 % VALOR I.V.A.&#160;&#160;&#160;&#160;:</fo:block></fo:table-cell>											  
													<fo:table-cell text-align="right"><fo:block xsl:use-attribute-sets="block-decoration"><xsl:value-of select="Totales/ValIva"/></fo:block></fo:table-cell>
													</fo:table-row>	
													<fo:table-row>	
													<fo:table-cell text-align="left"><fo:block xsl:use-attribute-sets="block-decoration">&#160;&#160;TOTAL IMPUESTO VERDE :</fo:block></fo:table-cell>											  
													<fo:table-cell text-align="right"><fo:block xsl:use-attribute-sets="block-decoration"><xsl:value-of select="Totales/ValTotImpVer"/></fo:block></fo:table-cell>
													</fo:table-row>	
													<fo:table-row>
														<fo:table-cell text-align="left"><fo:block xsl:use-attribute-sets="block-decoration">&#160;&#160;T O T A L&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;:</fo:block></fo:table-cell>											  
														  <fo:table-cell text-align="right"><fo:block xsl:use-attribute-sets="block-decoration"><xsl:value-of select="Totales/ValTot"/></fo:block></fo:table-cell>
													</fo:table-row>
													
													<fo:table-row>
														<fo:table-cell><fo:block xsl:use-attribute-sets="block-decoration"> 
																<fo:table xsl:use-attribute-sets="table" >
																	<fo:table-column column-width="6.8cm" />
																	<fo:table-body>	
																	<fo:table-row> 
																		<fo:table-cell text-align="left">><fo:block xsl:use-attribute-sets="block-decoration">SR. PROVEEDOR.-</fo:block></fo:table-cell>
																	</fo:table-row>
																	<fo:table-row> 
																		<fo:table-cell text-align="left">><fo:block xsl:use-attribute-sets="block-decoration">ESTE DOCUMENTO ES LA FACTURA DE RECEPCIO</fo:block></fo:table-cell>
																	</fo:table-row>
																	<fo:table-row> 
																		<fo:table-cell text-align="left">><fo:block xsl:use-attribute-sets="block-decoration">DE MERCADERIA. CUALQUIER TRAMITE DE CON-</fo:block></fo:table-cell>
																	</fo:table-row>
																	<fo:table-row> 
																		<fo:table-cell text-align="left">><fo:block xsl:use-attribute-sets="block-decoration">SULTA O RECLAMO, FAVOR REALIZARLO CON EL</fo:block></fo:table-cell>
																	</fo:table-row>
																	<fo:table-row> 
																		<fo:table-cell text-align="left">><fo:block xsl:use-attribute-sets="block-decoration">NUMERO DE ESTE DOCUMENTO.(factura:)</fo:block></fo:table-cell>
																	</fo:table-row>														
																	</fo:table-body>
																</fo:table>
														</fo:block></fo:table-cell>
													</fo:table-row>
												</fo:table-body>													
											</fo:table>
										</fo:block>
									</fo:table-cell>
								</fo:table-row>	
							</fo:table-body>	
					</fo:table> 
					<fo:block xsl:use-attribute-sets="block-decoration">&#160;</fo:block>
					
					<fo:table xsl:use-attribute-sets="table" >
								<fo:table-column column-width="14.1cm" />
								<fo:table-column column-width="8.1cm" />
								<fo:table-body>	
									<fo:table-row> 
									  <fo:table-cell> <fo:block space-before.optimum="0pt" space-after.optimum="20pt">   <!--block de separacion entre detalle totales-->
											<fo:table xsl:use-attribute-sets="table" >
												<fo:table-column column-width="2.6cm" />
												<fo:table-column column-width="2.9cm" />
												<fo:table-column column-width="2.9cm" />
												<fo:table-column column-width="2.8cm" />
												<fo:table-column column-width="2.9cm" />
												<fo:table-body>	
													<fo:table-row> 
													<fo:table-cell text-align="left"> <fo:block xsl:use-attribute-sets="block-decoration">FACTURA PROVEE</fo:block></fo:table-cell>
													<fo:table-cell text-align="right"> <fo:block xsl:use-attribute-sets="block-decoration">IMP.MERCANCIA</fo:block></fo:table-cell>
													<fo:table-cell text-align="right"> <fo:block xsl:use-attribute-sets="block-decoration">DESCUENTOS</fo:block></fo:table-cell>
													<fo:table-cell text-align="right"> <fo:block xsl:use-attribute-sets="block-decoration">IVA.</fo:block></fo:table-cell>
													<fo:table-cell text-align="right"> <fo:block xsl:use-attribute-sets="block-decoration">TOTAL FACTURA</fo:block></fo:table-cell>
													</fo:table-row> 
													<xsl:for-each select="FacProv/Item">
														<fo:table-row>
															<fo:table-cell text-align="left"><fo:block xsl:use-attribute-sets="block-decoration"><xsl:value-of select="NumFacProv"/></fo:block></fo:table-cell>
															<fo:table-cell text-align="right"><fo:block xsl:use-attribute-sets="block-decoration"><xsl:value-of select="ImpMercancia"/></fo:block></fo:table-cell>
															<fo:table-cell text-align="right"><fo:block xsl:use-attribute-sets="block-decoration"><xsl:value-of select="Des"/></fo:block></fo:table-cell>
															<fo:table-cell text-align="right"><fo:block xsl:use-attribute-sets="block-decoration"><xsl:value-of select="Iva"/></fo:block></fo:table-cell>
															<fo:table-cell text-align="right"><fo:block xsl:use-attribute-sets="block-decoration"><xsl:value-of select="ValTotFac"/></fo:block></fo:table-cell>
														</fo:table-row>
													</xsl:for-each> 													
												  </fo:table-body> 
												</fo:table>  
									  </fo:block></fo:table-cell>
									  <fo:table-cell> <fo:block xsl:use-attribute-sets="block-decoration">
												<fo:table xsl:use-attribute-sets="table" >
													<fo:table-column column-width="2.5cm" />
													<fo:table-column column-width="2.9cm" />
													<fo:table-column column-width="2.7cm" />
													<fo:table-body>	
														<fo:table-row> 
														  <fo:table-cell text-align="right"> <fo:block xsl:use-attribute-sets="block-decoration">ORD.COMPRA</fo:block></fo:table-cell>
														  <fo:table-cell text-align="right"> <fo:block xsl:use-attribute-sets="block-decoration">VALOR</fo:block></fo:table-cell>
														  <fo:table-cell text-align="right"> <fo:block xsl:use-attribute-sets="block-decoration">DIFERENCI</fo:block></fo:table-cell>
														</fo:table-row> 
													<xsl:for-each select="OrdComPrv/Item">
													<fo:table-row>
															<fo:table-cell text-align="right"><fo:block xsl:use-attribute-sets="block-decoration"><xsl:value-of select="NumOrdComProv"/></fo:block></fo:table-cell>
															<fo:table-cell text-align="right"><fo:block xsl:use-attribute-sets="block-decoration"><xsl:value-of select="ValTotOrdCom"/></fo:block></fo:table-cell>
															<fo:table-cell text-align="right"><fo:block xsl:use-attribute-sets="block-decoration">0.0</fo:block></fo:table-cell>
													</fo:table-row>
													</xsl:for-each> 
													</fo:table-body>
												</fo:table>													
									  </fo:block></fo:table-cell>
									</fo:table-row>
									<fo:table-row> 
									  <fo:table-cell><fo:block xsl:use-attribute-sets="block-decoration">
									  <fo:table xsl:use-attribute-sets="table" >
												<fo:table-column column-width="2.6cm" />
												<fo:table-column column-width="2.9cm" />
												<fo:table-column column-width="2.9cm" />
												<fo:table-column column-width="2.8cm" />
												<fo:table-column column-width="2.9cm" />
												<fo:table-body>	
													<fo:table-row> 
													<fo:table-cell text-align="left"> <fo:block xsl:use-attribute-sets="block-decoration">TOTALES</fo:block></fo:table-cell>
														<fo:table-cell text-align="right"><fo:block xsl:use-attribute-sets="block-decoration"><xsl:value-of select="FacProv/ValTotImpMer"/></fo:block></fo:table-cell>
														<fo:table-cell text-align="right"><fo:block xsl:use-attribute-sets="block-decoration"><xsl:value-of select="FacProv/ValTotIvaFacProv"/></fo:block></fo:table-cell>
														<fo:table-cell text-align="right"><fo:block xsl:use-attribute-sets="block-decoration"><xsl:value-of select="FacProv/ValTotDetFacProv"/></fo:block></fo:table-cell>
														<fo:table-cell text-align="right"><fo:block xsl:use-attribute-sets="block-decoration"></fo:block></fo:table-cell>
													</fo:table-row> 
												  </fo:table-body> 
												</fo:table> 
									  </fo:block></fo:table-cell>
									  <fo:table-cell> <fo:block xsl:use-attribute-sets="block-decoration">
												<fo:table xsl:use-attribute-sets="table" >
													<fo:table-column column-width="2.5cm" />
													<fo:table-column column-width="2.9cm" />
													<fo:table-column column-width="2.7cm" />
													<fo:table-body>	
														<fo:table-row> 
														  <fo:table-cell text-align="right"> <fo:block xsl:use-attribute-sets="block-decoration"></fo:block></fo:table-cell>
														  <fo:table-cell text-align="right"><fo:block xsl:use-attribute-sets="block-decoration"><xsl:value-of select="OrdComPrv/ValTotalOrdCom"/></fo:block></fo:table-cell>
														  <fo:table-cell text-align="right"> <fo:block xsl:use-attribute-sets="block-decoration"><xsl:value-of select="Totales/ValDif"/></fo:block></fo:table-cell>
														</fo:table-row> 
													</fo:table-body>
												</fo:table>													
									  </fo:block></fo:table-cell>	
									  
									</fo:table-row>   
								</fo:table-body>	
					</fo:table	>	
						
				</fo:block>	 	 
			</fo:static-content>					
				<fo:flow flow-name="page-body">
						<fo:block xsl:use-attribute-sets="body">							
							<fo:table xsl:use-attribute-sets="table">
							  <fo:table-column column-width="2.3cm"/>
							  <fo:table-column column-width="0.7cm"/>
							  <fo:table-column column-width="4.2cm"/>
							  <fo:table-column column-width="0.8cm"/>
							  <fo:table-column column-width="1.0cm"/>
							  <fo:table-column column-width="1.6cm"/>								
							  <fo:table-column column-width="2.0cm"/>
							  <fo:table-column column-width="0.9cm"/>
							  <fo:table-column column-width="0.9cm"/>
							  <fo:table-column column-width="0.9cm"/>
							  <fo:table-column column-width="0.9cm"/>
							  <fo:table-column column-width="0.9cm"/>
							  <fo:table-column column-width="0.9cm"/>
							  <fo:table-column column-width="0.9cm"/>
							  <fo:table-column column-width="2.3cm"/>
							  <fo:table-column column-width="0.9cm"/>
							
								<fo:table-body>									
									<fo:table-row><fo:table-cell text-align="center"><fo:block xsl:use-attribute-sets="block-decoration"></fo:block></fo:table-cell></fo:table-row>
									<xsl:for-each select="detalles/articulo">
										<fo:table-row>
											<fo:table-cell text-align="left"><fo:block xsl:use-attribute-sets="block-decoration"><xsl:value-of select="codBar"/></fo:block></fo:table-cell>
											<fo:table-cell text-align="left"><fo:block xsl:use-attribute-sets="block-decoration"><xsl:value-of select="Dp"/></fo:block></fo:table-cell>
											<fo:table-cell text-align="left"><fo:block xsl:use-attribute-sets="block-decoration"><xsl:value-of select="DesArt"/></fo:block></fo:table-cell>
											<!-- <fo:table-cell text-align="left"><fo:block xsl:use-attribute-sets="block-decoration"><xsl:value-of select="DesArt"/>&#160;<xsl:value-of select="TamArt"/></fo:block></fo:table-cell> -->
											<fo:table-cell text-align="right"><fo:block xsl:use-attribute-sets="block-decoration"><xsl:value-of select="Iva"/></fo:block></fo:table-cell>
											<fo:table-cell text-align="right"><fo:block xsl:use-attribute-sets="block-decoration"><xsl:value-of select="Uc"/></fo:block></fo:table-cell>
											<fo:table-cell text-align="right"><fo:block xsl:use-attribute-sets="block-decoration"><xsl:value-of select="CanArt"/></fo:block></fo:table-cell>
											<fo:table-cell text-align="right"><fo:block xsl:use-attribute-sets="block-decoration"><xsl:value-of select="descuento1"/></fo:block></fo:table-cell>
											<fo:table-cell text-align="right"><fo:block xsl:use-attribute-sets="block-decoration"><xsl:value-of select="descuento2"/></fo:block></fo:table-cell>
											<fo:table-cell text-align="right"><fo:block xsl:use-attribute-sets="block-decoration"><xsl:value-of select="descuento3"/></fo:block></fo:table-cell>
											<fo:table-cell text-align="right"><fo:block xsl:use-attribute-sets="block-decoration"><xsl:value-of select="descuento4"/></fo:block></fo:table-cell>
											<fo:table-cell text-align="right"><fo:block xsl:use-attribute-sets="block-decoration"><xsl:value-of select="descuento5"/></fo:block></fo:table-cell>
											<fo:table-cell text-align="right"><fo:block xsl:use-attribute-sets="block-decoration"></fo:block></fo:table-cell>
											<fo:table-cell text-align="right"><fo:block xsl:use-attribute-sets="block-decoration"></fo:block></fo:table-cell>
											<fo:table-cell text-align="right"><fo:block xsl:use-attribute-sets="block-decoration"></fo:block></fo:table-cell>
											<fo:table-cell text-align="right"><fo:block xsl:use-attribute-sets="block-decoration"><xsl:value-of select="CosTotArt"/></fo:block></fo:table-cell>
											<fo:table-cell text-align="right"><fo:block xsl:use-attribute-sets="block-decoration"></fo:block></fo:table-cell>
										</fo:table-row>
									</xsl:for-each>
								</fo:table-body>
							</fo:table> 
							<fo:block id="last-page"/>							
						</fo:block>
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