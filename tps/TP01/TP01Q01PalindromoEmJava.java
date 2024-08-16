public class TP01Q01PalindromoEmJava{

    //função para conferir se a frase ou palavra é palindroma
    public static boolean ehPalindromo(String palavra){
        boolean result = true;
        String reverso = "";
        String espaco = "";
        int x = palavra.length() - 1;

        //for para inverter a palavra
        for(int i = 0; i < palavra.length() ; i++){
            if(palavra.charAt(i) >= 'a' && palavra.charAt(i) <= 'z' || palavra.charAt(i) >= 'A' && palavra.charAt(i) <= 'Z'){
                espaco = espaco + palavra.charAt(i);
            };
            
            if(palavra.charAt(x) >= 'a' && palavra.charAt(x) <= 'z' || palavra.charAt(x) >= 'A' && palavra.charAt(x) <= 'Z'){
                reverso = reverso + palavra.charAt(x);
            };
            x--;
        };

        //for para conferir se a palavra invertida é igual a original
        for(int i = 0; i < espaco.length(); i++){
            if(espaco.charAt(i) == reverso.charAt(i)){
                result = true;
            }else{
                result = false;
                break;
            };
        }

        return result;
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
            if(ehPalindromo(palavra)){
                MyIO.println("SIM");
            }else{
                MyIO.println("NAO");
            }
        }   
    }
}