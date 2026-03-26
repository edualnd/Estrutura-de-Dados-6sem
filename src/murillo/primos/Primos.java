package murillo.primos;

import java.util.Scanner;

public class Primos {

    static No inicio = null; // <- VARIÁVEL GLOBAL
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Informe o valor de N: ");
        int N = sc.nextInt();

        for (int i = 0; i <= N; i++) {
            inserir(i);
        }
        primos(N);

        exibir(inicio);
        System.out.println("Existem "+tamanho(inicio)+" numeros primos entre 0 e "+N);
    }

    private static void primos(int n){
        if(inicio.valor == 0 || inicio.valor == 1){
            inicio = inicio.prox;
        }
    }

    private static int tamanho(No temp){
        int contador = 0;

        while(temp.prox != null){
            temp = temp.prox;
            contador++;
        }
        return contador;
    }


    private static void inserir(int x) {
        //recebe o primeiro valor e cria um no principal;
        if(inicio == null){
            inicio = new No(x);
        } else{
            No noSecundario = new No(x);
            if(inicio.prox == null){
                inicio.prox = noSecundario;
            } else{
                No temp = inicio;
                while(temp.prox != null){
                    temp = temp.prox;
                }
                temp.prox = noSecundario;
            }
        }
    }

    private static void exibir(No temp) {
        while(temp.prox != null){
            System.out.print(temp.valor + " ");
            temp = temp.prox;
        }
    }

}
