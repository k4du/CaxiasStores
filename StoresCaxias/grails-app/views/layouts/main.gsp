<%@ page import="storescaxias.Ramo" %>


<!doctype html>
<!--[if lt IE 7 ]> <html lang="en" class="no-js ie6"> <![endif]-->
<!--[if IE 7 ]>    <html lang="en" class="no-js ie7"> <![endif]-->
<!--[if IE 8 ]>    <html lang="en" class="no-js ie8"> <![endif]-->
<!--[if IE 9 ]>    <html lang="en" class="no-js ie9"> <![endif]-->
<!--[if (gt IE 9)|!(IE)]><!--> <html lang="en" class="no-js"><!--<![endif]-->
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
		<title><g:layoutTitle default="Grails"/></title>
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<link rel="shortcut icon" href="${resource(dir: 'images', file: 'favicon.ico')}" type="image/x-icon">
		<link rel="apple-touch-icon" href="${resource(dir: 'images', file: 'apple-touch-icon.png')}">
		<link rel="apple-touch-icon" sizes="114x114" href="${resource(dir: 'images', file: 'apple-touch-icon-retina.png')}">
		<link rel="stylesheet" href="${resource(dir: 'css', file: 'main.css')}" type="text/css">
		<link rel="stylesheet" href="${resource(dir: 'css', file: 'mobile.css')}" type="text/css">
		<link rel="stylesheet" href="${resource(dir: 'css', file: 'bootstrap.css')}" type="text/css">
		<link rel="stylesheet" href="${resource(dir: 'css', file: 'bootstrap-responsive.css')}" type="text/css">
		<link rel="stylesheet" href="${resource(dir: 'css', file: 'jquery-ui-1.8.18.custom.css')}" type="text/css">
		<g:javascript src="jquery-1.7.1.min.js"></g:javascript>
		<g:javascript src="bootstrap.js"></g:javascript>
		<g:javascript src="jquery-ui-1.8.18.custom.min.js"></g:javascript>
		<g:javascript src="bootstrap-dropdown.js"></g:javascript>
		<script type="text/javascript">
		$(function(){
			$('.dropdown-toggle').dropdown();
			$('.linav').click(function(){
				$('.linav').each(function(){
						if($(this).hasClass('active')){
							$(this).removeClass('active');
						}
				});
				$(this).addClass('active');
			});
		});
		</script>
		<style type="text/css">
		.textoCabec{
			background-image: url("${resource(dir: 'images', file: 'fundo.png')}") ;
			font-size: 100px;
			width: 100%;
			height: 200px;
			text-align: center;
		}
		.cabecalho{
			margin-top: 110px;
			text-decoration: overline underline;
			font-style:  bold;
			font-family: menu; 
		}
		</style>
		<g:layoutHead/>
        <r:layoutResources />
	</head>
	<body>
		<div class="navbar navbar-fixed-top">
   			<div class="navbar-inner">
	    		<div class="container">
	    			<a class="brand" href="#">Lojas Caxias</a>
	    			<g:form controller="usuario" class="navbar-form pull-right form-inline" action="login">
				      	<g:textField class="input-small" name="login" placeholder="Login"/>
				      	<g:passwordField class="input-small" name="senha" placeholder="Senha"/>
				      	<g:submitButton class='btn btn-inverse' name="Entrar"/>
		      		</g:form> 
	    			
	    		</div>
    		</div>
    	</div>
		<div class="textoCabec thumbnails"><div class="cabecalho">Lojas Caxias</div></div>
		<ul class="nav nav-tabs">
			<li class="linav"><a href="${createLink(controller:'loja', action :'list')}">Inicio</a></li>
		    <li class="linav dropdown">
			    <a class="dropdown-toggle" data-toggle="dropdown" href="#">   Lojas   <b class="caret"></b>  </a>
			    <ul class="dropdown-menu">
			    	<g:each in="${Ramo.list()}" var="ramoInstance">
				    	<a href="${createLink(controller:'loja', action:'list', id : ramoInstance.id )}">${ramoInstance.nome}</a>
			    	</g:each>
			    </ul>
			</li>
			<li class="linav"><a href="#">Contato</a></li>
	    </ul>
		
		<g:layoutBody/>
		
<%--		<div class="navbar navbar-fixed-bottom">--%>
<%--   			<div class="navbar-inner">--%>
<%--	    		<div class="container">--%>
<%--	    			<a class="brand" href="#">Lojas Caxias</a>--%>
<%--	    		</div>--%>
<%--    		</div>--%>
<%--    	</div>--%>
<%--		--%>
		
		
		<div id="spinner" class="spinner" style="display:none;"><g:message code="spinner.alt" default="Loading&hellip;"/></div>
		<g:javascript library="application"/>
        <r:layoutResources />
	</body>
</html>