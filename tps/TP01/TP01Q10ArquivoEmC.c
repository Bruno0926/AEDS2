#include <stdio.h>
#include <stdlib.h>
#include <string.h>
//função para ler um numero e colocar em um arquivo
void arquivo(int n){
    //declaração de variaveis
    FILE *arquivo;
    double dados;
    long posi;
    //conferindo e o numero digitado é valido 
    if (n >= 0){
        //abrindo arquivo
	    arquivo = fopen ("arquivo.txt","wb+");
	    //lendo dados do teclado
        for (int i = 0; i < n; i++){
	        scanf("%lf", &dados);
            //guardando dados no arquivo
		    fprintf(arquivo, "%lf\n", dados);
            //indo para a leitura do proximo dado
            posi = ((i+1)*sizeof(double));
            fseek(arquivo, posi, SEEK_SET);
	    }

        posi = (n-1)*sizeof(double);
        double x;

	    for (int i = 0; i < n;i++){ 
            fseek (arquivo, posi, SEEK_SET);
            fscanf (arquivo, "%lf", &x);
	        int y;
            y = x; 
            //printar o numero na tela 
		    if (x == y){
		        printf ("%d\n",y);
	        }else{
		        printf ("%g\n",x);
            }

            posi = posi - sizeof(double);
            fseek(arquivo, posi, SEEK_SET);
	    }
        //fechando arquivo
        fclose(arquivo);
    }
}
//MAIN
int main(){
    int n;
    scanf("%d", &n);
    
    arquivo(n);
    return 0;
}