package curriculos.mbeans;

import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import curriculos.negocio.App;
import curriculos.negocio.Curriculo;

@ManagedBean(name="curriculosMB", eager=true)
@ApplicationScoped
public class CurriculosMB {
	private List<Curriculo> curriculos;

	public CurriculosMB() {
		super();
	}

	private void carregaCurriculos() {
		App app = App.getInstancia();
		this.curriculos = app.getCurriculos();
	}

	public List<Curriculo> getCurriculos() {
		this.carregaCurriculos();
		return curriculos;
	}

	public List<Curriculo> getCurriculosBusca() {
		return curriculos;
	}

	public void setCurriculos(List<Curriculo> curriculos) {
		this.curriculos = curriculos;
	}

	public boolean isSemCurriculos() {
		this.carregaCurriculos();
		return this.curriculos.isEmpty();
	}

	public boolean isComCurriculos() {
		this.carregaCurriculos();
		return !this.curriculos.isEmpty();
	}

	// Gambiarra
	public boolean isSemCurriculosBusca() {
		return this.curriculos.isEmpty();
	}

	public boolean isComCurriculosBusca() {
		return !this.curriculos.isEmpty();
	}
}
