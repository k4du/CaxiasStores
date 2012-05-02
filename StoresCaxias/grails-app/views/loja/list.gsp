
<%@ page import="storescaxias.Loja" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'loja.label', default: 'Loja')}" />
		<title>Lojas Caxias</title>
		<g:javascript src="jquery-1.7.1.min.js"></g:javascript>
		<g:javascript src="jquery.corner.js"></g:javascript>
		<script type="text/javascript">
		$(function(){

			$(".figura").corner();

		});

		</script>
		<style type="text/css">
		div.figura {
		  float: left;
		  width: 30%;
		  margin: 0.5em;
		  padding: 0.5em;
		  position: relative;
		  background-color: #666666;
		}
		div.figura p {
		  text-align: center;
		  font-style: italic;
		  font-size: 1.5em;
		  color: #333333;
		  text-indent: 0;
		 
		}

		img{
			min-width: 305px;
			max-width: 305px;
			height:150px;
			border: 1px solid black;
		}
		.listImg{
			width: 80%;
			margin-left: 10%;
			position: fixed;
			border: 1px solid black;
			
		}
		
		
		</style>
	</head>
	<body>
		<div class="listImg">
			<g:if test="${lojaInstanceList}">
				<g:each in="${lojaInstanceList}" status="i" var="lojaInstance">
				
				<div class="figura">
				  	<p><img src="${createLink(controller:'loja', action :'mostrarImagem' , id:lojaInstance.id )}"  alt="torre Eiffel"></p>
				  	<p>${lojaInstance.nome}</p>
				</div>
						
<%--						<g:link>--%>
<%--							<img  title="${ lojaInstance.nome}" src="${createLink(controller:'loja', action :'mostrarImagem' , id:lojaInstance.id )}">--%>
<%--						</g:link>--%>
<%--						${lojaInstance.nome}--%>
				</g:each>
			</g:if>	
	 	</div>
	</body>
</html>
