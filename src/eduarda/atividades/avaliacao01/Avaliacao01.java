package eduarda.atividades.avaliacao01;

public class Avaliacao01 {

    static void main() {
        int tamanhoVet = 10000;

        int[] vetAleatorio = new int[tamanhoVet];
        int[] vetMelhorCaso = new int[tamanhoVet];
        int[] vetPiorCaso = new int[tamanhoVet];

        preencherVetor(vetAleatorio, tamanhoVet, 0);
        preencherVetor(vetMelhorCaso, tamanhoVet, 1);
        preencherVetor(vetPiorCaso, tamanhoVet, 2);

        System.out.println("=== Bubble Sort ===");
        bubbleSort(vetAleatorio.clone(), tamanhoVet, "Aleatorio");
        bubbleSort(vetMelhorCaso.clone(), tamanhoVet, "Melhor Caso");
        bubbleSort(vetPiorCaso.clone(), tamanhoVet, "Pior Caso");

        System.out.println();
        System.out.println("=== Selection Sort ===");
        selectionSort(vetAleatorio.clone(), tamanhoVet, "Aleatorio");
        selectionSort(vetMelhorCaso.clone(), tamanhoVet, "Melhor Caso");
        selectionSort(vetPiorCaso.clone(), tamanhoVet, "Pior Caso");

        System.out.println();
        System.out.println("=== Insertion Sort ===");
        insertionSort(vetAleatorio.clone(), tamanhoVet, "Aleatorio");
        insertionSort(vetMelhorCaso.clone(), tamanhoVet, "Melhor Caso");
        insertionSort(vetPiorCaso.clone(), tamanhoVet, "Pior Caso");

        System.out.println();
        System.out.println("=== Merge Sort ===");
        mergeSortImpl(vetAleatorio.clone(), tamanhoVet, "Aleatorio");
        mergeSortImpl(vetMelhorCaso.clone(), tamanhoVet, "Melhor Caso");
        mergeSortImpl(vetPiorCaso.clone(), tamanhoVet, "Pior Caso");

        System.out.println();
        System.out.println("=== Heap Sort ===");
        heapSort(vetAleatorio.clone(), tamanhoVet, "Aleatorio");
        heapSort(vetMelhorCaso.clone(), tamanhoVet, "Melhor Caso");
        heapSort(vetPiorCaso.clone(), tamanhoVet, "Pior Caso");

        System.out.println();
        System.out.println("=== Counting Sort ===");
        countingSort(vetAleatorio.clone(), tamanhoVet, "Aleatorio");
        countingSort(vetMelhorCaso.clone(), tamanhoVet, "Melhor Caso");
        countingSort(vetPiorCaso.clone(), tamanhoVet, "Pior Caso");

        System.out.println();
        System.out.println("=== Quick Sort ===");
        quickSortImpl(vetAleatorio.clone(), tamanhoVet, "Aleatorio");
        quickSortImpl(vetMelhorCaso.clone(), tamanhoVet, "Melhor Caso");
        quickSortImpl(vetPiorCaso.clone(), tamanhoVet, "Pior Caso");

        System.out.println();
    }

    // ==================== BUBBLE SORT ====================
    private static void bubbleSort(int[] vetor, int tamVet, String caso) {
        long inicio = System.currentTimeMillis();

        int aux;
        for (int i = 0; i < tamVet - 1; i++) {
            for (int j = 0; j < tamVet - 1 - i; j++) {
                if (vetor[j] > vetor[j + 1]) {
                    aux = vetor[j];
                    vetor[j] = vetor[j + 1];
                    vetor[j + 1] = aux;
                }
            }
        }

        long fim = System.currentTimeMillis();
        long tempoS = (fim - inicio) / 1000;
        long tempoMS = (fim - inicio) - tempoS * 1000;
        System.out.println("[" + caso + "] Tempo: " + tempoS + "s " + tempoMS + "ms");
    }

    // ==================== SELECTION SORT ====================
    private static void selectionSort(int[] vetor, int tamVet, String caso) {
        long inicio = System.currentTimeMillis();
        for (int i = 0; i < tamVet - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < tamVet; j++) {
                if (vetor[j] < vetor[minIndex]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                int temp = vetor[i];
                vetor[i] = vetor[minIndex];
                vetor[minIndex] = temp;
            }
        }

        long fim = System.currentTimeMillis();
        long tempoS = (fim - inicio) / 1000;
        long tempoMS = (fim - inicio) - tempoS * 1000;
        System.out.println("[" + caso + "] Tempo: " + tempoS + "s " + tempoMS + "ms");
    }

    // ==================== INSERTION SORT ====================
    private static void insertionSort(int[] vetor, int tamVet, String caso) {
        long inicio = System.currentTimeMillis();
        for (int i = 1; i < tamVet; i++) {
            int key = vetor[i];
            int j = i - 1;
            while (j >= 0 && vetor[j] > key) {
                vetor[j + 1] = vetor[j];
                j--;
            }
            vetor[j + 1] = key;
        }

        long fim = System.currentTimeMillis();
        long tempoS = (fim - inicio) / 1000;
        long tempoMS = (fim - inicio) - tempoS * 1000;
        System.out.println("[" + caso + "] Tempo: " + tempoS + "s " + tempoMS + "ms");
    }

