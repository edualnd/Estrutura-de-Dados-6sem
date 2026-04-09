package eduarda.atividades.listaduplamenteligada;

import java.util.Scanner;

public class Lista {
    static No inicio = null;
    static No fim = null;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = 1;
        while(n!=0){
            n = sc.nextInt();
            inserirOrdenado(n);
        }
        exibir();

    }

    static void inserirInicio(int x){
        No inserirNo = new No(x);
        if(inicio == null){
            inicio = inserirNo;
            fim = inserirNo;
        }else{
            inicio.setAnt(inserirNo);
            inserirNo.setProx(inicio);
            inicio = inserirNo;

        }
    }

    static void inserirFinal(int x){
        No inserirNo = new No(x);
        if(inicio == null){
            inicio = inserirNo;
            fim = inserirNo;
        }else{
            fim.setProx(inserirNo);
            inserirNo.setAnt(fim);
            fim = inserirNo;

        }
    }

    static void inserirOrdenado(int x){
        No inserirNo = new No(x);
        if(inicio == null){
            inicio = inserirNo;
            fim = inserirNo;
        }else{
            if(inicio.getValor() > inserirNo.getValor()){
                inicio.setAnt(inserirNo);
                inserirNo.setProx(inicio);
                inicio = inserirNo;
            }
            else if(fim.getValor() < inserirNo.getValor()){
                fim.setProx(inserirNo);
                inserirNo.setAnt(fim);
                fim = inserirNo;
            }
            else{
                No posicao = inicio;
                while(posicao.getProx() != null && posicao.getProx().getValor() < inserirNo.getValor()){
                    posicao = posicao.getProx();
                }
                inserirNo.setProx(posicao.getProx());
                inserirNo.setAnt(posicao);

                posicao.getProx().setAnt(inserirNo);
                posicao.setProx(inserirNo);

            }
        }
    }

    static void exibir(){
        No proximo = inicio;
        while(proximo!=null){
            System.out.printf(proximo.getValor() + ", ");
            proximo = proximo.getProx();
        }
        System.out.println();
    }

    static void exibirInverso(){
        No anterior = fim;
        while(anterior!=null){
            System.out.printf(anterior.getValor() + ", ");
            anterior = anterior.getAnt();
        }
        System.out.println();
    }

    static void remover(int x){
        No removerNo = inicio;

        while(removerNo.getValor() != x){
            removerNo = removerNo.getProx();
        };

        removerNo.getAnt().setProx(removerNo.getProx());
        removerNo.getProx().setAnt(removerNo.getAnt());

    }

    static void removerPrimeiro(){
        inicio = inicio.getProx();
        inicio.setAnt(null);
    }

    static void removerUltimo(){
        fim = fim.getAnt();
        fim.setProx(null);
    }
}
