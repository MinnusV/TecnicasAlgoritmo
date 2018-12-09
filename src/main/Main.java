package main;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	private static Scanner sc;
	private static AlgoritmoGuloso ag;
	//private static ProgramacaoDinamica pd;

	public static void main(String[] args) {
		
		int tamCartao, qtdFrases;
		
		boolean entInvalida = false;
		
		ArrayList<Integer> entradasQtdCaract;
		ArrayList<Integer> entradasQtdFrases;
		ArrayList<Integer> totalFrasesAG = new ArrayList<Integer>();
		
		sc = new Scanner(System.in);
		ag = new AlgoritmoGuloso();
		//pd = new ProgramacaoDinamica();
		
		
		System.out.println("Informe o tamanho do cartao e a quantidade de frases:");
		
		do {
			entradasQtdFrases = new ArrayList<Integer>();
			entradasQtdCaract = new ArrayList<Integer>();
			
			if(entInvalida) {
				System.out.print("Entrada inválida!  ");
				System.out.println("Informe novamente:");
			}
			
			tamCartao = sc.nextInt();
			qtdFrases = sc.nextInt();
			
			
			if(tamCartao == 0 && qtdFrases == 0){
				ImprimeResultado(totalFrasesAG);
				break;
			}
		
			if((tamCartao < 8 || tamCartao > 1000) && (qtdFrases < 1 || qtdFrases > 50)){
				entInvalida = true;
				continue;
			}else {
				entInvalida = false;
			}
			
			for (int i = 0; i < qtdFrases; i++) {
				entradasQtdCaract.add(sc.nextInt());
				entradasQtdFrases.add(sc.nextInt());
			}
			
			totalFrasesAG.add(ag.CalculaQuantidadeFrases(tamCartao, entradasQtdCaract, entradasQtdFrases));
			
			
		}while(tamCartao != 0 || qtdFrases != 0);

	}
	
	private static void ImprimeResultado(ArrayList<Integer> totalFrasesAG) {
		int count = 1;
		System.out.println("\nTestes encerrados!");
		
		if(!totalFrasesAG.isEmpty()) {
			System.out.println("Resultado:");
			
			for (Integer integer : totalFrasesAG) {
				System.out.println("\nTeste " + count);
				System.out.println("Solução Gulosa: " + integer);
				count++;
			}
		}
		
	}

}
