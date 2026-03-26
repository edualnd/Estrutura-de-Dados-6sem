package eduarda.atividades.listaligada;

import java.util.Scanner;

public class Primos {
    static No inicio = null; // <- VARIÁVEL GLOBAL
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //System.out.print("Informe o valor de N: ");
        //int N = sc.nextInt();
        int N = 50;

        for (int i = 0; i <= N; i++) {
            inserir(i);
        }
        primos(N);

        exibir(inicio);
        System.out.println("\nExistem "+tamanho(inicio)+" numeros primos entre 0 e "+N);
    }

    private static void primos(int n){
        No temp = inicio;
        No aux = null;
        int i = 0;
        while (temp.getValor() < n/2) {
            if (inicio.getValor() == 0 || inicio.getValor() == 1){
                inicio = inicio.getProximo();
                temp = inicio;
            }else {
                aux = temp;
                while(aux.getProximo() != null){
                    if(aux.getProximo().getValor() % temp.getValor() == 0){
                        aux.setProximo(aux.getProximo().getProximo());

                    }
                    if(aux.getProximo() != null){
                        aux = aux.getProximo();
                    }
                }
                temp = temp.getProximo();
            }


        }

    }

    private static int tamanho(No temp){
        int count = 1;
        while(temp.getProximo() != null){
            temp = temp.getProximo();
            count++;
        };
        return count;
    }


    private static void inserir(int x) {
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

    private static void exibir(No temp) {
        int i = 1;
        while(temp.getProximo() != null){
            System.out.printf(String.format( "%02d", temp.getValor()) + " ");
            temp = temp.getProximo();
            if(i%10 == 0){
                System.out.println();
            }
            i++;

        };
    }

}
