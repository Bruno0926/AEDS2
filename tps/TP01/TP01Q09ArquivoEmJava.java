import java.io.*;

public class TP01Q09ArquivoEmJava {
    //função para ler um numero e colocar em um arquivo
    public static void arquivo(int n){
        //declaração de variaveis
        RandomAccessFile arquivo;
        double dados;
        //conferindo e o numero digitado é valido 
        if(n >= 0){
            try{
                //criando arquivo
                arquivo = new RandomAccessFile("arquivo.txt", "rw");
                //lendo dados do teclado
                for(int i = 0;i < n;i++){
                    dados = MyIO.readDouble();
                    //guardando dados no arquivo
                    arquivo.writeDouble(dados);
                }
                for(int i = 0; i < n;i++){
                    long pos = arquivo.getFilePointer();
                    //indo para a leitura do proximo dados
                    arquivo.seek(pos-8);
                    double x = arquivo.readDouble();
                    arquivo.seek(pos - 8);
                    int y = (int)x;
                    if (x == y) {
                        MyIO.println (y);
                    }else{
                        MyIO.println (x);
                    } 
                }
                //fechando arquivo
                arquivo.close();
            }catch(IOException Erro){
                MyIO.println ("Deu errado");
            }
        }
    }
    //MAIN
    public static void main(String[] args){
        int n = MyIO.readInt();
 
        arquivo(n);
    }
}
