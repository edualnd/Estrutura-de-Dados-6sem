package eduarda.atividades.listaligada.circular.lista11.atividade04;



import eduarda.atividades.listaligada.circular.lista11.atividade03.No;

import java.util.Scanner;

public class Atividade04 {
    static NoLivro inicio = null;
    static NoLivro fim = null;

    public static void main(String[] args) {
        cadastrarLivro("LORENZI, F.; MATTOS, P. N.; CARVALHO, T. P."," Estruturas de dados","1ª edição","São Paulo","Thomson Learning",2007);
        cadastrarLivro("PEREIRA, S. L.","Estrutura de dados fundamentais: conceitos e aplicações","12ª edição","São Paulo","Érica",2008);
        cadastrarLivro("LAFORE, R.","Estrutura de dados & algoritmos em java","1ª edição","Rio de Janeiro","Ciência Moderna",2004);
        cadastrarLivro("SZWARCFITER, J. L.; MARKENZON, L.","Estruturas de dados e seus algoritmos","3ª edição","Rio de Janeiro","LTC",2010);
        cadastrarLivro("PREISS, B. R.","Estruturas de dados e algoritmos: pradrões de projetos orientados a objeto com java","1ª edição","Rio de Janeiro","Elsevier",2000);
        cadastrarLivro("WIRTH, N.","Algoritmos e estruturas de dados","1ª edição","Rio de Janeiro","LTC",2008);
        cadastrarLivro("CELES, W. ; CERQUEIRA, R.; RANGEL, J. L.","Introdução a estruturas de dados com técnicas de programação em C","1ª edição","Rio de Janeiro","Elsevier",2004);
        cadastrarLivro("GUIMARÃES, Â. M.; LAGES, N. A. C.","Algoritmos e estruturas de dados","1ª edição","Rio de Janeiro","LTC",2008);
        //autor, titulo, edicao, local, editora, ano

        Scanner teclado = new Scanner(System.in);

        String opcao;

        NoLivro atual = inicio;
        // ANTENÇÃO, EXIBA AS INFORMAÇÕES SIMPLES DO PRIMEIRO LIVRO ANTES DE ENTRAR NO MENU
        System.out.println(atual.titulo);

        do{
            System.out.print("\nINFORME A OPÇÃO DESEJADA\n"
                    + "\"a\" para avançar\n"
                    + "\"r\" para retroceder\n"
                    + "\"d\" para detalhar\n"
                    + "\"s\" para sair\n"
                    + "ESCOLHA:");

            opcao = teclado.nextLine();

            if(opcao.equals("a")){
                System.out.println("\nLIVRO ATUAL: " + atual.titulo);


                atual = atual.getProximo();

            }else if(opcao.equals("r")){
                System.out.println("\nLIVRO ATUAL: " + atual.titulo);
                atual = atual.getAnterior();
            }else if(opcao.equals("d")){
                System.out.println("\nLIVRO ATUAL DETALHADO");

                System.out.println("Autor: " + atual.autor);
                System.out.println("Título: " + atual.titulo);
                System.out.println("Edição: " + atual.edicao);
                System.out.println("Local: " + atual.local);
                System.out.println("Editora: " + atual.editora);
                System.out.println("Ano: " + atual.ano);


            }



        }while(!opcao.equals("s"));

    }

    private static void cadastrarLivro(String autor, String titulo, String edicao, String local, String editora, int ano) {
        NoLivro novoLivro = new NoLivro(autor, titulo, edicao, local, editora, ano);
        if(inicio == null){
            inicio = novoLivro;
            fim = novoLivro;
            inicio.setAnterior(novoLivro);
            fim.setProximo(novoLivro);

        }else{
            fim.setProximo(novoLivro);
            novoLivro.setAnterior(fim);
            fim = novoLivro;
            inicio.setAnterior(fim);
            fim.setProximo(inicio);

        }

    }


}
