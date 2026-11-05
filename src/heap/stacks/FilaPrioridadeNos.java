package heap.stacks;

class No {
    int chave;
    No pai;
    No esquerdo;
    No direito;

    public No(int chave) {
        this.chave = chave;
    }
}

public class FilaPrioridadeNos {
    private No raiz;
    private int tamanho;

    public FilaPrioridadeNos() {
        raiz = null;
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
        return raiz.chave;
    }

    public void insert(int k) {
        No novoNo = new No(k);

        if (isEmpty()) {
            raiz = novoNo;
        } else {
            No paiDeInsercao = encontrarNoPorPosicao((tamanho + 1) / 2);
            novoNo.pai = paiDeInsercao;

            if (paiDeInsercao.esquerdo == null) {
                paiDeInsercao.esquerdo = novoNo;
            } else {
                paiDeInsercao.direito = novoNo;
            }
            
            upheap(novoNo);
        }
        tamanho++;
    }

    public int removeMin() {
        if (isEmpty()) throw new RuntimeException("A fila está vazia!");

        int menorChave = raiz.chave;

        if (tamanho == 1) {
            raiz = null;
        } else {
            No ultimoNo = encontrarNoPorPosicao(tamanho);
            
            raiz.chave = ultimoNo.chave;
            
            if (ultimoNo.pai.esquerdo == ultimoNo) {
                ultimoNo.pai.esquerdo = null;
            } else {
                ultimoNo.pai.direito = null;
            }
            
            downheap(raiz);
        }
        
        tamanho--;
        return menorChave;
    }

    private void upheap(No atual) {
        while (atual.pai != null && atual.pai.chave > atual.chave) {
            int temp = atual.chave;
            atual.chave = atual.pai.chave;
            atual.pai.chave = temp;
            
            atual = atual.pai;
        }
    }

    private void downheap(No atual) {
        while (atual.esquerdo != null) {
            No menorFilho = atual.esquerdo;
            
            if (atual.direito != null && atual.direito.chave < atual.esquerdo.chave) {
                menorFilho = atual.direito;
            }

            if (atual.chave <= menorFilho.chave) {
                break; 
            }

            int temp = atual.chave;
            atual.chave = menorFilho.chave;
            menorFilho.chave = temp;
            
            atual = menorFilho;
        }
    }

    private No encontrarNoPorPosicao(int posicao) {
        if (posicao <= 1) return raiz;
        
        String caminho = Integer.toBinaryString(posicao);
        No atual = raiz;
        
        for (int i = 1; i < caminho.length(); i++) {
            if (caminho.charAt(i) == '0') {
                atual = atual.esquerdo;
            } else {
                atual = atual.direito;
            }
        }
        return atual;
    }
}