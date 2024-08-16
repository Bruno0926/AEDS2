public class TP01Q06IsEmJava {
    //função para verificar se palavra é vogal
    public static boolean isVogal(String palavra){
        int tam = palavra.length();
        //for para percorrer toda palavra
        for(int i = 0; i < tam; i++){
            //if para fazer a validação
            if(palavra.charAt(i) != 'a' && palavra.charAt(i) != 'e' && palavra.charAt(i) != 'i' && palavra.charAt(i) != 'o' && palavra.charAt(i) != 'u'){
                return false;
            }
        }

        return true;
    }
    //função para verificar se palavra é consoante
    public static boolean isConsoante(String palavra){
        int tam = palavra.length();
        //for para percorrer toda palavra
        for(int i = 0; i < tam; i++){
            //if else para fazer a validação
            if(isVogal(palavra)){
                return false;
            }else if(!(palavra.charAt(i) >= 'b' && palavra.charAt(i) <= 'z')){
                return false;
            }
        }

        return true;
    }
    //função para verificar se palavra é um numero inteiro
    public static boolean isInteiro(String palavra){
        int tam = palavra.length();
        //for para percorrer toda palavra
        for(int i = 0; i < tam; i++){
            //if para fazer a validação
            if(palavra.charAt(i) < '0' || palavra.charAt(i) > '9'){
                return false;
            }
        }

        return true;
    }
    //função para verificar se palavra é um numero real
    public static boolean isReal(String palavra){
        boolean isNumero = false;
        boolean isReal = false;
        //for para percorrer toda palavra
        for(int x=0; x<palavra.length(); x++){
            //if else para fazer a validação
            if((palavra.charAt(x) >= '0' && palavra.charAt(x) <= '9') || palavra.charAt(x) == '.'){ 
                isNumero = true;
                if(palavra.charAt(x) == '.' && x>0 && x<palavra.length()-1){ 
                    if(!isReal) 
                        isReal = true;
                    else
                        return false;
                }else{
                    if(palavra.charAt(x) == '.'){
                        return false;
                    } 
                }
            }else{
                return false;
            }
        }

        if(isNumero && isReal){
            return true;
        }else{
            return false;
        }
    }
    //função para ver se a resposta vai ser SIM ou NÃO
    public static String resposta(boolean result){
        String resposta;
        
        if (result){
	        resposta = "SIM";
        }else{
	        resposta = "NAO";
        }

        return resposta;
    }
    //função para ver se a palavra é fim
    public static boolean ehFim(String palavra){
        return(palavra.length() == 3 && palavra.charAt(0) == 'F' && palavra.charAt(1) == 'I' && palavra.charAt(2) == 'M');
    }
    //MAIN
    public static void main(String[] args){
        String palavra = "teste";
        while(!ehFim(palavra)){
            palavra = MyIO.readLine();
            MyIO.println(resposta(isVogal(palavra))+" "+resposta(isConsoante(palavra))+" "+resposta(isInteiro(palavra))+" "+resposta(isReal(palavra)));
        }
    }
}
