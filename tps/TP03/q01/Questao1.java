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

		String texto = pegatexto(diretorio),Split[];

		Split = texto.split("\'");

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

class Lista {
	private Celula primeiro;
	private Celula ultimo;


	/**
	 * Construtor da classe que cria uma lista sem elementos (somente no cabeca).
	 */
	public Lista() {
		primeiro = new Celula();
		ultimo = primeiro;
	}


	/**
	 * Insere um elemento na primeira posicao da lista.
    * @param x int elemento a ser inserido.
	 */
	public void incluirInicio(StarWars x) {
		Celula tmp = new Celula(x);
      	tmp.prox = primeiro.prox;
		primeiro.prox = tmp;
		if (primeiro == ultimo) {                 
			ultimo = tmp;
		}
      	tmp = null;
	}


	/**
	 * Insere um elemento na ultima posicao da lista.
    * @param x int elemento a ser inserido.
	 */
	public void incluirFim(StarWars x) {
		ultimo.prox = new Celula(x);
		ultimo = ultimo.prox;
	}


	public StarWars removeInicio() throws Exception {
		if (primeiro == ultimo) {
			throw new Exception("Erro ao remover (vazia)!");
		}

      Celula tmp = primeiro;
	  primeiro = primeiro.prox;
	  StarWars resp = primeiro.elemento.clone();
      tmp.prox = null;
      tmp = null;
	  return resp;
	}


	
	public StarWars removeFim() throws Exception {
		if (primeiro == ultimo) {
			throw new Exception("Erro ao remover (vazia)!");
		} 

		
      Celula i;
      for(i = primeiro; i.prox != ultimo; i = i.prox);

      StarWars resp = ultimo.elemento.clone(); 
      ultimo = i; 
      i = ultimo.prox = null;
      
	  return resp;
	}


	
   public void inserir(StarWars x, int pos) throws Exception {

      int tamanho = tamanho();

      if(pos < 0 || pos > tamanho){
			throw new Exception("Erro ao inserir posicao (" + pos + " / tamanho = " + tamanho + ") invalida!");
      } else if (pos == 0){
         incluirInicio(x);
      } else if (pos == tamanho){
         incluirFim(x);
      } else {
		   
         Celula i = primeiro;
         for(int j = 0; j < pos; j++, i = i.prox);
		
         Celula tmp = new Celula(x);
         tmp.prox = i.prox;
         i.prox = tmp;
         tmp = i = null;
      }
   }


	
	public StarWars remover(int pos) throws Exception {
      StarWars resp;
      int tamanho = tamanho();

		if (primeiro == ultimo){
			throw new Exception("Erro ao remover (vazia)!");

      } else if(pos < 0 || pos >= tamanho){
			throw new Exception("Erro ao remover (posicao " + pos + " / " + tamanho + " invalida!");
      } else if (pos == 0){
         resp = removeInicio();
      } else if (pos == tamanho - 1){
         resp = removeFim();
      } else {
		  
         Celula i = primeiro;
         for(int j = 0; j < pos; j++, i = i.prox);
		
         Celula tmp = i.prox;
         resp = tmp.elemento.clone();
         i.prox = tmp.prox;
         tmp.prox = null;
         i = tmp = null;
      }

		return resp;
	}

	
	public void mostrar() {
		int contador = 0;
		for (Celula i = primeiro.prox; i != null; i = i.prox,contador++) {
			System.out.println("["+contador+"] " + i.elemento.impressao());
		}
	}

	
	public boolean pesquisar(StarWars x) {
		boolean resp = false;
		for (Celula i = primeiro.prox; i != null; i = i.prox) {
         if(i.elemento.getNome().compareTo(x.getNome()) == 0){
            resp = true;
            i = ultimo;
         }
		}
		return resp;
	}

	
   public int tamanho() {
      int tamanho = 0; 
      for(Celula i = primeiro; i != ultimo; i = i.prox, tamanho++);
      return tamanho;
   }
}

public class Questao1
{

	public static void main(String[] args) throws Exception
	{

		StarWars a = new StarWars();
		Lista lista = new Lista();
		String split[];
		int n,numInteiro;

		String Entrada = MyIO.readLine();

		while( Entrada.contains("FIM") != true )
		{

			a = new StarWars(ISO88591toUTF8(Entrada));
			lista.incluirFim(a);

			Entrada = MyIO.readLine();

		}

		n = MyIO.readInt();

		for ( int i = 0 ; i < n ; i++ )
		{
		
			Entrada = MyIO.readLine();
			split = Entrada.split(" ");
			
			if ( split[0].equals("R*") == true )
			{

				numInteiro = Integer.parseInt(split[1]);
				a = lista.remover(numInteiro);
				MyIO.println("(R) " + a.getNome() );

			}
			else if ( split[0].equals("I*") == true ) 
			{

				numInteiro = Integer.parseInt(split[1]);
				a = new StarWars(ISO88591toUTF8(split[2]));
				lista.inserir(a,numInteiro);


			}
			else if ( split[0].equals("RI") == true )
			{

				a = lista.removeInicio();
				MyIO.println("(R) " + a.getNome() );
		
			}
			else if ( split[0].equals("RF") == true )
			{

				a = lista.removeFim();
				MyIO.println("(R) " + a.getNome() );
		
			}
			else if ( split[0].equals("II") == true ) 
			{

				a = new StarWars(ISO88591toUTF8(split[1]));
				lista.incluirInicio(a);


			}
			else if ( split[0].equals("IF") == true ) 
			{

				a = new StarWars(split[1]);
				lista.incluirFim(a);


			}


		}

		lista.mostrar();

	}


	public static String ISO88591toUTF8(String strISO) throws Exception 
	{

		byte[] isoBytes = strISO.getBytes("ISO-8859-1");
		return new String(isoBytes, "UTF-8");

	}

}

