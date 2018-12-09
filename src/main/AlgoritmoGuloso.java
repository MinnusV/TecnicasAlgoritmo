package main;

import java.util.ArrayList;

public class AlgoritmoGuloso {
	private ArrayList<Integer> vetorFAux, vetorCAux;
	private int tamCartaoAux = 0, count = 0;

	@SuppressWarnings("unchecked")
	public int CalculaQuantidadeFrases(int tamCartao, ArrayList<Integer> entQtdCarac, ArrayList<Integer> entQtdFrases) {
		int numFrases = 0, maiorValF = 0, valC = 0;
		
		tamCartaoAux = tamCartao;
		vetorFAux = (ArrayList<Integer>) entQtdFrases.clone();
		vetorCAux = (ArrayList<Integer>) entQtdCarac.clone();
		count = 0;
		
		while(count < entQtdFrases.size()) {
			maiorValF = MaiorValor(vetorFAux);
			
			valC = vetorCAux.get(vetorFAux.indexOf(maiorValF)); 
			
			if(tamCartaoAux >= valC) {
				tamCartaoAux -= valC;
				numFrases += maiorValF;
				RemoveValorF(vetorFAux, maiorValF);
				RemoveValorC(vetorCAux, valC);
			}else {
				RemoveValorF(vetorFAux, maiorValF);
				RemoveValorC(vetorCAux, valC);
			}
		}
		
		return numFrases;
	}
	
	private int MaiorValor(ArrayList<Integer> vetorAux) {
		int maiorValor = 0;

		maiorValor = vetorAux.get(0);
		for (Integer integer : vetorAux) {
			
			if(integer > maiorValor) {
				maiorValor = integer;
			}
		}
		
		count++;
		return maiorValor;
	}
	
	private void RemoveValorF(ArrayList<Integer> vetorAux, int valor) {
		this.vetorFAux.remove(vetorAux.indexOf(valor));
	}
	
	private void RemoveValorC(ArrayList<Integer> vetorAux, int valor) {
		this.vetorCAux.remove(vetorAux.indexOf(valor));
	}
}