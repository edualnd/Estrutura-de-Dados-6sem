package eduarda.atividades.bimestre2.arvorebinaria.refazendo;

public class ArvoreBinaria {
    static NoA raiz = null;
    static void main() {
        for (int i = 0; i < 7; i++) {
            int x = (int) (Math.random()*100);

            insereExclusivo(x);
        }
        exibir(raiz);

    }

    public static void inserir(int x){
        NoA novo = new NoA(x);

        if(raiz == null) raiz = novo;
        else{
            NoA temp = raiz;
            boolean inserido = false;
            while(!inserido){
                if (novo.valor >= temp.valor){
                    if(temp.dir == null){
                        temp.dir = novo;
                        inserido = true;
                    }else temp = temp.dir;
                }else{
                    if(temp.esq == null){
                        temp.esq = novo;
                        inserido = true;
                    }else temp = temp.esq;
                }
            }
        }
    }
    public static void insereExclusivo(int x){
        if(!existe(x)) inserir(x);
    }
    public static void exibir(NoA temp){
        if(temp != null){
            System.out.println(temp.valor);

            exibir(temp.esq);
            exibir(temp.dir);
        }

    }

    // ################## AUXILIAR ################
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
}
