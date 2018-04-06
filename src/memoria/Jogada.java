package memoria;

public class Jogada {
	
	
	private int posicao1 = 0;
	private int posicao2 = 0;
	
	Jogada(String posicao1, String posicao2){
		
		this.posicao1 = Integer.parseInt(posicao1);
		this.posicao2 = Integer.parseInt(posicao2);
		
	}
	
	public int getPosicao1() {
		return posicao1;
	}

	public void setPosicao1(int posicao1) {
		this.posicao1 = posicao1;
	}

	public int getPosicao2() {
		return posicao2;
	}
	
	public void setPosicao2(int posicao2) {
		this.posicao2 = posicao2;
	}

}
