package curriculos.mbeans;

import java.io.IOException;

import javax.faces.FacesException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import curriculos.negocio.App;
import curriculos.negocio.Curriculo;
import curriculos.negocio.Usuario;

@ManagedBean(name = "sessaoMB", eager = true)
@SessionScoped
public class SessaoMB {
	private Usuario usuario;
	private String objetivo, qualificacoes, idiomas, link1, link2;
	private String mensagem;

	public SessaoMB() {
		super();
		this.usuario = null;
		this.mensagem = "";
	}

	public String getObjetivo() {
		return objetivo;
	}

	public void setObjetivo(String objetivo) {
		this.objetivo = objetivo;
	}

	public String getQualificacoes() {
		return qualificacoes;
	}

	public void setQualificacoes(String qualificacoes) {
		this.qualificacoes = qualificacoes;
	}

	public String getIdiomas() {
		return idiomas;
	}

	public void setIdiomas(String idiomas) {
		this.idiomas = idiomas;
	}

	public String getLink1() {
		return link1;
	}

	public void setLink1(String link1) {
		this.link1 = link1;
	}

	public String getLink2() {
		return link2;
	}

	public void setLink2(String link2) {
		this.link2 = link2;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getMensagem() {
		String retorno = this.mensagem;
		this.mensagem = new String();
		return retorno;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public boolean isTemMensagem() {
		return !this.mensagem.isEmpty();
	}

	public boolean isLogado() {
		return usuario != null;
	}

	public boolean isNotLogado() {
		return usuario == null;
	}

	public void logout() {
		this.usuario = null;
		try {
			ExternalContext externalContext = FacesContext.getCurrentInstance()
					.getExternalContext();
			externalContext.redirect(externalContext.getRequestContextPath()
					+ "/app/index.jsp");
		} catch (IOException e) {
			throw new FacesException(e);
		}
	}

	public String cadastraCurriculo() {
		App app = App.getInstancia();
		ExternalContext externalContext = FacesContext.getCurrentInstance()
				.getExternalContext();

		if (this.objetivo != null) {
			Curriculo curriculo = new Curriculo(this.objetivo,
					this.qualificacoes, this.idiomas, this.link1, this.link2,
					this.usuario);
			if (app.adicionaCurriculo(curriculo)) {
				this.setMensagem("Currículo cadastrado com sucesso!");
				try {
					externalContext.redirect(externalContext
							.getRequestContextPath() + "/app/index.jsp");
				} catch (IOException e) {
					throw new FacesException(e);
				}
			} else {
				this.setMensagem("Este Currículo já está cadastrado!");
			}
		} else {
			this.setMensagem("É necessário informar o objetivo!");
		}

		return "cadastroCurriculo.jsp";
	}
}
