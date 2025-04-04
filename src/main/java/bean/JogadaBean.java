package bean;

import java.time.LocalDateTime;
import java.util.Date;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import dao.JogadaDAO;
import entidades.Jogada;

@ManagedBean
public class JogadaBean {

	private Jogada jogada = new Jogada();
	
	public String salvar() {
		jogada.atribuirJogadas();
		jogada.verificarResultado();
		jogada.setData(new Date());
		JogadaDAO.salvar(jogada);
		jogada = new Jogada();
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Jogo efetuado com Sucesso!"));
		return null;
	}

	public Jogada getJogada() {
		return jogada;
	}

	public void setJogada(Jogada jogada) {
		this.jogada = jogada;
	}	
}
