<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sistema de Currículos</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css">
<link rel="stylesheet"
	href="http://getbootstrap.com/examples/navbar/navbar.css">
</head>
<body>
	<div class="container">
		<f:view>
			<header class="header">
				<nav class="navbar navbar-default" role="navigation">
					<div class="container-fluid">
						<h:form id="f1">
							<div class="navbar-header">
								<h:commandLink value="Sistema de Currículos"
									action="index.jsp?faces-redirect=true"
									styleClass="navbar-brand"></h:commandLink>
							</div>
							<p class="navbar-text">
								<h:outputText value="Usuário logado: #{sessaoMB.usuario.nome}"
									rendered="#{sessaoMB.logado}"></h:outputText>
							</p>
							<ul class="nav navbar-nav navbar-right">
								<li><h:commandButton id="c4"
										value="Cadastrar novo Currículo" rendered="#{sessaoMB.logado}"
										action="cadastroCurriculo.jsp?faces-redirect=true" styleClass="btn btn-default navbar-btn"></h:commandButton></li>
								<li><h:commandLink value="Efetue Login"
										action="login.jsp?faces-redirect=true"
										rendered="#{sessaoMB.notLogado}" immediate="true"></h:commandLink></li>
								<li><h:commandLink value="Logout"
										action="#{sessaoMB.logout}" rendered="#{sessaoMB.logado}"></h:commandLink></li>
								<li><h:commandLink value="Faça o seu cadastro"
										action="cadastroUsuario.jsp?faces-redirect=true"
										rendered="#{sessaoMB.notLogado}"></h:commandLink></li>
							</ul>
						</h:form>
					</div>
				</nav>
			</header>
			<h:outputText id="o2" value="#{usuarioMB.mensagem}"
				rendered="#{usuarioMB.temMensagem}" styleClass="text-danger"></h:outputText>
			<h:outputText id="o6" value="#{sessaoMB.mensagem}"
				rendered="#{sessaoMB.temMensagem}" styleClass="text-danger"></h:outputText>

			<!-- INICIO DO CONTEUDO DA PAGINA -->
			<h3>Cadastrar Currículo</h3>
			<h:form>
				<h:messages layout="list" styleClass="alert alert-danger"></h:messages>

				<h:panelGrid columns="2"
					styleClass="table table-bordered table-hover">
					<h:outputLabel value="Objetivo: "></h:outputLabel>
					<h:inputTextarea value="#{sessaoMB.objetivo}" required="true" requiredMessage="O objetivo deve ser preenchido"
						styleClass="form-control"></h:inputTextarea>
					<h:outputLabel value="Qualificações: "></h:outputLabel>
					<h:inputTextarea value="#{sessaoMB.qualificacoes}"
						styleClass="form-control"></h:inputTextarea>
					<h:outputLabel value="Idiomas: "></h:outputLabel>
					<h:inputText value="#{sessaoMB.idiomas}"
						styleClass="form-control"></h:inputText>
						
					<h:outputLabel value="URL 1: "></h:outputLabel>
					<h:inputText value="#{sessaoMB.link1}"
						styleClass="form-control"></h:inputText>
					<h:outputLabel value="URL 2: "></h:outputLabel>
					<h:inputText value="#{sessaoMB.link2}"
						styleClass="form-control"></h:inputText>
				</h:panelGrid>
				<h:commandButton value="Cadastrar currículo"
					action="#{sessaoMB.cadastraCurriculo}" styleClass="btn btn-primary"></h:commandButton>
			</h:form>

			<!-- FIM DO CONTEUDO DA PAGINA -->
		</f:view>
	</div>
</body>
</html>