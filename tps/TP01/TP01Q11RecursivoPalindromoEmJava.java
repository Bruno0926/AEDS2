public class TP01Q11RecursivoPalindromoEmJava{

    //função para conferir se a frase ou palavra é palindroma
    public static boolean ehPalindromo(String palavra, int pos){
        boolean result = true;
        int tam = palavra.length();
        int x = tam - 1;

        if(pos > tam && pos < 0){
            result = false;
        }else{
            if(palavra.charAt(pos) != palavra.charAt(x - pos)){
                result = false;
            }else{
                result = true;
            };
            if(pos + 1 < tam && result == true){
                result = (result && ehPalindromo(palavra, pos + 1));
            }
        }
            


        return result;
    }
    //função para conferir se a palavra é FIM
    public static boolean ehFim(String palavra){
        return(palavra.length() == 3 && palavra.charAt(0) == 'F' && palavra.charAt(1) == 'I' && palavra.charAt(2) == 'M');
    }

    //MAIN
    public static void main(String[] args){
        String palavra = " ";
        while(!ehFim(palavra)){
            palavra = MyIO.readLine();
            if(ehPalindromo(palavra, 0)){
                MyIO.println("SIM");
            }else{
                MyIO.println("NAO");
            }
        }   
    }
}