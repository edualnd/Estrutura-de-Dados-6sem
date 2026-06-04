package eduarda.atividades.bimestre2.arvorebinaria.avl;

import static eduarda.atividades.bimestre2.arvorebinaria.avl.Main.exibeArvore;
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

    public static NoAVL acharNo(int valor){
        NoAVL temp = raiz;

        while (temp != null){
            if (temp.dir != null && temp.dir.valor == valor) return temp;
            else if (temp.esq != null && temp.esq.valor == valor) return temp;
            else if (temp.valor < valor) {
               temp = temp.dir;
            }else {
                temp = temp.esq;
            }
        }
        return null;
    }

    public static NoAVL girarEsq(NoAVL temp) {
        NoAVL filho = temp.dir;
        temp.dir = filho.esq;
        filho.esq = temp;
        return filho;
    }

    public static NoAVL girarDir(NoAVL temp) {
        NoAVL filho = temp.esq;
        temp.esq = filho.dir;
        filho.dir = temp;
        return filho;
    }

    public static NoAVL duplaGirarEsq(NoAVL temp) {
        temp.dir = girarDir(temp.dir);
        temp = girarEsq(temp);
        return temp;
    }

    public static NoAVL duplaGirarDir(NoAVL temp) {

        temp.esq = girarEsq(temp.esq);
        temp = girarDir(temp);
        return temp;
    }
    public static NoAVL balancear(NoAVL temp){

        if (temp == null) return null;

        temp.esq = balancear(temp.esq);
        temp.dir = balancear(temp.dir);
        int fb = fatorBalanceamento(temp);

        System.out.println(fb + "  " + temp.valor);
        if (fb <= -2){ // esquerda
            if(fatorBalanceamento(temp.dir) > 0){ //duas operações
                temp = duplaGirarEsq(temp);
            }else{
                temp = girarEsq(temp);

            }
        }
        if(fb >= 2){ //direita
            if(fatorBalanceamento(temp.esq) < 0){ //duas operações
                temp = duplaGirarDir(temp);
            }else{
                temp = girarDir(temp);
            }
        }

        return temp;
    }


}
