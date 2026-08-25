package stacks;

public class FilaListaLigada implements Interface {
    private static class No {
        Object elemento;
        No next;
    }

    private No inicio;
    private No fim;
    private int tamanho;

    public FilaListaLigada() {
        this.inicio = null;
        this.fim = null;
        this.tamanho = 0; // constructor
    }

    @Override
    public boolean isEmpty() {
        return this.tamanho == 0;
    }

    @Override
    public int size() {
        return this.tamanho;
    }

    @Override
    public Object first() throws EFilaVazia {
        if (isEmpty()) {
            throw new EFilaVazia("A Fila está vzia");
        }
        return this.inicio.elemento; // caso nao esteja retorna
    }

    @Override
    public void enqueue(Object o) {
        No novoNo = new No(); // um novo no baseado no padrão inicial do constructor
        novoNo.elemento = o;
        novoNo.next = null; // vai pro final entao o next dele é ninguem

        if (isEmpty()) {
            this.inicio = novoNo;
        } else {
            this.fim.next = novoNo;
        }

        this.fim = novoNo;
        this.tamanho++;
    }

    @Override
    public Object dequeue() throws EFilaVazia {
        if (isEmpty()) {
            throw new EFilaVazia("A Fila está vazia");
        }

        Object removido = this.inicio.elemento;
        this.inicio = this.inicio.next;
        this.tamanho--;

        return removido;
    }
}