package eduarda.atividades.avaliacao01;

public class Avaliacao01 {
    public static void main() {
        int tamanhoVet = 5000;

        int vetAleatorio[] = new int[tamanhoVet];
        int vetMelhorCaso[] = new int[tamanhoVet];
        int vetPiorCaso[] = new int[tamanhoVet];

        preencherVetor(vetAleatorio, tamanhoVet, 0);
        preencherVetor(vetMelhorCaso, tamanhoVet, 1);
        preencherVetor(vetPiorCaso, tamanhoVet, 2);

        System.out.println("=== Bubble Sort ===");

        bubbleSort(vetAleatorio, tamanhoVet, "Aleatorio");
        bubbleSort(vetMelhorCaso, tamanhoVet, "Melhor Caso");
        bubbleSort(vetPiorCaso, tamanhoVet, "Pior Caso");

        System.out.println();
        System.out.println("=== Selection Sort ===");

        selectionSort(vetAleatorio, tamanhoVet, "Aleatorio");
        selectionSort(vetMelhorCaso, tamanhoVet, "Melhor Caso");
        selectionSort(vetPiorCaso, tamanhoVet, "Pior Caso");

        System.out.println();
        System.out.println("=== Insertion Sort ===");

        insertionSort(vetAleatorio, tamanhoVet, "Aleatorio");
        insertionSort(vetMelhorCaso, tamanhoVet, "Melhor Caso");
        insertionSort(vetPiorCaso, tamanhoVet, "Pior Caso");

        System.out.println();
        System.out.println("=== Merge Sort ===");

        mergeSortImpl(vetAleatorio, tamanhoVet, "Aleatorio");
        mergeSortImpl(vetMelhorCaso, tamanhoVet, "Melhor Caso");
        mergeSortImpl(vetPiorCaso, tamanhoVet, "Pior Caso");

        System.out.println();
        System.out.println("=== Heap Sort ===");

        heapSort(vetAleatorio, tamanhoVet, "Aleatorio");
        heapSort(vetMelhorCaso, tamanhoVet, "Melhor Caso");
        heapSort(vetPiorCaso, tamanhoVet, "Pior Caso");

        System.out.println();
        System.out.println("=== Counting Sort ===");

        countingSort(vetAleatorio, tamanhoVet, "Aleatorio");
        countingSort(vetMelhorCaso, tamanhoVet, "Melhor Caso");
        countingSort(vetPiorCaso, tamanhoVet, "Pior Caso");

        System.out.println();
        System.out.println("=== Quick Sort ===");

        quickSortImpl(vetAleatorio, tamanhoVet, "Aleatorio");
        quickSortImpl(vetMelhorCaso, tamanhoVet, "Melhor Caso");
        quickSortImpl(vetPiorCaso, tamanhoVet, "Pior Caso");

        System.out.println();
    }

    private static void bubbleSort(int[] vet, int tamVet, String caso) {
        long inicio, fim, tempoS, tempoMS;
        int vetor[] = vet.clone();
        inicio = System.currentTimeMillis();

        int aux = 0;
        int i = 0;
        for(i = 0; i< tamVet-1; i++) {
            for (int j = 0; j < tamVet -1 -i; j++) {
                if (vetor[j] > vetor[j + 1]) {
                    aux = vetor[j];
                    vetor[j] = vetor[j + 1];
                    vetor[j + 1] = aux;
                }
            }
        }

        fim = System.currentTimeMillis();
        tempoS = (fim - inicio) / 1000;
        tempoMS = (fim - inicio) - tempoS * 1000;
        System.out.println("Tempo de ordenacao(melhorado) " + caso + ": " + tempoS + "s" + tempoMS + "ms");
        //exibirVetor(vetor, tamVet);
    }

    private static void selectionSort(int[] vet, int tamVet, String caso) {
        long inicio, fim, tempoS, tempoMS;
        int vetor[] = vet.clone();
        inicio = System.currentTimeMillis();

        for (int i = 0; i < tamVet - 1; i++) {
            int minElementIndex = i;
            for (int j = i + 1; j < tamVet; j++) {
                if (vetor[minElementIndex] > vetor[j]) {
                    minElementIndex = j;
                }
            }
            if (minElementIndex != i) {
                int temp = vetor[i];
                vetor[i] = vetor[minElementIndex];
                vetor[minElementIndex] = temp;
            }
        }



        fim = System.currentTimeMillis();
        tempoS = (fim - inicio) / 1000;
        tempoMS = (fim - inicio) - tempoS * 1000;
        System.out.println("Tempo de ordenacao(melhorado) " + caso + ": " + tempoS + "s" + tempoMS + "ms");
        //exibirVetor(vetor, tamVet);
    }

    private static void insertionSort(int[] vet, int tamVet, String caso) {
        long inicio, fim, tempoS, tempoMS;
        int vetor[] = vet.clone();
        inicio = System.currentTimeMillis();

        for (int i = 1; i < tamVet; i++) {
            int key = vetor[i];
            int j = i - 1;
            while (j >= 0 && vetor[j] > key) {
                vetor[j + 1] = vetor[j];
                j = j - 1;
            }
            vetor[j + 1] = key;
        }

        fim = System.currentTimeMillis();
        tempoS = (fim - inicio) / 1000;
        tempoMS = (fim - inicio) - tempoS * 1000;
        System.out.println("Tempo de ordenacao(melhorado) " + caso + ": " + tempoS + "s" + tempoMS + "ms");
        //exibirVetor(vetor, tamVet);
    }

