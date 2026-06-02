package eduarda.atividades.bimestre2.arvorebinaria.avl;

public class SobreArvore {
    //MAIOR VALOR DA ARVORE
    static int maior(NoAVL temp){
        while (temp.dir != null){
            if (temp.dir != null) temp = temp.dir;
        }
        return temp.valor;
    }

    //MENOR VALOR DA ARVORE
    static int menor(NoAVL temp){
        while (temp.esq != null){
            if (temp.esq != null) temp = temp.esq;
        }
        return temp.valor;
    }

    //EXIBIR FOLHAS
    static void exibeFolhas(NoAVL temp){
        if (temp != null){
            exibeFolhas(temp.esq);
            if(ehFolha(temp))System.out.println(temp.valor + " ");
            exibeFolhas(temp.dir);
        }
    }
    private static boolean ehFolha(NoAVL temp) {
        return temp.esq == null && temp.dir == null;
    }

    static int profundidade(NoAVL temp){
        if(temp != null){
            if(ehFolha(temp))
                return 0;
            else{
                int x = profundidade(temp.esq);
                int y = profundidade(temp.dir);
                int r = (x>y)? x : y;
                return r+1;
            }
        }
        return -1;
    }

    static int tamanho(NoAVL temp){
        if(temp != null){
            return tamanho(temp.esq) + tamanho(temp.dir) + 1;
        }
        return 0;
    }
}
