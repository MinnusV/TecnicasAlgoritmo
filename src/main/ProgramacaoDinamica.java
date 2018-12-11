package main;

import java.util.ArrayList;

public class ProgramacaoDinamica {

	private ArrayList<Integer> vetorFAux, vetorCAux;
	private int tamCartaoAux = 0, qtdFrasesAux = 0;

	@SuppressWarnings("unchecked")
	public int CalculaQuantidadeFrases(int tamCartao, int qtdFrases, ArrayList<Integer> entQtdCarac, ArrayList<Integer> entQtdFrases) {
		int numFrases = 0;
		
		tamCartaoAux = tamCartao;
		qtdFrasesAux = qtdFrases;
		vetorFAux = (ArrayList<Integer>) entQtdFrases.clone();
		vetorCAux = (ArrayList<Integer>) entQtdCarac.clone();
		
		int[][] matrizAux = new int[qtdFrasesAux+1][tamCartaoAux+1];

		for(int i = 0; i <= tamCartaoAux; i++) {
			matrizAux[0][i] = 0;
		}
		
		for(int i = 1; i <= qtdFrasesAux; i++) {
			matrizAux[i][0] = 0;
		}
		
		for (int i = 1; i <= qtdFrasesAux; i++) {
			for (int j = 0; j <= tamCartaoAux; j++) {
				if(vetorCAux.get(i-1) <= j) {
					if(vetorFAux.get(i-1) + matrizAux[i-1][j-vetorCAux.get(i-1)] > matrizAux[i-1][j]) {
						matrizAux[i][j] = vetorFAux.get(i-1) + matrizAux[i-1][j-vetorCAux.get(i-1)];
					}else {
						matrizAux[i][j] = matrizAux[i-1][j];
					}
				}else {
					matrizAux[i][j] = matrizAux[i-1][j];
				}
			}
		}
		
		numFrases = matrizAux[qtdFrases][tamCartao];
		
		return numFrases;
	}
}
