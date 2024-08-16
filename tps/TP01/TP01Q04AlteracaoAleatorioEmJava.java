import java.util.Random;

public class TP01Q04AlteracaoAleatorioEmJava {
    //função para fazer a troca das letras aleatoriamente
    public static String alteracaoAleatoria(String palavra){
        //declaração de variaveis alterada para ser palavra com as substituições e tam para guardar o tamanho da palavra
        String alterada = "";
        int tam = palavra.length();
        //gerador de caracteres aleatorios
        Random gerador = new Random();
        gerador.setSeed(4);
        //variaveis para guardar o primeira e o segundo caractere gerados
        char primeira = (char)('a' + (Math.abs(gerador.nextInt())%26));
        char segunda = (char)('a' + (Math.abs(gerador.nextInt())%26));
        //for para percorrer toda a palavra
        for(int i = 0; i < tam; i++){
            //if else para verificar as letras da palavra devem ser substituidas
            if(palavra.charAt(i) == primeira){
                alterada = alterada + segunda;
            }else{
                alterada = alterada + palavra.charAt(i);
            }
        } 

        return alterada;
    }
    //função para verificar se a palavra é FIM
    public static boolean ehFim(String palavra){
        return(palavra.length() == 3 && palavra.charAt(0) == 'F' && palavra.charAt(1) == 'I' && palavra.charAt(2) == 'M');
    }
    //MAIN
    public static void main(String[] args){
        String palavra = "teste";
        while(!ehFim(palavra)){
            palavra = MyIO.readLine();
            MyIO.println(alteracaoAleatoria(palavra));
        }
    }
}
