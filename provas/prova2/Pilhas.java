public class Pilhas {
    public static void main(String[] args) {
        class Pilha{ // flexível
            private Celula topo;
            public Pilha(){
                topo = null;
            }
            public void inserir(){
                Celula tmp = new Celula(x);
                tmp.prox = topo;
                topo = tmp;
                tmp = null;
            }
            public int remover(){
                if (topo == null) {
                    System.out.println("ERRO");
                }
                int elemento = topo.elemento;
                Celula tmp = topo;
                topo = topo.prox;
                tmp.prox = null;
                tmp = null;
                return elemento;
            }
            public void mostrar(){
                System.out.println("[");
                for(Celula i = topo; i != null; i = i.prox){
                    System.out.println(i.elemento + " ");
                }
                System.out.println("]");
            }
        }
    }
}

// exercicio 2 (lista simples)
for(i = primeiro; i.prox != null; i = i.prox){
    int elemento = primeiro.elemento;
if(i.elemento > i.elemento.prox){
    int tmp = primeiro;
    primeiro = primeiro.prox;
    primeiro.prox = tmp;
}
}