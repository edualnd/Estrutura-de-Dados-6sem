package eduarda.atividades.bimestre2.arvorebinaria.avl;

import static eduarda.atividades.bimestre2.arvorebinaria.avl.Main.raiz;
import static eduarda.atividades.bimestre2.arvorebinaria.avl.SobreArvore.profundidade;

public class Avl {
    static void mostrarFB(NoAVL n){
        if (n != null){
            int fator = fatorBalanceamento(n);
            System.out.println(n.valor + " ->  FB = " + fator);
            mostrarFB(n.esq);
            mostrarFB(n.dir);
        }
    }

    static int fatorBalanceamento(NoAVL n) {
        if (n == null) return -1;
        return profundidade(n.esq) - profundidade(n.dir);
    }

    static boolean ehAVL(NoAVL n){
        if (n != null){
            int fator = fatorBalanceamento(n);
            boolean subArvoreDir = ehAVL(n.dir);
            boolean subArvoreEsq = ehAVL(n.esq);
            return -1 <= fator && fator <=1 && subArvoreDir && subArvoreEsq;
        }
        return true;
    }

    public static void rodar(int valor, int direcao){
        if (raiz.valor == valor){
            switch (direcao){
                case 1:
                    raiz = rodarDir(raiz);
                    break;
                case -1:
                    raiz = rodarEsq(raiz);
                    break;
                default: System.out.println("Direção invalida"); break;
            }
        }
        else {
            switch (direcao){
                case 1: {
                    NoAVL avo = acharNo(valor, raiz);
                    if (avo.dir != null && avo.dir.valor == valor) {
                        avo.dir = rodarDir(avo.dir);
                    } else {
                        avo.esq = rodarDir(avo.esq);
                    }
                } break;
                case -1 : {
                    NoAVL avo = acharNo(valor, raiz);
                    if (avo.dir != null && avo.dir.valor == valor) {
                        avo.dir = rodarEsq(avo.dir);
                    } else {
                        avo.esq = rodarEsq(avo.esq);
                    }
                } break;
                default: System.out.println("Direção invalida"); break;
            }
        }
    }

    public static NoAVL acharNo(int valor, NoAVL temp){
        if(temp != null){

            if (temp.valor < valor) {
                if (temp.dir != null && temp.dir.valor == valor) return temp;
                return acharNo(valor, temp.dir);
            }
            else {
                if (temp.esq != null && temp.esq.valor == valor) return temp;
                return acharNo(valor, temp.esq);
            }
        }
        return null;


    }

    public static NoAVL rodarEsq(NoAVL temp) {
        NoAVL filho = temp.dir;
        temp.dir = filho.esq;
        filho.esq = temp;
        return filho;
    }

    public static NoAVL rodarDir(NoAVL temp) {
        NoAVL filho = temp.esq;
        temp.esq = filho.dir;
        filho.dir = temp;
        return filho;
    }

}
