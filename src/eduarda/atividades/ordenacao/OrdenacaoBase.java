package eduarda.atividades.ordenacao;

public class OrdenacaoBase {

    public static void main(String[] args) {
        int N = 50500;

        int vetAleatorio_1[] = new int[N];
        int vetMelhorCaso_1[] = new int[N];
        int vetPiorCaso_1[] = new int[N];

        inicializarVetor(vetAleatorio_1, N, 0); //0-aleatório, 1-crescente, 2-decrescente
        inicializarVetor(vetMelhorCaso_1, N, 1); //0-aleatório, 1-crescente, 2-decrescente
        inicializarVetor(vetPiorCaso_1, N, 2); //0-aleatório, 1-crescente, 2-decrescente

        int vetAleatorio_2[] = vetAleatorio_1.clone();
        int vetMelhorCaso_2[] = vetMelhorCaso_1.clone();
        int vetPiorCaso_2[] = vetPiorCaso_1.clone();



        long inicio, fim, tempoS, tempoMS;

        //////// ORDENAÇÃO RUIM ! /////////////////

        //--- ALEATORIO ---//
        inicio = System.currentTimeMillis();
        ordenar(vetAleatorio_1, N);
        fim = System.currentTimeMillis();
        tempoS = (fim - inicio) / 1000;
        tempoMS = (fim - inicio) - tempoS * 1000;
        System.out.println("Tempo de ordenacao Aleatorio: " + tempoS + "s" + tempoMS + "ms");
        //exibirVetor(vetAleatorio_1, N);

        //--- MELHOR CASO ---//
        inicio = System.currentTimeMillis();
        ordenar(vetMelhorCaso_1, N);
        fim = System.currentTimeMillis();
        tempoS = (fim - inicio) / 1000;
        tempoMS = (fim - inicio) - tempoS * 1000;
        System.out.println("Tempo de ordenacao Melhor Caso: " + tempoS + "s" + tempoMS + "ms");
        //exibirVetor(vetMelhorCaso_1, N);

        //--- PIOR CASO ---//
        inicio = System.currentTimeMillis();
        ordenar(vetPiorCaso_1, N);
        fim = System.currentTimeMillis();
        tempoS = (fim - inicio) / 1000;
        tempoMS = (fim - inicio) - tempoS * 1000;
        System.out.println("Tempo de ordenacao Pior Caso: " + tempoS + "s" + tempoMS + "ms");
        //exibirVetor(vetPiorCaso_1, N);

        //////// ORDENAÇÃO MELHORADO ! /////////////////

        //--- ALEATORIO ---//
        inicio = System.currentTimeMillis();
        ordenarMelhorado(vetAleatorio_2, N);
        fim = System.currentTimeMillis();
        tempoS = (fim - inicio) / 1000;
        tempoMS = (fim - inicio) - tempoS * 1000;
        System.out.println("Tempo de ordenacao(melhorado) Aleatorio: " + tempoS + "s" + tempoMS + "ms");
        //exibirVetor(vetAleatorio_2, N);

        //--- MELHOR CASO ---//
        inicio = System.currentTimeMillis();
        ordenarMelhorado(vetMelhorCaso_2, N);
        fim = System.currentTimeMillis();
        tempoS = (fim - inicio) / 1000;
        tempoMS = (fim - inicio) - tempoS * 1000;
        System.out.println("Tempo de ordenacao(melhorado) Melhor Caso: " + tempoS + "s" + tempoMS + "ms");
        //exibirVetor(vetMelhorCaso_2, N);

        //--- PIOR CASO ---//
        inicio = System.currentTimeMillis();
        ordenarMelhorado(vetPiorCaso_2, N);
        fim = System.currentTimeMillis();
        tempoS = (fim - inicio) / 1000;
        tempoMS = (fim - inicio) - tempoS * 1000;
        System.out.println("Tempo de ordenacao(melhorado) Pior Caso: " + tempoS + "s" + tempoMS + "ms");
        exibirVetor(vetPiorCaso_2, N);



    }

    static void inicializarVetor(int vet[], int N, int s) {
        switch(s){
            case 0:
                for (int i = 0; i < N; i++)
                    vet[i] = (int) (Math.random() * (N * 2));
                break;
            case 1:
                for (int i = 0; i < N; i++)
                    vet[i] = i+1;
                break;
            case 2:
                for (int i = 0; i < N; i++)
                    vet[i] = N-i;
                break;
        }
    }

    private static void exibirVetor(int[] vet, int N) {
        for (int i = 0; i < N; i++) {
            if (vet[i] < 10) {
                System.out.print("0" + vet[i] + " ");
            } else {
                System.out.print(vet[i] + " ");
            }
        }
        System.out.println("");
    }

    private static void troca(int[] vet, int a, int b) {
        int aux = vet[a];
        vet[a] = vet[b];
        vet[b] = aux;
    }

    private static void ordenar(int[] vet, int N) {
        for(int i=0; i<N; i++){
            for(int j=0; j<N-1; j++){
                if(vet[j]>vet[j+1])
                    troca(vet, j, j+1);
            }
        }

    }

    private static void ordenarMelhorado(int[] vet, int N) {
        boolean ordenado = true;

        for(int i=0; i<N; i++){
            for(int j=0; j<N-i-1; j++){
                if(vet[j]>vet[j+1]){
                    ordenado = false;
                    troca(vet, j, j+1);
                }
            }
            if(ordenado) break;
            else ordenado = true;
        }
    }

    private static void ordenarMaiorMenor(int[] vet, int N){
        for (int i = 0; i < N; i++) {
            System.out.println(vet[i]);
        }
    }





}

