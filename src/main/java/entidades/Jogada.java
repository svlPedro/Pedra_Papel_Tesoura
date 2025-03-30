package entidades;

import java.util.Date;
import java.util.Random;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Jogada {
	@Id
	@GeneratedValue
	private Integer id;
	@Column(nullable = false)
	private String jogador1;
	@Column(nullable = false)
	private String jogador2;
	private String jogada1;
	private String jogada2;
	private String resultado;
	@Temporal(TemporalType.DATE)
	private Date data;
	
	public void verificarResultado() {
		if (jogada1.equals(jogada2)) {
	        resultado = "Empate";
	    } else if (jogada1.equals("Pedra") && jogada2.equals("Tesoura")) {
	        resultado = jogador1 + " Venceu";
	    } else if (jogada1.equals("Tesoura") && jogada2.equals("Papel")) {
	        resultado = jogador1 + " Venceu";
	    } else if (jogada1.equals("Papel") && jogada2.equals("Pedra")) {
	        resultado = jogador1 + " Venceu";
	    } else if (jogada2.equals("Pedra") && jogada1.equals("Tesoura")) {
	        resultado = jogador2 + " Venceu";
	    } else if (jogada2.equals("Tesoura") && jogada1.equals("Papel")) {
	        resultado = jogador2 + " Venceu";
	    } else if (jogada2.equals("Papel") && jogada1.equals("Pedra")) {
	        resultado = jogador2 + " Venceu";
	    }
	}
	
	public void atribuirJogadas() {
		 String[] opcoes = {"Pedra", "Papel", "Tesoura"};
	     Random rd = new Random();
	     jogada1 = opcoes[rd.nextInt(opcoes.length)]; 
	     jogada2 = opcoes[rd.nextInt(opcoes.length)]; 
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getJogador1() {
		return jogador1;
	}
	public void setJogador1(String jogador1) {
		this.jogador1 = jogador1;
	}
	public String getJogador2() {
		return jogador2;
	}
	public void setJogador2(String jogador2) {
		this.jogador2 = jogador2;
	}
	public String getResultado() {
		return resultado;
	}
	public void setResultado(String resultado) {
		this.resultado = resultado;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}

	public String getJogada1() {
		return jogada1;
	}

	public void setJogada1(String jogada1) {
		this.jogada1 = jogada1;
	}

	public String getJogada2() {
		return jogada2;
	}

	public void setJogada2(String jogada2) {
		this.jogada2 = jogada2;
	}	
}
