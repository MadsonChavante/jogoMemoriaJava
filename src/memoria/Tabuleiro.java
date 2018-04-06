package memoria;

public class Tabuleiro {
	public String[] tabuleiroReal;
	public String[] tabuleiroTemporario;
	public int pares;

	public Tabuleiro(int pares) {
		this.pares = pares;
		int quantidadeDePosicoes = pares * 2;

		String[] valores = new String[quantidadeDePosicoes];

		for (int i = 0, j = 1; i < quantidadeDePosicoes; i = i + 2) {
			valores[i] = Integer.toString(j);
			valores[i + 1] = Integer.toString(j++);
		}

		tabuleiroReal = new String[quantidadeDePosicoes];
		tabuleiroTemporario = new String[quantidadeDePosicoes];

		int controle = 0;

		while (controle < pares * 2) {

			int posicao = (int) (Math.random() * quantidadeDePosicoes);
			if (tabuleiroReal[posicao] == null) {
				tabuleiroReal[posicao] = valores[controle];
				tabuleiroTemporario[posicao] = "X";
				controle++;
			}
		}
	}

	

	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("\nTabuleiro\n");
		for (int i = 0; i < pares * 2; i++) {
			sb.append(tabuleiroTemporario[i] + " ");

			if (pares * 2 != 1 && Util.quadradoPerfeito(pares * 2)) {
				if ((i + 1) % (Math.sqrt(pares * 2)) == 0) {
					sb.append("\n");
				}
			} else {
				if ((i + 1) % (pares) == 0) {
					sb.append("\n");
				}
			}
		}

		sb.append("\n");
		return sb.toString();
	}
}
