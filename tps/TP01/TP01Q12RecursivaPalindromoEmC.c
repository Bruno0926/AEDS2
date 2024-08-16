#include<stdio.h>
#include<stdlib.h>
#include<stdbool.h>

//função para conferir se a frase ou palavra é palindroma
bool ehPalindromo(char *palavra, int pos){
    bool result = true;
    int tam = strlen(palavra);
    int x = tam - 1;
    
    
    if(pos < 0 && pos > tam){
        result = false;
    }else{
        //if para conferir se a palavra é igual invertida
        if(palavra[pos] != palavra[x - pos]){
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
bool ehFim(char palavra[]){
    bool result;
    if((palavra[0]=='F')&&(palavra[1]=='I')&&(palavra[2]=='M')){
        result = true;
    }else{
        result = false;
    };
    
    return result;;
}
//MAIN
int main(){
    char palavra[1000];
        while(!ehFim(palavra)){
            scanf ("%[^\n]%*1[\n]", palavra);
            if(ehPalindromo(palavra, 0)){
                printf("SIM\n");
            }else{
                printf("NAO\n");
            }
        }
    
    return 0;
}
