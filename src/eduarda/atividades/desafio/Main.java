package eduarda.atividades.desafio;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static NoP raiz = null;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);


        LerDados.lerArquivo_e_Inserir();
        ArvBinaria.exibir(ArvBinaria.getRaiz());
        //  System.out.println("Palavras inseridas: "+ tamanho(raiz));
        //  System.out.println("Profundidade: "+profundidade(raiz));


        System.out.println(
                "O \"FILTRO\" trata-se de um string com 5 caracteres contendo as letras a serem removidas e o \n"
                        + "simbolo * para letras que devem ser desconsideradas.\n"
                        + "Por exemplo, se no jogo a palavra em formacao eh essa \"T____\" o filtro a ser digitado deve ser \n"
                        + "\"t****\" e o metodo removeParcial devera remover todas palavras que nao comecam com a letra T, se a \n"
                        + "palavra for \"__r_a\", o filtro sera \"**r*a\" e o metodo removeParcial devera remover todas\n"
                        + "as palavras em que o 3o caractere nao seja R e o ultimo nao seja A.\n");


        String filtro = "";
        do{
            System.out.print("\nDigite o FILTRO ou 0 para SAIR: ");
            filtro = sc.next();
            if(filtro.length() == 5){
                filtro = filtro.toUpperCase();
                System.out.println("Filtrando: "+filtro);
                removeParcial(filtro, 0);
            }
        }while(!filtro.equals("0"));


    }



    private static void removeParcial(String filtro, int op) {
        switch (op){
            case 0: removerFixo(filtro);
            case 1: removerVariavel(filtro);
            case 2: removerNExiste(filtro);
        }
    }

    private static void removerNExiste(String filtro) {
    }

    private static void removerVariavel(String filtro) {
    }

    public static void removerFixo(String filtro) {
        for(int i = 0; i<5; i++){
            if(filtro.charAt(i) != '*'){
                ArvBinaria.acharERemover(filtro.charAt(i), i);
            }
        }
    }


}
