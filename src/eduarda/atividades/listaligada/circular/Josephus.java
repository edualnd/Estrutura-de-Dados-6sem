package eduarda.atividades.listaligada.circular;


import eduarda.atividades.listaligada.No;

public class Josephus {
    static No inicio = null; // <- VARIÁVEL GLOBAL

    public static void main(String[] args) {

        int N = 5;
        int S = 3;
        int p = 3;

        for (int i = 1; i <= N; i++) {
            insereFinal(i);
        }

        //exibir();

        josephus2(p, N);

        System.out.println("JOSEPHUS");
        System.out.println("N = " + N);
        System.out.println("S = " + S);
        System.out.println("Sobrevivente: " + inicio.getValor());

    }

    static void insereFinal(int x) {
        No novo = new No(x);

        if (inicio == null) {
            inicio = novo;
        } else {
            No temp = inicio;

            while (temp.getProximo() != inicio) {
                temp = temp.getProximo();
            }

            temp.setProximo(novo);
        }
        novo.setProximo(inicio);
    }

    static void exibir() {
        if (inicio == null) {
            System.out.println("Lista VAZIA, nada a exibir");
        } else {
            No temp = inicio;
            do {
                System.out.println(temp.getValor());
                temp = temp.getProximo();
            } while (temp != inicio);
        }
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
    static void josephus2(int p, int N) {
        No eu = inicio;
        int s = 0;

        for (int i = 1; i < p; i++) {
            eu = inicio.getProximo();
        }


        do {
            s++;
            josephus(s);
            System.out.println(inicio.getValor() + " - " + s + " - " + eu.getValor());
            if(inicio.getValor() != eu.getValor()){
                inicio = null;
                for (int i = 1; i <= N; i++) {
                    insereFinal(i);
                }

            }
        }while(inicio.getValor() != eu.getValor());
        System.out.println(s);
    }





}
