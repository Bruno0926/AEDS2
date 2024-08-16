package Exercicios;

import java.util.Scanner;

public class Exercicio3 {
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
		System.out.println("Nome do arquivo para ser lido: ");
		nome = scanner.nextLine();
		Arq.openRead(nome);
		frase = Arq.readAll();
		System.out.println(frase.toUpperCase());
	}
}
