<%@ page import="storescaxias.Loja" %>


<div class="fieldcontain ${hasErrors(bean: lojaInstance, field: 'nome', 'error')} ">
	<label for="nome">
		<g:message code="loja.nome.label" default="Nome" />
		
	</label>
	<g:textField name="nome" value="${lojaInstance?.nome}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: lojaInstance, field: 'descricao', 'error')} ">
	<label for="descricao">
		<g:message code="loja.descricao.label" default="Descricao" />
		
	</label>
	<g:textField name="descricao" value="${lojaInstance?.descricao}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: lojaInstance, field: 'imagem', 'error')} required">
	<label for="imagem">
		<g:message code="loja.imagem.label" default="Imagem" />
		<span class="required-indicator">*</span>
	</label>
	<input class="img" type="file" id="imagem" name="imagem" />
</div>

<div class="fieldcontain ${hasErrors(bean: lojaInstance, field: 'ramo', 'error')} required">
	<label for="ramo">
		<g:message code="loja.ramo.label" default="Ramo" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="ramo.id" name="ramo.id" from="${storescaxias.Ramo.list()}" optionKey="id" required="" value="${lojaInstance?.ramo?.id}" class="many-to-one"/>
</div>

