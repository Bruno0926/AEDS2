#include<stdio.h>
#include<stdlib.h>
#include<stdbool.h>
#include <string.h>

//função para verificar se palavra é vogal
bool isVogal(char palavra[]){
    int tam = strlen(palavra);
    //for para percorrer toda palavra
    for(int i = 0; i < tam - 1; i++){
        //if para fazer a validação
        if(palavra[i] != 'a' && palavra[i] != 'e' && palavra[i] != 'i' && palavra[i] != 'o' && palavra[i] != 'u'){
            return false;
        }
    }

    return true;
}

//função para verificar se palavra é consoante
bool isConsoante(char palavra[]){
    int tam = strlen(palavra);
    //for para percorrer toda palavra
    for(int i = 0; i < tam - 1; i++){
        //if else para fazer a validação
        if(isVogal(palavra)){
            return false;
        }else if(!(palavra[i] >= 'b' && palavra[i] <= 'z')){
            return false;
        }
    }

    return true;
}

bool isInteiro(char palavra[]){
    int tam = strlen(palavra);
    //for para percorrer toda palavra
    for(int i = 0; i < tam - 1; i++){
        //if para fazer a validação
        if(palavra[i] < '0' || palavra[i] > '9'){
            return false;
        }
    }

    return true;
}
//função para verificar se palavra é um numero real
bool isReal(char palavra[]){
    int tam = strlen(palavra);
    bool isNumero = false;
    bool isReal = false;
    //for para percorrer toda palavra
    for(int i=0; i<tam - 1; i++){
        //if else para fazer a validação
        if((palavra[i] >= '0' && palavra[i] <= '9') || palavra[i] == '.'){ 
            isNumero = true;
            if(palavra[i] == '.' && i>0 && i<tam-1){ 
                if(!isReal) 
                    isReal = true;
                else
                    return false;
            }else{
                if(palavra[i] == '.'){
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
void resposta(bool result){
    char resposta[] = " ";
        
    if (result){
	    printf("SIM ");
    }else{
	    printf("NAO ");
    }

    return resposta;
}

//função para conferir se a palavra é FIM
bool ehFim(char palavra[]){
    bool result;
    if((palavra[0]=='F')&&(palavra[1]=='I')&&(palavra[2]=='M')){
        result = true;
    }else{
        result = false;
    };
    
    return result;;
}

int main(){
    char palavra[1000] = "teste";
    while(!ehFim(palavra)){
        fgets(palavra, 1000, stdin);
        resposta(isVogal(palavra)); 
        resposta(isConsoante(palavra));
        resposta(isInteiro(palavra));
        resposta(isReal(palavra));
        printf("\n");
    }
}