package eduarda.atividades.avaliativa01;

import java.io.*;
import java.util.Random;
import java.util.Scanner;


public class AtividadeAvaliativa {
    static void main() throws IOException {
        problema4();
    }

    /**
     * Crie um programa em que solicita ao usuário o valor de N e,
     * posteriormente os N números que devem ser armazenados em um vetor.
     * Em um segundo momento, exiba o vetor na ordem em que os elementos foram
     * digitados e em ordem inversa.
     * **/
    public static void problema1(){
        Scanner sc = new Scanner(System.in);

        System.out.print("Valor de N: ");
        int n = sc.nextInt();

        int[] vetor = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.printf("Vetor[%d]: ", i);
            vetor[i] = sc.nextInt();
        }

        for (int i = 0; i < n; i++) {
            System.out.println(vetor[i]);
        }
        System.out.print("\n\n");
        for (int i = n-1; i >= 0; i--) {
            System.out.println(vetor[i]);
        }
    }


    /**
     * Crie um programa em JAVA que solicita ao usuário o valor de N e,
     * posteriormente, alimente o vetor com valores aleatórios entre 0 e M
     * (M também é informado pelo usuário). Exiba o vetor gerado.**/
    public static void problema2(){
        Scanner sc = new Scanner(System.in);

        System.out.print("Valor de N: ");
        int n = sc.nextInt();

        System.out.print("Valor de M: ");
        int m = sc.nextInt();

        int[] vetor = new int[n];
        Random rd = new Random();
        for (int i = 0; i < n; i++) {

            vetor[i] = rd.nextInt(0, m);
        }

        for (int i = 0; i < n; i++) {
            System.out.println(vetor[i]);
        }
        System.out.print("\n\n");
        for (int i = n-1; i >= 0; i--) {
            System.out.println(vetor[i]);
        }
    }

    /**
     * Crie um metodo chamado Insere_Exclusivo(int vet[], int N) que alimenta
     * um vetor de N elementos com valores aleatórios entre 1 e N sem que ocorram
     * números repetidos. Exiba o vetor gerado.
     **/
    public static void problema3(){
        Scanner sc = new Scanner(System.in);

        System.out.print("Valor de N: ");
        int n = sc.nextInt();


        int[] vetor = new int[n];
        Insere_Exclusivo(vetor, n);
    }
    public static void Insere_Exclusivo(int vet[], int N){


        Random rd = new Random();
        int num;
        boolean repetido = false;
        for (int i = 0; i < N; i++) {
            repetido = false;
            num = rd.nextInt(0, N);
            for (int j = 0; j < i; j++) {
                if(vet[j] == num){
                    repetido = true;
                    break;
                }
            }
            if(!repetido){
                vet[i] = num;
            }else {
                i--;
            }
        }

        int length = vet.length;
        for (int i = 0; i < length; i++) {
            System.out.println(vet[i]);

        }
        System.out.print("\n\n");
        for (int i = length-1; i >= 0; i--) {
            System.out.println(vet[i]);
        }
    }

    /**
     * Crie um programa em JAVA que faça a leitura de um arquivo de texto
     * contendo um número inteiro em cada linha onde: O número da primeira
     * linha é o valor de N e os números subsequentes são a sequência numérica
     * de interesse. Armazene os valores lidos em um vetor e exiba-o. Aproveite
     * sua implementação do Exercício 1. e escreva em outro arquivo a sequência
     * numérica em ordem inversa.
     **/
    public static void problema4() throws IOException {
        String arq = "src/eduarda/atividades/avaliativa01/dados.txt";
        BufferedReader bf= new BufferedReader(new FileReader(arq));
        int n = Integer.parseInt(bf.readLine());

        int vetor[] = new int[n];
        for (int i = 0; i < n; i++) {
            vetor[i] = Integer.parseInt(bf.readLine());
        }

        String arqResultado = "src/eduarda/atividades/avaliativa01/resultado.txt";

        BufferedWriter bw = new BufferedWriter(new FileWriter(arqResultado,false));
        for (int i = n-1; i >= 0; i--) {
            String linha = vetor[i]+"\n";
            bw.append(linha);
        }
        bf.close();
        bw.close();
    }
}
