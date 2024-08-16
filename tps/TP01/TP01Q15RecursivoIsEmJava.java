import javax.swing.text.html.HTMLDocument.RunElement;
import javax.swing.text.html.HTMLDocument.HTMLReader.IsindexAction;

public class TP01Q15RecursivoIsEmJava {
    //função para verificar se palavra é vogal
    public static boolean isVogal(String palavra, int i){
        int tam = palavra.length();
        boolean result = true;
        //if para percorrer toda palavra
        if(i < tam){
            //if para fazer a validação
            if(palavra.charAt(i) != 'a' && palavra.charAt(i) != 'e' && palavra.charAt(i) != 'i' && palavra.charAt(i) != 'o' && palavra.charAt(i) != 'u'){
                return false;
            }else{
                result = isVogal(palavra, i + 1);
            }
        }

        return result;
    }
    //função para verificar se palavra é consoante
    public static boolean isConsoante(String palavra, int i){
        int tam = palavra.length();
        boolean result = true;
        //if para percorrer toda palavra
        if(i < tam){
            //if else para fazer a validação
            if(isVogal(palavra, 0)){
                return false;
            }else if(!(palavra.charAt(i) >= 'b' && palavra.charAt(i) <= 'z')){
                return false;
            }else{
                result = isConsoante(palavra, i + 1);
            }
        }

        return result;
    }
    //função para verificar se palavra é um numero inteiro
    public static boolean isInteiro(String palavra, int i){
        int tam = palavra.length();
        boolean result = true;
        //for para percorrer toda palavra
        if(i < tam){
            //if para fazer a validação
            if(palavra.charAt(i) < '0' || palavra.charAt(i) > '9'){
                return false;
            }else{
                result = isInteiro(palavra, i + 1);
            }
        }

        return result;
    }
    //função para verificar se palavra é um numero real
    public static boolean isReal(String palavra, int i){
        boolean isNumero = false;
        boolean isReal = false;
        boolean result = true;
        int tam = palavra.length();
        //for para percorrer toda palavra
        if(i < tam){
            //if else para fazer a validação
            if((palavra.charAt(i) >= '0' && palavra.charAt(i) <= '9') || palavra.charAt(i) == '.'){ 
                isNumero = true;
                if(palavra.charAt(i) == '.' && i>0 && i<palavra.length()-1){ 
                    if(!isReal) 
                        isReal = true;
                    else
                        return false;
                }else{
                    if(palavra.charAt(i) == '.'){
                        return false;
                    }else{
                        result = isReal(palavra, i +1);
                    } 
                }
            }else{
                return false;
            }

            return result;
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
            MyIO.println(resposta(isVogal(palavra, 0))+" "+resposta(isConsoante(palavra, 0))+" "+resposta(isInteiro(palavra, 0))+" "+resposta(isReal(palavra, 0)));
        }
    }
}
