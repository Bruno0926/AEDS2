package Exercicios;

import java.util.Scanner;

public class Exercicio1 {
    public static void main(String args[]) {
		Arq Arq = new Arq();
		String nome, frase;
		System.out.println("Nome do arquivo: ");
		Scanner scanner = new Scanner(System.in);
		nome = scanner.nextLine()+".txt";
		Arq.openWrite(nome);
		System.out.println("Escreva uma frase: ");
		frase = scanner.nextLine();
		Arq.println(frase);
		Arq.close();
	}
}