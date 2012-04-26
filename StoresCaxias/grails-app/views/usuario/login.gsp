<%@ page import="storescaxias.Usuario" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'usuario.label', default: 'Usuario')}" />
		<title>Login</title>
		
<%--		<g:javascript src="jquery.ui.widget.min.js"></g:javascript>--%>
<%--		<g:javascript src="jquery.ui.position.min.js"></g:javascript>--%>
<%--		<g:javascript src="jquery.ui.dialog.min.js"></g:javascript>--%>
<%--		<g:javascript src="jquery.ui.core.min.js"></g:javascript>--%>
<%--		<link rel="stylesheet" href="${resource(dir: 'css', file: 'jquery.ui.all.css')}" type="text/css">--%>
		 
		
		
		<script type="text/javascript">
		$(function(){
			var altura = 290;
			<g:if test="${flash.message}">
				altura = 340;
	   		 </g:if>	
			
			$( "#dialogLogin" ).dialog({
				autoOpen: true,
				height: altura,
				width: 300,
				modal: true,
				title:"SISTEMA DE CONTAS",
				buttons: {
					"Cadastre-se":function(){
						var form =	$(this).children("form");
						form.attr("action","usuario/create");
						form.submit();
					},
					Logar: function() {
						var form =	$(this).children("form");
						form.submit();
					}
					
				},
				close: function() {
					$("#login").val("");
					$("#senha").val("");
					var form =	$(this).children("form");
					form.submit();
				}
			});
		});

		</script>
		
		<style type="text/css">
		
		
		
		</style>
	</head>
	<body>
<%--			<div id="dialogLogin">--%>
<%--				<g:if test="${flash.message}">--%>
<%--					<div class="errors" role="status">${flash.message}</div>--%>
<%--			    </g:if>		--%>
<%--		      <g:form controller="usuario" action="login">--%>
<%--			      <p class="obrigatorio">--%>
<%--			      	<label for="login">Login:</label>--%>
<%--			      	<g:textField name="login"/>--%>
<%--			      </p>--%>
<%--			      <br>--%>
<%--			      <p class="obrigatorio">--%>
<%--			      	<label for="senha">Senha:</label>--%>
<%--			      	<g:passwordField name="senha"/>--%>
<%--			      </p>--%>
<%--		      </g:form>        --%>
<%--		    </div>--%>
	</body>
</html>
