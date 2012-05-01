<%@ page import="storescaxias.Ramo" %>



<div class="fieldcontain ${hasErrors(bean: ramoInstance, field: 'lojas', 'error')} ">
	<label for="lojas">
		<g:message code="ramo.lojas.label" default="Lojas" />
		
	</label>
	
<ul class="one-to-many">
<g:each in="${ramoInstance?.lojas?}" var="l">
    <li><g:link controller="loja" action="show" id="${l.id}">${l?.encodeAsHTML()}</g:link></li>
</g:each>
<li class="add">
<g:link controller="loja" action="create" params="['ramo.id': ramoInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'loja.label', default: 'Loja')])}</g:link>
</li>
</ul>

</div>

<div class="fieldcontain ${hasErrors(bean: ramoInstance, field: 'nome', 'error')} ">
	<label for="nome">
		<g:message code="ramo.nome.label" default="Nome" />
		
	</label>
	<g:textField name="nome" value="${ramoInstance?.nome}"/>
</div>

