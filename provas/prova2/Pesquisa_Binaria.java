import java.util.Scanner;

public class Pesquisa_Binaria {
    public static void main(String[] args) {

        int[] vetor = new int[8];
         for(int i = 0; i < vetor.length; i ++){
           vetor[i] = i + 1;
           //System.out.println(vetor[i]);
        }
        
        Scanner input = new Scanner(System.in);

        System.out.println("qual numero voce busca? ");
        int numero = input.nextInt();

        int contador = 0;
        boolean achou = false;
        int inicio = 0;
        int fim = vetor.length - 1;
        int meio;

        while(inicio <= fim){
            meio = (int)((inicio + fim) / 2);
            contador ++;
            if(vetor[meio] == numero){
                achou = true;
                break;
            } else if(vetor[meio] < numero){
                inicio = meio + 1;
            } else{
                fim = meio - 1;
            }
        }
        
        System.out.println("quantidade de testes: " + contador);
        
        if(achou == true){
            System.out.println("ACHOU!");
        }else{
            System.out.println("NAO ACHOU!");
        }
    }
}




