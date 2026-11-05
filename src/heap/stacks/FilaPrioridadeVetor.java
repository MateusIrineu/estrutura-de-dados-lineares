package heap.stacks;

public class FilaPrioridadeVetor {
    private int[] vetor;
    private int tamanho;

    public FilaPrioridadeVetor(int capacidadeMax) {
        vetor = new int[capacidadeMax + 1];
        tamanho = 0;
    }

    public int size() {
        return tamanho;
    }

    public boolean isEmpty() {
        return tamanho == 0;
    }

    public int min() {
        if (isEmpty()) throw new RuntimeException("A fila está vazia!");
        return vetor[1]; 
    }

    public void insert(int k) {
        tamanho++;
        vetor[tamanho] = k;
        upheap(tamanho);
    }

    public int removeMin() {
        if (isEmpty()) throw new RuntimeException("A fila está vazia!");
        
        int menor = vetor[1];
        vetor[1] = vetor[tamanho];
        tamanho--;
        
        downheap(1);
        
        return menor;
    }

    private void upheap(int i) {
        while (i > 1 && vetor[i / 2] > vetor[i]) {
            int temp = vetor[i];
            vetor[i] = vetor[i / 2];
            vetor[i / 2] = temp;
            i = i / 2;
        }
    }

    private void downheap(int i) {
        while (2 * i <= tamanho) {
            int filhoEsquerdo = 2 * i;
            int filhoDireito = 2 * i + 1;
            int menorFilho = filhoEsquerdo;

            if (filhoDireito <= tamanho && vetor[filhoDireito] < vetor[filhoEsquerdo]) {
                menorFilho = filhoDireito;
            }

            if (vetor[i] <= vetor[menorFilho]) {
                break; 
            }

            int temp = vetor[i];
            vetor[i] = vetor[menorFilho];
            vetor[menorFilho] = temp;
            
            i = menorFilho;
        }
    }
}