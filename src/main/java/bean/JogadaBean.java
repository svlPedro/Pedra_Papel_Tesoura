package bean;

import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import dao.JogadaDAO;
import entidades.Jogada;

@ManagedBean
public class JogadaBean {
	private List<Jogada> lista;
	private Jogada jogadaSelecionada = new Jogada();
	private Jogada jogada = new Jogada();
	
	public String salvar() {
		jogada.atribuirJogadas();
		jogada.verificarResultado();
		jogada.setData(new Date());
		JogadaDAO.salvar(jogada);
		String resultado = jogada.getResultado();
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Jogo efetuado com Sucesso! "+resultado));
		jogada = new Jogada();
		return null;
	}
		
	public String deletar() {
		lista.remove(jogadaSelecionada);
	    JogadaDAO.deletar(jogadaSelecionada);
	    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Jogo removido com sucesso!"));
	    return null;
	}	
	
	public Jogada getJogada() {
		return jogada;
	}
	
	public void setJogada(Jogada jogada) {
		this.jogada = jogada;
	}

	public Jogada getJogadaSelecionada() {
		return jogadaSelecionada;
	}

	public void setJogadaSelecionada(Jogada jogadaSelecionada) {
		this.jogadaSelecionada = jogadaSelecionada;
	}	
	
	public List<Jogada> getLista() {
		if (lista == null) {
			lista = JogadaDAO.listarTodos();
		}
		return lista;
	}

	public void setLista(List<Jogada> lista) {
		this.lista = lista;
	}
}