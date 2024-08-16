import java.io.*;
import java.util.*;

class StarWars
{
	private String nome,corDoCabelo,corDaPele,corDosOlhos,anoNascimento,genero,homeworld;
	private int altura;
	private double peso;

	public StarWars ( ) 
	{

		nome = corDoCabelo = corDaPele = corDosOlhos = anoNascimento = genero = homeworld = "";
		altura = 0;
		peso = 0.0;

	}

	public StarWars (String diretorio) 
	{

		cfgperson(diretorio);

	}

	public StarWars clone()
	{

		StarWars tmp = new StarWars();
		tmp.nome = this.nome;
		tmp.corDoCabelo = this.corDoCabelo;
		tmp.corDaPele = this.corDaPele;
		tmp.corDosOlhos = this.corDosOlhos;
		tmp.anoNascimento = this.anoNascimento;
		tmp.genero = this.genero;
		tmp.homeworld = this.homeworld;
		tmp.altura = this.altura;
		tmp.peso = this.peso;

		return tmp;	

	}

	public String getNome()
	{

		return nome;

	}

	public String getCorDoCabelo()
	{

		return corDoCabelo;

	}

	public String getCorDaPele()
	{

		return corDaPele;

	}

	public String getCorDosOlhos()
	{

		return corDosOlhos;

	}

	public String getAnoNascimento()
	{

		return anoNascimento;

	}

	public String getGenero()
	{

		return genero;

	}
	
	public String getHomeworld()
	{

		return homeworld;

	}

	public int getAltura()
	{	

		return altura;

	}

	public double getPeso()
	{	

		return peso;

	}

	public void setNome(String novoNome)
	{

		nome = novoNome;

	}

	public void setCorDoCabelo(String novaCorDoCabelo)
	{

		corDoCabelo = novaCorDoCabelo;

	}

	public void setCorDaPele(String novaCorDaPele)
	{

		corDaPele = novaCorDaPele;

	}
	
	public void setCorDosOlhos(String novaCorDosOlhos)
	{

		corDosOlhos = novaCorDosOlhos;

	}

	public void setAnoNascimento(String novoAnoNascimento)
	{

		anoNascimento = novoAnoNascimento;

	}

	public void setGenero(String novoGenero)
	{

		genero = novoGenero;

	}

	public void setHomeworld(String novoHomeworld)
	{

		homeworld = novoHomeworld;

	}

	public void setAltura(int novaAltura)
	{

		altura = novaAltura;

	}

	public void setPeso(double novoPeso)
	{

		peso = novoPeso;

	}
	
	public String impressao()
	{

		
		String resp = " ## " + getNome() + " ## " + getAltura() + " ## 0";

		
		resp += " ## " + getCorDoCabelo() + " ## " +  getCorDaPele() + " ## " + getCorDosOlhos() + " ## " + getAnoNascimento() + " ## " + getGenero() + " ## " + getHomeworld() + " ## ";
		return resp;

	}

	public String pegatexto(String diretorio)
	{
		String texto = "",linha = "";
		try {
			RandomAccessFile arq = new RandomAccessFile(diretorio,"r");
			linha = arq.readLine();

			while (linha != null) 
			{

				texto += linha;
				linha = arq.readLine();

			}

			arq.close();
		} 

		catch (IOException excecao) 
		{

			excecao.printStackTrace();

		}

		return texto;
	}

	public void cfgperson(String diretorio)
	{

		int numInteiro;
		double numDouble;

		String text = pegatexto(diretorio),Split[];

		Split = text.split("\'");

		setNome(Split[3]);
		
		if(Split[7].contains("unknown") == true)
		{

			setAltura(0);
		
		}		
		else
		{

			numInteiro = Integer.parseInt(Split[7]);
			setAltura(numInteiro);

		}
		if(Split[11].contains("unknown") == true)
		{

			setPeso(0);

		}
		else
		{
			
			numDouble = Double.parseDouble(Split[11]);
			setPeso(numDouble);

		}

		setCorDoCabelo(Split[15]);
		setCorDaPele(Split[19]);
		setCorDosOlhos(Split[23]);
		setAnoNascimento(Split[27]);
		setGenero(Split[31]);
		setHomeworld(Split[35]);

	}

} 



class Celula {
	public StarWars elemento; 
	public Celula prox; 
	
	public Celula() { 
		this.elemento = null;
		this.prox = null;
    }

	public Celula(StarWars elemento) {
      this.elemento = elemento.clone();
      this.prox = null;
	}
}


class Pilha {
	private Celula topo;
	public int contador;

	public Pilha() {
		topo = null;
	}

	public void insert(StarWars x) {
		Celula tmp = new Celula(x);
		tmp.prox = topo;
		topo = tmp;
		tmp = null;
	}

	public StarWars remove() throws Exception {
		if (topo == null) {
			throw new Exception("Erro ao remover!");
		}

		StarWars resp = topo.elemento.clone();
		Celula tmp = topo;
		topo = topo.prox;
		tmp.prox = null;
		tmp = null;
		return resp;
	}

	public void mostrar() {
		mostrar(topo);
		contador = 0;
	}

	public void mostrar(Celula i) {

		if ( i.prox != null ) {
			mostrar(i.prox);
			contador++;
		}
		System.out.println("["+contador+"] " + i.elemento.impressao());
	}

}

public class Questao2
{

	public static void main(String[] args) throws Exception
	{

		StarWars a = new StarWars();
		Pilha pilha = new Pilha();
		String split[];
		int n;

		String entrada = MyIO.readLine();

		while( entrada.contains("FIM") != true )
		{

			a = new StarWars(iso(entrada));
			pilha.insert(a);

			entrada = MyIO.readLine();

		}

		n = MyIO.readInt();

		for ( int i = 0 ; i < n ; i++ )
		{
		
			entrada = MyIO.readLine();
			split = entrada.split(" ");
			
			if ( split[0].equals("I") == true )
			{

				a = new StarWars(iso(split[1]));
				pilha.insert(a);

			}
			else if ( split[0].equals("R") == true ) 
			{

				a = pilha.remove();
				MyIO.println("(R) " + a.getNome() );

			}


		}

		pilha.mostrar();

	}


	public static String iso(String strISO) throws Exception 
	{

		byte[] isoBytes = strISO.getBytes("ISO-8859-1");
		return new String(isoBytes, "UTF-8");

	}

}

