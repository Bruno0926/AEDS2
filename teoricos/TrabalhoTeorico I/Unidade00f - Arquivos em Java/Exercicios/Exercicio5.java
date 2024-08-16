package Exercicios;

import java.util.Scanner;

public class Exercicio5 {
    public static void main(String args[]){
        Arq Arq = new Arq();
        String primeiro,segundo,conteudo;
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Nome do arquivo 1: ");
		primeiro = scanner.nextLine();
		System.out.println("Nome do arquivo 2: ");
		segundo = scanner.nextLine();
		Arq.openRead(primeiro);
		conteudo = Arq.readAll();
		Arq.close();
		Arq.openWrite(segundo);
		Arq.println(conteudo.toUpperCase());
		Arq.close();
    }
}