    private static void mergeSortImpl(int[] vet, int tamVet, String caso) {
        long inicio, fim, tempoS, tempoMS;
        int vetor[] = vet.clone();
        inicio = System.currentTimeMillis();

        mergeSort(vetor, tamVet);

        fim = System.currentTimeMillis();
        tempoS = (fim - inicio) / 1000;
        tempoMS = (fim - inicio) - tempoS * 1000;
        System.out.println("Tempo de ordenacao(melhorado) " + caso + ": " + tempoS + "s" + tempoMS + "ms");
        //exibirVetor(vetor, tamVet);
    }

    private static void mergeSort(int[] a, int n) {
        if (n < 2) {
            return;
        }
        int mid = n / 2;
        int[] l = new int[mid];
        int[] r = new int[n - mid];

        for (int i = 0; i < mid; i++) {
            l[i] = a[i];
        }
        for (int i = mid; i < n; i++) {
            r[i - mid] = a[i];
        }
        mergeSort(l, mid);
        mergeSort(r, n - mid);

        merge(a, l, r, mid, n - mid);
    }

    public static void merge(int[] a, int[] l, int[] r, int left, int right) {

        int i = 0, j = 0, k = 0;
        while (i < left && j < right) {
            if (l[i] <= r[j]) {
                a[k++] = l[i++];
            }
            else {
                a[k++] = r[j++];
            }
        }
        while (i < left) {
            a[k++] = l[i++];
        }
        while (j < right) {
            a[k++] = r[j++];
        }
    }

    private static void heapSort(int[] vet, int tamVet, String caso) {
        long inicio, fim, tempoS, tempoMS;
        int vetor[] = vet.clone();
        inicio = System.currentTimeMillis();

        for (int i = tamVet / 2 - 1; i >= 0; i--) {
            heapify(vetor, tamVet, i);
        }


        for (int i = tamVet - 1; i > 0; i--) {


            int temp = vetor[0];
            vetor[0] = vetor[i];
            vetor[i] = temp;


            heapify(vetor, i, 0);
        }

        fim = System.currentTimeMillis();
        tempoS = (fim - inicio) / 1000;
        tempoMS = (fim - inicio) - tempoS * 1000;
        System.out.println("Tempo de ordenacao(melhorado) " + caso + ": " + tempoS + "s" + tempoMS + "ms");
        //exibirVetor(vetor, tamVet);
    }

    public static void heapify(int[] vet, int tamanho, int i) {

        int maior = i;
        int esquerda = 2 * i + 1;
        int direita = 2 * i + 2;


        if (esquerda < tamanho && vet[esquerda] > vet[maior]) {
            maior = esquerda;
        }


        if (direita < tamanho && vet[direita] > vet[maior]) {
            maior = direita;
        }

        if (maior != i) {
            int troca = vet[i];
            vet[i] = vet[maior];
            vet[maior] = troca;


            heapify(vet, tamanho, maior);
        }
    }

    private static void countingSort(int[] vet, int tamVet, String caso) {
        long inicio, fim, tempoS, tempoMS;
        int vetor[] = vet.clone();
        inicio = System.currentTimeMillis();

        int maior = vet[0];
        for (int i = 1; i < tamVet; i++) { // Descobre o maior
            if (vetor[i] > maior) {
                maior = vetor[i];
            }
        }

        int[] contagem = new int[maior + 1]; // vetor de contagem
        for (int i = 0; i < tamVet; i++) {
            contagem[vetor[i]]++;
        }

        for (int i = 1; i <= maior; i++) { // conta
            contagem[i] += contagem[i - 1];
        }

        int[] ordenado = new int[tamVet]; // vetor aux
        for (int i = tamVet - 1; i >= 0; i--) {
            ordenado[contagem[vetor[i]] - 1] = vetor[i];
            contagem[vetor[i]]--;
        }
        for (int i = 0; i < tamVet; i++) { // ordena
            vetor[i] = ordenado[i];
        }



        fim = System.currentTimeMillis();
        tempoS = (fim - inicio) / 1000;
        tempoMS = (fim - inicio) - tempoS * 1000;
        System.out.println("Tempo de ordenacao(melhorado) " + caso + ": " + tempoS + "s" + tempoMS + "ms");
        //exibirVetor(vetor, tamVet);
    }
    private static void quickSortImpl(int[] vet, int tamVet, String caso) {
        long inicio, fim, tempoS, tempoMS;
        int vetor[] = vet.clone();
        inicio = System.currentTimeMillis();


        quickSort(vetor, 0, tamVet-1);


        fim = System.currentTimeMillis();
        tempoS = (fim - inicio) / 1000;
        tempoMS = (fim - inicio) - tempoS * 1000;
        System.out.println("Tempo de ordenacao(melhorado) " + caso + ": " + tempoS + "s" + tempoMS + "ms");
        //exibirVetor(vetor, tamVet);
    }
    static void quickSort(int arr[], int begin, int end) {
        if (begin < end) {
            int partitionIndex = partition(arr, begin, end);

            quickSort(arr, begin, partitionIndex-1);
            quickSort(arr, partitionIndex+1, end);
        }
    }

    static int partition(int arr[], int begin, int end) {
        int pivot = arr[end];
        int i = (begin-1);

        for (int j = begin; j < end; j++) {
            if (arr[j] <= pivot) {
                i++;

                int swapTemp = arr[i];
                arr[i] = arr[j];
                arr[j] = swapTemp;
            }
        }

        int swapTemp = arr[i+1];
        arr[i+1] = arr[end];
        arr[end] = swapTemp;

        return i+1;
    }

    static void preencherVetor(int vet[], int N, int s) {
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

}

