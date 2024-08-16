#include <stdbool.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <time.h>

// Definição do registro do personagem
typedef struct Personagem
{
    char nome[40];
    int altura;
    double peso;
    char corDoCabelo[40];
    char corDaPele[40];
    char corDosOlhos[40];
    char anoNascimento[40];
    char genero[40];
    char homeworld[40];
} Personagem;

// Função para retornar o resto da divisão com double
double fmod(double x, double y)
{
    return x - (int)(x / y) * y;
}

// Capturar o atributo entre aspas simples
void leituraAtributo(char atributo[], char descricaoPersonagem[], int index)
{
    int i = 0;

    while (descricaoPersonagem[index] != '\'')
    {
        atributo[i] = descricaoPersonagem[index];

        i++;
        index++;
    }

    atributo[i] = '\0';
}

// Função para testar o fim do arquivo
bool testaFim(char palavra[])
{
    bool teste = false;

    if (palavra[0] == 'F' && palavra[1] == 'I' && palavra[2] == 'M')
    {
        teste = true;
    }

    return teste;
}

// Função para estruturar o personagem
Personagem montaPersonagem(char camArq[])
{
    FILE *leitura = fopen(camArq, "r");

    char descricaoPersonagem[1000];

    fscanf(leitura, " %[^\n]s", descricaoPersonagem);

    Personagem personagem; // Cria a variável struct

    int contador = 0;

    for (int i = 0; i < strlen(descricaoPersonagem); i++)
    {
        if (descricaoPersonagem[i] == ':')
        {
            char atributo[50];
            contador++;

            switch (contador)
            {
            case 1:
                leituraAtributo(atributo, descricaoPersonagem, i + 3);
                strcpy(personagem.nome, atributo);
                break;
            case 2:
                leituraAtributo(atributo, descricaoPersonagem, i + 3);
                personagem.altura = atoi(atributo);
                break;
            case 3:
                leituraAtributo(atributo, descricaoPersonagem, i + 3);
                for (int i = 0; i < strlen(atributo); i++)
                {
                    if (atributo[i] == ',')
                    {
                        atributo[i] = atributo[i - 1];
                        atributo[i - 1] = '0';
                    }
                }
                personagem.peso = atof(atributo);
                break;
            case 4:
                leituraAtributo(atributo, descricaoPersonagem, i + 3);
                strcpy(personagem.corDoCabelo, atributo);
                break;
            case 5:
                leituraAtributo(atributo, descricaoPersonagem, i + 3);
                strcpy(personagem.corDaPele, atributo);
                break;
            case 6:
                leituraAtributo(atributo, descricaoPersonagem, i + 3);
                strcpy(personagem.corDosOlhos, atributo);
                break;
            case 7:
                leituraAtributo(atributo, descricaoPersonagem, i + 3);
                strcpy(personagem.anoNascimento, atributo);
                break;
            case 8:
                leituraAtributo(atributo, descricaoPersonagem, i + 3);
                strcpy(personagem.genero, atributo);
                break;
            case 9:
                leituraAtributo(atributo, descricaoPersonagem, i + 3);
                strcpy(personagem.homeworld, atributo);

                i = strlen(descricaoPersonagem); // Encerra os ciclos de repetição desnecessários
                break;
            default:
                break;
            }
        }
    }

    fclose(leitura);

    return personagem;
}

// Função para trocar os elementos de lugar
void trocaElementos(Personagem listPerson[], int posicaoAtual, int posicaoMenor)
{
    Personagem personagemtempoorario = listPerson[posicaoAtual];
    listPerson[posicaoAtual] = listPerson[posicaoMenor];
    listPerson[posicaoMenor] = personagemtempoorario;
}

// Função para Ordenação por Seleção Recursiva
void ordenaPorSelecao(Personagem listPerson[], int index, int tamanhoVetor, int *ptrComp, int *ptrTroca)
{
    if (index == (tamanhoVetor - 2))
    {
        *ptrComp += 1;

        if (strcmp(listPerson[index].nome, listPerson[index + 1].nome) > 0)
        {
            *ptrComp += 1;
            *ptrTroca += 1;
            trocaElementos(listPerson, index, index + 1);
        }
    }
    else
    {
        int menor = index;

        for (int i = index; i < tamanhoVetor; i++)
        {
            *ptrComp += 1;

            if (strcmp(listPerson[i].nome, listPerson[menor].nome) < 0)
            {
                menor = i;
            }
        }

        if (menor != index)
        {
            *ptrTroca += 1;

            trocaElementos(listPerson, index, menor);
        }

        ordenaPorSelecao(listPerson, index + 1, tamanhoVetor, ptrComp, ptrTroca);
    }
}

// Imprimir os resultados
void imprimir(Personagem listaPersonagens[], int tamanhoTotal)
{
    for (int i = 0; i < tamanhoTotal; i++)
    {
        printf(" ## %s", listaPersonagens[i].nome);
        printf(" ## %d", listaPersonagens[i].altura);
        if (fmod(listaPersonagens[i].peso, 1) == 0)
            printf(" ## %.0lf", listaPersonagens[i].peso);
        else
            printf(" ## %.1lf", listaPersonagens[i].peso);
        printf(" ## %s", listaPersonagens[i].corDoCabelo);
        printf(" ## %s", listaPersonagens[i].corDaPele);
        printf(" ## %s", listaPersonagens[i].corDosOlhos);
        printf(" ## %s", listaPersonagens[i].anoNascimento);
        printf(" ## %s", listaPersonagens[i].genero);
        printf(" ## %s", listaPersonagens[i].homeworld);
        printf(" ## \n");
    }
}

// Função para criar arquivo de log
void newLog(time_t inicio, int numeroComparacoes, int numeroMovimentacoes)
{
    float tempoo;
    time_t final = time(NULL); // Marcar o final da execução

    tempoo = difftime(final, inicio);

    FILE *log = fopen("matricula_selecaoRecursiva.txt", "w");

    fprintf(log, "Matricula: 790052\tNumero Comparacoes: %d\tNumero Movimentacoes: %d\ttempoo Execucao: %fs\n", numeroComparacoes, numeroMovimentacoes, tempoo);

    fclose(log);
}

int main(void)
{
    char camArq[100], nomePersonagem[100];
    int contTam = 0, numeroComparacoes = 0, numeroMovimentacoes = 0;
    int *ptrComp = &numeroComparacoes, *ptrMov = &numeroMovimentacoes;
    time_t inicio = time(NULL); // Marcar o início da execução
    Personagem listPerson[100];

    scanf(" %[^\n]s", camArq);
    getchar();

    // Testa o fim do arquivo
    while (testaFim(camArq) == false)
    {
        listPerson[contTam] = montaPersonagem(camArq);
        contTam += 1;

        scanf(" %[^\n]s", camArq);
        getchar();
    }

    ordenaPorSelecao(listPerson, 0, contTam, ptrComp, ptrMov);

    imprimir(listPerson, contTam); // Imprimir os resultados

    newLog(inicio, numeroComparacoes, numeroMovimentacoes);

    return 0;
}