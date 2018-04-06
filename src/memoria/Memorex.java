package memoria;

import java.util.ArrayList;
import java.util.Scanner;



public class Memorex {
	private ArrayList<Jogador> listaDeJogadores;
	private Tabuleiro tabuleiro;
	private int rodadas;
	
	
	
	public int getRodadas() {
		return rodadas;
	}

	public void setRodadas(int rodadas) {
		this.rodadas = rodadas;
	}

	public Jogador getJogador(int posicao){
		return listaDeJogadores.get(posicao);
	}
	
	public String getNomeJogador(int posicao){
		
		return listaDeJogadores.get(posicao).getNome();
		
	}
	
	public Jogador getVencedor(){
		int maiorPontuacao = 0;
		Jogador vencedor = null;
		
		for(int i = 0; i < listaDeJogadores.size(); i++){
			
			if(listaDeJogadores.get(i).getPontuacao() > maiorPontuacao){
				maiorPontuacao = listaDeJogadores.get(i).getPontuacao();
				vencedor = listaDeJogadores.get(i);
			}
			
		}
		
		return vencedor;
	}
	
	
	public void cabecalho(){ 
		
		System.out.println("------MEMOREX------\n\n");
		
		for(int i = 0; i < listaDeJogadores.size(); i++){
					System.out.println("Jogador " + i + ": " +
							listaDeJogadores.get(i).getNome() + " (" +
							listaDeJogadores.get(i).getPontuacao() + " pontos" + " )"
							+ "\n");
				}
		
		System.out.println("\n\n");
	}
	
	public void configurarJogo(){
		tabuleiro = new Tabuleiro(8);
	
		Scanner entrada = new Scanner(System.in);
		int qtdDeJogadores = 0;
		
		System.out.println("Por favor, informe a quantidade de jogadores: " + "\n");
		qtdDeJogadores = entrada.nextInt();
		
		
		listaDeJogadores = new ArrayList(qtdDeJogadores);
		
		for(int i = 0; i < listaDeJogadores.size(); i++){
			
			String nomeJogador ;
			
			System.out.println("Informe o nome do jogador " + i );
			nomeJogador  = entrada.nextLine();
			
			Jogador jogador = new Jogador();
			jogador.setNome(nomeJogador);
			
			listaDeJogadores.add(jogador);
			
		}	
		
		cabecalho();
		System.out.println("O jogo foi configurado \n");	
		
	}
	
	public void jogar(){
		
		Scanner entrada = new Scanner(System.in);
		String posicao1;
		String posicao2;
		
		
		
			while (rodadas < tabuleiro.pares){
				
				for (int i = 0; i < listaDeJogadores.size(); i++){
				
				cabecalho();
				System.out.println(tabuleiro.toString() + "\n " + "Clique em OK para informar a jogada");
				
				System.out.println("Olá " + listaDeJogadores.get(i).getNome() + " Nas próximas telas informe 2 posições"
						+ " do tabuleiro que você acha que possuem o mesmo número");
				
				System.out.println("Informe a primeira posição \n");
				posicao1 = entrada.nextLine();
				
				System.out.println("Informe a primeira posição \n");
				posicao2 = entrada.nextLine();
				
				Jogada jogada = new Jogada(posicao1, posicao2);
				
				listaDeJogadores.get(i).setJogada(jogada);
				
				
				// Se a jogada foi correta (se as posições corresponderem à valores iguais do tabuleiro):
				
				int pontuacao = listaDeJogadores.get(i).getPontuacao();// pegando a pontuacao atual 
				listaDeJogadores.get(i).setPontuacao(pontuacao + 5); // acrescentando + 5 
				
				rodadas++;
				System.out.println("Acertou \n");
				
				//Se não:
				
				System.out.println("Errou \n");
				int pontuacao2 = listaDeJogadores.get(i).getPontuacao(); // pegando a pontuacao atual
				listaDeJogadores.get(i).setPontuacao(pontuacao2 - 5);		
				
			}
		}
			
			cabecalho();
			System.out.println(tabuleiro.toString() + "FIM DE JOGO" + " O vencedor foi: " + getVencedor());
		
	}
	
	
	public void iniciarJogo(){
		
		configurarJogo();
		jogar();
		
	}

	
	public static void main(String[] args) {
		
		Memorex m = new Memorex();
		m.iniciarJogo();
		
		System.exit(0);
	}
	
}
