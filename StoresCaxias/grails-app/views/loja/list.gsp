
<%@ page import="storescaxias.Loja" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'loja.label', default: 'Loja')}" />
		<title>Lojas Caxias</title>
		<style type="text/css">

		img{
			min-width: 28%;
			max-width: 28%;
			height:70px;
			border: 1px solid black;
		}
		.listImg{
			width: 80%;
			margin-left: 10%;
			
		}
		
		
		</style>
	</head>
	<body>
		<div class="listImg">
			<g:if test="${lojaInstanceList}">
				<g:each in="${lojaInstanceList}" status="i" var="lojaInstance">
						<g:link>
							<img  title="${ lojaInstance.nome}" src="${createLink(controller:'loja', action :'mostrarImagem' , id:lojaInstance.id )}">
						</g:link>
						${lojaInstance.nome}
				</g:each>
			</g:if>	
	 	</div>
	</body>
</html>
