package curriculos.negocio;

import java.sql.Date;

public class Curriculo {
	private String objetivo, qualificacoes, idiomas, link1, link2;
	private Date created;
	private Usuario usuario;

	public Curriculo() {
		super();
	}

	//	public Curriculo(String objetivo, String qualificacoes, String idiomas, String link1, String link2,
	//			Usuario usuario, int usuarioId) {
	//		super();
	//		this.objetivo = objetivo; // Not NUll
	//		this.qualificacoes = qualificacoes;
	//		this.idiomas = idiomas;
	//		this.link1 = link1;
	//		this.link2 = link2;
	//		this.usuarioId = usuarioId;
	//		this.usuario = usuario;
	//	}

	public Curriculo(String objetivo, String qualificacoes, String idiomas, String link1, String link2,
			Usuario usuario) {
		super();
		this.objetivo = objetivo; // Not NUll
		this.qualificacoes = qualificacoes;
		this.idiomas = idiomas;
		this.link1 = link1;
		this.link2 = link2;
		this.usuario = usuario;
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

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
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
}
