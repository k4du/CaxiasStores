



<div class="fieldcontain ${hasErrors(bean: pessoaInstance, field: 'nome', 'error')} required">
	<label for="nome">
		<g:message code="pessoa.nome.label" default="Nome" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="nome" required="" value="${pessoaInstance?.nome}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: pessoaInstance, field: 'sobrenome', 'error')} required">
	<label for="sobrenome">
		<g:message code="pessoa.sobrenome.label" default="Sobrenome" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="sobrenome" required="" value="${pessoaInstance?.sobrenome}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: pessoaInstance, field: 'dataNasc', 'error')} required">
	<label for="dataNasc">
		<g:message code="pessoa.dataNasc.label" default="Data Nasc" />
		<span class="required-indicator">*</span>
	</label>
	<g:datePicker name="dataNasc" precision="day"  value="${pessoaInstance?.dataNasc}"  />
</div>

