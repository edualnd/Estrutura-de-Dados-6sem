package eduarda.atividades.listaligada.circular.lista11.atividade01;

import java.util.Scanner;

public class Atividade01 {
    static No inicio = null;
    static No fim = null;
    static void main() {
        Scanner sc = new Scanner(System.in);

        //System.out.print("Numero de elementos: ");
        //int n = sc.nextInt();
        int n = 5;
        int j = 4;
        int s = 2;
        for (int i = 1; i <= n; i++) {
            inserirFinal(i);
        }
        //1 2 3 4 5
//        System.ou t.print("Saltos para frente: ");
//        int s = sc.nextInt();
//        System.out.print("Saltos para trás: ");
//        int j = sc.nextInt();





        preencher(5); josephus(0, 1); exibir(); // Sobrevivente: 2
        preencher(5); josephus(0, 2); exibir(); // Sobrevivente: 4
        preencher(5); josephus(0, 3); exibir(); // Sobrevivente: 4
        preencher(5); josephus(0, 4); exibir(); // Sobrevivente: 1
        preencher(5); josephus(0, 5); exibir(); // Sobrevivente: 2

        preencher(3); josephus(0, 1); exibir(); // Sobrevivente: 2
        preencher(3); josephus(0, 2); exibir(); // Sobrevivente: 3
        preencher(3); josephus(0, 3); exibir(); // Sobrevivente: 2

        preencher(4); josephus(0, 1); exibir(); // Sobrevivente: 2
        preencher(4); josephus(0, 2); exibir(); // Sobrevivente: 1
        preencher(4); josephus(0, 3); exibir(); // Sobrevivente: 4
        preencher(4); josephus(0, 4); exibir(); // Sobrevivente: 1

        preencher(1); josephus(0, 1); exibir(); // Sobrevivente: 1
        preencher(2); josephus(0, 1); exibir(); // Sobrevivente: 2
        preencher(2); josephus(0, 2); exibir(); // Sobrevivente: 1






    }
    static void preencher(int n){
        inicio = null;
        fim = null;
        for (int i = 1; i <= n; i++) {
            inserirFinal(i);
        }
    }
    static void josephus(int j, int s){
        No assasinado = inicio;
        boolean andarHorario = true;

        do{

            if(andarHorario){
                for (int i = 0; i < s; i++) {
                    assasinado = assasinado.getProximo();
                }
                assasinado.getProximo().setAnterior(assasinado.getAnterior());
                assasinado.getAnterior().setProximo(assasinado.getProximo());

                assasinado = assasinado.getProximo();
            }else{
                if(assasinado.getProximo() == assasinado) {
                    break;
                }
                for (int i = 0; i < j-1; i++) {
                    assasinado = assasinado.getAnterior();
                }


                assasinado.getProximo().setAnterior(assasinado.getAnterior());
                assasinado.getAnterior().setProximo(assasinado.getProximo());

                assasinado = assasinado.getAnterior();
            }


            //andarHorario = !andarHorario;

        }while(assasinado.getProximo() != assasinado);

        inicio = assasinado;
    }

    static void josephus(int s) {
        No matarNo = inicio;
        int i = 0;
        do{
            i++;
            if((i+1)%s == 0) {
                matarNo.setProximo(matarNo.getProximo().getProximo());
                i++;
            };
            matarNo = matarNo.getProximo();
        }while(matarNo.getProximo() != matarNo);

        inicio = matarNo;
    }
    static void inserirFinal(int x){
        No inserirNo = new No(x);
        if(inicio == null){
            inicio = inserirNo;
            fim = inserirNo;
            inicio.setAnterior(inserirNo);
            fim.setProximo(inserirNo);

        }else{
            fim.setProximo(inserirNo);
            inserirNo.setAnterior(fim);
            fim = inserirNo;
            inicio.setAnterior(fim);
            fim.setProximo(inicio);

        }
    }

    public static void exibir(){
        No proximo = inicio;
        do{
            System.out.printf(proximo.getValor() + ", ");
            proximo = proximo.getProximo();
        }while(proximo != inicio);
        System.out.println();
    }
}
