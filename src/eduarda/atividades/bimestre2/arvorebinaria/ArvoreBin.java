package eduarda.atividades.bimestre2.arvorebinaria;

public class ArvoreBin {

    public static NoA raiz = null;


    public static void main(String[] args) {
//        for (int i = 0; i < 30; i++) {
//            int x = (int) (Math.random()*100);
//            //System.out.println("Inserindo: "+x);
//
//            insereExclusivo(x);
//        }
        insereExclusivo(10);
        insereExclusivo(5);
        insereExclusivo(15);
        insereExclusivo(3);
        insereExclusivo(7);
        insereExclusivo(12);
        //insereExclusivo(18);
        //exibeArvore(raiz, 0);
        System.out.println("------ exibicao --------");
        exibir(raiz);
        System.out.println(" ++++++ nova ");
        removeNo(raiz,7);
        exibir(raiz);
//        System.out.println("Maior: " + maior(raiz));
//        System.out.println("Menor: " + menor(raiz));
//        System.out.print("Folhas: "); exibeFolhas(raiz);
//        System.out.println("");
//        System.out.println("Profundidade: " + profundidade(raiz));
//        System.out.println("Tamanho: " + tamanho(raiz));


    }

    public static void inserir(int x) {
        NoA novo = new NoA(x);

        if (raiz == null) {
            raiz = novo;
        } else {

            NoA temp = raiz;
            boolean inseriu = false;

            while (!inseriu) {
                if (novo.valor <= temp.valor) {
                    if (temp.esq == null) {
                        temp.esq = novo;
                        inseriu = true;
                    } else {
                        temp = temp.esq;
                    }
                } else {
                    if (temp.dir == null) {
                        temp.dir = novo;
                        inseriu = true;
                    } else {
                        temp = temp.dir;
                    }
                }
            }
        }
    }

    public static void insereExclusivo(int x){
        if(!existe(x)) inserir(x);
    }

    private static boolean existe(int x) {
        NoA temp = raiz;
        boolean repetido = false;
        while(temp != null && !repetido){
            if (temp.valor == x) repetido = true;
            else if(temp.valor > x){
                temp = temp.dir;
            }else{
                temp = temp.esq;
            }
        }
        return repetido;
    }

    public static void exibir(NoA temp){
        if(temp != null){
            //TENTE MUDAR A ORDEM DAS 3 LINHAS ABAIXO
            System.out.println(temp.valor);
            exibir(temp.esq);

            exibir(temp.dir);
        }
    }

    public static void exibeArvore(NoA n, int x){

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

    public static int maior(NoA temp) {
        if(temp != null){
            int x = maior(temp.dir);
            if(temp.valor > x)
                return temp.valor;
            else
                return x;
        }
        return -1;
    }

    public static int menor(NoA temp) {
        if(temp != null){
            int x = menor(temp.esq);
            if(temp.valor < x)
                return temp.valor;
            else
                return x;
        }
        return 50000;
    }

    public static void exibeFolhas(NoA temp){
        if(temp != null){
            exibeFolhas(temp.esq);
            if(ehFolha(temp))
                System.out.print(temp.valor+" ");
            exibeFolhas(temp.dir);
        }
    }

    private static boolean ehFolha(NoA temp) {
        return (temp.esq == null) && (temp.dir == null);
    }

    private static int profundidade(NoA temp) {
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

    private static int tamanho(NoA temp) {
        if(temp != null)
            return 1+tamanho(temp.esq)+tamanho(temp.dir);

        return 0;
    }


    public static int contaFilhos(NoA n, int x){
        NoA temp = raiz;
        int ret;
        while(temp != null){
            if (temp.valor == x){
                if (temp.esq == null && temp.dir == null) ret = 0;
                else if (temp.esq != null && temp.dir != null) ret = 2;
                else ret = 1;
                return ret;
            }
            else if(temp.valor > x){
                temp = temp.esq;
            }else{
                temp = temp.dir;
            }
        }

        return -1;
    }

    static void remover(int x){
        if(raiz.valor == x){
            if((raiz.esq == null) && (raiz.dir==null))
                raiz = null;
            else
            if((raiz.esq != null) && (raiz.dir != null))
                removeDoisFilhos(raiz,x);
            else if (raiz.esq == null)
                raiz = raiz.dir;
            else
                raiz = raiz.esq;
        }else
            removeNo(raiz, x);
    }

    static void removeNo(NoA n, int x){

        int f = contaFilhos(n,x);

        switch(f){
            case -1: System.out.println("O nó não existe na árvore"); break;
            case  0: removeFolha(n,x); break;
            case  1: removeUmFilho(n,x); break;
            case  2: removeDoisFilhos(n,x); break;
        }
    }

    private static void removeDoisFilhos(NoA n, int x) {
    }

    private static void removeUmFilho(NoA n, int x) {
        NoA temp = n;
        boolean removido = false;
        while(!removido && temp != null){

            if (x > temp.valor){
                if (temp.dir != null && temp.dir.valor == x){
                    if (temp.dir.dir != null){
                        temp.dir = temp.dir.dir;
                    }else{
                        temp.dir = temp.dir.esq;
                    }
                    removido = true;
                }else temp = temp.dir;
            }else{
                if (temp.esq != null && temp.esq.valor == x){
                    if (temp.esq.dir != null){
                        temp.esq = temp.dir.dir;
                    }else{
                        temp.esq = temp.dir.esq;
                    }
                    removido = true;
                }  else temp = temp.esq;
            }
        }
    }

    private static void removeFolha(NoA n, int x) {
        NoA temp = n;
        boolean removido = false;
        while(!removido && temp != null){
            if (x > temp.valor){
                if (temp.dir != null && temp.dir.valor == x){
                    temp.dir = null;
                    removido = true;
                }else temp = temp.dir;
            }else{
                if (temp.esq != null && temp.esq.valor == x){
                    temp.esq = null;
                    removido = true;
                }  else temp = temp.esq;
            }
        }

    }

}