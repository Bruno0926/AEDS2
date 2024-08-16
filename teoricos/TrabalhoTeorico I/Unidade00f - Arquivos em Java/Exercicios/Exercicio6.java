package Exercicios;

import java.util.Scanner;

public class Exercicio6 {
    public static void main(String args[]){
        Arq Arq = new Arq();
        String primeiro,segundo,conteudo,inverte = "";
		Scanner scanner = new Scanner(System.in);
		System.out.println("Nome do arquivo 1: ");
		primeiro = scanner.nextLine();
		System.out.println("Nome do arquivo 2: ");
		segundo = scanner.nextLine();
		Arq.openRead(primeiro);
		conteudo = Arq.readAll();
		Arq.close();
		inverte = "";
		for(int i = conteudo.length(); i>0;i--) {
			inverte += conteudo.charAt(i-1);
			
		}
		Arq.openWrite(segundo);
		Arq.println(inverte);
		Arq.close();
    }
}
