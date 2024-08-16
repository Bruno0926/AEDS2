import java.io.*;

class Personagem {
    private String nome;
    private int altura;
    private double peso;
    private String corDoCabelo;
    private String corDaPele;
    private String corDosOlhos;
    private String anoNascimento;
    private String genero;
    private String homeworld;

    public Personagem() {
    }

    public Personagem(String nome, int altura, double peso, String corDoCabelo, String corDaPele,
            String corDosOlhos, String anoNascimento, String genero, String homeworld) {
        this.nome = nome;
        this.altura = altura;
        this.peso = peso;
        this.corDoCabelo = corDoCabelo;
        this.corDaPele = corDaPele;
        this.corDosOlhos = corDosOlhos;
        this.anoNascimento = anoNascimento;
        this.genero = genero;
        this.homeworld = homeworld;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    public int getAltura() {
        return altura;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getPeso() {
        return peso;
    }

    public void setCorDoCabelo(String corDoCabelo) {
        this.corDoCabelo = corDoCabelo;
    }

    public String getCorDoCabelo() {
        return corDoCabelo;
    }

    public void setCorDaPele(String corDaPele) {
        this.corDaPele = corDaPele;
    }

    public String getCorDaPele() {
        return corDaPele;
    }

    public void setCorDosOlhos(String corDosOlhos) {
        this.corDosOlhos = corDosOlhos;
    }

    public String getCorDosOlhos() {
        return corDosOlhos;
    }

    public String getAnoNascimento() {
        return anoNascimento;
    }

    public void setAnoNascimento(String anoNascimento) {
        this.anoNascimento = anoNascimento;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getHomeworld() {
        return homeworld;
    }

    public void setHomeworld(String homeworld) {
        this.homeworld = homeworld;
    }

    public Personagem clone() {
        Personagem cloned = new Personagem();

        cloned.nome = this.nome;
        cloned.altura = this.altura;
        cloned.peso = this.peso;
        cloned.corDoCabelo = this.corDoCabelo;
        cloned.corDaPele = this.corDaPele;
        cloned.corDosOlhos = this.corDosOlhos;
        cloned.anoNascimento = this.anoNascimento;
        cloned.genero = this.genero;
        cloned.homeworld = this.homeworld;

        return cloned;
    }
}

class List {
    static Personagem[] listaPersonagens = new Personagem[100];
    int contadorTamanho = 0;

    // Inserir registro na primeira posição
    public void inseririn(Personagem personagem) throws Exception {
        if (contadorTamanho >= LISTpERSONS.length) {
            throw new Exception("Erro!");
        }

        for (int i = contadorTamanho; i > 0; i--) {
            LISTpERSONS[i] = LISTpERSONS[i - 1];
        }

        LISTpERSONS[0] = personagem;

        contadorTamanho++; // Incrementar o tamanho do vetor
    }

    // Inserir registro em uma posição qualquer e remanejar os demais registros
    public void insert(Personagem personagem, int posicao) throws Exception {
        if (contadorTamanho >= LISTpERSONS.length || posicao < 0 || posicao > contadorTamanho) {
            throw new Exception("Erro!");
        }

        for (int i = contadorTamanho; i > posicao; i--) {
            LISTpERSONS[i] = LISTpERSONS[i - 1];
        }

        LISTpERSONS[posicao] = personagem;

        contadorTamanho++; // Incrementar o tamanho do vetor
    }

    // Inserir registro na última posição
    public void inserirfim(Personagem personagem) throws Exception {
        if (contadorTamanho >= LISTpERSONS.length) {
            throw new Exception("Erro!");
        }

        LISTpERSONS[contadorTamanho] = personagem;

        contadorTamanho++; // Incrementar o tamanho do vetor
    }

    // Remover registro na primeira posição
    public void removerinicio() throws Exception {
        if (contadorTamanho == 0) {
            throw new Exception("Erro!");
        }

        MyIO.println("(R) " + LISTpERSONS[0].getNome());

        contadorTamanho--; // Reduzir o tamanho do vetor

        for (int i = 0; i < contadorTamanho; i++) {
            LISTpERSONS[i] = LISTpERSONS[i + 1];
        }
    }

    // Remover registro em uma posição qualquer e remanejar os demais registros
    public void remover(int posicao) throws Exception {
        if (contadorTamanho == 0 || posicao < 0 || posicao >= contadorTamanho) {
            throw new Exception("Erro!");
        }

        MyIO.println("(R) " + LISTpERSONS[posicao].getNome());

        contadorTamanho--; // Reduzir o tamanho do vetor

        for (int i = posicao; i < contadorTamanho; i++) {
            LISTpERSONS[i] = LISTpERSONS[i + 1];
        }
    }

    // Remover registro na última posição
    public void removerfim() throws Exception {
        if (contadorTamanho == 0) {
            throw new Exception("Erro!");
        }

        contadorTamanho--; // Reduzir o tamanho do vetor

        MyIO.println("(R) " + LISTpERSONS[contadorTamanho].getNome());
    }

    // Imprimir resultados
    public void imprimResults() {
        for (int i = 0; i < contadorTamanho; i++) {
            MyIO.print("[" + i + "]  ## " + LISTpERSONS[i].getNome());
            MyIO.print(" ## " + LISTpERSONS[i].getAltura());
            if (LISTpERSONS[i].getPeso() % 1 == 0) {
                MyIO.print(" ## " + (int) LISTpERSONS[i].getPeso());
            } else {
                MyIO.print(" ## " + LISTpERSONS[i].getPeso());
            }
            MyIO.print(" ## " + LISTpERSONS[i].getCorDoCabelo());
            MyIO.print(" ## " + LISTpERSONS[i].getCorDaPele());
            MyIO.print(" ## " + LISTpERSONS[i].getCorDosOlhos());
            MyIO.print(" ## " + LISTpERSONS[i].getAnoNascimento());
            MyIO.print(" ## " + LISTpERSONS[i].getGenero());
            MyIO.print(" ## " + LISTpERSONS[i].getHomeworld());
            MyIO.println(" ## ");
        }
    }
}

public class TP02QO3 {
    public static void main(String[] args) throws Exception {
        MyIO.setCharset("ISO-8859-1");

        List listPersons = new List();

        String caminhoArquivo = MyIO.readLine().replaceAll("é", "\u00e9");

        // Testar fim da primeira parte do arquivo
        while (testaFim(caminhoArquivo) == false) {

            // Montar personagem e adicionar ao fim da lista
            listPersons.inserirfim(montaPersonagem(caminhoArquivo));

            caminhoArquivo = MyIO.readLine().replaceAll("é", "\u00e9");
        }

        int quantidadeRegistros = MyIO.readInt(); // Ler quantidade de registros a serem inseridos/removidos

        analisaOperacoes(quantidadeRegistros, listPersons);

        listPersons.imprimResults();
    }

    // Testar fim do arquivo
    public static boolean testaFim(String palavra) {
        boolean teste = false;

        if (palavra.equals("FIM")) {
            teste = true;
        }

        return teste;
    }

    // Retornar personagem lido
    public static Personagem montaPersonagem(String caminhoArquivo) throws Exception {
        RandomAccessFile leitura = new RandomAccessFile(caminhoArquivo, "r");

        String descricaoPersonagem = leitura.readLine().replaceAll("é", "\u00e9");

        Personagem personagem = new Personagem();
        int contadorDoisPontos = 0; // Contar separadores

        for (int i = 0; i < descricaoPersonagem.length(); i++) {
            if (descricaoPersonagem.charAt(i) == ':') {
                contadorDoisPontos++;

                switch (contadorDoisPontos) {
                    case 1:
                        personagem.setNome(leituraAtributo(descricaoPersonagem, i + 3));
                        break;
                    case 2:
                        String atributoInteiro = leituraAtributo(descricaoPersonagem, i + 3);
                        if (atributoInteiro.equals("unknown")) {
                            personagem.setAltura(0);
                        } else {
                            personagem.setAltura(Integer.parseInt(atributoInteiro));
                        }
                        break;
                    case 3:
                        String atributoDouble = leituraAtributo(descricaoPersonagem, i + 3).replaceAll(",", ".");
                        if (atributoDouble.equals("unknown")) {
                            personagem.setPeso(0);
                        } else {
                            personagem.setPeso(Double.parseDouble(atributoDouble));
                        }
                        break;
                    case 4:
                        personagem.setCorDoCabelo(leituraAtributo(descricaoPersonagem, i + 3));
                        break;
                    case 5:
                        personagem.setCorDaPele(leituraAtributo(descricaoPersonagem, i + 3));
                        break;
                    case 6:
                        personagem.setCorDosOlhos(leituraAtributo(descricaoPersonagem, i + 3));
                        break;
                    case 7:
                        personagem.setAnoNascimento(leituraAtributo(descricaoPersonagem, i + 3));
                        break;
                    case 8:
                        personagem.setGenero(leituraAtributo(descricaoPersonagem, i + 3));
                        break;
                    case 9:
                        personagem.setHomeworld(leituraAtributo(descricaoPersonagem, i + 3));
                        i = descricaoPersonagem.length(); // Encerra os ciclos de repetição desnecessários
                        break;
                    default:
                        break;
                }
            }
        }

        leitura.close();

        return personagem;
    }

    // Retornar valor do atributo do personagem
    public static String leituraAtributo(String descricaoPersonagem, int index) {
        String atributo = new String();

        while (descricaoPersonagem.charAt(index) != '\'') {
            atributo += descricaoPersonagem.charAt(index);

            index++;
        }

        return atributo;
    }

    // Analisar manipulações que devem ser feitas nos registros
    public static void analisaOperacoes(int quantidadeRegistros, List listaPersonagens) throws Exception {

        for (int i = 0; i < quantidadeRegistros; i++) {
            String comandoOperacao = MyIO.readString();
            int numeroOperacao;
            String camOP = new String();

            // Analisar o comando de cada operação a ser executada
            switch (comandoOperacao) {
                case "II":
                    camOP = MyIO.readString().replaceAll("é", "\u00e9");
                    listaPersonagens.inseririn(montaPersonagem(camOP));
                    break;
                case "I*":
                    numeroOperacao = MyIO.readInt();
                    camOP = MyIO.readString().replaceAll("é", "\u00e9");
                    listaPersonagens.insert(montaPersonagem(camOP), numeroOperacao);
                    break;
                case "IF":
                    camOP = MyIO.readString().replaceAll("é", "\u00e9");
                    listaPersonagens.inserirfim(montaPersonagem(camOP));
                    break;
                case "RI":
                    listaPersonagens.removerinicio();
                    break;
                case "R*":
                    numeroOperacao = MyIO.readInt();
                    listaPersonagens.remover(numeroOperacao);
                    break;
                case "RF":
                    listaPersonagens.removerfim();
                    break;
                default:
                    i = quantidadeRegistros; // Redundância para garantir o fim
                    break;
            }
        }
    }
}