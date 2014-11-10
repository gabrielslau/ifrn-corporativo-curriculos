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
	href="http://getbootstrap.com/examples/signin/signin.css">
</head>
<body>
	<div class="container">
		<f:view>
			<h:outputText value="#{usuarioMB.mensagem}"
				rendered="#{usuarioMB.temMensagem}" styleClass="text-danger"></h:outputText>
			<h:outputText value="#{sessaoMB.mensagem}"
				rendered="#{sessaoMB.temMensagem}" styleClass="text-danger"></h:outputText>

			<!-- INICIO DO CONTEUDO DA PAGINA -->
			
			<h:form styleClass="form-signin">
				<h2 class="form-signin-heading">Identifique-se</h2>

				<h:outputLabel value="Nome de usuário: "></h:outputLabel>
				<h:inputText value="#{usuarioMB.username}" styleClass="form-control"
					required="true"></h:inputText>

				<h:outputLabel value="Senha: "></h:outputLabel>
				<h:inputSecret value="#{usuarioMB.senha}" styleClass="form-control"
					required="true"></h:inputSecret>

				<h:commandButton value="Efetuar Login"
					action="#{usuarioMB.autenticar}"
					styleClass="btn btn-lg btn-primary btn-block"></h:commandButton>
			</h:form>

			<h:form styleClass="form-signin">
				<h:commandLink value="Efetuar cadastro"
					action="cadastroUsuario.jsp?faces-redirect=true"
					styleClass="btn btn-link btn-block"></h:commandLink>

				<h:commandLink value="Página inicial"
					action="index.jsp?faces-redirect=true"
					styleClass="btn btn-link btn-block"></h:commandLink>
			</h:form>

			<!-- FIM DO CONTEUDO DA PAGINA -->
		</f:view>
	</div>
</body>
</html>