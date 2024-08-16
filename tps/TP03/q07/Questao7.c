#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <time.h>

#define bool      short
#define true      1
#define false     0


#define MAXTAM 100
char string[MAXTAM];

int numComparacoes = 0,numMovimentacoes = 0;

typedef struct String
{

	char string[MAXTAM];

}String;

typedef struct longString
{

	char string[MAXTAM * 20];

}longString;

typedef struct StarWars
{

	String* nome;
	String* corDoCabelo;
	String* corDaPele;
	String* corDosOlhos;
	String* anoNascimento;
	String* genero;
	String* homeworld;
	int altura;
	double peso;

}StarWars;

typedef struct CelulaDupla {
	StarWars* elemento;
	struct CelulaDupla* prox;
    struct CelulaDupla* ant;
} CelulaDupla;

typedef struct ListaDupla
{
	CelulaDupla* primeiro;
	CelulaDupla* ultimo;

}ListaDupla;

StarWars* new_StarWars();
String* new_String();
longString* new_longString();
void setPersonagem(char* diretorio, StarWars* Personagens);
bool isFim(char* entrada);
StarWars* clone(StarWars* x);
void imprime(StarWars* temp);
int TamanhoExpressao(char* string);
int charToInt(char* string);

//Lista
ListaDupla* new_ListaDupla();
CelulaDupla* new_CelulaDupla(StarWars* elemento);
void InserirInicio(ListaDupla* x,StarWars* y);
void InserirFim(ListaDupla* x,StarWars* y);
void Insert(ListaDupla* x,StarWars* y, int pos);
StarWars* RemoveInicio(ListaDupla* x);
StarWars* RemoveFim(ListaDupla* x);
StarWars* remover(ListaDupla* x,int pos);
int tamanho(ListaDupla* x);
void Mostra(ListaDupla* x);
void quicksort(ListaDupla* x);
void insercao(ListaDupla* lista);
void quicksortCabelo(ListaDupla* x,int esq, int dir);
void swap(CelulaDupla* i, CelulaDupla* j);
CelulaDupla* getCelulaPos(int pos,ListaDupla* x);


int main()
{

	String* entrada = new_String();
	scanf("%s", entrada->string);
	StarWars* Personagens;
	bool resp;

	ListaDupla* lista = new_ListaDupla();

	while (!isFim(entrada->string))
	{

		Personagens = new_StarWars();
		setPersonagem(entrada->string,Personagens);
		InserirFim(lista,Personagens);
		scanf("\n%s", entrada->string);

	}

    clock_t time = clock();

    quicksort(lista);

    time = clock() - time;

	Mostra(lista);

    FILE *arq = fopen("matricula_quicksort.txt","w");
    fprintf(arq,"655264 %d %d %lf\n",numComparacoes,numMovimentacoes,((double)time)/((CLOCKS_PER_SEC/1000)));

	return 0;

}

void setPersonagem(char* diretorio, StarWars* Personagens)
{

	String* altura = new_String();
	String* peso = new_String();
	longString* texto = new_longString();
	Personagens->nome = new_String();
	Personagens->genero = new_String();
	Personagens->homeworld = new_String();
	Personagens->corDoCabelo = new_String();
	Personagens->corDaPele = new_String();
	Personagens->corDosOlhos = new_String();
	Personagens->anoNascimento = new_String();

	char* linha = (char*)malloc(sizeof(char)*100);

	FILE* arq=fopen(diretorio, "r");

	fgets(texto->string,1000,arq);
	texto->string[strlen(texto->string)-1]='\0';

	linha = strstr(texto->string, "name");

	linha = strstr(linha, "\'");

	memmove(&linha[0], &linha[4], strlen(linha));

	strncpy(Personagens->nome->string,linha,TamanhoExpressao(linha));

	linha = strstr(texto->string, "height");

	linha = strstr(linha, "\'");

	memmove(&linha[0], &linha[4], strlen(linha));

	strncpy(altura->string,linha,TamanhoExpressao(linha));

	if ( strcmp(altura->string,"unknown") == 0 )
		Personagens->altura = 0;
	else
		Personagens->altura = atoi(altura->string);

	linha = strstr(texto->string, "mass");

	linha = strstr(linha, "\'");

	memmove(&linha[0], &linha[4], strlen(linha));

	strncpy(peso->string,linha,TamanhoExpressao(linha));

	if ( strcmp(peso->string,"unknown") == 0 )
		Personagens->peso = 0;
	else
		Personagens->peso = atof(peso->string);

	linha = strstr(texto->string, "hair_color");

	linha = strstr(linha, "\'");

	memmove(&linha[0], &linha[4], strlen(linha));

	strncpy(Personagens->corDoCabelo->string,linha,TamanhoExpressao(linha));


	linha = strstr(texto->string, "skin_color");

	linha = strstr(linha, "\'");

	memmove(&linha[0], &linha[4], strlen(linha));

	strncpy(Personagens->corDaPele->string,linha,TamanhoExpressao(linha));


	linha = strstr(texto->string, "eye_color");

	linha = strstr(linha, "\'");

	memmove(&linha[0], &linha[4], strlen(linha));

	strncpy(Personagens->corDosOlhos->string,linha,TamanhoExpressao(linha));


	linha = strstr(texto->string, "birth_year");

	linha = strstr(linha, "\'");

	memmove(&linha[0], &linha[4], strlen(linha));

	strncpy(Personagens->anoNascimento->string,linha,TamanhoExpressao(linha));


	linha = strstr(texto->string, "gender");

	linha = strstr(linha, "\'");

	memmove(&linha[0], &linha[4], strlen(linha));

	strncpy(Personagens->genero->string,linha,TamanhoExpressao(linha));



	linha = strstr(texto->string, "homeworld");

	linha = strstr(linha, "\'");

	memmove(&linha[0], &linha[4], strlen(linha));

	strncpy(Personagens->homeworld->string,linha,TamanhoExpressao(linha));

	fclose(arq);

}
StarWars* clone(StarWars* x)
{

	StarWars *temp;
	temp = x;

	return temp;

}

