package murillo.listaduplamenteligada;



public class Lista {
    static No inicio = null;
    static No fim = null;

    public static void main(String[] args) {
        inserirFinal(1);
        inserirFinal(2);
        inserirFinal(3);
        inserirFinal(4);
        inserirFinal(5);

        remover(1);

        exibir();

    }

    static void inserirInicio(int x){
        if(inicio == null){
            inicio = new No(x);
            fim = inicio;
        } else {
            No aux = new No(x);

            aux.prox = inicio;
            inicio = aux;
            inicio.prox.ant = inicio;
        }
    }

    static void inserirFinal(int x){
        if(fim == null){
            inicio = new No(x);
            fim = inicio;
        } else {
            No aux = new No(x);

            aux.ant = fim;
            fim = aux;
            aux.ant.prox = fim;
        }
    }

    static void inserirOrdenado(int x){

    }

    static void exibir(){
        if(inicio == null){
            System.out.println("não há nada a imprimir");
        } else{
            No aux = inicio;
            while(aux != fim){
                System.out.print(aux.valor + ", ");
                aux = aux.prox;
            }
            System.out.println(aux.valor);
        }
    }

    static void exibirInverso(){
        if(inicio == null){
            System.out.println("não há nada a imprimir");
        } else{
            No aux = fim;
            while(aux != inicio){
                System.out.print(aux.valor + ", ");
                aux = aux.ant;
            }
            System.out.println(aux.valor);
        }
    }

    static void remover(int x){
        No aux = inicio;
        if(aux.valor == x){
            inicio = inicio.prox;
            inicio.ant = null;
        } else {
            while(aux.prox != null){
                if (aux.valor == x){
                    aux.prox.ant = aux.ant;
                    aux.ant.prox = aux.prox;
                    break;
                }
                aux = aux.prox;
            }
        }
    }

    static void removerPrimeiro(){
        if(inicio == null){
            System.out.println("nada a remover");
        } else {
            inicio = inicio.prox;
            inicio.ant = null;
        }
    }

    static void removerUltimo(){
        if(fim == null){
            System.out.println("nada a remover");
        } else {
            fim = fim.ant;
            fim.prox = null;
        }
    }
}
