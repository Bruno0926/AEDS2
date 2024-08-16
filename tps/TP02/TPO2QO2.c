#include <stdbool.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

// Definição do registro do personagem
typedef struct Person
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
} Person;

// Função para retornar o resto da divisão com double
double fmod(double x, double y)
{
    return x - (int)(x / y) * y;
}

// Capturar o atributo entre aspas simples
void readAtributo(char atributo[], char descricaoPersonagem[], int index)
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

// Imprimir os resultados
void impatributos(Person personagem)
{
    printf(" ## %s", personagem.nome);
    printf(" ## %d", personagem.altura);
    if (fmod(personagem.peso, 1) == 0)
        printf(" ## %.0lf", personagem.peso);
    else
        printf(" ## %.1lf", personagem.peso);
    printf(" ## %s", personagem.corDoCabelo);
    printf(" ## %s", personagem.corDaPele);
    printf(" ## %s", personagem.corDosOlhos);
    printf(" ## %s", personagem.anoNascimento);
    printf(" ## %s", personagem.genero);
    printf(" ## %s", personagem.homeworld);
    printf(" ## \n");
}

// Função para testar o fim do arquivo
bool fim(char palavra[])
{
    bool teste = false;

    if (palavra[0] == 'F' && palavra[1] == 'I' && palavra[2] == 'M')
    {
        teste = true;
    }

    return teste;
}

// Função para estruturar o personagem
Person montarpersonagem(char caminhoArquivo[])
{
    FILE *leitura = fopen(caminhoArquivo, "r");

    char descricaoPersonagem[1000];

    fscanf(leitura, " %[^\n]s", descricaoPersonagem);

    Person person; // Cria a variável struct

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
                readAtributo(atributo, descricaoPersonagem, i + 3);
                strcpy(person.nome, atributo);
                break;
            case 2:
                readAtributo(atributo, descricaoPersonagem, i + 3);
                person.altura = atoi(atributo);
                break;
            case 3:
                readAtributo(atributo, descricaoPersonagem, i + 3);
                for (int i = 0; i < strlen(atributo); i++)
                {
                    if (atributo[i] == ',')
                    {
                        atributo[i] = atributo[i - 1];
                        atributo[i - 1] = '0';
                    }
                }
                person.peso = atof(atributo);
                break;
            case 4:
                readAtributo(atributo, descricaoPersonagem, i + 3);
                strcpy(person.corDoCabelo, atributo);
                break;
            case 5:
                readAtributo(atributo, descricaoPersonagem, i + 3);
                strcpy(person.corDaPele, atributo);
                break;
            case 6:
                readAtributo(atributo, descricaoPersonagem, i + 3);
                strcpy(person.corDosOlhos, atributo);
                break;
            case 7:
                readAtributo(atributo, descricaoPersonagem, i + 3);
                strcpy(person.anoNascimento, atributo);
                break;
            case 8:
                readAtributo(atributo, descricaoPersonagem, i + 3);
                strcpy(person.genero, atributo);
                break;
            case 9:
                readAtributo(atributo, descricaoPersonagem, i + 3);
                strcpy(person.homeworld, atributo);

                i = strlen(descricaoPersonagem); // Encerra os ciclos de repetição desnecessários
                break;
            default:
                break;
            }
        }
    }

    fclose(leitura);

    return person;
}

int main(void)
{
    char camarq[100];

    scanf("%[^\n]s", camarq);
    getchar();

    // Testa o fim do arquivo
    while (fim(camarq) == false)
    {
        Person personagem = montarpersonagem(camarq);

        impatributos(personagem); // Imprimir o resultado

        scanf(" %[^\n]s", camarq);
        getchar();
    }

    return 0;
}