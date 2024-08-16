package ExercicioResolvido;

class ExemploArq02Leitura
{
  public static void main(String[] args)
  {
     Arq.openRead("exemplo.txt");

     int inteiro = Arq.readInt();
     double real = Arq.readDouble();
     char caractere = Arq.readChar();
     boolean boleano = Arq.readBoolean();
     String str = Arq.readString();

     Arq.close();

     MyIO.println("inteiro: " + inteiro);
     MyIO.println("real: " + real);
     MyIO.println("caractere: " + caractere);
     MyIO.println("boleano: " + boleano);
     MyIO.println("str: " + str);

  } 
}