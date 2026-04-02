package eduarda.atividades.listaligada.circular;

import eduarda.atividades.listaligada.No;

import java.util.Scanner;

public class ListaLigadaCircular {
    static No inicio = null;
    static void main() {
        Scanner sc = new Scanner(System.in);

//        System.out.print("Defina o inicio: ");
//        inserir(sc.nextInt());

        int n = 1;
        while (n!=0){
            System.out.println("Escolha");
            System.out.println("1 - Inserir");
            System.out.println("0 - Fechar");
            n = sc.nextInt();

            switch (n){
                case 1: menuInserir(); break;
                case 0: System.out.println("Finalizado"); break;
                default: System.out.println("Opção não encontrada"); break;
            }
        }


    }

    private static void menuInserir() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Qual o valor do proximo nó: ");
        inserir(sc.nextInt());
        exibir();
    }

    public static void exibir(){
        No proximo = inicio;
        do{
            System.out.printf(proximo.getValor() + ", ");
            proximo = proximo.getProximo();
        }while(proximo != inicio);
        System.out.println();
    }

    public static void inserir(int x){
        No inserirNo = new No(x);
        if(inicio == null){
            inicio = inserirNo;
            inicio.setProximo(inicio);
        }else{
            No ultimo = inicio;
            while(ultimo.getProximo()!=inicio){
                ultimo = ultimo.getProximo();
            }
            ultimo.setProximo(inserirNo);
            inserirNo.setProximo(inicio);
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
