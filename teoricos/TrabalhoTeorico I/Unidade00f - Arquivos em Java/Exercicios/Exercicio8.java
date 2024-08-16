package Exercicios;

import java.util.Scanner;

public class Exercicio8 {
    public static void main(String args[]){

        String primeiro, conteudo;
		int ascii, k = 3;
		Scanner scanner = new Scanner(System.in);
		System.out.println("Nome do arquivo que voce deseja descriptografar: ");
		primeiro = scanner.nextLine();
		Arq.openRead(primeiro);
		conteudo = Arq.readAll();
		for(int i = 0; i< conteudo.length(); i++) {
			ascii = (int)conteudo.charAt(i) - k;
			System.out.println((char)ascii);
			
		}
    }
}
