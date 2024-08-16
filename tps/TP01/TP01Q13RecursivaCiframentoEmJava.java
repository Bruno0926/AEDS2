public class TP01Q13RecursivaCiframentoEmJava {

    //função para fazer o ciframento de cesar
    public static String ciframento(String palavra, int pos){
        String criptografada = "";
        int tam = palavra.length();
        //if para percorrer toda a palavra e criptografala inteira de forma recursiva
        if(pos < tam - 1){
            //criptografando
            criptografada = ciframento(palavra, pos + 1);
        }
        
        //retorna palavra criptografada
        return (char)(palavra.charAt(pos) + 3) + criptografada;
    }

    //função para conferir se a palavra é FIM
    public static boolean ehFim(String palavra){
        return(palavra.length() == 3 && palavra.charAt(0) == 'F' && palavra.charAt(1) == 'I' && palavra.charAt(2) == 'M');
    }
    
    //MAIN
    public static void main(String[] args){
        String palavra = "teste";
        while(!ehFim(palavra)){
            palavra = MyIO.readLine();
            MyIO.println(ciframento(palavra, 0));
        }
    }
}
