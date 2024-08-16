#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <math.h>

#define bool      short
#define true      1
#define false     0


#define MAXTAM 100
char string[MAXTAM];

int cont;


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

typedef struct Celula {
	StarWars* elemento;
	struct Celula* prox;
} Celula;

typedef struct Pilha
{
	Celula* topo;

}Pilha;


StarWars* new_StarWars();
String* new_String();
longString* new_longString();
void setPersonagem(char* diretorio, StarWars* Personagens);
bool isFim(char* entrada);
StarWars* clone(StarWars* x);
void imprime(StarWars* temp);
int tamanhoExpressao(char* string);
int CharToInt(char* string);


Pilha* new_Pilha();
Celula* novaCelula(StarWars* elemento);
void Insert(Pilha* p,StarWars* x);
StarWars* remover(Pilha* p);
void Mostra(Pilha* p);
void MostraRec(Celula* i);

int main()
{

	String* entrada = new_String();
	scanf("%s", entrada->string);
	StarWars* Personagens;
	StarWars* tmp;

	Pilha* pilha = new_Pilha();

	while (!isFim(entrada->string))
	{

		Personagens = new_StarWars();
		tmp = new_StarWars();
		setPersonagem(entrada->string,Personagens);

		Insert(pilha,Personagens);
		scanf("\n%s", entrada->string);

	}

	int n,pos;
	scanf("%d", &n);

	for (int i = 0; i <= n; i++)
	{

		tmp = new_StarWars();
		Personagens = new_StarWars();
		char* endereco = (char*)malloc(sizeof(char)*100);
		fgets(entrada->string, sizeof(entrada->string), stdin);
		entrada->string[strlen(entrada->string)-1] = '\0';

		if ( entrada->string[0] == 'I' )
		{

			endereco = strstr(entrada->string,"/tmp");
			setPersonagem(endereco,Personagens);
			Insert(pilha,Personagens);

		}
		else if ( entrada->string[0] == 'R' )
		{

			Personagens = remover(pilha);
			printf("(R) %s\n", Personagens->nome->string);

		}

	}

	Mostra(pilha);

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

	char* line = (char*)malloc(sizeof(char)*100);

	FILE* arquivo=fopen(diretorio, "r");

	fgets(texto->string,1000,arquivo);
	texto->string[strlen(texto->string)-1]='\0';

	line = strstr(texto->string, "name");

	line = strstr(line, "\'");

	memmove(&line[0], &line[4], strlen(line));

	strncpy(Personagens->nome->string,line,tamanhoExpressao(line));


	line = strstr(texto->string, "height");

	line = strstr(line, "\'");

	memmove(&line[0], &line[4], strlen(line));

	strncpy(altura->string,line,tamanhoExpressao(line));

	if ( strcmp(altura->string,"unknown") == 0 )
		Personagens->altura = 0;
	else
		Personagens->altura = atoi(altura->string);

	line = strstr(texto->string, "mass");

	line = strstr(line, "\'");

	memmove(&line[0], &line[4], strlen(line));

	strncpy(peso->string,line,tamanhoExpressao(line));

	if ( strcmp(peso->string,"unknown") == 0 )
		Personagens->peso = 0;
	else
		Personagens->peso = atof(peso->string);

	line = strstr(texto->string, "hair_color");

	line = strstr(line, "\'");

	memmove(&line[0], &line[4], strlen(line));

	strncpy(Personagens->corDoCabelo->string,line,tamanhoExpressao(line));



	line = strstr(texto->string, "skin_color");

	line = strstr(line, "\'");

	memmove(&line[0], &line[4], strlen(line));

	strncpy(Personagens->corDaPele->string,line,tamanhoExpressao(line));


	line = strstr(texto->string, "eye_color");

	line = strstr(line, "\'");

	memmove(&line[0], &line[4], strlen(line));

	strncpy(Personagens->corDosOlhos->string,line,tamanhoExpressao(line));


	line = strstr(texto->string, "birth_year");

	line = strstr(line, "\'");

	memmove(&line[0], &line[4], strlen(line));

	strncpy(Personagens->anoNascimento->string,line,tamanhoExpressao(line));


	line = strstr(texto->string, "gender");

	line = strstr(line, "\'");

	memmove(&line[0], &line[4], strlen(line));

	strncpy(Personagens->genero->string,line,tamanhoExpressao(line));



	line = strstr(texto->string, "homeworld");

	line = strstr(line, "\'");

	memmove(&line[0], &line[4], strlen(line));

	strncpy(Personagens->homeworld->string,line,tamanhoExpressao(line));

	fclose(arquivo);

}
StarWars* clone(StarWars* x)
{

	StarWars *temp;
	temp = x;

	return temp;

}

void imprime(StarWars* temp)
{

	printf(" ## %s ## %d ## 0 ## %s ## %s ## %s ## %s ## %s ## %s ##", temp->nome->string,temp->altura,temp->corDoCabelo->string,temp->corDaPele->string,temp->corDosOlhos->string,temp->anoNascimento->string,temp->genero->string,temp->homeworld->string);

}

bool isFim(char* entrada)
{

	return ( entrada[0] == 'F' && entrada[1] == 'I' && entrada[2] == 'M' );

}

int tamanhoExpressao(char* string)
{
	int i = 0;
	while (string[i] != '\'' )
		i++;

	return i;
}

int CharToInt(char* string)
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


Pilha* new_Pilha()
{
	Pilha* novo = (Pilha*)malloc(sizeof(Pilha));
    novo->topo = NULL;
	return novo;
}

Celula* novaCelula(StarWars* elemento) {
   Celula* nova = (Celula*) malloc(sizeof(Celula));
   nova->elemento = clone(elemento);
   nova->prox = NULL;
   return nova;
}


void Insert(Pilha* p,StarWars* x) {
   Celula* tmp = novaCelula(x);
   tmp->prox = p->topo;
   p->topo = tmp;
   tmp = NULL;
}



StarWars* remover(Pilha* p) {
   if (p->topo == NULL) {
      errx(1, "Erro ao remover!");
   }

   StarWars* resp = clone(p->topo->elemento);
   Celula* tmp = p->topo;
   p->topo = p->topo->prox;
   tmp->prox = NULL;
   free(tmp);
   tmp = NULL;
   return resp;
}



void Mostra(Pilha* p) {
   cont = 0;
   MostraRec(p->topo);
}

void MostraRec(Celula* i) {

	if (i->prox != NULL ) {
		MostraRec(i->prox);
		cont++;
	}
	printf("[%d] ",cont);
	imprime(i->elemento);
	printf("\n");
}
