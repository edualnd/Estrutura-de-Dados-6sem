package eduarda.atividades.listaligada.circular.lista11.atividade03;



import java.util.Scanner;

public class Atividade03 {
    static No inicio = null;
    static No fim = null;
    static void main() {
        Scanner sc = new Scanner(System.in);
        inserirFinal(5);
        inserirFinal(9);
        inserirFinal(2);
        inserirFinal(7);
        inserirFinal(1);
        inserirFinal(4);
        inserirFinal(0);
        inserirFinal(6);
        inserirFinal(8);
        inserirFinal(8);



        exibir();
    }

    private static void exibir() {
        No pri = inicio;
        No ult = fim;

        while(pri != ult && pri.getProximo() != ult ){

            System.out.println(pri.getValor() + " " + ult.getValor());

            pri = pri.getProximo();
            ult = ult.getAnterior();
        }

        if(pri == ult) System.out.println(pri.getValor());
        else System.out.println(pri.getValor() + " " + ult.getValor());




    }

    static void inserirFinal(int x){
        No inserirNo = new No(x);
        if(inicio == null){
            inicio = inserirNo;
            fim = inserirNo;
        }else{
            fim.setProximo(inserirNo);
            inserirNo.setAnterior(fim);
            fim = inserirNo;

        }
    }


}
