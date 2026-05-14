package eduarda.atividades.desafio;




public class ArvBinaria {
    public static NoP raiz = null;

    public static NoP getRaiz (){
        return raiz;
    }

    public static void inserirExclusivo(String p) {

        if (!existe(p)) {

            NoP novo = new NoP(p);

            if (raiz == null) {
                raiz = novo;
            } else {

                NoP temp = raiz;
                boolean inseriu = false;

                while (!inseriu) {
                    int comparador = novo.palavra.compareTo(temp.palavra);
                    if (comparador <= 0) {
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
    }

    public static void exibir(NoP temp) {
        if (temp != null) {
            //TENTE MUDAR A ORDEM DAS 3 LINHAS ABAIXO
            exibir(temp.esq);
            System.out.println(temp.palavra);
            exibir(temp.dir);
        }
    }

    public static boolean ehFolha(NoP temp) {
        if ((temp.esq == null) && (temp.dir == null)) {
            return true;
        }
        return false;
    }

    public static int profundidade(NoP temp) {
        if (temp != null) {
            if (ehFolha(temp)) {
                return 0;
            } else {
                int x = profundidade(temp.esq);
                int y = profundidade(temp.dir);
                int r = (x > y) ? x : y;
                return r + 1;
            }
        }
        return -1;
    }

    public static int tamanho(NoP temp) {
        if (temp != null) {
            return 1 + tamanho(temp.esq) + tamanho(temp.dir);
        }

        return 0;
    }

    public static boolean existe(String p) {
        NoP temp = raiz;
        while(temp!=null){
            if(temp.palavra.equals(p))
                return true;
            else{
                int comparador = p.compareTo(temp.palavra);
                if (comparador <= 0)
                    temp = temp.esq;
                else
                    temp = temp.dir;
            }
        }


        return false;
    }

    public static void acharERemover(char n, int x){
        NoP no = acharNo(n, x, raiz);


        while(no != null){


            no = acharNo(n,x,raiz);
        }
    }
    public static void removeNo(NoP no){

        int f = contaFilhos(no);
        if(no == raiz){
            remover();
        }else{
            switch(f){
                case  0: removeFolha(no); break;
                case  1: removeUmFilho(no); break;
                case  2: removeDoisFilhos(n); break;
            }
        }



    }
    static void remover(){
        if((raiz.esq == null) && (raiz.dir==null))
            raiz = null;
        else if((raiz.esq != null) && (raiz.dir != null))
            //removeDoisFilhos(raiz);
            System.out.println("a");
        else if (raiz.esq == null)
            raiz = raiz.dir;
        else
            raiz = raiz.esq;

    }
    public static int contaFilhos(NoP n){
        int ret;

        if (n.esq == null && n.dir == null) ret = 0;
        else if (n.esq != null && n.dir != null) ret = 2;
        else ret = 1;
        return ret;

    }

    private static int acharNo(char n, int x, NoP temp) {
        int achado;
        if (temp != null) {
            if (temp.dir != null) {
                if (temp.dir.palavra.charAt(x) == n) {
                    removeNo(temp);
                    return -1;
                }
            } else if (temp.esq != null) {
                if (temp.esq.palavra.charAt(x) == n) {
                    removeNo(temp);
                    return -1;
                }
            }


            achado = acharNo(n, x, temp.esq);
            if (achado == -1) {
                acharNo(n, x, temp.dir);
            }

        }
        return -1;
    }

    private static void removeUmFilho(NoP n) {
        if (n.dir != null){
            if (n.dir.dir != null){
                n.dir = n.dir.dir;
            }else{
                n.dir = n.dir.esq;
            }

        } else if (n.esq != null){
        if (n.esq.dir != null){
            n.esq = n.dir.dir;
        }else{
            n.esq = n.dir.esq;
        }

    }
    }

    private static void removeDoisFilhos(NoP n) {
        NoP filho = n.esq;
        NoP temp = n.esq.dir;

        if(temp !=null){
            //andar para direita o maximo possivel
        }



    }

    private static void removeFolha(NoP n) {
        NoP temp = n;
        if (temp.dir != null) {
            temp.dir = null;
        } else if (temp.esq != null) {
                temp.esq = null;

            }


    }}

