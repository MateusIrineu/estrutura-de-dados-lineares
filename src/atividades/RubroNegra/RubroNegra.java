package atividades.RubroNegra;

public class RubroNegra {
    private int[] array;
    private int topRed;
    private int topBlack;
    private int capacidade;
    private int sizeR;
    private int sizeB;

    public RubroNegra(int capacidadeInicial) {
        this.capacidade = capacidadeInicial;
        this.array = new int[capacidadeInicial];
        this.topRed = -1;
        this.topBlack = capacidadeInicial;
        this.sizeR = 0;
        this.sizeB = 0;
    }

    private void redimensionar(int novaCapacidade) {
        int[] novoArray = new int[novaCapacidade];

        // aqui faz o caminho do Red ->
        for (int i = 0; i < this.sizeR; i++) {
            novoArray[i] = this.array[i];
        }
        //aqui fz o caminho do Black reverso <-
        for (int i = 0; i < this.sizeB; i++) {
            novoArray[novaCapacidade - 1 - i] = this.array[this.capacidade - 1 - i];
        }

        this.array = novoArray;
        this.capacidade = novaCapacidade;
        this.topBlack = novaCapacidade - this.sizeB;
    }
    private void checarRedimensionamento() {
        int totalElementos = this.sizeR + this.sizeB;

        if (totalElementos == this.capacidade) {
            redimensionar(this.capacidade * 2);
        }
        else if (totalElementos <= this.capacidade / 3 && this.capacidade / 2 >= 4) {
            redimensionar(this.capacidade / 2);
        }
    }
    public void pushRed(int valor) {
        checarRedimensionamento();
        this.topRed++; // LIFO
        this.array[this.topRed] = valor;
        this.sizeR++;
    }

    public int popRed() {
        if (isEmptyRed()) {
            throw new IllegalStateException("A Pilha vermelha está vazia!");
        }
        int valor = this.array[this.topRed];
        this.topRed--;
        this.sizeR--;
        checarRedimensionamento();
        return valor;
    }

    public int topRed() {
        if (isEmptyRed()) {
            throw new IllegalStateException("A pilha vermelha está vazia!");
        } 
        return this.array[this.topRed];
    }

    public boolean isEmptyRed() {
        return this.sizeR == 0;
    }

    public int sizeRed_() {
        return this.sizeR;
    }

    public void pushBlack(int valor) {
        checarRedimensionamento();
        this.topBlack--;
        this.array[this.topBlack] = valor;
        this.sizeB++;
    }

    public int popBlack() {
        if (isEmptyBlack()) {
            throw new IllegalStateException("A Pilha está vazia!");
        }
        int valor = this.array[this.topBlack];
        this.topBlack++;
        this.sizeB--;
        checarRedimensionamento();
        return valor;
    }

    public int topBlack() {
        if (isEmptyBlack()) {
            throw new IllegalStateException("A Pilha está vazia!");
        }
        return this.array[this.topBlack];
    }

    public boolean isEmptyBlack() {
        return this.sizeB == 0;
    }

    public int sizeBlack_() {
        return this.sizeB;
    }
}