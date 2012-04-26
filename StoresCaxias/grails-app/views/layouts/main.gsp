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
		});
		</script>
		<style type="text/css">
		.textoCabec{
			font-size: 120px;
		}
		.linhaBranca{
			width: 100%;
		}
		</style>
		<g:layoutHead/>
        <r:layoutResources />
	</head>
	<body>
		<div id="grailsLogo" role="banner" class="ui-widget-header textoCabec"><img src="${resource(dir: 'images', file: 'logotipo.gif')}" alt="Grails"/>Conta Paga</div>
		<p class="linhaBranca"> </p>
		<a href="#create-usuario" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul class="nav pills">
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<g:if test="${session.usuario}">
				<li class="dropdown" id="menu1">
					<a class="dropdown-toggle" data-toggle="dropdown" href="#menu1">
					Dropdown
					<b class="caret"></b>
					</a>
					<ul class="dropdown-menu">
						<li><a href="#">Action</a></li>
						<li><a href="#">Another action</a></li>
						<li><a href="#">Something else here</a></li>
						<li class="divider"></li>
						<li><a href="#">Separated link</a></li>
					</ul>
				</li>
				<li class="dropdown" id="menu1">
					<a class="dropdown-toggle" data-toggle="dropdown" href="#menu1">
					Dropdown
					<b class="caret"></b>
					</a>
					<ul class="dropdown-menu">
						<li><a href="#">Action</a></li>
						<li><a href="#">Another action</a></li>
						<li><a href="#">Something else here</a></li>
						<li class="divider"></li>
						<li><a href="#">Separated link</a></li>
					</ul>
				</li>
				<li class="dropdown" id="menu1">
					<a class="dropdown-toggle" data-toggle="dropdown" href="#menu1">
					Dropdown
					<b class="caret"></b>
					</a>
					<ul class="dropdown-menu">
						<li><a href="#">Action</a></li>
						<li><a href="#">Another action</a></li>
						<li><a href="#">Something else here</a></li>
						<li class="divider"></li>
						<li><a href="#">Separated link</a></li>
					</ul>
				</li>
				<li class="dropdown" id="menu5">
					<a class="dropdown-toggle" data-toggle="dropdown" href="#menu5">
						Usuario
					<b class="caret"></b>
					</a>
					<ul class="dropdown-menu">
						<li><g:link action="edit" controller="usuario"   params="[id:'session.usuario?.id']">Editar Usuario</g:link></li>
						<li><g:link action="logout" controller="usuario" >Logout</g:link></li>
					</ul>
				</li>
				</g:if>
			</ul>
		</div>
		<g:layoutBody/>
		<div class="footer" role="contentinfo"></div>
		<div id="spinner" class="spinner" style="display:none;"><g:message code="spinner.alt" default="Loading&hellip;"/></div>
		<g:javascript library="application"/>
        <r:layoutResources />
	</body>
</html>