package curriculos.mbeans;

import java.io.IOException;

import javax.faces.FacesException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import curriculos.negocio.App;
import curriculos.negocio.Usuario;

@ManagedBean(name = "usuarioMB", eager = true)
@RequestScoped
public class UsuarioMB {
	private String nome, username, senha, idade, email, estadoCivil;
	private String mensagem;

	public UsuarioMB() {
		super();
		this.mensagem = "";
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getIdade() {
		return idade;
	}

	public void setIdade(String idade) {
		this.idade = idade;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public boolean isTemMensagem() {
		return !this.mensagem.isEmpty();
	}

	public String cadastraUsuario() {
		if (!this.nome.isEmpty() && !this.username.isEmpty()
				&& !this.senha.isEmpty() && !this.email.isEmpty()
				&& !this.estadoCivil.isEmpty()) {
			ExternalContext externalContext = FacesContext.getCurrentInstance()
					.getExternalContext();
			Usuario usuario = new Usuario(nome, username, senha, idade, email,
					estadoCivil);
			App app = App.getInstancia();
			if (!app.hasLogin(username)) {
				app.adicionaUsuario(usuario);
				this.setMensagem("Usuario cadastrado com sucesso!");
				try {
					externalContext.redirect(externalContext
							.getRequestContextPath() + "/app/login.jsp");
				} catch (IOException e) {
					throw new FacesException(e);
				}
			} else {
				this.setMensagem("O nome de usuário informado já existe, escolha outro!");
			}
		} else {
			this.setMensagem("É necessário informar todos os parâmetros solicitados!");
		}
		return "cadastroUsuario.jsp";
	}

	public String autenticar() {
		if (!this.username.isEmpty() && !this.senha.isEmpty()) {
			App app = App.getInstancia();
			Usuario autenticado = app.autenticar(this.username, this.senha);
			if (autenticado != null) {
				FacesContext context = FacesContext.getCurrentInstance();
				ExternalContext externalContext = FacesContext
						.getCurrentInstance().getExternalContext();
				SessaoMB sessaoMB = (SessaoMB) context.getELContext()
						.getELResolver()
						.getValue(context.getELContext(), null, "sessaoMB");
				sessaoMB.setUsuario(autenticado);

				try {
					externalContext.redirect(externalContext
							.getRequestContextPath() + "/app/index.jsp");
				} catch (IOException e) {
					throw new FacesException(e);
				}
			} else {
				this.setMensagem("Login e senha não conferem!");
			}
		} else {
			this.setMensagem("É necessário informar username e senha!");
		}
		return "login.jsp";
	}
}
