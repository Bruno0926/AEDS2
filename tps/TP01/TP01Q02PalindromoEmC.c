#include<stdio.h>
#include<stdlib.h>
#include<stdbool.h>

//função para conferir se a frase ou palavra é palindroma
bool ehPalindromo(char *palavra){
    bool result = true;
    int tam = strlen(palavra);
    int x = tam - 1;
    
    //for para percorrer toda a palavra
    for(int i = 0; i < tam ; i++){
        //if para conferir se a palavra é igual invertida
        if(palavra[i] != palavra[x - i]){
            result = false;
        };
    };

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
            if(ehPalindromo(palavra)){
                printf("SIM\n");
            }else{
                printf("NAO\n");
            }
        }
    
    return 0;
}
