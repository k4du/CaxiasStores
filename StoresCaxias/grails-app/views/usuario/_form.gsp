



<div class="fieldcontain ${hasErrors(bean: usuarioInstance, field: 'email', 'error')} required">
	<label for="email">
		<g:message code="usuario.email.label" default="Email" />
		<span class="required-indicator">*</span>
	</label>
	<g:field type="email" name="email" required="" value="${usuarioInstance?.email}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: usuarioInstance, field: 'login', 'error')} required">
	<label for="login">
		<g:message code="usuario.login.label" default="Login" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="login" required="" value="${usuarioInstance?.login}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: usuarioInstance, field: 'senha', 'error')} required">
	<label for="senha">
		<g:message code="usuario.senha.label" default="Senha" />
		<span class="required-indicator">*</span>
	</label>
	<g:passwordField name="senha" required="" value="${usuarioInstance?.senha}"/>
</div>





<div class="fieldcontain ${hasErrors(bean: pessoaInstance, field: 'nome', 'error')} required">
	<label for="nome">
		<g:message code="pessoa.nome.label" default="Nome" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="nome" required="" value="${usuarioInstance?.pessoa?.nome}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: pessoaInstance, field: 'sobrenome', 'error')} required">
	<label for="sobrenome">
		<g:message code="pessoa.sobrenome.label" default="Sobrenome" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="sobrenome" required="" value="${usuarioInstance?.pessoa?.sobrenome}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: pessoaInstance, field: 'dataNasc', 'error')} required">
	<label for="dataNasc">
		<g:message code="pessoa.dataNasc.label" default="Data Nasc" />
		<span class="required-indicator">*</span>
	</label>
	<g:datePicker name="dataNasc" precision="day"  value="${usuarioInstance?.pessoa?.dataNasc}"  />
</div>


