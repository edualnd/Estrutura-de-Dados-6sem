package eduarda.atividades.recursividade;

public class Tarefa {
    static void main(String[] args) {


    }

    private static void exibeRec(int i) {
        if( i == 1 )
            System.out.println(i);
        else{
            exibeRec(i+1);
            System.out.println(i);
        }
    }
    public static int fatorial(int x){
        if (x==1){
            return x;
        }else{
            return x * fatorial(x-1);
        }

    }
    public static int pot(int x, int n){
        if (n==1){
            return x;
        }else{
            return x * pot(x, n-1);
        }
    }
    public static int vetor(int[] vet, int n){
        if (n==0){
            return 0;
        }else{
            return vet[n-1] + vetor(vet, n-1);
        }

    }
    public static int encontreMenor(int[] vet, int i){
        if (i+1 == vet.length){
            return vet[i];
        }else{
            int aux =  encontreMenor(vet, i+1);
            if(vet[i]> aux) {
                return aux;
            }else{
                return vet[i];
            }

        }

    };
    public static int nDigitos(int num){
        if(num/10 <= 0){
            return 1;
        }else{
            return 1 + nDigitos(num/10);
        }
    }
    public static String inverteStr(String str, int i){
        if(str.length() == i+1){
            return str.charAt(i) + "";
        }else{
            return inverteStr(str, i+1) + str.charAt(i);
        }
    }
    public static String decParaBin(int num){
        if(num/2 <= 0){
            return  num%2 + "";
        }else{

            return decParaBin(num/2) + num%2;
        }
    }

}