    // ==================== MERGE SORT ====================
    private static void mergeSortImpl(int[] vetor, int tamVet, String caso) {
        long inicio = System.currentTimeMillis();
        mergeSort(vetor, tamVet);

        long fim = System.currentTimeMillis();
        long tempoS = (fim - inicio) / 1000;
        long tempoMS = (fim - inicio) - tempoS * 1000;
        System.out.println("[" + caso + "] Tempo: " + tempoS + "s " + tempoMS + "ms");
    }

    private static void mergeSort(int[] a, int n) {
        if (n < 2) return;

        int mid = n / 2;
        int[] l = new int[mid];
        int[] r = new int[n - mid];

        for (int i = 0; i < mid; i++) l[i] = a[i];
        for (int i = mid; i < n; i++) r[i - mid] = a[i];

        mergeSort(l, mid);
        mergeSort(r, n - mid);
        merge(a, l, r, mid, n - mid);
    }

    public static void merge(int[] a, int[] l, int[] r, int left, int right) {
        int i = 0, j = 0, k = 0;
        while (i < left && j < right) {
            if (l[i] <= r[j]) a[k++] = l[i++];
            else               a[k++] = r[j++];
        }
        while (i < left)  a[k++] = l[i++];
        while (j < right) a[k++] = r[j++];
    }

    // ==================== HEAP SORT ====================
    private static void heapSort(int[] vetor, int tamVet, String caso) {
        long inicio = System.currentTimeMillis();
        for (int i = tamVet / 2 - 1; i >= 0; i--) {
            heapify(vetor, tamVet, i);
        }

        for (int i = tamVet - 1; i > 0; i--) {
            int temp = vetor[0];
            vetor[0] = vetor[i];
            vetor[i] = temp;
            heapify(vetor, i, 0);
        }

        long fim = System.currentTimeMillis();
        long tempoS = (fim - inicio) / 1000;
        long tempoMS = (fim - inicio) - tempoS * 1000;
        System.out.println("[" + caso + "] Tempo: " + tempoS + "s " + tempoMS + "ms");
    }

    public static void heapify(int[] vet, int tamanho, int i) {
        int maior    = i;
        int esquerda = 2 * i + 1;
        int direita  = 2 * i + 2;

        if (esquerda < tamanho && vet[esquerda] > vet[maior]) maior = esquerda;
        if (direita  < tamanho && vet[direita]  > vet[maior]) maior = direita;

        if (maior != i) {
            int troca = vet[i];
            vet[i]    = vet[maior];
            vet[maior] = troca;
            heapify(vet, tamanho, maior);
        }
    }

    // ==================== COUNTING SORT ====================
    private static void countingSort(int[] vetor, int tamVet, String caso) {
        long inicio = System.currentTimeMillis();
        int maior = vetor[0];
        for (int i = 1; i < tamVet; i++) {
            if (vetor[i] > maior) maior = vetor[i];
        }

        int[] contagem = new int[maior + 1];
        for (int i = 0; i < tamVet; i++) contagem[vetor[i]]++;

        for (int i = 1; i <= maior; i++) contagem[i] += contagem[i - 1];

        int[] ordenado = new int[tamVet];
        for (int i = tamVet - 1; i >= 0; i--) {
            ordenado[contagem[vetor[i]] - 1] = vetor[i];
            contagem[vetor[i]]--;
        }

        for (int i = 0; i < tamVet; i++) vetor[i] = ordenado[i];

        long fim = System.currentTimeMillis();
        long tempoS = (fim - inicio) / 1000;
        long tempoMS = (fim - inicio) - tempoS * 1000;
        System.out.println("[" + caso + "] Tempo: " + tempoS + "s " + tempoMS + "ms");
    }

    // ==================== QUICK SORT ====================
    private static void quickSortImpl(int[] vetor, int tamVet, String caso) {
        long inicio = System.currentTimeMillis();
        quickSort(vetor, 0, tamVet - 1);

        long fim = System.currentTimeMillis();
        long tempoS = (fim - inicio) / 1000;
        long tempoMS = (fim - inicio) - tempoS * 1000;
        System.out.println("[" + caso + "] Tempo: " + tempoS + "s " + tempoMS + "ms");
    }

    static void quickSort(int[] arr, int begin, int end) {
        if (begin < end) {
            int partitionIndex = partition(arr, begin, end);
            quickSort(arr, begin, partitionIndex - 1);
            quickSort(arr, partitionIndex + 1, end);
        }
    }

    static int partition(int[] arr, int begin, int end) {
        int pivot = arr[end];
        int i = begin - 1;

        for (int j = begin; j < end; j++) {
            if (arr[j] <= pivot) {
                i++;
                int swapTemp = arr[i];
                arr[i] = arr[j];
                arr[j] = swapTemp;
            }
        }

        int swapTemp = arr[i + 1];
        arr[i + 1]   = arr[end];
        arr[end]     = swapTemp;

        return i + 1;
    }

    static void preencherVetor(int[] vet, int N, int s) {
        switch (s) {
            case 0:
                for (int i = 0; i < N; i++)
                    vet[i] = (int) (Math.random() * (N * 2));
                break;
            case 1:
                for (int i = 0; i < N; i++)
                    vet[i] = i + 1;
                break;
            case 2:
                for (int i = 0; i < N; i++)
                    vet[i] = N - i;
                break;
        }
    }

    static void exibirVetor(int[] vet, int N) {
        for (int i = 0; i < N; i++) {
            if (vet[i] < 10) System.out.print("0" + vet[i] + " ");
            else             System.out.print(vet[i] + " ");
        }
        System.out.println();
    }
}