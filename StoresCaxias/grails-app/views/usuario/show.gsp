

<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'usuario.label', default: 'Usuario')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-usuario" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-usuario" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list usuario">
			
				<g:if test="${usuarioInstance?.email}">
				<li class="fieldcontain">
					<span id="email-label" class="property-label"><g:message code="usuario.email.label" default="Email" />:</span>
					
						<span class="property-value" aria-labelledby="email-label"><g:fieldValue bean="${usuarioInstance}" field="email"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${usuarioInstance?.login}">
				<li class="fieldcontain">
					<span id="login-label" class="property-label"><g:message code="usuario.login.label" default="Login" />:</span>
					
						<span class="property-value" aria-labelledby="login-label"><g:fieldValue bean="${usuarioInstance}" field="login"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${usuarioInstance?.senha}">
				<li class="fieldcontain">
					<span id="senha-label" class="property-label"><g:message code="usuario.senha.label" default="Senha" />:</span>
					
						<span class="property-value" aria-labelledby="senha-label"><g:fieldValue bean="${usuarioInstance}" field="senha"/></span>
					
				</li>
				</g:if>
				<g:if test="${usuarioInstance?.pessoa?.nome}">
					<li class="fieldcontain">
						<span id="nome-label" class="property-label"><g:message code="pessoa.nome.label" default="Nome" />:</span>
						
							<span class="property-value" aria-labelledby="nome-label"><g:fieldValue bean="${usuarioInstance?.pessoa}" field="nome"/></span>
						
					</li>
				</g:if>
			
				<g:if test="${usuarioInstance?.pessoa?.sobrenome}">
					<li class="fieldcontain">
						<span id="sobrenome-label" class="property-label"><g:message code="pessoa.sobrenome.label" default="Sobrenome" />:</span>
						
							<span class="property-value" aria-labelledby="sobrenome-label"><g:fieldValue bean="${usuarioInstance?.pessoa}" field="sobrenome"/></span>
						
					</li>
				</g:if>
				<g:if test="${usuarioInstance?.pessoa?.dataNasc}">
					<li class="fieldcontain">
						<span id="dataNasc-label" class="property-label"><g:message code="pessoa.dataNasc.label" default="Data Nasc" />:</span>
						
							<span class="property-value" aria-labelledby="dataNasc-label"><g:formatDate date="${usuarioInstance?.pessoa?.dataNasc}" /></span>
						
					</li>
				</g:if>
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${usuarioInstance?.id}" />
					<g:link class="edit" action="edit" id="${usuarioInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
