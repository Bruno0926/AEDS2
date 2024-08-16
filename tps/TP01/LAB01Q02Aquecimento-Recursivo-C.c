#include <stdio.h>
#include <stdbool.h>
#include <stddef.h>
#include <string.h>

bool maiuscula(char string){
    return(string >= 'A' && string <= 'Z');
}

bool FIM(char string[]){
    bool result;
    if((string[0]=='F')&&(string[1]=='I')&&(string[2]=='M')){
        result = true;
    }else{
        result = false;
    };
    
    return result;
}

quantidadeMaiusculas(char string[], int posicao){
    int result = 0;
    if(posicao < strlen(string)){
        if(maiuscula(string[posicao])){
            result = 1 + quantidadeMaiusculas(string,++posicao);
        }
        else{
            result = quantidadeMaiusculas(string,++posicao);
        }
    }
    return result;
}

int main(){
    char string[1000]; 
    
    while(!FIM(string)){
        fgets(string,1000,stdin);
        printf("%i\n",quantidadeMaiusculas(string, 0));
    }
}