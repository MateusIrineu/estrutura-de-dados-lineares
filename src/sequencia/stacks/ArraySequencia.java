package sequencia.stacks;

public class ArraySequencia<E> implements Sequencia<E> {

    private static class PositionArray<E> implements Position<E> {
        E elemento;
        int rank;

        PositionArray(E elemento, int rank) {
            this.elemento = elemento;
            this.rank = rank;
        }

        public E getElemento() {
            return elemento;
        }
    }

    private PositionArray<E>[] vetor;
    private int tamanho;

    @SuppressWarnings("unchecked")
    public ArraySequencia(int capacidade) {
        vetor = new PositionArray[capacidade];
        tamanho = 0;
    }

    public int size() { return tamanho; }
    public boolean isEmpty() { return tamanho == 0; }

    public Position<E> atRank(int r) {
        return vetor[r];
    }

    public int rankOf(Position<E> p) {
        PositionArray<E> pos = (PositionArray<E>) p;
        return pos.rank;
    }

    public E elemAtRank(int r) {
        return vetor[r].getElemento();
    }

    public E replaceAtRank(int r, E o) {
        E antigo = vetor[r].elemento;
        vetor[r].elemento = o;
        return antigo;
    }

    public void insertAtRank(int r, E o) {
        for (int i = tamanho - 1; i >= r; i--) {
            vetor[i + 1] = vetor[i];
            vetor[i + 1].rank = i + 1; 
        }
        vetor[r] = new PositionArray<>(o, r);
        tamanho++;
    }

    public E removeAtRank(int r) {
        E antigo = vetor[r].elemento;
        for (int i = r; i < tamanho - 1; i++) {
            vetor[i] = vetor[i + 1];
            vetor[i].rank = i; 
        }
        vetor[tamanho - 1] = null;
        tamanho--;
        return antigo;
    }

    public Position<E> first() { return vetor[0]; }
    public Position<E> last() { return vetor[tamanho - 1]; }
    
    public Position<E> before(Position<E> p) {
        int r = rankOf(p);
        return vetor[r - 1];
    }

    public Position<E> after(Position<E> p) {
        int r = rankOf(p);
        return vetor[r + 1];
    }

    public Position<E> insertBefore(Position<E> p, E o) {
        int r = rankOf(p);
        insertAtRank(r, o);
        return vetor[r];
    }

    public Position<E> insertAfter(Position<E> p, E o) {
        int r = rankOf(p);
        insertAtRank(r + 1, o);
        return vetor[r + 1];
    }

    public Position<E> insertFirst(E o) {
        insertAtRank(0, o);
        return vetor[0];
    }

    public Position<E> insertLast(E o) {
        insertAtRank(tamanho, o);
        return vetor[tamanho - 1];
    }

    public E remove(Position<E> p) {
        int r = rankOf(p);
        return removeAtRank(r);
    }

    public E replaceElement(Position<E> p, E o) {
        PositionArray<E> pos = (PositionArray<E>) p;
        E antigo = pos.elemento;
        pos.elemento = o;
        return antigo;
    }

    public void swapElements(Position<E> p, Position<E> q) {
        PositionArray<E> posP = (PositionArray<E>) p;
        PositionArray<E> posQ = (PositionArray<E>) q;
        E temp = posP.elemento;
        posP.elemento = posQ.elemento;
        posQ.elemento = temp;
    }
}