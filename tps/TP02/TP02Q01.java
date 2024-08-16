import java.util.Scanner;
import java.io.*;

class Personagem {
    private String nome;
    private int altura;
    private double peso;
    private String corDoCabelo;
    private String corDaPele;
    private String corDosOlhos;
    private String anoDeNascimento;
    private String genero;
    private String homeworld;

    public Personagem(String nome, int altura, double peso, String corDoCabelo, String corDaPele, String corDosOlhos, String anoDeNascimento, String genero, String homeworld) {
        this.nome = nome;
        this.altura = altura;
        this.peso = peso;
        this.corDoCabelo = corDoCabelo;
        this.corDaPele = corDaPele;
        this.corDosOlhos = corDosOlhos;
        this.anoDeNascimento = anoDeNascimento;
        this.genero = genero;
        this.homeworld = homeworld;
    }

    public Personagem() {
        this.nome = "";
        this.altura = 0;
        this.peso = 0.0;
        this.corDoCabelo = "";
        this.corDaPele = "";
        this.corDosOlhos = "";
        this.anoDeNascimento = "";
        this.genero = "";
        this.homeworld = "";
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public String getCorDoCabelo() {
        return corDoCabelo;
    }

    public void setCorDoCabelo(String corDoCabelo) {
        this.corDoCabelo = corDoCabelo;
    }

    public String getCorDaPele() {
        return corDaPele;
    }

    public void setCorDaPele(String corDaPele) {
        this.corDaPele = corDaPele;
    }

    public String getCorDosOlhos() {
        return corDosOlhos;
    }

    public void setCorDosOlhos(String corDosOlhos) {
        this.corDosOlhos = corDosOlhos;
    }

    public String getAnoDeNascimento() {
        return anoDeNascimento;
    }

    public void setAnoDeNascimento(String anoDeNascimento) {
        this.anoDeNascimento = anoDeNascimento;
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

    @Override
    public String toString() {
        return " ## " + nome + " ## " + altura + " ## " + (int) peso + " ## " + corDoCabelo
                + " ## " + corDaPele + " ## " + corDosOlhos + " ## " + anoDeNascimento
                + " ## " + genero + " ## " + homeworld + " ## ";
    }

    public Jogador clone() {
        Jogador personagemNovo = new Jogador();
        personagemNovo.nome = this.nome;
        personagemNovo.altura = this.altura;
        personagemNovo.peso = this.peso;
        personagemNovo.corDoCabelo = this.corDoCabelo;
        personagemNovo.corDaPele = this.corDaPele;
        personagemNovo.corDosOlhos = this.corDosOlhos;
        personagemNovo.anoDeNascimento = this.anoDeNascimento;
        personagemNovo.genero = this.genero;
        personagemNovo.homeworld = this.homeworld;

        return personagemNovo;
    }

}

public class TP02Q01{
    public static boolean isFim(String s) {
        return (s.length() == 3 && s.charAt(0) == 'F' && s.charAt(1) == 'I' && s.charAt(2) == 'M');
    }

    public static void main(String[] args) {
        // File folder = new File("personagens");
        // File[] listOfFiles = folder.listFiles();
        Scanner scc = new Scanner(System.in);
        int virgula = 0;
        String filepath = scc.nextLine();
        while (!isFim(filepath)) {
            String[] atributs = new String[9];
            int a = 0;
            try (BufferedReader br = new BufferedReader(new FileReader(filepath))) {
                String json = br.readLine();
                String[] separado = json.split(":");
                for (String A : separado) {
                    virgula = 0;
                    for (int i = 0; i < A.length(); i++) {
                        if (A.charAt(i) == ',') {
                            virgula++;
                        }
                    }
                    if (virgula == 1) {
                        String[] str = A.split(",");
                        atributs[a] = str[0].substring(2, str[0].length() - 1);
                        a++;
                    }
                    if (virgula > 1) {
                        String[] str = A.split(",");
                        atributs[a] = str[0].substring(2);
                        for (int i = 1; i < str.length - 2; i++)
                            atributs[a] = atributs[a] + "," + str[i];
                        atributs[a] = atributs[a] + ","
                                + str[str.length - 2].substring(0, str[str.length - 2].length() - 1);
                        a++;
                    }
                    if (a == 9)
                        break;
                }
                for (int i = 0; i < atributs[2].length(); i++) {
                    if (atributs[2].charAt(i) == ',') {
                        atributs[2] = atributs[2].substring(0, i)
                                + atributs[2].substring(i + 1, atributs[2].length());
                    }
                }
                if (atributs[1].equals("unknown"))
                    atributs[1] = "0";
                if (atributs[2].equals("unknown"))
                    atributs[2] = "0";
                Jogador starWars = new Jogador(atributs[0], Integer.parseInt(atributs[1]),
                        Double.parseDouble(atributs[2]), atributs[3], atributs[4],
                        atributs[5], atributs[6], atributs[7], atributs[8]);
                System.out.println(starWars.toString());
            } catch (IOException e) {
                e.printStackTrace();
            }
            filepath = scc.nextLine();
        }
        scc.close();
    }
}