void imprime(StarWars* temp)
{

	printf("## %s ## %d ## %g ## %s ## %s ## %s ## %s ## %s ## %s ##", temp->nome->string,temp->altura,temp->peso,temp->corDoCabelo->string,temp->corDaPele->string,temp->corDosOlhos->string,temp->anoNascimento->string,temp->genero->string,temp->homeworld->string);

}

bool isFim(char* entrada)
{

	return ( entrada[0] == 'F' && entrada[1] == 'I' && entrada[2] == 'M' );

}

int TamanhoExpressao(char* string)
{
	int i = 0;
	while (string[i] != '\'' )
		i++;

	return i;
}

int charToInt(char* string)
{
	int i = 3,resultado;

	if (string[i + 1] != ' ')
		resultado = ((int)string[i] - 48) * 10 + ((int)string[i + 1] - 48);
	else
		resultado = ((int)string[i] - 48);

	return resultado;

}

String* new_String(){

	return (String*) malloc(sizeof(String));

}

longString* new_longString(){

	return (longString*) malloc(sizeof(longString));

}

StarWars* new_StarWars(){

	return (StarWars*) malloc(sizeof(StarWars));

}


ListaDupla* new_ListaDupla()
{
	ListaDupla* novo = (ListaDupla*)malloc(sizeof(ListaDupla));
    novo->primeiro = new_CelulaDupla(NULL);
    novo->ultimo = novo->primeiro;
	return novo;
}


CelulaDupla* new_CelulaDupla(StarWars* elemento) {
   CelulaDupla* nova = (CelulaDupla*) malloc(sizeof(CelulaDupla));
   nova->elemento = elemento;
   nova->ant = nova->prox = NULL;
   return nova;
}



void InserirInicio(ListaDupla* x, StarWars* y) {
   CelulaDupla* tmp = new_CelulaDupla(y);

   tmp->ant = x->primeiro;
   tmp->prox = x->primeiro->prox;
   x->primeiro->prox = tmp;
   if (x->primeiro == x->ultimo) {
      x->ultimo = tmp;
   } else {
      tmp->prox->ant = tmp;
   }
   tmp = NULL;
}



void InserirFim(ListaDupla* x,StarWars* y) {

   x->ultimo->prox = new_CelulaDupla(y);
   x->ultimo->prox->ant = x->ultimo;
   x->ultimo = x->ultimo->prox;
}



void Insert(ListaDupla* x, StarWars* y, int pos) {

   int tam = tamanho(x);

   if(pos < 0 || pos > tam){
      errx(1, "Erro ao remover (posicao %d/%d invalida!", pos, tam);
   } else if (pos == 0){
      InserirInicio(x,y);
   } else if (pos == tam){
      InserirFim(x,y);
   } else {

      CelulaDupla* i = x->primeiro;
      int j;
      for(j = 0; j < pos; j++, i = i->prox);

      CelulaDupla* tmp = new_CelulaDupla(y);
      tmp->ant = i;
      tmp->prox = i->prox;
      tmp->ant->prox = tmp->prox->ant = tmp;
      tmp = i = NULL;
   }
}



