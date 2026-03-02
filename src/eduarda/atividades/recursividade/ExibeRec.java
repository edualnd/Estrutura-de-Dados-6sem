package eduarda.atividades.recursividade;

import java.util.Scanner;

public class ExibeRec {
    static void main() {
        Scanner sc = new Scanner(System.in);
        System.out.print("De i: ");
        int i = sc.nextInt();
        System.out.print("Até n: ");
        int n = sc.nextInt();

        System.out.println("Pre");
        exibirComRecursividadePreOrdem(i, n);

        System.out.println("\n\nPos");
        exibirComRecursividadePosOrdem(i, n);
    }

    private static void exibirComRecursividadePreOrdem(int i, int n) {
        if(i==n){
            System.out.printf(i + " ");
        }else{
            System.out.printf(i + " ");
            exibirComRecursividadePreOrdem(i+1, n);
        }
    }

    private static void exibirComRecursividadePosOrdem(int i, int n) {
        if(i==n){
            System.out.printf(i + " ");
        }else{
            exibirComRecursividadePosOrdem(i+1, n);
            System.out.printf(i + " ");
        }
    }
}
