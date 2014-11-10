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
										action="cadastroCurriculo.jsp?faces-redirect=true"
										styleClass="btn btn-default navbar-btn"></h:commandButton></li>
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

			<div>
				<h3>Currículos</h3>
				<!-- TODO: implementar método de busca -->
				<h:form styleClass="form-inline">
					<h:inputText styleClass="form-control"></h:inputText>
					<h:commandButton value="Pesquisar currículos" styleClass="btn btn-default"></h:commandButton>
				</h:form>
				
				<h:dataTable styleClass="table table-bordered table-hover"
					rendered="#{curriculosMB.comCurriculos}"
					value="#{curriculosMB.curriculos}" var="curriculo">
					<h:column>
						<f:facet name="header">
							<h:outputText value="Objetivo" />
						</f:facet>
						<h:outputText value="#{curriculo.objetivo}"></h:outputText>
					</h:column>
					<h:column>
						
						<f:facet name="header">
							<h:outputText value="Qualificações" />
						</f:facet>
						<h:outputText value="#{curriculo.qualificacoes}"></h:outputText>
					</h:column>
					<h:column>
						<f:facet name="header">
							<h:outputText value="Idiomas" />
						</f:facet>
						<h:outputText value="#{curriculo.idiomas}"></h:outputText>
					</h:column>
					<h:column>
						<f:facet name="header">
							<h:outputText value="Responsável"></h:outputText>
						</f:facet>
						<h:outputText value="#{curriculo.usuario.nome}"></h:outputText>
					</h:column>
					<h:column>
						<f:facet name="header">
							<h:outputText value="Email"></h:outputText>
						</f:facet>
						<h:outputText value="#{curriculo.usuario.email}"></h:outputText>
					</h:column>
				</h:dataTable>
				<h:outputText value="Sem currículos para exibir... "
					rendered="#{curriculosMB.semCurriculos}">
				</h:outputText>
			</div>


			<!-- FIM DO CONTEUDO DA PAGINA -->
		</f:view>
	</div>
</body>
</html>