package eduarda.atividades.bimestre2.arvorebinaria.avl;

public class Main {
    static NoAVL raiz = null;
    static void main() {
        inserir(50);
        inserir(30);
        inserir(70);
        inserir(20);
        inserir(40);
        inserir(60);
        inserir(80);

        System.out.println("Em ordem:");
        exibir(raiz);

        System.out.println("\nÁrvore:");
        exibeArvore(raiz, 0);

        System.out.println("\nMaior valor: " + maior(raiz));
        System.out.println("Menor valor: " + menor(raiz));
        exibeFolhas(raiz);
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
}
