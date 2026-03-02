package eduarda.atividades.desafio01;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Desafio {
    static void main() {
        Scanner sc = new Scanner(System.in);

        System.out.printf("Valor de n: ");
        int n = sc.nextInt();

        ArrayList<Integer> vet = new ArrayList<Integer>();
        inserirSemRepeticao(vet, n);

        System.out.print("Valor de c: ");
        int c = sc.nextInt();


        int length = vet.size();
        System.out.println("Vetor sem repeticoes");
        for (int i = 0; i < length; i++) {
            System.out.print(vet.get(i) + " ");
        }
        System.out.println();

        System.out.println("\nCombinações possíveis:");
        gerarCombinacoes(vet, c, 0, new ArrayList<>());


    }

    private static void inserirSemRepeticao(ArrayList<Integer> vet, int n) {
        Random rd = new Random();
        int num;
        boolean repetido = false;
        for (int i = 0; i < n; i++) {
            repetido = false;
            num = rd.nextInt(1, 100);
            for (int j = 0; j < i; j++) {
                if (vet.get(j) == num) {
                    repetido = true;
                    break;
                }
            }
            if (!repetido) {
                vet.add(num);
            } else {
                i--;
            }
        }
    }

    public static void gerarCombinacoes(List<Integer> numeros, int C, int inicio, List<Integer> atual) {

        if (atual.size() == C) {
            System.out.println(atual);
            return;
        }

        for (int i = inicio; i < numeros.size(); i++) {
            atual.add(numeros.get(i));
            gerarCombinacoes(numeros, C, i + 1, atual);
            atual.remove(atual.size() - 1); // backtrack
        }
    }


}
