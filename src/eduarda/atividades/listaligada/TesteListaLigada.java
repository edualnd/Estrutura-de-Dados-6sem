package eduarda.atividades.listaligada;

import java.util.Scanner;

public class TesteListaLigada {
    static No inicio = null;
    static void main() {
        Scanner sc = new Scanner(System.in);

//        System.out.print("Defina o inicio: ");
//        inserir(sc.nextInt());

        int n = 1;
        while (n!=0){
            System.out.println("Escolha");
            System.out.println("1 - Inserir");
            System.out.println("2 - Inserir Ordenado");
            System.out.println("0 - Fechar");
            n = sc.nextInt();

            switch (n){
                case 1: menuInserir(1); break;
                case 2: menuInserir(2); break;
                case 0: System.out.println("Finalizado"); break;
                default: System.out.println("Opção não encontrada"); break;
            }
        }


    }

    private static void menuInserir(int type) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Qual o valor do proximo nó: ");
        if(type == 1){
            inserir(sc.nextInt());
        }else{
            insereOrdenado(sc.nextInt());
        }
        exibir();
    }

    public static void exibir(){
        No proximo = inicio;
        while(proximo!=null){
            System.out.printf(proximo.getValor() + ", ");
            proximo = proximo.getProximo();
        }
        System.out.println();
    }

    public static void inserir(int x){
        No inserirNo = new No(x);
        if(inicio == null){
            inicio = inserirNo;
        }else{
            No ultimo = inicio;
            while(ultimo.getProximo()!=null){
                ultimo = ultimo.getProximo();
            }
            ultimo.setProximo(inserirNo);
        }
    }

    public static void insereOrdenado(int x){
        No inserirNo = new No(x);
        if(inicio == null){
            inicio = inserirNo;
        }else{

            if(inicio.getValor() > inserirNo.getValor()){
                inserirNo.setProximo(inicio);
                inicio = inserirNo;
            }else{
                No ultimo = inicio;
                while(ultimo.getProximo() != null && ultimo.getProximo().getValor() < inserirNo.getValor()){
                    ultimo = ultimo.getProximo();
                }
                inserirNo.setProximo(ultimo.getProximo());
                ultimo.setProximo(inserirNo);

            }


        }
    }

    public static void removerUltimo(){
        No ultimo = inicio;
        while(ultimo.getProximo().getProximo() !=null){
            ultimo = ultimo.getProximo();
        }
        ultimo.setProximo(null);
    }
}
