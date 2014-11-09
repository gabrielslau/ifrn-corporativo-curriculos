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
			<h3>Catastrar Usuário</h3>
			<h:form id="f2">
				<h:messages layout="list" id="m1" styleClass="alert alert-danger"></h:messages>

				<h:panelGrid id="p1" columns="2"
					styleClass="table table-bordered table-hover">
					<h:outputLabel id="o1" value="Nome: "></h:outputLabel>
					<h:inputText id="i1" value="#{usuarioMB.nome}" required="true" requiredMessage="O nome deve ser preenchido"
						styleClass="form-control"></h:inputText>
					<h:outputLabel id="o2" value="Nome de usuário: "></h:outputLabel>
					<h:inputText id="i2" value="#{usuarioMB.username}" required="true" requiredMessage="O nome de usuário deve ser preenchido"
						styleClass="form-control"></h:inputText>
					<h:outputLabel id="o3" value="Senha: "></h:outputLabel>
					<h:inputSecret id="i3" value="#{usuarioMB.senha}" required="true" requiredMessage="A senha deve ser preenchida"
						styleClass="form-control"></h:inputSecret>
					<h:outputLabel id="o4" value="Idade: "></h:outputLabel>
					<h:inputText id="i4" value="#{usuarioMB.idade}"
						styleClass="form-control"></h:inputText>
					<h:outputLabel id="o5" value="Email: "></h:outputLabel>
					<h:inputText id="i5" value="#{usuarioMB.email}" required="true" requiredMessage="O email deve ser preenchido"
						styleClass="form-control"></h:inputText>
					<h:outputLabel id="o6" value="Estado Civil: "></h:outputLabel>
					<h:selectOneListbox id="s1" value="Estado Civil" required="true" requiredMessage="O estado civil deve ser preenchido"
						styleClass="form-control" size="1">
						<f:selectItem itemValue="Desinteressado"
							itemLabel="Desinteressado" />
						<f:selectItem itemValue="Separado" itemLabel="Separado" />
						<f:selectItem itemValue="Casado" itemLabel="Casado" />
						<f:selectItem itemValue="Solteiro" itemLabel="Solteiro" />
						<f:selectItem itemValue="Sozinho" itemLabel="Sozinho" />
					</h:selectOneListbox>
				</h:panelGrid>
				<h:commandButton value="Cadastrar Usuário"
					action="#{usuarioMB.cadastraUsuario}" styleClass="btn btn-primary"></h:commandButton>
			</h:form>

			<!-- FIM DO CONTEUDO DA PAGINA -->
		</f:view>
	</div>
</body>
</html>