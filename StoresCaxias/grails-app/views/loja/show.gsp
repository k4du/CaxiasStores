
<%@ page import="storescaxias.Loja" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'loja.label', default: 'Loja')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-loja" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-loja" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list loja">
			
				<g:if test="${lojaInstance?.imagem}">
				<li class="fieldcontain">
					<span id="imagem-label" class="property-label"><g:message code="loja.imagem.label" default="Imagem" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${lojaInstance?.descricao}">
				<li class="fieldcontain">
					<span id="descricao-label" class="property-label"><g:message code="loja.descricao.label" default="Descricao" /></span>
					
						<span class="property-value" aria-labelledby="descricao-label"><g:fieldValue bean="${lojaInstance}" field="descricao"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${lojaInstance?.enderecos}">
				<li class="fieldcontain">
					<span id="enderecos-label" class="property-label"><g:message code="loja.enderecos.label" default="Enderecos" /></span>
					
						<g:each in="${lojaInstance.enderecos}" var="e">
						<span class="property-value" aria-labelledby="enderecos-label"><g:link controller="endereco" action="show" id="${e.id}">${e?.encodeAsHTML()}</g:link></span>
						</g:each>
					
				</li>
				</g:if>
			
				<g:if test="${lojaInstance?.nome}">
				<li class="fieldcontain">
					<span id="nome-label" class="property-label"><g:message code="loja.nome.label" default="Nome" /></span>
					
						<span class="property-value" aria-labelledby="nome-label"><g:fieldValue bean="${lojaInstance}" field="nome"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${lojaInstance?.produtos}">
				<li class="fieldcontain">
					<span id="produtos-label" class="property-label"><g:message code="loja.produtos.label" default="Produtos" /></span>
					
						<g:each in="${lojaInstance.produtos}" var="p">
						<span class="property-value" aria-labelledby="produtos-label"><g:link controller="produto" action="show" id="${p.id}">${p?.encodeAsHTML()}</g:link></span>
						</g:each>
					
				</li>
				</g:if>
			
				<g:if test="${lojaInstance?.ramo}">
				<li class="fieldcontain">
					<span id="ramo-label" class="property-label"><g:message code="loja.ramo.label" default="Ramo" /></span>
					
						<span class="property-value" aria-labelledby="ramo-label"><g:link controller="ramo" action="show" id="${lojaInstance?.ramo?.id}">${lojaInstance?.ramo?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${lojaInstance?.id}" />
					<g:link class="edit" action="edit" id="${lojaInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
