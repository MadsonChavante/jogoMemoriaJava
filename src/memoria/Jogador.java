package memoria;
import java.util.ArrayList;
import java.util.List;


public class Jogador {
	private String nome;
	private int pontuacao;
	private ArrayList<Jogada> jogadas = new ArrayList();
	
	
	public void setJogada(Jogada jogada){
		jogadas.add(jogada);
	}

	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome){
		this.nome = nome;
	}

	public int getPontuacao() {
		return pontuacao;
	}

	public List<Jogada> getJogadas() {
		return jogadas;
	}
	
	public void setPontuacao(int pontuacao) {
		this.pontuacao = pontuacao;
	}

	@Override
	public String toString() {
		
		return "Nome: " + getNome() + "\n " + "Pontuacao " + getPontuacao();
	}

}
