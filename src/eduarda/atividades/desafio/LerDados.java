package eduarda.atividades.desafio;

import java.io.*;
import java.util.ArrayList;

public class LerDados {

    public static void lerArquivo_e_Inserir() throws FileNotFoundException, IOException {
        String arq = "src/eduarda/atividades/desafio/entrada.txt";

        BufferedReader bf =  new BufferedReader(new FileReader(arq));
        String linha = bf.readLine();
        while (linha != null){
            String[] arrPalavras = linha.split(" ");

                for (String cha: arrPalavras){
                    String palavraValida = cha.toUpperCase();
                    if(palavraValida.length() < 8){
                        palavraValida = removerAcentos(palavraValida);
                        palavraValida = removerPontuacao(palavraValida);
                    }

                    if(palavraValida.length()==5){
                        ArvBinaria.inserirExclusivo(palavraValida);
                    }

                }

            linha = bf.readLine();
        }
        bf.close();



    }

    private static String removerAcentos(String palavraValida) {
        String pl = "";
        for (int i = 0; i < palavraValida.length(); i++) {
            char letra = palavraValida.charAt(i);
            switch (letra){
                case 'Á', 'À', 'Â', 'Ã': pl = pl + "A"; break;
                case 'É', 'È', 'Ê': pl = pl + "E"; break;
                case 'Í', 'Ì': pl = pl + "I"; break;
                case 'Ó', 'Ò', 'Ô', 'Õ': pl = pl + "O"; break;
                case 'Ú', 'Ù', 'Û': pl = pl + "U"; break;
                case 'Ç': pl = pl + "C"; break;
                default: pl = pl + letra; break;
            }
        }
        return pl;
    }

    private static String removerPontuacao(String cha) {
        String novaPalavra = "";

        for (int i = 0; i < cha.length(); i++) {
            int c = cha.charAt(i);
            if(c >= 65 && c<=90){
                novaPalavra = novaPalavra + cha.charAt(i);
            }

        }
        return novaPalavra;
    }



}
