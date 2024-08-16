public class TP01Q03CiframentoEmJava {

    //função para fazer o ciframento de cesar
    public static String ciframento(String palavra){
        String criptografada = "";
        int tam = palavra.length();
        //for para percorrer toda a palavra e criptografala inteira
        for(int i = 0; i < tam; i++){
            //criptografando
            criptografada = criptografada + (char)(palavra.charAt(i)+3);
        }
        //retorna palavra criptografada
        return criptografada;
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
            MyIO.println(ciframento(palavra));
        }
    }
}