StarWars* RemoveInicio(ListaDupla* x) {
   if (x->primeiro == x->ultimo) {
      errx(1, "Erro ao remover (vazia)!");
   }

   CelulaDupla* tmp = x->primeiro;
   x->primeiro = x->primeiro->prox;
   StarWars* resp = clone(x->primeiro->elemento);
   tmp->prox = x->primeiro->ant = NULL;
   free(tmp);
   tmp = NULL;
   return resp;
}


StarWars* RemoveFim(ListaDupla* x) {
   if (x->primeiro == x->ultimo) {
      errx(1, "Erro ao remover (vazia)!");
   }
   StarWars* resp = clone(x->ultimo->elemento);
   x->ultimo = x->ultimo->ant;
   x->ultimo->prox->ant = NULL;
   free(x->ultimo->prox);
   x->ultimo->prox = NULL;
   return resp;
}



StarWars* remover(ListaDupla* x,int pos) {
   StarWars* resp;
   int tam = tamanho(x);

   if (x->primeiro == x->ultimo){
      errx(1, "Erro ao remover (vazia)!");
   } else if(pos < 0 || pos >= tam){
      errx(1, "Erro ao remover (posicao %d/%d invalida!", pos, tam);
   } else if (pos == 0){
      resp = RemoveInicio(x);
   } else if (pos == tam - 1){
      resp = RemoveFim(x);
   } else {

      CelulaDupla* i = x->primeiro->prox;
      int j;
      for(j = 0; j < pos; j++, i = i->prox);

      i->ant->prox = i->prox;
      i->prox->ant = i->ant;
      resp = clone(i->elemento);
      i->prox = i->ant = NULL;
      free(i);
      i = NULL;
   }

   return resp;
}


void Mostra(ListaDupla* x) {
   CelulaDupla* i;
   for (i = x->primeiro->prox; i != NULL; i = i->prox) {
	   printf(" ");
   	   imprime(i->elemento);
   	   printf("\n");
   }

}

void quicksort(ListaDupla* x)
{

	quicksortCabelo(x,0, tamanho(x)-1);
	quicksortCabelo(x,0, tamanho(x)-1);
	insercao(x);


}

CelulaDupla* getCelulaPos(int pos,ListaDupla* x)
{
	CelulaDupla* resp;

    int i = 0;

    for(resp = x->primeiro->prox; i < pos; resp = resp->prox,i++);

    return resp;
}

void quicksortCabelo(ListaDupla* x,int esq, int dir)
{
        int i = esq, j = dir;
        StarWars* pivo = clone(getCelulaPos((int)((esq+dir)/2),x)->elemento);

        while (i <= j) {
            while (strcmp(getCelulaPos(i,x)->elemento->corDoCabelo->string,pivo->corDoCabelo->string) < 0 ) {
				i++;
				numComparacoes++;
            }

			while (strcmp(getCelulaPos(j,x)->elemento->corDoCabelo->string,pivo->corDoCabelo->string) > 0 ) {
				j--;
				numComparacoes++;
            }

			if (i <= j) {
				numMovimentacoes++;
                swap(getCelulaPos(i,x), getCelulaPos(j,x));
                i++;
                j--;
            }
        }
        if (esq < j)
		     quicksortCabelo(x,esq, j);
        if (i < dir)
             quicksortCabelo(x,i, dir);
}
void insercao(ListaDupla* lista) {

        CelulaDupla* tmp = lista->primeiro->prox;
        CelulaDupla* inicio = lista->primeiro->prox;
        CelulaDupla* pMenor = inicio;
        StarWars* menor;
        StarWars* tmp2;

        while(inicio->prox != NULL){
            menor = inicio->elemento;
            tmp = inicio->prox;
            pMenor = inicio;
            while(tmp->prox != NULL){
if(strcmp(tmp->elemento->corDoCabelo->string, menor->corDoCabelo->string) == 0 && strcmp(tmp->elemento->nome->string, menor->nome->string)<0) {
                 pMenor = tmp;
                    menor = tmp->elemento;
                }
                tmp = tmp->prox;
            }
            tmp2 = pMenor->elemento;
            pMenor->elemento = inicio->elemento;
            inicio->elemento = tmp2;

            inicio = inicio->prox;

        }
    }

void swap(CelulaDupla* i, CelulaDupla* j) {
   StarWars* temp = clone(i->elemento);
   i->elemento = clone(j->elemento);
   j->elemento = clone(temp);
}

int tamanho(ListaDupla* x) {
   int tamanho = 0;
   CelulaDupla* i;
   for(i = x->primeiro; i != x->ultimo; i = i->prox, tamanho++);
   return tamanho;
}

