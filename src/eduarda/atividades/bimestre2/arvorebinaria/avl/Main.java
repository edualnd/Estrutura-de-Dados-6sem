package eduarda.atividades.bimestre2.arvorebinaria.avl;

import static eduarda.atividades.bimestre2.arvorebinaria.avl.SobreArvore.tamanho;

public class Main {
    static NoAVL raiz = null;
    static void main() {
        inserirExclusivo(50);
        inserirExclusivo(30);
        inserirExclusivo(70);
        inserirExclusivo(20);
        inserirExclusivo(40);
        inserirExclusivo(40);
        inserirExclusivo(60);
        inserirExclusivo(80);
        exibeArvore(raiz, 0);


    }


    static void inserir(int x){
        NoAVL novoNo = new NoAVL(x);

        if(raiz == null) raiz = novoNo;
        else{
            NoAVL temp = raiz;
            boolean inseriu = false;

            while(!inseriu){
                if (novoNo.valor <= temp.valor){
                    if(temp.esq == null){
                        temp.esq = novoNo;
                        inseriu = true;
                    }else temp = temp.esq;
                }else{
                    if(temp.dir == null){
                        temp.dir = novoNo;
                        inseriu = true;
                    }else temp = temp.dir;
                }
            }
        }
    }
    static void exibir(NoAVL temp){
        if(temp != null){
            exibir(temp.esq);
            System.out.println(temp.valor);
            exibir(temp.dir);
        }
    }
    static void exibeArvore(NoAVL n, int x){

        if(n.dir != null)
            exibeArvore(n.dir, x+1);
        else
            System.out.println();

        for(int i=1; i<=x; i++)
            System.out.print("|  ");

        if((n.esq == null)&&(n.dir == null))
            System.out.print("["+n.valor+"]");
        else
            System.out.print(n.valor);

        if(n.esq != null)
            exibeArvore(n.esq, x+1);
        else
            System.out.println();

    }

    static void inserirExclusivo(int x){
        if (!existeNo(x)) inserir(x);
    }
    private static boolean existeNo(int x) {
        boolean existe = false;
        NoAVL temp = raiz;
        while(!existe && temp != null){
            if (temp.valor == x) existe = true;
            else if (temp.valor < x) temp = temp.dir;
            else temp = temp.esq;
        }
        return existe;
    }

    static int contarFilhos(NoAVL temp, int x){
        if (temp==null) return -1;
        else if (temp.valor == x) {
            if (temp.dir != null && temp.esq != null) return 2;
            else if (temp.dir != null || temp.esq != null) return 1;
            return 0;
        }
        else if (temp.valor < x) return contarFilhos(temp.dir, x);
        else return contarFilhos(temp.esq, x);
    }

    static void remover(int x){
        if(raiz.valor == x){
            if((raiz.esq == null) && (raiz.dir==null))
                raiz = null;
            else
            if((raiz.esq != null) && (raiz.dir != null))
                removeDoisFilhos(raiz,x);
            else
            if(raiz.esq == null)
                raiz = raiz.dir;
            else
                raiz = raiz.esq;
        }else
            removeNo(raiz, x);
    }



    static void removeNo(NoAVL n, int x){

        int f = contarFilhos(n,x);

        switch(f){
            case -1: System.out.println("O nó não existe na árvore"); break;
            case  0: removeFolha(n,x); break;
            case  1: removeUmFilho(n,x); break;
            case  2: removeDoisFilhos(n,x); break;
        }
    }
    private static void removeDoisFilhos(NoAVL n, int x) {
        if (n.valor == x){
            int maisAEsquerda = maiorDaEsquerda(n.dir).valor;
            removeNo(n,maisAEsquerda);
            n.valor = maisAEsquerda;
        }else{
            if (n.valor > x)  removeDoisFilhos(n.dir,x);
            else removeDoisFilhos(n.esq,x);
        }

    }

    static NoAVL maiorDaEsquerda(NoAVL temp){
        if (temp.esq == null) return temp;
        else return maiorDaEsquerda(temp.esq);
    }
    private static void removeUmFilho(NoAVL n, int x) {
        if (n.esq != null){
            if (n.esq.valor == x){
                if (n.esq.esq != null) n.esq = n.esq.esq;
                else n.esq = n.esq.dir;
            }
            else {
                if (n.valor > x) removeUmFilho(n.esq, x);
            }
        }
        if (n.dir != null){
            if (n.dir.valor == x) {
                if (n.dir.esq != null) n.dir = n.dir.esq;
                else n.dir = n.dir.dir;
            }
            else {
                if (n.valor < x) removeUmFilho(n.dir, x);
            }
        }
    }
    private static void removeFolha(NoAVL n, int x) {
        if (n.esq != null){
            if (n.esq.valor == x) n.esq = null;
            else {
                if (n.valor > x) removeFolha(n.esq, x);
            }
        }
        if (n.dir != null){
            if (n.dir.valor == x) n.dir = null;
            else {
                if (n.valor < x) removeFolha(n.dir, x);
            }
        }
    }
}
